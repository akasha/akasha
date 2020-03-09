package org.realityforge.webtack.config;

public class SourceConfig
{
  private String name;
  private String title;
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

  public String getTitle()
  {
    return title;
  }

  public void setTitle( final String title )
  {
    this.title = title;
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
