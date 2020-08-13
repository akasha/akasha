package org.realityforge.webtack.jsinterop;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.Definition;
import org.realityforge.webtack.model.EnumerationDefinition;
import org.realityforge.webtack.model.ExtendedAttribute;
import org.realityforge.webtack.model.FrozenArrayType;
import org.realityforge.webtack.model.InterfaceDefinition;
import org.realityforge.webtack.model.Kind;
import org.realityforge.webtack.model.PromiseType;
import org.realityforge.webtack.model.RecordType;
import org.realityforge.webtack.model.SequenceType;
import org.realityforge.webtack.model.Type;
import org.realityforge.webtack.model.TypeReference;
import org.realityforge.webtack.model.TypedefDefinition;
import org.realityforge.webtack.model.UnionType;
import org.realityforge.webtack.model.WebIDLSchema;

final class CodeGenContext
{
  @Nonnull
  private final WebIDLSchema _schema;
  @Nonnull
  private final Map<String, ClassName> _typeMapping = new HashMap<>();
  @Nonnull
  private final Map<String, UnionType> _unions = new HashMap<>();
  @Nonnull
  private final Path _outputDirectory;
  @Nonnull
  private final String _packageName;
  @Nullable
  private final String _globalInterface;
  private final boolean _generateGwtModule;
  // Maps Classname -> Path of source file
  @Nonnull
  private final Map<String, Path> _generatedSourceFiles = new HashMap<>();

  CodeGenContext( @Nonnull final WebIDLSchema schema,
                  @Nonnull final Path outputDirectory,
                  @Nonnull final String packageName,
                  @Nullable final String globalInterface,
                  final boolean generateGwtModule )
  {
    _schema = Objects.requireNonNull( schema );
    _outputDirectory = Objects.requireNonNull( outputDirectory );
    _packageName = Objects.requireNonNull( packageName );
    _globalInterface = globalInterface;
    _generateGwtModule = generateGwtModule;
  }

  @Nonnull
  WebIDLSchema getSchema()
  {
    return _schema;
  }

  @Nonnull
  Path getOutputDirectory()
  {
    return _outputDirectory;
  }

  @Nonnull
  Path getMainJavaDirectory()
  {
    return getOutputDirectory().resolve( "main" ).resolve( "java" );
  }

  @Nonnull
  String getPackageName()
  {
    return _packageName;
  }

  @Nullable
  String getGlobalInterface()
  {
    return _globalInterface;
  }

  boolean shouldGenerateGwtModule()
  {
    return _generateGwtModule;
  }

  @Nonnull
  TypeName lookupTypeByName( @Nonnull final String name )
  {
    final ClassName existing = _typeMapping.get( name );
    if ( null != existing )
    {
      return existing;
    }
    else
    {
      final ClassName className = getClassName( name );
      _typeMapping.put( name, className );
      return className;
    }
  }

  @Nonnull
  Path getPackageDirectory( @Nonnull final String packageName )
  {
    final Path baseDirectory = getMainJavaDirectory();
    return packageName.isEmpty() ?
           baseDirectory :
           baseDirectory.resolve( packageName.replaceAll( "\\.", File.separator ) );
  }

  void writeResourceFile( @Nonnull final String name, @Nonnull final byte[] content )
    throws IOException
  {
    final Path path = getPackageDirectory( getPackageName() ).resolve( name );
    final String qualifiedName = getPackageName() + "." + name;
    assert !_generatedSourceFiles.containsKey( qualifiedName );
    _generatedSourceFiles.put( qualifiedName, path );

    Files.write( path, content, StandardOpenOption.CREATE_NEW );
  }

  void writeTopLevelType( @Nonnull final TypeSpec.Builder type )
    throws IOException
  {
    writeTopLevelType( type, null );
  }

  void writeTopLevelType( @Nonnull final TypeSpec.Builder type, @Nullable final String namespace )
    throws IOException
  {
    final Path outputDirectory = getMainJavaDirectory();
    final TypeSpec typeSpec = type.build();
    final String packageName = derivePackage( namespace );
    final String name = typeSpec.name;
    final Path path = getPackageDirectory( packageName ).resolve( name + ".java" );
    final String qualifiedName = packageName + "." + name;
    assert !_generatedSourceFiles.containsKey( qualifiedName );
    _generatedSourceFiles.put( qualifiedName, path );
    JavaFile
      .builder( packageName, typeSpec )
      .skipJavaLangImports( true )
      .build()
      .writeTo( outputDirectory );
  }

  @Nonnull
  private String derivePackage( @Nullable final String namespace )
  {
    return getPackageName() + ( null == namespace ? "" : "." + NamingUtil.underscore( namespace ) );
  }

  @Nonnull
  Map<String, Path> getGeneratedSourceFiles()
  {
    return Collections.unmodifiableMap( _generatedSourceFiles );
  }

  @Nonnull
  private ClassName getClassName( @Nonnull final String name )
  {
    final EnumerationDefinition enumeration = getSchema().findEnumerationByName( name );
    if ( null != enumeration )
    {
      return Types.STRING;
    }
    final TypedefDefinition typedef = getSchema().findTypedefByName( name );
    if ( null != typedef )
    {
      if ( Kind.Union == typedef.getType().getKind() )
      {
        return ClassName.get( getPackageName(), name );
      }
      else
      {
        //TODO: resolve typedef
      }
    }
    final InterfaceDefinition interfaceDefinition = getSchema().findInterfaceByName( name );
    if ( null != interfaceDefinition )
    {
      return ClassName.get( derivePackage( getNamespace( interfaceDefinition ) ), name );
    }
    return ClassName.get( getPackageName(), name );
  }

