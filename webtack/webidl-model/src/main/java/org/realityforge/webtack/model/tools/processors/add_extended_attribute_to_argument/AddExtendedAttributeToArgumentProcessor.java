package org.realityforge.webtack.model.tools.processors.add_extended_attribute_to_argument;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.Argument;
import org.realityforge.webtack.model.DictionaryDefinition;
import org.realityforge.webtack.model.ExtendedAttribute;
import org.realityforge.webtack.model.InterfaceDefinition;
import org.realityforge.webtack.model.MixinDefinition;
import org.realityforge.webtack.model.NamedDefinition;
import org.realityforge.webtack.model.NamespaceDefinition;
import org.realityforge.webtack.model.OperationMember;
import org.realityforge.webtack.model.PartialDictionaryDefinition;
import org.realityforge.webtack.model.PartialInterfaceDefinition;
import org.realityforge.webtack.model.PartialMixinDefinition;
import org.realityforge.webtack.model.PartialNamespaceDefinition;
import org.realityforge.webtack.model.tools.processors.AbstractProcessor;
import org.realityforge.webtack.model.tools.spi.Completable;
import org.realityforge.webtack.model.tools.spi.PipelineContext;

final class AddExtendedAttributeToArgumentProcessor
  extends AbstractProcessor
  implements Completable
{
  @Nonnull
  private final Pattern _elementNamePattern;
  @Nonnull
  private final Pattern _operationNamePattern;
  @Nonnull
  private final Pattern _argumentNamePattern;
  @Nonnull
  private final ExtendedAttribute _extendedAttribute;
  private boolean _lastElementMatched;
  private boolean _lastOperationMatched;
  public final int _expectedAddCount;
  private int _addCount;

  AddExtendedAttributeToArgumentProcessor( @Nonnull final PipelineContext context,
                                           @Nonnull final Pattern elementNamePattern,
                                           @Nonnull final Pattern operationNamePattern,
                                           @Nonnull final Pattern argumentNamePattern,
                                           @Nonnull final ExtendedAttribute extendedAttribute,
                                           final int expectedAddCount )
  {
    super( context );
    _elementNamePattern = Objects.requireNonNull( elementNamePattern );
    _operationNamePattern = Objects.requireNonNull( operationNamePattern );
    _argumentNamePattern = Objects.requireNonNull( argumentNamePattern );
    _extendedAttribute = Objects.requireNonNull( extendedAttribute );
    _expectedAddCount = expectedAddCount;
  }

  @Override
  public void onComplete()
  {
    if ( _expectedAddCount > 0 )
    {
      if ( _addCount != _expectedAddCount )
      {
        context().error( "Added " + _addCount + " extended attributes but expected to " +
                         "add " + _expectedAddCount + " extended attributes." );
      }
    }
    else
    {
      if ( 0 == _addCount )
      {
        context().error( "Added " + _addCount + " extended attributes. Remove processor." );
      }
      else
      {
        context().debug( "Added " + _addCount + " extended attributes." );
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

  @Nullable
  @Override
  protected DictionaryDefinition transformDictionary( @Nonnull final DictionaryDefinition input )
  {
    _lastElementMatched = matches( input );
    try
    {
      return super.transformDictionary( input );
    }
    finally
    {
      _lastElementMatched = false;
    }
  }

  @Nullable
  @Override
  protected PartialDictionaryDefinition transformPartialDictionary( @Nonnull final PartialDictionaryDefinition input )
  {
    _lastElementMatched = matches( input );
    return super.transformPartialDictionary( input );
  }

  private boolean matches( @Nonnull final NamedDefinition input )
  {
    return _elementNamePattern.matcher( input.getName() ).matches();
  }

  @Nonnull
  @Override
  protected OperationMember transformOperationMember( @Nonnull final OperationMember input )
  {
    _lastOperationMatched = matches( input );
    final OperationMember member = super.transformOperationMember( input );
    _lastOperationMatched = false;
    return member;
  }

  @Nonnull
  @Override
  protected Argument transformArgument( @Nonnull final Argument input )
  {
    return new Argument( input.getName(),
                         transformType( input.getType() ),
                         input.isOptional(),
                         input.isVariadic(),
                         transformDefaultValue( input.getDefaultValue() ),
                         transformDocumentation( input.getDocumentation() ),
                         matches( input ) ?
                         expandExtendedAttributes( input.getExtendedAttributes() ) :
                         transformExtendedAttributes( input.getExtendedAttributes() ),
                         input.getSourceLocations() );
  }

  private boolean matches( @Nonnull final OperationMember input )
  {
    final String name = input.getName();
    return _lastElementMatched && null != name && _operationNamePattern.matcher( name ).matches();
  }

  private boolean matches( @Nonnull final Argument input )
  {
    final String name = input.getName();
    return _lastOperationMatched && _argumentNamePattern.matcher( name ).matches();
  }

  @Nonnull
  private List<ExtendedAttribute> expandExtendedAttributes( @Nonnull final List<ExtendedAttribute> inputs )
  {
    final List<ExtendedAttribute> extendedAttributes = new ArrayList<>( inputs );
    extendedAttributes.add( _extendedAttribute );
    _addCount++;
    return extendedAttributes;
  }
}
