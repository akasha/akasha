package org.realityforge.webtack.model.tools.mdn_scanner.config;

import gir.io.FileUtil;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.AbstractTest;
import org.realityforge.webtack.model.tools.repository.config.IllegalConfigException;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class DocRepositoryConfigTest
  extends AbstractTest
{
  @Test
  public void load_emptyFile()
    throws Exception
  {
    final Path file = getWorkingDirectory().resolve( DocRepositoryConfig.FILENAME );
    FileUtil.write( file, "[]" );

    final DocRepositoryConfig repository = load( file, "\n[\n]\n" );

    assertEquals( repository.getConfigLocation(), file );
    assertTrue( repository.getSources().isEmpty() );
    assertNull( repository.findSourceByName( "notFound" ) );
  }

  @Test
  public void load_entryMissingName()
    throws Exception
  {
    final Path file = getWorkingDirectory().resolve( DocRepositoryConfig.FILENAME );
    FileUtil.write( file, "[{}]" );

    assertThrows( IllegalConfigException.class,
                  "DocRepository contains a source missing the name value",
                  () -> DocRepositoryConfig.load( file ) );
  }

  @Test
  public void load_singleEntry()
    throws Exception
  {
    final Path file = getWorkingDirectory().resolve( DocRepositoryConfig.FILENAME );
    final String content = "\n" +
                           "[\n" +
                           "    {\n" +
                           "        \"lastModifiedAt\": 1579594580000,\n" +
                           "        \"name\": \"XRInputSourcesChangeEvent\",\n" +
                           "        \"url\": \"https://developer.mozilla.org/en-US/docs/Web/API/XRInputSourcesChangeEvent\"\n" +
                           "    }\n" +
                           "]\n";
    FileUtil.write( file, content );

    final DocRepositoryConfig repository = load( file, content );

    assertEquals( repository.getConfigLocation(), file );
    final List<DocSourceConfig> sources = repository.getSources();
    assertEquals( sources.size(), 1 );
    final DocSourceConfig source = sources.get( 0 );
    assertEquals( source.getName(), "XRInputSourcesChangeEvent" );
    assertEquals( source.getUrl(), "https://developer.mozilla.org/en-US/docs/Web/API/XRInputSourcesChangeEvent" );
    assertEquals( source.getLastModifiedAt(), 1579594580000L );

    assertNull( repository.findSourceByName( "notFound" ) );
    assertEquals( repository.findSourceByName( source.getName() ), source );
  }

  @Test
  public void load_multipleEntries()
    throws Exception
  {
    final Path file = getWorkingDirectory().resolve( DocRepositoryConfig.FILENAME );
    final String content =
      "\n" +
      "[\n" +
      "    {\n" +
      "        \"lastModifiedAt\": 1579594580000,\n" +
      "        \"name\": \"XRInputSourcesChangeEvent\",\n" +
      "        \"url\": \"https://developer.mozilla.org/en-US/docs/Web/API/XRInputSourcesChangeEvent\"\n" +
      "    },\n" +
      "    {\n" +
      "        \"lastModifiedAt\": 1579594580000,\n" +
      "        \"name\": \"XRSession\",\n" +
      "        \"url\": \"https://developer.mozilla.org/en-US/docs/Web/API/XRSession\"\n" +
      "    }\n" +
      "]\n";
    FileUtil.write( file, content );

    final DocRepositoryConfig repository = load( file, content );

    assertEquals( repository.getConfigLocation(), file );
    final List<DocSourceConfig> sources = repository.getSources();
    assertEquals( sources.size(), 2 );
    assertEquals( sources.get( 0 ).getName(), "XRInputSourcesChangeEvent" );
    assertEquals( sources.get( 1 ).getName(), "XRSession" );

    assertNull( repository.findSourceByName( "notFound" ) );
    assertEquals( repository.findSourceByName( "XRInputSourcesChangeEvent" ), sources.get( 0 ) );
    assertEquals( repository.findSourceByName( "XRSession" ), sources.get( 1 ) );
  }

  @Nonnull
  private DocRepositoryConfig load( @Nonnull final Path file, @Nonnull final String expectedOutput )
    throws Exception
  {
    final Path outputDir = getWorkingDirectory().resolve( "output" );
    Files.createDirectories( outputDir );
    final DocRepositoryConfig config = DocRepositoryConfig.load( file );
    final Path outputFile = outputDir.resolve( file.getName( file.getNameCount() - 1 ) );
    DocRepositoryConfig.save( new DocRepositoryConfig( outputFile, new ArrayList<>( config.getSources() ) ) );
    final String actualOutput = new String( Files.readAllBytes( outputFile ), StandardCharsets.UTF_8 );
    assertEquals( actualOutput, expectedOutput );
    return config;
  }
}
