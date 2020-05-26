package org.realityforge.webtack.model.tools.repository.config;

import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class SourceConfig
{
  @Nonnull
  public static final String IDL_SUFFIX = ".webidl";

  private String name;
  @Nullable
  private String url;
  @Nullable
  private String selector;
  private long lastModifiedTime;
  @Nullable
  private List<String> tags;

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

  @Nullable
  public String getSelector()
  {
    return selector;
  }

  public void setSelector( @Nullable final String selector )
  {
    this.selector = selector;
  }

  public long getLastModifiedTime()
  {
    return lastModifiedTime;
  }

  public void setLastModifiedTime( final long lastModifiedTime )
  {
    this.lastModifiedTime = lastModifiedTime;
  }

  @Nullable
  public List<String> getTags()
  {
    return tags;
  }

  public void setTags( @Nullable final List<String> tags )
  {
    this.tags = tags;
  }
}
