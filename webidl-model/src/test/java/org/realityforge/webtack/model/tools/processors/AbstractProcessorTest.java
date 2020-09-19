package org.realityforge.webtack.model.tools.processors;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Supplier;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.AbstractTest;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.tools.spi.Completable;
import org.realityforge.webtack.model.tools.spi.Processor;
import static org.testng.Assert.*;

public abstract class AbstractProcessorTest
  extends AbstractTest
{
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

  @SuppressWarnings( "SameParameterValue" )
  protected final void performFixtureTest( @Nonnull final String label,
                                           @Nonnull final Supplier<Processor> supplier,
                                           @Nonnull final Path dir,
                                           @Nonnull final String inputFilename,
                                           @Nonnull final String outputFilename )
    throws Exception
  {
    final String testDescription = label + " fixture test. Input=" + inputFilename + " Output=" + outputFilename;

    final Path inputFile = dir.resolve( inputFilename + WebIDLSchema.EXTENSION );
    final WebIDLSchema input = loadWebIDLSchema( inputFile, testDescription );
    maybeWriteSchemaFixture( inputFile, input );
    final Processor processor = supplier.get();
    final WebIDLSchema output = processor.process( input );
    assertNotNull( output );
    Completable.complete( processor );

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
    final String testDescription = ( getClass().getSimpleName() + " " + subDirectory ) + " fixture test. Input=" +
                                   "input";

    final Path path = getTestLocalFixtureDir().resolve( subDirectory );
    final WebIDLSchema input = loadWebIDLSchema( path.resolve( "input" + WebIDLSchema.EXTENSION ), testDescription );
    try
    {
      processorSupplier.get().process( input );
    }
    catch ( final Exception e )
    {
      final String message = e.getMessage();
      assertEquals( message.replace( path.toString() + "/", "" ), errorMessage );
      return;
    }
    fail( "Expected test failure for " + testDescription );
  }
}
