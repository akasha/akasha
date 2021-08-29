package org.realityforge.webtack.model.tools.processors.js_symbol_dedup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.AttributeMember;
import org.realityforge.webtack.model.AttributedNode;
import org.realityforge.webtack.model.CallbackDefinition;
import org.realityforge.webtack.model.CallbackInterfaceDefinition;
import org.realityforge.webtack.model.ConstEnumerationDefinition;
import org.realityforge.webtack.model.DictionaryDefinition;
import org.realityforge.webtack.model.EnumerationDefinition;
import org.realityforge.webtack.model.ExtendedAttribute;
import org.realityforge.webtack.model.IllegalModelException;
import org.realityforge.webtack.model.IncludesStatement;
import org.realityforge.webtack.model.InterfaceDefinition;
import org.realityforge.webtack.model.Kind;
import org.realityforge.webtack.model.MixinDefinition;
import org.realityforge.webtack.model.NamedDefinition;
import org.realityforge.webtack.model.NamespaceDefinition;
import org.realityforge.webtack.model.OperationMember;
import org.realityforge.webtack.model.PartialDictionaryDefinition;
import org.realityforge.webtack.model.PartialInterfaceDefinition;
import org.realityforge.webtack.model.PartialMixinDefinition;
import org.realityforge.webtack.model.PartialNamespaceDefinition;
import org.realityforge.webtack.model.PromiseType;
import org.realityforge.webtack.model.SequenceType;
import org.realityforge.webtack.model.Type;
import org.realityforge.webtack.model.TypeReference;
import org.realityforge.webtack.model.TypedefDefinition;
import org.realityforge.webtack.model.UnionType;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.tools.processors.AbstractProcessor;
import org.realityforge.webtack.model.tools.spi.PipelineContext;
import org.realityforge.webtack.model.tools.util.ExtendedAttributes;
import org.realityforge.webtack.model.tools.util.JsUtil;
import org.realityforge.webtack.model.tools.util.NamingUtil;
import org.realityforge.webtack.model.tools.util.UnionUtil;

