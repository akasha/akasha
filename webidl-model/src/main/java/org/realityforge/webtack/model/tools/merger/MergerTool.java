package org.realityforge.webtack.model.tools.merger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.CallbackDefinition;
import org.realityforge.webtack.model.CallbackInterfaceDefinition;
import org.realityforge.webtack.model.Definition;
import org.realityforge.webtack.model.DictionaryDefinition;
import org.realityforge.webtack.model.EnumerationDefinition;
import org.realityforge.webtack.model.IllegalModelException;
import org.realityforge.webtack.model.IncludesStatement;
import org.realityforge.webtack.model.InterfaceDefinition;
import org.realityforge.webtack.model.MixinDefinition;
import org.realityforge.webtack.model.NamespaceDefinition;
import org.realityforge.webtack.model.PartialDictionaryDefinition;
import org.realityforge.webtack.model.PartialInterfaceDefinition;
import org.realityforge.webtack.model.PartialMixinDefinition;
import org.realityforge.webtack.model.PartialNamespaceDefinition;
import org.realityforge.webtack.model.SourceInterval;
import org.realityforge.webtack.model.TypedefDefinition;
import org.realityforge.webtack.model.WebIDLSchema;

public final class MergerTool
{
  /**
   * Combine two or more schemas into a single schema.
   *
   * @param schemas the schemas to combine.
   * @return the merged schema.
   */
  public WebIDLSchema merge( @Nonnull final WebIDLSchema... schemas )
  {
    Objects.requireNonNull( schemas );
    if ( schemas.length < 2 )
    {
      throw new IllegalArgumentException( "The merge operation requires 2 or more schemas to merge" );
    }
    final Map<String, CallbackDefinition> callbacks = new HashMap<>();
    final Map<String, CallbackInterfaceDefinition> callbackInterfaces = new HashMap<>();
    final Map<String, DictionaryDefinition> dictionaries = new HashMap<>();
    final Map<String, EnumerationDefinition> enumerations = new HashMap<>();
    final Map<String, InterfaceDefinition> interfaces = new HashMap<>();
    final Map<String, MixinDefinition> mixins = new HashMap<>();
    final Map<String, IncludesStatement> includes = new HashMap<>();
    final Map<String, NamespaceDefinition> namespaces = new HashMap<>();
    final Map<String, List<PartialDictionaryDefinition>> partialDictionaries = new HashMap<>();
    final Map<String, List<PartialInterfaceDefinition>> partialInterfaces = new HashMap<>();
    final Map<String, List<PartialMixinDefinition>> partialMixins = new HashMap<>();
    final Map<String, List<PartialNamespaceDefinition>> partialNamespaces = new HashMap<>();
    final Map<String, TypedefDefinition> typedefs = new HashMap<>();
    final List<SourceInterval> sourceLocations = new ArrayList<>();

    for ( final WebIDLSchema schema : schemas )
    {
      for ( final CallbackDefinition callback : schema.getCallbacks() )
      {
        addToCollection( "callbacks", callbacks, callback.getName(), callback );
      }
      for ( final CallbackInterfaceDefinition callbackInterface : schema.getCallbackInterfaces() )
      {
        addToCollection( "callback interfaces", callbackInterfaces, callbackInterface.getName(), callbackInterface );
      }
      for ( final DictionaryDefinition dictionary : schema.getDictionaries() )
      {
        addToCollection( "dictionaries", dictionaries, dictionary.getName(), dictionary );
      }
      for ( final EnumerationDefinition enumeration : schema.getEnumerations() )
      {
        addToCollection( "enumerations", enumerations, enumeration.getName(), enumeration );
      }
      for ( final InterfaceDefinition definition : schema.getInterfaces() )
      {
        addToCollection( "interfaces", interfaces, definition.getName(), definition );
      }
      for ( final MixinDefinition mixin : schema.getMixins() )
      {
        addToCollection( "mixins", mixins, mixin.getName(), mixin );
      }
      for ( final IncludesStatement include : schema.getIncludes() )
      {
        addToCollection( "includes", includes, include.getInterfaceName() + "+" + include.getMixinName(), include );
      }
      for ( final NamespaceDefinition namespace : schema.getNamespaces() )
      {
        addToCollection( "namespaces", namespaces, namespace.getName(), namespace );
      }
      for ( final TypedefDefinition typedef : schema.getTypedefs() )
      {
        addToCollection( "typedefs", typedefs, typedef.getName(), typedef );
      }
      sourceLocations.addAll( schema.getSourceLocations() );
    }
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
                             sourceLocations );
  }

  private static <T extends Definition> void addToCollection( @Nonnull final String collectionName,
                                                              @Nonnull final Map<String, T> collection,
                                                              @Nonnull final String name,
                                                              @Nonnull final T value )
  {
    final T existing = collection.get( name );
    if ( null != existing )
    {
      throw new IllegalModelException( "Multiple " + collectionName + " defined with the name '" + name + "'. " +
                                       "Existing defined in:\n" + describeLocations( existing, "\n" ) + "\n" +
                                       "Attempting to add element defined in:\n" + describeLocations( value, "\n" ) );
    }
    else
    {
      collection.put( name, value );
    }
  }

  @SuppressWarnings( "SameParameterValue" )
  @Nonnull
  private static <T extends Definition> String describeLocations( @Nonnull final T existing,
                                                                  @Nonnull final String delimiter )
  {
    return existing.getSourceLocations()
      .stream()
      .map( l -> l.getStart().toString() )
      .collect( Collectors.joining( delimiter ) );
  }
}
