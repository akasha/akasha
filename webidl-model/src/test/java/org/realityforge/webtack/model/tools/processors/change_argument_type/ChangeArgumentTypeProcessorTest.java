package org.realityforge.webtack.model.tools.processors.change_argument_type;

import javax.annotation.Nonnull;
import javax.json.Json;
import org.realityforge.webtack.model.tools.pipeline.ProgressListener;
import org.realityforge.webtack.model.tools.pipeline.TestProgressListener;
import org.realityforge.webtack.model.tools.processors.AbstractProcessorTest;
import org.realityforge.webtack.model.tools.spi.Processor;
import org.realityforge.webtack.model.tools.spi.Registry;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class ChangeArgumentTypeProcessorTest
  extends AbstractProcessorTest
{
  @Test
  public void registry()
  {
    assertTrue( Registry.isProcessorPresent( "ChangeArgumentType" ) );
  }

  @Test
  public void basic()
    throws Exception
  {
    performStandardFixtureTest( "basic",
                                () -> createProcessor( new TestProgressListener(),
                                                       "^WebGL2RenderingContext$",
                                                       "^createShader$",
                                                       "^type$",
                                                       "ShaderType",
                                                       1 ) );
  }

  @Test
  public void basicBad_expectedAddCount()
    throws Exception
  {
    final TestProgressListener progressListener = new TestProgressListener();
    performStandardFixtureTest( "basic",
                                () -> createProcessor( progressListener,
                                                       "^WebGL2RenderingContext$",
                                                       "^createShader$",
                                                       "^type$",
                                                       "ShaderType",
                                                       2000 ) );
    progressListener.assertContains( "stageError(MyPipeline,MyStage): ERROR: Changed 1 arguments but expected to change 2000 arguments." );
  }

  @SuppressWarnings( "SameParameterValue" )
  @Nonnull
  private Processor createProcessor( @Nonnull final ProgressListener progressListener,
                                     @Nonnull final String elementNamePattern,
                                     @Nonnull final String operationNamePattern,
                                     @Nonnull final String argumentNamePattern,
                                     @Nonnull final String type,
                                     final int expectedChangeCount )
  {
    return Registry.createProcessor( newPipelineContext( progressListener ),
                                     "ChangeArgumentType",
                                     Json
                                       .createObjectBuilder()
                                       .add( "expectedChangeCount", expectedChangeCount )
                                       .add( "elementNamePattern", elementNamePattern )
                                       .add( "operationNamePattern", operationNamePattern )
                                       .add( "argumentNamePattern", argumentNamePattern )
                                       .add( "type", type )
                                       .build() );
  }
}