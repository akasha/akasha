package org.realityforge.webtack.closure;

import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.Argument;
import org.realityforge.webtack.model.CallbackDefinition;
import org.realityforge.webtack.model.CallbackInterfaceDefinition;
import org.realityforge.webtack.model.ConstEnumerationDefinition;
import org.realityforge.webtack.model.ConstMember;
import org.realityforge.webtack.model.DictionaryDefinition;
import org.realityforge.webtack.model.EnumerationDefinition;
import org.realityforge.webtack.model.FrozenArrayType;
import org.realityforge.webtack.model.InterfaceDefinition;
import org.realityforge.webtack.model.Kind;
import org.realityforge.webtack.model.NamedDefinition;
import org.realityforge.webtack.model.NamedElement;
import org.realityforge.webtack.model.NamespaceDefinition;
import org.realityforge.webtack.model.OperationMember;
import org.realityforge.webtack.model.PromiseType;
import org.realityforge.webtack.model.RecordType;
import org.realityforge.webtack.model.SequenceType;
import org.realityforge.webtack.model.Type;
import org.realityforge.webtack.model.TypeReference;
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
      writeJsDoc( writer, "@fileoverview", "@externs" );
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
    writer.write( "/**\n * @typedef {" );
    writeFunctionType( writer, definition.getArguments(), definition.getReturnType() );
    writer.write( "\n */\n" );
    writer.write( "var " + definition.getName() + ";\n" );
  }

  private void generateCallbackInterface( @Nonnull final Writer writer,
                                          @Nonnull final CallbackInterfaceDefinition definition )
    throws IOException
  {
    writer.write( "/**\n * @interface\n */\nfunction () {}\n" );
    writeConstMembers( writer, definition, definition.getConstants() );
    writeUniquelyNamedOperation( writer, definition, definition.getOperation() );
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
    final List<OperationMember> constructors =
      definition
        .getOperations()
        .stream()
        .filter( o -> OperationMember.Kind.CONSTRUCTOR == o.getKind() )
        .collect( Collectors.toList() );
    if ( constructors.isEmpty() )
    {
      writeConstructor( writer,
                        definition.getName(),
                        definition.getInherits(),
                        Collections.emptyList(),
                        Collections.singletonList( "@private" ) );
    }
    else if ( 1 == constructors.size() )
    {
      writeConstructor( writer,
                        definition.getName(),
                        definition.getInherits(),
                        constructors.get( 0 ).getArguments(),
                        Collections.emptyList() );
    }
    else
    {
      writeConstructor( writer,
                        definition.getName(),
                        definition.getInherits(),
                        deriveArguments( constructors ),
                        Collections.emptyList() );
    }
    writeConstMembers( writer, definition, definition.getConstants() );

    final Map<String, List<OperationMember>> operationMap =
      definition
        .getOperations()
        .stream()
        .filter( o -> null != o.getName() )
        .filter( o -> OperationMember.Kind.CONSTRUCTOR != o.getKind() )
        .collect( Collectors.groupingBy( OperationMember::getName ) );
    for ( final Map.Entry<String, List<OperationMember>> entry : operationMap.entrySet() )
    {
      final List<OperationMember> operationsToMerge = entry.getValue();
      final OperationMember templateOperation = operationsToMerge.get( 0 );
      final boolean isNonStaticOperation = OperationMember.Kind.STATIC != templateOperation.getKind();
      if ( 1 == operationsToMerge.size() )
      {
        writeOperation( writer,
                        definition.getName(),
                        entry.getKey(),
                        templateOperation.getArguments(),
                        templateOperation.getReturnType(),
                        isNonStaticOperation );
      }
      else
      {
        writeOperation( writer,
                        definition.getName(),
                        entry.getKey(),
                        deriveArguments( operationsToMerge ),
                        deriveReturnType( operationsToMerge ),
                        isNonStaticOperation );
      }
    }
  }

  @Nonnull
  private List<Argument> deriveArguments( @Nonnull final List<OperationMember> operations )
  {
    final List<List<Type>> arguments = new ArrayList<>();
    final List<Boolean> optionals = new ArrayList<>();
    boolean variadic = false;
    int minArgCount = Integer.MAX_VALUE;
    for ( final OperationMember operation : operations )
    {
      int i = 0;
      minArgCount = Math.min( minArgCount, operation.getArguments().size() );
      for ( final Argument argument : operation.getArguments() )
      {
        if ( argument.isVariadic() )
        {
          // The assumption is that only the last argument may be variadic and variadic APIs should be consistent
          // across operations with the same name...
          variadic = true;
        }
        if ( argument.isOptional() )
        {
          // Make sure optional array covers index and then set to true
          for ( int j = optionals.size(); j <= i; j++ )
          {
            optionals.add( Boolean.FALSE );
          }
          optionals.set( i, Boolean.TRUE );
        }
        final Type type = argument.getType();
        for ( int j = arguments.size(); j <= i; j++ )
        {
          arguments.add( new ArrayList<>() );
        }
        maybeAddTypeToList( arguments.get( i ), type );
        i++;
      }
    }

    final List<Type> types = arguments.stream().map( this::toType ).collect( Collectors.toList() );
    final List<Argument> results = new ArrayList<>();
    final int argCount = types.size();
    for ( int i = 0; i < argCount; i++ )
    {
      results.add( new Argument( "arg" + i,
                                 types.get( i ),
                                 i >= minArgCount || (optionals.size() > i && optionals.get( i )),
                                 i == argCount - 1 && variadic,
                                 null,
                                 null,
                                 Collections.emptyList(),
                                 Collections.emptyList() ) );
    }
    return results;
  }

  @Nonnull
  private Type deriveReturnType( @Nonnull final List<OperationMember> operations )
  {
    final List<Type> types = new ArrayList<>();
    for ( final OperationMember operation : operations )
    {
      maybeAddTypeToList( types, operation.getReturnType() );
    }
    return toType( types );
  }

  private void maybeAddTypeToList( @Nonnull final List<Type> types, @Nonnull final Type candidate )
  {
    for ( final Type type : types )
    {
      if ( type.equiv( candidate ) )
      {
        return;
      }
    }
    types.add( candidate );
  }

  @Nonnull
  private Type toType( @Nonnull final List<Type> types )
  {
    return 1 == types.size() ?
           types.get( 0 ) :
           new UnionType( types,
                          Collections.emptyList(),
                          types.stream().anyMatch( Type::isNullable ),
                          Collections.emptyList() );
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

  private void writeConstMembers( @Nonnull final Writer writer,
                                  @Nonnull final NamedDefinition definition,
                                  @Nonnull final List<ConstMember> constants )
    throws IOException
  {
    for ( final ConstMember constant : constants )
    {
      writeConstMember( writer, definition, constant );
    }
  }

  private void writeConstMember( @Nonnull final Writer writer,
                                 @Nonnull final NamedDefinition definition,
                                 @Nonnull final ConstMember constant )
    throws IOException
  {
    writer.write( "/** @const {" );
    writeType( writer, constant.getType() );
    writer.write( "} */ " );
    writer.write( definition.getName() );
    writer.write( "." );
    writer.write( constant.getName() );
    writer.write( ";\n" );
  }

  private void writeUniquelyNamedOperation( @Nonnull final Writer writer,
                                            @Nonnull final NamedDefinition definition,
                                            @Nonnull final OperationMember operation )
    throws IOException
  {
    final String name = operation.getName();
    final OperationMember.Kind kind = operation.getKind();
    if ( null != name && OperationMember.Kind.CONSTRUCTOR != kind )
    {
      writeOperation( writer,
                      definition.getName(),
                      name,
                      operation.getArguments(),
                      operation.getReturnType(),
                      OperationMember.Kind.STATIC != kind );
    }
  }

  private void writeOperation( @Nonnull final Writer writer,
                               @Nonnull final String typeName,
                               @Nonnull final String name,
                               @Nonnull final List<Argument> arguments,
                               @Nonnull final Type returnType,
                               final boolean onPrototype )
    throws IOException
  {
    writer.write( "/**\n" );
    for ( final Argument argument : arguments )
    {
      writer.write( " * @param {" );
      if ( argument.isVariadic() )
      {
        writer.write( "..." );
      }
      writeType( writer, argument.getType() );
      if ( argument.isOptional() )
      {
        writer.write( "=" );
      }
      writer.write( "} " );
      writer.write( argument.getName() );
      writer.write( "\n" );
    }
    writer.write( " * @return {" );
    writeType( writer, returnType );
    writer.write( "}\n" );
    writer.write( " */\n" );
    writer.write( typeName +
                  "." +
                  ( onPrototype ? "prototype." : "" ) +
                  name +
                  " = function" + toArgumentsList( arguments ) + " {}\n" );
  }

  private void writeConstructor( @Nonnull final Writer writer,
                                 @Nonnull final String typeName,
                                 @Nullable final String superType,
                                 @Nonnull final List<Argument> arguments,
                                 @Nonnull final List<String> additionalLines )
    throws IOException
  {
    writer.write( "/**\n" );
    writer.write( " * @constructor\n" );
    if ( null != superType )
    {
      writer.write( " * @extends {" );
      writer.write( superType );
      writer.write( "}\n" );
    }
    for ( final String additionalLine : additionalLines )
    {
      writer.write( " * " );
      writer.write( additionalLine );
      writer.write( "\n" );
    }
    //TODO: Implement types like iterable
    for ( final Argument argument : arguments )
    {
      writer.write( " * @param {" );
      if ( argument.isVariadic() )
      {
        writer.write( "..." );
      }
      writeType( writer, argument.getType() );
      if ( argument.isOptional() )
      {
        writer.write( "=" );
      }
      writer.write( "} " );
      writer.write( argument.getName() );
      writer.write( "\n" );
    }
    writer.write( " */\n" );
    writer.write( "function " + typeName + toArgumentsList( arguments ) + " {}\n" );
  }

  @Nonnull
  private String toArgumentsList( @Nonnull final List<Argument> arguments )
  {
    return "(" + arguments.stream().map( NamedElement::getName ).collect( Collectors.joining( "," ) ) + ")";
  }

  private void writeFunctionType( @Nonnull final Writer writer,
                                  @Nonnull final List<Argument> arguments,
                                  @Nonnull final Type returnType )
    throws IOException
  {
    writer.write( "function(" );
    boolean first = true;
    for ( final Argument argument : arguments )
    {
      if ( !first )
      {
        writer.write( "," );
      }
      first = false;
      if ( argument.isVariadic() )
      {
        writer.write( "..." );
      }
      writeType( writer, argument.getType() );
      if ( argument.isOptional() )
      {
        writer.write( "=" );
      }
    }

    writer.write( "): " );
    writeType( writer, returnType );
    writer.write( "}" );
  }

  private void writeType( @Nonnull final Writer writer, @Nonnull final Type type )
    throws IOException
  {
    final Kind kind = type.getKind();
    if ( Kind.Union != kind && Kind.Any != kind && Kind.Void != kind )
    {
      writer.write( type.isNullable() ? "?" : "!" );
    }
    if ( kind.isNumeric() || Kind.Byte == kind || Kind.Octet == kind )
    {
      writer.write( "number" );
    }
    else if ( kind.isString() )
    {
      writer.write( "string" );
    }
    else if ( Kind.Boolean == kind )
    {
      writer.write( "boolean" );
    }
    else if ( Kind.Void == kind )
    {
      writer.write( "undefined" );
    }
    else if ( Kind.Any == kind )
    {
      writer.write( "*" );
    }
    else if ( Kind.Sequence == kind )
    {
      writer.write( "Array<" );
      writeType( writer, ( (SequenceType) type ).getItemType() );
      writer.write( ">" );
    }
    else if ( Kind.FrozenArray == kind )
    {
      writer.write( "Array<" );
      writeType( writer, ( (FrozenArrayType) type ).getItemType() );
      writer.write( ">" );
    }
    else if ( Kind.Promise == kind )
    {
      writer.write( "Promise<" );
      writeType( writer, ( (PromiseType) type ).getResolveType() );
      writer.write( ">" );
    }
    else if ( Kind.Object == kind )
    {
      writer.write( "Object" );
    }
    else if ( Kind.Union == kind )
    {
      writer.write( "(" );
      final List<Type> memberTypes = ( (UnionType) type ).getMemberTypes();
      boolean first = true;
      for ( final Type memberType : memberTypes )
      {
        if ( !first )
        {
          writer.write( "|" );
        }
        else
        {
          first = false;
        }
        writeType( writer, memberType );
      }
      writer.write( ")" );
    }
    else if ( Kind.Record == kind )
    {
      final RecordType recordType = (RecordType) type;
      writer.write( "Object<" );
      writeType( writer, recordType.getKeyType() );
      writer.write( "," );
      writeType( writer, recordType.getValueType() );
      writer.write( ">" );
    }
    else
    {
      assert Kind.TypeReference == kind;
      final TypeReference typeReference = (TypeReference) type;
      writer.write( typeReference.getName() );
    }
  }
}
