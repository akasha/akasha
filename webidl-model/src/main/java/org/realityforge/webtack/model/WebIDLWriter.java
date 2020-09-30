package org.realityforge.webtack.model;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class WebIDLWriter
{
  private WebIDLWriter()
  {
  }

  public static void writeSchema( @Nonnull final Writer writer, @Nonnull final WebIDLSchema schema )
    throws IOException
  {
    int definitionCount = 0;
    final List<EnumerationDefinition> enumerations =
      schema
        .getEnumerations()
        .stream()
        .sorted( Comparator.comparing( EnumerationDefinition::getName ) )
        .collect( Collectors.toList() );
    for ( final EnumerationDefinition definition : enumerations )
    {
      maybeNewLine( writer, definitionCount++ );
      writeEnumerationDefinition( writer, definition );
    }
    final List<TypedefDefinition> typedefs =
      schema
        .getTypedefs()
        .stream()
        .sorted( Comparator.comparing( TypedefDefinition::getName ) )
        .collect( Collectors.toList() );
    for ( final TypedefDefinition definition : typedefs )
    {
      maybeNewLine( writer, definitionCount++ );
      writeTypedefDefinition( writer, definition );
    }
    final List<NamespaceDefinition> namespaces =
      schema
        .getNamespaces()
        .stream()
        .sorted( Comparator.comparing( NamespaceDefinition::getName ) )
        .collect( Collectors.toList() );
    for ( final NamespaceDefinition definition : namespaces )
    {
      maybeNewLine( writer, definitionCount++ );
      writeNamespaceDefinition( writer, definition );
    }
    final List<PartialNamespaceDefinition> partialNamespaces =
      schema
        .getPartialNamespaces()
        .stream()
        .sorted( Comparator.comparing( PartialNamespaceDefinition::getName ) )
        .collect( Collectors.toList() );
    for ( final PartialNamespaceDefinition definition : partialNamespaces )
    {
      maybeNewLine( writer, definitionCount++ );
      writePartialNamespaceDefinition( writer, definition );
    }
    final List<CallbackDefinition> callbacks =
      schema
        .getCallbacks()
        .stream()
        .sorted( Comparator.comparing( CallbackDefinition::getName ) )
        .collect( Collectors.toList() );
    for ( final CallbackDefinition definition : callbacks )
    {
      maybeNewLine( writer, definitionCount++ );
      writeCallbackDefinition( writer, definition );
    }
    final List<CallbackInterfaceDefinition> callbackInterfaces =
      schema
        .getCallbackInterfaces()
        .stream()
        .sorted( Comparator.comparing( CallbackInterfaceDefinition::getName ) )
        .collect( Collectors.toList() );
    for ( final CallbackInterfaceDefinition definition : callbackInterfaces )
    {
      maybeNewLine( writer, definitionCount++ );
      writeCallbackInterfaceDefinition( writer, definition );
    }
    final List<DictionaryDefinition> dictionaries =
      schema
        .getDictionaries()
        .stream()
        .sorted( Comparator.comparing( DictionaryDefinition::getName ) )
        .collect( Collectors.toList() );
    for ( final DictionaryDefinition definition : dictionaries )
    {
      maybeNewLine( writer, definitionCount++ );
      writeDictionaryDefinition( writer, definition );
    }
    final List<PartialDictionaryDefinition> partialDictionaries =
      schema
        .getPartialDictionaries()
        .stream()
        .sorted( Comparator.comparing( PartialDictionaryDefinition::getName ) )
        .collect( Collectors.toList() );
    for ( final PartialDictionaryDefinition definition : partialDictionaries )
    {
      maybeNewLine( writer, definitionCount++ );
      writePartialDictionaryDefinition( writer, definition );
    }
    final List<MixinDefinition> mixins =
      schema
        .getMixins()
        .stream()
        .sorted( Comparator.comparing( MixinDefinition::getName ) )
        .collect( Collectors.toList() );
    for ( final MixinDefinition definition : mixins )
    {
      maybeNewLine( writer, definitionCount++ );
      writeMixinDefinition( writer, definition );
    }
    final List<PartialMixinDefinition> partialMixins =
      schema
        .getPartialMixins()
        .stream()
        .sorted( Comparator.comparing( PartialMixinDefinition::getName ) )
        .collect( Collectors.toList() );
    for ( final PartialMixinDefinition definition : partialMixins )
    {
      maybeNewLine( writer, definitionCount++ );
      writePartialMixinDefinition( writer, definition );
    }
    final List<InterfaceDefinition> interfaces =
      schema
        .getInterfaces()
        .stream()
        .sorted( Comparator.comparing( InterfaceDefinition::getName ) )
        .collect( Collectors.toList() );
    for ( final InterfaceDefinition definition : interfaces )
    {
      maybeNewLine( writer, definitionCount++ );
      writeInterfaceDefinition( writer, definition );
    }
    final List<PartialInterfaceDefinition> partialInterfaces =
      schema
        .getPartialInterfaces()
        .stream()
        .sorted( Comparator.comparing( PartialInterfaceDefinition::getName ) )
        .collect( Collectors.toList() );
    for ( final PartialInterfaceDefinition definition : partialInterfaces )
    {
      maybeNewLine( writer, definitionCount++ );
      writePartialInterfaceDefinition( writer, definition );
    }
    final List<IncludesStatement> includes =
      schema
        .getIncludes()
        .stream()
        .sorted( Comparator.comparing( s -> s.getInterfaceName() + "-" + s.getMixinName() ) )
        .collect( Collectors.toList() );
    for ( final IncludesStatement definition : includes )
    {
      maybeNewLine( writer, definitionCount++ );
      writeIncludesStatement( writer, definition );
    }
  }

  private static void maybeNewLine( @Nonnull final Writer writer, final int definitionCount )
    throws IOException
  {
    if ( 0 != definitionCount )
    {
      writer.append( "\n" );
    }
  }

  static void writeCallbackDefinition( @Nonnull final Writer writer, @Nonnull final CallbackDefinition definition )
    throws IOException
  {
    writeOperationDocumentationIfRequired( writer, definition.getDocumentation(), definition.getArguments(), "" );
    writeAttributesIfRequired( writer, definition.getExtendedAttributes(), "\n" );
    writer.write( "callback " );
    writer.write( definition.getName() );
    writer.write( " = " );
    writeType( writer, definition.getReturnType() );
    writer.write( " " );
    writeArgumentList( writer, definition.getArguments() );
    writer.write( ";\n" );
  }

  static void writeCallbackInterfaceDefinition( @Nonnull final Writer writer,
                                                @Nonnull final CallbackInterfaceDefinition definition )
    throws IOException
  {
    writeDocumentationIfRequired( writer, definition.getDocumentation(), "" );
    writeAttributesIfRequired( writer, definition.getExtendedAttributes(), "\n" );
    writer.write( "callback interface " );
    writer.write( definition.getName() );
    writer.write( " {\n" );
    writeConstants( writer, definition.getConstants() );
    writeOperationMember( writer, definition.getOperation() );
    writer.write( "};\n" );
  }

  static void writeDocumentationIfRequired( @Nonnull final Writer writer,
                                            @Nullable final DocumentationElement documentation,
                                            @Nonnull final String prefix )
    throws IOException
  {
    if ( null != documentation )
    {
      writer.write( prefix + "/**\n" );
      final String description = documentation.getDocumentation();
      if ( null != description )
      {
        for ( final String line : description.split( "\n" ) )
        {
          if ( line.isEmpty() )
          {
            writer.write( prefix + " *\n" );
          }
          else
          {
            writer.write( prefix + " * " + line + "\n" );
          }
        }
      }

      final List<DocumentationBlockTag> blockTags = documentation.getBlockTags();
      if ( !blockTags.isEmpty() && null != description )
      {
        writer.write( prefix + " *\n" );
      }

      for ( final DocumentationBlockTag tag : blockTags )
      {
        final String name = tag.getName();
        final String tagDescription = tag.getDocumentation();
        boolean firstLine = true;
        for ( final String descLine : tagDescription.split( "\n" ) )
        {
          final String line = descLine.trim();
          if ( firstLine )
          {
            firstLine = false;
            writer.write( prefix + " * @" + name + ( line.isEmpty() ? "" : " " + line ) + "\n" );
          }
          else if ( line.isEmpty() )
          {
            writer.write( prefix + " *\n" );
          }
          else
          {
            writer.write( prefix +
                          " *   " +
                          name.chars().mapToObj( v -> " " ).collect( Collectors.joining() ) +
                          line +
                          "\n" );
          }
        }
      }

      writer.write( prefix + " */\n" );
    }
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
                                      @Nonnull final TypedefDefinition definition )
    throws IOException
  {
    writeDocumentationIfRequired( writer, definition.getDocumentation(), "" );
    writeAttributesIfRequired( writer, definition.getExtendedAttributes(), "\n" );
    writer.write( "typedef " );
    writeType( writer, definition.getType() );
    writer.write( ' ' );
    writer.write( definition.getName() );
    writer.write( ";\n" );
  }

  static void writeIncludesStatement( @Nonnull final Writer writer, @Nonnull final IncludesStatement definition )
    throws IOException
  {
    writeDocumentationIfRequired( writer, definition.getDocumentation(), "" );
    writeAttributesIfRequired( writer, definition.getExtendedAttributes(), "\n" );
    writer.write( definition.getInterfaceName() );
    writer.write( " includes " );
    writer.write( definition.getMixinName() );
    writer.write( ";\n" );
  }

  static void writeEnumerationDefinition( @Nonnull final Writer writer,
                                          @Nonnull final EnumerationDefinition definition )
    throws IOException
  {
    writeDocumentationIfRequired( writer, definition.getDocumentation(), "" );
    writeAttributesIfRequired( writer, definition.getExtendedAttributes(), "\n" );
    writer.write( "enum " );
    writer.write( definition.getName() );
    writer.write( " {\n" );
    final int size = definition.getValues().size();
    int index = 1;
    for ( final EnumerationValue value : definition.getValues() )
    {
      writeDocumentationIfRequired( writer, value.getDocumentation(), "  " );
      writeIndent( writer );
      writeAttributesIfRequired( writer, value.getExtendedAttributes(), " " );
      writeString( writer, value.getValue() );
      if ( size != index++ )
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
    writeDocumentationIfRequired( writer, definition.getDocumentation(), "" );
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
    writeDocumentationIfRequired( writer, definition.getDocumentation(), "" );
    writeAttributesIfRequired( writer, definition.getExtendedAttributes(), "\n" );
    writer.write( "partial dictionary " );
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
    writeDocumentationIfRequired( writer, definition.getDocumentation(), "" );
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
    writeEvents( writer, definition.getEvents() );
    writeOperations( writer, definition.getOperations() );
    writer.write( "};\n" );
  }

  static void writePartialInterfaceDefinition( @Nonnull final Writer writer,
                                               @Nonnull final PartialInterfaceDefinition definition )
    throws IOException
  {
    writeDocumentationIfRequired( writer, definition.getDocumentation(), "" );
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
    writeEvents( writer, definition.getEvents() );
    writeOperations( writer, definition.getOperations() );
    writer.write( "};\n" );
  }

  static void writeMixinDefinition( @Nonnull final Writer writer, @Nonnull final MixinDefinition definition )
    throws IOException
  {
    writeDocumentationIfRequired( writer, definition.getDocumentation(), "" );
    writeAttributesIfRequired( writer, definition.getExtendedAttributes(), "\n" );
    writer.write( "interface mixin " );
    writer.write( definition.getName() );
    writer.write( " {\n" );
    writeConstants( writer, definition.getConstants() );
    writeAttributes( writer, definition.getAttributes() );
    writeOperations( writer, definition.getOperations() );
    writeEvents( writer, definition.getEvents() );
    writer.write( "};\n" );
  }

  static void writePartialMixinDefinition( @Nonnull final Writer writer,
                                           @Nonnull final PartialMixinDefinition definition )
    throws IOException
  {
    writeDocumentationIfRequired( writer, definition.getDocumentation(), "" );
    writeAttributesIfRequired( writer, definition.getExtendedAttributes(), "\n" );
    writer.write( "partial interface mixin " );
    writer.write( definition.getName() );
    writer.write( " {\n" );
    writeConstants( writer, definition.getConstants() );
    writeAttributes( writer, definition.getAttributes() );
    writeOperations( writer, definition.getOperations() );
    writeEvents( writer, definition.getEvents() );
    writer.write( "};\n" );
  }

  static void writeNamespaceDefinition( @Nonnull final Writer writer, @Nonnull final NamespaceDefinition definition )
    throws IOException
  {
    writeDocumentationIfRequired( writer, definition.getDocumentation(), "" );
    writeAttributesIfRequired( writer, definition.getExtendedAttributes(), "\n" );
    writer.write( "namespace " );
    writer.write( definition.getName() );
    writer.write( " {\n" );
    writeAttributes( writer, definition.getAttributes() );
    writeOperations( writer, definition.getOperations() );
    writer.write( "};\n" );
  }

  static void writePartialNamespaceDefinition( @Nonnull final Writer writer,
                                               @Nonnull final PartialNamespaceDefinition definition )
    throws IOException
  {
    writeDocumentationIfRequired( writer, definition.getDocumentation(), "" );
    writeAttributesIfRequired( writer, definition.getExtendedAttributes(), "\n" );
    writer.write( "partial namespace " );
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
                 .thenComparing( ( o1, o2 ) -> {
                   final String name1 = o1.getName();
                   final String name2 = o2.getName();
                   return null == name1 ? 1 : null == name2 ? -1 : name1.compareTo( name2 );
                 } )
      )
      .collect( Collectors.toList() );
    for ( final OperationMember operation : operations )
    {
      writeOperationMember( writer, operation );
    }
  }

  private static void writeEvents( @Nonnull final Writer writer, @Nonnull final List<EventMember> members )
    throws IOException
  {
    final List<EventMember> events =
      members
        .stream()
        .sorted( Comparator.comparing( EventMember::getName ) )
        .collect( Collectors.toList() );
    for ( final EventMember event : events )
    {
      writeEventMember( writer, event );
    }
  }

  static void writeEventMember( @Nonnull final Writer writer, @Nonnull final EventMember event )
    throws IOException
  {
    writeDocumentationIfRequired( writer, event.getDocumentation(), "  " );
    // Attributes are always nested in a container so add some leading space
    writeIndent( writer );
    writeAttributesIfRequired( writer, event.getExtendedAttributes(), "\n  " );
    writer.write( "event " );
    writeType( writer, event.getEventType() );
    writer.write( " " );
    writer.write( event.getName() );
    writer.write( ";\n" );
  }

  static void writeDictionaryMember( @Nonnull final Writer writer, @Nonnull final DictionaryMember member )
    throws IOException
  {
    writeDocumentationIfRequired( writer, member.getDocumentation(), "  " );
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
    writeDocumentationIfRequired( writer, member.getDocumentation(), "  " );
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
    writeDocumentationIfRequired( writer, member.getDocumentation(), "  " );
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
    writeDocumentationIfRequired( writer, member.getDocumentation(), "  " );
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
    writeDocumentationIfRequired( writer, member.getDocumentation(), "  " );
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
    writeDocumentationIfRequired( writer, attribute.getDocumentation(), "  " );
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
    writeDocumentationIfRequired( writer, constMember.getDocumentation(), "  " );
    writeIndent( writer );
    writeAttributesIfRequired( writer, constMember.getExtendedAttributes(), "\n  " );
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
    writeOperationDocumentationIfRequired( writer, operation.getDocumentation(), operation.getArguments(), "  " );
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

  private static void writeOperationDocumentationIfRequired( @Nonnull final Writer writer,
                                                             @Nullable final DocumentationElement documentation,
                                                             @Nonnull final List<Argument> arguments,
                                                             @Nonnull final String prefix )
    throws IOException
  {
    final List<Argument> documentedArguments =
      arguments.stream().filter( a -> null != a.getDocumentation() ).collect( Collectors.toList() );
    if ( null != documentation || !documentedArguments.isEmpty() )
    {
      final List<DocumentationBlockTag> blockTags = new ArrayList<>();
      for ( final Argument documentedArgument : documentedArguments )
      {
        final DocumentationElement argumentDocumentation = documentedArgument.getDocumentation();
        assert null != argumentDocumentation;
        blockTags.add( new DocumentationBlockTag( "param",
                                                  documentedArgument.getName() +
                                                  " " +
                                                  argumentDocumentation.getDocumentation() ) );
      }
      if ( null != documentation )
      {
        blockTags.addAll( documentation.getBlockTags() );
      }
      final DocumentationElement operationDocumentation =
        new DocumentationElement( null == documentation ? null : documentation.getDocumentation(),
                                  blockTags,
                                  Collections.emptyList() );
      writeDocumentationIfRequired( writer, operationDocumentation, prefix );
    }
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
        writer.write( "undefined" );
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
