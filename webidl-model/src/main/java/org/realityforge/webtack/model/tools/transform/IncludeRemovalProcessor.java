package org.realityforge.webtack.model.tools.transform;

import java.util.Objects;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.IncludesStatement;

/**
 * Remove includes that match a pattern.
 */
public final class IncludeRemovalProcessor
  extends AbstractSchemaProcessor
{
  @Nonnull
  private final Pattern _interfacePattern;
  @Nonnull
  private final Pattern _mixinPattern;

  public IncludeRemovalProcessor( @Nonnull final Pattern interfacePattern, @Nonnull final Pattern mixinPattern )
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

  public static final class Config
    implements SchemaProcessorFactory
  {
    public String interfacePattern;
    public String mixinPattern;

    @Nonnull
    @Override
    public SchemaProcessor create()
    {
      return new IncludeRemovalProcessor( extractPattern( "interfacePattern", interfacePattern ),
                                          extractPattern( "mixinPattern", mixinPattern ) );
    }

    @Nonnull
    private Pattern extractPattern( @Nonnull final String configKey, @Nullable final String input )
    {
      if ( null == input )
      {
        throw new IllegalArgumentException( "IncludeRemovalProcessor missing required " +
                                            configKey + " configuration value" );
      }
      return Pattern.compile( input );
    }
  }
}
