package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public interface EventMemberContainer
{
  @Nonnull
  List<EventMember> getEvents();

  @Nullable
  default EventMember findEventByName( @Nonnull final String name )
  {
    return findEventByName( name, false );
  }

  @Nullable
  default EventMember findEventByName( @Nonnull final String name, final boolean searchParent )
  {
    return getEvents()
      .stream()
      .filter( e -> e.getName().equals( name ) )
      .findFirst()
      .orElseGet( () -> {
        if ( searchParent )
        {
          final EventMemberContainer parent = getParentEventMemberContainer();
          return null == parent ? null : parent.findEventByName( name, searchParent );
        }
        else
        {
          return null;
        }
      } );
  }

  @Nonnull
  default EventMember getEventByName( @Nonnull final String name )
  {
    return Objects.requireNonNull( findEventByName( name ), "Missing expected event with name " + name );
  }

  @Nullable
  default EventMemberContainer getParentEventMemberContainer()
  {
    return null;
  }
}
