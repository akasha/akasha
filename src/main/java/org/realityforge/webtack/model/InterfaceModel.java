package org.realityforge.webtack.model;

import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class InterfaceModel
{
  @Nonnull
  private final ModelRepository _repository;
  @Nonnull
  private final String _name;
  @Nullable
  private String _inherits;
  private boolean _inheritsSet;

  InterfaceModel( @Nonnull final ModelRepository repository, @Nonnull final String name )
  {
    _repository = Objects.requireNonNull( repository );
    _name = Objects.requireNonNull( name );
  }

  @Nonnull
  public ModelRepository getRepository()
  {
    return _repository;
  }

  @Nonnull
  public String getName()
  {
    return _name;
  }

  public boolean isInheritsSet()
  {
    return _inheritsSet;
  }

  public void setInherits( @Nullable final String inherits )
  {
    if ( _inheritsSet )
    {
      if ( Objects.equals( inherits, _inherits ) )
      {
        throw new IllegalModelException( "Attempting to set inherits for interface named '" + _name + "' to '" +
                                         inherits + "' but it has already been set to '" + _inherits + "'" );
      }
    }
    else
    {
      _inherits = inherits;
      _inheritsSet = true;
    }
  }

  @Nullable
  public String getInherits()
  {
    if ( !isInheritsSet() )
    {
      throw new IllegalModelException( "Attempting to access inherits for interface named '" +
                                       _name + "' before it has been set" );
    }
    return _inherits;
  }
}
