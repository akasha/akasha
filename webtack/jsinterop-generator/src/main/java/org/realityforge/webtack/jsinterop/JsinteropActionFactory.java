package org.realityforge.webtack.jsinterop;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
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
   * The expected consumer of the generate classes. There are slightly different strategies depending on whether
   * the code is being generated for GWT or J2CL consumers.
   */
  @Nonnull
  public OutputType outputType = OutputType.gwt;
  /**
   * The base directory in which to generate code.
   */
  @Nullable
  public String outputDirectory;
  /**
   * The base package under which to generate code.
   */
  @Nullable
  public String packageName;
  /**
   * A list of files that list types that are predefined.
   * Each file contains lines of the form: "[idl_type_name]=[qualified java class name]"
   */
  @Nullable
  public List<String> predefinedTypeMapping;
  /**
   * A list of files that override the name of the generated java class for an idl type.
   * Each file contains lines of the form: "[idl_type_name]=[qualified java class name]"
   */
  @Nullable
  public List<String> externalTypeMapping;
  /**
   * A list of inherits to add to the generated to the generated gwt module.
   */
  @Nullable
  public List<String> gwtInherits;
  /**
   * A flag controlling whether java classes are generated that reference
   * and invoke the generated classes. If the outputType is j2cl then a
   * closure module is generated that requires modules for these java classes.
   * This is used to help perform GWT or J2cl+closure compiler pass over generated
   * code to ensure that the artifacts will compile and type check correctly.
   */
  public boolean generateCompileTest = true;
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
  @Nullable
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
      if ( OutputType.j2cl != outputType && !extraClosureModulesToRequireInCompileTest.isEmpty() )
      {
        throw new IllegalArgumentException( "Jsinterop action configuration did not specify 'j2cl' outputType " +
                                            "but specified values in the extraClosureModulesToRequireInCompileTest " +
                                            "configuration: " + extraClosureModulesToRequireInCompileTest );
      }
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

    if ( OutputType.gwt != outputType && ( null != gwtInherits && !gwtInherits.isEmpty() ) )
    {
      throw new IllegalArgumentException( "Jsinterop action configuration did not specify 'gwt' outputType " +
                                          "but specified values in the gwtInherits configuration: " + gwtInherits );
    }
    return new JsinteropAction( context,
                                outputType,
                                Paths.get( outputDirectory ),
                                packageName,
                                predefinedTypeMappingPaths,
                                externalTypeMappingPaths,
                                extraClosureModulesToRequireInCompileTestPaths,
                                generateCompileTest,
                                null == gwtInherits ? Collections.emptyList() : gwtInherits,
                                generateTypeMapping,
                                generateGlobal,
                                enableMagicConstants );
  }
}
