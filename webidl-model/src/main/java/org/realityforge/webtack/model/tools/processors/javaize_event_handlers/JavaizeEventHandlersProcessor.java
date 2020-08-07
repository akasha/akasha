package org.realityforge.webtack.model.tools.processors.javaize_event_handlers;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.Argument;
import org.realityforge.webtack.model.AttributeMember;
import org.realityforge.webtack.model.CallbackDefinition;
import org.realityforge.webtack.model.CallbackInterfaceDefinition;
import org.realityforge.webtack.model.DictionaryDefinition;
import org.realityforge.webtack.model.DocumentationElement;
import org.realityforge.webtack.model.EnumerationDefinition;
import org.realityforge.webtack.model.EventMember;
import org.realityforge.webtack.model.IncludesStatement;
import org.realityforge.webtack.model.InterfaceDefinition;
import org.realityforge.webtack.model.Kind;
import org.realityforge.webtack.model.MixinDefinition;
import org.realityforge.webtack.model.NamespaceDefinition;
import org.realityforge.webtack.model.OperationMember;
import org.realityforge.webtack.model.PartialDictionaryDefinition;
import org.realityforge.webtack.model.PartialInterfaceDefinition;
import org.realityforge.webtack.model.PartialMixinDefinition;
import org.realityforge.webtack.model.PartialNamespaceDefinition;
import org.realityforge.webtack.model.Type;
import org.realityforge.webtack.model.TypeReference;
import org.realityforge.webtack.model.TypedefDefinition;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.tools.mdn_scanner.DocEntry;
import org.realityforge.webtack.model.tools.mdn_scanner.DocRepositoryRuntime;
import org.realityforge.webtack.model.tools.processors.AbstractProcessor;

