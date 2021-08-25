package org.realityforge.webtack.model.tools.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;

public final class JsonUtil
{
  private JsonUtil()
  {
  }

  public interface OutputHandler
  {
    void output( @Nonnull Jsonb jsonb, @Nonnull OutputStream outputStream )
      throws IOException;
  }

  public static void saveJson( @Nonnull final Path path, @Nonnull final OutputHandler handler )
    throws Exception
  {
    Files.createDirectories( path.getParent() );
    final JsonbConfig jsonbConfig = new JsonbConfig().withFormatting( true );
    final Jsonb jsonb = JsonbBuilder.create( jsonbConfig );
    try ( final FileOutputStream outputStream = new FileOutputStream( path.toFile() ) )
    {
      handler.output( jsonb, outputStream );
    }
    jsonb.close();
    // Strip leading new line and add trailing newline to json output
    final String newContent =
      Files.readAllLines( path ).stream().filter( s -> !s.isEmpty() ).collect( Collectors.joining( "\n" ) ) + "\n";
    Files.write( path, newContent.getBytes( StandardCharsets.UTF_8 ), StandardOpenOption.WRITE );

  }
}
