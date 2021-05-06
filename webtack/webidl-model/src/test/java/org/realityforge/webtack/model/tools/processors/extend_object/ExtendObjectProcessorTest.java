package org.realityforge.webtack.model.tools.processors.extend_object;

import javax.annotation.Nonnull;
import javax.json.Json;
import org.realityforge.webtack.model.tools.pipeline.ProgressListener;
import org.realityforge.webtack.model.tools.processors.AbstractProcessorTest;
import org.realityforge.webtack.model.tools.qa.TestProgressListener;
import org.realityforge.webtack.model.tools.spi.Processor;
import org.realityforge.webtack.model.tools.spi.Registry;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ExtendObjectProcessorTest
  extends AbstractProcessorTest
{
  @Test
  public void registry()
  {
    assertTrue( Registry.isProcessorPresent( "ExtendObject" ) );
    assertNotNull( createProcessor( new TestProgressListener() ) );
  }

  @Test
  public void basic()
    throws Exception
  {
    performStandardFixtureTest( "basic", () -> createProcessor( new TestProgressListener() ) );
  }

  @SuppressWarnings( "SameParameterValue" )
  @Nonnull
  private Processor createProcessor( @Nonnull final ProgressListener progressListener )
  {
    return Registry.createProcessor( newPipelineContext( progressListener ),
                                     "ExtendObject",
                                     Json.createObjectBuilder().build() );
  }
}
