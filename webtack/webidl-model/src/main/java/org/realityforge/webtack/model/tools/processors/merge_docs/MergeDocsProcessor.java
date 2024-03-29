package org.realityforge.webtack.model.tools.processors.merge_docs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.AttributeMember;
import org.realityforge.webtack.model.CallbackInterfaceDefinition;
import org.realityforge.webtack.model.ConstMember;
import org.realityforge.webtack.model.DictionaryDefinition;
import org.realityforge.webtack.model.DictionaryMember;
import org.realityforge.webtack.model.DocumentationElement;
import org.realityforge.webtack.model.Element;
import org.realityforge.webtack.model.EventMember;
import org.realityforge.webtack.model.EventMemberContainer;
import org.realityforge.webtack.model.ExtendedAttribute;
import org.realityforge.webtack.model.InterfaceDefinition;
import org.realityforge.webtack.model.MixinDefinition;
import org.realityforge.webtack.model.NamespaceDefinition;
import org.realityforge.webtack.model.OperationMember;
import org.realityforge.webtack.model.PartialDictionaryDefinition;
import org.realityforge.webtack.model.PartialInterfaceDefinition;
import org.realityforge.webtack.model.PartialMixinDefinition;
import org.realityforge.webtack.model.PartialNamespaceDefinition;
import org.realityforge.webtack.model.TypeReference;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.tools.mdn_scanner.DocEntry;
import org.realityforge.webtack.model.tools.mdn_scanner.config2.DocEntryUtil;
import org.realityforge.webtack.model.tools.mdn_scanner.config2.DocIndex;
import org.realityforge.webtack.model.tools.mdn_scanner.config2.EntryIndex;
import org.realityforge.webtack.model.tools.processors.AbstractProcessor;
import org.realityforge.webtack.model.tools.spi.PipelineContext;

/**
 * Lookup DocRepositoryRuntime for documentation for elements and add javadocs if documentation is present.
 */
