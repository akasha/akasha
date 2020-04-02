package org.realityforge.webtack.model;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;
import javax.annotation.Nonnull;
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
    return WebIDLModelParser.parse( createParser( webIDL ).enumDefinition(), Collections.emptyList() );
  }
}
