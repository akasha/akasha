package org.realityforge.webtack.webidl.parser;

import java.io.StringReader;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class WebIDLParserToolTest
{
  @Test
  public void basicParse()
    throws Exception
  {
    // Test just performs a parse of a fragment from whatwg url spec.
    // Mostly to verify that basic parsing infrastructure works
    final String webidl =
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
      "  stringifier attribute USVString href;\n" +
      "  readonly attribute USVString origin;\n" +
      "           attribute USVString protocol;\n" +
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
      "};\n";
    final WebIDLParser parser = WebIDLParserTool.createParser( "myschema", new StringReader( webidl ) );
    final WebIDLParser.WebIDLContext context = parser.webIDL();
    final WebIDLParser.DefinitionContext definition = context.definitions().definition();
    assertEquals( definition.callbackOrInterfaceOrMixin()
                    .interfaceOrMixin()
                    .interfaceRest()
                    .IDENTIFIER()
                    .getSymbol()
                    .getText(), "URL" );
  }
}
