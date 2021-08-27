package org.realityforge.webtack.model.tools.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.lang.model.SourceVersion;
import org.realityforge.webtack.model.AttributeMember;
import org.realityforge.webtack.model.Attributed;
import org.realityforge.webtack.model.AttributedNode;
import org.realityforge.webtack.model.DocumentationElement;
import org.realityforge.webtack.model.EnumerationValue;
import org.realityforge.webtack.model.ExtendedAttribute;
import org.realityforge.webtack.model.InterfaceDefinition;
import org.realityforge.webtack.model.Kind;
import org.realityforge.webtack.model.Named;
import org.realityforge.webtack.model.NamedDefinition;
import org.realityforge.webtack.model.OperationMember;
import org.realityforge.webtack.model.PromiseType;
import org.realityforge.webtack.model.SequenceType;
import org.realityforge.webtack.model.Type;
import org.realityforge.webtack.model.TypeReference;
import org.realityforge.webtack.model.UnionType;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.tools.mdn_scanner.DocEntry;
import org.realityforge.webtack.model.tools.mdn_scanner.config2.DocEntryUtil;
import org.realityforge.webtack.model.tools.spi.Action;
import org.realityforge.webtack.model.tools.spi.PipelineContext;

public abstract class AbstractAction
  implements Action
{
  @Nonnull
  protected static final String ITERATOR_TYPE_NAME = "Iterator";
  @Nonnull
  private final PipelineContext _context;
  @Nonnull
  private final Path _outputDirectory;
  @Nonnull
  private final String _packageName;
  /**
   * Value cached during processing
   */
  @Nullable
  private WebIDLSchema _schema;
  @Nonnull
  private final Set<Path> _generatedFiles = new HashSet<>();
  @Nonnull
  private final Map<String, UnionType> _unions = new HashMap<>();
  /**
   * Maps the interface name to the set of ExposureSet keys associated with the interface.
   */
  @Nonnull
  private final Map<String, List<String>> _globalInterfaces = new HashMap<>();

  protected AbstractAction( @Nonnull final PipelineContext context,
                            @Nonnull final Path outputDirectory,
                            @Nonnull final String packageName )
  {
    _context = Objects.requireNonNull( context );
    _outputDirectory = Objects.requireNonNull( outputDirectory );
    _packageName = Objects.requireNonNull( packageName );
  }

  @Nonnull
  protected final PipelineContext context()
  {
    return _context;
  }

  @Nonnull
  protected final String getPackageName()
  {
    return _packageName;
  }

  @Nonnull
  protected final String getLeafPackageName()
  {
    return getPackageName().replaceAll( ".*\\.([^.]+)$", "$1" );
  }

  @Nonnull
  protected final WebIDLSchema getSchema()
  {
    assert null != _schema;
    return _schema;
  }

  @Nonnull
  public Set<Path> getGeneratedFiles()
  {
    return _generatedFiles;
  }

  protected final void recordGeneratedFile( @Nonnull final Path file )
  {
    assert !_generatedFiles.contains( file );
    _generatedFiles.add( file );
  }

  protected void processInit( @Nonnull final WebIDLSchema schema )
  {
    _generatedFiles.clear();
    _schema = Objects.requireNonNull( schema );
    _unions.clear();
    _globalInterfaces.clear();
    for ( final InterfaceDefinition definition : schema.getInterfaces() )
    {
      final List<String> globalInterfaces = definition.getIdentValueOrValues( ExtendedAttributes.GLOBAL );
      if ( !globalInterfaces.isEmpty() )
      {
        _globalInterfaces.put( definition.getName(), globalInterfaces );
      }
    }
    schema.link();
  }

  @Nonnull
  protected final Map<String, List<String>> getGlobalInterfaces()
  {
    return _globalInterfaces;
  }

  @Nonnull
  protected final Path getOutputDirectory()
  {
    return _outputDirectory;
  }

  @Nullable
  protected final DocumentationElement getDocumentationElement( @Nonnull final String type,
                                                                @Nullable final String member )
  {
    final DocEntry docEntry = context().docRepository().findDocEntry( type, member );
    return null != docEntry ? DocEntryUtil.createDocumentationElement( docEntry ) : null;
  }

  @Nonnull
  protected final BufferedWriter openWriter( @Nonnull final Path path )
    throws IOException
  {
    recordGeneratedFile( path );
    Files.createDirectories( path.getParent() );
    return new BufferedWriter( new FileWriter( path.toFile() ) );
  }

  protected final void writeFile( @Nonnull final Path path, @Nonnull final byte[] content )
    throws IOException
  {
    recordGeneratedFile( path );
    Files.createDirectories( path.getParent() );
    Files.write( path, content, StandardOpenOption.CREATE_NEW );
  }

  @Nonnull
  protected final Map<String, UnionType> getUnions()
  {
    return _unions;
  }

  @Nonnull
  protected final String synthesizeUnionType( @Nonnull final UnionType type )
  {
    final StringBuilder sb = new StringBuilder();
    for ( final Type memberType : type.getMemberTypes() )
    {
      if ( 0 != sb.length() )
      {
        sb.append( "Or" );
      }
      appendTypeToUnionName( sb, memberType );
    }
    sb.append( "Union" );
    final String name = sb.toString();
    if ( !_unions.containsKey( name ) )
    {
      _unions.put( name, type );
    }
    return name;
  }

  private void appendTypeToUnionName( @Nonnull final StringBuilder sb, @Nonnull final Type type )
  {
    final Kind kind = type.getKind();
    if ( kind.isString() )
    {
      sb.append( "String" );
    }
    else if ( kind.isPrimitive() || Kind.FrozenArray == kind || Kind.Object == kind )
    {
      sb.append( kind.name() );
    }
    else if ( Kind.TypeReference == kind )
    {
      sb.append( NamingUtil.uppercaseFirstCharacter( ( (TypeReference) type ).getName() ) );
    }
    else if ( Kind.Sequence == kind )
    {
      appendTypeToUnionName( sb, ( (SequenceType) type ).getItemType() );
      sb.append( "Array" );
    }
    else if ( Kind.Void == kind )
    {
      sb.append( "Undefined" );
    }
    else if ( Kind.Promise == kind )
    {
      appendTypeToUnionName( sb, ( (PromiseType) type ).getResolveType() );
      sb.append( "Promise" );
    }
    else
    {
      throw new UnsupportedOperationException( "Contains kind " + kind + " in union which has not been implemented" );
    }
  }

  @Nonnull
  protected final Type deriveAttributeType( @Nonnull final List<AttributeMember> attributes )
  {
    final List<Type> types = new ArrayList<>();
    for ( final AttributeMember attribute : attributes )
    {
      maybeAddTypeToList( types, attribute.getType() );
    }
    return convertToUnionIfRequired( types );
  }

  @Nonnull
  protected final Type deriveReturnType( @Nonnull final List<OperationMember> operations )
  {
    final List<Type> types = new ArrayList<>();
    for ( final OperationMember operation : operations )
    {
      maybeAddTypeToList( types, operation.getReturnType() );
    }
    return convertToUnionIfRequired( types );
  }

  protected final void maybeAddTypeToList( @Nonnull final List<Type> types, @Nonnull final Type candidate )
  {
    for ( final Type type : types )
    {
      if ( type.equiv( candidate ) )
      {
        return;
      }
    }
    types.add( candidate );
  }

  /**
   * Return a type that represents the specified type list.
   * If the list contains a single type then it is just the type, otherwise it is a union representing the types.
   *
   * @param types the types.
   * @return the type representing the specified type list.
   */
  @Nonnull
  protected final Type convertToUnionIfRequired( @Nonnull final List<Type> types )
  {
    if ( 1 == types.size() )
    {
      return types.get( 0 );
    }
    else
    {
      final List<ExtendedAttribute> extendedAttributes =
        Collections.singletonList( ExtendedAttribute.createExtendedAttributeNoArgs( ExtendedAttributes.SYNTHETIC,
                                                                                    Collections.emptyList() ) );
      final boolean nullable = types.stream().anyMatch( Type::isNullable );
      final UnionType unionType = new UnionType( types, extendedAttributes, nullable, Collections.emptyList() );
      // Ensure a Union type is defined as it is referenced from jsinterop
      synthesizeUnionType( unionType );
      return unionType;
    }
  }

  @Nonnull
  protected String javaName( @Nonnull final EnumerationValue value )
  {
    return javaName( enumerationValueToName( value.getValue() ), value );
  }

  @Nonnull
  protected <T extends Named & Attributed> String javaName( @Nonnull final T element )
  {
    return javaName( element.getName(), element );
  }

  @Nonnull
  private String javaName( @Nonnull final String defaultName, @Nonnull final Attributed node )
  {
    final String specifiedName = node.getIdentValue( ExtendedAttributes.JAVA_NAME );
    return null != specifiedName ? specifiedName : safeName( defaultName );
  }

  @Nonnull
  private String enumerationValueToName( @Nonnull final String value )
  {
    final StringBuilder sb = new StringBuilder();
    for ( int i = 0; i < value.length(); i++ )
    {
      final char ch = value.charAt( i );
      sb.append( Character.isUnicodeIdentifierPart( ch ) ? ch : "_" );
    }
    return sb.toString();
  }

  @Nonnull
  protected final String safeName( @Nonnull final String name )
  {
    return isNameJavaSafe( name ) ? name : mangleName( name );
  }

  protected final boolean isNameJavaSafe( @Nonnull final String name )
  {
    return SourceVersion.isName( name );
  }

  @Nonnull
  protected final String mangleName( @Nonnull final String name )
  {
    return Character.isUnicodeIdentifierStart( name.charAt( 0 ) ) ? name + "_" : "_" + name;
  }

  @SuppressWarnings( "SameParameterValue" )
  @Nonnull
  protected final String deriveJavaType( @Nonnull final NamedDefinition definition,
                                         @Nonnull final String prefix,
                                         @Nonnull final String postfix )
  {
    return derivePackagePrefix( definition ) + deriveSimpleJavaType( definition, prefix, postfix );
  }

  @Nonnull
  protected final String deriveSimpleJavaType( @Nonnull final NamedDefinition definition,
                                               @Nonnull final String prefix,
                                               @Nonnull final String postfix )
  {
    return prefix + NamingUtil.uppercaseFirstCharacter( javaName( definition ) + postfix );
  }

  @Nonnull
  protected final String derivePackagePrefix( @Nonnull final NamedDefinition definition )
  {
    final String declaredSubPackage = definition.getIdentValue( ExtendedAttributes.JAVA_SUB_PACKAGE );
    final String subPackage =
      null != declaredSubPackage ? asSubPackage( declaredSubPackage ) : asSubPackage( getNamespace( definition ) );
    return getPackageName() + subPackage + ".";
  }

  @Nullable
  protected final String getNamespace( @Nonnull final NamedDefinition definition )
  {
    return definition instanceof InterfaceDefinition ? ( (InterfaceDefinition) definition ).getNamespace() : null;
  }

  @Nonnull
  protected final String asSubPackage( @Nullable final String value )
  {
    return null != value && !value.isEmpty() ? "." + NamingUtil.underscore( value ) : "";
  }

  @Nonnull
  protected final String deriveOptionalSupportCompileConstant( @Nonnull final Named definition,
                                                               @Nonnull final String elementName,
                                                               @Nonnull final AttributedNode element )
  {
    final String elementKey =
      element.isNoArgsExtendedAttributePresent( ExtendedAttributes.OPTIONAL_SUPPORT ) ?
      elementName :
      element.getIdentValue( ExtendedAttributes.OPTIONAL_SUPPORT );

    return getPackageName() + ".is__" + definition.getName() + "_" + elementKey + "__supported";
  }
}
