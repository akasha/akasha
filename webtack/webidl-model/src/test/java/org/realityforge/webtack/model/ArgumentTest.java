package org.realityforge.webtack.model;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import javax.annotation.Nonnull;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class ArgumentTest
  extends AbstractTest
{
  @Test
  public void parse()
    throws IOException
  {
    ensureArgument( "long speed", "speed", Kind.Long, false, false );
    {
      final Argument argument =
        ensureArgument( "optional boolean lazy = true", "lazy", Kind.Boolean, true, false );
      final DefaultValue defaultValue = argument.getDefaultValue();
      assertNotNull( defaultValue );
      assertEquals( defaultValue.getKind(), DefaultValue.Kind.Const );
      final ConstValue constValue = defaultValue.getConstValue();
      assertNotNull( constValue );
      assertEquals( constValue.getKind(), ConstValue.Kind.True );
    }

    {
      final Argument argument =
        ensureArgument( "optional XRRenderStateInit state = {}", "state", Kind.TypeReference, true, false );
      final DefaultValue defaultValue = argument.getDefaultValue();
      assertNotNull( defaultValue );
      assertEquals( defaultValue.getKind(), DefaultValue.Kind.EmptyDictionary );
      assertNull( defaultValue.getConstValue() );
    }

    {
      final Argument argument =
        ensureArgument( "long long... times", "times", Kind.LongLong, false, true );
      assertNull( argument.getDefaultValue() );
    }

    {
      final Argument argument =
        ensureArgument( "(Node or DOMString)... nodes", "nodes", Kind.Union, false, true );
      assertNull( argument.getDefaultValue() );
    }
  }

  @Nonnull
  private Argument ensureArgument( @Nonnull final String webIDL,
                                   @Nonnull final String name,
                                   @Nonnull final Kind kind,
                                   final boolean optional,
                                   final boolean variadic )
    throws IOException
  {
    final Argument argument = WebIDLModelParser.parse( createParser( webIDL ).argument(), null );
    assertArgument( argument, name, kind, optional, variadic );
    return argument;
  }

  @Test
  public void parseList()
    throws IOException
  {
    {
      final List<Argument> arguments = parseArgumentList( "long speed, long long accel, optional short friction", 3 );

      assertArgument( arguments.get( 0 ), "speed", Kind.Long, false, false );
      assertArgument( arguments.get( 1 ), "accel", Kind.LongLong, false, false );
      assertArgument( arguments.get( 2 ), "friction", Kind.Short, true, false );
    }

    {
      final List<Argument> arguments =
        parseArgumentList( "optional DOMPointInit position = {}, optional DOMPointInit orientation = {}", 2 );

      final Argument argument1 = arguments.get( 0 );
      assertArgument( argument1, "position", Kind.TypeReference, true, false );
      assertNotNull( argument1.getDefaultValue() );
      assertEquals( argument1.getDefaultValue().getKind(), DefaultValue.Kind.EmptyDictionary );
      assertArgument( arguments.get( 1 ), "orientation", Kind.TypeReference, true, false );
    }
  }

  @Nonnull
  private List<Argument> parseArgumentList( @Nonnull final String webIDL, final int expectedArgumentCount )
    throws IOException
  {
    // Add a trailing ")" so we do not get an EOF when we try to peek at the next token to see if it is a ","
    final List<Argument> actual = WebIDLModelParser.parse( createParser( webIDL + ")" ).argumentList(), null );
    assertEquals( actual.size(), expectedArgumentCount );

    final StringWriter writer = new StringWriter();
    WebIDLWriter.writeArgumentList( writer, actual );
    writer.close();
    // substring consumes the '(' opening for argList
    final String emittedIDL = writer.toString().substring( 1 );
    final List<Argument> elements = WebIDLModelParser.parse( createParser( emittedIDL + ")" ).argumentList(), null );
    assertEquals( elements.size(), expectedArgumentCount );
    for ( int i = 0; i < expectedArgumentCount; i++ )
    {
      final Argument element = elements.get( i );
      final Argument actualElement = actual.get( i );
      assertEquals( element, actualElement );
      assertEquals( element.hashCode(), actualElement.hashCode() );
      assertTrue( element.equiv( actualElement ) );
      assertNotSame( element, actualElement );
    }

    return actual;
  }
}
