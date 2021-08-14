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
import org.realityforge.webtack.jsinterop.OutputType;
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

  @SuppressWarnings( "SameParameterValue" )
  protected final void generateCode( @Nonnull final Path directory,
                                     @Nonnull final Path commonDirectory,
                                     @Nonnull final WebIDLSchema schema,
                                     @Nonnull final String packageName,
                                     @Nullable final String globalInterface,
                                     final boolean compileTest,
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
    final Path gwtOutputDirectory = workingDirectory.resolve( "output" ).resolve( "gwt" );
    final Path j2clOutputDirectory = workingDirectory.resolve( "output" ).resolve( "j2cl" );
    final List<Path> predefinedTypeMappingPaths =
      collectFilesWithExtension( ".mapping", inputDirectory.resolve( "main" ).resolve( "resources" ) );
    final List<Path> externalTypeMappingPaths =
      collectFilesWithExtension( ".mapping", commonInput.resolve( "main" ).resolve( "resources" ) );

    // Produce GWT outputs
    {
      final Set<Path> gwtGeneratedFiles =
        performJsinteropAction( directory,
                                schema,
                                OutputType.gwt,
                                packageName,
                                globalInterface,
                                gwtInherits,
                                compileTest,
                                gwtOutputDirectory,
                                predefinedTypeMappingPaths,
                                externalTypeMappingPaths );

      assertFilesMatch( directory,
                        workingDirectory,
                        inputJavaDirectory,
                        gwtGeneratedFiles,
                        gwtOutputDirectory.resolve( "main" ).resolve( "java" ) );
    }

    // Produce J2CL outputs
    {
      final Set<Path> j2clGeneratedFiles =
        performJsinteropAction( directory,
                                schema,
                                OutputType.j2cl,
                                packageName,
                                globalInterface,
                                null,
                                compileTest,
                                j2clOutputDirectory,
                                predefinedTypeMappingPaths,
                                externalTypeMappingPaths );

      final Path j2clMainJavaOutput = j2clOutputDirectory.resolve( "main" ).resolve( "java" );
      assertFilesMatch( directory, workingDirectory, inputJavaDirectory, j2clGeneratedFiles, j2clMainJavaOutput );
    }

    // Generate closure outputs
    {
      final List<Path> predefinedTypeCatalogPaths =
        collectFilesWithExtension( ".types", inputDirectory.resolve( "main" ).resolve( "resources" ) );
      final List<Path> additionalExternFragmentPaths =
        collectFilesWithExtension( ".externs.fragment.js", inputDirectory.resolve( "main" ).resolve( "js" ) );
      final List<Path> commonTypeCatalogPaths =
        collectFilesWithExtension( ".types", commonInput.resolve( "main" ).resolve( "resources" ) );
      predefinedTypeCatalogPaths.addAll( commonTypeCatalogPaths );
      final Set<Path> generatedClosureFiles =
        performClosureAction( directory,
                              schema,
                              packageName,
                              globalInterface,
                              j2clOutputDirectory,
                              predefinedTypeCatalogPaths,
                              additionalExternFragmentPaths );
      assertFilesMatch( directory,
                        workingDirectory,
                        inputJsDirectory,
                        generatedClosureFiles,
                        j2clOutputDirectory.resolve( "main" ).resolve( "js" ) );
    }

    final List<Path> gwtSourceDirectories = new ArrayList<>();
    final List<Path> gwtJavaFiles =
      collectJavaFiles( inputJavaDirectory, commonInputJavaDirectory, gwtOutputDirectory, gwtSourceDirectories );
    if ( !gwtJavaFiles.isEmpty() )
    {
      final Path output =
        javaCompileTest( gwtSourceDirectories, gwtJavaFiles, getWorkingDir().resolve( "target" ).resolve( "gwt" ) );
      if ( "true".equals( SystemProperty.get( "webtack.jsinterop-generator.gwtc" ) ) )
      {
        gwtc( collectLibs(), output );
      }
    }

    final List<Path> j2clSourceDirectories = new ArrayList<>();
    final List<Path> j2clJavaFiles =
      collectJavaFiles( inputJavaDirectory, commonInputJavaDirectory, j2clOutputDirectory, j2clSourceDirectories );
    final List<Path> j2clJsFiles =
      collectJsFiles( inputJsDirectory, commonInputJsDirectory, j2clOutputDirectory );
    if ( !j2clJavaFiles.isEmpty() )
    {
      javaCompileTest( j2clSourceDirectories, j2clJavaFiles, getWorkingDir().resolve( "target" ).resolve( "j2cl" ) );
      // Perform a j2cl compile here to simplify testing going forward
      if ( !j2clJsFiles.isEmpty() )
      {
        if ( "true".equals( SystemProperty.get( "webtack.jsinterop-generator.closure_compile" ) ) )
        {
          closureCompile( j2clJsFiles, getWorkingDir().resolve( "target" ).resolve( "j2cl" ).resolve( "js" ) );
        }
      }
    }
  }

  @Nonnull
  private List<Path> collectJsFiles( @Nonnull final Path inputJsDirectory,
                                     @Nonnull final Path commonInputJsDirectory,
                                     @Nonnull final Path outputDirectory )
    throws IOException
  {
    final Path mainJsDirectory = outputDirectory.resolve( "main" ).resolve( "js" );
    final List<Path> jsFiles =
      collectFilesWithExtension( ".js", mainJsDirectory )
        .stream()
        .filter( f -> !f.toString().endsWith( ".externs.fragment.js" ) )
        .collect( Collectors.toList() );
    if ( Files.exists( inputJsDirectory ) )
    {
      jsFiles.addAll( collectFilesWithExtension( ".js", inputJsDirectory )
                        .stream()
                        .filter( f -> !f.toString().endsWith( ".externs.fragment.js" ) )
                        .collect( Collectors.toList() ) );
    }
    if ( Files.exists( commonInputJsDirectory ) )
    {
      jsFiles.addAll( collectFilesWithExtension( ".js", commonInputJsDirectory )
                        .stream()
                        .filter( f -> !f.toString().endsWith( ".externs.fragment.js" ) )
                        .collect( Collectors.toList() ) );
    }
    return jsFiles;
  }

  @Nonnull
  private List<Path> collectJavaFiles( @Nonnull final Path inputJavaDirectory,
                                       @Nonnull final Path commonInputJavaDirectory,
                                       @Nonnull final Path outputDirectory,
                                       @Nonnull final List<Path> sourceDirectories )
    throws IOException
  {
    final Path mainJavaDirectory = outputDirectory.resolve( "main" ).resolve( "java" );
    sourceDirectories.add( mainJavaDirectory );
    final List<Path> javaFiles = new ArrayList<>( collectFilesWithExtension( ".java", mainJavaDirectory ) );

    final Path testJavaDirectory = outputDirectory.resolve( "test" ).resolve( "java" );
    if ( Files.exists( testJavaDirectory ) )
    {
      javaFiles.addAll( collectFilesWithExtension( ".java", testJavaDirectory ) );
      sourceDirectories.add( testJavaDirectory );
    }

    if ( Files.exists( inputJavaDirectory ) )
    {
      javaFiles.addAll( collectFilesWithExtension( ".java", inputJavaDirectory ) );
      sourceDirectories.add( inputJavaDirectory );
    }
    if ( Files.exists( commonInputJavaDirectory ) )
    {
      javaFiles.addAll( collectFilesWithExtension( ".java", commonInputJavaDirectory ) );
      sourceDirectories.add( commonInputJavaDirectory );
    }
    return javaFiles;
  }

  private void assertFilesMatch( @Nonnull final Path directory,
                                 @Nonnull final Path workingDirectory,
                                 @Nonnull final Path inputDirectory,
                                 @Nonnull final Set<Path> generatedFiles, final Path outputDirectory )
    throws IOException
  {
    for ( final Path file : generatedFiles )
    {
      // If it is not in the input path then it must be in output path
      final Path javaPath = outputDirectory.relativize( file );
      if ( !Files.exists( inputDirectory.resolve( javaPath ) ) )
      {
        final Path relativePath = workingDirectory.relativize( file );
        assertFileMatchesFixture( file, directory.resolve( relativePath ) );
      }
    }
  }

  @Nonnull
  private Set<Path> performJsinteropAction( @Nonnull final Path directory,
                                            @Nonnull final WebIDLSchema schema,
                                            @Nonnull final OutputType outputType,
                                            @Nonnull final String packageName,
                                            @Nullable final String globalInterface,
                                            @Nullable final List<String> gwtInherits,
                                            final boolean compileTest,
                                            @Nonnull final Path outputDirectory,
                                            @Nonnull final List<Path> predefinedTypeMappingPaths,
                                            @Nonnull final List<Path> externalTypeMappingPaths )
    throws Exception
  {
    final JsinteropActionFactory factory = new JsinteropActionFactory();
    factory.outputType = outputType;
    factory.packageName = packageName;
    factory.generateCompileTest = compileTest;
    factory.globalInterface = globalInterface;
    factory.gwtInherits = OutputType.gwt == outputType ? gwtInherits : null;
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
                                          @Nonnull final List<Path> predefinedSymbolCatalogPaths,
                                          @Nonnull final List<Path> additionalExternFragmentPaths )
    throws Exception
  {
    final ClosureActionFactory factory = new ClosureActionFactory();
    factory.outputDirectory = outputDirectory.toString();
    factory.packageName = packageName;
    factory.globalInterface = globalInterface;
    factory.predefinedSymbolCatalogs =
      predefinedSymbolCatalogPaths.stream().map( Path::toString ).collect( Collectors.toList() );
    factory.additionalExternFragments =
      additionalExternFragmentPaths.stream().map( Path::toString ).collect( Collectors.toList() );
    final Action action = factory.create( newPipelineContext( directory ) );
    action.process( schema );
    return ( (AbstractAction) action ).getGeneratedFiles();
  }

  private void closureCompile( @Nonnull final List<Path> jsFiles, @Nonnull final Path outputDirectory )
    throws Exception
  {
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

    assertEquals( JavaProcess.java( args ), 0 );
  }

  @Nonnull
  private Path javaCompileTest( @Nonnull final List<Path> javaSourceDirectories,
                                @Nonnull final List<Path> javaFiles,
                                @Nonnull final Path baseOutputDirectory )
    throws Exception
  {
    final List<Path> classpathEntries = collectLibs();
    final Path output = baseOutputDirectory.resolve( "classes" );
    JavaProcess.javac( javaFiles, classpathEntries, output );
    JavaProcess.javadoc( javaSourceDirectories,
                         javaFiles,
                         classpathEntries,
                         baseOutputDirectory.resolve( "javadoc" ) );
    return output;
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
    final List<Path> paths = new ArrayList<>();
    for ( final Path dir : dirs )
    {
      if ( dir.toFile().exists() )
      {
        Files
          .walk( dir )
          .filter( p -> p.toString().endsWith( extension ) )
          .forEach( paths::add );
      }
    }
    return paths;
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
