package org.realityforge.webtack.model;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;

public final class ModelRepository
{
  @Nonnull
  private final Map<String, InterfaceModel> _interfaces = new HashMap<>();

  @Nonnull
  public InterfaceModel findOrCreateInterfaceByName( @Nonnull final String name )
  {
    return _interfaces.computeIfAbsent( name, n -> new InterfaceModel( this, n ) );
  }

  @Nonnull
  public Collection<InterfaceModel> getInterfaces()
  {
    return Collections.unmodifiableCollection( _interfaces.values() );
  }
}
