package org.realityforge.webtack.model;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class CallbackDefinitionTest
  extends AbstractTest
{
  @Test
  public void parse()
    throws IOException
  {
    // Single arg
    {
      final CallbackDefinition definition =
        ensureCallbackDefinition( "callback PositionCallback = void (Position position);",
                                  "PositionCallback",
                                  Kind.Void,
                                  1 );
      final Argument argument1 = definition.getArguments().get( 0 );
      assertEquals( argument1.getName(), "position" );
      final Type argument1Type = argument1.getType();
      assertEquals( argument1Type.getKind(), Kind.TypeReference );
      assertEquals( ( (TypeReference) argument1Type ).getName(), "Position" );
    }

    // Multiple args
    {
      final CallbackDefinition definition =
        ensureCallbackDefinition( "callback XRFrameRequestCallback = void (DOMHighResTimeStamp time, XRFrame frame);",
                                  "XRFrameRequestCallback",
                                  Kind.Void,
                                  2 );
      final List<Argument> arguments = definition.getArguments();
      final Argument argument1 = arguments.get( 0 );
      assertEquals( argument1.getName(), "time" );
      final Type argument1Type = argument1.getType();
      assertEquals( argument1Type.getKind(), Kind.TypeReference );
      assertEquals( ( (TypeReference) argument1Type ).getName(), "DOMHighResTimeStamp" );
    }

    // zero args but has a return type
    {
      final CallbackDefinition definition =
        ensureCallbackDefinition( "callback ClipboardItemDelayedCallback = ClipboardItemData ();",
                                  "ClipboardItemDelayedCallback",
                                  Kind.TypeReference,
                                  0 );
      assertEquals( ( (TypeReference) definition.getReturnType() ).getName(), "ClipboardItemData" );
    }
  }

  @Nonnull
  private CallbackDefinition ensureCallbackDefinition( @Nonnull final String webIDL,
                                                       @Nonnull final String name,
                                                       @Nonnull final Kind returnTypeKind,
                                                       final int argumentCount )
    throws IOException
  {
    final Definition definition =
      WebIDLModelParser.parse( createParser( webIDL ).definition(), Collections.emptyList() );
    assertTrue( definition instanceof CallbackDefinition );
    final CallbackDefinition callbackDefinition = (CallbackDefinition) definition;
    assertEquals( callbackDefinition.getName(), name );
    assertEquals( callbackDefinition.getReturnType().getKind(), returnTypeKind );
    assertEquals( callbackDefinition.getArguments().size(), argumentCount );
    return callbackDefinition;
  }
}
