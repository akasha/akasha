package org.realityforge.webtack.model.tools.processors.javaize_event_handlers;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.Argument;
import org.realityforge.webtack.model.CallbackDefinition;
import org.realityforge.webtack.model.DocumentationElement;
import org.realityforge.webtack.model.InterfaceDefinition;
import org.realityforge.webtack.model.Kind;
import org.realityforge.webtack.model.Type;
import org.realityforge.webtack.model.TypeReference;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.tools.processors.AbstractProcessor;

final class JavaizeEventHandlersProcessor
  extends AbstractProcessor
{
  private WebIDLSchema _schema;
  @Nullable
  private String _type;

  JavaizeEventHandlersProcessor()
  {
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

    final Collection<InterfaceDefinition> interfaces = _schema.getInterfaces();
    for ( final InterfaceDefinition definition : interfaces )
    {
      final String name = definition.getName();
      if ( name.endsWith( "Event" ) && isSubclassOfEvent( definition ) )
      {
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
          new CallbackDefinition( name,
                                  newVoidType(),
                                  Collections.singletonList( argument ),
                                  new DocumentationElement( "Handle events of type " + name,
                                                            Collections.emptyList(),
                                                            Collections.emptyList() ),
                                  Collections.emptyList(),
                                  Collections.emptyList() );
        definitions.put( name, callback );
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
