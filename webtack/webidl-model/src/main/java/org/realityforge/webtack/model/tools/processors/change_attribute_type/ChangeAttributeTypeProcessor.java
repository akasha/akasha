package org.realityforge.webtack.model.tools.processors.change_attribute_type;

import java.util.Objects;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.AttributeMember;
import org.realityforge.webtack.model.InterfaceDefinition;
import org.realityforge.webtack.model.MixinDefinition;
import org.realityforge.webtack.model.NamedDefinition;
import org.realityforge.webtack.model.NamedElement;
import org.realityforge.webtack.model.NamespaceDefinition;
import org.realityforge.webtack.model.PartialInterfaceDefinition;
import org.realityforge.webtack.model.PartialMixinDefinition;
import org.realityforge.webtack.model.PartialNamespaceDefinition;
import org.realityforge.webtack.model.Type;
import org.realityforge.webtack.model.tools.processors.AbstractProcessor;
import org.realityforge.webtack.model.tools.spi.Completable;
import org.realityforge.webtack.model.tools.spi.PipelineContext;

final class ChangeAttributeTypeProcessor
  extends AbstractProcessor
  implements Completable
{
  @Nonnull
  private final Pattern _elementNamePattern;
  @Nonnull
  private final Pattern _attributeNamePattern;
  @Nonnull
  private final Type _type;
  private boolean _lastElementMatched;
  public final int _expectedChangeCount;
  private int _changeCount;

  ChangeAttributeTypeProcessor( @Nonnull final PipelineContext context,
                                @Nonnull final Pattern elementNamePattern,
                                @Nonnull final Pattern attributeNamePattern,
                                @Nonnull final Type type,
                                final int expectedChangeCount )
  {
    super( context );
    _elementNamePattern = Objects.requireNonNull( elementNamePattern );
    _attributeNamePattern = Objects.requireNonNull( attributeNamePattern );
    _type = Objects.requireNonNull( type );
    _expectedChangeCount = expectedChangeCount;
  }

  @Override
  public void onComplete()
  {
    if ( _expectedChangeCount > 0 )
    {
      if ( _changeCount != _expectedChangeCount )
      {
        context().error( "Changed " + _changeCount + " attributes but expected to " +
                         "change " + _expectedChangeCount + " attributes." );
      }
    }
    else
    {
      if ( 0 == _changeCount )
      {
        context().error( "Changed " + _changeCount + " attributes. Remove processor." );
      }
      else
      {
        context().debug( "Changed " + _changeCount + " attributes." );
      }
    }
  }

  @Nullable
  @Override
  protected MixinDefinition transformMixin( @Nonnull final MixinDefinition input )
  {
    _lastElementMatched = matches( input );
    try
    {
      return super.transformMixin( input );
    }
    finally
    {
      _lastElementMatched = false;
    }
  }

  @Nullable
  @Override
  protected PartialMixinDefinition transformPartialMixin( @Nonnull final PartialMixinDefinition input )
  {
    _lastElementMatched = matches( input );
    try
    {
      return super.transformPartialMixin( input );
    }
    finally
    {
      _lastElementMatched = false;
    }
  }

  @Nullable
  @Override
  protected InterfaceDefinition transformInterface( @Nonnull final InterfaceDefinition input )
  {
    _lastElementMatched = matches( input );
    try
    {
      return super.transformInterface( input );
    }
    finally
    {
      _lastElementMatched = false;
    }
  }

  @Nullable
  @Override
  protected PartialInterfaceDefinition transformPartialInterface( @Nonnull final PartialInterfaceDefinition input )
  {
    _lastElementMatched = matches( input );
    try
    {
      return super.transformPartialInterface( input );
    }
    finally
    {
      _lastElementMatched = false;
    }
  }

  @Nullable
  @Override
  protected NamespaceDefinition transformNamespace( @Nonnull final NamespaceDefinition input )
  {
    _lastElementMatched = matches( input );
    try
    {
      return super.transformNamespace( input );
    }
    finally
    {
      _lastElementMatched = false;
    }
  }

  @Nullable
  @Override
  protected PartialNamespaceDefinition transformPartialNamespace( @Nonnull final PartialNamespaceDefinition input )
  {
    _lastElementMatched = matches( input );
    try
    {
      return super.transformPartialNamespace( input );
    }
    finally
    {
      _lastElementMatched = false;
    }
  }

  private boolean matches( @Nonnull final NamedDefinition input )
  {
    return _elementNamePattern.matcher( input.getName() ).matches();
  }

  @Nonnull
  @Override
  protected AttributeMember transformAttributeMember( @Nonnull final AttributeMember input )
  {
    final boolean matches = matches( input );
    if ( matches )
    {
      _changeCount++;
    }
    return new AttributeMember( input.getName(),
                                matches ? _type : transformType( input.getType() ),
                                input.getModifiers(),
                                transformDocumentation( input.getDocumentation() ),
                                transformExtendedAttributes( input.getExtendedAttributes() ),
                                transformSourceLocations( input.getSourceLocations() ) );
  }

  private boolean matches( @Nonnull final NamedElement input )
  {
    final String name = input.getName();
    return _lastElementMatched && _attributeNamePattern.matcher( name ).matches();
  }
}
