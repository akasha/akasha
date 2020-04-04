package org.realityforge.webtack.model;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.realityforge.webtack.webidl.parser.WebIDLParser;
import org.realityforge.webtack.webidl.parser.WebIDLParserTool;

@SuppressWarnings( "DuplicatedCode" )
public final class WebIDLModelParser
{
  @Nonnull
  private static final Map<String, Kind> STRING_KIND_MAP = Collections.unmodifiableMap( new HashMap<String, Kind>()
  {
    {
      put( "DOMString", Kind.DOMString );
      put( "ByteString", Kind.ByteString );
      put( "USVString", Kind.USVString );
    }
  } );
  @Nonnull
  private static final Map<String, Kind> BUFFER_KIND_MAP = Collections.unmodifiableMap( new HashMap<String, Kind>()
  {
    {
      put( "ArrayBuffer", Kind.ArrayBuffer );
      put( "DataView", Kind.DataView );
      put( "Int8Array", Kind.Int8Array );
      put( "Int16Array", Kind.Int16Array );
      put( "Int32Array", Kind.Int32Array );
      put( "Uint8Array", Kind.Uint8Array );
      put( "Uint16Array", Kind.Uint16Array );
      put( "Uint32Array", Kind.Uint32Array );
      put( "Uint8ClampedArray", Kind.Uint8ClampedArray );
      put( "Float32Array", Kind.Float32Array );
      put( "Float64Array", Kind.Float64Array );
    }
  } );

  private WebIDLModelParser()
  {
  }

  @Nonnull
  public static List<Definition> parse( @Nonnull final WebIDLParser.WebIDLContext ctx )
  {
    WebIDLParser.DefinitionsContext definitionsContext = ctx.definitions();
    WebIDLParser.DefinitionContext definitionContext;
    final List<Definition> definitions = new ArrayList<>();
    while ( null != ( definitionContext = definitionsContext.definition() ) )
    {
      final List<ExtendedAttribute> extendedAttributes = parse( definitionsContext.extendedAttributeList() );
      definitions.add( parse( definitionContext, extendedAttributes ) );
      definitionsContext = definitionsContext.definitions();
    }

    return Collections.unmodifiableList( definitions );
  }

