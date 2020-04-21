package org.realityforge.webtack.model;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import javax.annotation.Nonnull;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class PartialInterfaceDefinitionTest
  extends AbstractTest
{
  @Test
  public void parse_constant()
    throws IOException
  {
    final PartialInterfaceDefinition definition =
      ensurePartialInterfaceDefinition( "[Exposed=(Window,DedicatedWorker,SharedWorker)]\n" +
                                        "partial interface XMLHttpRequest {\n" +
                                        "  const unsigned short UNSENT = 0;\n" +
                                        "};\n",
                                        "XMLHttpRequest",
                                        1,
                                        1,
                                        0,
                                        0 );
    final List<ConstMember> constants = definition.getConstants();
    final ConstMember constant = constants.get( 0 );
    assertEquals( constant.getName(), "UNSENT" );
    assertEquals( constant.getType().getKind(), Kind.UnsignedShort );
    assertEquals( constant.getValue().getValue(), "0" );
  }

  @Test
  public void parse_attribute()
    throws IOException
  {
    final PartialInterfaceDefinition mixin =
      ensurePartialInterfaceDefinition( "[SecureContext,Exposed=(Window,DedicatedWorker,SharedWorker)]\n" +
                                        "partial interface NavigatorStorage {\n" +
                                        "  [SameObject] readonly attribute StorageManager storage;\n" +
                                        "};\n",
                                        "NavigatorStorage",
                                        2,
                                        0,
                                        1,
                                        0 );
    final List<AttributeMember> attributes = mixin.getAttributes();
    final AttributeMember attribute = attributes.get( 0 );
    assertEquals( attribute.getName(), "storage" );
    assertTrue( attribute.getModifiers().contains( AttributeMember.Modifier.READ_ONLY ) );
    assertEquals( attribute.getExtendedAttributes().size(), 1 );
    assertEquals( attribute.getType().getKind(), Kind.TypeReference );
    assertEquals( ( (TypeReference) attribute.getType() ).getName(), "StorageManager" );
  }

  @Test
  public void parse_operation()
    throws IOException
  {
    final PartialInterfaceDefinition definition =
      ensurePartialInterfaceDefinition( "[Exposed=Window]\n" +
                                        "partial interface Worklet {\n" +
                                        "    [NewObject] Promise<void> addModule(USVString moduleURL, optional WorkletOptions options);\n" +
                                        "};\n",
                                        "Worklet",
                                        1,
                                        0,
                                        0,
                                        1 );

    final List<ExtendedAttribute> extendedAttributes = definition.getExtendedAttributes();
    assertEquals( extendedAttributes.size(), 1 );
    final ExtendedAttribute extendedAttribute = extendedAttributes.get( 0 );
    assertEquals( extendedAttribute.getName(), "Exposed" );
    assertEquals( extendedAttribute.getIdent(), "Window" );

    final List<OperationMember> operations = definition.getOperations();
    final OperationMember operation = operations.get( 0 );
    final List<ExtendedAttribute> operationExtendedAttributes = operation.getExtendedAttributes();
    assertEquals( operationExtendedAttributes.size(), 1 );
    assertEquals( operationExtendedAttributes.get( 0 ).getName(), "NewObject" );
    assertEquals( operation.getName(), "addModule" );
    final Type returnType = operation.getReturnType();
    assertEquals( returnType.getKind(), Kind.Promise );
    assertEquals( ( (PromiseType) returnType ).getResolveType().getKind(), Kind.Void );
    final List<Argument> arguments = operation.getArguments();
    assertEquals( arguments.size(), 2 );
    final Argument argument1 = arguments.get( 0 );
    assertEquals( argument1.getName(), "moduleURL" );
    assertEquals( argument1.getType().getKind(), Kind.USVString );

    final Argument argument2 = arguments.get( 1 );
    assertEquals( argument2.getName(), "options" );
    assertTrue( argument2.isOptional() );
    final Type argument2Type = argument2.getType();
    assertEquals( argument2Type.getKind(), Kind.TypeReference );
    assertEquals( ( (TypeReference) argument2Type ).getName(), "WorkletOptions" );
  }

  @Test
  public void parse_maplike()
    throws IOException
  {
    final PartialInterfaceDefinition definition =
      ensurePartialInterfaceDefinition( "[Exposed=Window]\n" +
                                        "partial interface AudioParamMap {\n" +
                                        "  readonly maplike<DOMString, AudioParam>;\n" +
                                        "};\n",
                                        "AudioParamMap",
                                        1,
                                        0,
                                        0,
                                        0 );
    final MapLikeMember mapLike = definition.getMapLikeMember();
    assertNotNull( mapLike );
    assertTrue( mapLike.isReadOnly() );
    assertEquals( mapLike.getKeyType().getKind(), Kind.DOMString );
    assertEquals( mapLike.getValueType().getKind(), Kind.TypeReference );
  }

  @Test
  public void parse_setlike()
    throws IOException
  {
    final PartialInterfaceDefinition definition =
      ensurePartialInterfaceDefinition( "[Exposed=Window]\n" +
                                        "partial interface AudioParamMap {\n" +
                                        "  readonly setlike<DOMString>;\n" +
                                        "};\n",
                                        "AudioParamMap",
                                        1,
                                        0,
                                        0,
                                        0 );
    final SetLikeMember setLike = definition.getSetLikeMember();
    assertNotNull( setLike );
    assertTrue( setLike.isReadOnly() );
    assertEquals( setLike.getType().getKind(), Kind.DOMString );
  }

  @Test
  public void parse_iterable()
    throws IOException
  {
    final PartialInterfaceDefinition definition =
      ensurePartialInterfaceDefinition( "[Exposed=Window]\n" +
                                        " partial interface NodeList {\n" +
                                        "    getter Node? item(unsigned long index);\n" +
                                        "    readonly attribute unsigned long length;\n" +
                                        "    iterable<Node>;\n" +
                                        "  };",
                                        "NodeList",
                                        1,
                                        0,
                                        1,
                                        1 );
    final IterableMember iterable = definition.getIterable();
    assertNotNull( iterable );
    assertNull( iterable.getKeyType() );
    assertEquals( iterable.getValueType().getKind(), Kind.TypeReference );
  }

  @Test
  public void parse_async_iterable()
    throws IOException
  {
    final PartialInterfaceDefinition definition =
      ensurePartialInterfaceDefinition( "partial interface Config {\n" +
                                        "    async iterable<DOMString,any>;\n" +
                                        "  };",
                                        "Config",
                                        0,
                                        0,
                                        0,
                                        0 );
    final AsyncIterableMember iterable = definition.getAsyncIterable();
    assertNotNull( iterable );
    assertEquals( iterable.getKeyType().getKind(), Kind.DOMString );
    assertEquals( iterable.getValueType().getKind(), Kind.Any );
  }

  @Test
  public void parse_complex()
    throws IOException
  {
    ensurePartialInterfaceDefinition( "partial interface Window {\n" +
                                      "    [NewObject] MediaQueryList matchMedia(CSSOMString query);\n" +
                                      "    [SameObject, Replaceable] readonly attribute Screen screen;\n" +
                                      "\n" +
                                      "    // browsing context\n" +
                                      "    void moveTo(long x, long y);\n" +
                                      "    void moveBy(long x, long y);\n" +
                                      "    void resizeTo(long width, long height);\n" +
                                      "    void resizeBy(long x, long y);\n" +
                                      "\n" +
                                      "    // viewport\n" +
                                      "    [Replaceable] readonly attribute long innerWidth;\n" +
                                      "    [Replaceable] readonly attribute long innerHeight;\n" +
                                      "\n" +
                                      "    // viewport scrolling\n" +
                                      "    [Replaceable] readonly attribute double scrollX;\n" +
                                      "    [Replaceable] readonly attribute double pageXOffset;\n" +
                                      "    [Replaceable] readonly attribute double scrollY;\n" +
                                      "    [Replaceable] readonly attribute double pageYOffset;\n" +
                                      "    void scroll(optional ScrollToOptions options = {});\n" +
                                      "    void scroll(unrestricted double x, unrestricted double y);\n" +
                                      "    void scrollTo(optional ScrollToOptions options = {});\n" +
                                      "    void scrollTo(unrestricted double x, unrestricted double y);\n" +
                                      "    void scrollBy(optional ScrollToOptions options = {});\n" +
                                      "    void scrollBy(unrestricted double x, unrestricted double y);\n" +
                                      "\n" +
                                      "    // client\n" +
                                      "    [Replaceable] readonly attribute long screenX;\n" +
                                      "    [Replaceable] readonly attribute long screenLeft;\n" +
                                      "    [Replaceable] readonly attribute long screenY;\n" +
                                      "    [Replaceable] readonly attribute long screenTop;\n" +
                                      "    [Replaceable] readonly attribute long outerWidth;\n" +
                                      "    [Replaceable] readonly attribute long outerHeight;\n" +
                                      "    [Replaceable] readonly attribute double devicePixelRatio;\n" +
                                      "};",
                                      "Window",
                                      0,
                                      0,
                                      14,
                                      11 );
  }

  @Nonnull
  private PartialInterfaceDefinition ensurePartialInterfaceDefinition( @Nonnull final String webIDL,
                                                                       @Nonnull final String name,
                                                                       final int extendedAttributeCount,
                                                                       final int constantCount,
                                                                       final int attributeCount,
                                                                       final int operationCount )
    throws IOException
  {
    final Definition definition =
      WebIDLModelParser.parse( createParser( webIDL ).definitions() ).get( 0 );
    assertTrue( definition instanceof PartialInterfaceDefinition );
    final PartialInterfaceDefinition actual = (PartialInterfaceDefinition) definition;
    assertEquals( actual.getName(), name );
    assertEquals( actual.getExtendedAttributes().size(), extendedAttributeCount );
    assertEquals( actual.getConstants().size(), constantCount );
    assertEquals( actual.getAttributes().size(), attributeCount );
    assertEquals( actual.getOperations().size(), operationCount );

    assertEquals( actual, actual );
    assertEquals( actual.hashCode(), actual.hashCode() );

    final StringWriter writer = new StringWriter();
    WebIDLWriter.writePartialInterfaceDefinition( writer, actual );
    writer.close();
    final String emittedIDL = writer.toString();
    final List<Definition> definitions = WebIDLModelParser.parse( createParser( emittedIDL ).definitions() );
    assertEquals( definitions.size(), 1 );
    assertTrue( definitions.get( 0 ) instanceof PartialInterfaceDefinition );
    final PartialInterfaceDefinition element = (PartialInterfaceDefinition) definitions.get( 0 );
    assertEquals( element, element );
    assertEquals( element.hashCode(), element.hashCode() );

    assertTrue( element.equiv( actual ) );
    assertNotSame( element, actual );

    return actual;
  }
}
