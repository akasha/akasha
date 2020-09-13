package org.realityforge.webtack.react4j;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
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
  public List<String> typeCatalogs;
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
    final List<Path> typeCatalogPaths = new ArrayList<>();
    if ( null != typeCatalogs )
    {
      for ( final String typeCatalog : typeCatalogs )
      {
        final Path catalog = Paths.get( typeCatalog );
        if ( !Files.exists( catalog ) )
        {
          throw new IllegalArgumentException( "Jsinterop action was supplied an invalid type " +
                                              "catalog that does not exist: " + catalog );
        }
        else if ( !Files.isRegularFile( catalog ) )
        {
          throw new IllegalArgumentException( "Jsinterop action was supplied an invalid type " +
                                              "catalog that is not a regular file: " + catalog );
        }
        typeCatalogPaths.add( catalog );
      }
    }
    return new React4jAction( Paths.get( outputDirectory ),
                              packageName,
                              typeCatalogPaths,
                              generateGwtModule,
                              enableMagicConstants );
  }
}
