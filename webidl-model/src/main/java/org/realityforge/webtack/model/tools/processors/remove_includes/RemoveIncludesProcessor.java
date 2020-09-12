package org.realityforge.webtack.model.tools.processors.remove_includes;

import java.util.Objects;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.IncludesStatement;
import org.realityforge.webtack.model.tools.processors.AbstractProcessor;
import org.realityforge.webtack.model.tools.spi.Completable;
import org.realityforge.webtack.model.tools.spi.PipelineContext;

/**
 * Remove includes that match a pattern.
 */
final class RemoveIncludesProcessor
  extends AbstractProcessor
  implements Completable
{
  @Nonnull
  private final PipelineContext _context;
  @Nonnull
  private final Pattern _interfacePattern;
  @Nonnull
  private final Pattern _mixinPattern;
  /**
   * The number of includes the processor expected to remove. If less than 1 this is ignored.
   */
  private final int _expectedRemoveCount;
  private int _removeCount;

  RemoveIncludesProcessor( @Nonnull final PipelineContext context,
                           @Nonnull final Pattern interfacePattern,
                           @Nonnull final Pattern mixinPattern,
                           final int expectedRemoveCount )
  {
    _context = Objects.requireNonNull( context );
    _interfacePattern = Objects.requireNonNull( interfacePattern );
    _mixinPattern = Objects.requireNonNull( mixinPattern );
    _expectedRemoveCount = expectedRemoveCount;
  }

  @Override
  public void onComplete()
  {
    if ( _expectedRemoveCount > 0 )
    {
      if ( _removeCount != _expectedRemoveCount )
      {
        _context.error( "Removed " + _removeCount + " includes but expected to " +
                        "remove " + _expectedRemoveCount + " includes." );
      }
    }
    else
    {
      if ( 0 == _removeCount )
      {
        _context.info( "Removed " + _removeCount + " includes." );
      }
      else
      {
        _context.debug( "Removed " + _removeCount + " includes." );
      }
    }
  }

  @Nullable
  <T> T incRemoveCountAndReturnNull()
  {
    _removeCount++;
    return null;
  }

  @Nullable
  @Override
  protected IncludesStatement transformIncludesStatement( @Nonnull final IncludesStatement input )
  {
    return matches( input ) ? incRemoveCountAndReturnNull() : super.transformIncludesStatement( input );
  }

  private boolean matches( @Nonnull final IncludesStatement input )
  {
    return _interfacePattern.matcher( input.getInterfaceName() ).matches() &&
           _mixinPattern.matcher( input.getMixinName() ).matches();
  }
}
