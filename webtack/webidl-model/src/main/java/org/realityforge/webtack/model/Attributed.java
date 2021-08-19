package org.realityforge.webtack.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public interface Attributed
{
  @Nonnull
  List<ExtendedAttribute> getExtendedAttributes();

  @Nullable
  default String getIdentValue( @Nonnull final String name )
  {
    return getExtendedAttributes()
      .stream()
      .filter( a -> ExtendedAttribute.Kind.IDENT == a.getKind() && name.equals( a.getName() ) )
      .map( ExtendedAttribute::getIdent )
      .findAny()
      .orElse( null );
  }

  @Nonnull
  default List<String> getIdentValueOrValues( @Nonnull final String name )
  {
    return getExtendedAttributes()
      .stream()
      .filter( a -> ExtendedAttribute.Kind.IDENT == a.getKind() || ExtendedAttribute.Kind.IDENT_LIST == a.getKind() )
      .filter( a -> a.getName().equals( name ) )
      .flatMap( a -> ExtendedAttribute.Kind.IDENT == a.getKind() ?
                     Stream.of( a.getIdent() ) :
                     a.getIdentList().stream() )
      .collect( Collectors.toList() );
  }

  default boolean isNoArgsExtendedAttributePresent( @Nonnull final String name )
  {
    return getExtendedAttributes()
      .stream()
      .filter( a -> ExtendedAttribute.Kind.NO_ARGS == a.getKind() )
      .anyMatch( a -> name.equals( a.getName() ) );
  }

  default boolean equiv( @Nonnull final Attributed other )
  {
    final List<ExtendedAttribute> otherAttributes = other.getExtendedAttributes();
    final List<ExtendedAttribute> extendedAttributes = getExtendedAttributes();
    if ( otherAttributes.size() != extendedAttributes.size() )
    {
      return false;
    }
    else
    {
      final Set<ExtendedAttribute> otherAttr = new HashSet<>( otherAttributes );
      for ( final ExtendedAttribute extendedAttribute : extendedAttributes )
      {
        if ( !otherAttr.removeIf( extendedAttribute::equiv ) )
        {
          return false;
        }
      }
      return true;
    }
  }
}
