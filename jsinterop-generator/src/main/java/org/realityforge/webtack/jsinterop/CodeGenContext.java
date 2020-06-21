package org.realityforge.webtack.jsinterop;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.TypeName;
import java.nio.file.Path;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.WebIDLSchema;

final class CodeGenContext
{
  @Nonnull
  private final WebIDLSchema _schema;
  @Nonnull
  private final Map<String, String> _typeMapping;
  @Nonnull
  private final Path _outputDirectory;
  @Nonnull
  private final String _packageName;

  CodeGenContext( @Nonnull final WebIDLSchema schema,
                  @Nonnull final Map<String, String> typeMapping,
                  @Nonnull final Path outputDirectory,
                  @Nonnull final String packageName )
  {
    _schema = Objects.requireNonNull( schema );
    _typeMapping = Objects.requireNonNull( typeMapping );
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
  public TypeName lookupTypeByName( @Nonnull final String name )
  {
    final String typeMapping = _typeMapping.get( name );
    // TODO: Cache ClassName in context?
    return null != typeMapping ? ClassName.bestGuess( typeMapping ) : getClassName( name );
  }

  @Nonnull
  public ClassName getClassName( @Nonnull final String name )
  {
    return ClassName.get( getPackageName(), name );
  }
}
