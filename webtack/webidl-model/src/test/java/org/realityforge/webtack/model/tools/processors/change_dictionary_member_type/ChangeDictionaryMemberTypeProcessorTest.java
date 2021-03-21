package org.realityforge.webtack.model.tools.processors.change_dictionary_member_type;

import javax.annotation.Nonnull;
import javax.json.Json;
import org.realityforge.webtack.model.tools.pipeline.ProgressListener;
import org.realityforge.webtack.model.tools.processors.AbstractProcessorTest;
import org.realityforge.webtack.model.tools.qa.TestProgressListener;
import org.realityforge.webtack.model.tools.spi.Processor;
import org.realityforge.webtack.model.tools.spi.Registry;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class ChangeDictionaryMemberTypeProcessorTest
  extends AbstractProcessorTest
{
  @Test
  public void registry()
  {
    assertTrue( Registry.isProcessorPresent( "ChangeDictionaryMemberType" ) );
  }

  @Test
  public void basic()
    throws Exception
  {
    performStandardFixtureTest( "basic",
                                () -> createProcessor( new TestProgressListener(),
                                                       "^PostMessageOptions$",
                                                       "^transfer$",
                                                       "sequence<Transferable>",
                                                       1 ) );
  }
  @Test
  public void basicBad_expectedAddCount()
    throws Exception
  {
    final TestProgressListener progressListener = new TestProgressListener();
    performStandardFixtureTest( "basic",
                                () -> createProcessor( progressListener,
                                                       "^PostMessageOptions$",
                                                       "^transfer$",
                                                       "sequence<Transferable>",
                                                       2000 ) );
    progressListener.assertContains(
      "stageError(MyPipeline,MyStage): ERROR: Changed 1 members but expected to change 2000 members." );
  }

  @SuppressWarnings( "SameParameterValue" )
  @Nonnull
  private Processor createProcessor( @Nonnull final ProgressListener progressListener,
                                     @Nonnull final String dictionaryNamePattern,
                                     @Nonnull final String dictionaryMemberNamePattern,
                                     @Nonnull final String type,
                                     final int expectedChangeCount )
  {
    return Registry.createProcessor( newPipelineContext( progressListener ),
                                     "ChangeDictionaryMemberType",
                                     Json
                                       .createObjectBuilder()
                                       .add( "expectedChangeCount", expectedChangeCount )
                                       .add( "dictionaryNamePattern", dictionaryNamePattern )
                                       .add( "dictionaryMemberNamePattern", dictionaryMemberNamePattern )
                                       .add( "type", type )
                                       .build() );
  }
}