final class JavaizeEventHandlersProcessor
  extends AbstractProcessor
{
  @Nonnull
  private final DocRepositoryRuntime _runtime;
  private WebIDLSchema _schema;
  @Nonnull
  private final Set<String> _declaredHandlers = new HashSet<>();
  @Nonnull
  private final Set<String> _usedHandlers = new HashSet<>();
  @Nonnull
  private final Set<String> _declaredListeners = new HashSet<>();
  @Nonnull
  private final Set<String> _usedListeners = new HashSet<>();
  @Nullable
  private String _type;

  JavaizeEventHandlersProcessor( @Nonnull final DocRepositoryRuntime runtime )
  {
    _runtime = Objects.requireNonNull( runtime );
  }

  @Nullable
  @Override
  public WebIDLSchema process( @Nonnull final WebIDLSchema schema )
  {
    try
    {
      _schema = schema;
      schema.link();
      return super.process( schema );
    }
    finally
    {
      _declaredHandlers.clear();
      _usedHandlers.clear();
      _declaredListeners.clear();
      _usedListeners.clear();
      _schema = null;
    }
  }

  @Nullable
  @Override
  protected CallbackDefinition transformCallback( @Nonnull final CallbackDefinition input )
  {
    // We assume that EventHandlerNonNull callback has been renamed to EventHandler by this stage
    if ( "EventHandler".equals( input.getName() ) )
    {
      return new CallbackDefinition( input.getName(),
                                     newVoidType(),
                                     transformArguments( input.getArguments() ),
                                     transformDocumentation( input.getDocumentation() ),
                                     transformExtendedAttributes( input.getExtendedAttributes() ),
                                     transformSourceLocations( input.getSourceLocations() ) );
    }
    else
    {
      return super.transformCallback( input );
    }
  }

  @Nonnull
  @Override
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

    for ( final InterfaceDefinition definition : _schema.getInterfaces() )
    {
      final String name = definition.getName();
      if ( name.endsWith( "Event" ) && isSubclassOfEvent( definition ) )
      {
        final String handlerName = name + "Handler";
        _declaredHandlers.add( handlerName );
        final TypeReference eventType =
          new TypeReference( name, Collections.emptyList(), false, Collections.emptyList() );
        final Argument argument =
          new Argument( "event",
                        eventType,
                        false,
                        false,
                        null,
                        new DocumentationElement( "the event", Collections.emptyList(), Collections.emptyList() ),
                        Collections.emptyList(),
                        Collections.emptyList() );
        final CallbackDefinition callback =
          new CallbackDefinition( handlerName,
                                  newVoidType(),
                                  Collections.singletonList( argument ),
                                  new DocumentationElement( "Handle events of type " + name,
                                                            Collections.emptyList(),
                                                            Collections.emptyList() ),
                                  Collections.emptyList(),
                                  Collections.emptyList() );
        definitions.put( handlerName, callback );
      }
    }

    return definitions;
  }

  @Nonnull
  @Override
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
    for ( final InterfaceDefinition definition : _schema.getInterfaces() )
    {
      final String name = definition.getName();
      if ( name.endsWith( "Event" ) && isSubclassOfEvent( definition ) )
      {
        final String listenerName = name + "Listener";
        _declaredListeners.add( listenerName );

        final TypeReference eventType =
          new TypeReference( name, Collections.emptyList(), false, Collections.emptyList() );
        final Argument argument =
          new Argument( "event",
                        eventType,
                        false,
                        false,
                        null,
                        new DocumentationElement( "the event", Collections.emptyList(), Collections.emptyList() ),
                        Collections.emptyList(),
                        Collections.emptyList() );
        final OperationMember operation =
          new OperationMember( OperationMember.Kind.DEFAULT,
                               "handleEvent",
                               Collections.singletonList( argument ),
                               newVoidType(),
                               new DocumentationElement( "Handle event of type " + name,
                                                         Collections.emptyList(),
                                                         Collections.emptyList() ),
                               Collections.emptyList(),
                               Collections.emptyList() );
        final CallbackInterfaceDefinition callbackInterface =
          new CallbackInterfaceDefinition( listenerName,
                                           operation,
                                           Collections.emptyList(),
                                           new DocumentationElement( "Listener for events of type " + name,
                                                                     Collections.emptyList(),
                                                                     Collections.emptyList() ),
                                           Collections.emptyList(),
                                           Collections.emptyList() );
        definitions.put( listenerName, callbackInterface );
      }
    }
    return definitions;
  }

  @Nullable
  @Override
  protected MixinDefinition transformMixin( @Nonnull final MixinDefinition input )
  {
    try
    {
      _type = input.getName();
      return super.transformMixin( input );
    }
    finally
    {
      _type = null;
    }
  }

  @Nullable
  @Override
  protected PartialMixinDefinition transformPartialMixin( @Nonnull final PartialMixinDefinition input )
  {
    try
    {
      _type = input.getName();
      return super.transformPartialMixin( input );
    }
    finally
    {
      _type = null;
    }
  }

  @Nullable
  @Override
  protected InterfaceDefinition transformInterface( @Nonnull final InterfaceDefinition input )
  {
    try
    {
      _type = input.getName();
      return super.transformInterface( input );
    }
    finally
    {
      _type = null;
    }
  }

  @Nullable
  @Override
  protected PartialInterfaceDefinition transformPartialInterface( @Nonnull final PartialInterfaceDefinition input )
  {
    try
    {
      _type = input.getName();
      return super.transformPartialInterface( input );
    }
    finally
    {
      _type = null;
    }
  }

  @Nullable
  @Override
  protected AttributeMember transformAttributeMember( @Nonnull final AttributeMember input )
  {
    if ( isEventHandlerProperty( input ) )
    {
      assert null != _type;
      final DocEntry typeDocEntry = _runtime.getDocEntry( _type );
      if ( null != typeDocEntry )
      {
        final List<String> events = typeDocEntry.getEvents();
        if ( null != events )
        {
          for ( final String event : events )
          {
            final DocEntry eventDocEntry = _runtime.getDocEntry( _type + "." + event + "_event" );
            if ( null != eventDocEntry )
            {
              final String eventHandlerProperty = eventDocEntry.getEventHandlerProperty();
              if ( input.getName().equals( eventHandlerProperty ) )
              {
                final String eventTypeName = eventDocEntry.getEventType();
                assert null != eventTypeName;
                // EventSource.error is documented as so this code essentially guards
                // against this scenario which would generate bad code
                if ( !eventTypeName.contains( " or " ) )
                {
                  final String handlerName = eventTypeName + "Handler";
                  _usedHandlers.add( handlerName );
                  return new AttributeMember( input.getName(),
                                              new TypeReference( handlerName,
                                                                 Collections.emptyList(),
                                                                 true,
                                                                 Collections.emptyList() ),
                                              input.getModifiers(),
                                              transformDocumentation( input.getDocumentation() ),
                                              transformExtendedAttributes( input.getExtendedAttributes() ),
                                              transformSourceLocations( input.getSourceLocations() ) );
                }
              }
            }
          }
        }
      }
    }
    return super.transformAttributeMember( input );
  }

  @Nonnull
  @Override
  protected EventMember transformEventMember( @Nonnull final EventMember input )
  {
    final EventMember output = super.transformEventMember( input );
    assert null != output;
    _usedListeners.add( output.getEventType().getName() + "Listener" );
    return output;
  }

  @Nonnull
  @Override
  protected WebIDLSchema createSchema( @Nonnull final WebIDLSchema schema,
                                       @Nonnull final Map<String, CallbackDefinition> callbacks,
                                       @Nonnull final Map<String, CallbackInterfaceDefinition> callbackInterfaces,
                                       @Nonnull final Map<String, EnumerationDefinition> enumerations,
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
    // Remove any handlers that were not actually used
    final Set<String> unusedHandlers = new HashSet<>( _declaredHandlers );
    unusedHandlers.removeAll( _usedHandlers );
    for ( final String unusedHandler : unusedHandlers )
    {
      callbacks.remove( unusedHandler );
    }

    // Remove any event listeners that were not actually used
    final Set<String> unusedListeners = new HashSet<>( _declaredListeners );
    unusedListeners.removeAll( _usedListeners );
    for ( final String unusedListener : unusedListeners )
    {
      callbackInterfaces.remove( unusedListener );
    }

    return super.createSchema( schema,
                               callbacks,
                               callbackInterfaces,
                               enumerations,
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

  private boolean isEventHandlerProperty( @Nonnull final AttributeMember input )
  {
    // Assume NullableEventHandler rename has already occurred
    final Type type = input.getType();
    return Kind.TypeReference == type.getKind() &&
           "NullableEventHandler".equals( ( (TypeReference) type ).getName() ) &&
           input.getName().startsWith( "on" );
  }

  private boolean isSubclassOfEvent( @Nonnull final InterfaceDefinition definition )
  {
    final InterfaceDefinition parent = definition.getSuperInterface();
    return null != parent && ( parent.getName().equals( "Event" ) || isSubclassOfEvent( parent ) );
  }

  @Nonnull
  private Type newVoidType()
  {
    return new Type( Kind.Void, Collections.emptyList(), false, Collections.emptyList() );
  }
}
