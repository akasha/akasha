package org.realityforge.webtack.model.tools.validator;

import java.util.Collection;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.WebIDLSchema;

/**
 * Interface implemented by the tools that perform schema validation.
 */
public interface Validator
{
  @Nonnull
  Collection<ValidationError> validate( @Nonnull WebIDLSchema schema );
}
