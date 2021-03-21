package org.realityforge.webtack.model;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;
import org.realityforge.webtack.webidl.parser.WebIDLParser;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class CallbackInterfaceDefinitionTest
  extends AbstractTest
{
  @Test
  public void parse_no_constants()
    throws IOException
  {
    final CallbackInterfaceDefinition definition =
      ensureCallbackInterface( "callback interface EventListener {\n" +
                               "  void handleEvent(Event event);\n" +
                               "};\n",
                               "EventListener",
                               0 );
    final OperationMember operation = definition.getOperation();
    assertEquals( operation.getName(), "handleEvent" );
    assertEquals( operation.getReturnType().getKind(), Kind.Void );
    final List<Argument> arguments = operation.getArguments();
    assertEquals( arguments.size(), 1 );
    final Argument argument = arguments.get( 0 );

    assertEquals( argument.getName(), "event" );
    final Type argumentType = argument.getType();
    assertEquals( argumentType.getKind(), Kind.TypeReference );
    assertEquals( ( (TypeReference) argumentType ).getName(), "Event" );
  }

  @Test
  public void parse_with_constants()
    throws IOException
  {
    final CallbackInterfaceDefinition definition =
      ensureCallbackInterface( "callback interface NodeFilter {\n" +
                               "  // Constants for acceptNode()\n" +
                               "  const unsigned short FILTER_ACCEPT = 1;\n" +
                               "  const unsigned short FILTER_REJECT = 2;\n" +
                               "  const unsigned short FILTER_SKIP = 3;\n" +
                               "  unsigned short acceptNode(Node node);\n" +
                               "};\n",
                               "NodeFilter",
                               3 );

    final OperationMember operation = definition.getOperation();
    assertEquals( operation.getName(), "acceptNode" );
    assertEquals( operation.getReturnType().getKind(), Kind.UnsignedShort );
    final List<Argument> arguments = operation.getArguments();
    assertEquals( arguments.size(), 1 );
    final Argument argument = arguments.get( 0 );

    assertEquals( argument.getName(), "node" );
    final Type argumentType = argument.getType();
    assertEquals( argumentType.getKind(), Kind.TypeReference );
    assertEquals( ( (TypeReference) argumentType ).getName(), "Node" );

    final List<ConstMember> constants = definition.getConstants();
    final ConstMember constant1 = constants.get( 0 );
    assertEquals( constant1.getName(), "FILTER_ACCEPT" );
    assertEquals( constant1.getType().getKind(), Kind.UnsignedShort );
    assertEquals( constant1.getValue().getKind(), ConstValue.Kind.Integer );
    assertEquals( constant1.getValue().getValue(), "1" );

    final ConstMember constant2 = constants.get( 1 );
    assertEquals( constant2.getName(), "FILTER_REJECT" );
    assertEquals( constant2.getType().getKind(), Kind.UnsignedShort );
    assertEquals( constant2.getValue().getKind(), ConstValue.Kind.Integer );
    assertEquals( constant2.getValue().getValue(), "2" );

    final ConstMember constant3 = constants.get( 2 );
    assertEquals( constant3.getName(), "FILTER_SKIP" );
    assertEquals( constant3.getType().getKind(), Kind.UnsignedShort );
    assertEquals( constant3.getValue().getKind(), ConstValue.Kind.Integer );
    assertEquals( constant3.getValue().getValue(), "3" );
  }

  @Nonnull
  private CallbackInterfaceDefinition ensureCallbackInterface( @Nonnull final String webIDL,
                                                               @Nonnull final String name,
                                                               final int constantCount )
    throws IOException
  {
    final WebIDLParser.DefinitionContext ctx = createParser( webIDL ).definition();
    final Definition definition =
      WebIDLModelParser.parse( ctx, null, Collections.emptyList(), parseStartPosition( ctx ) );
    assertTrue( definition instanceof CallbackInterfaceDefinition );
    final CallbackInterfaceDefinition actual = (CallbackInterfaceDefinition) definition;
    assertEquals( actual.getName(), name );
    assertEquals( actual.getConstants().size(), constantCount );

    final StringWriter writer = new StringWriter();
    WebIDLWriter.writeCallbackInterfaceDefinition( writer, actual );
    writer.close();
    final String emittedIDL = writer.toString();
    final List<Definition> definitions = WebIDLModelParser.parse( createParser( emittedIDL ).definitions() );
    assertEquals( definitions.size(), 1 );
    assertTrue( definitions.get( 0 ) instanceof CallbackInterfaceDefinition );
    final CallbackInterfaceDefinition element = (CallbackInterfaceDefinition) definitions.get( 0 );
    assertEquals( element, element );
    assertEquals( element.hashCode(), element.hashCode() );

    assertTrue( element.equiv( actual ) );
    assertNotSame( element, actual );

    return actual;
  }
}
