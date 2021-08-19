package org.realityforge.webtack.model;

import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.tools.util.ExtendedAttributes;

public abstract class Element
  extends AttributedNode
{
  /**
   * Documentation attached to the element if any.
   */
  @Nullable
  private final DocumentationElement _documentation;

  Element( @Nullable final DocumentationElement documentation,
           @Nonnull final List<ExtendedAttribute> extendedAttributes,
           @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( extendedAttributes, sourceLocations );
    _documentation = documentation;
  }

  @Nullable
  public DocumentationElement getDocumentation()
  {
    return _documentation;
  }

  @Nonnull
  public List<String> getExposureSet()
  {
    return getIdentValueOrValues( ExtendedAttributes.EXPOSED );
  }

  public boolean isExposedOnAnyGlobal()
  {
    return getExtendedAttributes()
      .stream()
      .filter( a -> ExtendedAttribute.Kind.IDENT == a.getKind() || ExtendedAttribute.Kind.IDENT_LIST == a.getKind() )
      .anyMatch( a -> a.getName().equals( ExtendedAttributes.EXPOSED ) );
  }

  @SuppressWarnings( "BooleanMethodIsAlwaysInverted" )
  boolean equiv( @Nonnull final Element other )
  {
    final DocumentationElement documentation = other.getDocumentation();
    return super.equiv( other ) &&
           ( null == _documentation ) == ( null == documentation ) &&
           ( null == _documentation || _documentation.equiv( documentation ) );
  }
}
