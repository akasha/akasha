package org.realityforge.webtack.model.tools.mdn_scanner;

import java.util.Objects;
import javax.annotation.Nonnull;

final class ExtractResult
{
  @Nonnull
  private final DocEntry _entry;
  private final boolean _changed;

  ExtractResult( @Nonnull final DocEntry entry, final boolean changed )
  {
    _entry = Objects.requireNonNull( entry );
    _changed = changed;
  }

  @Nonnull
  DocEntry getEntry()
  {
    return _entry;
  }

  boolean isChanged()
  {
    return _changed;
  }
}
