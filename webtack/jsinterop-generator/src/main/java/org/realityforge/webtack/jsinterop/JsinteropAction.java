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
import com.squareup.javapoet.WildcardTypeName;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.lang.model.element.Modifier;
import org.realityforge.webtack.model.Argument;
import org.realityforge.webtack.model.AttributeMember;
import org.realityforge.webtack.model.AttributedNode;
import org.realityforge.webtack.model.CallbackDefinition;
import org.realityforge.webtack.model.CallbackInterfaceDefinition;
import org.realityforge.webtack.model.ConstEnumerationDefinition;
import org.realityforge.webtack.model.ConstEnumerationValue;
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
import org.realityforge.webtack.model.IterableMember;
import org.realityforge.webtack.model.Kind;
import org.realityforge.webtack.model.MapLikeMember;
import org.realityforge.webtack.model.MixinDefinition;
import org.realityforge.webtack.model.Named;
import org.realityforge.webtack.model.NamedDefinition;
import org.realityforge.webtack.model.NamedElement;
import org.realityforge.webtack.model.NamespaceDefinition;
import org.realityforge.webtack.model.OperationMember;
import org.realityforge.webtack.model.OperationMemberContainer;
import org.realityforge.webtack.model.PartialInterfaceDefinition;
import org.realityforge.webtack.model.SequenceType;
import org.realityforge.webtack.model.SetLikeMember;
import org.realityforge.webtack.model.Type;
import org.realityforge.webtack.model.TypeReference;
import org.realityforge.webtack.model.TypedefDefinition;
import org.realityforge.webtack.model.UnionType;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.tools.io.FilesUtil;
import org.realityforge.webtack.model.tools.spi.PipelineContext;
import org.realityforge.webtack.model.tools.util.AbstractJavaAction;
import org.realityforge.webtack.model.tools.util.BasicTypes;
import org.realityforge.webtack.model.tools.util.ExtendedAttributes;
import org.realityforge.webtack.model.tools.util.JsinteropTypes;
import org.realityforge.webtack.model.tools.util.NamingUtil;

