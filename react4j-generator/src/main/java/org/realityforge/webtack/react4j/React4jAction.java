package org.realityforge.webtack.react4j;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.TypeVariableName;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.lang.model.element.Modifier;
import org.realityforge.webtack.model.InterfaceDefinition;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.tools.io.FilesUtil;
import org.realityforge.webtack.model.tools.util.AbstractJavaAction;
import org.realityforge.webtack.model.tools.util.NamingUtil;

final class React4jAction
  extends AbstractJavaAction
{
  @Nonnull
  private static final String HTML_ELEMENT = "HTMLElement";
  private final boolean _generateGwtModule;

  React4jAction( @Nonnull final Path outputDirectory,
                 @Nonnull final String packageName,
                 final boolean generateGwtModule )
  {
    super( outputDirectory, packageName );
    _generateGwtModule = generateGwtModule;
  }

  @Override
  public void process( @Nonnull final WebIDLSchema schema )
    throws Exception
  {
    schema.link();
    processInit();

    FilesUtil.deleteDirectory( getMainJavaDirectory() );

    generateFactory( schema, "HTML", HTMLElementsGenerator.create() );

    if ( _generateGwtModule )
    {
      writeGwtModule();
    }
  }

  private void writeGwtModule()
    throws IOException
  {
    final String gwtModuleContent =
      "<module>\n" +
      "  <source path=''/>\n" +
      "</module>\n";
    final String packageName = getPackageName();
    final String name =
      packageName.isEmpty() ?
      "core" :
      NamingUtil.uppercaseFirstCharacter( packageName.replaceAll( ".*\\.([^.]+)$", "$1" ) );
    writeResourceFile( name + ".gwt.xml", gwtModuleContent.getBytes( StandardCharsets.UTF_8 ) );
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

  @SuppressWarnings( "SameParameterValue" )
  private void generateFactory( @Nonnull final WebIDLSchema schema,
                                @Nonnull final String className,
                                @Nonnull final ElementCollection elements )
    throws IOException
  {
    final TypeSpec.Builder type =
      TypeSpec
        .classBuilder( className )
        .addModifiers( Modifier.PUBLIC, Modifier.FINAL );

    writeGeneratedAnnotation( type );
    type.addJavadoc( "Element factory that provides convenience wrappers for creating react4j host elements" );

    type.addMethod( MethodSpec.constructorBuilder().addModifiers( Modifier.PRIVATE ).build() );

    final List<Element> elementSelection =
      elements
        .elements()
        .stream()
        .filter( element -> null != schema.findInterfaceByName( element.getDomInterface() ) )
        .collect( Collectors.toList() );

    final Set<String> inputTypeNames =
      elementSelection
        .stream()
        .map( Element::getDomInterface )
        .collect( Collectors.toSet() );

    final List<InterfaceDefinition> inputTypes =
      inputTypeNames
        .stream()
        .sorted()
        .map( schema::getInterfaceByName )
        .collect( Collectors.toList() );

    // Name of all the types extended by other inputs
    final Set<String> parentTypes = new HashSet<>();

    for ( final InterfaceDefinition definition : new ArrayList<>( inputTypes ) )
    {
      collectParentTypes( schema, inputTypeNames, inputTypes, parentTypes, definition );
    }

    for ( final InterfaceDefinition definition : inputTypes )
    {
      if ( isBaseType( definition ) || parentTypes.contains( definition.getName() ) )
      {
        emitAbstractElementInputsType( definition );
        emitConcreteElementInputsType( definition );
      }
      else
      {
        emitElementInputsType( definition );
      }
    }

    for ( final Element element : elementSelection )
    {
      emitElementFactoryMethods( type, element );
    }

    type.addMethod( emitToArray() );

    type.addMethod( emitCreateElement() );

    writeTopLevelType( type );
  }

  private void collectParentTypes( @Nonnull final WebIDLSchema schema,
                                   @Nonnull final Set<String> inputTypeNames,
                                   @Nonnull final List<InterfaceDefinition> inputTypes,
                                   @Nonnull final Set<String> parentTypes,
                                   @Nonnull final InterfaceDefinition definition )
  {
    if ( !isBaseType( definition ) )
    {
      final String inherits = definition.getInherits();
      assert null != inherits;
      final InterfaceDefinition parent = schema.getInterfaceByName( inherits );
      parentTypes.add( parent.getName() );
      if ( inputTypeNames.add( inherits ) )
      {
        inputTypes.add( parent );
      }
      collectParentTypes( schema, inputTypeNames, inputTypes, parentTypes, parent );
    }
  }

  private void emitAbstractElementInputsType( @Nonnull final InterfaceDefinition definition )
    throws IOException
  {
    final String name = definition.getName();
    final ClassName self = ClassName.get( getPackageName(), "Abstract" + getInputsName( name ) );

    final TypeSpec.Builder type =
      TypeSpec
        .classBuilder( "Abstract" + getInputsName( name ) )
        .addModifiers( Modifier.PUBLIC, Modifier.ABSTRACT )
        .addAnnotation( AnnotationSpec.builder( Types.JS_TYPE )
                          .addMember( "isNative", "true" )
                          .addMember( "namespace", "$T.GLOBAL", Types.JS_PACKAGE )
                          .addMember( "name", "$S", "Object" )
                          .build() )
        .addTypeVariable( TypeVariableName.get( "T",
                                                ParameterizedTypeName.get( self, TypeVariableName.get( "T" ) ) ) );

    if ( isBaseType( definition ) )
    {
      // TODO: Add Magic self() key() id() className()
      type.addMethod( MethodSpec
                        .methodBuilder( "prop" )
                        .addAnnotation( Types.JS_OVERLAY )
                        .addAnnotation( Types.NONNULL )
                        .addModifiers( Modifier.PUBLIC, Modifier.FINAL )
                        .addParameter( ParameterSpec
                                         .builder( Types.STRING, "key", Modifier.FINAL )
                                         .addAnnotation( Types.NONNULL )
                                         .build() )
                        .addParameter( ParameterSpec
                                         .builder( Types.ANY, "value", Modifier.FINAL )
                                         .addAnnotation( Types.NULLABLE )
                                         .build() )
                        .returns( TypeVariableName.get( "T" ) )
                        .addStatement( "$T.asPropertyMap( this ).set( key, value )", Types.JS )
                        .addStatement( "return self()", Types.JS )
                        .build() );
      type.addMethod( MethodSpec
                        .methodBuilder( "self" )
                        .addAnnotation( Types.JS_OVERLAY )
                        .addAnnotation( Types.NONNULL )
                        .addModifiers( Modifier.PROTECTED, Modifier.FINAL )
                        .addStatement( "return $T.uncheckedCast( this )", Types.JS )
                        .returns( TypeVariableName.get( "T" ) )
                        .build() );
    }
    else
    {
      final String inherits = definition.getInherits();
      assert null != inherits;
      final ClassName superclass = ClassName.get( getPackageName(), "Abstract" + getInputsName( inherits ) );

      type.superclass( ParameterizedTypeName.get( superclass, TypeVariableName.get( "T" ) ) );
    }

    writeTopLevelType( type );
  }

  private void emitConcreteElementInputsType( @Nonnull final InterfaceDefinition definition )
    throws IOException
  {
    final String name = definition.getName();

    final ClassName self = ClassName.get( getPackageName(), getInputsName( name ) );
    final ClassName superclass = ClassName.get( getPackageName(), "Abstract" + getInputsName( name ) );
    final TypeSpec.Builder type =
      TypeSpec
        .classBuilder( getInputsName( name ) )
        .addModifiers( Modifier.PUBLIC, Modifier.ABSTRACT )
        .addAnnotation( AnnotationSpec.builder( Types.JS_TYPE )
                          .addMember( "isNative", "true" )
                          .addMember( "namespace", "$T.GLOBAL", Types.JS_PACKAGE )
                          .addMember( "name", "$S", "Object" )
                          .build() )
        .superclass( ParameterizedTypeName.get( superclass, self ) );

    type.addMethod( emitRefSetter( definition ) );

    writeTopLevelType( type );
  }

  @Nonnull
  private MethodSpec emitRefSetter( @Nonnull final InterfaceDefinition definition )
  {
    return MethodSpec
      .methodBuilder( "ref" )
      .addParameter( ParameterSpec
                       .builder( ParameterizedTypeName.get( Types.REF_CALLBACK,
                                                            ClassName.get( "elemental3",
                                                                           definition.getName() ) ),
                                 "callback",
                                 Modifier.FINAL )
                       .addAnnotation( Types.NULLABLE )
                       .build() )
      .addStatement( "prop( $S, $T.asAny( callback ) )", "ref", Types.JS )
      .build();
  }

  private void emitElementInputsType( @Nonnull final InterfaceDefinition definition )
    throws IOException
  {
    final String name = definition.getName();
    final ClassName self = ClassName.get( getPackageName(), getInputsName( name ) );
    final String inherits = definition.getInherits();
    assert null != inherits;
    final ClassName superclass = ClassName.get( getPackageName(), "Abstract" + getInputsName( inherits ) );
    final TypeSpec.Builder type =
      TypeSpec
        .classBuilder( getInputsName( name ) )
        .addModifiers( Modifier.PUBLIC )
        .addAnnotation( AnnotationSpec.builder( Types.JS_TYPE )
                          .addMember( "isNative", "true" )
                          .addMember( "namespace", "$T.GLOBAL", Types.JS_PACKAGE )
                          .addMember( "name", "$S", "Object" )
                          .build() )
        .superclass( ParameterizedTypeName.get( superclass, self ) );

    writeTopLevelType( type );
  }

  private boolean isBaseType( @Nonnull final InterfaceDefinition definition )
  {
    return HTML_ELEMENT.equals( definition.getName() ) || null == definition.getInherits();
  }

  @Nonnull
  private String getInputsName( @Nonnull final String name )
  {
    return ( name.equals( HTML_ELEMENT ) ?
             "Element" :
             name.replaceAll( "^HTML", "" ).replaceAll( "Element$", "" )
           ) + "Inputs";
  }

  private void emitElementFactoryMethods( @Nonnull final TypeSpec.Builder type, @Nonnull final Element element )
  {
    final ClassName inputsClassName = ClassName.get( getPackageName(), getInputsName( element.getDomInterface() ) );
    final ParameterSpec inputsParameter =
      ParameterSpec.builder( inputsClassName, "inputs", Modifier.FINAL ).addAnnotation( Types.NULLABLE ).build();

    type.addMethod( MethodSpec
                      .methodBuilder( element.getName() )
                      .returns( Types.REACT_NODE )
                      .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                      .addAnnotation( Types.NONNULL )
                      .addParameter( inputsParameter )
                      .addStatement( "return createElement( $S, $T.asPropertyMap( inputs ), ($T) null )",
                                     element.getName(),
                                     Types.JS,
                                     Types.REACT_NODE_ARRAY )
                      .build() );
    type.addMethod( MethodSpec
                      .methodBuilder( element.getName() )
                      .returns( Types.REACT_NODE )
                      .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                      .addAnnotation( Types.NONNULL )
                      .addStatement( "return createElement( $S, null, ($T) null )",
                                     element.getName(),
                                     Types.REACT_NODE_ARRAY )
                      .build() );

    if ( element.supportsChildren() )
    {
      type.addMethod( MethodSpec
                        .methodBuilder( element.getName() )
                        .returns( Types.REACT_NODE )
                        .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                        .addAnnotation( Types.NONNULL )
                        .addParameter( inputsParameter )
                        .addParameter( ParameterSpec
                                         .builder( Types.REACT_NODE_ARRAY, "children", Modifier.FINAL )
                                         .addAnnotation( Types.NULLABLE )
                                         .build() )
                        .varargs()
                        .addStatement( "return createElement( $S, $T.asPropertyMap( inputs ), children )",
                                       element.getName(),
                                       Types.JS )
                        .build() );
      type.addMethod( MethodSpec
                        .methodBuilder( element.getName() )
                        .returns( Types.REACT_NODE )
                        .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                        .addAnnotation( Types.NONNULL )
                        .addParameter( ParameterSpec
                                         .builder( Types.REACT_NODE_ARRAY, "children", Modifier.FINAL )
                                         .addAnnotation( Types.NULLABLE )
                                         .build() )
                        .varargs()
                        .addStatement( "return createElement( $S, null, children )", element.getName() )
                        .build() );

      type.addMethod( MethodSpec
                        .methodBuilder( element.getName() )
                        .returns( Types.REACT_NODE )
                        .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                        .addAnnotation( Types.NONNULL )
                        .addParameter( inputsParameter )
                        .addParameter( ParameterSpec
                                         .builder( Types.STREAM_T_REACT_NODE, "children", Modifier.FINAL )
                                         .addAnnotation( Types.NULLABLE )
                                         .build() )
                        .addStatement( "return $N( inputs, toArray( children ) )", element.getName() )
                        .build() );
      type.addMethod( MethodSpec
                        .methodBuilder( element.getName() )
                        .returns( Types.REACT_NODE )
                        .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                        .addAnnotation( Types.NONNULL )
                        .addParameter( ParameterSpec
                                         .builder( Types.STREAM_T_REACT_NODE, "children", Modifier.FINAL )
                                         .addAnnotation( Types.NULLABLE )
                                         .build() )
                        .addStatement( "return $N( toArray( children ) )", element.getName() )
                        .build() );

      final Set<String> permittedContent = element.getPermittedContent();
      if ( permittedContent.contains( "phrasing content" ) ||
           permittedContent.contains( "text content" ) ||
           permittedContent.contains( "transparent content" ) ||
           permittedContent.contains( "flow content" ) )
      {
        type.addMethod( emitElementFactoryWithSimpleContentAndInputs( element, inputsParameter, Types.STRING ) );
        type.addMethod( emitElementFactoryWithSimpleContent( element, Types.STRING ) );
        type.addMethod( emitElementFactoryWithSimpleContentAndInputs( element, inputsParameter, TypeName.BYTE ) );
        type.addMethod( emitElementFactoryWithSimpleContent( element, TypeName.BYTE ) );
        type.addMethod( emitElementFactoryWithSimpleContentAndInputs( element, inputsParameter, TypeName.SHORT ) );
        type.addMethod( emitElementFactoryWithSimpleContent( element, TypeName.SHORT ) );
        type.addMethod( emitElementFactoryWithSimpleContentAndInputs( element, inputsParameter, TypeName.INT ) );
        type.addMethod( emitElementFactoryWithSimpleContent( element, TypeName.INT ) );
        type.addMethod( emitElementFactoryWithSimpleContentAndInputs( element, inputsParameter, TypeName.LONG ) );
        type.addMethod( emitElementFactoryWithSimpleContent( element, TypeName.LONG ) );
        type.addMethod( emitElementFactoryWithSimpleContentAndInputs( element, inputsParameter, TypeName.FLOAT ) );
        type.addMethod( emitElementFactoryWithSimpleContent( element, TypeName.FLOAT ) );
        type.addMethod( emitElementFactoryWithSimpleContentAndInputs( element, inputsParameter, TypeName.DOUBLE ) );
        type.addMethod( emitElementFactoryWithSimpleContent( element, TypeName.DOUBLE ) );
      }
    }
  }

  @Nonnull
  private static MethodSpec emitElementFactoryWithSimpleContentAndInputs( @Nonnull final Element element,
                                                                          @Nonnull final ParameterSpec inputsParameter,
                                                                          @Nonnull final TypeName paramType )
  {
    final ParameterSpec.Builder parameter = ParameterSpec.builder( paramType, "content", Modifier.FINAL );
    if ( !paramType.isPrimitive() )
    {
      parameter.addAnnotation( Types.NULLABLE );
    }

    return MethodSpec
      .methodBuilder( element.getName() )
      .returns( Types.REACT_NODE )
      .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
      .addAnnotation( Types.NONNULL )
      .addParameter( inputsParameter )
      .addParameter( parameter.build() )
      .addStatement( "return $N( inputs, $T.of( content ) )", element.getName(), Types.REACT_NODE )
      .build();
  }

  @Nonnull
  private static MethodSpec emitElementFactoryWithSimpleContent( @Nonnull final Element element,
                                                                 @Nonnull final TypeName paramType )
  {
    final ParameterSpec.Builder parameter = ParameterSpec.builder( paramType, "content", Modifier.FINAL );
    if ( !paramType.isPrimitive() )
    {
      parameter.addAnnotation( Types.NULLABLE );
    }

    return MethodSpec
      .methodBuilder( element.getName() )
      .returns( Types.REACT_NODE )
      .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
      .addAnnotation( Types.NONNULL )
      .addParameter( parameter.build() )
      .addStatement( "return $N( $T.of( content ) )", element.getName(), Types.REACT_NODE )
      .build();
  }

  @Nonnull
  private static MethodSpec emitToArray()
  {
    return MethodSpec
      .methodBuilder( "toArray" )
      .returns( Types.REACT_NODE_ARRAY )
      .addModifiers( Modifier.PRIVATE, Modifier.STATIC )
      .addAnnotation( Types.NONNULL )
      .addParameter( ParameterSpec.builder( Types.STREAM_T_REACT_NODE, "children", Modifier.FINAL )
                       .addAnnotation( Types.NULLABLE )
                       .build() )
      .addStatement( "return children.toArray( $T::new )", Types.REACT_NODE_ARRAY )
      .build();
  }

  @Nonnull
  private static MethodSpec emitCreateElement()
  {
    // This factory approach is reasonably inefficient. It emulates existing react architecture and
    // in the future we should probably change it so that we do not need so much ceremony. We can
    // set key and ref directly without creating a new map for the props.

    // We could also add runtime validation here to check that elements are only contained by elements
    // as allowed by the spec or view components

    // If we ever decided to rewrite the reconciler we could also do things like add hints to indicate a
    // particular element always contain an array of children, a single child or no children or add hints
    // like all children must be keyed etc. This is looking off into the future...

    return MethodSpec
      .methodBuilder( "createElement" )
      .returns( Types.REACT_ELEMENT )
      .addModifiers( Modifier.PRIVATE, Modifier.STATIC )
      .addAnnotation( Types.NONNULL )
      .addParameter( ParameterSpec.builder( String.class, "type", Modifier.FINAL )
                       .addAnnotation( Types.NONNULL )
                       .build() )
      .addParameter( ParameterSpec.builder( Types.JS_PROPERTY_MAP_T_OBJECT, "props", Modifier.FINAL )
                       .addAnnotation( Types.NULLABLE )
                       .build() )
      .addParameter( ParameterSpec.builder( Types.REACT_NODE_ARRAY, "children", Modifier.FINAL )
                       .addAnnotation( Types.NULLABLE )
                       .build() )
      .varargs()
      .addStatement( "final $T actual = $T.of()", Types.JS_PROPERTY_MAP_T_OBJECT, Types.JS_PROPERTY_MAP )
      .addStatement( "$T key = null", String.class )
      .addStatement( "$T ref = null", TypeName.OBJECT )
      .addCode( CodeBlock
                  .builder()
                  .beginControlFlow( "if ( null != props )" )
                  .addStatement( "key = props.has( \"key\" ) ? $T.asString( props.get( \"key\" ) ) : null",
                                 Types.JS )
                  .addStatement( "ref = props.has( \"ref\" ) ? props.get( \"ref\" ) : null" )
                  .addStatement(
                    "props.forEach( p -> { if ( !p.equals( \"key\" ) && !p.equals( \"ref\" ) ) { actual.set( p, props.get( p ) ); } } )" )
                  .endControlFlow()
                  .build() )
      .addCode( CodeBlock
                  .builder()
                  .beginControlFlow( "if ( null != children && children.length > 0 )" )
                  .addStatement( "actual.set( \"children\", 1 == children.length ? children[ 0 ] : children )" )
                  .endControlFlow()
                  .build() )
      .addStatement( "return $T.createHostElement( type, key, ref, actual )", Types.REACT_ELEMENT )
      .build();
  }
}
