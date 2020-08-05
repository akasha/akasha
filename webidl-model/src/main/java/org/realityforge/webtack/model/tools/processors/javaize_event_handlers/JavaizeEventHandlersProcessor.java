package org.realityforge.webtack.model.tools.processors.javaize_event_handlers;

import java.util.Collections;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.CallbackDefinition;
import org.realityforge.webtack.model.Kind;
import org.realityforge.webtack.model.Type;
import org.realityforge.webtack.model.tools.processors.AbstractProcessor;

final class JavaizeEventHandlersProcessor
  extends AbstractProcessor
{
  JavaizeEventHandlersProcessor()
  {
  }

  @Nullable
  @Override
  protected CallbackDefinition transformCallback( @Nonnull final CallbackDefinition input )
  {
    // We assume that EventHandlerNonNull callback has been renamed to EventHandler by this stage
    if ( "EventHandler".equals( input.getName() ) )
    {
      return new CallbackDefinition( input.getName(),
                                     new Type( Kind.Void,
                                               Collections.emptyList(),
                                               false,
                                               input.getReturnType().getSourceLocations() ),
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
}
