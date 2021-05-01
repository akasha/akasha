package org.realityforge.webtack.model.tools.processors.add_no_side_effects_extended_attribute;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.DictionaryDefinition;
import org.realityforge.webtack.model.ExtendedAttribute;
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
import org.realityforge.webtack.model.tools.util.ExtendedAttributes;

final class AddNoSideEffectsExtendedAttributeProcessor
  extends AbstractProcessor
  implements Completable
{
  @Nonnull
  private static final ExtendedAttribute NO_SIDE_EFFECTS =
    ExtendedAttribute.createExtendedAttributeNoArgs( ExtendedAttributes.NO_SIDE_EFFECTS,
                                                     Collections.emptyList() );
  @Nonnull
  private final Set<String> _operationsToMatch;
  private String _elementName;
  @Nonnull
  private final Set<String> _remainingOperationsToMatch = new HashSet<>();

  AddNoSideEffectsExtendedAttributeProcessor( @Nonnull final PipelineContext context, @Nonnull final Path file )
  {
    super( context );
    try
    {
      _operationsToMatch =
        Files
          .readAllLines( file )
          .stream()
          .map( String::trim )
          .filter( l -> !l.isEmpty() )
          .filter( l -> !l.startsWith( "#" ) )
          .collect( Collectors.toSet() );
    }
    catch ( final Exception e )
    {
      throw new IllegalStateException( "Failed to load NoSideEffectsExtended list file " +
                                       Objects.requireNonNull( file ), e );
    }
  }

  @Override
  public void onComplete()
  {
    if ( !_remainingOperationsToMatch.isEmpty() )
    {
      context().error( "Failed to match " +
                       _remainingOperationsToMatch.size() +
                       " operations of " +
                       _operationsToMatch.size() +
                       ".\n" +
                       _remainingOperationsToMatch.stream()
                         .sorted()
                         .map( t -> "\t" + t )
                         .collect( Collectors.joining( "\n" ) ) );
    }
  }

  @Nullable
  @Override
  public WebIDLSchema process( @Nonnull final WebIDLSchema schema )
  {
    _remainingOperationsToMatch.clear();
    _remainingOperationsToMatch.addAll( _operationsToMatch );
    return super.process( schema );
  }

  @Nullable
  @Override
  protected MixinDefinition transformMixin( @Nonnull final MixinDefinition input )
  {
    _elementName = input.isNoArgsExtendedAttributePresent( ExtendedAttributes.GLOBAL_OBJECT ) ? "" : input.getName();
    try
    {
      return super.transformMixin( input );
    }
    finally
    {
      _elementName = null;
    }
  }

  @Nullable
  @Override
  protected PartialMixinDefinition transformPartialMixin( @Nonnull final PartialMixinDefinition input )
  {
    _elementName = input.isNoArgsExtendedAttributePresent( ExtendedAttributes.GLOBAL_OBJECT ) ? "" : input.getName();
    try
    {
      return super.transformPartialMixin( input );
    }
    finally
    {
      _elementName = null;
    }
  }

  @Nullable
  @Override
  protected InterfaceDefinition transformInterface( @Nonnull final InterfaceDefinition input )
  {
    _elementName = input.getName();
    try
    {
      return super.transformInterface( input );
    }
    finally
    {
      _elementName = null;
    }
  }

  @Nullable
  @Override
  protected PartialInterfaceDefinition transformPartialInterface( @Nonnull final PartialInterfaceDefinition input )
  {
    _elementName = input.getName();
    try
    {
      return super.transformPartialInterface( input );
    }
    finally
    {
      _elementName = null;
    }
  }

  @Nullable
  @Override
  protected NamespaceDefinition transformNamespace( @Nonnull final NamespaceDefinition input )
  {
    _elementName = input.getName();
    try
    {
      return super.transformNamespace( input );
    }
    finally
    {
      _elementName = null;
    }
  }

  @Nullable
  @Override
  protected PartialNamespaceDefinition transformPartialNamespace( @Nonnull final PartialNamespaceDefinition input )
  {
    _elementName = input.getName();
    try
    {
      return super.transformPartialNamespace( input );
    }
    finally
    {
      _elementName = null;
    }
  }

  @Nonnull
  @Override
  protected OperationMember transformOperationMember( @Nonnull final OperationMember input )
  {
    final OperationMember.Kind kind = input.getKind();
    if ( OperationMember.Kind.CONSTRUCTOR == kind )
    {
      return new OperationMember( kind,
                                  input.getName(),
                                  transformArguments( input.getArguments() ),
                                  transformType( input.getReturnType() ),
                                  transformDocumentation( input.getDocumentation() ),
                                  matchesMemberName( _elementName ) ?
                                  expandExtendedAttributes( input.getExtendedAttributes() ) :
                                  transformExtendedAttributes( input.getExtendedAttributes() ),
                                  transformSourceLocations( input.getSourceLocations() ) );
    }
    else
    {
      final String name = input.getName();
      return new OperationMember( kind,
                                  name,
                                  transformArguments( input.getArguments() ),
                                  transformType( input.getReturnType() ),
                                  transformDocumentation( input.getDocumentation() ),
                                  null != name && matchesMemberName( name ) ?
                                  expandExtendedAttributes( input.getExtendedAttributes() ) :
                                  transformExtendedAttributes( input.getExtendedAttributes() ),
                                  transformSourceLocations( input.getSourceLocations() ) );
    }
  }

  @Nonnull
  private List<ExtendedAttribute> expandExtendedAttributes( @Nonnull final List<ExtendedAttribute> inputs )
  {
    final List<ExtendedAttribute> extendedAttributes = new ArrayList<>( inputs );
    extendedAttributes.add( NO_SIDE_EFFECTS );
    return extendedAttributes;
  }

  private boolean matchesMemberName( @Nonnull final String name )
  {
    if ( null == _elementName )
    {
      return false;
    }
    else
    {
      final String key = _elementName.isEmpty() ? name : _elementName + "." + name;
      if ( _operationsToMatch.contains( key ) )
      {
        _remainingOperationsToMatch.remove( key );
        return true;
      }
      else
      {
        return false;
      }
    }
  }
}
