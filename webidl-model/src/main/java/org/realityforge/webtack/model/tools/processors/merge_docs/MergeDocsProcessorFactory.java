package org.realityforge.webtack.model.tools.processors.merge_docs;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.mdn_scanner.DocRepositoryRuntime;
import org.realityforge.webtack.model.tools.mdn_scanner.config.DocRepositoryConfig;
import org.realityforge.webtack.model.tools.processors.AbstractProcessorFactory;
import org.realityforge.webtack.model.tools.spi.Name;
import org.realityforge.webtack.model.tools.spi.Processor;

@Name( "MergeDocs" )
public final class MergeDocsProcessorFactory
  extends AbstractProcessorFactory
{
  public String docsRepositoryConfigFile;

  @Nonnull
  @Override
  public Processor create()
  {
    final String filename = requireNonNull( "docsRepositoryConfigFile", docsRepositoryConfigFile );
    final Path path = Paths.get( "." ).resolve( filename );
    if ( !Files.exists( path ) )
    {
      throw new IllegalArgumentException( getProcessorName() + " supplied docsRepositoryConfigFile configuration " +
                                          "value " + docsRepositoryConfigFile + " but no such file exists at " + path );
    }
    final DocRepositoryRuntime runtime =
      new DocRepositoryRuntime( loadDocRepositoryConfig( path ), path.getParent().resolve( "docs" ) );
    return new MergeDocsProcessor( runtime );
  }

  @Nonnull
  private DocRepositoryConfig loadDocRepositoryConfig( @Nonnull final Path path )
  {
    try
    {
      return DocRepositoryConfig.load( path );
    }
    catch ( final Exception e )
    {
      throw new IllegalArgumentException( getProcessorName() + " failed to load doc repository from " + path, e );
    }
  }
}
