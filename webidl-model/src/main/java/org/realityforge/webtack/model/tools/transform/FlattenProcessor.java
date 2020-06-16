package org.realityforge.webtack.model.tools.transform;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.AsyncIterableMember;
import org.realityforge.webtack.model.AttributeMember;
import org.realityforge.webtack.model.CallbackDefinition;
import org.realityforge.webtack.model.CallbackInterfaceDefinition;
import org.realityforge.webtack.model.ConstMember;
import org.realityforge.webtack.model.DictionaryDefinition;
import org.realityforge.webtack.model.DictionaryMember;
import org.realityforge.webtack.model.EnumerationDefinition;
import org.realityforge.webtack.model.IllegalModelException;
import org.realityforge.webtack.model.InterfaceDefinition;
import org.realityforge.webtack.model.IterableMember;
import org.realityforge.webtack.model.MapLikeMember;
import org.realityforge.webtack.model.MixinDefinition;
import org.realityforge.webtack.model.NamespaceDefinition;
import org.realityforge.webtack.model.Node;
import org.realityforge.webtack.model.OperationMember;
import org.realityforge.webtack.model.PartialDictionaryDefinition;
import org.realityforge.webtack.model.PartialInterfaceDefinition;
import org.realityforge.webtack.model.PartialMixinDefinition;
import org.realityforge.webtack.model.PartialNamespaceDefinition;
import org.realityforge.webtack.model.SetLikeMember;
import org.realityforge.webtack.model.SourceInterval;
import org.realityforge.webtack.model.TypedefDefinition;
import org.realityforge.webtack.model.WebIDLSchema;

/**
 * Flatten the types.
 * First the members in "PartialX" types are merged into "X" types.
 * Then members in mixins are merged into interface types.
 */
