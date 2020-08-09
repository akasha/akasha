package org.realityforge.webtack.model.tools.mdn_scanner.config2;

import javax.json.bind.annotation.JsonbPropertyOrder;

@JsonbPropertyOrder( { "name", "lastModifiedAt" } )
public class EntryIndex
{
  private String name;
  private long lastModifiedAt;

  public String getName()
  {
    return name;
  }

  public void setName( final String name )
  {
    this.name = name;
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
