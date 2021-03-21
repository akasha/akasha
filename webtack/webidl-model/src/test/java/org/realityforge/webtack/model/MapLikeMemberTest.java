package org.realityforge.webtack.model;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collections;
import javax.annotation.Nonnull;
import org.realityforge.webtack.webidl.parser.WebIDLParser;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class MapLikeMemberTest
  extends AbstractTest
{
  @Test
  public void parse()
    throws IOException
  {
    {
      final MapLikeMember mapLike = parse( "maplike<DOMString, object>;", true );
      assertEquals( mapLike.getKeyType().getKind(), Kind.DOMString );
      assertEquals( mapLike.getValueType().getKind(), Kind.Object );
      assertTrue( mapLike.isReadOnly() );
    }

    {
      final MapLikeMember mapLike = parse( "maplike<DOMString, AudioParam>;", false );
      assertEquals( mapLike.getKeyType().getKind(), Kind.DOMString );
      assertEquals( mapLike.getValueType().getKind(), Kind.TypeReference );
      assertEquals( ( (TypeReference) mapLike.getValueType() ).getName(), "AudioParam" );
      assertFalse( mapLike.isReadOnly() );
    }
  }

  @Nonnull
  private MapLikeMember parse( @Nonnull final String webIDL, final boolean readOnly )
    throws IOException
  {
    final WebIDLParser.MaplikeRestContext ctx = createParser( webIDL ).maplikeRest();
    final MapLikeMember actual =
      WebIDLModelParser.parse( ctx, readOnly, null, Collections.emptyList(), parseStartPosition( ctx ) );

    assertEquals( actual, actual );
    assertEquals( actual.hashCode(), actual.hashCode() );

    final StringWriter writer = new StringWriter();
    WebIDLWriter.writeMapLikeMember( writer, actual );
    writer.close();
    final String emittedIDL = writer.toString();
    final MapLikeMember element;
    if ( readOnly )
    {
      final WebIDLParser.ReadOnlyMemberContext ctx2 = createParser( emittedIDL ).readOnlyMember();
      element =
        (MapLikeMember) WebIDLModelParser.parse( ctx2, null, Collections.emptyList(), parseStartPosition( ctx2 ) );
    }
    else
    {
      final WebIDLParser.MaplikeRestContext ctx2 = createParser( emittedIDL ).maplikeRest();
      element = WebIDLModelParser.parse( ctx2, readOnly, null, Collections.emptyList(), parseStartPosition( ctx2 ) );
    }
    assertEquals( element, element );
    assertEquals( element.hashCode(), element.hashCode() );

    assertTrue( element.equiv( actual ) );
    assertNotSame( element, actual );

    return actual;
  }
}
