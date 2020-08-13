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
import java.util.ArrayList;
import java.util.Arrays;
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
import org.realityforge.webtack.model.OperationMember;
import org.realityforge.webtack.model.PartialInterfaceDefinition;
import org.realityforge.webtack.model.SequenceType;
import org.realityforge.webtack.model.Type;
import org.realityforge.webtack.model.TypeReference;
import org.realityforge.webtack.model.TypedefDefinition;
import org.realityforge.webtack.model.UnionType;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.tools.io.FilesUtil;

final class Generator
{
  @Nonnull
  private static final List<String> OBJECT_METHODS =
    Arrays.asList( "hashCode", "equals", "clone", "toString", "finalize", "getClass", "wait", "notifyAll", "notify" );

  void generate( @Nonnull final CodeGenContext context )
    throws IOException
  {
    FilesUtil.deleteDirectory( context.getMainJavaDirectory() );
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

    if ( context.shouldGenerateGwtModule() )
    {
      writeGwtModule( context );
    }

    final String globalInterface = context.getGlobalInterface();
    if ( null != globalInterface )
    {
      generateGlobal( context, globalInterface );
    }
  }

  private void generateGlobal( @Nonnull final CodeGenContext context, @Nonnull final String globalInterface )
    throws IOException
  {
    final InterfaceDefinition definition = context.getSchema().findInterfaceByName( globalInterface );
    if ( null == definition )
    {
      throw new IllegalStateException( "Declared globalInterface '" + globalInterface + "' does not exist in schema" );
    }
    final TypeSpec.Builder type =
      TypeSpec
        .classBuilder( "Global" )
        .addModifiers( Modifier.PUBLIC, Modifier.FINAL );
    writeGeneratedAnnotation( type );
    type.addAnnotation( AnnotationSpec.builder( Types.JS_TYPE )
                          .addMember( "isNative", "true" )
                          .addMember( "namespace", "$T.GLOBAL", Types.JS_PACKAGE )
                          .addMember( "name", "$S", "goog.global" )
                          .build() );

    type.addMethod( MethodSpec.constructorBuilder().addModifiers( Modifier.PRIVATE ).build() );

    final TypeName globalType = context.lookupTypeByName( definition.getName() );

    type.addField( FieldSpec.builder( globalType, "globalThis", Modifier.PRIVATE, Modifier.STATIC ).build() );

    type.addMethod( MethodSpec.methodBuilder( "globalThis" )
                      .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                      .addAnnotation( Types.JS_OVERLAY )
                      .addAnnotation( Types.NONNULL )
                      .returns( globalType )
                      .addStatement( "return globalThis" )
                      .build() );

    context.writeTopLevelType( type );
  }

