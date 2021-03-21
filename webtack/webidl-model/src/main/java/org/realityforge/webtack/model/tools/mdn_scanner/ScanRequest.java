package org.realityforge.webtack.model.tools.mdn_scanner;

import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

final class ScanRequest
{
  @Nonnull
  private final DocKind _kind;
  @Nonnull
  private final String _type;
  @Nullable
  private final String _member;

  ScanRequest( @Nonnull final DocKind kind, @Nonnull final String type, @Nullable final String member )
  {
    _kind = Objects.requireNonNull( kind );
    _type = Objects.requireNonNull( type );
    _member = member;
  }

  @Nonnull
  DocKind getKind()
  {
    return _kind;
  }

  @Nonnull
  String getType()
  {
    return _type;
  }

  @Nullable
  String getMember()
  {
    return _member;
  }
}
