package org.realityforge.webtack.model.tools.util;

import java.nio.file.Path;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.DocumentationElement;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.tools.mdn_scanner.DocEntry;
import org.realityforge.webtack.model.tools.mdn_scanner.config2.DocEntryUtil;
import org.realityforge.webtack.model.tools.spi.Action;
import org.realityforge.webtack.model.tools.spi.PipelineContext;

public abstract class AbstractAction
  implements Action
{
  @Nonnull
  private final PipelineContext _context;
  @Nonnull
  private final Path _outputDirectory;
  /**
   * Value cached during processing
   */
  @Nullable
  private WebIDLSchema _schema;

  protected AbstractAction( @Nonnull final PipelineContext context, @Nonnull final Path outputDirectory )
  {
    _context = Objects.requireNonNull( context );
    _outputDirectory = Objects.requireNonNull( outputDirectory );
  }

  @Nonnull
  protected final PipelineContext context()
  {
    return _context;
  }

  @Nonnull
  protected final WebIDLSchema getSchema()
  {
    assert null != _schema;
    return _schema;
  }

  protected void processInit( @Nonnull final WebIDLSchema schema )
  {
    _schema = Objects.requireNonNull( schema );
    schema.link();
  }

  @Nonnull
  protected final Path getOutputDirectory()
  {
    return _outputDirectory;
  }

  @Nullable
  protected final DocumentationElement getDocumentationElement( @Nonnull final String type,
                                                                @Nullable final String member )
  {
    final DocEntry docEntry = context().docRepository().findDocEntry( type, member );
    return null != docEntry ? DocEntryUtil.createDocumentationElement( docEntry ) : null;
  }
}