  private void writeGwtModule( @Nonnull final CodeGenContext context )
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
    final String packageName = context.getPackageName();
    final String name =
      packageName.isEmpty() ?
      "core" :
      NamingUtil.uppercaseFirstCharacter( packageName.replaceAll( ".*\\.([^.]+)$", "$1" ) );
    context.writeResourceFile( name + ".gwt.xml", gwtModuleContent.getBytes( StandardCharsets.UTF_8 ) );
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
  private List<List<TypedValue>> explodeTypeList( @Nonnull final CodeGenContext context,
                                                  @Nonnull final List<Type> types )
  {
    final List<List<TypedValue>> results = new ArrayList<>();
    results.add( new ArrayList<>() );
    for ( final Type type : types )
    {
      final List<TypedValue> itemTypes = explodeType( context, type );
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
  private List<TypedValue> explodeType( @Nonnull final CodeGenContext context, @Nonnull final Type type )
  {
    final List<TypedValue> values = new ArrayList<>();
    explodeType( context, type, type, values );
    return values;
  }

  private void explodeType( @Nonnull final CodeGenContext context,
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
        explodeType( context, declaredType, resolvedType, values );
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
        explodeType( context, declaredType, memberType, values );
      }
    }
    else if ( Kind.Sequence == kind )
    {
      final SequenceType sequenceType = (SequenceType) type;
      final Type itemType = sequenceType.getItemType();
      final boolean nullable = context.getSchema().isNullable( type );
      final TypeName javaType = context.toTypeName( type );

      final TypeName arrayJavaType = ArrayTypeName.of( context.getUnexpandedType( itemType ) );
      final TypedValue.Nullability nullability =
        nullable ? TypedValue.Nullability.NULLABLE : TypedValue.Nullability.NONNULL;
      values.add( new TypedValue( declaredType, type, javaType, nullability ) );
      values.add( new TypedValue( declaredType, type, arrayJavaType, nullability ) );
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
      for ( final TypedValue typedValue : explodeType( context, memberType ) )
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
    maybeAddJavadoc( definition, type );

    final String inherits = definition.getInherits();
    if ( null != inherits )
    {
      type.addSuperinterface( context.lookupTypeByName( inherits ) );
    }

    final List<DictionaryMember> requiredMembers = getRequiredDictionaryMembers( context, definition );
    final List<List<TypedValue>> explodedTypeList =
      explodeTypeList( context,
                       requiredMembers.stream().map( DictionaryMember::getType ).collect( Collectors.toList() ) );
    for ( final List<TypedValue> argTypes : explodedTypeList )
    {
      generateDictionaryCreateMethod( context, definition, requiredMembers, argTypes, type );
    }

    for ( final DictionaryMember member : definition.getMembers() )
    {
      final Type actualType = context.getSchema().resolveType( member.getType() );
      final TypeName javaType = context.toTypeName( actualType );
      generateDictionaryMemberGetter( context, member, actualType, javaType, type );
      generateDictionaryMemberSetter( context, member, actualType, javaType, type );
      for ( final TypedValue typedValue : explodeType( context, member.getType() ) )
      {
        if ( !javaType.equals( typedValue.getJavaType() ) )
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
        for ( final TypedValue memberType : explodeType( context, member.getType() ) )
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
        params.add( safeMethodName( member.getName() ) );
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
    return isNameJavaSafe( name ) ? name : mangleName( name );
  }

  @Nonnull
  private String safeMethodName( @Nonnull final String name )
  {
    return isMethodNameJavaSafe( name ) ? name : mangleName( name );
  }

  @Nonnull
  private String safeJsPropertyMethodName( @Nonnull final String name )
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

  private boolean isMethodNameJavaSafe( @Nonnull final String name )
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

  private void generateDictionaryMemberSetter( @Nonnull final CodeGenContext context,
                                               @Nonnull final DictionaryMember member,
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

    addNullabilityAnnotation( typedValue, parameter );
    method.addParameter( parameter.build() );
    final WebIDLSchema schema = context.getSchema();
    final Type declaredType = schema.resolveType( typedValue.getDeclaredType() );
    final Type resolvedType = schema.resolveType( typedValue.getType(), true );
    if ( Kind.Union == declaredType.getKind() || unwrapsToUnion( context, declaredType ) )
    {
      method.addStatement( "$N( $T.of( $N ) )", mutatorName, context.toTypeName( declaredType ), paramName );
    }
    else if ( Kind.Sequence == declaredType.getKind() || Kind.Sequence == resolvedType.getKind() )
    {
      method.addStatement( "$N( $T.asJsArray( $N ) )", mutatorName, Types.JS_ARRAY, paramName );
    }
    else
    {
      throw new UnsupportedOperationException( "Create method for dictionary does not yet support exploding " +
                                               typedValue.getType() + " from " + declaredType );
    }
    type.addMethod( method.build() );
  }

  private boolean unwrapsToUnion( @Nonnull final CodeGenContext context, @Nonnull final Type type )
  {
    final Kind kind = type.getKind();
    if ( Kind.TypeReference == kind )
    {
      final String name = ( (TypeReference) type ).getName();
      final TypedefDefinition typedef = context.getSchema().findTypedefByName( name );
      if ( null != typedef )
      {
        final Type otherType = typedef.getType();
        return Kind.Union == otherType.getKind() || unwrapsToUnion( context, otherType );
      }
    }
    return false;
  }

  private void generateDictionaryMemberSetterReturningThis( @Nonnull final CodeGenContext context,
                                                            @Nonnull final DictionaryDefinition dictionary,
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
        .returns( context.lookupTypeByName( dictionary.getName() ) );
    maybeAddJavadoc( member, method );
    if ( addOverride )
    {
      method.addAnnotation( Override.class );
    }
    final TypeName javaType = typedValue.getJavaType();
    final String paramName = safeName( member.getName() );
    final ParameterSpec.Builder parameter =
      ParameterSpec.builder( javaType, paramName, Modifier.FINAL );

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
    maybeAddJavadoc( definition, type );
    final MethodSpec.Builder method =
      MethodSpec
        .methodBuilder( "onInvoke" )
        .addModifiers( Modifier.PUBLIC, Modifier.ABSTRACT );
    emitReturnType( context, definition.getReturnType(), method );
    for ( final Argument argument : definition.getArguments() )
    {
      generateArgument( context, argument, asTypedValue( context, argument.getType() ), false, method );
    }
    type.addMethod( method.build() );

    context.writeTopLevelType( type );
  }

  @Nonnull
  private TypedValue asTypedValue( @Nonnull final CodeGenContext context, final Type type )
  {
    final Type resolveType = context.getSchema().resolveType( type );
    final TypeName javaType = context.toTypeName( resolveType );
    final TypedValue.Nullability nullability =
      javaType.isPrimitive() ? TypedValue.Nullability.NA :
      context.getSchema().isNullable( type ) ? TypedValue.Nullability.NULLABLE :
      TypedValue.Nullability.NONNULL;
    return new TypedValue( type, resolveType, javaType, nullability );
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
    maybeAddJavadoc( definition, type );

    generateConstants( context, definition.getConstants(), type );

    final OperationMember operation = definition.getOperation();
    final List<Argument> arguments = operation.getArguments();
    final List<TypedValue> typedValues = asTypedValuesList( context, arguments );
    generateDefaultOperation( context, operation, true, arguments, typedValues, type );

    context.writeTopLevelType( type );
  }

  @Nonnull
  private List<TypedValue> asTypedValuesList( @Nonnull final CodeGenContext context,
                                              @Nonnull final List<Argument> arguments )
  {
    return arguments.stream().map( a -> asTypedValue( context, a.getType() ) ).collect( Collectors.toList() );
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
    maybeAddJavadoc( definition, type );

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
                      .addModifiers( Modifier.PRIVATE )
                      .build() );

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
        generateDefaultOperation( context, operation, type );
      }
      else if ( OperationMember.Kind.STRINGIFIER == operationKind && null != operation.getName() )
      {
        generateDefaultOperation( context, operation, type );
      }
    }
    final MapLikeMember mapLike = definition.getMapLikeMember();
    if ( null != mapLike )
    {
      generateMapLikeOperations( context, definition.getName(), definition.getOperations(), mapLike, type );
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
    maybeAddJavadoc( definition, type );

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
        generateDefaultOperation( context, operation, type );
      }
      else if ( OperationMember.Kind.STRINGIFIER == operationKind && null != operation.getName() )
      {
        generateDefaultOperation( context, operation, type );
      }
      else if ( OperationMember.Kind.CONSTRUCTOR == operationKind )
      {
        generateConstructorOperation( context, operation, parentConstructor, type );
        constructorPresent = true;
      }
      else if ( OperationMember.Kind.STATIC == operationKind )
      {
        generateStaticOperation( context, operation, type );
      }
    }

