package org.realityforge.webtack.model.tools.processors.merge_docs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
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
  public Map<String, ArrayList<String>> aliases;

  @Nonnull
  @Override
  public Processor create( @Nonnull final PipelineContext context )
  {
    return new MergeDocsProcessor( context.docRepository(),
                                   createEvents,
                                   null == aliases ? Collections.emptyMap() : aliases );
  }
}
