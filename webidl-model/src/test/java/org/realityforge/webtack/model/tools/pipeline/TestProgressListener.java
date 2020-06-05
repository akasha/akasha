package org.realityforge.webtack.model.tools.pipeline;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.tools.pipeline.config.PipelineConfig;
import org.realityforge.webtack.model.tools.repository.config.SourceConfig;
import static org.testng.Assert.*;

final class TestProgressListener
  implements ProgressListener
{
  @Nonnull
  private final List<String> _trace = new ArrayList<>();

  @Override
  public void onSourcesFiltered( @Nonnull final PipelineConfig pipeline, @Nonnull final List<SourceConfig> sources )
  {
    _trace.add( "onSourcesFiltered(" + pipeline.getName() + "," +
                sources.stream().map( SourceConfig::getName ).collect( Collectors.toList() ) +
                ")" );
  }

  @Override
  public void onSourceParsed( @Nonnull final PipelineConfig pipeline,
                              @Nonnull final SourceConfig source,
                              @Nonnull final WebIDLSchema schema )
  {
    _trace.add( "onSourceParsed(" + pipeline.getName() + "," + source.getName() + ")" );
  }

  @Nonnull
  List<String> getTrace()
  {
    return _trace;
  }

  void assertContains( @Nonnull final String line )
  {
    assertTrue( _trace.contains( line ),
                "Expected trace to contain line:\n\n" + line +
                "\n\nbut trace consisted of:\n\n" + String.join( "\n", _trace ) + "\n" );
  }
}
