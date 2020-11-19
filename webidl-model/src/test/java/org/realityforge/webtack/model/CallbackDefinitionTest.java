package org.realityforge.webtack.model;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;
import org.realityforge.webtack.webidl.parser.WebIDLParser;
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
        ensureCallbackDefinition( "callback PositionCallback = undefined (Position position);",
                                  "PositionCallback",
                                  Kind.Void,
                                  1 );
      final Argument argument1 = definition.getArguments().get( 0 );
      assertEquals( argument1.getName(), "position" );
      final Type argument1Type = argument1.getType();
      assertEquals( argument1Type.getKind(), Kind.TypeReference );
      assertEquals( ( (TypeReference) argument1Type ).getName(), "Position" );
    }
    // Single arg, void return
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
        ensureCallbackDefinition(
          "callback XRFrameRequestCallback = undefined (DOMHighResTimeStamp time, XRFrame frame);",
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
    final WebIDLParser.DefinitionContext ctx = createParser( webIDL ).definition();
    final Definition definition =
      WebIDLModelParser.parse( ctx, null, Collections.emptyList(), parseStartPosition( ctx ) );
    assertTrue( definition instanceof CallbackDefinition );
    final CallbackDefinition actual = (CallbackDefinition) definition;
    assertEquals( actual.getName(), name );
    assertEquals( actual.getReturnType().getKind(), returnTypeKind );
    assertEquals( actual.getArguments().size(), argumentCount );
    assertEquals( actual, actual );
    assertEquals( actual.hashCode(), actual.hashCode() );

    final StringWriter writer = new StringWriter();
    WebIDLWriter.writeCallbackDefinition( writer, actual );
    writer.close();
    final String emittedIDL = writer.toString();
    final List<Definition> definitions = WebIDLModelParser.parse( createParser( emittedIDL ).definitions() );
    assertEquals( definitions.size(), 1 );
    assertTrue( definitions.get( 0 ) instanceof CallbackDefinition );
    final CallbackDefinition element = (CallbackDefinition) definitions.get( 0 );
    assertEquals( element, element );
    assertEquals( element.hashCode(), element.hashCode() );

    assertTrue( element.equiv( actual ) );
    assertNotSame( element, actual );

    return actual;
  }
}
