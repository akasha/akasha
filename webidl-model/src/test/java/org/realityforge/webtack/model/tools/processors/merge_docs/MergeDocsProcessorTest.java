package org.realityforge.webtack.model.tools.processors.merge_docs;

import java.nio.file.Path;
import javax.annotation.Nonnull;
import javax.json.Json;
import org.realityforge.webtack.model.tools.mdn_scanner.config.DocRepositoryConfig;
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

  @Test
  public void badDocRepository()
  {
    final IllegalArgumentException exception =
      expectThrows( IllegalArgumentException.class,
                    () -> createProcessor( "broken" ) );
    assertTrue( exception.getMessage().startsWith( "MergeDocsProcessor failed to load doc repository from" ) );
  }

  @Test
  public void missingConfiguration()
  {
    final IllegalArgumentException exception =
      expectThrows( IllegalArgumentException.class,
                    () -> Registry.createProcessor( "MergeDocs", Json.createObjectBuilder().build() ) );
    assertEquals( exception.getMessage(),
                  "MergeDocsProcessor missing required docsRepositoryConfigFile configuration value" );
  }

  @SuppressWarnings( "SameParameterValue" )
  @Nonnull
  private Processor createProcessor( @Nonnull final String subDirectory )
  {
    final Path configFile = getTestLocalFixtureDir().resolve( subDirectory ).resolve( DocRepositoryConfig.FILENAME );
    return Registry.createProcessor( "MergeDocs",
                                     Json
                                       .createObjectBuilder()
                                       .add( "docsRepositoryConfigFile", configFile.toString() )
                                       .add( "createEvents", true )
                                       .build() );
  }
}
