package org.realityforge.webtack.model.tools.processors.rename_type;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.CallbackDefinition;
import org.realityforge.webtack.model.CallbackInterfaceDefinition;
import org.realityforge.webtack.model.DictionaryDefinition;
import org.realityforge.webtack.model.EnumerationDefinition;
import org.realityforge.webtack.model.IncludesStatement;
import org.realityforge.webtack.model.InterfaceDefinition;
import org.realityforge.webtack.model.Kind;
import org.realityforge.webtack.model.MixinDefinition;
import org.realityforge.webtack.model.NamespaceDefinition;
import org.realityforge.webtack.model.PartialDictionaryDefinition;
import org.realityforge.webtack.model.PartialInterfaceDefinition;
import org.realityforge.webtack.model.PartialMixinDefinition;
import org.realityforge.webtack.model.PartialNamespaceDefinition;
import org.realityforge.webtack.model.Type;
import org.realityforge.webtack.model.TypeReference;
import org.realityforge.webtack.model.TypedefDefinition;
import org.realityforge.webtack.model.tools.processors.AbstractProcessor;

final class RenameTypeProcessor
  extends AbstractProcessor
{
  @Nonnull
  private final Pattern _namePattern;
  @Nonnull
  private final String _replacement;

  RenameTypeProcessor( @Nonnull final Pattern namePattern, @Nonnull final String replacement )
  {
    _namePattern = Objects.requireNonNull( namePattern );
    _replacement = Objects.requireNonNull( replacement );
  }

  @Nonnull
  @Override
  protected Type transformType( @Nonnull final Type type )
  {
    if ( Kind.TypeReference == type.getKind() )
    {
      final TypeReference typeReference = (TypeReference) type;
      final Matcher matcher = _namePattern.matcher( typeReference.getName() );
      if ( matcher.matches() )
      {
        return new TypeReference( matcher.replaceAll( _replacement ),
                                  typeReference.getExtendedAttributes(),
                                  typeReference.isNullable(),
                                  typeReference.getSourceLocations() );
      }
    }
    return super.transformType( type );
  }

  @Nullable
  @Override
  protected EnumerationDefinition transformEnumeration( @Nonnull final EnumerationDefinition input )
  {
    final Matcher matcher = _namePattern.matcher( input.getName() );
    if ( matcher.matches() )
    {
      return new EnumerationDefinition( matcher.replaceAll( _replacement ),
                                        input.getValues(),
                                        transformDocumentation( input.getDocumentation() ),
                                        transformExtendedAttributes( input.getExtendedAttributes() ),
                                        transformSourceLocations( input.getSourceLocations() ) );
    }
    else
    {
      return super.transformEnumeration( input );
    }
  }

  @Nullable
  @Override
  protected CallbackDefinition transformCallback( @Nonnull final CallbackDefinition input )
  {
    final Matcher matcher = _namePattern.matcher( input.getName() );
    if ( matcher.matches() )
    {
      return new CallbackDefinition( matcher.replaceAll( _replacement ),
                                     transformType( input.getReturnType() ),
                                     transformArguments( input.getArguments() ),
                                     transformDocumentation( input.getDocumentation() ),
                                     transformExtendedAttributes( input.getExtendedAttributes() ),
                                     transformSourceLocations( input.getSourceLocations() ) );
    }
    else
    {
      return super.transformCallback( input );
    }
  }

  @Nullable
  @Override
  protected CallbackInterfaceDefinition transformCallbackInterface( @Nonnull final CallbackInterfaceDefinition input )
  {
    final Matcher matcher = _namePattern.matcher( input.getName() );
    if ( matcher.matches() )
    {
      return new CallbackInterfaceDefinition( matcher.replaceAll( _replacement ),
                                              transformOperationMember( input.getOperation() ),
                                              transformConstants( input.getConstants() ),
                                              transformDocumentation( input.getDocumentation() ),
                                              transformExtendedAttributes( input.getExtendedAttributes() ),
                                              transformSourceLocations( input.getSourceLocations() ) );
    }
    else
    {
      return super.transformCallbackInterface( input );
    }
  }

  @Nullable
  @Override
  protected MixinDefinition transformMixin( @Nonnull final MixinDefinition input )
  {
    final Matcher matcher = _namePattern.matcher( input.getName() );
    if ( matcher.matches() )
    {
      return new MixinDefinition( matcher.replaceAll( _replacement ),
                                  transformConstants( input.getConstants() ),
                                  transformAttributeMembers( input.getAttributes() ),
                                  transformOperationMembers( input.getOperations() ),
                                  transformDocumentation( input.getDocumentation() ),
                                  transformExtendedAttributes( input.getExtendedAttributes() ),
                                  transformSourceLocations( input.getSourceLocations() ) );
    }
    else
    {
      return super.transformMixin( input );
    }
  }

  @Nullable
  @Override
  protected PartialMixinDefinition transformPartialMixin( @Nonnull final PartialMixinDefinition input )
  {
    final Matcher matcher = _namePattern.matcher( input.getName() );
    if ( matcher.matches() )
    {
      return new PartialMixinDefinition( matcher.replaceAll( _replacement ),
                                         transformConstants( input.getConstants() ),
                                         transformAttributeMembers( input.getAttributes() ),
                                         transformOperationMembers( input.getOperations() ),
                                         transformDocumentation( input.getDocumentation() ),
                                         transformExtendedAttributes( input.getExtendedAttributes() ),
                                         transformSourceLocations( input.getSourceLocations() ) );
    }
    else
    {
      return super.transformPartialMixin( input );
    }
  }

  @Nullable
  @Override
  protected InterfaceDefinition transformInterface( @Nonnull final InterfaceDefinition input )
  {
    final Matcher matcher1 = _namePattern.matcher( input.getName() );
    final String inherits = input.getInherits();
    final Matcher matcher2 = null != inherits ? _namePattern.matcher( inherits ) : null;
    if ( matcher1.matches() || ( null != matcher2 && matcher2.matches() ) )
    {
      return new InterfaceDefinition( matcher1.matches() ? matcher1.replaceAll( _replacement ) : input.getName(),
                                      ( null != matcher2 && matcher2.matches() ) ?
                                      matcher2.replaceAll( _replacement ) :
                                      input.getInherits(),
                                      transformConstants( input.getConstants() ),
                                      transformAttributeMembers( input.getAttributes() ),
                                      transformOperationMembers( input.getOperations() ),
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

  @Nullable
  @Override
  protected PartialInterfaceDefinition transformPartialInterface( @Nonnull final PartialInterfaceDefinition input )
  {
    final Matcher matcher = _namePattern.matcher( input.getName() );
    if ( matcher.matches() )
    {
      return new PartialInterfaceDefinition( matcher.replaceAll( _replacement ),
                                             transformConstants( input.getConstants() ),
                                             transformAttributeMembers( input.getAttributes() ),
                                             transformOperationMembers( input.getOperations() ),
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
      return super.transformPartialInterface( input );
    }
  }

  @Nullable
  @Override
  protected NamespaceDefinition transformNamespace( @Nonnull final NamespaceDefinition input )
  {
    final Matcher matcher = _namePattern.matcher( input.getName() );
    if ( matcher.matches() )
    {
      return new NamespaceDefinition( matcher.replaceAll( _replacement ),
                                      transformOperationMembers( input.getOperations() ),
                                      transformAttributeMembers( input.getAttributes() ),
                                      transformDocumentation( input.getDocumentation() ),
                                      transformExtendedAttributes( input.getExtendedAttributes() ),
                                      transformSourceLocations( input.getSourceLocations() ) );
    }
    else
    {
      return super.transformNamespace( input );
    }
  }

  @Nullable
  @Override
  protected PartialNamespaceDefinition transformPartialNamespace( @Nonnull final PartialNamespaceDefinition input )
  {
    final Matcher matcher = _namePattern.matcher( input.getName() );
    if ( matcher.matches() )
    {
      return new PartialNamespaceDefinition( matcher.replaceAll( _replacement ),
                                             transformOperationMembers( input.getOperations() ),
                                             transformAttributeMembers( input.getAttributes() ),
                                             transformDocumentation( input.getDocumentation() ),
                                             transformExtendedAttributes( input.getExtendedAttributes() ),
                                             transformSourceLocations( input.getSourceLocations() ) );
    }
    else
    {
      return super.transformPartialNamespace( input );
    }
  }

  @Nullable
  @Override
  protected DictionaryDefinition transformDictionary( @Nonnull final DictionaryDefinition input )
  {
    final Matcher matcher1 = _namePattern.matcher( input.getName() );
    final String inherits = input.getInherits();
    final Matcher matcher2 = null != inherits ? _namePattern.matcher( inherits ) : null;
    if ( matcher1.matches() || ( null != matcher2 && matcher2.matches() ) )
    {
      return new DictionaryDefinition( matcher1.matches() ? matcher1.replaceAll( _replacement ) : input.getName(),
                                       ( null != matcher2 && matcher2.matches() ) ?
                                       matcher2.replaceAll( _replacement ) :
                                       input.getInherits(),
                                       transformDictionaryMembers( input.getMembers() ),
                                       transformDocumentation( input.getDocumentation() ),
                                       transformExtendedAttributes( input.getExtendedAttributes() ),
                                       transformSourceLocations( input.getSourceLocations() ) );
    }
    else
    {
      return super.transformDictionary( input );
    }
  }

  @Nullable
  @Override
  protected PartialDictionaryDefinition transformPartialDictionary( @Nonnull final PartialDictionaryDefinition input )
  {
    final Matcher matcher = _namePattern.matcher( input.getName() );
    if ( matcher.matches() )
    {
      return new PartialDictionaryDefinition( matcher.replaceAll( _replacement ),
                                              transformDictionaryMembers( input.getMembers() ),
                                              transformDocumentation( input.getDocumentation() ),
                                              transformExtendedAttributes( input.getExtendedAttributes() ),
                                              transformSourceLocations( input.getSourceLocations() ) );
    }
    else
    {
      return super.transformPartialDictionary( input );
    }
  }

  @Nullable
  @Override
  protected IncludesStatement transformIncludesStatement( @Nonnull final IncludesStatement input )
  {
    final Matcher matcher1 = _namePattern.matcher( input.getInterfaceName() );
    if ( matcher1.matches() )
    {
      return new IncludesStatement( matcher1.replaceAll( _replacement ),
                                    input.getMixinName(),
                                    transformDocumentation( input.getDocumentation() ),
                                    transformExtendedAttributes( input.getExtendedAttributes() ),
                                    transformSourceLocations( input.getSourceLocations() ) );
    }
    else
    {
      final Matcher matcher2 = _namePattern.matcher( input.getMixinName() );
      if ( matcher2.matches() )
      {
        return new IncludesStatement( input.getInterfaceName(),
                                      matcher2.replaceAll( _replacement ),
                                      transformDocumentation( input.getDocumentation() ),
                                      transformExtendedAttributes( input.getExtendedAttributes() ),
                                      transformSourceLocations( input.getSourceLocations() ) );
      }
      else
      {
        return super.transformIncludesStatement( input );
      }
    }
  }

  @Nullable
  @Override
  protected TypedefDefinition transformTypedef( @Nonnull final TypedefDefinition input )
  {
    final Matcher matcher = _namePattern.matcher( input.getName() );
    if ( matcher.matches() )
    {
      return new TypedefDefinition( matcher.replaceAll( _replacement ),
                                    transformType( input.getType() ),
                                    transformDocumentation( input.getDocumentation() ),
                                    transformExtendedAttributes( input.getExtendedAttributes() ),
                                    transformSourceLocations( input.getSourceLocations() ) );
    }
    else
    {
      return super.transformTypedef( input );
    }
  }
}
