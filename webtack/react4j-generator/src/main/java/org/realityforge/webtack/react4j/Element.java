package org.realityforge.webtack.react4j;

import java.util.Objects;
import java.util.Set;
import javax.annotation.Nonnull;

final class Element
{
  @Nonnull
  private final String _name;
  @Nonnull
  private final Set<String> _classifications;
  /**
   * This set contains names of other element or names of classifications permitted to be contained within this element.
   */
  @Nonnull
  private final Set<String> _permittedContent;
  @Nonnull
  private final String _domInterface;
  private final boolean _supportsChildren;

  Element( @Nonnull final String name,
           @Nonnull final Set<String> classifications,
           @Nonnull final Set<String> permittedContent,
           @Nonnull final String domInterface,
           final boolean supportsChildren )
  {
    _name = Objects.requireNonNull( name );
    _classifications = Objects.requireNonNull( classifications );
    _permittedContent = Objects.requireNonNull( permittedContent );
    _domInterface = Objects.requireNonNull( domInterface );
    _supportsChildren = supportsChildren;
  }

  @Nonnull
  String getName()
  {
    return _name;
  }

  @Nonnull
  Set<String> getClassifications()
  {
    return _classifications;
  }

  @Nonnull
  Set<String> getPermittedContent()
  {
    return _permittedContent;
  }

  @Nonnull
  String getDomInterface()
  {
    return _domInterface;
  }

  boolean supportsChildren()
  {
    return _supportsChildren;
  }
}