  @Nonnull
  public static Definition parse( @Nonnull final WebIDLParser.DefinitionContext ctx,
                                  @Nonnull final List<ExtendedAttribute> extendedAttributes )
  {
    final WebIDLParser.CallbackOrInterfaceOrMixinContext callbackOrInterfaceOrMixinContext =
      ctx.callbackOrInterfaceOrMixin();
    if ( null != callbackOrInterfaceOrMixinContext )
    {
      final WebIDLParser.CallbackRestOrInterfaceContext callbackRestOrInterfaceContext =
        callbackOrInterfaceOrMixinContext.callbackRestOrInterface();
      if ( null != callbackRestOrInterfaceContext )
      {
        final WebIDLParser.CallbackRestContext callbackRestContext = callbackRestOrInterfaceContext.callbackRest();
        if ( null != callbackRestContext )
        {
          final String name = callbackRestContext.IDENTIFIER().getText();
          final Type returnType = parse( callbackRestContext.returnType() );
          final List<Argument> arguments = parse( callbackRestContext.argumentList() );

          return new CallbackDefinition( name, returnType, arguments, extendedAttributes );
        }
        else
        {
          final String interfaceName = callbackRestOrInterfaceContext.IDENTIFIER().getText();
          final WebIDLParser.CallbackInterfaceMembersContext callbackInterfaceMembersContext =
            callbackRestOrInterfaceContext.callbackInterfaceMembers();
          assert null != callbackInterfaceMembersContext;
          //TODO:
          throw new UnsupportedOperationException();
        }
      }
      else
      {
        final WebIDLParser.InterfaceOrMixinContext interfaceOrMixinContext =
          callbackOrInterfaceOrMixinContext.interfaceOrMixin();
        assert null != interfaceOrMixinContext;
        final WebIDLParser.InterfaceRestContext interfaceRestContext = interfaceOrMixinContext.interfaceRest();
        if ( null != interfaceRestContext )
        {
          //TODO:
          throw new UnsupportedOperationException();
        }
        else
        {
          final WebIDLParser.MixinRestContext mixinRestContext = interfaceOrMixinContext.mixinRest();
          assert null != mixinRestContext;
          //TODO:
          throw new UnsupportedOperationException();
        }
      }
    }
    final WebIDLParser.NamespaceContext namespaceContext = ctx.namespace();
    if ( null != namespaceContext )
    {
      //TODO:
      throw new UnsupportedOperationException();
    }
    final WebIDLParser.PartialContext partialContext = ctx.partial();
    if ( null != partialContext )
    {
      final WebIDLParser.PartialDefinitionContext partialDefinitionContext = partialContext.partialDefinition();
      final WebIDLParser.PartialInterfaceOrPartialMixinContext partialInterfaceOrPartialMixinContext =
        partialDefinitionContext.partialInterfaceOrPartialMixin();
      if ( null != partialInterfaceOrPartialMixinContext )
      {
        final WebIDLParser.PartialInterfaceRestContext partialInterfaceRestContext =
          partialInterfaceOrPartialMixinContext.partialInterfaceRest();
        if ( null != partialInterfaceRestContext )
        {
          //TODO:
          throw new UnsupportedOperationException();
        }
        else
        {
          final WebIDLParser.MixinRestContext mixinRestContext = partialInterfaceOrPartialMixinContext.mixinRest();
          assert null != mixinRestContext;
          //TODO:
          throw new UnsupportedOperationException();
        }
      }
      final WebIDLParser.PartialDictionaryContext partialDictionaryContext =
        partialDefinitionContext.partialDictionary();
      if ( null != partialDictionaryContext )
      {
        return parse( partialDictionaryContext, extendedAttributes );
      }
      else
      {
        final WebIDLParser.NamespaceContext partialNamespaceContext = partialDefinitionContext.namespace();
        assert null != partialNamespaceContext;
        //TODO:
        throw new UnsupportedOperationException();
      }
    }
    final WebIDLParser.DictionaryContext dictionaryContext = ctx.dictionary();
    if ( null != dictionaryContext )
    {
      return parse( dictionaryContext, extendedAttributes );
    }
    final WebIDLParser.EnumDefinitionContext enumDefinitionContext = ctx.enumDefinition();
    if ( null != enumDefinitionContext )
    {
      return parse( enumDefinitionContext, extendedAttributes );
    }
    final WebIDLParser.TypedefContext typedefContext = ctx.typedef();
    if ( null != typedefContext )
    {
      return parse( typedefContext, extendedAttributes );
    }
    final WebIDLParser.IncludesStatementContext includesStatementContext = ctx.includesStatement();
    assert null != includesStatementContext;
    return parse( includesStatementContext, extendedAttributes );
  }

  @Nonnull
  public static List<Argument> parse( @Nonnull final WebIDLParser.ArgumentListContext ctx )
  {
    final WebIDLParser.ArgumentContext argumentContext = ctx.argument();
    if ( null != argumentContext )
    {
      final List<Argument> arguments = new ArrayList<>();
      arguments.add( parse( argumentContext ) );
      WebIDLParser.ArgumentsContext argumentsContext = ctx.arguments();
      while ( argumentsContext.getChildCount() > 0 )
      {
        arguments.add( parse( argumentsContext.argument() ) );
        argumentsContext = argumentsContext.arguments();
      }
      return Collections.unmodifiableList( arguments );
    }
    else
    {
      return Collections.emptyList();
    }
  }

  @Nonnull
  public static Argument parse( @Nonnull final WebIDLParser.ArgumentContext ctx )
  {
    final List<ExtendedAttribute> extendedAttributes = parse( ctx.extendedAttributeList() );
    final WebIDLParser.ArgumentRestContext argumentRestContext = ctx.argumentRest();
    final WebIDLParser.ArgumentNameContext argumentNameContext = argumentRestContext.argumentName();
    final TerminalNode identifier = argumentNameContext.IDENTIFIER();
    final String name = null != identifier ? identifier.getText() : argumentNameContext.argumentNameKeyword().getText();
    final WebIDLParser.TypeWithExtendedAttributesContext typeWithExtendedAttributesContext =
      argumentRestContext.typeWithExtendedAttributes();
    final Type type;
    final boolean optional;
    final boolean variadic;
    final DefaultValue defaultValue;
    if ( null != typeWithExtendedAttributesContext )
    {
      type = parse( typeWithExtendedAttributesContext );
      optional = true;
      variadic = false;
      final WebIDLParser.DefaultValueContext defaultValueContext =
        argumentRestContext.defaultAssignment().defaultValue();
      defaultValue = null != defaultValueContext ? parse( defaultValueContext ) : null;
    }
    else
    {
      type = parse( argumentRestContext.type() );
      optional = false;
      variadic = argumentRestContext.ellipsis().getChildCount() > 0;
      defaultValue = null;
    }
    return new Argument( name, type, optional, variadic, defaultValue, extendedAttributes );
  }

