package org.realityforge.webtack.model;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Set;
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
    writeAttributesIfRequired( writer, callbackDefinition.getExtendedAttributes(), "\n" );
    writer.write( "callback " );
    writer.write( callbackDefinition.getName() );
    writer.write( " = " );
    writeType( writer, callbackDefinition.getReturnType() );
    writer.write( " ( " );
    writeArgumentList( writer, callbackDefinition.getArguments() );
    writer.write( " );\n" );
  }

  static void writeAttributesIfRequired( @Nonnull final Writer writer,
                                         @Nonnull final List<ExtendedAttribute> extendedAttributes,
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
    writeAttributesIfRequired( writer, argument.getExtendedAttributes(), " " );
    if ( argument.isOptional() )
    {
      writer.write( "optional " );
    }
    writeType( writer, argument.getType() );
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
      writeDefaultValue( writer, defaultValue );
    }
  }

  static void writeConstValue( @Nonnull final Writer writer, @Nonnull final ConstValue constValue )
    throws IOException
  {
    switch ( constValue.getKind() )
    {
      case NaN:
        writer.write( "NaN" );
        break;
      case PositiveInfinity:
        writer.write( "Infinity" );
        break;
      case NegativeInfinity:
        writer.write( "-Infinity" );
        break;
      case True:
        writer.write( "true" );
        break;
      case False:
        writer.write( "false" );
        break;
      default:
        final String value = constValue.getValue();
        assert null != value;
        writer.write( value );
        break;
    }
  }

  static void writeDefaultValue( @Nonnull final Writer writer, @Nonnull final DefaultValue defaultValue )
    throws IOException
  {
    switch ( defaultValue.getKind() )
    {
      case Const:
        final ConstValue constValue = defaultValue.getConstValue();
        assert null != constValue;
        writeConstValue( writer, constValue );
        break;
      case EmptyDictionary:
        writer.write( "{}" );
        break;
      case EmptySequence:
        writer.write( "[]" );
        break;
      case Null:
        writer.write( "null" );
        break;
      default:
        assert DefaultValue.Kind.String == defaultValue.getKind();
        final String stringValue = defaultValue.getStringValue();
        assert null != stringValue;
        writer.write( '"' );
        writer.write( stringValue );
        writer.write( '"' );
        break;
    }
  }

  static void writeTypedefDefinition( @Nonnull final Writer writer,
                                      @Nonnull final TypedefDefinition typedefDefinition )
    throws IOException
  {
    writeAttributesIfRequired( writer, typedefDefinition.getExtendedAttributes(), "\n" );
    writer.write( "typedef " );
    writeType( writer, typedefDefinition.getType() );
    writer.write( ' ' );
    writer.write( typedefDefinition.getName() );
    writer.write( ";\n" );
  }

  static void writeAttributeMember( @Nonnull final Writer writer, @Nonnull final AttributeMember attribute )
    throws IOException
  {
    // Attributes are always nested in a container so add some leading space
    writer.write( "  " );

    writeAttributesIfRequired( writer, attribute.getExtendedAttributes(), "\n  " );
    final Set<AttributeMember.Modifier> modifiers = attribute.getModifiers();
    if ( modifiers.contains( AttributeMember.Modifier.STATIC ) )
    {
      writer.write( "static " );
    }
    else if ( modifiers.contains( AttributeMember.Modifier.STRINGIFIER ) )
    {
      writer.write( "stringifier " );
    }
    if ( modifiers.contains( AttributeMember.Modifier.READ_ONLY ) )
    {
      writer.write( "readonly " );
    }
    if ( modifiers.contains( AttributeMember.Modifier.INHERIT ) )
    {
      writer.write( "inherit " );
    }
    writer.write( "attribute " );
    writeType( writer, attribute.getType() );
    writer.write( " " );
    writer.write( attribute.getName() );
    writer.write( ";\n" );
  }

  static void writeConstMember( @Nonnull final Writer writer, @Nonnull final ConstMember constMember )
    throws IOException
  {
    writer.write( "  " );
    writeAttributesIfRequired( writer, constMember.getExtendedAttributes(), " \n" );
    writer.write( "const " );
    writeType( writer, constMember.getType() );
    writer.write( " " );
    writer.write( constMember.getName() );
    writer.write( " = " );
    writeConstValue( writer, constMember.getValue() );
    writer.write( ";\n" );
  }

  static void writeType( @Nonnull final Writer writer, @Nonnull final Type type )
    throws IOException
  {
    writeAttributesIfRequired( writer, type.getExtendedAttributes(), " " );
    switch ( type.getKind() )
    {
      case Any:
        writer.write( "any" );
        break;
      case Object:
        writer.write( "object" );
        break;
      case Symbol:
        writer.write( "symbol" );
        break;
      case Void:
        writer.write( "void" );
        break;
      case Byte:
        writer.write( "byte" );
        break;
      case Octet:
        writer.write( "octet" );
        break;
      case Boolean:
        writer.write( "boolean" );
        break;
      case ArrayBuffer:
        writer.write( "ArrayBuffer" );
        break;
      case DataView:
        writer.write( "DataView" );
        break;
      case Int8Array:
        writer.write( "Int8Array" );
        break;
      case Int16Array:
        writer.write( "Int16Array" );
        break;
      case Int32Array:
        writer.write( "Int32Array" );
        break;
      case Uint8Array:
        writer.write( "Uint8Array" );
        break;
      case Uint16Array:
        writer.write( "Uint16Array" );
        break;
      case Uint32Array:
        writer.write( "Uint32Array" );
        break;
      case Uint8ClampedArray:
        writer.write( "Uint8ClampedArray" );
        break;
      case Float32Array:
        writer.write( "Float32Array" );
        break;
      case Float64Array:
        writer.write( "Float64Array" );
        break;
      case DOMString:
        writer.write( "DOMString" );
        break;
      case ByteString:
        writer.write( "ByteString" );
        break;
      case USVString:
        writer.write( "USVString" );
        break;
      case Short:
        writer.write( "short" );
        break;
      case Long:
        writer.write( "long" );
        break;
      case LongLong:
        writer.write( "long long" );
        break;
      case UnsignedShort:
        writer.write( "unsigned short" );
        break;
      case UnsignedLong:
        writer.write( "unsigned long" );
        break;
      case UnsignedLongLong:
        writer.write( "unsigned long long" );
        break;
      case Float:
        writer.write( "float" );
        break;
      case Double:
        writer.write( "double" );
        break;
      case UnrestrictedFloat:
        writer.write( "unrestricted float" );
        break;
      case UnrestrictedDouble:
        writer.write( "unrestricted double" );
        break;
      case FrozenArray:
      {
        final FrozenArrayType self = (FrozenArrayType) type;
        writer.write( "FrozenArray<" );
        writeType( writer, self.getItemType() );
        writer.write( ">" );
        break;
      }
      case Sequence:
      {
        final SequenceType self = (SequenceType) type;
        writer.write( "sequence<" );
        writeType( writer, self.getItemType() );
        writer.write( ">" );
        break;
      }
      case Record:
      {
        final RecordType self = (RecordType) type;
        writer.write( "record<" );
        writeType( writer, self.getKeyType() );
        writer.write( ", " );
        writeType( writer, self.getValueType() );
        writer.write( ">" );
        break;
      }
      case TypeReference:
      {
        final TypeReference self = (TypeReference) type;
        writer.write( self.getName() );
        break;
      }
      case Promise:
      {
        final PromiseType self = (PromiseType) type;
        writer.write( "Promise<" );
        writeType( writer, self.getResolveType() );
        writer.write( ">" );
        break;
      }
      case Union:
      {
        final UnionType self = (UnionType) type;
        writer.write( "( " );
        boolean first = true;
        for ( final Type memberType : self.getMemberTypes() )
        {
          if ( !first )
          {
            writer.write( " or " );
          }
          else
          {
            first = false;
          }
          writeType( writer, memberType );
        }
        writer.write( " )" );
        break;
      }
    }
    if ( type.isNullable() )
    {
      writer.write( '?' );
    }
  }
}
