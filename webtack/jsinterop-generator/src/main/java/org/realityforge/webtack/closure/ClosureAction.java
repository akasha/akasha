package org.realityforge.webtack.closure;

import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.CallbackDefinition;
import org.realityforge.webtack.model.CallbackInterfaceDefinition;
import org.realityforge.webtack.model.ConstEnumerationDefinition;
import org.realityforge.webtack.model.DictionaryDefinition;
import org.realityforge.webtack.model.EnumerationDefinition;
import org.realityforge.webtack.model.InterfaceDefinition;
import org.realityforge.webtack.model.Kind;
import org.realityforge.webtack.model.NamespaceDefinition;
import org.realityforge.webtack.model.PartialInterfaceDefinition;
import org.realityforge.webtack.model.Type;
import org.realityforge.webtack.model.TypedefDefinition;
import org.realityforge.webtack.model.UnionType;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.tools.io.FilesUtil;
import org.realityforge.webtack.model.tools.spi.PipelineContext;
import org.realityforge.webtack.model.tools.util.AbstractAction;

final class ClosureAction
  extends AbstractAction
{
  @Nonnull
  private final String _key;
  @Nullable
  private final String _globalInterface;
  private final boolean _generateTypeCatalog;
  @Nonnull
  private final List<String> _predefinedTypes = new ArrayList<>();
  @Nonnull
  private final Set<String> _generatedTypes = new HashSet<>();

  ClosureAction( @Nonnull final PipelineContext context,
                 @Nonnull final Path outputDirectory,
                 @Nonnull final String key,
                 @Nullable final String globalInterface,
                 @Nonnull final List<Path> predefinedTypeCatalogPaths,
                 final boolean generateTypeCatalog )
  {
    super( context, outputDirectory );
    _key = Objects.requireNonNull( key );
    _globalInterface = globalInterface;
    _generateTypeCatalog = generateTypeCatalog;
    for ( final Path predefinedTypeCatalog : predefinedTypeCatalogPaths )
    {
      try
      {
        Files.readAllLines( predefinedTypeCatalog )
          .stream()
          .map( String::trim )
          .filter( String::isEmpty )
          .forEach( _predefinedTypes::add );
      }
      catch ( final IOException ioe )
      {
        throw new IllegalStateException( "Failed to read predefined type catalog " + predefinedTypeCatalog,
                                         ioe );
      }
    }
  }

  @Nonnull
  Path getMainJsDirectory()
  {
    return getOutputDirectory().resolve( "main" ).resolve( "js" );
  }

  @Nonnull
  Path getMainResourcesDirectory()
  {
    return getOutputDirectory().resolve( "main" ).resolve( "resources" );
  }

  boolean tryRecordGeneratedType( @Nonnull final String name )
  {
    return !_predefinedTypes.contains( name ) && _generatedTypes.add( name );
  }

  @Override
  public void process( @Nonnull final WebIDLSchema schema )
    throws Exception
  {
    processInit( schema );

    FilesUtil.deleteDirectory( getMainJsDirectory() );

    try ( final Writer writer = openWriter( getMainJsDirectory().resolve( _key + ".externs.js" ) ) )
    {
      writer.write( "/**\n * @externs\n */\n" );
      for ( final TypedefDefinition definition : schema.getTypedefs() )
      {
        final Type type = definition.getType();
        if ( Kind.Union == type.getKind() && tryRecordGeneratedType( definition.getName() ) )
        {
          final UnionType unionType = (UnionType) type;
          generateUnion( writer, definition.getName(), unionType );
        }
      }
      for ( final CallbackDefinition definition : schema.getCallbacks() )
      {
        if ( tryRecordGeneratedType( definition.getName() ) )
        {
          generateCallback( writer, definition );
        }
      }
      for ( final CallbackInterfaceDefinition definition : schema.getCallbackInterfaces() )
      {
        if ( tryRecordGeneratedType( definition.getName() ) )
        {
          generateCallbackInterface( writer, definition );
        }
      }
      for ( final DictionaryDefinition definition : schema.getDictionaries() )
      {
        if ( tryRecordGeneratedType( definition.getName() ) )
        {
          generateDictionary( writer, definition );
        }
      }
      for ( final EnumerationDefinition definition : schema.getEnumerations() )
      {
        if ( tryRecordGeneratedType( definition.getName() ) )
        {
          generateEnumeration( writer, definition );
        }
      }
      for ( final ConstEnumerationDefinition definition : schema.getConstEnumerations() )
      {
        if ( tryRecordGeneratedType( definition.getName() ) )
        {
          generateConstEnumeration( definition );
        }
      }
      for ( final InterfaceDefinition definition : schema.getInterfaces() )
      {
        if ( tryRecordGeneratedType( definition.getName() ) )
        {
          generateInterface( writer, definition );
        }
      }
      for ( final PartialInterfaceDefinition definition : schema.getPartialInterfaces() )
      {
        if ( tryRecordGeneratedType( definition.getName() ) )
        {
          generatePartialInterface( writer, definition );
        }
      }
      for ( final NamespaceDefinition definition : schema.getNamespaces() )
      {
        if ( tryRecordGeneratedType( definition.getName() ) )
        {
          generateNamespace( definition );
        }
      }

      if ( null != _globalInterface )
      {
        // Should we define externs for globalThis.X, window.X and X ?
      }
    }

    if ( _generateTypeCatalog )
    {
      writeTypeCatalog();
    }
  }

  private void generateNamespace( @Nonnull final NamespaceDefinition definition )
  {

  }

  private void generateConstEnumeration( @Nonnull final ConstEnumerationDefinition definition )
    throws IOException
  {
  }

  private void writeTypeCatalog()
    throws IOException
  {
    final String content =
      _generatedTypes
        .stream()
        .sorted()
        .collect( Collectors.joining( "\n" ) ) + "\n";
    writeFile( getMainResourcesDirectory().resolve( _key + ".types" ),
               content.getBytes( StandardCharsets.UTF_8 ) );
  }

  private void generateCallback( @Nonnull final Writer writer, @Nonnull final CallbackDefinition definition )
    throws IOException
  {
  }

  private void generateCallbackInterface( @Nonnull final Writer writer,
                                          @Nonnull final CallbackInterfaceDefinition definition )
    throws IOException
  {
  }

  private void generateEnumeration( @Nonnull final Writer writer, @Nonnull final EnumerationDefinition definition )
    throws IOException
  {
  }

  private void generateUnion( @Nonnull final Writer writer,
                              @Nonnull final String idlName,
                              @Nonnull final UnionType unionType )
    throws IOException
  {
  }

  private void generateDictionary( @Nonnull final Writer writer, @Nonnull final DictionaryDefinition definition )
    throws IOException
  {
  }

  private void generateInterface( @Nonnull final Writer writer, @Nonnull final InterfaceDefinition definition )
    throws IOException
  {
  }

  private void generatePartialInterface( @Nonnull final Writer writer,
                                         @Nonnull final PartialInterfaceDefinition definition )
    throws IOException
  {
  }

  private void writeJsDoc( @Nonnull final Writer writer, @Nonnull final String... lines )
    throws IOException
  {
    final List<String> docLines = Stream.of( lines ).filter( Objects::nonNull ).collect( Collectors.toList() );
    if ( !docLines.isEmpty() )
    {
      writer.write( "/**\n" );
      for ( final String line : docLines )
      {
        writer.write( " * " );
        writer.write( line );
        writer.write( "\n" );
      }
      writer.write( " */\n" );
    }
  }
}
