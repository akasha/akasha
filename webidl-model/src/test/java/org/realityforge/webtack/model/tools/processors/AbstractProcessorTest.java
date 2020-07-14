package org.realityforge.webtack.model.tools.processors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Supplier;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.AbstractTest;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.tools.spi.Processor;
import static org.testng.Assert.*;

public abstract class AbstractProcessorTest
  extends AbstractTest
{
  @Nonnull
  protected final Object[][] scanForStandardFixturesTestInput()
    throws IOException
  {
    return Files.list( getTestLocalFixtureDir() )
      .filter( Files::isDirectory )
      .filter( d -> Files.exists( d.resolve( "input.webidl" ) ) && Files.exists( d.resolve( "output.webidl" ) ) )
      .map( d -> new Object[]{ d.getFileName().toString() } )
      .toArray( Object[][]::new );
  }

  protected final void performStandardFixtureTest( @Nonnull final String subDirectory,
                                                   @Nonnull final Supplier<Processor> processorSupplier )
    throws Exception
  {
    performFixtureTest( getClass().getSimpleName() + " " + subDirectory,
                        processorSupplier,
                        getTestLocalFixtureDir().resolve( subDirectory ),
                        "input",
                        "output" );
  }

  protected final void performFixtureTest( @Nonnull final String label,
                                           @Nonnull final Supplier<Processor> supplier,
                                           @Nonnull final Path dir,
                                           @Nonnull final String inputFilename,
                                           @Nonnull final String outputFilename )
    throws Exception
  {
    final String testDescription = label + " fixture test. Input=" + inputFilename + " Output=" + outputFilename;

    final WebIDLSchema input =
      loadWebIDLSchema( dir.resolve( inputFilename + WebIDLSchema.EXTENSION ), testDescription );
    final WebIDLSchema output = supplier.get().process( input );
    assertNotNull( output );

    final Path outputFile = dir.resolve( outputFilename + WebIDLSchema.EXTENSION );
    maybeWriteSchemaFixture( outputFile, output );
    assertTrue( Files.exists( outputFile ), "Expected output file missing for " + testDescription );
    final WebIDLSchema expected = loadWebIDLSchema( outputFile, testDescription );
    assertTrue( expected.equiv( output ),
                "Expected output file for " + testDescription + " does not match value emitted by " + label );
  }

  protected final void processFailedTest( @Nonnull final String subDirectory,
                                          @Nonnull final String errorMessage,
                                          @Nonnull final Supplier<Processor> processorSupplier )
  {
    processorGeneratesError( getClass().getSimpleName() + " " + subDirectory,
                             processorSupplier,
                             getTestLocalFixtureDir().resolve( subDirectory ),
                             "input",
                             errorMessage );
  }

  private void processorGeneratesError( @Nonnull final String label,
                                        @Nonnull final Supplier<Processor> supplier,
                                        @Nonnull final Path dir,
                                        @Nonnull final String inputFilename,
                                        @Nonnull final String errorMessage )
  {
    final String testDescription = label + " fixture test. Input=" + inputFilename;

    final WebIDLSchema input =
      loadWebIDLSchema( dir.resolve( inputFilename + WebIDLSchema.EXTENSION ), testDescription );
    try
    {
      supplier.get().process( input );
    }
    catch ( final Exception e )
    {
      assertEquals( e.getMessage(), errorMessage );
    }
  }
}
