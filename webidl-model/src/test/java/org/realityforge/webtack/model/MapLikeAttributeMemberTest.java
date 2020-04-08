package org.realityforge.webtack.model;

import java.io.IOException;
import java.util.Collections;
import javax.annotation.Nonnull;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class MapLikeAttributeMemberTest
  extends AbstractTest
{
  @Test
  public void parse()
    throws IOException
  {
    {
      final MapLikeAttributeMember mapLike = parse( "maplike<DOMString, object>;", true );
      assertEquals( mapLike.getKeyType().getKind(), Kind.DOMString );
      assertEquals( mapLike.getValueType().getKind(), Kind.Object );
      assertTrue( mapLike.isReadOnly() );
    }

    {
      final MapLikeAttributeMember mapLike = parse( "maplike<DOMString, AudioParam>;", false );
      assertEquals( mapLike.getKeyType().getKind(), Kind.DOMString );
      assertEquals( mapLike.getValueType().getKind(), Kind.TypeReference );
      assertFalse( mapLike.isReadOnly() );
    }
  }

  @Nonnull
  private MapLikeAttributeMember parse( @Nonnull final String webIDL, final boolean readOnly )
    throws IOException
  {
    return WebIDLModelParser.parse( createParser( webIDL ).maplikeRest(), readOnly, Collections.emptyList() );
  }
}
