package org.realityforge.webtack.model.tools.processors.merge_docs;

import java.nio.file.Path;
import javax.annotation.Nonnull;
import javax.json.Json;
import org.realityforge.webtack.model.tools.processors.AbstractProcessorTest;
import org.realityforge.webtack.model.tools.spi.Processor;
import org.realityforge.webtack.model.tools.spi.Registry;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class MergeDocsProcessorTest
  extends AbstractProcessorTest
{
  @Test
  public void registry()
  {
    assertTrue( Registry.isProcessorPresent( "MergeDocs" ) );
    assertNotNull( createProcessor( "basic" ) );
  }

  @Test
  public void basic()
    throws Exception
  {
    performStandardFixtureTest( "basic", () -> createProcessor( "basic" ) );
  }

  @SuppressWarnings( "SameParameterValue" )
  @Nonnull
  private Processor createProcessor( @Nonnull final String subDirectory )
  {
    return Registry.createProcessor( newPipelineContext( subDirectory ),
                                     "MergeDocs",
                                     Json
                                       .createObjectBuilder()
                                       .add( "createEvents", true )
                                       .build() );
  }
}
