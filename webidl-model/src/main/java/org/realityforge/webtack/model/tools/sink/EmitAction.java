package org.realityforge.webtack.model.tools.sink;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.WebIDLWriter;
import org.realityforge.webtack.model.tools.spi.Action;

final class EmitAction
  implements Action
{
  @Nonnull
  static final String NAME = "Emit";
  @Nonnull
  private final String _filePattern;

  EmitAction( @Nonnull final String filePattern )
  {
    _filePattern = Objects.requireNonNull( filePattern );
  }

  @Override
  public void process( @Nonnull final WebIDLSchema schema )
    throws Exception
  {
    final Path path = Paths.get( getFilename( schema ) );
    final Path dir = path.getParent();
    if ( Files.notExists( dir ) )
    {
      Files.createDirectories( dir );
    }
    try ( final FileWriter writer = new FileWriter( path.toFile() ) )
    {
      WebIDLWriter.writeSchema( writer, schema );
    }
  }

  @Nonnull
  private String getFilename( @Nonnull final WebIDLSchema schema )
  {
    final Pattern pattern = Pattern.compile( "(%\\{([^)]+)})" );
    final Matcher matcher = pattern.matcher( _filePattern );
    final StringBuffer filename = new StringBuffer();
    while ( matcher.find() )
    {
      final String key = matcher.group( 2 );
      final String prefix = key + '=';
      final Set<String> tags = schema.getTags();
      final String value = tags
        .stream()
        .filter( s -> s.startsWith( prefix ) )
        .map( s -> s.substring( prefix.length() ) )
        .findAny()
        .orElse( null );
      if ( null == value )
      {
        throw new IllegalStateException( "Attempting to generate filename from pattern '" + _filePattern +
                                         "' for schema looking for key '" + key +
                                         "' in tags: " + tags );
      }
      matcher.appendReplacement( filename, value );
    }
    matcher.appendTail( filename );

    return filename.toString();
  }
}
