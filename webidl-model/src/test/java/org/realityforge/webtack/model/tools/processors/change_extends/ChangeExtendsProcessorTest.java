package org.realityforge.webtack.model.tools.processors.change_extends;

import javax.annotation.Nonnull;
import javax.json.Json;
import org.realityforge.webtack.model.tools.pipeline.ProgressListener;
import org.realityforge.webtack.model.tools.pipeline.TestProgressListener;
import org.realityforge.webtack.model.tools.processors.AbstractProcessorTest;
import org.realityforge.webtack.model.tools.spi.Processor;
import org.realityforge.webtack.model.tools.spi.Registry;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class ChangeExtendsProcessorTest
  extends AbstractProcessorTest
{
  @Test
  public void registry()
  {
    assertTrue( Registry.isProcessorPresent( "ChangeExtends" ) );
  }

  @Test
  public void basic()
    throws Exception
  {
    performStandardFixtureTest( "basic",
                                () -> createProcessor( new TestProgressListener(),
                                                       "^DOMException$",
                                                       "Error",
                                                       1 ) );
  }

  @Test
  public void basicBad_expectedAddCount()
    throws Exception
  {
    final TestProgressListener progressListener = new TestProgressListener();
    performStandardFixtureTest( "basic",
                                () -> createProcessor( progressListener,
                                                       "^DOMException$",
                                                       "Error",
                                                       2000 ) );
    progressListener.assertContains(
      "stageError(MyPipeline,MyStage): ERROR: Changed 1 extends but expected to change 2000 extends." );
  }

  @SuppressWarnings( "SameParameterValue" )
  @Nonnull
  private Processor createProcessor( @Nonnull final ProgressListener progressListener,
                                     @Nonnull final String elementNamePattern,
                                     @Nonnull final String parentType,
                                     final int expectedChangeCount )
  {
    return Registry.createProcessor( newPipelineContext( progressListener ),
                                     "ChangeExtends",
                                     Json
                                       .createObjectBuilder()
                                       .add( "expectedChangeCount", expectedChangeCount )
                                       .add( "elementNamePattern", elementNamePattern )
                                       .add( "parentType", parentType )
                                       .build() );
  }
}
