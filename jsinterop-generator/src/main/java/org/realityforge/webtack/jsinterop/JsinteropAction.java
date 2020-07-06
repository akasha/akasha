package org.realityforge.webtack.jsinterop;

import java.nio.file.Paths;
import java.util.Objects;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.tools.spi.Action;

final class JsinteropAction
  implements Action
{
  @Nonnull
  private final String _outputDirectory;
  @Nonnull
  private final String _packageName;

  JsinteropAction( @Nonnull final String outputDirectory, @Nonnull final String packageName )
  {
    _outputDirectory = Objects.requireNonNull( outputDirectory );
    _packageName = Objects.requireNonNull( packageName );
  }

  @Override
  public void process( @Nonnull final WebIDLSchema schema )
    throws Exception
  {
    final CodeGenContext context =
      new CodeGenContext( schema, Paths.get( _outputDirectory ), _packageName );
    new Generator().generate( context );
  }
}
