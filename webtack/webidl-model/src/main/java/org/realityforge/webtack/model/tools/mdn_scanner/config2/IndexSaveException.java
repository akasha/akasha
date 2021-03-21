package org.realityforge.webtack.model.tools.mdn_scanner.config2;

import java.util.Objects;
import javax.annotation.Nonnull;

public final class IndexSaveException
  extends IndexException
{
  @Nonnull
  private final DocIndex _index;

  public IndexSaveException( @Nonnull final DocIndex index, @Nonnull final Throwable cause )
  {
    super( cause );
    _index = Objects.requireNonNull( index );
  }

  @Nonnull
  public DocIndex getIndex()
  {
    return _index;
  }
}
