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
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import org.realityforge.webtack.model.tools.io.FilesUtil;

public final class DocIndex
{
  @Nonnull
  public static final String FILENAME = "__index__.json";
  @Nonnull
  private final String _name;
  @Nonnull
  private final Path _directory;
  @Nonnull
  private final DocIndexContent _content;

  DocIndex( @Nonnull final String name, @Nonnull final Path directory, @Nonnull final DocIndexContent content )
  {
    _name = Objects.requireNonNull( name );
    _directory = Objects.requireNonNull( directory );
    _content = Objects.requireNonNull( content );
    for ( final EntryIndex entry : _content.getEntries() )
    {
      if ( null == entry.getName() )
      {
        throw new IndexFormatException( "DocIndex at " + _directory + " contains an entry missing the name value" );
      }
      entry.setDocIndex( this );
    }
  }

  @Nonnull
  public String getName()
  {
    return _name;
  }

  @Nonnull
  public Path getDirectory()
  {
    return _directory;
  }

  @Nonnull
  public DocIndexContent getContent()
  {
    return _content;
  }

  @Nonnull
  public List<EntryIndex> getEntries()
  {
    return getContent().getEntries();
  }

  public void removeEntry( @Nonnull final EntryIndex entry )
    throws IndexSaveException
  {
    final List<EntryIndex> entries = getEntries();
    entries.remove( entry );
    if ( entries.remove( entry ) )
    {
      save();
    }
  }

  public void remove()
    throws IndexSaveException
  {
    getEntries().clear();
    try
    {
      FilesUtil.deleteDirectory( _directory );
    }
    catch ( final IOException ioe )
    {
      throw new IndexSaveException( this, ioe );
    }
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
      entry.setDocIndex( this );
      entry.setName( name );
      entry.setLastModifiedAt( 0 );
      getEntries().add( entry );
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
  public static DocIndex open( @Nonnull final Jsonb jsonb, @Nonnull final Path directory )
    throws IndexException
  {
    return Files.exists( directory.resolve( FILENAME ) ) ? load( jsonb, directory ) : create( directory );
  }

  @Nonnull
  private static DocIndex create( @Nonnull final Path directory )
  {
    final DocIndexContent content = new DocIndexContent();
    final String name = directory.getFileName().toString();
    content.setName( name );
    content.setLastModifiedAt( 0 );
    content.setEntries( new ArrayList<>() );
    return new DocIndex( directory.getFileName().toString(), directory, content );
  }

  @Nonnull
  private static DocIndex load( @Nonnull final Jsonb jsonb, @Nonnull final Path directory )
    throws IndexException
  {
    final Path path = directory.resolve( FILENAME );
    try ( final InputStream inputStream = new FileInputStream( path.toFile() ) )
    {
      final DocIndexContent content = jsonb.fromJson( inputStream, DocIndexContent.class );
      return new DocIndex( content.getName(), directory, content );
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
      final DocIndexContent content = index.getContent();
      final List<EntryIndex> entries = content.getEntries();
      entries.sort( Comparator.comparing( EntryIndex::getName ) );
      try ( final FileOutputStream outputStream = new FileOutputStream( path.toFile() ) )
      {
        jsonb.toJson( content, outputStream );
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
