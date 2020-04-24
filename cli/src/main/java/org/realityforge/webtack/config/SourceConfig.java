package org.realityforge.webtack.config;

public class SourceConfig
{
  private String name;
  private String url;
  private long lastModifiedTime;

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
}
