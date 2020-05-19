package org.realityforge.webtack.model.tools.pipeline.config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.annotation.JsonbTransient;

public final class PipelineConfig
{
  private String name;
  @Nullable
  private String sourceSelector;
  private List<StageConfig> stages;

  @JsonbTransient
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

  public List<StageConfig> getStages()
  {
    return stages;
  }

  public void setStages( final List<StageConfig> stages )
  {
    this.stages = stages;
  }

  @Nonnull
  public static PipelineConfig load( @Nonnull final Path path )
    throws Exception
  {
    try ( final InputStream inputStream = new FileInputStream( path.toFile() ) )
    {
      final PipelineConfig pipeline = JsonbBuilder.create().fromJson( inputStream, PipelineConfig.class );
      if ( null == pipeline.getName() )
      {
        final String name = path.getName( path.getNameCount() - 1 ).toString().replaceAll( "\\.json$", "" );
        pipeline.setName( name );
      }
      pipeline.validate();
      return pipeline;
    }
  }

  void validate()
  {
    if ( null == stages )
    {
      throw new IllegalPipelineConfigException( "Invalid pipeline named '" + name + "' specifies no stages" );
    }
    stages.forEach( StageConfig::validate );
  }
}
