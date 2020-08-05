package org.realityforge.webtack.model.tools.mdn_scanner;

import java.nio.file.Files;
import java.nio.file.Path;
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
    final Path path = getDataFileLocation( config );
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

  @Nonnull
  public Path getDataFileLocation( @Nonnull final DocSourceConfig config )
  {
    final String name = config.getName();
    final String[] parts = name.split( "\\." );
    return _dataDirectory.resolve( parts[ 0 ] ).resolve( ( 1 == parts.length ? "__type__" : parts[ 1 ] ) + ".json" );
  }
}
