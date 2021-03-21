package org.realityforge.webtack.model.tools.actions.emit;

import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.spi.Action;
import org.realityforge.webtack.model.tools.spi.ActionFactory;
import org.realityforge.webtack.model.tools.spi.Name;
import org.realityforge.webtack.model.tools.spi.PipelineContext;

@Name( "Emit" )
public final class EmitActionFactory
  implements ActionFactory
{
  public String filePattern;

  @Nonnull
  @Override
  public Action create( @Nonnull final PipelineContext context )
  {
    if ( null == filePattern )
    {
      throw new IllegalArgumentException( "EmitAction missing required filePattern configuration value" );
    }
    return new EmitAction( filePattern );
  }
}
