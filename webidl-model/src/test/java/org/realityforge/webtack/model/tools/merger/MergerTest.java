package org.realityforge.webtack.model.tools.merger;

import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.AbstractTest;
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
      if ( Files.isRegularFile( file ) &&
           localName.startsWith( "input" ) &&
           localName.endsWith( WebIDLSchema.EXTENSION ) )
      {
        inputs.add( file );
      }
    }
    Collections.sort( inputs );
    final String testDescription = "MergeTool fixture test. Inputs=" + inputs;

    final WebIDLSchema[] schemas =
      inputs.stream()
        .map( input -> loadWebIDLSchema( input,
                                         Collections.singleton( "name=" + input.getFileName().toString() ),
                                         testDescription ) )
        .toArray( WebIDLSchema[]::new );

    final WebIDLSchema output = new MergeCombiner().combine( schemas );

    assertEquals( output.getTags().size(), inputs.size() );
    for ( final Path input : inputs )
    {
      final String expected = "name=" + input.getFileName().toString();
      assertTrue( output.getTags().contains( expected ),
                  "Actual tags=" + output.getTags() + " " +
                  "Desired tag=" + expected );
    }

    final Path outputFile = dir.resolve( "output" + WebIDLSchema.EXTENSION );
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
}
