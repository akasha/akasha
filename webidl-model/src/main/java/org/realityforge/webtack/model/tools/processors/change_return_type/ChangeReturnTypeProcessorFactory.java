package org.realityforge.webtack.model.tools.processors.change_return_type;

import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.processors.AbstractProcessorFactory;
import org.realityforge.webtack.model.tools.spi.Name;
import org.realityforge.webtack.model.tools.spi.PipelineContext;
import org.realityforge.webtack.model.tools.spi.Processor;

@Name( "ChangeReturnType" )
public final class ChangeReturnTypeProcessorFactory
  extends AbstractProcessorFactory
{
  public String elementNamePattern;
  public String operationNamePattern;
  public String type;
  public int expectedChangeCount;

  @Nonnull
  @Override
  public Processor create( @Nonnull final PipelineContext context )
  {
    return new ChangeReturnTypeProcessor( context,
                                          requirePattern( "elementNamePattern", elementNamePattern ),
                                          requirePattern( "operationNamePattern", operationNamePattern ),
                                          requireType( "type", type ),
                                          expectedChangeCount );
  }
}
