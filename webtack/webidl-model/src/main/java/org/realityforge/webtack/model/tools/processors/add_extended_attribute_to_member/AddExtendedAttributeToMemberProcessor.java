package org.realityforge.webtack.model.tools.processors.add_extended_attribute_to_member;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.AttributeMember;
import org.realityforge.webtack.model.ConstMember;
import org.realityforge.webtack.model.DictionaryDefinition;
import org.realityforge.webtack.model.DictionaryMember;
import org.realityforge.webtack.model.EnumerationDefinition;
import org.realityforge.webtack.model.EnumerationValue;
import org.realityforge.webtack.model.EventMember;
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

final class AddExtendedAttributeToMemberProcessor
  extends AbstractProcessor
  implements Completable
{
  @Nonnull
  private final Pattern _elementNamePattern;
  @Nonnull
  private final Pattern _memberNamePattern;
  @Nonnull
  private final ExtendedAttribute _extendedAttribute;
  private boolean _lastElementMatched;
  private final int _expectedAddCount;
  private int _addCount;

  AddExtendedAttributeToMemberProcessor( @Nonnull final PipelineContext context,
                                         @Nonnull final Pattern elementNamePattern,
                                         @Nonnull final Pattern memberNamePattern,
                                         @Nonnull final ExtendedAttribute extendedAttribute,
                                         final int expectedAddCount )
  {
    super( context );
    _elementNamePattern = Objects.requireNonNull( elementNamePattern );
    _memberNamePattern = Objects.requireNonNull( memberNamePattern );
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
  protected EnumerationDefinition transformEnumeration( @Nonnull final EnumerationDefinition input )
  {
    _lastElementMatched = matches( input );
    try
    {
      return super.transformEnumeration( input );
    }
    finally
    {
      _lastElementMatched = false;
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

  @Nonnull
  @Override
  protected EnumerationValue transformEnumerationValue( @Nonnull final EnumerationValue input )
  {
    return new EnumerationValue( input.getValue(),
                                 transformDocumentation( input.getDocumentation() ),
                                 matchesMemberName( input.getValue() ) ?
                                 expandExtendedAttributes( input.getExtendedAttributes() ) :
                                 transformExtendedAttributes( input.getExtendedAttributes() ),
                                 transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  @Override
  protected ConstMember transformConstant( @Nonnull final ConstMember input )
  {
    return new ConstMember( input.getName(),
                            transformType( input.getType() ),
                            transformConstValue( input.getValue() ),
                            transformDocumentation( input.getDocumentation() ),
                            matchesMemberName( input.getName() ) ?
                            expandExtendedAttributes( input.getExtendedAttributes() ) :
                            transformExtendedAttributes( input.getExtendedAttributes() ),
                            transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  @Override
  protected AttributeMember transformAttributeMember( @Nonnull final AttributeMember input )
  {
    return new AttributeMember( input.getName(),
                                transformType( input.getType() ),
                                input.getModifiers(),
                                transformDocumentation( input.getDocumentation() ),
                                matchesMemberName( input.getName() ) ?
                                expandExtendedAttributes( input.getExtendedAttributes() ) :
                                transformExtendedAttributes( input.getExtendedAttributes() ),
                                transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  @Override
  protected OperationMember transformOperationMember( @Nonnull final OperationMember input )
  {
    final String name = input.getName();
    return new OperationMember( input.getKind(),
                                input.getName(),
                                transformArguments( input.getArguments() ),
                                transformType( input.getReturnType() ),
                                transformDocumentation( input.getDocumentation() ),
                                null != name && matchesMemberName( name ) ?
                                expandExtendedAttributes( input.getExtendedAttributes() ) :
                                transformExtendedAttributes( input.getExtendedAttributes() ),
                                transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  @Override
  protected OperationMember transformOptionalOperationMember( @Nonnull final OperationMember input )
  {
    final String name = input.getName();
    return new OperationMember( input.getKind(),
                                input.getName(),
                                transformArguments( input.getArguments() ),
                                transformType( input.getReturnType() ),
                                transformDocumentation( input.getDocumentation() ),
                                null != name && matchesMemberName( name ) ?
                                expandExtendedAttributes( input.getExtendedAttributes() ) :
                                transformExtendedAttributes( input.getExtendedAttributes() ),
                                transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  @Override
  protected DictionaryMember transformDictionaryMember( @Nonnull final DictionaryMember input )
  {
    return new DictionaryMember( input.getName(),
                                 transformType( input.getType() ),
                                 input.isOptional(),
                                 input.getDefaultValue(),
                                 transformDocumentation( input.getDocumentation() ),
                                 matchesMemberName( input.getName() ) ?
                                 expandExtendedAttributes( input.getExtendedAttributes() ) :
                                 transformExtendedAttributes( input.getExtendedAttributes() ),
                                 transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  @Override
  protected EventMember transformEventMember( @Nonnull final EventMember input )
  {
    return new EventMember( input.getName(),
                            input.getEventType(),
                            transformDocumentation( input.getDocumentation() ),
                            matchesMemberName( input.getName() ) ?
                            expandExtendedAttributes( input.getExtendedAttributes() ) :
                            transformExtendedAttributes( input.getExtendedAttributes() ),
                            transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  private List<ExtendedAttribute> expandExtendedAttributes( @Nonnull final List<ExtendedAttribute> inputs )
  {
    final List<ExtendedAttribute> extendedAttributes = new ArrayList<>( inputs );
    extendedAttributes.add( _extendedAttribute );
    _addCount++;
    return extendedAttributes;
  }

  private boolean matches( @Nonnull final NamedDefinition input )
  {
    return _elementNamePattern.matcher( input.getName() ).matches();
  }

  private boolean matchesMemberName( @Nonnull final String name )
  {
    return _lastElementMatched && _memberNamePattern.matcher( name ).matches();
  }
}
