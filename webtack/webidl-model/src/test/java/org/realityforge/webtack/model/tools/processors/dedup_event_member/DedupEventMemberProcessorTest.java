package org.realityforge.webtack.model.tools.processors.dedup_event_member;

import javax.annotation.Nonnull;
import javax.json.Json;
import org.realityforge.webtack.model.tools.processors.AbstractProcessorTest;
import org.realityforge.webtack.model.tools.spi.Processor;
import org.realityforge.webtack.model.tools.spi.Registry;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class DedupEventMemberProcessorTest
  extends AbstractProcessorTest
{
  @Test
  public void registry()
  {
    assertTrue( Registry.isProcessorPresent( "DedupEventMember" ) );
    assertNotNull( createProcessor() );
  }

  @Test
  public void duplicate_event_in_inheritance()
    throws Exception
  {
    performStandardFixtureTest( "duplicate_event_in_inheritance", this::createProcessor );
  }

  @Nonnull
  private Processor createProcessor()
  {
    return Registry.createProcessor( newPipelineContext(),
                                     "DedupEventMember",
                                     Json.createObjectBuilder().build() );
  }
}
