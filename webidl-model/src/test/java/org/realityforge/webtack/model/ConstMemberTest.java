package org.realityforge.webtack.model;

import java.io.IOException;
import java.util.Collections;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.webidl.parser.WebIDLParser;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class ConstMemberTest
  extends AbstractTest
{
  @Test
  public void parse()
    throws Exception
  {
    assertConstMember( "const short rambaldi = 47;", "rambaldi", Kind.Short, ConstValue.Kind.Integer, "47" );
    assertConstMember( "const boolean ALIVE = true;", "ALIVE", Kind.Boolean, ConstValue.Kind.True, null );
    assertConstMember( "const GLenum DEPTH_BUFFER_BIT = 0x00000100;",
                       "DEPTH_BUFFER_BIT",
                       Kind.TypeReference,
                       ConstValue.Kind.Integer,
                       "0x00000100" );
  }

  private void assertConstMember( @Nonnull final String idl,
                                  @Nonnull final String name,
                                  @Nonnull final Kind kind,
                                  @Nonnull final ConstValue.Kind valueType,
                                  @Nullable final String value )
    throws IOException
  {
    final ConstMember member = parse( idl );
    assertEquals( member.getName(), name );
    assertEquals( member.getType().getKind(), kind );
    assertEquals( member.getValue().getKind(), valueType );
    assertEquals( member.getValue().getValue(), value );
  }

  @Nonnull
  private ConstMember parse( @Nonnull final String webIDL )
    throws IOException
  {
    final WebIDLParser.ConstMemberContext ctx = createParser( webIDL ).constMember();
    return WebIDLModelParser.parse( ctx, Collections.emptyList(), parseStartPosition( ctx ) );
  }
}
