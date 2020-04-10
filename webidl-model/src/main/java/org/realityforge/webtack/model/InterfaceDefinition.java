package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class InterfaceDefinition
  extends Definition
{
  @Nonnull
  private final String _name;
  @Nullable
  private final String _inherits;
  @Nonnull
  private final List<ConstMember> _constants;
  @Nonnull
  private final List<AttributeMember> _attributes;
  @Nonnull
  private final List<OperationMember> _operations;
  @Nullable
  private final IterableMember _iterable;
  @Nullable
  private final AsyncIterableMember _asyncIterable;
  @Nullable
  private final MapLikeMember _mapLikeMember;
  @Nullable
  private final SetLikeMember _setLikeMember;

  InterfaceDefinition( @Nonnull final String name,
                       @Nullable final String inherits,
                       @Nonnull final List<ConstMember> constants,
                       @Nonnull final List<AttributeMember> attributes,
                       @Nonnull final List<OperationMember> operations,
                       @Nullable final IterableMember iterable,
                       @Nullable final AsyncIterableMember asyncIterable,
                       @Nullable final MapLikeMember mapLikeMember,
                       @Nullable final SetLikeMember setLikeMember,
                       @Nonnull final List<ExtendedAttribute> extendedAttributes )
  {
    super( extendedAttributes );
    _name = Objects.requireNonNull( name );
    _inherits = inherits;
    _constants = Objects.requireNonNull( constants );
    _attributes = Objects.requireNonNull( attributes );
    _operations = Objects.requireNonNull( operations );
    _iterable = iterable;
    _asyncIterable = asyncIterable;
    _mapLikeMember = mapLikeMember;
    _setLikeMember = setLikeMember;
  }

  @Nonnull
  public String getName()
  {
    return _name;
  }

  @Nullable
  public String getInherits()
  {
    return _inherits;
  }

  @Nonnull
  public List<ConstMember> getConstants()
  {
    return _constants;
  }

  @Nonnull
  public List<AttributeMember> getAttributes()
  {
    return _attributes;
  }

  @Nonnull
  public List<OperationMember> getOperations()
  {
    return _operations;
  }

  @Nullable
  public IterableMember getIterable()
  {
    return _iterable;
  }

  @Nullable
  public AsyncIterableMember getAsyncIterable()
  {
    return _asyncIterable;
  }

  @Nullable
  public MapLikeMember getMapLikeMember()
  {
    return _mapLikeMember;
  }

  @Nullable
  public SetLikeMember getSetLikeMember()
  {
    return _setLikeMember;
  }
}
