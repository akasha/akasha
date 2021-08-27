package org.realityforge.webtack.model.tools.processors.js_symbol_dedup;

import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.processors.AbstractProcessorFactory;
import org.realityforge.webtack.model.tools.spi.Name;
import org.realityforge.webtack.model.tools.spi.PipelineContext;
import org.realityforge.webtack.model.tools.spi.Processor;

@Name( "JsSymbolDedup" )
public final class JsSymbolDedupProcessorFactory
  extends AbstractProcessorFactory
{
  @Nonnull
  @Override
  public Processor create( @Nonnull final PipelineContext context )
  {
    return new JsSymbolDedupProcessor( context );
  }
}
