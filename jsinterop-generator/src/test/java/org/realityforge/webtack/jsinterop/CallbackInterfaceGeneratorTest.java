package org.realityforge.webtack.jsinterop;

import javax.annotation.Nonnull;
import org.realityforge.webtack.model.CallbackInterfaceDefinition;
import org.realityforge.webtack.model.WebIDLSchema;
import org.testng.annotations.Test;

public final class CallbackInterfaceGeneratorTest
  extends AbstractTest
{
  @Test
  public void generate()
    throws Exception
  {
    final String content =
      "[Exposed=(Window,Worker,AudioWorklet)]\n" +
      "interface Event {\n" +
      "  constructor();\n" +
      "};\n" +
      "\n" +
      "callback interface EventListener {\n" +
      "  void handleEvent( Event event );\n" +
      "};\n";
    assertCallbackInterfaceGenerated( content, "EventListener" );
  }

  @Test
  public void generate_callback_returnsValue()
    throws Exception
  {
    // Example returns nullable value
    final String content =
      "callback interface XPathNSResolver {\n" +
      "  DOMString? lookupNamespaceURI( DOMString? prefix );\n" +
      "};\n";
    assertCallbackInterfaceGenerated( content, "XPathNSResolver" );
  }

  @Test
  public void generate_exposed_and_contains_constants()
    throws Exception
  {
    // Example returns nullable value
    final String content =
      "[Exposed=Window]\n" +
      "interface Node {\n" +
      "  constructor();\n" +
      "};\n" +
      "[Exposed=Window]\n" +
      "callback interface NodeFilter {\n" +
      "  const unsigned short FILTER_ACCEPT = 1;\n" +
      "  const unsigned short FILTER_REJECT = 2;\n" +
      "  const unsigned short FILTER_SKIP = 3;\n" +
      "  const unsigned long SHOW_ALL = 0xFFFFFFFF;\n" +
      "  const unsigned long SHOW_ATTRIBUTE = 0x2;\n" +
      "  const unsigned long SHOW_CDATA_SECTION = 0x8;\n" +
      "  const unsigned long SHOW_COMMENT = 0x80;\n" +
      "  const unsigned long SHOW_DOCUMENT = 0x100;\n" +
      "  const unsigned long SHOW_DOCUMENT_FRAGMENT = 0x400;\n" +
      "  const unsigned long SHOW_DOCUMENT_TYPE = 0x200;\n" +
      "  const unsigned long SHOW_ELEMENT = 0x1;\n" +
      "  const unsigned long SHOW_ENTITY = 0x20;\n" +
      "  const unsigned long SHOW_ENTITY_REFERENCE = 0x10;\n" +
      "  const unsigned long SHOW_NOTATION = 0x800;\n" +
      "  const unsigned long SHOW_PROCESSING_INSTRUCTION = 0x40;\n" +
      "  const unsigned long SHOW_TEXT = 0x4;\n" +
      "  unsigned short acceptNode( Node node );\n" +
      "};\n";
    assertCallbackInterfaceGenerated( content, "NodeFilter" );
  }

  private void assertCallbackInterfaceGenerated( @Nonnull final String content, @Nonnull final String name )
    throws Exception
  {
    final WebIDLSchema schema = loadSchema( content );
    generateCode( schema, schema.getCallbackInterfaceByName( name ) );
  }

  private void generateCode( @Nonnull final WebIDLSchema schema,
                             @Nonnull final CallbackInterfaceDefinition definition )
    throws Exception
  {
    generateCode( schema );
    assertFileMatchesFixture( javaFile( definition.getName() ), javaFixtureFile( definition.getName() ) );
  }
}
