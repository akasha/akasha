package org.realityforge.webtack.model;

import java.util.Collections;
import org.realityforge.webtack.webidl.parser.WebIDLParser;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

// This class contains tests for parse rules that do not line up one-to-one with a type
public final class WebIDLModelParserTest
  extends AbstractTest
{
  @Test
  public void parse_readOnlyMember_attributeRest()
    throws Exception
  {
    final WebIDLParser.ReadOnlyMemberContext ctx =
      createParser( "readonly attribute DOMString name;" ).readOnlyMember();
    final Member member = WebIDLModelParser.parse( ctx, null, Collections.emptyList(), parseStartPosition( ctx ) );
    assertTrue( member instanceof AttributeMember );
    final AttributeMember value = (AttributeMember) member;
    assertEquals( value.getName(), "name" );
    assertEquals( value.getType().getKind(), Kind.DOMString );
    assertEquals( value.getModifiers().size(), 1 );
    assertTrue( value.getModifiers().contains( AttributeMember.Modifier.READ_ONLY ) );
  }

  @Test
  public void parse_readOnlyMember_maplikeRest()
    throws Exception
  {
    final WebIDLParser.ReadOnlyMemberContext ctx =
      createParser( "readonly maplike<DOMString, object>;" ).readOnlyMember();
    final Member member = WebIDLModelParser.parse( ctx, null, Collections.emptyList(), parseStartPosition( ctx ) );
    assertTrue( member instanceof MapLikeMember );

    final MapLikeMember mapLike = (MapLikeMember) member;
    assertEquals( mapLike.getKeyType().getKind(), Kind.DOMString );
    assertEquals( mapLike.getValueType().getKind(), Kind.Object );
    assertTrue( mapLike.isReadOnly() );
  }

  @Test
  public void parse_readOnlyMember_setlikeRest()
    throws Exception
  {
    final WebIDLParser.ReadOnlyMemberContext ctx =
      createParser( "readonly setlike<DOMString>;" ).readOnlyMember();
    final Member member = WebIDLModelParser.parse( ctx, null, Collections.emptyList(), parseStartPosition( ctx ) );
    assertTrue( member instanceof SetLikeMember );

    final SetLikeMember setLike = (SetLikeMember) member;
    assertEquals( setLike.getType().getKind(), Kind.DOMString );
    assertTrue( setLike.isReadOnly() );
  }
}
