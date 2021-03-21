package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class EventMember
  extends Element
  implements Member, Named
{
  @Nonnull
  private final TypeReference _eventType;
  @Nonnull
  private final String _name;

  public EventMember( @Nonnull final String name,
                      @Nonnull final TypeReference eventType,
                      @Nullable final DocumentationElement documentation,
                      @Nonnull final List<ExtendedAttribute> extendedAttributes,
                      @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( documentation, extendedAttributes, sourceLocations );
    _eventType = Objects.requireNonNull( eventType );
    _name = Objects.requireNonNull( name );
  }

  @Nonnull
  public TypeReference getEventType()
  {
    return _eventType;
  }

  @Nonnull
  @Override
  public String getName()
  {
    return _name;
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
      final EventMember other = (EventMember) o;
      return _name.equals( other._name ) && _eventType.equals( other._eventType );
    }
  }

  @Override
  public int hashCode()
  {
    return Objects.hash( super.hashCode(), _name, _eventType );
  }

  public boolean equiv( @Nonnull final EventMember other )
  {
    return super.equiv( other ) &&
           _name.equals( other._name ) &&
           _eventType.equiv( other._eventType );
  }
}
