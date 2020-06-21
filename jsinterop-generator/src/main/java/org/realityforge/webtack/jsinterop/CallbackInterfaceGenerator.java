package org.realityforge.webtack.jsinterop;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeSpec;
import java.io.IOException;
import java.util.List;
import javax.annotation.Nonnull;
import javax.lang.model.element.Modifier;
import org.realityforge.webtack.model.Argument;
import org.realityforge.webtack.model.CallbackInterfaceDefinition;
import org.realityforge.webtack.model.Kind;
import org.realityforge.webtack.model.OperationMember;
import org.realityforge.webtack.model.Type;

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

    final OperationMember operation = definition.getOperation();
    final String name = operation.getName();
    assert null != name;
    final MethodSpec.Builder method =
      MethodSpec.methodBuilder( name ).addModifiers( Modifier.PUBLIC, Modifier.ABSTRACT );
    final Type returnType = operation.getReturnType();
    if ( Kind.Void != returnType.getKind() )
    {
      final Type actualType = CodeGenUtil.resolveTypeDefs( context, returnType );
      method.returns( CodeGenUtil.toTypeName( context, returnType, actualType ) );
    }
    final List<Argument> arguments = operation.getArguments();
    for ( final Argument argument : arguments )
    {
      final Type argumentType = argument.getType();
      final Type actualType = CodeGenUtil.resolveTypeDefs( context, argumentType );
      final ParameterSpec.Builder parameter =
        ParameterSpec.builder( CodeGenUtil.toTypeName( context, argumentType, actualType ), argument.getName() );
      if ( CodeGenUtil.isNullable( context, argumentType ) )
      {
        parameter.addAnnotation( Types.NULLABLE );
      }
      else if ( !argumentType.getKind().isPrimitive() )
      {
        parameter.addAnnotation( Types.NONNULL );
      }
      // TODO: Add jetbrains annotation for enumerations constants
      method.addParameter( parameter.build() );
    }
    type.addMethod( method.build() );

    // TODO: Constants

    CodeGenUtil.writeTopLevelType( context, type );
  }
}
