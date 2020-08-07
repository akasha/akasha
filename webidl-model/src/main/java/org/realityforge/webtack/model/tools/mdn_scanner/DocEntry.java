package org.realityforge.webtack.model.tools.mdn_scanner;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.annotation.JsonbPropertyOrder;

@JsonbPropertyOrder( { "kind",
                       "name",
                       "href",
                       "description",
                       "content",
                       "constructors",
                       "properties",
                       "methods",
                       "events" } )
public class DocEntry
{
  private DocKind kind;
  private String name;
  private String href;
  private String description;
  // field is only present when kind == Type
  @Nullable
  private List<String> constructors;
  // field is only present when kind == Type
  @Nullable
  private List<String> properties;
  // field is only present when kind == Type
  @Nullable
  private List<String> methods;
  // field is only present when kind == Type
  @Nullable
  private List<String> events;
  // field is only present when kind == Event
  @Nullable
  private String eventName;
  // field is only present when kind == Event
  @Nullable
  private String eventType;
  // field is only present when kind == Event
  @Nullable
  private String eventHandlerProperty;

  public DocKind getKind()
  {
    return kind;
  }

  public void setKind( final DocKind kind )
  {
    this.kind = kind;
  }

  public String getName()
  {
    return name;
  }

  public void setName( final String name )
  {
    this.name = name;
  }

  public String getHref()
  {
    return href;
  }

  public void setHref( final String href )
  {
    this.href = href;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription( final String description )
  {
    this.description = description;
  }

  @Nullable
  public List<String> getConstructors()
  {
    return constructors;
  }

  public void setConstructors( @Nullable final List<String> constructors )
  {
    this.constructors = constructors;
  }

  @Nullable
  public List<String> getProperties()
  {
    return properties;
  }

  public void setProperties( @Nullable final List<String> properties )
  {
    this.properties = properties;
  }

  @Nullable
  public List<String> getMethods()
  {
    return methods;
  }

  public void setMethods( @Nullable final List<String> methods )
  {
    this.methods = methods;
  }

  @Nullable
  public List<String> getEvents()
  {
    return events;
  }

  public void setEvents( @Nullable final List<String> events )
  {
    this.events = events;
  }

  @Nullable
  public String getEventName()
  {
    return eventName;
  }

  public void setEventName( @Nullable final String eventName )
  {
    this.eventName = eventName;
  }

  @Nullable
  public String getEventType()
  {
    return eventType;
  }

  public void setEventType( @Nullable final String eventType )
  {
    this.eventType = eventType;
  }

  @Nullable
  public String getEventHandlerProperty()
  {
    return eventHandlerProperty;
  }

  public void setEventHandlerProperty( @Nullable final String eventHandlerProperty )
  {
    this.eventHandlerProperty = eventHandlerProperty;
  }

  @Nonnull
  static DocEntry load( @Nonnull final Path path )
    throws Exception
  {
    try ( final InputStream inputStream = new FileInputStream( path.toFile() ) )
    {
      return JsonbBuilder.create().fromJson( inputStream, DocEntry.class );
    }
  }

  static void save( @Nonnull final DocEntry entry, @Nonnull final Path path )
    throws Exception
  {
    Files.createDirectories( path.getParent() );
    final JsonbConfig jsonbConfig = new JsonbConfig().withFormatting( true );
    final Jsonb jsonb = JsonbBuilder.create( jsonbConfig );
    try ( final FileOutputStream outputStream = new FileOutputStream( path.toFile() ) )
    {
      jsonb.toJson( entry, outputStream );
    }
    jsonb.close();
    // Add newline as json output omits trailing new line
    Files.write( path, new byte[]{ '\n' }, StandardOpenOption.APPEND );
  }
}
