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

@JsonbPropertyOrder( { "kind", "name", "href", "description", "content", "constructors", "properties", "methods" } )
public class DocEntry
{
  private DocKind kind;
  private String name;
  private String href;
  private String description;
  private String content;
  @Nullable
  private List<String> constructors;
  @Nullable
  private List<String> properties;
  @Nullable
  private List<String> methods;

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

  public String getContent()
  {
    return content;
  }

  public void setContent( final String content )
  {
    this.content = content;
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

  @Nonnull
  public static DocEntry load( @Nonnull final Path path )
    throws Exception
  {
    try ( final InputStream inputStream = new FileInputStream( path.toFile() ) )
    {
      return JsonbBuilder.create().fromJson( inputStream, DocEntry.class );
    }
  }

  public static void save( @Nonnull final DocEntry entry, @Nonnull final Path path )
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
