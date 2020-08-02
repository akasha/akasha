package org.realityforge.webtack.model.tools.mdn_scanner;

import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.tools.mdn_scanner.config.DocSourceConfig;

public final class DocFetchResult
{
  @Nonnull
  private final DocSourceConfig _source;
  @Nullable
  private final DocEntry _entry;
  private final boolean _changed;

  DocFetchResult( @Nonnull final DocSourceConfig source,
                  @Nullable final DocEntry entry,
                  final boolean changed )
  {
    _source = Objects.requireNonNull( source );
    _entry = entry;
    _changed = changed;
  }

  @Nonnull
  public DocSourceConfig getSource()
  {
    return _source;
  }

  @Nullable
  public DocEntry getEntry()
  {
    return _entry;
  }

  public boolean isChanged()
  {
    return _changed;
  }
}
