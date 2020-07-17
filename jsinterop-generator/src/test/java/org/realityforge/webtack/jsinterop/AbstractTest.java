package org.realityforge.webtack.jsinterop;

import gir.io.FileUtil;
import gir.sys.SystemProperty;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import org.realityforge.webtack.model.WebIDLModelParser;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.WebIDLWriter;
import org.realityforge.webtack.model.tools.validator.ValidationError;
import org.realityforge.webtack.model.tools.validator.ValidatorRuleConfig;
import org.realityforge.webtack.model.tools.validator.ValidatorTool;
import org.testng.annotations.AfterMethod;
import static org.testng.Assert.*;

public abstract class AbstractTest
{
  @Nullable
  private Path _workingDir;

  @AfterMethod
  protected void afterMethod()
  {
    if ( null != _workingDir )
    {
      FileUtil.deleteDirIfExists( _workingDir );
      _workingDir = null;
    }
  }

  @Nonnull
  protected final Path getWorkingDir()
    throws Exception
  {
    if ( null == _workingDir )
    {
      _workingDir = FileUtil.createTempDir();
    }
    return _workingDir;
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
    final Path directory = getWorkingDir();
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

  protected final void generateCode( @Nonnull final Path directory, @Nonnull final ValidatorRuleConfig validator )
    throws Exception
  {
    generateCode( directory,
                  new String( Files.readAllBytes( directory.resolve( "schema.webidl" ) ), StandardCharsets.UTF_8 ),
                  validator );
  }

  private void generateCode( @Nonnull final Path directory,
                             @Nonnull final String content,
                             @Nonnull final ValidatorRuleConfig validator )
    throws Exception
  {
    generateCode( directory, loadSchema( content ), validator );
  }

  private void generateCode( @Nonnull final Path directory,
                             @Nonnull final WebIDLSchema schema,
                             @Nonnull final ValidatorRuleConfig validator )
    throws Exception
  {
    final Collection<ValidationError> errors = ValidatorTool.create( validator ).validate( schema );
    assertTrue( errors.isEmpty(), "Unexpected Errors: " + asString( errors ) );
    final CodeGenContext context = newContext( schema );

    if ( writeOutputFixtures() )
    {
      // Delete local fixtures if we plan to regenerate them to ensure that no
      // stray source files are left in fixtures directory
      FileUtil.deleteDirIfExists( directory );

      // write out schema to ensure it is normalized
      Files.createDirectories( directory );
      final Path schemaPath = directory.resolve( "schema.webidl" );
      try ( final FileWriter writer = new FileWriter( schemaPath.toFile() ) )
      {
        WebIDLWriter.writeSchema( writer, schema );
      }
    }

    new Generator().generate( context );
    final List<Path> javaFiles = collectJavaFiles( context.getMainJavaDirectory() );
    final List<Path> classpathEntries = collectLibs();

    ensureGeneratedCodeCompiles( javaFiles, classpathEntries );

    final Map<String, Path> generatedSourceFiles = context.getGeneratedSourceFiles();
    for ( final Map.Entry<String, Path> e : generatedSourceFiles.entrySet() )
    {
      final Path file = e.getValue();
      final Path relativePath = context.getOutputDirectory().relativize( file );
      assertFileMatchesFixture( file, directory.resolve( relativePath ) );
    }
  }

  @Nonnull
  protected final CodeGenContext newContext( @Nonnull final WebIDLSchema schema )
    throws Exception
  {
    schema.link();
    return new CodeGenContext( schema, getWorkingDir(), "com.example" );
  }

  /**
   * Compile the supplied java files and make sure that they compile together.
   *
   * @param javaFiles the java files.
   * @throws Exception if there is an error
   */
  private void ensureGeneratedCodeCompiles( @Nonnull final List<Path> javaFiles,
                                            @Nonnull final List<Path> classpathEntries )
    throws Exception
  {
    if ( !javaFiles.isEmpty() )
    {
      final JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
      final StandardJavaFileManager fileManager = compiler.getStandardFileManager( null, null, null );
      final Path output = getWorkingDir().resolve( "target" ).resolve( "classes" );
      Files.createDirectories( output );
      final Iterable<? extends JavaFileObject> compilationUnits =
        fileManager.getJavaFileObjectsFromFiles( javaFiles
                                                   .stream()
                                                   .map( Path::toFile )
                                                   .collect( Collectors.toList() ) );
      final DiagnosticCollector<JavaFileObject> listener = new DiagnosticCollector<>();
      final String classpath =
        classpathEntries
          .stream()
          .map( Path::toAbsolutePath )
          .map( Path::toString )
          .collect( Collectors.joining( File.pathSeparator ) );
      final JavaCompiler.CompilationTask compilationTask =
        compiler.getTask( null,
                          fileManager,
                          listener,
                          Arrays.asList( "-d",
                                         output.toString(),
                                         "-cp",
                                         classpath,
                                         "-Xlint:all,-processing,-serial",
                                         "-Werror" ),
                          null,
                          compilationUnits );
      if ( !compilationTask.call() || !listener.getDiagnostics().isEmpty() )
      {
        fail( "Failed to compile files:\n" +
              listener.getDiagnostics().stream().map( Object::toString ).collect( Collectors.joining( "\n" ) ) );
      }
      if ( "true".equals( SystemProperty.get( "webtack.jsinterop-generator.gwtc" ) ) )
      {
        FileUtil.write( output.resolve( "com" ).resolve( "example" ).resolve( "MyModule.gwt.xml" ),
                        "<module>\n" +
                        "  <inherits name=\"com.google.gwt.user.User\"/>\n" +
                        "  <source path=''/>\n" +
                        "  <collapse-all-properties/>\n" +
                        "</module>\n" );
        classpathEntries.add( output );
        classpathEntries.addAll( gwtDevLibs() );
        final List<String> gwtClasspath =
          classpathEntries
            .stream()
            .map( Path::toAbsolutePath )
            .map( Path::toString )
            .collect( Collectors.toList() );
        final int exitCode =
          JavaProcess.exec( "com.google.gwt.dev.Compiler",
                            Collections.singletonList( "-Dgwt.persistentunitcache=false" ),
                            Arrays.asList( "-strict",
                                           "-war",
                                           getWorkingDir().resolve( "war" ).toAbsolutePath().toString(),
                                           "-draftCompile",
                                           "-noincremental",
                                           "com.example.MyModule" ),
                            gwtClasspath );
        assertEquals( exitCode, 0 );
      }
    }
  }

  @Nonnull
  private List<Path> collectJavaFiles( @Nonnull final Path... dirs )
    throws IOException
  {
    final List<Path> javaFiles = new ArrayList<>();
    for ( final Path dir : dirs )
    {
      if ( dir.toFile().exists() )
      {
        Files
          .walk( dir )
          .filter( p -> p.toString().endsWith( ".java" ) )
          .forEach( javaFiles::add );
      }
    }
    return javaFiles;
  }

  @Nonnull
  private List<Path> collectLibs()
  {
    final String libraries = System.getProperty( "webtack.jsinterop-generator.fixture.libs" );
    return null == libraries ?
           new ArrayList<>() :
           Arrays
             .stream( libraries.split( File.pathSeparator ) )
             .map( Paths::get )
             .collect( Collectors.toList() );
  }

  @Nonnull
  private List<Path> gwtDevLibs()
  {
    final String libraries = System.getProperty( "webtack.jsinterop-generator.gwt_dev.libs" );
    return null == libraries ?
           new ArrayList<>() :
           Arrays
             .stream( libraries.split( File.pathSeparator ) )
             .map( Paths::get )
             .collect( Collectors.toList() );
  }

  @Nonnull
  private String asString( @Nonnull final Collection<ValidationError> errors )
  {
    return "Errors:\n" + errors.stream().map( ValidationError::getMessage ).collect( Collectors.joining( "\n" ) );
  }
}