    final MapLikeMember mapLike = definition.getMapLikeMember();
    if ( null != mapLike )
    {
      generateMapLikeOperations( context, definition.getName(), definition.getOperations(), mapLike, type );
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
        context.getSchema().findCallbackInterfaceByName( event.getEventType().getName() + "Listener" );
      if ( null != callbackInterface )
      {
        generateAddEventListener( context, event, 0, type );
        generateAddEventListener( context, event, 1, type );
        generateAddEventListener( context, event, 2, type );
        generateRemoveEventListener( context, event, 0, type );
        generateRemoveEventListener( context, event, 1, type );
        generateRemoveEventListener( context, event, 2, type );
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
        generateSuperCall( context, parentConstructor, method );
      }
      type.addMethod( method.build() );
    }

    context.writeTopLevelType( type, context.getNamespace( definition ) );
  }

  private void generateMapLikeOperations( @Nonnull final CodeGenContext context,
                                          @Nonnull final String definitionName,
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
    final TypeName keyType = context.toTypeName( mapLike.getKeyType() );
    final TypeName boxedKeyType = context.toTypeName( mapLike.getKeyType(), true );
    final TypeName valueType = context.toTypeName( mapLike.getValueType() );
    final TypeName boxedValueType = context.toTypeName( mapLike.getValueType(), true );

    final ParameterSpec.Builder keyParamBuilder = ParameterSpec.builder( keyType, "key" );
    addNullabilityAnnotationIfRequired( context, mapLike.getKeyType(), keyParamBuilder );
    final ParameterSpec keyParam = keyParamBuilder.build();

    final ParameterSpec.Builder valueParamBuilder = ParameterSpec.builder( valueType, "value" );
    addNullabilityAnnotationIfRequired( context, mapLike.getValueType(), valueParamBuilder );
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
                                                   .builder( ClassName.bestGuess( definitionName ), "map" )
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

  private void addNullabilityAnnotationIfRequired( @Nonnull final CodeGenContext context,
                                                   @Nonnull final Type type,
                                                   final ParameterSpec.Builder builder )
  {
    if ( context.getSchema().isNullable( type ) )
    {
      builder.addAnnotation( Types.NULLABLE );
    }
    else if ( !context.getSchema().resolveType( type ).getKind().isPrimitive() )
    {
      builder.addAnnotation( Types.NONNULL );
    }
  }

  private void generateAddEventListener( @Nonnull final CodeGenContext context,
                                         @Nonnull final EventMember event,
                                         final int variant,
                                         @Nonnull final TypeSpec.Builder type )
  {
    final String eventName = event.getName();
    final TypeName listenerType = context.lookupTypeByName( event.getEventType().getName() + "Listener" );
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
                         .builder( context.lookupTypeByName( "AddEventListenerOptions" ),
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

  private void generateRemoveEventListener( @Nonnull final CodeGenContext context,
                                            @Nonnull final EventMember event,
                                            final int variant,
                                            @Nonnull final TypeSpec.Builder type )
  {
    final String eventName = event.getName();
    final TypeName listenerType = context.lookupTypeByName( event.getEventType().getName() + "Listener" );
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
                         .builder( context.lookupTypeByName( "EventListenerOptions" ),
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
        .methodBuilder( safeJsPropertyMethodName( name ) )
        .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
        .returns( context.toTypeName( actualType ) )
        .addAnnotation( AnnotationSpec.builder( Types.JS_PROPERTY ).addMember( "name", "$S", name ).build() );
    maybeAddJavadoc( attribute, method );
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
    final String fieldName = safeName( name );
    final FieldSpec.Builder field =
      FieldSpec.builder( context.toTypeName( actualType ), fieldName, Modifier.PUBLIC );
    maybeAddJavadoc( attribute, field );
    if ( !fieldName.equals( name ) )
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

  private void generateDefaultOperation( @Nonnull final CodeGenContext context,
                                         @Nonnull final OperationMember operation,
                                         @Nonnull final TypeSpec.Builder type )
  {
    final List<Argument> arguments = operation.getArguments();
    final int argCount = arguments.size();
    final long optionalCount = arguments.stream().filter( Argument::isOptional ).count();
    for ( int i = 0; i <= optionalCount; i++ )
    {
      final List<Argument> argumentList = operation.getArguments().subList( 0, argCount - i );
      final List<List<TypedValue>> explodedTypeList =
        explodeTypeList( context, argumentList.stream().map( Argument::getType ).collect( Collectors.toList() ) );
      for ( final List<TypedValue> typeList : explodedTypeList )
      {
        generateDefaultOperation( context, operation, false, argumentList, typeList, type );
      }
    }
  }

  private void generateDefaultOperation( @Nonnull final CodeGenContext context,
                                         @Nonnull final OperationMember operation,
                                         final boolean javaInterface,
                                         @Nonnull final List<Argument> arguments,
                                         @Nonnull final List<TypedValue> typeList,
                                         @Nonnull final TypeSpec.Builder type )
  {
    assert OperationMember.Kind.DEFAULT == operation.getKind() ||
           OperationMember.Kind.STRINGIFIER == operation.getKind();
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
    emitReturnType( context, returnType, method );
    int index = 0;
    for ( final Argument argument : arguments )
    {
      final TypedValue typedValue = typeList.get( index++ );
      generateArgument( context, argument, typedValue, false, method );
    }
    type.addMethod( method.build() );
  }

  private void generateStaticOperation( @Nonnull final CodeGenContext context,
                                        @Nonnull final OperationMember operation,
                                        @Nonnull final TypeSpec.Builder type )
  {
    final List<Argument> arguments = operation.getArguments();
    final int argCount = arguments.size();
    final long optionalCount = arguments.stream().filter( Argument::isOptional ).count();
    for ( int i = 0; i <= optionalCount; i++ )
    {
      final List<Argument> argumentList = operation.getArguments().subList( 0, argCount - i );
      final List<List<TypedValue>> explodedTypeList =
        explodeTypeList( context, argumentList.stream().map( Argument::getType ).collect( Collectors.toList() ) );
      for ( final List<TypedValue> typeList : explodedTypeList )
      {
        generateStaticOperation( context, operation, argumentList, typeList, type );
      }
    }
  }

  private void generateStaticOperation( @Nonnull final CodeGenContext context,
                                        @Nonnull final OperationMember operation,
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
    emitReturnType( context, returnType, method );
    int index = 0;
    for ( final Argument argument : arguments )
    {
      generateArgument( context, argument, typeList.get( index++ ), false, method );
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
      final List<Argument> argumentList = arguments.subList( 0, argCount - i );
      final List<List<TypedValue>> explodedTypeList =
        explodeTypeList( context, argumentList.stream().map( Argument::getType ).collect( Collectors.toList() ) );
      for ( final List<TypedValue> typeList : explodedTypeList )
      {
        generateConstructorOperation( context, operation, parentConstructor, argumentList, typeList, type );
      }
    }
  }

  private void generateConstructorOperation( @Nonnull final CodeGenContext context,
                                             @Nonnull final OperationMember operation,
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
      generateArgument( context, argument, typeList.get( index++ ), true, method );
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
                                 @Nonnull final TypedValue typedValue,
                                 final boolean isFinal,
                                 @Nonnull final MethodSpec.Builder method )
  {
    final Type actualType = context.getSchema().resolveType( argument.getType() );
    final TypeName type = typedValue.getJavaType();
    final ParameterSpec.Builder parameter =
      ParameterSpec.builder( argument.isVariadic() ? ArrayTypeName.of( type ) : type, safeName( argument.getName() ) );
    addMagicConstantAnnotationIfNeeded( context, actualType, parameter );
    if ( isFinal )
    {
      parameter.addModifiers( Modifier.FINAL );
    }
    addNullabilityAnnotation( typedValue, parameter );
    // Only the last argument can be variadic
    if ( argument.isVariadic() )
    {
      method.varargs();
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
        for ( final EnumerationValue value : enumeration.getValues() )
        {
          annotation.addMember( "stringValues", "$S", value.getValue() );
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
    maybeAddJavadoc( definition, type );

    for ( final EnumerationValue enumerationValue : definition.getValues() )
    {
      final String value = enumerationValue.getValue();
      if ( !value.isEmpty() )
      {
        final FieldSpec.Builder field = FieldSpec
          .builder( Types.STRING, safeName( toName( value ) ), Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL )
          .addAnnotation( Types.NONNULL )
          .initializer( "$S", value );
        maybeAddJavadoc( enumerationValue.getDocumentation(), field );
        type.addField( field.build() );
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
      sb.append( Character.isUnicodeIdentifierPart( ch ) ? ch : "_" );
    }
    return sb.toString();
  }

  boolean addMagicConstantsAnnotation()
  {
    return true;
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
    docs.append( documentation.getDocumentation() );
    docs.append( "\n" );
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