  @Nonnull
  static String extractString( @Nonnull final TerminalNode string )
  {
    final String text = string.getText();
    assert text.startsWith( "\"" );
    assert text.endsWith( "\"" );
    return text.substring( 1, text.length() - 1 );
  }

  @Nonnull
  static AttributeMember parse( @Nonnull final WebIDLParser.AttributeRestContext ctx,
                                @Nonnull final List<ExtendedAttribute> extendedAttributes )
  {
    final WebIDLParser.AttributeNameContext attributeNameContext = ctx.attributeName();
    final WebIDLParser.AttributeNameKeywordContext attributeNameKeywordContext =
      attributeNameContext.attributeNameKeyword();
    final String name = null == attributeNameKeywordContext ?
                        attributeNameContext.IDENTIFIER().getText() :
                        attributeNameKeywordContext.getText();
    final Type type = parse( ctx.typeWithExtendedAttributes() );
    return new AttributeMember( name, type, extendedAttributes );
  }

  @Nonnull
  static ConstMember parse( @Nonnull final WebIDLParser.ConstMemberContext ctx,
                            @Nonnull final List<ExtendedAttribute> extendedAttributes )
  {
    final String name = ctx.IDENTIFIER().getText();
    final WebIDLParser.ConstMemberTypeContext constMemberTypeContext = ctx.constMemberType();
    final TerminalNode identifier = constMemberTypeContext.IDENTIFIER();
    final Type type;
    if ( null != identifier )
    {
      type = new TypeReference( identifier.getText(), Collections.emptyList(), false );
    }
    else
    {
      type = parse( constMemberTypeContext.primitiveType(), Collections.emptyList(), false );
    }
    final ConstValue value = parse( ctx.constMemberValue() );
    return new ConstMember( name, type, value, extendedAttributes );
  }

  @Nonnull
  static ConstValue parse( @Nonnull final WebIDLParser.ConstMemberValueContext ctx )
  {
    final WebIDLParser.BooleanLiteralContext booleanLiteralContext = ctx.booleanLiteral();
    if ( null != booleanLiteralContext )
    {
      return new ConstValue( "true".equals( booleanLiteralContext.getText() ) ?
                             ConstValue.Kind.True :
                             ConstValue.Kind.False, null );
    }
    final WebIDLParser.FloatLiteralContext floatLiteralContext = ctx.floatLiteral();
    if ( null != floatLiteralContext )
    {
      final TerminalNode decimal = floatLiteralContext.DECIMAL();
      if ( null != decimal )
      {
        return new ConstValue( ConstValue.Kind.Decimal, decimal.getText() );
      }
      else
      {
        final String text = floatLiteralContext.getText();
        if ( "-Infinity".equals( text ) )
        {
          return new ConstValue( ConstValue.Kind.NegativeInfinity, null );
        }
        else if ( "Infinity".equals( text ) )
        {
          return new ConstValue( ConstValue.Kind.PositiveInfinity, null );
        }
        else
        {
          assert "NaN".equals( text );
          return new ConstValue( ConstValue.Kind.NaN, null );
        }
      }
    }
    return new ConstValue( ConstValue.Kind.Integer, ctx.INTEGER().getText() );
  }