final class JsSymbolDedupProcessor
  extends AbstractProcessor
{
  @Nonnull
  private final Map<String, UnionType> _unions = new HashMap<>();
  @Nonnull
  private final Set<InterfaceDefinition> _globalInterfaces = new HashSet<>();
  @Nonnull
  private final Map<String, UnionType> _globalAttributeTypeOverrides = new HashMap<>();
  @Nonnull
  private final Map<String, UnionType> _operationTypeOverrides = new HashMap<>();
  @Nonnull
  private final Map<String, UnionType> _globalOperationTypeOverrides = new HashMap<>();
  private boolean _processingGlobalInterface;
  private WebIDLSchema _schema;

  JsSymbolDedupProcessor( @Nonnull final PipelineContext context )
  {
    super( context );
  }

  @Nullable
  @Override
  public WebIDLSchema process( @Nonnull final WebIDLSchema schema )
  {
    _schema = schema;
    _unions.clear();
    _globalInterfaces.clear();
    _globalAttributeTypeOverrides.clear();
    _globalOperationTypeOverrides.clear();

    schema.link();

    schema
      .getInterfaces()
      .stream()
      .filter( t -> !t.getIdentValueOrValues( ExtendedAttributes.GLOBAL ).isEmpty() )
      .forEach( _globalInterfaces::add );

    // Need to add any parent interfaces as they can potentially also contribute duplicate
    // attributes or operations
    for ( final InterfaceDefinition globalInterface : new ArrayList<>( _globalInterfaces ) )
    {
      InterfaceDefinition current = globalInterface.getSuperInterface();
      while ( null != current )
      {
        if ( isNotSpecialObjectType( current ) )
        {
          _globalInterfaces.add( current );
        }
        current = current.getSuperInterface();
      }
    }

    final List<AttributeMember> attributes = new ArrayList<>();
    final List<OperationMember> operations = new ArrayList<>();
    for ( final InterfaceDefinition globalInterface : _globalInterfaces )
    {
      InterfaceDefinition current = globalInterface;
      while ( null != current )
      {
        if ( isNotSpecialObjectType( current ) )
        {
          attributes.addAll( current.getAttributes() );
          operations.addAll( current.getOperations() );
        }
        current = current.getSuperInterface();
      }
    }

    // instance attributes
    attributes
      .stream()
      .filter( a -> !a.getModifiers().contains( AttributeMember.Modifier.STATIC ) )
      .collect( Collectors.groupingBy( JsUtil::toJsName ) )
      .entrySet()
      .stream()
      .filter( entry -> 1 != entry.getValue().size() )
      .forEach( entry -> {
        final String name = entry.getKey();
        final Type derivedType = deriveAttributeType( entry.getValue() );
        if ( derivedType.isNoArgsExtendedAttributePresent( ExtendedAttributes.SYNTHETIC ) )
        {
          assert derivedType instanceof UnionType;
          // If a new UnionType was created then mark attribute as overridden
          _globalAttributeTypeOverrides.put( name, (UnionType) derivedType );
        }
      } );

    operations
      .stream()
      .filter( o -> null != JsUtil.toJsName( o ) )
      .filter( o -> OperationMember.Kind.CONSTRUCTOR != o.getKind() )
      .filter( o -> OperationMember.Kind.STATIC != o.getKind() )
      .collect( Collectors.groupingBy( JsUtil::toJsName ) )
      .entrySet()
      .stream()
      .filter( entry -> 1 != entry.getValue().size() )
      .forEach( entry -> {
        final String name = entry.getKey();
        final List<OperationMember> members = entry.getValue();
        final Type derivedType = deriveReturnType( members );
        if ( derivedType.isNoArgsExtendedAttributePresent( ExtendedAttributes.SYNTHETIC ) )
        {
          assert derivedType instanceof UnionType;
          // If a new UnionType was created then mark operation as overridden
          _globalOperationTypeOverrides.put( name, (UnionType) derivedType );
        }
      } );

    return super.process( schema );
  }

  private boolean isNotSpecialObjectType( @Nonnull final InterfaceDefinition current )
  {
    return !current.getName().equals( "Object" );
  }

  @Nullable
  @Override
  protected InterfaceDefinition transformInterface( @Nonnull final InterfaceDefinition input )
  {
    _processingGlobalInterface = _globalInterfaces.contains( input );
    _operationTypeOverrides.clear();
    try
    {
      final List<OperationMember> operations = new ArrayList<>();
      if ( isNotSpecialObjectType( input ) )
      {
        for ( final InterfaceDefinition type : getInterfaceDefinitionsInInheritanceHierarchy( input ) )
        {
          operations.addAll( type.getOperations() );
        }
      }

      operations
        .stream()
        .filter( o -> null != o.getName() )
        .filter( o -> OperationMember.Kind.STATIC != o.getKind() )
        .collect( Collectors.groupingBy( JsUtil::toJsName ) )
        .entrySet()
        .stream()
        .filter( entry -> 1 != entry.getValue().size() )
        .forEach( entry -> {
          final String name = entry.getKey();
          if ( null != input.findOperationByName( name ) )
          {
            // For any operation of the current interface, that has overrides then register them
            final List<OperationMember> members = entry.getValue();
            final Type derivedAttributeType = deriveReturnType( members );
            if ( members.get( 0 ).getReturnType() != derivedAttributeType )
            {
              assert derivedAttributeType instanceof UnionType;
              // If a new UnionType was created then mark attribute as overridden
              _operationTypeOverrides.put( name, (UnionType) derivedAttributeType );
            }
          }
        } );

      return super.transformInterface( input );
    }
    finally
    {
      _processingGlobalInterface = false;
    }
  }

  @Nonnull
  private List<InterfaceDefinition> getInterfaceDefinitionsInInheritanceHierarchy( @Nonnull final InterfaceDefinition input )
  {
    final Set<InterfaceDefinition> types = new HashSet<>();
    final Stack<InterfaceDefinition> toDescendDown = new Stack<>();
    toDescendDown.add( input );
    while ( !toDescendDown.isEmpty() )
    {
      final InterfaceDefinition current = toDescendDown.pop();
      types.add( current );
      toDescendDown.addAll( current.getDirectSubInterfaces() );
    }

    InterfaceDefinition current = input;
    while ( null != current )
    {
      if ( isNotSpecialObjectType( current ) )
      {
        types.add( current );
      }
      current = current.getSuperInterface();
    }
    return types.stream().sorted( Comparator.comparing( NamedDefinition::getName ) ).collect( Collectors.toList() );
  }

  @Nullable
  @Override
  protected AttributeMember transformAttributeMember( @Nonnull final AttributeMember input )
  {
    if ( _processingGlobalInterface && !input.getModifiers().contains( AttributeMember.Modifier.STATIC ) )
    {
      final UnionType overrideType = _globalAttributeTypeOverrides.get( input.getName() );
      if ( null != overrideType )
      {
        return new AttributeMember( input.getName(),
                                    transformType( input.getType() ),
                                    input.getModifiers(),
                                    transformDocumentation( input.getDocumentation() ),
                                    buildExtendedAttributes( input,
                                                             ExtendedAttributes.GLOBAL_TYPE_OVERRIDE,
                                                             overrideType ),
                                    transformSourceLocations( input.getSourceLocations() ) );
      }
    }

    return super.transformAttributeMember( input );
  }

  @Nonnull
  private List<ExtendedAttribute> buildExtendedAttributes( @Nonnull final AttributedNode input,
                                                           @Nonnull final String overrideKey,
                                                           @Nonnull final UnionType overrideType )
  {
    final List<ExtendedAttribute> extendedAttributes = new ArrayList<>( input.getExtendedAttributes() );
    extendedAttributes.add( ExtendedAttribute.createIdent( overrideKey,
                                                           deriveTypeDefNameForUnionType( overrideType ) ) );
    return extendedAttributes;
  }

  @Nonnull
  @Override
  protected OperationMember transformOperationMember( @Nonnull final OperationMember input )
  {
    if ( _processingGlobalInterface )
    {
      final UnionType overrideType = _globalOperationTypeOverrides.get( input.getName() );
      if ( null != overrideType )
      {
        return new OperationMember( input.getKind(),
                                    input.getName(),
                                    transformArguments( input.getArguments() ),
                                    transformType( input.getReturnType() ),
                                    transformDocumentation( input.getDocumentation() ),
                                    buildExtendedAttributes( input,
                                                             ExtendedAttributes.GLOBAL_TYPE_OVERRIDE,
                                                             overrideType ),
                                    transformSourceLocations( input.getSourceLocations() ) );
      }
    }
    if ( OperationMember.Kind.STATIC != input.getKind() )
    {
      final UnionType overrideType = _operationTypeOverrides.get( input.getName() );
      if ( null != overrideType )
      {
        return new OperationMember( input.getKind(),
                                    input.getName(),
                                    transformArguments( input.getArguments() ),
                                    transformType( input.getReturnType() ),
                                    transformDocumentation( input.getDocumentation() ),
                                    buildExtendedAttributes( input, ExtendedAttributes.TYPE_OVERRIDE, overrideType ),
                                    transformSourceLocations( input.getSourceLocations() ) );
      }
    }

    return super.transformOperationMember( input );
  }

  @Nonnull
  @Override
  protected WebIDLSchema createSchema( @Nonnull final WebIDLSchema schema,
                                       @Nonnull final Map<String, CallbackDefinition> callbacks,
                                       @Nonnull final Map<String, CallbackInterfaceDefinition> callbackInterfaces,
                                       @Nonnull final Map<String, EnumerationDefinition> enumerations,
                                       @Nonnull final Map<String, ConstEnumerationDefinition> constEnumerations,
                                       @Nonnull final Map<String, DictionaryDefinition> dictionaries,
                                       @Nonnull final Map<String, List<PartialDictionaryDefinition>> partialDictionaries,
                                       @Nonnull final Map<String, NamespaceDefinition> namespaces,
                                       @Nonnull final Map<String, List<PartialNamespaceDefinition>> partialNamespaces,
                                       @Nonnull final Map<String, MixinDefinition> mixins,
                                       @Nonnull final Map<String, List<PartialMixinDefinition>> partialMixins,
                                       @Nonnull final Map<String, InterfaceDefinition> interfaces,
                                       @Nonnull final Map<String, List<PartialInterfaceDefinition>> partialInterfaces,
                                       @Nonnull final List<IncludesStatement> includes,
                                       @Nonnull final Map<String, TypedefDefinition> typedefs )
  {
    for ( final Map.Entry<String, UnionType> entry : _unions.entrySet() )
    {
      final String name = entry.getKey();
      if ( typedefs.containsKey( name ) )
      {
        throw new IllegalModelException( "Attempted to create union named " + name +
                                         " that has already been explicitly declared" );
      }
      final UnionType unionType = entry.getValue();
      final TypedefDefinition typedef =
        new TypedefDefinition( name,
                               unionType,
                               null,
                               unionType.getExtendedAttributes(),
                               Collections.emptyList() );
      typedefs.put( name, typedef );
    }

    return super.createSchema( schema,
                               callbacks,
                               callbackInterfaces,
                               enumerations,
                               constEnumerations,
                               dictionaries,
                               partialDictionaries,
                               namespaces,
                               partialNamespaces,
                               mixins,
                               partialMixins,
                               interfaces,
                               partialInterfaces,
                               includes,
                               typedefs );
  }

  private void registerUnionTypeName( @Nonnull final UnionType type )
  {
    final String name = deriveTypeDefNameForUnionType( type );
    if ( !_unions.containsKey( name ) )
    {
      _unions.put( name, type );
    }
  }

  @Nonnull
  private String deriveTypeDefNameForUnionType( @Nonnull final UnionType type )
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
    return sb.toString();
  }

  private void appendTypeToUnionName( @Nonnull final StringBuilder sb, @Nonnull final Type type )
  {
    final Kind kind = type.getKind();
    if ( kind.isString() )
    {
      sb.append( "String" );
    }
    else if ( kind.isPrimitive() || Kind.FrozenArray == kind || Kind.Object == kind )
    {
      sb.append( kind.name() );
    }
    else if ( Kind.TypeReference == kind )
    {
      sb.append( NamingUtil.uppercaseFirstCharacter( ( (TypeReference) type ).getName() ) );
    }
    else if ( Kind.Sequence == kind )
    {
      appendTypeToUnionName( sb, ( (SequenceType) type ).getItemType() );
      sb.append( "Array" );
    }
    else if ( Kind.Void == kind )
    {
      sb.append( "Undefined" );
    }
    else if ( Kind.Any == kind )
    {
      sb.append( "Any" );
    }
    else if ( Kind.Promise == kind )
    {
      appendTypeToUnionName( sb, ( (PromiseType) type ).getResolveType() );
      sb.append( "Promise" );
    }
    else
    {
      throw new UnsupportedOperationException( "Contains kind " + kind + " in union which has not been implemented" );
    }
  }

  @Nonnull
  private Type deriveAttributeType( @Nonnull final List<AttributeMember> attributes )
  {
    return convertToUnionIfRequired( attributes
                                       .stream()
                                       .map( AttributeMember::getType )
                                       .collect( Collectors.toList() ) );
  }

  @Nonnull
  private Type deriveReturnType( @Nonnull final List<OperationMember> operations )
  {
    return convertToUnionIfRequired( operations
                                       .stream()
                                       .map( OperationMember::getReturnType )
                                       .collect( Collectors.toList() ) );
  }

  /**
   * Return a type that represents the specified type list.
   * If the list contains a single type then it is just the type, otherwise it is a union representing the types.
   *
   * @param types the types.
   * @return the type representing the specified type list.
   */
  @Nonnull
  private Type convertToUnionIfRequired( @Nonnull final List<Type> types )
  {
    final UnionType unionType = UnionUtil.createUnionIfRequired( _schema, types );
    if ( null != unionType )
    {
      registerUnionTypeName( unionType );
      return unionType;
    }
    else
    {
      return types.get( 0 );
    }
  }
}
