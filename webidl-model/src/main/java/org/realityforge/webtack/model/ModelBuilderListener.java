package org.realityforge.webtack.model;

import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.antlr.v4.runtime.tree.TerminalNode;
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
    final TerminalNode name = ctx.IDENTIFIER();
    final InterfaceModel interfaceModel = _repository.findOrCreateInterfaceByName( name.getSymbol().getText() );
    interfaceModel.setInherits( extractInherits( ctx ) );
  }

  @Nullable
  private String extractInherits( @Nonnull final WebIDLParser.InterfaceRestContext ctx )
  {
    final WebIDLParser.InheritanceContext inheritance = ctx.inheritance();
    if ( null != inheritance )
    {
      final TerminalNode identifier = inheritance.IDENTIFIER();
      if ( null != identifier )
      {
        return identifier.getSymbol().getText();
      }
    }
    return null;
  }
}