  @Nonnull
  public static DefaultValue parse( @Nonnull final WebIDLParser.DefaultValueContext ctx )
  {
    final WebIDLParser.ConstMemberValueContext constMemberValueContext = ctx.constMemberValue();
    if ( null != constMemberValueContext )
    {
      return new DefaultValue( DefaultValue.Kind.Const, parse( constMemberValueContext ), null );
    }
    final TerminalNode string = ctx.STRING();
    if ( null != string )
    {
      return new DefaultValue( DefaultValue.Kind.String, null, extractString( string ) );
    }
    final String child = ctx.getChild( 0 ).getText();
    if ( "[".equals( child ) )
    {
      return new DefaultValue( DefaultValue.Kind.EmptySequence, null, null );
    }
    else if ( "{".equals( child ) )
    {
      return new DefaultValue( DefaultValue.Kind.EmptyDictionary, null, null );
    }
    else
    {
      assert "null".equals( child );
      return new DefaultValue( DefaultValue.Kind.Null, null, null );
    }
  }

  @Nonnull
  public static EnumerationDefinition parse( @Nonnull final WebIDLParser.EnumDefinitionContext ctx,
                                             @Nonnull final List<ExtendedAttribute> extendedAttributes )
  {
    final String name = ctx.IDENTIFIER().getText();
    final Set<String> values = parse( ctx.enumValueList() );
    return new EnumerationDefinition( name, values, extendedAttributes );
  }

  @Nonnull
  private static Set<String> parse( @Nonnull final WebIDLParser.EnumValueListContext enumValueListContext )
  {
    final Set<String> values = new LinkedHashSet<>();
    values.add( extractString( enumValueListContext.STRING() ) );

    WebIDLParser.EnumValueListStringContext enumValueListStringContext =
      enumValueListContext.enumValueListComma().enumValueListString();
    while ( null != enumValueListStringContext )
    {
      final TerminalNode string = enumValueListStringContext.STRING();
      if ( null != string )
      {
        values.add( extractString( string ) );
      }
      final WebIDLParser.EnumValueListCommaContext enumValueListCommaContext =
        enumValueListStringContext.enumValueListComma();
      enumValueListStringContext =
        null != enumValueListCommaContext ? enumValueListCommaContext.enumValueListString() : null;
    }

    return Collections.unmodifiableSet( values );
  }

  @Nonnull
  public static List<ExtendedAttribute> parse( @Nonnull final WebIDLParser.ExtendedAttributeListContext ctx )
  {
    final WebIDLParser.ExtendedAttributeContext extendedAttributeContext = ctx.extendedAttribute();
    if ( null == extendedAttributeContext )
    {
      return Collections.emptyList();
    }
    else
    {
      final List<ExtendedAttribute> attributes = new ArrayList<>();
      attributes.add( parse( extendedAttributeContext ) );
      collectAttributes( attributes, ctx.extendedAttributes() );
      return Collections.unmodifiableList( attributes );
    }
  }

  private static void collectAttributes( @Nonnull final List<ExtendedAttribute> attributes,
                                         @Nonnull final WebIDLParser.ExtendedAttributesContext extendedAttributesContext )
  {
    final WebIDLParser.ExtendedAttributeContext attr = extendedAttributesContext.extendedAttribute();
    if ( null != attr )
    {
      attributes.add( parse( attr ) );
      collectAttributes( attributes, extendedAttributesContext.extendedAttributes() );
    }
  }

  @Nonnull
  static ExtendedAttribute parse( @Nonnull final WebIDLParser.ExtendedAttributeContext ctx )
  {
    final WebIDLParser.ExtendedAttributeNoArgsContext noArgsContext = ctx.extendedAttributeNoArgs();
    if ( null != noArgsContext )
    {
      return ExtendedAttribute.createExtendedAttributeNoArgs( noArgsContext.IDENTIFIER().getText() );
    }
    final WebIDLParser.ExtendedAttributeIdentContext identContext = ctx.extendedAttributeIdent();
    if ( null != identContext )
    {
      return ExtendedAttribute.createExtendedAttributeIdent( identContext.IDENTIFIER( 0 ).getText(),
                                                             identContext.IDENTIFIER( 1 ).getText() );
    }
    final WebIDLParser.ExtendedAttributeIdentListContext identListContext = ctx.extendedAttributeIdentList();
    if ( null != identListContext )
    {
      final List<String> identifiers = new ArrayList<>();
      collectIdentifiers( identifiers, identListContext.identifierList() );
      return ExtendedAttribute.createExtendedAttributeIdentList( identListContext.IDENTIFIER().getText(),
                                                                 Collections.unmodifiableList( identifiers ) );
    }
    final WebIDLParser.ExtendedAttributeArgListContext argListContext = ctx.extendedAttributeArgList();
    if ( null != argListContext )
    {
      final String argName = argListContext.IDENTIFIER().getText();
      final List<Argument> arguments = parse( argListContext.argumentList() );
      return ExtendedAttribute.createExtendedAttributeArgList( argName, arguments );
    }
    final WebIDLParser.ExtendedAttributeNamedArgListContext namedArgListContext = ctx.extendedAttributeNamedArgList();
    assert null != namedArgListContext;

    final String name = namedArgListContext.IDENTIFIER( 0 ).getText();
    final String argName = namedArgListContext.IDENTIFIER( 1 ).getText();
    final List<Argument> arguments = parse( namedArgListContext.argumentList() );
    return ExtendedAttribute.createExtendedAttributeNamedArgList( name, argName, arguments );
  }

