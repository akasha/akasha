package org.realityforge.webtack.model.tools.processors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.Argument;
import org.realityforge.webtack.model.AsyncIterableMember;
import org.realityforge.webtack.model.AttributeMember;
import org.realityforge.webtack.model.CallbackDefinition;
import org.realityforge.webtack.model.CallbackInterfaceDefinition;
import org.realityforge.webtack.model.ConstMember;
import org.realityforge.webtack.model.ConstValue;
import org.realityforge.webtack.model.DefaultValue;
import org.realityforge.webtack.model.DictionaryDefinition;
import org.realityforge.webtack.model.DictionaryMember;
import org.realityforge.webtack.model.DocumentationElement;
import org.realityforge.webtack.model.EnumerationDefinition;
import org.realityforge.webtack.model.ExtendedAttribute;
import org.realityforge.webtack.model.FrozenArrayType;
import org.realityforge.webtack.model.IncludesStatement;
import org.realityforge.webtack.model.InterfaceDefinition;
import org.realityforge.webtack.model.IterableMember;
import org.realityforge.webtack.model.Kind;
import org.realityforge.webtack.model.MapLikeMember;
import org.realityforge.webtack.model.MixinDefinition;
import org.realityforge.webtack.model.NamespaceDefinition;
import org.realityforge.webtack.model.OperationMember;
import org.realityforge.webtack.model.PartialDictionaryDefinition;
import org.realityforge.webtack.model.PartialInterfaceDefinition;
import org.realityforge.webtack.model.PartialMixinDefinition;
import org.realityforge.webtack.model.PartialNamespaceDefinition;
import org.realityforge.webtack.model.PromiseType;
import org.realityforge.webtack.model.RecordType;
import org.realityforge.webtack.model.SequenceType;
import org.realityforge.webtack.model.SetLikeMember;
import org.realityforge.webtack.model.SourceInterval;
import org.realityforge.webtack.model.Type;
import org.realityforge.webtack.model.TypedefDefinition;
import org.realityforge.webtack.model.UnionType;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.tools.spi.Processor;

/**
 * Base class for applying a transformation to a schema.
 *
 * <p>It should be notes that this is extremely inefficient computationally and memory-wise. If this is
 * ever a problem we can always allow subclasses to use a bitset to declare which child elements of the
 * schema are processed. We would just reuse elements if we don't walk down a tree.</p>
 */
