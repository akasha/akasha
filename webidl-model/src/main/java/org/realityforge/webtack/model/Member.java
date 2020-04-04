package org.realityforge.webtack.model;

import java.util.List;
import javax.annotation.Nonnull;

/**
 * A member of an interface, a callback interface, interface mixins or namespaces.
 */
public abstract class Member
  extends NamedElement
{
  protected Member( @Nonnull final String name, @Nonnull final List<ExtendedAttribute> extendedAttributes )
  {
    super( name, extendedAttributes );
  }
}
