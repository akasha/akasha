package org.realityforge.webtack.model;

import java.util.Objects;
import javax.annotation.Nonnull;
import org.realityforge.webtack.webidl.parser.WebIDLBaseListener;
import org.realityforge.webtack.webidl.parser.WebIDLListener;
import org.realityforge.webtack.webidl.parser.WebIDLParser;

public class ModelBuilderListener
  extends WebIDLBaseListener
  implements WebIDLListener
{
  @Nonnull
  private final ModelRepository _repository;

  public ModelBuilderListener( @Nonnull final ModelRepository repository )
  {
    _repository = Objects.requireNonNull( repository );
  }

  @Override
  public void exitInterfaceRest( @Nonnull final WebIDLParser.InterfaceRestContext ctx )
  {
    InterfaceModel.parse( _repository, ctx );
  }
}
