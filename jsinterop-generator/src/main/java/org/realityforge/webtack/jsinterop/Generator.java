package org.realityforge.webtack.jsinterop;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ArrayTypeName;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.lang.model.SourceVersion;
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
import org.realityforge.webtack.model.Element;
import org.realityforge.webtack.model.EnumerationDefinition;
import org.realityforge.webtack.model.ExtendedAttribute;
import org.realityforge.webtack.model.InterfaceDefinition;
import org.realityforge.webtack.model.Kind;
import org.realityforge.webtack.model.OperationMember;
import org.realityforge.webtack.model.PartialInterfaceDefinition;
import org.realityforge.webtack.model.PromiseType;
import org.realityforge.webtack.model.Type;
import org.realityforge.webtack.model.TypeReference;
import org.realityforge.webtack.model.TypedefDefinition;
import org.realityforge.webtack.model.UnionType;
import org.realityforge.webtack.model.WebIDLSchema;

final class Generator
{
  @Nonnull
  private static final List<String> OBJECT_METHODS =
    Arrays.asList( "hashCode", "equals", "clone", "toString", "finalize", "getClass", "wait", "notifyAll", "notify" );

  void generate( @Nonnull final CodeGenContext context )
    throws IOException
  {
    final WebIDLSchema schema = context.getSchema();
    for ( final TypedefDefinition definition : schema.getTypedefs() )
    {
      generateTypedef( context, definition );
    }
    for ( final CallbackDefinition definition : schema.getCallbacks() )
    {
      generateCallback( context, definition );
    }
    for ( final CallbackInterfaceDefinition definition : schema.getCallbackInterfaces() )
    {
      generateCallbackInterface( context, definition );
    }
    for ( final DictionaryDefinition definition : schema.getDictionaries() )
    {
      generateDictionary( context, definition );
    }
    for ( final EnumerationDefinition definition : schema.getEnumerations() )
    {
      generateEnumeration( context, definition );
    }
    for ( final InterfaceDefinition definition : schema.getInterfaces() )
    {
      generateInterface( context, definition );
    }
    for ( final PartialInterfaceDefinition definition : schema.getPartialInterfaces() )
    {
      generatePartialInterface( context, definition );
    }

    for ( final Map.Entry<String, UnionType> entry : context.getUnions().entrySet() )
    {
      final String name = entry.getKey();
      final UnionType unionType = entry.getValue();
      generateUnion( context, name, unionType );
    }
  }

  private void generateTypedef( @Nonnull final CodeGenContext context, @Nonnull final TypedefDefinition definition )
    throws IOException
  {
    final Type type = definition.getType();
    final Kind kind = type.getKind();
    if ( Kind.Union == kind )
    {
      final String name = definition.getName();
      final UnionType unionType = (UnionType) type;
      generateUnion( context, name, unionType );
    }
  }

  private void generateUnion( @Nonnull final CodeGenContext context,
                              @Nonnull final String name,
                              @Nonnull final UnionType unionType )
    throws IOException
  {
    final TypeSpec.Builder type =
      TypeSpec
        .interfaceBuilder( name )
        .addModifiers( Modifier.PUBLIC );
    writeGeneratedAnnotation( type );
    type.addAnnotation( AnnotationSpec.builder( Types.JS_TYPE )
                          .addMember( "isNative", "true" )
                          .addMember( "namespace", "$T.GLOBAL", Types.JS_PACKAGE )
                          .addMember( "name", "$S", "?" )
                          .build() );

    generateUnionOfMethods( context, name, unionType, type );

    context.writeTopLevelType( type );
  }

  @Nonnull
  private List<List<Type>> explodeTypeList( @Nonnull final List<Type> types )
  {
    final List<List<Type>> results = new ArrayList<>();
    results.add( new ArrayList<>() );
    for ( final Type type : types )
    {
      final List<Type> itemTypes = explodeType( type );
      if ( 1 == itemTypes.size() )
      {
        final Type itemType = itemTypes.get( 0 );
        results.forEach( result -> result.add( itemType ) );
      }
      else
      {
        final List<List<Type>> dupList = new ArrayList<>( results );
        results.clear();
        for ( final Type itemType : itemTypes )
        {
          for ( final List<Type> result : dupList )
          {
            final List<Type> newList = new ArrayList<>( result );
            newList.add( itemType );
            results.add( newList );
          }
        }
      }
    }
    return results;
  }

