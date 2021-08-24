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
    return getEvents().stream().filter( e -> e.getName().equals( name ) ).findFirst().orElse( null );
  }

  @Nonnull
  default EventMember getEventByName( @Nonnull final String name )
  {
    return Objects.requireNonNull( findEventByName( name ), "Missing expected event with name " + name );
  }
}
