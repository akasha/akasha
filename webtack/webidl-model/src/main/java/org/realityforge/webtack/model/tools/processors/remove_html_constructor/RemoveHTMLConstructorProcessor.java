package org.realityforge.webtack.model.tools.processors.remove_html_constructor;

import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.OperationMember;
import org.realityforge.webtack.model.tools.processors.AbstractProcessor;
import org.realityforge.webtack.model.tools.spi.Completable;
import org.realityforge.webtack.model.tools.spi.PipelineContext;
import org.realityforge.webtack.model.tools.util.ExtendedAttributes;

final class RemoveHTMLConstructorProcessor
  extends AbstractProcessor
  implements Completable
{
  private final int _expectedRemoveCount;
  private int _removeCount;

  RemoveHTMLConstructorProcessor( @Nonnull final PipelineContext context,
                                  final int expectedRemoveCount )
  {
    super( context );
    _expectedRemoveCount = expectedRemoveCount;
  }

  @Override
  public void onComplete()
  {
    if ( _expectedRemoveCount > 0 )
    {
      if ( _removeCount != _expectedRemoveCount )
      {
        context().error( "Removed " + _removeCount + " [HTMLConstructor] constructors but expected to " +
                         "remove " + _expectedRemoveCount + " constructors." );
      }
    }
    else
    {
      if ( 0 == _removeCount )
      {
        context().info( "Removed " + _removeCount + " [HTMLConstructor] constructors." );
      }
      else
      {
        context().debug( "Removed " + _removeCount + " [HTMLConstructor] constructors." );
      }
    }
  }

  @Nonnull
  @Override
  protected List<OperationMember> transformOperationMembers( @Nonnull final List<OperationMember> inputs )
  {
    final List<OperationMember> operations = inputs
      .stream()
      .filter( o -> !( OperationMember.Kind.CONSTRUCTOR == o.getKind() &&
                       o.isNoArgsExtendedAttributePresent( ExtendedAttributes.HTML_CONSTRUCTOR ) ) )
      .collect( Collectors.toList() );
    _removeCount += inputs.size() - operations.size();
    return super.transformOperationMembers( operations );
  }
}
