package org.realityforge.webtack.model.tools.mdn_scanner;

import java.util.Objects;
import javax.annotation.Nonnull;

public final class SourceFetchException
  extends DocException
{
  @Nonnull
  private final String _qualifiedName;

  public SourceFetchException( @Nonnull final String qualifiedName, @Nonnull final Throwable cause )
  {
    super( cause );
    _qualifiedName = Objects.requireNonNull( qualifiedName );
  }

  @Nonnull
  public String getQualifiedName()
  {
    return _qualifiedName;
  }
}
