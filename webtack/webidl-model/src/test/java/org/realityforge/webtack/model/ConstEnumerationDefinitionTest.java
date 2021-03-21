package org.realityforge.webtack.model;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import org.realityforge.webtack.webidl.parser.WebIDLParser;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class ConstEnumerationDefinitionTest
  extends AbstractTest
{
  @Test
  public void basicParse()
    throws IOException
  {
    final String webIDL =
      "/**\n" +
      " * Some docs.\n" +
      " */\n" +
      "[SomeOtherAttribute]\n" +
      "const enum ReadyStateType {\n" +
      "  [SomeAttribute] XMLHttpRequest.UNSENT,\n" +
      "  XMLHttpRequest.OPENED,\n" +
      "  XMLHttpRequest.HEADERS_RECEIVED,\n" +
      "  XMLHttpRequest.LOADING,\n" +
      "  XMLHttpRequest.DONE\n" +
      "};\n";
    final ConstEnumerationDefinition enumerationDefinition = parse( webIDL );
    assertEquals( enumerationDefinition.getName(), "ReadyStateType" );
    assertTrue( enumerationDefinition.isNoArgsExtendedAttributePresent( "SomeOtherAttribute" ) );
    final DocumentationElement documentation = enumerationDefinition.getDocumentation();
    assertNotNull( documentation );
    assertEquals( documentation.getDocumentation(), "Some docs." );
    final List<ConstEnumerationValue> values = enumerationDefinition.getValues();
    assertEquals( values.size(), 5 );
    // This is to ensure that we order by insertion order
    assertEquals( values
                    .stream()
                    .map( v -> v.getInterfaceName() + "." + v.getConstName() )
                    .collect( Collectors.joining( "|" ) ),
                  "XMLHttpRequest.UNSENT|XMLHttpRequest.OPENED|XMLHttpRequest.HEADERS_RECEIVED|XMLHttpRequest.LOADING|XMLHttpRequest.DONE" );
    final ConstEnumerationValue enumerationValue = values.get( 0 );
    assertEquals( enumerationValue.getExtendedAttributes().size(), 1 );
    assertTrue( enumerationValue.isNoArgsExtendedAttributePresent( "SomeAttribute" ) );
  }

  @SuppressWarnings( "SameParameterValue" )
  @Nonnull
  private ConstEnumerationDefinition parse( @Nonnull final String webIDL )
    throws IOException
  {
    final WebIDLParser.DefinitionsContext ctx = createParser( webIDL ).definitions();
    final ConstEnumerationDefinition actual = (ConstEnumerationDefinition) WebIDLModelParser.parse( ctx ).get( 0 );
    assertEquals( actual, actual );
    assertEquals( actual.hashCode(), actual.hashCode() );

    final StringWriter writer = new StringWriter();
    WebIDLWriter.writeConstEnumerationDefinition( writer, actual );
    writer.close();
    final String emittedIDL = writer.toString();
    final List<Definition> definitions = WebIDLModelParser.parse( createParser( emittedIDL ).definitions() );
    assertEquals( definitions.size(), 1 );
    assertTrue( definitions.get( 0 ) instanceof ConstEnumerationDefinition );
    final ConstEnumerationDefinition element = (ConstEnumerationDefinition) definitions.get( 0 );
    assertEquals( element, element );
    assertEquals( element.hashCode(), element.hashCode() );

    assertTrue( element.equiv( actual ) );
    assertNotSame( element, actual );

    return actual;
  }
}
