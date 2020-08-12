package org.realityforge.webtack.model.tools.mdn_scanner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.tools.mdn_scanner.config2.DocIndex;
import org.realityforge.webtack.model.tools.mdn_scanner.config2.EntryIndex;
import org.realityforge.webtack.model.tools.mdn_scanner.config2.IndexException;
import org.realityforge.webtack.model.tools.mdn_scanner.config2.IndexIOException;

public final class DocRepositoryRuntime
{
  @Nonnull
  private final Map<String, DocIndex> _indexes = new HashMap<>();
  @Nonnull
  private final Map<String, DocEntry> _cache = new HashMap<>();
  @Nonnull
  private final Set<String> _negativeCache = new HashSet<>();
  @Nonnull
  private final Path _dataDirectory;

  public DocRepositoryRuntime( @Nonnull final Path dataDirectory )
  {
    _dataDirectory = Objects.requireNonNull( dataDirectory );
  }

  @Nonnull
  public Set<String> findTypes()
  {
    try
    {
      return Files
        .list( _dataDirectory )
        .filter( Files::isDirectory )
        .filter( p -> Files.exists( p.resolve( DocIndex.FILENAME ) ) )
        .map( Path::getFileName )
        .map( Path::toString )
        .collect( Collectors.toSet() );
    }
    catch ( final IOException ignored )
    {
      return Collections.emptySet();
    }
  }

  @Nullable
  public DocEntry findDocEntry( @Nonnull final String name )
  {
    final DocEntry entry = _cache.get( name );
    if ( null != entry )
    {
      return entry;
    }
    else if ( _negativeCache.contains( name ) )
    {
      return null;
    }
    else
    {
      final String[] parts = name.split( "\\." );
      final DocIndex index = findIndexForType( parts[ 0 ] );
      if ( null == index )
      {
        _negativeCache.add( name );
        return null;
      }
      else
      {
        final EntryIndex entryIndex = index.findEntry( 1 == parts.length ? "__type__" : parts[ 1 ] );
        if ( null == entryIndex )
        {
          _negativeCache.add( name );
          return null;
        }
        else
        {
          return getDocEntry( entryIndex );
        }
      }
    }
  }

  public void removeEntry( @Nonnull final EntryIndex entryIndex )
    throws IndexException
  {
    final String qualifiedName = entryIndex.getQualifiedName();
    final Path path = getDocEntryPath( entryIndex );
    try
    {
      Files.deleteIfExists( path );
    }
    catch ( final IOException ioe )
    {
      throw new IndexIOException( "Error removing " + path + " for entry " + qualifiedName, ioe );
    }
    _cache.remove( qualifiedName );
    _negativeCache.remove( qualifiedName );
    entryIndex.remove();
  }

  @Nonnull
  public DocEntry getDocEntry( @Nonnull final EntryIndex entryIndex )
  {
    final DocEntry entry = findDocEntry( entryIndex );
    assert null != entry;
    return entry;
  }

  @Nullable
  public DocEntry findDocEntry( @Nonnull final EntryIndex entryIndex )
  {
    final String name = entryIndex.getDocIndex().getName() + "." + entryIndex.getName();
    final Path path = getDocEntryPath( name );
    final DocEntry entry = tryLoadDocEntry( path );
    if ( null != entry )
    {
      _cache.put( name, entry );
    }
    return entry;
  }

  @Nullable
  private DocEntry tryLoadDocEntry( @Nonnull final Path path )
  {
    if ( Files.exists( path ) )
    {
      try
      {
        return DocEntry.load( path );
      }
      catch ( final Exception e )
      {
        //TODO: Log error message here
        return null;
      }
    }
    else
    {
      return null;
    }
  }

  /**
   * Attempt to save the specified DocEntry.
   * The
   *
   * @param entry the DocEntry to save.
   * @return true if the entry has changed and thus the entry was saved.
   * @throws Exception if an error occurs saving the entry.
   */
  public boolean save( @Nonnull final DocEntry entry, final long modifiedAt )
    throws Exception
  {
    final String name = entry.getName();
    _cache.put( name, entry );
    _negativeCache.remove( name );
    final Path output = getDocEntryPath( name );
    final Path tmpOutput = asTmpTarget( output );
    DocEntry.save( entry, tmpOutput );
    if ( Files.exists( output ) && doFileContentsMatch( output, tmpOutput ) )
    {
      Files.delete( tmpOutput );
      return false;
    }
    else
    {
      updateIndex( entry, modifiedAt );
      Files.move( tmpOutput, output, StandardCopyOption.REPLACE_EXISTING );
      return true;
    }
  }

  private void updateIndex( @Nonnull final DocEntry entry, final long modifiedAt )
    throws IndexException
  {
    final String[] parts = entry.getName().split( "\\." );
    final DocIndex index = findOrCreateIndexForType( parts[ 0 ] );
    final EntryIndex entryIndex = index.findOrCreateEntry( 1 == parts.length ? "__type__" : parts[ 1 ] );
    entryIndex.setLastModifiedAt( modifiedAt );
    index.save();
  }

  @Nonnull
  private Path getDocEntryPath( @Nonnull final String qualifiedName )
  {
    final String[] parts = qualifiedName.split( "\\." );
    return _dataDirectory.resolve( parts[ 0 ] ).resolve( ( 1 == parts.length ? "__type__" : parts[ 1 ] ) + ".json" );
  }

  @Nonnull
  private Path asTmpTarget( @Nonnull final Path target )
  {
    return target.getParent().resolve( target.getName( target.getNameCount() - 1 ) + ".tmp" + "" );
  }

  private boolean doFileContentsMatch( @Nonnull final Path path1, @Nonnull final Path path2 )
    throws IOException
  {
    final byte[] path1Bytes = Files.readAllBytes( path1 );
    final byte[] path2Bytes = Files.readAllBytes( path2 );
    if ( path1Bytes.length == path2Bytes.length )
    {
      for ( int i = 0; i < path1Bytes.length; i++ )
      {
        if ( path1Bytes[ i ] != path2Bytes[ i ] )
        {
          return false;
        }
      }
      return true;
    }
    else
    {
      return false;
    }
  }

  @Nonnull
  public Path getDocEntryPath( @Nonnull final EntryIndex entryIndex )
  {
    return _dataDirectory.resolve( entryIndex.getDocIndex().getName() ).resolve( entryIndex.getName() + ".json" );
  }

  @Nonnull
  public DocIndex findOrCreateIndexForType( @Nonnull final String name )
    throws IndexException
  {
    final DocIndex index = _indexes.get( name );
    if ( null != index )
    {
      return index;
    }
    else
    {
      final DocIndex newIndex = DocIndex.open( _dataDirectory.resolve( name ) );
      _indexes.put( name, newIndex );
      return newIndex;
    }
  }

  @Nullable
  public DocIndex findIndexForType( @Nonnull final String name )
    throws IndexException
  {
    final DocIndex index = _indexes.get( name );
    if ( null != index )
    {
      return index;
    }
    else
    {
      final Path path = _dataDirectory.resolve( name );
      if ( Files.exists( path.resolve( DocIndex.FILENAME ) ) )
      {
        final DocIndex newIndex = DocIndex.open( path );
        _indexes.put( name, newIndex );
        return newIndex;
      }
      else
      {
        return null;
      }
    }
  }
}
