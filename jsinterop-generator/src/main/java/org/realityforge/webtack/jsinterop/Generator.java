package org.realityforge.webtack.jsinterop;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Modifier;
import org.realityforge.webtack.model.Argument;
import org.realityforge.webtack.model.AttributeMember;
import org.realityforge.webtack.model.CallbackInterfaceDefinition;
import org.realityforge.webtack.model.ConstMember;
import org.realityforge.webtack.model.ConstValue;
import org.realityforge.webtack.model.DictionaryDefinition;
import org.realityforge.webtack.model.DictionaryMember;
import org.realityforge.webtack.model.Element;
import org.realityforge.webtack.model.EnumerationDefinition;
import org.realityforge.webtack.model.ExtendedAttribute;
import org.realityforge.webtack.model.InterfaceDefinition;
import org.realityforge.webtack.model.Kind;
import org.realityforge.webtack.model.OperationMember;
import org.realityforge.webtack.model.SequenceType;
import org.realityforge.webtack.model.Type;
import org.realityforge.webtack.model.TypeReference;
import org.realityforge.webtack.model.TypedefDefinition;
import org.realityforge.webtack.model.UnionType;
import org.realityforge.webtack.model.WebIDLSchema;

final class Generator
{
  void generate( @Nonnull final CodeGenContext context )
    throws IOException
  {
    final WebIDLSchema schema = context.getSchema();
    for ( final TypedefDefinition definition : schema.getTypedefs() )
    {
      generateTypedef( context, definition );
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

    generateUnionOfMethod( context, name, unionType, type );

    context.writeTopLevelType( type );
  }

  private void generateUnionOfMethod( @Nonnull final CodeGenContext context,
                                      @Nonnull final String name,
                                      @Nonnull final UnionType unionType,
                                      @Nonnull final TypeSpec.Builder type )
  {
    final ClassName self = ClassName.bestGuess( name );
    final List<Type> memberTypes = unionType.getMemberTypes();
    //TODO: We need to generate a separate "of" method for each possible union specialized operation
    for ( final Type memberType : memberTypes )
    {
      final ParameterSpec.Builder parameter =
        ParameterSpec.builder( toTypeName( context, memberType ), "value", Modifier.FINAL );

      final ClassName methodNullability;
      if ( context.getSchema().isNullable( memberType ) )
      {
        parameter.addAnnotation( Types.NULLABLE );
        methodNullability = Types.NULLABLE;
      }
      else if ( !memberType.getKind().isPrimitive() )
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

    generateDictionaryCreateMethod( context, definition, type );

    for ( final DictionaryMember member : definition.getMembers() )
    {
      final Type actualType = context.getSchema().resolveType( member.getType() );
      generateDictionaryMemberGetter( context, member, actualType, type );
      generateDictionaryMemberSetter( context, member, actualType, type );
    }

    context.writeTopLevelType( type );
  }

  private void generateDictionaryCreateMethod( @Nonnull final CodeGenContext context,
                                               @Nonnull final DictionaryDefinition definition,
                                               @Nonnull final TypeSpec.Builder type )
  {
    final List<DictionaryMember> requiredMembers = getRequiredDictionaryMembers( context, definition );

    final ClassName self = ClassName.bestGuess( definition.getName() );
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
      final String name = "$instance$";
      method.addStatement( "final $T $N = $T.uncheckedCast( $T.of() )", self, name, Types.JS, Types.JS_PROPERTY_MAP );
      for ( final DictionaryMember member : requiredMembers )
      {
        final Type memberType = member.getType();
        final Type actualType = context.getSchema().resolveType( memberType );
        final ParameterSpec.Builder parameter =
          ParameterSpec.builder( toTypeName( context, actualType ), member.getName(), Modifier.FINAL );
        if ( context.getSchema().isNullable( memberType ) )
        {
          parameter.addAnnotation( Types.NULLABLE );
        }
        else if ( !actualType.getKind().isPrimitive() )
        {
          parameter.addAnnotation( Types.NONNULL );
        }
        method.addParameter( parameter.build() );
        method.addStatement( "$N.$N( $N )", name, getMutatorName( member ), member.getName() );
      }
      method.addStatement( "return $N", name );
    }
    type.addMethod( method.build() );
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
        .returns( toTypeName( context, actualType ) )
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
    final ParameterSpec.Builder parameter =
      ParameterSpec.builder( toTypeName( context, actualType ), member.getName() );

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

  @Nonnull
  private String getMutatorName( @Nonnull final DictionaryMember member )
  {
    return "set" + NamingUtil.uppercaseFirstCharacter( member.getName() );
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
                          .addMember( "name", exposedOnGlobal ? "\"" + definition.getName() + "\"" : "\"?\"" )
                          .build() )
      .addAnnotation( FunctionalInterface.class );

    generateConstants( context, definition.getConstants(), type );

    generateDefaultOperation( context, definition.getOperation(), true, type );

    context.writeTopLevelType( type );
  }

  private void generateInterface( @Nonnull final CodeGenContext context, @Nonnull final InterfaceDefinition definition )
    throws IOException
  {
    final boolean exposedOnGlobal = isExposedOnGlobal( definition );
    if ( !exposedOnGlobal )
    {
      throw new UnsupportedOperationException( "Unexpected scenario with interface named '" + definition.getName() +
                                               "' not exposed on global." );
    }
    final TypeSpec.Builder type =
      TypeSpec
        .classBuilder( definition.getName() )
        .addModifiers( Modifier.PUBLIC );
    writeGeneratedAnnotation( type );
    type.addAnnotation( AnnotationSpec.builder( Types.JS_TYPE )
                          .addMember( "isNative", "true" )
                          .addMember( "namespace", "$T.GLOBAL", Types.JS_PACKAGE )
                          .addMember( "name", "$S", exposedOnGlobal ? definition.getName() : "?" )
                          .build() );

    final String inherits = definition.getInherits();
    if ( null != inherits )
    {
      type.superclass( context.lookupTypeByName( inherits ) );
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

    for ( final OperationMember operation : definition.getOperations() )
    {
      final OperationMember.Kind operationKind = operation.getKind();
      if ( OperationMember.Kind.DEFAULT == operationKind )
      {
        generateDefaultOperation( context, operation, false, type );
      }
      else if ( OperationMember.Kind.CONSTRUCTOR == operationKind )
      {
        generateConstructorOperation( context, operation, null != inherits, type );
      }
    }

    context.writeTopLevelType( type );
  }

  private void generateReadOnlyAttribute( @Nonnull final CodeGenContext context,
                                          @Nonnull final AttributeMember attribute,
                                          @Nonnull final TypeSpec.Builder type )
  {
    assert attribute.getModifiers().contains( AttributeMember.Modifier.READ_ONLY );
    final Type attributeType = attribute.getType();
    final Type actualType = context.getSchema().resolveType( attributeType );
    final String name = attribute.getName();
    final String prefix = SourceVersion.isName( name ) ? "" : "_";
    final MethodSpec.Builder method =
      MethodSpec
        .methodBuilder( prefix + name )
        .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
        .returns( toTypeName( context, actualType ) )
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
    final FieldSpec.Builder field =
      FieldSpec.builder( toTypeName( context, actualType ), attribute.getName(), Modifier.PUBLIC );
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
        .builder( toTypeName( context, actualType ),
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
      //TODO: We need to generate a separate method for each possible union specialized operation
      generateDefaultOperation( context, operation, javaInterface, argumentList, type );
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
      method.returns( toTypeName( context, actualType ) );
    }
    for ( final Argument argument : arguments )
    {
      generateOperationArgument( context, argument, false, method );
    }
    type.addMethod( method.build() );
  }

  private void generateConstructorOperation( @Nonnull final CodeGenContext context,
                                             @Nonnull final OperationMember operation,
                                             final boolean invokeSuper,
                                             @Nonnull final TypeSpec.Builder type )
  {
    final List<Argument> arguments = operation.getArguments();
    final int argCount = arguments.size();
    final long optionalCount = arguments.stream().filter( Argument::isOptional ).count();
    for ( int i = 0; i <= optionalCount; i++ )
    {
      generateConstructorOperation( context, operation, invokeSuper, argCount - i, type );
    }
  }

  private void generateConstructorOperation( @Nonnull final CodeGenContext context,
                                             @Nonnull final OperationMember operation,
                                             final boolean invokeSuper,
                                             final long maxArgumentCount,
                                             @Nonnull final TypeSpec.Builder type )
  {
    final MethodSpec.Builder method = MethodSpec.constructorBuilder().addModifiers( Modifier.PUBLIC );
    final List<String> superArgs = invokeSuper ? new ArrayList<>() : null;
    for ( int i = 0; i < maxArgumentCount; i++ )
    {
      final Argument argument = operation.getArguments().get( i );
      generateOperationArgument( context, argument, true, method );
      if ( invokeSuper )
      {
        superArgs.add( argument.getName() );
      }
    }
    if ( invokeSuper )
    {
      method.addStatement( "super( " + String.join( ", ", superArgs ) + " )" );
    }

    type.addMethod( method.build() );
  }

  private void generateOperationArgument( @Nonnull final CodeGenContext context,
                                          @Nonnull final Argument argument,
                                          final boolean isFinal,
                                          @Nonnull final MethodSpec.Builder method )
  {
    final Type argumentType = argument.getType();
    final Type actualType = context.getSchema().resolveType( argumentType );
    final ParameterSpec.Builder parameter =
      ParameterSpec.builder( toTypeName( context, actualType ), argument.getName() );
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
                                                   final Type actualType, final ParameterSpec.Builder parameter )
  {
    if ( addMagicConstantsAnnotation() && Kind.TypeReference == actualType.getKind() )
    {
      final EnumerationDefinition enumeration =
        context.getSchema().findEnumerationByName( ( (TypeReference) actualType ).getName() );
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
                         .builder( Types.STRING, name, Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL )
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

  @Nonnull
  private TypeName toTypeName( @Nonnull final CodeGenContext context, @Nonnull final Type type )
  {
    final Kind kind = type.getKind();

    final boolean nullable = type.isNullable();
    if ( nullable &&
         ( Kind.Byte == kind ||
           Kind.Octet == kind ||
           Kind.Short == kind ||
           Kind.UnsignedShort == kind ||
           Kind.Long == kind ||
           Kind.LongLong == kind ||
           Kind.UnsignedLongLong == kind ) )
    {
      throw new UnsupportedOperationException( "Nullable " + kind + " not supported" );
    }

    if ( Kind.Any == kind )
    {
      return Types.ANY;
    }
    else if ( Kind.Void == kind )
    {
      return TypeName.VOID;
    }
    else if ( Kind.Boolean == kind )
    {
      return nullable ? TypeName.BOOLEAN.box() : TypeName.BOOLEAN;
    }
    else if ( Kind.Byte == kind )
    {
      return TypeName.BYTE;
    }
    else if ( Kind.Octet == kind )
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
      return nullable ? TypeName.DOUBLE.box() : TypeName.FLOAT;
    }
    else if ( Kind.Double == kind || Kind.UnrestrictedDouble == kind )
    {
      return nullable ? TypeName.DOUBLE.box() : TypeName.DOUBLE;
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
      final WebIDLSchema schema = context.getSchema();
      if ( null != schema.findInterfaceByName( name ) ||
           null != schema.findDictionaryByName( name ) ||
           null != schema.findCallbackInterfaceByName( name ) ||
           null != schema.findCallbackByName( name ) )
      {
        return context.lookupTypeByName( name );
      }
      else if ( null != schema.findEnumerationByName( name ) )
      {
        return Types.STRING;
      }
      else
      {
        return toTypeName( context, schema.getTypedefByName( name ).getType() );
      }
    }
    else if ( Kind.Promise == kind )
    {
      return Types.PROMISE;
    }
    else if ( Kind.Sequence == kind )
    {
      final Type itemType = ( (SequenceType) type ).getItemType();
      return ParameterizedTypeName.get( Types.JS_ARRAY,
                                        toTypeName( context, context.getSchema().resolveType( itemType ) ) );
    }
    else if ( Kind.Record == kind )
    {
      throw new UnsupportedOperationException( "Record not currently supported by generator" );
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
    else
    {
      throw new UnsupportedOperationException( kind + " type not currently supported by generator: " + type );
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