  private static void collectIdentifiers( @Nonnull final List<String> identifiers,
                                          @Nonnull final WebIDLParser.IdentifierListContext identifierListContext )
  {
    identifiers.add( identifierListContext.IDENTIFIER().getText() );
    collectIdentifiers( identifiers, identifierListContext.identifiers() );
  }

  private static void collectIdentifiers( @Nonnull final List<String> identifiers,
                                          @Nonnull final WebIDLParser.IdentifiersContext identifiersContext )
  {
    final TerminalNode identifier = identifiersContext.IDENTIFIER();
    if ( null != identifier )
    {
      identifiers.add( identifier.getText() );
      collectIdentifiers( identifiers, identifiersContext.identifiers() );
    }
  }

  @Nonnull
  public static InterfaceModel parse( @Nonnull final ModelRepository repository,
                                      @Nonnull final WebIDLParser.InterfaceRestContext ctx )
  {
    final String name = ctx.IDENTIFIER().getText();
    final InterfaceModel interfaceModel = repository.findOrCreateInterfaceByName( name );
    interfaceModel.setInherits( extractInherits( ctx.inheritance() ) );
    return interfaceModel;
  }

  @Nullable
  private static String extractInherits( @Nonnull final WebIDLParser.InheritanceContext inheritance )
  {
    final TerminalNode identifier = inheritance.IDENTIFIER();
    return null != identifier ? identifier.getSymbol().getText() : null;
  }

  @Nonnull
  public static TypedefDefinition parse( @Nonnull final WebIDLParser.TypedefContext ctx,
                                         @Nonnull final List<ExtendedAttribute> extendedAttributes )
  {
    final String name = ctx.IDENTIFIER().getText();
    final Type type = parse( ctx.typeWithExtendedAttributes() );
    return new TypedefDefinition( name, type, extendedAttributes );
  }

  @Nonnull
  public static Type parse( @Nonnull final WebIDLParser.TypeWithExtendedAttributesContext ctx )
  {
    final WebIDLParser.ExtendedAttributeListContext extendedAttributeListContext = ctx.extendedAttributeList();
    return parse( ctx.type(), parse( extendedAttributeListContext ) );
  }

  @Nonnull
  public static Type parse( @Nonnull final WebIDLParser.TypeContext ctx )
  {
    return parse( ctx, Collections.emptyList() );
  }

  @Nonnull
  private static Type parse( @Nonnull final WebIDLParser.TypeContext ctx,
                             @Nonnull final List<ExtendedAttribute> extendedAttributes )
  {
    final WebIDLParser.SingleTypeContext singleTypeContext = ctx.singleType();
    if ( null != singleTypeContext )
    {
      return parse( singleTypeContext, extendedAttributes );
    }
    else
    {
      final boolean nullable = 1 == ctx.nullModifier().getChildCount();
      final WebIDLParser.UnionTypeContext unionTypeContext = ctx.unionType();
      assert null != unionTypeContext;
      return parse( unionTypeContext, extendedAttributes, nullable );
    }
  }

