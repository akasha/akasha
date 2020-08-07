package org.realityforge.webtack.model.tools.mdn_scanner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.tools.mdn_scanner.config.DocRepositoryConfig;
import org.realityforge.webtack.model.tools.mdn_scanner.config.DocSourceConfig;

public final class DocRepositoryRuntime
{
  @Nonnull
  private final DocRepositoryConfig _repository;
  @Nonnull
  private final Map<String, DocEntry> _cache = new HashMap<>();
  @Nonnull
  private final Set<String> _negativeCache = new HashSet<>();
  @Nonnull
  private final Path _dataDirectory;

  public DocRepositoryRuntime( @Nonnull final DocRepositoryConfig repository, @Nonnull final Path dataDirectory )
  {
    _repository = Objects.requireNonNull( repository );
    _dataDirectory = Objects.requireNonNull( dataDirectory );
  }

  @Nonnull
  DocRepositoryConfig getRepository()
  {
    return _repository;
  }

  @Nullable
  public DocEntry getDocEntry( @Nonnull final String name )
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
      final DocSourceConfig config = _repository.findSourceByName( name );
      if ( null == config )
      {
        _negativeCache.add( name );
        return null;
      }
      else
      {
        final DocEntry docEntry = getDocEntry( config );
        if ( null == docEntry )
        {
          _negativeCache.add( name );
        }
        else
        {
          _cache.put( name, docEntry );
        }
        return docEntry;
      }
    }
  }

  @Nullable
  private DocEntry getDocEntry( @Nonnull final DocSourceConfig config )
  {
    final Path path = getDocEntryPath( config );
    try
    {
      return Files.exists( path ) ? DocEntry.load( path ) : null;
    }
    catch ( final Exception e )
    {
      //TODO: Log error message here
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
  public boolean save( @Nonnull final DocEntry entry )
    throws Exception
  {
    final Path output = getDocEntryPath( entry );
    final Path tmpOutput = asTmpTarget( output );
    DocEntry.save( entry, tmpOutput );
    if ( Files.exists( output ) && doFileContentsMatch( output, tmpOutput ) )
    {
      Files.delete( tmpOutput );
      return false;
    }
    else
    {
      Files.move( tmpOutput, output, StandardCopyOption.REPLACE_EXISTING );
      return true;
    }
  }

  @Nonnull
  private Path getDocEntryPath( @Nonnull final DocEntry entry )
  {
    return getDocEntryPath( entry.getName() );
  }

  @Nonnull
  private Path getDocEntryPath( final String name )
  {
    final String[] parts = name.split( "\\." );
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
  public Path getDocEntryPath( @Nonnull final DocSourceConfig config )
  {
    return getDocEntryPath( config.getName() );
  }
}
