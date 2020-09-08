package org.realityforge.webtack.jsinterop;

import java.nio.file.Paths;
import java.util.stream.Stream;
import javax.annotation.Nonnull;
import javax.lang.model.SourceVersion;
import org.realityforge.webtack.model.tools.spi.Action;
import org.realityforge.webtack.model.tools.spi.ActionFactory;
import org.realityforge.webtack.model.tools.spi.Name;
import org.realityforge.webtack.model.tools.spi.PipelineContext;

@Name( "Jsinterop" )
public final class JsinteropActionFactory
  implements ActionFactory
{
  public String outputDirectory;
  public String packageName;
  public String globalInterface;
  public boolean generateGwtModule = true;
  public boolean generateTypeCatalog = true;
  public boolean enableMagicConstants = true;

  @Nonnull
  @Override
  public Action create( @Nonnull final PipelineContext context )
  {
    if ( null == outputDirectory )
    {
      throw new IllegalArgumentException( "Jsinterop missing required outputDirectory configuration value" );
    }
    if ( null == packageName )
    {
      throw new IllegalArgumentException( "Jsinterop missing required packageName configuration value" );
    }
    if ( packageName.isEmpty() )
    {
      throw new IllegalArgumentException( "Jsinterop supplied an invalid empty packageName configuration value" );
    }
    if ( Stream.of( packageName.split( "\\." ) ).anyMatch( e -> !SourceVersion.isName( e ) ) )
    {
      throw new IllegalArgumentException( "Jsinterop supplied an invalid packageName configuration value" );
    }
    return new JsinteropAction( Paths.get( outputDirectory ),
                                packageName,
                                globalInterface,
                                generateGwtModule,
                                generateTypeCatalog,
                                enableMagicConstants );
  }
}