public final class FlattenProcessor
  implements SchemaProcessor
{
  /**
   * Flatten two or more schemas into a single schema.
   *
   * @param schema the schema to flatten.
   * @return the merged schema.
   */
  @Override
  public WebIDLSchema transform( @Nonnull final WebIDLSchema schema )
  {
    final Map<String, DictionaryDefinition> dictionaries = new HashMap<>();
    final Map<String, InterfaceDefinition> interfaces = new HashMap<>();
    final Map<String, MixinDefinition> mixins = new HashMap<>();
    final Map<String, NamespaceDefinition> namespaces = new HashMap<>();

    for ( final DictionaryDefinition definition : schema.getDictionaries() )
    {
      final String name = definition.getName();
      final List<PartialDictionaryDefinition> partials = schema.findPartialDictionariesByName( name );
      dictionaries.put( name, partials.isEmpty() ? definition : merge( definition, partials ) );
    }
    for ( final NamespaceDefinition definition : schema.getNamespaces() )
    {
      final String name = definition.getName();
      final List<PartialNamespaceDefinition> partials = schema.findPartialNamespacesByName( name );
      namespaces.put( name, partials.isEmpty() ? definition : merge( definition, partials ) );
    }
    for ( final MixinDefinition definition : schema.getMixins() )
    {
      final String name = definition.getName();
      final List<PartialMixinDefinition> partials = schema.findPartialMixinsByName( name );
      mixins.put( name, partials.isEmpty() ? definition : merge( definition, partials ) );
    }
    for ( final InterfaceDefinition definition : schema.getInterfaces() )
    {
      final String name = definition.getName();
      final List<PartialInterfaceDefinition> partials = schema.findPartialInterfacesByName( name );
      final List<MixinDefinition> includedMixins =
        schema
          .findIncludesByInterfaceName( name )
          .stream()
          .map( i -> mixins.get( i.getMixinName() ) )
          .collect( Collectors.toList() );
      interfaces.put( name,
                      partials.isEmpty() && includedMixins.isEmpty() ?
                      definition :
                      merge( definition, partials, includedMixins ) );
    }

    return new WebIDLSchema( schema.getCallbacks()
                               .stream()
                               .collect( Collectors.toMap( CallbackDefinition::getName, Function.identity() ) ),
                             schema.getCallbackInterfaces()
                               .stream()
                               .collect( Collectors.toMap( CallbackInterfaceDefinition::getName,
                                                           Function.identity() ) ),
                             dictionaries,
                             schema.getEnumerations()
                               .stream()
                               .collect( Collectors.toMap( EnumerationDefinition::getName, Function.identity() ) ),
                             interfaces,
                             Collections.emptyMap(),
                             Collections.emptyList(),
                             namespaces,
                             Collections.emptyMap(),
                             Collections.emptyMap(),
                             Collections.emptyMap(),
                             Collections.emptyMap(),
                             schema.getTypedefs()
                               .stream()
                               .collect( Collectors.toMap( TypedefDefinition::getName, Function.identity() ) ),
                             schema.getSourceLocations(),
                             schema.getTags() );
  }

  @Nonnull
  private DictionaryDefinition merge( @Nonnull final DictionaryDefinition definition,
                                      @Nonnull final List<PartialDictionaryDefinition> partials )
  {
    final Map<String, DictionaryMember> members = new LinkedHashMap<>();
    for ( final DictionaryMember member : definition.getMembers() )
    {
      members.put( member.getName(), member );
    }
    final List<SourceInterval> sourceLocations = new ArrayList<>( definition.getSourceLocations() );
    for ( final PartialDictionaryDefinition partial : partials )
    {
      sourceLocations.addAll( partial.getSourceLocations() );
      for ( final DictionaryMember member : partial.getMembers() )
      {
        final String name = member.getName();
        final DictionaryMember existing = members.get( name );
        if ( null != existing )
        {
          throw new IllegalModelException( "Failed to merge dictionary member named '" + name + "' into dictionary " +
                                           "named '" + definition.getName() + "' as the dictionary already " +
                                           "contains a member with the same name. Existing defined in:\n" +
                                           describeLocations( existing, "\n" ) + "\n" +
                                           "Attempting to add member defined in:\n" +
                                           describeLocations( member, "\n" ) );
        }
        members.put( name, member );
      }
    }
    return new DictionaryDefinition( definition.getName(),
                                     definition.getInherits(),
                                     Collections.unmodifiableList( new ArrayList<>( members.values() ) ),
                                     definition.getExtendedAttributes(),
                                     Collections.unmodifiableList( sourceLocations ) );
  }

  @Nonnull
  private NamespaceDefinition merge( @Nonnull final NamespaceDefinition definition,
                                     @Nonnull final List<PartialNamespaceDefinition> partials )
  {
    final Map<String, AttributeMember> attributes = new LinkedHashMap<>();
    for ( final AttributeMember attribute : definition.getAttributes() )
    {
      attributes.put( attribute.getName(), attribute );
    }
    final Set<OperationMember> operations = new LinkedHashSet<>( definition.getOperations() );
    final List<SourceInterval> sourceLocations = new ArrayList<>( definition.getSourceLocations() );
    for ( final PartialNamespaceDefinition partial : partials )
    {
      sourceLocations.addAll( partial.getSourceLocations() );
      for ( final AttributeMember attribute : partial.getAttributes() )
      {
        final String name = attribute.getName();
        final AttributeMember existing = attributes.get( name );
        if ( null != existing )
        {
          throw new IllegalModelException( "Failed to merge attribute named '" + name + "' into namespace " +
                                           "named '" + definition.getName() + "' as the namespace already " +
                                           "contains an attribute with the same name. Existing defined in:\n" +
                                           describeLocations( existing, "\n" ) + "\n" +
                                           "Attempting to add member defined in:\n" +
                                           describeLocations( attribute, "\n" ) );
        }
        attributes.put( name, attribute );
      }
      operations.addAll( partial.getOperations() );
    }
    return new NamespaceDefinition( definition.getName(),
                                    Collections.unmodifiableList( new ArrayList<>( operations ) ),
                                    Collections.unmodifiableList( new ArrayList<>( attributes.values() ) ),
                                    definition.getExtendedAttributes(),
                                    Collections.unmodifiableList( sourceLocations ) );
  }

  @Nonnull
  private MixinDefinition merge( @Nonnull final MixinDefinition definition,
                                 @Nonnull final List<PartialMixinDefinition> partials )
  {
    final Map<String, ConstMember> constants = new LinkedHashMap<>();
    final Map<String, AttributeMember> attributes = new LinkedHashMap<>();
    for ( final ConstMember constant : definition.getConstants() )
    {
      constants.put( constant.getName(), constant );
    }
    for ( final AttributeMember attribute : definition.getAttributes() )
    {
      attributes.put( attribute.getName(), attribute );
    }
    final Set<OperationMember> operations = new LinkedHashSet<>( definition.getOperations() );
    final List<SourceInterval> sourceLocations = new ArrayList<>( definition.getSourceLocations() );
    for ( final PartialMixinDefinition partial : partials )
    {
      sourceLocations.addAll( partial.getSourceLocations() );
      for ( final ConstMember constant : partial.getConstants() )
      {
        final String name = constant.getName();
        final ConstMember existing = constants.get( name );
        if ( null != existing )
        {
          throw new IllegalModelException( "Failed to merge constant named '" + name + "' into mixin " +
                                           "named '" + definition.getName() + "' as the mixin already " +
                                           "contains a constant with the same name. Existing defined in:\n" +
                                           describeLocations( existing, "\n" ) + "\n" +
                                           "Attempting to add member defined in:\n" +
                                           describeLocations( constant, "\n" ) );
        }
        constants.put( name, constant );
      }
      for ( final AttributeMember attribute : partial.getAttributes() )
      {
        final String name = attribute.getName();
        final AttributeMember existing = attributes.get( name );
        if ( null != existing )
        {
          throw new IllegalModelException( "Failed to merge attribute named '" + name + "' into mixin " +
                                           "named '" + definition.getName() + "' as the mixin already " +
                                           "contains an attribute with the same name. Existing defined in:\n" +
                                           describeLocations( existing, "\n" ) + "\n" +
                                           "Attempting to add member defined in:\n" +
                                           describeLocations( attribute, "\n" ) );
        }
        attributes.put( name, attribute );
      }
      operations.addAll( partial.getOperations() );
    }
    return new MixinDefinition( definition.getName(),
                                Collections.unmodifiableList( new ArrayList<>( constants.values() ) ),
                                Collections.unmodifiableList( new ArrayList<>( attributes.values() ) ),
                                Collections.unmodifiableList( new ArrayList<>( operations ) ),
                                definition.getExtendedAttributes(),
                                Collections.unmodifiableList( sourceLocations ) );
  }

  @Nonnull
  private InterfaceDefinition merge( @Nonnull final InterfaceDefinition definition,
                                     @Nonnull final List<PartialInterfaceDefinition> partials,
                                     @Nonnull final List<MixinDefinition> mixins )
  {
    IterableMember iterable = definition.getIterable();
    AsyncIterableMember asyncIterable = definition.getAsyncIterable();
    MapLikeMember mapLikeMember = definition.getMapLikeMember();
    SetLikeMember setLikeMember = definition.getSetLikeMember();

    final Map<String, ConstMember> constants = new LinkedHashMap<>();
    final Map<String, AttributeMember> attributes = new LinkedHashMap<>();
    for ( final ConstMember constant : definition.getConstants() )
    {
      constants.put( constant.getName(), constant );
    }
    for ( final AttributeMember attribute : definition.getAttributes() )
    {
      attributes.put( attribute.getName(), attribute );
    }
    final Set<OperationMember> operations = new LinkedHashSet<>( definition.getOperations() );
    final List<SourceInterval> sourceLocations = new ArrayList<>( definition.getSourceLocations() );
    for ( final PartialInterfaceDefinition partial : partials )
    {
      sourceLocations.addAll( partial.getSourceLocations() );
      iterable = null == partial.getIterable() ? iterable : partial.getIterable();
      asyncIterable = null == partial.getAsyncIterable() ? asyncIterable : partial.getAsyncIterable();
      mapLikeMember = null == partial.getMapLikeMember() ? mapLikeMember : partial.getMapLikeMember();
      setLikeMember = null == partial.getSetLikeMember() ? setLikeMember : partial.getSetLikeMember();

      for ( final ConstMember constant : partial.getConstants() )
      {
        final String name = constant.getName();
        final ConstMember existing = constants.get( name );
        if ( null != existing )
        {
          throw new IllegalModelException( "Failed to merge constant named '" + name + "' into interface " +
                                           "named '" + definition.getName() + "' as the interface already " +
                                           "contains a constant with the same name. Existing defined in:\n" +
                                           describeLocations( existing, "\n" ) + "\n" +
                                           "Attempting to add member defined in:\n" +
                                           describeLocations( constant, "\n" ) );
        }
        constants.put( name, constant );
      }
      for ( final AttributeMember attribute : partial.getAttributes() )
      {
        final String name = attribute.getName();
        final AttributeMember existing = attributes.get( name );
        if ( null != existing )
        {
          throw new IllegalModelException( "Failed to merge attribute named '" + name + "' into interface " +
                                           "named '" + definition.getName() + "' as the interface already " +
                                           "contains an attribute with the same name. Existing defined in:\n" +
                                           describeLocations( existing, "\n" ) + "\n" +
                                           "Attempting to add member defined in:\n" +
                                           describeLocations( attribute, "\n" ) );
        }
        attributes.put( name, attribute );
      }
      operations.addAll( partial.getOperations() );
    }
    for ( final MixinDefinition mixin : mixins )
    {
      sourceLocations.addAll( mixin.getSourceLocations() );

      for ( final ConstMember constant : mixin.getConstants() )
      {
        final String name = constant.getName();
        final ConstMember existing = constants.get( name );
        if ( null != existing )
        {
          throw new IllegalModelException( "Failed to merge constant named '" + name + "' from mixin named '" +
                                           mixin.getName() + "' into interface " +
                                           "named '" + definition.getName() + "' as the interface already " +
                                           "contains a constant with the same name. Existing defined in:\n" +
                                           describeLocations( existing, "\n" ) + "\n" +
                                           "Attempting to add member defined in:\n" +
                                           describeLocations( constant, "\n" ) );
        }
        constants.put( name, constant );
      }
      for ( final AttributeMember attribute : mixin.getAttributes() )
      {
        final String name = attribute.getName();
        final AttributeMember existing = attributes.get( name );
        if ( null != existing )
        {
          throw new IllegalModelException( "Failed to merge attribute named '" + name + "' from mixin named '" +
                                           mixin.getName() + "' into interface " +
                                           "named '" + definition.getName() + "' as the interface already " +
                                           "contains an attribute with the same name. Existing defined in:\n" +
                                           describeLocations( existing, "\n" ) + "\n" +
                                           "Attempting to add member defined in:\n" +
                                           describeLocations( attribute, "\n" ) );
        }
        attributes.put( name, attribute );
      }
      operations.addAll( mixin.getOperations() );
    }
    return new InterfaceDefinition( definition.getName(),
                                    definition.getInherits(),
                                    Collections.unmodifiableList( new ArrayList<>( constants.values() ) ),
                                    Collections.unmodifiableList( new ArrayList<>( attributes.values() ) ),
                                    Collections.unmodifiableList( new ArrayList<>( operations ) ),
                                    iterable,
                                    asyncIterable,
                                    mapLikeMember,
                                    setLikeMember,
                                    definition.getExtendedAttributes(),
                                    Collections.unmodifiableList( sourceLocations ) );
  }

  @SuppressWarnings( "SameParameterValue" )
  @Nonnull
  private static <T extends Node> String describeLocations( @Nonnull final T existing, @Nonnull final String delimiter )
  {
    return existing.getSourceLocations()
      .stream()
      .map( l -> l.getStart().toString() )
      .collect( Collectors.joining( delimiter ) );
  }

  public static final class Config
    implements SchemaProcessorFactory
  {
    @Nonnull
    @Override
    public SchemaProcessor create()
    {
      return new FlattenProcessor();
    }
  }
}
