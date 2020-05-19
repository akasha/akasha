package org.realityforge.webtack.model.tools.pipeline.config;

import javax.annotation.Nullable;
import javax.json.JsonObject;

public final class StageConfig
{
  private String name;
  @Nullable
  private String sourceSelector;
  @Nullable
  private JsonObject config;

  public String getName()
  {
    return name;
  }

  public void setName( final String name )
  {
    this.name = name;
  }

  @Nullable
  public String getSourceSelector()
  {
    return sourceSelector;
  }

  public void setSourceSelector( @Nullable final String sourceSelector )
  {
    this.sourceSelector = sourceSelector;
  }

  @Nullable
  public JsonObject getConfig()
  {
    return config;
  }

  public void setConfig( @Nullable final JsonObject config )
  {
    this.config = config;
  }

  void validate()
  {
    if ( null == name )
    {
      throw new IllegalPipelineConfigException( "Invalid stage detected that specifies no name" );
    }
  }
}
