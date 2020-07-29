package org.realityforge.webtack.model.io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.AbstractTest;
import org.realityforge.webtack.model.WebIDLSchema;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class WebIDLReadWriteTest
  extends AbstractTest
{
  @DataProvider( name = "fixtureTests" )
  public Object[][] fixtureTests()
    throws IOException
  {
    return scanForStandardFixturesTestInput();
  }

  @Test( dataProvider = "fixtureTests" )
  public void fixtureTest( @Nonnull final String subDirectory )
    throws Exception
  {
    performStandardFixtureTest( subDirectory );
  }

  void performStandardFixtureTest( @Nonnull final String subDirectory )
    throws Exception
  {
    final String label = getClass().getSimpleName() + " " + subDirectory;
    final Path dir = getTestLocalFixtureDir().resolve( subDirectory );
    final String testDescription = label + " fixture test. Input=" + "input" + " Output=" + "output";

    final Path inputFile = dir.resolve( "input" + WebIDLSchema.EXTENSION );
    final Path outputFile = dir.resolve( "output" + WebIDLSchema.EXTENSION );

    final WebIDLSchema schema = loadWebIDLSchema( inputFile, testDescription );
    maybeWriteSchemaFixture( outputFile, schema );
    assertTrue( Files.exists( outputFile ), "Expected output file missing for " + testDescription );
    assertEquals( new String( Files.readAllBytes( inputFile ), StandardCharsets.UTF_8 ),
                  new String( Files.readAllBytes( outputFile ), StandardCharsets.UTF_8 ),
                  "Schema contents..." );
    final WebIDLSchema expected = loadWebIDLSchema( outputFile, testDescription );
    assertTrue( expected.equiv( schema ),
                "Expected output file for " + testDescription + " does not match value emitted by " + label );
  }
}