@SuppressWarnings( "unused" )
public abstract class AbstractProcessor
  implements Processor
{
  @Nullable
  @Override
  public WebIDLSchema process( @Nonnull final WebIDLSchema schema )
  {
    final Map<String, CallbackDefinition> callbacks = transformCallbacks( schema.getCallbacks() );
    final Map<String, CallbackInterfaceDefinition> callbackInterfaces =
      transformCallbackInterfaces( schema.getCallbackInterfaces() );
    final Map<String, EnumerationDefinition> enumerations = transformEnumerations( schema.getEnumerations() );
    final Map<String, DictionaryDefinition> dictionaries = transformDictionaries( schema.getDictionaries() );
    final Map<String, List<PartialDictionaryDefinition>> partialDictionaries =
      transformPartialDictionaries( schema.getPartialDictionaries() );
    final Map<String, NamespaceDefinition> namespaces = transformNamespaces( schema.getNamespaces() );
    final Map<String, List<PartialNamespaceDefinition>> partialNamespaces =
      transformPartialNamespaces( schema.getPartialNamespaces() );
    final Map<String, MixinDefinition> mixins = transformMixins( schema.getMixins() );
    final Map<String, List<PartialMixinDefinition>> partialMixins = transformPartialMixins( schema.getPartialMixins() );
    final Map<String, InterfaceDefinition> interfaces = transformInterfaces( schema.getInterfaces() );
    final Map<String, List<PartialInterfaceDefinition>> partialInterfaces =
      transformPartialInterfaces( schema.getPartialInterfaces() );
    final List<IncludesStatement> includes = transformIncludesStatements( schema.getIncludes() );
    final Map<String, TypedefDefinition> typedefs = transformTypedefs( schema.getTypedefs() );

    return new WebIDLSchema( callbacks,
                             callbackInterfaces,
                             dictionaries,
                             enumerations,
                             interfaces,
                             mixins,
                             includes,
                             namespaces,
                             partialDictionaries,
                             partialInterfaces,
                             partialMixins,
                             partialNamespaces,
                             typedefs,
                             transformSourceLocations( schema.getSourceLocations() ),
                             transformTags( schema ) );
  }

  @Nonnull
  protected Set<String> transformTags( @Nonnull final WebIDLSchema schema )
  {
    return schema.getTags();
  }

  @Nonnull
  protected Map<String, CallbackDefinition> transformCallbacks( @Nonnull final Collection<CallbackDefinition> inputs )
  {
    final Map<String, CallbackDefinition> definitions = new HashMap<>();
    for ( final CallbackDefinition input : inputs )
    {
      final CallbackDefinition output = transformCallback( input );
      if ( null != output )
      {
        definitions.put( output.getName(), output );
      }
    }
    return definitions;
  }

  @Nullable
  protected CallbackDefinition transformCallback( @Nonnull final CallbackDefinition input )
  {
    return new CallbackDefinition( input.getName(),
                                   transformType( input.getReturnType() ),
                                   transformArguments( input.getArguments() ),
                                   transformDocumentation( input.getDocumentation() ),
                                   transformExtendedAttributes( input.getExtendedAttributes() ),
                                   transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  protected Map<String, CallbackInterfaceDefinition> transformCallbackInterfaces( @Nonnull final Collection<CallbackInterfaceDefinition> inputs )
  {
    final Map<String, CallbackInterfaceDefinition> definitions = new HashMap<>();
    for ( final CallbackInterfaceDefinition input : inputs )
    {
      final CallbackInterfaceDefinition output = transformCallbackInterface( input );
      if ( null != output )
      {
        definitions.put( output.getName(), output );
      }
    }
    return definitions;
  }

  @Nullable
  protected CallbackInterfaceDefinition transformCallbackInterface( @Nonnull final CallbackInterfaceDefinition input )
  {
    return new CallbackInterfaceDefinition( input.getName(),
                                            transformOperationMember( input.getOperation() ),
                                            transformConstants( input.getConstants() ),
                                            transformDocumentation( input.getDocumentation() ),
                                            transformExtendedAttributes( input.getExtendedAttributes() ),
                                            transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  protected OperationMember transformOperationMember( @Nonnull final OperationMember input )
  {
    return new OperationMember( input.getKind(),
                                input.getName(),
                                transformArguments( input.getArguments() ),
                                transformType( input.getReturnType() ),
                                transformDocumentation( input.getDocumentation() ),
                                transformExtendedAttributes( input.getExtendedAttributes() ),
                                transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nullable
  protected OperationMember transformOptionalOperationMember( @Nonnull final OperationMember input )
  {
    return transformOperationMember( input );
  }

  @Nonnull
  protected List<ConstMember> transformConstants( @Nonnull final List<ConstMember> inputs )
  {
    final List<ConstMember> outputs = new ArrayList<>();
    for ( final ConstMember input : inputs )
    {
      final ConstMember output = transformConstant( input );
      if ( null != output )
      {
        outputs.add( output );
      }
    }
    return outputs;
  }

  @Nullable
  protected ConstMember transformConstant( @Nonnull final ConstMember input )
  {
    return new ConstMember( input.getName(),
                            transformType( input.getType() ),
                            transformConstValue( input.getValue() ),
                            transformDocumentation( input.getDocumentation() ),
                            transformExtendedAttributes( input.getExtendedAttributes() ),
                            transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  protected Map<String, EnumerationDefinition> transformEnumerations( @Nonnull final Collection<EnumerationDefinition> inputs )
  {
    final Map<String, EnumerationDefinition> definitions = new HashMap<>();
    for ( final EnumerationDefinition input : inputs )
    {
      final EnumerationDefinition output = transformEnumeration( input );
      if ( null != output )
      {
        definitions.put( output.getName(), output );
      }
    }
    return definitions;
  }

  @Nullable
  protected EnumerationDefinition transformEnumeration( @Nonnull final EnumerationDefinition input )
  {
    return new EnumerationDefinition( input.getName(),
                                      input.getValues(),
                                      transformDocumentation( input.getDocumentation() ),
                                      transformExtendedAttributes( input.getExtendedAttributes() ),
                                      transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  protected Map<String, MixinDefinition> transformMixins( @Nonnull final Collection<MixinDefinition> inputs )
  {
    final Map<String, MixinDefinition> definitions = new HashMap<>();
    for ( final MixinDefinition input : inputs )
    {
      final MixinDefinition output = transformMixin( input );
      if ( null != output )
      {
        definitions.put( output.getName(), output );
      }
    }
    return definitions;
  }

  @Nullable
  protected MixinDefinition transformMixin( @Nonnull final MixinDefinition input )
  {
    return new MixinDefinition( input.getName(),
                                transformConstants( input.getConstants() ),
                                transformAttributeMembers( input.getAttributes() ),
                                transformOperationMembers( input.getOperations() ),
                                transformDocumentation( input.getDocumentation() ),
                                transformExtendedAttributes( input.getExtendedAttributes() ),
                                transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  protected Map<String, List<PartialMixinDefinition>> transformPartialMixins( @Nonnull final Collection<PartialMixinDefinition> inputs )
  {
    final Map<String, List<PartialMixinDefinition>> definitions = new HashMap<>();
    for ( final PartialMixinDefinition input : inputs )
    {
      final PartialMixinDefinition output = transformPartialMixin( input );
      if ( null != output )
      {
        definitions.computeIfAbsent( output.getName(), v -> new ArrayList<>() ).add( output );
      }
    }
    return definitions;
  }

  @Nullable
  protected PartialMixinDefinition transformPartialMixin( @Nonnull final PartialMixinDefinition input )
  {
    return new PartialMixinDefinition( input.getName(),
                                       transformConstants( input.getConstants() ),
                                       transformAttributeMembers( input.getAttributes() ),
                                       transformOperationMembers( input.getOperations() ),
                                       transformDocumentation( input.getDocumentation() ),
                                       transformExtendedAttributes( input.getExtendedAttributes() ),
                                       transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  protected Map<String, InterfaceDefinition> transformInterfaces( @Nonnull final Collection<InterfaceDefinition> inputs )
  {
    final Map<String, InterfaceDefinition> definitions = new HashMap<>();
    for ( final InterfaceDefinition input : inputs )
    {
      final InterfaceDefinition output = transformInterface( input );
      if ( null != output )
      {
        definitions.put( output.getName(), output );
      }
    }
    return definitions;
  }

  @Nullable
  protected InterfaceDefinition transformInterface( @Nonnull final InterfaceDefinition input )
  {
    return new InterfaceDefinition( input.getName(),
                                    input.getInherits(),
                                    transformConstants( input.getConstants() ),
                                    transformAttributeMembers( input.getAttributes() ),
                                    transformOperationMembers( input.getOperations() ),
                                    transformIterableMember( input.getIterable() ),
                                    transformAsyncIterableMember( input.getAsyncIterable() ),
                                    transformMapLikeMember( input.getMapLikeMember() ),
                                    transformSetLikeMember( input.getSetLikeMember() ),
                                    transformDocumentation( input.getDocumentation() ),
                                    transformExtendedAttributes( input.getExtendedAttributes() ),
                                    transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nullable
  protected SetLikeMember transformSetLikeMember( @Nullable final SetLikeMember input )
  {
    return null == input ?
           null :
           new SetLikeMember( transformType( input.getType() ),
                              input.isReadOnly(),
                              transformDocumentation( input.getDocumentation() ),
                              transformExtendedAttributes( input.getExtendedAttributes() ),
                              transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nullable
  protected MapLikeMember transformMapLikeMember( @Nullable final MapLikeMember input )
  {
    return null == input ?
           null :
           new MapLikeMember( transformType( input.getKeyType() ),
                              transformType( input.getValueType() ),
                              input.isReadOnly(),
                              transformDocumentation( input.getDocumentation() ),
                              transformExtendedAttributes( input.getExtendedAttributes() ),
                              transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nullable
  protected AsyncIterableMember transformAsyncIterableMember( @Nullable final AsyncIterableMember input )
  {
    return null == input ?
           null :
           new AsyncIterableMember( transformType( input.getKeyType() ),
                                    transformType( input.getValueType() ),
                                    transformDocumentation( input.getDocumentation() ),
                                    transformExtendedAttributes( input.getExtendedAttributes() ),
                                    transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nullable
  protected IterableMember transformIterableMember( @Nullable final IterableMember input )
  {
    return null == input ?
           null :
           new IterableMember( transformOptionalType( input.getKeyType() ),
                               transformType( input.getValueType() ),
                               transformDocumentation( input.getDocumentation() ),
                               transformExtendedAttributes( input.getExtendedAttributes() ),
                               transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nullable
  protected Type transformOptionalType( @Nullable final Type type )
  {
    return null == type ? null : transformType( type );
  }

  @Nonnull
  protected Map<String, List<PartialInterfaceDefinition>> transformPartialInterfaces( @Nonnull final Collection<PartialInterfaceDefinition> inputs )
  {
    final Map<String, List<PartialInterfaceDefinition>> definitions = new HashMap<>();
    for ( final PartialInterfaceDefinition input : inputs )
    {
      final PartialInterfaceDefinition output = transformPartialInterface( input );
      if ( null != output )
      {
        definitions.computeIfAbsent( output.getName(), v -> new ArrayList<>() ).add( output );
      }
    }
    return definitions;
  }

  @Nullable
  protected PartialInterfaceDefinition transformPartialInterface( @Nonnull final PartialInterfaceDefinition input )
  {
    return new PartialInterfaceDefinition( input.getName(),
                                           transformConstants( input.getConstants() ),
                                           transformAttributeMembers( input.getAttributes() ),
                                           transformOperationMembers( input.getOperations() ),
                                           transformIterableMember( input.getIterable() ),
                                           transformAsyncIterableMember( input.getAsyncIterable() ),
                                           transformMapLikeMember( input.getMapLikeMember() ),
                                           transformSetLikeMember( input.getSetLikeMember() ),
                                           transformDocumentation( input.getDocumentation() ),
                                           transformExtendedAttributes( input.getExtendedAttributes() ),
                                           transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  protected Map<String, NamespaceDefinition> transformNamespaces( @Nonnull final Collection<NamespaceDefinition> inputs )
  {
    final Map<String, NamespaceDefinition> definitions = new HashMap<>();
    for ( final NamespaceDefinition input : inputs )
    {
      final NamespaceDefinition output = transformNamespace( input );
      if ( null != output )
      {
        definitions.put( output.getName(), output );
      }
    }
    return definitions;
  }

  @Nullable
  protected NamespaceDefinition transformNamespace( @Nonnull final NamespaceDefinition input )
  {
    return new NamespaceDefinition( input.getName(),
                                    transformOperationMembers( input.getOperations() ),
                                    transformAttributeMembers( input.getAttributes() ),
                                    transformDocumentation( input.getDocumentation() ),
                                    transformExtendedAttributes( input.getExtendedAttributes() ),
                                    transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  protected Map<String, List<PartialNamespaceDefinition>> transformPartialNamespaces( @Nonnull final Collection<PartialNamespaceDefinition> inputs )
  {
    final Map<String, List<PartialNamespaceDefinition>> definitions = new HashMap<>();
    for ( final PartialNamespaceDefinition input : inputs )
    {
      final PartialNamespaceDefinition output = transformPartialNamespace( input );
      if ( null != output )
      {
        definitions.computeIfAbsent( output.getName(), v -> new ArrayList<>() ).add( output );
      }
    }
    return definitions;
  }

  @Nullable
  protected PartialNamespaceDefinition transformPartialNamespace( @Nonnull final PartialNamespaceDefinition input )
  {
    return new PartialNamespaceDefinition( input.getName(),
                                           transformOperationMembers( input.getOperations() ),
                                           transformAttributeMembers( input.getAttributes() ),
                                           transformDocumentation( input.getDocumentation() ),
                                           transformExtendedAttributes( input.getExtendedAttributes() ),
                                           transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  protected List<OperationMember> transformOperationMembers( @Nonnull final List<OperationMember> inputs )
  {
    final List<OperationMember> outputs = new ArrayList<>();
    for ( final OperationMember member : inputs )
    {
      final OperationMember output = transformOptionalOperationMember( member );
      if ( null != output )
      {
        outputs.add( output );
      }
    }
    return outputs;
  }

  @Nonnull
  protected List<AttributeMember> transformAttributeMembers( @Nonnull final List<AttributeMember> inputs )
  {
    final List<AttributeMember> outputs = new ArrayList<>();
    for ( final AttributeMember member : inputs )
    {
      final AttributeMember output = transformAttributeMember( member );
      if ( null != output )
      {
        outputs.add( output );
      }
    }
    return outputs;
  }

  @Nullable
  protected AttributeMember transformAttributeMember( @Nonnull final AttributeMember input )
  {
    return new AttributeMember( input.getName(),
                                transformType( input.getType() ),
                                input.getModifiers(),
                                transformDocumentation( input.getDocumentation() ),
                                transformExtendedAttributes( input.getExtendedAttributes() ),
                                transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  protected Map<String, DictionaryDefinition> transformDictionaries( @Nonnull final Collection<DictionaryDefinition> inputs )
  {
    final Map<String, DictionaryDefinition> definitions = new HashMap<>();
    for ( final DictionaryDefinition input : inputs )
    {
      final DictionaryDefinition output = transformDictionary( input );
      if ( null != output )
      {
        definitions.put( output.getName(), output );
      }
    }
    return definitions;
  }

  @Nullable
  protected DictionaryDefinition transformDictionary( @Nonnull final DictionaryDefinition input )
  {
    return new DictionaryDefinition( input.getName(),
                                     input.getInherits(),
                                     transformDictionaryMembers( input.getMembers() ),
                                     transformDocumentation( input.getDocumentation() ),
                                     transformExtendedAttributes( input.getExtendedAttributes() ),
                                     transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  protected List<DictionaryMember> transformDictionaryMembers( @Nonnull final List<DictionaryMember> inputs )
  {
    final List<DictionaryMember> outputs = new ArrayList<>();
    for ( final DictionaryMember member : inputs )
    {
      final DictionaryMember output = transformDictionaryMember( member );
      if ( null != output )
      {
        outputs.add( output );
      }
    }
    return outputs;
  }

  @Nullable
  protected DictionaryMember transformDictionaryMember( @Nonnull final DictionaryMember input )
  {
    return new DictionaryMember( input.getName(),
                                 transformType( input.getType() ),
                                 input.isOptional(),
                                 input.getDefaultValue(),
                                 transformDocumentation( input.getDocumentation() ),
                                 transformExtendedAttributes( input.getExtendedAttributes() ),
                                 transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  protected Map<String, List<PartialDictionaryDefinition>> transformPartialDictionaries( @Nonnull final Collection<PartialDictionaryDefinition> inputs )
  {
    final Map<String, List<PartialDictionaryDefinition>> definitions = new HashMap<>();
    for ( final PartialDictionaryDefinition input : inputs )
    {
      final PartialDictionaryDefinition output = transformPartialDictionary( input );
      if ( null != output )
      {
        definitions.computeIfAbsent( output.getName(), v -> new ArrayList<>() ).add( output );
      }
    }
    return definitions;
  }

  @Nullable
  protected PartialDictionaryDefinition transformPartialDictionary( @Nonnull final PartialDictionaryDefinition input )
  {
    return new PartialDictionaryDefinition( input.getName(),
                                            transformDictionaryMembers( input.getMembers() ),
                                            transformDocumentation( input.getDocumentation() ),
                                            transformExtendedAttributes( input.getExtendedAttributes() ),
                                            transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  protected List<IncludesStatement> transformIncludesStatements( @Nonnull final Collection<IncludesStatement> inputs )
  {
    final List<IncludesStatement> definitions = new ArrayList<>();
    for ( final IncludesStatement input : inputs )
    {
      final IncludesStatement output = transformIncludesStatement( input );
      if ( null != output )
      {
        definitions.add( output );
      }
    }
    return definitions;
  }

  @Nullable
  protected IncludesStatement transformIncludesStatement( @Nonnull final IncludesStatement input )
  {
    return new IncludesStatement( input.getInterfaceName(),
                                  input.getMixinName(),
                                  transformDocumentation( input.getDocumentation() ),
                                  transformExtendedAttributes( input.getExtendedAttributes() ),
                                  transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  protected Map<String, TypedefDefinition> transformTypedefs( @Nonnull final Collection<TypedefDefinition> inputs )
  {
    final Map<String, TypedefDefinition> definitions = new HashMap<>();
    for ( final TypedefDefinition input : inputs )
    {
      final TypedefDefinition output = transformTypedef( input );
      if ( null != output )
      {
        definitions.put( output.getName(), output );
      }
    }
    return definitions;
  }

  @Nullable
  protected TypedefDefinition transformTypedef( @Nonnull final TypedefDefinition input )
  {
    return new TypedefDefinition( input.getName(),
                                  transformType( input.getType() ),
                                  transformDocumentation( input.getDocumentation() ),
                                  transformExtendedAttributes( input.getExtendedAttributes() ),
                                  transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  protected List<Argument> transformArguments( @Nonnull final List<Argument> arguments )
  {
    final List<Argument> outputs = new ArrayList<>();
    for ( final Argument input : arguments )
    {
      outputs.add( transformArgument( input ) );
    }
    return outputs;
  }

  @Nonnull
  protected Argument transformArgument( @Nonnull final Argument input )
  {
    return new Argument( input.getName(),
                         transformType( input.getType() ),
                         input.isOptional(),
                         input.isVariadic(),
                         transformDefaultValue( input.getDefaultValue() ),
                         transformDocumentation( input.getDocumentation() ),
                         transformExtendedAttributes( input.getExtendedAttributes() ),
                         input.getSourceLocations() );
  }

  @Nullable
  protected DefaultValue transformDefaultValue( @Nullable final DefaultValue input )
  {
    return null == input ?
           null :
           new DefaultValue( input.getKind(),
                             null == input.getConstValue() ? null : transformConstValue( input.getConstValue() ),
                             input.getStringValue(),
                             transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  protected ConstValue transformConstValue( @Nonnull final ConstValue input )
  {
    return new ConstValue( input.getKind(), input.getValue(), transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  protected Type transformType( @Nonnull final Type type )
  {
    final Kind kind = type.getKind();
    if ( Kind.Union == kind )
    {
      final UnionType unionType = (UnionType) type;
      return new UnionType( unionType
                              .getMemberTypes()
                              .stream()
                              .map( this::transformType )
                              .collect( Collectors.toList() ),
                            unionType.getExtendedAttributes(),
                            unionType.isNullable(),
                            unionType.getSourceLocations() );
    }
    else if ( Kind.Promise == kind )
    {
      final PromiseType promiseType = (PromiseType) type;
      return new PromiseType( transformType( promiseType.getResolveType() ),
                              promiseType.getExtendedAttributes(),
                              promiseType.getSourceLocations() );
    }
    else if ( Kind.Sequence == kind )
    {
      final SequenceType sequenceType = (SequenceType) type;
      return new SequenceType( transformType( sequenceType.getItemType() ),
                               sequenceType.getExtendedAttributes(),
                               sequenceType.isNullable(),
                               sequenceType.getSourceLocations() );
    }
    else if ( Kind.FrozenArray == kind )
    {
      final FrozenArrayType frozenArrayType = (FrozenArrayType) type;
      return new FrozenArrayType( transformType( frozenArrayType.getItemType() ),
                                  frozenArrayType.getExtendedAttributes(),
                                  frozenArrayType.isNullable(),
                                  frozenArrayType.getSourceLocations() );
    }
    else if ( Kind.Record == kind )
    {
      final RecordType recordType = (RecordType) type;
      return new RecordType( transformType( recordType.getKeyType() ),
                             transformType( recordType.getValueType() ),
                             recordType.getExtendedAttributes(),
                             recordType.isNullable(),
                             recordType.getSourceLocations() );
    }
    else
    {
      return type;
    }
  }

  @Nullable
  protected DocumentationElement transformDocumentation( @Nullable final DocumentationElement documentation )
  {
    return documentation;
  }

  @Nonnull
  protected List<ExtendedAttribute> transformExtendedAttributes( @Nonnull final List<ExtendedAttribute> inputs )
  {
    return inputs;
  }

  @Nonnull
  protected List<SourceInterval> transformSourceLocations( @Nonnull final List<SourceInterval> inputs )
  {
    return inputs;
  }
}
