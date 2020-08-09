package org.realityforge.webtack.model.tools.mdn_scanner.config2;

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

public final class DocIndexTest
  extends AbstractTest
{
  @Test
  public void load_emptyFile()
    throws Exception
  {
    final Path directory = getWorkingDirectory();
    FileUtil.write( directory.resolve( DocIndex.FILENAME ), "[]" );

    final DocIndex repository = load( directory, "\n[\n]\n" );

    assertEquals( repository.getDirectory(), directory );
    assertTrue( repository.getEntries().isEmpty() );
    assertNull( repository.findEntry( "notFound" ) );
  }

  @Test
  public void load_entryMissingName()
    throws Exception
  {
    final Path directory = getWorkingDirectory();
    final Path path = directory.resolve( DocIndex.FILENAME );
    FileUtil.write( path, "[{}]" );

    assertThrows( IndexFormatException.class,
                  "DocIndex at " + path + " contains an entry missing the name value",
                  () -> DocIndex.open( directory ) );
  }

  @Test
  public void load_singleEntry()
    throws Exception
  {
    final Path directory = getWorkingDirectory();
    final String content = "\n" +
                           "[\n" +
                           "    {\n" +
                           "        \"name\": \"__type__\",\n" +
                           "        \"lastModifiedAt\": 1579594580000\n" +
                           "    }\n" +
                           "]\n";
    FileUtil.write( directory.resolve( DocIndex.FILENAME ), content );

    final DocIndex repository = load( directory, content );

    assertEquals( repository.getDirectory(), directory );
    final List<EntryIndex> sources = repository.getEntries();
    assertEquals( sources.size(), 1 );
    final EntryIndex entry = sources.get( 0 );
    assertEquals( entry.getName(), "__type__" );
    assertEquals( entry.getLastModifiedAt(), 1579594580000L );

    assertNull( repository.findEntry( "notFound" ) );
    assertEquals( repository.findEntry( entry.getName() ), entry );
  }

  @Test
  public void load_multipleEntries()
    throws Exception
  {
    final Path directory = getWorkingDirectory();
    final String content =
      "\n" +
      "[\n" +
      "    {\n" +
      "        \"name\": \"__type__\",\n" +
      "        \"lastModifiedAt\": 1579594580000\n" +
      "    },\n" +
      "    {\n" +
      "        \"name\": \"onfocus\",\n" +
      "        \"lastModifiedAt\": 1579594580000\n" +
      "    }\n" +
      "]\n";
    FileUtil.write( directory.resolve( DocIndex.FILENAME ), content );

    final DocIndex repository = load( directory, content );

    assertEquals( repository.getDirectory(), directory );
    final List<EntryIndex> entries = repository.getEntries();
    assertEquals( entries.size(), 2 );
    assertEquals( entries.get( 0 ).getName(), "__type__" );
    assertEquals( entries.get( 1 ).getName(), "onfocus" );

    assertNull( repository.findEntry( "notFound" ) );
    assertEquals( repository.findEntry( "__type__" ), entries.get( 0 ) );
    assertEquals( repository.findEntry( "onfocus" ), entries.get( 1 ) );
  }

  @Nonnull
  private DocIndex load( @Nonnull final Path directory, @Nonnull final String expectedOutput )
    throws Exception
  {
    final Path outputDir = getWorkingDirectory().resolve( "output" );
    final DocIndex index = DocIndex.open( directory );
    final Path outputFile = outputDir.resolve( DocIndex.FILENAME );
    DocIndex.save( new DocIndex( outputDir, new ArrayList<>( index.getEntries() ) ) );
    final String actualOutput = new String( Files.readAllBytes( outputFile ), StandardCharsets.UTF_8 );
    assertEquals( actualOutput, expectedOutput );
    return index;
  }
}
