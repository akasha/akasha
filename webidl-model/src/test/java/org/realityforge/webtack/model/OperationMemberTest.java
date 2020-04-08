package org.realityforge.webtack.model;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class OperationMemberTest
  extends AbstractTest
{
  @Test
  public void parse()
    throws Exception
  {
    {
      final OperationMember operationMember =
        ensureOperationMember( "Promise<boolean> isSessionSupported(XRSessionMode mode);",
                               "isSessionSupported",
                               Kind.Promise );
      assertEquals( operationMember.getKind(), OperationMember.Kind.OPERATOR );
      assertEquals( ( (PromiseType) operationMember.getReturnType() ).getResolveType().getKind(), Kind.Boolean );
      final List<Argument> arguments = operationMember.getArguments();
      assertEquals( arguments.size(), 1 );
      final Argument argument1 = arguments.get( 0 );
      assertEquals( argument1.getName(), "mode" );
      final Type argument1Type = argument1.getType();
      assertEquals( argument1Type.getKind(), Kind.TypeReference );
      assertEquals( ( (TypeReference) argument1Type ).getName(), "XRSessionMode" );
    }

    {
      final OperationMember operationMember =
        ensureOperationMember( "getter XRInputSource(unsigned long index);",
                               null,
                               Kind.TypeReference );
      assertEquals( operationMember.getKind(), OperationMember.Kind.GETTER );
      assertEquals( ( (TypeReference) operationMember.getReturnType() ).getName(), "XRInputSource" );
      final List<Argument> arguments = operationMember.getArguments();
      assertEquals( arguments.size(), 1 );
      final Argument argument1 = arguments.get( 0 );
      assertEquals( argument1.getName(), "index" );
      assertEquals( argument1.getType().getKind(), Kind.UnsignedLong );
    }

    {
      final OperationMember operationMember =
        ensureOperationMember( "boolean includes(any key);",
                               "includes",
                               Kind.Boolean );
      assertEquals( operationMember.getKind(), OperationMember.Kind.OPERATOR );
      final List<Argument> arguments = operationMember.getArguments();
      assertEquals( arguments.size(), 1 );
      final Argument argument1 = arguments.get( 0 );
      assertEquals( argument1.getName(), "key" );
      assertEquals( argument1.getType().getKind(), Kind.Any );
    }
  }

  @Nonnull
  private OperationMember ensureOperationMember( @Nonnull final String idl,
                                                 @Nullable final String name,
                                                 @Nonnull final Kind returnKind )
    throws IOException
  {
    final OperationMember member = parse( idl );
    assertEquals( member.getName(), name );
    assertEquals( member.getReturnType().getKind(), returnKind );
    return member;
  }

  @Nonnull
  private OperationMember parse( @Nonnull final String webIDL )
    throws IOException
  {
    return WebIDLModelParser.parse( createParser( webIDL ).operation(), Collections.emptyList() );
  }
}
