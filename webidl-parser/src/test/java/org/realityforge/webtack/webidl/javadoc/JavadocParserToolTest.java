package org.realityforge.webtack.webidl.javadoc;

import java.io.StringReader;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class JavadocParserToolTest
{
  @Test
  public void basicParse()
    throws Exception
  {
    final String input =
      "/**\n" +
      "   * This is a description. And it has\n" +
      "   * multiple lines\n" +
      "   *\n" +
      "   * @param base the base parameter. It is also\n" +
      "   *             over multiple lines\n" +
      "   */";
    final JavadocParser parser = JavadocParserTool.createParser( "myschema", new StringReader( input ) );
    final JavadocParser.DocumentationContentContext documentationContentContext =
      parser.documentation().documentationContent();
    final JavadocParser.DescriptionContext description = documentationContentContext.description();
    final List<JavadocParser.DescriptionLineContext> descriptionLineContexts = description.descriptionLine();
    assertNotNull( descriptionLineContexts );
    final StringBuilder descriptionContent = new StringBuilder();
    for ( final JavadocParser.DescriptionLineContext descriptionLineContext : descriptionLineContexts )
    {
      descriptionContent.append( descriptionLineContext.getText().trim() );
      descriptionContent.append( "\n" );
    }
    assertEquals( descriptionContent.toString().trim(), "This is a description. And it has\nmultiple lines" );

    final JavadocParser.TagSectionContext tagSectionContext = documentationContentContext.tagSection();
    assertNotNull( tagSectionContext );
    final List<JavadocParser.BlockTagContext> blockTagContexts = tagSectionContext.blockTag();
    assertEquals( blockTagContexts.size(), 1 );
    final JavadocParser.BlockTagContext blockTagContext = blockTagContexts.get( 0 );
    assertEquals( blockTagContext.NAME().getText(), "param" );
    final StringBuilder paramTagContent = new StringBuilder();
    for ( final JavadocParser.BlockTagContentContext blockTagContent : blockTagContext.blockTagContent() )
    {
      if ( null == blockTagContent.NEWLINE() )
      {
        paramTagContent.append( blockTagContent.getText().trim() );
      }
      else
      {
        paramTagContent.append( "\n" );
      }
    }
    assertEquals( paramTagContent.toString().trim(), "base the base parameter. It is also\nover multiple lines" );
  }
}
