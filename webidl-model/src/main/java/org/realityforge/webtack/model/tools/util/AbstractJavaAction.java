package org.realityforge.webtack.model.tools.util;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.lang.model.SourceVersion;
import org.realityforge.webtack.model.tools.spi.Action;

public abstract class AbstractJavaAction
  implements Action
{
  @Nonnull
  private static final List<String> OBJECT_METHODS =
    Arrays.asList( "hashCode", "equals", "clone", "toString", "finalize", "getClass", "wait", "notifyAll", "notify" );
  @Nonnull
  private final Path _outputDirectory;
  @Nonnull
  private final String _packageName;
  // Maps Classname -> Path of source file
  @Nonnull
  private final Map<String, Path> _generatedFiles = new HashMap<>();
  // Maps idlName -> Qualified Java Name of output
  @Nonnull
  private final Map<String, String> _typeToJavaMapping = new HashMap<>();

  protected AbstractJavaAction( @Nonnull final Path outputDirectory, @Nonnull final String packageName )
  {
    _outputDirectory = Objects.requireNonNull( outputDirectory );
    _packageName = Objects.requireNonNull( packageName );
  }

  @Nonnull
  protected Map<String, String> getTypeToJavaMapping()
  {
    return _typeToJavaMapping;
  }

  protected void processInit()
  {
    _generatedFiles.clear();
  }

  @Nonnull
  protected String safeName( @Nonnull final String name )
  {
    return isNameJavaSafe( name ) ? name : mangleName( name );
  }

  @Nonnull
  protected String safeMethodName( @Nonnull final String name )
  {
    return isMethodNameJavaSafe( name ) ? name : mangleName( name );
  }

  @Nonnull
  protected String safeJsPropertyMethodName( @Nonnull final String name )
  {
    if ( "is".equals( name ) )
    {
      // This method is a work around for a bug in GWTs validation of properties
      // https://github.com/gwtproject/gwt/issues/9703
      return "_" + name;
    }
    else
    {
      return isMethodNameJavaSafe( name ) ? name : mangleName( name );
    }
  }

  protected boolean isMethodNameJavaSafe( @Nonnull final String name )
  {
    return isNameJavaSafe( name ) && !OBJECT_METHODS.contains( name );
  }

  private boolean isNameJavaSafe( @Nonnull final String name )
  {
    return SourceVersion.isName( name );
  }

  @Nonnull
  private String mangleName( @Nonnull final String name )
  {
    return Character.isUnicodeIdentifierStart( name.charAt( 0 ) ) ? name + "_" : "_" + name;
  }

  @Nonnull
  protected Path getOutputDirectory()
  {
    return _outputDirectory;
  }

  @Nonnull
  protected Path getMainJavaDirectory()
  {
    return getOutputDirectory().resolve( "main" ).resolve( "java" );
  }

  @Nonnull
  protected Path getMainResourcesDirectory()
  {
    return getOutputDirectory().resolve( "main" ).resolve( "resources" );
  }

  private Path getPackageDirectory( @Nonnull final Path baseDirectory, @Nonnull final String packageName )
  {
    return packageName.isEmpty() ?
           baseDirectory :
           baseDirectory.resolve( packageName.replaceAll( "\\.", File.separator ) );
  }

  protected void writeResourceFile( @Nonnull final Path baseDirectory,
                                    @Nonnull final String name,
                                    @Nonnull final byte[] content )
    throws IOException
  {
    final Path path = getPackageDirectory( baseDirectory, _packageName ).resolve( name );
    final String qualifiedName = _packageName + "." + name;
    assert !_generatedFiles.containsKey( qualifiedName );
    _generatedFiles.put( qualifiedName, path );

    final Path parent = path.getParent();
    if ( !Files.exists( parent ) )
    {
      Files.createDirectories( parent );
    }
    Files.write( path, content, StandardOpenOption.CREATE_NEW );
  }

  @Nonnull
  protected String getLeafPackageName()
  {
    return _packageName.replaceAll( ".*\\.([^.]+)$", "$1" );
  }

  protected void writeTopLevelType( @Nullable final String idlName, @Nonnull final TypeSpec.Builder type )
    throws IOException
  {
    writeTopLevelType( idlName, type, null );
  }

  protected void writeTopLevelType( @Nullable final String idlName,
                                    @Nonnull final TypeSpec.Builder type,
                                    @Nullable final String namespace )
    throws IOException
  {
    final Path outputDirectory = getMainJavaDirectory();
    final TypeSpec typeSpec = type.build();
    final String packageName = derivePackage( namespace );
    final String name = typeSpec.name;
    final Path path = getPackageDirectory( getMainJavaDirectory(), packageName ).resolve( name + ".java" );
    final String qualifiedName = packageName + "." + name;
    assert !_generatedFiles.containsKey( qualifiedName );
    _generatedFiles.put( qualifiedName, path );
    if ( null != idlName )
    {
      _typeToJavaMapping.put( idlName, qualifiedName );
    }
    JavaFile
      .builder( packageName, typeSpec )
      .skipJavaLangImports( true )
      .build()
      .writeTo( outputDirectory );
  }

  protected final void writeGeneratedAnnotation( @Nonnull final TypeSpec.Builder builder )
  {
    writeGeneratedAnnotation( builder, "org.realityforge.webtack" );
  }

  @SuppressWarnings( "SameParameterValue" )
  private void writeGeneratedAnnotation( @Nonnull final TypeSpec.Builder builder,
                                         @Nonnull final String generatorClassName )
  {
    final Class<?> generated = GeneratedAnnotationUtil.getGeneratedAnnotation();
    if ( null != generated )
    {
      builder.addAnnotation( AnnotationSpec.builder( ClassName.get( generated ) )
                               .addMember( "value", "$S", generatorClassName )
                               .build() );
    }
  }

  @Nonnull
  protected String derivePackage( @Nullable final String subPackage )
  {
    return _packageName + ( null == subPackage ? "" : "." + NamingUtil.underscore( subPackage ) );
  }

  @Nonnull
  protected String getPackageName()
  {
    return _packageName;
  }

  @Nonnull
  protected Map<String, Path> getGeneratedFiles()
  {
    return Collections.unmodifiableMap( _generatedFiles );
  }
}
