package org.realityforge.webtack.jsinterop;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
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
  public List<String> predefinedTypeMapping;
  public List<String> externalTypeMapping;
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

    final List<Path> predefinedTypeMappingPaths = new ArrayList<>();
    if ( null != predefinedTypeMapping )
    {
      for ( final String typeCatalog : predefinedTypeMapping )
      {
        final Path catalog = Paths.get( typeCatalog );
        if ( !Files.exists( catalog ) )
        {
          throw new IllegalArgumentException( "React4j action configuration specified a file that does not exist " +
                                              "in the predefinedTypeMapping parameter: " + catalog );
        }
        else if ( !Files.isRegularFile( catalog ) )
        {
          throw new IllegalArgumentException( "React4j action configuration specified a file that is not a regular " +
                                              "file in the predefinedTypeMapping parameter: " + catalog );
        }
        predefinedTypeMappingPaths.add( catalog );
      }
    }

    final List<Path> externalTypeMappingPaths = new ArrayList<>();
    if ( null != externalTypeMapping )
    {
      for ( final String typeCatalog : externalTypeMapping )
      {
        final Path catalog = Paths.get( typeCatalog );
        if ( !Files.exists( catalog ) )
        {
          throw new IllegalArgumentException( "React4j action configuration specified a file that does not exist " +
                                              "in the externalTypeMapping parameter: " + catalog );
        }
        else if ( !Files.isRegularFile( catalog ) )
        {
          throw new IllegalArgumentException( "React4j action configuration specified a file that is not a regular " +
                                              "file in the externalTypeMapping parameter: " + catalog );
        }
        externalTypeMappingPaths.add( catalog );
      }
    }
    return new JsinteropAction( context,
                                Paths.get( outputDirectory ),
                                packageName,
                                globalInterface,
                                predefinedTypeMappingPaths,
                                externalTypeMappingPaths,
                                generateGwtModule,
                                generateTypeCatalog,
                                enableMagicConstants );
  }
}
