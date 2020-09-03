package org.realityforge.webtack.model.tools.processors.merge_docs;

import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.processors.AbstractProcessorFactory;
import org.realityforge.webtack.model.tools.spi.Name;
import org.realityforge.webtack.model.tools.spi.PipelineContext;
import org.realityforge.webtack.model.tools.spi.Processor;

@Name( "MergeDocs" )
public final class MergeDocsProcessorFactory
  extends AbstractProcessorFactory
{
  public boolean createEvents;

  @Nonnull
  @Override
  public Processor create( @Nonnull final PipelineContext context )
  {
    return new MergeDocsProcessor( context.docRepository(), createEvents );
  }
}