final class MergeDocsProcessor
  extends AbstractProcessor
{
  private final boolean _createEvents;
  @Nonnull
  private final Map<String, ArrayList<String>> _aliases;
  @Nonnull
  private final Map<String, ArrayList<String>> _memberAliases;
  @Nullable
  private String _type;
  private boolean _typeIsMixin;
  @Nullable
  private EventMemberContainer _eventContainer;
  @Nullable
  private WebIDLSchema _schema;

  MergeDocsProcessor( @Nonnull final PipelineContext context,
                      final boolean createEvents,
                      @Nonnull final Map<String, ArrayList<String>> aliases,
                      @Nonnull final Map<String, ArrayList<String>> memberAliases )
  {
    super( context );
    _createEvents = createEvents;
    _aliases = Objects.requireNonNull( aliases );
    _memberAliases = memberAliases;
  }

  @Nullable
  @Override
  public WebIDLSchema process( @Nonnull final WebIDLSchema schema )
  {
    try
    {
      _schema = schema;
      return super.process( schema );
    }
    finally
    {
      _schema = null;
    }
  }

  @Nonnull
  @Override
  protected CallbackInterfaceDefinition transformCallbackInterface( @Nonnull final CallbackInterfaceDefinition input )
  {
    _type = input.getName();
    _typeIsMixin = false;
    final DocEntry docEntry = findTypeDocEntry();
    final CallbackInterfaceDefinition definition =
      new CallbackInterfaceDefinition( input.getName(),
                                       transformOperationMember( input.getOperation() ),
                                       transformConstants( input.getConstants() ),
                                       shouldUseInputDocs( input, docEntry ) ?
                                       transformDocumentation( input.getDocumentation() ) :
                                       DocEntryUtil.createDocumentationElement( docEntry ),
                                       transformExtendedAttributes( input.getExtendedAttributes() ),
                                       transformSourceLocations( input.getSourceLocations() ) );
    _type = null;
    return definition;
  }

  @Nonnull
  @Override
  protected InterfaceDefinition transformInterface( @Nonnull final InterfaceDefinition input )
  {
    final String namespace = input.getNamespace();
    _type = ( null == namespace ? "" : namespace + "." ) + input.getName();
    _typeIsMixin = false;
    _eventContainer = input;
    final DocEntry docEntry = findTypeDocEntry();
    final InterfaceDefinition definition =
      new InterfaceDefinition( input.getName(),
                               input.getInherits(),
                               transformConstants( input.getConstants() ),
                               transformAttributeMembers( input.getAttributes() ),
                               transformOperationMembers( input.getOperations() ),
                               transformEventMembers( input.getEvents() ),
                               transformIterableMember( input.getIterable() ),
                               transformAsyncIterableMember( input.getAsyncIterable() ),
                               transformMapLikeMember( input.getMapLikeMember() ),
                               transformSetLikeMember( input.getSetLikeMember() ),
                               shouldUseInputDocs( input, docEntry ) ?
                               transformDocumentation( input.getDocumentation() ) :
                               DocEntryUtil.createDocumentationElement( docEntry ),
                               transformExtendedAttributes( input.getExtendedAttributes() ),
                               transformSourceLocations( input.getSourceLocations() ) );
    _type = null;
    _eventContainer = null;
    return definition;
  }

  @Nonnull
  @Override
  protected List<EventMember> transformEventMembers( @Nonnull final List<EventMember> inputs )
  {
    final List<EventMember> events = super.transformEventMembers( inputs );
    if ( _createEvents )
    {
      assert null != _type;
      final DocIndex index = context().docRepository().findIndexForType( _type );
      final List<EntryIndex> entries =
        null != index ?
        index.getEntries().stream().filter( e -> e.getName().endsWith( "_event" ) ).collect( Collectors.toList() ) :
        null;
      if ( null != entries )
      {
        for ( final EntryIndex eventIndex : entries )
        {
          final DocEntry eventDocEntry = context().docRepository().getDocEntry( eventIndex );
          final String eventName = eventDocEntry.getEventName();
          assert null != eventName;
          if ( events.stream().noneMatch( e -> e.getName().equals( eventName ) ) && !partialContainsEvent( eventName ) )
          {
            final String eventTypeOverride = index.getEventMap().get( eventName );
            final String eventType = null == eventTypeOverride ? eventDocEntry.getEventType() : eventTypeOverride;
            assert null != eventType;
            // Some events are a union and we don't yet represent this scenario so this will fail
            // It will also skip adding events that are documented on MDN but are deprecated and no longer part of the spec
            assert null != _schema;
            if ( null != _schema.findInterfaceByName( eventType ) )
            {
              final List<ExtendedAttribute> attributes = new ArrayList<>();
              if ( Boolean.FALSE == eventDocEntry.getEventBubbles() )
              {
                attributes.add( ExtendedAttribute.createNoArgs( "NoBubble" ) );
              }
              if ( Boolean.FALSE == eventDocEntry.getEventCancelable() )
              {
                attributes.add( ExtendedAttribute.createNoArgs( "NoCancel" ) );
              }
              events.add( new EventMember( eventName,
                                           new TypeReference( eventType,
                                                              Collections.emptyList(),
                                                              false,
                                                              Collections.emptyList() ),
                                           DocEntryUtil.createDocumentationElement( eventDocEntry ),
                                           attributes,
                                           Collections.emptyList() ) );
            }
          }
        }
      }

      if ( null != index )
      {
        for ( final Map.Entry<String, String> entry : index.getEventMap().entrySet() )
        {
          final String eventName = entry.getKey();
          final String eventType = entry.getValue();
          assert null != _eventContainer;
          // Only create event if not already defined
          if ( events.stream().noneMatch( e -> e.getName().equals( eventName ) ) && !partialContainsEvent( eventName ) )
          {
            assert null != _schema;
            if ( null != _schema.findInterfaceByName( eventType ) )
            {
              events.add( new EventMember( eventName,
                                           new TypeReference( eventType,
                                                              Collections.emptyList(),
                                                              false,
                                                              Collections.emptyList() ),
                                           null,
                                           Collections.emptyList(),
                                           Collections.emptyList() ) );
            }
          }
        }
      }
    }
    return events;
  }

  @SuppressWarnings( "BooleanMethodIsAlwaysInverted" )
  private boolean partialContainsEvent( @Nonnull final String eventName )
  {
    return _typeIsMixin ? anyPartialMixinContainEvent( eventName ) : anyPartialInterfaceContainEvent( eventName );
  }

  private boolean anyPartialMixinContainEvent( @Nonnull final String eventName )
  {
    assert null != _schema;
    assert null != _type;
    for ( final PartialMixinDefinition definition : _schema.findPartialMixinsByName( _type ) )
    {
      if ( definition.getEvents().stream().anyMatch( e -> e.getName().equals( eventName ) ) )
      {
        return true;
      }
    }
    return false;
  }

  private boolean anyPartialInterfaceContainEvent( @Nonnull final String eventName )
  {
    assert null != _schema;
    assert null != _type;
    for ( final PartialInterfaceDefinition definition : _schema.findPartialInterfacesByName( _type ) )
    {
      if ( definition.getEvents().stream().anyMatch( e -> e.getName().equals( eventName ) ) )
      {
        return true;
      }
    }
    return false;
  }

  @Nonnull
  @Override
  protected PartialInterfaceDefinition transformPartialInterface( @Nonnull final PartialInterfaceDefinition input )
  {
    _type = input.getName();
    _eventContainer = input;
    _typeIsMixin = false;
    final DocEntry docEntry = findTypeDocEntry();
    final PartialInterfaceDefinition definition =
      new PartialInterfaceDefinition( input.getName(),
                                      transformConstants( input.getConstants() ),
                                      transformAttributeMembers( input.getAttributes() ),
                                      transformOperationMembers( input.getOperations() ),
                                      // Deliberately call super here so that only interfaces
                                      // pick up events otherwise multiple partial interfaces
                                      // or a partial and an actual interface would both receive
                                      // events that are part of the docs which would cause errors
                                      super.transformEventMembers( input.getEvents() ),
                                      transformIterableMember( input.getIterable() ),
                                      transformAsyncIterableMember( input.getAsyncIterable() ),
                                      transformMapLikeMember( input.getMapLikeMember() ),
                                      transformSetLikeMember( input.getSetLikeMember() ),
                                      shouldUseInputDocs( input, docEntry ) ?
                                      transformDocumentation( input.getDocumentation() ) :
                                      DocEntryUtil.createDocumentationElement( docEntry ),
                                      transformExtendedAttributes( input.getExtendedAttributes() ),
                                      transformSourceLocations( input.getSourceLocations() ) );
    _type = null;
    _eventContainer = null;
    return definition;
  }

  @Nonnull
  @Override
  protected MixinDefinition transformMixin( @Nonnull final MixinDefinition input )
  {
    _type = input.getName();
    _eventContainer = input;
    _typeIsMixin = true;
    final DocEntry docEntry = findTypeDocEntry();
    final MixinDefinition definition =
      new MixinDefinition( input.getName(),
                           transformConstants( input.getConstants() ),
                           transformAttributeMembers( input.getAttributes() ),
                           transformOperationMembers( input.getOperations() ),
                           transformEventMembers( input.getEvents() ),
                           shouldUseInputDocs( input, docEntry ) ?
                           transformDocumentation( input.getDocumentation() ) :
                           DocEntryUtil.createDocumentationElement( docEntry ),
                           transformExtendedAttributes( input.getExtendedAttributes() ),
                           transformSourceLocations( input.getSourceLocations() ) );
    _type = null;
    _eventContainer = null;
    return definition;
  }

  @Nonnull
  @Override
  protected PartialMixinDefinition transformPartialMixin( @Nonnull final PartialMixinDefinition input )
  {
    _type = input.getName();
    _eventContainer = input;
    _typeIsMixin = true;
    final DocEntry docEntry = findTypeDocEntry();
    final PartialMixinDefinition definition =
      new PartialMixinDefinition( input.getName(),
                                  transformConstants( input.getConstants() ),
                                  transformAttributeMembers( input.getAttributes() ),
                                  transformOperationMembers( input.getOperations() ),
                                  transformEventMembers( input.getEvents() ),
                                  shouldUseInputDocs( input, docEntry ) ?
                                  transformDocumentation( input.getDocumentation() ) :
                                  DocEntryUtil.createDocumentationElement( docEntry ),
                                  transformExtendedAttributes( input.getExtendedAttributes() ),
                                  transformSourceLocations( input.getSourceLocations() ) );
    _type = null;
    _eventContainer = null;
    return definition;
  }

  @Nonnull
  @Override
  protected DictionaryDefinition transformDictionary( @Nonnull final DictionaryDefinition input )
  {
    _type = input.getName();
    _typeIsMixin = false;
    final DocEntry docEntry = findTypeDocEntry();
    final DictionaryDefinition definition =
      new DictionaryDefinition( input.getName(),
                                input.getInherits(),
                                transformDictionaryMembers( input.getMembers() ),
                                shouldUseInputDocs( input, docEntry ) ?
                                transformDocumentation( input.getDocumentation() ) :
                                DocEntryUtil.createDocumentationElement( docEntry ),
                                transformExtendedAttributes( input.getExtendedAttributes() ),
                                transformSourceLocations( input.getSourceLocations() ) );
    _type = null;
    return definition;
  }

  @Nonnull
  @Override
  protected PartialDictionaryDefinition transformPartialDictionary( @Nonnull final PartialDictionaryDefinition input )
  {
    _type = input.getName();
    _typeIsMixin = false;
    final DocEntry docEntry = findTypeDocEntry();
    final PartialDictionaryDefinition definition =
      new PartialDictionaryDefinition( input.getName(),
                                       transformDictionaryMembers( input.getMembers() ),
                                       shouldUseInputDocs( input, docEntry ) ?
                                       transformDocumentation( input.getDocumentation() ) :
                                       DocEntryUtil.createDocumentationElement( docEntry ),
                                       transformExtendedAttributes( input.getExtendedAttributes() ),
                                       transformSourceLocations( input.getSourceLocations() ) );
    _type = null;
    return definition;
  }

  @Nonnull
  @Override
  protected NamespaceDefinition transformNamespace( @Nonnull final NamespaceDefinition input )
  {
    _type = input.getName();
    _typeIsMixin = false;
    final DocEntry docEntry = findTypeDocEntry();
    final NamespaceDefinition definition =
      new NamespaceDefinition( input.getName(),
                               transformConstants( input.getConstants() ),
                               transformOperationMembers( input.getOperations() ),
                               transformAttributeMembers( input.getAttributes() ),
                               shouldUseInputDocs( input, docEntry ) ?
                               transformDocumentation( input.getDocumentation() ) :
                               DocEntryUtil.createDocumentationElement( docEntry ),
                               transformExtendedAttributes( input.getExtendedAttributes() ),
                               transformSourceLocations( input.getSourceLocations() ) );
    _type = null;
    return definition;
  }

  @Nonnull
  @Override
  protected PartialNamespaceDefinition transformPartialNamespace( @Nonnull final PartialNamespaceDefinition input )
  {
    _type = input.getName();
    _typeIsMixin = false;
    final DocEntry docEntry = findTypeDocEntry();
    final PartialNamespaceDefinition definition =
      new PartialNamespaceDefinition( input.getName(),
                                      transformConstants( input.getConstants() ),
                                      transformOperationMembers( input.getOperations() ),
                                      transformAttributeMembers( input.getAttributes() ),
                                      shouldUseInputDocs( input, docEntry ) ?
                                      transformDocumentation( input.getDocumentation() ) :
                                      DocEntryUtil.createDocumentationElement( docEntry ),
                                      transformExtendedAttributes( input.getExtendedAttributes() ),
                                      transformSourceLocations( input.getSourceLocations() ) );
    _type = null;
    return definition;
  }

  @Nonnull
  @Override
  protected ConstMember transformConstant( @Nonnull final ConstMember input )
  {
    final DocEntry docEntry = findMemberDocEntry( input.getName() );
    return new ConstMember( input.getName(),
                            transformType( input.getType() ),
                            transformConstValue( input.getValue() ),
                            shouldUseInputDocs( input, docEntry ) ?
                            transformDocumentation( input.getDocumentation() ) :
                            DocEntryUtil.createDocumentationElement( docEntry ),
                            transformExtendedAttributes( input.getExtendedAttributes() ),
                            transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  @Override
  protected EventMember transformEventMember( @Nonnull final EventMember input )
  {
    final DocEntry docEntry = findMemberDocEntry( input.getName() + "_event" );
    return new EventMember( input.getName(),
                            input.getEventType(),
                            shouldUseInputDocs( input, docEntry ) ?
                            transformDocumentation( input.getDocumentation() ) :
                            DocEntryUtil.createDocumentationElement( docEntry ),
                            transformExtendedAttributes( input.getExtendedAttributes() ),
                            transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  @Override
  protected DictionaryMember transformDictionaryMember( @Nonnull final DictionaryMember input )
  {
    final DocEntry docEntry = findMemberDocEntry( input.getName() );
    return new DictionaryMember( input.getName(),
                                 transformType( input.getType() ),
                                 input.isOptional(),
                                 input.getDefaultValue(),
                                 shouldUseInputDocs( input, docEntry ) ?
                                 transformDocumentation( input.getDocumentation() ) :
                                 DocEntryUtil.createDocumentationElement( docEntry ),
                                 transformExtendedAttributes( input.getExtendedAttributes() ),
                                 transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  @Override
  protected AttributeMember transformAttributeMember( @Nonnull final AttributeMember input )
  {
    final DocEntry docEntry = findMemberDocEntry( input.getName() );
    return new AttributeMember( input.getName(),
                                transformType( input.getType() ),
                                input.getModifiers(),
                                shouldUseInputDocs( input, docEntry ) ?
                                transformDocumentation( input.getDocumentation() ) :
                                DocEntryUtil.createDocumentationElement( docEntry ),
                                transformExtendedAttributes( input.getExtendedAttributes() ),
                                transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  @Override
  protected OperationMember transformOperationMember( @Nonnull final OperationMember input )
  {
    final String member = OperationMember.Kind.CONSTRUCTOR == input.getKind() ? _type : input.getName();
    final DocEntry docEntry = null != member ? findMemberDocEntry( member ) : null;
    return new OperationMember( input.getKind(),
                                input.getName(),
                                transformArguments( input.getArguments() ),
                                transformType( input.getReturnType() ),
                                shouldUseInputDocs( input, docEntry ) ?
                                transformDocumentation( input.getDocumentation() ) :
                                DocEntryUtil.createDocumentationElement( docEntry ),
                                transformExtendedAttributes( input.getExtendedAttributes() ),
                                transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nullable
  private DocEntry findTypeDocEntry()
  {
    return findDocEntry( _type, null );
  }

  @Nullable
  private DocEntry findMemberDocEntry( @Nullable final String member )
  {
    return findDocEntry( _type, member );
  }

  @Nullable
  private DocEntry findDocEntry( @Nullable final String type, @Nullable final String member )
  {
    if ( null != type )
    {
      final DocEntry entry = context().docRepository().findDocEntry( type, member );
      if ( null != entry )
      {
        return entry;
      }
      else
      {
        final List<String> aliases = _aliases.get( type );
        if ( null != aliases )
        {
          for ( final String alias : aliases )
          {
            final DocEntry aliasEntry = context().docRepository().findDocEntry( alias, member );
            if ( null != aliasEntry )
            {
              return aliasEntry;
            }
            if ( null != member )
            {
              final List<String> memberAliases = _memberAliases.get( type + "." + member );
              if ( null != memberAliases )
              {
                for ( final String memberAlias : memberAliases )
                {
                  final String[] parts = memberAlias.split( "\\." );
                  final DocEntry memberAliasEntry = context().docRepository().findDocEntry( parts[ 0 ], parts[ 1 ] );
                  if ( null != memberAliasEntry )
                  {
                    return memberAliasEntry;
                  }
                }
              }
            }
          }
        }
        return null;
      }
    }
    else
    {
      return null;
    }
  }

  @Nonnull
  @Override
  protected OperationMember transformOptionalOperationMember( @Nonnull final OperationMember input )
  {
    return transformOperationMember( input );
  }

  private boolean shouldUseInputDocs( @Nonnull final Element input, @Nullable final DocEntry docEntry )
  {
    if ( null == docEntry )
    {
      return true;
    }
    else
    {
      final DocumentationElement documentation = input.getDocumentation();
      return null != documentation && !documentation.isSynthetic();
    }
  }
}
