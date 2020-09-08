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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.lang.model.element.Modifier;
import org.realityforge.webtack.model.Argument;
import org.realityforge.webtack.model.AttributeMember;
import org.realityforge.webtack.model.CallbackDefinition;
import org.realityforge.webtack.model.CallbackInterfaceDefinition;
import org.realityforge.webtack.model.ConstMember;
import org.realityforge.webtack.model.ConstValue;
import org.realityforge.webtack.model.Definition;
import org.realityforge.webtack.model.DictionaryDefinition;
import org.realityforge.webtack.model.DictionaryMember;
import org.realityforge.webtack.model.DocumentationBlockTag;
import org.realityforge.webtack.model.DocumentationElement;
import org.realityforge.webtack.model.Element;
import org.realityforge.webtack.model.EnumerationDefinition;
import org.realityforge.webtack.model.EnumerationValue;
import org.realityforge.webtack.model.EventMember;
import org.realityforge.webtack.model.ExtendedAttribute;
import org.realityforge.webtack.model.FrozenArrayType;
import org.realityforge.webtack.model.InterfaceDefinition;
import org.realityforge.webtack.model.Kind;
import org.realityforge.webtack.model.MapLikeMember;
import org.realityforge.webtack.model.NamedDefinition;
import org.realityforge.webtack.model.NamespaceDefinition;
import org.realityforge.webtack.model.OperationMember;
import org.realityforge.webtack.model.PartialInterfaceDefinition;
import org.realityforge.webtack.model.PromiseType;
import org.realityforge.webtack.model.RecordType;
import org.realityforge.webtack.model.SequenceType;
import org.realityforge.webtack.model.Type;
import org.realityforge.webtack.model.TypeReference;
import org.realityforge.webtack.model.TypedefDefinition;
import org.realityforge.webtack.model.UnionType;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.tools.io.FilesUtil;
import org.realityforge.webtack.model.tools.util.AbstractJavaAction;
import org.realityforge.webtack.model.tools.util.NamingUtil;

