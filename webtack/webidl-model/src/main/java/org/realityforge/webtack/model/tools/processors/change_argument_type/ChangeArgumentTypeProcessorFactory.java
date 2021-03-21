package org.realityforge.webtack.model.tools.processors.change_argument_type;

import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.processors.AbstractProcessorFactory;
import org.realityforge.webtack.model.tools.spi.Name;
import org.realityforge.webtack.model.tools.spi.PipelineContext;
import org.realityforge.webtack.model.tools.spi.Processor;

@Name( "ChangeArgumentType" )
public final class ChangeArgumentTypeProcessorFactory
  extends AbstractProcessorFactory
{
  public String elementNamePattern;
  public String operationNamePattern;
  public String argumentNamePattern;
  public String type;
  public int expectedChangeCount;

  @Nonnull
  @Override
  public Processor create( @Nonnull final PipelineContext context )
  {
    return new ChangeArgumentTypeProcessor( context,
                                            requirePattern( "elementNamePattern", elementNamePattern ),
                                            requirePattern( "operationNamePattern", operationNamePattern ),
                                            requirePattern( "argumentNamePattern", argumentNamePattern ),
                                            requireType( "type", type ),
                                            expectedChangeCount );
  }
}
