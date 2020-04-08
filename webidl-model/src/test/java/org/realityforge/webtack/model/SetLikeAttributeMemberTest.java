package org.realityforge.webtack.model;

import java.io.IOException;
import java.util.Collections;
import javax.annotation.Nonnull;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class SetLikeAttributeMemberTest
  extends AbstractTest
{
  @Test
  public void parse()
    throws IOException
  {
    {
      final SetLikeAttributeMember setLike = parse( "setlike<DOMString>;", true );
      assertEquals( setLike.getType().getKind(), Kind.DOMString );
      assertTrue( setLike.isReadOnly() );
    }

    {
      final SetLikeAttributeMember setLike = parse( "setlike<FooBarBaz>;", false );
      assertEquals( setLike.getType().getKind(), Kind.TypeReference );
      assertEquals( ( (TypeReference) setLike.getType() ).getName(), "FooBarBaz" );
      assertFalse( setLike.isReadOnly() );
    }
  }

  @Nonnull
  private SetLikeAttributeMember parse( @Nonnull final String webIDL, final boolean readOnly )
    throws IOException
  {
    return WebIDLModelParser.parse( createParser( webIDL ).setlikeRest(), readOnly, Collections.emptyList() );
  }
}
