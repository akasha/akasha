package org.realityforge.webtack.model;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;
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
      "  \"inline\",\n" +
      "  \"immersive-vr\"\n" +
      "};";
    final EnumerationDefinition enumerationDefinition = parse( webIDL );
    assertEquals( enumerationDefinition.getName(), "XRSessionMode" );
    final Set<String> values = enumerationDefinition.getValues();
    assertEquals( values.size(), 2 );
    assertTrue( values.contains( "inline" ) );
    assertTrue( values.contains( "immersive-vr" ) );
    // This is to ensure that we order by insertion order
    assertEquals( String.join( "|", values ), "inline|immersive-vr" );
  }

  @Test
  public void trailingComma()
    throws IOException
  {
    final String webIDL = "enum PresentationStyle { \"unspecified\", \"inline\", \"attachment\", };";
    final EnumerationDefinition enumerationDefinition = parse( webIDL );
    assertEquals( enumerationDefinition.getName(), "PresentationStyle" );
    final Set<String> values = enumerationDefinition.getValues();
    assertEquals( values.size(), 3 );
    assertTrue( values.contains( "unspecified" ) );
    assertTrue( values.contains( "inline" ) );
    assertTrue( values.contains( "attachment" ) );
    // This is to ensure that we order by insertion order
    assertEquals( String.join( "|", values ), "unspecified|inline|attachment" );
  }

  @Nonnull
  private EnumerationDefinition parse( @Nonnull final String webIDL )
    throws IOException
  {
    final WebIDLParser.EnumDefinitionContext ctx = createParser( webIDL ).enumDefinition();
    final EnumerationDefinition actual =
      WebIDLModelParser.parse( ctx, Collections.emptyList(), parseStartPosition( ctx ) );
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

    assertTrue( element.equiv( actual ) );
    assertNotSame( element, actual );

    return actual;
  }
}
