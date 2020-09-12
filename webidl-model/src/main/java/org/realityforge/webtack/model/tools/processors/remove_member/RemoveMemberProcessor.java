package org.realityforge.webtack.model.tools.processors.remove_member;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.AttributeMember;
import org.realityforge.webtack.model.ConstMember;
import org.realityforge.webtack.model.DictionaryDefinition;
import org.realityforge.webtack.model.DictionaryMember;
import org.realityforge.webtack.model.EventMember;
import org.realityforge.webtack.model.InterfaceDefinition;
import org.realityforge.webtack.model.MixinDefinition;
import org.realityforge.webtack.model.NamespaceDefinition;
import org.realityforge.webtack.model.OperationMember;
import org.realityforge.webtack.model.PartialDictionaryDefinition;
import org.realityforge.webtack.model.PartialInterfaceDefinition;
import org.realityforge.webtack.model.PartialMixinDefinition;
import org.realityforge.webtack.model.PartialNamespaceDefinition;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.tools.processors.AbstractProcessor;
import org.realityforge.webtack.model.tools.spi.Completable;
import org.realityforge.webtack.model.tools.spi.PipelineContext;

final class RemoveMemberProcessor
  extends AbstractProcessor
  implements Completable
{
  @Nonnull
  private final PipelineContext _context;
  @Nonnull
  private final Pattern _elementNamePattern;
  @Nonnull
  private final Pattern _memberNamePattern;
  @Nullable
  private final List<ElementType> _types;
  private boolean _lastElementMatched;
  /**
   * The number of members the processor expected to remove. If less than 1 this is ignored.
   */
  private final int _expectedRemoveCount;
  private int _removeCount;

  RemoveMemberProcessor( @Nonnull final PipelineContext context,
                         @Nonnull final Pattern elementNamePattern,
                         @Nonnull final Pattern memberNamePattern,
                         @Nullable final List<ElementType> types, final int expectedRemoveCount )
  {
    _context = context;
    _elementNamePattern = Objects.requireNonNull( elementNamePattern );
    _memberNamePattern = Objects.requireNonNull( memberNamePattern );
    _types = types;
    _expectedRemoveCount = expectedRemoveCount;
  }

  @Nullable
  @Override
  public WebIDLSchema process( @Nonnull final WebIDLSchema schema )
  {
    _removeCount = 0;
    return super.process( schema );
  }

  @Override
  public void onComplete()
  {
    if ( _expectedRemoveCount > 0 )
    {
      if ( _removeCount != _expectedRemoveCount )
      {
        _context.error( "Removed " + _removeCount + " members but expected to " +
                        "remove " + _expectedRemoveCount + " members." );
      }
    }
    else
    {
      if ( 0 == _removeCount )
      {
        _context.info( "Removed " + _removeCount + " members." );
      }
      else
      {
        _context.debug( "Removed " + _removeCount + " elements." );
      }
    }
  }

  @Nullable
  <T> T incRemoveCountAndReturnNull()
  {
    _removeCount++;
    return null;
  }

  @Nullable
  @Override
  protected ConstMember transformConstant( @Nonnull final ConstMember input )
  {
    return matchesMemberName( input.getName() ) ? incRemoveCountAndReturnNull() : super.transformConstant( input );
  }

  @Nullable
  @Override
  protected AttributeMember transformAttributeMember( @Nonnull final AttributeMember input )
  {
    return matchesMemberName( input.getName() ) ?
           incRemoveCountAndReturnNull() :
           super.transformAttributeMember( input );
  }

  @Nullable
  @Override
  protected OperationMember transformOptionalOperationMember( @Nonnull final OperationMember input )
  {
    final String name = input.getName();
    return null != name && matchesMemberName( name ) ?
           incRemoveCountAndReturnNull() :
           super.transformOptionalOperationMember( input );
  }

  @Nullable
  @Override
  protected DictionaryMember transformDictionaryMember( @Nonnull final DictionaryMember input )
  {
    return matchesMemberName( input.getName() ) ?
           incRemoveCountAndReturnNull() :
           super.transformDictionaryMember( input );
  }

  @Nullable
  @Override
  protected EventMember transformEventMember( @Nonnull final EventMember input )
  {
    return matchesMemberName( input.getName() ) ? incRemoveCountAndReturnNull() : super.transformEventMember( input );
  }

  @Nullable
  @Override
  protected MixinDefinition transformMixin( @Nonnull final MixinDefinition input )
  {
    _lastElementMatched = matches( input );
    return super.transformMixin( input );
  }

  @Nullable
  @Override
  protected PartialMixinDefinition transformPartialMixin( @Nonnull final PartialMixinDefinition input )
  {
    _lastElementMatched = matches( input );
    return super.transformPartialMixin( input );
  }

  @Nullable
  @Override
  protected InterfaceDefinition transformInterface( @Nonnull final InterfaceDefinition input )
  {
    _lastElementMatched = matches( input );
    return super.transformInterface( input );
  }

  @Nullable
  @Override
  protected PartialInterfaceDefinition transformPartialInterface( @Nonnull final PartialInterfaceDefinition input )
  {
    _lastElementMatched = matches( input );
    return super.transformPartialInterface( input );
  }

  @Nullable
  @Override
  protected NamespaceDefinition transformNamespace( @Nonnull final NamespaceDefinition input )
  {
    _lastElementMatched = matches( input );
    return super.transformNamespace( input );
  }

  @Nullable
  @Override
  protected PartialNamespaceDefinition transformPartialNamespace( @Nonnull final PartialNamespaceDefinition input )
  {
    _lastElementMatched = matches( input );
    return super.transformPartialNamespace( input );
  }

  @Nullable
  @Override
  protected DictionaryDefinition transformDictionary( @Nonnull final DictionaryDefinition input )
  {
    _lastElementMatched = matches( input );
    return super.transformDictionary( input );
  }

  @Nullable
  @Override
  protected PartialDictionaryDefinition transformPartialDictionary( @Nonnull final PartialDictionaryDefinition input )
  {
    _lastElementMatched = matches( input );
    return super.transformPartialDictionary( input );
  }

  private boolean matches( @Nonnull final DictionaryDefinition input )
  {
    return matchesType( ElementType.dictionary ) && matchesElementName( input.getName() );
  }

  private boolean matches( @Nonnull final PartialDictionaryDefinition input )
  {
    return matchesType( ElementType.dictionary ) && matchesElementName( input.getName() );
  }

  private boolean matches( @Nonnull final MixinDefinition input )
  {
    return matchesType( ElementType.mixin ) && matchesElementName( input.getName() );
  }

  private boolean matches( @Nonnull final PartialMixinDefinition input )
  {
    return matchesType( ElementType.mixin ) && matchesElementName( input.getName() );
  }

  private boolean matches( @Nonnull final InterfaceDefinition input )
  {
    return matchesType( ElementType.interface_type ) && matchesElementName( input.getName() );
  }

  private boolean matches( @Nonnull final PartialInterfaceDefinition input )
  {
    return matchesType( ElementType.interface_type ) && matchesElementName( input.getName() );
  }

  private boolean matches( @Nonnull final NamespaceDefinition input )
  {
    return matchesType( ElementType.namespace ) && matchesElementName( input.getName() );
  }

  private boolean matches( @Nonnull final PartialNamespaceDefinition input )
  {
    return matchesType( ElementType.namespace ) && matchesElementName( input.getName() );
  }

  private boolean matchesType( @Nonnull final ElementType type )
  {
    return null == _types || _types.contains( type );
  }

  private boolean matchesElementName( @Nonnull final String name )
  {
    return _elementNamePattern.matcher( name ).matches();
  }

  private boolean matchesMemberName( @Nonnull final String name )
  {
    return _lastElementMatched && _memberNamePattern.matcher( name ).matches();
  }
}