  @Nonnull
  private List<Type> explodeType( @Nonnull final Type type )
  {
    final Kind kind = type.getKind();
    if ( Kind.Union == kind )
    {
      final UnionType unionType = (UnionType) type;
      return unionType.getMemberTypes()
        .stream()
        .flatMap( t -> explodeType( t ).stream() )
        .collect( Collectors.toList() );
    }
    else if ( Kind.Promise == kind )
    {
      final PromiseType promiseType = (PromiseType) type;
      final List<Type> resolveTypes = explodeType( promiseType.getResolveType() );
      return resolveTypes
        .stream()
        .map( t -> new PromiseType( t, promiseType.getExtendedAttributes(), promiseType.getSourceLocations() ) )
        .collect( Collectors.toList() );
    }
    else
    {
      return Collections.singletonList( type );
    }
  }

  @Nonnull
  private List<List<TypedValue>> explodeTypeList2( @Nonnull final CodeGenContext context,
                                                   @Nonnull final List<Type> types )
  {
    final List<List<TypedValue>> results = new ArrayList<>();
    results.add( new ArrayList<>() );
    for ( final Type type : types )
    {
      final List<TypedValue> itemTypes = explodeType2( context, type );
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
  private List<TypedValue> explodeType2( @Nonnull final CodeGenContext context, @Nonnull final Type type )
  {
    final List<TypedValue> values = new ArrayList<>();
    explodeType2( context, type, type, values );
    return values;
  }

  private void explodeType2( @Nonnull final CodeGenContext context,
                             @Nonnull final Type declaredType,
                             @Nonnull final Type type,
                             @Nonnull final List<TypedValue> values )
  {
    final Kind kind = type.getKind();
    if ( Kind.TypeReference == type.getKind() )
    {
      final String name = ( (TypeReference) type ).getName();
      final TypedefDefinition typedef = context.getSchema().findTypedefByName( name );
      if ( null != typedef )
      {
        final Type resolvedType = typedef.getType();
        if ( Kind.Union == resolvedType.getKind() )
        {
          final boolean nullable = context.getSchema().isNullable( resolvedType );
          values.add( new TypedValue( declaredType,
                                      type,
                                      context.lookupTypeByName( name ),
                                      nullable ? TypedValue.Nullability.NULLABLE : TypedValue.Nullability.NONNULL ) );
        }
        explodeType2( context, declaredType, resolvedType, values );
      }
      else
      {
        final boolean nullable = context.getSchema().isNullable( type );
        values.add( new TypedValue( declaredType,
                                    type,
                                    context.toTypeName( type ),
                                    nullable ? TypedValue.Nullability.NULLABLE : TypedValue.Nullability.NONNULL ) );
      }
    }
    else if ( Kind.Union == kind )
    {
      final UnionType unionType = (UnionType) type;
      for ( final Type memberType : unionType.getMemberTypes() )
      {
        explodeType2( context, declaredType, memberType, values );
      }
    }
    else if ( Kind.Promise == kind )
    {
      final PromiseType promiseType = (PromiseType) type;
      final List<TypedValue> resolveTypes = explodeType2( context, promiseType.getResolveType() );
      for ( final TypedValue t : resolveTypes )
      {
        final PromiseType p =
          new PromiseType( t.getType(), promiseType.getExtendedAttributes(), promiseType.getSourceLocations() );
        values.add( new TypedValue( declaredType,
                                    p,
                                    context.toTypeName( p ),
                                    TypedValue.Nullability.NONNULL ) );
      }
    }
    else
    {
      final boolean nullable = context.getSchema().isNullable( type );
      TypeName javaType = context.toTypeName( type );
      if ( nullable )
      {
        javaType = javaType.box();
      }
      final TypedValue.Nullability nullability =
        javaType.isPrimitive() ? TypedValue.Nullability.NA :
        nullable ? TypedValue.Nullability.NULLABLE :
        TypedValue.Nullability.NONNULL;
      values.add( new TypedValue( declaredType, type, javaType, nullability ) );
    }
  }

  private void generateUnionOfMethods( @Nonnull final CodeGenContext context,
                                       @Nonnull final String name,
                                       @Nonnull final UnionType unionType,
                                       @Nonnull final TypeSpec.Builder type )
  {
    final ClassName self = ClassName.bestGuess( name );
    final List<Type> memberTypes = unionType.getMemberTypes();
    for ( final Type memberType : memberTypes )
    {
      for ( final TypedValue typedValue : explodeType2( context, memberType ) )
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

  private void generateDictionary( @Nonnull final CodeGenContext context,
                                   @Nonnull final DictionaryDefinition definition )
    throws IOException
  {
    final TypeSpec.Builder type =
      TypeSpec
        .interfaceBuilder( definition.getName() )
        .addModifiers( Modifier.PUBLIC );
    writeGeneratedAnnotation( type );
    type.addAnnotation( AnnotationSpec.builder( Types.JS_TYPE )
                          .addMember( "isNative", "true" )
                          .addMember( "namespace", "$T.GLOBAL", Types.JS_PACKAGE )
                          .addMember( "name", "$S", "?" )
                          .build() );

    final String inherits = definition.getInherits();
    if ( null != inherits )
    {
      type.addSuperinterface( context.lookupTypeByName( inherits ) );
    }

    final List<DictionaryMember> requiredMembers = getRequiredDictionaryMembers( context, definition );
    final List<List<TypedValue>> explodedTypeList =
      explodeTypeList2( context,
                        requiredMembers.stream().map( DictionaryMember::getType ).collect( Collectors.toList() ) );
    for ( final List<TypedValue> argTypes : explodedTypeList )
    {
      generateDictionaryCreateMethod( context, definition, requiredMembers, argTypes, type );
    }

    for ( final DictionaryMember member : definition.getMembers() )
    {
      final Type actualType = context.getSchema().resolveType( member.getType() );
      generateDictionaryMemberGetter( context, member, actualType, type );
      generateDictionaryMemberSetter( context, member, actualType, type );
      for ( final TypedValue typedValue : explodeType2( context, member.getType() ) )
      {
        if ( !actualType.equiv( typedValue.getType() ) )
        {
          generateDictionaryMemberOverlaySetter( context, member, typedValue, type );
        }
        generateDictionaryMemberSetterReturningThis( context, definition, member, typedValue, false, type );
      }
    }
    String superName = definition.getInherits();
    while ( null != superName )
    {
      final DictionaryDefinition parent = context.getSchema().getDictionaryByName( superName );
      for ( final DictionaryMember member : parent.getMembers() )
      {
        for ( final TypedValue memberType : explodeType2( context, member.getType() ) )
        {
          generateDictionaryMemberSetterReturningThis( context, definition, member, memberType, true, type );
        }
      }
      superName = parent.getInherits();
    }

    context.writeTopLevelType( type );
  }

  private void generateDictionaryCreateMethod( @Nonnull final CodeGenContext context,
                                               @Nonnull final DictionaryDefinition definition,
                                               @Nonnull final List<DictionaryMember> requiredMembers,
                                               @Nonnull final List<TypedValue> types,
                                               @Nonnull final TypeSpec.Builder type )
  {
    final TypeName self = context.lookupTypeByName( definition.getName() );
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
        params.add( paramName );
        params.add( paramName );

        final TypedValue memberType = types.get( index++ );
        final ParameterSpec.Builder parameter =
          ParameterSpec.builder( memberType.getJavaType(), paramName, Modifier.FINAL );
        addNullabilityAnnotation( memberType, parameter );
        method.addParameter( parameter.build() );
      }
      method.addStatement( sb.toString(), params.toArray() );
    }
    type.addMethod( method.build() );
  }

  @Nonnull
  private String safeName( @Nonnull final String name )
  {
    return SourceVersion.isName( name ) && !OBJECT_METHODS.contains( name ) ? name : "_" + name;
  }

  @Nonnull
  private List<DictionaryMember> getRequiredDictionaryMembers( @Nonnull final CodeGenContext context,
                                                               @Nonnull final DictionaryDefinition definition )
  {
    final List<DictionaryMember> requiredMembers = new ArrayList<>();
    collectRequiredDictionaryMembers( context, definition, requiredMembers );
    return requiredMembers;
  }

  private void collectRequiredDictionaryMembers( @Nonnull final CodeGenContext context,
                                                 @Nonnull final DictionaryDefinition definition,
                                                 @Nonnull final List<DictionaryMember> members )
  {
    final String inherits = definition.getInherits();
    if ( null != inherits )
    {
      collectRequiredDictionaryMembers( context, context.getSchema().getDictionaryByName( inherits ), members );
    }

    definition.getMembers().stream().filter( m -> !m.isOptional() ).forEach( members::add );
  }

  private void generateDictionaryMemberGetter( @Nonnull final CodeGenContext context,
                                               @Nonnull final DictionaryMember member,
                                               @Nonnull final Type actualType,
                                               @Nonnull final TypeSpec.Builder type )
  {
    final MethodSpec.Builder method =
      MethodSpec
        .methodBuilder( getAccessorName( member ) )
        .addModifiers( Modifier.PUBLIC, Modifier.ABSTRACT )
        .returns( context.toTypeName( actualType ) )
        .addAnnotation( Types.JS_PROPERTY );
    if ( context.getSchema().isNullable( member.getType() ) )
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

  @Nonnull
  private String getAccessorName( @Nonnull final DictionaryMember member )
  {
    final Type type = member.getType();
    final String prefix = !type.isNullable() && type.getKind() == Kind.Boolean ? "is" : "get";
    return prefix + NamingUtil.uppercaseFirstCharacter( member.getName() );
  }

  private void generateDictionaryMemberSetter( @Nonnull final CodeGenContext context,
                                               @Nonnull final DictionaryMember member,
                                               @Nonnull final Type actualType,
                                               @Nonnull final TypeSpec.Builder type )
  {
    final MethodSpec.Builder method =
      MethodSpec
        .methodBuilder( getMutatorName( member ) )
        .addModifiers( Modifier.PUBLIC, Modifier.ABSTRACT )
        .addAnnotation( Types.JS_PROPERTY );
    final String paramName = safeName( member.getName() );
    final ParameterSpec.Builder parameter =
      ParameterSpec.builder( context.toTypeName( actualType ), paramName );

    if ( context.getSchema().isNullable( member.getType() ) )
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

  private void generateDictionaryMemberOverlaySetter( @Nonnull final CodeGenContext context,
                                                      @Nonnull final DictionaryMember member,
                                                      @Nonnull final TypedValue typedValue,
                                                      @Nonnull final TypeSpec.Builder type )
  {
    final String mutatorName = getMutatorName( member );
    final MethodSpec.Builder method =
      MethodSpec
        .methodBuilder( mutatorName )
        .addModifiers( Modifier.PUBLIC, Modifier.DEFAULT )
        .addAnnotation( Types.JS_OVERLAY );
    final String paramName = safeName( member.getName() );
    final ParameterSpec.Builder parameter =
      ParameterSpec.builder( typedValue.getJavaType(), paramName, Modifier.FINAL );

    addNullabilityAnnotation( typedValue, parameter );
    method.addParameter( parameter.build() );
    final Type declaredType = context.getSchema().resolveType( typedValue.getDeclaredType() );
    final Type resolvedType = context.getSchema().resolveType( typedValue.getDeclaredType(), true );
    if ( Kind.Union == declaredType.getKind() || Kind.Union == resolvedType.getKind() )
    {
      method.addStatement( "$N( $T.of( $N ) )", mutatorName, context.toTypeName( declaredType ), paramName );
    }
    else
    {
      throw new UnsupportedOperationException( "Create method for dictionary does not yet support exploding " +
                                               typedValue.getType() + " from " + declaredType );
    }
    type.addMethod( method.build() );
  }

  private void generateDictionaryMemberSetterReturningThis( @Nonnull final CodeGenContext context,
                                                            @Nonnull final DictionaryDefinition dictionary,
                                                            @Nonnull final DictionaryMember member,
                                                            @Nonnull final TypedValue typedValue,
                                                            final boolean addOverride,
                                                            @Nonnull final TypeSpec.Builder type )
  {
    final String paramName = safeName( member.getName() );
    final MethodSpec.Builder method =
      MethodSpec
        .methodBuilder( paramName )
        .addModifiers( Modifier.PUBLIC, Modifier.DEFAULT )
        .addAnnotation( Types.JS_OVERLAY )
        .addAnnotation( Types.NONNULL )
        .returns( context.lookupTypeByName( dictionary.getName() ) );
    if ( addOverride )
    {
      method.addAnnotation( Override.class );
    }
    final ParameterSpec.Builder parameter =
      ParameterSpec.builder( typedValue.getJavaType(), paramName, Modifier.FINAL );

    addNullabilityAnnotation( typedValue, parameter );

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

  @Nonnull
  private String getMutatorName( @Nonnull final DictionaryMember member )
  {
    return "set" + NamingUtil.uppercaseFirstCharacter( member.getName() );
  }

  private void generateCallback( @Nonnull final CodeGenContext context, @Nonnull final CallbackDefinition definition )
    throws IOException
  {
    final TypeSpec.Builder type =
      TypeSpec
        .interfaceBuilder( definition.getName() )
        .addModifiers( Modifier.PUBLIC );
    writeGeneratedAnnotation( type );
    type
      .addAnnotation( Types.JS_FUNCTION )
      .addAnnotation( FunctionalInterface.class );
    final MethodSpec.Builder method =
      MethodSpec
        .methodBuilder( "onInvoke" )
        .addModifiers( Modifier.PUBLIC, Modifier.ABSTRACT );
    emitReturnType( context, definition.getReturnType(), method );
    for ( final Argument argument : definition.getArguments() )
    {
      generateArgument( context, argument, false, method );
    }
    type.addMethod( method.build() );

    context.writeTopLevelType( type );
  }

  private void generateCallbackInterface( @Nonnull final CodeGenContext context,
                                          @Nonnull final CallbackInterfaceDefinition definition )
    throws IOException
  {
    final boolean exposedOnGlobal = isExposedOnGlobal( definition );
    final TypeSpec.Builder type =
      TypeSpec
        .interfaceBuilder( definition.getName() )
        .addModifiers( Modifier.PUBLIC );
    writeGeneratedAnnotation( type );
    type.addAnnotation( AnnotationSpec.builder( Types.JS_TYPE )
                          .addMember( "isNative", "true" )
                          .addMember( "namespace", "$T.GLOBAL", Types.JS_PACKAGE )
                          .addMember( "name", "$S", exposedOnGlobal ? definition.getName() : "?" )
                          .build() )
      .addAnnotation( FunctionalInterface.class );

    generateConstants( context, definition.getConstants(), type );

    generateDefaultOperation( context, definition.getOperation(), true, type );

    context.writeTopLevelType( type );
  }

  private void generatePartialInterface( @Nonnull final CodeGenContext context,
                                         @Nonnull final PartialInterfaceDefinition definition )
    throws IOException
  {
    final TypeSpec.Builder type =
      TypeSpec
        .classBuilder( definition.getName() )
        .addModifiers( Modifier.PUBLIC, Modifier.FINAL );
    writeGeneratedAnnotation( type );

    generateConstants( context, definition.getConstants(), type );

    type.addMethod( MethodSpec
                      .methodBuilder( "of" )
                      .addAnnotation( Types.JS_OVERLAY )
                      .addAnnotation( Types.NONNULL )
                      .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                      .returns( context.lookupTypeByName( definition.getName() ) )
                      .addParameter( ParameterSpec
                                       .builder( TypeName.OBJECT, "object", Modifier.FINAL )
                                       .addAnnotation( Types.NONNULL )
                                       .build() )
                      .addStatement( "return $T.cast( object )", Types.JS )
                      .build() );

    type.addMethod( MethodSpec
                      .constructorBuilder()
                      .addAnnotation( Deprecated.class )
                      .addModifiers( Modifier.PRIVATE )
                      .addJavadoc( "Use the static of method to cast an existing object to this type." ).build() );

    for ( final AttributeMember attribute : definition.getAttributes() )
    {
      if ( attribute.getModifiers().contains( AttributeMember.Modifier.READ_ONLY ) )
      {
        generateReadOnlyAttribute( context, attribute, type );
      }
      else
      {
        generateAttribute( context, attribute, type );
      }
    }

    for ( final OperationMember operation : definition.getOperations() )
    {
      final OperationMember.Kind operationKind = operation.getKind();
      if ( OperationMember.Kind.DEFAULT == operationKind )
      {
        generateDefaultOperation( context, operation, false, type );
      }
    }

    final boolean noPublicSymbol = shouldExpectNoGlobalSymbol( definition );

    type.addAnnotation( AnnotationSpec.builder( Types.JS_TYPE )
                          .addMember( "isNative", "true" )
                          .addMember( "namespace", "$T.GLOBAL", Types.JS_PACKAGE )
                          .addMember( "name", "$S", noPublicSymbol ? "Object" : definition.getName() )
                          .build() );

    context.writeTopLevelType( type );
  }

  private boolean shouldExpectNoGlobalSymbol( @Nonnull final Definition definition )
  {
    return definition.getExtendedAttributes()
      .stream()
      .anyMatch( a -> ExtendedAttribute.Kind.IDENT == a.getKind() &&
                      "LegacyNoInterfaceObject".equals( a.getName() ) );
  }

  private void generateInterface( @Nonnull final CodeGenContext context, @Nonnull final InterfaceDefinition definition )
    throws IOException
  {
    final TypeSpec.Builder type =
      TypeSpec
        .classBuilder( definition.getName() )
        .addModifiers( Modifier.PUBLIC );
    writeGeneratedAnnotation( type );

    final String inherits = definition.getInherits();
    final OperationMember parentConstructor;
    if ( null != inherits )
    {
      parentConstructor = context
        .getSchema()
        .getInterfaceByName( inherits )
        .getOperations()
        .stream()
        .filter( o -> OperationMember.Kind.CONSTRUCTOR == o.getKind() )
        .min( Comparator.comparingLong( o -> o.getArguments()
          .stream()
          .filter( a -> !a.isOptional() && !a.isVariadic() )
          .count() ) )
        .orElse( null );
      type.superclass( context.lookupTypeByName( inherits ) );
    }
    else
    {
      parentConstructor = null;
    }

    generateConstants( context, definition.getConstants(), type );

    for ( final AttributeMember attribute : definition.getAttributes() )
    {
      if ( attribute.getModifiers().contains( AttributeMember.Modifier.READ_ONLY ) )
      {
        generateReadOnlyAttribute( context, attribute, type );
      }
      else
      {
        generateAttribute( context, attribute, type );
      }
    }

    boolean constructorPresent = false;
    for ( final OperationMember operation : definition.getOperations() )
    {
      final OperationMember.Kind operationKind = operation.getKind();
      if ( OperationMember.Kind.DEFAULT == operationKind )
      {
        generateDefaultOperation( context, operation, false, type );
      }
      else if ( OperationMember.Kind.CONSTRUCTOR == operationKind )
      {
        generateConstructorOperation( context, operation, parentConstructor, type );
        constructorPresent = true;
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
      final MethodSpec.Builder method = MethodSpec.constructorBuilder().addAnnotation( Deprecated.class );
      method.addJavadoc( "Type is instantiated by the runtime no attempt should be made to " +
                         "instantiate type by application code." );

      if ( null != parentConstructor )
      {
        generateSuperCall( context, parentConstructor, method );
      }
      type.addMethod( method.build() );
    }

    context.writeTopLevelType( type );
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
      final String namespace =
        definition
          .getExtendedAttributes()
          .stream()
          .filter( a -> ExtendedAttribute.Kind.IDENT == a.getKind() && "LegacyNamespace".equals( a.getName() ) )
          .map( ExtendedAttribute::getIdent )
          .map( n -> n + "." )
          .findAny()
          .orElse( "" );
      return namespace + definition.getName();
    }
  }

  private void generateReadOnlyAttribute( @Nonnull final CodeGenContext context,
                                          @Nonnull final AttributeMember attribute,
                                          @Nonnull final TypeSpec.Builder type )
  {
    assert attribute.getModifiers().contains( AttributeMember.Modifier.READ_ONLY );
    final Type attributeType = attribute.getType();
    final Type actualType = context.getSchema().resolveType( attributeType );
    final String name = attribute.getName();
    final MethodSpec.Builder method =
      MethodSpec
        .methodBuilder( safeName( name ) )
        .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
        .returns( context.toTypeName( actualType ) )
        .addAnnotation( AnnotationSpec.builder( Types.JS_PROPERTY ).addMember( "name", "$S", name ).build() );
    if ( context.getSchema().isNullable( attributeType ) )
    {
      method.addAnnotation( Types.NULLABLE );
    }
    else if ( !actualType.getKind().isPrimitive() )
    {
      method.addAnnotation( Types.NONNULL );
    }
    type.addMethod( method.build() );
  }

  private void generateAttribute( @Nonnull final CodeGenContext context,
                                  @Nonnull final AttributeMember attribute,
                                  @Nonnull final TypeSpec.Builder type )
  {
    assert !attribute.getModifiers().contains( AttributeMember.Modifier.READ_ONLY );
    final Type attributeType = attribute.getType();
    final Type actualType = context.getSchema().resolveType( attributeType );
    final String name = attribute.getName();
    final String safeName = safeName( name );
    final FieldSpec.Builder field =
      FieldSpec.builder( context.toTypeName( actualType ), safeName, Modifier.PUBLIC );
    if ( !safeName.equals( name ) )
    {
      field.addAnnotation( AnnotationSpec.builder( Types.JS_PROPERTY ).addMember( "name", "$S", name ).build() );
    }
    if ( context.getSchema().isNullable( attributeType ) )
    {
      field.addAnnotation( Types.NULLABLE );
    }
    else if ( !actualType.getKind().isPrimitive() )
    {
      field.addAnnotation( Types.NONNULL );
    }
    type.addField( field.build() );
  }

  private void generateConstants( @Nonnull final CodeGenContext context,
                                  @Nonnull final Iterable<ConstMember> constants,
                                  @Nonnull final TypeSpec.Builder type )
  {
    for ( final ConstMember constant : constants )
    {
      generateConstant( context, constant, type );
    }
  }

  private void generateConstant( @Nonnull final CodeGenContext context,
                                 @Nonnull final ConstMember constant,
                                 @Nonnull final TypeSpec.Builder type )
  {
    final Type constantType = constant.getType();
    final Type actualType = context.getSchema().resolveType( constantType );
    final FieldSpec.Builder field =
      FieldSpec
        .builder( context.toTypeName( actualType ),
                  constant.getName(),
                  Modifier.PUBLIC,
                  Modifier.STATIC,
                  Modifier.FINAL )
        .addAnnotation( Types.JS_OVERLAY );
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

  private void generateDefaultOperation( @Nonnull final CodeGenContext context,
                                         @Nonnull final OperationMember operation,
                                         final boolean javaInterface,
                                         @Nonnull final TypeSpec.Builder type )
  {
    final List<Argument> arguments = operation.getArguments();
    final int argCount = arguments.size();
    final long optionalCount = arguments.stream().filter( Argument::isOptional ).count();
    for ( int i = 0; i <= optionalCount; i++ )
    {
      final List<Argument> argumentList = operation.getArguments().subList( 0, argCount - i );
      final List<List<Type>> explodedTypeList =
        explodeTypeList( argumentList.stream().map( Argument::getType ).collect( Collectors.toList() ) );
      for ( final List<Type> typeList : explodedTypeList )
      {
        final List<Argument> args = new ArrayList<>();
        final int variantArgCount = typeList.size();
        for ( int j = 0; j < variantArgCount; j++ )
        {
          final Type argType = typeList.get( j );
          final Argument argument = argumentList.get( j );
          args.add( new Argument( argument.getName(),
                                  argType,
                                  argument.isOptional(),
                                  argument.isVariadic(),
                                  argument.getDefaultValue(),
                                  argument.getExtendedAttributes(),
                                  argument.getSourceLocations() ) );
        }
        generateDefaultOperation( context, operation, javaInterface, args, type );
      }
    }
  }

  private void generateDefaultOperation( @Nonnull final CodeGenContext context,
                                         @Nonnull final OperationMember operation,
                                         final boolean javaInterface,
                                         @Nonnull final List<Argument> arguments,
                                         @Nonnull final TypeSpec.Builder type )
  {
    assert OperationMember.Kind.DEFAULT == operation.getKind();
    final String name = operation.getName();
    assert null != name;
    final MethodSpec.Builder method = MethodSpec.methodBuilder( name ).addModifiers( Modifier.PUBLIC );
    method.addModifiers( javaInterface ? Modifier.ABSTRACT : Modifier.NATIVE );
    final Type returnType = operation.getReturnType();
    emitReturnType( context, returnType, method );
    for ( final Argument argument : arguments )
    {
      generateArgument( context, argument, false, method );
    }
    type.addMethod( method.build() );
  }

  private void emitReturnType( @Nonnull final CodeGenContext context,
                               @Nonnull final Type returnType,
                               @Nonnull final MethodSpec.Builder method )
  {
    if ( Kind.Void != returnType.getKind() )
    {
      final Type actualType = context.getSchema().resolveType( returnType );
      if ( context.getSchema().isNullable( returnType ) )
      {
        method.addAnnotation( Types.NULLABLE );
      }
      else if ( !actualType.getKind().isPrimitive() )
      {
        method.addAnnotation( Types.NONNULL );
      }
      method.returns( context.toTypeName( returnType ) );
    }
  }

  private void generateConstructorOperation( @Nonnull final CodeGenContext context,
                                             @Nonnull final OperationMember operation,
                                             @Nullable final OperationMember parentConstructor,
                                             @Nonnull final TypeSpec.Builder type )
  {
    final List<Argument> arguments = operation.getArguments();
    final int argCount = arguments.size();
    final long optionalCount = arguments.stream().filter( Argument::isOptional ).count();
    for ( int i = 0; i <= optionalCount; i++ )
    {
      generateConstructorOperation( context, operation, parentConstructor, argCount - i, type );
    }
  }

  private void generateConstructorOperation( @Nonnull final CodeGenContext context,
                                             @Nonnull final OperationMember operation,
                                             @Nullable final OperationMember parentConstructor,
                                             final long maxArgumentCount,
                                             @Nonnull final TypeSpec.Builder type )
  {
    final MethodSpec.Builder method = MethodSpec.constructorBuilder().addModifiers( Modifier.PUBLIC );
    for ( int i = 0; i < maxArgumentCount; i++ )
    {
      generateArgument( context, operation.getArguments().get( i ), true, method );
    }
    if ( null != parentConstructor )
    {
      generateSuperCall( context, parentConstructor, method );
    }

    type.addMethod( method.build() );
  }

  private void generateSuperCall( @Nonnull final CodeGenContext context,
                                  @Nonnull final OperationMember parentConstructor,
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
        arguments.stream().map( a -> defaultValue( context, a, params ) ).collect( Collectors.joining( ", " ) ) +
        " )";
      method.addStatement( statement, params.toArray() );
    }
  }

  @Nonnull
  private String defaultValue( @Nonnull final CodeGenContext context,
                               @Nonnull final Argument argument,
                               @Nonnull final List<Object> params )
  {
    final Type type = context.getSchema().resolveType( argument.getType() );
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
      params.add( context.toTypeName( type ) );
      return "null";
    }
  }

  private void generateArgument( @Nonnull final CodeGenContext context,
                                 @Nonnull final Argument argument,
                                 final boolean isFinal,
                                 @Nonnull final MethodSpec.Builder method )
  {
    final Type argumentType = argument.getType();
    final Type actualType = context.getSchema().resolveType( argumentType );
    final TypeName type = context.toTypeName( actualType );
    final ParameterSpec.Builder parameter =
      ParameterSpec.builder( argument.isVariadic() ? ArrayTypeName.of( type ) : type, argument.getName() );
    addMagicConstantAnnotationIfNeeded( context, actualType, parameter );
    if ( isFinal )
    {
      parameter.addModifiers( Modifier.FINAL );
    }
    if ( context.getSchema().isNullable( argumentType ) )
    {
      parameter.addAnnotation( Types.NULLABLE );
    }
    else if ( !actualType.getKind().isPrimitive() )
    {
      parameter.addAnnotation( Types.NONNULL );
    }
    // Only the last argument can be variadic
    if ( argument.isVariadic() )
    {
      method.varargs( true );
    }
    method.addParameter( parameter.build() );
  }

  private void addMagicConstantAnnotationIfNeeded( @Nonnull final CodeGenContext context,
                                                   @Nonnull final Type type,
                                                   @Nonnull final ParameterSpec.Builder parameter )
  {
    if ( addMagicConstantsAnnotation() && Kind.TypeReference == type.getKind() )
    {
      final EnumerationDefinition enumeration =
        context.getSchema().findEnumerationByName( ( (TypeReference) type ).getName() );
      if ( null != enumeration )
      {
        final AnnotationSpec.Builder annotation = AnnotationSpec.builder( Types.MAGIC_CONSTANT );
        for ( final String value : enumeration.getValues() )
        {
          annotation.addMember( "stringValues", "$S", value );
        }
        parameter.addAnnotation( annotation.build() );
      }
    }
  }

  private void generateEnumeration( @Nonnull final CodeGenContext context,
                                    @Nonnull final EnumerationDefinition definition )
    throws IOException
  {
    final TypeSpec.Builder type =
      TypeSpec
        .classBuilder( definition.getName() )
        .addModifiers( Modifier.PUBLIC, Modifier.FINAL );
    writeGeneratedAnnotation( type );

    for ( final String value : definition.getValues() )
    {
      if ( !value.isEmpty() )
      {
        final String name = toName( value );
        type.addField( FieldSpec
                         .builder( Types.STRING, safeName( name ), Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL )
                         .addAnnotation( Types.NONNULL )
                         .initializer( "$S", value )
                         .build() );
      }
    }

    type.addMethod( MethodSpec.constructorBuilder().addModifiers( Modifier.PRIVATE ).build() );

    context.writeTopLevelType( type );
  }

  @Nonnull
  private String toName( @Nonnull final String value )
  {
    final StringBuilder sb = new StringBuilder();
    for ( int i = 0; i < value.length(); i++ )
    {
      final char ch = value.charAt( i );
      if ( ( i == 0 && Character.isUnicodeIdentifierStart( ch ) ) ||
           ( i != 0 && Character.isUnicodeIdentifierPart( ch ) ) )
      {
        sb.append( ch );
      }
      else
      {
        sb.append( "_" );
      }
    }
    return sb.toString();
  }

  boolean addMagicConstantsAnnotation()
  {
    return true;
  }

  private void writeGeneratedAnnotation( @Nonnull final TypeSpec.Builder builder )
  {
    Class<?> generated = getGeneratedAnnotation();
    if ( null != generated )
    {
      builder.addAnnotation( AnnotationSpec.builder( ClassName.get( generated ) )
                               .addMember( "value", "$S", "org.realityforge.webtack" )
                               .build() );
    }
  }

  @Nullable
  private Class<?> getGeneratedAnnotation()
  {
    try
    {
      return Class.forName( "javax.annotation.processing.Generated" );
    }
    catch ( final ClassNotFoundException ignored )
    {
      try
      {
        return Class.forName( "javax.annotation.Generated" );
      }
      catch ( final ClassNotFoundException ignored2 )
      {
        //Generate no annotation
        return null;
      }
    }
  }

  private boolean isExposedOnGlobal( @Nonnull final Element element )
  {
    return element.getExtendedAttributes()
      .stream()
      .filter( a -> a.getKind() == ExtendedAttribute.Kind.IDENT || a.getKind() == ExtendedAttribute.Kind.IDENT_LIST )
      .anyMatch( a -> a.getName().equals( "Exposed" ) );
  }
}