  @Nonnull
  private static Type parse( @Nonnull final WebIDLParser.UnionTypeContext ctx,
                             @Nonnull final List<ExtendedAttribute> extendedAttributes,
                             final boolean nullable )
  {
    final List<Type> memberTypes = new ArrayList<>();
    collectUnionMemberType( ctx.unionMemberType( 0 ), memberTypes );
    collectUnionMemberType( ctx.unionMemberType( 1 ), memberTypes );
    WebIDLParser.UnionMemberTypesContext unionMemberTypesContext = ctx.unionMemberTypes();
    while ( null != unionMemberTypesContext.unionMemberType() )
    {
      collectUnionMemberType( unionMemberTypesContext.unionMemberType(), memberTypes );
      unionMemberTypesContext = unionMemberTypesContext.unionMemberTypes();
    }
    return new UnionType( Collections.unmodifiableList( memberTypes ), extendedAttributes, nullable );
  }

  private static void collectUnionMemberType( @Nonnull final WebIDLParser.UnionMemberTypeContext ctx,
                                              @Nonnull final List<Type> memberTypes )
  {
    final WebIDLParser.ExtendedAttributeListContext extendedAttributeListContext = ctx.extendedAttributeList();
    if ( null != extendedAttributeListContext )
    {
      final WebIDLParser.DistinguishableTypeContext distinguishableTypeContext = ctx.distinguishableType();
      assert null != distinguishableTypeContext;
      memberTypes.add( parse( distinguishableTypeContext, parse( extendedAttributeListContext ) ) );
    }
    else
    {
      final boolean nullable = 1 == ctx.nullModifier().getChildCount();
      final WebIDLParser.UnionTypeContext unionTypeContext = ctx.unionType();
      assert null != unionTypeContext;
      memberTypes.add( parse( unionTypeContext, Collections.emptyList(), nullable ) );
    }
  }

  @Nonnull
  private static Type parse( @Nonnull final WebIDLParser.SingleTypeContext ctx,
                             @Nonnull final List<ExtendedAttribute> extendedAttributes )
  {
    final WebIDLParser.DistinguishableTypeContext distinguishableTypeContext = ctx.distinguishableType();
    if ( null != distinguishableTypeContext )
    {
      return parse( distinguishableTypeContext, extendedAttributes );
    }
    else if ( ctx.getChild( 0 ) instanceof TerminalNode )
    {
      assert ctx.getChild( 0 ).getText().equals( "any" );
      return new Type( Kind.Any, extendedAttributes, false );
    }
    else
    {
      final WebIDLParser.PromiseTypeContext promiseTypeContext = ctx.promiseType();
      assert null != promiseTypeContext;
      return parse( promiseTypeContext, extendedAttributes );
    }
  }

  @Nonnull
  private static Type parse( @Nonnull final WebIDLParser.PromiseTypeContext ctx,
                             @Nonnull final List<ExtendedAttribute> extendedAttributes )
  {
    return new PromiseType( parse( ctx.returnType() ), extendedAttributes );
  }

  @Nonnull
  public static Type parse( @Nonnull final WebIDLParser.ReturnTypeContext returnTypeContext )
  {
    final WebIDLParser.TypeContext type = returnTypeContext.type();
    return null != type ? parse( type ) : new Type( Kind.Void, Collections.emptyList(), false );
  }

  @Nonnull
  private static Type parse( @Nonnull final WebIDLParser.DistinguishableTypeContext ctx,
                             @Nonnull final List<ExtendedAttribute> extendedAttributes )
  {
    final boolean nullable = 1 == ctx.nullModifier().getChildCount();

    final WebIDLParser.PrimitiveTypeContext primitiveTypeContext = ctx.primitiveType();
    if ( null != primitiveTypeContext )
    {
      return parse( primitiveTypeContext, extendedAttributes, nullable );
    }
    final WebIDLParser.StringTypeContext stringTypeContext = ctx.stringType();
    if ( null != stringTypeContext )
    {
      return parse( stringTypeContext, extendedAttributes, nullable );
    }
    final TerminalNode identifier = ctx.IDENTIFIER();
    if ( null != identifier )
    {
      return new TypeReference( identifier.getText(), extendedAttributes, nullable );
    }
    final ParseTree child1 = ctx.getChild( 0 );
    if ( child1 instanceof TerminalNode )
    {
      final String text = child1.getText();
      if ( "sequence".equals( text ) )
      {
        return new SequenceType( parse( ctx.typeWithExtendedAttributes() ), extendedAttributes, nullable );
      }
      else if ( "object".equals( text ) )
      {
        return new Type( Kind.Object, extendedAttributes, nullable );
      }
      else if ( "symbol".equals( text ) )
      {
        return new Type( Kind.Symbol, extendedAttributes, nullable );
      }
      else
      {
        assert "FrozenArray".equals( text );
        return new FrozenArrayType( parse( ctx.typeWithExtendedAttributes() ), extendedAttributes, nullable );
      }
    }
    final WebIDLParser.BufferRelatedTypeContext bufferRelatedTypeContext = ctx.bufferRelatedType();
    if ( null != bufferRelatedTypeContext )
    {
      return parse( bufferRelatedTypeContext, extendedAttributes, nullable );
    }
    final WebIDLParser.RecordTypeContext recordTypeContext = ctx.recordType();
    assert null != recordTypeContext;
    return parse( recordTypeContext, extendedAttributes, nullable );
  }

