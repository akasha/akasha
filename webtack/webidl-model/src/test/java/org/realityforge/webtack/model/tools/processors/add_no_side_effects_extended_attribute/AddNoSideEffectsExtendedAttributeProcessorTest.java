package org.realityforge.webtack.model.tools.processors.add_no_side_effects_extended_attribute;

import java.nio.file.Path;
import javax.annotation.Nonnull;
import javax.json.Json;
import org.realityforge.webtack.model.tools.pipeline.ProgressListener;
import org.realityforge.webtack.model.tools.processors.AbstractProcessorTest;
import org.realityforge.webtack.model.tools.qa.TestProgressListener;
import org.realityforge.webtack.model.tools.spi.Processor;
import org.realityforge.webtack.model.tools.spi.Registry;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class AddNoSideEffectsExtendedAttributeProcessorTest
  extends AbstractProcessorTest
{
  @Test
  public void registry()
  {
    assertTrue( Registry.isProcessorPresent( "AddNoSideEffectsExtendedAttribute" ) );
  }

  @Test
  public void basic()
    throws Exception
  {
    final Path file = getTestLocalFixtureDir().resolve( "basic" ).resolve( "no_side_effects.txt" );

    performStandardFixtureTest( "basic", () -> createProcessor( new TestProgressListener(), file ) );
  }

  @Test
  public void missing_file()
  {
    final Path file = getTestLocalFixtureDir().resolve( "missing_file" ).resolve( "no_side_effects.txt" );
    final TestProgressListener progressListener = new TestProgressListener();
    try
    {
      createProcessor( progressListener, file );
      fail( "Expected processor creation to fail" );
    }
    catch ( final IllegalArgumentException iae )
    {
      assertEquals( iae.getMessage(),
                    "AddNoSideEffectsExtendedAttributeProcessor failed to parse the file " +
                    "configuration value as it expected to reference a file that existed but no such " +
                    "file exists at " + file );
    }
  }

  @SuppressWarnings( "SameParameterValue" )
  @Nonnull
  private Processor createProcessor( @Nonnull final ProgressListener progressListener,
                                     @Nonnull final Path file )
  {
    return Registry.createProcessor( newPipelineContext( progressListener ),
                                     "AddNoSideEffectsExtendedAttribute",
                                     Json
                                       .createObjectBuilder()
                                       .add( "file", file.toString() )
                                       .build() );
  }
}
