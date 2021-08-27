package org.realityforge.webtack.model.tools.processors.js_symbol_dedup;

import javax.annotation.Nonnull;
import javax.json.Json;
import org.realityforge.webtack.model.tools.processors.AbstractProcessorTest;
import org.realityforge.webtack.model.tools.spi.Processor;
import org.realityforge.webtack.model.tools.spi.Registry;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class JsSymbolDedupProcessorTest
  extends AbstractProcessorTest
{
  @Test
  public void registry()
  {
    assertTrue( Registry.isProcessorPresent( "JsSymbolDedup" ) );
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
    return Registry.createProcessor( newPipelineContext(), "JsSymbolDedup", Json.createObjectBuilder().build() );
  }
}
