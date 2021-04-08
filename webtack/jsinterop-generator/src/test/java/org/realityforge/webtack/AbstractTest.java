package org.realityforge.webtack;

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
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.closure.ClosureActionFactory;
import org.realityforge.webtack.jsinterop.JsinteropActionFactory;
import org.realityforge.webtack.model.WebIDLModelParser;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.WebIDLWriter;
import org.realityforge.webtack.model.tools.PipelineContextImpl;
import org.realityforge.webtack.model.tools.pipeline.ExecutionContext;
import org.realityforge.webtack.model.tools.pipeline.config.PipelineConfig;
import org.realityforge.webtack.model.tools.pipeline.config.StageConfig;
import org.realityforge.webtack.model.tools.qa.BailErrorListener;
import org.realityforge.webtack.model.tools.qa.TestProgressListener;
import org.realityforge.webtack.model.tools.spi.Action;
import org.realityforge.webtack.model.tools.spi.PipelineContext;
import org.realityforge.webtack.model.tools.util.AbstractAction;
import org.realityforge.webtack.model.tools.util.JavaProcess;
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

  protected final void generateCode( @Nonnull final Path directory,
                                     @Nonnull final Path commonDirectory,
                                     @Nonnull final WebIDLSchema schema,
                                     @Nonnull final String packageName,
                                     @Nullable final String globalInterface,
                                     @Nonnull final ValidatorRuleConfig validator,
                                     @Nonnull final List<String> gwtInherits )
    throws Exception
  {
    final Collection<ValidationError> errors = ValidatorTool.create( validator ).validate( schema );
    assertTrue( errors.isEmpty(), "Unexpected Errors: " + asString( errors ) );
    schema.link();

    if ( writeOutputFixtures() )
    {
      // Delete local fixtures if we plan to regenerate them to ensure that no
      // stray source files are left in fixtures directory
      FileUtil.deleteDirIfExists( directory.resolve( "output" ) );

      // write out schema to ensure it is normalized
      Files.createDirectories( directory );
      final Path schemaPath = directory.resolve( "schema.webidl" );
      try ( final FileWriter writer = new FileWriter( schemaPath.toFile() ) )
      {
        WebIDLWriter.writeSchema( writer, schema );
      }
    }

    final Path workingDirectory = getWorkingDir();
    final Path inputDirectory = directory.resolve( "input" );
    final Path inputJavaDirectory = inputDirectory.resolve( "main" ).resolve( "java" );
    final Path inputJsDirectory = inputDirectory.resolve( "main" ).resolve( "js" );
    final Path commonInput = commonDirectory.resolve( "input" );
    final Path commonInputJavaDirectory = commonInput.resolve( "main" ).resolve( "java" );
    final Path commonInputJsDirectory = commonInput.resolve( "main" ).resolve( "js" );
    final Path outputDirectory = workingDirectory.resolve( "output" );
    final List<Path> predefinedTypeMappingPaths =
      collectFilesWithExtension( ".mapping", inputDirectory.resolve( "main" ).resolve( "resources" ) );
    final List<Path> externalTypeMappingPaths =
      collectFilesWithExtension( ".mapping", commonInput.resolve( "main" ).resolve( "resources" ) );
    final Set<Path> generatedJsinteropFiles =
      performJsinteropAction( directory,
                              schema,
                              packageName,
                              globalInterface,
                              gwtInherits,
                              outputDirectory,
                              predefinedTypeMappingPaths,
                              externalTypeMappingPaths );

    for ( final Path file : generatedJsinteropFiles )
    {
      // If it is not in the input path then it must be in output path
      final Path javaPath = outputDirectory.resolve( "main" ).resolve( "java" ).relativize( file );
      if ( !Files.exists( inputJavaDirectory.resolve( javaPath ) ) )
      {
        final Path relativePath = workingDirectory.relativize( file );
        assertFileMatchesFixture( file, directory.resolve( relativePath ) );
      }
    }

    final List<Path> predefinedTypeCatalogPaths =
      collectFilesWithExtension( ".types", inputDirectory.resolve( "main" ).resolve( "resources" ) );
    final List<Path> commonTypeCatalogPaths =
      collectFilesWithExtension( ".types", commonInput.resolve( "main" ).resolve( "resources" ) );
    predefinedTypeCatalogPaths.addAll( commonTypeCatalogPaths );
    final Set<Path> generatedClosureFiles =
      performClosureAction( directory,
                            schema,
                            packageName,
                            globalInterface,
                            outputDirectory,
                            predefinedTypeCatalogPaths );
    for ( final Path file : generatedClosureFiles )
    {
      // If it is not in the input path then it must be in output path
      final Path javaPath = outputDirectory.resolve( "main" ).resolve( "js" ).relativize( file );
      if ( !Files.exists( inputJsDirectory.resolve( javaPath ) ) )
      {
        final Path relativePath = workingDirectory.relativize( file );
        assertFileMatchesFixture( file, directory.resolve( relativePath ) );
      }
    }

    final List<Path> javaSourceDirectories = new ArrayList<>();
    final Path mainJavaDirectory = outputDirectory.resolve( "main" ).resolve( "java" );
    javaSourceDirectories.add( mainJavaDirectory );
    final List<Path> javaFiles = new ArrayList<>( collectFilesWithExtension( ".java", mainJavaDirectory ) );
    if ( Files.exists( inputJavaDirectory ) )
    {
      javaFiles.addAll( collectFilesWithExtension( ".java", inputJavaDirectory ) );
      javaSourceDirectories.add( inputJavaDirectory );
    }
    if ( Files.exists( commonInputJavaDirectory ) )
    {
      javaFiles.addAll( collectFilesWithExtension( ".java", commonInputJavaDirectory ) );
      javaSourceDirectories.add( commonInputJavaDirectory );
    }

    final Path mainJsDirectory = outputDirectory.resolve( "main" ).resolve( "js" );
    final List<Path> jsFiles = new ArrayList<>( collectFilesWithExtension( ".js", mainJsDirectory ) );
    if ( Files.exists( inputJsDirectory ) )
    {
      jsFiles.addAll( collectFilesWithExtension( ".js", inputJsDirectory ) );
    }
    if ( Files.exists( commonInputJsDirectory ) )
    {
      jsFiles.addAll( collectFilesWithExtension( ".js", commonInputJsDirectory ) );
    }

    ensureGeneratedCodeCompiles( javaSourceDirectories, javaFiles, jsFiles );
  }

  @Nonnull
  private Set<Path> performJsinteropAction( @Nonnull final Path directory,
                                            @Nonnull final WebIDLSchema schema,
                                            @Nonnull final String packageName,
                                            @Nullable final String globalInterface,
                                            @Nonnull final List<String> gwtInherits,
                                            @Nonnull final Path outputDirectory,
                                            @Nonnull final List<Path> predefinedTypeMappingPaths,
                                            @Nonnull final List<Path> externalTypeMappingPaths )
    throws Exception
  {
    final JsinteropActionFactory factory = new JsinteropActionFactory();
    factory.packageName = packageName;
    factory.globalInterface = globalInterface;
    factory.gwtInherits = gwtInherits;
    factory.outputDirectory = outputDirectory.toString();
    factory.predefinedTypeMapping =
      predefinedTypeMappingPaths.stream().map( Path::toString ).collect( Collectors.toList() );
    factory.externalTypeMapping =
      externalTypeMappingPaths.stream().map( Path::toString ).collect( Collectors.toList() );
    final Action action = factory.create( newPipelineContext( directory ) );
    action.process( schema );
    return ( (AbstractAction) action ).getGeneratedFiles();
  }

  @Nonnull
  private Set<Path> performClosureAction( @Nonnull final Path directory,
                                          @Nonnull final WebIDLSchema schema,
                                          @Nonnull final String packageName,
                                          @Nullable final String globalInterface,
                                          @Nonnull final Path outputDirectory,
                                          @Nonnull final List<Path> predefinedTypeCatalogPaths )
    throws Exception
  {
    final ClosureActionFactory factory = new ClosureActionFactory();
    factory.outputDirectory = outputDirectory.toString();
    factory.key = packageName.replace( ".", "/" ) + "/externs.js";
    factory.globalInterface = globalInterface;
    factory.predefinedTypeCatalogs =
      predefinedTypeCatalogPaths.stream().map( Path::toString ).collect( Collectors.toList() );
    final Action action = factory.create( newPipelineContext( directory ) );
    action.process( schema );
    return ( (AbstractAction) action ).getGeneratedFiles();
  }

  /**
   * Compile the supplied java files and make sure that they compile together.
   *
   * @param javaSourceDirectories the directories from which the java files are compiled.
   * @param javaFiles             the java files.
   * @param jsFiles               the javascript files.
   * @throws Exception if there is an error
   */
  private void ensureGeneratedCodeCompiles( @Nonnull final List<Path> javaSourceDirectories,
                                            @Nonnull final List<Path> javaFiles,
                                            @Nonnull final List<Path> jsFiles )
    throws Exception
  {
    if ( !javaFiles.isEmpty() )
    {
      final List<Path> classpathEntries = collectLibs();
      final Path output =
        JavaProcess.javac( javaFiles, classpathEntries, getWorkingDir().resolve( "target" ).resolve( "classes" ) );
      final List<Path> classpathElements = new ArrayList<>( classpathEntries );
      classpathElements.addAll( gwtDevLibs() );

      JavaProcess.javadoc( javaSourceDirectories,
                           javaFiles,
                           classpathElements,
                           getWorkingDir().resolve( "target" ).resolve( "javadoc" ) );
      if ( "true".equals( SystemProperty.get( "webtack.jsinterop-generator.gwtc" ) ) )
      {
        gwtc( classpathEntries, output );
      }
    }
    if ( !jsFiles.isEmpty() )
    {
      if ( "true".equals( SystemProperty.get( "webtack.jsinterop-generator.closure_compile" ) ) )
      {
        final Path outputDirectory = getWorkingDir().resolve( "target" ).resolve( "js" );
        Files.createDirectories( outputDirectory );
        final Path outputJs = outputDirectory.resolve( "output.js" );
        final Path inputJs = outputDirectory.resolve( "input.js" );
        FileUtil.write( inputJs, "" );
        final List<String> args = new ArrayList<>();
        args.add( "-jar" );
        args.add( closureJar().toString() );
        args.add( "--compilation_level" );
        args.add( "ADVANCED" );
        args.add( "--env" );
        args.add( "CUSTOM" );
        args.add( "--js_output_file" );
        args.add( outputJs.toString() );
        args.add( "--jscomp_error" );
        args.add( "*" );
        args.add( "--warning_level" );
        args.add( "VERBOSE" );
        args.add( inputJs.toString() );
        for ( final Path file : jsFiles )
        {
          args.add( file.toString() );
        }

        final int exitCode = JavaProcess.java( args );
        assertEquals( exitCode, 0 );
      }
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
  private List<Path> collectFilesWithExtension( @Nonnull final String extension, @Nonnull final Path... dirs )
    throws IOException
  {
    final List<Path> javaFiles = new ArrayList<>();
    for ( final Path dir : dirs )
    {
      if ( dir.toFile().exists() )
      {
        Files
          .walk( dir )
          .filter( p -> p.toString().endsWith( extension ) )
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
  private Path closureJar()
  {
    return Paths.get( SystemProperty.get( "webtack.jsinterop-generator.closure.jar" ) );
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

  @Nonnull
  protected PipelineContext newPipelineContext( @Nonnull final Path directory )
  {
    try
    {
      final ExecutionContext executionContext =
        new ExecutionContext( directory.resolve( "idl" ), directory.resolve( "docs" ), new TestProgressListener() );
      final PipelineConfig pipelineConfig = new PipelineConfig();
      pipelineConfig.setName( "MyPipeline" );
      pipelineConfig.setStages( new ArrayList<>() );
      final PipelineContextImpl pipelineContext = new PipelineContextImpl( executionContext, pipelineConfig );
      final StageConfig stage = new StageConfig();
      stage.setName( "MyStage" );
      pipelineContext.beforeStage( stage, Collections.emptyList() );
      return pipelineContext;
    }
    catch ( final Exception e )
    {
      throw new IllegalStateException( e );
    }
  }
}