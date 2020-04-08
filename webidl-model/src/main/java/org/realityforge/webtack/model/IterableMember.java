package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class IterableMember
  extends Element
  implements Member
{
  @Nullable
  private final Type _keyType;
  @Nonnull
  private final Type _valueType;

  IterableMember( @Nullable final Type keyType,
                  @Nonnull final Type valueType,
                  @Nonnull final List<ExtendedAttribute> extendedAttributes )
  {
    super( extendedAttributes );
    _keyType = keyType;
    _valueType = Objects.requireNonNull( valueType );
  }

  @Nullable
  public Type getKeyType()
  {
    return _keyType;
  }

  @Nonnull
  public Type getValueType()
  {
    return _valueType;
  }
}
