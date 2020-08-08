package org.realityforge.webtack.webidl.parser;

import java.io.StringReader;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class WebIDLParserToolTest
{
  @Test
  public void basicParse()
    throws Exception
  {
    // Test just performs a parse of a fragment to verify that the basic parsing infrastructure works
    final String webidl =
      "/**\n" +
      " * This is a multiline description for the\n" +
      " * interface\n" +
      " *\n" +
      " * @see http://example.com\n" +
      " */\n" +
      "[Exposed=(Window,Worker),\n" +
      " LegacyWindowAlias=webkitURL]\n" +
      "interface URL {\n" +
      "  /**\n" +
      "   * This is a multiline description for the\n" +
      "   * constructor\n" +
      "   *\n" +
      "   * @param base the base parameter. It is also\n" +
      "   *             over multiple lines\n" +
      "   */" +
      "  constructor(USVString url, optional USVString base);\n" +
      "\n" +
      "  /**\n" +
      "   * This is a multiline description for the\n" +
      "   * protocol attribute\n" +
      "   */" +
      "           attribute USVString protocol;\n" +
      "  stringifier attribute USVString href;\n" +
      "  readonly attribute USVString origin;\n" +
      "           attribute USVString username;\n" +
      "           attribute USVString password;\n" +
      "           attribute USVString host;\n" +
      "           attribute USVString hostname;\n" +
      "           attribute USVString port;\n" +
      "           attribute USVString pathname;\n" +
      "           attribute USVString search;\n" +
      "  [SameObject] readonly attribute URLSearchParams searchParams;\n" +
      "           attribute USVString hash;\n" +
      "\n" +
      "  USVString toJSON();\n" +
      "\n" +
      "  event FocusEvent focus;\n" +
      "  event GamepadEvent gamepadconnected;\n" +
      "};\n";
    final WebIDLParser parser = WebIDLParserTool.createParser( "myschema", new StringReader( webidl ) );
    final WebIDLParser.WebIDLContext context = parser.webIDL();
    final WebIDLParser.DefinitionsContext definitions = context.definitions();
    assertDocumentationContent( definitions.documentation(), "This is a multiline description for the\ninterface" );
    final WebIDLParser.DefinitionContext definition = definitions.definition();

    final WebIDLParser.InterfaceRestContext interfaceRestContext =
      definition.callbackOrInterfaceOrMixin().interfaceOrMixin().interfaceRest();
    assertEquals( interfaceRestContext.IDENTIFIER().getSymbol().getText(), "URL" );

    final WebIDLParser.InterfaceMembersContext interfaceMembersContext = interfaceRestContext.interfaceMembers();
    assertDocumentationContent( interfaceMembersContext.documentation(),
                                "This is a multiline description for the\nconstructor" );
    assertNotNull( interfaceMembersContext.interfaceMember().constructor() );
    final WebIDLParser.InterfaceMembersContext attributeInterfaceMembersContext = interfaceMembersContext.interfaceMembers();
    assertNotNull( attributeInterfaceMembersContext.interfaceMember().partialInterfaceMember().readWriteAttribute().attributeRest().attributeName().getText(),
                   "protocol");
    assertDocumentationContent( attributeInterfaceMembersContext.documentation(),
                                "This is a multiline description for the\nprotocol attribute" );
  }

  private void assertDocumentationContent( @Nullable final WebIDLParser.DocumentationContext documentation,
                                           @Nonnull final String expected )
  {
    assertNotNull( documentation );
    final WebIDLParser.DocumentationContentContext documentationContentContext = documentation.documentationContent();
    final WebIDLParser.DescriptionContext description = documentationContentContext.description();
    final List<WebIDLParser.DescriptionLineContext> descriptionLineContexts = description.descriptionLine();
    assertNotNull( descriptionLineContexts );
    final StringBuilder descriptionContent = new StringBuilder();
    for ( final WebIDLParser.DescriptionLineContext descriptionLineContext : descriptionLineContexts )
    {
      descriptionContent.append( descriptionLineContext.getText().trim() );
      descriptionContent.append( "\n" );
    }
    assertEquals( descriptionContent.toString().trim(), expected );
  }
}
