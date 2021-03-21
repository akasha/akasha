package org.realityforge.webtack.model.tools.processors.change_attribute_type;

import javax.annotation.Nonnull;
import javax.json.Json;
import org.realityforge.webtack.model.tools.pipeline.ProgressListener;
import org.realityforge.webtack.model.tools.processors.AbstractProcessorTest;
import org.realityforge.webtack.model.tools.qa.TestProgressListener;
import org.realityforge.webtack.model.tools.spi.Processor;
import org.realityforge.webtack.model.tools.spi.Registry;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class ChangeAttributeTypeProcessorTest
  extends AbstractProcessorTest
{
  @Test
  public void registry()
  {
    assertTrue( Registry.isProcessorPresent( "ChangeAttributeType" ) );
  }

  @Test
  public void basic()
    throws Exception
  {
    performStandardFixtureTest( "basic",
                                () -> createProcessor( new TestProgressListener(),
                                                       "^WebGLActiveInfo$",
                                                       "^type$",
                                                       "ActiveInfoDataType",
                                                       1 ) );
  }
  @Test
  public void basicBad_expectedAddCount()
    throws Exception
  {
    final TestProgressListener progressListener = new TestProgressListener();
    performStandardFixtureTest( "basic",
                                () -> createProcessor( progressListener,
                                                       "^WebGLActiveInfo$",
                                                       "^type$",
                                                       "ActiveInfoDataType",
                                                       2000 ) );
    progressListener.assertContains(
      "stageError(MyPipeline,MyStage): ERROR: Changed 1 attributes but expected to change 2000 attributes." );
  }

  @SuppressWarnings( "SameParameterValue" )
  @Nonnull
  private Processor createProcessor( @Nonnull final ProgressListener progressListener,
                                     @Nonnull final String elementNamePattern,
                                     @Nonnull final String attributeNamePattern,
                                     @Nonnull final String type,
                                     final int expectedChangeCount )
  {
    return Registry.createProcessor( newPipelineContext( progressListener ),
                                     "ChangeAttributeType",
                                     Json
                                       .createObjectBuilder()
                                       .add( "expectedChangeCount", expectedChangeCount )
                                       .add( "elementNamePattern", elementNamePattern )
                                       .add( "attributeNamePattern", attributeNamePattern )
                                       .add( "type", type )
                                       .build() );
  }
}
