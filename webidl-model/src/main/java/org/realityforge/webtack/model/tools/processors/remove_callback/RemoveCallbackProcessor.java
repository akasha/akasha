package org.realityforge.webtack.model.tools.processors.remove_callback;

import java.util.Objects;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.CallbackDefinition;
import org.realityforge.webtack.model.tools.processors.AbstractProcessor;

final class RemoveCallbackProcessor
  extends AbstractProcessor
{
  @Nonnull
  private final Pattern _namePattern;

  RemoveCallbackProcessor( @Nonnull final Pattern namePattern )
  {
    _namePattern = Objects.requireNonNull( namePattern );
  }

  @Nullable
  @Override
  protected CallbackDefinition transformCallback( @Nonnull final CallbackDefinition input )
  {
    return matches( input ) ? null : super.transformCallback( input );
  }

  private boolean matches( @Nonnull final CallbackDefinition input )
  {
    return _namePattern.matcher( input.getName() ).matches();
  }
}
