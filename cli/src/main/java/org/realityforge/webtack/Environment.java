package org.realityforge.webtack;

import java.io.Console;
import java.nio.file.Path;
import java.util.Objects;
import java.util.logging.Logger;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.tools.repository.config.SourceConfig;

final class Environment
{
  @Nonnull
  private Path _currentDirectory;
  @Nonnull
  private final Logger _logger;
  @Nullable
  private Path _repositoryConfigFile;
  @Nullable
  private Command _command;

  Environment( @Nonnull final Path currentDirectory, @Nonnull final Logger logger )
  {
    _currentDirectory = Objects.requireNonNull( currentDirectory );
    _logger = Objects.requireNonNull( logger );
  }

  public void setCurrentDirectory( @Nonnull final Path currentDirectory )
  {
    _currentDirectory = Objects.requireNonNull( currentDirectory );
  }

  @Nonnull
  Path currentDirectory()
  {
    return _currentDirectory;
  }

  @Nonnull
  Logger logger()
  {
    return _logger;
  }

  boolean hasRepositoryConfigFile()
  {
    return null != _repositoryConfigFile;
  }

  @Nonnull
  Path webidlDirectory()
  {
    return currentDirectory().resolve( "idl" );
  }

  @Nonnull
  Path getPathForSource( @Nonnull final SourceConfig source )
  {
    return webidlDirectory().resolve( source.getName() + WebIDLSchema.EXTENSION );
  }

  @Nonnull
  Path getRepositoryConfigFile()
  {
    assert null != _repositoryConfigFile;
    return _repositoryConfigFile;
  }

  void setRepositoryConfigFile( @Nullable final Path repositoryConfigFile )
  {
    _repositoryConfigFile = repositoryConfigFile;
  }

  boolean hasCommand()
  {
    return null != _command;
  }

  @Nonnull
  Command getCommand()
  {
    assert null != _command;
    return _command;
  }

  void setCommand( @Nonnull final Command command )
  {
    _command = Objects.requireNonNull( command );
  }
}
