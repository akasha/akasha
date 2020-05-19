package org.realityforge.webtack.model.tools.pipeline.config;

import javax.annotation.Nullable;

public class IllegalPipelineConfigException
  extends RuntimeException
{
  public IllegalPipelineConfigException( @Nullable final String message )
  {
    super( message );
  }
}
