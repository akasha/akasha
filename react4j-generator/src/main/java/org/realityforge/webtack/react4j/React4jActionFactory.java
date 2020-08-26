package org.realityforge.webtack.react4j;

import java.nio.file.Paths;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.spi.Action;
import org.realityforge.webtack.model.tools.spi.ActionFactory;
import org.realityforge.webtack.model.tools.spi.Name;

@Name( "React4j" )
public final class React4jActionFactory
  implements ActionFactory
{
  public String outputDirectory;
  public String packageName;
  public String factoryName;
  public boolean generateGwtModule = true;

  @Nonnull
  @Override
  public Action create()
  {
    if ( null == outputDirectory )
    {
      throw new IllegalArgumentException( "React4j missing required outputDirectory configuration value" );
    }
    if ( null == packageName )
    {
      throw new IllegalArgumentException( "React4j missing required packageName configuration value" );
    }
    return new React4jAction( Paths.get( outputDirectory ), packageName, factoryName, generateGwtModule );
  }
}