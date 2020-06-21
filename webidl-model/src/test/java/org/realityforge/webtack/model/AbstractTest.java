package org.realityforge.webtack.model;

import gir.io.FileUtil;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.antlr.v4.runtime.ParserRuleContext;
import org.realityforge.webtack.model.tools.spi.Processor;
import org.realityforge.webtack.model.tools.validator.ValidationError;
import org.realityforge.webtack.webidl.parser.WebIDLParser;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import static org.testng.Assert.*;

public abstract class AbstractTest
{
  @Nullable
  private Path _workingDirectory;

  @AfterMethod
  protected void afterMethod()
  {
    if ( null != _workingDirectory )
    {
      FileUtil.deleteDirIfExists( _workingDirectory );
      _workingDirectory = null;
    }
  }

  @Nonnull
  protected final Path getWorkingDirectory()
    throws Exception
  {
    if ( null == _workingDirectory )
    {
      _workingDirectory = FileUtil.createTempDir();
    }
    return _workingDirectory;
  }

  protected final void assertArgument( @Nonnull final Argument argument,
                                       @Nonnull final String name,
                                       @Nonnull final Kind kind,
                                       final boolean optional,
                                       final boolean variadic )
  {
    assertEquals( argument.getName(), name );
    assertEquals( argument.getType().getKind(), kind );
    assertEquals( argument.isOptional(), optional );
    assertEquals( argument.isVariadic(), variadic );
  }

  @Nonnull
  protected final String randomString()
  {
    return UUID.randomUUID().toString().substring( 0, 7 );
  }

  protected final <T extends Throwable> void assertThrows( @Nonnull Class<T> throwableClass,
                                                           @Nullable final String message,
                                                           @Nonnull final Assert.ThrowingRunnable throwingRunnable )
  {
    assertEquals( expectThrows( throwableClass, throwingRunnable ).getMessage(), message );
  }

  @Nonnull
  protected final WebIDLParser createParser( @Nonnull final String webIDL )
    throws IOException
  {
    return WebIDLModelParser.createParser( "test", new StringReader( webIDL ) );
  }

  @Nonnull
  protected final SourcePosition parseStartPosition( @Nonnull final ParserRuleContext ctx )
  {
    return WebIDLModelParser.parseSourcePosition( ctx.getStart() );
  }

  @Nonnull
  protected final WebIDLSchema loadTestLocalSchema( @Nonnull final String filename )
  {
    return loadWebIDLSchema( getTestLocalFixtureDir().resolve( filename ) );
  }

  @Nonnull
  protected final WebIDLSchema loadWebIDLSchema( @Nonnull final Path file )
  {
    return loadWebIDLSchema( file, null );
  }

  @Nonnull
  protected final WebIDLSchema loadWebIDLSchema( @Nonnull final Path file, @Nullable final String testDescription )
  {
    return loadWebIDLSchema( file, Collections.emptySet(), testDescription );
  }

  @Nonnull
  protected final WebIDLSchema loadWebIDLSchema( @Nonnull final Path file,
                                                 @Nonnull final Set<String> tags,
                                                 @Nullable final String testDescription )
  {
    final String filename = file.toString();
    try ( final Reader reader = new FileReader( file.toFile() ) )
    {
      return WebIDLModelParser.parse( filename, tags, reader, new BailErrorListener( filename ) );
    }
    catch ( final IOException ioe )
    {
      throw new AssertionError( "Error reading file " + filename +
                                ( null == testDescription ? "" : " for " + testDescription ) );
    }
  }

  @Nonnull
  protected final Path getTestLocalFixtureDir()
  {
    return getBaseFixtureDir().resolve( getClass().getName().replaceAll( "\\.", File.separator ) );
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

  protected final void maybeWriteSchemaFixture( @Nonnull final Path file, @Nonnull final WebIDLSchema schema )
    throws IOException
  {
    if ( writeOutputFixtures() )
    {
      try ( final Writer writer = new FileWriter( file.toFile() ) )
      {
        WebIDLWriter.writeSchema( writer, schema );
      }
    }
  }

  protected final void assertFileContents( @Nonnull final Path path, @Nonnull final String expected )
    throws IOException
  {
    assertTrue( Files.exists( path ) );
    assertEquals( new String( Files.readAllBytes( path ), StandardCharsets.UTF_8 ), expected );
  }

  protected final boolean writeOutputFixtures()
  {
    return "true".equals( System.getProperty( "webtack.output_fixture_data" ) );
  }

  @Nonnull
  protected final Path getBaseFixtureDir()
  {
    final String key = "webtack.fixture_dir";
    final String fixtureDir = System.getProperty( key );
    assertNotNull( fixtureDir, "Expected System.getProperty( \"" + key + "\" ) to return fixture directory" );
    return new File( fixtureDir ).toPath();
  }

  protected final void assertErrorPresent( @Nonnull final Collection<ValidationError> errors,
                                           @Nonnull final String message )
  {
    assertErrorPresent( errors, message, true );
  }

  @SuppressWarnings( "SameParameterValue" )
  protected final void assertErrorPresent( @Nonnull final Collection<ValidationError> errors,
                                           @Nonnull final String message,
                                           final boolean halt )
  {
    assertTrue( errors.stream().anyMatch( e -> e.getMessage().equals( message ) && e.shouldHalt() == halt ),
                "Failed to find error with message '" + message + "' and shouldHalt = " + halt + " in " +
                asString( errors ) );
  }

  protected final void assertErrorCount( @Nonnull final Collection<ValidationError> errors, final int errorCount )
  {
    assertEquals( errors.size(), errorCount, "Errors: " + asString( errors ) );
  }

  @Nonnull
  private String asString( @Nonnull final Collection<ValidationError> errors )
  {
    return "Errors:\n" + errors.stream().map( ValidationError::getMessage ).collect( Collectors.joining( "\n" ) );
  }

  @Nonnull
  protected final Path writeSchema( @Nonnull final String name, @Nonnull final String content )
    throws Exception
  {
    final Path file = getIdlDirectory().resolve( name + WebIDLSchema.EXTENSION );
    Files.write( file, content.getBytes( StandardCharsets.UTF_8 ) );
    return file;
  }

  @Nonnull
  protected final Path getOutputFile( @Nonnull final String filename )
    throws Exception
  {
    return getOutputDirectory().resolve( filename + WebIDLSchema.EXTENSION );
  }

  @Nonnull
  protected final Path getOutputDirectory()
    throws Exception
  {
    final Path idlDirectory = getWorkingDirectory().resolve( "output" );
    Files.createDirectories( idlDirectory );
    return idlDirectory;
  }

  @Nonnull
  protected final Path getIdlDirectory()
    throws Exception
  {
    final Path idlDirectory = getWorkingDirectory().resolve( "idl" );
    Files.createDirectories( idlDirectory );
    return idlDirectory;
  }
}
