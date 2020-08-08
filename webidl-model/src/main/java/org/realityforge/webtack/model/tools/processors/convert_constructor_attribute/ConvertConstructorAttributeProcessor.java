package org.realityforge.webtack.model.tools.processors.convert_constructor_attribute;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.ExtendedAttribute;
import org.realityforge.webtack.model.InterfaceDefinition;
import org.realityforge.webtack.model.Kind;
import org.realityforge.webtack.model.OperationMember;
import org.realityforge.webtack.model.Type;
import org.realityforge.webtack.model.tools.processors.AbstractProcessor;

final class ConvertConstructorAttributeProcessor
  extends AbstractProcessor
{
  @Nullable
  private InterfaceDefinition _interface;

  @Nullable
  @Override
  protected InterfaceDefinition transformInterface( @Nonnull final InterfaceDefinition input )
  {
    try
    {
      _interface = input;
      return super.transformInterface( input );
    }
    finally
    {
      _interface = null;
    }
  }

  @Nonnull
  @Override
  protected List<OperationMember> transformOperationMembers( @Nonnull final List<OperationMember> inputs )
  {
    final List<OperationMember> operations = super.transformOperationMembers( inputs );
    if ( null != _interface )
    {
      final List<ExtendedAttribute> constructorAttributes =
        _interface
          .getExtendedAttributes()
          .stream()
          .filter( this::isConstructorAttribute )
          .collect( Collectors.toList() );
      for ( final ExtendedAttribute attribute : constructorAttributes )
      {
        operations.add( new OperationMember( OperationMember.Kind.CONSTRUCTOR,
                                             null,
                                             attribute.getArgList(),
                                             new Type( Kind.Void,
                                                       Collections.emptyList(),
                                                       false,
                                                       Collections.emptyList() ),
                                             null,
                                             Collections.emptyList(),
                                             Collections.emptyList() ) );
      }
    }

    return operations;
  }

  @Nonnull
  @Override
  protected List<ExtendedAttribute> transformExtendedAttributes( @Nonnull final List<ExtendedAttribute> inputs )
  {
    return inputs
      .stream()
      .filter( a -> !isConstructorAttribute( a ) )
      .collect( Collectors.toList() );
  }

  private boolean isConstructorAttribute( @Nonnull final ExtendedAttribute attribute )
  {
    return ExtendedAttribute.Kind.ARG_LIST == attribute.getKind() && "Constructor".equals( attribute.getArgListName() );
  }
}
