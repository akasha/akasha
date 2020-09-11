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
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.lang.model.element.Modifier;
import org.realityforge.webtack.model.AttributeMember;
import org.realityforge.webtack.model.EnumerationDefinition;
import org.realityforge.webtack.model.InterfaceDefinition;
import org.realityforge.webtack.model.Kind;
import org.realityforge.webtack.model.Type;
import org.realityforge.webtack.model.TypeReference;
import org.realityforge.webtack.model.TypedefDefinition;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.tools.io.FilesUtil;
import org.realityforge.webtack.model.tools.mdn_scanner.DocRepositoryRuntime;
import org.realityforge.webtack.model.tools.util.AbstractJavaAction;
import org.realityforge.webtack.model.tools.util.NamingUtil;

final class React4jAction
  extends AbstractJavaAction
{
  @Nonnull
  private static final String HTML_ELEMENT = "HTMLElement";
  @Nonnull
  private final DocRepositoryRuntime _docRepository;
  private final boolean _generateGwtModule;
  private final boolean _enableMagicConstants;
  private WebIDLSchema _schema;

  React4jAction( @Nonnull final Path outputDirectory,
                 @Nonnull final String packageName,
                 @Nonnull final List<Path> inputTypeCatalogs,
                 @Nonnull final DocRepositoryRuntime docRepository,
                 final boolean generateGwtModule,
                 final boolean enableMagicConstants )
  {
    super( outputDirectory, packageName, inputTypeCatalogs );
    _docRepository = Objects.requireNonNull( docRepository );
    _generateGwtModule = generateGwtModule;
    _enableMagicConstants = enableMagicConstants;
  }

  @Override
  public void process( @Nonnull final WebIDLSchema schema )
    throws Exception
  {
    _schema = schema;
    schema.link();
    processInit();

    FilesUtil.deleteDirectory( getMainJavaDirectory() );

    generateRefCallback();

    final List<Element> elements =
      HTMLElementsGenerator
        .create()
        .elements()
        .stream()
        .filter( element -> null != schema.findInterfaceByName( element.getDomInterface() ) )
        .collect( Collectors.toList() );

    emitInputTypes( schema, elements );
    emitFactoryType( "HTML", elements );

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
    writeResourceFile( getMainJavaDirectory(), name + ".gwt.xml", gwtModuleContent.getBytes( StandardCharsets.UTF_8 ) );
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
  private void generateRefCallback()
    throws IOException
  {
    final TypeVariableName typeVariable = TypeVariableName.get( "T" );
    final TypeSpec.Builder type =
      TypeSpec
        .interfaceBuilder( "RefCallback" )
        .addModifiers( Modifier.PUBLIC, Modifier.ABSTRACT )
        .addTypeVariable( typeVariable )
        .addJavadoc( "Pass an element instance from the renderer." );

    writeGeneratedAnnotation( type );

    type
      .addAnnotation( Types.JS_FUNCTION )
      .addAnnotation( FunctionalInterface.class );

    type.addMethod( MethodSpec
                      .methodBuilder( "accept" )
                      .addModifiers( Modifier.PUBLIC, Modifier.ABSTRACT )
                      .addParameter( ParameterSpec
                                       .builder( typeVariable, "reference" )
                                       .addAnnotation( Types.NULLABLE )
                                       .build() )
                      .addJavadoc( "Passes the reference to the component instance or element.\n" +
                                   "The reference is nonnull when the element has been attached to the DOM and\n" +
                                   "null when the reference has been detached from the DOM.\n" +
                                   "\n" +
                                   "@param reference the reference." )
                      .build() );

    writeTopLevelType( type );
  }

  @SuppressWarnings( "SameParameterValue" )
  private void emitFactoryType( @Nonnull final String className, @Nonnull final List<Element> elements )
    throws IOException
  {
    final TypeSpec.Builder type =
      TypeSpec
        .classBuilder( className )
        .addModifiers( Modifier.PUBLIC, Modifier.FINAL );

    writeGeneratedAnnotation( type );
    type.addJavadoc( "Element factory that provides convenience wrappers for creating react4j host elements" );

    type.addMethod( MethodSpec.constructorBuilder().addModifiers( Modifier.PRIVATE ).build() );

    for ( final Element element : elements )
    {
      emitElementFactoryMethods( type, element );
    }

    type.addMethod( emitToArray() );

    type.addMethod( emitCreateElement() );

    writeTopLevelType( type );
  }

  private void emitInputTypes( @Nonnull final WebIDLSchema schema, @Nonnull final List<Element> elementSelection )
    throws IOException
  {
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
      // TODO: Add the custom logic for combining multiple classnames here?

      // id is a real "dom" attribute inherited from "Element" WebIDL interface
      type.addMethod( MethodSpec
                        .methodBuilder( "id" )
                        .addAnnotation( Types.JS_OVERLAY )
                        .addAnnotation( Types.NONNULL )
                        .addModifiers( Modifier.PUBLIC, Modifier.FINAL )
                        .addParameter( ParameterSpec
                                         .builder( Types.STRING, "id", Modifier.FINAL )
                                         .addAnnotation( Types.NONNULL )
                                         .build() )
                        .addStatement( "prop( $S, $T.asAny( id ) )", "id", Types.JS )
                        .returns( TypeVariableName.get( "T" ) )
                        .addStatement( "return self()", Types.JS )
                        .build() );
      // className is a real "className" attribute inherited from "Element" WebIDL interface
      type.addMethod( MethodSpec
                        .methodBuilder( "className" )
                        .addAnnotation( Types.JS_OVERLAY )
                        .addAnnotation( Types.NONNULL )
                        .addModifiers( Modifier.PUBLIC, Modifier.FINAL )
                        .addParameter( ParameterSpec
                                         .builder( Types.STRING, "className", Modifier.FINAL )
                                         .addAnnotation( Types.NONNULL )
                                         .build() )
                        .addStatement( "prop( $S, $T.asAny( className ) )", "className", Types.JS )
                        .returns( TypeVariableName.get( "T" ) )
                        .addStatement( "return self()", Types.JS )
                        .build() );
      // key is a synthetic "react" attribute used for identifying vnodes
      type.addMethod( MethodSpec
                        .methodBuilder( "key" )
                        .addAnnotation( Types.JS_OVERLAY )
                        .addAnnotation( Types.NONNULL )
                        .addModifiers( Modifier.PUBLIC, Modifier.FINAL )
                        .addParameter( ParameterSpec
                                         .builder( Types.STRING, "key", Modifier.FINAL )
                                         .addAnnotation( Types.NONNULL )
                                         .build() )
                        .addStatement( "prop( $S, $T.asAny( key ) )", "key", Types.JS )
                        .returns( TypeVariableName.get( "T" ) )
                        .addStatement( "return self()", Types.JS )
                        .build() );
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

    for ( final AttributeMember attribute : selectAttributes( definition ) )
    {
      // TODO: The attribute definitions should map event handlers to react
      //  equivalents and add @MagicConstant for enums
      final String attributeName = safeMethodName( attribute.getName() );
      if ( Kind.Boolean == attribute.getType().getKind() )
      {
        type.addMethod( MethodSpec
                          .methodBuilder( attributeName )
                          .addAnnotation( Types.JS_OVERLAY )
                          .addAnnotation( Types.NONNULL )
                          .addModifiers( Modifier.PUBLIC, Modifier.FINAL )
                          .returns( TypeVariableName.get( "T" ) )
                          .addStatement( "return $N( true )", attributeName )
                          .build() );
      }
      final TypeName paramType = toTypeName( attribute.getType() );
      final ParameterSpec.Builder parameter = ParameterSpec.builder( paramType, attributeName, Modifier.FINAL );
      if ( !paramType.isPrimitive() )
      {
        parameter.addAnnotation( _schema.isNullable( attribute.getType() ) ? Types.NULLABLE : Types.NONNULL );
      }
      addMagicConstantAnnotationIfNeeded( attribute.getType(), parameter );
      type.addMethod( MethodSpec
                        .methodBuilder( attributeName )
                        .addAnnotation( Types.JS_OVERLAY )
                        .addAnnotation( Types.NONNULL )
                        .addModifiers( Modifier.PUBLIC, Modifier.FINAL )
                        .addParameter( parameter.build() )
                        .returns( TypeVariableName.get( "T" ) )
                        .addStatement( "prop( $S, $T.asAny( $N ) )", attributeName, Types.JS, attributeName )
                        .addStatement( "return self()", Types.JS )
                        .build() );
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
      .addModifiers( Modifier.PUBLIC )
      .addParameter( ParameterSpec
                       .builder( ParameterizedTypeName.get( ClassName.get( getPackageName(), "RefCallback" ),
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

    type.addMethod( emitRefSetter( definition ) );

    for ( final AttributeMember attribute : selectAttributes( definition ) )
    {
      // TODO: The attribute definitions should map event handlers to react
      //  equivalents and add @MagicConstant for enums
      final String attributeName = safeMethodName( attribute.getName() );
      if ( Kind.Boolean == attribute.getType().getKind() )
      {
        type.addMethod( MethodSpec
                          .methodBuilder( attributeName )
                          .addAnnotation( Types.JS_OVERLAY )
                          .addAnnotation( Types.NONNULL )
                          .addModifiers( Modifier.PUBLIC, Modifier.FINAL )
                          .returns( self )
                          .addStatement( "return $N( true )", attributeName )
                          .build() );
      }
      final TypeName paramType = toTypeName( attribute.getType() );
      final ParameterSpec.Builder parameter = ParameterSpec.builder( paramType, attributeName, Modifier.FINAL );
      if ( !paramType.isPrimitive() )
      {
        parameter.addAnnotation( _schema.isNullable( attribute.getType() ) ? Types.NULLABLE : Types.NONNULL );
      }
      addMagicConstantAnnotationIfNeeded( attribute.getType(), parameter );
      type.addMethod( MethodSpec
                        .methodBuilder( attributeName )
                        .addAnnotation( Types.JS_OVERLAY )
                        .addAnnotation( Types.NONNULL )
                        .addModifiers( Modifier.PUBLIC, Modifier.FINAL )
                        .addParameter( parameter.build() )
                        .returns( self )
                        .addStatement( "prop( $S, $T.asAny( $N ) )", attributeName, Types.JS, attributeName )
                        .addStatement( "return self()", Types.JS )
                        .build() );
    }

    writeTopLevelType( type );
  }

  @Nonnull
  private List<AttributeMember> selectAttributes( @Nonnull final InterfaceDefinition definition )
  {
    return definition
      .getAttributes()
      .stream()
      .filter( a -> !a.getModifiers().contains( AttributeMember.Modifier.STATIC ) )
      .filter( a -> !a.getModifiers().contains( AttributeMember.Modifier.READ_ONLY ) )
      .collect( Collectors.toList() );
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
        // TODO: Asses downstream apps but it seems like we could probably remove all of these except STRING
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
        return ClassName.get( "elemental3", name );
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
          // TODO: There is a single named union in the HTML API which is MediaProvider. We
          //  could live with including this unnecessary abstraction or copy the logic for
          //  expanding types from jsinterop generator and expand this to it's subtypes ala
          //  MediaStream, MediaSource or Blob. At the moment the extra complexity is unjustified
          return ClassName.get( "elemental3", name );
        }
        else
        {
          return toTypeName( typedef.getType() );
        }
      }
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

  private void addMagicConstantAnnotationIfNeeded( @Nonnull final Type type,
                                                   @Nonnull final ParameterSpec.Builder parameter )
  {
    if ( _enableMagicConstants && Kind.TypeReference == type.getKind() )
    {
      final TypeReference typeReference = (TypeReference) type;
      final EnumerationDefinition enumeration = _schema.findEnumerationByName( typeReference.getName() );
      if ( null != enumeration )
      {
        parameter.addAnnotation( emitMagicConstantAnnotation( enumeration ) );
      }
    }
  }

  @Nonnull
  private AnnotationSpec emitMagicConstantAnnotation( @Nonnull final EnumerationDefinition enumeration )
  {
    final ClassName enumerationType =
      ClassName.get( "elemental3", NamingUtil.uppercaseFirstCharacter( enumeration.getName() ) );
    return AnnotationSpec
      .builder( Types.MAGIC_CONSTANT )
      .addMember( "valuesFromClass", "$T.class", enumerationType )
      .build();
  }
}
