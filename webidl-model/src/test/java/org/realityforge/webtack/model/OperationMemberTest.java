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

  @Test
  public void parse_static()
    throws Exception
  {
    final Member member =
      WebIDLModelParser.parse( createParser( "static double getNativeFramebufferScaleFactor(XRSession session);" ).staticMember(),
                               Collections.emptyList() );
    assertTrue( member instanceof OperationMember );
    final OperationMember operation = (OperationMember) member;
    assertEquals( operation.getName(), "getNativeFramebufferScaleFactor" );
    assertEquals( operation.getReturnType().getKind(), Kind.Double );
    assertEquals( operation.getKind(), OperationMember.Kind.STATIC );
    final List<Argument> arguments = operation.getArguments();
    assertEquals( arguments.size(), 1 );
    final Argument argument1 = arguments.get( 0 );
    assertEquals( argument1.getName(), "session" );
    assertEquals( argument1.getType().getKind(), Kind.TypeReference );
  }

  @Test
  public void parse_stringifier()
    throws Exception
  {
    final Member member =
      WebIDLModelParser.parse( createParser( "stringifier DOMString ();" ).stringifier(),
                               Collections.emptyList() );
    assertTrue( member instanceof OperationMember );
    final OperationMember operation = (OperationMember) member;
    assertNull( operation.getName() );
    assertEquals( operation.getReturnType().getKind(), Kind.DOMString );
    assertEquals( operation.getKind(), OperationMember.Kind.STRINGIFIER );
    assertEquals( operation.getArguments().size(), 0 );
  }

  @Test
  public void parse_empty_stringifier()
    throws Exception
  {
    final Member member =
      WebIDLModelParser.parse( createParser( "stringifier;" ).stringifier(),
                               Collections.emptyList() );
    assertTrue( member instanceof OperationMember );
    final OperationMember operation = (OperationMember) member;
    assertNull( operation.getName() );
    assertEquals( operation.getReturnType().getKind(), Kind.DOMString );
    assertEquals( operation.getKind(), OperationMember.Kind.STRINGIFIER );
    assertEquals( operation.getArguments().size(), 0 );
  }

  @Test
  public void parse_constructor()
    throws Exception
  {
    final OperationMember operation =
      WebIDLModelParser.parse( createParser( "constructor(unsigned long sw, unsigned long sh);" ).constructor(),
                               Collections.emptyList() );
    assertNull( operation.getName() );
    assertEquals( operation.getReturnType().getKind(), Kind.Void );
    assertEquals( operation.getKind(), OperationMember.Kind.CONSTRUCTOR );
    final List<Argument> arguments = operation.getArguments();
    assertEquals( arguments.size(), 2 );
    final Argument argument1 = arguments.get( 0 );
    assertEquals( argument1.getName(), "sw" );
    assertEquals( argument1.getType().getKind(), Kind.UnsignedLong );
    final Argument argument2 = arguments.get( 1 );
    assertEquals( argument2.getName(), "sh" );
    assertEquals( argument2.getType().getKind(), Kind.UnsignedLong );
  }
}
