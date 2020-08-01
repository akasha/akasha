package org.realityforge.webtack.model.tools.repository.config;

import javax.annotation.Nullable;

public final class DocSourceConfig
{
  /**
   * The qualified name of the element
   */
  private String name;
  @Nullable
  private String url;
  private long lastModifiedAt;

  public String getName()
  {
    return name;
  }

  public void setName( final String name )
  {
    this.name = name;
  }

  @Nullable
  public String getUrl()
  {
    return url;
  }

  public void setUrl( @Nullable final String url )
  {
    this.url = url;
  }

  public long getLastModifiedAt()
  {
    return lastModifiedAt;
  }

  public void setLastModifiedAt( final long lastModifiedAt )
  {
    this.lastModifiedAt = lastModifiedAt;
  }
}
