package org.realityforge.webtack.model.tools.processors.remove_extended_attribute;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.CallbackDefinition;
import org.realityforge.webtack.model.CallbackInterfaceDefinition;
import org.realityforge.webtack.model.DictionaryDefinition;
import org.realityforge.webtack.model.EnumerationDefinition;
import org.realityforge.webtack.model.ExtendedAttribute;
import org.realityforge.webtack.model.InterfaceDefinition;
import org.realityforge.webtack.model.MixinDefinition;
import org.realityforge.webtack.model.NamespaceDefinition;
import org.realityforge.webtack.model.PartialDictionaryDefinition;
import org.realityforge.webtack.model.PartialInterfaceDefinition;
import org.realityforge.webtack.model.PartialMixinDefinition;
import org.realityforge.webtack.model.PartialNamespaceDefinition;
import org.realityforge.webtack.model.TypedefDefinition;
import org.realityforge.webtack.model.tools.processors.AbstractProcessor;
import org.realityforge.webtack.model.tools.spi.Completable;
import org.realityforge.webtack.model.tools.spi.PipelineContext;

final class RemoveExtendedAttributeProcessor
  extends AbstractProcessor
  implements Completable
{
  @Nonnull
  private final Pattern _namePattern;
  @Nullable
  private final List<ElementType> _types;
  @Nonnull
  private final ExtendedAttribute _extendedAttribute;
  /**
   * The number of attributes the processor expected to remove. If less than 1 this is ignored.
   */
  private final int _expectedRemoveCount;
  private int _removeCount;

  RemoveExtendedAttributeProcessor( @Nonnull final PipelineContext context,
                                    @Nonnull final Pattern namePattern,
                                    @Nullable final List<ElementType> types,
                                    @Nonnull final ExtendedAttribute extendedAttribute,
                                    final int expectedRemoveCount )
  {
    super( context );
    _namePattern = Objects.requireNonNull( namePattern );
    _types = types;
    _extendedAttribute = Objects.requireNonNull( extendedAttribute );
    _expectedRemoveCount = expectedRemoveCount;
  }

  @Override
  public void onComplete()
  {
    if ( _expectedRemoveCount > 0 )
    {
      if ( _removeCount != _expectedRemoveCount )
      {
        context().error( "Removed " + _removeCount + " attributes but expected to " +
                         "remove " + _expectedRemoveCount + " attributes." );
      }
    }
    else
    {
      if ( 0 == _removeCount )
      {
        context().info( "Removed " + _removeCount + " attributes." );
      }
      else
      {
        context().debug( "Removed " + _removeCount + " attributes." );
      }
    }
  }

  @Nonnull
  @Override
  protected CallbackDefinition transformCallback( @Nonnull final CallbackDefinition input )
  {
    return new CallbackDefinition( input.getName(),
                                   transformType( input.getReturnType() ),
                                   transformArguments( input.getArguments() ),
                                   transformDocumentation( input.getDocumentation() ),
                                   matches( input ) ?
                                   shrinkExtendedAttributes( input.getExtendedAttributes() ) :
                                   transformExtendedAttributes( input.getExtendedAttributes() ),
                                   transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  @Override
  protected CallbackInterfaceDefinition transformCallbackInterface( @Nonnull final CallbackInterfaceDefinition input )
  {
    return new CallbackInterfaceDefinition( input.getName(),
                                            transformOperationMember( input.getOperation() ),
                                            transformConstants( input.getConstants() ),
                                            transformDocumentation( input.getDocumentation() ),
                                            matches( input ) ?
                                            shrinkExtendedAttributes( input.getExtendedAttributes() ) :
                                            transformExtendedAttributes( input.getExtendedAttributes() ),
                                            transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  @Override
  protected EnumerationDefinition transformEnumeration( @Nonnull final EnumerationDefinition input )
  {
    return new EnumerationDefinition( input.getName(),
                                      transformEnumerationValues( input.getValues() ),
                                      transformDocumentation( input.getDocumentation() ),
                                      matches( input ) ?
                                      shrinkExtendedAttributes( input.getExtendedAttributes() ) :
                                      transformExtendedAttributes( input.getExtendedAttributes() ),
                                      transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  @Override
  protected MixinDefinition transformMixin( @Nonnull final MixinDefinition input )
  {
    return new MixinDefinition( input.getName(),
                                transformConstants( input.getConstants() ),
                                transformAttributeMembers( input.getAttributes() ),
                                transformOperationMembers( input.getOperations() ),
                                transformEventMembers( input.getEvents() ),
                                transformDocumentation( input.getDocumentation() ),
                                matches( input ) ?
                                shrinkExtendedAttributes( input.getExtendedAttributes() ) :
                                transformExtendedAttributes( input.getExtendedAttributes() ),
                                transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  @Override
  protected PartialMixinDefinition transformPartialMixin( @Nonnull final PartialMixinDefinition input )
  {
    return new PartialMixinDefinition( input.getName(),
                                       transformConstants( input.getConstants() ),
                                       transformAttributeMembers( input.getAttributes() ),
                                       transformOperationMembers( input.getOperations() ),
                                       transformEventMembers( input.getEvents() ),
                                       transformDocumentation( input.getDocumentation() ),
                                       matches( input ) ?
                                       shrinkExtendedAttributes( input.getExtendedAttributes() ) :
                                       transformExtendedAttributes( input.getExtendedAttributes() ),
                                       transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  @Override
  protected InterfaceDefinition transformInterface( @Nonnull final InterfaceDefinition input )
  {
    return new InterfaceDefinition( input.getName(),
                                    input.getInherits(),
                                    transformConstants( input.getConstants() ),
                                    transformAttributeMembers( input.getAttributes() ),
                                    transformOperationMembers( input.getOperations() ),
                                    transformEventMembers( input.getEvents() ),
                                    transformIterableMember( input.getIterable() ),
                                    transformAsyncIterableMember( input.getAsyncIterable() ),
                                    transformMapLikeMember( input.getMapLikeMember() ),
                                    transformSetLikeMember( input.getSetLikeMember() ),
                                    transformDocumentation( input.getDocumentation() ),
                                    matches( input ) ?
                                    shrinkExtendedAttributes( input.getExtendedAttributes() ) :
                                    transformExtendedAttributes( input.getExtendedAttributes() ),
                                    transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  @Override
  protected PartialInterfaceDefinition transformPartialInterface( @Nonnull final PartialInterfaceDefinition input )
  {
    return new PartialInterfaceDefinition( input.getName(),
                                           transformConstants( input.getConstants() ),
                                           transformAttributeMembers( input.getAttributes() ),
                                           transformOperationMembers( input.getOperations() ),
                                           transformEventMembers( input.getEvents() ),
                                           transformIterableMember( input.getIterable() ),
                                           transformAsyncIterableMember( input.getAsyncIterable() ),
                                           transformMapLikeMember( input.getMapLikeMember() ),
                                           transformSetLikeMember( input.getSetLikeMember() ),
                                           transformDocumentation( input.getDocumentation() ),
                                           matches( input ) ?
                                           shrinkExtendedAttributes( input.getExtendedAttributes() ) :
                                           transformExtendedAttributes( input.getExtendedAttributes() ),
                                           transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  @Override
  protected NamespaceDefinition transformNamespace( @Nonnull final NamespaceDefinition input )
  {
    return new NamespaceDefinition( input.getName(),
                                    transformConstants( input.getConstants() ),
                                    transformOperationMembers( input.getOperations() ),
                                    transformAttributeMembers( input.getAttributes() ),
                                    transformDocumentation( input.getDocumentation() ),
                                    matches( input ) ?
                                    shrinkExtendedAttributes( input.getExtendedAttributes() ) :
                                    transformExtendedAttributes( input.getExtendedAttributes() ),
                                    transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  @Override
  protected PartialNamespaceDefinition transformPartialNamespace( @Nonnull final PartialNamespaceDefinition input )
  {
    return new PartialNamespaceDefinition( input.getName(),
                                           transformConstants( input.getConstants() ),
                                           transformOperationMembers( input.getOperations() ),
                                           transformAttributeMembers( input.getAttributes() ),
                                           transformDocumentation( input.getDocumentation() ),
                                           matches( input ) ?
                                           shrinkExtendedAttributes( input.getExtendedAttributes() ) :
                                           transformExtendedAttributes( input.getExtendedAttributes() ),
                                           transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  @Override
  protected DictionaryDefinition transformDictionary( @Nonnull final DictionaryDefinition input )
  {
    return new DictionaryDefinition( input.getName(),
                                     input.getInherits(),
                                     transformDictionaryMembers( input.getMembers() ),
                                     transformDocumentation( input.getDocumentation() ),
                                     matches( input ) ?
                                     shrinkExtendedAttributes( input.getExtendedAttributes() ) :
                                     transformExtendedAttributes( input.getExtendedAttributes() ),
                                     transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  @Override
  protected PartialDictionaryDefinition transformPartialDictionary( @Nonnull final PartialDictionaryDefinition input )
  {
    return new PartialDictionaryDefinition( input.getName(),
                                            transformDictionaryMembers( input.getMembers() ),
                                            transformDocumentation( input.getDocumentation() ),
                                            matches( input ) ?
                                            shrinkExtendedAttributes( input.getExtendedAttributes() ) :
                                            transformExtendedAttributes( input.getExtendedAttributes() ),
                                            transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  @Override
  protected TypedefDefinition transformTypedef( @Nonnull final TypedefDefinition input )
  {
    return new TypedefDefinition( input.getName(),
                                  transformType( input.getType() ),
                                  transformDocumentation( input.getDocumentation() ),
                                  matches( input ) ?
                                  shrinkExtendedAttributes( input.getExtendedAttributes() ) :
                                  transformExtendedAttributes( input.getExtendedAttributes() ),
                                  transformSourceLocations( input.getSourceLocations() ) );
  }

  private boolean matches( @Nonnull final TypedefDefinition input )
  {
    return matchesType( ElementType.callback ) && matchesName( input.getName() );
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

  private boolean matchesType( @Nonnull final ElementType type )
  {
    return null == _types || _types.contains( type );
  }

  private boolean matchesName( @Nonnull final String name )
  {
    return _namePattern.matcher( name ).matches();
  }

  @Nonnull
  private List<ExtendedAttribute> shrinkExtendedAttributes( @Nonnull final List<ExtendedAttribute> inputs )
  {
    return inputs.stream().filter( a -> {
      if ( a.equiv( _extendedAttribute ) )
      {
        _removeCount++;
        return false;
      }
      else
      {
        return true;
      }
    } ).collect( Collectors.toList() );
  }
}
