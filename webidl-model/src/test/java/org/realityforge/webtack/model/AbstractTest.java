package org.realityforge.webtack.model;

import java.util.UUID;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.testng.Assert;
import static org.testng.Assert.*;

public abstract class AbstractTest
{
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
}
