package org.realityforge.webtack.model.tools.processors.remove_includes;

import java.util.Objects;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.IncludesStatement;
import org.realityforge.webtack.model.tools.processors.AbstractProcessor;

/**
 * Remove includes that match a pattern.
 */
public final class RemoveIncludesProcessor
  extends AbstractProcessor
{
  @Nonnull
  private final Pattern _interfacePattern;
  @Nonnull
  private final Pattern _mixinPattern;

  RemoveIncludesProcessor( @Nonnull final Pattern interfacePattern, @Nonnull final Pattern mixinPattern )
  {
    _interfacePattern = Objects.requireNonNull( interfacePattern );
    _mixinPattern = Objects.requireNonNull( mixinPattern );
  }

  @Nullable
  @Override
  protected IncludesStatement transformIncludesStatement( @Nonnull final IncludesStatement input )
  {
    return matches( input ) ? null : super.transformIncludesStatement( input );
  }

  private boolean matches( @Nonnull final IncludesStatement input )
  {
    return _interfacePattern.matcher( input.getInterfaceName() ).matches() &&
           _mixinPattern.matcher( input.getMixinName() ).matches();
  }
}