  @Nonnull
  TypeName toTypeName( @Nonnull final Type type )
  {
    return toTypeName( type, type.isNullable() );
  }

  @Nullable
  String getNamespace( @Nonnull final Definition definition )
  {
    return definition.getExtendedAttributes()
      .stream()
      .filter( a -> ExtendedAttribute.Kind.IDENT == a.getKind() && "LegacyNamespace".equals( a.getName() ) )
      .map( ExtendedAttribute::getIdent )
      .findAny()
      .orElse( null );
  }

  @Nonnull
  TypeName toTypeName( @Nonnull final Type type, final boolean boxed )
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
      // TODO: This is uncomfortable mapping. Not sure what the solutions is...
      //  We should emit a warning a deal with it later
      return TypeName.DOUBLE.box();
    }
    else if ( Kind.Any == kind )
    {
      return Types.ANY;
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
      return Types.STRING;
    }
    else if ( Kind.Object == kind )
    {
      return TypeName.OBJECT;
    }
    else if ( Kind.Symbol == kind )
    {
      return Types.SYMBOL;
    }
    else if ( Kind.TypeReference == kind )
    {
      final TypeReference typeReference = (TypeReference) type;
      final String name = typeReference.getName();
      final WebIDLSchema schema = _schema;
      if ( null != schema.findInterfaceByName( name ) ||
           null != schema.findDictionaryByName( name ) ||
           null != schema.findCallbackInterfaceByName( name ) ||
           null != schema.findCallbackByName( name ) )
      {
        return lookupTypeByName( name );
      }
      else if ( null != schema.findEnumerationByName( name ) )
      {
        return Types.STRING;
      }
      else
      {
        final TypedefDefinition typedef = schema.getTypedefByName( name );
        //TODO: Figure out some sensible mechanism for this logic rather than duplicating the logic all over the place
        if ( Kind.Union == typedef.getType().getKind() )
        {
          return lookupTypeByName( name );
        }
        else
        {
          return toTypeName( typedef.getType() );
        }
      }
    }
    else if ( Kind.Promise == kind )
    {
      return ParameterizedTypeName.get( Types.PROMISE, getUnexpandedType( ( (PromiseType) type ).getResolveType() ) );
    }
    else if ( Kind.Sequence == kind )
    {
      return ParameterizedTypeName.get( Types.JS_ARRAY, getUnexpandedType( ( (SequenceType) type ).getItemType() ) );
    }
    else if ( Kind.Record == kind )
    {
      return ParameterizedTypeName.get( Types.JS_PROPERTY_MAP,
                                        getUnexpandedType( ( (RecordType) type ).getValueType() ) );
    }
    else if ( Kind.FrozenArray == kind )
    {
      return ParameterizedTypeName.get( Types.JS_ARRAY, getUnexpandedType( ( (FrozenArrayType) type ).getItemType() ) );
    }
    else if ( Kind.ArrayBuffer == kind )
    {
      return Types.ARRAY_BUFFER;
    }
    else if ( Kind.DataView == kind )
    {
      return Types.DATA_VIEW;
    }
    else if ( Kind.Int8Array == kind )
    {
      return Types.INT8_ARRAY;
    }
    else if ( Kind.Int16Array == kind )
    {
      return Types.INT16_ARRAY;
    }
    else if ( Kind.Int32Array == kind )
    {
      return Types.INT32_ARRAY;
    }
    else if ( Kind.Uint8Array == kind )
    {
      return Types.UINT8_ARRAY;
    }
    else if ( Kind.Uint16Array == kind )
    {
      return Types.UINT16_ARRAY;
    }
    else if ( Kind.Uint32Array == kind )
    {
      return Types.UINT32_ARRAY;
    }
    else if ( Kind.Uint8ClampedArray == kind )
    {
      return Types.UINT8_CLAMPED_ARRAY;
    }
    else if ( Kind.Float32Array == kind )
    {
      return Types.FLOAT32_ARRAY;
    }
    else if ( Kind.Float64Array == kind )
    {
      return Types.FLOAT64_ARRAY;
    }
    else if ( Kind.Union == kind )
    {
      return lookupTypeByName( generateUnionType( (UnionType) type ) );
    }
    else
    {
      throw new UnsupportedOperationException( kind + " type not currently supported by generator: " + type );
    }
  }

  @Nonnull
  TypeName getUnexpandedType( @Nonnull final Type type )
  {
    return toTypeName( toJsinteropCompatibleType( _schema.resolveType( type ) ) ).box();
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
  Map<String, UnionType> getUnions()
  {
    return _unions;
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
    else if ( kind.isPrimitive() ||
              kind.isBufferRelated() ||
              Kind.FrozenArray == kind ||
              Kind.Object == kind ||
              Kind.Symbol == kind )
    {
      sb.append( kind.name() );
    }
    else if ( Kind.TypeReference == kind )
    {
      sb.append( ( (TypeReference) type ).getName() );
    }
    else if ( Kind.Sequence == kind )
    {
      appendTypeToUnionName( sb, ( (SequenceType) type ).getItemType() );
      sb.append( "Array" );
    }
    else
    {
      throw new UnsupportedOperationException( "Contains kind " + kind + " in union which has not been implemented" );
    }
  }
}
