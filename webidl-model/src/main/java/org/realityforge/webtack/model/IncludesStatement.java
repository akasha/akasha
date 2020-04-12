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
}
