package org.realityforge.webtack.model.tools.processors.change_extends;

import java.util.Objects;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.InterfaceDefinition;
import org.realityforge.webtack.model.tools.processors.AbstractProcessor;
import org.realityforge.webtack.model.tools.spi.Completable;
import org.realityforge.webtack.model.tools.spi.PipelineContext;

final class ChangeExtendsProcessor
  extends AbstractProcessor
  implements Completable
{
  @Nonnull
  private final Pattern _elementNamePattern;
  @Nonnull
  private final String _parentType;
  public final int _expectedChangeCount;
  private int _changeCount;

  ChangeExtendsProcessor( @Nonnull final PipelineContext context,
                          @Nonnull final Pattern elementNamePattern,
                          @Nonnull final String parentType,
                          final int expectedChangeCount )
  {
    super( context );
    _elementNamePattern = Objects.requireNonNull( elementNamePattern );
    _parentType = Objects.requireNonNull( parentType );
    _expectedChangeCount = expectedChangeCount;
  }

  @Override
  public void onComplete()
  {
    if ( _expectedChangeCount > 0 )
    {
      if ( _changeCount != _expectedChangeCount )
      {
        context().error( "Changed " + _changeCount + " extends but expected to " +
                         "change " + _expectedChangeCount + " extends." );
      }
    }
    else
    {
      if ( 0 == _changeCount )
      {
        context().error( "Changed " + _changeCount + " extends. Remove processor." );
      }
      else
      {
        context().debug( "Changed " + _changeCount + " extends." );
      }
    }
  }

  @Nullable
  @Override
  protected InterfaceDefinition transformInterface( @Nonnull final InterfaceDefinition input )
  {
    if ( _elementNamePattern.matcher( input.getName() ).matches() )
    {
      _changeCount++;
      return new InterfaceDefinition( input.getName(),
                                      _parentType,
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
    else
    {
      return super.transformInterface( input );
    }
  }
}
