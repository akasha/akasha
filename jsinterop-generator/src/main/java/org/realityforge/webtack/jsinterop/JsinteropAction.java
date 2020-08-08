package org.realityforge.webtack.jsinterop;

import java.nio.file.Paths;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.tools.spi.Action;

final class JsinteropAction
  implements Action
{
  @Nonnull
  private final String _outputDirectory;
  @Nonnull
  private final String _packageName;
  @Nullable
  private final String _globalInterface;
  private final boolean _generateGwtModule;

  JsinteropAction( @Nonnull final String outputDirectory,
                   @Nonnull final String packageName,
                   @Nullable final String globalInterface,
                   final boolean generateGwtModule )
  {
    _outputDirectory = Objects.requireNonNull( outputDirectory );
    _packageName = Objects.requireNonNull( packageName );
    _globalInterface = globalInterface;
    _generateGwtModule = generateGwtModule;
  }

  @Override
  public void process( @Nonnull final WebIDLSchema schema )
    throws Exception
  {
    final CodeGenContext context =
      new CodeGenContext( schema, Paths.get( _outputDirectory ), _packageName, _globalInterface, _generateGwtModule );
    new Generator().generate( context );
  }
}
