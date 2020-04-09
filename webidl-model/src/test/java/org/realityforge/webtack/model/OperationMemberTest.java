package org.realityforge.webtack.model;

import java.util.Collections;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class OperationMemberTest
  extends AbstractTest
{
  @Test
  public void parse()
    throws Exception
  {
    final OperationMember member =
      WebIDLModelParser.parse( createParser( "Promise<boolean> isSessionSupported(XRSessionMode mode);" ).operation(),
                               Collections.emptyList() );
    assertEquals( member.getName(), "isSessionSupported" );
    assertEquals( member.getReturnType().getKind(), Kind.Promise );
    assertEquals( member.getKind(), OperationMember.Kind.OPERATOR );
    assertEquals( ( (PromiseType) member.getReturnType() ).getResolveType().getKind(), Kind.Boolean );
    final List<Argument> arguments = member.getArguments();
    assertEquals( arguments.size(), 1 );
    final Argument argument1 = arguments.get( 0 );
    assertEquals( argument1.getName(), "mode" );
    final Type argument1Type = argument1.getType();
    assertEquals( argument1Type.getKind(), Kind.TypeReference );
    assertEquals( ( (TypeReference) argument1Type ).getName(), "XRSessionMode" );
  }

  @Test
  public void parse_getter()
    throws Exception
  {
    final OperationMember member =
      WebIDLModelParser.parse( createParser( "getter XRInputSource(unsigned long index);" ).operation(),
                               Collections.emptyList() );
    assertNull( member.getName() );
    assertEquals( member.getReturnType().getKind(), Kind.TypeReference );
    assertEquals( member.getKind(), OperationMember.Kind.GETTER );
    assertEquals( ( (TypeReference) member.getReturnType() ).getName(), "XRInputSource" );
    final List<Argument> arguments = member.getArguments();
    assertEquals( arguments.size(), 1 );
    final Argument argument1 = arguments.get( 0 );
    assertEquals( argument1.getName(), "index" );
    assertEquals( argument1.getType().getKind(), Kind.UnsignedLong );

  }

  @Test
  public void parse_specialName()
    throws Exception
  {
    final OperationMember member =
      WebIDLModelParser.parse( createParser( "boolean includes(any key);" ).operation(), Collections.emptyList() );
    assertEquals( member.getName(), "includes" );
    assertEquals( member.getReturnType().getKind(), Kind.Boolean );
    assertEquals( member.getKind(), OperationMember.Kind.OPERATOR );
    final List<Argument> arguments = member.getArguments();
    assertEquals( arguments.size(), 1 );
    final Argument argument1 = arguments.get( 0 );
    assertEquals( argument1.getName(), "key" );
    assertEquals( argument1.getType().getKind(), Kind.Any );
  }
}
