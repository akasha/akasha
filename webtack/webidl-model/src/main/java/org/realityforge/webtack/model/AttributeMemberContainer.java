package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public interface AttributeMemberContainer
{
  @Nonnull
  List<AttributeMember> getAttributes();

  @Nullable
  default AttributeMember findAttributeByName( @Nonnull final String name )
  {
    return getAttributes().stream().filter( a -> a.getName().equals( name ) ).findFirst().orElse( null );
  }

  @Nonnull
  default AttributeMember getAttributeByName( @Nonnull final String name )
  {
    return Objects.requireNonNull( findAttributeByName( name ), "Missing expected attribute with name " + name );
  }
}
