package org.realityforge.webtack.jsinterop;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeSpec;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.lang.model.element.Modifier;
import org.realityforge.webtack.model.Argument;
import org.realityforge.webtack.model.CallbackInterfaceDefinition;
import org.realityforge.webtack.model.ConstMember;
import org.realityforge.webtack.model.ConstValue;
import org.realityforge.webtack.model.EnumerationDefinition;
import org.realityforge.webtack.model.InterfaceDefinition;
import org.realityforge.webtack.model.Kind;
import org.realityforge.webtack.model.OperationMember;
import org.realityforge.webtack.model.Type;
import org.realityforge.webtack.model.TypeReference;

final class CallbackInterfaceGenerator
{
  void generate( @Nonnull final CodeGenContext context, @Nonnull final CallbackInterfaceDefinition definition )
    throws IOException
  {
    final boolean exposedOnGlobal = ElementUtil.isExposedOnGlobal( definition );
    final TypeSpec.Builder type =
      TypeSpec
        .interfaceBuilder( definition.getName() )
        .addModifiers( Modifier.PUBLIC );
    CodeGenUtil.writeGeneratedAnnotation( type );
    type.addAnnotation( AnnotationSpec.builder( Types.JS_TYPE )
                          .addMember( "isNative", "true" )
                          .addMember( "namespace", "$T.GLOBAL", Types.JS_PACKAGE )
                          .addMember( "name", exposedOnGlobal ? "\"" + definition.getName() + "\"" : "\"?\"" )
                          .build() )
      .addAnnotation( FunctionalInterface.class );

    generateConstants( context, definition.getConstants(), type );

    generateDefaultOperation( context, definition.getOperation(), true, type );

    CodeGenUtil.writeTopLevelType( context, type );
  }

  void generate( @Nonnull final CodeGenContext context, @Nonnull final InterfaceDefinition definition )
    throws IOException
  {
    final boolean exposedOnGlobal = ElementUtil.isExposedOnGlobal( definition );
    if ( !exposedOnGlobal )
    {
      throw new UnsupportedOperationException( "Unexpected scenario with interface named '" + definition.getName() +
                                               "' not exposed on global." );
    }
    final TypeSpec.Builder type =
      TypeSpec
        .classBuilder( definition.getName() )
        .addModifiers( Modifier.PUBLIC );
    CodeGenUtil.writeGeneratedAnnotation( type );
    type.addAnnotation( AnnotationSpec.builder( Types.JS_TYPE )
                          .addMember( "isNative", "true" )
                          .addMember( "namespace", "$T.GLOBAL", Types.JS_PACKAGE )
                          .addMember( "name", exposedOnGlobal ? "\"" + definition.getName() + "\"" : "\"?\"" )
                          .build() );

    final String inherits = definition.getInherits();
    if ( null != inherits )
    {
      type.superclass( context.lookupTypeByName( inherits ) );
    }

    generateConstants( context, definition.getConstants(), type );

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

    CodeGenUtil.writeTopLevelType( context, type );
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
    final Type actualType = CodeGenUtil.resolveTypeDefs( context, constantType );
    final FieldSpec.Builder field =
      FieldSpec.builder( CodeGenUtil.toTypeName( context, constantType, actualType ),
                         constant.getName(),
                         Modifier.PUBLIC,
                         Modifier.STATIC,
                         Modifier.FINAL );
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
      generateDefaultOperation( context, operation, javaInterface, argCount - i, type );
    }
  }

  private void generateDefaultOperation( @Nonnull final CodeGenContext context,
                                         @Nonnull final OperationMember operation,
                                         final boolean javaInterface,
                                         final long maxArgumentCount,
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
      final Type actualType = CodeGenUtil.resolveTypeDefs( context, returnType );
      if ( CodeGenUtil.isNullable( context, returnType ) )
      {
        method.addAnnotation( Types.NULLABLE );
      }
      else if ( !actualType.getKind().isPrimitive() )
      {
        method.addAnnotation( Types.NONNULL );
      }
      method.returns( CodeGenUtil.toTypeName( context, returnType, actualType ) );
    }
    for ( int i = 0; i < maxArgumentCount; i++ )
    {
      generateOperationArgument( context, operation.getArguments().get( i ), false, method );
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
    final Type actualType = CodeGenUtil.resolveTypeDefs( context, argumentType );
    final ParameterSpec.Builder parameter =
      ParameterSpec.builder( CodeGenUtil.toTypeName( context, argumentType, actualType ), argument.getName() );
    addMagicConstantAnnotationIfNeeded( context, actualType, parameter );

    if ( CodeGenUtil.isNullable( context, argumentType ) )
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

  boolean addMagicConstantsAnnotation()
  {
    return true;
  }
}
