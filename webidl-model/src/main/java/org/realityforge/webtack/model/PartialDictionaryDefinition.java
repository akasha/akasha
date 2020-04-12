package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;

public final class PartialDictionaryDefinition
  extends Definition
{
  @Nonnull
  private final String _name;
  @Nonnull
  private final List<DictionaryMember> _members;

  PartialDictionaryDefinition( @Nonnull final String name,
                               @Nonnull final List<DictionaryMember> members,
                               @Nonnull final List<ExtendedAttribute> extendedAttributes,
                               @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( extendedAttributes, sourceLocations );
    _name = Objects.requireNonNull( name );
    _members = Objects.requireNonNull( members );
  }

  @Nonnull
  public String getName()
  {
    return _name;
  }

  @Nonnull
  public List<DictionaryMember> getMembers()
  {
    return _members;
  }
}
