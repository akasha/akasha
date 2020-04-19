package org.realityforge.webtack.model;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import javax.annotation.Nonnull;

public final class WebIDLWriter
{
  private WebIDLWriter()
  {
  }

  static void writeCallbackDefinition( @Nonnull final Writer writer,
                                       @Nonnull final CallbackDefinition callbackDefinition )
    throws IOException
  {
    writeAttributesIfRequired( callbackDefinition.getExtendedAttributes(), writer, "\n" );
    writer.write( "callback " );
    writer.write( callbackDefinition.getName() );
    writer.write( " = " );
    callbackDefinition.getReturnType().write( writer );
    writer.write( " ( " );
    writeArgumentList( writer, callbackDefinition.getArguments() );
    writer.write( " );\n" );
  }

  static void writeAttributesIfRequired( @Nonnull final List<ExtendedAttribute> extendedAttributes,
                                         @Nonnull final Writer writer,
                                         @Nonnull final String separator )
    throws IOException
  {
    if ( !extendedAttributes.isEmpty() )
    {
      //TODO: emit Attributes
      writer.write( separator );
    }
  }

  static void writeArgumentList( @Nonnull final Writer writer, @Nonnull final List<Argument> arguments )
    throws IOException
  {
    boolean first = true;
    for ( final Argument argument : arguments )
    {
      if ( !first )
      {
        writer.write( ", " );
      }
      else
      {
        first = false;
      }
      writeArgument( writer, argument );
    }
  }

  static void writeArgument( @Nonnull final Writer writer, @Nonnull final Argument argument )
    throws IOException
  {
    writeAttributesIfRequired( argument.getExtendedAttributes(), writer, " " );
    if ( argument.isOptional() )
    {
      writer.write( "optional " );
    }
    argument.getType().write( writer );
    if ( argument.isVariadic() )
    {
      writer.write( "..." );
    }
    writer.write( " " );
    writer.write( argument.getName() );
    final DefaultValue defaultValue = argument.getDefaultValue();
    if ( null != defaultValue )
    {
      writer.write( " = " );
      defaultValue.write( writer );
    }
  }
}
