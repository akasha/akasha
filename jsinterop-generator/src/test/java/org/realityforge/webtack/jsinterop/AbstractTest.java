package org.realityforge.webtack.jsinterop;

import gir.io.FileUtil;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.BailErrorListener;
import org.realityforge.webtack.model.WebIDLModelParser;
import org.realityforge.webtack.model.WebIDLSchema;
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

  @Nonnull
  protected final Path getJavaMainDirectory()
    throws Exception
  {
    return getWorkingDirectory().resolve( "main" ).resolve( "java" );
  }

  @Nonnull
  protected final WebIDLSchema loadWebIDLSchema( @Nonnull final Path file )
  {
    final String filename = file.toString();
    try ( final Reader reader = new FileReader( file.toFile() ) )
    {
      return WebIDLModelParser.parse( filename, Collections.emptySet(), reader, new BailErrorListener( filename ) );
    }
    catch ( final IOException ioe )
    {
      throw new AssertionError( "Error reading file " + filename );
    }
  }

  @Nonnull
  protected final WebIDLSchema loadSchema( @Nonnull final String content )
    throws Exception
  {
    final Path directory = getWorkingDirectory();
    final Path file = directory.resolve( "schema.webidl" );
    writeContent( file, content );
    return loadWebIDLSchema( file );
  }

  protected final void writeContent( @Nonnull final Path path, @Nonnull final String content )
    throws IOException
  {
    Files.write( path, content.getBytes( StandardCharsets.UTF_8 ) );
  }

  protected final void assertFileExists( @Nonnull final Path file )
  {
    assertTrue( Files.exists( file ), " File " + file + " should exist" );
  }

  @Nonnull
  private String getFileContentsAsString( @Nonnull final Path file )
    throws IOException
  {
    return new String( Files.readAllBytes( file ), StandardCharsets.UTF_8 );
  }

  protected final boolean writeOutputFixtures()
  {
    return "true".equals( System.getProperty( "webtack.output_fixture_data" ) );
  }

  @Nonnull
  protected final Path getBaseFixtureDir()
  {
    final String key = "webtack.jsinterop-generator.fixture_dir";
    final String fixtureDir = System.getProperty( key );
    assertNotNull( fixtureDir, "Expected System.getProperty( \"" + key + "\" ) to return fixture directory" );
    return new File( fixtureDir ).toPath();
  }

  @Nonnull
  protected final Path getTestLocalFixtureDir()
  {
    return getBaseFixtureDir().resolve( getClass().getName().replaceAll( "\\.", File.separator ) );
  }

  @Nonnull
  protected final Path getJavaMainFixtureDirectory()
  {
    return getTestLocalFixtureDir().resolve( "main" ).resolve( "java" );
  }

  @Nonnull
  protected final Path javaFixtureFile( @Nonnull final String name )
  {
    return javaMain( getJavaMainFixtureDirectory(), name );
  }

  @Nonnull
  protected final Path javaFile( @Nonnull final String name )
    throws Exception
  {
    return javaMain( getJavaMainDirectory(), name );
  }

  @Nonnull
  private Path javaMain( @Nonnull final Path directory, @Nonnull final String name )
  {
    return directory.resolve( "com" ).resolve( "example" ).resolve( name + ".java" );
  }

  protected final void assertFileMatchesFixture( @Nonnull final Path file, @Nonnull final Path fixtureFile )
    throws IOException
  {
    assertFileExists( file );
    if ( writeOutputFixtures() )
    {
      Files.createDirectories( fixtureFile.getParent() );
      FileUtil.write( fixtureFile, Files.readAllBytes( file ) );
    }
    assertFileExists( fixtureFile );
    final String actualContents = getFileContentsAsString( file );
    final String expectedContents = getFileContentsAsString( fixtureFile );
    assertEquals( actualContents, expectedContents, "File " + file + " should match fixture file " + fixtureFile );
  }

  @Nonnull
  protected final CodeGenContext newContext()
    throws Exception
  {
    return new CodeGenContext( Collections.emptyMap(), getWorkingDirectory(), "com.example" );
  }
}
