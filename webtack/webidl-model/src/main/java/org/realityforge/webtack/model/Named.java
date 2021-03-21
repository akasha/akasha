package org.realityforge.webtack.model;

import javax.annotation.Nonnull;

/**
 * A member of an interface, a callback interface, interface mixins or namespaces.
 */
public interface Named
{
  /**
   * Return the name of the node.
   *
   * @return the name of the node.
   */
  @Nonnull
  String getName();
}
