package org.realityforge.webtack.model.tools.processors.merge_docs;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.AttributeMember;
import org.realityforge.webtack.model.CallbackInterfaceDefinition;
import org.realityforge.webtack.model.ConstMember;
import org.realityforge.webtack.model.DictionaryDefinition;
import org.realityforge.webtack.model.DictionaryMember;
import org.realityforge.webtack.model.DocumentationBlockTag;
import org.realityforge.webtack.model.DocumentationElement;
import org.realityforge.webtack.model.EventMember;
import org.realityforge.webtack.model.InterfaceDefinition;
import org.realityforge.webtack.model.MixinDefinition;
import org.realityforge.webtack.model.OperationMember;
import org.realityforge.webtack.model.PartialDictionaryDefinition;
import org.realityforge.webtack.model.PartialInterfaceDefinition;
import org.realityforge.webtack.model.PartialMixinDefinition;
import org.realityforge.webtack.model.TypeReference;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.tools.mdn_scanner.DocEntry;
import org.realityforge.webtack.model.tools.mdn_scanner.DocRepositoryRuntime;
import org.realityforge.webtack.model.tools.processors.AbstractProcessor;

/**
 * Lookup DocRepositoryRuntime for documentation for elements and add javadocs if documentation is present.
 */
final class MergeDocsProcessor
  extends AbstractProcessor
{
  @Nonnull
  private final DocRepositoryRuntime _runtime;
  private final boolean _createEvents;
  private String _type;
  private WebIDLSchema _schema;

  MergeDocsProcessor( @Nonnull final DocRepositoryRuntime runtime, final boolean createEvents )
  {
    _runtime = Objects.requireNonNull( runtime );
    _createEvents = createEvents;
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
    final DocEntry docEntry = _runtime.getDocEntry( _type );
    final CallbackInterfaceDefinition definition =
      new CallbackInterfaceDefinition( input.getName(),
                                       transformOperationMember( input.getOperation() ),
                                       transformConstants( input.getConstants() ),
                                       null == docEntry ?
                                       transformDocumentation( input.getDocumentation() ) :
                                       createDocumentationElement( docEntry ),
                                       transformExtendedAttributes( input.getExtendedAttributes() ),
                                       transformSourceLocations( input.getSourceLocations() ) );
    _type = null;
    return definition;
  }

  @Nonnull
  @Override
  protected InterfaceDefinition transformInterface( @Nonnull final InterfaceDefinition input )
  {
    _type = input.getName();
    final DocEntry docEntry = _runtime.getDocEntry( _type );
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
                               null == docEntry ?
                               transformDocumentation( input.getDocumentation() ) :
                               createDocumentationElement( docEntry ),
                               transformExtendedAttributes( input.getExtendedAttributes() ),
                               transformSourceLocations( input.getSourceLocations() ) );
    _type = null;
    return definition;
  }

  @Nonnull
  @Override
  protected List<EventMember> transformEventMembers( @Nonnull final List<EventMember> inputs )
  {
    final List<EventMember> events = super.transformEventMembers( inputs );
    if ( _createEvents )
    {
      final DocEntry docEntry = _runtime.getDocEntry( _type );
      final List<String> eventNames = null != docEntry ? docEntry.getEvents() : null;
      if ( null != eventNames )
      {
        for ( final String eventName : eventNames )
        {
          final DocEntry eventDocEntry = _runtime.getDocEntry( _type + "." + eventName + "_event" );
          if ( null != eventDocEntry &&
               events.stream().noneMatch( e -> e.getName().equals( eventName ) ) &&
               !anyPartialInterfaceContainEvent( eventName ) )
          {
            final String eventType = eventDocEntry.getEventType();
            assert null != eventType;
            events.add( new EventMember( eventName,
                                         new TypeReference( eventType,
                                                            Collections.emptyList(),
                                                            false,
                                                            Collections.emptyList() ),
                                         createDocumentationElement( docEntry ),
                                         Collections.emptyList(),
                                         Collections.emptyList() ) );
          }
        }
      }
    }
    return events;
  }

  private boolean anyPartialInterfaceContainEvent( @Nonnull final String eventName )
  {
    // TODO: In the future when mixins can contain events we will need an equiv for mixins
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
    final DocEntry docEntry = _runtime.getDocEntry( _type );
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
                                      null == docEntry ?
                                      transformDocumentation( input.getDocumentation() ) :
                                      createDocumentationElement( docEntry ),
                                      transformExtendedAttributes( input.getExtendedAttributes() ),
                                      transformSourceLocations( input.getSourceLocations() ) );
    _type = null;
    return definition;
  }

  @Nonnull
  @Override
  protected MixinDefinition transformMixin( @Nonnull final MixinDefinition input )
  {
    _type = input.getName();
    final DocEntry docEntry = _runtime.getDocEntry( _type );
    final MixinDefinition definition =
      new MixinDefinition( input.getName(),
                           transformConstants( input.getConstants() ),
                           transformAttributeMembers( input.getAttributes() ),
                           transformOperationMembers( input.getOperations() ),
                           null == docEntry ?
                           transformDocumentation( input.getDocumentation() ) :
                           createDocumentationElement( docEntry ),
                           transformExtendedAttributes( input.getExtendedAttributes() ),
                           transformSourceLocations( input.getSourceLocations() ) );
    _type = null;
    return definition;
  }

  @Nonnull
  @Override
  protected PartialMixinDefinition transformPartialMixin( @Nonnull final PartialMixinDefinition input )
  {
    _type = input.getName();
    final DocEntry docEntry = _runtime.getDocEntry( _type );
    final PartialMixinDefinition definition =
      new PartialMixinDefinition( input.getName(),
                                  transformConstants( input.getConstants() ),
                                  transformAttributeMembers( input.getAttributes() ),
                                  transformOperationMembers( input.getOperations() ),
                                  null == docEntry ?
                                  transformDocumentation( input.getDocumentation() ) :
                                  createDocumentationElement( docEntry ),
                                  transformExtendedAttributes( input.getExtendedAttributes() ),
                                  transformSourceLocations( input.getSourceLocations() ) );
    _type = null;
    return definition;
  }

  @Nonnull
  @Override
  protected DictionaryDefinition transformDictionary( @Nonnull final DictionaryDefinition input )
  {
    _type = input.getName();
    final DocEntry docEntry = _runtime.getDocEntry( _type );
    final DictionaryDefinition definition =
      new DictionaryDefinition( input.getName(),
                                input.getInherits(),
                                transformDictionaryMembers( input.getMembers() ),
                                null == docEntry ?
                                transformDocumentation( input.getDocumentation() ) :
                                createDocumentationElement( docEntry ),
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
    final DocEntry docEntry = _runtime.getDocEntry( _type );
    final PartialDictionaryDefinition definition =
      new PartialDictionaryDefinition( input.getName(),
                                       transformDictionaryMembers( input.getMembers() ),
                                       null == docEntry ?
                                       transformDocumentation( input.getDocumentation() ) :
                                       createDocumentationElement( docEntry ),
                                       transformExtendedAttributes( input.getExtendedAttributes() ),
                                       transformSourceLocations( input.getSourceLocations() ) );
    _type = null;
    return definition;
  }

  @Nonnull
  @Override
  protected ConstMember transformConstant( @Nonnull final ConstMember input )
  {
    final DocEntry docEntry = null != _type ? _runtime.getDocEntry( _type + "." + input.getName() ) : null;
    return new ConstMember( input.getName(),
                            transformType( input.getType() ),
                            transformConstValue( input.getValue() ),
                            null == docEntry ?
                            transformDocumentation( input.getDocumentation() ) :
                            createDocumentationElement( docEntry ),
                            transformExtendedAttributes( input.getExtendedAttributes() ),
                            transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  @Override
  protected EventMember transformEventMember( @Nonnull final EventMember input )
  {
    final DocEntry docEntry = null != _type ? _runtime.getDocEntry( _type + "." + input.getName() + "_event" ) : null;
    return new EventMember( input.getName(),
                            input.getEventType(),
                            null == docEntry ?
                            transformDocumentation( input.getDocumentation() ) :
                            createDocumentationElement( docEntry ),
                            transformExtendedAttributes( input.getExtendedAttributes() ),
                            transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  @Override
  protected DictionaryMember transformDictionaryMember( @Nonnull final DictionaryMember input )
  {
    final DocEntry docEntry = null != _type ? _runtime.getDocEntry( _type + "." + input.getName() ) : null;
    return new DictionaryMember( input.getName(),
                                 transformType( input.getType() ),
                                 input.isOptional(),
                                 input.getDefaultValue(),
                                 null == docEntry ?
                                 transformDocumentation( input.getDocumentation() ) :
                                 createDocumentationElement( docEntry ),
                                 transformExtendedAttributes( input.getExtendedAttributes() ),
                                 transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  @Override
  protected AttributeMember transformAttributeMember( @Nonnull final AttributeMember input )
  {
    final DocEntry docEntry = null != _type ? _runtime.getDocEntry( _type + "." + input.getName() ) : null;
    return new AttributeMember( input.getName(),
                                transformType( input.getType() ),
                                input.getModifiers(),
                                null == docEntry ?
                                transformDocumentation( input.getDocumentation() ) :
                                createDocumentationElement( docEntry ),
                                transformExtendedAttributes( input.getExtendedAttributes() ),
                                transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  @Override
  protected OperationMember transformOperationMember( @Nonnull final OperationMember input )
  {
    final DocEntry docEntry = null != _type ? _runtime.getDocEntry( _type + "." + input.getName() ) : null;
    return new OperationMember( input.getKind(),
                                input.getName(),
                                transformArguments( input.getArguments() ),
                                transformType( input.getReturnType() ),
                                null == docEntry ?
                                transformDocumentation( input.getDocumentation() ) :
                                createDocumentationElement( docEntry ),
                                transformExtendedAttributes( input.getExtendedAttributes() ),
                                transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  @Override
  protected OperationMember transformOptionalOperationMember( @Nonnull final OperationMember input )
  {
    return transformOperationMember( input );
  }

  @Nonnull
  private DocumentationElement createDocumentationElement( @Nonnull final DocEntry docEntry )
  {
    return new DocumentationElement( docEntry.getDescription(),
                                     Collections.singletonList( seeTag( docEntry ) ),
                                     Collections.emptyList() );
  }

  @Nonnull
  private DocumentationBlockTag seeTag( @Nonnull final DocEntry docEntry )
  {
    final String seeLink = "<a href=\"" + docEntry.getHref() + "\">" + docEntry.getName() + " - MDN</a>";
    return new DocumentationBlockTag( "see", seeLink );
  }
}
