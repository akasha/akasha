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
  public boolean createEvents;

  @Nonnull
  @Override
  public Processor create()
  {
    return new MergeDocsProcessor( requireDocRepository( "docsRepositoryConfigFile", docsRepositoryConfigFile ),
                                   createEvents );
  }
}
