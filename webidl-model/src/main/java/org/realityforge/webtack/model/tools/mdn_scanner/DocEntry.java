package org.realityforge.webtack.model.tools.mdn_scanner;

import java.util.List;
import javax.annotation.Nullable;
import javax.json.bind.annotation.JsonbPropertyOrder;

@JsonbPropertyOrder( { "name", "href", "description", "content", "constructors", "properties", "methods" } )
public class DocEntry
{
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
}
