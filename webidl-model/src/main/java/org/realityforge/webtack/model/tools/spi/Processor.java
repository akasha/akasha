package org.realityforge.webtack.model.tools.spi;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.WebIDLSchema;

/**
 * Consume a schema and emit a schema.
 * This interface is usually used to apply a transformation or validity checking the schema.
 */
public interface Processor
{
  /**
   * Process input schema and return output schema.
   *
   * @param schema the input schema.
   * @return the output schema.
   */
  @Nullable
  WebIDLSchema process( @Nonnull WebIDLSchema schema )
    throws Exception;
}
