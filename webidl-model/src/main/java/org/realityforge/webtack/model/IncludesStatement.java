package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;

public final class IncludesStatement
  extends Definition
{
  @Nonnull
  private final String _interfaceName;
  @Nonnull
  private final String _mixinName;

  IncludesStatement( @Nonnull final String interfaceName,
                     @Nonnull final String mixinName,
                     @Nonnull final List<ExtendedAttribute> extendedAttributes,
                     @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( extendedAttributes, sourceLocations );
    _interfaceName = Objects.requireNonNull( interfaceName );
    _mixinName = Objects.requireNonNull( mixinName );
  }

  @Nonnull
  public String getInterfaceName()
  {
    return _interfaceName;
  }

  @Nonnull
  public String getMixinName()
  {
    return _mixinName;
  }

  @Override
  public boolean equals( final Object o )
  {
    if ( this == o )
    {
      return true;
    }
    else if ( o == null || getClass() != o.getClass() || !super.equals( o ) )
    {
      return false;
    }
    else
    {
      final IncludesStatement that = (IncludesStatement) o;
      return _interfaceName.equals( that._interfaceName ) &&
             _mixinName.equals( that._mixinName );
    }
  }

  @Override
  public int hashCode()
  {
    return Objects.hash( super.hashCode(), _interfaceName, _mixinName );
  }

  public boolean equiv( @Nonnull final IncludesStatement other )
  {
    return super.equiv( other ) &&
           _interfaceName.equals( other._interfaceName ) &&
           _mixinName.equals( other._mixinName );
  }
}
