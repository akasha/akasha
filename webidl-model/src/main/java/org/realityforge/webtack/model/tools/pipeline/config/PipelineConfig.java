package org.realityforge.webtack.model.tools.pipeline.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
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
  private List<String> pre;
  private List<String> post;
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

  public List<String> getPre()
  {
    return pre;
  }

  public void setPre( final List<String> pre )
  {
    this.pre = pre;
  }

  public List<String> getPost()
  {
    return post;
  }

  public void setPost( final List<String> post )
  {
    this.post = post;
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
  public static PipelineConfig load( @Nonnull final String name, @Nonnull final Path directory )
    throws Exception
  {
    final PipelineConfig config = loadSingle( name, directory.resolve( name + ".json" ) );

    final List<String> prePipelines = config.getPre();
    if ( null != prePipelines )
    {
      final ArrayList<String> pipelines = new ArrayList<>( prePipelines );
      Collections.reverse( pipelines );
      for ( final String prePipeline : pipelines )
      {
        final PipelineConfig pipeline = load( prePipeline, directory );
        if ( null == config.getSourceSelector() )
        {
          config.setSourceSelector( pipeline.getSourceSelector() );
        }
        final List<StageConfig> stages = pipeline.getStages();
        if ( null != stages )
        {
          final List<StageConfig> existing = config.getStages();
          if ( null == existing )
          {
            config.setStages( new ArrayList<>( stages ) );
          }
          else
          {
            existing.addAll( 0, stages );
          }
        }
      }
    }

    final List<String> postPipelines = config.getPost();
    if ( null != postPipelines )
    {
      for ( final String postPipeline : postPipelines )
      {
        final PipelineConfig pipeline = load( postPipeline, directory );
        if ( null != pipeline.getSourceSelector() )
        {
          config.setSourceSelector( pipeline.getSourceSelector() );
        }
        final List<StageConfig> stages = pipeline.getStages();
        if ( null != stages )
        {
          final List<StageConfig> existing = config.getStages();
          if ( null == existing )
          {
            config.setStages( new ArrayList<>( stages ) );
          }
          else
          {
            existing.addAll( stages );
          }
        }
      }
    }

    return config;
  }

  @Nonnull
  private static PipelineConfig loadSingle( @Nonnull final String name, @Nonnull final Path path )
    throws Exception
  {
    if ( !Files.exists( path ) )
    {
      throw new FileNotFoundException( "Unable to locate pipeline named '" + name + "' at " + path );
    }

    try ( final InputStream inputStream = new FileInputStream( path.toFile() ) )
    {
      final PipelineConfig pipeline = JsonbBuilder.create().fromJson( inputStream, PipelineConfig.class );
      pipeline.setName( name );
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
