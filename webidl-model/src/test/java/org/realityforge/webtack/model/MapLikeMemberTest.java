package org.realityforge.webtack.model;

import java.io.IOException;
import java.util.Collections;
import javax.annotation.Nonnull;
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
    return WebIDLModelParser.parse( createParser( webIDL ).maplikeRest(), readOnly, Collections.emptyList() );
  }
}
