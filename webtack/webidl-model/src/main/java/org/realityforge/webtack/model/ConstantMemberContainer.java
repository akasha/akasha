package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public interface ConstantMemberContainer
{
  @Nonnull
  List<ConstMember> getConstants();

  @Nullable
  default ConstMember findConstantByName( @Nonnull final String name )
  {
    return getConstants().stream().filter( c -> c.getName().equals( name ) ).findFirst().orElse( null );
  }

  @Nonnull
  default ConstMember getConstantByName( @Nonnull final String name )
  {
    return Objects.requireNonNull( findConstantByName( name ), "Missing expected constant with name " + name );
  }
}
