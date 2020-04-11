package org.realityforge.webtack.model;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;

public final class WebIDLSchema
{
  @Nonnull
  private final Map<String, CallbackDefinition> _callbacks;
  @Nonnull
  private final Map<String, CallbackInterfaceDefinition> _callbackInterfaces;
  @Nonnull
  private final Map<String, DictionaryDefinition> _dictionaries;
  @Nonnull
  private final Map<String, EnumerationDefinition> _enumerations;
  @Nonnull
  private final Map<String, InterfaceDefinition> _interfaces;
  @Nonnull
  private final Map<String, MixinDefinition> _mixins;
  @Nonnull
  private final Map<String, IncludesStatement> _includes;
  @Nonnull
  private final Map<String, NamespaceDefinition> _namespaces;
  @Nonnull
  private final Map<String, List<PartialDictionaryDefinition>> _partialDictionaries;
  @Nonnull
  private final Map<String, List<PartialInterfaceDefinition>> _partialInterfaces;
  @Nonnull
  private final Map<String, List<PartialMixinDefinition>> _partialMixins;
  @Nonnull
  private final Map<String, List<PartialNamespaceDefinition>> _partialNamespaces;
  @Nonnull
  private final Map<String, TypedefDefinition> _typedefs;

  public WebIDLSchema( @Nonnull final Map<String, CallbackDefinition> callbacks,
                       @Nonnull final Map<String, CallbackInterfaceDefinition> callbackInterfaces,
                       @Nonnull final Map<String, DictionaryDefinition> dictionaries,
                       @Nonnull final Map<String, EnumerationDefinition> enumerations,
                       @Nonnull final Map<String, InterfaceDefinition> interfaces,
                       @Nonnull final Map<String, MixinDefinition> mixins,
                       @Nonnull final Map<String, IncludesStatement> includes,
                       @Nonnull final Map<String, NamespaceDefinition> namespaces,
                       @Nonnull final Map<String, List<PartialDictionaryDefinition>> partialDictionaries,
                       @Nonnull final Map<String, List<PartialInterfaceDefinition>> partialInterfaces,
                       @Nonnull final Map<String, List<PartialMixinDefinition>> partialMixins,
                       @Nonnull final Map<String, List<PartialNamespaceDefinition>> partialNamespaces,
                       @Nonnull final Map<String, TypedefDefinition> typedefs )
  {
    _callbacks = Objects.requireNonNull( callbacks );
    _callbackInterfaces = Objects.requireNonNull( callbackInterfaces );
    _dictionaries = Objects.requireNonNull( dictionaries );
    _enumerations = Objects.requireNonNull( enumerations );
    _interfaces = Objects.requireNonNull( interfaces );
    _mixins = Objects.requireNonNull( mixins );
    _includes = Objects.requireNonNull( includes );
    _namespaces = Objects.requireNonNull( namespaces );
    _partialDictionaries = Objects.requireNonNull( partialDictionaries );
    _partialInterfaces = Objects.requireNonNull( partialInterfaces );
    _partialMixins = Objects.requireNonNull( partialMixins );
    _partialNamespaces = Objects.requireNonNull( partialNamespaces );
    _typedefs = Objects.requireNonNull( typedefs );
  }

  @Nonnull
  public Collection<CallbackDefinition> getCallbacks()
  {
    return _callbacks.values();
  }

  @Nonnull
  public Collection<CallbackInterfaceDefinition> getCallbackInterfaces()
  {
    return _callbackInterfaces.values();
  }

  @Nonnull
  public Collection<DictionaryDefinition> getDictionaries()
  {
    return _dictionaries.values();
  }

  @Nonnull
  public Collection<EnumerationDefinition> getEnumerations()
  {
    return _enumerations.values();
  }

  @Nonnull
  public Collection<InterfaceDefinition> getInterfaces()
  {
    return _interfaces.values();
  }

  @Nonnull
  public Collection<MixinDefinition> getMixins()
  {
    return _mixins.values();
  }

  @Nonnull
  public Collection<IncludesStatement> getIncludes()
  {
    return _includes.values();
  }

  @Nonnull
  public Collection<NamespaceDefinition> getNamespaces()
  {
    return _namespaces.values();
  }

  @Nonnull
  public Collection<PartialDictionaryDefinition> getPartialDictionaries()
  {
    return _partialDictionaries.values().stream().flatMap( Collection::stream ).collect( Collectors.toList() );
  }

  @Nonnull
  public Collection<PartialInterfaceDefinition> getPartialInterfaces()
  {
    return _partialInterfaces.values().stream().flatMap( Collection::stream ).collect( Collectors.toList() );
  }

  @Nonnull
  public Collection<PartialMixinDefinition> getPartialMixins()
  {
    return _partialMixins.values().stream().flatMap( Collection::stream ).collect( Collectors.toList() );
  }

  @Nonnull
  public Collection<PartialNamespaceDefinition> getPartialNamespaces()
  {
    return _partialNamespaces.values().stream().flatMap( Collection::stream ).collect( Collectors.toList() );
  }

  @Nonnull
  public Collection<TypedefDefinition> getTypedefs()
  {
    return _typedefs.values();
  }
}
