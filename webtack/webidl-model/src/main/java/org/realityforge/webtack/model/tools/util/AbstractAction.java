package org.realityforge.webtack.model.tools.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
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
  @Nonnull
  private final Set<Path> _generatedFiles = new HashSet<>();

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

  @Nonnull
  public Set<Path> getGeneratedFiles()
  {
    return _generatedFiles;
  }

  protected final void recordGeneratedFile( @Nonnull final Path file )
  {
    assert !_generatedFiles.contains( file );
    _generatedFiles.add( file );
  }

  protected void processInit( @Nonnull final WebIDLSchema schema )
  {
    _generatedFiles.clear();
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

  protected final void writeFile( @Nonnull final Path path, @Nonnull final byte[] content )
    throws IOException
  {
    recordGeneratedFile( path );
    Files.createDirectories( path.getParent() );
    Files.write( path, content, StandardOpenOption.CREATE_NEW );
  }
}
