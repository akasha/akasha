package org.realityforge.webtack.model;

import java.io.IOException;
import java.io.StringReader;
import java.util.UUID;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.webidl.parser.WebIDLParser;
import org.testng.Assert;
import static org.testng.Assert.*;

public abstract class AbstractTest
{
  protected final void assertArgument( @Nonnull final Argument argument,
                                       @Nonnull final String name,
                                       @Nonnull final Kind kind,
                                       final boolean optional,
                                       final boolean variadic )
  {
    assertEquals( argument.getName(), name );
    assertEquals( argument.getType().getKind(), kind );
    assertEquals( argument.isOptional(), optional );
    assertEquals( argument.isVariadic(), variadic );
  }

  @Nonnull
  protected final String randomString()
  {
    return UUID.randomUUID().toString().substring( 0, 7 );
  }

  protected final <T extends Throwable> void assertThrows( @Nonnull Class<T> throwableClass,
                                                           @Nullable final String message,
                                                           @Nonnull final Assert.ThrowingRunnable throwingRunnable )
  {
    assertEquals( expectThrows( throwableClass, throwingRunnable ).getMessage(), message );
  }

  @Nonnull
  protected final WebIDLParser createParser( @Nonnull final String webIDL )
    throws IOException
  {
    return WebIDLModelParser.createParser( "test", new StringReader( webIDL ) );
  }
}
