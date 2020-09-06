package org.realityforge.webtack.react4j;

import java.nio.file.Paths;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.spi.Action;
import org.realityforge.webtack.model.tools.spi.ActionFactory;
import org.realityforge.webtack.model.tools.spi.Name;
import org.realityforge.webtack.model.tools.spi.PipelineContext;

@Name( "React4j" )
public final class React4jActionFactory
  implements ActionFactory
{
  public String outputDirectory;
  public String packageName;
  public boolean generateGwtModule = true;
  public boolean enableMagicConstants = true;

  @Nonnull
  @Override
  public Action create( @Nonnull final PipelineContext context )
  {
    if ( null == outputDirectory )
    {
      throw new IllegalArgumentException( "React4j missing required outputDirectory configuration value" );
    }
    if ( null == packageName )
    {
      throw new IllegalArgumentException( "React4j missing required packageName configuration value" );
    }
    return new React4jAction( Paths.get( outputDirectory ), packageName, generateGwtModule, enableMagicConstants );
  }
}