  @Nonnull
  private static Type parse( @Nonnull final WebIDLParser.RecordTypeContext ctx,
                             @Nonnull final List<ExtendedAttribute> extendedAttributes,
                             final boolean nullable )
  {
    final Type keyType = parse( ctx.stringType(), Collections.emptyList(), false );
    final Type valueType = parse( ctx.typeWithExtendedAttributes() );
    return new RecordType( keyType, valueType, extendedAttributes, nullable );
  }

  @Nonnull
  private static Type parse( @Nonnull final WebIDLParser.BufferRelatedTypeContext ctx,
                             @Nonnull final List<ExtendedAttribute> extendedAttributes,
                             final boolean nullable )
  {
    final TerminalNode child = (TerminalNode) ctx.getChild( 0 );
    final String literalName = child.getText();
    assert null != literalName;
    final Kind kind = BUFFER_KIND_MAP.get( literalName );
    assert null != kind;
    return new Type( kind, extendedAttributes, nullable );
  }

  @Nonnull
  private static Type parse( @Nonnull final WebIDLParser.PrimitiveTypeContext ctx,
                             @Nonnull final List<ExtendedAttribute> extendedAttributes,
                             final boolean nullable )
  {
    final WebIDLParser.UnsignedIntegerTypeContext unsignedIntegerType = ctx.unsignedIntegerType();
    if ( null != unsignedIntegerType )
    {
      final ParseTree first = unsignedIntegerType.getChild( 0 );
      final boolean unsigned = first instanceof TerminalNode;
      assert !unsigned || first.getText().equals( "unsigned" );
      final WebIDLParser.IntegerTypeContext integerTypeContext = unsignedIntegerType.integerType();
      if ( integerTypeContext.getChild( 0 ).getText().equals( "long" ) )
      {
        final WebIDLParser.OptionalLongContext optionalLongContext = integerTypeContext.optionalLong();
        if ( 0 == optionalLongContext.getChildCount() )
        {
          return new Type( unsigned ? Kind.UnsignedLong : Kind.Long, extendedAttributes, nullable );
        }
        else
        {
          assert optionalLongContext.getChild( 0 ).getText().equals( "long" );
          return new Type( unsigned ? Kind.UnsignedLongLong : Kind.LongLong, extendedAttributes, nullable );
        }
      }
      else
      {
        assert integerTypeContext.getChild( 0 ).getText().equals( "short" );
        return new Type( unsigned ? Kind.UnsignedShort : Kind.Short, extendedAttributes, nullable );
      }
    }
    final WebIDLParser.UnrestrictedFloatTypeContext unrestrictedFloatType = ctx.unrestrictedFloatType();
    if ( null != unrestrictedFloatType )
    {
      final ParseTree first = unrestrictedFloatType.getChild( 0 );
      final boolean unrestricted = first instanceof TerminalNode;
      assert !unrestricted || first.getText().equals( "unrestricted" );

      if ( unrestrictedFloatType.floatType().getChild( 0 ).getText().equals( "float" ) )
      {
        return new Type( unrestricted ? Kind.UnrestrictedFloat : Kind.Float, extendedAttributes, nullable );
      }
      else
      {
        assert unrestrictedFloatType.floatType().getChild( 0 ).getText().equals( "double" );
        return new Type( unrestricted ? Kind.UnrestrictedDouble : Kind.Double, extendedAttributes, nullable );
      }
    }

    final TerminalNode child = (TerminalNode) ctx.getChild( 0 );
    final String literalName = child.getText();
    if ( "boolean".equals( literalName ) )
    {
      return new Type( Kind.Boolean, extendedAttributes, nullable );
    }
    else if ( "byte".equals( literalName ) )
    {
      return new Type( Kind.Byte, extendedAttributes, nullable );
    }
    else
    {
      assert "octet".equals( literalName );
      return new Type( Kind.Octet, extendedAttributes, nullable );
    }
  }

