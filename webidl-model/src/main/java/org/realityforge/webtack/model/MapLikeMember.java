package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;

public final class MapLikeMember
  extends Element
  implements Member
{
  @Nonnull
  private final Type _keyType;
  @Nonnull
  private final Type _valueType;
  private final boolean _readOnly;

  MapLikeMember( @Nonnull final Type keyType,
                 @Nonnull final Type valueType,
                 final boolean readOnly,
                 @Nonnull final List<ExtendedAttribute> extendedAttributes,
                 @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( extendedAttributes, sourceLocations );
    _keyType = Objects.requireNonNull( keyType );
    _valueType = Objects.requireNonNull( valueType );
    _readOnly = readOnly;
  }

  @Nonnull
  public Type getKeyType()
  {
    return _keyType;
  }

  @Nonnull
  public Type getValueType()
  {
    return _valueType;
  }

  public boolean isReadOnly()
  {
    return _readOnly;
  }
}
