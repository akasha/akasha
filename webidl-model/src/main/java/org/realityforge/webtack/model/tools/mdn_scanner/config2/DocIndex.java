package org.realityforge.webtack.model.tools.mdn_scanner.config2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;

public final class DocIndex
{
  @Nonnull
  public static final String FILENAME = "__index__.json";
  @Nonnull
  private final Path _directory;
  @Nonnull
  private final List<EntryIndex> _entries;

  DocIndex( @Nonnull final Path directory, @Nonnull final List<EntryIndex> entries )
  {
    _directory = Objects.requireNonNull( directory );
    _entries = Objects.requireNonNull( entries );
    for ( final EntryIndex entry : _entries )
    {
      entry.setDocIndex( this );
    }
  }

  @Nonnull
  public Path getDirectory()
  {
    return _directory;
  }

  @Nonnull
  public List<EntryIndex> getEntries()
  {
    return _entries;
  }

  @Nullable
  public EntryIndex findEntry( @Nonnull final String name )
  {
    return getEntries().stream().filter( s -> Objects.equals( s.getName(), name ) ).findAny().orElse( null );
  }

  /**
   * Find or create a EntryIndex for specified name.
   *
   * @param name the name of the Entry.
   * @return a EntryIndex that was either looked up or created.
   * @throws IndexSaveException if there was an error saving the index after the entry was created.
   */
  @Nonnull
  public EntryIndex findOrCreateEntry( @Nonnull final String name )
    throws IndexSaveException
  {
    EntryIndex entry = findEntry( name );
    if ( null == entry )
    {
      entry = new EntryIndex();
      entry.setName( name );
      entry.setLastModifiedAt( 0 );
      _entries.add( entry );
      save();
    }
    return entry;
  }

  public void save()
    throws IndexSaveException
  {
    DocIndex.save( this );
  }

  @Nonnull
  public static DocIndex open( @Nonnull final Path directory )
    throws IndexException
  {
    return Files.exists( directory.resolve( FILENAME ) ) ? load( directory ) : create( directory );
  }

  @Nonnull
  private static DocIndex create( @Nonnull final Path directory )
  {
    return new DocIndex( directory, new ArrayList<>() );
  }

  @Nonnull
  private static DocIndex load( @Nonnull final Path directory )
    throws IndexException
  {
    final Path path = directory.resolve( FILENAME );
    try ( final InputStream inputStream = new FileInputStream( path.toFile() ) )
    {
      final List<EntryIndex> entries =
        JsonbBuilder.create().fromJson( inputStream, new ArrayList<EntryIndex>()
        {
        }.getClass().getGenericSuperclass() );
      for ( final EntryIndex entry : entries )
      {
        if ( null == entry.getName() )
        {
          throw new IndexFormatException( "DocIndex at " + path + " contains an entry missing the name value" );
        }
      }
      return new DocIndex( directory, entries );
    }
    catch ( final IOException ioe )
    {
      throw new IndexIOException( "Error reading index at " + path, ioe );
    }
  }

   static void save( @Nonnull final DocIndex index )
    throws IndexSaveException
  {
    try
    {
      final Path directory = index.getDirectory();
      Files.createDirectories( directory );
      final JsonbConfig jsonbConfig = new JsonbConfig().withFormatting( true );
      final Jsonb jsonb = JsonbBuilder.create( jsonbConfig );
      final Path path = directory.resolve( FILENAME );
      try ( final FileOutputStream outputStream = new FileOutputStream( path.toFile() ) )
      {
        jsonb.toJson( index.getEntries()
                        .stream()
                        .sorted( Comparator.comparing( EntryIndex::getName ) )
                        .collect( Collectors.toList() ),
                      outputStream );
      }
      jsonb.close();
      // Add newline as json output omits trailing new line
      Files.write( path, new byte[]{ '\n' }, StandardOpenOption.APPEND );
    }
    catch ( final Exception e )
    {
      throw new IndexSaveException( index, e );
    }
  }
}
