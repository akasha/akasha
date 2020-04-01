package org.realityforge.webtack.model;

import java.io.IOException;
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
        ensureArgument( "optional XRRenderStateInit state = {}", "state", Kind.Enumeration, true, false );
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
    final Argument argument = Argument.parse( createParser( webIDL ).argument() );
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
      final List<Argument> arguments = parseArgumentList( "optional DOMPointInit position = {}, optional DOMPointInit orientation = {}", 2 );

      final Argument argument1 = arguments.get( 0 );
      assertArgument( argument1, "position", Kind.Enumeration, true, false );
      assertNotNull( argument1.getDefaultValue() );
      assertEquals( argument1.getDefaultValue().getKind(), DefaultValue.Kind.EmptyDictionary );
      assertArgument( arguments.get( 1 ), "orientation", Kind.Enumeration, true, false );
    }
  }

  @Nonnull
  private List<Argument> parseArgumentList( @Nonnull final String webIDL, final int expectedArgumentCount )
    throws IOException
  {
    // Add a trailing ")" so we do not get an EOF when we try to peek at the next token to see if it is a ","
    final List<Argument> arguments = Argument.parse( createParser( webIDL + ")" ).argumentList() );
    assertEquals( arguments.size(), expectedArgumentCount );
    return arguments;
  }
}
