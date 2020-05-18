package org.realityforge.webtack.model.tools.repository.config;

import gir.io.FileUtil;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.AbstractTest;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class RepositoryConfigTest
  extends AbstractTest
{
  @Test
  public void load_emptyFile()
    throws Exception
  {
    final Path file = getWorkingDirectory().resolve( RepositoryConfig.FILENAME );
    FileUtil.write( file, "[]" );

    final RepositoryConfig repository = load( file, "\n[\n]\n" );

    assertEquals( repository.getConfigLocation(), file );
    assertTrue( repository.getSources().isEmpty() );
    assertNull( repository.findSourceByName( "notFound" ) );
  }

  @Test
  public void load_entryMissingName()
    throws Exception
  {
    final Path file = getWorkingDirectory().resolve( RepositoryConfig.FILENAME );
    FileUtil.write( file, "[{}]" );

    final IllegalConfigException exception =
      expectThrows( IllegalConfigException.class, () -> RepositoryConfig.load( file ) );

    assertEquals( exception.getMessage(), "Repository contains a source missing the name value" );
  }

  @Test
  public void load_completeEntry()
    throws Exception
  {
    final Path file = getWorkingDirectory().resolve( RepositoryConfig.FILENAME );
    final String content = "\n" +
                           "[\n" +
                           "    {\n" +
                           "        \"lastModifiedTime\": 1579594580000,\n" +
                           "        \"name\": \"speech_api\",\n" +
                           "        \"selector\": \"[data-level~=4.] ~ pre.idl\",\n" +
                           "        \"tags\": [\n" +
                           "            \"a\",\n" +
                           "            \"b\"\n" +
                           "        ],\n" +
                           "        \"url\": \"https://wicg.github.io/speech-api/\"\n" +
                           "    }\n" +
                           "]\n";
    FileUtil.write( file, content );

    final RepositoryConfig repository = load( file, content );

    assertEquals( repository.getConfigLocation(), file );
    final List<SourceConfig> sources = repository.getSources();
    assertEquals( sources.size(), 1 );
    final SourceConfig source = sources.get( 0 );
    assertEquals( source.getName(), "speech_api" );
    assertEquals( source.getSelector(), "[data-level~=4.] ~ pre.idl" );
    assertEquals( source.getUrl(), "https://wicg.github.io/speech-api/" );
    assertEquals( source.getLastModifiedTime(), 1579594580000L );
    final List<String> tags = source.getTags();
    assertNotNull( tags );
    assertEquals( tags.size(), 2 );
    assertTrue( tags.contains( "a" ) );
    assertTrue( tags.contains( "b" ) );

    assertNull( repository.findSourceByName( "notFound" ) );
    assertEquals( repository.findSourceByName( source.getName() ), source );
  }

  @Test
  public void load_minimalEntry()
    throws Exception
  {
    final Path file = getWorkingDirectory().resolve( RepositoryConfig.FILENAME );
    FileUtil.write( file, "[{\"name\": \"speech_api\"}]" );

    final String expectedOutput =
      "\n" +
      "[\n" +
      "    {\n" +
      "        \"lastModifiedTime\": 0,\n" +
      "        \"name\": \"speech_api\"\n" +
      "    }\n" +
      "]\n";
    final RepositoryConfig repository = load( file, expectedOutput );

    assertEquals( repository.getConfigLocation(), file );
    final List<SourceConfig> sources = repository.getSources();
    assertEquals( sources.size(), 1 );
    final SourceConfig source = sources.get( 0 );
    assertEquals( source.getName(), "speech_api" );
    assertNull( source.getSelector() );
    assertNull( source.getUrl() );
    assertEquals( source.getLastModifiedTime(), 0L );
    assertNull( source.getTags() );

    assertNull( repository.findSourceByName( "notFound" ) );
    assertEquals( repository.findSourceByName( source.getName() ), source );
  }

  @Test
  public void load_multipleEntries()
    throws Exception
  {
    final Path file = getWorkingDirectory().resolve( RepositoryConfig.FILENAME );
    final String expectedOutput =
      "\n" +
      "[\n" +
      "    {\n" +
      "        \"lastModifiedTime\": 0,\n" +
      "        \"name\": \"local\"\n" +
      "    },\n" +
      "    {\n" +
      "        \"lastModifiedTime\": 0,\n" +
      "        \"name\": \"speech_api\"\n" +
      "    },\n" +
      "    {\n" +
      "        \"lastModifiedTime\": 0,\n" +
      "        \"name\": \"webxr\"\n" +
      "    }\n" +
      "]\n";
    FileUtil.write( file,
                    "[\n" +
                    "  {\"name\": \"webxr\"},\n" +
                    "  {\"name\": \"local\"},\n" +
                    "  {\"name\": \"speech_api\"}\n" +
                    "]\n" );

    final RepositoryConfig repository = load( file, expectedOutput );

    assertEquals( repository.getConfigLocation(), file );
    final List<SourceConfig> sources = repository.getSources();
    assertEquals( sources.size(), 3 );
    assertEquals( sources.get( 0 ).getName(), "webxr" );
    assertEquals( sources.get( 1 ).getName(), "local" );
    assertEquals( sources.get( 2 ).getName(), "speech_api" );

    assertNull( repository.findSourceByName( "notFound" ) );
    assertEquals( repository.findSourceByName( "webxr" ), sources.get( 0 ) );
    assertEquals( repository.findSourceByName( "local" ), sources.get( 1 ) );
    assertEquals( repository.findSourceByName( "speech_api" ), sources.get( 2 ) );
  }

  @Nonnull
  private RepositoryConfig load( @Nonnull final Path file, @Nonnull final String expectedOutput )
    throws Exception
  {
    final Path outputDir = getWorkingDirectory().resolve( "output" );
    Files.createDirectories( outputDir );
    final RepositoryConfig config = RepositoryConfig.load( file );
    final Path outputFile = outputDir.resolve( file.getName( file.getNameCount() - 1 ) );
    RepositoryConfig.save( new RepositoryConfig( outputFile, new ArrayList<>( config.getSources() ) ) );
    final String actualOutput = new String( Files.readAllBytes( outputFile ), StandardCharsets.UTF_8 );
    assertEquals( actualOutput, expectedOutput );
    return config;
  }
}
