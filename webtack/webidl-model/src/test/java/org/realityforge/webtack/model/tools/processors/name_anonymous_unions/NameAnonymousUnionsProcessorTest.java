package org.realityforge.webtack.model.tools.processors.name_anonymous_unions;

import javax.annotation.Nonnull;
import javax.json.Json;
import org.realityforge.webtack.model.tools.processors.AbstractProcessorTest;
import org.realityforge.webtack.model.tools.spi.Processor;
import org.realityforge.webtack.model.tools.spi.Registry;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class NameAnonymousUnionsProcessorTest
  extends AbstractProcessorTest
{
  @Test
  public void registry()
  {
    assertTrue( Registry.isProcessorPresent( "NameAnonymousUnions" ) );
    assertNotNull( createProcessor() );
  }

  @Test
  public void basic()
    throws Exception
  {
    performStandardFixtureTest( "basic", this::createProcessor );
  }

  @Nonnull
  private Processor createProcessor()
  {
    return Registry.createProcessor( newPipelineContext(), "NameAnonymousUnions", Json.createObjectBuilder().build() );
  }
}
