package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;

public final class SetLikeMember
  extends Element
  implements Member
{
  @Nonnull
  private final Type _type;
  private final boolean _readOnly;

  SetLikeMember( @Nonnull final Type type,
                 final boolean readOnly,
                 @Nonnull final List<ExtendedAttribute> extendedAttributes,
                 @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( extendedAttributes, sourceLocations );
    _type = Objects.requireNonNull( type );
    _readOnly = readOnly;
  }

  @Nonnull
  public Type getType()
  {
    return _type;
  }

  public boolean isReadOnly()
  {
    return _readOnly;
  }
}
