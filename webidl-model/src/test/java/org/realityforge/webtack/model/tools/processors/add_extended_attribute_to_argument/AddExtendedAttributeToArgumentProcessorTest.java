package org.realityforge.webtack.model.tools.processors.add_extended_attribute_to_argument;

import javax.annotation.Nonnull;
import javax.json.Json;
import org.realityforge.webtack.model.tools.pipeline.ProgressListener;
import org.realityforge.webtack.model.tools.pipeline.TestProgressListener;
import org.realityforge.webtack.model.tools.processors.AbstractProcessorTest;
import org.realityforge.webtack.model.tools.spi.Processor;
import org.realityforge.webtack.model.tools.spi.Registry;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class AddExtendedAttributeToArgumentProcessorTest
  extends AbstractProcessorTest
{
  @Test
  public void registry()
  {
    assertTrue( Registry.isProcessorPresent( "AddExtendedAttributeToArgument" ) );
  }

  @Test
  public void basic()
    throws Exception
  {
    performStandardFixtureTest( "basic",
                                () -> createProcessor( new TestProgressListener(),
                                                       "^(ImageBitmap|MessagePort|DedicatedWorkerGlobalScope)$",
                                                       "^postMessage$",
                                                       "^transfer$",
                                                       "Transferables",
                                                       2 ) );
  }

  @Test
  public void basicBad_expectedAddCount()
    throws Exception
  {
    final TestProgressListener progressListener = new TestProgressListener();
    performStandardFixtureTest( "basic",
                                () -> createProcessor( progressListener,
                                                       "^(ImageBitmap|MessagePort|DedicatedWorkerGlobalScope)$",
                                                       "^postMessage$",
                                                       "^transfer$",
                                                       "Transferables",
                                                       2000 ) );
    progressListener.assertContains( "stageError(MyPipeline,MyStage): ERROR: Added 2 extended attributes but expected to add 2000 extended attributes." );
  }

  @SuppressWarnings( "SameParameterValue" )
  @Nonnull
  private Processor createProcessor( @Nonnull final ProgressListener progressListener,
                                     @Nonnull final String elementNamePattern,
                                     @Nonnull final String operationNamePattern,
                                     @Nonnull final String argumentNamePattern,
                                     @Nonnull final String extendedAttribute,
                                     final int expectedAddCount )
  {
    return Registry.createProcessor( newPipelineContext( progressListener ),
                                     "AddExtendedAttributeToArgument",
                                     Json
                                       .createObjectBuilder()
                                       .add( "expectedAddCount", expectedAddCount )
                                       .add( "elementNamePattern", elementNamePattern )
                                       .add( "operationNamePattern", operationNamePattern )
                                       .add( "argumentNamePattern", argumentNamePattern )
                                       .add( "extendedAttribute", extendedAttribute ).build() );
  }
}