  @Nonnull
  private static Type parse( @Nonnull final WebIDLParser.StringTypeContext ctx,
                             @Nonnull final List<ExtendedAttribute> extendedAttributes,
                             final boolean nullable )
  {
    final TerminalNode child = (TerminalNode) ctx.getChild( 0 );
    final String literalName = child.getText();
    assert null != literalName;
    final Kind kind = STRING_KIND_MAP.get( literalName );
    assert null != kind;
    return new Type( kind, extendedAttributes, nullable );
  }

  @Nonnull
  public static IncludesStatement parse( @Nonnull final WebIDLParser.IncludesStatementContext ctx,
                                         @Nonnull final List<ExtendedAttribute> extendedAttributes )
  {
    final String interfaceName = ctx.IDENTIFIER( 0 ).getText();
    final String mixinName = ctx.IDENTIFIER( 1 ).getText();
    return new IncludesStatement( interfaceName, mixinName, extendedAttributes );
  }

  @Nonnull
  public static DictionaryDefinition parse( @Nonnull final WebIDLParser.DictionaryContext ctx,
                                            @Nonnull final List<ExtendedAttribute> extendedAttributes )
  {
    final String name = ctx.IDENTIFIER().getText();
    final String inherits = extractInherits( ctx.inheritance() );
    final List<DictionaryMember> members = parse( ctx.dictionaryMembers() );
    return new DictionaryDefinition( name, inherits, members, extendedAttributes );
  }

  @Nonnull
  public static PartialDictionaryDefinition parse( @Nonnull final WebIDLParser.PartialDictionaryContext ctx,
                                                   @Nonnull final List<ExtendedAttribute> extendedAttributes )
  {
    final String name = ctx.IDENTIFIER().getText();
    final List<DictionaryMember> members = parse( ctx.dictionaryMembers() );
    return new PartialDictionaryDefinition( name, members, extendedAttributes );
  }

  @Nonnull
  static DictionaryMember parse( @Nonnull final WebIDLParser.DictionaryMemberContext ctx )
  {
    final List<ExtendedAttribute> extendedAttributes = parse( ctx.extendedAttributeList() );
    final WebIDLParser.DictionaryMemberRestContext restContext = ctx.dictionaryMemberRest();
    final String name = restContext.IDENTIFIER().getText();
    final WebIDLParser.TypeContext typeContext = restContext.type();
    final Type type;
    final boolean optional;
    final DefaultValue defaultValue;
    if ( null != typeContext )
    {
      type = parse( typeContext );
      optional = true;
      final WebIDLParser.DefaultValueContext defaultValueContext = restContext.defaultAssignment().defaultValue();
      defaultValue = null != defaultValueContext ? parse( defaultValueContext ) : null;
    }
    else
    {
      type = parse( restContext.typeWithExtendedAttributes() );
      optional = false;
      defaultValue = null;
    }
    return new DictionaryMember( name, type, optional, defaultValue, extendedAttributes );
  }

  @Nonnull
  static List<DictionaryMember> parse( @Nonnull final WebIDLParser.DictionaryMembersContext ctx )
  {
    WebIDLParser.DictionaryMembersContext members = ctx;
    WebIDLParser.DictionaryMemberContext memberContext;
    final List<DictionaryMember> results = new ArrayList<>();
    while ( null != ( memberContext = members.dictionaryMember() ) )
    {
      results.add( parse( memberContext ) );
      members = members.dictionaryMembers();
    }
    return Collections.unmodifiableList( results );
  }

  @Nonnull
  public static WebIDLParser createParser( @Nonnull final Reader reader )
    throws IOException
  {
    final WebIDLParser parser = WebIDLParserTool.createParser( reader );
    parser.setBuildParseTree( true );
    return parser;
  }
}
