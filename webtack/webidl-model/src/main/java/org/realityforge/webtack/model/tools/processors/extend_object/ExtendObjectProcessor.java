package org.realityforge.webtack.model.tools.processors.extend_object;

import javax.annotation.Nonnull;
import org.realityforge.webtack.model.InterfaceDefinition;
import org.realityforge.webtack.model.tools.processors.AbstractProcessor;
import org.realityforge.webtack.model.tools.spi.PipelineContext;

final class ExtendObjectProcessor
  extends AbstractProcessor
{
  ExtendObjectProcessor( @Nonnull final PipelineContext context )
  {
    super( context );
  }

  @Nonnull
  @Override
  protected InterfaceDefinition transformInterface( @Nonnull final InterfaceDefinition input )
  {
    final String name = input.getName();
    if ( "Object".equals( name ) || null != input.getInherits() )
    {
      return input;
    }
    else
    {
      return new InterfaceDefinition( input.getName(),
                                      "Object",
                                      transformConstants( input.getConstants() ),
                                      transformAttributeMembers( input.getAttributes() ),
                                      transformOperationMembers( input.getOperations() ),
                                      transformEventMembers( input.getEvents() ),
                                      transformIterableMember( input.getIterable() ),
                                      transformAsyncIterableMember( input.getAsyncIterable() ),
                                      transformMapLikeMember( input.getMapLikeMember() ),
                                      transformSetLikeMember( input.getSetLikeMember() ),
                                      transformDocumentation( input.getDocumentation() ),
                                      transformExtendedAttributes( input.getExtendedAttributes() ),
                                      transformSourceLocations( input.getSourceLocations() ) );

    }
  }
}
