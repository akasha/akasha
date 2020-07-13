package org.realityforge.webtack.model.tools.processors.flatten;

import java.io.IOException;
import java.nio.file.Files;
import javax.annotation.Nonnull;
import javax.json.Json;
import org.realityforge.webtack.model.AbstractTest;
import org.realityforge.webtack.model.tools.spi.Processor;
import org.realityforge.webtack.model.tools.spi.Registry;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class FlattenProcessorTest
  extends AbstractTest
{
  @Test
  public void registry()
  {
    assertTrue( Registry.isProcessorPresent( "Flatten" ) );
    assertNotNull( createProcessor() );
  }

  @DataProvider( name = "fixtureTests" )
  public Object[][] fixtureTests()
    throws IOException
  {
    return Files.list( getTestLocalFixtureDir() )
      .filter( Files::isDirectory )
      .filter( d -> Files.exists( d.resolve( "input.webidl" ) ) && Files.exists( d.resolve( "output.webidl" ) ) )
      .map( d -> new Object[]{ d.getFileName().toString() } )
      .toArray( Object[][]::new );
  }

  @Test( dataProvider = "fixtureTests" )
  public void fixtureTest( @Nonnull final String subDirectory )
    throws Exception
  {
    performFlattenFixtureTest( subDirectory );
  }

  private void performFlattenFixtureTest( @Nonnull final String subDirectory )
    throws Exception
  {
    performFixtureTest( getClass().getSimpleName() + " " + subDirectory,
                        this::createProcessor,
                        getTestLocalFixtureDir().resolve( subDirectory ),
                        "input",
                        "output" );
  }

  @Nonnull
  private Processor createProcessor()
  {
    return Registry.createProcessor( "Flatten", Json.createObjectBuilder().build() );
  }
}
