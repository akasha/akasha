package org.realityforge.webtack.jsinterop;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ArrayTypeName;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.lang.model.element.Modifier;
import org.realityforge.webtack.model.Argument;
import org.realityforge.webtack.model.AttributeMember;
import org.realityforge.webtack.model.AttributedNode;
import org.realityforge.webtack.model.CallbackDefinition;
import org.realityforge.webtack.model.CallbackInterfaceDefinition;
import org.realityforge.webtack.model.ConstMember;
import org.realityforge.webtack.model.ConstValue;
import org.realityforge.webtack.model.DictionaryDefinition;
import org.realityforge.webtack.model.DictionaryMember;
import org.realityforge.webtack.model.DocumentationBlockTag;
import org.realityforge.webtack.model.DocumentationElement;
import org.realityforge.webtack.model.Element;
import org.realityforge.webtack.model.EnumerationDefinition;
import org.realityforge.webtack.model.EnumerationValue;
import org.realityforge.webtack.model.EventMember;
import org.realityforge.webtack.model.ExtendedAttribute;
import org.realityforge.webtack.model.InterfaceDefinition;
import org.realityforge.webtack.model.Kind;
import org.realityforge.webtack.model.MapLikeMember;
import org.realityforge.webtack.model.NamedDefinition;
import org.realityforge.webtack.model.NamedElement;
import org.realityforge.webtack.model.NamespaceDefinition;
import org.realityforge.webtack.model.OperationMember;
import org.realityforge.webtack.model.PartialInterfaceDefinition;
import org.realityforge.webtack.model.SequenceType;
import org.realityforge.webtack.model.Type;
import org.realityforge.webtack.model.TypeReference;
import org.realityforge.webtack.model.TypedefDefinition;
import org.realityforge.webtack.model.UnionType;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.tools.io.FilesUtil;
import org.realityforge.webtack.model.tools.util.AbstractJavaAction;
import org.realityforge.webtack.model.tools.util.BasicTypes;
import org.realityforge.webtack.model.tools.util.ExtendedAttributes;
import org.realityforge.webtack.model.tools.util.JsinteropTypes;
import org.realityforge.webtack.model.tools.util.NamingUtil;

