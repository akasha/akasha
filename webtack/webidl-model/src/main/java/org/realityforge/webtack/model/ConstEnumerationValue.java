package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class ConstEnumerationValue
  extends AttributedNode
{
  @Nonnull
  private final String _typeName;
  @Nonnull
  private final String _constName;
  /**
   * Documentation attached to the definition if any.
   */
  @Nullable
  private final DocumentationElement _documentation;

  public ConstEnumerationValue( @Nonnull final String typeName,
                                @Nonnull final String constName,
                                @Nullable final DocumentationElement documentation,
                                @Nonnull final List<ExtendedAttribute> extendedAttributes,
                                @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( extendedAttributes, sourceLocations );
    _typeName = Objects.requireNonNull( typeName );
    _constName = Objects.requireNonNull( constName );
    _documentation = documentation;
  }

  @Nonnull
  public String getTypeName()
  {
    return _typeName;
  }

  @Nonnull
  public String getConstName()
  {
    return _constName;
  }

  @Nullable
  public DocumentationElement getDocumentation()
  {
    return _documentation;
  }

  @Override
  public boolean equals( final Object o )
  {
    if ( this == o )
    {
      return true;
    }
    else if ( o == null || getClass() != o.getClass() || !super.equals( o ) )
    {
      return false;
    }
    else
    {
      final ConstEnumerationValue other = (ConstEnumerationValue) o;
      return _typeName.equals( other._typeName ) &&
             _constName.equals( other._constName ) &&
             Objects.equals( _documentation, other._documentation );
    }
  }

  @Override
  public int hashCode()
  {
    return Objects.hash( super.hashCode(), _typeName, _constName, _documentation );
  }

  public boolean equiv( @Nonnull final ConstEnumerationValue other )
  {
    final DocumentationElement documentation = other.getDocumentation();
    return _typeName.equals( other._typeName ) &&
           _constName.equals( other._constName ) &&
           ( null == _documentation ) == ( null == documentation ) &&
           ( null == _documentation || _documentation.equiv( documentation ) );
  }
}
