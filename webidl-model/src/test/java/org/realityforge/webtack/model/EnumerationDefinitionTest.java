package org.realityforge.webtack.model;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import org.realityforge.webtack.webidl.parser.WebIDLParser;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class EnumerationDefinitionTest
  extends AbstractTest
{
  @Test
  public void basicParse()
    throws IOException
  {
    final String webIDL =
      "enum XRSessionMode {\n" +
      "  \"immersive-vr\",\n" +
      "  \"inline\"\n" +
      "};";
    final EnumerationDefinition enumerationDefinition = parse( webIDL );
    assertEquals( enumerationDefinition.getName(), "XRSessionMode" );
    final List<EnumerationValue> values = enumerationDefinition.getValues();
    assertEquals( values.size(), 2 );
    // This is to ensure that we order by insertion order
    assertEquals( values.stream().map( EnumerationValue::getValue ).collect( Collectors.joining( "|" ) ),
                  "immersive-vr|inline" );
  }

  @Test
  public void trailingComma()
    throws IOException
  {
    final String webIDL = "enum PresentationStyle { \"unspecified\", \"inline\", \"attachment\", };";
    final EnumerationDefinition enumerationDefinition = parse( webIDL );
    assertEquals( enumerationDefinition.getName(), "PresentationStyle" );
    final List<EnumerationValue> values = enumerationDefinition.getValues();
    assertEquals( values.size(), 3 );
    // This is to ensure that we order by insertion order
    assertEquals( values.stream().map( EnumerationValue::getValue ).collect( Collectors.joining( "|" ) ),
                  "attachment|inline|unspecified" );
  }

  @Test
  public void extendedAttributesOnValue()
    throws IOException
  {
    final String webIDL =
      "enum XRSessionMode {\n" +
      " [JavaName=VR] \"immersive-vr\",\n" +
      " \"inline\"\n" +
      "};";
    final EnumerationDefinition enumerationDefinition = parse( webIDL );
    assertEquals( enumerationDefinition.getName(), "XRSessionMode" );
    final List<EnumerationValue> values = enumerationDefinition.getValues();
    assertEquals( values.size(), 2 );
    // This is to ensure that we order by insertion order
    assertEquals( values.stream().map( EnumerationValue::getValue ).collect( Collectors.joining( "|" ) ),
                  "immersive-vr|inline" );
    final List<ExtendedAttribute> extendedAttributes = values.get( 0 ).getExtendedAttributes();
    assertEquals( extendedAttributes.size(), 1 );
    assertEquals( extendedAttributes.get( 0 ).getName(), "JavaName" );

    assertEquals( values.get( 1 ).getExtendedAttributes().size(), 0 );
  }

  @Nonnull
  private EnumerationDefinition parse( @Nonnull final String webIDL )
    throws IOException
  {
    final WebIDLParser.EnumDefinitionContext ctx = createParser( webIDL ).enumDefinition();
    final EnumerationDefinition actual =
      WebIDLModelParser.parse( ctx, null, Collections.emptyList(), parseStartPosition( ctx ) );
    assertEquals( actual, actual );
    assertEquals( actual.hashCode(), actual.hashCode() );

    final StringWriter writer = new StringWriter();
    WebIDLWriter.writeEnumerationDefinition( writer, actual );
    writer.close();
    final String emittedIDL = writer.toString();
    final List<Definition> definitions = WebIDLModelParser.parse( createParser( emittedIDL ).definitions() );
    assertEquals( definitions.size(), 1 );
    assertTrue( definitions.get( 0 ) instanceof EnumerationDefinition );
    final EnumerationDefinition element = (EnumerationDefinition) definitions.get( 0 );
    assertEquals( element, element );
    assertEquals( element.hashCode(), element.hashCode() );

    assertTrue( element.equiv( actual ), "" );
    assertNotSame( element, actual );

    return actual;
  }
}
