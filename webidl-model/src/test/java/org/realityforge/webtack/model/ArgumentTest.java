package org.realityforge.webtack.model;

import java.io.IOException;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ArgumentTest
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
                                   @Nullable final Kind kind,
                                   final boolean optional,
                                   final boolean variadic )
    throws IOException
  {
    final Argument argument = Argument.parse( createParser( webIDL ).argument() );
    assertEquals( argument.getName(), name );
    assertEquals( argument.getType().getKind(), kind );
    assertEquals( argument.isOptional(), optional );
    assertEquals( argument.isVariadic(), variadic );
    return argument;
  }
}
