package org.realityforge.webtack.model.tools.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;

public final class FilesUtil
{
  private FilesUtil()
  {
  }

  public static void deleteDirectory( @Nonnull final Path directory )
    throws IOException
  {
    if ( Files.exists( directory ) )
    {
      final List<Path> pathsToDelete =
        Files
          .walk( directory )
          .sorted( Comparator.reverseOrder() )
          .collect( Collectors.toList() );
      for ( final Path path : pathsToDelete )
      {
        Files.delete( path );
      }
    }
  }
}
