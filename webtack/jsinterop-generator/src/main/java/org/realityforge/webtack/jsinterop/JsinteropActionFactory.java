package org.realityforge.webtack.jsinterop;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
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
  /**
   * The base directory in which to generate code.
   */
  public String outputDirectory;
  /**
   * The base package under which to generate code.
   */
  public String packageName;
  /**
   * The global interface expected for generated library.
   * If this is specified, then only types that are exposed
   * on that global interface are present in generated output.
   */
  public String globalInterface;
  /**
   * A list of files that list types that are predefined.
   * Each file contains lines of the form: "[idl_type_name]=[qualified java class name]"
   */
  public List<String> predefinedTypeMapping;
  /**
   * A list of files that override the name of the generated java class for an idl type.
   * Each file contains lines of the form: "[idl_type_name]=[qualified java class name]"
   */
  public List<String> externalTypeMapping;
  /**
   * A list of inherits to add to the generated to the generated gwt module.
   */
  public List<String> gwtInherits;
  /**
   * A flag controlling whether the gwt module descriptor is generated.
   */
  public boolean generateGwtModule = true;
  /**
   * A flag controlling whether a closure module is generated that
   * requires modules that j2cl will generate. This is used to help
   * perform J2cl+closure compiler pass over generated code to ensure
   * that the correct artifacts are generated.
   */
  public boolean generateJ2clCompileTest = true;
  /**
   * A flag controlling whether the type mapping file is generated.
   * The type mapping file consists of a line for every generated class and
   * each line is of the form "[idl_type_name]=[qualified java class name]".
   * This is designed to be passed in to the "externalTypeMapping" of other
   * "Jsinterop" actions.
   */
  public boolean generateTypeMapping = true;
  /**
   * A flag controlling whether the Global type should be generated. It will only be present if
   * mixins with the extended attribute [GlobalObject]
   */
  public boolean generateGlobal = true;
  /**
   * Should the generated code emit @MagicConstant annotations to improve usability
   * in IntelliJ IDEA and related IDEs.
   */
  public boolean enableMagicConstants = true;
  /**
   * A list of files that override the name of closure modules to include in compile test.
   * Each file contains one closure module per lilne
   */
  public List<String> extraClosureModulesToRequireInCompileTest;

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
          throw new IllegalArgumentException( "Jsinterop action configuration specified a file that does not exist " +
                                              "in the predefinedTypeMapping parameter: " + catalog );
        }
        else if ( !Files.isRegularFile( catalog ) )
        {
          throw new IllegalArgumentException( "Jsinterop action configuration specified a file that is not a regular " +
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
          throw new IllegalArgumentException( "Jsinterop action configuration specified a file that does not exist " +
                                              "in the externalTypeMapping parameter: " + catalog );
        }
        else if ( !Files.isRegularFile( catalog ) )
        {
          throw new IllegalArgumentException( "Jsinterop action configuration specified a file that is not a regular " +
                                              "file in the externalTypeMapping parameter: " + catalog );
        }
        externalTypeMappingPaths.add( catalog );
      }
    }
    final List<Path> extraClosureModulesToRequireInCompileTestPaths = new ArrayList<>();
    if ( null != extraClosureModulesToRequireInCompileTest )
    {
      for ( final String typeCatalog : extraClosureModulesToRequireInCompileTest )
      {
        final Path file = Paths.get( typeCatalog );
        if ( !Files.exists( file ) )
        {
          throw new IllegalArgumentException( "Jsinterop action configuration specified a file that does not exist " +
                                              "in the extraClosureModulesToRequireInCompileTest parameter: " + file );
        }
        else if ( !Files.isRegularFile( file ) )
        {
          throw new IllegalArgumentException( "Jsinterop action configuration specified a file that is not a regular " +
                                              "file in the extraClosureModulesToRequireInCompileTest parameter: " +
                                              file );
        }
        extraClosureModulesToRequireInCompileTestPaths.add( file );
      }
    }

    return new JsinteropAction( context,
                                Paths.get( outputDirectory ),
                                packageName,
                                globalInterface,
                                predefinedTypeMappingPaths,
                                externalTypeMappingPaths,
                                extraClosureModulesToRequireInCompileTestPaths,
                                generateGwtModule,
                                generateJ2clCompileTest,
                                null == gwtInherits ? Collections.emptyList() : gwtInherits,
                                generateTypeMapping,
                                generateGlobal,
                                enableMagicConstants );
  }
}
