package org.realityforge.webtack.config;

import java.util.List;

public class SourceConfig
{
  private String name;
  private String url;
  private long lastModifiedTime;
  private List<String> tags;

  public String getName()
  {
    return name;
  }

  public void setName( final String name )
  {
    this.name = name;
  }

  public String getUrl()
  {
    return url;
  }

  public void setUrl( final String url )
  {
    this.url = url;
  }

  public long getLastModifiedTime()
  {
    return lastModifiedTime;
  }

  public void setLastModifiedTime( final long lastModifiedTime )
  {
    this.lastModifiedTime = lastModifiedTime;
  }

  public List<String> getTags()
  {
    return tags;
  }

  public void setTags( final List<String> tags )
  {
    this.tags = tags;
  }
}
