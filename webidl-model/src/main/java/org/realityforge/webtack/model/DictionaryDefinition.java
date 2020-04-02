package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class DictionaryDefinition
  extends Definition
{
  @Nonnull
  private final String _name;
  @Nullable
  private final String _inherits;
  @Nonnull
  private final List<DictionaryMember> _members;

  DictionaryDefinition( @Nonnull final String name,
                        @Nullable final String inherits,
                        @Nonnull final List<DictionaryMember> members )
  {
    _name = Objects.requireNonNull( name );
    _inherits = inherits;
    _members = Objects.requireNonNull( members );
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
  public List<DictionaryMember> getMembers()
  {
    return _members;
  }
}
