package org.realityforge.webtack;

import java.io.Console;
import java.nio.file.Path;
import java.util.Objects;
import java.util.logging.Logger;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

final class Environment
{
  @Nullable
  private final Console _console;
  @Nonnull
  private Path _currentDirectory;
  @Nonnull
  private final Logger _logger;
  @Nullable
  private Path _configFile;
  @Nullable
  private Command _command;

  Environment( @Nullable final Console console, @Nonnull final Path currentDirectory, @Nonnull final Logger logger )
  {
    _console = console;
    _currentDirectory = Objects.requireNonNull( currentDirectory );
    _logger = Objects.requireNonNull( logger );
  }

  @Nullable
  Console console()
  {
    return _console;
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

  boolean hasConfigFile()
  {
    return null != _configFile;
  }

  @Nonnull
  Path getConfigFile()
  {
    assert null != _configFile;
    return _configFile;
  }

  void setConfigFile( @Nullable final Path configFile )
  {
    _configFile = configFile;
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
