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
import org.realityforge.webtack.model.DocumentationElement;
import org.realityforge.webtack.model.ExtendedAttribute;
import org.realityforge.webtack.model.Kind;
import org.realityforge.webtack.model.OperationMember;
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
  private final PipelineContext _context;
  @Nonnull
  private final Path _outputDirectory;
  /**
   * Value cached during processing
   */
  @Nullable
  private WebIDLSchema _schema;
  @Nonnull
  private final Set<Path> _generatedFiles = new HashSet<>();
  @Nonnull
  private final Map<String, UnionType> _unions = new HashMap<>();

  protected AbstractAction( @Nonnull final PipelineContext context, @Nonnull final Path outputDirectory )
  {
    _context = Objects.requireNonNull( context );
    _outputDirectory = Objects.requireNonNull( outputDirectory );
  }

  @Nonnull
  protected final PipelineContext context()
  {
    return _context;
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
    schema.link();
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
    else
    {
      throw new UnsupportedOperationException( "Contains kind " + kind + " in union which has not been implemented" );
    }
  }

  @Nonnull
  protected final Type deriveReturnType( @Nonnull final List<OperationMember> operations )
  {
    final List<Type> types = new ArrayList<>();
    for ( final OperationMember operation : operations )
    {
      maybeAddTypeToList( types, operation.getReturnType() );
    }
    return toReturnType( types );
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

  @Nonnull
  private Type toReturnType( @Nonnull final List<Type> types )
  {
    if ( 1 == types.size() )
    {
      return types.get( 0 );
    }
    else
    {
      final UnionType unionType =
        new UnionType( types,
                       Collections.singletonList( ExtendedAttribute.createExtendedAttributeNoArgs(
                         ExtendedAttributes.SYNTHESIZED_RETURN,
                         Collections.emptyList() ) ),
                       types.stream().anyMatch( Type::isNullable ),
                       Collections.emptyList() );
      if ( unionType.getMemberTypes().stream().noneMatch( t -> Kind.Promise == t.getKind() ) )
      {
        synthesizeUnionType( unionType );
      }
      return unionType;
    }
  }
}
