package org.realityforge.webtack.model.tools.processors.merge_docs;

import java.util.Collections;
import java.util.Objects;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.AttributeMember;
import org.realityforge.webtack.model.CallbackInterfaceDefinition;
import org.realityforge.webtack.model.ConstMember;
import org.realityforge.webtack.model.DocumentationBlockTag;
import org.realityforge.webtack.model.DocumentationElement;
import org.realityforge.webtack.model.InterfaceDefinition;
import org.realityforge.webtack.model.OperationMember;
import org.realityforge.webtack.model.PartialInterfaceDefinition;
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
  private String _type;

  MergeDocsProcessor( @Nonnull final DocRepositoryRuntime runtime )
  {
    _runtime = Objects.requireNonNull( runtime );
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
  protected PartialInterfaceDefinition transformPartialInterface( @Nonnull final PartialInterfaceDefinition input )
  {
    _type = input.getName();
    final DocEntry docEntry = _runtime.getDocEntry( _type );
    final PartialInterfaceDefinition definition =
      new PartialInterfaceDefinition( input.getName(),
                                      transformConstants( input.getConstants() ),
                                      transformAttributeMembers( input.getAttributes() ),
                                      transformOperationMembers( input.getOperations() ),
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
  private DocumentationElement createDocumentationElement( final DocEntry docEntry )
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