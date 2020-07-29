package org.realityforge.webtack.model;

import java.io.IOException;
import java.io.StringWriter;
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
    final SetLikeMember actual =
      WebIDLModelParser.parse( ctx, readOnly, null, Collections.emptyList(), parseStartPosition( ctx ) );

    assertEquals( actual, actual );
    assertEquals( actual.hashCode(), actual.hashCode() );

    final StringWriter writer = new StringWriter();
    WebIDLWriter.writeSetLikeMember( writer, actual );
    writer.close();
    final String emittedIDL = writer.toString();
    final SetLikeMember element;
    if ( readOnly )
    {
      final WebIDLParser.ReadOnlyMemberContext ctx2 = createParser( emittedIDL ).readOnlyMember();
      element =
        (SetLikeMember) WebIDLModelParser.parse( ctx2, null, Collections.emptyList(), parseStartPosition( ctx2 ) );
    }
    else
    {
      final WebIDLParser.SetlikeRestContext ctx2 = createParser( emittedIDL ).setlikeRest();
      element = WebIDLModelParser.parse( ctx2, readOnly, null, Collections.emptyList(), parseStartPosition( ctx2 ) );
    }
    assertEquals( element, element );
    assertEquals( element.hashCode(), element.hashCode() );

    assertTrue( element.equiv( actual ) );
    assertNotSame( element, actual );

    return actual;
  }
}
