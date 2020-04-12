package org.realityforge.webtack.model;

import java.io.IOException;
import java.util.Collections;
import javax.annotation.Nonnull;
import org.realityforge.webtack.webidl.parser.WebIDLParser;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class SetLikeMemberTest
  extends AbstractTest
{
  @Test
  public void parse()
    throws IOException
  {
    {
      final SetLikeMember setLike = parse( "setlike<DOMString>;", true );
      assertEquals( setLike.getType().getKind(), Kind.DOMString );
      assertTrue( setLike.isReadOnly() );
    }

    {
      final SetLikeMember setLike = parse( "setlike<FooBarBaz>;", false );
      assertEquals( setLike.getType().getKind(), Kind.TypeReference );
      assertEquals( ( (TypeReference) setLike.getType() ).getName(), "FooBarBaz" );
      assertFalse( setLike.isReadOnly() );
    }
  }

  @Nonnull
  private SetLikeMember parse( @Nonnull final String webIDL, final boolean readOnly )
    throws IOException
  {
    final WebIDLParser.SetlikeRestContext ctx = createParser( webIDL ).setlikeRest();
    return WebIDLModelParser.parse( ctx, readOnly, Collections.emptyList(), parseStartPosition( ctx ) );
  }
}
