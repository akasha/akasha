package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public interface OperationMemberContainer
{
  @Nonnull
  List<OperationMember> getOperations();

  @Nonnull
  default List<OperationMember> findAllOperationsByName( @Nonnull final String name )
  {
    return getOperations().stream().filter( c -> name.equals( c.getName() ) ).collect( Collectors.toList() );
  }

  @Nullable
  default OperationMember findOperationByName( @Nonnull final String name )
  {
    return getOperations().stream().filter( c -> name.equals( c.getName() ) ).findFirst().orElse( null );
  }

  @Nonnull
  default OperationMember getOperationByName( @Nonnull final String name )
  {
    return Objects.requireNonNull( findOperationByName( name ), "Missing expected Operation with name " + name );
  }

}
