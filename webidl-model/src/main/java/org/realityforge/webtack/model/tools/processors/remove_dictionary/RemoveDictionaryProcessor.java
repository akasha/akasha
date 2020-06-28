package org.realityforge.webtack.model.tools.processors.remove_dictionary;

import java.util.Objects;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.DictionaryDefinition;
import org.realityforge.webtack.model.tools.processors.AbstractProcessor;

final class RemoveDictionaryProcessor
  extends AbstractProcessor
{
  @Nonnull
  private final Pattern _namePattern;

  RemoveDictionaryProcessor( @Nonnull final Pattern namePattern )
  {
    _namePattern = Objects.requireNonNull( namePattern );
  }

  @Nullable
  @Override
  protected DictionaryDefinition transformDictionary( @Nonnull final DictionaryDefinition input )
  {
    return matches( input ) ? null : super.transformDictionary( input );
  }

  private boolean matches( @Nonnull final DictionaryDefinition input )
  {
    return _namePattern.matcher( input.getName() ).matches();
  }
}
