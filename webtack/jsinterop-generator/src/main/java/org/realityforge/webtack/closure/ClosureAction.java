package org.realityforge.webtack.closure;

import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.Argument;
import org.realityforge.webtack.model.AttributeMember;
import org.realityforge.webtack.model.CallbackDefinition;
import org.realityforge.webtack.model.CallbackInterfaceDefinition;
import org.realityforge.webtack.model.ConstEnumerationDefinition;
import org.realityforge.webtack.model.ConstMember;
import org.realityforge.webtack.model.DictionaryDefinition;
import org.realityforge.webtack.model.DictionaryMember;
import org.realityforge.webtack.model.FrozenArrayType;
import org.realityforge.webtack.model.InterfaceDefinition;
import org.realityforge.webtack.model.Kind;
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
import org.realityforge.webtack.model.tools.util.ExtendedAttributes;

final class ClosureAction
  extends AbstractAction
{
  /**
   * ES5 key words. See Section 7.6.1.1
   */
  @Nonnull
  private static final List<String> JS_KEY_WORDS =
    Arrays.asList( "break", "case", "catch", "continue", "debugger", "default", "delete",
                   "do", "else", "finally", "for", "function", "if", "in", "instanceof",
                   "new", "return", "switch", "this", "throw", "try", "typeof", "var", "void",
                   "while", "with" );
  /**
   * ES5 strict mode reserved words. See Section 7.6.1.2
   */
  @Nonnull
  private static final List<String> JS_RESERVED_WORDS =
    Arrays.asList( "class", "const", "enum", "export", "extends", "import", "super",
                   "implements", "interface", "let", "package", "private", "protected",
                   "public", "static", "yield" );
  /**
   * JS Literals. See Section 7.8 Literals.
   */
  @Nonnull
  private static final List<String> JS_LITERALS = Arrays.asList( "true", "false", "null" );
  /**
   * Instance methods that are implicitly available on every object and thus mandate an `@override` annotation
   * if they are redefined by other interface/namespace types.
   */
  @Nonnull
  private static final List<String> OBJECT_PROTOTYPE_METHODS =
    Arrays.asList( "hasOwnProperty",
                   "isPrototypeOf",
                   "propertyIsEnumerable",
                   "toLocaleString",
                   "toJSON",
                   "toSource",
                   "toString",
                   "valueOf" );
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
        Files
          .readAllLines( predefinedTypeCatalog )
          .stream()
          .map( String::trim )
          .filter( t -> !t.isEmpty() )
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
        if ( tryRecordGeneratedType( definition.getName() ) )
        {
          writeTypedef( writer, definition.getName(), definition.getType() );
        }
      }
      for ( final CallbackDefinition definition : schema.getCallbacks() )
      {
        if ( tryRecordGeneratedType( definition.getName() ) )
        {
          writeCallback( writer, definition );
        }
      }
      for ( final CallbackInterfaceDefinition definition : schema.getCallbackInterfaces() )
      {
        if ( tryRecordGeneratedType( definition.getName() ) )
        {
          writeCallbackInterface( writer, definition );
        }
      }
      for ( final DictionaryDefinition definition : schema.getDictionaries() )
      {
        if ( tryRecordGeneratedType( definition.getName() ) )
        {
          writeDictionary( writer, definition );
        }
      }
      for ( final NamespaceDefinition definition : schema.getNamespaces() )
      {
        if ( tryRecordGeneratedType( definition.getName() ) )
        {
          writeNamespace( writer, definition );
        }
      }
      for ( final InterfaceDefinition definition : schema.getInterfaces() )
      {
        if ( tryRecordGeneratedType( definition.getName() ) )
        {
          writeInterface( writer, definition );
        }
      }

      if ( null != _globalInterface )
      {
        final InterfaceDefinition definition = schema.findInterfaceByName( _globalInterface );
        if ( null == definition )
        {
          throw new IllegalStateException( "Declared globalInterface '" +
                                           _globalInterface +
                                           "' does not exist in schema" );
        }
        writeGlobalInterface( writer, definition );
      }
    }

    if ( _generateTypeCatalog )
    {
      writeTypeCatalog();
    }
  }

  private void writeTypedef( @Nonnull final Writer writer,
                             @Nonnull final String idlName,
                             @Nonnull final Type unionType )
    throws IOException
  {
    writer.write( "/**\n * @typedef {" );
    writeType( writer, unionType );
    writer.write( "}\n */\nvar " );
    writer.write( idlName );
    writer.write( ";\n" );
  }

  private void writeCallback( @Nonnull final Writer writer, @Nonnull final CallbackDefinition definition )
    throws IOException
  {
    writer.write( "/**\n * @typedef {" );
    writeFunctionType( writer, definition.getArguments(), definition.getReturnType() );
    writer.write( "\n */\n" );
    writer.write( "var " + definition.getName() + ";\n" );
  }

  private void writeCallbackInterface( @Nonnull final Writer writer,
                                       @Nonnull final CallbackInterfaceDefinition definition )
    throws IOException
  {
    final String type = definition.getName();
    writer.write( "/**\n * @interface\n */\nfunction " );
    writer.write( type );
    writer.write( "() {}\n" );
    writeConstMembers( writer, type, definition.getConstants(), true, false );
    final OperationMember operation = definition.getOperation();
    final String name = operation.getName();
    assert null != name;
    writeOperation( writer, type, name, operation.getArguments(), operation.getReturnType(), true, false );
  }

  private void writeDictionary( @Nonnull final Writer writer, @Nonnull final DictionaryDefinition definition )
    throws IOException
  {
    final List<DictionaryMember> members = new ArrayList<>();
    DictionaryDefinition dict = definition;
    while ( null != dict )
    {
      members.addAll( dict.getMembers() );
      dict = dict.getSuperDictionary();
    }

    if ( members.isEmpty() )
    {
      writer.write( "/**\n * @record\n */\nvar " );
      writer.write( definition.getName() );
      writer.write( ";\n" );
    }
    else
    {
      writer.write( "/**\n * @typedef {{" );

      boolean first = true;
      for ( final DictionaryMember member : members )
      {
        if ( !first )
        {
          writer.write( "," );
        }
        else
        {
          first = false;
        }
        writer.write( member.getName() );
        writer.write( ":" );
        final Type type = member.getType();
        if ( member.isOptional() )
        {
          final Type undefinedType = new Type( Kind.Void, Collections.emptyList(), false, Collections.emptyList() );
          final List<Type> types = new ArrayList<>();
          if ( Kind.Union == type.getKind() )
          {
            types.addAll( ( (UnionType) type ).getMemberTypes() );
          }
          else
          {
            types.add( type );
          }
          maybeAddTypeToList( types, undefinedType );
          writeType( writer, new UnionType( types, Collections.emptyList(), false, Collections.emptyList() ) );
        }
        else
        {
          writeType( writer, type );
        }
      }

      writer.write( "}}\n */\nvar " );
      writer.write( definition.getName() );
      writer.write( ";\n" );
    }
  }

  private void writeNamespace( @Nonnull final Writer writer, @Nonnull final NamespaceDefinition definition )
    throws IOException
  {
    final String name = definition.getName();

    // There is no actual interface for the underlying type that matches this name as the underlying
    // type is the same name as namespace. But introducing this synthetic type is the closest we can get
    // to getting closure to handle this scenario correctly
    final String interfaceType = name + "Interface";
    writeConstructor( writer,
                      interfaceType,
                      null,
                      Collections.emptyList(),
                      true,
                      Collections.singletonList( "@private" ) );
    writeConstMembers( writer, interfaceType, definition.getConstants(), true, false );
    writeAttributeMembers( writer, interfaceType, definition.getAttributes() );
    writeOperations( writer, interfaceType, definition.getOperations(), s -> false );

    writeJsDoc( writer, "@const", "@type {" + interfaceType + "}" );
    writer.write( "var " );
    writer.write( name );
    writer.write( ";\n" );
  }

  private void writeInterface( @Nonnull final Writer writer, @Nonnull final InterfaceDefinition definition )
    throws IOException
  {
    final List<OperationMember> operations = definition.getOperations();
    final List<OperationMember> constructors =
      operations
        .stream()
        .filter( o -> OperationMember.Kind.CONSTRUCTOR == o.getKind() )
        .collect( Collectors.toList() );
    final boolean hasNoJsType =
      definition.isNoArgsExtendedAttributePresent( ExtendedAttributes.LEGACY_NO_INTERFACE_OBJECT );

    final String namespace = definition.getNamespace();
    final String type = ( null == namespace ? "" : namespace + "." ) + definition.getName();
    if ( hasNoJsType )
    {
      writeConstructor( writer,
                        type,
                        definition.getInherits(),
                        Collections.emptyList(),
                        false,
                        Collections.emptyList() );
    }
    else if ( constructors.isEmpty() )
    {
      writeConstructor( writer,
                        type,
                        definition.getInherits(),
                        Collections.emptyList(),
                        true,
                        Collections.singletonList( "@private" ) );
    }
    else if ( 1 == constructors.size() )
    {
      writeConstructor( writer,
                        type,
                        definition.getInherits(),
                        constructors.get( 0 ).getArguments(),
                        true,
                        Collections.emptyList() );
    }
    else
    {
      writeConstructor( writer,
                        type,
                        definition.getInherits(),
                        deriveArguments( constructors ),
                        true,
                        Collections.emptyList() );
    }
    writeConstMembers( writer, type, definition.getConstants(), !hasNoJsType, true );
    writeAttributeMembers( writer, type, definition.getAttributes() );
    writeOperations( writer, type, operations, operationName -> {
      InterfaceDefinition interfaceDefinition = definition.getSuperInterface();
      while ( null != interfaceDefinition )
      {
        final OperationMember operation = interfaceDefinition.findOperationByName( operationName );
        if ( null != operation && OperationMember.Kind.STATIC != operation.getKind() )
        {
          return true;
        }
        interfaceDefinition = interfaceDefinition.getSuperInterface();
      }
      return false;
    } );
  }

  private void writeOperations( @Nonnull final Writer writer,
                                @Nonnull final String type,
                                @Nonnull final List<OperationMember> operations,
                                @Nonnull final Predicate<String> isOperationOverride )
    throws IOException
  {
    final Map<String, List<OperationMember>> operationMap =
      operations
        .stream()
        .filter( o -> null != o.getName() )
        .filter( o -> OperationMember.Kind.CONSTRUCTOR != o.getKind() )
        .collect( Collectors.groupingBy( OperationMember::getName ) );
    for ( final Map.Entry<String, List<OperationMember>> entry : operationMap.entrySet() )
    {
      final String operationName = entry.getKey();
      final List<OperationMember> operationsToMerge = entry.getValue();
      final OperationMember templateOperation = operationsToMerge.get( 0 );
      final boolean isNonStaticOperation = OperationMember.Kind.STATIC != templateOperation.getKind();
      final boolean isOverride = isNonStaticOperation && isOperationOverride.test( operationName );
      if ( 1 == operationsToMerge.size() )
      {
        writeOperation( writer,
                        type,
                        operationName,
                        templateOperation.getArguments(),
                        templateOperation.getReturnType(),
                        isNonStaticOperation,
                        isOverride );
      }
      else
      {
        writeOperation( writer,
                        type,
                        operationName,
                        deriveArguments( operationsToMerge ),
                        deriveReturnType( operationsToMerge ),
                        isNonStaticOperation,
                        isOverride );
      }
    }
  }

  private void writeGlobalInterface( @Nonnull final Writer writer, @Nonnull final InterfaceDefinition definition )
    throws IOException
  {
    // Should we define externs for globalThis.X, window.X and X ?
  }

  private void writeTypeCatalog()
    throws IOException
  {
    final String content =
      _generatedTypes
        .stream()
        .sorted()
        .filter( t -> !_predefinedTypes.contains( t ) )
        .collect( Collectors.joining( "\n" ) ) + "\n";
    writeFile( getMainResourcesDirectory().resolve( _key + ".types" ),
               content.getBytes( StandardCharsets.UTF_8 ) );
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
                                 i >= minArgCount || ( optionals.size() > i && optionals.get( i ) ),
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

  private void writeAttributeMembers( @Nonnull final Writer writer,
                                      @Nonnull final String type,
                                      @Nonnull final List<AttributeMember> attributes )
    throws IOException
  {
    for ( final AttributeMember attribute : attributes )
    {
      writeAttributeMember( writer, type, attribute );
    }
  }

  private void writeAttributeMember( @Nonnull final Writer writer,
                                     @Nonnull final String type,
                                     @Nonnull final AttributeMember attribute )
    throws IOException
  {
    writer.write( "/** @type {" );
    writeType( writer, attribute.getType() );
    writer.write( "} */ " );
    writer.write( type );
    writer.write( "." );
    // TODO: Should INHERIT imply @Override
    if ( !attribute.getModifiers().contains( AttributeMember.Modifier.STATIC ) )
    {
      writer.write( "prototype." );
    }
    writer.write( attribute.getName() );
    writer.write( ";\n" );
  }

  private void writeConstMembers( @Nonnull final Writer writer,
                                  @Nonnull final String type,
                                  @Nonnull final List<ConstMember> constants,
                                  final boolean addConstantsToType,
                                  final boolean addConstantsToPrototype )
    throws IOException
  {
    for ( final ConstMember constant : constants )
    {
      if ( addConstantsToType )
      {
        writeConstMember( writer, type, constant, false );
      }
      if ( addConstantsToPrototype )
      {
        writeConstMember( writer, type, constant, true );
      }
    }
  }

  private void writeConstMember( @Nonnull final Writer writer,
                                 @Nonnull final String type,
                                 @Nonnull final ConstMember constant,
                                 final boolean onPrototype )
    throws IOException
  {
    writer.write( "/** @const {" );
    writeType( writer, constant.getType() );
    writer.write( "} */ " );
    writer.write( type );
    writer.write( "." );
    if ( onPrototype )
    {
      writer.write( "prototype." );
    }
    writer.write( constant.getName() );
    writer.write( ";\n" );
  }

  private void writeOperation( @Nonnull final Writer writer,
                               @Nonnull final String typeName,
                               @Nonnull final String name,
                               @Nonnull final List<Argument> arguments,
                               @Nonnull final Type returnType,
                               final boolean onPrototype,
                               final boolean override )
    throws IOException
  {
    writer.write( "/**\n" );
    writeArgumentsJsDoc( writer, arguments );
    writer.write( " * @return {" );
    writeType( writer, returnType );
    writer.write( "}\n" );
    if ( override || ( onPrototype && OBJECT_PROTOTYPE_METHODS.contains( name ) ) )
    {
      writer.write( " * @override\n" );
    }
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
                                 final boolean hasJsType,
                                 @Nonnull final List<String> additionalLines )
    throws IOException
  {
    writer.write( "/**\n" );
    writer.write( " * @constructor\n" );
    if ( !hasJsType )
    {
      writer.write( " * @private\n" );
    }
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
    writeArgumentsJsDoc( writer, arguments );
    writer.write( " */\n" );
    if ( typeName.contains( "." ) )
    {
      writer.write( typeName + " = function" + toArgumentsList( arguments ) + " {}\n" );
    }
    else
    {
      writer.write( "function " + typeName + toArgumentsList( arguments ) + " {}\n" );
    }
  }

  private void writeArgumentsJsDoc( @Nonnull final Writer writer,
                                    @Nonnull final List<Argument> arguments )
    throws IOException
  {
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
      writer.write( safeJsArgName( argument.getName() ) );
      writer.write( "\n" );
    }
  }

  @Nonnull
  private String toArgumentsList( @Nonnull final List<Argument> arguments )
  {
    return "(" +
           arguments
             .stream()
             .map( NamedElement::getName )
             .map( this::safeJsArgName )
             .collect( Collectors.joining( "," ) ) +
           ")";
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
    if ( Kind.TypeReference != kind && Kind.Union != kind && Kind.Any != kind && Kind.Void != kind )
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
      final String name = typeReference.getName();
      final WebIDLSchema schema = getSchema();
      if ( null != schema.findEnumerationByName( name ) )
      {
        writer.write( type.isNullable() ? "?" : "!" );
        writer.write( "string" );
      }
      else
      {
        final ConstEnumerationDefinition constEnumeration = schema.findConstEnumerationByName( name );
        if ( null != constEnumeration )
        {
          writeType( writer, schema.getConstant( constEnumeration.getValues().get( 0 ) ).getType() );
        }
        else
        {
          writer.write( type.isNullable() ? "?" : "!" );
          final InterfaceDefinition interfaceDefinition = schema.findInterfaceByName( name );
          if ( null != interfaceDefinition )
          {
            final String namespace = interfaceDefinition.getNamespace();
            if ( null != namespace )
            {
              writer.write( namespace );
              writer.write( "." );
            }
            writer.write( name );
          }
          else
          {
            writer.write( name );
          }
        }
      }
    }
  }

  @Nonnull
  private String safeJsArgName( @Nonnull final String name )
  {
    return isArgNameJsSafe( name ) ? name : mangleName( name );
  }

  private boolean isArgNameJsSafe( @Nonnull final String name )
  {
    return !JS_RESERVED_WORDS.contains( name ) && !JS_KEY_WORDS.contains( name ) && !JS_LITERALS.contains( name );
  }

  @Nonnull
  private String mangleName( @Nonnull final String name )
  {
    return Character.isUnicodeIdentifierStart( name.charAt( 0 ) ) ? name + "_" : "_" + name;
  }
}
