package org.realityforge.webtack.model.tools.validator;

import java.util.Objects;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.Node;

/**
 * A entity representing a validation failure detected when validating a schema.
 * Typically a validation failure indicates that it is not possible to continue process and generate artifacts from the schema.
 */
public final class ValidationError
{
  @Nonnull
  private final Node _node;
  @Nonnull
  private final String _message;
  /**
   * Flag set to true if this error should stop latesr stages of validation from running.
   * Typically this set when there is significant structural problems with the schema so subsequent validation
   * errors will likely result from this unless it is fixed.
   */
  private final boolean _haltValidation;

  public ValidationError( @Nonnull final Node node, @Nonnull final String message, final boolean haltValidation )
  {
    _node = Objects.requireNonNull( node );
    _message = Objects.requireNonNull( message );
    _haltValidation = haltValidation;
  }

  @Nonnull
  public Node getNode()
  {
    return _node;
  }

  @Nonnull
  public String getMessage()
  {
    return _message;
  }

  public boolean shouldHaltValidation()
  {
    return _haltValidation;
  }
}