final class JsinteropAction
  extends AbstractJavaAction
{
  /**
   * Pattern matcher used to process link annotations.
   */
  @Nonnull
  private final Pattern _linkMatcher = Pattern.compile( "\\{@link ([^ }]*)" );
  @Nonnull
  private final OutputType _outputType;
  @Nonnull
  private final List<String> _gwtInherits;
  private final boolean _generateCompileTest;
  private final boolean _generateTypeMapping;
  private final boolean _generateGlobal;
  @Nonnull
  private final Set<String> _modulesToRequireInCompileTest = new HashSet<>();
  @Nonnull
  private final Set<String> _extraModulesToRequireInCompileTest = new HashSet<>();

  JsinteropAction( @Nonnull final PipelineContext context,
                   @Nonnull final OutputType outputType,
                   @Nonnull final Path outputDirectory,
                   @Nonnull final String packageName,
                   @Nonnull final List<Path> predefinedTypeMappingPaths,
                   @Nonnull final List<Path> externalTypeMappingPaths,
                   @Nonnull final List<Path> extraClosureModulesToRequireInCompileTestPaths,
                   final boolean generateCompileTest,
                   @Nonnull final List<String> gwtInherits,
                   final boolean generateTypeMapping,
                   final boolean generateGlobal,
                   final boolean enableMagicConstants )
  {
    super( context,
           outputDirectory,
           packageName,
           enableMagicConstants,
           predefinedTypeMappingPaths,
           externalTypeMappingPaths );
    _outputType = Objects.requireNonNull( outputType );
    _generateCompileTest = generateCompileTest;
    _gwtInherits = Objects.requireNonNull( gwtInherits );
    _generateTypeMapping = generateTypeMapping;
    _generateGlobal = generateGlobal;
    for ( final Path path : extraClosureModulesToRequireInCompileTestPaths )
    {
      try
      {
        Files
          .readAllLines( path )
          .stream()
          .filter( line -> !line.trim().isEmpty() )
          .forEach( _extraModulesToRequireInCompileTest::add );
      }
      catch ( final IOException ioe )
      {
        throw new IllegalStateException( "Failed to read closure test module list in file " + path, ioe );
      }
    }
  }

  @Override
  protected void processInit( @Nonnull final WebIDLSchema schema )
  {
    _modulesToRequireInCompileTest.clear();
    super.processInit( schema );
  }

  @Override
  public void process( @Nonnull final WebIDLSchema schema )
    throws Exception
  {
    processInit( schema );

    FilesUtil.deleteDirectory( getOutputDirectory() );
    _modulesToRequireInCompileTest.addAll( _extraModulesToRequireInCompileTest );

    registerIdlTypeToJavaTypeMapping();
    registerDefaultTypeMapping();

    for ( final TypedefDefinition definition : schema.getTypedefs() )
    {
      final Type type = definition.getType();
      if ( Kind.Union == type.getKind() && isIdlTypeNotPredefined( definition.getName() ) )
      {
        final UnionType unionType = (UnionType) type;
        if ( isMarkerType( definition ) )
        {
          generateMarkerType( definition );
        }
        else
        {
          generateUnion( definition.getName(),
                         toJsName( definition ),
                         lookupClassName( definition.getName() ).simpleName(),
                         unionType,
                         getAnnotationStream( definition ).collect( Collectors.toList() ) );
        }
      }
    }
    for ( final CallbackDefinition definition : schema.getCallbacks() )
    {
      if ( isIdlTypeNotPredefined( definition.getName() ) )
      {
        generateCallback( definition );
      }
    }
    for ( final CallbackInterfaceDefinition definition : schema.getCallbackInterfaces() )
    {
      if ( isIdlTypeNotPredefined( definition.getName() ) )
      {
        generateCallbackInterface( definition );
      }
    }
    for ( final DictionaryDefinition definition : schema.getDictionaries() )
    {
      if ( isIdlTypeNotPredefined( definition.getName() ) )
      {
        generateDictionary( definition );
      }
    }
    for ( final EnumerationDefinition definition : schema.getEnumerations() )
    {
      if ( isIdlTypeNotPredefined( definition.getName() ) )
      {
        generateEnumeration( definition );
      }
    }
    for ( final ConstEnumerationDefinition definition : schema.getConstEnumerations() )
    {
      if ( isIdlTypeNotPredefined( definition.getName() ) )
      {
        generateConstEnumeration( definition );
      }
    }
    for ( final InterfaceDefinition definition : schema.getInterfaces() )
    {
      if ( isIdlTypeNotPredefined( definition.getName() ) )
      {
        generateInterface( definition );
      }
    }
    for ( final PartialInterfaceDefinition definition : schema.getPartialInterfaces() )
    {
      if ( isIdlTypeNotPredefined( definition.getName() ) )
      {
        generatePartialInterface( definition );
      }
    }
    for ( final NamespaceDefinition definition : schema.getNamespaces() )
    {
      if ( isIdlTypeNotPredefined( definition.getName() ) )
      {
        generateNamespace( definition );
      }
    }

    for ( final Map.Entry<String, UnionType> entry : getUnions().entrySet() )
    {
      final String name = entry.getKey();
      if ( isIdlTypeNotPredefined( name ) )
      {
        generateUnion( name,
                       name,
                       NamingUtil.uppercaseFirstCharacter( name ),
                       entry.getValue(),
                       Collections.emptyList() );
      }
    }

    if ( OutputType.gwt == _outputType )
    {
      writeGwtModule();
    }

    for ( final String globalInterface : getGlobalInterfaces().keySet() )
    {
      generateGlobalType( globalInterface );
    }
    if ( _generateGlobal )
    {
      generateGlobalType();
    }

    if ( _generateCompileTest && OutputType.j2cl == _outputType )
    {
      writeJ2clCompileTest();
    }
    if ( _generateTypeMapping )
    {
      writeTypeMappingFile();
    }
  }

  private void generateConstEnumeration( @Nonnull final ConstEnumerationDefinition definition )
    throws IOException
  {
    final String name = definition.getName();
    final ClassName self = lookupClassName( name );
    final String simpleName = self.simpleName();
    final TypeSpec.Builder type =
      TypeSpec
        .annotationBuilder( simpleName )
        .addModifiers( Modifier.PUBLIC );
    writeGeneratedAnnotation( type );
    type.addAnnotation( Documented.class );

    final WebIDLSchema schema = getSchema();

    final ConstEnumerationValue firstValue = definition.getValues().get( 0 );
    final ConstMember constant = getSchema().getConstant( firstValue );
    final boolean isInteger = schema.resolveType( constant.getType() ).getKind().isInteger();
    final boolean isFlags = isInteger && definition.isNoArgsExtendedAttributePresent( ExtendedAttributes.FLAGS );

    final AnnotationSpec.Builder annotation = AnnotationSpec.builder( BasicTypes.MAGIC_CONSTANT );
    final List<ConstEnumerationValue> sortedConstants =
      definition
        .getValues()
        .stream()
        .sorted( ( o1, o2 ) -> sortByValue( isInteger, o1, o2 ) )
        .collect( Collectors.toList() );
    for ( final ConstEnumerationValue value : sortedConstants )
    {
      annotation.addMember( isFlags ? "flags" : isInteger ? "intValues" : "stringValues",
                            "$T.$N",
                            lookupClassName( value.getInterfaceName() ),
                            value.getConstName() );
    }
    type.addAnnotation( annotation.build() );

    final TypeName enumType = toTypeName( constant.getType() );

    final List<Object> params = new ArrayList<>();
    final List<String> descriptions = new ArrayList<>();
    final List<Object> describeParams = new ArrayList<>();
    final List<String> describeBlocks = new ArrayList<>();
    final String test =
      definition
        .getValues()
        .stream()
        .peek( v -> params.add( lookupClassName( v.getInterfaceName() ) ) )
        .peek( v -> params.add( v.getConstName() ) )
        .peek( v -> descriptions.add( "$T.$N" ) )
        .peek( v -> describeParams.add( lookupClassName( v.getInterfaceName() ) ) )
        .peek( v -> describeParams.add( v.getConstName() ) )
        .peek( v -> describeParams.add( v.getConstName() ) )
        .peek( v -> describeBlocks.add( isInteger ? "$T.$N == value ? $S : " : "$T.$N.equals( value ) ? $S : " ) )
        .map( v -> isInteger ? "$T.$N == value" : "$T.$N.equals( value )" )
        .collect( Collectors.joining( " || " ) );

    final ParameterSpec.Builder parameter = ParameterSpec.builder( enumType, "value", Modifier.FINAL );
    if ( !isInteger )
    {
      parameter.addAnnotation( BasicTypes.NONNULL );
    }

    final MethodSpec.Builder requireValidMethod =
      MethodSpec
        .methodBuilder( "requireValid" )
        .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
        .addAnnotation( self )
        .addParameter( parameter.build() )
        .addStatement( "assertValid( value )" )
        .addStatement( "return value" )
        .returns( enumType );
    if ( !isInteger )
    {
      requireValidMethod.addAnnotation( BasicTypes.NONNULL );
    }
    type.addType( TypeSpec
                    .classBuilder( "Util" )
                    .addModifiers( Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL )
                    .addMethod( MethodSpec.constructorBuilder().addModifiers( Modifier.PRIVATE ).build() )
                    .addMethod( requireValidMethod.build() )
                    .addMethod( MethodSpec
                                  .methodBuilder( "assertValid" )
                                  .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                                  .addParameter( parameter.build() )
                                  .addStatement( "assert isValid( value ) : \"@" + simpleName +
                                                 " annotated value must be one of [" +
                                                 String.join( ", ", descriptions ) +
                                                 "] but is \" + value",
                                                 params.toArray() )
                                  .build() )
                    .addMethod( MethodSpec
                                  .methodBuilder( "isValid" )
                                  .returns( TypeName.BOOLEAN )
                                  .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                                  .addParameter( parameter.build() )
                                  .addStatement( "return " + test, params.toArray() )
                                  .build() )
                    .addMethod( MethodSpec
                                  .methodBuilder( "describe" )
                                  .addAnnotation( BasicTypes.NONNULL )
                                  .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                                  .returns( BasicTypes.STRING )
                                  .addParameter( parameter.build() )
                                  .addStatement( "return " + String.join( "", describeBlocks ) +
                                                 "\"Unknown value \" + value", describeParams.toArray() )
                                  .build() )
                    .build() );

    writeTopLevelType( name, type );
  }

  private int sortByValue( final boolean isInteger,
                           @Nonnull final ConstEnumerationValue o1,
                           @Nonnull final ConstEnumerationValue o2 )
  {
    final ConstMember c1 = getSchema().getConstant( o1 );
    final ConstMember c2 = getSchema().getConstant( o2 );
    final String v1 = c1.getValue().getValue();
    final String v2 = c2.getValue().getValue();
    assert null != v1;
    assert null != v2;
    final int value =
      isInteger ?
      Integer.compare( parseNumericConstantValue( v1 ), parseNumericConstantValue( v2 ) ) :
      v1.compareTo( v2 );
    return 0 == value ?
           ( o1.getInterfaceName() + o1.getConstName() ).compareTo( o2.getInterfaceName() + o2.getConstName() ) :
           value;
  }

  private int parseNumericConstantValue( @Nonnull final String value )
  {
    final boolean isHex = value.startsWith( "0x" );
    return Integer.parseInt( isHex ? value.substring( 2 ) : value, isHex ? 16 : 10 );
  }

  private void writeTypeMappingFile()
    throws IOException
  {
    final String typeMappingContent =
      getIdlToClassNameMapping()
        .entrySet()
        .stream()
        .filter( e -> isIdlTypeNotPredefined( e.getKey() ) )
        .map( e -> e.getKey() + "=" + e.getValue() )
        .sorted()
        .collect( Collectors.joining( "\n" ) ) + "\n";
    final String name = NamingUtil.uppercaseFirstCharacter( getLeafPackageName() );
    writeResourceFile( getMainResourcesDirectory(),
                       name + ".mapping",
                       typeMappingContent.getBytes( StandardCharsets.UTF_8 ) );
  }

  private void writeJ2clCompileTest()
    throws IOException
  {
    final String name = NamingUtil.uppercaseFirstCharacter( getLeafPackageName() );
    final String content =
      "goog.module('" + getPackageName() + "." + name + "CompileTest');\n" +
      _modulesToRequireInCompileTest
        .stream()
        .map( v -> "goog.require('" + v + "');" )
        .sorted()
        .collect( Collectors.joining( "\n" ) ) + "\n";

    writeResourceFile( getOutputDirectory().resolve( "test" ).resolve( "js" ),
                       name + ".CompileTest.js",
                       content.getBytes( StandardCharsets.UTF_8 ) );
  }

  private void generateGlobalType()
    throws IOException
  {
    final WebIDLSchema schema = getSchema();
    final List<MixinDefinition> globalMixins = getGlobalMixins( schema );
    if ( !globalMixins.isEmpty() )
    {
      final String idlName = "$Global";
      final ClassName className = lookupClassName( idlName );
      final String javaName = className.simpleName();
      final TypeSpec.Builder type =
        TypeSpec
          .classBuilder( javaName )
          .addModifiers( Modifier.PUBLIC, Modifier.FINAL );
      writeGeneratedAnnotation( type );
      type.addAnnotation( getGlobalAnnotation() );
      type.addMethod( MethodSpec.constructorBuilder().addModifiers( Modifier.PRIVATE ).build() );

      final String testJavaName = javaName + "TestCompile";
      final TypeSpec.Builder testType =
        TypeSpec
          .classBuilder( testJavaName )
          .addModifiers( Modifier.PUBLIC, Modifier.FINAL );
      writeGeneratedAnnotation( testType );

      for ( final MixinDefinition mixin : globalMixins )
      {
        generateConstants( toJsName( mixin ), mixin.getConstants(), type );
        generateStaticAttributes( mixin, mixin.getAttributes(), className, type, testType );
        generateStaticOperations( mixin, mixin.getOperations(), className, type, testType );
        generateStaticEventsMethods( type, schema, mixin.getEvents() );
      }

      _modulesToRequireInCompileTest.add( className.canonicalName() + ".$Overlay" );
      writeTopLevelType( idlName, type );

      if ( _generateCompileTest )
      {
        emitJavaType( getTestJavaDirectory(),
                      testType.build(),
                      ClassName.get( className.packageName(), testJavaName ).toString() );

        _modulesToRequireInCompileTest.add( className.canonicalName() + "TestCompile" );
      }
    }
  }

  @Nonnull
  private AnnotationSpec getGlobalAnnotation()
  {
    final AnnotationSpec.Builder annotation =
      AnnotationSpec
        .builder( JsinteropTypes.JS_TYPE )
        .addMember( "isNative", "true" );

    if ( OutputType.gwt == _outputType )
    {
      annotation
        .addMember( "namespace", "$S", "<window>" )
        .addMember( "name", "$S", "$wnd" );
    }
    else
    {
      annotation
        .addMember( "namespace", "$T.GLOBAL", JsinteropTypes.JS_PACKAGE )
        .addMember( "name", "$S", "goog.global" );
    }
    return annotation.build();
  }

  private void generateGlobalType( @Nonnull final String globalInterface )
    throws IOException
  {
    final String idlName = "$Global" + globalInterface;
    final ClassName className = lookupClassName( idlName );
    final String javaName = className.simpleName();
    final TypeSpec.Builder type =
      TypeSpec
        .classBuilder( javaName )
        .addModifiers( Modifier.PUBLIC, Modifier.FINAL );
    writeGeneratedAnnotation( type );
    type.addAnnotation( getGlobalAnnotation() );

    final String testJavaName = javaName + "TestCompile";
    final TypeSpec.Builder testType =
      TypeSpec
        .classBuilder( testJavaName )
        .addModifiers( Modifier.PUBLIC, Modifier.FINAL );
    writeGeneratedAnnotation( testType );

    type.addMethod( MethodSpec.constructorBuilder().addModifiers( Modifier.PRIVATE ).build() );

    final WebIDLSchema schema = getSchema();
    InterfaceDefinition definition = schema.getInterfaceByName( globalInterface );
    maybeAddJavadoc( definition, type );
    while ( null != definition )
    {
      generateStaticAttributes( definition, definition.getAttributes(), className, type, testType );
      generateStaticOperations( definition, definition.getOperations(), className, type, testType );
      generateStaticEventsMethods( type, schema, definition.getEvents() );
      definition = definition.getSuperInterface();
    }

    _modulesToRequireInCompileTest.add( className.canonicalName() + ".$Overlay" );
    writeTopLevelType( idlName, type );

    if ( _generateCompileTest )
    {
      emitJavaType( getTestJavaDirectory(),
                    testType.build(),
                    ClassName.get( className.packageName(), testJavaName ).toString() );

      _modulesToRequireInCompileTest.add( className.canonicalName() + "TestCompile" );
    }
  }

  private void generateStaticEventsMethods( @Nonnull final TypeSpec.Builder type,
                                            @Nonnull final WebIDLSchema schema,
                                            @Nonnull final List<EventMember> events )
  {
    for ( final EventMember event : events )
    {
      final CallbackInterfaceDefinition callbackInterface =
        schema.findCallbackInterfaceByName( event.getEventType().getName() + "Listener" );
      if ( null != callbackInterface )
      {
        generateStaticAddEventListener( event, 0, type );
        generateStaticAddEventListener( event, 1, type );
        generateStaticAddEventListener( event, 2, type );
        generateStaticRemoveEventListener( event, 0, type );
        generateStaticRemoveEventListener( event, 1, type );
        generateStaticRemoveEventListener( event, 2, type );
      }
    }
  }

  private void generateStaticAttributes( @Nonnull final NamedDefinition definition,
                                         @Nonnull final List<AttributeMember> attributes,
                                         @Nonnull final ClassName className,
                                         @Nonnull final TypeSpec.Builder type,
                                         @Nonnull final TypeSpec.Builder testType )
  {
    attributes
      .stream()
      .sorted( Comparator.comparing( NamedElement::getName ) )
      .forEach( attribute -> generateStaticAttribute( definition, attribute, className, type, testType ) );
  }

  private void generateStaticAttribute( @Nonnull final NamedDefinition definition,
                                        @Nonnull final AttributeMember attribute,
                                        @Nonnull final ClassName className,
                                        @Nonnull final TypeSpec.Builder type,
                                        @Nonnull final TypeSpec.Builder testType )
  {
    if ( attribute.getModifiers().contains( AttributeMember.Modifier.READ_ONLY ) )
    {
      generateStaticReadOnlyAttribute( definition, attribute, className, type, testType );
    }
    else
    {
      generateStaticReadWriteAttribute( attribute, className, type, testType );
    }
  }

  private void generateStaticReadOnlyAttribute( @Nonnull final NamedDefinition definition,
                                                @Nonnull final AttributeMember attribute,
                                                @Nonnull final ClassName className,
                                                @Nonnull final TypeSpec.Builder type,
                                                @Nonnull final TypeSpec.Builder testType )
  {
    assert attribute.getModifiers().contains( AttributeMember.Modifier.READ_ONLY );
    if ( attribute.isNoArgsExtendedAttributePresent( ExtendedAttributes.OPTIONAL_SUPPORT ) ||
         null != attribute.getIdentValue( ExtendedAttributes.OPTIONAL_SUPPORT ) )
    {
      if ( attribute.getModifiers().contains( AttributeMember.Modifier.STATIC ) )
      {
        // Static attributes should not have OptionalSupport extended attribute and thus the only way we can get
        // to this method is instance attributes promoted to static attributes as they appear on a GlobalObject
        throw new UnsupportedOperationException( "Optional attribute guards not supported on static attributes" );
      }
      generateStaticOptionalSupportGuard( definition, attribute, attribute.getName(), className, type, testType );
    }

    final Type attributeType = attribute.getType();
    final WebIDLSchema schema = getSchema();
    final Type actualType = schema.resolveType( attributeType );
    final String name = attribute.getName();
    final TypeName actualJavaType = toTypeName( actualType );
    final String javaName = safeJsPropertyMethodName( name, TypeName.BOOLEAN.equals( actualJavaType ) );
    final MethodSpec.Builder method =
      MethodSpec
        .methodBuilder( javaName )
        .addModifiers( Modifier.PUBLIC, Modifier.STATIC, Modifier.NATIVE )
        .returns( actualJavaType )
        .addAnnotation( AnnotationSpec
                          .builder( JsinteropTypes.JS_PROPERTY )
                          .addMember( "name", "$S", toJsName( attribute ) )
                          .build() );
    maybeAddCustomAnnotations( attribute, method );
    maybeAddJavadoc( attribute, method );
    if ( schema.isNullable( attributeType ) )
    {
      method.addAnnotation( JsinteropTypes.JS_NULLABLE );
    }
    else if ( !actualJavaType.isPrimitive() )
    {
      method.addAnnotation( JsinteropTypes.JS_NONNULL );
    }
    addMagicConstantAnnotationIfNeeded( actualType, method );
    type.addMethod( method.build() );

    final MethodSpec.Builder testMethod =
      MethodSpec
        .methodBuilder( javaName )
        .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
        .returns( actualJavaType )
        .addStatement( "return $T.$N()", className, javaName );
    final DocumentationElement documentation = attribute.getDocumentation();
    if ( null != documentation && documentation.hasDeprecatedTag() )
    {
      testMethod.addAnnotation( Deprecated.class );
    }
    testType.addMethod( testMethod.build() );
  }

  private void generateStaticReadWriteAttribute( @Nonnull final AttributeMember attribute,
                                                 @Nonnull final ClassName className,
                                                 @Nonnull final TypeSpec.Builder type,
                                                 @Nonnull final TypeSpec.Builder testType )
  {
    assert !attribute.getModifiers().contains( AttributeMember.Modifier.READ_ONLY );
    final Type attributeType = attribute.getType();
    final WebIDLSchema schema = getSchema();
    final Type actualType = schema.resolveType( attributeType );
    final String fieldName = javaName( attribute );
    final TypeName actualJavaType = toTypeName( actualType );
    final FieldSpec.Builder field =
      FieldSpec.builder( actualJavaType, fieldName, Modifier.PUBLIC, Modifier.STATIC );
    maybeAddCustomAnnotations( attribute, field );
    maybeAddJavadoc( attribute, field );
    final String jsName = toJsName( attribute );
    if ( !fieldName.equals( jsName ) )
    {
      field.addAnnotation( AnnotationSpec.builder( JsinteropTypes.JS_PROPERTY )
                             .addMember( "name", "$S", jsName )
                             .build() );
    }
    if ( schema.isNullable( attributeType ) )
    {
      field.addAnnotation( JsinteropTypes.JS_NULLABLE );
    }
    else if ( !actualType.getKind().isPrimitive() )
    {
      field.addAnnotation( JsinteropTypes.JS_NONNULL );
    }
    addMagicConstantAnnotationIfNeeded( actualType, field );
    type.addField( field.build() );

    final MethodSpec.Builder testReadMethod =
      MethodSpec
        .methodBuilder( fieldName )
        .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
        .returns( actualJavaType )
        .addStatement( "return $T.$N", className, fieldName );
    final MethodSpec.Builder testWriteMethod =
      MethodSpec
        .methodBuilder( fieldName )
        .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
        .addStatement( "$T.$N = value", className, fieldName )
        .addParameter( ParameterSpec.builder( actualJavaType, "value", Modifier.FINAL ).build() );

    final DocumentationElement documentation = attribute.getDocumentation();
    if ( null != documentation && documentation.hasDeprecatedTag() )
    {
      testReadMethod.addAnnotation( Deprecated.class );
      testWriteMethod.addAnnotation( Deprecated.class );
    }
    testType.addMethod( testReadMethod.build() );
    testType.addMethod( testWriteMethod.build() );
  }

  private void generateStaticAddEventListener( @Nonnull final EventMember event,
                                               final int variant,
                                               @Nonnull final TypeSpec.Builder type )
  {
    final String eventName = event.getName();
    final TypeName listenerType = lookupClassName( event.getEventType().getName() + "Listener" );
    final String methodName = "add" + NamingUtil.uppercaseFirstCharacter( eventName ) + "Listener";
    final MethodSpec.Builder method =
      MethodSpec
        .methodBuilder( methodName )
        .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
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
                         .builder( TypeName.BOOLEAN, "useCapture", Modifier.FINAL )
                         .build() )
        .addStatement( "addEventListener( $S, $T.cast( callback ), useCapture )", eventName, JsinteropTypes.JS );
    }
    else
    {
      assert 2 == variant;
      method.addStatement( "addEventListener( $S, $T.cast( callback ) )", eventName, JsinteropTypes.JS );
    }

    type.addMethod( method.build() );
  }

  private void generateStaticRemoveEventListener( @Nonnull final EventMember event,
                                                  final int variant,
                                                  @Nonnull final TypeSpec.Builder type )
  {
    final String eventName = event.getName();
    final TypeName listenerType = lookupClassName( event.getEventType().getName() + "Listener" );
    final String methodName = "remove" + NamingUtil.uppercaseFirstCharacter( eventName ) + "Listener";
    final MethodSpec.Builder method =
      MethodSpec
        .methodBuilder( methodName )
        .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
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
                         .builder( TypeName.BOOLEAN, "useCapture", Modifier.FINAL )
                         .build() )
        .addStatement( "removeEventListener( $S, $T.cast( callback ), useCapture )", eventName, JsinteropTypes.JS );
    }
    else
    {
      assert 2 == variant;
      method.addStatement( "removeEventListener( $S, $T.cast( callback ) )", eventName, JsinteropTypes.JS );
    }

    type.addMethod( method.build() );
  }

  @Nonnull
  private List<MixinDefinition> getGlobalMixins( @Nonnull final WebIDLSchema schema )
  {
    return schema
      .getMixins()
      .stream()
      .filter( m -> m.isNoArgsExtendedAttributePresent( ExtendedAttributes.GLOBAL_OBJECT ) )
      .collect( Collectors.toList() );
  }

  private void writeGwtModule()
    throws IOException
  {
    final StringBuilder sb = new StringBuilder();
    sb.append( "<module>\n" );
    sb.append( "  <inherits name='jsinterop.base.Base'/>\n" );
    for ( final String gwtInherit : _gwtInherits )
    {
      sb.append( "  <inherits name='" ).append( gwtInherit ).append( "'/>\n" );
    }
    for ( final InterfaceDefinition definition : getSchema().getInterfaces() )
    {
      for ( final AttributeMember attribute : definition.getAttributes() )
      {
        emitOptionalSupportConfig( sb, definition, attribute.getName(), attribute );
      }
      for ( final OperationMember operation : definition.getOperations() )
      {
        final String operationName = operation.getName();
        if ( null != operationName )
        {
          emitOptionalSupportConfig( sb, definition, operationName, operation );
        }
      }
    }
    for ( final PartialInterfaceDefinition definition : getSchema().getPartialInterfaces() )
    {
      for ( final AttributeMember attribute : definition.getAttributes() )
      {
        emitOptionalSupportConfig( sb, definition, attribute.getName(), attribute );
      }
      for ( final OperationMember operation : definition.getOperations() )
      {
        final String operationName = operation.getName();
        if ( null != operationName )
        {
          emitOptionalSupportConfig( sb, definition, operationName, operation );
        }
      }
    }

    sb.append( "\n" );
    sb.append( "  <source path=''/>\n" );
    sb.append( "</module>\n" );
    final String gwtModuleContent = sb.toString();
    final String name = NamingUtil.uppercaseFirstCharacter( getLeafPackageName() );
    writeResourceFile( getMainJavaDirectory(), name + ".gwt.xml", gwtModuleContent.getBytes( StandardCharsets.UTF_8 ) );
  }

  private void emitOptionalSupportConfig( @Nonnull final StringBuilder sb,
                                          @Nonnull final Named definition,
                                          @Nonnull final String elementName,
                                          @Nonnull final AttributedNode element )
  {
    if ( element.isNoArgsExtendedAttributePresent( ExtendedAttributes.OPTIONAL_SUPPORT ) ||
         null != element.getIdentValue( ExtendedAttributes.OPTIONAL_SUPPORT ) )
    {
      final String name = deriveOptionalSupportCompileConstant( definition, elementName, element );
      sb.append( "\n" );
      sb.append( "  <!-- Configuration to control whether the code will assume the " )
        .append( definition.getName() ).append( "." ).append( elementName )
        .append( " feature is present, absent or will perform runtime detection -->\n" );
      sb.append( "  <define-property name='" ).append( name ).append( "' values='true,false,detect'/>\n" );
      sb.append( "  <set-property name='" ).append( name ).append( "' value='detect'/>\n" );
    }
  }

  private void generateUnion( @Nonnull final String idlName,
                              @Nonnull final String jsName,
                              @Nonnull final String javaName,
                              @Nonnull final UnionType unionType,
                              @Nonnull final Collection<ClassName> additionalAnnotations )
    throws IOException
  {
    final String qualifiedName = getQualifiedName( idlName, javaName );
    assert null != qualifiedName;
    final ClassName className = ClassName.bestGuess( qualifiedName );
    final TypeSpec.Builder type =
      TypeSpec
        .interfaceBuilder( javaName )
        .addModifiers( Modifier.PUBLIC );
    writeGeneratedAnnotation( type );
    type.addAnnotation( AnnotationSpec
                          .builder( JsinteropTypes.JS_TYPE )
                          .addMember( "isNative", "true" )
                          .addMember( "namespace", "$T.GLOBAL", JsinteropTypes.JS_PACKAGE )
                          .addMember( "name", "$S", OutputType.gwt == _outputType ? "?" : jsName )
                          .build() );

    final String testJavaName = javaName + "TestCompile";
    final String qualifiedTestName = qualifiedName + "TestCompile";
    final TypeSpec.Builder testType =
      TypeSpec
        .classBuilder( testJavaName )
        .addModifiers( Modifier.PUBLIC, Modifier.FINAL );
    writeGeneratedAnnotation( testType );

    additionalAnnotations.forEach( type::addAnnotation );

    generateUnionOfMethods( idlName, unionType, type, testType );

    final List<Type> types =
      toComponentTypes( unionType )
        .stream()
        .sorted( Comparator.comparing( this::toUnionComponentKey ) )
        .collect( Collectors.toList() );

    for ( final Type componentType : types )
    {
      final TypeName javaType = toTypeName( componentType );
      final String key = toUnionComponentKey( componentType );
      final Kind kind = componentType.getKind();
      final String isMethodName = "is" + key;
      final MethodSpec.Builder isMethod =
        MethodSpec
          .methodBuilder( isMethodName )
          .addAnnotation( JsinteropTypes.JS_OVERLAY )
          .addModifiers( Modifier.PUBLIC, Modifier.DEFAULT )
          .returns( TypeName.BOOLEAN );
      if ( Kind.Void == kind )
      {
        isMethod.addStatement( "return $T.isTripleEqual( $T.undefined(), this )",
                               JsinteropTypes.JS,
                               JsinteropTypes.JS );
      }
      else if ( Kind.TypeReference == kind )
      {
        final TypeReference typeReference = (TypeReference) componentType;
        final DictionaryDefinition dictionary = getSchema().findDictionaryByName( typeReference.getName() );
        if ( null == dictionary )
        {
          isMethod.addStatement( "return ( ($T) this ) instanceof $T",
                                 TypeName.OBJECT,
                                 toTypeName( componentType, true ) );
        }
        else
        {
          isMethod.addStatement( "return ( ($T) this ) instanceof $T",
                                 TypeName.OBJECT,
                                 lookupClassName( Kind.Object.name() ) );
        }
      }
      else if ( kind.isPrimitive() || kind.isString() )
      {
        isMethod.addStatement( "return ( ($T) this ) instanceof $T",
                               TypeName.OBJECT,
                               toTypeName( componentType, true ) );
      }
      else if ( Kind.Sequence == kind )
      {
        isMethod.addStatement( "return ( ($T) this ) instanceof $T",
                               TypeName.OBJECT,
                               lookupClassName( Kind.Sequence.name() ) );
      }
      else if ( Kind.Object == kind || Kind.Record == kind )
      {
        isMethod.addStatement( "return ( ($T) this ) instanceof $T",
                               TypeName.OBJECT,
                               lookupClassName( Kind.Object.name() ) );
      }
      else
      {
        throw new UnsupportedOperationException( "Union contains member type of " + kind +
                                                 " which is not currently supported" );
      }
      type.addMethod( isMethod.build() );
      testType.addMethod( MethodSpec
                            .methodBuilder( isMethodName )
                            .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                            .returns( TypeName.BOOLEAN )
                            .addParameter( ParameterSpec.builder( className, "$instance", Modifier.FINAL ).build() )
                            .addStatement( "return $N.$N()", "$instance", isMethodName )
                            .build() );
      if ( Kind.Void != kind )
      {
        final String asMethodName = "as" + key;
        final MethodSpec.Builder asMethod =
          MethodSpec
            .methodBuilder( asMethodName )
            .addAnnotation( JsinteropTypes.JS_OVERLAY )
            .addModifiers( Modifier.PUBLIC, Modifier.DEFAULT )
            .returns( javaType );

        addMagicConstantAnnotationIfNeeded( componentType, asMethod );

        asMethod.addStatement( "return $T.$N( this )", JsinteropTypes.JS, getJsAccessor( javaType ) );
        type.addMethod( asMethod.build() );
        testType.addMethod( MethodSpec
                              .methodBuilder( asMethodName )
                              .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                              .returns( javaType )
                              .addParameter( ParameterSpec.builder( className, "$instance", Modifier.FINAL ).build() )
                              .addStatement( "return $N.$N()", "$instance", asMethodName )
                              .build() );
      }
    }

    writeTopLevelType( idlName, type );

    if ( _generateCompileTest )
    {
      emitJavaType( getTestJavaDirectory(), testType.build(), qualifiedTestName );
      _modulesToRequireInCompileTest.add( qualifiedTestName );
    }
  }

  @Nonnull
  private String toUnionComponentKey( @Nonnull final Type type )
  {
    final Kind kind = type.getKind();
    return Kind.TypeReference == kind ?
           NamingUtil.uppercaseFirstCharacter( ( (TypeReference) type ).getName() ) :
           kind.isString() ? "String" :
           kind.isPrimitive() ? NamingUtil.uppercaseFirstCharacter( toTypeName( type ).unbox().toString() ) :
           Kind.Sequence == kind ? "Array" :
           Kind.Object == kind ? "Object" :
           Kind.Record == kind ? "PropertyMap" :
           kind.name();
  }

  @Nonnull
  private Set<Type> toComponentTypes( @Nonnull final UnionType unionType )
  {
    final Set<Type> results = new HashSet<>();
    collectComponentTypes( results, unionType );
    return results;
  }

  private void collectComponentTypes( @Nonnull final Set<Type> results, @Nonnull final Type type )
  {
    if ( Kind.Union == type.getKind() )
    {
      for ( final Type memberType : ( (UnionType) type ).getMemberTypes() )
      {
        collectComponentTypes( results, memberType );
      }
    }
    else if ( Kind.TypeReference == type.getKind() )
    {
      final String name = ( (TypeReference) type ).getName();
      final WebIDLSchema schema = getSchema();
      final TypedefDefinition typedef = schema.findTypedefByName( name );
      if ( null != typedef )
      {
        collectComponentTypes( results, typedef.getType() );
      }
      else
      {
        results.add( type );
      }
    }
    else
    {
      results.add( type );
    }
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
          if ( !isMarkerType( typedef ) )
          {
            explodeType( declaredType, resolvedType, values );
          }
        }
        else
        {
          explodeType( declaredType, resolvedType, values );
        }
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
    else if ( Kind.Any == kind )
    {
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
      final boolean nullable = getSchema().isNullable( type );
      final TypedValue.Nullability nullability =
        nullable ? TypedValue.Nullability.NULLABLE : TypedValue.Nullability.NONNULL;
      values.add( new TypedValue( declaredType, type, toSequenceType( (SequenceType) type ), nullability, false ) );
      if ( null == type.getIdentValue( ExtendedAttributes.SEQUENCE_TYPE ) )
      {
        final TypeName arrayJavaType = asArrayType( getUnexpandedType( ( (SequenceType) type ).getItemType() ) );
        values.add( new TypedValue( declaredType, type, arrayJavaType, nullability, false ) );
      }
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

  private boolean isMarkerType( @Nonnull final Definition definition )
  {
    return definition.isNoArgsExtendedAttributePresent( ExtendedAttributes.MARKER_TYPE );
  }

  private void generateUnionOfMethods( @Nonnull final String idlName,
                                       @Nonnull final UnionType unionType,
                                       @Nonnull final TypeSpec.Builder type,
                                       @Nonnull final TypeSpec.Builder testType )
  {
    final TypeName self = lookupClassName( idlName );
    final List<Type> memberTypes = unionType.getMemberTypes();
    for ( final Type memberType : memberTypes )
    {
      if ( Kind.Void == memberType.getKind() )
      {
        type.addMethod( MethodSpec
                          .methodBuilder( "of" )
                          .addAnnotation( JsinteropTypes.JS_OVERLAY )
                          .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                          .addStatement( "return $T.cast( $T.undefined() )", JsinteropTypes.JS, JsinteropTypes.JS )
                          .returns( self )
                          .build() );
        testType.addMethod( MethodSpec
                              .methodBuilder( "of" )
                              .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                              .returns( self )
                              .addStatement( "return $T.$N()", self, "of" )
                              .build() );
      }
      else
      {
        for ( final TypedValue typedValue : explodeType( memberType ) )
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
                            .returns( self )
                            .build() );
          final ParameterSpec.Builder testParameter =
            ParameterSpec.builder( typedValue.getJavaType(), "value", Modifier.FINAL );

          addMagicConstantAnnotationIfNeeded( typedValue.getType(), testParameter );

          testType.addMethod( MethodSpec
                                .methodBuilder( "of" )
                                .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                                .returns( self )
                                .addParameter( ParameterSpec.builder( self, "$instance", Modifier.FINAL ).build() )
                                .addParameter( testParameter.build() )
                                .addStatement( "return $T.$N( $N )", self, "of", "value" )
                                .build() );
        }
      }
    }
  }

  private void generateDictionaryBuilder( @Nonnull final DictionaryDefinition definition,
                                          @Nonnull final TypeSpec.Builder container )
  {
    final TypeSpec.Builder type =
      TypeSpec
        .interfaceBuilder( "Builder" )
        .addModifiers( Modifier.PUBLIC, Modifier.STATIC );
    writeGeneratedAnnotation( type );
    type.addAnnotation( AnnotationSpec
                          .builder( JsinteropTypes.JS_TYPE )
                          .addMember( "isNative", "true" )
                          .addMember( "namespace", "$T.GLOBAL", JsinteropTypes.JS_PACKAGE )
                          .addMember( "name", "$S", OutputType.gwt == _outputType ? "Object" : toJsName( definition ) )
                          .build() );
    maybeAddCustomAnnotations( definition, type );
    maybeAddJavadoc( definition, type );

    type.addSuperinterface( lookupClassName( definition.getName() ) );

    for ( final DictionaryMember member : definition.getMembers() )
    {
      for ( final TypedValue typedValue : explodeType( member.getType() ) )
      {
        generateDictionaryMemberSetterReturningThis( definition, member, typedValue, type );
      }
    }
    DictionaryDefinition parent = definition.getSuperDictionary();
    while ( null != parent )
    {
      for ( final DictionaryMember member : parent.getMembers() )
      {
        for ( final TypedValue memberType : explodeType( member.getType() ) )
        {
          generateDictionaryMemberSetterReturningThis( definition, member, memberType, type );
        }
      }
      parent = parent.getSuperDictionary();
    }

    container.addType( type.build() );
  }

  private void generateDictionary( @Nonnull final DictionaryDefinition definition )
    throws IOException
  {
    final TypeSpec.Builder type =
      TypeSpec
        .interfaceBuilder( lookupClassName( definition.getName() ).simpleName() )
        .addModifiers( Modifier.PUBLIC );
    writeGeneratedAnnotation( type );
    type.addAnnotation( AnnotationSpec.builder( JsinteropTypes.JS_TYPE )
                          .addMember( "isNative", "true" )
                          .addMember( "namespace", "$T.GLOBAL", JsinteropTypes.JS_PACKAGE )
                          .addMember( "name", "$S", OutputType.gwt == _outputType ? "Object" : toJsName( definition ) )
                          .build() );
    maybeAddCustomAnnotations( definition, type );
    maybeAddJavadoc( definition, type );

    final String inherits = definition.getInherits();
    if ( null != inherits )
    {
      type.addSuperinterface( lookupClassName( inherits ) );
    }

    for ( final TypedefDefinition markerType : definition.getMarkerTypes() )
    {
      type.addSuperinterface( lookupClassName( markerType.getName() ) );
    }

    final List<DictionaryMember> requiredMembers = getRequiredDictionaryMembers( definition );
    final List<List<TypedValue>> explodedTypeList =
      explodeTypeList( requiredMembers.stream().map( DictionaryMember::getType ).collect( Collectors.toList() ) );
    for ( final List<TypedValue> argTypes : explodedTypeList )
    {
      generateDictionaryCreateMethod( definition, requiredMembers, argTypes, type );
    }

    final WebIDLSchema schema = getSchema();
    for ( final DictionaryMember member : definition.getMembers() )
    {
      final Type actualType = schema.resolveType( member.getType() );
      final TypeName javaType = toTypeName( actualType );

      generateDictionaryMemberGetter( member, actualType, javaType, type );
      generateDictionaryMemberSetter( member, actualType, javaType, type );
      for ( final TypedValue typedValue : explodeType( member.getType() ) )
      {
        if ( Kind.Any != actualType.getKind() && !javaType.equals( typedValue.getJavaType() ) )
        {
          generateDictionaryMemberOverlaySetter( member, typedValue, type );
        }
      }
    }
    generateDictionaryBuilder( definition, type );

    writeTopLevelType( definition.getName(), type );
  }

  private void generateDictionaryCreateMethod( @Nonnull final DictionaryDefinition dictionary,
                                               @Nonnull final List<DictionaryMember> requiredMembers,
                                               @Nonnull final List<TypedValue> types,
                                               @Nonnull final TypeSpec.Builder type )
  {
    final ClassName self = lookupClassName( dictionary.getName() );
    final ClassName target = self.nestedClass( "Builder" );
    final MethodSpec.Builder method = MethodSpec
      .methodBuilder( "create" )
      .addAnnotation( JsinteropTypes.JS_OVERLAY )
      .addAnnotation( BasicTypes.NONNULL )
      .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
      .returns( target );
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
      params.add( target );
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
        maybeAddCustomAnnotations( member, parameter );
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

    definition.getMembers().stream().filter( DictionaryMember::isRequired ).forEach( members::add );
  }

  private void generateDictionaryMemberGetter( @Nonnull final DictionaryMember member,
                                               @Nonnull final Type actualType,
                                               @Nonnull final TypeName javaType,
                                               @Nonnull final TypeSpec.Builder type )
  {
    final MethodSpec.Builder method =
      MethodSpec
        .methodBuilder( safeJsPropertyMethodName( member.getName(), TypeName.BOOLEAN.equals( javaType ) ) )
        .addModifiers( Modifier.PUBLIC, Modifier.ABSTRACT )
        .returns( javaType );
    method.addAnnotation( AnnotationSpec
                            .builder( JsinteropTypes.JS_PROPERTY )
                            .addMember( "name", "$S", toJsName( member ) )
                            .build() );
    maybeAddCustomAnnotations( member, method );
    maybeAddJavadoc( member, method );
    addMagicConstantAnnotationIfNeeded( member.getType(), method );
    if ( getSchema().isNullable( member.getType() ) )
    {
      method.addAnnotation( JsinteropTypes.JS_NULLABLE );
    }
    else
    {
      if ( !actualType.getKind().isPrimitive() && member.isRequired() )
      {
        method.addAnnotation( JsinteropTypes.JS_NONNULL );
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
    maybeAddCustomAnnotations( member, parameter );
    addMagicConstantAnnotationIfNeeded( member.getType(), parameter );

    if ( getSchema().isNullable( member.getType() ) )
    {
      parameter.addAnnotation( JsinteropTypes.JS_NULLABLE );
    }
    else if ( !actualType.getKind().isPrimitive() )
    {
      parameter.addAnnotation( JsinteropTypes.JS_NONNULL );
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

    maybeAddCustomAnnotations( member, parameter );
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
      method.addStatement( "$N( $T.<$T>uncheckedCast( $N ) )",
                           mutatorName,
                           JsinteropTypes.JS,
                           toSequenceType( (SequenceType) resolvedType ),
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
                                                            @Nonnull final TypeSpec.Builder type )
  {
    final ClassName self = lookupClassName( dictionary.getName() );
    final ClassName target = self.nestedClass( "Builder" );
    final MethodSpec.Builder method =
      MethodSpec
        .methodBuilder( javaMethodName( member ) )
        .addModifiers( Modifier.PUBLIC, Modifier.DEFAULT )
        .addAnnotation( JsinteropTypes.JS_OVERLAY )
        .addAnnotation( BasicTypes.NONNULL )
        .returns( target );
    maybeAddJavadoc( member, method );
    final TypeName javaType = typedValue.getJavaType();
    final String paramName = javaName( member );
    final ParameterSpec.Builder parameter = ParameterSpec.builder( javaType, paramName, Modifier.FINAL );

    maybeAddCustomAnnotations( member, parameter );
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
        .interfaceBuilder( lookupClassName( definition.getName() ).simpleName() )
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
    maybeAddCustomAnnotations( definition, method );
    emitReturnType( definition, definition.getReturnType(), method );
    for ( final Argument argument : definition.getArguments() )
    {
      generateArgument( argument, asTypedValue( argument.getType(), argument.isOptional() ), false, true, method );
    }
    type.addMethod( method.build() );

    writeTopLevelType( definition.getName(), type );
  }

  private void generateMarkerType( @Nonnull final TypedefDefinition definition )
    throws IOException
  {
    final TypeSpec.Builder type =
      TypeSpec
        .interfaceBuilder( lookupClassName( definition.getName() ).simpleName() )
        .addModifiers( Modifier.PUBLIC );
    writeGeneratedAnnotation( type );
    maybeAddJavadoc( definition, type );
    type.addAnnotation( AnnotationSpec
                          .builder( JsinteropTypes.JS_TYPE )
                          .addMember( "isNative", "true" )
                          .addMember( "namespace", "$T.GLOBAL", JsinteropTypes.JS_PACKAGE )
                          .addMember( "name", "$S", "?" )
                          .build() );

    for ( final TypedefDefinition markerType : definition.getMarkerTypes() )
    {
      type.addSuperinterface( lookupClassName( markerType.getName() ) );
    }

    writeTopLevelType( definition.getName(), type );
  }

  @Nonnull
  private TypedValue asTypedValue( @Nonnull final Type type )
  {
    return asTypedValue( type, false );
  }

  @Nonnull
  private TypedValue asTypedValue( @Nonnull final Type type, final boolean supportJsOptional )
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
      final TypeName javaType = toTypeName( resolveType, supportJsOptional );
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
    final boolean exposedOnGlobal = definition.isExposedOnAnyGlobal();
    final String name = definition.getName();
    final ClassName className = lookupClassName( definition.getName() );
    final String javaName = className.simpleName();
    final TypeSpec.Builder type =
      TypeSpec
        .interfaceBuilder( javaName )
        .addModifiers( Modifier.PUBLIC );
    writeGeneratedAnnotation( type );
    type.addAnnotation( AnnotationSpec.builder( JsinteropTypes.JS_TYPE )
                          .addMember( "isNative", "true" )
                          .addMember( "namespace", "$T.GLOBAL", JsinteropTypes.JS_PACKAGE )
                          .addMember( "name", "$S", exposedOnGlobal ? toJsName( definition ) : "?" )
                          .build() )
      .addAnnotation( FunctionalInterface.class );
    maybeAddCustomAnnotations( definition, type );
    maybeAddJavadoc( definition, type );

    final String testJavaName = javaName + "TestCompile";
    final TypeSpec.Builder testType =
      TypeSpec
        .classBuilder( testJavaName )
        .addModifiers( Modifier.PUBLIC, Modifier.FINAL );
    writeGeneratedAnnotation( testType );

    generateConstants( toJsName( definition ), definition.getConstants(), type );

    final OperationMember operation = definition.getOperation();
    final List<Argument> arguments = operation.getArguments();
    final List<TypedValue> typedValues = asTypedValuesList( arguments );
    generateDefaultOperation( operation,
                              true,
                              operation.getReturnType(),
                              arguments,
                              typedValues,
                              className,
                              type,
                              testType );

    writeTopLevelType( name, type );

    if ( _generateCompileTest )
    {
      emitJavaType( getTestJavaDirectory(),
                    testType.build(),
                    ClassName.get( className.packageName(), testJavaName ).toString() );

      _modulesToRequireInCompileTest.add( className.canonicalName() + "TestCompile" );
    }
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
    final ClassName className = lookupClassName( definition.getName() );
    final String javaName = className.simpleName();
    final TypeSpec.Builder type =
      TypeSpec
        .classBuilder( javaName )
        .addModifiers( Modifier.PUBLIC, Modifier.FINAL );
    writeGeneratedAnnotation( type );
    maybeAddCustomAnnotations( definition, type );
    maybeAddJavadoc( definition, type );

    final String testJavaName = javaName + "TestCompile";
    final TypeSpec.Builder testType =
      TypeSpec
        .classBuilder( testJavaName )
        .addModifiers( Modifier.PUBLIC, Modifier.FINAL );
    writeGeneratedAnnotation( testType );

    generateConstants( toJsName( definition ), definition.getConstants(), type );

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

    generateAttributes( definition, definition.getAttributes(), className, type, testType );
    definition
      .getOperations()
      .stream()
      .sorted()
      .forEach( operation -> generateOperation( definition,
                                                operation,
                                                deriveOperationReturnType( definition, operation ),
                                                className,
                                                type,
                                                testType ) );

    final MapLikeMember mapLike = definition.getMapLikeMember();
    if ( null != mapLike )
    {
      generateMapLikeOperations( name, definition.getOperations(), mapLike, className, type, testType );
    }
    final IterableMember iterable = definition.getIterable();
    if ( null != iterable )
    {
      if ( null == iterable.getKeyType() )
      {
        generateValueIterableElements( name, iterable, className, type, testType );
      }
      else
      {
        generatePairIterableElements( name, iterable, className, type, testType );
      }
    }
    if ( null != iterable || null != mapLike )
    {
      type.addSuperinterface( ParameterizedTypeName.get( lookupClassName( "Iterable" ),
                                                         ClassName.bestGuess( javaName + ".Entry" ) ) );
    }
    if ( null != definition.getAsyncIterable() )
    {
      throw new UnsupportedOperationException( "async iterable not yet supported in code generator" );
    }
    final SetLikeMember setLike = definition.getSetLikeMember();
    if ( null != setLike )
    {
      generateSetLikeOperations( name, definition.getOperations(), setLike, className, type, testType );
    }
    final boolean noPublicSymbol =
      OutputType.gwt == _outputType &&
      definition.isNoArgsExtendedAttributePresent( ExtendedAttributes.LEGACY_NO_INTERFACE_OBJECT );
    type.addAnnotation( AnnotationSpec.builder( JsinteropTypes.JS_TYPE )
                          .addMember( "isNative", "true" )
                          .addMember( "namespace", "$T.GLOBAL", JsinteropTypes.JS_PACKAGE )
                          .addMember( "name", "$S", noPublicSymbol ? "Object" : toJsName( definition ) )
                          .build() );

    writeTopLevelType( name, type );
    if ( _generateCompileTest )
    {
      emitJavaType( getTestJavaDirectory(),
                    testType.build(),
                    ClassName.get( className.packageName(), testJavaName ).toString() );

      _modulesToRequireInCompileTest.add( className.canonicalName() + "TestCompile" );
    }
  }

  @Nonnull
  private Type deriveOperationReturnType( @Nonnull final OperationMemberContainer definition,
                                          @Nonnull final OperationMember operation )
  {
    final String operationName = operation.getName();

    // We only care about merging return types in closure binding due to the way the type system works
    return OutputType.j2cl == _outputType &&
           // We are matching on operations by name so must have a name
           null != operationName &&
           // Promises seems to be handled fine in the underlying Closure type system
           Kind.Promise != operation.getReturnType().getKind() ?
           deriveReturnType( definition.findAllOperationsByName( operationName ) ) :
           operation.getReturnType();
  }

  private void generatePairIterableElements( @Nonnull final String idlName,
                                             @Nonnull final IterableMember iterable,
                                             @Nonnull final ClassName className,
                                             @Nonnull final TypeSpec.Builder type,
                                             @Nonnull final TypeSpec.Builder testType )
  {
    final Type keyType = iterable.getKeyType();
    assert null != keyType;
    generateEntry( "key", toTypeName( keyType ), toTypeName( iterable.getValueType() ), type );
    generateIterableKeysMethod( idlName, toTypeName( keyType ), className, type, testType );
    generateIterableValuesMethod( idlName, iterable, className, type, testType );
    generateIterableEntriesMethod( idlName, className, type, testType );
    generateIterableForEachMethod( idlName, iterable, toTypeName( keyType ), "key", className, type, testType );
  }

  private void generateValueIterableElements( @Nonnull final String idlName,
                                              @Nonnull final IterableMember iterable,
                                              @Nonnull final ClassName className,
                                              @Nonnull final TypeSpec.Builder type,
                                              @Nonnull final TypeSpec.Builder testType )
  {
    generateEntry( "index", TypeName.INT, toTypeName( iterable.getValueType() ), type );
    generateIterableKeysMethod( idlName, TypeName.DOUBLE, className, type, testType );
    generateIterableValuesMethod( idlName, iterable, className, type, testType );
    generateIterableEntriesMethod( idlName, className, type, testType );
    generateIterableForEachMethod( idlName, iterable, TypeName.INT, "index", className, type, testType );
  }

  private void generateIterableForEachMethod( @Nonnull final String idlName,
                                              @Nonnull final IterableMember iterable,
                                              @Nonnull final TypeName keyType,
                                              @Nonnull final String keyName,
                                              @Nonnull final ClassName className,
                                              @Nonnull final TypeSpec.Builder type,
                                              @Nonnull final TypeSpec.Builder testType )
  {
    final ParameterSpec indexParam = ParameterSpec.builder( keyType, keyName ).build();

    final TypeName valueType = toTypeName( iterable.getValueType() );
    final ParameterSpec.Builder valueParamBuilder = ParameterSpec.builder( valueType, "value" );
    addNullabilityAnnotationIfRequired( iterable.getValueType(), valueParamBuilder );
    final ParameterSpec valueParam = valueParamBuilder.build();

    final DocumentationElement documentation = getDocumentationElement( idlName, "forEach" );

    type.addType( TypeSpec
                    .interfaceBuilder( "ForEachCallback" )
                    .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                    .addAnnotation( JsinteropTypes.JS_FUNCTION )
                    .addAnnotation( FunctionalInterface.class )
                    .addMethod( MethodSpec
                                  .methodBuilder( "item" )
                                  .addModifiers( Modifier.PUBLIC, Modifier.ABSTRACT )
                                  .addParameter( valueParam )
                                  .build() ).build() );
    type.addType( TypeSpec
                    .interfaceBuilder( "ForEachCallback2" )
                    .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                    .addAnnotation( JsinteropTypes.JS_FUNCTION )
                    .addAnnotation( FunctionalInterface.class )
                    .addMethod( MethodSpec
                                  .methodBuilder( "item" )
                                  .addModifiers( Modifier.PUBLIC, Modifier.ABSTRACT )
                                  .addParameter( valueParam )
                                  .addParameter( indexParam )
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
                                  .addParameter( indexParam )
                                  .addParameter( ParameterSpec
                                                   .builder( lookupClassName( idlName ), "iterable" )
                                                   .addAnnotation( JsinteropTypes.JS_NONNULL )
                                                   .build() )
                                  .build() )
                    .build() );
    final MethodSpec.Builder forEach1 =
      MethodSpec
        .methodBuilder( "forEach" )
        .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
        .addParameter( ParameterSpec.builder( ClassName.bestGuess( "ForEachCallback" ), "callback" )
                         .addAnnotation( JsinteropTypes.JS_NONNULL )
                         .build() );
    maybeAddJavadoc( documentation, forEach1 );
    type.addMethod( forEach1.build() );

    testType.addMethod( MethodSpec
                          .methodBuilder( "forEach" )
                          .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                          .addParameter( ParameterSpec.builder( className, "$instance" ).build() )
                          .addParameter( ParameterSpec
                                           .builder( className.nestedClass( "ForEachCallback" ), "callback" )
                                           .build() )
                          .addStatement( "$N.$N( callback )", "$instance", "forEach" )
                          .build() );

    final MethodSpec.Builder forEach2 =
      MethodSpec
        .methodBuilder( "forEach" )
        .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
        .addParameter( ParameterSpec.builder( ClassName.bestGuess( "ForEachCallback2" ), "callback" )
                         .addAnnotation( JsinteropTypes.JS_NONNULL )
                         .build() );
    maybeAddJavadoc( documentation, forEach2 );
    type.addMethod( forEach2.build() );

    testType.addMethod( MethodSpec
                          .methodBuilder( "forEach" )
                          .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                          .addParameter( ParameterSpec.builder( className, "$instance" ).build() )
                          .addParameter( ParameterSpec
                                           .builder( className.nestedClass( "ForEachCallback2" ), "callback" )
                                           .build() )
                          .addStatement( "$N.$N( callback )", "$instance", "forEach" )
                          .build() );

    final MethodSpec.Builder forEach3 =
      MethodSpec
        .methodBuilder( "forEach" )
        .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
        .addParameter( ParameterSpec.builder( ClassName.bestGuess( "ForEachCallback3" ), "callback" )
                         .addAnnotation( JsinteropTypes.JS_NONNULL )
                         .build() );
    maybeAddJavadoc( documentation, forEach3 );
    type.addMethod( forEach3.build() );

    testType.addMethod( MethodSpec
                          .methodBuilder( "forEach" )
                          .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                          .addParameter( ParameterSpec.builder( className, "$instance" ).build() )
                          .addParameter( ParameterSpec
                                           .builder( className.nestedClass( "ForEachCallback3" ), "callback" )
                                           .build() )
                          .addStatement( "$N.$N( callback )", "$instance", "forEach" )
                          .build() );
  }

  private void generateIterableEntriesMethod( @Nonnull final String idlName,
                                              @Nonnull final ClassName className,
                                              @Nonnull final TypeSpec.Builder type,
                                              @Nonnull final TypeSpec.Builder testType )
  {
    final String methodName = "entries";
    final MethodSpec.Builder method =
      MethodSpec
        .methodBuilder( methodName )
        .addAnnotation( JsinteropTypes.HAS_NO_SIDE_EFFECTS )
        .addAnnotation( JsinteropTypes.JS_NONNULL )
        .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
        .returns( iteratorType( ClassName.bestGuess( "Entry" ) ) );
    maybeAddJavadoc( getDocumentationElement( idlName, methodName ), method );
    type.addMethod( method.build() );

    testType.addMethod( MethodSpec
                          .methodBuilder( methodName )
                          .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                          .addParameter( ParameterSpec.builder( className, "$instance" ).build() )
                          .returns( iteratorType( className.nestedClass( "Entry" ) ) )
                          .addStatement( "return $N.$N()", "$instance", methodName )
                          .build() );
  }

  private void generateIterableKeysMethod( @Nonnull final String idlName,
                                           @Nonnull final TypeName keyType,
                                           @Nonnull final ClassName className,
                                           @Nonnull final TypeSpec.Builder type,
                                           @Nonnull final TypeSpec.Builder testType )
  {
    final String methodName = "keys";
    final MethodSpec.Builder method =
      MethodSpec
        .methodBuilder( methodName )
        .addAnnotation( JsinteropTypes.HAS_NO_SIDE_EFFECTS )
        .addAnnotation( JsinteropTypes.JS_NONNULL )
        .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
        .returns( iteratorType( keyType.box() ) );
    maybeAddJavadoc( getDocumentationElement( idlName, methodName ), method );
    type.addMethod( method.build() );

    testType.addMethod( MethodSpec
                          .methodBuilder( methodName )
                          .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                          .addParameter( ParameterSpec.builder( className, "$instance" ).build() )
                          .returns( iteratorType( keyType.box() ) )
                          .addStatement( "return $N.$N()", "$instance", methodName )
                          .build() );
  }

  private void generateIterableValuesMethod( @Nonnull final String idlName,
                                             @Nonnull final IterableMember iterable,
                                             @Nonnull final ClassName className,
                                             @Nonnull final TypeSpec.Builder type,
                                             @Nonnull final TypeSpec.Builder testType )
  {
    final String methodName = "values";
    final MethodSpec.Builder method =
      MethodSpec.methodBuilder( methodName )
        .addAnnotation( JsinteropTypes.HAS_NO_SIDE_EFFECTS )
        .addAnnotation( JsinteropTypes.JS_NONNULL )
        .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
        .returns( iteratorType( toTypeName( iterable.getValueType() ) ) );
    maybeAddJavadoc( getDocumentationElement( idlName, methodName ), method );
    type.addMethod( method.build() );

    testType.addMethod( MethodSpec
                          .methodBuilder( methodName )
                          .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                          .addParameter( ParameterSpec.builder( className, "$instance" ).build() )
                          .returns( iteratorType( toTypeName( iterable.getValueType() ) ) )
                          .addStatement( "return $N.$N()", "$instance", methodName )
                          .build() );
  }

  private void generateNamespace( @Nonnull final NamespaceDefinition definition )
    throws IOException
  {
    final String idlName = definition.getName();
    final ClassName className = lookupClassName( idlName );
    final String javaName = className.simpleName();
    final TypeSpec.Builder type =
      TypeSpec
        .classBuilder( javaName )
        .addModifiers( Modifier.PUBLIC, Modifier.FINAL )
        .addAnnotation( AnnotationSpec
                          .builder( JsinteropTypes.JS_TYPE )
                          .addMember( "isNative", "true" )
                          .addMember( "name", "$S", toJsName( definition ) )
                          .addMember( "namespace", "$T.GLOBAL", JsinteropTypes.JS_PACKAGE )
                          .build() );
    writeGeneratedAnnotation( type );
    maybeAddJavadoc( definition, type );

    final String testJavaName = javaName + "TestCompile";
    final TypeSpec.Builder testType =
      TypeSpec
        .classBuilder( testJavaName )
        .addModifiers( Modifier.PUBLIC, Modifier.FINAL );
    writeGeneratedAnnotation( testType );

    generateConstants( toJsName( definition ), definition.getConstants(), type );
    generateStaticAttributes( definition, definition.getAttributes(), className, type, testType );
    generateStaticOperations( definition, definition.getOperations(), className, type, testType );

    type.addMethod( MethodSpec.constructorBuilder().addModifiers( Modifier.PRIVATE ).build() );

    writeTopLevelType( idlName, type );
    if ( _generateCompileTest )
    {
      emitJavaType( getTestJavaDirectory(),
                    testType.build(),
                    ClassName.get( className.packageName(), testJavaName ).toString() );

      _modulesToRequireInCompileTest.add( className.canonicalName() + "TestCompile" );
    }
  }

  private void generateStaticOperations( @Nonnull final NamedDefinition definition,
                                         @Nonnull final List<OperationMember> operations,
                                         @Nonnull final ClassName className,
                                         @Nonnull final TypeSpec.Builder type,
                                         @Nonnull final TypeSpec.Builder testType )
  {
    for ( final OperationMember operation : operations )
    {
      final OperationMember.Kind operationKind = operation.getKind();
      if ( OperationMember.Kind.DEFAULT == operationKind ||
           (
             ( OperationMember.Kind.STRINGIFIER == operationKind ||
               OperationMember.Kind.GETTER == operationKind ||
               OperationMember.Kind.SETTER == operationKind ||
               OperationMember.Kind.DELETER == operationKind ) &&
             null != operation.getName() ) )
      {
        generateNamespaceOperation( definition, operation, className, type, testType );
      }
    }
  }

  private void generateInterface( @Nonnull final InterfaceDefinition definition )
    throws IOException
  {
    final String name = definition.getName();
    final ClassName className = lookupClassName( definition.getName() );
    final String javaName = className.simpleName();
    final TypeSpec.Builder type =
      TypeSpec
        .classBuilder( javaName )
        .addModifiers( Modifier.PUBLIC );
    writeGeneratedAnnotation( type );
    maybeAddCustomAnnotations( definition, type );
    maybeAddJavadoc( definition, type );

    final String testJavaName = javaName + "TestCompile";
    final TypeSpec.Builder testType =
      TypeSpec
        .classBuilder( testJavaName )
        .addModifiers( Modifier.PUBLIC, Modifier.FINAL );
    writeGeneratedAnnotation( testType );

    final FieldSpec.Builder typeReferenceField =
      FieldSpec.builder( className, "$typeReference$", Modifier.STATIC );
    final DocumentationElement documentation = definition.getDocumentation();
    if ( null != documentation && documentation.hasDeprecatedTag() )
    {
      typeReferenceField.addAnnotation( Deprecated.class );
    }

    testType.addField( typeReferenceField.build() );

    for ( final TypedefDefinition markerType : definition.getMarkerTypes() )
    {
      type.addSuperinterface( lookupClassName( markerType.getName() ) );
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

    generateConstants( toJsName( definition ), definition.getConstants(), type );
    generateAttributes( definition, definition.getAttributes(), className, type, testType );

    boolean constructorPresent = false;
    for ( final OperationMember operation : definition.getOperations() )
    {
      final boolean processed =
        generateOperation( definition,
                           operation,
                           deriveOperationReturnType( definition, operation ),
                           className,
                           type,
                           testType );
      if ( !processed && OperationMember.Kind.CONSTRUCTOR == operation.getKind() )
      {
        generateConstructorOperation( operation, parentConstructor, type );
        constructorPresent = true;
      }
    }

    final MapLikeMember mapLike = definition.getMapLikeMember();
    if ( null != mapLike )
    {
      generateMapLikeOperations( name, definition.getOperations(), mapLike, className, type, testType );
    }
    final IterableMember iterable = definition.getIterable();
    if ( null != iterable )
    {
      if ( null == iterable.getKeyType() )
      {
        generateValueIterableElements( name, iterable, className, type, testType );
      }
      else
      {
        generatePairIterableElements( name, iterable, className, type, testType );
      }
    }
    if ( null != iterable || null != mapLike )
    {
      type.addSuperinterface( ParameterizedTypeName.get( lookupClassName( "Iterable" ),
                                                         ClassName.bestGuess( javaName + ".Entry" ) ) );
    }
    final SetLikeMember setLike = definition.getSetLikeMember();
    if ( null != setLike )
    {
      generateSetLikeOperations( name, definition.getOperations(), setLike, className, type, testType );
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
    if ( _generateCompileTest )
    {
      emitJavaType( getTestJavaDirectory(),
                    testType.build(),
                    ClassName.get( className.packageName(), testJavaName ).toString() );

      _modulesToRequireInCompileTest.add( className.canonicalName() + "TestCompile" );
    }
  }

  private boolean generateOperation( @Nonnull final NamedDefinition definition,
                                     @Nonnull final OperationMember operation,
                                     @Nonnull final Type returnType,
                                     @Nonnull final ClassName className,
                                     @Nonnull final TypeSpec.Builder type,
                                     @Nonnull final TypeSpec.Builder testType )
  {
    final OperationMember.Kind operationKind = operation.getKind();
    final String operationName = operation.getName();
    if ( OperationMember.Kind.DEFAULT == operationKind )
    {
      generateDefaultOperation( definition, operation, returnType, className, type, testType );
    }
    else if ( ( OperationMember.Kind.STRINGIFIER == operationKind ||
                OperationMember.Kind.GETTER == operationKind ||
                OperationMember.Kind.SETTER == operationKind ||
                OperationMember.Kind.DELETER == operationKind ) &&
              null != operationName )
    {
      generateDefaultOperation( definition, operation, returnType, className, type, testType );
    }
    else if ( OperationMember.Kind.GETTER == operationKind &&
              Kind.UnsignedLong == operation.getArguments().get( 0 ).getType().getKind() )
    {
      generateAnonymousIndexedGetter( operation, type );
    }
    else if ( OperationMember.Kind.SETTER == operationKind &&
              Kind.UnsignedLong == operation.getArguments().get( 0 ).getType().getKind() )
    {
      generateAnonymousIndexedSetter( operation, type );
    }
    else if ( OperationMember.Kind.GETTER == operationKind &&
              Kind.DOMString == operation.getArguments().get( 0 ).getType().getKind() )
    {
      generateAnonymousNamedGetter( operation, type );
    }
    else if ( OperationMember.Kind.SETTER == operationKind &&
              Kind.DOMString == operation.getArguments().get( 0 ).getType().getKind() )
    {
      generateAnonymousNamedSetter( operation, type );
    }
    else if ( OperationMember.Kind.DELETER == operationKind &&
              Kind.DOMString == operation.getArguments().get( 0 ).getType().getKind() )
    {
      generateAnonymousNamedDeleter( operation, type );
    }
    else if ( OperationMember.Kind.STATIC == operationKind )
    {
      generateStaticOperation( operation, className, type, testType );
    }
    else
    {
      return false;
    }
    return true;
  }

  private void generateAttributes( @Nonnull final NamedDefinition definition,
                                   @Nonnull final List<AttributeMember> attributes,
                                   @Nonnull final ClassName className,
                                   @Nonnull final TypeSpec.Builder type,
                                   @Nonnull final TypeSpec.Builder testType )
  {
    attributes
      .stream()
      .sorted( Comparator.comparing( NamedElement::getName ) )
      .forEach( attribute -> generateAttribute( definition, attribute, className, type, testType ) );
  }

  private void generateAttribute( @Nonnull final NamedDefinition definition,
                                  @Nonnull final AttributeMember attribute,
                                  @Nonnull final ClassName className,
                                  @Nonnull final TypeSpec.Builder type,
                                  @Nonnull final TypeSpec.Builder testType )
  {
    if ( attribute.getModifiers().contains( AttributeMember.Modifier.READ_ONLY ) )
    {
      generateReadOnlyAttribute( definition, attribute, className, type, testType );
    }
    else
    {
      generateReadWriteAttribute( attribute, className, type, testType );
    }
  }

  private void generateSetLikeOperations( @Nonnull final String definitionName,
                                          @Nonnull final List<OperationMember> operations,
                                          @Nonnull final SetLikeMember setLike,
                                          @Nonnull final ClassName className,
                                          @Nonnull final TypeSpec.Builder type,
                                          @Nonnull final TypeSpec.Builder testType )
  {
    type.addMethod( MethodSpec
                      .methodBuilder( "size" )
                      .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
                      .addAnnotation( AnnotationSpec.builder( JsinteropTypes.JS_PROPERTY )
                                        .addMember( "name", "$S", "size" )
                                        .build() )
                      .returns( TypeName.INT )
                      .build() );
    testType.addMethod( MethodSpec
                          .methodBuilder( "size" )
                          .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                          .returns( TypeName.INT )
                          .addParameter( ParameterSpec.builder( className, "$instance" ).build() )
                          .addStatement( "return $N.$N()", "$instance", "size" )
                          .build() );
    final TypeName elementType = toTypeName( setLike.getType() );
    final TypeName boxedElementType = toTypeName( setLike.getType(), true );

    final ParameterSpec.Builder elementParamBuilder = ParameterSpec.builder( elementType, "value" );
    addNullabilityAnnotationIfRequired( setLike.getType(), elementParamBuilder );
    final ParameterSpec elementParam = elementParamBuilder.build();

    final ParameterSpec.Builder elementParam2Builder = ParameterSpec.builder( elementType, "value2" );
    addNullabilityAnnotationIfRequired( setLike.getType(), elementParam2Builder );
    final ParameterSpec elementParam2 = elementParam2Builder.build();

    final MethodSpec.Builder has =
      MethodSpec
        .methodBuilder( "has" )
        .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
        .addAnnotation( JsinteropTypes.HAS_NO_SIDE_EFFECTS )
        .addParameter( elementParam )
        .returns( TypeName.BOOLEAN );
    maybeAddJavadoc( getDocumentationElement( definitionName, "has" ), has );
    type.addMethod( has.build() );

    testType.addMethod( MethodSpec
                          .methodBuilder( "has" )
                          .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                          .addParameter( ParameterSpec.builder( elementType, "key" ).build() )
                          .returns( TypeName.BOOLEAN )
                          .addParameter( ParameterSpec.builder( className, "$instance" ).build() )
                          .addStatement( "return $N.$N( key )", "$instance", "has" )
                          .build() );

    final MethodSpec.Builder keys =
      MethodSpec
        .methodBuilder( "keys" )
        .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
        .addAnnotation( JsinteropTypes.HAS_NO_SIDE_EFFECTS )
        .addAnnotation( JsinteropTypes.JS_NONNULL )
        .returns( iteratorType( boxedElementType ) );
    maybeAddJavadoc( getDocumentationElement( definitionName, "keys" ), keys );
    type.addMethod( keys.build() );

    testType.addMethod( MethodSpec
                          .methodBuilder( "keys" )
                          .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                          .addParameter( ParameterSpec.builder( className, "$instance" ).build() )
                          .returns( iteratorType( boxedElementType ) )
                          .addStatement( "return $N.$N()", "$instance", "keys" )
                          .build() );

    final MethodSpec.Builder values =
      MethodSpec
        .methodBuilder( "values" )
        .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
        .addAnnotation( JsinteropTypes.HAS_NO_SIDE_EFFECTS )
        .addAnnotation( JsinteropTypes.JS_NONNULL )
        .returns( iteratorType( boxedElementType ) );
    maybeAddJavadoc( getDocumentationElement( definitionName, "values" ), values );
    type.addMethod( values.build() );

    testType.addMethod( MethodSpec
                          .methodBuilder( "values" )
                          .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                          .addParameter( ParameterSpec.builder( className, "$instance" ).build() )
                          .returns( iteratorType( boxedElementType ) )
                          .addStatement( "return $N.$N()", "$instance", "values" )
                          .build() );

    generateEntry( "key", elementType, elementType, type );

    final MethodSpec.Builder entries =
      MethodSpec
        .methodBuilder( "entries" )
        .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
        .addAnnotation( JsinteropTypes.HAS_NO_SIDE_EFFECTS )
        .addAnnotation( JsinteropTypes.JS_NONNULL )
        .returns( iteratorType( ClassName.bestGuess( "Entry" ) ) );
    maybeAddJavadoc( getDocumentationElement( definitionName, "entries" ), entries );
    type.addMethod( entries.build() );

    testType.addMethod( MethodSpec
                          .methodBuilder( "entries" )
                          .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                          .addParameter( ParameterSpec.builder( className, "$instance" ).build() )
                          .returns( iteratorType( className.nestedClass( "Entry" ) ) )
                          .addStatement( "return $N.$N()", "$instance", "entries" )
                          .build() );

    type.addType( TypeSpec
                    .interfaceBuilder( "ForEachCallback" )
                    .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                    .addAnnotation( JsinteropTypes.JS_FUNCTION )
                    .addAnnotation( FunctionalInterface.class )
                    .addMethod( MethodSpec
                                  .methodBuilder( "item" )
                                  .addModifiers( Modifier.PUBLIC, Modifier.ABSTRACT )
                                  .addParameter( elementParam )
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
                                  .addParameter( elementParam )
                                  .addParameter( elementParam2 )
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
                                  .addParameter( elementParam )
                                  .addParameter( elementParam2 )
                                  .addParameter( ParameterSpec
                                                   .builder( lookupClassName( definitionName ), "set" )
                                                   .addAnnotation( JsinteropTypes.JS_NONNULL )
                                                   .build() )
                                  .build() )
                    .build() );
    final DocumentationElement forEachDocumentation = getDocumentationElement( definitionName, "forEach" );
    final MethodSpec.Builder forEach1 =
      MethodSpec
        .methodBuilder( "forEach" )
        .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
        .addParameter( ParameterSpec
                         .builder( ClassName.bestGuess( "ForEachCallback" ), "callback" )
                         .addAnnotation( JsinteropTypes.JS_NONNULL )
                         .build() );
    maybeAddJavadoc( forEachDocumentation, forEach1 );
    type.addMethod( forEach1.build() );

    testType.addMethod( MethodSpec
                          .methodBuilder( "forEach" )
                          .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                          .addParameter( ParameterSpec.builder( className, "$instance" ).build() )
                          .addParameter( ParameterSpec
                                           .builder( className.nestedClass( "ForEachCallback" ), "callback" )
                                           .build() )
                          .addStatement( "$N.$N( callback )", "$instance", "forEach" )
                          .build() );

    final MethodSpec.Builder forEach2 =
      MethodSpec
        .methodBuilder( "forEach" )
        .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
        .addParameter( ParameterSpec.builder( ClassName.bestGuess( "ForEachCallback2" ), "callback" )
                         .addAnnotation( JsinteropTypes.JS_NONNULL )
                         .build() );
    maybeAddJavadoc( forEachDocumentation, forEach2 );
    type.addMethod( forEach2.build() );

    testType.addMethod( MethodSpec
                          .methodBuilder( "forEach" )
                          .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                          .addParameter( ParameterSpec.builder( className, "$instance" ).build() )
                          .addParameter( ParameterSpec
                                           .builder( className.nestedClass( "ForEachCallback2" ), "callback" )
                                           .build() )
                          .addStatement( "$N.$N( callback )", "$instance", "forEach" )
                          .build() );

    final MethodSpec.Builder forEach3 = MethodSpec
      .methodBuilder( "forEach" )
      .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
      .addParameter( ParameterSpec.builder( ClassName.bestGuess( "ForEachCallback3" ), "callback" )
                       .addAnnotation( JsinteropTypes.JS_NONNULL )
                       .build() );
    maybeAddJavadoc( forEachDocumentation, forEach3 );
    type.addMethod( forEach3.build() );

    testType.addMethod( MethodSpec
                          .methodBuilder( "forEach" )
                          .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                          .addParameter( ParameterSpec.builder( className, "$instance" ).build() )
                          .addParameter( ParameterSpec
                                           .builder( className.nestedClass( "ForEachCallback3" ), "callback" )
                                           .build() )
                          .addStatement( "$N.$N( callback )", "$instance", "forEach" )
                          .build() );

    if ( !setLike.isReadOnly() )
    {
      final boolean addPresent =
        operations
          .stream()
          .anyMatch( o -> "add".equals( o.getName() ) &&
                          1 == o.getArguments().size() &&
                          Kind.Void == o.getReturnType().getKind() );
      if ( !addPresent )
      {
        final MethodSpec.Builder set = MethodSpec
          .methodBuilder( "add" )
          .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
          .addParameter( elementParam );
        maybeAddJavadoc( getDocumentationElement( definitionName, "add" ), set );
        type.addMethod( set.build() );

        testType.addMethod( MethodSpec
                              .methodBuilder( "add" )
                              .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                              .addParameter( ParameterSpec.builder( className, "$instance" ).build() )
                              .addParameter( ParameterSpec.builder( elementType, "value" ).build() )
                              .addStatement( "$N.$N( value )", "$instance", "add" )
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
        final MethodSpec.Builder delete =
          MethodSpec
            .methodBuilder( "delete" )
            .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
            .addParameter( elementParam )
            .returns( TypeName.BOOLEAN );
        maybeAddJavadoc( getDocumentationElement( definitionName, "delete" ), delete );
        type.addMethod( delete.build() );

        testType.addMethod( MethodSpec
                              .methodBuilder( "delete" )
                              .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                              .addParameter( ParameterSpec.builder( className, "$instance" ).build() )
                              .addParameter( ParameterSpec.builder( elementType, "value" ).build() )
                              .returns( TypeName.BOOLEAN )
                              .addStatement( "return $N.$N( value )", "$instance", "delete" )
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
        final MethodSpec.Builder clear =
          MethodSpec
            .methodBuilder( "clear" )
            .addModifiers( Modifier.PUBLIC, Modifier.NATIVE );
        maybeAddJavadoc( getDocumentationElement( definitionName, "clear" ), clear );
        type.addMethod( clear.build() );

        testType.addMethod( MethodSpec
                              .methodBuilder( "clear" )
                              .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                              .addParameter( ParameterSpec.builder( className, "$instance" ).build() )
                              .addStatement( "$N.$N()", "$instance", "clear" )
                              .build() );
      }
    }
  }

  private void generateMapLikeOperations( @Nonnull final String definitionName,
                                          @Nonnull final List<OperationMember> operations,
                                          @Nonnull final MapLikeMember mapLike,
                                          @Nonnull final ClassName className,
                                          @Nonnull final TypeSpec.Builder type,
                                          @Nonnull final TypeSpec.Builder testType )
  {
    type.addMethod( MethodSpec
                      .methodBuilder( "size" )
                      .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
                      .addAnnotation( AnnotationSpec.builder( JsinteropTypes.JS_PROPERTY )
                                        .addMember( "name", "$S", "size" )
                                        .build() )
                      .returns( TypeName.INT )
                      .build() );
    testType.addMethod( MethodSpec
                          .methodBuilder( "size" )
                          .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                          .returns( TypeName.INT )
                          .addParameter( ParameterSpec.builder( className, "$instance" ).build() )
                          .addStatement( "return $N.$N()", "$instance", "size" )
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

    final MethodSpec.Builder has =
      MethodSpec
        .methodBuilder( "has" )
        .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
        .addAnnotation( JsinteropTypes.HAS_NO_SIDE_EFFECTS )
        .addParameter( keyParam )
        .returns( TypeName.BOOLEAN );
    maybeAddJavadoc( getDocumentationElement( definitionName, "has" ), has );
    type.addMethod( has.build() );

    testType.addMethod( MethodSpec
                          .methodBuilder( "has" )
                          .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                          .addParameter( ParameterSpec.builder( keyType, "key" ).build() )
                          .returns( TypeName.BOOLEAN )
                          .addParameter( ParameterSpec.builder( className, "$instance" ).build() )
                          .addStatement( "return $N.$N( key )", "$instance", "has" )
                          .build() );

    final MethodSpec.Builder get = MethodSpec
      .methodBuilder( "get" )
      .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
      .addAnnotation( JsinteropTypes.HAS_NO_SIDE_EFFECTS )
      .addAnnotation( JsinteropTypes.JS_NULLABLE )
      .addParameter( keyParam )
      .returns( boxedValueType );
    maybeAddJavadoc( getDocumentationElement( definitionName, "get" ), get );
    type.addMethod( get.build() );

    testType.addMethod( MethodSpec
                          .methodBuilder( "get" )
                          .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                          .addParameter( ParameterSpec.builder( className, "$instance" ).build() )
                          .addParameter( ParameterSpec.builder( keyType, "key" ).build() )
                          .returns( boxedValueType )
                          .addStatement( "return $N.$N( key )", "$instance", "get" )
                          .build() );

    final MethodSpec.Builder keys =
      MethodSpec
        .methodBuilder( "keys" )
        .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
        .addAnnotation( JsinteropTypes.HAS_NO_SIDE_EFFECTS )
        .addAnnotation( JsinteropTypes.JS_NONNULL )
        .returns( iteratorType( boxedKeyType ) );
    maybeAddJavadoc( getDocumentationElement( definitionName, "keys" ), keys );
    type.addMethod( keys.build() );

    testType.addMethod( MethodSpec
                          .methodBuilder( "keys" )
                          .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                          .addParameter( ParameterSpec.builder( className, "$instance" ).build() )
                          .returns( iteratorType( boxedKeyType ) )
                          .addStatement( "return $N.$N()", "$instance", "keys" )
                          .build() );

    final MethodSpec.Builder values =
      MethodSpec
        .methodBuilder( "values" )
        .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
        .addAnnotation( JsinteropTypes.HAS_NO_SIDE_EFFECTS )
        .addAnnotation( JsinteropTypes.JS_NONNULL )
        .returns( iteratorType( boxedValueType ) );
    maybeAddJavadoc( getDocumentationElement( definitionName, "values" ), values );
    type.addMethod( values.build() );

    testType.addMethod( MethodSpec
                          .methodBuilder( "values" )
                          .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                          .addParameter( ParameterSpec.builder( className, "$instance" ).build() )
                          .returns( iteratorType( boxedValueType ) )
                          .addStatement( "return $N.$N()", "$instance", "values" )
                          .build() );

    generateEntry( "key", keyType, valueType, type );

    final MethodSpec.Builder entries =
      MethodSpec
        .methodBuilder( "entries" )
        .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
        .addAnnotation( JsinteropTypes.HAS_NO_SIDE_EFFECTS )
        .addAnnotation( JsinteropTypes.JS_NONNULL )
        .returns( iteratorType( ClassName.bestGuess( "Entry" ) ) );
    maybeAddJavadoc( getDocumentationElement( definitionName, "entries" ), entries );
    type.addMethod( entries.build() );

    testType.addMethod( MethodSpec
                          .methodBuilder( "entries" )
                          .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                          .addParameter( ParameterSpec.builder( className, "$instance" ).build() )
                          .returns( iteratorType( className.nestedClass( "Entry" ) ) )
                          .addStatement( "return $N.$N()", "$instance", "entries" )
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
                                                   .addAnnotation( JsinteropTypes.JS_NONNULL )
                                                   .build() )
                                  .build() )
                    .build() );
    final DocumentationElement forEachDocumentation = getDocumentationElement( definitionName, "forEach" );
    final MethodSpec.Builder forEach1 =
      MethodSpec
        .methodBuilder( "forEach" )
        .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
        .addParameter( ParameterSpec
                         .builder( ClassName.bestGuess( "ForEachCallback" ), "callback" )
                         .addAnnotation( JsinteropTypes.JS_NONNULL )
                         .build() );
    maybeAddJavadoc( forEachDocumentation, forEach1 );
    type.addMethod( forEach1.build() );

    testType.addMethod( MethodSpec
                          .methodBuilder( "forEach" )
                          .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                          .addParameter( ParameterSpec.builder( className, "$instance" ).build() )
                          .addParameter( ParameterSpec
                                           .builder( className.nestedClass( "ForEachCallback" ), "callback" )
                                           .build() )
                          .addStatement( "$N.$N( callback )", "$instance", "forEach" )
                          .build() );

    final MethodSpec.Builder forEach2 =
      MethodSpec
        .methodBuilder( "forEach" )
        .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
        .addParameter( ParameterSpec.builder( ClassName.bestGuess( "ForEachCallback2" ), "callback" )
                         .addAnnotation( JsinteropTypes.JS_NONNULL )
                         .build() );
    maybeAddJavadoc( forEachDocumentation, forEach2 );
    type.addMethod( forEach2.build() );

    testType.addMethod( MethodSpec
                          .methodBuilder( "forEach" )
                          .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                          .addParameter( ParameterSpec.builder( className, "$instance" ).build() )
                          .addParameter( ParameterSpec
                                           .builder( className.nestedClass( "ForEachCallback2" ), "callback" )
                                           .build() )
                          .addStatement( "$N.$N( callback )", "$instance", "forEach" )
                          .build() );

    final MethodSpec.Builder forEach3 = MethodSpec
      .methodBuilder( "forEach" )
      .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
      .addParameter( ParameterSpec.builder( ClassName.bestGuess( "ForEachCallback3" ), "callback" )
                       .addAnnotation( JsinteropTypes.JS_NONNULL )
                       .build() );
    maybeAddJavadoc( forEachDocumentation, forEach3 );
    type.addMethod( forEach3.build() );

    testType.addMethod( MethodSpec
                          .methodBuilder( "forEach" )
                          .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                          .addParameter( ParameterSpec.builder( className, "$instance" ).build() )
                          .addParameter( ParameterSpec
                                           .builder( className.nestedClass( "ForEachCallback3" ), "callback" )
                                           .build() )
                          .addStatement( "$N.$N( callback )", "$instance", "forEach" )
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
        final MethodSpec.Builder set = MethodSpec
          .methodBuilder( "set" )
          .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
          .addParameter( keyParam )
          .addParameter( valueParam );
        maybeAddJavadoc( getDocumentationElement( definitionName, "set" ), set );
        type.addMethod( set.build() );

        testType.addMethod( MethodSpec
                              .methodBuilder( "set" )
                              .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                              .addParameter( ParameterSpec.builder( className, "$instance" ).build() )
                              .addParameter( ParameterSpec.builder( keyType, "key" ).build() )
                              .addParameter( ParameterSpec.builder( valueType, "value" ).build() )
                              .addStatement( "$N.$N( key, value )", "$instance", "set" )
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
        final MethodSpec.Builder delete =
          MethodSpec
            .methodBuilder( "delete" )
            .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
            .addParameter( keyParam )
            .returns( TypeName.BOOLEAN );
        maybeAddJavadoc( getDocumentationElement( definitionName, "delete" ), delete );
        type.addMethod( delete.build() );

        testType.addMethod( MethodSpec
                              .methodBuilder( "delete" )
                              .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                              .addParameter( ParameterSpec.builder( className, "$instance" ).build() )
                              .addParameter( ParameterSpec.builder( keyType, "key" ).build() )
                              .returns( TypeName.BOOLEAN )
                              .addStatement( "return $N.$N( key )", "$instance", "delete" )
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
        final MethodSpec.Builder clear =
          MethodSpec
            .methodBuilder( "clear" )
            .addModifiers( Modifier.PUBLIC, Modifier.NATIVE );
        maybeAddJavadoc( getDocumentationElement( definitionName, "clear" ), clear );
        type.addMethod( clear.build() );

        testType.addMethod( MethodSpec
                              .methodBuilder( "clear" )
                              .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                              .addParameter( ParameterSpec.builder( className, "$instance" ).build() )
                              .addStatement( "$N.$N()", "$instance", "clear" )
                              .build() );
      }
    }
  }

  private void completeEntryAccessorMethod( @Nonnull final MethodSpec.Builder method,
                                            @Nonnull final TypeName type,
                                            final int index )
  {
    // This code assumes that keys and values are non-nullable and this is true with current
    // set of specs so we can deal with nullability when/if it is required
    if ( !type.isPrimitive() )
    {
      method.addAnnotation( BasicTypes.NONNULL );
    }
    method.addStatement( "return getAtAsAny( " + index + " ).$N()", getJsAccessor( type ) );
  }

  @Nonnull
  private String getJsAccessor( @Nonnull final TypeName type )
  {
    if ( TypeName.BOOLEAN == type )
    {
      return "asBoolean";
    }
    else if ( TypeName.BYTE == type )
    {
      return "asByte";
    }
    else if ( TypeName.CHAR == type )
    {
      return "asChar";
    }
    else if ( TypeName.SHORT == type )
    {
      return "asShort";
    }
    else if ( TypeName.INT == type )
    {
      return "asInt";
    }
    else if ( TypeName.LONG == type )
    {
      return "asLong";
    }
    else if ( TypeName.FLOAT == type )
    {
      return "asFloat";
    }
    else if ( TypeName.DOUBLE == type )
    {
      return "asDouble";
    }
    else if ( BasicTypes.STRING.equals( type ) )
    {
      return "asString";
    }
    else
    {
      return "cast";
    }
  }

  private void generateEntry( @Nonnull final String keyMethodName,
                              @Nonnull final TypeName keyType,
                              @Nonnull final TypeName valueType,
                              @Nonnull final TypeSpec.Builder type )
  {
    final MethodSpec.Builder keyMethod =
      MethodSpec
        .methodBuilder( keyMethodName )
        .addModifiers( Modifier.PUBLIC )
        .addAnnotation( JsinteropTypes.JS_OVERLAY )
        .returns( keyType );
    completeEntryAccessorMethod( keyMethod, keyType, 0 );

    final MethodSpec.Builder valueMethod =
      MethodSpec
        .methodBuilder( "value" )
        .addModifiers( Modifier.PUBLIC )
        .addAnnotation( JsinteropTypes.JS_OVERLAY )
        .returns( valueType );
    completeEntryAccessorMethod( valueMethod, valueType, 1 );

    type.addType( TypeSpec
                    .classBuilder( "Entry" )
                    .addModifiers( Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL )
                    .superclass( ParameterizedTypeName.get( lookupClassName( Kind.Sequence.name() ),
                                                            TypeName.OBJECT ) )
                    .addAnnotation( AnnotationSpec
                                      .builder( JsinteropTypes.JS_TYPE )
                                      .addMember( "isNative", "true" )
                                      .addMember( "namespace", "$T.GLOBAL", JsinteropTypes.JS_PACKAGE )
                                      .addMember( "name", "$S", "Array" )
                                      .build() )
                    .addMethod( keyMethod.build() )
                    .addMethod( valueMethod.build() ).build() );
  }

  private void addNullabilityAnnotationIfRequired( @Nonnull final Type type,
                                                   @Nonnull final ParameterSpec.Builder builder )
  {
    final WebIDLSchema schema = getSchema();
    if ( schema.isNullable( type ) )
    {
      builder.addAnnotation( JsinteropTypes.JS_NULLABLE );
    }
    else if ( !schema.resolveType( type ).getKind().isPrimitive() )
    {
      builder.addAnnotation( JsinteropTypes.JS_NONNULL );
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
                         .builder( TypeName.BOOLEAN, "useCapture", Modifier.FINAL )
                         .build() )
        .addStatement( "addEventListener( $S, $T.cast( callback ), useCapture )", eventName, JsinteropTypes.JS );
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
                         .builder( TypeName.BOOLEAN, "useCapture", Modifier.FINAL )
                         .build() )
        .addStatement( "removeEventListener( $S, $T.cast( callback ), useCapture )", eventName, JsinteropTypes.JS );
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
    if ( OutputType.gwt == _outputType &&
         definition.isNoArgsExtendedAttributePresent( ExtendedAttributes.LEGACY_NO_INTERFACE_OBJECT ) )
    {
      return "Object";
    }
    else
    {
      final String namespace = definition.getNamespace();
      return ( null == namespace ? "" : namespace + "." ) + toJsName( definition );
    }
  }

  private void generateReadOnlyAttribute( @Nonnull final NamedDefinition definition,
                                          @Nonnull final AttributeMember attribute,
                                          @Nonnull final ClassName className,
                                          @Nonnull final TypeSpec.Builder type,
                                          @Nonnull final TypeSpec.Builder testType )
  {
    assert attribute.getModifiers().contains( AttributeMember.Modifier.READ_ONLY );
    if ( attribute.isNoArgsExtendedAttributePresent( ExtendedAttributes.OPTIONAL_SUPPORT ) ||
         null != attribute.getIdentValue( ExtendedAttributes.OPTIONAL_SUPPORT ) )
    {
      if ( attribute.getModifiers().contains( AttributeMember.Modifier.STATIC ) )
      {
        throw new UnsupportedOperationException( "Optional attribute guards not supported on static attributes" );
      }
      generateOptionalSupportGuard( definition, attribute.getName(), attribute, className, type, testType );
    }
    final Type attributeType = attribute.getType();
    final WebIDLSchema schema = getSchema();
    final Type actualType = schema.resolveType( attributeType );
    final String name = attribute.getName();
    final TypeName actualJavaType = toTypeName( actualType );
    final String javaName = safeJsPropertyMethodName( name, TypeName.BOOLEAN.equals( actualJavaType ) );
    final MethodSpec.Builder method =
      MethodSpec
        .methodBuilder( javaName )
        .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
        .returns( actualJavaType )
        .addAnnotation( AnnotationSpec
                          .builder( JsinteropTypes.JS_PROPERTY )
                          .addMember( "name", "$S", toJsName( attribute ) )
                          .build() );
    maybeAddCustomAnnotations( attribute, method );
    maybeAddJavadoc( attribute, method );

    final MethodSpec.Builder testMethod =
      MethodSpec
        .methodBuilder( javaName )
        .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
        .returns( actualJavaType );

    final DocumentationElement documentation = attribute.getDocumentation();
    if ( null != documentation && documentation.hasDeprecatedTag() )
    {
      testMethod.addAnnotation( Deprecated.class );
    }

    if ( attribute.getModifiers().contains( AttributeMember.Modifier.STATIC ) )
    {
      method.addModifiers( Modifier.STATIC );
      testMethod.addStatement( "return $T.$N()", className, javaName );
    }
    else
    {
      testMethod.addParameter( ParameterSpec.builder( className, "type", Modifier.FINAL ).build() );
      testMethod.addStatement( "return type.$N()", javaName );
    }
    if ( schema.isNullable( attributeType ) )
    {
      method.addAnnotation( BasicTypes.NULLABLE );
    }
    else if ( !actualJavaType.isPrimitive() )
    {
      method.addAnnotation( BasicTypes.NONNULL );
    }
    addMagicConstantAnnotationIfNeeded( actualType, method );
    type.addMethod( method.build() );

    testType.addMethod( testMethod.build() );
  }

  private void generateReadWriteAttribute( @Nonnull final AttributeMember attribute,
                                           @Nonnull final ClassName className,
                                           @Nonnull final TypeSpec.Builder type,
                                           @Nonnull final TypeSpec.Builder testType )
  {
    assert !attribute.getModifiers().contains( AttributeMember.Modifier.READ_ONLY );
    final Type attributeType = attribute.getType();
    final WebIDLSchema schema = getSchema();
    final Type actualType = schema.resolveType( attributeType );
    final TypeName actualJavaType = toTypeName( actualType );
    final String jsName = toJsName( attribute );
    final String fieldName = javaName( attribute );
    final FieldSpec.Builder field =
      FieldSpec.builder( actualJavaType, fieldName, Modifier.PUBLIC );
    maybeAddCustomAnnotations( attribute, field );
    maybeAddJavadoc( attribute, field );

    final MethodSpec.Builder testReadMethod =
      MethodSpec
        .methodBuilder( fieldName )
        .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
        .returns( actualJavaType );
    final MethodSpec.Builder testWriteMethod =
      MethodSpec
        .methodBuilder( fieldName )
        .addModifiers( Modifier.PUBLIC, Modifier.STATIC );
    final DocumentationElement documentation = attribute.getDocumentation();
    if ( null != documentation && documentation.hasDeprecatedTag() )
    {
      testReadMethod.addAnnotation( Deprecated.class );
      testWriteMethod.addAnnotation( Deprecated.class );
    }

    if ( !fieldName.equals( jsName ) )
    {
      field.addAnnotation( AnnotationSpec.builder( JsinteropTypes.JS_PROPERTY )
                             .addMember( "name", "$S", jsName )
                             .build() );
    }
    if ( attribute.getModifiers().contains( AttributeMember.Modifier.STATIC ) )
    {
      field.addModifiers( Modifier.STATIC );
      testReadMethod.addStatement( "return $T.$N", className, fieldName );
      testWriteMethod.addStatement( "$T.$N = value", className, fieldName );
    }
    else
    {
      testReadMethod.addParameter( ParameterSpec.builder( className, "type", Modifier.FINAL ).build() );
      testReadMethod.addStatement( "return type.$N", fieldName );
      testWriteMethod.addParameter( ParameterSpec.builder( className, "type", Modifier.FINAL ).build() );
      testWriteMethod.addStatement( "type.$N = value", fieldName );
    }
    testWriteMethod.addParameter( ParameterSpec.builder( actualJavaType, "value", Modifier.FINAL ).build() );

    if ( schema.isNullable( attributeType ) )
    {
      field.addAnnotation( JsinteropTypes.JS_NULLABLE );
    }
    else if ( !actualType.getKind().isPrimitive() )
    {
      field.addAnnotation( JsinteropTypes.JS_NONNULL );
    }
    addMagicConstantAnnotationIfNeeded( actualType, field );
    type.addField( field.build() );

    testType.addMethod( testReadMethod.build() );
    testType.addMethod( testWriteMethod.build() );
  }

  private void generateConstants( @Nonnull final String jsTypeName,
                                  @Nonnull final List<ConstMember> constants,
                                  @Nonnull final TypeSpec.Builder type )
  {
    final List<ConstMember> noInlineConstants =
      constants
        .stream()
        .filter( constant -> constant.isNoArgsExtendedAttributePresent( ExtendedAttributes.JAVA_NO_INLINE ) )
        .sorted( Comparator.comparing( NamedElement::getName ) )
        .collect( Collectors.toList() );

    if ( !noInlineConstants.isEmpty() )
    {
      final TypeSpec.Builder constantType =
        TypeSpec
          .classBuilder( "Constants" )
          .addModifiers( Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL )
          .addAnnotation( AnnotationSpec
                            .builder( JsinteropTypes.JS_TYPE )
                            .addMember( "isNative", "true" )
                            .addMember( "name", "$S", jsTypeName )
                            .addMember( "namespace", "$T.GLOBAL", JsinteropTypes.JS_PACKAGE )
                            .build() );
      for ( final ConstMember constant : noInlineConstants )
      {
        final String name = constant.getName();
        final String jsName = toJsName( constant );
        final FieldSpec.Builder field =
          FieldSpec
            .builder( toTypeName( getSchema().resolveType( constant.getType() ) ),
                      name,
                      Modifier.PRIVATE,
                      Modifier.STATIC );
        if ( !name.equals( jsName ) )
        {
          field.addAnnotation( AnnotationSpec
                                 .builder( JsinteropTypes.JS_PROPERTY )
                                 .addMember( "name", "$S", jsName )
                                 .build() );
        }
        constantType.addField( field.build() );
      }
      type.addType( constantType.build() );
    }

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

    maybeAddCustomAnnotations( constant, field );
    maybeAddJavadoc( constant, field );

    if ( constant.isNoArgsExtendedAttributePresent( ExtendedAttributes.JAVA_NO_INLINE ) )
    {
      field.initializer( "$T.$N", ClassName.bestGuess( "Constants" ), constant.getName() );
    }
    else
    {
      final ConstValue value = constant.getValue();
      final ConstValue.Kind kind = value.getKind();
      if ( ConstValue.Kind.String == kind )
      {
        field.initializer( "$S", value.getValue() );
      }
      else if ( ConstValue.Kind.True == kind )
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
    }
    type.addField( field.build() );
  }

  private void generateDefaultOperation( @Nonnull final NamedDefinition definition,
                                         @Nonnull final OperationMember operation,
                                         @Nonnull final Type returnType,
                                         @Nonnull final ClassName className,
                                         @Nonnull final TypeSpec.Builder type,
                                         @Nonnull final TypeSpec.Builder testType )
  {
    if ( operation.isNoArgsExtendedAttributePresent( ExtendedAttributes.OPTIONAL_SUPPORT ) ||
         null != operation.getIdentValue( ExtendedAttributes.OPTIONAL_SUPPORT ) )
    {
      final String name = operation.getName();
      assert null != name;
      generateOptionalSupportGuard( definition, name, operation, className, type, testType );
    }

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
        generateDefaultOperation(
          operation,
          false,
          returnType,
          argumentList,
          typeList,
          className,
          type,
          testType );
      }
    }
  }

  private void generateDefaultOperation( @Nonnull final OperationMember operation,
                                         final boolean javaInterface,
                                         @Nonnull final Type returnType,
                                         @Nonnull final List<Argument> arguments,
                                         @Nonnull final List<TypedValue> typeList,
                                         @Nonnull final ClassName className,
                                         @Nonnull final TypeSpec.Builder type,
                                         @Nonnull final TypeSpec.Builder testType )
  {
    final boolean requireOverlay = OutputType.j2cl == _outputType && !operation.getReturnType().equals( returnType );

    // Codegen does not currently support requiring overlays on java interfaces.
    // We could add that later if ever needed
    assert !requireOverlay || !javaInterface;

    final OperationMember.Kind operationKind = operation.getKind();
    assert OperationMember.Kind.STATIC != operationKind && OperationMember.Kind.CONSTRUCTOR != operationKind;
    final String name = operation.getName();
    final String jsName = toJsName( operation );
    assert null != name;
    assert null != jsName;

    final String methodName = javaMethodName( name, operation );
    final MethodSpec.Builder method =
      MethodSpec
        .methodBuilder( ( requireOverlay ? "_" : "" ) + methodName )
        .addModifiers( Modifier.PUBLIC, javaInterface ? Modifier.ABSTRACT : Modifier.NATIVE );
    final MethodSpec.Builder overlayMethod =
      MethodSpec
        .methodBuilder( methodName )
        .addAnnotation( JsinteropTypes.JS_OVERLAY )
        .addModifiers( Modifier.PUBLIC, Modifier.FINAL );

    maybeAddCustomAnnotations( operation, requireOverlay ? overlayMethod : method );
    maybeAddJavadoc( operation, requireOverlay ? overlayMethod : method );

    if ( requireOverlay || !methodName.equals( jsName ) )
    {
      method.addAnnotation( AnnotationSpec.builder( JsinteropTypes.JS_METHOD )
                              .addMember( "name", "$S", jsName )
                              .build() );
    }
    if ( operation.isNoArgsExtendedAttributePresent( ExtendedAttributes.NO_SIDE_EFFECTS ) ||
         OperationMember.Kind.GETTER == operation.getKind() )
    {
      method.addAnnotation( JsinteropTypes.HAS_NO_SIDE_EFFECTS );
    }
    emitReturnType( operation, operation.getReturnType(), overlayMethod );
    emitReturnType( operation, returnType, method );

    final MethodSpec.Builder testMethod =
      MethodSpec
        .methodBuilder( methodName )
        .addModifiers( Modifier.PUBLIC, Modifier.STATIC );
    final DocumentationElement documentation = operation.getDocumentation();
    if ( null != documentation && documentation.hasDeprecatedTag() )
    {
      testMethod.addAnnotation( Deprecated.class );
    }
    emitTestReturnType( operation, operation.getReturnType(), testMethod );
    testMethod.addParameter( ParameterSpec.builder( className, "$instance", Modifier.FINAL ).build() );

    final StringBuilder overlayCallStatement = new StringBuilder();
    final List<Object> overlayCallArgs = new ArrayList<>();

    final StringBuilder testCallStatement = new StringBuilder();
    final List<Object> testCallArgs = new ArrayList<>();
    if ( Kind.Void != operation.getReturnType().getKind() )
    {
      overlayCallStatement.append( "return " );
      testCallStatement.append( "return " );
    }
    final Type actualReturnType = operation.getReturnType();
    final Kind kind = actualReturnType.getKind();
    if ( requireOverlay )
    {
      if ( Kind.TypeReference == kind )
      {
        overlayCallStatement.append( "$T.uncheckedCast( " );
        overlayCallArgs.add( JsinteropTypes.JS );
      }
      else if ( Kind.Void != kind )
      {
        // This scenario does not exist atm so no need to expend effort to support scenario
        throw new IllegalStateException( "Synthesized union type consisting of more than just " +
                                         "type references is not supported" );
      }
    }
    overlayCallStatement.append( "$N(" );
    overlayCallArgs.add( "_" + methodName );

    testCallStatement.append( "$N.$N(" );
    testCallArgs.add( "$instance" );
    testCallArgs.add( methodName );

    int index = 0;
    for ( final Argument argument : arguments )
    {
      if ( 0 == index )
      {
        overlayCallStatement.append( " " );
        testCallStatement.append( " " );
      }
      else
      {
        overlayCallStatement.append( ", " );
        testCallStatement.append( ", " );
      }
      overlayCallStatement.append( "$N" );
      overlayCallArgs.add( javaName( argument ) );

      testCallStatement.append( "$N" );
      testCallArgs.add( javaName( argument ) );
      final TypedValue typedValue = typeList.get( index++ );
      generateArgument( argument, typedValue, false, false, overlayMethod, null );
      generateArgument( argument, typedValue, false, false, method, testMethod );
    }
    type.addMethod( method.build() );

    if ( !arguments.isEmpty() )
    {
      overlayCallStatement.append( " " );
      testCallStatement.append( " " );
    }
    overlayCallStatement.append( ")" );
    testCallStatement.append( ")" );

    if ( requireOverlay && Kind.TypeReference == kind )
    {
      overlayCallStatement.append( " )" );
    }

    overlayMethod.addStatement( overlayCallStatement.toString(), overlayCallArgs.toArray() );
    if ( requireOverlay )
    {
      type.addMethod( overlayMethod.build() );
    }

    testMethod.addStatement( testCallStatement.toString(), testCallArgs.toArray() );
    testType.addMethod( testMethod.build() );
  }

  private void emitTestReturnType( @Nonnull final OperationMember operation,
                                   @Nonnull final Type returnType,
                                   @Nonnull final MethodSpec.Builder testMethod )
  {
    if ( Kind.Void != returnType.getKind() )
    {
      final Type actualType = getSchema().resolveType( returnType );
      final TypeName javaReturnType =
        Kind.Sequence == actualType.getKind() ?
        toSequenceType( (SequenceType) actualType, operation.getIdentValue( ExtendedAttributes.SEQUENCE_TYPE ) ) :
        toTypeName( returnType );
      testMethod.returns( javaReturnType );
    }
  }

  private void generateNamespaceOperation( @Nonnull final NamedDefinition definition,
                                           @Nonnull final OperationMember operation,
                                           @Nonnull final ClassName className,
                                           @Nonnull final TypeSpec.Builder type,
                                           @Nonnull final TypeSpec.Builder testType )
  {
    final String name = operation.getName();
    assert null != name;
    if ( operation.isNoArgsExtendedAttributePresent( ExtendedAttributes.OPTIONAL_SUPPORT ) ||
         null != operation.getIdentValue( ExtendedAttributes.OPTIONAL_SUPPORT ) )
    {
      if ( OperationMember.Kind.STATIC == operation.getKind() )
      {
        throw new UnsupportedOperationException( "Optional operation guards not supported on static operations" );
      }
      generateStaticOptionalSupportGuard( definition, operation, name, className, type, testType );
    }

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
        generateNamespaceOperation( operation, argumentList, typeList, className, type, testType );
      }
    }
  }

  private void generateNamespaceOperation( @Nonnull final OperationMember operation,
                                           @Nonnull final List<Argument> arguments,
                                           @Nonnull final List<TypedValue> typeList,
                                           @Nonnull final ClassName className,
                                           @Nonnull final TypeSpec.Builder type,
                                           @Nonnull final TypeSpec.Builder testType )
  {
    final String name = operation.getName();
    assert null != name;
    final String jsName = toJsName( operation );
    assert null != jsName;
    final String methodName = javaMethodName( name, operation );
    final MethodSpec.Builder method =
      MethodSpec
        .methodBuilder( methodName )
        .addModifiers( Modifier.PUBLIC, Modifier.STATIC, Modifier.NATIVE );
    maybeAddCustomAnnotations( operation, method );
    maybeAddJavadoc( operation, method );
    if ( !methodName.equals( jsName ) )
    {
      method.addAnnotation( AnnotationSpec.builder( JsinteropTypes.JS_METHOD )
                              .addMember( "name", "$S", jsName )
                              .build() );
    }
    if ( operation.isNoArgsExtendedAttributePresent( ExtendedAttributes.NO_SIDE_EFFECTS ) ||
         OperationMember.Kind.GETTER == operation.getKind() )
    {
      method.addAnnotation( JsinteropTypes.HAS_NO_SIDE_EFFECTS );
    }
    final Type returnType = operation.getReturnType();
    emitReturnType( operation, returnType, method );

    final MethodSpec.Builder testMethod =
      MethodSpec
        .methodBuilder( methodName ).addModifiers( Modifier.PUBLIC, Modifier.STATIC );
    final DocumentationElement documentation = operation.getDocumentation();
    if ( null != documentation && documentation.hasDeprecatedTag() )
    {
      testMethod.addAnnotation( Deprecated.class );
    }

    emitTestReturnType( operation, returnType, testMethod );

    final StringBuilder testCallStatement = new StringBuilder();
    final List<Object> testCallArgs = new ArrayList<>();
    if ( Kind.Void != returnType.getKind() )
    {
      testCallStatement.append( "return " );
    }
    testCallStatement.append( "$T.$N(" );
    testCallArgs.add( className );
    testCallArgs.add( methodName );

    int index = 0;
    for ( final Argument argument : arguments )
    {
      if ( 0 == index )
      {
        testCallStatement.append( " " );
      }
      else
      {
        testCallStatement.append( ", " );
      }
      testCallStatement.append( "$N" );
      testCallArgs.add( javaName( argument ) );
      final TypedValue typedValue = typeList.get( index++ );
      generateArgument( argument, typedValue, false, false, method, testMethod );
    }
    type.addMethod( method.build() );

    if ( !arguments.isEmpty() )
    {
      testCallStatement.append( " " );
    }
    testCallStatement.append( ")" );

    testMethod.addStatement( testCallStatement.toString(), testCallArgs.toArray() );
    testType.addMethod( testMethod.build() );
  }

  private void generateAnonymousIndexedGetter( @Nonnull final OperationMember operation,
                                               @Nonnull final TypeSpec.Builder type )
  {
    final OperationMember.Kind operationKind = operation.getKind();
    assert OperationMember.Kind.GETTER == operationKind;
    assert null == operation.getName();
    final List<Argument> arguments = operation.getArguments();
    assert 1 == arguments.size();
    final MethodSpec.Builder method =
      MethodSpec
        .methodBuilder( javaMethodName( "getAt", operation ) )
        .addModifiers( Modifier.PUBLIC, Modifier.FINAL );
    maybeAddCustomAnnotations( operation, method );
    maybeAddJavadoc( operation, method );
    method.addAnnotation( AnnotationSpec.builder( JsinteropTypes.JS_OVERLAY ).build() );
    final Type itemType = operation.getReturnType();
    emitReturnType( operation, itemType, method );
    final Argument argument = arguments.get( 0 );
    generateArgument( argument, asTypedValue( argument.getType() ), true, false, method );
    final Kind itemTypeKind = itemType.getKind();
    final boolean mustConvert =
      itemTypeKind.isPrimitive() && Kind.Double != itemTypeKind && Kind.UnrestrictedDouble != itemTypeKind;
    final TypeName itemTypeName = mustConvert ? JsinteropTypes.ANY : toTypeName( itemType, true );
    final String suffix =
      !mustConvert ? "" :
      Kind.Float == itemTypeKind || Kind.UnrestrictedFloat == itemTypeKind ? ".asFloat()" :
      Kind.Octet == itemTypeKind || Kind.Short == itemTypeKind ? ".asShort()" :
      Kind.UnsignedShort == itemTypeKind ||
      Kind.Long == itemTypeKind ||
      Kind.UnsignedLong == itemTypeKind ||
      Kind.LongLong == itemTypeKind ||
      Kind.UnsignedLongLong == itemTypeKind ? ".asInt()" :
      Kind.Boolean == itemTypeKind ? ".asBoolean()" :
      Kind.Byte == itemTypeKind ? ".asByte()" :
      "";
    method.addStatement( "return $T.<$T>cast( this ).getAt( $N )" + suffix,
                         JsinteropTypes.JS,
                         ParameterizedTypeName.get( JsinteropTypes.JS_ARRAY_LIKE, itemTypeName ),
                         argument.getName() );
    type.addMethod( method.build() );
  }

  private void generateAnonymousIndexedSetter( @Nonnull final OperationMember operation,
                                               @Nonnull final TypeSpec.Builder type )
  {
    final OperationMember.Kind operationKind = operation.getKind();
    assert OperationMember.Kind.SETTER == operationKind;
    assert null == operation.getName();
    final List<Argument> arguments = operation.getArguments();
    assert 2 == arguments.size();
    final MethodSpec.Builder method =
      MethodSpec
        .methodBuilder( javaMethodName( "setAt", operation ) )
        .addModifiers( Modifier.PUBLIC, Modifier.FINAL );
    maybeAddCustomAnnotations( operation, method );
    maybeAddJavadoc( operation, method );
    method.addAnnotation( AnnotationSpec.builder( JsinteropTypes.JS_OVERLAY ).build() );
    final Argument indexArgument = arguments.get( 0 );
    generateArgument( indexArgument, asTypedValue( indexArgument.getType() ), true, false, method );

    final Argument valueArgument = arguments.get( 1 );
    generateArgument( valueArgument, asTypedValue( valueArgument.getType() ), true, false, method );

    method.addStatement( "$T.<$T>cast( this ).setAt( $N, $N )",
                         JsinteropTypes.JS,
                         ParameterizedTypeName.get( JsinteropTypes.JS_ARRAY_LIKE,
                                                    toTypeName( valueArgument.getType() ).box() ),
                         indexArgument.getName(),
                         valueArgument.getName() );
    type.addMethod( method.build() );
  }

  private void generateAnonymousNamedGetter( @Nonnull final OperationMember operation,
                                             @Nonnull final TypeSpec.Builder type )
  {
    final OperationMember.Kind operationKind = operation.getKind();
    assert OperationMember.Kind.GETTER == operationKind;
    assert null == operation.getName();
    final List<Argument> arguments = operation.getArguments();
    assert 1 == arguments.size();
    final MethodSpec.Builder method =
      MethodSpec
        .methodBuilder( javaMethodName( "get", operation ) )
        .addModifiers( Modifier.PUBLIC, Modifier.FINAL );
    maybeAddCustomAnnotations( operation, method );
    maybeAddJavadoc( operation, method );
    method.addAnnotation( AnnotationSpec.builder( JsinteropTypes.JS_OVERLAY ).build() );
    final Type itemType = operation.getReturnType();
    emitReturnType( operation, itemType, method );
    final Argument argument = arguments.get( 0 );
    generateArgument( argument, asTypedValue( argument.getType() ), true, false, method );
    final Kind itemTypeKind = itemType.getKind();
    final boolean mustConvert =
      itemTypeKind.isPrimitive() && Kind.Double != itemTypeKind && Kind.UnrestrictedDouble != itemTypeKind;
    final TypeName itemTypeName = mustConvert ? JsinteropTypes.ANY : toTypeName( itemType, true );
    final String suffix =
      !mustConvert ? "" :
      Kind.Float == itemTypeKind || Kind.UnrestrictedFloat == itemTypeKind ? ".asFloat()" :
      Kind.Octet == itemTypeKind || Kind.Short == itemTypeKind ? ".asShort()" :
      Kind.UnsignedShort == itemTypeKind ||
      Kind.Long == itemTypeKind ||
      Kind.UnsignedLong == itemTypeKind ||
      Kind.LongLong == itemTypeKind ||
      Kind.UnsignedLongLong == itemTypeKind ? ".asInt()" :
      Kind.Boolean == itemTypeKind ? ".asBoolean()" :
      Kind.Byte == itemTypeKind ? ".asByte()" :
      "";
    method.addStatement( "return $T.<$T>cast( this ).get( $N )" + suffix,
                         JsinteropTypes.JS,
                         ParameterizedTypeName.get( JsinteropTypes.JS_PROPERTY_MAP, itemTypeName ),
                         argument.getName() );
    type.addMethod( method.build() );
  }

  private void generateAnonymousNamedSetter( @Nonnull final OperationMember operation,
                                             @Nonnull final TypeSpec.Builder type )
  {
    final OperationMember.Kind operationKind = operation.getKind();
    assert OperationMember.Kind.SETTER == operationKind;
    assert null == operation.getName();
    final List<Argument> arguments = operation.getArguments();
    assert 2 == arguments.size();
    final MethodSpec.Builder method =
      MethodSpec
        .methodBuilder( javaMethodName( "set", operation ) )
        .addModifiers( Modifier.PUBLIC, Modifier.FINAL );
    maybeAddCustomAnnotations( operation, method );
    maybeAddJavadoc( operation, method );
    method.addAnnotation( AnnotationSpec.builder( JsinteropTypes.JS_OVERLAY ).build() );
    final Argument indexArgument = arguments.get( 0 );
    generateArgument( indexArgument, asTypedValue( indexArgument.getType() ), true, false, method );

    final Argument valueArgument = arguments.get( 1 );
    generateArgument( valueArgument, asTypedValue( valueArgument.getType() ), true, false, method );

    method.addStatement( "$T.<$T>cast( this ).set( $N, $N )",
                         JsinteropTypes.JS,
                         ParameterizedTypeName.get( JsinteropTypes.JS_PROPERTY_MAP,
                                                    toTypeName( valueArgument.getType() ).box() ),
                         indexArgument.getName(),
                         valueArgument.getName() );
    type.addMethod( method.build() );
  }

  private void generateAnonymousNamedDeleter( @Nonnull final OperationMember operation,
                                              @Nonnull final TypeSpec.Builder type )
  {
    final OperationMember.Kind operationKind = operation.getKind();
    assert OperationMember.Kind.DELETER == operationKind;
    assert null == operation.getName();
    final List<Argument> arguments = operation.getArguments();
    assert 1 == arguments.size();
    final MethodSpec.Builder method =
      MethodSpec
        .methodBuilder( javaMethodName( "delete", operation ) )
        .addModifiers( Modifier.PUBLIC, Modifier.FINAL );
    maybeAddCustomAnnotations( operation, method );
    maybeAddJavadoc( operation, method );
    method.addAnnotation( AnnotationSpec.builder( JsinteropTypes.JS_OVERLAY ).build() );
    final Argument argument = arguments.get( 0 );
    generateArgument( argument, asTypedValue( argument.getType() ), true, false, method );
    method.addStatement( "$T.<$T>cast( this ).delete( $N )",
                         JsinteropTypes.JS,
                         ParameterizedTypeName.get( JsinteropTypes.JS_PROPERTY_MAP,
                                                    WildcardTypeName.subtypeOf( TypeName.OBJECT ) ),
                         argument.getName() );
    type.addMethod( method.build() );
  }

  private void generateStaticOperation( @Nonnull final OperationMember operation,
                                        @Nonnull final ClassName className,
                                        @Nonnull final TypeSpec.Builder type,
                                        @Nonnull final TypeSpec.Builder testType )
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
        generateStaticOperation( operation, argumentList, typeList, className, type, testType );
      }
    }
  }

  private void generateStaticOperation( @Nonnull final OperationMember operation,
                                        @Nonnull final List<Argument> arguments,
                                        @Nonnull final List<TypedValue> typeList,
                                        @Nonnull final ClassName className,
                                        @Nonnull final TypeSpec.Builder type,
                                        @Nonnull final TypeSpec.Builder testType )
  {
    assert OperationMember.Kind.STATIC == operation.getKind();
    final String name = operation.getName();
    final String jsName = toJsName( operation );
    assert null != name;
    assert null != jsName;
    final String methodName = javaMethodName( name, operation );
    final MethodSpec.Builder method =
      MethodSpec
        .methodBuilder( methodName )
        .addModifiers( Modifier.PUBLIC, Modifier.STATIC, Modifier.NATIVE );
    maybeAddCustomAnnotations( operation, method );
    maybeAddJavadoc( operation, method );
    if ( !methodName.equals( jsName ) )
    {
      method.addAnnotation( AnnotationSpec.builder( JsinteropTypes.JS_METHOD )
                              .addMember( "name", "$S", jsName )
                              .build() );
    }
    final Type returnType = operation.getReturnType();
    emitReturnType( operation, returnType, method );

    final MethodSpec.Builder testMethod =
      MethodSpec
        .methodBuilder( methodName ).addModifiers( Modifier.PUBLIC, Modifier.STATIC );
    final DocumentationElement documentation = operation.getDocumentation();
    if ( null != documentation && documentation.hasDeprecatedTag() )
    {
      testMethod.addAnnotation( Deprecated.class );
    }

    emitTestReturnType( operation, returnType, testMethod );

    final StringBuilder testCallStatement = new StringBuilder();
    final List<Object> testCallArgs = new ArrayList<>();
    if ( Kind.Void != returnType.getKind() )
    {
      testCallStatement.append( "return " );
    }
    testCallStatement.append( "$T.$N(" );
    testCallArgs.add( className );
    testCallArgs.add( methodName );

    int index = 0;
    for ( final Argument argument : arguments )
    {
      if ( 0 == index )
      {
        testCallStatement.append( " " );
      }
      else
      {
        testCallStatement.append( ", " );
      }
      testCallStatement.append( "$N" );
      testCallArgs.add( javaName( argument ) );
      generateArgument( argument, typeList.get( index++ ), false, false, method, testMethod );
    }
    type.addMethod( method.build() );

    if ( !arguments.isEmpty() )
    {
      testCallStatement.append( " " );
    }
    testCallStatement.append( ")" );

    testMethod.addStatement( testCallStatement.toString(), testCallArgs.toArray() );
    testType.addMethod( testMethod.build() );
  }

  private void emitReturnType( @Nonnull final AttributedNode operation,
                               @Nonnull final Type returnType,
                               @Nonnull final MethodSpec.Builder method )
  {
    if ( Kind.Void != returnType.getKind() )
    {
      addMagicConstantAnnotationIfNeeded( returnType, method );
      final Type actualType = getSchema().resolveType( returnType );
      if ( getSchema().isNullable( returnType ) )
      {
        method.addAnnotation( JsinteropTypes.JS_NULLABLE );
      }
      else if ( !actualType.getKind().isPrimitive() )
      {
        method.addAnnotation( JsinteropTypes.JS_NONNULL );
      }
      final TypeName type =
        Kind.Sequence == actualType.getKind() ?
        toSequenceType( (SequenceType) actualType, operation.getIdentValue( ExtendedAttributes.SEQUENCE_TYPE ) ) :
        toTypeName( returnType );
      method.returns( type );
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
    maybeAddCustomAnnotations( operation, method );
    maybeAddJavadoc( operation, method );
    int index = 0;
    for ( final Argument argument : argumentList )
    {
      generateArgument( argument, typeList.get( index++ ), true, false, method );
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
                                 final boolean applyJsOptional,
                                 @Nonnull final MethodSpec.Builder method )
  {
    generateArgument( argument, typedValue, isFinal, applyJsOptional, method, null );
  }

  private void generateArgument( @Nonnull final Argument argument,
                                 @Nonnull final TypedValue typedValue,
                                 final boolean isFinal,
                                 final boolean applyJsOptional,
                                 @Nonnull final MethodSpec.Builder method,
                                 @Nullable final MethodSpec.Builder testMethod )
  {
    final Type actualType = getSchema().resolveType( argument.getType() );
    final TypeName type = typedValue.getJavaType();
    final String argumentName = javaName( argument );
    final TypeName argumentType = argument.isVariadic() ? asArrayType( type ) : type;
    final ParameterSpec.Builder parameter = ParameterSpec.builder( argumentType, argumentName );
    final ParameterSpec.Builder testParameter =
      null != testMethod ? ParameterSpec.builder( argumentType, argumentName ).addModifiers( Modifier.FINAL ) : null;
    if ( isFinal )
    {
      parameter.addModifiers( Modifier.FINAL );
    }
    maybeAddCustomAnnotations( argument, parameter );
    addMagicConstantAnnotationIfNeeded( actualType, parameter );
    addDoNotAutoboxAnnotation( typedValue, parameter );
    addNullabilityAnnotation( typedValue, parameter );
    if ( applyJsOptional && argument.isOptional() )
    {
      parameter.addAnnotation( JsinteropTypes.JS_OPTIONAL );
    }
    // Only the last argument can be variadic
    if ( argument.isVariadic() )
    {
      method.varargs();
    }
    method.addParameter( parameter.build() );
    if ( null != testParameter )
    {
      addDoNotAutoboxAnnotation( typedValue, testParameter );
      addMagicConstantAnnotationIfNeeded( actualType, testParameter );
      testMethod.addParameter( testParameter.build() );
    }
  }

  private void generateEnumeration( @Nonnull final EnumerationDefinition definition )
    throws IOException
  {
    final String name = definition.getName();
    final ClassName self = lookupClassName( name );
    final TypeSpec.Builder type =
      TypeSpec
        .annotationBuilder( self.simpleName() )
        .addModifiers( Modifier.PUBLIC );
    writeGeneratedAnnotation( type );
    maybeAddCustomAnnotations( definition, type );
    maybeAddJavadoc( definition, type );
    type.addAnnotation( Documented.class );
    type.addAnnotation( AnnotationSpec
                          .builder( BasicTypes.MAGIC_CONSTANT )
                          .addMember( "valuesFromClass", "$T.class", self )
                          .build() );

    for ( final EnumerationValue enumerationValue : definition.getValues() )
    {
      if ( enumerationValue.getValue().isEmpty() &&
           null == enumerationValue.getIdentValue( ExtendedAttributes.JAVA_NAME ) )
      {
        throw new IllegalStateException( "Enumeration named '" + name + "' " +
                                         "has an empty enumeration value without specifying " +
                                         "the [JavaName=...] extended attribute so the Jsinterop " +
                                         "action can not determine a valid name for the value" );
      }
      final String value = javaName( enumerationValue );
      if ( !value.isEmpty() )
      {
        final FieldSpec.Builder field =
          FieldSpec
            .builder( BasicTypes.STRING, value, Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL )
            .addAnnotation( BasicTypes.NONNULL )
            .initializer( "$S", enumerationValue.getValue() );
        maybeAddCustomAnnotations( enumerationValue, field );
        maybeAddJavadoc( enumerationValue.getDocumentation(), field );
        type.addField( field.build() );
      }
    }

    final List<Object> params = new ArrayList<>();
    final String test =
      definition
        .getValues()
        .stream()
        .map( this::javaName )
        .filter( v -> !v.isEmpty() )
        .peek( v -> params.add( self ) )
        .peek( params::add )
        .map( v -> "$T.$N.equals( value )" )
        .collect( Collectors.joining( " || " ) );

    type.addType( TypeSpec
                    .classBuilder( "Util" )
                    .addModifiers( Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL )
                    .addMethod( MethodSpec.constructorBuilder().addModifiers( Modifier.PRIVATE ).build() )
                    .addMethod( MethodSpec
                                  .methodBuilder( "requireValid" )
                                  .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                                  .addAnnotation( self )
                                  .addParameter( ParameterSpec
                                                   .builder( BasicTypes.STRING, "value", Modifier.FINAL )
                                                   .build() )
                                  .addStatement( "assertValid( value )" )
                                  .addStatement( "return value" )
                                  .returns( BasicTypes.STRING )
                                  .build() )
                    .addMethod( MethodSpec
                                  .methodBuilder( "assertValid" )
                                  .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                                  .addParameter( ParameterSpec
                                                   .builder( BasicTypes.STRING, "value", Modifier.FINAL )
                                                   .addAnnotation( BasicTypes.NONNULL )
                                                   .build() )
                                  .addStatement( "assert isValid( value )" )
                                  .build() )
                    .addMethod( MethodSpec
                                  .methodBuilder( "isValid" )
                                  .returns( TypeName.BOOLEAN )
                                  .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                                  .addParameter( ParameterSpec
                                                   .builder( BasicTypes.STRING, "value", Modifier.FINAL )
                                                   .addAnnotation( BasicTypes.NONNULL )
                                                   .build() )
                                  .addStatement( "return " + test, params.toArray() )
                                  .build() )
                    .build() );

    writeTopLevelType( name, type );
  }

  private void maybeAddCustomAnnotations( @Nonnull final AttributedNode node,
                                          @Nonnull final TypeSpec.Builder element )
  {
    getAnnotationStream( node ).forEach( element::addAnnotation );
  }

  private void maybeAddCustomAnnotations( @Nonnull final AttributedNode node,
                                          @Nonnull final FieldSpec.Builder element )
  {
    getAnnotationStream( node ).forEach( element::addAnnotation );
  }

  private void maybeAddCustomAnnotations( @Nonnull final AttributedNode node,
                                          @Nonnull final MethodSpec.Builder element )
  {
    getAnnotationStream( node ).forEach( element::addAnnotation );
  }

  private void maybeAddCustomAnnotations( @Nonnull final AttributedNode node,
                                          @Nonnull final ParameterSpec.Builder element )
  {
    getAnnotationStream( node ).forEach( element::addAnnotation );
  }

  @Nonnull
  private Stream<ClassName> getAnnotationStream( @Nonnull final AttributedNode element )
  {
    return element
      .getExtendedAttributes()
      .stream()
      .filter( a -> ExtendedAttribute.Kind.NAMED_STRING == a.getKind() &&
                    a.getName().equals( ExtendedAttributes.JAVA_ANNOTATION ) )
      .map( ExtendedAttribute::getValue )
      .map( ClassName::bestGuess );
  }

  private void maybeAddJavadoc( @Nonnull final Element element, @Nonnull final FieldSpec.Builder field )
  {
    maybeAddJavadoc( element.getDocumentation(), field );
  }

  private void maybeAddJavadoc( @Nonnull final Element element, @Nonnull final TypeSpec.Builder type )
  {
    maybeAddJavadoc( element.getDocumentation(), type );
  }

  private void maybeAddJavadoc( @Nonnull final Element element, @Nonnull final MethodSpec.Builder method )
  {
    maybeAddJavadoc( element.getDocumentation(), method );
  }

  private void maybeAddJavadoc( @Nullable final DocumentationElement documentation,
                                @Nonnull final TypeSpec.Builder type )
  {
    if ( null != documentation )
    {
      type.addJavadoc( asJavadoc( documentation ) );
      if ( documentation.hasDeprecatedTag() )
      {
        type.addAnnotation( Deprecated.class );
      }
    }
  }

  private void maybeAddJavadoc( @Nullable final DocumentationElement documentation,
                                @Nonnull final FieldSpec.Builder field )
  {
    if ( null != documentation )
    {
      field.addJavadoc( asJavadoc( documentation ) );
      if ( documentation.hasDeprecatedTag() )
      {
        field.addAnnotation( Deprecated.class );
      }
    }
  }

  private void maybeAddJavadoc( @Nullable final DocumentationElement documentation,
                                @Nonnull final MethodSpec.Builder method )
  {
    if ( null != documentation )
    {
      method.addJavadoc( asJavadoc( documentation ) );
      if ( documentation.hasDeprecatedTag() )
      {
        method.addAnnotation( Deprecated.class );
      }
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
      if ( 0 != docs.length() )
      {
        docs.append( "\n" );
      }
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
    schema.getEnumerations().forEach( this::registerDefinition );
    schema.getConstEnumerations().forEach( this::registerDefinition );
    schema.getInterfaces().forEach( this::registerDefinition );
    schema.getPartialInterfaces().forEach( this::registerDefinition );
    schema.getNamespaces().forEach( this::registerDefinition );
    for ( final String globalInterface : getGlobalInterfaces().keySet() )
    {
      final InterfaceDefinition global = schema.getInterfaceByName( globalInterface );
      final List<String> exposureSets = global.getExposureSet();
      if ( 1 != exposureSets.size() )
      {
        throw new UnsupportedOperationException( "Global interface " + globalInterface + " is expected to be " +
                                                 "in a single ExposureSet but is in " + exposureSets );
      }
      final String javaName = derivePackagePrefix( global ) + exposureSets.get( 0 ) + "Global";
      tryRegisterIdlToJavaTypeMapping( "$Global" + global.getName(), javaName );
    }
    if ( _generateGlobal )
    {
      tryRegisterIdlToJavaTypeMapping( "$Global", getPackageName() + ".Global" );
    }
  }

  private void registerDefinition( @Nonnull final NamedDefinition definition )
  {
    final String name = definition.getName();
    tryRegisterIdlToJavaTypeMapping( name, deriveJavaType( definition, "", "" ) );

    if ( isIdlTypeNotPredefined( name ) &&
         ( definition instanceof CallbackInterfaceDefinition ||
           definition instanceof DictionaryDefinition ||
           definition instanceof InterfaceDefinition ||
           definition instanceof NamespaceDefinition ) )
    {
      _modulesToRequireInCompileTest.add( lookupJavaType( name ) + ".$Overlay" );
    }
  }

  private void generateOptionalSupportGuard( @Nonnull final NamedDefinition definition,
                                             @Nonnull final String elementName,
                                             @Nonnull final AttributedNode element,
                                             @Nonnull final ClassName className,
                                             @Nonnull final TypeSpec.Builder type,
                                             @Nonnull final TypeSpec.Builder testType )
  {
    final String name = getOptionalSupportKey( elementName, element );
    final String methodName = "is" + name + "Supported";
    final MethodSpec.Builder method = MethodSpec
      .methodBuilder( methodName )
      .addModifiers( Modifier.PUBLIC, Modifier.FINAL )
      .returns( TypeName.BOOLEAN )
      .addAnnotation( JsinteropTypes.JS_OVERLAY );
    final String propertyName = deriveOptionalSupportCompileConstant( definition, elementName, element );
    if ( OutputType.gwt == _outputType )
    {
      method.addStatement( "return $S == $T.getProperty( $S ) ? true : " +
                           "$S == $T.getProperty( $S ) ? false : " +
                           "$T.asPropertyMap( this ).has( $S )",
                           "true",
                           System.class,
                           propertyName,
                           "false",
                           System.class,
                           propertyName,
                           JsinteropTypes.JS,
                           elementName );
    }
    else
    {
      method.addStatement( "return $S.equals( $T.getProperty( $S ) ) ? true : " +
                           "$S.equals( $T.getProperty( $S ) ) ? false : " +
                           "$T.asPropertyMap( this ).has( $S )",
                           "true",
                           System.class,
                           propertyName,
                           "false",
                           System.class,
                           propertyName,
                           JsinteropTypes.JS,
                           elementName );
    }
    type.addMethod( method.build() );

    testType.addMethod( MethodSpec
                          .methodBuilder( methodName )
                          .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                          .returns( TypeName.BOOLEAN )
                          .addParameter( ParameterSpec.builder( className, "type", Modifier.FINAL ).build() )
                          .addStatement( "return type.$N()", methodName )
                          .build() );
  }

  private void generateStaticOptionalSupportGuard( @Nonnull final NamedDefinition definition,
                                                   @Nonnull final AttributedNode element,
                                                   @Nonnull final String elementName,
                                                   @Nonnull final ClassName className,
                                                   @Nonnull final TypeSpec.Builder type,
                                                   @Nonnull final TypeSpec.Builder testType )
  {
    final String name = getOptionalSupportKey( elementName, element );
    final String methodName = "is" + name + "Supported";
    final MethodSpec.Builder method = MethodSpec
      .methodBuilder( methodName )
      .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
      .returns( TypeName.BOOLEAN )
      .addAnnotation( JsinteropTypes.JS_OVERLAY );
    final String propertyName = deriveOptionalSupportCompileConstant( definition, elementName, element );
    if ( OutputType.gwt == _outputType )
    {
      method.addStatement( "return $S == $T.getProperty( $S ) ? true : " +
                           "$S == $T.getProperty( $S ) ? false : " +
                           "$T.global().has( $S )",
                           "true",
                           System.class,
                           propertyName,
                           "false",
                           System.class,
                           propertyName,
                           JsinteropTypes.JS,
                           elementName );
    }
    else
    {
      method.addStatement( "return $S.equals( $T.getProperty( $S ) ) ? true : " +
                           "$S.equals( $T.getProperty( $S ) ) ? false : " +
                           "$T.global().has( $S )",
                           "true",
                           System.class,
                           propertyName,
                           "false",
                           System.class,
                           propertyName,
                           JsinteropTypes.JS,
                           elementName );
    }
    type.addMethod( method.build() );

    testType.addMethod( MethodSpec
                          .methodBuilder( methodName )
                          .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                          .returns( TypeName.BOOLEAN )
                          .addStatement( "return $T.$N()", className, methodName )
                          .build() );
  }

  @Nullable
  private String getOptionalSupportKey( @Nonnull final String elementName, @Nonnull final AttributedNode element )
  {
    return element.isNoArgsExtendedAttributePresent( ExtendedAttributes.OPTIONAL_SUPPORT ) ?
           elementName.substring( 0, 1 ).toUpperCase() + elementName.substring( 1 ) :
           element.getIdentValue( ExtendedAttributes.OPTIONAL_SUPPORT );
  }
}
