package org.realityforge.webtack.model.tools.processors.synthesize_transferable;

import javax.annotation.Nonnull;
import javax.json.Json;
import org.realityforge.webtack.model.tools.pipeline.ProgressListener;
import org.realityforge.webtack.model.tools.processors.AbstractProcessorTest;
import org.realityforge.webtack.model.tools.qa.TestProgressListener;
import org.realityforge.webtack.model.tools.spi.Processor;
import org.realityforge.webtack.model.tools.spi.Registry;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class SynthesizeTransferableProcessorTest
  extends AbstractProcessorTest
{
  @Test
  public void registry()
  {
    assertTrue( Registry.isProcessorPresent( "SynthesizeTransferable" ) );
    assertNotNull( createProcessor( 1 ) );
  }

  @Test
  public void basic()
    throws Exception
  {
    performStandardFixtureTest( "basic", () -> createProcessor( 5 ) );
  }

  @Test
  public void basicBad_expectedTransferableCount()
    throws Exception
  {
    final TestProgressListener progressListener = new TestProgressListener();
    performStandardFixtureTest( "basic", () -> createProcessor( progressListener, 2000 ) );
    progressListener.assertContains(
      "stageError(MyPipeline,MyStage): ERROR: Detected 5 [Transferable] interfaces but expected 2000 interfaces." );
  }

  @Nonnull
  private Processor createProcessor( final int expectedTransferableCount )
  {
    return createProcessor( new TestProgressListener(), expectedTransferableCount );
  }

  @Nonnull
  private Processor createProcessor( @Nonnull final ProgressListener progressListener,
                                     final int expectedTransferableCount )
  {
    return Registry.createProcessor( newPipelineContext( progressListener ),
                                     "SynthesizeTransferable",
                                     Json.createObjectBuilder()
                                       .add( "expectedTransferableCount", expectedTransferableCount )
                                       .build() );
  }
}
