package org.realityforge.webtack.react4j;

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
import javax.tools.DocumentationTool;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
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
    final String key = "webtack.react4j-generator.fixture_dir";
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

  protected final void generateCode( @Nonnull final Path directory,
                                     @Nullable final String factoryName,
                                     @Nonnull final ValidatorRuleConfig validator )
    throws Exception
  {
    generateCode( directory,
                  new String( Files.readAllBytes( directory.resolve( "schema.webidl" ) ), StandardCharsets.UTF_8 ),
                  factoryName,
                  validator );
  }

  private void generateCode( @Nonnull final Path directory,
                             @Nonnull final String content,
                             @Nullable final String factoryName,
                             @Nonnull final ValidatorRuleConfig validator )
    throws Exception
  {
    generateCode( directory, loadSchema( content ), factoryName, validator );
  }

  private void generateCode( @Nonnull final Path directory,
                             @Nonnull final WebIDLSchema schema,
                             @Nullable final String factoryName,
                             @Nonnull final ValidatorRuleConfig validator )
    throws Exception
  {
    final Collection<ValidationError> errors = ValidatorTool.create( validator ).validate( schema );
    assertTrue( errors.isEmpty(), "Unexpected Errors: " + asString( errors ) );
    schema.link();

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

    final Path outputDirectory = getWorkingDir();
    final React4jAction action = new React4jAction( outputDirectory, "com.example", factoryName, true );
    action.process( schema );
    final Path mainJavaDirectory = action.getMainJavaDirectory();
    final List<Path> javaFiles = collectJavaFiles( mainJavaDirectory );
    final List<Path> classpathEntries = collectLibs();

    final Map<String, Path> generatedSourceFiles = action.getGeneratedFiles();
    for ( final Map.Entry<String, Path> e : generatedSourceFiles.entrySet() )
    {
      final Path file = e.getValue();
      final Path relativePath = outputDirectory.relativize( file );
      assertFileMatchesFixture( file, directory.resolve( relativePath ) );
    }

    ensureGeneratedCodeCompiles( mainJavaDirectory, javaFiles, classpathEntries );
  }

  /**
   * Compile the supplied java files and make sure that they compile together.
   *
   * @param mainJavaDirectory the directory in which java files are compiled.
   * @param javaFiles         the java files.
   * @throws Exception if there is an error
   */
  private void ensureGeneratedCodeCompiles( @Nonnull final Path mainJavaDirectory,
                                            @Nonnull final List<Path> javaFiles,
                                            @Nonnull final List<Path> classpathEntries )
    throws Exception
  {
    if ( !javaFiles.isEmpty() )
    {
      final Path output = javac( javaFiles, classpathEntries );
      javadoc( mainJavaDirectory, javaFiles, classpathEntries );
      if ( "true".equals( SystemProperty.get( "webtack.react4j-generator.gwtc" ) ) )
      {
        gwtc( classpathEntries, output );
      }
    }
  }

  @Nonnull
  private Path javac( @Nonnull final List<Path> javaFiles, @Nonnull final List<Path> classpathEntries )
    throws Exception
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
    fileManager.setLocation( StandardLocation.CLASS_OUTPUT,
                             Collections.singletonList( output.toFile() ) );
    fileManager.setLocation( StandardLocation.SOURCE_OUTPUT,
                             Collections.singletonList( output.toFile() ) );
    fileManager.setLocation( StandardLocation.CLASS_PATH,
                             classpathEntries.stream().map( Path::toFile ).collect( Collectors.toList() ) );

    final JavaCompiler.CompilationTask task =
      compiler.getTask( null,
                        fileManager,
                        listener,
                        Arrays.asList( "-Xlint:all,-processing,-serial", "-Werror" ),
                        null,
                        compilationUnits );
    if ( !task.call() || !listener.getDiagnostics().isEmpty() )
    {
      fail( "Failed to compile files:\n" +
            listener.getDiagnostics().stream().map( Object::toString ).collect( Collectors.joining( "\n" ) ) );
    }
    return output;
  }

  private void javadoc( @Nonnull final Path mainJavaDirectory,
                        @Nonnull final List<Path> javaFiles,
                        @Nonnull final List<Path> classpathEntries )
    throws Exception
  {
    final DocumentationTool javadoc = ToolProvider.getSystemDocumentationTool();
    final StandardJavaFileManager fileManager = javadoc.getStandardFileManager( null, null, null );
    final Path output = getWorkingDir().resolve( "target" ).resolve( "javadoc" );
    Files.createDirectories( output );
    final Iterable<? extends JavaFileObject> compilationUnits =
      fileManager.getJavaFileObjectsFromFiles( javaFiles
                                                 .stream()
                                                 .map( Path::toFile )
                                                 .collect( Collectors.toList() ) );
    final DiagnosticCollector<JavaFileObject> listener = new DiagnosticCollector<>();
    final List<Path> classpathElements = new ArrayList<>( classpathEntries );
    classpathElements.addAll( gwtDevLibs() );
    fileManager.setLocation( DocumentationTool.Location.DOCUMENTATION_OUTPUT,
                             Collections.singletonList( output.toFile() ) );
    fileManager.setLocation( StandardLocation.CLASS_PATH,
                             classpathElements.stream().map( Path::toFile ).collect( Collectors.toList() ) );
    fileManager.setLocation( StandardLocation.SOURCE_PATH,
                             Collections.singletonList( mainJavaDirectory.toFile() ) );

    final DocumentationTool.DocumentationTask task =
      javadoc.getTask( null,
                       fileManager,
                       listener,
                       null,
                       Collections.singletonList( "-Xdoclint:all" ),
                       compilationUnits );
    if ( !task.call() )
    {
      fail( "Failed to javadoc files:\n" +
            listener.getDiagnostics().stream().map( Object::toString ).collect( Collectors.joining( "\n" ) ) );
    }
  }

  private void gwtc( @Nonnull final List<Path> classpathEntries, @Nonnull final Path output )
    throws Exception
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
    final String libraries = System.getProperty( "webtack.react4j-generator.fixture.libs" );
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
    final String libraries = System.getProperty( "webtack.react4j-generator.gwt_dev.libs" );
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