final class JsinteropAction
  extends AbstractJavaAction
{
  /**
   * Logical/idl name used to refer to the transferrable marker interface.
   */
  @Nonnull
  private static final String TRANSFERABLE_IDL_NAME = "Transferable";
  /**
   * Pattern matcher used to process link annotations.
   */
  private final Pattern _linkMatcher = Pattern.compile( "\\{@link ([^ }]*)" );
  @Nullable
  private final String _globalInterface;
  private final boolean _generateGwtModule;
  private final boolean _generateTypeCatalog;
  private boolean _transferablePresent;

  JsinteropAction( @Nonnull final Path outputDirectory,
                   @Nonnull final String packageName,
                   @Nullable final String globalInterface,
                   @Nonnull final List<Path> predefinedTypeMappingPaths,
                   @Nonnull final List<Path> externalTypeMappingPaths,
                   final boolean generateGwtModule,
                   final boolean generateTypeCatalog,
                   final boolean enableMagicConstants )
  {
    super( outputDirectory, packageName, enableMagicConstants, predefinedTypeMappingPaths, externalTypeMappingPaths );
    _globalInterface = globalInterface;
    _generateGwtModule = generateGwtModule;
    _generateTypeCatalog = generateTypeCatalog;
  }

  @Override
  public void process( @Nonnull final WebIDLSchema schema )
    throws Exception
  {
    processInit( schema );

    FilesUtil.deleteDirectory( getMainJavaDirectory() );
    FilesUtil.deleteDirectory( getMainResourcesDirectory() );

    registerIdlTypeToJavaTypeMapping();
    registerDefaultTypeMapping();

    for ( final TypedefDefinition definition : schema.getTypedefs() )
    {
      final Type type = definition.getType();
      if ( Kind.Union == type.getKind() && !isIdlTypePredefined( definition.getName() ) )
      {
        generateUnion( definition.getName(), javaName( definition ), (UnionType) type );
      }
    }
    for ( final CallbackDefinition definition : schema.getCallbacks() )
    {
      if ( !isIdlTypePredefined( definition.getName() ) )
      {
        generateCallback( definition );
      }
    }
    for ( final CallbackInterfaceDefinition definition : schema.getCallbackInterfaces() )
    {
      if ( !isIdlTypePredefined( definition.getName() ) )
      {
        generateCallbackInterface( definition );
      }
    }
    for ( final DictionaryDefinition definition : schema.getDictionaries() )
    {
      if ( !isIdlTypePredefined( definition.getName() ) )
      {
        generateDictionary( definition );
      }
    }
    for ( final EnumerationDefinition definition : schema.getEnumerations() )
    {
      if ( !isIdlTypePredefined( definition.getName() ) )
      {
        generateEnumeration( definition );
      }
    }
    for ( final InterfaceDefinition definition : schema.getInterfaces() )
    {
      if ( !isIdlTypePredefined( definition.getName() ) )
      {
        generateInterface( definition );
      }
    }
    for ( final PartialInterfaceDefinition definition : schema.getPartialInterfaces() )
    {
      if ( !isIdlTypePredefined( definition.getName() ) )
      {
        generatePartialInterface( definition );
      }
    }
    for ( final NamespaceDefinition definition : schema.getNamespaces() )
    {
      if ( !isIdlTypePredefined( definition.getName() ) )
      {
        generateNamespace( definition );
      }
    }

    for ( final Map.Entry<String, UnionType> entry : getUnions().entrySet() )
    {
      final String name = entry.getKey();
      if ( !isIdlTypePredefined( name ) )
      {
        generateUnion( name, NamingUtil.uppercaseFirstCharacter( name ), entry.getValue() );
      }
    }

    if ( _transferablePresent && !isIdlTypePredefined( TRANSFERABLE_IDL_NAME ) )
    {
      writeTransferableInterface();
    }

    if ( _generateGwtModule )
    {
      writeGwtModule();
    }

    if ( null != _globalInterface )
    {
      generateGlobalThisInterface( _globalInterface );
    }

    if ( _generateTypeCatalog )
    {
      writeTypeCatalog();
    }
  }

  private void writeTransferableInterface()
    throws IOException
  {
    final TypeSpec.Builder type =
      TypeSpec
        .interfaceBuilder( lookupClassName( TRANSFERABLE_IDL_NAME ).simpleName() )
        .addModifiers( Modifier.PUBLIC );
    writeGeneratedAnnotation( type );
    type.addAnnotation( AnnotationSpec
                          .builder( JsinteropTypes.JS_TYPE )
                          .addMember( "isNative", "true" )
                          .addMember( "namespace", "$T.GLOBAL", JsinteropTypes.JS_PACKAGE )
                          .addMember( "name", "$S", "*" )
                          .build() );
    writeTopLevelType( type );
  }

  private void writeTypeCatalog()
    throws IOException
  {
    final String typeMappingContent =
      getIdlToClassNameMapping()
        .entrySet()
        .stream()
        .filter( e -> !isIdlTypePredefined( e.getKey() ) )
        .map( e -> e.getKey() + "=" + e.getValue() )
        .sorted()
        .collect( Collectors.joining( "\n" ) ) + "\n";
    final String name = NamingUtil.uppercaseFirstCharacter( getLeafPackageName() );
    writeResourceFile( getMainResourcesDirectory(),
                       name + ".mapping",
                       typeMappingContent.getBytes( StandardCharsets.UTF_8 ) );
  }

  private void generateGlobalThisInterface( @Nonnull final String globalInterface )
    throws IOException
  {
    final WebIDLSchema schema = getSchema();
    final InterfaceDefinition definition = schema.findInterfaceByName( globalInterface );
    if ( null == definition )
    {
      throw new IllegalStateException( "Declared globalInterface '" + globalInterface + "' does not exist in schema" );
    }
    final TypeSpec.Builder type =
      TypeSpec
        .classBuilder( "Global" )
        .addModifiers( Modifier.PUBLIC, Modifier.FINAL )
        .superclass( lookupClassName( definition.getName() ) );
    writeGeneratedAnnotation( type );
    type.addAnnotation( AnnotationSpec.builder( JsinteropTypes.JS_TYPE )
                          .addMember( "isNative", "true" )
                          .addMember( "namespace", "$T.GLOBAL", JsinteropTypes.JS_PACKAGE )
                          .addMember( "name", "$S", "goog.global" )
                          .build() );

    type.addJavadoc( "The global <b>globalThis</b> property or the global object.\n" +
                     "\n" +
                     "@see <a href=\"https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/globalThis\">globalThis - MDN</a>\n" );

    final OperationMember parentConstructor = schema
      .getInterfaceByName( definition.getName() )
      .getOperations()
      .stream()
      .filter( o -> OperationMember.Kind.CONSTRUCTOR == o.getKind() )
      .min( Comparator.comparingLong( o -> o.getArguments()
        .stream()
        .filter( a -> !a.isOptional() && !a.isVariadic() )
        .count() ) )
      .orElse( null );

    final MethodSpec.Builder method = MethodSpec.constructorBuilder().addModifiers( Modifier.PRIVATE );
    if ( null != parentConstructor )
    {
      generateSuperCall( parentConstructor, method );
    }
    type.addMethod( method.build() );

    for ( final NamespaceDefinition namespace : schema.getNamespaces() )
    {
      final String name = namespace.getName();
      type.addMethod( MethodSpec
                        .methodBuilder( NamingUtil.camelCase( safeJsPropertyMethodName( name ) ) )
                        .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
                        .returns( lookupClassName( namespace.getName() ) )
                        .addAnnotation( AnnotationSpec
                                          .builder( JsinteropTypes.JS_PROPERTY )
                                          .addMember( "name", "$S", name )
                                          .build() )
                        .addAnnotation( BasicTypes.NONNULL ).build() );
    }

    final TypeName globalType = ClassName.bestGuess( "Global" );

    type.addField( FieldSpec.builder( globalType, "globalThis", Modifier.PRIVATE, Modifier.STATIC ).build() );

    type.addMethod( MethodSpec.methodBuilder( "globalThis" )
                      .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                      .addAnnotation( JsinteropTypes.JS_OVERLAY )
                      .addAnnotation( BasicTypes.NONNULL )
                      .returns( globalType )
                      .addStatement( "return globalThis" )
                      .addJavadoc( "Accessor for the global <b>globalThis</b> property contains the global " +
                                   "<i>this</i> value, which is akin to the global object.\n" +
                                   "\n" +
                                   "@return the global object\n" +
                                   "@see <a href=\"https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/globalThis\">globalThis - MDN</a>\n" )
                      .build() );

    writeTopLevelType( type );
  }

  private void writeGwtModule()
    throws IOException
  {
    final String gwtModuleContent =
      "<module>\n" +
      "  <inherits name='jsinterop.base.Base'/>\n" +
      "  <inherits name='elemental2.promise.Promise'/>\n" +
      "  <inherits name='elemental2.core.Core'/>\n" +
      "\n" +
      "  <source path=''/>\n" +
      "</module>\n";
    final String name = NamingUtil.uppercaseFirstCharacter( getLeafPackageName() );
    writeResourceFile( getMainJavaDirectory(), name + ".gwt.xml", gwtModuleContent.getBytes( StandardCharsets.UTF_8 ) );
  }

  private void generateUnion( @Nonnull final String idlName,
                              @Nonnull final String javaName,
                              @Nonnull final UnionType unionType )
    throws IOException
  {
    final TypeSpec.Builder type =
      TypeSpec
        .interfaceBuilder( javaName )
        .addModifiers( Modifier.PUBLIC );
    writeGeneratedAnnotation( type );
    type.addAnnotation( AnnotationSpec.builder( JsinteropTypes.JS_TYPE )
                          .addMember( "isNative", "true" )
                          .addMember( "namespace", "$T.GLOBAL", JsinteropTypes.JS_PACKAGE )
                          .addMember( "name", "$S", "?" )
                          .build() );

    generateUnionOfMethods( idlName, unionType, type );

    writeTopLevelType( idlName, type );
  }

  @Nonnull
  private List<List<TypedValue>> explodeTypeList( @Nonnull final List<AttributedNode> nodes,
                                                  @Nonnull final List<Type> types )
  {
    final List<List<TypedValue>> results = new ArrayList<>();
    results.add( new ArrayList<>() );
    int i = 0;
    for ( final Type type : types )
    {
      final AttributedNode node = nodes.get( i );
      i++;
      final List<TypedValue> itemTypes = explodeType( node, type );
      if ( 1 == itemTypes.size() )
      {
        final TypedValue itemType = itemTypes.get( 0 );
        results.forEach( result -> result.add( itemType ) );
      }
      else
      {
        final List<List<TypedValue>> dupList = new ArrayList<>( results );
        results.clear();
        for ( final TypedValue itemType : itemTypes )
        {
          for ( final List<TypedValue> result : dupList )
          {
            final List<TypedValue> newList = new ArrayList<>( result );
            newList.add( itemType );
            results.add( newList );
          }
        }
      }
    }
    return results;
  }

  @Nonnull
  private List<TypedValue> explodeType( @Nullable final AttributedNode node, @Nonnull final Type type )
  {
    final List<TypedValue> values = new ArrayList<>();
    explodeType( node, type, type, values );
    return values;
  }

  private void explodeType( @Nullable final AttributedNode node,
                            @Nonnull final Type declaredType,
                            @Nonnull final Type type,
                            @Nonnull final List<TypedValue> values )
  {
    final Kind kind = type.getKind();
    if ( Kind.TypeReference == type.getKind() )
    {
      final String name = ( (TypeReference) type ).getName();
      final WebIDLSchema schema = getSchema();
      final TypedefDefinition typedef = schema.findTypedefByName( name );
      if ( null != typedef )
      {
        final Type resolvedType = typedef.getType();
        if ( Kind.Union == resolvedType.getKind() )
        {
          final boolean nullable = schema.isNullable( type );
          values.add( new TypedValue( declaredType,
                                      type,
                                      lookupClassName( name ),
                                      nullable ? TypedValue.Nullability.NULLABLE : TypedValue.Nullability.NONNULL,
                                      false ) );
        }
        explodeType( node, declaredType, resolvedType, values );
      }
      else
      {
        final boolean nullable = getSchema().isNullable( type );
        values.add( new TypedValue( declaredType,
                                    type,
                                    toTypeName( type ),
                                    nullable ? TypedValue.Nullability.NULLABLE : TypedValue.Nullability.NONNULL,
                                    false ) );
      }
    }
    else if ( Kind.Any == kind )
    {
      values.add( new TypedValue( declaredType, type, TypeName.OBJECT, TypedValue.Nullability.NULLABLE, true ) );
    }
    else if ( Kind.Union == kind )
    {
      final UnionType unionType = (UnionType) type;
      for ( final Type memberType : unionType.getMemberTypes() )
      {
        explodeType( node, declaredType, memberType, values );
      }
    }
    else if ( Kind.Sequence == kind )
    {
      final SequenceType sequenceType = (SequenceType) type;
      final Type itemType = sequenceType.getItemType();
      final boolean nullable = getSchema().isNullable( type );
      final TypeName javaType;
      final TypeName arrayJavaType;
      if ( Kind.Object == itemType.getKind() &&
           null != node &&
           node.isNoArgsExtendedAttributePresent( ExtendedAttributes.TRANSFERABLE ) )
      {
        final ClassName transferableTypeName = lookupClassName( TRANSFERABLE_IDL_NAME );
        javaType = ParameterizedTypeName.get( lookupClassName( Kind.Sequence.name() ), transferableTypeName );
        arrayJavaType = ArrayTypeName.of( transferableTypeName );
      }
      else
      {
        javaType = toTypeName( type );
        arrayJavaType = ArrayTypeName.of( getUnexpandedType( itemType ) );
      }
      final TypedValue.Nullability nullability =
        nullable ? TypedValue.Nullability.NULLABLE : TypedValue.Nullability.NONNULL;
      values.add( new TypedValue( declaredType, type, javaType, nullability, false ) );
      values.add( new TypedValue( declaredType, type, arrayJavaType, nullability, false ) );
    }
    else
    {
      final boolean nullable = getSchema().isNullable( type );
      TypeName javaType = toTypeName( type );
      if ( nullable )
      {
        javaType = javaType.box();
      }
      final TypedValue.Nullability nullability =
        javaType.isPrimitive() ? TypedValue.Nullability.NA :
        nullable ? TypedValue.Nullability.NULLABLE :
        TypedValue.Nullability.NONNULL;
      values.add( new TypedValue( declaredType, type, javaType, nullability, false ) );
    }
  }

  private void generateUnionOfMethods( @Nonnull final String idlName,
                                       @Nonnull final UnionType unionType,
                                       @Nonnull final TypeSpec.Builder type )
  {
    final TypeName self = lookupClassName( idlName );
    final List<Type> memberTypes = unionType.getMemberTypes();
    for ( final Type memberType : memberTypes )
    {
      for ( final TypedValue typedValue : explodeType( null, memberType ) )
      {
        final ParameterSpec.Builder parameter =
          ParameterSpec.builder( typedValue.getJavaType(), "value", Modifier.FINAL );

        addMagicConstantAnnotationIfNeeded( typedValue.getType(), parameter );
        final ClassName methodNullability;
        final TypedValue.Nullability nullability = typedValue.getNullability();
        if ( TypedValue.Nullability.NULLABLE == nullability )
        {
          parameter.addAnnotation( BasicTypes.NULLABLE );
          methodNullability = BasicTypes.NULLABLE;
        }
        else if ( TypedValue.Nullability.NONNULL == nullability )
        {
          parameter.addAnnotation( BasicTypes.NONNULL );
          methodNullability = BasicTypes.NONNULL;
        }
        else
        {
          methodNullability = BasicTypes.NONNULL;
        }

        type.addMethod( MethodSpec
                          .methodBuilder( "of" )
                          .addAnnotation( JsinteropTypes.JS_OVERLAY )
                          .addAnnotation( methodNullability )
                          .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                          .addParameter( parameter.build() )
                          .addStatement( "return $T.cast( value )", JsinteropTypes.JS )
                          .returns( self ).build() );
      }
    }
  }

  private void generateDictionary( @Nonnull final DictionaryDefinition definition )
    throws IOException
  {
    final TypeSpec.Builder type =
      TypeSpec
        .interfaceBuilder( rawLookupClassName( definition.getName() ).simpleName() )
        .addModifiers( Modifier.PUBLIC );
    writeGeneratedAnnotation( type );
    type.addAnnotation( AnnotationSpec.builder( JsinteropTypes.JS_TYPE )
                          .addMember( "isNative", "true" )
                          .addMember( "namespace", "$T.GLOBAL", JsinteropTypes.JS_PACKAGE )
                          .addMember( "name", "$S", "?" )
                          .build() );
    maybeAddJavadoc( definition, type );

    final String inherits = definition.getInherits();
    if ( null != inherits )
    {
      type.addSuperinterface( lookupClassName( inherits ) );
    }

    final List<DictionaryMember> requiredMembers = getRequiredDictionaryMembers( definition );
    final List<List<TypedValue>> explodedTypeList =
      explodeTypeList( requiredMembers.stream().map( v -> (AttributedNode) v ).collect( Collectors.toList() ),
                       requiredMembers.stream().map( DictionaryMember::getType ).collect( Collectors.toList() ) );
    for ( final List<TypedValue> argTypes : explodedTypeList )
    {
      generateDictionaryCreateMethod( definition, requiredMembers, argTypes, type );
    }

    final WebIDLSchema schema = getSchema();
    for ( final DictionaryMember member : definition.getMembers() )
    {
      final Type actualType = schema.resolveType( member.getType() );
      final TypeName javaType;
      if ( Kind.Sequence == actualType.getKind() &&
           Kind.Object == ( (SequenceType) actualType ).getItemType().getKind() &&
           member.isNoArgsExtendedAttributePresent( ExtendedAttributes.TRANSFERABLE ) )
      {
        final ClassName transferableTypeName = lookupClassName( TRANSFERABLE_IDL_NAME );
        javaType = ParameterizedTypeName.get( lookupClassName( Kind.Sequence.name() ), transferableTypeName );
      }
      else
      {
        javaType = toTypeName( actualType );
      }

      generateDictionaryMemberGetter( member, actualType, javaType, type );
      generateDictionaryMemberSetter( member, actualType, javaType, type );
      for ( final TypedValue typedValue : explodeType( member, member.getType() ) )
      {
        if ( Kind.Any != actualType.getKind() && !javaType.equals( typedValue.getJavaType() ) )
        {
          generateDictionaryMemberOverlaySetter( member, typedValue, type );
        }
        generateDictionaryMemberSetterReturningThis( definition, member, typedValue, false, type );
      }
    }
    String superName = definition.getInherits();
    while ( null != superName )
    {
      final DictionaryDefinition parent = schema.getDictionaryByName( superName );
      for ( final DictionaryMember member : parent.getMembers() )
      {
        for ( final TypedValue memberType : explodeType( member, member.getType() ) )
        {
          generateDictionaryMemberSetterReturningThis( definition, member, memberType, true, type );
        }
      }
      superName = parent.getInherits();
    }

    writeTopLevelType( definition.getName(), type );
  }

  private void generateDictionaryCreateMethod( @Nonnull final DictionaryDefinition definition,
                                               @Nonnull final List<DictionaryMember> requiredMembers,
                                               @Nonnull final List<TypedValue> types,
                                               @Nonnull final TypeSpec.Builder type )
  {
    final TypeName self = lookupClassName( definition.getName() );
    final MethodSpec.Builder method = MethodSpec
      .methodBuilder( "create" )
      .addAnnotation( JsinteropTypes.JS_OVERLAY )
      .addAnnotation( BasicTypes.NONNULL )
      .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
      .returns( self );
    if ( requiredMembers.isEmpty() )
    {
      method.addStatement( "return $T.uncheckedCast( $T.of() )", JsinteropTypes.JS, JsinteropTypes.JS_PROPERTY_MAP );
    }
    else
    {
      final List<Object> params = new ArrayList<>();
      final StringBuilder sb = new StringBuilder();
      sb.append( "return $T.<$T>uncheckedCast( $T.of() )" );
      params.add( JsinteropTypes.JS );
      params.add( self );
      params.add( JsinteropTypes.JS_PROPERTY_MAP );

      int index = 0;
      for ( final DictionaryMember member : requiredMembers )
      {
        final String paramName = javaName( member );
        sb.append( ".$N( $N )" );
        params.add( javaMethodName( member ) );
        params.add( paramName );

        final TypedValue memberType = types.get( index++ );
        final ParameterSpec.Builder parameter =
          ParameterSpec.builder( memberType.getJavaType(), paramName, Modifier.FINAL );
        addMagicConstantAnnotationIfNeeded( member.getType(), parameter );
        addDoNotAutoboxAnnotation( memberType, parameter );
        addNullabilityAnnotation( memberType, parameter );
        method.addParameter( parameter.build() );
      }
      method.addStatement( sb.toString(), params.toArray() );
    }
    type.addMethod( method.build() );
  }

  @Nonnull
  private List<DictionaryMember> getRequiredDictionaryMembers( @Nonnull final DictionaryDefinition definition )
  {
    final List<DictionaryMember> requiredMembers = new ArrayList<>();
    collectRequiredDictionaryMembers( definition, requiredMembers );
    return requiredMembers;
  }

  private void collectRequiredDictionaryMembers( @Nonnull final DictionaryDefinition definition,
                                                 @Nonnull final List<DictionaryMember> members )
  {
    final String inherits = definition.getInherits();
    if ( null != inherits )
    {
      collectRequiredDictionaryMembers( getSchema().getDictionaryByName( inherits ), members );
    }

    definition.getMembers().stream().filter( m -> !m.isOptional() ).forEach( members::add );
  }

  private void generateDictionaryMemberGetter( @Nonnull final DictionaryMember member,
                                               @Nonnull final Type actualType,
                                               @Nonnull final TypeName javaType,
                                               @Nonnull final TypeSpec.Builder type )
  {
    final MethodSpec.Builder method =
      MethodSpec
        .methodBuilder( safeJsPropertyMethodName( member.getName() ) )
        .addModifiers( Modifier.PUBLIC, Modifier.ABSTRACT )
        .returns( javaType );
    method.addAnnotation( AnnotationSpec
                            .builder( JsinteropTypes.JS_PROPERTY )
                            .addMember( "name", "$S", member.getName() )
                            .build() );
    maybeAddJavadoc( member, method );
    addMagicConstantAnnotationIfNeeded( member.getType(), method );
    if ( getSchema().isNullable( member.getType() ) )
    {
      method.addAnnotation( BasicTypes.NULLABLE );
    }
    else
    {
      if ( !actualType.getKind().isPrimitive() && !member.isOptional() )
      {
        method.addAnnotation( BasicTypes.NONNULL );
      }
    }
    type.addMethod( method.build() );
  }

  private void generateDictionaryMemberSetter( @Nonnull final DictionaryMember member,
                                               @Nonnull final Type actualType,
                                               @Nonnull final TypeName javaType,
                                               @Nonnull final TypeSpec.Builder type )
  {
    final MethodSpec.Builder method =
      MethodSpec
        .methodBuilder( getMutatorName( member ) )
        .addModifiers( Modifier.PUBLIC, Modifier.ABSTRACT )
        .addAnnotation( JsinteropTypes.JS_PROPERTY );
    maybeAddJavadoc( member, method );
    final boolean isAny = Kind.Any == actualType.getKind();
    final ParameterSpec.Builder parameter =
      ParameterSpec.builder( isAny ? TypeName.OBJECT : javaType, javaName( member ) );
    if ( isAny )
    {
      parameter.addAnnotation( JsinteropTypes.DO_NOT_AUTOBOX );
    }
    addMagicConstantAnnotationIfNeeded( member.getType(), parameter );

    if ( getSchema().isNullable( member.getType() ) )
    {
      parameter.addAnnotation( BasicTypes.NULLABLE );
    }
    else if ( !actualType.getKind().isPrimitive() )
    {
      parameter.addAnnotation( BasicTypes.NONNULL );
    }
    method.addParameter( parameter.build() );
    type.addMethod( method.build() );
  }

  private void generateDictionaryMemberOverlaySetter( @Nonnull final DictionaryMember member,
                                                      @Nonnull final TypedValue typedValue,
                                                      @Nonnull final TypeSpec.Builder type )
  {
    final String mutatorName = getMutatorName( member );
    final MethodSpec.Builder method =
      MethodSpec
        .methodBuilder( mutatorName )
        .addModifiers( Modifier.PUBLIC, Modifier.DEFAULT )
        .addAnnotation( JsinteropTypes.JS_OVERLAY );
    maybeAddJavadoc( member, method );
    final String paramName = javaName( member );
    final TypeName javaType = typedValue.getJavaType();
    final ParameterSpec.Builder parameter =
      ParameterSpec.builder( javaType, paramName, Modifier.FINAL );

    if ( javaType instanceof ArrayTypeName )
    {
      method.varargs();
      final ArrayTypeName javaArrayType = (ArrayTypeName) javaType;
      if ( javaArrayType.componentType instanceof ArrayTypeName ||
           javaArrayType.componentType instanceof ParameterizedTypeName )
      {
        method.addAnnotation( AnnotationSpec
                                .builder( SuppressWarnings.class )
                                .addMember( "value", "$S", "unchecked" )
                                .build() );
      }
    }

    addMagicConstantAnnotationIfNeeded( member.getType(), parameter );
    addDoNotAutoboxAnnotation( typedValue, parameter );
    addNullabilityAnnotation( typedValue, parameter );
    method.addParameter( parameter.build() );
    final WebIDLSchema schema = getSchema();
    final Type declaredType = schema.resolveType( typedValue.getDeclaredType() );
    final Type resolvedType = schema.resolveType( typedValue.getType(), true );
    if ( Kind.Union == declaredType.getKind() || unwrapsToUnion( declaredType ) )
    {
      method.addStatement( "$N( $T.of( $N ) )", mutatorName, toTypeName( declaredType ), paramName );
    }
    else if ( Kind.Sequence == declaredType.getKind() || Kind.Sequence == resolvedType.getKind() )
    {
      final Type itemType = ( (SequenceType) resolvedType ).getItemType();
      final TypeName itemJavaType;
      if ( Kind.Object == itemType.getKind() &&
           member.isNoArgsExtendedAttributePresent( ExtendedAttributes.TRANSFERABLE ) )
      {
        itemJavaType = lookupClassName( TRANSFERABLE_IDL_NAME );
      }
      else
      {
        itemJavaType = toTypeName( itemType, true );
      }
      method.addStatement( "$N( $T.<$T>uncheckedCast( $N ) )",
                           mutatorName,
                           JsinteropTypes.JS,
                           ParameterizedTypeName.get( lookupClassName( Kind.Sequence.name() ), itemJavaType ),
                           paramName );
    }
    else if ( Kind.Any == declaredType.getKind() && typedValue.doNotAutobox() )
    {
      method.addStatement( "$N( $T.asAny( $N ) )", mutatorName, JsinteropTypes.JS, paramName );
    }
    else
    {
      throw new UnsupportedOperationException( "Create method for dictionary does not yet support exploding " +
                                               typedValue.getType() + " from " + declaredType );
    }
    type.addMethod( method.build() );
  }

  private boolean unwrapsToUnion( @Nonnull final Type type )
  {
    final Kind kind = type.getKind();
    if ( Kind.TypeReference == kind )
    {
      final String name = ( (TypeReference) type ).getName();
      final TypedefDefinition typedef = getSchema().findTypedefByName( name );
      if ( null != typedef )
      {
        final Type otherType = typedef.getType();
        return Kind.Union == otherType.getKind() || unwrapsToUnion( otherType );
      }
    }
    return false;
  }

  private void generateDictionaryMemberSetterReturningThis( @Nonnull final DictionaryDefinition dictionary,
                                                            @Nonnull final DictionaryMember member,
                                                            @Nonnull final TypedValue typedValue,
                                                            final boolean addOverride,
                                                            @Nonnull final TypeSpec.Builder type )
  {
    final MethodSpec.Builder method =
      MethodSpec
        .methodBuilder( javaMethodName( member ) )
        .addModifiers( Modifier.PUBLIC, Modifier.DEFAULT )
        .addAnnotation( JsinteropTypes.JS_OVERLAY )
        .addAnnotation( BasicTypes.NONNULL )
        .returns( lookupClassName( dictionary.getName() ) );
    maybeAddJavadoc( member, method );
    if ( addOverride )
    {
      method.addAnnotation( Override.class );
    }
    final TypeName javaType = typedValue.getJavaType();
    final String paramName = javaName( member );
    final ParameterSpec.Builder parameter =
      ParameterSpec.builder( javaType, paramName, Modifier.FINAL );

    addMagicConstantAnnotationIfNeeded( member.getType(), parameter );
    addDoNotAutoboxAnnotation( typedValue, parameter );
    addNullabilityAnnotation( typedValue, parameter );

    if ( javaType instanceof ArrayTypeName )
    {
      method.varargs();
      final ArrayTypeName javaArrayType = (ArrayTypeName) javaType;
      if ( javaArrayType.componentType instanceof ArrayTypeName ||
           javaArrayType.componentType instanceof ParameterizedTypeName )
      {
        method.addAnnotation( AnnotationSpec
                                .builder( SuppressWarnings.class )
                                .addMember( "value", "$S", "unchecked" )
                                .build() );
      }
    }

    method.addParameter( parameter.build() );
    method.addStatement( "$N( $N )", getMutatorName( member ), paramName );
    method.addStatement( "return this" );
    type.addMethod( method.build() );
  }

  private void addNullabilityAnnotation( @Nonnull final TypedValue typedValue,
                                         @Nonnull final ParameterSpec.Builder parameter )
  {
    final TypedValue.Nullability nullability = typedValue.getNullability();
    if ( TypedValue.Nullability.NULLABLE == nullability )
    {
      parameter.addAnnotation( BasicTypes.NULLABLE );
    }
    else if ( TypedValue.Nullability.NONNULL == nullability )
    {
      parameter.addAnnotation( BasicTypes.NONNULL );
    }
  }

  private void addDoNotAutoboxAnnotation( @Nonnull final TypedValue typedValue,
                                          @Nonnull final ParameterSpec.Builder parameter )
  {
    if ( typedValue.doNotAutobox() )
    {
      parameter.addAnnotation( JsinteropTypes.DO_NOT_AUTOBOX );
    }
  }

  @Nonnull
  private String getMutatorName( @Nonnull final DictionaryMember member )
  {
    return "set" + NamingUtil.uppercaseFirstCharacter( member.getName() );
  }

  private void generateCallback( @Nonnull final CallbackDefinition definition )
    throws IOException
  {
    final TypeSpec.Builder type =
      TypeSpec
        .interfaceBuilder( rawLookupClassName( definition.getName() ).simpleName() )
        .addModifiers( Modifier.PUBLIC );
    writeGeneratedAnnotation( type );
    type
      .addAnnotation( JsinteropTypes.JS_FUNCTION )
      .addAnnotation( FunctionalInterface.class );
    maybeAddJavadoc( definition, type );
    final MethodSpec.Builder method =
      MethodSpec
        .methodBuilder( "onInvoke" )
        .addModifiers( Modifier.PUBLIC, Modifier.ABSTRACT );
    emitReturnType( definition.getReturnType(), method );
    for ( final Argument argument : definition.getArguments() )
    {
      generateArgument( argument, asTypedValue( argument.getType() ), false, method );
    }
    type.addMethod( method.build() );

    writeTopLevelType( definition.getName(), type );
  }

  @Nonnull
  private TypedValue asTypedValue( @Nonnull final Type type )
  {
    // This method is only called for arguments to callback interfaces a callbacks
    final WebIDLSchema schema = getSchema();
    final Type resolveType = schema.resolveType( type );
    if ( Kind.Any == type.getKind() )
    {
      return new TypedValue( type, resolveType, TypeName.OBJECT, TypedValue.Nullability.NULLABLE, true );
    }
    else
    {
      final TypeName javaType = toTypeName( resolveType );
      final TypedValue.Nullability nullability =
        javaType.isPrimitive() ? TypedValue.Nullability.NA :
        schema.isNullable( type ) ? TypedValue.Nullability.NULLABLE :
        TypedValue.Nullability.NONNULL;
      return new TypedValue( type, resolveType, javaType, nullability, false );
    }
  }

  private void generateCallbackInterface( @Nonnull final CallbackInterfaceDefinition definition )
    throws IOException
  {
    final boolean exposedOnGlobal = isExposedOnGlobal( definition );
    final String name = definition.getName();
    final TypeSpec.Builder type =
      TypeSpec
        .interfaceBuilder( rawLookupClassName( definition.getName() ).simpleName() )
        .addModifiers( Modifier.PUBLIC );
    writeGeneratedAnnotation( type );
    type.addAnnotation( AnnotationSpec.builder( JsinteropTypes.JS_TYPE )
                          .addMember( "isNative", "true" )
                          .addMember( "namespace", "$T.GLOBAL", JsinteropTypes.JS_PACKAGE )
                          .addMember( "name", "$S", exposedOnGlobal ? name : "?" )
                          .build() )
      .addAnnotation( FunctionalInterface.class );
    maybeAddJavadoc( definition, type );

    generateConstants( definition.getConstants(), type );

    final OperationMember operation = definition.getOperation();
    final List<Argument> arguments = operation.getArguments();
    final List<TypedValue> typedValues = asTypedValuesList( arguments );
    generateDefaultOperation( operation, true, arguments, typedValues, type );

    writeTopLevelType( name, type );
  }

  @Nonnull
  private List<TypedValue> asTypedValuesList( @Nonnull final List<Argument> arguments )
  {
    return arguments.stream().map( a -> asTypedValue( a.getType() ) ).collect( Collectors.toList() );
  }

  private void generatePartialInterface( @Nonnull final PartialInterfaceDefinition definition )
    throws IOException
  {
    final String name = definition.getName();
    final TypeSpec.Builder type =
      TypeSpec
        .classBuilder( rawLookupClassName( definition.getName() ).simpleName() )
        .addModifiers( Modifier.PUBLIC, Modifier.FINAL );
    writeGeneratedAnnotation( type );
    maybeAddJavadoc( definition, type );

    generateConstants( definition.getConstants(), type );

    type.addMethod( MethodSpec
                      .methodBuilder( "of" )
                      .addAnnotation( JsinteropTypes.JS_OVERLAY )
                      .addAnnotation( BasicTypes.NONNULL )
                      .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                      .returns( lookupClassName( name ) )
                      .addParameter( ParameterSpec
                                       .builder( TypeName.OBJECT, "object", Modifier.FINAL )
                                       .addAnnotation( BasicTypes.NONNULL )
                                       .build() )
                      .addStatement( "return $T.cast( object )", JsinteropTypes.JS )
                      .build() );

    type.addMethod( MethodSpec
                      .constructorBuilder()
                      .addModifiers( Modifier.PRIVATE )
                      .build() );

    generateAttributes( definition.getAttributes(), type );
    generateOperations( definition.getOperations(), type );

    final MapLikeMember mapLike = definition.getMapLikeMember();
    if ( null != mapLike )
    {
      generateMapLikeOperations( name, definition.getOperations(), mapLike, type );
    }
    if ( null != definition.getAsyncIterable() )
    {
      throw new UnsupportedOperationException( "async iterable not yet supported in code generator" );
    }
    if ( null != definition.getSetLikeMember() )
    {
      throw new UnsupportedOperationException( "setlike not yet supported in code generator" );
    }
    final boolean noPublicSymbol =
      definition.isNoArgsExtendedAttributePresent( ExtendedAttributes.LEGACY_NO_INTERFACE_OBJECT );
    type.addAnnotation( AnnotationSpec.builder( JsinteropTypes.JS_TYPE )
                          .addMember( "isNative", "true" )
                          .addMember( "namespace", "$T.GLOBAL", JsinteropTypes.JS_PACKAGE )
                          .addMember( "name", "$S", noPublicSymbol ? "Object" : name )
                          .build() );

    writeTopLevelType( name, type );
  }

  private void generateOperations( @Nonnull final List<OperationMember> operations,
                                   @Nonnull final TypeSpec.Builder type )
  {
    operations
      .stream()
      .sorted()
      .forEach( operation -> generateOperation( operation, type ) );
  }

  private void generateOperation( @Nonnull final OperationMember operation, @Nonnull final TypeSpec.Builder type )
  {
    final OperationMember.Kind operationKind = operation.getKind();
    if ( OperationMember.Kind.DEFAULT == operationKind )
    {
      generateDefaultOperation( operation, type );
    }
    else if ( OperationMember.Kind.STRINGIFIER == operationKind && null != operation.getName() )
    {
      generateDefaultOperation( operation, type );
    }
  }

  private void generateNamespace( @Nonnull final NamespaceDefinition definition )
    throws IOException
  {
    final String name = definition.getName();
    final TypeSpec.Builder type =
      TypeSpec
        // The type "console" starts with a lower case name due to legacy reasons.
        // This next line just makes sure that an uppercase is used for the java type
        .classBuilder( rawLookupClassName( definition.getName() ).simpleName() )
        .addModifiers( Modifier.PUBLIC, Modifier.FINAL );
    writeGeneratedAnnotation( type );
    maybeAddJavadoc( definition, type );

    generateAttributes( definition.getAttributes(), type );
    generateOperations( definition.getOperations(), type );

    type.addAnnotation( AnnotationSpec
                          .builder( JsinteropTypes.JS_TYPE )
                          .addMember( "isNative", "true" )
                          .addMember( "namespace", "$T.GLOBAL", JsinteropTypes.JS_PACKAGE )
                          .addMember( "name", "$S", name )
                          .build() );

    type.addMethod( MethodSpec.constructorBuilder().addModifiers( Modifier.PRIVATE ).build() );

    writeTopLevelType( name, type );
  }

  private void generateInterface( @Nonnull final InterfaceDefinition definition )
    throws IOException
  {
    final String name = definition.getName();
    final TypeSpec.Builder type =
      TypeSpec
        .classBuilder( rawLookupClassName( definition.getName() ).simpleName() )
        .addModifiers( Modifier.PUBLIC );
    writeGeneratedAnnotation( type );
    maybeAddJavadoc( definition, type );

    if ( definition.isNoArgsExtendedAttributePresent( ExtendedAttributes.TRANSFERABLE ) )
    {
      type.addSuperinterface( lookupClassName( TRANSFERABLE_IDL_NAME ) );
      _transferablePresent = true;
    }

    final String inherits = definition.getInherits();
    final OperationMember parentConstructor;
    final WebIDLSchema schema = getSchema();
    if ( null != inherits )
    {
      parentConstructor = schema
        .getInterfaceByName( inherits )
        .getOperations()
        .stream()
        .filter( o -> OperationMember.Kind.CONSTRUCTOR == o.getKind() )
        .min( Comparator.comparingLong( o -> o.getArguments()
          .stream()
          .filter( a -> !a.isOptional() && !a.isVariadic() )
          .count() ) )
        .orElse( null );
      type.superclass( lookupClassName( inherits ) );
    }
    else
    {
      parentConstructor = null;
    }

    generateConstants( definition.getConstants(), type );
    generateAttributes( definition.getAttributes(), type );

    boolean constructorPresent = false;
    for ( final OperationMember operation : definition.getOperations() )
    {
      final OperationMember.Kind operationKind = operation.getKind();
      if ( OperationMember.Kind.DEFAULT == operationKind )
      {
        generateDefaultOperation( operation, type );
      }
      else if ( ( OperationMember.Kind.STRINGIFIER == operationKind ||
                  OperationMember.Kind.GETTER == operationKind ||
                  OperationMember.Kind.SETTER == operationKind ||
                  OperationMember.Kind.DELETER == operationKind ) &&
                null != operation.getName() )
      {
        generateDefaultOperation( operation, type );
      }
      else if ( OperationMember.Kind.CONSTRUCTOR == operationKind )
      {
        generateConstructorOperation( operation, parentConstructor, type );
        constructorPresent = true;
      }
      else if ( OperationMember.Kind.STATIC == operationKind )
      {
        generateStaticOperation( operation, type );
      }
    }

    final MapLikeMember mapLike = definition.getMapLikeMember();
    if ( null != mapLike )
    {
      generateMapLikeOperations( name, definition.getOperations(), mapLike, type );
    }
    if ( null != definition.getAsyncIterable() )
    {
      throw new UnsupportedOperationException( "async iterable not yet supported in code generator" );
    }
    if ( null != definition.getSetLikeMember() )
    {
      throw new UnsupportedOperationException( "setlike not yet supported in code generator" );
    }

    for ( final EventMember event : definition.getEvents() )
    {
      final CallbackInterfaceDefinition callbackInterface =
        schema.findCallbackInterfaceByName( event.getEventType().getName() + "Listener" );
      if ( null != callbackInterface )
      {
        generateAddEventListener( event, 0, type );
        generateAddEventListener( event, 1, type );
        generateAddEventListener( event, 2, type );
        generateRemoveEventListener( event, 0, type );
        generateRemoveEventListener( event, 1, type );
        generateRemoveEventListener( event, 2, type );
      }
    }

    final AnnotationSpec.Builder jsTypeAnnotation =
      AnnotationSpec
        .builder( JsinteropTypes.JS_TYPE )
        .addMember( "isNative", "true" )
        .addMember( "namespace", "$T.GLOBAL", JsinteropTypes.JS_PACKAGE );

    type.addAnnotation( jsTypeAnnotation
                          .addMember( "name", "$S", deriveJavascriptName( definition ) )
                          .build() );

    if ( !constructorPresent )
    {
      // Need protected annotation otherwise subclasses can not be created in different packages
      final MethodSpec.Builder method = MethodSpec.constructorBuilder().addModifiers( Modifier.PROTECTED );
      if ( null != parentConstructor )
      {
        generateSuperCall( parentConstructor, method );
      }
      type.addMethod( method.build() );
    }

    writeTopLevelType( name, type );
  }

  private void generateAttributes( @Nonnull final List<AttributeMember> attributes,
                                   @Nonnull final TypeSpec.Builder type )
  {
    attributes
      .stream()
      .sorted( Comparator.comparing( NamedElement::getName ) )
      .forEach( attribute -> generateAttribute( attribute, type ) );
  }

  private void generateAttribute( @Nonnull final AttributeMember attribute, @Nonnull final TypeSpec.Builder type )
  {
    if ( attribute.getModifiers().contains( AttributeMember.Modifier.READ_ONLY ) )
    {
      generateReadOnlyAttribute( attribute, type );
    }
    else
    {
      generateReadWriteAttribute( attribute, type );
    }
  }

  private void generateMapLikeOperations( @Nonnull final String definitionName,
                                          @Nonnull final List<OperationMember> operations,
                                          @Nonnull final MapLikeMember mapLike,
                                          @Nonnull final TypeSpec.Builder type )
  {
    type.addMethod( MethodSpec
                      .methodBuilder( "size" )
                      .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
                      .addAnnotation( AnnotationSpec.builder( JsinteropTypes.JS_PROPERTY )
                                        .addMember( "name", "$S", "size" )
                                        .build() )
                      .returns( TypeName.INT )
                      .build() );
    final TypeName keyType = toTypeName( mapLike.getKeyType() );
    final TypeName boxedKeyType = toTypeName( mapLike.getKeyType(), true );
    final TypeName valueType = toTypeName( mapLike.getValueType() );
    final TypeName boxedValueType = toTypeName( mapLike.getValueType(), true );

    final ParameterSpec.Builder keyParamBuilder = ParameterSpec.builder( keyType, "key" );
    addNullabilityAnnotationIfRequired( mapLike.getKeyType(), keyParamBuilder );
    final ParameterSpec keyParam = keyParamBuilder.build();

    final ParameterSpec.Builder valueParamBuilder = ParameterSpec.builder( valueType, "value" );
    addNullabilityAnnotationIfRequired( mapLike.getValueType(), valueParamBuilder );
    final ParameterSpec valueParam = valueParamBuilder.build();

    type.addMethod( MethodSpec
                      .methodBuilder( "has" )
                      .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
                      .addParameter( keyParam )
                      .returns( TypeName.BOOLEAN )
                      .build() );
    type.addMethod( MethodSpec
                      .methodBuilder( "get" )
                      .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
                      .addAnnotation( BasicTypes.NULLABLE )
                      .addParameter( keyParam )
                      .returns( boxedValueType )
                      .build() );
    type.addMethod( MethodSpec
                      .methodBuilder( "keys" )
                      .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
                      .addAnnotation( BasicTypes.NONNULL )
                      .returns( ParameterizedTypeName.get( lookupClassName( "Iterator" ), boxedKeyType ) )
                      .build() );
    type.addMethod( MethodSpec
                      .methodBuilder( "values" )
                      .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
                      .addAnnotation( BasicTypes.NONNULL )
                      .returns( ParameterizedTypeName.get( lookupClassName( "Iterator" ), boxedValueType ) )
                      .build() );
    type.addType( TypeSpec
                    .interfaceBuilder( "Entry" )
                    .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                    .addAnnotation( AnnotationSpec
                                      .builder( JsinteropTypes.JS_TYPE )
                                      .addMember( "isNative", "true" )
                                      .addMember( "name", "$S", "?" )
                                      .addMember( "namespace", "$T.GLOBAL", JsinteropTypes.JS_PACKAGE )
                                      .build() )
                    .addMethod( MethodSpec.methodBuilder( "key" )
                                  .addAnnotation( JsinteropTypes.JS_OVERLAY )
                                  .addModifiers( Modifier.PUBLIC, Modifier.DEFAULT )
                                  .returns( keyType )
                                  .addStatement( "return $T.asArray( this )[ 0 ].cast()", JsinteropTypes.JS )
                                  .build() )
                    .addMethod( MethodSpec.methodBuilder( "value" )
                                  .addAnnotation( JsinteropTypes.JS_OVERLAY )
                                  .addModifiers( Modifier.PUBLIC, Modifier.DEFAULT )
                                  .returns( valueType )
                                  .addStatement( "return $T.asArray( this )[ 1 ].cast()", JsinteropTypes.JS )
                                  .build() )
                    .build() );
    type.addMethod( MethodSpec
                      .methodBuilder( "entries" )
                      .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
                      .addAnnotation( BasicTypes.NONNULL )
                      .returns( ParameterizedTypeName.get( lookupClassName( "Iterator" ),
                                                           ClassName.bestGuess( "Entry" ) ) )
                      .build() );
    type.addType( TypeSpec
                    .interfaceBuilder( "ForEachCallback" )
                    .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                    .addAnnotation( JsinteropTypes.JS_FUNCTION )
                    .addAnnotation( FunctionalInterface.class )
                    .addMethod( MethodSpec
                                  .methodBuilder( "item" )
                                  .addModifiers( Modifier.PUBLIC, Modifier.ABSTRACT )
                                  .addParameter( valueParam )
                                  .build() )
                    .build() );
    type.addType( TypeSpec
                    .interfaceBuilder( "ForEachCallback2" )
                    .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                    .addAnnotation( JsinteropTypes.JS_FUNCTION )
                    .addAnnotation( FunctionalInterface.class )
                    .addMethod( MethodSpec
                                  .methodBuilder( "item" )
                                  .addModifiers( Modifier.PUBLIC, Modifier.ABSTRACT )
                                  .addParameter( valueParam )
                                  .addParameter( keyParam )
                                  .build() )
                    .build() );
    type.addType( TypeSpec
                    .interfaceBuilder( "ForEachCallback3" )
                    .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                    .addAnnotation( JsinteropTypes.JS_FUNCTION )
                    .addAnnotation( FunctionalInterface.class )
                    .addMethod( MethodSpec
                                  .methodBuilder( "item" )
                                  .addModifiers( Modifier.PUBLIC, Modifier.ABSTRACT )
                                  .addParameter( valueParam )
                                  .addParameter( keyParam )
                                  .addParameter( ParameterSpec
                                                   .builder( lookupClassName( definitionName ), "map" )
                                                   .addAnnotation( BasicTypes.NONNULL )
                                                   .build() )
                                  .build() )
                    .build() );
    type.addMethod( MethodSpec
                      .methodBuilder( "forEach" )
                      .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
                      .addParameter( ParameterSpec.builder( ClassName.bestGuess( "ForEachCallback" ), "callback" )
                                       .addAnnotation( BasicTypes.NONNULL )
                                       .build() )
                      .build() );
    type.addMethod( MethodSpec
                      .methodBuilder( "forEach" )
                      .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
                      .addParameter( ParameterSpec.builder( ClassName.bestGuess( "ForEachCallback2" ), "callback" )
                                       .addAnnotation( BasicTypes.NONNULL )
                                       .build() )
                      .build() );
    type.addMethod( MethodSpec
                      .methodBuilder( "forEach" )
                      .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
                      .addParameter( ParameterSpec.builder( ClassName.bestGuess( "ForEachCallback3" ), "callback" )
                                       .addAnnotation( BasicTypes.NONNULL )
                                       .build() )
                      .build() );
    if ( !mapLike.isReadOnly() )
    {
      final boolean setPresent =
        operations
          .stream()
          .anyMatch( o -> "set".equals( o.getName() ) &&
                          2 == o.getArguments().size() &&
                          Kind.Void == o.getReturnType().getKind() );
      if ( !setPresent )
      {
        type.addMethod( MethodSpec
                          .methodBuilder( "set" )
                          .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
                          .addParameter( keyParam )
                          .addParameter( valueParam )
                          .build() );
      }

      final boolean deletePresent =
        operations
          .stream()
          .anyMatch( o -> "delete".equals( o.getName() ) &&
                          1 == o.getArguments().size() &&
                          Kind.Boolean == o.getReturnType().getKind() );
      if ( !deletePresent )
      {
        type.addMethod( MethodSpec
                          .methodBuilder( "delete" )
                          .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
                          .addParameter( keyParam )
                          .returns( TypeName.BOOLEAN )
                          .build() );
      }

      final boolean clearPresent =
        operations
          .stream()
          .anyMatch( o -> "clear".equals( o.getName() ) &&
                          o.getArguments().isEmpty() &&
                          Kind.Void == o.getReturnType().getKind() );
      if ( !clearPresent )
      {
        type.addMethod( MethodSpec
                          .methodBuilder( "clear" )
                          .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
                          .build() );
      }
    }
  }

  private void addNullabilityAnnotationIfRequired( @Nonnull final Type type,
                                                   @Nonnull final ParameterSpec.Builder builder )
  {
    final WebIDLSchema schema = getSchema();
    if ( schema.isNullable( type ) )
    {
      builder.addAnnotation( BasicTypes.NULLABLE );
    }
    else if ( !schema.resolveType( type ).getKind().isPrimitive() )
    {
      builder.addAnnotation( BasicTypes.NONNULL );
    }
  }

  private void generateAddEventListener( @Nonnull final EventMember event,
                                         final int variant,
                                         @Nonnull final TypeSpec.Builder type )
  {
    final String eventName = event.getName();
    final TypeName listenerType = lookupClassName( event.getEventType().getName() + "Listener" );
    final MethodSpec.Builder method =
      MethodSpec
        .methodBuilder( "add" + NamingUtil.uppercaseFirstCharacter( eventName ) + "Listener" )
        .addModifiers( Modifier.PUBLIC, Modifier.FINAL )
        .addAnnotation( JsinteropTypes.JS_OVERLAY )
        .addParameter( ParameterSpec
                         .builder( listenerType, "callback", Modifier.FINAL )
                         .addAnnotation( BasicTypes.NONNULL )
                         .build() );
    if ( 0 == variant )
    {
      method
        .addParameter( ParameterSpec
                         .builder( lookupClassName( "AddEventListenerOptions" ),
                                   "options",
                                   Modifier.FINAL )
                         .addAnnotation( BasicTypes.NONNULL )
                         .build() )
        .addStatement( "addEventListener( $S, $T.cast( callback ), options )", eventName, JsinteropTypes.JS );
    }
    else if ( 1 == variant )
    {
      method
        .addParameter( ParameterSpec
                         .builder( TypeName.BOOLEAN, "options", Modifier.FINAL )
                         .build() )
        .addStatement( "addEventListener( $S, $T.cast( callback ), options )", eventName, JsinteropTypes.JS );
    }
    else
    {
      assert 2 == variant;
      method.addStatement( "addEventListener( $S, $T.cast( callback ) )", eventName, JsinteropTypes.JS );
    }

    type.addMethod( method.build() );
  }

  private void generateRemoveEventListener( @Nonnull final EventMember event,
                                            final int variant,
                                            @Nonnull final TypeSpec.Builder type )
  {
    final String eventName = event.getName();
    final TypeName listenerType = lookupClassName( event.getEventType().getName() + "Listener" );
    final MethodSpec.Builder method =
      MethodSpec
        .methodBuilder( "remove" + NamingUtil.uppercaseFirstCharacter( eventName ) + "Listener" )
        .addModifiers( Modifier.PUBLIC, Modifier.FINAL )
        .addAnnotation( JsinteropTypes.JS_OVERLAY )
        .addParameter( ParameterSpec
                         .builder( listenerType, "callback", Modifier.FINAL )
                         .addAnnotation( BasicTypes.NONNULL )
                         .build() );
    if ( 0 == variant )
    {
      method
        .addParameter( ParameterSpec
                         .builder( lookupClassName( "EventListenerOptions" ),
                                   "options",
                                   Modifier.FINAL )
                         .addAnnotation( BasicTypes.NONNULL )
                         .build() )
        .addStatement( "removeEventListener( $S, $T.cast( callback ), options )", eventName, JsinteropTypes.JS );
    }
    else if ( 1 == variant )
    {
      method
        .addParameter( ParameterSpec
                         .builder( TypeName.BOOLEAN, "options", Modifier.FINAL )
                         .build() )
        .addStatement( "removeEventListener( $S, $T.cast( callback ), options )", eventName, JsinteropTypes.JS );
    }
    else
    {
      assert 2 == variant;
      method.addStatement( "removeEventListener( $S, $T.cast( callback ) )", eventName, JsinteropTypes.JS );
    }

    type.addMethod( method.build() );
  }

  @Nonnull
  private String deriveJavascriptName( @Nonnull final InterfaceDefinition definition )
  {
    if ( definition.isNoArgsExtendedAttributePresent( ExtendedAttributes.LEGACY_NO_INTERFACE_OBJECT ) )
    {
      return "Object";
    }
    else
    {
      final String namespace = definition.getNamespace();
      return ( null == namespace ? "" : namespace + "." ) + definition.getName();
    }
  }

  private void generateReadOnlyAttribute( @Nonnull final AttributeMember attribute,
                                          @Nonnull final TypeSpec.Builder type )
  {
    assert attribute.getModifiers().contains( AttributeMember.Modifier.READ_ONLY );
    final Type attributeType = attribute.getType();
    final WebIDLSchema schema = getSchema();
    final Type actualType = schema.resolveType( attributeType );
    final String name = attribute.getName();
    final MethodSpec.Builder method =
      MethodSpec
        .methodBuilder( safeJsPropertyMethodName( name ) )
        .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
        .returns( toTypeName( actualType ) )
        .addAnnotation( AnnotationSpec.builder( JsinteropTypes.JS_PROPERTY ).addMember( "name", "$S", name ).build() );
    maybeAddJavadoc( attribute, method );
    if ( schema.isNullable( attributeType ) )
    {
      method.addAnnotation( BasicTypes.NULLABLE );
    }
    else if ( !actualType.getKind().isPrimitive() )
    {
      method.addAnnotation( BasicTypes.NONNULL );
    }
    addMagicConstantAnnotationIfNeeded( actualType, method );
    type.addMethod( method.build() );
  }

  private void generateReadWriteAttribute( @Nonnull final AttributeMember attribute,
                                           @Nonnull final TypeSpec.Builder type )
  {
    assert !attribute.getModifiers().contains( AttributeMember.Modifier.READ_ONLY );
    final Type attributeType = attribute.getType();
    final WebIDLSchema schema = getSchema();
    final Type actualType = schema.resolveType( attributeType );
    final String name = attribute.getName();
    final String fieldName = javaName( attribute );
    final FieldSpec.Builder field =
      FieldSpec.builder( toTypeName( actualType ), fieldName, Modifier.PUBLIC );
    maybeAddJavadoc( attribute, field );
    if ( !fieldName.equals( name ) )
    {
      field.addAnnotation( AnnotationSpec.builder( JsinteropTypes.JS_PROPERTY )
                             .addMember( "name", "$S", name )
                             .build() );
    }
    if ( schema.isNullable( attributeType ) )
    {
      field.addAnnotation( BasicTypes.NULLABLE );
    }
    else if ( !actualType.getKind().isPrimitive() )
    {
      field.addAnnotation( BasicTypes.NONNULL );
    }
    addMagicConstantAnnotationIfNeeded( actualType, field );
    type.addField( field.build() );
  }

  private void generateConstants( @Nonnull final List<ConstMember> constants,
                                  @Nonnull final TypeSpec.Builder type )
  {
    constants
      .stream()
      .sorted( Comparator.comparing( NamedElement::getName ) )
      .forEach( constant -> generateConstant( constant, type ) );
  }

  private void generateConstant( @Nonnull final ConstMember constant,
                                 @Nonnull final TypeSpec.Builder type )
  {
    final Type constantType = constant.getType();
    final Type actualType = getSchema().resolveType( constantType );
    final FieldSpec.Builder field =
      FieldSpec
        .builder( toTypeName( actualType ),
                  constant.getName(),
                  Modifier.PUBLIC,
                  Modifier.STATIC,
                  Modifier.FINAL )
        .addAnnotation( JsinteropTypes.JS_OVERLAY );

    maybeAddJavadoc( constant, field );

    final ConstValue value = constant.getValue();
    final ConstValue.Kind kind = value.getKind();
    if ( ConstValue.Kind.True == kind )
    {
      field.initializer( "true" );
    }
    else if ( ConstValue.Kind.False == kind )
    {
      field.initializer( "false" );
    }
    else if ( ConstValue.Kind.NaN == kind &&
              ( Kind.Float == actualType.getKind() || Kind.UnrestrictedFloat == actualType.getKind() ) )
    {
      field.initializer( "$T.NaN", Float.class );
    }
    else if ( ConstValue.Kind.NaN == kind )
    {
      assert Kind.Double == actualType.getKind() || Kind.UnrestrictedDouble == actualType.getKind();
      field.initializer( "$T.NaN", Double.class );
    }
    else if ( ConstValue.Kind.PositiveInfinity == kind &&
              ( Kind.Float == actualType.getKind() || Kind.UnrestrictedFloat == actualType.getKind() ) )
    {
      field.initializer( "$T.POSITIVE_INFINITY", Float.class );
    }
    else if ( ConstValue.Kind.PositiveInfinity == kind )
    {
      assert Kind.Double == actualType.getKind() || Kind.UnrestrictedDouble == actualType.getKind();
      field.initializer( "$T.POSITIVE_INFINITY", Double.class );
    }
    else if ( ConstValue.Kind.NegativeInfinity == kind &&
              ( Kind.Float == actualType.getKind() || Kind.UnrestrictedFloat == actualType.getKind() ) )
    {
      field.initializer( "$T.NEGATIVE_INFINITY", Float.class );
    }
    else if ( ConstValue.Kind.NegativeInfinity == kind )
    {
      assert Kind.Double == actualType.getKind() || Kind.UnrestrictedDouble == actualType.getKind();
      field.initializer( "$T.NEGATIVE_INFINITY", Double.class );
    }
    else if ( ConstValue.Kind.Decimal == kind )
    {
      field.initializer( Objects.requireNonNull( value.getValue() ) );
    }
    else
    {
      assert ConstValue.Kind.Integer == kind;
      field.initializer( Objects.requireNonNull( value.getValue() ) );
    }
    type.addField( field.build() );
  }

  private void generateDefaultOperation( @Nonnull final OperationMember operation,
                                         @Nonnull final TypeSpec.Builder type )
  {
    final List<Argument> arguments = operation.getArguments();
    final int argCount = arguments.size();
    final long optionalCount = arguments.stream().filter( Argument::isOptional ).count();
    for ( int i = 0; i <= optionalCount; i++ )
    {
      final List<Argument> argumentList = operation.getArguments().subList( 0, argCount - i );
      final List<List<TypedValue>> explodedTypeList =
        explodeTypeList( argumentList.stream().map( v -> (AttributedNode) v ).collect( Collectors.toList() ),
                         argumentList.stream().map( Argument::getType ).collect( Collectors.toList() ) );
      for ( final List<TypedValue> typeList : explodedTypeList )
      {
        generateDefaultOperation( operation, false, argumentList, typeList, type );
      }
    }
  }

  private void generateDefaultOperation( @Nonnull final OperationMember operation,
                                         final boolean javaInterface,
                                         @Nonnull final List<Argument> arguments,
                                         @Nonnull final List<TypedValue> typeList,
                                         @Nonnull final TypeSpec.Builder type )
  {
    final OperationMember.Kind operationKind = operation.getKind();
    assert OperationMember.Kind.STATIC != operationKind && OperationMember.Kind.CONSTRUCTOR != operationKind;
    final String name = operation.getName();
    assert null != name;
    final String methodName = javaMethodName( name, operation );
    final MethodSpec.Builder method =
      MethodSpec
        .methodBuilder( methodName )
        .addModifiers( Modifier.PUBLIC, javaInterface ? Modifier.ABSTRACT : Modifier.NATIVE );
    maybeAddJavadoc( operation, method );
    if ( !methodName.equals( name ) )
    {
      method.addAnnotation( AnnotationSpec.builder( JsinteropTypes.JS_METHOD )
                              .addMember( "name", "$S", name )
                              .build() );
    }
    final Type returnType = operation.getReturnType();
    emitReturnType( returnType, method );
    int index = 0;
    for ( final Argument argument : arguments )
    {
      final TypedValue typedValue = typeList.get( index++ );
      generateArgument( argument, typedValue, false, method );
    }
    type.addMethod( method.build() );
  }

  private void generateStaticOperation( @Nonnull final OperationMember operation,
                                        @Nonnull final TypeSpec.Builder type )
  {
    final List<Argument> arguments = operation.getArguments();
    final int argCount = arguments.size();
    final long optionalCount = arguments.stream().filter( Argument::isOptional ).count();
    for ( int i = 0; i <= optionalCount; i++ )
    {
      final List<Argument> argumentList = operation.getArguments().subList( 0, argCount - i );
      final List<List<TypedValue>> explodedTypeList =
        explodeTypeList( argumentList.stream().map( v -> (AttributedNode) v ).collect( Collectors.toList() ),
                         argumentList.stream().map( Argument::getType ).collect( Collectors.toList() ) );
      for ( final List<TypedValue> typeList : explodedTypeList )
      {
        generateStaticOperation( operation, argumentList, typeList, type );
      }
    }
  }

  private void generateStaticOperation( @Nonnull final OperationMember operation,
                                        @Nonnull final List<Argument> arguments,
                                        @Nonnull final List<TypedValue> typeList,
                                        @Nonnull final TypeSpec.Builder type )
  {
    assert OperationMember.Kind.STATIC == operation.getKind();
    final String name = operation.getName();
    assert null != name;
    final String methodName = javaMethodName( name, operation );
    final MethodSpec.Builder method =
      MethodSpec
        .methodBuilder( methodName )
        .addModifiers( Modifier.PUBLIC, Modifier.STATIC, Modifier.NATIVE );
    maybeAddJavadoc( operation, method );
    if ( !methodName.equals( name ) )
    {
      method.addAnnotation( AnnotationSpec.builder( JsinteropTypes.JS_METHOD )
                              .addMember( "name", "$S", name )
                              .build() );
    }
    final Type returnType = operation.getReturnType();
    emitReturnType( returnType, method );
    int index = 0;
    for ( final Argument argument : arguments )
    {
      generateArgument( argument, typeList.get( index++ ), false, method );
    }
    type.addMethod( method.build() );
  }

  private void emitReturnType( @Nonnull final Type returnType, @Nonnull final MethodSpec.Builder method )
  {
    if ( Kind.Void != returnType.getKind() )
    {
      addMagicConstantAnnotationIfNeeded( returnType, method );
      final Type actualType = getSchema().resolveType( returnType );
      if ( getSchema().isNullable( returnType ) )
      {
        method.addAnnotation( BasicTypes.NULLABLE );
      }
      else if ( !actualType.getKind().isPrimitive() )
      {
        method.addAnnotation( BasicTypes.NONNULL );
      }
      method.returns( toTypeName( returnType ) );
    }
  }

  private void generateConstructorOperation( @Nonnull final OperationMember operation,
                                             @Nullable final OperationMember parentConstructor,
                                             @Nonnull final TypeSpec.Builder type )
  {
    final List<Argument> arguments = operation.getArguments();
    final int argCount = arguments.size();
    final long optionalCount = arguments.stream().filter( Argument::isOptional ).count();
    for ( int i = 0; i <= optionalCount; i++ )
    {
      final List<Argument> argumentList = arguments.subList( 0, argCount - i );
      final List<List<TypedValue>> explodedTypeList =
        explodeTypeList( argumentList.stream().map( v -> (AttributedNode) v ).collect( Collectors.toList() ),
                         argumentList.stream().map( Argument::getType ).collect( Collectors.toList() ) );
      for ( final List<TypedValue> typeList : explodedTypeList )
      {
        generateConstructorOperation( operation, parentConstructor, argumentList, typeList, type );
      }
    }
  }

  private void generateConstructorOperation( @Nonnull final OperationMember operation,
                                             @Nullable final OperationMember parentConstructor,
                                             @Nonnull final List<Argument> argumentList,
                                             @Nonnull final List<TypedValue> typeList,
                                             @Nonnull final TypeSpec.Builder type )
  {
    final MethodSpec.Builder method = MethodSpec.constructorBuilder().addModifiers( Modifier.PUBLIC );
    maybeAddJavadoc( operation, method );
    int index = 0;
    for ( final Argument argument : argumentList )
    {
      generateArgument( argument, typeList.get( index++ ), true, method );
    }
    if ( null != parentConstructor )
    {
      generateSuperCall( parentConstructor, method );
    }

    type.addMethod( method.build() );
  }

  private void generateSuperCall( @Nonnull final OperationMember parentConstructor,
                                  @Nonnull final MethodSpec.Builder method )
  {
    final List<Argument> arguments = parentConstructor
      .getArguments()
      .stream()
      .filter( a -> !a.isOptional() && !a.isVariadic() )
      .collect( Collectors.toList() );

    if ( !arguments.isEmpty() )
    {
      final List<Object> params = new ArrayList<>();
      final String statement =
        "super( " +
        arguments.stream().map( a -> defaultValue( a, params ) ).collect( Collectors.joining( ", " ) ) +
        " )";
      method.addStatement( statement, params.toArray() );
    }
  }

  @Nonnull
  private String defaultValue( @Nonnull final Argument argument, @Nonnull final List<Object> params )
  {
    final Type type = getSchema().resolveType( argument.getType() );
    final Kind kind = type.getKind();
    if ( kind.isInteger() )
    {
      return "0";
    }
    else if ( kind.isDecimal() )
    {
      return "0F";
    }
    else if ( Kind.Boolean == kind )
    {
      return "false";
    }
    else
    {
      params.add( toTypeName( type ) );
      return "null";
    }
  }

  private void generateArgument( @Nonnull final Argument argument,
                                 @Nonnull final TypedValue typedValue,
                                 final boolean isFinal,
                                 @Nonnull final MethodSpec.Builder method )
  {
    final Type actualType = getSchema().resolveType( argument.getType() );
    final TypeName type = typedValue.getJavaType();
    final ParameterSpec.Builder parameter =
      ParameterSpec.builder( argument.isVariadic() ? ArrayTypeName.of( type ) : type, javaName( argument ) );
    if ( isFinal )
    {
      parameter.addModifiers( Modifier.FINAL );
    }
    addMagicConstantAnnotationIfNeeded( actualType, parameter );
    addDoNotAutoboxAnnotation( typedValue, parameter );
    addNullabilityAnnotation( typedValue, parameter );
    // Only the last argument can be variadic
    if ( argument.isVariadic() )
    {
      method.varargs();
    }
    method.addParameter( parameter.build() );
  }

  private void generateEnumeration( @Nonnull final EnumerationDefinition definition )
    throws IOException
  {
    final String name = definition.getName();
    final TypeSpec.Builder type =
      TypeSpec
        .annotationBuilder( rawLookupClassName( definition.getName() ).simpleName() )
        .addModifiers( Modifier.PUBLIC );
    writeGeneratedAnnotation( type );
    maybeAddJavadoc( definition, type );
    type.addAnnotation( AnnotationSpec
                          .builder( BasicTypes.MAGIC_CONSTANT )
                          .addMember( "valuesFromClass", "$T.class", rawLookupClassName( definition.getName() ) )
                          .build() );

    for ( final EnumerationValue enumerationValue : definition.getValues() )
    {
      final String value = enumerationValue.getValue();
      if ( !value.isEmpty() )
      {
        final FieldSpec.Builder field = FieldSpec
          .builder( BasicTypes.STRING,
                    javaName( enumerationValue ),
                    Modifier.PUBLIC,
                    Modifier.STATIC,
                    Modifier.FINAL )
          .addAnnotation( BasicTypes.NONNULL )
          .initializer( "$S", value );
        maybeAddJavadoc( enumerationValue.getDocumentation(), field );
        type.addField( field.build() );
      }
    }

    writeTopLevelType( name, type );
  }

  private void maybeAddJavadoc( @Nonnull final Element constant, @Nonnull final FieldSpec.Builder field )
  {
    maybeAddJavadoc( constant.getDocumentation(), field );
  }

  private void maybeAddJavadoc( @Nonnull final Element element, @Nonnull final TypeSpec.Builder type )
  {
    final DocumentationElement documentation = element.getDocumentation();
    if ( null != documentation )
    {
      type.addJavadoc( asJavadoc( documentation ) );
    }
  }

  private void maybeAddJavadoc( @Nullable final DocumentationElement documentation,
                                @Nonnull final FieldSpec.Builder field )
  {
    if ( null != documentation )
    {
      field.addJavadoc( asJavadoc( documentation ) );
    }
  }

  private void maybeAddJavadoc( @Nonnull final Element element, @Nonnull final MethodSpec.Builder method )
  {
    final DocumentationElement documentation = element.getDocumentation();
    if ( null != documentation )
    {
      method.addJavadoc( asJavadoc( documentation ) );
    }
  }

  @Nonnull
  private String asJavadoc( @Nonnull final DocumentationElement documentation )
  {
    final StringBuilder docs = new StringBuilder();
    final String text = documentation.getDocumentation();
    if ( null != text )
    {
      final StringBuffer sb = new StringBuffer();
      final Matcher matcher = _linkMatcher.matcher( text );
      if ( matcher.find() )
      {
        do
        {
          matcher.appendReplacement( sb, "{@link " + lookupJavaType( matcher.group( 1 ) ) );
        } while ( matcher.find() );
      }
      matcher.appendTail( sb );
      docs.append( sb );
      docs.append( "\n" );
    }
    final List<DocumentationBlockTag> blockTags = documentation.getBlockTags();
    if ( !blockTags.isEmpty() )
    {
      docs.append( "\n" );
      for ( final DocumentationBlockTag tag : blockTags )
      {
        docs.append( "@" );
        docs.append( tag.getName() );
        final String tagDocumentation = tag.getDocumentation();
        if ( !tagDocumentation.isEmpty() )
        {
          docs.append( " " );
          docs.append( tagDocumentation );
        }
        docs.append( "\n" );
      }
    }

    return docs.toString();
  }

  private boolean isExposedOnGlobal( @Nonnull final Element element )
  {
    return element.getExtendedAttributes()
      .stream()
      .filter( a -> a.getKind() == ExtendedAttribute.Kind.IDENT || a.getKind() == ExtendedAttribute.Kind.IDENT_LIST )
      .anyMatch( a -> a.getName().equals( "Exposed" ) );
  }

  @Nonnull
  @Override
  protected Map<String, Path> getGeneratedFiles()
  {
    return super.getGeneratedFiles();
  }

  private void registerIdlTypeToJavaTypeMapping()
  {
    final WebIDLSchema schema = getSchema();
    schema.getTypedefs()
      .stream()
      .filter( definition -> Kind.Union == definition.getType().getKind() )
      .forEach( this::registerDefinition );
    schema.getCallbacks().forEach( this::registerDefinition );
    schema.getCallbackInterfaces().forEach( this::registerDefinition );
    schema.getDictionaries().forEach( this::registerDefinition );
    for ( final EnumerationDefinition definition : schema.getEnumerations() )
    {
      registerDefinition( definition );
      // Force the lookup of the underlying Enumeration to guarantee it is part of output type catalog
      rawLookupClassName( definition.getName() );
    }
    schema.getInterfaces().forEach( this::registerDefinition );
    schema.getPartialInterfaces().forEach( this::registerDefinition );
    schema.getNamespaces().forEach( this::registerDefinition );
  }

  private void registerDefinition( @Nonnull final NamedDefinition definition )
  {
    final String declaredSubPackage = definition.getIdentValue( ExtendedAttributes.JAVA_SUB_PACKAGE );
    final String subPackage =
      null != declaredSubPackage ? asSubPackage( declaredSubPackage ) : asSubPackage( getNamespace( definition ) );
    final String javaType = getPackageName() + subPackage + "." + javaName( definition );
    tryRegisterIdlToJavaTypeMapping( definition.getName(), javaType );
  }

  @Nullable
  private String getNamespace( @Nonnull final NamedDefinition definition )
  {
    return definition instanceof InterfaceDefinition ? ( (InterfaceDefinition) definition ).getNamespace() : null;
  }

  @Nonnull
  private String asSubPackage( @Nullable final String value )
  {
    return null != value && !value.isEmpty() ? "." + NamingUtil.underscore( value ) : "";
  }
}
