package org.realityforge.webtack.model.tools.processors.extract_exposure_set;

import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.processors.AbstractProcessorFactory;
import org.realityforge.webtack.model.tools.spi.Name;
import org.realityforge.webtack.model.tools.spi.Processor;

@Name( "ExtractExposureSet" )
public final class ExtractExposureSetProcessorFactory
  extends AbstractProcessorFactory
{
  public String globalInterface;

  @Nonnull
  @Override
  public Processor create()
  {
    return new ExtractExposureSetProcessor( requireNonNull( "globalInterface", globalInterface ) );
  }
}
