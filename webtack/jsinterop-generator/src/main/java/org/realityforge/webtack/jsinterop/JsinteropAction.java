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
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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
  @Nullable
  private final String _globalInterface;
  @Nonnull
  private final List<String> _gwtInherits;
  private final boolean _generateGwtModule;
  private final boolean _generateTypeCatalog;

  JsinteropAction( @Nonnull final PipelineContext context,
                   @Nonnull final Path outputDirectory,
                   @Nonnull final String packageName,
                   @Nullable final String globalInterface,
                   @Nonnull final List<Path> predefinedTypeMappingPaths,
                   @Nonnull final List<Path> externalTypeMappingPaths,
                   final boolean generateGwtModule,
                   @Nonnull final List<String> gwtInherits,
                   final boolean generateTypeCatalog,
                   final boolean enableMagicConstants )
  {
    super( context,
           outputDirectory,
           packageName,
           enableMagicConstants,
           predefinedTypeMappingPaths,
           externalTypeMappingPaths );
    _globalInterface = globalInterface;
    _generateGwtModule = generateGwtModule;
    _gwtInherits = Objects.requireNonNull( gwtInherits );
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
        final UnionType unionType = (UnionType) type;
        if ( isMarkerType( definition ) )
        {
          generateMarkerType( definition );
        }
        else
        {
          generateUnion( definition.getName(),
                         lookupClassName( definition.getName() ).simpleName(),
                         unionType,
                         getAnnotationStream( definition ).collect( Collectors.toList() ) );
        }
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
    for ( final ConstEnumerationDefinition definition : schema.getConstEnumerations() )
    {
      if ( !isIdlTypePredefined( definition.getName() ) )
      {
        generateConstEnumeration( definition );
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
    final List<NamespaceDefinition> namespacesGenerated = new ArrayList<>();
    for ( final NamespaceDefinition definition : schema.getNamespaces() )
    {
      if ( !isIdlTypePredefined( definition.getName() ) )
      {
        generateNamespace( definition );
        namespacesGenerated.add( definition );
      }
    }

    for ( final Map.Entry<String, UnionType> entry : getUnions().entrySet() )
    {
      final String name = entry.getKey();
      if ( !isIdlTypePredefined( name ) )
      {
        generateUnion( name, NamingUtil.uppercaseFirstCharacter( name ), entry.getValue(), Collections.emptyList() );
      }
    }

    if ( _generateGwtModule )
    {
      writeGwtModule();
    }

    if ( null != _globalInterface )
    {
      generateGlobalThisInterface( _globalInterface );
      generateGlobalThisAccessor( _globalInterface );
      for ( final NamespaceDefinition definition : namespacesGenerated )
      {
        generateStaticNamespace( definition );
      }
    }

    if ( _generateTypeCatalog )
    {
      writeTypeCatalog();
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

    final AnnotationSpec.Builder annotation = AnnotationSpec.builder( BasicTypes.MAGIC_CONSTANT );
    final List<ConstEnumerationValue> sortedConstants =
      definition
        .getValues()
        .stream()
        .sorted( ( o1, o2 ) -> sortByValue( isInteger, o1, o2 ) )
        .collect( Collectors.toList() );
    for ( final ConstEnumerationValue value : sortedConstants )
    {
      annotation.addMember( isInteger ? "intValues" : "stringValues",
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

  private void generateGlobalThisAccessor( @Nonnull final String globalInterface )
    throws IOException
  {
    final TypeSpec.Builder type =
      TypeSpec
        .classBuilder( lookupClassName( "$Global" ).simpleName() )
        .addModifiers( Modifier.PUBLIC, Modifier.FINAL );
    writeGeneratedAnnotation( type );

    type.addJavadoc( "Accessor for the global <b>globalThis</b> property also know as the global object.\n" +
                     "\n" +
                     "@see <a href=\"https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/globalThis\">globalThis - MDN</a>\n" );

    type.addMethod( MethodSpec.constructorBuilder().addModifiers( Modifier.PRIVATE ).build() );

    final TypeName globalType = lookupClassName( "$Global" + globalInterface );

    type.addField( FieldSpec
                     .builder( globalType, "globalThis", Modifier.PRIVATE, Modifier.STATIC )
                     .build() );

    type.addMethod( MethodSpec.methodBuilder( "globalThis" )
                      .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
                      .addAnnotation( BasicTypes.NONNULL )
                      .returns( globalType )
                      .addStatement( "return $T.uncheckedCast( $T.global() )", JsinteropTypes.JS, JsinteropTypes.JS )
                      .addJavadoc( "Accessor for the global <b>globalThis</b> property contains the global " +
                                   "<i>this</i> value, which is akin to the global object.\n" +
                                   "\n" +
                                   "@return the global object\n" +
                                   "@see <a href=\"https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/globalThis\">globalThis - MDN</a>\n" )
                      .build() );

    final WebIDLSchema schema = getSchema();
    InterfaceDefinition definition = schema.getInterfaceByName( globalInterface );
    while ( null != definition )
    {
      generateStaticAttributes( definition.getAttributes(), type, true );
      generateGlobalOperationsMethods( type, definition.getOperations() );
      generateGlobalEventsMethods( type, schema, definition.getEvents() );
      final String inherits = definition.getInherits();
      definition = null == inherits ? null : schema.getInterfaceByName( inherits );
    }

    for ( final MixinDefinition mixin : getGlobalMixins( schema ) )
    {
      generateStaticAttributes( mixin.getAttributes(), type, true );
      generateGlobalOperationsMethods( type, mixin.getOperations() );
      generateGlobalEventsMethods( type, schema, mixin.getEvents() );
    }

    for ( final NamespaceDefinition namespace : schema.getNamespaces() )
    {
      final String methodName = NamingUtil.camelCase( safeJsPropertyMethodName( namespace.getName(), false ) );
      final MethodSpec.Builder namespaceMethod =
        MethodSpec
          .methodBuilder( methodName )
          .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
          .returns( lookupClassName( namespace.getName() ) )
          .addAnnotation( BasicTypes.NONNULL )
          .addStatement( "return globalThis().$N()", methodName );
      final DocumentationElement documentation = namespace.getDocumentation();
      if ( null != documentation && documentation.hasDeprecatedTag() )
      {
        namespaceMethod.addAnnotation( Deprecated.class );
      }
      type.addMethod( namespaceMethod.build() );
    }

    writeTopLevelType( "$Global", type );
  }

  private void generateGlobalOperationsMethods( final TypeSpec.Builder type, final List<OperationMember> operations )
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
        generateDelegateOperation( operation, type, true );
      }
    }
  }

  private void generateGlobalEventsMethods( final TypeSpec.Builder type,
                                            final WebIDLSchema schema,
                                            final List<EventMember> events )
  {
    for ( final EventMember event : events )
    {
      final CallbackInterfaceDefinition callbackInterface =
        schema.findCallbackInterfaceByName( event.getEventType().getName() + "Listener" );
      if ( null != callbackInterface )
      {
        generateGlobalAddEventListener( event, 0, type );
        generateGlobalAddEventListener( event, 1, type );
        generateGlobalAddEventListener( event, 2, type );
        generateGlobalRemoveEventListener( event, 0, type );
        generateGlobalRemoveEventListener( event, 1, type );
        generateGlobalRemoveEventListener( event, 2, type );
      }
    }
  }

  private void generateStaticConstants( @Nonnull final List<ConstMember> constants,
                                        @Nonnull final String namespaceName,
                                        @Nonnull final TypeSpec.Builder type )
  {
    constants
      .stream()
      .sorted( Comparator.comparing( NamedElement::getName ) )
      .forEach( constant -> generateStaticConstant( constant, namespaceName, type ) );
  }

  private void generateStaticConstant( @Nonnull final ConstMember constant,
                                       @Nonnull final String namespaceName,
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
                  Modifier.FINAL );

    maybeAddCustomAnnotations( constant, field );
    maybeAddJavadoc( constant, field );
    field.initializer( "$T.$N", lookupClassName( namespaceName ), constant.getName() );
    type.addField( field.build() );
  }

  private void generateStaticAttributes( @Nonnull final List<AttributeMember> attributes,
                                         @Nonnull final TypeSpec.Builder type,
                                         final boolean global )
  {
    attributes
      .stream()
      .sorted( Comparator.comparing( NamedElement::getName ) )
      .forEach( attribute -> generateStaticAttribute( attribute, type, global ) );
  }

  private void generateStaticAttribute( @Nonnull final AttributeMember attribute,
                                        @Nonnull final TypeSpec.Builder type,
                                        final boolean global )
  {
    if ( attribute.getModifiers().contains( AttributeMember.Modifier.READ_ONLY ) )
    {
      generateStaticReadOnlyAttribute( attribute, type, global );
    }
    else
    {
      generateStaticReadWriteAttribute( attribute, type, global );
    }
  }

  private void generateStaticReadOnlyAttribute( @Nonnull final AttributeMember attribute,
                                                @Nonnull final TypeSpec.Builder type,
                                                final boolean global )
  {
    assert attribute.getModifiers().contains( AttributeMember.Modifier.READ_ONLY );
    final Type attributeType = attribute.getType();
    final WebIDLSchema schema = getSchema();
    final Type actualType = schema.resolveType( attributeType );
    final String name = attribute.getName();
    final TypeName actualJavaType = toTypeName( actualType );
    final String methodName = safeJsPropertyMethodName( name, TypeName.BOOLEAN.equals( actualJavaType ) );
    final MethodSpec.Builder method =
      MethodSpec
        .methodBuilder( methodName )
        .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
        .returns( actualJavaType );
    maybeAddCustomAnnotations( attribute, method );
    maybeAddJavadoc( attribute, method );
    if ( schema.isNullable( attributeType ) )
    {
      method.addAnnotation( BasicTypes.NULLABLE );
    }
    else if ( !actualJavaType.isPrimitive() )
    {
      method.addAnnotation( BasicTypes.NONNULL );
    }
    addMagicConstantAnnotationIfNeeded( actualType, method );
    method.addStatement( "return $N().$N()", global ? "globalThis" : "namespace", methodName );
    type.addMethod( method.build() );
  }

  private void generateStaticReadWriteAttribute( @Nonnull final AttributeMember attribute,
                                                 @Nonnull final TypeSpec.Builder type,
                                                 final boolean global )
  {
    assert !attribute.getModifiers().contains( AttributeMember.Modifier.READ_ONLY );
    final Type attributeType = attribute.getType();
    final WebIDLSchema schema = getSchema();
    final Type actualType = schema.resolveType( attributeType );
    final String name = attribute.getName();
    final TypeName actualJavaType = toTypeName( actualType );
    final String methodName = safeJsPropertyMethodName( name, TypeName.BOOLEAN.equals( actualJavaType ) );
    final MethodSpec.Builder method =
      MethodSpec
        .methodBuilder( methodName )
        .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
        .returns( actualJavaType );
    maybeAddCustomAnnotations( attribute, method );
    maybeAddJavadoc( attribute, method );
    if ( schema.isNullable( attributeType ) )
    {
      method.addAnnotation( BasicTypes.NULLABLE );
    }
    else if ( !actualJavaType.isPrimitive() )
    {
      method.addAnnotation( BasicTypes.NONNULL );
    }
    addMagicConstantAnnotationIfNeeded( actualType, method );
    method.addStatement( "return $N().$N", global ? "globalThis" : "namespace", methodName );
    type.addMethod( method.build() );
  }

  private void generateDelegateOperation( @Nonnull final OperationMember operation,
                                          @Nonnull final TypeSpec.Builder type,
                                          final boolean global )
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
        generateDelegateOperation( operation, argumentList, typeList, type, global );
      }
    }
  }

  private void generateDelegateOperation( @Nonnull final OperationMember operation,
                                          @Nonnull final List<Argument> arguments,
                                          @Nonnull final List<TypedValue> typeList,
                                          @Nonnull final TypeSpec.Builder type,
                                          final boolean global )
  {
    final OperationMember.Kind operationKind = operation.getKind();
    assert OperationMember.Kind.STATIC != operationKind && OperationMember.Kind.CONSTRUCTOR != operationKind;
    final String name = operation.getName();
    assert null != name;
    final String methodName = javaMethodName( name, operation );
    final MethodSpec.Builder method =
      MethodSpec
        .methodBuilder( methodName )
        .addModifiers( Modifier.PUBLIC, Modifier.STATIC );
    maybeAddCustomAnnotations( operation, method );
    maybeAddJavadoc( operation, method );
    final Type returnType = operation.getReturnType();
    emitReturnType( returnType, method );
    int index = 0;
    for ( final Argument argument : arguments )
    {
      generateArgument( argument, typeList.get( index++ ), false, method );
    }
    final StringBuilder sb = new StringBuilder();
    final List<Object> args = new ArrayList<>();
    if ( Kind.Void != returnType.getKind() )
    {
      sb.append( "return " );
    }
    sb.append( "$N().$N(" );
    args.add( global ? "globalThis" : "namespace" );
    args.add( methodName );

    boolean firstArg = true;
    for ( final Argument argument : arguments )
    {
      if ( !firstArg )
      {
        sb.append( ", " );
      }
      else
      {
        firstArg = false;
      }
      sb.append( "$N" );
      args.add( javaName( argument ) );
    }
    sb.append( ")" );
    method.addStatement( sb.toString(), args.toArray() );
    type.addMethod( method.build() );
  }

  private void generateGlobalAddEventListener( @Nonnull final EventMember event,
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
        .addStatement( "globalThis().$N( callback, options )", methodName );
    }
    else if ( 1 == variant )
    {
      method
        .addParameter( ParameterSpec
                         .builder( TypeName.BOOLEAN, "useCapture", Modifier.FINAL )
                         .build() )
        .addStatement( "globalThis().$N( callback, useCapture )", methodName );
    }
    else
    {
      assert 2 == variant;
      method.addStatement( "globalThis().$N( callback )", methodName );
    }

    type.addMethod( method.build() );
  }

  private void generateGlobalRemoveEventListener( @Nonnull final EventMember event,
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
        .addStatement( "globalThis().$N( callback, options )", methodName );
    }
    else if ( 1 == variant )
    {
      method
        .addParameter( ParameterSpec
                         .builder( TypeName.BOOLEAN, "useCapture", Modifier.FINAL )
                         .build() )
        .addStatement( "globalThis().$N( callback, useCapture )", methodName );
    }
    else
    {
      assert 2 == variant;
      method.addStatement( "globalThis().$N( callback )", methodName );
    }

    type.addMethod( method.build() );
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
        .classBuilder( lookupClassName( "$Global" + definition.getName() ).simpleName() )
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
      final MethodSpec.Builder namespaceMethod =
        MethodSpec
          .methodBuilder( NamingUtil.camelCase( safeJsPropertyMethodName( name, false ) ) )
          .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
          .returns( lookupClassName( namespace.getName() ) )
          .addAnnotation( AnnotationSpec
                            .builder( JsinteropTypes.JS_PROPERTY )
                            .addMember( "name", "$S", name )
                            .build() )
          .addAnnotation( BasicTypes.NONNULL );
      final DocumentationElement documentation = namespace.getDocumentation();
      if ( null != documentation && documentation.hasDeprecatedTag() )
      {
        namespaceMethod.addAnnotation( Deprecated.class );
      }
      type.addMethod( namespaceMethod.build() );
    }

    for ( final MixinDefinition mixin : getGlobalMixins( schema ) )
    {
      generateConstants( definition.getName(), mixin.getConstants(), type );
      generateAttributes( mixin.getAttributes(), type );
      for ( final OperationMember operation : mixin.getOperations() )
      {
        generateOperation( operation, type );
      }
    }

    writeTopLevelType( type );
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
    sb.append( "\n" );
    sb.append( "  <source path=''/>\n" );
    sb.append( "</module>\n" );
    final String gwtModuleContent = sb.toString();
    final String name = NamingUtil.uppercaseFirstCharacter( getLeafPackageName() );
    writeResourceFile( getMainJavaDirectory(), name + ".gwt.xml", gwtModuleContent.getBytes( StandardCharsets.UTF_8 ) );
  }

  private void generateUnion( @Nonnull final String idlName,
                              @Nonnull final String javaName,
                              @Nonnull final UnionType unionType,
                              @Nonnull final Collection<ClassName> additionalAnnotations )
    throws IOException
  {
    final TypeSpec.Builder type =
      TypeSpec
        .interfaceBuilder( javaName )
        .addModifiers( Modifier.PUBLIC );
    writeGeneratedAnnotation( type );
    type.addAnnotation( AnnotationSpec
                          .builder( JsinteropTypes.JS_TYPE )
                          .addMember( "isNative", "true" )
                          .addMember( "namespace", "$T.GLOBAL", JsinteropTypes.JS_PACKAGE )
                          .addMember( "name", "$S", "?" )
                          .build() );

    additionalAnnotations.forEach( type::addAnnotation );

    generateUnionOfMethods( idlName, unionType, type );

    writeTopLevelType( idlName, type );
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
      values.add( new TypedValue( declaredType, type, toJavaSequenceType( (SequenceType) type ), nullability, false ) );
      if ( null == type.getIdentValue( ExtendedAttributes.JAVA_SEQUENCE_TYPE ) )
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

  private boolean isMarkerType( @Nonnull final TypedefDefinition typedef )
  {
    return typedef.isNoArgsExtendedAttributePresent( ExtendedAttributes.MARKER_TYPE );
  }

  private void generateUnionOfMethods( @Nonnull final String idlName,
                                       @Nonnull final UnionType unionType,
                                       @Nonnull final TypeSpec.Builder type )
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
        }
      }
    }
  }

  private void generateDictionary( @Nonnull final DictionaryDefinition definition )
    throws IOException
  {
    if ( definition.getDirectSubDictionary().isEmpty() )
    {
      generateAllInOneDictionary( definition );
    }
    else
    {
      generateAbstractDictionary( definition );
    }
  }

  private void generateConcreteDictionary( @Nonnull final DictionaryDefinition definition,
                                           @Nonnull final TypeSpec.Builder container )
  {
    final TypeSpec.Builder type =
      TypeSpec
        .interfaceBuilder( "Builder" )
        .addModifiers( Modifier.PUBLIC, Modifier.STATIC );
    writeGeneratedAnnotation( type );
    type.addAnnotation( AnnotationSpec.builder( JsinteropTypes.JS_TYPE )
                          .addMember( "isNative", "true" )
                          .addMember( "namespace", "$T.GLOBAL", JsinteropTypes.JS_PACKAGE )
                          .addMember( "name", "$S", "Object" )
                          .build() );
    maybeAddCustomAnnotations( definition, type );
    maybeAddJavadoc( definition, type );

    type.addSuperinterface( lookupClassName( definition.getName() ) );

    final WebIDLSchema schema = getSchema();
    for ( final DictionaryMember member : definition.getMembers() )
    {
      for ( final TypedValue typedValue : explodeType( member.getType() ) )
      {
        generateDictionaryMemberSetterReturningThis( definition, member, typedValue, true, type );
      }
    }
    String superName = definition.getInherits();
    while ( null != superName )
    {
      final DictionaryDefinition parent = schema.getDictionaryByName( superName );
      for ( final DictionaryMember member : parent.getMembers() )
      {
        for ( final TypedValue memberType : explodeType( member.getType() ) )
        {
          generateDictionaryMemberSetterReturningThis( definition, member, memberType, true, type );
        }
      }
      superName = parent.getInherits();
    }

    container.addType( type.build() );
  }

  private void generateAbstractDictionary( @Nonnull final DictionaryDefinition definition )
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
                          .addMember( "name", "$S", "Object" )
                          .build() );
    maybeAddCustomAnnotations( definition, type );
    maybeAddJavadoc( definition, type );

    final String inherits = definition.getInherits();
    if ( null != inherits )
    {
      type.addSuperinterface( lookupClassName( inherits ) );
    }

    final List<DictionaryMember> requiredMembers = getRequiredDictionaryMembers( definition );
    final List<List<TypedValue>> explodedTypeList =
      explodeTypeList( requiredMembers.stream().map( DictionaryMember::getType ).collect( Collectors.toList() ) );
    for ( final List<TypedValue> argTypes : explodedTypeList )
    {
      generateDictionaryCreateMethod( definition, requiredMembers, argTypes, true, type );
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
    generateConcreteDictionary( definition, type );

    writeTopLevelType( definition.getName(), type );
  }

  private void generateAllInOneDictionary( @Nonnull final DictionaryDefinition definition )
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
                          .addMember( "name", "$S", "Object" )
                          .build() );
    maybeAddCustomAnnotations( definition, type );
    maybeAddJavadoc( definition, type );

    final String inherits = definition.getInherits();
    if ( null != inherits )
    {
      type.addSuperinterface( lookupClassName( inherits ) );
    }

    final List<DictionaryMember> requiredMembers = getRequiredDictionaryMembers( definition );
    final List<List<TypedValue>> explodedTypeList =
      explodeTypeList( requiredMembers.stream().map( DictionaryMember::getType ).collect( Collectors.toList() ) );
    for ( final List<TypedValue> argTypes : explodedTypeList )
    {
      generateDictionaryCreateMethod( definition, requiredMembers, argTypes, false, type );
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
        generateDictionaryMemberSetterReturningThis( definition, member, typedValue, false, type );
      }
    }
    String superName = definition.getInherits();
    while ( null != superName )
    {
      final DictionaryDefinition parent = schema.getDictionaryByName( superName );
      for ( final DictionaryMember member : parent.getMembers() )
      {
        for ( final TypedValue memberType : explodeType( member.getType() ) )
        {
          generateDictionaryMemberSetterReturningThis( definition, member, memberType, false, type );
        }
      }
      superName = parent.getInherits();
    }

    writeTopLevelType( definition.getName(), type );
  }

  private void generateDictionaryCreateMethod( @Nonnull final DictionaryDefinition dictionary,
                                               @Nonnull final List<DictionaryMember> requiredMembers,
                                               @Nonnull final List<TypedValue> types,
                                               final boolean onBuilder,
                                               @Nonnull final TypeSpec.Builder type )
  {
    final ClassName self = lookupClassName( dictionary.getName() );
    final ClassName target = onBuilder ? self.nestedClass( "Builder" ) : self;
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
        .methodBuilder( safeJsPropertyMethodName( member.getName(), TypeName.BOOLEAN.equals( javaType ) ) )
        .addModifiers( Modifier.PUBLIC, Modifier.ABSTRACT )
        .returns( javaType );
    method.addAnnotation( AnnotationSpec
                            .builder( JsinteropTypes.JS_PROPERTY )
                            .addMember( "name", "$S", member.getName() )
                            .build() );
    maybeAddCustomAnnotations( member, method );
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
    maybeAddCustomAnnotations( member, parameter );
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
                           toJavaSequenceType( (SequenceType) resolvedType ),
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
                                                            final boolean onBuilder,
                                                            @Nonnull final TypeSpec.Builder type )
  {

    final ClassName self = lookupClassName( dictionary.getName() );
    final ClassName target = onBuilder ? self.nestedClass( "Builder" ) : self;
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
    emitReturnType( definition.getReturnType(), method );
    for ( final Argument argument : definition.getArguments() )
    {
      generateArgument( argument, asTypedValue( argument.getType() ), false, method );
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
        .interfaceBuilder( lookupClassName( definition.getName() ).simpleName() )
        .addModifiers( Modifier.PUBLIC );
    writeGeneratedAnnotation( type );
    type.addAnnotation( AnnotationSpec.builder( JsinteropTypes.JS_TYPE )
                          .addMember( "isNative", "true" )
                          .addMember( "namespace", "$T.GLOBAL", JsinteropTypes.JS_PACKAGE )
                          .addMember( "name", "$S", exposedOnGlobal ? name : "?" )
                          .build() )
      .addAnnotation( FunctionalInterface.class );
    maybeAddCustomAnnotations( definition, type );
    maybeAddJavadoc( definition, type );

    generateConstants( definition.getName(), definition.getConstants(), type );

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
        .classBuilder( lookupClassName( definition.getName() ).simpleName() )
        .addModifiers( Modifier.PUBLIC, Modifier.FINAL );
    writeGeneratedAnnotation( type );
    maybeAddCustomAnnotations( definition, type );
    maybeAddJavadoc( definition, type );

    generateConstants( definition.getName(), definition.getConstants(), type );

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
    final IterableMember iterable = definition.getIterable();
    if ( null != iterable )
    {
      if ( null == iterable.getKeyType() )
      {
        generateValueIterableElements( name, iterable, type );
      }
      else
      {
        generatePairIterableElements( name, iterable, type );
      }
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

  private void generatePairIterableElements( @Nonnull final String idlName,
                                             @Nonnull final IterableMember iterable,
                                             @Nonnull final TypeSpec.Builder type )
  {
    final Type keyType = iterable.getKeyType();
    assert null != keyType;
    generateEntry( "key", toTypeName( keyType ), toTypeName( iterable.getValueType() ), type );
    generateIterableKeysMethod( idlName, toTypeName( keyType ), type );
    generateIterableValuesMethod( idlName, iterable, type );
    generateIterableEntriesMethod( idlName, type );
    generateIterableForEachMethod( idlName, iterable, toTypeName( keyType ), "key", type );
  }

  private void generateValueIterableElements( @Nonnull final String idlName,
                                              @Nonnull final IterableMember iterable,
                                              @Nonnull final TypeSpec.Builder type )
  {
    generateEntry( "index", TypeName.INT, toTypeName( iterable.getValueType() ), type );
    generateIterableKeysMethod( idlName, TypeName.DOUBLE, type );
    generateIterableValuesMethod( idlName, iterable, type );
    generateIterableEntriesMethod( idlName, type );
    generateIterableForEachMethod( idlName, iterable, TypeName.INT, "index", type );
  }

  private void generateIterableForEachMethod( @Nonnull final String idlName,
                                              @Nonnull final IterableMember iterable,
                                              @Nonnull final TypeName keyType,
                                              @Nonnull final String keyName,
                                              @Nonnull final TypeSpec.Builder type )
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
                                                   .addAnnotation( BasicTypes.NONNULL )
                                                   .build() )
                                  .build() )
                    .build() );
    final MethodSpec.Builder forEach1 =
      MethodSpec
        .methodBuilder( "forEach" )
        .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
        .addParameter( ParameterSpec.builder( ClassName.bestGuess( "ForEachCallback" ), "callback" )
                         .addAnnotation( BasicTypes.NONNULL )
                         .build() );
    maybeAddJavadoc( documentation, forEach1 );
    type.addMethod( forEach1.build() );

    final MethodSpec.Builder forEach2 =
      MethodSpec
        .methodBuilder( "forEach" )
        .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
        .addParameter( ParameterSpec.builder( ClassName.bestGuess( "ForEachCallback2" ), "callback" )
                         .addAnnotation( BasicTypes.NONNULL )
                         .build() );
    maybeAddJavadoc( documentation, forEach2 );
    type.addMethod( forEach2.build() );
    final MethodSpec.Builder forEach3 =
      MethodSpec
        .methodBuilder( "forEach" )
        .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
        .addParameter( ParameterSpec.builder( ClassName.bestGuess( "ForEachCallback3" ), "callback" )
                         .addAnnotation( BasicTypes.NONNULL )
                         .build() );
    maybeAddJavadoc( documentation, forEach3 );
    type.addMethod( forEach3.build() );
  }

  private void generateIterableEntriesMethod( @Nonnull final String idlName, @Nonnull final TypeSpec.Builder type )
  {
    final String methodName = "entries";
    final MethodSpec.Builder method =
      MethodSpec
        .methodBuilder( methodName )
        .addAnnotation( BasicTypes.NONNULL )
        .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
        .returns( ParameterizedTypeName.get( lookupClassName( "Iterator" ), ClassName.bestGuess( "Entry" ) ) );
    maybeAddJavadoc( getDocumentationElement( idlName, methodName ), method );
    type.addMethod( method.build() );
  }

  private void generateIterableKeysMethod( @Nonnull final String idlName,
                                           @Nonnull final TypeName keyType,
                                           @Nonnull final TypeSpec.Builder type )
  {
    final String methodName = "keys";
    final MethodSpec.Builder method =
      MethodSpec
        .methodBuilder( methodName )
        .addAnnotation( BasicTypes.NONNULL )
        .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
        .returns( ParameterizedTypeName.get( lookupClassName( "Iterator" ), keyType.box() ) );
    maybeAddJavadoc( getDocumentationElement( idlName, methodName ), method );
    type.addMethod( method.build() );
  }

  private void generateIterableValuesMethod( @Nonnull final String idlName,
                                             @Nonnull final IterableMember iterable,
                                             @Nonnull final TypeSpec.Builder type )
  {
    final String methodName = "values";
    final MethodSpec.Builder method =
      MethodSpec.methodBuilder( methodName )
        .addAnnotation( BasicTypes.NONNULL )
        .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
        .returns( ParameterizedTypeName.get( lookupClassName( "Iterator" ), toTypeName( iterable.getValueType() ) ) );
    maybeAddJavadoc( getDocumentationElement( idlName, methodName ), method );
    type.addMethod( method.build() );
  }

  private void generateOperations( @Nonnull final List<OperationMember> operations,
                                   @Nonnull final TypeSpec.Builder type )
  {
    operations
      .stream()
      .sorted()
      .forEach( operation -> generateOperation( operation, type ) );
  }

  private void generateNamespace( @Nonnull final NamespaceDefinition definition )
    throws IOException
  {
    final String name = definition.getName();
    final TypeSpec.Builder type =
      TypeSpec
        .classBuilder( lookupClassName( definition.getName() ).simpleName() )
        .addModifiers( Modifier.PUBLIC, Modifier.FINAL );
    writeGeneratedAnnotation( type );
    maybeAddCustomAnnotations( definition, type );
    maybeAddJavadoc( definition, type );

    generateConstants( definition.getName(), definition.getConstants(), type );
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

  private void generateStaticNamespace( @Nonnull final NamespaceDefinition definition )
    throws IOException
  {
    final String idlName = "$Static" + definition.getName();
    final TypeSpec.Builder type =
      TypeSpec
        .classBuilder( lookupClassName( idlName ).simpleName() )
        .addModifiers( Modifier.PUBLIC, Modifier.FINAL );
    writeGeneratedAnnotation( type );
    maybeAddJavadoc( definition, type );

    generateStaticConstants( definition.getConstants(), definition.getName(), type );
    generateStaticAttributes( definition.getAttributes(), type, false );

    for ( final OperationMember operation : definition.getOperations() )
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
        generateDelegateOperation( operation, type, false );
      }
    }
    type.addMethod( MethodSpec.constructorBuilder().addModifiers( Modifier.PRIVATE ).build() );

    final MethodSpec.Builder namespaceMethod =
      MethodSpec
        .methodBuilder( "namespace" )
        .addModifiers( Modifier.PUBLIC, Modifier.STATIC )
        .addAnnotation( BasicTypes.NONNULL )
        .returns( lookupClassName( definition.getName() ) )
        .addStatement( "return $T.$N()",
                       lookupClassName( "$Global" ),
                       NamingUtil.camelCase( safeJsPropertyMethodName( definition.getName(), false ) ) )
        .addJavadoc( "Return the '" + definition.getName() + "' namespace object.\n" +
                     "\n" +
                     "@return the '" + definition.getName() + "' namespace object\n" );
    final DocumentationElement documentation = definition.getDocumentation();
    if ( null != documentation && documentation.hasDeprecatedTag() )
    {
      namespaceMethod.addAnnotation( Deprecated.class );
    }
    type.addMethod( namespaceMethod.build() );

    writeTopLevelType( idlName, type );
  }

  private void generateInterface( @Nonnull final InterfaceDefinition definition )
    throws IOException
  {
    final String name = definition.getName();
    final TypeSpec.Builder type =
      TypeSpec
        .classBuilder( lookupClassName( definition.getName() ).simpleName() )
        .addModifiers( Modifier.PUBLIC );
    writeGeneratedAnnotation( type );
    maybeAddCustomAnnotations( definition, type );
    maybeAddJavadoc( definition, type );

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

    generateConstants( definition.getName(), definition.getConstants(), type );
    generateAttributes( definition.getAttributes(), type );

    boolean constructorPresent = false;
    for ( final OperationMember operation : definition.getOperations() )
    {
      final boolean processed = generateOperation( operation, type );
      if ( !processed && OperationMember.Kind.CONSTRUCTOR == operation.getKind() )
      {
        generateConstructorOperation( operation, parentConstructor, type );
        constructorPresent = true;
      }
    }

    final MapLikeMember mapLike = definition.getMapLikeMember();
    if ( null != mapLike )
    {
      generateMapLikeOperations( name, definition.getOperations(), mapLike, type );
    }
    final IterableMember iterable = definition.getIterable();
    if ( null != iterable )
    {
      if ( null == iterable.getKeyType() )
      {
        generateValueIterableElements( name, iterable, type );
      }
      else
      {
        generatePairIterableElements( name, iterable, type );
      }
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

  private boolean generateOperation( @Nonnull final OperationMember operation, @Nonnull final TypeSpec.Builder type )
  {
    final OperationMember.Kind operationKind = operation.getKind();
    final String operationName = operation.getName();
    if ( OperationMember.Kind.DEFAULT == operationKind )
    {
      generateDefaultOperation( operation, type );
    }
    else if ( ( OperationMember.Kind.STRINGIFIER == operationKind ||
                OperationMember.Kind.GETTER == operationKind ||
                OperationMember.Kind.SETTER == operationKind ||
                OperationMember.Kind.DELETER == operationKind ) &&
              null != operationName )
    {
      generateDefaultOperation( operation, type );
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
      generateStaticOperation( operation, type );
    }
    else
    {
      return false;
    }
    return true;
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

    final MethodSpec.Builder has =
      MethodSpec
        .methodBuilder( "has" )
        .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
        .addParameter( keyParam )
        .returns( TypeName.BOOLEAN );
    maybeAddJavadoc( getDocumentationElement( definitionName, "has" ), has );
    type.addMethod( has.build() );

    final MethodSpec.Builder get = MethodSpec
      .methodBuilder( "get" )
      .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
      .addAnnotation( BasicTypes.NULLABLE )
      .addParameter( keyParam )
      .returns( boxedValueType );
    maybeAddJavadoc( getDocumentationElement( definitionName, "get" ), get );
    type.addMethod( get.build() );

    final MethodSpec.Builder keys =
      MethodSpec
        .methodBuilder( "keys" )
        .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
        .addAnnotation( BasicTypes.NONNULL )
        .returns( ParameterizedTypeName.get( lookupClassName( "Iterator" ), boxedKeyType ) );
    maybeAddJavadoc( getDocumentationElement( definitionName, "keys" ), keys );
    type.addMethod( keys.build() );

    final MethodSpec.Builder values =
      MethodSpec
        .methodBuilder( "values" )
        .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
        .addAnnotation( BasicTypes.NONNULL )
        .returns( ParameterizedTypeName.get( lookupClassName( "Iterator" ), boxedValueType ) );
    maybeAddJavadoc( getDocumentationElement( definitionName, "values" ), values );
    type.addMethod( values.build() );

    generateEntry( "key", keyType, valueType, type );

    final MethodSpec.Builder entries =
      MethodSpec
        .methodBuilder( "entries" )
        .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
        .addAnnotation( BasicTypes.NONNULL )
        .returns( ParameterizedTypeName.get( lookupClassName( "Iterator" ),
                                             ClassName.bestGuess( "Entry" ) ) );
    maybeAddJavadoc( getDocumentationElement( definitionName, "entries" ), entries );
    type.addMethod( entries.build() );

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
    final DocumentationElement forEachDocumentation = getDocumentationElement( definitionName, "forEach" );
    final MethodSpec.Builder forEach1 =
      MethodSpec
        .methodBuilder( "forEach" )
        .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
        .addParameter( ParameterSpec.builder( ClassName.bestGuess( "ForEachCallback" ), "callback" )
                         .addAnnotation( BasicTypes.NONNULL )
                         .build() );
    maybeAddJavadoc( forEachDocumentation, forEach1 );
    type.addMethod( forEach1.build() );
    final MethodSpec.Builder forEach2 =
      MethodSpec
        .methodBuilder( "forEach" )
        .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
        .addParameter( ParameterSpec.builder( ClassName.bestGuess( "ForEachCallback2" ), "callback" )
                         .addAnnotation( BasicTypes.NONNULL )
                         .build() );
    maybeAddJavadoc( forEachDocumentation, forEach2 );
    type.addMethod( forEach2.build() );

    final MethodSpec.Builder forEach3 = MethodSpec
      .methodBuilder( "forEach" )
      .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
      .addParameter( ParameterSpec.builder( ClassName.bestGuess( "ForEachCallback3" ), "callback" )
                       .addAnnotation( BasicTypes.NONNULL )
                       .build() );
    maybeAddJavadoc( forEachDocumentation, forEach3 );
    type.addMethod( forEach3.build() );
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
      }
    }
  }

  private void completeEntryAccessorMethod( @Nonnull final MethodSpec.Builder method,
                                            @Nonnull final TypeName type,
                                            final int index )
  {
    // This code assumes that keys and values are non-nullable and this is true with current
    // set of specs so we can deal with nullability when/if it is required
    final String accessorMethod;
    if ( TypeName.BOOLEAN == type )
    {
      accessorMethod = "asBoolean";
    }
    else if ( TypeName.BYTE == type )
    {
      accessorMethod = "asByte";
    }
    else if ( TypeName.CHAR == type )
    {
      accessorMethod = "asChar";
    }
    else if ( TypeName.SHORT == type )
    {
      accessorMethod = "asShort";
    }
    else if ( TypeName.INT == type )
    {
      accessorMethod = "asInt";
    }
    else if ( TypeName.LONG == type )
    {
      accessorMethod = "asLong";
    }
    else if ( TypeName.FLOAT == type )
    {
      accessorMethod = "asFloat";
    }
    else if ( TypeName.DOUBLE == type )
    {
      accessorMethod = "asDouble";
    }
    else if ( BasicTypes.STRING.equals( type ) )
    {
      method.addAnnotation( BasicTypes.NONNULL );
      accessorMethod = "asString";
    }
    else
    {
      method.addAnnotation( BasicTypes.NONNULL );
      accessorMethod = "cast";
    }
    method.addStatement( "return getAtAsAny( " + index + " ).$N()", accessorMethod );
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

    final MethodSpec.Builder valueMethod = MethodSpec
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
    final TypeName actualJavaType = toTypeName( actualType );
    final MethodSpec.Builder method =
      MethodSpec
        .methodBuilder( safeJsPropertyMethodName( name, TypeName.BOOLEAN.equals( actualJavaType ) ) )
        .addModifiers( Modifier.PUBLIC, Modifier.NATIVE )
        .returns( actualJavaType )
        .addAnnotation( AnnotationSpec.builder( JsinteropTypes.JS_PROPERTY ).addMember( "name", "$S", name ).build() );
    maybeAddCustomAnnotations( attribute, method );
    maybeAddJavadoc( attribute, method );
    if ( attribute.getModifiers().contains( AttributeMember.Modifier.STATIC ) )
    {
      method.addModifiers( Modifier.STATIC );
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
    maybeAddCustomAnnotations( attribute, field );
    maybeAddJavadoc( attribute, field );
    if ( !fieldName.equals( name ) )
    {
      field.addAnnotation( AnnotationSpec.builder( JsinteropTypes.JS_PROPERTY )
                             .addMember( "name", "$S", name )
                             .build() );
    }
    if ( attribute.getModifiers().contains( AttributeMember.Modifier.STATIC ) )
    {
      field.addModifiers( Modifier.STATIC );
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

  private void generateConstants( @Nonnull final String definitionName,
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
                            .addMember( "name", "$S", definitionName )
                            .addMember( "namespace", "$T.GLOBAL", JsinteropTypes.JS_PACKAGE )
                            .build() );
      for ( final ConstMember constant : noInlineConstants )
      {
        constantType.addField( FieldSpec
                                 .builder( toTypeName( getSchema().resolveType( constant.getType() ) ),
                                           constant.getName(),
                                           Modifier.PRIVATE,
                                           Modifier.STATIC )
                                 .addAnnotation( JsinteropTypes.JS_OVERLAY )
                                 .build() );
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
    final String methodName = javaMethodName( name, operation );
    final MethodSpec.Builder method =
      MethodSpec
        .methodBuilder( methodName )
        .addModifiers( Modifier.PUBLIC, javaInterface ? Modifier.ABSTRACT : Modifier.NATIVE );
    maybeAddCustomAnnotations( operation, method );
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
    emitReturnType( itemType, method );
    final Argument argument = arguments.get( 0 );
    generateArgument( argument, asTypedValue( argument.getType() ), true, method );
    method.addStatement( "return $T.<$T>cast( this ).getAt( $N )",
                         JsinteropTypes.JS,
                         ParameterizedTypeName.get( JsinteropTypes.JS_ARRAY_LIKE, toTypeName( itemType ) ),
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
    generateArgument( indexArgument, asTypedValue( indexArgument.getType() ), true, method );

    final Argument valueArgument = arguments.get( 1 );
    generateArgument( valueArgument, asTypedValue( valueArgument.getType() ), true, method );

    method.addStatement( "$T.<$T>cast( this ).setAt( $N, $N )",
                         JsinteropTypes.JS,
                         ParameterizedTypeName.get( JsinteropTypes.JS_ARRAY_LIKE,
                                                    toTypeName( valueArgument.getType() ) ),
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
    emitReturnType( itemType, method );
    final Argument argument = arguments.get( 0 );
    generateArgument( argument, asTypedValue( argument.getType() ), true, method );
    final TypeName javaItemType = toTypeName( itemType );
    method.addStatement( "return $T.<$T>cast( this ).get( $N )",
                         JsinteropTypes.JS,
                         ParameterizedTypeName.get( JsinteropTypes.JS_PROPERTY_MAP, javaItemType ),
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
    generateArgument( indexArgument, asTypedValue( indexArgument.getType() ), true, method );

    final Argument valueArgument = arguments.get( 1 );
    generateArgument( valueArgument, asTypedValue( valueArgument.getType() ), true, method );

    method.addStatement( "$T.<$T>cast( this ).set( $N, $N )",
                         JsinteropTypes.JS,
                         ParameterizedTypeName.get( JsinteropTypes.JS_PROPERTY_MAP,
                                                    toTypeName( valueArgument.getType() ) ),
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
    generateArgument( argument, asTypedValue( argument.getType() ), true, method );
    method.addStatement( "$T.<$T>cast( this ).delete( $N )",
                         JsinteropTypes.JS,
                         ParameterizedTypeName.get( JsinteropTypes.JS_PROPERTY_MAP,
                                                    WildcardTypeName.subtypeOf( TypeName.OBJECT ) ),
                         argument.getName() );
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
    final String methodName = javaMethodName( name, operation );
    final MethodSpec.Builder method =
      MethodSpec
        .methodBuilder( methodName )
        .addModifiers( Modifier.PUBLIC, Modifier.STATIC, Modifier.NATIVE );
    maybeAddCustomAnnotations( operation, method );
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
      ParameterSpec.builder( argument.isVariadic() ? asArrayType( type ) : type, javaName( argument ) );
    if ( isFinal )
    {
      parameter.addModifiers( Modifier.FINAL );
    }
    maybeAddCustomAnnotations( argument, parameter );
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
    schema.getEnumerations().forEach( this::registerDefinition );
    schema.getConstEnumerations().forEach( this::registerDefinition );
    schema.getInterfaces().forEach( this::registerDefinition );
    schema.getPartialInterfaces().forEach( this::registerDefinition );
    schema.getNamespaces().forEach( definition -> {
      tryRegisterIdlToJavaTypeMapping( definition.getName(), deriveJavaType( definition, "", "Namespace" ) );
      tryRegisterIdlToJavaTypeMapping( "$Static" + definition.getName(), deriveJavaType( definition, "", "" ) );
    } );
    if ( null != _globalInterface )
    {
      final InterfaceDefinition global = schema.getInterfaceByName( _globalInterface );
      tryRegisterIdlToJavaTypeMapping( "$Global" + global.getName(), deriveJavaType( global, "Global", "" ) );
      tryRegisterIdlToJavaTypeMapping( "$Global", getPackageName() + ".Global" );
    }
  }

  private void registerDefinition( @Nonnull final NamedDefinition definition )
  {
    tryRegisterIdlToJavaTypeMapping( definition.getName(), deriveJavaType( definition, "", "" ) );
  }

  @Nonnull
  private String deriveJavaType( @Nonnull final NamedDefinition definition,
                                 @Nonnull final String prefix,
                                 @Nonnull final String suffix )
  {
    return derivePackagePrefix( definition ) + deriveSimpleJavaType( definition, prefix, suffix );
  }

  @Nonnull
  private String deriveSimpleJavaType( @Nonnull final NamedDefinition definition,
                                       @Nonnull final String prefix,
                                       @Nonnull final String suffix )
  {
    return prefix + NamingUtil.uppercaseFirstCharacter( javaName( definition ) ) + suffix;
  }

  @Nonnull
  private String derivePackagePrefix( @Nonnull final NamedDefinition definition )
  {
    final String declaredSubPackage = definition.getIdentValue( ExtendedAttributes.JAVA_SUB_PACKAGE );
    final String subPackage =
      null != declaredSubPackage ? asSubPackage( declaredSubPackage ) : asSubPackage( getNamespace( definition ) );
    return getPackageName() + subPackage + ".";
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
