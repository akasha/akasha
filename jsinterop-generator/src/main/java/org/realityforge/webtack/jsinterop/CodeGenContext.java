package org.realityforge.webtack.jsinterop;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.EnumerationDefinition;
import org.realityforge.webtack.model.WebIDLSchema;

final class CodeGenContext
{
  @Nonnull
  private final WebIDLSchema _schema;
  @Nonnull
  private final Map<String, ClassName> _typeMapping = new HashMap<>();
  @Nonnull
  private final Path _outputDirectory;
  @Nonnull
  private final String _packageName;
  // Maps Classname -> Path of source file
  @Nonnull
  private final Map<String, Path> _generatedSourceFiles = new HashMap<>();

  CodeGenContext( @Nonnull final WebIDLSchema schema,
                  @Nonnull final Path outputDirectory,
                  @Nonnull final String packageName )
  {
    _schema = Objects.requireNonNull( schema );
    _outputDirectory = Objects.requireNonNull( outputDirectory );
    _packageName = Objects.requireNonNull( packageName );
  }

  @Nonnull
  WebIDLSchema getSchema()
  {
    return _schema;
  }

  @Nonnull
  Path getOutputDirectory()
  {
    return _outputDirectory;
  }

  @Nonnull
  Path getMainJavaDirectory()
  {
    return getOutputDirectory().resolve( "main" ).resolve( "java" );
  }

  @Nonnull
  String getPackageName()
  {
    return _packageName;
  }

  @Nonnull
  TypeName lookupTypeByName( @Nonnull final String name )
  {
    final ClassName existing = _typeMapping.get( name );
    if ( null != existing )
    {
      return existing;
    }
    else
    {
      final ClassName className = getClassName( name );
      _typeMapping.put( name, className );
      return className;
    }
  }

  void writeTopLevelType( @Nonnull final TypeSpec.Builder type )
    throws IOException
  {
    final Path outputDirectory = getMainJavaDirectory();
    final TypeSpec typeSpec = type.build();
    final String packageName = getPackageName();
    final String name = typeSpec.name;
    Path path = outputDirectory;
    if ( !packageName.isEmpty() )
    {
      path = outputDirectory.resolve( packageName.replaceAll( "\\.", File.separator ) );
    }
    path = path.resolve( name + ".java" );
    final String qualifiedName = packageName + "." + name;
    assert !_generatedSourceFiles.containsKey( qualifiedName );
    _generatedSourceFiles.put( qualifiedName, path );
    JavaFile
      .builder( packageName, typeSpec )
      .skipJavaLangImports( true )
      .build()
      .writeTo( outputDirectory );
  }

  @Nonnull
  Map<String, Path> getGeneratedSourceFiles()
  {
    return Collections.unmodifiableMap( _generatedSourceFiles );
  }

  @Nonnull
  private ClassName getClassName( @Nonnull final String name )
  {
    final EnumerationDefinition enumeration = getSchema().findEnumerationByName( name );
    if ( null != enumeration )
    {
      return Types.STRING;
    }
    return ClassName.get( getPackageName(), name );
  }
}
