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
  private final Map<String, String> _idlToJavaTypeMapping = new HashMap<>();
  // Maps idlName -> JavaPoet TypeName
  @Nonnull
  private final Map<String, ClassName> _idlToClassNameMapping = new HashMap<>();

  protected AbstractJavaAction( @Nonnull final Path outputDirectory, @Nonnull final String packageName )
  {
    _outputDirectory = Objects.requireNonNull( outputDirectory );
    _packageName = Objects.requireNonNull( packageName );
  }

  /**
   * Register a mapping from the specified idl type to the specified java type.
   * If a mapping already exists then generate an error.
   *
   * @param idlType  the idle type. This is the name of the definition or the name of one of the predefined types.
   * @param javaType the java type to associated with the idl type.
   * @throws IllegalStateException if a mapping already exists for idlName.
   */
  protected void registerIdlToJavaTypeMapping( @Nonnull final String idlType, @Nonnull final String javaType )
  {
    if ( !tryRegisterIdlToJavaTypeMapping( idlType, javaType ) )
    {
      throw new IllegalStateException( "IDL Type '" + idlType + "' already mapped to java type '" +
                                       _idlToJavaTypeMapping.get( idlType ) + "' unable to map to '" + javaType + "'" );
    }
  }

  /**
   * Register a mapping from the specified idl type to the specified java type if no type mapping for the idl type exists.
   *
   * @param idlType  the idle type. This is the name of the definition or the name of one of the predefined types.
   * @param javaType the java type to associated with the idl type.
   * @return true if type mapping successfully registered, false if there was already a mapping.
   */
  protected boolean tryRegisterIdlToJavaTypeMapping( @Nonnull final String idlType, @Nonnull final String javaType )
  {
    final String existingJavaType = _idlToJavaTypeMapping.get( idlType );
    if ( null != existingJavaType )
    {
      return false;
    }
    else
    {
      _idlToJavaTypeMapping.put( idlType, javaType );
      return true;
    }
  }

  @Nonnull
  protected String lookupJavaType( @Nonnull final String idlType )
  {
    return _idlToJavaTypeMapping.computeIfAbsent( idlType, t -> _packageName + "." + idlType );
  }

  @Nonnull
  protected Map<String, String> getIdlToJavaTypeMapping()
  {
    return _idlToJavaTypeMapping;
  }

  protected void processInit()
  {
    _idlToJavaTypeMapping.clear();
    _idlToClassNameMapping.clear();
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

  protected void writeTopLevelType( @Nonnull final TypeSpec.Builder type )
    throws IOException
  {
    writeTopLevelType( null, type );
  }

  protected void writeTopLevelType( @Nullable final String idlName, @Nonnull final TypeSpec.Builder type )
    throws IOException
  {
    final Path outputDirectory = getMainJavaDirectory();
    final TypeSpec typeSpec = type.build();
    final String qualifiedName =
      null != idlName ? _idlToJavaTypeMapping.get( idlName ) : _packageName + "." + typeSpec.name;
    if ( null == qualifiedName )
    {
      throw new IllegalStateException( "Qualified java name missing for IDL type '" + idlName + "'" );
    }
    assert !_generatedFiles.containsKey( qualifiedName );
    _generatedFiles.put( qualifiedName,
                         outputDirectory.resolve( qualifiedName.replaceAll( "\\.", File.separator ) + ".java" ) );
    JavaFile
      .builder( ClassName.bestGuess( qualifiedName ).packageName(), typeSpec )
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
  protected String getPackageName()
  {
    return _packageName;
  }

  @Nonnull
  protected Map<String, Path> getGeneratedFiles()
  {
    return Collections.unmodifiableMap( _generatedFiles );
  }

  @Nonnull
  protected ClassName lookupClassName( @Nonnull final String idlName )
  {
    return _idlToClassNameMapping.computeIfAbsent( idlName, this::createClassName );
  }

  @Nonnull
  protected ClassName createClassName( @Nonnull final String idlName )
  {
    return ClassName.bestGuess( lookupJavaType( idlName ) );
  }
}
