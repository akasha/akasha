package org.realityforge.webtack.closure;

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

@Name( "Closure" )
public final class ClosureActionFactory
  implements ActionFactory
{
  public String outputDirectory;
  public String key = "schema";
  public String globalInterface;
  public List<String> predefinedTypeCatalogs;
  public boolean generateTypeCatalog = true;

  @Nonnull
  @Override
  public Action create( @Nonnull final PipelineContext context )
  {
    if ( null == outputDirectory )
    {
      throw new IllegalArgumentException( "Closure missing required outputDirectory configuration value" );
    }

    final List<Path> predefinedTypeCatalogPaths = new ArrayList<>();
    if ( null != predefinedTypeCatalogs )
    {
      for ( final String typeCatalog : predefinedTypeCatalogs )
      {
        final Path catalog = Paths.get( typeCatalog );
        if ( !Files.exists( catalog ) )
        {
          throw new IllegalArgumentException( "Closure action configuration specified a file that does not exist " +
                                              "in the predefinedTypeCatalogs parameter: " + catalog );
        }
        else if ( !Files.isRegularFile( catalog ) )
        {
          throw new IllegalArgumentException( "Closure action configuration specified a file that is not a regular " +
                                              "file in the predefinedTypeCatalogs parameter: " + catalog );
        }
        predefinedTypeCatalogPaths.add( catalog );
      }
    }

    return new ClosureAction( context,
                              Paths.get( outputDirectory ),
                              key,
                              globalInterface,
                              predefinedTypeCatalogPaths,
                              generateTypeCatalog );
  }
}
