package org.realityforge.webtack.model.tools.pipeline;

import gir.io.FileUtil;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.AbstractTest;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.tools.pipeline.config.PipelineConfig;
import org.realityforge.webtack.model.tools.repository.config.RepositoryConfig;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class PipelineTest
  extends AbstractTest
{
  @Test
  public void processSchemas_singleSchemaProcessor()
    throws Exception
  {
    final TestProgressListener listener = new TestProgressListener();

    final Path output = getOutputFile( "%{name}" );
    final Pipeline pipeline =
      buildPipeline( "[{\"name\": \"speech_api\"},{\"name\": \"webxr\"}]",
                     "main",
                     "{\"stages\": [" +
                     "    {\n" +
                     "      \"name\": \"ExtractExposureSet\",\n" +
                     "      \"config\": {\n" +
                     "        \"globalInterface\": \"Window\"\n" +
                     "      }\n" +
                     "    },\n" +
                     "    {\n" +
                     "      \"name\": \"Emit\",\n" +
                     "      \"config\": {\n" +
                     "        \"filePattern\": \"" + output + "\"\n" +
                     "      }\n" +
                     "    }\n" +
                     "]}",
                     getIdlDirectory(),
                     listener );

    writeSchema( "speech_api",
                 "[Exposed=(Window,Other)]\n" +
                 "interface SpeechGrammar {\n" +
                 "  attribute DOMString src;\n" +
                 "  attribute float weight;\n" +
                 "};\n" +
                 "[Exposed=Worker]\n" +
                 "interface SpeechGrammar2 {\n" +
                 "  attribute DOMString src;\n" +
                 "  attribute float weight;\n" +
                 "};\n" );
    writeSchema( "webxr",
                 "[SecureContext, Exposed=Window]\n" +
                 "interface XRFrame {\n" +
                 "  [SameObject]\n" +
                 "  readonly attribute XRSession session;\n" +
                 "  XRPose? getPose( XRSpace space, XRSpace baseSpace );\n" +
                 "  XRViewerPose? getViewerPose( XRReferenceSpace referenceSpace );\n" +
                 "};\n" );

    final List<WebIDLSchema> schemas = pipeline.loadSchemas();

    assertEquals( listener.getTrace().size(), 3 );
    listener.assertContains( "onSourcesFiltered(main,[speech_api, webxr])" );
    listener.assertContains( "onSourceParsed(main,speech_api)" );
    listener.assertContains( "onSourceParsed(main,webxr)" );

    assertEquals( schemas.size(), 2 );

    pipeline.processSchemas( schemas );

    assertEquals( listener.getTrace().size(), 7 );
    listener.assertContains( "beforeStage(main,ExtractExposureSet), schemaCount=2" );
    listener.assertContains( "afterStage(main,ExtractExposureSet), schemaCount=2" );
    listener.assertContains( "beforeStage(main,Emit), schemaCount=2" );
    listener.assertContains( "afterStage(main,Emit), schemaCount=2" );

    final Path output1 = getOutputDirectory().resolve( "speech_api.webidl" );
    final Path output2 = getOutputDirectory().resolve( "webxr.webidl" );

    assertFileContents( output1,
                        "[Exposed=(Window,Other)]\n" +
                        "interface SpeechGrammar {\n" +
                        "  attribute DOMString src;\n" +
                        "  attribute float weight;\n" +
                        "};\n" );

    assertFileContents( output2,
                        "[SecureContext, Exposed=Window]\n" +
                        "interface XRFrame {\n" +
                        "  [SameObject]\n" +
                        "  readonly attribute XRSession session;\n" +
                        "  XRPose? getPose( XRSpace space, XRSpace baseSpace );\n" +
                        "  XRViewerPose? getViewerPose( XRReferenceSpace referenceSpace );\n" +
                        "};\n" );
  }

  @Test
  public void loadSchemas_sourceNotFetched()
    throws Exception
  {
    final TestProgressListener listener = new TestProgressListener();

    final String pipelineName = "main";
    final Pipeline pipeline =
      buildPipeline( "[{\"name\": \"speech_api\"}]", pipelineName, "{\"stages\": []}", getIdlDirectory(), listener );

    final SourceNotFetchedException exception =
      expectThrows( SourceNotFetchedException.class, pipeline::loadSchemas );

    listener.assertContains( "onSourcesFiltered(main,[speech_api])" );

    assertEquals( exception.getPipeline(), pipeline.getConfig() );
    assertEquals( exception.getSource().getName(), "speech_api" );
  }

  @Test
  public void loadSchemas_badFormatSource()
    throws Exception
  {
    final TestProgressListener listener = new TestProgressListener();

    final Pipeline pipeline =
      buildPipeline( "[{\"name\": \"speech_api\"}]", "main", "{\"stages\": []}", getIdlDirectory(), listener );

    writeSchema( "speech_api", "interface BadData" );

    final InvalidFormatException exception =
      expectThrows( InvalidFormatException.class, pipeline::loadSchemas );

    listener.assertContains( "onSourcesFiltered(main,[speech_api])" );

    assertEquals( exception.getPipeline(), pipeline.getConfig() );
    assertEquals( exception.getSource().getName(), "speech_api" );
    assertEquals( exception.getErrors().get( 0 ).getLine(), 1 );
    assertEquals( exception.getErrors().get( 0 ).getCharPositionInLine(), 17 );
    assertEquals( exception.getErrors().get( 0 ).getMessage(), "no viable alternative at input '<EOF>'" );
  }

  @Test
  public void loadSchemas_IOErrorReadingSource()
    throws Exception
  {
    final TestProgressListener listener = new TestProgressListener();

    final Pipeline pipeline =
      buildPipeline( "[{\"name\": \"speech_api\"}]", "main", "{\"stages\": []}", getIdlDirectory(), listener );

    final Path sourceFile = writeSchema( "speech_api", "" );

    // Write only. Should result in error attempting to read
    Files.setPosixFilePermissions( sourceFile, Collections.singleton( PosixFilePermission.OWNER_WRITE ) );

    final SourceIOException exception = expectThrows( SourceIOException.class, pipeline::loadSchemas );

    listener.assertContains( "onSourcesFiltered(main,[speech_api])" );

    assertEquals( exception.getPipeline(), pipeline.getConfig() );
    assertEquals( exception.getSource().getName(), "speech_api" );
  }

  @Test
  public void loadSchema_singleSchema()
    throws Exception
  {
    final TestProgressListener listener = new TestProgressListener();

    final Pipeline pipeline =
      buildPipeline( "[{\"name\": \"speech_api\"}]", "main", "{\"stages\": []}", getIdlDirectory(), listener );

    writeSchema( "speech_api", "" );

    final List<WebIDLSchema> schemas = pipeline.loadSchemas();

    listener.assertContains( "onSourcesFiltered(main,[speech_api])" );
    listener.assertContains( "onSourceParsed(main,speech_api)" );

    assertEquals( schemas.size(), 1 );
    final Set<String> tags = schemas.get( 0 ).getTags();
    assertEquals( tags.size(), 1 );
    assertTrue( tags.contains( "name=speech_api" ) );
  }

  @Test
  public void loadSchema_mergedTags()
    throws Exception
  {
    final TestProgressListener listener = new TestProgressListener();

    final Pipeline pipeline =
      buildPipeline( "[{\"name\": \"speech_api\", \"tags\":[\"z\", \"a\"]}]",
                     "main",
                     "{\"stages\": []}",
                     getIdlDirectory(),
                     listener );

    writeSchema( "speech_api", "" );

    final List<WebIDLSchema> schemas = pipeline.loadSchemas();

    listener.assertContains( "onSourcesFiltered(main,[speech_api])" );
    listener.assertContains( "onSourceParsed(main,speech_api)" );

    assertEquals( schemas.size(), 1 );
    final Set<String> tags = schemas.get( 0 ).getTags();
    assertEquals( tags.size(), 3 );
    assertTrue( tags.contains( "name=speech_api" ) );
    assertTrue( tags.contains( "a" ) );
    assertTrue( tags.contains( "z" ) );
  }

  @Test
  public void loadSchema_multipleSchema()
    throws Exception
  {
    final TestProgressListener listener = new TestProgressListener();

    final Pipeline pipeline =
      buildPipeline( "[{\"name\": \"speech_api\"},{\"name\": \"webxr\"}]",
                     "main",
                     "{\"stages\": []}",
                     getIdlDirectory(),
                     listener );

    writeSchema( "speech_api", "" );
    writeSchema( "webxr", "" );

    final List<WebIDLSchema> schemas = pipeline.loadSchemas();

    listener.assertContains( "onSourcesFiltered(main,[speech_api, webxr])" );
    listener.assertContains( "onSourceParsed(main,speech_api)" );
    listener.assertContains( "onSourceParsed(main,webxr)" );

    assertEquals( schemas.size(), 2 );
  }

  @Nonnull
  public Pipeline buildPipeline( final String repositoryContent,
                                 final String pipelineName,
                                 final String pipelineContent,
                                 final Path idlDirectory,
                                 final TestProgressListener listener )
    throws Exception
  {
    final RepositoryConfig repository = loadRepositoryConfig( repositoryContent );
    final PipelineConfig config = loadPipelineConfig( pipelineName, pipelineContent );

    return createPipeline( repository, config, idlDirectory, listener );
  }

  @Nonnull
  public Pipeline createPipeline( @Nonnull final RepositoryConfig repository,
                                  @Nonnull final PipelineConfig config,
                                  @Nonnull final Path idlDirectory,
                                  @Nonnull final TestProgressListener listener )
  {
    return new Pipeline( repository, config, new ExecutionContext( idlDirectory, listener ) );
  }

  @Nonnull
  private PipelineConfig loadPipelineConfig( @Nonnull final String name, @Nonnull final String content )
    throws Exception
  {
    final Path pipelineFile = getWorkingDirectory().resolve( name + ".json" );
    FileUtil.write( pipelineFile, content );
    return PipelineConfig.load( pipelineFile );
  }

  @Nonnull
  private RepositoryConfig loadRepositoryConfig( @Nonnull final String content )
    throws Exception
  {
    final Path repositoryFile = getWorkingDirectory().resolve( RepositoryConfig.FILENAME );
    FileUtil.write( repositoryFile, content );
    return RepositoryConfig.load( repositoryFile );
  }
}
