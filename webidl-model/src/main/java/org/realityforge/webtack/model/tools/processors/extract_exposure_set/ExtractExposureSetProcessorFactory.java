package org.realityforge.webtack.model.tools.processors.extract_exposure_set;

import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.Name;
import org.realityforge.webtack.model.tools.spi.Processor;
import org.realityforge.webtack.model.tools.spi.ProcessorFactory;

@Name( "ExtractExposureSet" )
public final class ExtractExposureSetProcessorFactory
  implements ProcessorFactory
{
  public String globalInterface;

  @Nonnull
  @Override
  public Processor create()
  {
    if ( null == globalInterface )
    {
      throw new IllegalArgumentException(
        "ExposureSetExtractorProcessor missing required globalInterface configuration value" );
    }
    return new ExtractExposureSetProcessor( globalInterface );
  }
}
