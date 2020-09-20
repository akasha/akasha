package org.realityforge.webtack.model.tools.processors.convert_factory_function_attribute;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.ExtendedAttribute;
import org.realityforge.webtack.model.InterfaceDefinition;
import org.realityforge.webtack.model.Kind;
import org.realityforge.webtack.model.OperationMember;
import org.realityforge.webtack.model.Type;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.tools.processors.AbstractProcessor;
import org.realityforge.webtack.model.tools.spi.Completable;
import org.realityforge.webtack.model.tools.spi.PipelineContext;
import org.realityforge.webtack.model.tools.util.ExtendedAttributes;

final class ConvertFactoryFunctionAttributeProcessor
  extends AbstractProcessor
  implements Completable
{
  @Nonnull
  private final Map<String, InterfaceDefinition> _interfaces = new HashMap<>();
  @Nonnull
  private final PipelineContext _context;
  private final int _expectedConvertCount;
  private int _convertCount;
  private boolean _legacyFactoryFunctionPresent;

  ConvertFactoryFunctionAttributeProcessor( @Nonnull final PipelineContext context,
                                            final int expectedConvertCount )
  {
    _context = Objects.requireNonNull( context );
    _expectedConvertCount = expectedConvertCount;
  }

  @Override
  public void onComplete()
  {
    if ( _expectedConvertCount > 0 )
    {
      if ( _convertCount != _expectedConvertCount )
      {
        _context.error( "Converted " + _convertCount + " elements but expected to " +
                        "convert " + _expectedConvertCount + " elements." );
      }
    }
    else
    {
      if ( 0 == _convertCount )
      {
        _context.info( "Converted " + _convertCount + " elements." );
      }
      else
      {
        _context.debug( "Converted " + _convertCount + " elements." );
      }
    }
  }

  @Nullable
  @Override
  public WebIDLSchema process( @Nonnull final WebIDLSchema schema )
  {
    _interfaces.clear();
    return super.process( schema );
  }

  @Nonnull
  @Override
  protected Map<String, InterfaceDefinition> transformInterfaces( @Nonnull final Collection<InterfaceDefinition> inputs )
  {
    final Map<String, InterfaceDefinition> definitions = super.transformInterfaces( inputs );
    definitions.putAll( _interfaces );
    _interfaces.clear();
    return definitions;
  }

  @Nullable
  @Override
  protected InterfaceDefinition transformInterface( @Nonnull final InterfaceDefinition input )
  {
    _legacyFactoryFunctionPresent =
      0 != input
        .getExtendedAttributes()
        .stream()
        .filter( this::isFactoryFunctionAttribute )
        .peek( extendedAttribute -> createFactoryType( input, extendedAttribute ) )
        .count();
    try
    {
      return super.transformInterface( input );
    }
    finally
    {
      _legacyFactoryFunctionPresent = false;
    }
  }

  private void createFactoryType( @Nonnull final InterfaceDefinition input,
                                  final ExtendedAttribute extendedAttribute )
  {
    _convertCount++;
    final InterfaceDefinition definition =
      new InterfaceDefinition( extendedAttribute.getArgListName(),
                               input.getName(),
                               Collections.emptyList(),
                               Collections.emptyList(),
                               Collections.singletonList( new OperationMember( OperationMember.Kind.CONSTRUCTOR,
                                                                               null,
                                                                               extendedAttribute.getArgList(),
                                                                               new Type( Kind.Void,
                                                                                         Collections.emptyList(),
                                                                                         false,
                                                                                         Collections.emptyList() ),
                                                                               null,
                                                                               Collections.emptyList(),
                                                                               Collections.emptyList() ) ),
                               Collections.emptyList(),
                               null,
                               null,
                               null,
                               null,
                               null,
                               Collections.emptyList(),
                               Collections.emptyList() );
    _interfaces.put( definition.getName(), definition );
  }

  @Nonnull
  @Override
  protected List<OperationMember> transformOperationMembers( @Nonnull final List<OperationMember> inputs )
  {
    return super.transformOperationMembers( _legacyFactoryFunctionPresent ?
                                            inputs
                                              .stream()
                                              .filter( o -> OperationMember.Kind.CONSTRUCTOR != o.getKind() )
                                              .collect( Collectors.toList() ) :
                                            inputs );
  }

  @Nonnull
  @Override
  protected List<ExtendedAttribute> transformExtendedAttributes( @Nonnull final List<ExtendedAttribute> inputs )
  {
    return inputs
      .stream()
      .filter( a -> !isFactoryFunctionAttribute( a ) )
      .collect( Collectors.toList() );
  }

  private boolean isFactoryFunctionAttribute( @Nonnull final ExtendedAttribute attribute )
  {
    return ExtendedAttribute.Kind.NAMED_ARG_LIST == attribute.getKind() &&
           ExtendedAttributes.LEGACY_FACTORY_FUNCTION.equals( attribute.getName() );
  }
}
