package org.realityforge.webtack.model.tools.processors.rename_enumeration;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.EnumerationDefinition;
import org.realityforge.webtack.model.Kind;
import org.realityforge.webtack.model.Type;
import org.realityforge.webtack.model.TypeReference;
import org.realityforge.webtack.model.tools.processors.AbstractProcessor;

/**
 * Remove includes that match a pattern.
 */
final class RenameEnumerationProcessor
  extends AbstractProcessor
{
  @Nonnull
  private final Pattern _namePattern;
  @Nonnull
  private final String _replacement;

  RenameEnumerationProcessor( @Nonnull final Pattern namePattern, @Nonnull final String replacement )
  {
    _namePattern = Objects.requireNonNull( namePattern );
    _replacement = Objects.requireNonNull( replacement );
  }

  @Nonnull
  @Override
  protected Type transformType( @Nonnull final Type type )
  {
    if ( Kind.TypeReference == type.getKind() )
    {
      final TypeReference typeReference = (TypeReference) type;
      final Matcher matcher = _namePattern.matcher( typeReference.getName() );
      if ( matcher.matches() )
      {
        return new TypeReference( matcher.replaceAll( _replacement ),
                                  typeReference.getExtendedAttributes(),
                                  typeReference.isNullable(),
                                  typeReference.getSourceLocations() );
      }
    }
    return super.transformType( type );
  }

  @Nullable
  @Override
  protected EnumerationDefinition transformEnumeration( @Nonnull final EnumerationDefinition input )
  {
    final Matcher matcher = _namePattern.matcher( input.getName() );
    if ( matcher.matches() )
    {
      return new EnumerationDefinition( matcher.replaceAll( _replacement ),
                                        input.getValues(),
                                        transformExtendedAttributes( input.getExtendedAttributes() ),
                                        transformSourceLocations( input.getSourceLocations() ) );
    }
    else
    {
      return super.transformEnumeration( input );
    }
  }
}
