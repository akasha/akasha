package org.realityforge.webtack.model.tools.processors.add_extended_attribute;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
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
import org.realityforge.webtack.model.tools.processors.AbstractProcessor;

final class AddExtendedAttributeProcessor
  extends AbstractProcessor
{
  @Nonnull
  private final Pattern _namePattern;
  @Nullable
  private final List<ElementType> _types;
  @Nonnull
  private final ExtendedAttribute _extendedAttribute;

  AddExtendedAttributeProcessor( @Nonnull final Pattern namePattern,
                                 @Nullable final List<ElementType> types,
                                 @Nonnull final ExtendedAttribute extendedAttribute )
  {
    _namePattern = Objects.requireNonNull( namePattern );
    _types = types;
    _extendedAttribute = Objects.requireNonNull( extendedAttribute );
  }

  @Nonnull
  @Override
  protected CallbackDefinition transformCallback( @Nonnull final CallbackDefinition input )
  {
    return new CallbackDefinition( input.getName(),
                                   transformType( input.getReturnType() ),
                                   transformArguments( input.getArguments() ),
                                   matches( input ) ?
                                   expandExtendedAttributes( input.getExtendedAttributes() ) :
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
                                            matches( input ) ?
                                            expandExtendedAttributes( input.getExtendedAttributes() ) :
                                            transformExtendedAttributes( input.getExtendedAttributes() ),
                                            transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  @Override
  protected EnumerationDefinition transformEnumeration( @Nonnull final EnumerationDefinition input )
  {
    return new EnumerationDefinition( input.getName(),
                                      input.getValues(),
                                      matches( input ) ?
                                      expandExtendedAttributes( input.getExtendedAttributes() ) :
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
                                matches( input ) ?
                                expandExtendedAttributes( input.getExtendedAttributes() ) :
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
                                       matches( input ) ?
                                       expandExtendedAttributes( input.getExtendedAttributes() ) :
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
                                    transformIterableMember( input.getIterable() ),
                                    transformAsyncIterableMember( input.getAsyncIterable() ),
                                    transformMapLikeMember( input.getMapLikeMember() ),
                                    transformSetLikeMember( input.getSetLikeMember() ),
                                    matches( input ) ?
                                    expandExtendedAttributes( input.getExtendedAttributes() ) :
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
                                           transformIterableMember( input.getIterable() ),
                                           transformAsyncIterableMember( input.getAsyncIterable() ),
                                           transformMapLikeMember( input.getMapLikeMember() ),
                                           transformSetLikeMember( input.getSetLikeMember() ),
                                           matches( input ) ?
                                           expandExtendedAttributes( input.getExtendedAttributes() ) :
                                           transformExtendedAttributes( input.getExtendedAttributes() ),
                                           transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  @Override
  protected NamespaceDefinition transformNamespace( @Nonnull final NamespaceDefinition input )
  {
    return new NamespaceDefinition( input.getName(),
                                    transformOperationMembers( input.getOperations() ),
                                    transformAttributeMembers( input.getAttributes() ),
                                    matches( input ) ?
                                    expandExtendedAttributes( input.getExtendedAttributes() ) :
                                    transformExtendedAttributes( input.getExtendedAttributes() ),
                                    transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  @Override
  protected PartialNamespaceDefinition transformPartialNamespace( @Nonnull final PartialNamespaceDefinition input )
  {
    return new PartialNamespaceDefinition( input.getName(),
                                           transformOperationMembers( input.getOperations() ),
                                           transformAttributeMembers( input.getAttributes() ),
                                           matches( input ) ?
                                           expandExtendedAttributes( input.getExtendedAttributes() ) :
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
                                     matches( input ) ?
                                     expandExtendedAttributes( input.getExtendedAttributes() ) :
                                     transformExtendedAttributes( input.getExtendedAttributes() ),
                                     transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  @Override
  protected PartialDictionaryDefinition transformPartialDictionary( @Nonnull final PartialDictionaryDefinition input )
  {
    return new PartialDictionaryDefinition( input.getName(),
                                            transformDictionaryMembers( input.getMembers() ),
                                            matches( input ) ?
                                            expandExtendedAttributes( input.getExtendedAttributes() ) :
                                            transformExtendedAttributes( input.getExtendedAttributes() ),
                                            transformSourceLocations( input.getSourceLocations() ) );
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
  private List<ExtendedAttribute> expandExtendedAttributes( @Nonnull final List<ExtendedAttribute> inputs )
  {
    final List<ExtendedAttribute> extendedAttributes = new ArrayList<>( inputs );
    extendedAttributes.add( _extendedAttribute );
    return extendedAttributes;
  }
}
