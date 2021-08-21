package org.realityforge.webtack.closure;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
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
import org.realityforge.webtack.model.Attributed;
import org.realityforge.webtack.model.AttributedNode;
import org.realityforge.webtack.model.CallbackDefinition;
import org.realityforge.webtack.model.CallbackInterfaceDefinition;
import org.realityforge.webtack.model.ConstEnumerationDefinition;
import org.realityforge.webtack.model.ConstMember;
import org.realityforge.webtack.model.DictionaryDefinition;
import org.realityforge.webtack.model.DictionaryMember;
import org.realityforge.webtack.model.ExtendedAttribute;
import org.realityforge.webtack.model.FrozenArrayType;
import org.realityforge.webtack.model.InterfaceDefinition;
import org.realityforge.webtack.model.IterableMember;
import org.realityforge.webtack.model.Kind;
import org.realityforge.webtack.model.MapLikeMember;
import org.realityforge.webtack.model.Named;
import org.realityforge.webtack.model.NamedDefinition;
import org.realityforge.webtack.model.NamespaceDefinition;
import org.realityforge.webtack.model.OperationMember;
import org.realityforge.webtack.model.PartialInterfaceDefinition;
import org.realityforge.webtack.model.PromiseType;
import org.realityforge.webtack.model.RecordType;
import org.realityforge.webtack.model.SequenceType;
import org.realityforge.webtack.model.SetLikeMember;
import org.realityforge.webtack.model.Type;
import org.realityforge.webtack.model.TypeReference;
import org.realityforge.webtack.model.TypedefDefinition;
import org.realityforge.webtack.model.UnionType;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.tools.io.FilesUtil;
import org.realityforge.webtack.model.tools.spi.PipelineContext;
import org.realityforge.webtack.model.tools.util.AbstractAction;
import org.realityforge.webtack.model.tools.util.ExtendedAttributes;
import org.realityforge.webtack.model.tools.util.NamingUtil;

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
  private final boolean _generateTypeCatalog;
  @Nonnull
  private final List<String> _predefinedSymbols = new ArrayList<>();
  @Nonnull
  private final Set<String> _generatedTypes = new HashSet<>();
  @Nonnull
  private final List<Path> _additionalExternFragmentsPaths;

  ClosureAction( @Nonnull final PipelineContext context,
                 @Nonnull final Path outputDirectory,
                 @Nonnull final String packageName,
                 @Nonnull final List<Path> predefinedTypeCatalogPaths,
                 @Nonnull final List<Path> additionalExternFragmentsPaths,
                 final boolean generateTypeCatalog )
  {
    super( context, outputDirectory, packageName );
    _generateTypeCatalog = generateTypeCatalog;
    _additionalExternFragmentsPaths = Objects.requireNonNull( additionalExternFragmentsPaths );
    for ( final Path predefinedTypeCatalog : predefinedTypeCatalogPaths )
    {
      try
      {
        Files
          .readAllLines( predefinedTypeCatalog )
          .stream()
          .map( String::trim )
          .filter( t -> !t.isEmpty() )
          .forEach( _predefinedSymbols::add );
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

  @Nonnull
  private String getBaseName()
  {
    return getPackageName() + "." + NamingUtil.uppercaseFirstCharacter( getLeafPackageName() );
  }

  @Override
  public void process( @Nonnull final WebIDLSchema schema )
    throws Exception
  {
    processInit( schema );

    FilesUtil.deleteDirectory( getMainJsDirectory() );

    final String externsFilename = getBaseName().replaceAll( "\\.", File.separator ) + ".externs.js";
    try ( final Writer writer = openWriter( getMainJsDirectory().resolve( externsFilename ) ) )
    {
      writeJsDoc( writer, "@fileoverview", "@externs" );
      for ( final TypedefDefinition definition : schema.getTypedefs() )
      {
        if ( isNotExcluded( definition ) && tryRecordGeneratedType( definition ) )
        {
          final String jsName = toJsName( definition );
          if ( shouldGenerateSymbol( jsName ) )
          {
            writeTypedef( writer, jsName, definition.getType() );
          }
        }
      }
      for ( final CallbackDefinition definition : schema.getCallbacks() )
      {
        if ( isNotExcluded( definition ) && tryRecordGeneratedType( definition ) )
        {
          writeCallback( writer, definition );
        }
      }
      for ( final CallbackInterfaceDefinition definition : schema.getCallbackInterfaces() )
      {
        if ( isNotExcluded( definition ) && tryRecordGeneratedType( definition ) )
        {
          writeCallbackInterface( writer, definition );
        }
      }
      for ( final DictionaryDefinition definition : schema.getDictionaries() )
      {
        if ( isNotExcluded( definition ) && tryRecordGeneratedType( definition ) )
        {
          writeDictionary( writer, definition );
        }
      }
      for ( final NamespaceDefinition definition : schema.getNamespaces() )
      {
        if ( isNotExcluded( definition ) && tryRecordGeneratedType( definition ) )
        {
          writeNamespace( writer, definition );
        }
      }
      for ( final InterfaceDefinition definition : schema.getInterfaces() )
      {
        if ( isNotExcluded( definition ) && tryRecordGeneratedType( definition ) )
        {
          writeInterface( writer, definition );
        }
      }
      for ( final Map.Entry<String, UnionType> entry : getUnions().entrySet() )
      {
        final String name = entry.getKey();
        if ( tryRecordGeneratedType( name ) )
        {
          writeUnion( writer, NamingUtil.uppercaseFirstCharacter( name ), entry.getValue() );
        }
      }

      writeGlobalInterfaces( writer );

      for ( final Path path : _additionalExternFragmentsPaths )
      {
        for ( final String line : Files.readAllLines( path ) )
        {
          writer.write( line );
          writer.write( "\n" );
        }
      }
    }

    final StringBuffer sb = new StringBuffer();
    for ( final InterfaceDefinition definition : getSchema().getInterfaces() )
    {
      writeNativeJsIfRequired( sb, definition, definition.getAttributes(), definition.getOperations() );
    }
    for ( final PartialInterfaceDefinition definition : getSchema().getPartialInterfaces() )
    {
      writeNativeJsIfRequired( sb, definition, definition.getAttributes(), definition.getOperations() );
    }
    if ( 0 != sb.length() )
    {
      final String baseName = getBaseName();
      final String filename = baseName.replaceAll( "\\.", File.separator ) + ".js";
      try ( final Writer writer = openWriter( getMainJsDirectory().resolve( filename ) ) )
      {
        // Suppress use of goog.provide until we can move forward with a new approach
        writer.write( "/**\n * @fileoverview\n * @suppress {useOfGoogProvide}\n */\n" );
        // Declare a goog var if required. Hopefully not required when used in building apps, just tests.
        writer.write( "/**\n * @suppress {lintChecks}\n * @const\n */\nvar goog = goog || {};\n" );
        writer.write( "goog.provide('" + baseName + "');\n" );
        writer.write( sb.toString() );
      }
    }

    if ( _generateTypeCatalog )
    {
      writeTypeCatalog();
    }
  }

  private void writeGlobalInterfaces( @Nonnull final Writer writer )
    throws IOException
  {
    final WebIDLSchema schema = getSchema();
    final List<InterfaceDefinition> globalInterfaces =
      getGlobalInterfaces()
        .keySet()
        .stream()
        .map( schema::getInterfaceByName )
        .collect( Collectors.toList() );
    final List<ConstMember> constants = new ArrayList<>();
    final List<AttributeMember> attributes = new ArrayList<>();
    final List<OperationMember> operations = new ArrayList<>();
    for ( final InterfaceDefinition globalInterface : globalInterfaces )
    {
       InterfaceDefinition current = globalInterface;
       while( null != current )
       {
         constants.addAll( current.getConstants() );
         attributes.addAll( current.getAttributes() );
         operations.addAll( current.getOperations() );
         current = current.getSuperInterface();
       }
    }
    writeConstants( writer, null, constants, true, false );

    final Map<String, List<AttributeMember>> attributeMap =
      attributes
        .stream()
        .collect( Collectors.groupingBy( this::toJsName ) );
    for ( final Map.Entry<String, List<AttributeMember>> entry : attributeMap.entrySet() )
    {
      final List<AttributeMember> attributesToMerge = entry.getValue();
      final AttributeMember templateAttribute = attributesToMerge.get( 0 );
      if ( isNotExcluded( templateAttribute ) )
      {
        writeAttribute( writer,
                        null,
                        templateAttribute,
                        1 == attributesToMerge.size() ?
                        templateAttribute.getType() :
                        deriveAttributeType( attributesToMerge ) );
      }
    }
    writeOperations( writer, null, operations, false, name -> false );
  }

  private void writeNativeJsIfRequired( @Nonnull final StringBuffer defines,
                                        @Nonnull final NamedDefinition definition,
                                        @Nonnull final List<AttributeMember> attributes,
                                        @Nonnull final List<OperationMember> operations )
    throws IOException
  {
    boolean requiresNativeJs = false;
    for ( final AttributeMember attribute : attributes )
    {
      if ( attribute.isNoArgsExtendedAttributePresent( ExtendedAttributes.OPTIONAL_SUPPORT ) ||
           null != attribute.getIdentValue( ExtendedAttributes.OPTIONAL_SUPPORT ) )
      {
        final String name = deriveOptionalSupportCompileConstant( definition, attribute.getName(), attribute );
        defines.append( "\n" );
        defines.append( "/** @define {string} */\n" );
        defines.append( name );
        defines.append( " = goog.define('" );
        defines.append( name );
        defines.append( "', 'detect');\n" );
        requiresNativeJs = true;
      }
    }
    for ( final OperationMember operation : operations )
    {
      if ( operation.isNoArgsExtendedAttributePresent( ExtendedAttributes.OPTIONAL_SUPPORT ) ||
           null != operation.getIdentValue( ExtendedAttributes.OPTIONAL_SUPPORT ) )
      {
        final String operationName = operation.getName();
        assert null != operationName;
        final String name = deriveOptionalSupportCompileConstant( definition, operationName, operation );
        defines.append( "\n" );
        defines.append( "/** @define {string} */\n" );
        defines.append( name );
        defines.append( " = goog.define('" );
        defines.append( name );
        defines.append( "', 'detect');\n" );
        requiresNativeJs = true;
      }
    }
    if ( requiresNativeJs )
    {
      final String javaType = deriveJavaType( definition, "", "" );
      final String nativeJs = javaType.replaceAll( "\\.", File.separator ) + ".native.js";
      try ( final Writer writer = openWriter( getMainJsDirectory().resolve( nativeJs ) ) )
      {
        writer.write( "/**\n * @fileoverview\n * @suppress {lintChecks}\n */\n" );
        writer.write( "/** @suppress {extraRequire} */\n" );
        writer.write( "goog.require('" + getBaseName() + "');\n" );
      }
    }
  }

  private boolean isNotExcluded( @Nonnull final AttributedNode node )
  {
    return !node.isNoArgsExtendedAttributePresent( ExtendedAttributes.JAVA_ONLY );
  }

  private void writeTypedef( @Nonnull final Writer writer,
                             @Nonnull final String jsName,
                             @Nonnull final Type unionType )
    throws IOException
  {
    writer.write( "/**\n * @typedef {" );
    writeType( writer, unionType );
    writer.write( "}\n */\nvar " );
    writer.write( jsName );
    writer.write( ";\n" );
  }

  private void writeCallback( @Nonnull final Writer writer, @Nonnull final CallbackDefinition definition )
    throws IOException
  {
    final String jsName = toJsName( definition );
    if ( shouldGenerateSymbol( jsName ) )
    {
      writer.write( "/**\n * @typedef {" );
      writeFunctionType( writer, definition.getArguments(), definition.getReturnType() );
      writer.write( "\n */\n" );
      writer.write( "var " + jsName + ";\n" );
    }
  }

  private void writeCallbackInterface( @Nonnull final Writer writer,
                                       @Nonnull final CallbackInterfaceDefinition definition )
    throws IOException
  {
    final String jsType = toJsName( definition );
    writer.write( "/**\n * @interface\n */\nfunction " );
    writer.write( jsType );
    writer.write( "() {}\n" );
    writeConstants( writer, jsType, definition.getConstants(), true, false );
    final OperationMember operation = definition.getOperation();
    final String jsName = toJsName( operation );
    assert null != jsName;
    if ( shouldGenerateSymbol( jsType + "." + jsName ) )
    {
      writeOperation( writer, jsType, jsName, operation.getArguments(), operation.getReturnType(), true, false, false );
    }
  }

  private void writeDictionary( @Nonnull final Writer writer, @Nonnull final DictionaryDefinition definition )
    throws IOException
  {
    final List<DictionaryMember> members = new ArrayList<>();
    DictionaryDefinition dict = definition;
    while ( null != dict )
    {
      dict.getMembers().stream().filter( this::isNotExcluded ).forEach( members::add );
      dict = dict.getSuperDictionary();
    }

    final String jsTypeName = toJsName( definition );
    if ( shouldGenerateSymbol( jsTypeName ) )
    {
      if ( members.isEmpty() )
      {
        writer.write( "/**\n * @record\n */\nvar " );
        writer.write( jsTypeName );
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
          writer.write( toJsName( member ) );
          writer.write( ":" );
          final Type type = member.getType();
          if ( member.isOptional() )
          {
            final Type undefinedType = new Type( Kind.Void, Collections.emptyList(), false, Collections.emptyList() );
            final List<Type> types = new ArrayList<>();
            if ( Kind.Union == type.getKind() )
            {
              final UnionType unionType = (UnionType) type;
              if ( !unionType.isNoArgsExtendedAttributePresent( ExtendedAttributes.SYNTHESIZED_RETURN ) )
              {
                final String typeName = synthesizeUnionType( unionType );
                types.add( new TypeReference( typeName,
                                              unionType.getExtendedAttributes(),
                                              unionType.isNullable(),
                                              unionType.getSourceLocations() ) );
              }
              else
              {
                types.addAll( unionType.getMemberTypes() );
              }
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
            writeType( writer, type, type.isNullable(), true );
          }
        }

        writer.write( "}}\n */\nvar " );
        writer.write( jsTypeName );
        writer.write( ";\n" );
      }
    }
  }

  private void writeNamespace( @Nonnull final Writer writer, @Nonnull final NamespaceDefinition definition )
    throws IOException
  {
    final String jsType = toJsName( definition );

    writeJsDoc( writer, "@const" );
    writer.write( "var " );
    writer.write( jsType );
    writer.write( ";\n" );

    for ( final ConstMember constant : definition.getConstants() )
    {
      if ( isNotExcluded( constant ) )
      {
        final String jsName = jsType + "." + toJsName( constant );
        if ( shouldGenerateSymbol( jsName ) )
        {
          writer.write( "/** @const {" );
          writeType( writer, constant.getType() );
          writer.write( "} */ " );
          writer.write( jsName );
          writer.write( ";\n" );
        }
      }
    }
    for ( final AttributeMember attribute : definition.getAttributes() )
    {
      if ( isNotExcluded( attribute ) )
      {
        final String jsName = jsType + "." + toJsName( attribute );
        if ( shouldGenerateSymbol( jsName ) )
        {
          writer.write( "/** @type {" );
          writeType( writer, attribute.getType(), attribute.getType().isNullable(), true );
          writer.write( "} */ " );
          writer.write( jsName );
          writer.write( ";\n" );
        }
      }
    }
    writeOperations( writer, jsType, definition.getOperations(), true, s -> false );
  }

  private void writeUnion( @Nonnull final Writer writer,
                           @Nonnull final String name,
                           @Nonnull final UnionType unionType )
    throws IOException
  {
    writer.write( "/**\n * @typedef {(" );
    final List<Type> memberTypes = unionType.getMemberTypes();
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
      writeType( writer, memberType, memberType.isNullable(), true );
    }
    writer.write( ")}\n */\nvar " );
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

    final MapLikeMember mapLike = definition.getMapLikeMember();
    final SetLikeMember setLike = definition.getSetLikeMember();
    final IterableMember iterable = definition.getIterable();

    final String namespace = definition.getNamespace();
    final String jsType = ( null == namespace ? "" : namespace + "." ) + toJsName( definition );
    if ( shouldGenerateSymbol( jsType + "." + jsType ) )
    {
      final List<String> lines = new ArrayList<>();
      if ( null != iterable )
      {
        final Type keyType = iterable.getKeyType();
        if ( null == keyType )
        {
          lines.add( "@implements {Iterable<!Array<!number|" + toClosureType( iterable.getValueType() ) + ">>}" );
        }
        else
        {
          lines.add( "@implements {Iterable<!Array<" + toClosureType( keyType ) + "|" +
                     toClosureType( iterable.getValueType() ) + ">>}" );
        }
      }
      if ( null != mapLike )
      {
        lines.add( "@implements {Iterable<!Array<" + toClosureType( mapLike.getKeyType() ) + "|" +
                   toClosureType( mapLike.getValueType() ) + ">>}" );
      }

      if ( hasNoJsType || constructors.isEmpty() )
      {
        lines.add( "@nosideeffects" );
        writeConstructor( writer,
                          jsType,
                          definition.getInherits(),
                          Collections.emptyList(),
                          false,
                          lines );
      }
      else if ( 1 == constructors.size() )
      {
        final OperationMember constructor = constructors.get( 0 );
        final boolean noSideEffects =
          constructor.isNoArgsExtendedAttributePresent( ExtendedAttributes.NO_SIDE_EFFECTS );
        if ( noSideEffects )
        {
          lines.add( "@nosideeffects" );
        }
        writeConstructor( writer,
                          jsType,
                          definition.getInherits(),
                          constructor.getArguments(),
                          true,
                          lines );
      }
      else
      {
        final OperationMember constructor = constructors.get( 0 );
        final boolean noSideEffects =
          constructor.isNoArgsExtendedAttributePresent( ExtendedAttributes.NO_SIDE_EFFECTS );
        if ( noSideEffects )
        {
          lines.add( "@nosideeffects" );
        }
        writeConstructor( writer,
                          jsType,
                          definition.getInherits(),
                          deriveArguments( constructors ),
                          true,
                          lines );
      }
    }
    writeConstants( writer, jsType, definition.getConstants(), !hasNoJsType, true );
    writeAttributes( writer, jsType, definition.getAttributes() );
    writeOperations( writer, jsType, operations, false, name -> shouldOperationBeAnOverride( definition, name ) );
    if ( null != mapLike )
    {
      generateMapLikeOperations( writer, jsType, definition.getOperations(), mapLike );
    }
    if ( null != setLike )
    {
      generateSetLikeOperations( writer, jsType, definition.getOperations(), setLike );
    }
    if ( null != iterable )
    {
      generateIterableOperations( writer, jsType, iterable );
    }
  }

  @Nonnull
  private String toClosureType( @Nonnull final Type keyType )
    throws IOException
  {
    final StringWriter sw = new StringWriter();
    writeType( sw, keyType );
    return sw.toString();
  }

  private void generateSetLikeOperations( @Nonnull final Writer writer,
                                          @Nonnull final String jsType,
                                          @Nonnull final List<OperationMember> operations,
                                          @Nonnull final SetLikeMember setLike )
    throws IOException
  {
    writer.write( "/** @const {number} */ " );
    writer.write( jsType );
    writer.write( ".prototype.size;\n" );

    final Type elementType = setLike.getType();
    final Argument elementArgument =
      new Argument( "value",
                    elementType,
                    false,
                    false,
                    null,
                    null,
                    Collections.emptyList(),
                    Collections.emptyList() );

    // has operation
    writeOperation( writer,
                    jsType,
                    "has",
                    Collections.singletonList( elementArgument ),
                    new Type( Kind.Boolean, Collections.emptyList(), false, Collections.emptyList() ),
                    true,
                    false,
                    true );
    final ExtendedAttribute iteratorExtendedAttribute =
      ExtendedAttribute.createExtendedAttributeIdent( ExtendedAttributes.SEQUENCE_TYPE,
                                                      "Iterator",
                                                      Collections.emptyList() );
    writeOperation( writer,
                    jsType,
                    "keys",
                    Collections.emptyList(),
                    new SequenceType( elementType,
                                      Collections.singletonList( iteratorExtendedAttribute ),
                                      false,
                                      Collections.emptyList() ),
                    true,
                    false,
                    true );

    writeOperation( writer,
                    jsType,
                    "values",
                    Collections.emptyList(),
                    new SequenceType( elementType,
                                      Collections.singletonList( iteratorExtendedAttribute ),
                                      false,
                                      Collections.emptyList() ),
                    true,
                    false,
                    true );

    writer.write( "/**\n" );
    writer.write( " * @return {!Iterator<!Array<" );
    writeType( writer, elementType );
    writer.write( "|" );
    writeType( writer, elementType );
    writer.write( ">>}\n" );
    writer.write( " * @nosideeffects\n" );
    writer.write( " */\n" );
    writer.write( jsType + ".prototype.entries = function() {};\n" );

    writer.write( "/**\n" );
    writer.write( " * @return {!Iterator<!Array<" );
    writeType( writer, elementType );
    writer.write( "|" );
    writeType( writer, elementType );
    writer.write( ">>}\n" );
    writer.write( " * @nosideeffects\n" );
    writer.write( " */\n" );
    writer.write( jsType + ".prototype[Symbol.iterator] = function() {};\n" );

    writer.write( "/**\n" );
    writer.write( " * @param {function(" );
    writeType( writer, elementType );
    writer.write( ", " );
    writeType( writer, elementType );
    writer.write( ", MAP)} callback\n" );
    writer.write( " * @this {MAP}\n" );
    writer.write( " * @template MAP\n" );
    writer.write( " */\n" );
    writer.write( jsType + ".prototype.forEach = function(callback) {};\n" );

    if ( !setLike.isReadOnly() )
    {
      final boolean setPresent =
        operations
          .stream()
          .anyMatch( o -> "add".equals( toJsName( o ) ) &&
                          1 == o.getArguments().size() &&
                          Kind.Void == o.getReturnType().getKind() );
      if ( !setPresent )
      {
        writeOperation( writer,
                        jsType,
                        "add",
                        Collections.singletonList( elementArgument ),
                        new Type( Kind.Void, Collections.emptyList(), false, Collections.emptyList() ),
                        true,
                        false,
                        false );
      }
      final boolean deletePresent =
        operations
          .stream()
          .anyMatch( o -> "delete".equals( toJsName( o ) ) &&
                          1 == o.getArguments().size() &&
                          Kind.Boolean == o.getReturnType().getKind() );
      if ( !deletePresent )
      {
        writeOperation( writer,
                        jsType,
                        "delete",
                        Collections.singletonList( elementArgument ),
                        new Type( Kind.Boolean, Collections.emptyList(), false, Collections.emptyList() ),
                        true,
                        false,
                        false );
      }
      final boolean clearPresent =
        operations
          .stream()
          .anyMatch( o -> "clear".equals( toJsName( o ) ) &&
                          o.getArguments().isEmpty() &&
                          Kind.Void == o.getReturnType().getKind() );
      if ( !clearPresent )
      {
        writeOperation( writer,
                        jsType,
                        "clear",
                        Collections.emptyList(),
                        new Type( Kind.Void, Collections.emptyList(), false, Collections.emptyList() ),
                        true,
                        false,
                        false );
      }
    }
  }

  private void generateMapLikeOperations( @Nonnull final Writer writer,
                                          @Nonnull final String jsType,
                                          @Nonnull final List<OperationMember> operations,
                                          @Nonnull final MapLikeMember mapLike )
    throws IOException
  {

    final String jsSizeName = jsType + ".prototype.size";
    if ( shouldGenerateSymbol( jsSizeName ) )
    {
      writer.write( "/** @const {number} */ " );
      writer.write( jsSizeName );
      writer.write( ";\n" );
    }

    final Type keyType = mapLike.getKeyType();
    final Argument keyArgument =
      new Argument( "key",
                    keyType,
                    false,
                    false,
                    null,
                    null,
                    Collections.emptyList(),
                    Collections.emptyList() );
    final Type valueType = mapLike.getValueType();
    final Argument valueArgument =
      new Argument( "value",
                    valueType,
                    false,
                    false,
                    null,
                    null,
                    Collections.emptyList(),
                    Collections.emptyList() );

    // has operation
    writeOperation( writer,
                    jsType,
                    "has",
                    Collections.singletonList( keyArgument ),
                    new Type( Kind.Boolean, Collections.emptyList(), false, Collections.emptyList() ),
                    true,
                    false,
                    true );
    writeOperation( writer,
                    jsType,
                    "get",
                    Collections.singletonList( keyArgument ),
                    valueType,
                    true,
                    true,
                    false,
                    true );
    final ExtendedAttribute iteratorExtendedAttribute =
      ExtendedAttribute.createExtendedAttributeIdent( ExtendedAttributes.SEQUENCE_TYPE,
                                                      "Iterator",
                                                      Collections.emptyList() );
    writeOperation( writer,
                    jsType,
                    "keys",
                    Collections.emptyList(),
                    new SequenceType( keyType,
                                      Collections.singletonList( iteratorExtendedAttribute ),
                                      false,
                                      Collections.emptyList() ),
                    true,
                    false,
                    true );

    writeOperation( writer,
                    jsType,
                    "values",
                    Collections.emptyList(),
                    new SequenceType( valueType,
                                      Collections.singletonList( iteratorExtendedAttribute ),
                                      false,
                                      Collections.emptyList() ),
                    true,
                    false,
                    true );

    writer.write( "/**\n" );
    writer.write( " * @return {!Iterator<!Array<" );
    writeType( writer, keyType );
    writer.write( "|" );
    writeType( writer, valueType );
    writer.write( ">>}\n" );
    writer.write( " * @nosideeffects\n" );
    writer.write( " */\n" );
    writer.write( jsType + ".prototype.entries = function() {};\n" );

    writer.write( "/**\n" );
    writer.write( " * @return {!Iterator<!Array<" );
    writeType( writer, keyType );
    writer.write( "|" );
    writeType( writer, valueType );
    writer.write( ">>}\n" );
    writer.write( " * @nosideeffects\n" );
    writer.write( " */\n" );
    writer.write( jsType + ".prototype[Symbol.iterator] = function() {};\n" );

    writer.write( "/**\n" );
    writer.write( " * @param {function(" );
    writeType( writer, valueType );
    writer.write( ", " );
    writeType( writer, keyType );
    writer.write( ", MAP)} callback\n" );
    writer.write( " * @this {MAP}\n" );
    writer.write( " * @template MAP\n" );
    writer.write( " */\n" );
    writer.write( jsType + ".prototype.forEach = function(callback) {};\n" );

    if ( !mapLike.isReadOnly() )
    {
      final boolean setPresent =
        operations
          .stream()
          .anyMatch( o -> "set".equals( toJsName( o ) ) &&
                          2 == o.getArguments().size() &&
                          Kind.Void == o.getReturnType().getKind() );
      if ( !setPresent )
      {
        writeOperation( writer,
                        jsType,
                        "set",
                        Arrays.asList( keyArgument, valueArgument ),
                        new Type( Kind.Void, Collections.emptyList(), false, Collections.emptyList() ),
                        true,
                        false,
                        false );
      }
      final boolean deletePresent =
        operations
          .stream()
          .anyMatch( o -> "delete".equals( toJsName( o ) ) &&
                          1 == o.getArguments().size() &&
                          Kind.Boolean == o.getReturnType().getKind() );
      if ( !deletePresent )
      {
        writeOperation( writer,
                        jsType,
                        "delete",
                        Collections.singletonList( keyArgument ),
                        new Type( Kind.Boolean, Collections.emptyList(), false, Collections.emptyList() ),
                        true,
                        false,
                        false );
      }
      final boolean clearPresent =
        operations
          .stream()
          .anyMatch( o -> "clear".equals( toJsName( o ) ) &&
                          o.getArguments().isEmpty() &&
                          Kind.Void == o.getReturnType().getKind() );
      if ( !clearPresent )
      {
        writeOperation( writer,
                        jsType,
                        "clear",
                        Collections.emptyList(),
                        new Type( Kind.Void, Collections.emptyList(), false, Collections.emptyList() ),
                        true,
                        false,
                        false );
      }
    }
  }

  private void generateIterableOperations( @Nonnull final Writer writer,
                                           @Nonnull final String type,
                                           @Nonnull final IterableMember iterable )
    throws IOException
  {
    generateIterableKeysMethod( writer, type, iterable );
    generateIterableValuesMethod( writer, type, iterable );
    generateIterableEntriesMethod( writer, type, iterable );
    generateIterableForEachMethod( writer, type, iterable );
  }

  private void generateIterableForEachMethod( @Nonnull final Writer writer,
                                              @Nonnull final String type,
                                              @Nonnull final IterableMember iterable )
    throws IOException
  {
    final Type keyType = iterable.getKeyType();
    final Type valueType = iterable.getValueType();

    writer.write( "/**\n" );
    writer.write( " * @param {function(" );
    writeType( writer, valueType );
    writer.write( ", " );
    if ( null == keyType )
    {
      writer.write( "!number" );
    }
    else
    {
      writeType( writer, keyType );
    }
    writer.write( ", MAP)} callback\n" );
    writer.write( " * @this {MAP}\n" );
    writer.write( " * @template MAP\n" );
    writer.write( " */\n" );
    writer.write( type + ".prototype.forEach = function(callback) {};\n" );
  }

  private void generateIterableEntriesMethod( @Nonnull final Writer writer,
                                              @Nonnull final String type,
                                              @Nonnull final IterableMember iterable )
    throws IOException
  {
    final Type keyType = iterable.getKeyType();
    final Type valueType = iterable.getValueType();

    writer.write( "/**\n" );
    writer.write( " * @return {!Iterator<!Array<" );
    if ( null == keyType )
    {
      writer.write( "!number" );
    }
    else
    {
      writeType( writer, keyType );
    }
    writer.write( "|" );
    writeType( writer, valueType );
    writer.write( ">>}\n" );
    writer.write( " * @nosideeffects\n" );
    writer.write( " */\n" );
    writer.write( type + ".prototype.entries = function() {};\n" );

    writer.write( "/**\n" );
    writer.write( " * @return {!Iterator<!Array<" );
    if ( null == keyType )
    {
      writer.write( "!number" );
    }
    else
    {
      writeType( writer, keyType );
    }
    writer.write( "|" );
    writeType( writer, valueType );
    writer.write( ">>}\n" );
    writer.write( " * @nosideeffects\n" );
    writer.write( " */\n" );
    writer.write( type + ".prototype[Symbol.iterator] = function() {};\n" );
  }

  private void generateIterableKeysMethod( @Nonnull final Writer writer,
                                           @Nonnull final String type,
                                           @Nonnull final IterableMember iterable )
    throws IOException
  {
    final ExtendedAttribute iteratorExtendedAttribute =
      ExtendedAttribute.createExtendedAttributeIdent( ExtendedAttributes.SEQUENCE_TYPE,
                                                      "Iterator",
                                                      Collections.emptyList() );
    final Type declaredKeyType = iterable.getKeyType();
    final Type keyType =
      null == declaredKeyType ?
      new Type( Kind.Double, Collections.emptyList(), false, Collections.emptyList() ) :
      declaredKeyType;
    writeOperation( writer,
                    type,
                    "keys",
                    Collections.emptyList(),
                    new SequenceType( keyType,
                                      Collections.singletonList( iteratorExtendedAttribute ),
                                      false,
                                      Collections.emptyList() ),
                    true,
                    false,
                    true );
  }

  private void generateIterableValuesMethod( @Nonnull final Writer writer,
                                             @Nonnull final String type,
                                             @Nonnull final IterableMember iterable )
    throws IOException
  {
    final ExtendedAttribute iteratorExtendedAttribute =
      ExtendedAttribute.createExtendedAttributeIdent( ExtendedAttributes.SEQUENCE_TYPE,
                                                      "Iterator",
                                                      Collections.emptyList() );
    writeOperation( writer,
                    type,
                    "values",
                    Collections.emptyList(),
                    new SequenceType( iterable.getValueType(),
                                      Collections.singletonList( iteratorExtendedAttribute ),
                                      false,
                                      Collections.emptyList() ),
                    true,
                    false,
                    true );
  }

  private boolean shouldOperationBeAnOverride( @Nonnull final InterfaceDefinition definition,
                                               @Nonnull final String operationName )
  {
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
  }

  private void writeOperations( @Nonnull final Writer writer,
                                @Nullable final String type,
                                @Nonnull final List<OperationMember> operations,
                                final boolean onNamespace,
                                @Nonnull final Predicate<String> isOperationOverride )
    throws IOException
  {
    final Map<String, List<OperationMember>> operationMap =
      operations
        .stream()
        .filter( o -> null != toJsName( o ) )
        .filter( o -> OperationMember.Kind.CONSTRUCTOR != o.getKind() )
        .collect( Collectors.groupingBy( this::toJsName ) );
    for ( final Map.Entry<String, List<OperationMember>> entry : operationMap.entrySet() )
    {
      final String jsOperationName = entry.getKey();
      final List<OperationMember> operationsToMerge = entry.getValue();
      final OperationMember templateOperation = operationsToMerge.get( 0 );
      if ( isNotExcluded( templateOperation ) )
      {
        final boolean isNonStaticOperation = !onNamespace && OperationMember.Kind.STATIC != templateOperation.getKind();
        final boolean isOverride = isNonStaticOperation && isOperationOverride.test( jsOperationName );
        final boolean noSideEffects =
          templateOperation.isNoArgsExtendedAttributePresent( ExtendedAttributes.NO_SIDE_EFFECTS );
        if ( 1 == operationsToMerge.size() )
        {
          writeOperation( writer,
                          type,
                          jsOperationName,
                          templateOperation.getArguments(),
                          templateOperation.getReturnType(),
                          isNonStaticOperation,
                          isOverride,
                          noSideEffects );
        }
        else
        {
          writeOperation( writer,
                          type,
                          jsOperationName,
                          deriveArguments( operationsToMerge ),
                          deriveReturnType( operationsToMerge ),
                          isNonStaticOperation,
                          isOverride,
                          noSideEffects );
        }
      }
    }
  }

  private void writeTypeCatalog()
    throws IOException
  {
    final String content =
      _generatedTypes
        .stream()
        .sorted()
        .filter( t -> !_predefinedSymbols.contains( t ) )
        .collect( Collectors.joining( "\n" ) ) + "\n";
    writeFile( getMainResourcesDirectory().resolve( getBaseName().replaceAll( "\\.", File.separator ) + ".types" ),
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

  private void writeAttributes( @Nonnull final Writer writer,
                                @Nullable final String type,
                                @Nonnull final List<AttributeMember> attributes )
    throws IOException
  {
    for ( final AttributeMember attribute : attributes )
    {
      if ( isNotExcluded( attribute ) )
      {
        writeAttribute( writer, type, attribute );
      }
    }
  }

  private void writeAttribute( @Nonnull final Writer writer,
                               @Nullable final String type,
                               @Nonnull final AttributeMember attribute )
    throws IOException
  {
    writeAttribute( writer, type, attribute, attribute.getType() );
  }

  private void writeAttribute( @Nonnull final Writer writer,
                               @Nullable final String type,
                               @Nonnull final AttributeMember attribute,
                               @Nonnull final Type attributeType )
    throws IOException
  {
    final String jsSymbolName =
      ( null != type ?
        type + "." + ( attribute.getModifiers().contains( AttributeMember.Modifier.STATIC ) ? "" : "prototype." ) :
        "" ) + toJsName( attribute );
    if ( shouldGenerateSymbol( jsSymbolName ) )
    {
      writer.write( "/** @type {" );
      writeType( writer, attributeType, attributeType.isNullable(), true );
      writer.write( "} */ " );
      if ( null == type )
      {
        writer.write( "var " );
      }
      writer.write( jsSymbolName );
      writer.write( ";\n" );
    }
  }

  private void writeConstants( @Nonnull final Writer writer,
                               @Nullable final String type,
                               @Nonnull final List<ConstMember> constants,
                               final boolean addConstantsToType,
                               final boolean addConstantsToPrototype )
    throws IOException
  {
    for ( final ConstMember constant : constants )
    {
      if ( isNotExcluded( constant ) )
      {
        if ( addConstantsToType )
        {
          writeConstant( writer, type, constant, false );
        }
        if ( addConstantsToPrototype )
        {
          writeConstant( writer, type, constant, true );
        }
      }
    }
  }

  private void writeConstant( @Nonnull final Writer writer,
                              @Nullable final String type,
                              @Nonnull final ConstMember constant,
                              final boolean onPrototype )
    throws IOException
  {
    final String jsSymbolName =
      ( null != type ? type + "." + ( onPrototype ? "prototype." : "" ) : "" ) + toJsName( constant );
    if ( shouldGenerateSymbol( jsSymbolName ) )
    {
      writer.write( "/** @const {" );
      writeType( writer, constant.getType() );
      writer.write( "} */ " );
      if ( null == type )
      {
        writer.write( "var " );
      }
      writer.write( jsSymbolName );
      writer.write( ";\n" );
    }
  }

  private void writeOperation( @Nonnull final Writer writer,
                               @Nullable final String jsType,
                               @Nonnull final String jsName,
                               @Nonnull final List<Argument> arguments,
                               @Nonnull final Type returnType,
                               final boolean onPrototype,
                               final boolean override,
                               final boolean noSideEffects )
    throws IOException
  {
    writeOperation( writer,
                    jsType,
                    jsName,
                    arguments,
                    returnType,
                    returnType.isNullable(),
                    onPrototype,
                    override,
                    noSideEffects );
  }

  private void writeOperation( @Nonnull final Writer writer,
                               @Nullable final String jsType,
                               @Nonnull final String jsName,
                               @Nonnull final List<Argument> arguments,
                               @Nonnull final Type returnType,
                               final boolean returnNullable,
                               final boolean onPrototype,
                               final boolean override,
                               final boolean noSideEffects )
    throws IOException
  {
    final String jsSymbolName = ( null != jsType ? jsType + "." + ( onPrototype ? "prototype." : "" ) : "" ) + jsName;
    if ( shouldGenerateSymbol( jsSymbolName ) )
    {
      writer.write( "/**\n" );
      writeArgumentsJsDoc( writer, arguments );
      writer.write( " * @return {" );
      writeType( writer, returnType, returnNullable, true );
      writer.write( "}\n" );
      if ( override || ( onPrototype && OBJECT_PROTOTYPE_METHODS.contains( jsName ) ) )
      {
        writer.write( " * @override\n" );
      }
      if ( noSideEffects )
      {
        writer.write( " * @nosideeffects\n" );
      }
      writer.write( " */\n" );
      if ( null != jsType )
      {
        writer.write( jsSymbolName + " = function" + toArgumentsList( arguments ) + " {}\n" );
      }
      else
      {
        writer.write( "function " + jsSymbolName + toArgumentsList( arguments ) + " {}\n" );
      }
    }
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
      writer.write( toJsName( getSchema().getInterfaceByName( superType ) ) );
      writer.write( "}\n" );
    }
    for ( final String additionalLine : additionalLines )
    {
      writer.write( " * " );
      writer.write( additionalLine );
      writer.write( "\n" );
    }
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

  private void writeArgumentsJsDoc( @Nonnull final Writer writer, @Nonnull final List<Argument> arguments )
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
      writer.write( safeJsArgName( toJsName( argument ) ) );
      writer.write( "\n" );
    }
  }

  @Nonnull
  private String toArgumentsList( @Nonnull final List<Argument> arguments )
  {
    return "(" +
           arguments
             .stream()
             .map( this::toJsName )
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
      writeType( writer, argument.getType(), argument.getType().isNullable(), true );
      if ( argument.isOptional() )
      {
        writer.write( "=" );
      }
    }

    writer.write( "): " );
    writeType( writer, returnType, returnType.isNullable(), true );
    writer.write( "}" );
  }

  private void writeType( @Nonnull final Writer writer, @Nonnull final Type type )
    throws IOException
  {
    writeType( writer, type, type.isNullable(), false );
  }

  private void writeType( @Nonnull final Writer writer,
                          @Nonnull final Type type,
                          final boolean nullable,
                          final boolean synthesizeUnionTypes )
    throws IOException
  {
    final Kind kind = type.getKind();
    if ( Kind.TypeReference != kind && Kind.Union != kind && Kind.Any != kind && Kind.Void != kind )
    {
      writer.write( nullable ? "?" : "!" );
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
      final String sequenceType = type.getIdentValue( ExtendedAttributes.SEQUENCE_TYPE );
      writer.write( null == sequenceType ? "Array" : sequenceType );
      writer.write( "<" );
      final Type itemType = ( (SequenceType) type ).getItemType();
      writeType( writer, itemType, itemType.isNullable(), true );
      writer.write( ">" );
    }
    else if ( Kind.FrozenArray == kind )
    {
      writer.write( "Array<" );
      final Type itemType = ( (FrozenArrayType) type ).getItemType();
      writeType( writer, itemType, itemType.isNullable(), true );
      writer.write( ">" );
    }
    else if ( Kind.Promise == kind )
    {
      writer.write( "Promise<" );
      final Type resolveType = ( (PromiseType) type ).getResolveType();
      writeType( writer, resolveType, resolveType.isNullable(), true );
      writer.write( ">" );
    }
    else if ( Kind.Object == kind )
    {
      writer.write( "Object" );
    }
    else if ( Kind.Union == kind )
    {
      final UnionType unionType = (UnionType) type;
      if ( synthesizeUnionTypes &&
           !unionType.isNoArgsExtendedAttributePresent( ExtendedAttributes.SYNTHESIZED_RETURN ) )
      {
        writer.write( synthesizeUnionType( unionType ) );
      }
      else
      {
        writer.write( "(" );
        boolean first = true;
        for ( final Type memberType : unionType.getMemberTypes() )
        {
          if ( !first )
          {
            writer.write( "|" );
          }
          else
          {
            first = false;
          }
          writeType( writer, memberType, memberType.isNullable(), true );
        }
        writer.write( ")" );
      }
    }
    else if ( Kind.Record == kind )
    {
      final RecordType recordType = (RecordType) type;
      writer.write( "Object<" );
      writeType( writer, recordType.getKeyType(), recordType.getKeyType().isNullable(), true );
      writer.write( "," );
      writeType( writer, recordType.getValueType(), recordType.getValueType().isNullable(), true );
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
          final Type constantType = schema.getConstant( constEnumeration.getValues().get( 0 ) ).getType();
          writeType( writer, constantType, constantType.isNullable(), true );
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
            writer.write( toJsName( interfaceDefinition ) );
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

  private <T extends Named & Attributed> boolean tryRecordGeneratedType( @Nonnull final T element )
  {
    return tryRecordGeneratedType( toJsName( element ) );
  }

  private boolean tryRecordGeneratedType( @Nonnull final String jsName )
  {
    return shouldGenerateSymbol( jsName ) && _generatedTypes.add( jsName );
  }

  private boolean shouldGenerateSymbol( @Nonnull final String jsName )
  {
    return !_predefinedSymbols.contains( jsName );
  }
}
