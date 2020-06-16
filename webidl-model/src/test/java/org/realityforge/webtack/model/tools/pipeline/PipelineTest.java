package org.realityforge.webtack.model.tools.pipeline;

import gir.io.FileUtil;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Collections;
import java.util.List;
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