final class JsinteropAction
  extends AbstractJavaAction
{
  @Nullable
  private final String _globalInterface;
  private final boolean _generateGwtModule;
  private final boolean _generateTypeCatalog;
  private final boolean _enableMagicConstants;
  @Nonnull
  private final Map<String, ClassName> _typeMapping = new HashMap<>();
  @Nonnull
  private final Map<String, UnionType> _unions = new HashMap<>();
  private WebIDLSchema _schema;

  JsinteropAction( @Nonnull final Path outputDirectory,
                   @Nonnull final String packageName,
                   @Nullable final String globalInterface,
                   final boolean generateGwtModule,
                   final boolean generateTypeCatalog,
                   final boolean enableMagicConstants )
  {
    super( outputDirectory, packageName );
    _globalInterface = globalInterface;
    _generateGwtModule = generateGwtModule;
    _generateTypeCatalog = generateTypeCatalog;
    _enableMagicConstants = enableMagicConstants;
  }

  @Override
  protected void processInit()
  {
    super.processInit();
    _typeMapping.clear();
    _unions.clear();
  }

  @Override
  public void process( @Nonnull final WebIDLSchema schema )
    throws Exception
  {
    processInit();
    _schema = Objects.requireNonNull( schema );

    FilesUtil.deleteDirectory( getMainJavaDirectory() );

    registerIdlTypeToJavaTypeMapping();

    for ( final TypedefDefinition definition : _schema.getTypedefs() )
    {
      generateTypedef( definition );
    }
    for ( final CallbackDefinition definition : _schema.getCallbacks() )
    {
      generateCallback( definition );
    }
    for ( final CallbackInterfaceDefinition definition : _schema.getCallbackInterfaces() )
    {
      generateCallbackInterface( definition );
    }
    for ( final DictionaryDefinition definition : _schema.getDictionaries() )
    {
      generateDictionary( definition );
    }
    for ( final EnumerationDefinition definition : _schema.getEnumerations() )
    {
      generateEnumeration( definition );
    }
    for ( final InterfaceDefinition definition : _schema.getInterfaces() )
    {
      generateInterface( definition );
    }
    for ( final PartialInterfaceDefinition definition : _schema.getPartialInterfaces() )
    {
      generatePartialInterface( definition );
    }
    for ( final NamespaceDefinition definition : _schema.getNamespaces() )
    {
      generateNamespace( definition );
    }

    for ( final Map.Entry<String, UnionType> entry : getUnions().entrySet() )
    {
      final String name = NamingUtil.uppercaseFirstCharacter( entry.getKey() );
      final UnionType unionType = entry.getValue();
      generateUnion( name, unionType );
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

  private void writeTypeCatalog()
    throws IOException
  {
    final String typeMappingContent =
      getTypeToJavaMapping()
        .entrySet()
        .stream()
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
    final InterfaceDefinition definition = _schema.findInterfaceByName( globalInterface );
    if ( null == definition )
    {
      throw new IllegalStateException( "Declared globalInterface '" + globalInterface + "' does not exist in schema" );
    }
    final TypeSpec.Builder type =
      TypeSpec
        .classBuilder( "Global" )
        .addModifiers( Modifier.PUBLIC, Modifier.FINAL )
        .superclass( lookupTypeByName( definition.getName() ) );
    writeGeneratedAnnotation( type );
    type.addAnnotation( AnnotationSpec.builder( Types.JS_TYPE )
                          .addMember( "isNative", "true" )
                          .addMember( "namespace", "$T.GLOBAL", Types.JS_PACKAGE )
                          .addMember( "name", "$S", "goog.global" )
                          .build() );

    type.addJavadoc( "The global <b>globalThis</b> property or the global object.\n" +
                     "\n" +
                     "@see <a href=\"https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/globalThis\">globalThis - MDN</a>\n" );

    final OperationMember parentConstructor = _schema
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

    for ( final NamespaceDefinition namespace : _schema.getNamespaces() )
    {
      final String name = namespace.getName();
      type.addMethod( MethodSpec
                        .methodBuilder( NamingUtil.camelCase( safeJsPropertyMethodName( name ) ) )
                        .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
                        .returns( lookupTypeByName( namespace.getName() ) )
                        .addAnnotation( AnnotationSpec
                                          .builder( Types.JS_PROPERTY )
                                          .addMember( "name", "$S", name )
                                          .build() )
                        .addAnnotation( Types.NONNULL ).build() );
    }

    final TypeName globalType = ClassName.bestGuess( "Global" );

    type.addField( FieldSpec.builder( globalType, "globalThis", Modifier.PRIVATE, Modifier.STATIC ).build() );

    type.addMethod( MethodSpec.methodBuilder( "globalThis" )
                      .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                      .addAnnotation( Types.JS_OVERLAY )
                      .addAnnotation( Types.NONNULL )
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

  private void generateTypedef( @Nonnull final TypedefDefinition definition )
    throws IOException
  {
    final Type type = definition.getType();
    if ( Kind.Union == type.getKind() )
    {
      generateUnion( definition.getName(), (UnionType) type );
    }
  }

  private void generateUnion( @Nonnull final String name, @Nonnull final UnionType unionType )
    throws IOException
  {
    final TypeSpec.Builder type =
      TypeSpec
        .interfaceBuilder( NamingUtil.uppercaseFirstCharacter( name ) )
        .addModifiers( Modifier.PUBLIC );
    writeGeneratedAnnotation( type );
    type.addAnnotation( AnnotationSpec.builder( Types.JS_TYPE )
                          .addMember( "isNative", "true" )
                          .addMember( "namespace", "$T.GLOBAL", Types.JS_PACKAGE )
                          .addMember( "name", "$S", "?" )
                          .build() );

    generateUnionOfMethods( name, unionType, type );

    writeTopLevelType( name, type );
  }

  @Nonnull
  private List<List<TypedValue>> explodeTypeList( @Nonnull final List<Type> types )
  {
    final List<List<TypedValue>> results = new ArrayList<>();
    results.add( new ArrayList<>() );
    for ( final Type type : types )
    {
      final List<TypedValue> itemTypes = explodeType( type );
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
  private List<TypedValue> explodeType( @Nonnull final Type type )
  {
    final List<TypedValue> values = new ArrayList<>();
    explodeType( type, type, values );
    return values;
  }

  private void explodeType( @Nonnull final Type declaredType,
                            @Nonnull final Type type,
                            @Nonnull final List<TypedValue> values )
  {
    final Kind kind = type.getKind();
    if ( Kind.TypeReference == type.getKind() )
    {
      final String name = ( (TypeReference) type ).getName();
      final TypedefDefinition typedef = _schema.findTypedefByName( name );
      if ( null != typedef )
      {
        final Type resolvedType = typedef.getType();
        if ( Kind.Union == resolvedType.getKind() )
        {
          final boolean nullable = _schema.isNullable( type );
          values.add( new TypedValue( declaredType,
                                      type,
                                      lookupTypeByName( name ),
                                      nullable ? TypedValue.Nullability.NULLABLE : TypedValue.Nullability.NONNULL,
                                      false ) );
        }
        explodeType( declaredType, resolvedType, values );
      }
      else
      {
        final boolean nullable = _schema.isNullable( type );
        values.add( new TypedValue( declaredType,
                                    type,
                                    toTypeName( type ),
                                    nullable ? TypedValue.Nullability.NULLABLE : TypedValue.Nullability.NONNULL,
                                    false ) );
      }
    }
    else if ( Kind.Any == kind )
    {
      values.add( new TypedValue( declaredType, type, Types.ANY, TypedValue.Nullability.NULLABLE, false ) );
      values.add( new TypedValue( declaredType, type, TypeName.OBJECT, TypedValue.Nullability.NULLABLE, true ) );
    }
    else if ( Kind.Union == kind )
    {
      final UnionType unionType = (UnionType) type;
      for ( final Type memberType : unionType.getMemberTypes() )
      {
        explodeType( declaredType, memberType, values );
      }
    }
    else if ( Kind.Sequence == kind )
    {
      final SequenceType sequenceType = (SequenceType) type;
      final Type itemType = sequenceType.getItemType();
      final boolean nullable = _schema.isNullable( type );
      final TypeName javaType = toTypeName( type );

      final TypeName arrayJavaType = ArrayTypeName.of( getUnexpandedType( itemType ) );
      final TypedValue.Nullability nullability =
        nullable ? TypedValue.Nullability.NULLABLE : TypedValue.Nullability.NONNULL;
      values.add( new TypedValue( declaredType, type, javaType, nullability, false ) );
      values.add( new TypedValue( declaredType, type, arrayJavaType, nullability, false ) );
    }
    else
    {
      final boolean nullable = _schema.isNullable( type );
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

  private void generateUnionOfMethods( @Nonnull final String name,
                                       @Nonnull final UnionType unionType,
                                       @Nonnull final TypeSpec.Builder type )
  {
    final TypeName self = lookupTypeByName( name );
    final List<Type> memberTypes = unionType.getMemberTypes();
    for ( final Type memberType : memberTypes )
    {
      for ( final TypedValue typedValue : explodeType( memberType ) )
      {
        final ParameterSpec.Builder parameter =
          ParameterSpec.builder( typedValue.getJavaType(), "value", Modifier.FINAL );

        final ClassName methodNullability;
        final TypedValue.Nullability nullability = typedValue.getNullability();
        if ( TypedValue.Nullability.NULLABLE == nullability )
        {
          parameter.addAnnotation( Types.NULLABLE );
          methodNullability = Types.NULLABLE;
        }
        else if ( TypedValue.Nullability.NONNULL == nullability )
        {
          parameter.addAnnotation( Types.NONNULL );
          methodNullability = Types.NONNULL;
        }
        else
        {
          methodNullability = Types.NONNULL;
        }

        type.addMethod( MethodSpec
                          .methodBuilder( "of" )
                          .addAnnotation( Types.JS_OVERLAY )
                          .addAnnotation( methodNullability )
                          .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                          .addParameter( parameter.build() )
                          .addStatement( "return $T.cast( value )", Types.JS )
                          .returns( self ).build() );
      }
    }
  }

  private void generateDictionary( @Nonnull final DictionaryDefinition definition )
    throws IOException
  {
    final String name = definition.getName();
    final TypeSpec.Builder type =
      TypeSpec
        .interfaceBuilder( NamingUtil.uppercaseFirstCharacter( name ) )
        .addModifiers( Modifier.PUBLIC );
    writeGeneratedAnnotation( type );
    type.addAnnotation( AnnotationSpec.builder( Types.JS_TYPE )
                          .addMember( "isNative", "true" )
                          .addMember( "namespace", "$T.GLOBAL", Types.JS_PACKAGE )
                          .addMember( "name", "$S", "?" )
                          .build() );
    maybeAddJavadoc( definition, type );

    final String inherits = definition.getInherits();
    if ( null != inherits )
    {
      type.addSuperinterface( lookupTypeByName( inherits ) );
    }

    final List<DictionaryMember> requiredMembers = getRequiredDictionaryMembers( definition );
    final List<List<TypedValue>> explodedTypeList =
      explodeTypeList(
        requiredMembers.stream().map( DictionaryMember::getType ).collect( Collectors.toList() ) );
    for ( final List<TypedValue> argTypes : explodedTypeList )
    {
      generateDictionaryCreateMethod( definition, requiredMembers, argTypes, type );
    }

    for ( final DictionaryMember member : definition.getMembers() )
    {
      final Type actualType = _schema.resolveType( member.getType() );
      final TypeName javaType = toTypeName( actualType );
      generateDictionaryMemberGetter( member, actualType, javaType, type );
      generateDictionaryMemberSetter( member, actualType, javaType, type );
      for ( final TypedValue typedValue : explodeType( member.getType() ) )
      {
        if ( !javaType.equals( typedValue.getJavaType() ) )
        {
          generateDictionaryMemberOverlaySetter( member, typedValue, type );
        }
        generateDictionaryMemberSetterReturningThis( definition, member, typedValue, false, type );
      }
    }
    String superName = definition.getInherits();
    while ( null != superName )
    {
      final DictionaryDefinition parent = _schema.getDictionaryByName( superName );
      for ( final DictionaryMember member : parent.getMembers() )
      {
        for ( final TypedValue memberType : explodeType( member.getType() ) )
        {
          generateDictionaryMemberSetterReturningThis( definition, member, memberType, true, type );
        }
      }
      superName = parent.getInherits();
    }

    writeTopLevelType( name, type );
  }

  private void generateDictionaryCreateMethod( @Nonnull final DictionaryDefinition definition,
                                               @Nonnull final List<DictionaryMember> requiredMembers,
                                               @Nonnull final List<TypedValue> types,
                                               @Nonnull final TypeSpec.Builder type )
  {
    final TypeName self = lookupTypeByName( definition.getName() );
    final MethodSpec.Builder method = MethodSpec
      .methodBuilder( "create" )
      .addAnnotation( Types.JS_OVERLAY )
      .addAnnotation( Types.NONNULL )
      .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
      .returns( self );
    if ( requiredMembers.isEmpty() )
    {
      method.addStatement( "return $T.uncheckedCast( $T.of() )", Types.JS, Types.JS_PROPERTY_MAP );
    }
    else
    {
      final List<Object> params = new ArrayList<>();
      final StringBuilder sb = new StringBuilder();
      sb.append( "return $T.<$T>uncheckedCast( $T.of() )" );
      params.add( Types.JS );
      params.add( self );
      params.add( Types.JS_PROPERTY_MAP );

      int index = 0;
      for ( final DictionaryMember member : requiredMembers )
      {
        final String paramName = safeName( member.getName() );
        sb.append( ".$N( $N )" );
        params.add( safeMethodName( member.getName() ) );
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
      collectRequiredDictionaryMembers( _schema.getDictionaryByName( inherits ), members );
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
                            .builder( Types.JS_PROPERTY )
                            .addMember( "name", "$S", member.getName() )
                            .build() );
    maybeAddJavadoc( member, method );
    addMagicConstantAnnotationIfNeeded( member.getType(), method );
    if ( _schema.isNullable( member.getType() ) )
    {
      method.addAnnotation( Types.NULLABLE );
    }
    else
    {
      if ( !actualType.getKind().isPrimitive() && !member.isOptional() )
      {
        method.addAnnotation( Types.NONNULL );
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
        .addAnnotation( Types.JS_PROPERTY );
    maybeAddJavadoc( member, method );
    final ParameterSpec.Builder parameter =
      ParameterSpec.builder( javaType, safeName( member.getName() ) );
    addMagicConstantAnnotationIfNeeded( member.getType(), parameter );

    if ( _schema.isNullable( member.getType() ) )
    {
      parameter.addAnnotation( Types.NULLABLE );
    }
    else if ( !actualType.getKind().isPrimitive() )
    {
      parameter.addAnnotation( Types.NONNULL );
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
        .addAnnotation( Types.JS_OVERLAY );
    maybeAddJavadoc( member, method );
    final String paramName = safeName( member.getName() );
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
    final Type declaredType = _schema.resolveType( typedValue.getDeclaredType() );
    final Type resolvedType = _schema.resolveType( typedValue.getType(), true );
    if ( Kind.Union == declaredType.getKind() || unwrapsToUnion( declaredType ) )
    {
      method.addStatement( "$N( $T.of( $N ) )", mutatorName, toTypeName( declaredType ), paramName );
    }
    else if ( Kind.Sequence == declaredType.getKind() || Kind.Sequence == resolvedType.getKind() )
    {
      method.addStatement( "$N( $T.asJsArray( $N ) )", mutatorName, Types.JS_ARRAY, paramName );
    }
    else if ( Kind.Any == declaredType.getKind() && typedValue.doNotAutobox() )
    {
      method.addStatement( "$N( $T.asAny( $N ) )", mutatorName, Types.JS, paramName );
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
      final TypedefDefinition typedef = _schema.findTypedefByName( name );
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
        .methodBuilder( safeMethodName( member.getName() ) )
        .addModifiers( Modifier.PUBLIC, Modifier.DEFAULT )
        .addAnnotation( Types.JS_OVERLAY )
        .addAnnotation( Types.NONNULL )
        .returns( lookupTypeByName( dictionary.getName() ) );
    maybeAddJavadoc( member, method );
    if ( addOverride )
    {
      method.addAnnotation( Override.class );
    }
    final TypeName javaType = typedValue.getJavaType();
    final String paramName = safeName( member.getName() );
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
      parameter.addAnnotation( Types.NULLABLE );
    }
    else if ( TypedValue.Nullability.NONNULL == nullability )
    {
      parameter.addAnnotation( Types.NONNULL );
    }
  }

  private void addDoNotAutoboxAnnotation( @Nonnull final TypedValue typedValue,
                                          @Nonnull final ParameterSpec.Builder parameter )
  {
    if ( typedValue.doNotAutobox() )
    {
      parameter.addAnnotation( Types.DO_NOT_AUTOBOX );
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
    final String name = definition.getName();
    final TypeSpec.Builder type =
      TypeSpec
        .interfaceBuilder( NamingUtil.uppercaseFirstCharacter( name ) )
        .addModifiers( Modifier.PUBLIC );
    writeGeneratedAnnotation( type );
    type
      .addAnnotation( Types.JS_FUNCTION )
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

    writeTopLevelType( name, type );
  }

  @Nonnull
  private TypedValue asTypedValue( @Nonnull final Type type )
  {
    // This method is only called for arguments to callback interfaces a callbacks
    final Type resolveType = _schema.resolveType( type );
    if ( Kind.Any == type.getKind() )
    {
      return new TypedValue( type, resolveType, TypeName.OBJECT, TypedValue.Nullability.NULLABLE, true );
    }
    else
    {
      final TypeName javaType = toTypeName( resolveType );
      final TypedValue.Nullability nullability =
        javaType.isPrimitive() ? TypedValue.Nullability.NA :
        _schema.isNullable( type ) ? TypedValue.Nullability.NULLABLE :
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
        .interfaceBuilder( NamingUtil.uppercaseFirstCharacter( name ) )
        .addModifiers( Modifier.PUBLIC );
    writeGeneratedAnnotation( type );
    type.addAnnotation( AnnotationSpec.builder( Types.JS_TYPE )
                          .addMember( "isNative", "true" )
                          .addMember( "namespace", "$T.GLOBAL", Types.JS_PACKAGE )
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
        .classBuilder( NamingUtil.uppercaseFirstCharacter( name ) )
        .addModifiers( Modifier.PUBLIC, Modifier.FINAL );
    writeGeneratedAnnotation( type );
    maybeAddJavadoc( definition, type );

    generateConstants( definition.getConstants(), type );

    type.addMethod( MethodSpec
                      .methodBuilder( "of" )
                      .addAnnotation( Types.JS_OVERLAY )
                      .addAnnotation( Types.NONNULL )
                      .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                      .returns( lookupTypeByName( name ) )
                      .addParameter( ParameterSpec
                                       .builder( TypeName.OBJECT, "object", Modifier.FINAL )
                                       .addAnnotation( Types.NONNULL )
                                       .build() )
                      .addStatement( "return $T.cast( object )", Types.JS )
                      .build() );

    type.addMethod( MethodSpec
                      .constructorBuilder()
                      .addModifiers( Modifier.PRIVATE )
                      .build() );

    for ( final AttributeMember attribute : definition.getAttributes() )
    {
      if ( attribute.getModifiers().contains( AttributeMember.Modifier.READ_ONLY ) )
      {
        generateReadOnlyAttribute( attribute, type );
      }
      else
      {
        generateAttribute( attribute, type );
      }
    }

    for ( final OperationMember operation : definition.getOperations() )
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
    final boolean noPublicSymbol = shouldExpectNoGlobalSymbol( definition );

    type.addAnnotation( AnnotationSpec.builder( Types.JS_TYPE )
                          .addMember( "isNative", "true" )
                          .addMember( "namespace", "$T.GLOBAL", Types.JS_PACKAGE )
                          .addMember( "name", "$S", noPublicSymbol ? "Object" : name )
                          .build() );

    writeTopLevelType( name, type );
  }

  private boolean shouldExpectNoGlobalSymbol( @Nonnull final Definition definition )
  {
    return definition.getExtendedAttributes()
      .stream()
      .anyMatch( a -> ExtendedAttribute.Kind.IDENT == a.getKind() &&
                      "LegacyNoInterfaceObject".equals( a.getName() ) );
  }

  private void generateNamespace( @Nonnull final NamespaceDefinition definition )
    throws IOException
  {
    final String name = definition.getName();
    final TypeSpec.Builder type =
      TypeSpec
        // The type "console" starts with a lower case name due to legacy reasons.
        // This next line just makes sure that an uppercase is used for the java type
        .classBuilder( NamingUtil.uppercaseFirstCharacter( name ) )
        .addModifiers( Modifier.PUBLIC, Modifier.FINAL );
    writeGeneratedAnnotation( type );
    maybeAddJavadoc( definition, type );

    for ( final AttributeMember attribute : definition.getAttributes() )
    {
      assert attribute.getModifiers().contains( AttributeMember.Modifier.READ_ONLY );
      generateReadOnlyAttribute( attribute, type );
    }

    for ( final OperationMember operation : definition.getOperations() )
    {
      assert OperationMember.Kind.DEFAULT == operation.getKind();
      generateDefaultOperation( operation, type );
    }

    final AnnotationSpec.Builder jsTypeAnnotation =
      AnnotationSpec
        .builder( Types.JS_TYPE )
        .addMember( "isNative", "true" )
        .addMember( "namespace", "$T.GLOBAL", Types.JS_PACKAGE );

    type.addAnnotation( jsTypeAnnotation
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
        .classBuilder( NamingUtil.uppercaseFirstCharacter( name ) )
        .addModifiers( Modifier.PUBLIC );
    writeGeneratedAnnotation( type );
    maybeAddJavadoc( definition, type );

    final String inherits = definition.getInherits();
    final OperationMember parentConstructor;
    if ( null != inherits )
    {
      parentConstructor = _schema
        .getInterfaceByName( inherits )
        .getOperations()
        .stream()
        .filter( o -> OperationMember.Kind.CONSTRUCTOR == o.getKind() )
        .min( Comparator.comparingLong( o -> o.getArguments()
          .stream()
          .filter( a -> !a.isOptional() && !a.isVariadic() )
          .count() ) )
        .orElse( null );
      type.superclass( lookupTypeByName( inherits ) );
    }
    else
    {
      parentConstructor = null;
    }

    generateConstants( definition.getConstants(), type );

    for ( final AttributeMember attribute : definition.getAttributes() )
    {
      if ( attribute.getModifiers().contains( AttributeMember.Modifier.READ_ONLY ) )
      {
        generateReadOnlyAttribute( attribute, type );
      }
      else
      {
        generateAttribute( attribute, type );
      }
    }

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
        _schema.findCallbackInterfaceByName( event.getEventType().getName() + "Listener" );
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
        .builder( Types.JS_TYPE )
        .addMember( "isNative", "true" )
        .addMember( "namespace", "$T.GLOBAL", Types.JS_PACKAGE );

    type.addAnnotation( jsTypeAnnotation
                          .addMember( "name", "$S", deriveJavascriptName( definition ) )
                          .build() );

    if ( !constructorPresent )
    {
      final MethodSpec.Builder method = MethodSpec.constructorBuilder();
      if ( null != parentConstructor )
      {
        generateSuperCall( parentConstructor, method );
      }
      type.addMethod( method.build() );
    }

    writeTopLevelType( name, type );
  }

  private void generateMapLikeOperations( @Nonnull final String definitionName,
                                          @Nonnull final List<OperationMember> operations,
                                          @Nonnull final MapLikeMember mapLike,
                                          @Nonnull final TypeSpec.Builder type )
  {
    type.addMethod( MethodSpec
                      .methodBuilder( "size" )
                      .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
                      .addAnnotation( AnnotationSpec.builder( Types.JS_PROPERTY )
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
                      .addAnnotation( Types.NULLABLE )
                      .addParameter( keyParam )
                      .returns( boxedValueType )
                      .build() );
    type.addMethod( MethodSpec
                      .methodBuilder( "keys" )
                      .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
                      .addAnnotation( Types.NONNULL )
                      .returns( ParameterizedTypeName.get( Types.JS_ITERATOR, boxedKeyType ) )
                      .build() );
    type.addMethod( MethodSpec
                      .methodBuilder( "values" )
                      .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
                      .addAnnotation( Types.NONNULL )
                      .returns( ParameterizedTypeName.get( Types.JS_ITERATOR, boxedValueType ) )
                      .build() );
    type.addType( TypeSpec
                    .interfaceBuilder( "Entry" )
                    .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                    .addAnnotation( AnnotationSpec.builder( Types.JS_TYPE )
                                      .addMember( "isNative", "true" )
                                      .addMember( "name", "$S", "?" )
                                      .addMember( "namespace", "$T.GLOBAL", Types.JS_PACKAGE )
                                      .build() )
                    .addMethod( MethodSpec.methodBuilder( "key" )
                                  .addAnnotation( Types.JS_OVERLAY )
                                  .addModifiers( Modifier.PUBLIC, Modifier.DEFAULT )
                                  .returns( keyType )
                                  .addStatement( "return $T.asArray( this )[ 0 ].cast()", Types.JS )
                                  .build() )
                    .addMethod( MethodSpec.methodBuilder( "value" )
                                  .addAnnotation( Types.JS_OVERLAY )
                                  .addModifiers( Modifier.PUBLIC, Modifier.DEFAULT )
                                  .returns( valueType )
                                  .addStatement( "return $T.asArray( this )[ 1 ].cast()", Types.JS )
                                  .build() )
                    .build() );
    type.addMethod( MethodSpec
                      .methodBuilder( "entries" )
                      .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
                      .addAnnotation( Types.NONNULL )
                      .returns( ParameterizedTypeName.get( Types.JS_ITERATOR, ClassName.bestGuess( "Entry" ) ) )
                      .build() );
    type.addType( TypeSpec
                    .interfaceBuilder( "ForEachCallback" )
                    .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                    .addAnnotation( Types.JS_FUNCTION )
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
                    .addAnnotation( Types.JS_FUNCTION )
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
                    .addAnnotation( Types.JS_FUNCTION )
                    .addAnnotation( FunctionalInterface.class )
                    .addMethod( MethodSpec
                                  .methodBuilder( "item" )
                                  .addModifiers( Modifier.PUBLIC, Modifier.ABSTRACT )
                                  .addParameter( valueParam )
                                  .addParameter( keyParam )
                                  .addParameter( ParameterSpec
                                                   .builder( lookupTypeByName( definitionName ), "map" )
                                                   .addAnnotation( Types.NONNULL )
                                                   .build() )
                                  .build() )
                    .build() );
    type.addMethod( MethodSpec
                      .methodBuilder( "forEach" )
                      .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
                      .addParameter( ParameterSpec.builder( ClassName.bestGuess( "ForEachCallback" ), "callback" )
                                       .addAnnotation( Types.NONNULL )
                                       .build() )
                      .build() );
    type.addMethod( MethodSpec
                      .methodBuilder( "forEach" )
                      .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
                      .addParameter( ParameterSpec.builder( ClassName.bestGuess( "ForEachCallback2" ), "callback" )
                                       .addAnnotation( Types.NONNULL )
                                       .build() )
                      .build() );
    type.addMethod( MethodSpec
                      .methodBuilder( "forEach" )
                      .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
                      .addParameter( ParameterSpec.builder( ClassName.bestGuess( "ForEachCallback3" ), "callback" )
                                       .addAnnotation( Types.NONNULL )
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
    if ( _schema.isNullable( type ) )
    {
      builder.addAnnotation( Types.NULLABLE );
    }
    else if ( !_schema.resolveType( type ).getKind().isPrimitive() )
    {
      builder.addAnnotation( Types.NONNULL );
    }
  }

  private void generateAddEventListener( @Nonnull final EventMember event,
                                         final int variant,
                                         @Nonnull final TypeSpec.Builder type )
  {
    final String eventName = event.getName();
    final TypeName listenerType = lookupTypeByName( event.getEventType().getName() + "Listener" );
    final MethodSpec.Builder method =
      MethodSpec
        .methodBuilder( "add" + NamingUtil.uppercaseFirstCharacter( eventName ) + "Listener" )
        .addModifiers( Modifier.PUBLIC, Modifier.FINAL )
        .addAnnotation( Types.JS_OVERLAY )
        .addParameter( ParameterSpec
                         .builder( listenerType, "callback", Modifier.FINAL )
                         .addAnnotation( Types.NONNULL )
                         .build() );
    if ( 0 == variant )
    {
      method
        .addParameter( ParameterSpec
                         .builder( lookupTypeByName( "AddEventListenerOptions" ),
                                   "options",
                                   Modifier.FINAL )
                         .addAnnotation( Types.NONNULL )
                         .build() )
        .addStatement( "addEventListener( $S, $T.cast( callback ), options )", eventName, Types.JS );
    }
    else if ( 1 == variant )
    {
      method
        .addParameter( ParameterSpec
                         .builder( TypeName.BOOLEAN, "options", Modifier.FINAL )
                         .build() )
        .addStatement( "addEventListener( $S, $T.cast( callback ), options )", eventName, Types.JS );
    }
    else
    {
      assert 2 == variant;
      method.addStatement( "addEventListener( $S, $T.cast( callback ) )", eventName, Types.JS );
    }

    type.addMethod( method.build() );
  }

  private void generateRemoveEventListener( @Nonnull final EventMember event,
                                            final int variant,
                                            @Nonnull final TypeSpec.Builder type )
  {
    final String eventName = event.getName();
    final TypeName listenerType = lookupTypeByName( event.getEventType().getName() + "Listener" );
    final MethodSpec.Builder method =
      MethodSpec
        .methodBuilder( "remove" + NamingUtil.uppercaseFirstCharacter( eventName ) + "Listener" )
        .addModifiers( Modifier.PUBLIC, Modifier.FINAL )
        .addAnnotation( Types.JS_OVERLAY )
        .addParameter( ParameterSpec
                         .builder( listenerType, "callback", Modifier.FINAL )
                         .addAnnotation( Types.NONNULL )
                         .build() );
    if ( 0 == variant )
    {
      method
        .addParameter( ParameterSpec
                         .builder( lookupTypeByName( "EventListenerOptions" ),
                                   "options",
                                   Modifier.FINAL )
                         .addAnnotation( Types.NONNULL )
                         .build() )
        .addStatement( "removeEventListener( $S, $T.cast( callback ), options )", eventName, Types.JS );
    }
    else if ( 1 == variant )
    {
      method
        .addParameter( ParameterSpec
                         .builder( TypeName.BOOLEAN, "options", Modifier.FINAL )
                         .build() )
        .addStatement( "removeEventListener( $S, $T.cast( callback ), options )", eventName, Types.JS );
    }
    else
    {
      assert 2 == variant;
      method.addStatement( "removeEventListener( $S, $T.cast( callback ) )", eventName, Types.JS );
    }

    type.addMethod( method.build() );
  }

  @Nonnull
  private String deriveJavascriptName( @Nonnull final InterfaceDefinition definition )
  {
    final boolean noInterfaceObject =
      definition
        .getExtendedAttributes()
        .stream()
        .anyMatch( a -> ExtendedAttribute.Kind.NO_ARGS == a.getKind() &&
                        "LegacyNoInterfaceObject".equals( a.getName() ) );
    if ( noInterfaceObject )
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
    final Type actualType = _schema.resolveType( attributeType );
    final String name = attribute.getName();
    final MethodSpec.Builder method =
      MethodSpec
        .methodBuilder( safeJsPropertyMethodName( name ) )
        .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
        .returns( toTypeName( actualType ) )
        .addAnnotation( AnnotationSpec.builder( Types.JS_PROPERTY ).addMember( "name", "$S", name ).build() );
    maybeAddJavadoc( attribute, method );
    if ( _schema.isNullable( attributeType ) )
    {
      method.addAnnotation( Types.NULLABLE );
    }
    else if ( !actualType.getKind().isPrimitive() )
    {
      method.addAnnotation( Types.NONNULL );
    }
    type.addMethod( method.build() );
  }

  private void generateAttribute( @Nonnull final AttributeMember attribute,
                                  @Nonnull final TypeSpec.Builder type )
  {
    assert !attribute.getModifiers().contains( AttributeMember.Modifier.READ_ONLY );
    final Type attributeType = attribute.getType();
    final Type actualType = _schema.resolveType( attributeType );
    final String name = attribute.getName();
    final String fieldName = safeName( name );
    final FieldSpec.Builder field =
      FieldSpec.builder( toTypeName( actualType ), fieldName, Modifier.PUBLIC );
    maybeAddJavadoc( attribute, field );
    if ( !fieldName.equals( name ) )
    {
      field.addAnnotation( AnnotationSpec.builder( Types.JS_PROPERTY ).addMember( "name", "$S", name ).build() );
    }
    if ( _schema.isNullable( attributeType ) )
    {
      field.addAnnotation( Types.NULLABLE );
    }
    else if ( !actualType.getKind().isPrimitive() )
    {
      field.addAnnotation( Types.NONNULL );
    }
    addMagicConstantAnnotationIfNeeded( actualType, field );
    type.addField( field.build() );
  }

  private void generateConstants( @Nonnull final Iterable<ConstMember> constants,
                                  @Nonnull final TypeSpec.Builder type )
  {
    for ( final ConstMember constant : constants )
    {
      generateConstant( constant, type );
    }
  }

  private void generateConstant( @Nonnull final ConstMember constant,
                                 @Nonnull final TypeSpec.Builder type )
  {
    final Type constantType = constant.getType();
    final Type actualType = _schema.resolveType( constantType );
    final FieldSpec.Builder field =
      FieldSpec
        .builder( toTypeName( actualType ),
                  constant.getName(),
                  Modifier.PUBLIC,
                  Modifier.STATIC,
                  Modifier.FINAL )
        .addAnnotation( Types.JS_OVERLAY );

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
        explodeTypeList( argumentList.stream().map( Argument::getType ).collect( Collectors.toList() ) );
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
    final String methodName = safeMethodName( name );
    final MethodSpec.Builder method =
      MethodSpec
        .methodBuilder( methodName )
        .addModifiers( Modifier.PUBLIC, javaInterface ? Modifier.ABSTRACT : Modifier.NATIVE );
    maybeAddJavadoc( operation, method );
    if ( !methodName.equals( name ) )
    {
      method.addAnnotation( AnnotationSpec.builder( Types.JS_METHOD ).addMember( "name", "$S", name ).build() );
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
        explodeTypeList( argumentList.stream().map( Argument::getType ).collect( Collectors.toList() ) );
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
    final String methodName = safeMethodName( name );
    final MethodSpec.Builder method =
      MethodSpec
        .methodBuilder( methodName )
        .addModifiers( Modifier.PUBLIC, Modifier.STATIC, Modifier.NATIVE );
    maybeAddJavadoc( operation, method );
    if ( !methodName.equals( name ) )
    {
      method.addAnnotation( AnnotationSpec.builder( Types.JS_METHOD ).addMember( "name", "$S", name ).build() );
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
      final Type actualType = _schema.resolveType( returnType );
      if ( _schema.isNullable( returnType ) )
      {
        method.addAnnotation( Types.NULLABLE );
      }
      else if ( !actualType.getKind().isPrimitive() )
      {
        method.addAnnotation( Types.NONNULL );
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
        explodeTypeList( argumentList.stream().map( Argument::getType ).collect( Collectors.toList() ) );
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
    final Type type = _schema.resolveType( argument.getType() );
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
    final Type actualType = _schema.resolveType( argument.getType() );
    final TypeName type = typedValue.getJavaType();
    final ParameterSpec.Builder parameter =
      ParameterSpec.builder( argument.isVariadic() ? ArrayTypeName.of( type ) : type, safeName( argument.getName() ) );
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

  private void addMagicConstantAnnotationIfNeeded( @Nonnull final Type type,
                                                   @Nonnull final ParameterSpec.Builder parameter )
  {
    if ( _enableMagicConstants && Kind.TypeReference == type.getKind() )
    {
      final EnumerationDefinition enumeration =
        _schema.findEnumerationByName( ( (TypeReference) type ).getName() );
      if ( null != enumeration )
      {
        parameter.addAnnotation( emitMagicConstantAnnotation( enumeration ) );
      }
    }
  }

  private void addMagicConstantAnnotationIfNeeded( @Nonnull final Type returnType,
                                                   @Nonnull final MethodSpec.Builder method )
  {
    if ( _enableMagicConstants && Kind.TypeReference == returnType.getKind() )
    {
      final EnumerationDefinition enumeration =
        _schema.findEnumerationByName( ( (TypeReference) returnType ).getName() );
      if ( null != enumeration )
      {
        method.addAnnotation( emitMagicConstantAnnotation( enumeration ) );
      }
    }
  }

  private void addMagicConstantAnnotationIfNeeded( @Nonnull final Type returnType,
                                                   @Nonnull final FieldSpec.Builder field )
  {
    if ( _enableMagicConstants && Kind.TypeReference == returnType.getKind() )
    {
      final EnumerationDefinition enumeration =
        _schema.findEnumerationByName( ( (TypeReference) returnType ).getName() );
      if ( null != enumeration )
      {
        field.addAnnotation( emitMagicConstantAnnotation( enumeration ) );
      }
    }
  }

  @Nonnull
  private AnnotationSpec emitMagicConstantAnnotation( @Nonnull final EnumerationDefinition enumeration )
  {
    final ClassName enumerationType =
      ClassName.bestGuess( lookupIdlTypeToJavaType( enumeration.getName() ) );
    return AnnotationSpec
      .builder( Types.MAGIC_CONSTANT )
      .addMember( "valuesFromClass", "$T.class", enumerationType )
      .build();
  }

  private void generateEnumeration( @Nonnull final EnumerationDefinition definition )
    throws IOException
  {
    final String name = definition.getName();
    final TypeSpec.Builder type =
      TypeSpec
        .classBuilder( NamingUtil.uppercaseFirstCharacter( name ) )
        .addModifiers( Modifier.PUBLIC, Modifier.FINAL );
    writeGeneratedAnnotation( type );
    maybeAddJavadoc( definition, type );

    for ( final EnumerationValue enumerationValue : definition.getValues() )
    {
      final String value = enumerationValue.getValue();
      if ( !value.isEmpty() )
      {
        final FieldSpec.Builder field = FieldSpec
          .builder( Types.STRING,
                    safeName( enumerationValueToName( value ) ),
                    Modifier.PUBLIC,
                    Modifier.STATIC,
                    Modifier.FINAL )
          .addAnnotation( Types.NONNULL )
          .initializer( "$S", value );
        maybeAddJavadoc( enumerationValue.getDocumentation(), field );
        type.addField( field.build() );
      }
    }

    type.addMethod( MethodSpec.constructorBuilder().addModifiers( Modifier.PRIVATE ).build() );

    writeTopLevelType( name, type );
  }

  @Nonnull
  private String enumerationValueToName( @Nonnull final String value )
  {
    final StringBuilder sb = new StringBuilder();
    for ( int i = 0; i < value.length(); i++ )
    {
      final char ch = value.charAt( i );
      sb.append( Character.isUnicodeIdentifierPart( ch ) ? ch : "_" );
    }
    return sb.toString();
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
      docs.append( text );
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
  private TypeName lookupTypeByName( @Nonnull final String name )
  {
    return _typeMapping.computeIfAbsent( name, this::getClassName );
  }

  @Nonnull
  @Override
  protected Map<String, Path> getGeneratedFiles()
  {
    return super.getGeneratedFiles();
  }

  @Nonnull
  @Override
  protected Path getMainJavaDirectory()
  {
    return super.getMainJavaDirectory();
  }

  @Nonnull
  private ClassName getClassName( @Nonnull final String name )
  {
    final EnumerationDefinition enumeration = _schema.findEnumerationByName( name );
    return null != enumeration ? Types.STRING : ClassName.bestGuess( lookupIdlTypeToJavaType( name ) );
  }

  @Nonnull
  private TypeName toTypeName( @Nonnull final Type type )
  {
    return toTypeName( type, type.isNullable() );
  }

  @Nonnull
  private TypeName toTypeName( @Nonnull final Type type, final boolean boxed )
  {
    final Kind kind = type.getKind();
    if ( boxed &&
         ( Kind.Byte == kind ||
           Kind.Octet == kind ||
           Kind.Short == kind ||
           Kind.UnsignedShort == kind ||
           Kind.UnsignedLong == kind ||
           Kind.Long == kind ||
           Kind.LongLong == kind ||
           Kind.UnsignedLongLong == kind ) )
    {
      // TODO: This is uncomfortable mapping. Not sure what the solutions is...
      //  We should emit a warning a deal with it later
      return TypeName.DOUBLE.box();
    }
    else if ( Kind.Any == kind )
    {
      return Types.ANY;
    }
    else if ( Kind.Void == kind )
    {
      return TypeName.VOID;
    }
    else if ( Kind.Boolean == kind )
    {
      return boxed ? TypeName.BOOLEAN.box() : TypeName.BOOLEAN;
    }
    else if ( Kind.Byte == kind )
    {
      return TypeName.BYTE;
    }
    else if ( Kind.Octet == kind )
    {
      return TypeName.SHORT;
    }
    else if ( Kind.Short == kind )
    {
      return TypeName.SHORT;
    }
    else if ( Kind.UnsignedShort == kind )
    {
      return TypeName.INT;
    }
    else if ( Kind.Long == kind )
    {
      return TypeName.INT;
    }
    else if ( Kind.UnsignedLong == kind )
    {
      // UnsignedLong is not representable in a JVM but we may it using a signed integer when in jsinterop
      // and just hope it produces the correct value.
      return TypeName.INT;
    }
    else if ( Kind.LongLong == kind )
    {
      // LongLong is actually the same size as a java long in the jre but the way that
      // it is transpiled by GWT/J2CL means we need to represent it as an integer but
      // acknowledge that at runtime the value can exceed what the java type represents
      return TypeName.INT;
    }
    else if ( Kind.UnsignedLongLong == kind )
    {
      // Not representable natively in java but in jsinterop it is best represented as an integer
      // See comment on LongLong type
      return TypeName.INT;
    }
    else if ( Kind.Float == kind || Kind.UnrestrictedFloat == kind )
    {
      return boxed ? TypeName.DOUBLE.box() : TypeName.FLOAT;
    }
    else if ( Kind.Double == kind || Kind.UnrestrictedDouble == kind )
    {
      return boxed ? TypeName.DOUBLE.box() : TypeName.DOUBLE;
    }
    else if ( Kind.DOMString == kind || Kind.ByteString == kind || Kind.USVString == kind )
    {
      return Types.STRING;
    }
    else if ( Kind.Object == kind )
    {
      return TypeName.OBJECT;
    }
    else if ( Kind.Symbol == kind )
    {
      return Types.SYMBOL;
    }
    else if ( Kind.TypeReference == kind )
    {
      final TypeReference typeReference = (TypeReference) type;
      final String name = typeReference.getName();
      if ( null != _schema.findInterfaceByName( name ) ||
           null != _schema.findDictionaryByName( name ) ||
           null != _schema.findCallbackInterfaceByName( name ) ||
           null != _schema.findCallbackByName( name ) )
      {
        return lookupTypeByName( name );
      }
      else if ( null != _schema.findEnumerationByName( name ) )
      {
        return Types.STRING;
      }
      else
      {
        final TypedefDefinition typedef = _schema.getTypedefByName( name );
        if ( Kind.Union == typedef.getType().getKind() )
        {
          return lookupTypeByName( name );
        }
        else
        {
          return toTypeName( typedef.getType() );
        }
      }
    }
    else if ( Kind.Promise == kind )
    {
      return ParameterizedTypeName.get( Types.PROMISE, getUnexpandedType( ( (PromiseType) type ).getResolveType() ) );
    }
    else if ( Kind.Sequence == kind )
    {
      return ParameterizedTypeName.get( Types.JS_ARRAY, getUnexpandedType( ( (SequenceType) type ).getItemType() ) );
    }
    else if ( Kind.Record == kind )
    {
      return ParameterizedTypeName.get( Types.JS_PROPERTY_MAP,
                                        getUnexpandedType( ( (RecordType) type ).getValueType() ) );
    }
    else if ( Kind.FrozenArray == kind )
    {
      return ParameterizedTypeName.get( Types.JS_ARRAY, getUnexpandedType( ( (FrozenArrayType) type ).getItemType() ) );
    }
    else if ( Kind.ArrayBuffer == kind )
    {
      return Types.ARRAY_BUFFER;
    }
    else if ( Kind.DataView == kind )
    {
      return Types.DATA_VIEW;
    }
    else if ( Kind.Int8Array == kind )
    {
      return Types.INT8_ARRAY;
    }
    else if ( Kind.Int16Array == kind )
    {
      return Types.INT16_ARRAY;
    }
    else if ( Kind.Int32Array == kind )
    {
      return Types.INT32_ARRAY;
    }
    else if ( Kind.Uint8Array == kind )
    {
      return Types.UINT8_ARRAY;
    }
    else if ( Kind.Uint16Array == kind )
    {
      return Types.UINT16_ARRAY;
    }
    else if ( Kind.Uint32Array == kind )
    {
      return Types.UINT32_ARRAY;
    }
    else if ( Kind.Uint8ClampedArray == kind )
    {
      return Types.UINT8_CLAMPED_ARRAY;
    }
    else if ( Kind.Float32Array == kind )
    {
      return Types.FLOAT32_ARRAY;
    }
    else if ( Kind.Float64Array == kind )
    {
      return Types.FLOAT64_ARRAY;
    }
    else if ( Kind.Union == kind )
    {
      return lookupTypeByName( generateUnionType( (UnionType) type ) );
    }
    else
    {
      throw new UnsupportedOperationException( kind + " type not currently supported by generator: " + type );
    }
  }

  @Nonnull
  private TypeName getUnexpandedType( @Nonnull final Type type )
  {
    return toTypeName( toJsinteropCompatibleType( _schema.resolveType( type ) ) ).box();
  }

  @Nonnull
  private Type toJsinteropCompatibleType( @Nonnull final Type type )
  {
    final Kind kind = type.getKind();
    if ( kind.isPrimitive() &&
         Kind.Boolean != kind &&
         Kind.Double != kind &&
         Kind.UnrestrictedDouble != kind )
    {
      return new Type( Kind.Double,
                       type.getExtendedAttributes(),
                       type.isNullable(),
                       type.getSourceLocations() );
    }
    else
    {
      return type;
    }
  }

  @Nonnull
  private Map<String, UnionType> getUnions()
  {
    return _unions;
  }

  @Nonnull
  private String generateUnionType( @Nonnull final UnionType type )
  {
    final StringBuilder sb = new StringBuilder();
    for ( final Type memberType : type.getMemberTypes() )
    {
      if ( 0 != sb.length() )
      {
        sb.append( "Or" );
      }
      appendTypeToUnionName( sb, memberType );
    }
    sb.append( "Union" );
    final String name = sb.toString();
    if ( !_unions.containsKey( name ) )
    {
      _unions.put( name, type );
    }
    return name;
  }

  private void appendTypeToUnionName( @Nonnull final StringBuilder sb, @Nonnull final Type type )
  {
    final Kind kind = type.getKind();
    if ( kind.isString() )
    {
      sb.append( "String" );
    }
    else if ( kind.isPrimitive() ||
              kind.isBufferRelated() ||
              Kind.FrozenArray == kind ||
              Kind.Object == kind ||
              Kind.Symbol == kind )
    {
      sb.append( kind.name() );
    }
    else if ( Kind.TypeReference == kind )
    {
      sb.append( ( (TypeReference) type ).getName() );
    }
    else if ( Kind.Sequence == kind )
    {
      appendTypeToUnionName( sb, ( (SequenceType) type ).getItemType() );
      sb.append( "Array" );
    }
    else
    {
      throw new UnsupportedOperationException( "Contains kind " + kind + " in union which has not been implemented" );
    }
  }

  private void registerIdlTypeToJavaTypeMapping()
  {
    _schema.getTypedefs()
      .stream()
      .filter( definition -> Kind.Union == definition.getType().getKind() )
      .forEach( this::registerIdlTypeToJavaType );
    _schema.getCallbacks().forEach( this::registerIdlTypeToJavaType );
    _schema.getCallbackInterfaces().forEach( this::registerIdlTypeToJavaType );
    _schema.getDictionaries().forEach( this::registerIdlTypeToJavaType );
    _schema.getEnumerations().forEach( this::registerIdlTypeToJavaType );
    _schema.getInterfaces().forEach( this::registerIdlTypeToJavaType );
    _schema.getPartialInterfaces().forEach( this::registerIdlTypeToJavaType );
    _schema.getNamespaces().forEach( this::registerIdlTypeToJavaType );
  }

  private void registerIdlTypeToJavaType( @Nonnull final NamedDefinition definition )
  {
    final String namespace =
      definition instanceof InterfaceDefinition ? ( (InterfaceDefinition) definition ).getNamespace() : null;
    final String subPackage = null != namespace ? "." + NamingUtil.underscore( namespace ) : "";
    final String javaType =
      getPackageName() + subPackage + "." + NamingUtil.uppercaseFirstCharacter( definition.getName() );
    registerIdlTypeToJavaType( definition.getName(), javaType );
  }
}
