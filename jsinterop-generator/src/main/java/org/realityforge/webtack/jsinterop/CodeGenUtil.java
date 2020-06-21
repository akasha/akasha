package org.realityforge.webtack.jsinterop;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import java.io.IOException;
import java.nio.file.Path;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.Kind;
import org.realityforge.webtack.model.Type;
import org.realityforge.webtack.model.TypeReference;

final class CodeGenUtil
{
  private CodeGenUtil()
  {
  }

  static void writeTopLevelType( @Nonnull final CodeGenContext context, @Nonnull final TypeSpec.Builder builder )
    throws IOException
  {
    final Path outputDirectory = context.getMainJavaDirectory();
    JavaFile.builder( context.getPackageName(), builder.build() ).
      skipJavaLangImports( true ).
      build().
      writeTo( outputDirectory );
  }

  static void writeGeneratedAnnotation( @Nonnull final TypeSpec.Builder builder )
  {
    Class<?> generated = getGeneratedAnnotation();
    if ( null != generated )
    {
      builder.addAnnotation( AnnotationSpec.builder( ClassName.get( generated ) )
                               .addMember( "value", "$S", "org.realityforge.webtack" )
                               .build() );
    }
  }

  @Nullable
  private static Class<?> getGeneratedAnnotation()
  {
    try
    {
      return Class.forName( "javax.annotation.processing.Generated" );
    }
    catch ( final ClassNotFoundException ignored )
    {
      try
      {
        return Class.forName( "javax.annotation.Generated" );
      }
      catch ( final ClassNotFoundException ignored2 )
      {
        //Generate no annotation
        return null;
      }
    }
  }


  @Nonnull
  static Type resolveTypeDefs( @Nonnull final CodeGenContext context, @Nonnull final Type type )
  {
    if ( Kind.TypeReference == type.getKind() )
    {
      final String name = ( (TypeReference) type ).getName();
      final TypedefDefinition typedef = context.getSchema().findTypedefByName( name );
      if ( null != typedef )
      {
        return resolveTypeDefs( context, typedef.getType() );
      }
    }
    return type;
  }

  @Nonnull
  static TypeName toTypeName( @Nonnull final CodeGenContext context,
                              @Nonnull final Type type,
                              @Nonnull final Type actualType )
  {
    final Kind kind = type.getKind();

    final boolean nullable = type.isNullable();
    if ( nullable &&
         ( Kind.Byte == kind ||
           Kind.Octet == kind ||
           Kind.Short == kind ||
           Kind.UnsignedShort == kind ||
           Kind.Long == kind ||
           Kind.LongLong == kind ||
           Kind.UnsignedLongLong == kind ) )
    {
      throw new UnsupportedOperationException( "Nullable " + kind + " not supported" );
    }

    if ( Kind.Any == kind )
    {
      return Types.ANY;
    }
    else if ( Kind.Void == kind )
    {
      return TypeName.VOID;
    }
    else if ( Kind.Boolean == kind )
    {
      return nullable ? TypeName.BOOLEAN.box() : TypeName.BOOLEAN;
    }
    else if ( Kind.Byte == kind )
    {
      return TypeName.BYTE;
    }
    else if ( Kind.Octet == kind )
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
      return nullable ? TypeName.DOUBLE.box() : TypeName.FLOAT;
    }
    else if ( Kind.Double == kind || Kind.UnrestrictedDouble == kind )
    {
      return nullable ? TypeName.DOUBLE.box() : TypeName.DOUBLE;
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
      return context.lookupTypeByName( typeReference.getName() );
    }
    else if ( Kind.Promise == kind )
    {
      return Types.PROMISE;
    }
    else if ( Kind.Sequence == kind )
    {
      throw new UnsupportedOperationException( "Sequence not currently supported by generator" );
    }
    else if ( Kind.Record == kind )
    {
      throw new UnsupportedOperationException( "Record not currently supported by generator" );
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
    else
    {
      throw new UnsupportedOperationException( kind + " type not currently supported by generator" );
    }
  }
}
