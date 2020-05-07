package org.realityforge.webtack.model;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class WebIDLSchema
  extends Node
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
  private final List<IncludesStatement> _includes;
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
                       @Nonnull final List<IncludesStatement> includes,
                       @Nonnull final Map<String, NamespaceDefinition> namespaces,
                       @Nonnull final Map<String, List<PartialDictionaryDefinition>> partialDictionaries,
                       @Nonnull final Map<String, List<PartialInterfaceDefinition>> partialInterfaces,
                       @Nonnull final Map<String, List<PartialMixinDefinition>> partialMixins,
                       @Nonnull final Map<String, List<PartialNamespaceDefinition>> partialNamespaces,
                       @Nonnull final Map<String, TypedefDefinition> typedefs,
                       @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( sourceLocations );
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

  public boolean isEmpty()
  {
    return _callbacks.isEmpty() &&
           _callbackInterfaces.isEmpty() &&
           _dictionaries.isEmpty() &&
           _enumerations.isEmpty() &&
           _interfaces.isEmpty() &&
           _mixins.isEmpty() &&
           _includes.isEmpty() &&
           _namespaces.isEmpty() &&
           _partialDictionaries.isEmpty() &&
           _partialInterfaces.isEmpty() &&
           _partialMixins.isEmpty() &&
           _partialNamespaces.isEmpty() &&
           _typedefs.isEmpty();
  }

  @Nonnull
  public Collection<CallbackDefinition> getCallbacks()
  {
    return _callbacks.values();
  }

  @Nullable
  public CallbackDefinition findCallbackByName( @Nonnull final String name )
  {
    return _callbacks.get( name );
  }

  @Nonnull
  public Collection<CallbackInterfaceDefinition> getCallbackInterfaces()
  {
    return _callbackInterfaces.values();
  }

  @Nullable
  public CallbackInterfaceDefinition findCallbackInterfaceByName( @Nonnull final String name )
  {
    return _callbackInterfaces.get( name );
  }

  @Nonnull
  public Collection<DictionaryDefinition> getDictionaries()
  {
    return _dictionaries.values();
  }

  @Nullable
  public DictionaryDefinition findDictionaryByName( @Nonnull final String name )
  {
    return _dictionaries.get( name );
  }

  @Nonnull
  public Collection<EnumerationDefinition> getEnumerations()
  {
    return _enumerations.values();
  }

  @Nullable
  public EnumerationDefinition findEnumerationByName( @Nonnull final String name )
  {
    return _enumerations.get( name );
  }

  @Nonnull
  public Collection<InterfaceDefinition> getInterfaces()
  {
    return _interfaces.values();
  }

  @Nullable
  public InterfaceDefinition findInterfaceByName( @Nonnull final String name )
  {
    return _interfaces.get( name );
  }

  @Nonnull
  public Collection<MixinDefinition> getMixins()
  {
    return _mixins.values();
  }

  @Nullable
  public MixinDefinition findMixinByName( @Nonnull final String name )
  {
    return _mixins.get( name );
  }

  @Nonnull
  public Collection<IncludesStatement> getIncludes()
  {
    return _includes;
  }

  @Nonnull
  public List<IncludesStatement> findIncludesByInterfaceName( @Nonnull final String name )
  {
    return _includes
      .stream()
      .filter( i -> i.getInterfaceName().equals( name ) )
      .collect( Collectors.toList() );
  }

  @Nonnull
  public Collection<NamespaceDefinition> getNamespaces()
  {
    return _namespaces.values();
  }

  @Nullable
  public NamespaceDefinition findNamespaceByName( @Nonnull final String name )
  {
    return _namespaces.get( name );
  }

  @Nonnull
  public Collection<PartialDictionaryDefinition> getPartialDictionaries()
  {
    return _partialDictionaries.values().stream().flatMap( Collection::stream ).collect( Collectors.toList() );
  }

  @Nonnull
  public List<PartialDictionaryDefinition> findPartialDictionariesByName( @Nonnull final String name )
  {
    return _partialDictionaries.getOrDefault( name, Collections.emptyList() );
  }

  @Nonnull
  public Collection<PartialInterfaceDefinition> getPartialInterfaces()
  {
    return _partialInterfaces.values().stream().flatMap( Collection::stream ).collect( Collectors.toList() );
  }

  @Nonnull
  public List<PartialInterfaceDefinition> findPartialInterfacesByName( @Nonnull final String name )
  {
    return _partialInterfaces.getOrDefault( name, Collections.emptyList() );
  }

  @Nonnull
  public Collection<PartialMixinDefinition> getPartialMixins()
  {
    return _partialMixins.values().stream().flatMap( Collection::stream ).collect( Collectors.toList() );
  }

  @Nonnull
  public List<PartialMixinDefinition> findPartialMixinsByName( @Nonnull final String name )
  {
    return _partialMixins.getOrDefault( name, Collections.emptyList() );
  }

  @Nonnull
  public Collection<PartialNamespaceDefinition> getPartialNamespaces()
  {
    return _partialNamespaces.values().stream().flatMap( Collection::stream ).collect( Collectors.toList() );
  }

  @Nonnull
  public List<PartialNamespaceDefinition> findPartialNamespacesByName( @Nonnull final String name )
  {
    return _partialNamespaces.getOrDefault( name, Collections.emptyList() );
  }

  @Nonnull
  public Collection<TypedefDefinition> getTypedefs()
  {
    return _typedefs.values();
  }

  @Nullable
  public TypedefDefinition findTypedefByName( @Nonnull final String name )
  {
    return _typedefs.get( name );
  }

  @Override
  public boolean equals( final Object o )
  {
    if ( this == o )
    {
      return true;
    }
    else if ( o == null || getClass() != o.getClass() )
    {
      return false;
    }
    else
    {
      final WebIDLSchema other = (WebIDLSchema) o;
      return _callbacks.equals( other._callbacks ) &&
             _callbackInterfaces.equals( other._callbackInterfaces ) &&
             _dictionaries.equals( other._dictionaries ) &&
             _enumerations.equals( other._enumerations ) &&
             _interfaces.equals( other._interfaces ) &&
             _mixins.equals( other._mixins ) &&
             _includes.equals( other._includes ) &&
             _namespaces.equals( other._namespaces ) &&
             _partialDictionaries.equals( other._partialDictionaries ) &&
             _partialInterfaces.equals( other._partialInterfaces ) &&
             _partialMixins.equals( other._partialMixins ) &&
             _partialNamespaces.equals( other._partialNamespaces ) &&
             _typedefs.equals( other._typedefs );
    }
  }

  @Override
  public int hashCode()
  {
    return Objects.hash( _callbacks,
                         _callbackInterfaces,
                         _dictionaries,
                         _enumerations,
                         _interfaces,
                         _mixins,
                         _includes,
                         _namespaces,
                         _partialDictionaries,
                         _partialInterfaces,
                         _partialMixins,
                         _partialNamespaces,
                         _typedefs );
  }

  public boolean equiv( @Nonnull final WebIDLSchema other )
  {
    if ( _callbacks.size() == other._callbacks.size() &&
         _callbackInterfaces.size() == other._callbackInterfaces.size() &&
         _dictionaries.size() == other._dictionaries.size() &&
         _enumerations.size() == other._enumerations.size() &&
         _interfaces.size() == other._interfaces.size() &&
         _mixins.size() == other._mixins.size() &&
         _includes.size() == other._includes.size() &&
         _namespaces.size() == other._namespaces.size() &&
         _partialDictionaries.size() == other._partialDictionaries.size() &&
         _partialInterfaces.size() == other._partialInterfaces.size() &&
         _partialMixins.size() == other._partialMixins.size() &&
         _partialNamespaces.size() == other._partialNamespaces.size() &&
         _typedefs.size() == other._typedefs.size()
    )
    {
      final Set<CallbackDefinition> otherCallbacks = new HashSet<>( _callbacks.values() );
      for ( final CallbackDefinition definition : _callbacks.values() )
      {
        if ( !otherCallbacks.removeIf( definition::equiv ) )
        {
          return false;
        }
      }
      final Set<CallbackInterfaceDefinition> otherCallbackInterfaces = new HashSet<>( _callbackInterfaces.values() );
      for ( final CallbackInterfaceDefinition definition : _callbackInterfaces.values() )
      {
        if ( !otherCallbackInterfaces.removeIf( definition::equiv ) )
        {
          return false;
        }
      }
      final Set<DictionaryDefinition> otherDictionaries = new HashSet<>( _dictionaries.values() );
      for ( final DictionaryDefinition definition : _dictionaries.values() )
      {
        if ( !otherDictionaries.removeIf( definition::equiv ) )
        {
          return false;
        }
      }
      final Set<EnumerationDefinition> otherEnumerations = new HashSet<>( _enumerations.values() );
      for ( final EnumerationDefinition definition : _enumerations.values() )
      {
        if ( !otherEnumerations.removeIf( definition::equiv ) )
        {
          return false;
        }
      }
      final Set<InterfaceDefinition> otherInterfaces = new HashSet<>( _interfaces.values() );
      for ( final InterfaceDefinition definition : _interfaces.values() )
      {
        if ( !otherInterfaces.removeIf( definition::equiv ) )
        {
          return false;
        }
      }
      final Set<MixinDefinition> otherMixins = new HashSet<>( _mixins.values() );
      for ( final MixinDefinition definition : _mixins.values() )
      {
        if ( !otherMixins.removeIf( definition::equiv ) )
        {
          return false;
        }
      }
      final Set<IncludesStatement> otherIncludes = new HashSet<>( _includes );
      for ( final IncludesStatement definition : _includes )
      {
        if ( !otherIncludes.removeIf( definition::equiv ) )
        {
          return false;
        }
      }
      final Set<NamespaceDefinition> otherNamespaces = new HashSet<>( _namespaces.values() );
      for ( final NamespaceDefinition definition : _namespaces.values() )
      {
        if ( !otherNamespaces.removeIf( definition::equiv ) )
        {
          return false;
        }
      }
      final Set<TypedefDefinition> otherTypedefs = new HashSet<>( _typedefs.values() );
      for ( final TypedefDefinition definition : _typedefs.values() )
      {
        if ( !otherTypedefs.removeIf( definition::equiv ) )
        {
          return false;
        }
      }
      final Set<PartialDictionaryDefinition> otherPartialDictionaries =
        other._partialDictionaries.values().stream().flatMap( Collection::stream ).collect( Collectors.toSet() );
      final List<PartialDictionaryDefinition> partialDictionaries =
        _partialDictionaries.values().stream().flatMap( Collection::stream ).collect( Collectors.toList() );
      for ( final PartialDictionaryDefinition definition : partialDictionaries )
      {
        if ( !otherPartialDictionaries.removeIf( definition::equiv ) )
        {
          return false;
        }
      }
      final Set<PartialInterfaceDefinition> otherPartialInterfaces =
        other._partialInterfaces.values().stream().flatMap( Collection::stream ).collect( Collectors.toSet() );
      final List<PartialInterfaceDefinition> partialInterfaces =
        _partialInterfaces.values().stream().flatMap( Collection::stream ).collect( Collectors.toList() );
      for ( final PartialInterfaceDefinition definition : partialInterfaces )
      {
        if ( !otherPartialInterfaces.removeIf( definition::equiv ) )
        {
          return false;
        }
      }
      final Set<PartialMixinDefinition> otherPartialMixins =
        other._partialMixins.values().stream().flatMap( Collection::stream ).collect( Collectors.toSet() );
      final List<PartialMixinDefinition> partialMixins =
        _partialMixins.values().stream().flatMap( Collection::stream ).collect( Collectors.toList() );
      for ( final PartialMixinDefinition definition : partialMixins )
      {
        if ( !otherPartialMixins.removeIf( definition::equiv ) )
        {
          return false;
        }
      }
      final Set<PartialNamespaceDefinition> otherPartialNamespaces =
        other._partialNamespaces.values().stream().flatMap( Collection::stream ).collect( Collectors.toSet() );
      final List<PartialNamespaceDefinition> partialNamespaces =
        _partialNamespaces.values().stream().flatMap( Collection::stream ).collect( Collectors.toList() );
      for ( final PartialNamespaceDefinition definition : partialNamespaces )
      {
        if ( !otherPartialNamespaces.removeIf( definition::equiv ) )
        {
          return false;
        }
      }
      return true;
    }
    else
    {
      return false;
    }
  }
}
