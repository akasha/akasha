package org.realityforge.webtack.model.tools.processors.add_no_side_effects_extended_attribute;

import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.processors.AbstractProcessorFactory;
import org.realityforge.webtack.model.tools.spi.Name;
import org.realityforge.webtack.model.tools.spi.PipelineContext;
import org.realityforge.webtack.model.tools.spi.Processor;

@Name( "AddNoSideEffectsExtendedAttribute" )
public final class AddNoSideEffectsExtendedAttributeProcessorFactory
  extends AbstractProcessorFactory
{
  public String file;

  @Nonnull
  @Override
  public Processor create( @Nonnull final PipelineContext context )
  {
    return new AddNoSideEffectsExtendedAttributeProcessor( context, requirePath( "file", file, Boolean.TRUE ) );
  }
}
