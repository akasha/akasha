package org.realityforge.webtack.model.tools.processors.remove_element;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.CallbackDefinition;
import org.realityforge.webtack.model.CallbackInterfaceDefinition;
import org.realityforge.webtack.model.DictionaryDefinition;
import org.realityforge.webtack.model.EnumerationDefinition;
import org.realityforge.webtack.model.IncludesStatement;
import org.realityforge.webtack.model.InterfaceDefinition;
import org.realityforge.webtack.model.MixinDefinition;
import org.realityforge.webtack.model.NamespaceDefinition;
import org.realityforge.webtack.model.PartialDictionaryDefinition;
import org.realityforge.webtack.model.PartialInterfaceDefinition;
import org.realityforge.webtack.model.PartialMixinDefinition;
import org.realityforge.webtack.model.PartialNamespaceDefinition;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.tools.processors.AbstractProcessor;
import org.realityforge.webtack.model.tools.spi.Completable;
import org.realityforge.webtack.model.tools.spi.PipelineContext;

final class RemoveElementProcessor
  extends AbstractProcessor
  implements Completable
{
  @Nonnull
  private final PipelineContext _context;
  @Nonnull
  private final Pattern _namePattern;
  @Nullable
  private final List<ElementType> _types;
  /**
   * The number of elements the processor expected to remove. If less than 1 this is ignored.
   */
  private final int _expectedRemoveCount;
  private int _removeCount;

  RemoveElementProcessor( @Nonnull final PipelineContext context,
                          @Nonnull final Pattern namePattern,
                          @Nullable final List<ElementType> types,
                          final int expectedRemoveCount )
  {
    _context = Objects.requireNonNull( context );
    _namePattern = Objects.requireNonNull( namePattern );
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
        _context.error( "Removed " + _removeCount + " elements but expected to " +
                        "remove " + _expectedRemoveCount + " elements." );
      }
    }
    else
    {
      if ( 0 == _removeCount )
      {
        _context.info( "Removed " + _removeCount + " elements." );
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
  protected CallbackDefinition transformCallback( @Nonnull final CallbackDefinition input )
  {
    return matches( input ) ? incRemoveCountAndReturnNull() : super.transformCallback( input );
  }

  @Nullable
  @Override
  protected CallbackInterfaceDefinition transformCallbackInterface( @Nonnull final CallbackInterfaceDefinition input )
  {
    return matches( input ) ? incRemoveCountAndReturnNull() : super.transformCallbackInterface( input );
  }

  @Nullable
  @Override
  protected EnumerationDefinition transformEnumeration( @Nonnull final EnumerationDefinition input )
  {
    return matches( input ) ? incRemoveCountAndReturnNull() : super.transformEnumeration( input );
  }

  @Nullable
  @Override
  protected MixinDefinition transformMixin( @Nonnull final MixinDefinition input )
  {
    return matches( input ) ? incRemoveCountAndReturnNull() : super.transformMixin( input );
  }

  @Nullable
  @Override
  protected PartialMixinDefinition transformPartialMixin( @Nonnull final PartialMixinDefinition input )
  {
    return matches( input ) ? incRemoveCountAndReturnNull() : super.transformPartialMixin( input );
  }

  @Nullable
  @Override
  protected InterfaceDefinition transformInterface( @Nonnull final InterfaceDefinition input )
  {
    return matches( input ) ? incRemoveCountAndReturnNull() : super.transformInterface( input );
  }

  @Nullable
  @Override
  protected PartialInterfaceDefinition transformPartialInterface( @Nonnull final PartialInterfaceDefinition input )
  {
    return matches( input ) ? incRemoveCountAndReturnNull() : super.transformPartialInterface( input );
  }

  @Nullable
  @Override
  protected NamespaceDefinition transformNamespace( @Nonnull final NamespaceDefinition input )
  {
    return matches( input ) ? incRemoveCountAndReturnNull() : super.transformNamespace( input );
  }

  @Nullable
  @Override
  protected PartialNamespaceDefinition transformPartialNamespace( @Nonnull final PartialNamespaceDefinition input )
  {
    return matches( input ) ? incRemoveCountAndReturnNull() : super.transformPartialNamespace( input );
  }

  @Nullable
  @Override
  protected DictionaryDefinition transformDictionary( @Nonnull final DictionaryDefinition input )
  {
    return matches( input ) ? incRemoveCountAndReturnNull() : super.transformDictionary( input );
  }

  @Nullable
  @Override
  protected PartialDictionaryDefinition transformPartialDictionary( @Nonnull final PartialDictionaryDefinition input )
  {
    return matches( input ) ? incRemoveCountAndReturnNull() : super.transformPartialDictionary( input );
  }

  @Nullable
  @Override
  protected IncludesStatement transformIncludesStatement( @Nonnull final IncludesStatement input )
  {
    return matches( input ) ? incRemoveCountAndReturnNull() : super.transformIncludesStatement( input );
  }

  private boolean matches( @Nonnull final CallbackDefinition input )
  {
    return matchesType( ElementType.callback ) && matchesName( input.getName() );
  }

  private boolean matches( @Nonnull final CallbackInterfaceDefinition input )
  {
    return matchesType( ElementType.callback_interface ) && matchesName( input.getName() );
  }

  private boolean matches( @Nonnull final DictionaryDefinition input )
  {
    return matchesType( ElementType.dictionary ) && matchesName( input.getName() );
  }

  private boolean matches( @Nonnull final PartialDictionaryDefinition input )
  {
    return matchesType( ElementType.dictionary ) && matchesName( input.getName() );
  }

  private boolean matches( @Nonnull final MixinDefinition input )
  {
    return matchesType( ElementType.mixin ) && matchesName( input.getName() );
  }

  private boolean matches( @Nonnull final PartialMixinDefinition input )
  {
    return matchesType( ElementType.mixin ) && matchesName( input.getName() );
  }

  private boolean matches( @Nonnull final EnumerationDefinition input )
  {
    return matchesType( ElementType.enumeration ) && matchesName( input.getName() );
  }

  private boolean matches( @Nonnull final InterfaceDefinition input )
  {
    return matchesType( ElementType.interface_type ) && matchesName( input.getName() );
  }

  private boolean matches( @Nonnull final PartialInterfaceDefinition input )
  {
    return matchesType( ElementType.interface_type ) && matchesName( input.getName() );
  }

  private boolean matches( @Nonnull final NamespaceDefinition input )
  {
    return matchesType( ElementType.namespace ) && matchesName( input.getName() );
  }

  private boolean matches( @Nonnull final PartialNamespaceDefinition input )
  {
    return matchesType( ElementType.namespace ) && matchesName( input.getName() );
  }

  private boolean matches( @Nonnull final IncludesStatement input )
  {
    return ( matchesType( ElementType.interface_type ) && matchesName( input.getInterfaceName() ) ) ||
           ( matchesType( ElementType.mixin ) && matchesName( input.getMixinName() ) );
  }

  private boolean matchesType( @Nonnull final ElementType type )
  {
    return null == _types || _types.contains( type );
  }

  private boolean matchesName( @Nonnull final String name )
  {
    return _namePattern.matcher( name ).matches();
  }
}
