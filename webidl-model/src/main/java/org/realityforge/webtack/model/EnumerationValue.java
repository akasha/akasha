package org.realityforge.webtack.model;

import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class EnumerationValue
{
  @Nonnull
  private final String _value;
  /**
   * Documentation attached to the definition if any.
   */
  @Nullable
  private final DocumentationElement _documentation;

  public EnumerationValue( @Nonnull final String value,
                           @Nullable final DocumentationElement documentation )
  {
    _value = Objects.requireNonNull( value );
    _documentation = documentation;
  }

  @Nonnull
  public String getValue()
  {
    return _value;
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
      final EnumerationValue other = (EnumerationValue) o;
      return _value.equals( other._value ) && Objects.equals( _documentation, other._documentation );
    }
  }

  @Override
  public int hashCode()
  {
    return Objects.hash( super.hashCode(), _value, _documentation );
  }

  public boolean equiv( @Nonnull final EnumerationValue other )
  {
    final DocumentationElement documentation = other.getDocumentation();
    return _value.equals( other._value ) &&
           ( null == _documentation ) == ( null == documentation ) &&
           ( null == _documentation || _documentation.equiv( documentation ) );
  }
}
