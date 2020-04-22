package org.realityforge.webtack.model.tools.merger;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.AbstractTest;
import org.realityforge.webtack.model.WebIDLModelParser;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.WebIDLWriter;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class MergerTest
  extends AbstractTest
{
  @Test
  public void fixtureTests()
    throws Exception
  {
    final Path fixtureDir = getTestLocalFixtureDir();
    for ( final Path path : Files.newDirectoryStream( fixtureDir ) )
    {
      if ( Files.isDirectory( path ) )
      {
        performFixtureTest( path );
      }
    }
  }

  private void performFixtureTest( @Nonnull final Path dir )
    throws Exception
  {
    final List<Path> inputs = new ArrayList<>();
    for ( final Path file : Files.newDirectoryStream( dir ) )
    {
      final String localName = file.getName( file.getNameCount() - 1 ).toString();
      if ( Files.isRegularFile( file ) && localName.startsWith( "input" ) && localName.endsWith( ".webidl" ) )
      {
        inputs.add( file );
      }
    }
    Collections.sort( inputs );
    final String testDescription = "MergeTool fixture test. Inputs=" + inputs;

    final WebIDLSchema[] schemas =
      inputs.stream().map( input -> loadWebIDLSchema( input, testDescription ) ).toArray( WebIDLSchema[]::new );

    final WebIDLSchema output = new MergerTool().merge( schemas );

    final Path outputFile = dir.resolve( "output.webidl" );
    if ( writeOutputFixtures() )
    {
      try ( final Writer writer = new FileWriter( outputFile.toFile() ) )
      {
        WebIDLWriter.writeSchema( writer, output );
      }
    }
    assertTrue( Files.exists( outputFile ), "Expected output file missing for " + testDescription );
    final WebIDLSchema expected = loadWebIDLSchema( outputFile, testDescription );
    assertTrue( expected.equiv( output ),
                "Expected output file for " + testDescription + " does not match value emitted by merge operation" );
  }

  @Nonnull
  private WebIDLSchema loadWebIDLSchema( @Nonnull final Path file, @Nonnull final String testDescription )
  {
    final String filename = file.toString();
    try ( final Reader reader = new FileReader( file.toFile() ) )
    {
      return WebIDLModelParser.parse( filename, reader, new BailErrorListener( filename ) );
    }
    catch ( final IOException ioe )
    {
      throw new AssertionError( "Error reading file " + filename + " for " + testDescription );
    }
  }

  @Nonnull
  private Path getTestLocalFixtureDir()
  {
    return getBaseFixtureDir().resolve( getClass().getName().replaceAll( "\\.", File.separator ) );
  }

  private boolean writeOutputFixtures()
  {
    return "true".equals( System.getProperty( "webtack.output_fixture_data" ) );
  }

  @Nonnull
  private Path getBaseFixtureDir()
  {
    final String key = "webtack.fixture_dir";
    final String fixtureDir = System.getProperty( key );
    assertNotNull( fixtureDir, "Expected System.getProperty( \"" + key + "\" ) to return fixture directory" );
    return new File( fixtureDir ).toPath();
  }
}
