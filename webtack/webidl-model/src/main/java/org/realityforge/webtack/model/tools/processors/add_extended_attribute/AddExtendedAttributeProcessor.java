package org.realityforge.webtack.model.tools.processors.add_extended_attribute;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.CallbackDefinition;
import org.realityforge.webtack.model.CallbackInterfaceDefinition;
import org.realityforge.webtack.model.ConstEnumerationDefinition;
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

final class AddExtendedAttributeProcessor
  extends AbstractProcessor
  implements Completable
{
  @Nonnull
  private final Pattern _namePattern;
  @Nullable
  private final List<ElementType> _types;
  @Nonnull
  private final ExtendedAttribute _extendedAttribute;
  private final int _expectedAddCount;
  private int _addCount;

  AddExtendedAttributeProcessor( @Nonnull final PipelineContext context,
                                 @Nonnull final Pattern namePattern,
                                 @Nullable final List<ElementType> types,
                                 @Nonnull final ExtendedAttribute extendedAttribute,
                                 final int expectedAddCount )
  {
    super( context );
    _namePattern = Objects.requireNonNull( namePattern );
    _types = types;
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

  @Nonnull
  @Override
  protected CallbackDefinition transformCallback( @Nonnull final CallbackDefinition input )
  {
    return new CallbackDefinition( input.getName(),
                                   transformType( input.getReturnType() ),
                                   transformArguments( input.getArguments() ),
                                   transformDocumentation( input.getDocumentation() ),
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
                                            transformDocumentation( input.getDocumentation() ),
                                            matches( input ) ?
                                            expandExtendedAttributes( input.getExtendedAttributes() ) :
                                            transformExtendedAttributes( input.getExtendedAttributes() ),
                                            transformSourceLocations( input.getSourceLocations() ) );
  }

  @Nonnull
  @Override
  protected ConstEnumerationDefinition transformConstEnumeration( @Nonnull final ConstEnumerationDefinition input )
  {
    return new ConstEnumerationDefinition( input.getName(),
                                           transformConstEnumerationValues( input.getValues() ),
                                           transformDocumentation( input.getDocumentation() ),
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
                                      transformEnumerationValues( input.getValues() ),
                                      transformDocumentation( input.getDocumentation() ),
                                      matches( input ) ?
                                      expandExtendedAttributes( input.getExtendedAttributes() ) :
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
                                transformEventMembers( input.getEvents() ),
                                transformDocumentation( input.getDocumentation() ),
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
                                       transformEventMembers( input.getEvents() ),
                                       transformDocumentation( input.getDocumentation() ),
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
                                    transformEventMembers( input.getEvents() ),
                                    transformIterableMember( input.getIterable() ),
                                    transformAsyncIterableMember( input.getAsyncIterable() ),
                                    transformMapLikeMember( input.getMapLikeMember() ),
                                    transformSetLikeMember( input.getSetLikeMember() ),
                                    transformDocumentation( input.getDocumentation() ),
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
                                           transformEventMembers( input.getEvents() ),
                                           transformIterableMember( input.getIterable() ),
                                           transformAsyncIterableMember( input.getAsyncIterable() ),
                                           transformMapLikeMember( input.getMapLikeMember() ),
                                           transformSetLikeMember( input.getSetLikeMember() ),
                                           transformDocumentation( input.getDocumentation() ),
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
                                    transformConstants( input.getConstants() ),
                                    transformOperationMembers( input.getOperations() ),
                                    transformAttributeMembers( input.getAttributes() ),
                                    transformDocumentation( input.getDocumentation() ),
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
                                           transformConstants( input.getConstants() ),
                                           transformOperationMembers( input.getOperations() ),
                                           transformAttributeMembers( input.getAttributes() ),
                                           transformDocumentation( input.getDocumentation() ),
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
                                     transformDocumentation( input.getDocumentation() ),
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
                                            transformDocumentation( input.getDocumentation() ),
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

  private boolean matches( @Nonnull final ConstEnumerationDefinition input )
  {
    return matchesType( ElementType.const_enumeration ) && matchesName( input.getName() );
  }

  private boolean matches( @Nonnull final EnumerationDefinition input )
  {
    return matchesType( ElementType.enumeration ) && matchesName( input.getName() );
  }

  private boolean matches( @Nonnull final TypedefDefinition input )
  {
    return matchesType( ElementType.typedef ) && matchesName( input.getName() );
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
    _addCount++;
    return extendedAttributes;
  }
}
