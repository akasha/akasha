package org.realityforge.webtack.model;

import java.util.Collections;
import java.util.List;
import org.realityforge.webtack.webidl.parser.WebIDLParser;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class OperationMemberTest
  extends AbstractTest
{
  @Test
  public void parse()
    throws Exception
  {
    final WebIDLParser.OperationContext ctx =
      createParser( "Promise<boolean> isSessionSupported(XRSessionMode mode);" ).operation();
    final OperationMember member = WebIDLModelParser.parse( ctx, Collections.emptyList(), parseStartPosition( ctx ) );
    assertEquals( member.getName(), "isSessionSupported" );
    assertEquals( member.getReturnType().getKind(), Kind.Promise );
    assertEquals( member.getKind(), OperationMember.Kind.DEFAULT );
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
    final WebIDLParser.OperationContext ctx =
      createParser( "getter XRInputSource(unsigned long index);" ).operation();
    final OperationMember member = WebIDLModelParser.parse( ctx, Collections.emptyList(), parseStartPosition( ctx ) );
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
    final WebIDLParser.OperationContext ctx = createParser( "boolean includes(any key);" ).operation();
    final OperationMember member = WebIDLModelParser.parse( ctx, Collections.emptyList(), parseStartPosition( ctx ) );
    assertEquals( member.getName(), "includes" );
    assertEquals( member.getReturnType().getKind(), Kind.Boolean );
    assertEquals( member.getKind(), OperationMember.Kind.DEFAULT );
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
    final WebIDLParser.StaticMemberContext ctx =
      createParser( "static double getNativeFramebufferScaleFactor(XRSession session);" ).staticMember();
    final Member member = WebIDLModelParser.parse( ctx, Collections.emptyList(), parseStartPosition( ctx ) );
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
    final WebIDLParser.StringifierContext ctx = createParser( "stringifier DOMString ();" ).stringifier();
    final Member member = WebIDLModelParser.parse( ctx, Collections.emptyList(), parseStartPosition( ctx ) );
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
    final WebIDLParser.StringifierContext ctx = createParser( "stringifier;" ).stringifier();
    final Member member = WebIDLModelParser.parse( ctx, Collections.emptyList(), parseStartPosition( ctx ) );
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
    final WebIDLParser.ConstructorContext ctx =
      createParser( "constructor(unsigned long sw, unsigned long sh);" ).constructor();
    final OperationMember operation = WebIDLModelParser.parse( ctx, Collections.emptyList(), parseStartPosition( ctx ) );
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
