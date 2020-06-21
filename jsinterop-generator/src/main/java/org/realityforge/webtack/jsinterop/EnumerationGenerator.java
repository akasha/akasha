package org.realityforge.webtack.jsinterop;

import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import java.io.IOException;
import javax.annotation.Nonnull;
import javax.lang.model.element.Modifier;
import org.realityforge.webtack.model.EnumerationDefinition;

final class EnumerationGenerator
{
  void generate( @Nonnull final CodeGenContext context, @Nonnull final EnumerationDefinition definition )
    throws IOException
  {
    final TypeSpec.Builder type =
      TypeSpec
        .classBuilder( definition.getName() )
        .addModifiers( Modifier.PUBLIC, Modifier.FINAL );
    CodeGenUtil.writeGeneratedAnnotation( type );

    for ( final String value : definition.getValues() )
    {
      final String name = toName( value );
      type.addField( FieldSpec
                       .builder( Types.STRING, name, Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL )
                       .addAnnotation( Types.NONNULL )
                       .initializer( "$S", value )
                       .build() );
    }

    type.addMethod( MethodSpec.constructorBuilder().addModifiers( Modifier.PRIVATE ).build() );

    CodeGenUtil.writeTopLevelType( context, type );
  }

  @Nonnull
  private String toName( @Nonnull final String value )
  {
    if ( value.isEmpty() )
    {
      return "empty";
    }
    final StringBuilder sb = new StringBuilder();
    for ( int i = 0; i < value.length(); i++ )
    {
      final char ch = value.charAt( i );
      if ( ( i == 0 && Character.isUnicodeIdentifierStart( ch ) ) ||
           ( i != 0 && Character.isUnicodeIdentifierPart( ch ) ) )
      {
        sb.append( ch );
      }
      else
      {
        sb.append( "_" );
      }
    }
    return sb.toString();
  }
}
