package org.realityforge.webtack.model.tools.processors.dedup_event_member;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.EventMember;
import org.realityforge.webtack.model.InterfaceDefinition;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.tools.processors.AbstractProcessor;
import org.realityforge.webtack.model.tools.spi.PipelineContext;

final class DedupEventMemberProcessor
  extends AbstractProcessor
{
  @Nullable
  private InterfaceDefinition _interfaceType;

  DedupEventMemberProcessor( @Nonnull final PipelineContext context )
  {
    super( context );
  }

  @Nullable
  @Override
  public WebIDLSchema process( @Nonnull final WebIDLSchema schema )
  {
    schema.link();
    return super.process( schema );
  }

  @Nullable
  @Override
  protected InterfaceDefinition transformInterface( @Nonnull final InterfaceDefinition input )
  {
    try
    {
      _interfaceType = input;
      return super.transformInterface( input );
    }
    finally
    {
      _interfaceType = null;
    }
  }

  @Nullable
  @Override
  protected EventMember transformEventMember( @Nonnull final EventMember input )
  {
    if ( null == _interfaceType )
    {
      return super.transformEventMember( input );
    }
    else
    {
      final InterfaceDefinition parent = _interfaceType.getSuperInterface();
      if ( null != parent && null != parent.findEventByName( input.getName(), true ) )
      {
        return null;
      }
      else
      {
        return super.transformEventMember( input );
      }
    }
  }
}
