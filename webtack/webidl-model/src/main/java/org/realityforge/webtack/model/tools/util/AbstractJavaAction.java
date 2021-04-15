package org.realityforge.webtack.model.tools.util;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ArrayTypeName;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.lang.model.SourceVersion;
import org.realityforge.webtack.model.Attributed;
import org.realityforge.webtack.model.ConstEnumerationDefinition;
import org.realityforge.webtack.model.ConstEnumerationValue;
import org.realityforge.webtack.model.EnumerationDefinition;
import org.realityforge.webtack.model.EnumerationValue;
import org.realityforge.webtack.model.FrozenArrayType;
import org.realityforge.webtack.model.Kind;
import org.realityforge.webtack.model.Named;
import org.realityforge.webtack.model.PromiseType;
import org.realityforge.webtack.model.RecordType;
import org.realityforge.webtack.model.SequenceType;
import org.realityforge.webtack.model.Type;
import org.realityforge.webtack.model.TypeReference;
import org.realityforge.webtack.model.TypedefDefinition;
import org.realityforge.webtack.model.UnionType;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.tools.spi.PipelineContext;

public abstract class AbstractJavaAction
  extends AbstractAction
{
  @Nonnull
  private static final List<String> OBJECT_METHODS =
    Arrays.asList( "hashCode", "equals", "clone", "toString", "finalize", "getClass", "wait", "notifyAll", "notify" );
  @Nonnull
  private final String _packageName;
  private final boolean _enableMagicConstants;
  // Maps idlName -> Qualified Java Name for types that are provided by external libraries
  @Nonnull
  private final Map<String, String> _predefinedIdlToJavaTypeMapping = new HashMap<>();
  // Maps idlName -> Qualified Java Name that specified explicitly but types are still generate by action
  @Nonnull
  private final Map<String, String> _externalIdlToJavaTypeMapping = new HashMap<>();
  // Maps idlName -> Qualified Java Name of output
  @Nonnull
  private final Map<String, String> _idlToJavaTypeMapping = new HashMap<>();
  // Maps idlName -> JavaPoet TypeName
  @Nonnull
  private final Map<String, ClassName> _idlToClassNameMapping = new HashMap<>();
  @Nonnull
  private final Map<String, UnionType> _unions = new HashMap<>();

  protected AbstractJavaAction( @Nonnull final PipelineContext context,
                                @Nonnull final Path outputDirectory,
                                @Nonnull final String packageName,
                                final boolean enableMagicConstants,
                                @Nonnull final List<Path> predefinedTypeMappingPaths,
                                @Nonnull final List<Path> externalTypeMappingPaths )
  {
    super(context, outputDirectory );
    _packageName = Objects.requireNonNull( packageName );
    _enableMagicConstants = enableMagicConstants;
    final Properties predefinedTypes = new Properties();
    for ( final Path predefinedTypeMapping : predefinedTypeMappingPaths )
    {
      try
      {
        predefinedTypes.load( new FileReader( predefinedTypeMapping.toFile() ) );
      }
      catch ( final IOException ioe )
      {
        throw new IllegalStateException( "Failed to read predefined type mapping catalog " + predefinedTypeMapping,
                                         ioe );
      }
    }
    for ( final String name : predefinedTypes.stringPropertyNames() )
    {
      _predefinedIdlToJavaTypeMapping.put( name, predefinedTypes.getProperty( name ) );
    }
    final Properties externalMapping = new Properties();
    for ( final Path typeMapping : externalTypeMappingPaths )
    {
      try
      {
        externalMapping.load( new FileReader( typeMapping.toFile() ) );
      }
      catch ( final IOException ioe )
      {
        throw new IllegalStateException( "Failed to read external type mapping " + typeMapping, ioe );
      }
    }
    for ( final String name : externalMapping.stringPropertyNames() )
    {
      final String pkgName = externalMapping.getProperty( name );
      _externalIdlToJavaTypeMapping.put( name, ( pkgName.startsWith( "." ) ? getPackageName() : "" ) + pkgName );
    }
  }

  @Nonnull
  protected final Map<String, UnionType> getUnions()
  {
    return _unions;
  }

  /**
   * Register a mapping from the specified idl type to the specified java type if no type mapping for the idl type exists.
   *
   * @param idlType  the idle type. This is the name of the definition or the name of one of the predefined BasicTypes.
   * @param javaType the java type to associated with the idl type.
   * @return true if type mapping successfully registered, false if there was already a mapping.
   */
  @SuppressWarnings( "UnusedReturnValue" )
  protected boolean tryRegisterIdlToJavaTypeMapping( @Nonnull final String idlType, @Nonnull final String javaType )
  {
    final String existingJavaType = _idlToJavaTypeMapping.get( idlType );
    if ( null != existingJavaType )
    {
      return false;
    }
    else
    {
      _idlToJavaTypeMapping.put( idlType, javaType );
      return true;
    }
  }

  @Nonnull
  protected String lookupJavaType( @Nonnull final String idlType )
  {
    return _idlToJavaTypeMapping.computeIfAbsent( idlType, t -> _packageName + "." + idlType );
  }

  protected boolean isIdlTypeNotPredefined( @Nonnull final String idlName )
  {
    return !_predefinedIdlToJavaTypeMapping.containsKey( idlName );
  }

  @Nonnull
  protected Map<String, ClassName> getIdlToClassNameMapping()
  {
    return _idlToClassNameMapping;
  }

  protected void processInit( @Nonnull final WebIDLSchema schema )
  {
    _idlToJavaTypeMapping.clear();
    _idlToClassNameMapping.clear();
    _unions.clear();
    _idlToJavaTypeMapping.putAll( _predefinedIdlToJavaTypeMapping );
    _idlToJavaTypeMapping.putAll( _externalIdlToJavaTypeMapping );
    super.processInit( schema );
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
  protected String safeName( @Nonnull final String name )
  {
    return isNameJavaSafe( name ) ? name : mangleName( name );
  }

  @Nonnull
  protected <T extends Named & Attributed> String javaMethodName( @Nonnull final T element )
  {
    return javaMethodName( element.getName(), element );
  }

  @Nonnull
  protected String javaMethodName( @Nonnull final String defaultName, @Nonnull final Attributed node )
  {
    final String specifiedName = node.getIdentValue( ExtendedAttributes.JAVA_NAME );
    return null != specifiedName ? specifiedName : safeMethodName( defaultName );
  }

  @Nonnull
  private String safeMethodName( @Nonnull final String name )
  {
    return isMethodNameJavaSafe( name ) ? name : mangleName( name );
  }

  @Nonnull
  protected String safeJsPropertyMethodName( @Nonnull final String name, final boolean isBooleanValue )
  {
    if ( "is".equals( name ) || ( !isBooleanValue && name.matches( "^is[A-Za-z].*" ) ) )
    {
      // This method is a work around for a bug in GWTs validation of properties
      // where methods named /is[A-Z].*/ must return booleans. J2CL has a similar
      // problem but the "is" prefix can have a lowercase name trailing it
      // https://github.com/gwtproject/gwt/issues/9703
      return "_" + name;
    }
    else
    {
      return isMethodNameJavaSafe( name ) ? name : mangleName( name );
    }
  }

  private boolean isMethodNameJavaSafe( @Nonnull final String name )
  {
    return isNameJavaSafe( name ) && !OBJECT_METHODS.contains( name );
  }

  private boolean isNameJavaSafe( @Nonnull final String name )
  {
    return SourceVersion.isName( name );
  }

  @Nonnull
  private String mangleName( @Nonnull final String name )
  {
    return Character.isUnicodeIdentifierStart( name.charAt( 0 ) ) ? name + "_" : "_" + name;
  }

  @Nonnull
  protected Path getMainJavaDirectory()
  {
    return getOutputDirectory().resolve( "main" ).resolve( "java" );
  }

  @Nonnull
  protected Path getMainResourcesDirectory()
  {
    return getOutputDirectory().resolve( "main" ).resolve( "resources" );
  }

  private Path getPackageDirectory( @Nonnull final Path baseDirectory, @Nonnull final String packageName )
  {
    return packageName.isEmpty() ?
           baseDirectory :
           baseDirectory.resolve( packageName.replaceAll( "\\.", File.separator ) );
  }

  protected void writeResourceFile( @Nonnull final Path baseDirectory,
                                    @Nonnull final String name,
                                    @Nonnull final byte[] content )
    throws IOException
  {
    writeFile( getPackageDirectory( baseDirectory, _packageName ).resolve( name ), content );
  }

  @Nonnull
  protected String getLeafPackageName()
  {
    return _packageName.replaceAll( ".*\\.([^.]+)$", "$1" );
  }

  protected void writeTopLevelType( @Nonnull final TypeSpec.Builder type )
    throws IOException
  {
    writeTopLevelType( null, type );
  }

  protected void writeTopLevelType( @Nullable final String idlName, @Nonnull final TypeSpec.Builder type )
    throws IOException
  {
    final Path outputDirectory = getMainJavaDirectory();
    final TypeSpec typeSpec = type.build();
    final String qualifiedName =
      null != idlName ? _idlToJavaTypeMapping.get( idlName ) : _packageName + "." + typeSpec.name;
    if ( null == qualifiedName )
    {
      throw new IllegalStateException( "Qualified java name missing for IDL type '" + idlName + "'" );
    }
    if ( null != idlName )
    {
      // Lookup java type so that it will be part of cache AND it will be emitted in mapping file
      lookupClassName( idlName );
    }
    recordGeneratedFile( outputDirectory.resolve( qualifiedName.replaceAll( "\\.", File.separator ) + ".java" ) );
    JavaFile
      .builder( ClassName.bestGuess( qualifiedName ).packageName(), typeSpec )
      .skipJavaLangImports( true )
      .build()
      .writeTo( outputDirectory );
  }

  protected final void writeGeneratedAnnotation( @Nonnull final TypeSpec.Builder builder )
  {
    writeGeneratedAnnotation( builder, "org.realityforge.webtack" );
  }

  @SuppressWarnings( "SameParameterValue" )
  private void writeGeneratedAnnotation( @Nonnull final TypeSpec.Builder builder,
                                         @Nonnull final String generatorClassName )
  {
    final Class<?> generated = GeneratedAnnotationUtil.getGeneratedAnnotation();
    if ( null != generated )
    {
      builder.addAnnotation( AnnotationSpec.builder( ClassName.get( generated ) )
                               .addMember( "value", "$S", generatorClassName )
                               .build() );
    }
  }

  @Nonnull
  protected String getPackageName()
  {
    return _packageName;
  }


  @Nonnull
  protected ClassName lookupClassName( @Nonnull final String idlName )
  {
    return _idlToClassNameMapping.computeIfAbsent( idlName, n -> ClassName.bestGuess( lookupJavaType( n ) ) );
  }

  protected void registerDefaultTypeMapping()
  {
    tryRegisterIdlToJavaTypeMapping( "object", "java.lang.Object" );
  }

  @Nonnull
  protected final TypeName toTypeName( @Nonnull final Type type )
  {
    return toTypeName( type, type.isNullable() );
  }

  @Nonnull
  protected final TypeName toTypeName( @Nonnull final Type type, final boolean boxed )
  {
    final Kind kind = type.getKind();
    if ( boxed &&
         ( Kind.Byte == kind ||
           Kind.Octet == kind ||
           Kind.Short == kind ||
           Kind.UnsignedShort == kind ||
           Kind.UnsignedLong == kind ||
           Kind.Long == kind ||
           Kind.LongLong == kind ||
           Kind.UnsignedLongLong == kind ) )
    {
      // This is uncomfortable mapping. Not sure what the solutions is...
      // Maybe we should emit a warning so we can track down the scenarios
      return TypeName.DOUBLE.box();
    }
    else if ( Kind.Any == kind )
    {
      return JsinteropTypes.ANY;
    }
    else if ( Kind.Void == kind )
    {
      return TypeName.VOID;
    }
    else if ( Kind.Boolean == kind )
    {
      return boxed ? TypeName.BOOLEAN.box() : TypeName.BOOLEAN;
    }
    else if ( Kind.Byte == kind )
    {
      return TypeName.BYTE;
    }
    else if ( Kind.Octet == kind )
    {
      return TypeName.SHORT;
    }
    else if ( Kind.Short == kind )
    {
      return TypeName.SHORT;
    }
    else if ( Kind.UnsignedShort == kind )
    {
      return TypeName.INT;
    }
    else if ( Kind.Long == kind )
    {
      return TypeName.INT;
    }
    else if ( Kind.UnsignedLong == kind )
    {
      // UnsignedLong is not representable in a JVM but we may it using a signed integer when in jsinterop
      // and just hope it produces the correct value.
      return TypeName.INT;
    }
    else if ( Kind.LongLong == kind )
    {
      // LongLong is actually the same size as a java long in the jre but the way that
      // it is transpiled by GWT/J2CL means we need to represent it as an integer but
      // acknowledge that at runtime the value can exceed what the java type represents
      return TypeName.INT;
    }
    else if ( Kind.UnsignedLongLong == kind )
    {
      // Not representable natively in java but in jsinterop it is best represented as an integer
      // See comment on LongLong type
      return TypeName.INT;
    }
    else if ( Kind.Float == kind || Kind.UnrestrictedFloat == kind )
    {
      return boxed ? TypeName.DOUBLE.box() : TypeName.FLOAT;
    }
    else if ( Kind.Double == kind || Kind.UnrestrictedDouble == kind )
    {
      return boxed ? TypeName.DOUBLE.box() : TypeName.DOUBLE;
    }
    else if ( Kind.DOMString == kind || Kind.ByteString == kind || Kind.USVString == kind )
    {
      return BasicTypes.STRING;
    }
    else if ( Kind.TypeReference == kind )
    {
      final TypeReference typeReference = (TypeReference) type;
      final String name = typeReference.getName();
      final WebIDLSchema schema = getSchema();
      if ( null != schema.findInterfaceByName( name ) ||
           null != schema.findDictionaryByName( name ) ||
           null != schema.findCallbackInterfaceByName( name ) ||
           null != schema.findCallbackByName( name ) )
      {
        return lookupClassName( name );
      }
      else if ( null != schema.findEnumerationByName( name ) )
      {
        return BasicTypes.STRING;
      }
      else
      {
        final ConstEnumerationDefinition definition = schema.findConstEnumerationByName( name );
        if ( null != definition )
        {
          final ConstEnumerationValue value = definition.getValues().get( 0 );
          return toTypeName( schema
                               .getInterfaceByName( value.getInterfaceName() )
                               .getConstantByName( value.getConstName() )
                               .getType() );
        }
        else
        {
          final TypedefDefinition typedef = schema.getTypedefByName( name );
          if ( Kind.Union == typedef.getType().getKind() )
          {
            // There is a single named union in the HTML API which is MediaProvider which we
            // convert to a MarkerType so this does not actually appear. If it does appear we
            // could live with including this unnecessary abstraction or copy the logic for
            // expanding types from jsinterop generator and expand this to it's subtypes ala
            // MediaStream, MediaSource or Blob. At the moment the extra complexity is unjustified
            return lookupClassName( name );
          }
          else
          {
            return toTypeName( typedef.getType(), boxed );
          }
        }
      }
    }
    else if ( Kind.Promise == kind )
    {
      return ParameterizedTypeName.get( lookupClassName( Kind.Promise.name() ),
                                        getUnexpandedType( ( (PromiseType) type ).getResolveType() ) );
    }
    else if ( Kind.Sequence == kind )
    {
      return toJavaSequenceType( (SequenceType) type );
    }
    else if ( Kind.Record == kind )
    {
      return ParameterizedTypeName.get( JsinteropTypes.JS_PROPERTY_MAP,
                                        getUnexpandedType( ( (RecordType) type ).getValueType() ) );
    }
    else if ( Kind.FrozenArray == kind )
    {
      return ParameterizedTypeName.get( lookupClassName( Kind.Sequence.name() ),
                                        getUnexpandedType( ( (FrozenArrayType) type ).getItemType() ) );
    }
    else if ( Kind.Union == kind )
    {
      return lookupClassName( generateUnionType( (UnionType) type ) );
    }
    else if ( Kind.Object == kind )
    {
      return lookupClassName( "object" );
    }
    else
    {
      throw new UnsupportedOperationException( kind + " type not currently supported by generator: " + type );
    }
  }

  @Nonnull
  private String generateUnionType( @Nonnull final UnionType type )
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
  protected final TypeName getUnexpandedType( @Nonnull final Type type )
  {
    return toTypeName( toJsinteropCompatibleType( getSchema().resolveType( type ) ) ).box();
  }

  @Nonnull
  private Type toJsinteropCompatibleType( @Nonnull final Type type )
  {
    final Kind kind = type.getKind();
    if ( kind.isPrimitive() &&
         Kind.Boolean != kind &&
         Kind.Double != kind &&
         Kind.UnrestrictedDouble != kind )
    {
      return new Type( Kind.Double,
                       type.getExtendedAttributes(),
                       type.isNullable(),
                       type.getSourceLocations() );
    }
    else
    {
      return type;
    }
  }

  @Nonnull
  private AnnotationSpec emitMagicConstantAnnotation( @Nonnull final EnumerationDefinition enumeration )
  {
    return AnnotationSpec.builder( lookupClassName( enumeration.getName() ) ).build();
  }

  @Nonnull
  private AnnotationSpec emitMagicConstantAnnotation( @Nonnull final ConstEnumerationDefinition enumeration )
  {
    return AnnotationSpec.builder( lookupClassName( enumeration.getName() ) ).build();
  }

  protected final void addMagicConstantAnnotationIfNeeded( @Nonnull final Type type,
                                                           @Nonnull final ParameterSpec.Builder parameter )
  {
    if ( _enableMagicConstants && Kind.TypeReference == type.getKind() )
    {
      final WebIDLSchema schema = getSchema();
      final EnumerationDefinition enumeration =
        schema.findEnumerationByName( ( (TypeReference) type ).getName() );
      if ( null != enumeration )
      {
        parameter.addAnnotation( emitMagicConstantAnnotation( enumeration ) );
      }
      final ConstEnumerationDefinition constEnumeration =
        schema.findConstEnumerationByName( ( (TypeReference) type ).getName() );
      if ( null != constEnumeration )
      {
        parameter.addAnnotation( emitMagicConstantAnnotation( constEnumeration ) );
      }
    }
  }

  protected final void addMagicConstantAnnotationIfNeeded( @Nonnull final Type type,
                                                           @Nonnull final MethodSpec.Builder method )
  {
    if ( _enableMagicConstants && Kind.TypeReference == type.getKind() )
    {
      final WebIDLSchema schema = getSchema();
      final EnumerationDefinition enumeration =
        schema.findEnumerationByName( ( (TypeReference) type ).getName() );
      if ( null != enumeration )
      {
        method.addAnnotation( emitMagicConstantAnnotation( enumeration ) );
      }
      final ConstEnumerationDefinition constEnumeration =
        schema.findConstEnumerationByName( ( (TypeReference) type ).getName() );
      if ( null != constEnumeration )
      {
        method.addAnnotation( emitMagicConstantAnnotation( constEnumeration ) );
      }
    }
  }

  protected final void addMagicConstantAnnotationIfNeeded( @Nonnull final Type type,
                                                           @Nonnull final FieldSpec.Builder field )
  {
    if ( _enableMagicConstants && Kind.TypeReference == type.getKind() )
    {
      final WebIDLSchema schema = getSchema();
      final EnumerationDefinition enumeration =
        schema.findEnumerationByName( ( (TypeReference) type ).getName() );
      if ( null != enumeration )
      {
        field.addAnnotation( emitMagicConstantAnnotation( enumeration ) );
      }
      final ConstEnumerationDefinition constEnumeration =
        schema.findConstEnumerationByName( ( (TypeReference) type ).getName() );
      if ( null != constEnumeration )
      {
        field.addAnnotation( emitMagicConstantAnnotation( constEnumeration ) );
      }
    }
  }

  @Nonnull
  protected final TypeName toJavaSequenceType( @Nonnull final SequenceType sequenceType )
  {
    final String containerTypeName = sequenceType.getIdentValue( ExtendedAttributes.JAVA_SEQUENCE_TYPE );

    final ClassName containerType =
      lookupClassName( null == containerTypeName ? Kind.Sequence.name() : containerTypeName );
    return ParameterizedTypeName.get( containerType, toTypeName( sequenceType.getItemType(), true ) );
  }

  @Nonnull
  protected final ArrayTypeName asArrayType( @Nonnull final TypeName typeName )
  {
    return ArrayTypeName.of( BasicTypes.BOXED_DOUBLE.equals( typeName ) ? TypeName.DOUBLE : typeName );
  }
}
