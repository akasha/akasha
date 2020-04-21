package org.realityforge.webtack.model;

import java.io.IOException;
import java.io.Writer;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
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
    writer.write( " " );
    writeArgumentList( writer, callbackDefinition.getArguments() );
    writer.write( ";\n" );
  }

  static void writeCallbackInterfaceDefinition( @Nonnull final Writer writer,
                                                @Nonnull final CallbackInterfaceDefinition definition )
    throws IOException
  {
    writeAttributesIfRequired( writer, definition.getExtendedAttributes(), "\n" );
    writer.write( "callback interface " );
    writer.write( definition.getName() );
    writer.write( " {\n" );
    writeConstants( writer, definition.getConstants() );
    writeOperationMember( writer, definition.getOperation() );
    writer.write( "};\n" );
  }

  static void writeAttributesIfRequired( @Nonnull final Writer writer,
                                         @Nonnull final List<ExtendedAttribute> extendedAttributes,
                                         @Nonnull final String separator )
    throws IOException
  {
    if ( !extendedAttributes.isEmpty() )
    {
      writer.write( "[" );
      boolean first = true;
      for ( final ExtendedAttribute extendedAttribute : extendedAttributes )
      {
        if ( first )
        {
          first = false;
        }
        else
        {
          writer.write( ", " );
        }
        writeExtendedAttribute( writer, extendedAttribute );
      }
      writer.write( "]" );
      writer.write( separator );
    }
  }

  static void writeExtendedAttribute( @Nonnull final Writer writer,
                                      @Nonnull final ExtendedAttribute extendedAttribute )
    throws IOException
  {
    final ExtendedAttribute.Kind kind = extendedAttribute.getKind();
    if ( ExtendedAttribute.Kind.NO_ARGS == kind )
    {
      writer.write( extendedAttribute.getName() );
    }
    else if ( ExtendedAttribute.Kind.ARG_LIST == kind )
    {
      writer.write( extendedAttribute.getArgListName() );
      writeArgumentList( writer, extendedAttribute.getArgList() );
    }
    else if ( ExtendedAttribute.Kind.IDENT == kind )
    {
      writer.write( extendedAttribute.getName() );
      writer.write( "=" );
      writer.write( extendedAttribute.getIdent() );
    }
    else if ( ExtendedAttribute.Kind.IDENT_LIST == kind )
    {
      writer.write( extendedAttribute.getName() );
      writer.write( "=(" );
      final List<String> identList = extendedAttribute.getIdentList();
      writer.write( String.join( ",", identList ) );
      writer.write( ")" );
    }
    else
    {
      assert ExtendedAttribute.Kind.NAMED_ARG_LIST == kind;
      writer.write( extendedAttribute.getName() );
      writer.write( "=" );
      writer.write( extendedAttribute.getArgListName() );
      writeArgumentList( writer, extendedAttribute.getArgList() );
    }
  }

  static void writeArgumentList( @Nonnull final Writer writer, @Nonnull final List<Argument> arguments )
    throws IOException
  {
    if ( arguments.isEmpty() )
    {
      writer.write( "()" );
    }
    else
    {
      writer.write( "( " );
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
      writer.write( " )" );
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
        writeString( writer, stringValue );
        break;
    }
  }

  private static void writeString( @Nonnull final Writer writer, @Nonnull final String value )
    throws IOException
  {
    writer.write( '"' );
    writer.write( value );
    writer.write( '"' );
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

  static void writeIncludesStatement( @Nonnull final Writer writer,
                                      @Nonnull final IncludesStatement includesStatement )
    throws IOException
  {
    writeAttributesIfRequired( writer, includesStatement.getExtendedAttributes(), "\n" );
    writer.write( includesStatement.getInterfaceName() );
    writer.write( " includes " );
    writer.write( includesStatement.getMixinName() );
    writer.write( ";\n" );
  }

  static void writeEnumerationDefinition( @Nonnull final Writer writer,
                                          @Nonnull final EnumerationDefinition definition )
    throws IOException
  {
    writeAttributesIfRequired( writer, definition.getExtendedAttributes(), "\n" );
    writer.write( "enum " );
    writer.write( definition.getName() );
    writer.write( " {\n" );
    final String[] values =
      definition
        .getValues()
        .stream()
        .sorted()
        .toArray( String[]::new );
    for ( int i = 0; i < values.length; i++ )
    {
      writeIndent( writer );
      writeString( writer, values[ i ] );
      if ( i + 1 != values.length )
      {
        writer.write( "," );
      }
      writer.write( "\n" );
    }
    writer.write( "};\n" );
  }

  static void writeDictionaryDefinition( @Nonnull final Writer writer, @Nonnull final DictionaryDefinition definition )
    throws IOException
  {
    writeAttributesIfRequired( writer, definition.getExtendedAttributes(), "\n" );
    writer.write( "dictionary " );
    writer.write( definition.getName() );
    final String inherits = definition.getInherits();
    if ( null != inherits )
    {
      writer.write( " : " );
      writer.write( inherits );
    }
    writer.write( " {\n" );
    final List<DictionaryMember> members = definition.getMembers()
      .stream()
      .sorted( Comparator.comparing( NamedElement::getName ) )
      .collect( Collectors.toList() );
    for ( final DictionaryMember member : members )
    {
      writeDictionaryMember( writer, member );
    }
    writer.write( "};\n" );
  }

  static void writePartialDictionaryDefinition( @Nonnull final Writer writer,
                                                @Nonnull final PartialDictionaryDefinition definition )
    throws IOException
  {
    writeAttributesIfRequired( writer, definition.getExtendedAttributes(), "\n" );
    writer.write( "dictionary " );
    writer.write( definition.getName() );
    writer.write( " {\n" );
    final List<DictionaryMember> members = definition.getMembers()
      .stream()
      .sorted( Comparator.comparing( NamedElement::getName ) )
      .collect( Collectors.toList() );
    for ( final DictionaryMember member : members )
    {
      writeDictionaryMember( writer, member );
    }
    writer.write( "};\n" );
  }

  static void writeInterfaceDefinition( @Nonnull final Writer writer, @Nonnull final InterfaceDefinition definition )
    throws IOException
  {
    writeAttributesIfRequired( writer, definition.getExtendedAttributes(), "\n" );
    writer.write( "interface " );
    writer.write( definition.getName() );
    final String inherits = definition.getInherits();
    if ( null != inherits )
    {
      writer.write( " : " );
      writer.write( inherits );
    }
    writer.write( " {\n" );
    writeConstants( writer, definition.getConstants() );
    final MapLikeMember mapLikeMember = definition.getMapLikeMember();
    if ( null != mapLikeMember )
    {
      writeMapLikeMember( writer, mapLikeMember );
    }
    final SetLikeMember setLikeMember = definition.getSetLikeMember();
    if ( null != setLikeMember )
    {
      writeSetLikeMember( writer, setLikeMember );
    }
    final IterableMember iterableMember = definition.getIterable();
    if ( null != iterableMember )
    {
      writeIterableMember( writer, iterableMember );
    }
    final AsyncIterableMember asyncIterableMember = definition.getAsyncIterable();
    if ( null != asyncIterableMember )
    {
      writeAsyncIterableMember( writer, asyncIterableMember );
    }
    writeAttributes( writer, definition.getAttributes() );
    writeOperations( writer, definition.getOperations() );
    writer.write( "};\n" );
  }

  static void writePartialInterfaceDefinition( @Nonnull final Writer writer,
                                               @Nonnull final PartialInterfaceDefinition definition )
    throws IOException
  {
    writeAttributesIfRequired( writer, definition.getExtendedAttributes(), "\n" );
    writer.write( "partial interface " );
    writer.write( definition.getName() );
    writer.write( " {\n" );
    writeConstants( writer, definition.getConstants() );
    final MapLikeMember mapLikeMember = definition.getMapLikeMember();
    if ( null != mapLikeMember )
    {
      writeMapLikeMember( writer, mapLikeMember );
    }
    final SetLikeMember setLikeMember = definition.getSetLikeMember();
    if ( null != setLikeMember )
    {
      writeSetLikeMember( writer, setLikeMember );
    }
    final IterableMember iterableMember = definition.getIterable();
    if ( null != iterableMember )
    {
      writeIterableMember( writer, iterableMember );
    }
    final AsyncIterableMember asyncIterableMember = definition.getAsyncIterable();
    if ( null != asyncIterableMember )
    {
      writeAsyncIterableMember( writer, asyncIterableMember );
    }
    writeAttributes( writer, definition.getAttributes() );
    writeOperations( writer, definition.getOperations() );
    writer.write( "};\n" );
  }

  static void writeMixinDefinition( @Nonnull final Writer writer, @Nonnull final MixinDefinition definition )
    throws IOException
  {
    writeAttributesIfRequired( writer, definition.getExtendedAttributes(), "\n" );
    writer.write( "interface mixin " );
    writer.write( definition.getName() );
    writer.write( " {\n" );
    writeConstants( writer, definition.getConstants() );
    writeAttributes( writer, definition.getAttributes() );
    writeOperations( writer, definition.getOperations() );
    writer.write( "};\n" );
  }

  static void writePartialMixinDefinition( @Nonnull final Writer writer,
                                           @Nonnull final PartialMixinDefinition definition )
    throws IOException
  {
    writeAttributesIfRequired( writer, definition.getExtendedAttributes(), "\n" );
    writer.write( "partial interface mixin " );
    writer.write( definition.getName() );
    writer.write( " {\n" );
    writeConstants( writer, definition.getConstants() );
    writeAttributes( writer, definition.getAttributes() );
    writeOperations( writer, definition.getOperations() );
    writer.write( "};\n" );
  }

  static void writeNamespaceDefinition( @Nonnull final Writer writer, @Nonnull final NamespaceDefinition definition )
    throws IOException
  {
    writeAttributesIfRequired( writer, definition.getExtendedAttributes(), "\n" );
    writer.write( "namespace " );
    writer.write( definition.getName() );
    writer.write( " {\n" );
    final List<AttributeMember> attr = definition.getAttributes();
    writeAttributes( writer, attr );
    writeOperations( writer, definition.getOperations() );
    writer.write( "};\n" );
  }

  private static void writeConstants( @Nonnull final Writer writer, @Nonnull final List<ConstMember> members )
    throws IOException
  {
    final List<ConstMember> constants = members
      .stream()
      .sorted( Comparator.comparing( NamedElement::getName ) )
      .collect( Collectors.toList() );
    for ( final ConstMember constant : constants )
    {
      writeConstMember( writer, constant );
    }
  }

  private static void writeAttributes( @Nonnull final Writer writer, @Nonnull final List<AttributeMember> members )
    throws IOException
  {
    final List<AttributeMember> attributes = members
      .stream()
      .sorted( Comparator
                 .comparing( AttributeMember::orderId )
                 .thenComparing( NamedElement::getName ) )
      .collect( Collectors.toList() );
    for ( final AttributeMember attribute : attributes )
    {
      writeAttributeMember( writer, attribute );
    }
  }

  private static void writeOperations( @Nonnull final Writer writer, final List<OperationMember> members )
    throws IOException
  {
    final List<OperationMember> operations = members
      .stream()
      .sorted( Comparator
                 .comparing( OperationMember::getKind )
                 .thenComparing( Comparator.nullsLast( Comparator.comparing( OperationMember::getName ) ) ) )
      .collect( Collectors.toList() );
    for ( final OperationMember operation : operations )
    {
      writeOperationMember( writer, operation );
    }
  }

  static void writeDictionaryMember( @Nonnull final Writer writer, @Nonnull final DictionaryMember member )
    throws IOException
  {
    writeIndent( writer );

    writeAttributesIfRequired( writer, member.getExtendedAttributes(), "\n  " );
    if ( !member.isOptional() )
    {
      writer.write( "required " );
    }
    writeType( writer, member.getType() );
    writer.write( " " );
    writer.write( member.getName() );
    final DefaultValue defaultValue = member.getDefaultValue();
    if ( null != defaultValue )
    {
      writer.write( " = " );
      writeDefaultValue( writer, defaultValue );
    }
    writer.write( ";\n" );
  }

  static void writeMapLikeMember( @Nonnull final Writer writer, @Nonnull final MapLikeMember member )
    throws IOException
  {
    writeIndent( writer );
    writeAttributesIfRequired( writer, member.getExtendedAttributes(), "\n  " );
    if ( member.isReadOnly() )
    {
      writer.write( "readonly " );
    }
    writer.write( "maplike<" );
    writeType( writer, member.getKeyType() );
    writer.write( ", " );
    writeType( writer, member.getValueType() );
    writer.write( ">;\n" );
  }

  static void writeSetLikeMember( @Nonnull final Writer writer, @Nonnull final SetLikeMember member )
    throws IOException
  {
    writeIndent( writer );
    writeAttributesIfRequired( writer, member.getExtendedAttributes(), "\n  " );
    if ( member.isReadOnly() )
    {
      writer.write( "readonly " );
    }
    writer.write( "setlike<" );
    writeType( writer, member.getType() );
    writer.write( ">;\n" );
  }

  static void writeAsyncIterableMember( @Nonnull final Writer writer, @Nonnull final AsyncIterableMember member )
    throws IOException
  {
    writeIndent( writer );
    writeAttributesIfRequired( writer, member.getExtendedAttributes(), "\n  " );
    writer.write( "async iterable<" );
    writeType( writer, member.getKeyType() );
    writer.write( ", " );
    writeType( writer, member.getValueType() );
    writer.write( ">;\n" );
  }

  static void writeIterableMember( @Nonnull final Writer writer, @Nonnull final IterableMember member )
    throws IOException
  {
    writeIndent( writer );
    writeAttributesIfRequired( writer, member.getExtendedAttributes(), "\n  " );
    writer.write( "iterable<" );
    final Type keyType = member.getKeyType();
    if ( null != keyType )
    {
      writeType( writer, keyType );
      writer.write( ", " );
    }
    writeType( writer, member.getValueType() );
    writer.write( ">;\n" );
  }

  private static void writeIndent( @Nonnull final Writer writer )
    throws IOException
  {
    writer.write( "  " );
  }

  static void writeAttributeMember( @Nonnull final Writer writer, @Nonnull final AttributeMember attribute )
    throws IOException
  {
    // Attributes are always nested in a container so add some leading space
    writeIndent( writer );

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
    writeIndent( writer );
    writeAttributesIfRequired( writer, constMember.getExtendedAttributes(), " \n" );
    writer.write( "const " );
    writeType( writer, constMember.getType() );
    writer.write( " " );
    writer.write( constMember.getName() );
    writer.write( " = " );
    writeConstValue( writer, constMember.getValue() );
    writer.write( ";\n" );
  }

  static void writeOperationMember( @Nonnull final Writer writer, @Nonnull final OperationMember operation )
    throws IOException
  {
    writeIndent( writer );
    writeAttributesIfRequired( writer, operation.getExtendedAttributes(), "\n  " );
    final OperationMember.Kind kind = operation.getKind();
    if ( OperationMember.Kind.STRINGIFIER == kind && null == operation.getName() )
    {
      writer.write( "stringifier" );
    }
    else
    {
      if ( OperationMember.Kind.STATIC == kind )
      {
        writer.write( "static " );
      }
      else if ( OperationMember.Kind.GETTER == kind )
      {
        writer.write( "getter " );
      }
      else if ( OperationMember.Kind.SETTER == kind )
      {
        writer.write( "setter " );
      }
      else if ( OperationMember.Kind.DELETER == kind )
      {
        writer.write( "deleter " );
      }
      else if ( OperationMember.Kind.STRINGIFIER == kind )
      {
        writer.write( "stringifier " );
      }

      if ( OperationMember.Kind.CONSTRUCTOR != kind )
      {
        writeType( writer, operation.getReturnType() );
        writer.write( " " );
        final String name = operation.getName();
        if ( null != name )
        {
          writer.write( name );
        }
      }
      else
      {
        writer.write( "constructor" );
      }
      writeArgumentList( writer, operation.getArguments() );
    }
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
