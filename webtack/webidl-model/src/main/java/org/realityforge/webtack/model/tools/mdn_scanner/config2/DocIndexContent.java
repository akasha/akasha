package org.realityforge.webtack.model.tools.mdn_scanner.config2;

import java.util.List;
import javax.json.bind.annotation.JsonbPropertyOrder;

@JsonbPropertyOrder( { "name", "lastModifiedAt", "entries" } )
public final class DocIndexContent
{
  private String name;
  private long lastModifiedAt;
  private List<EntryIndex> _entries;

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

  public List<EntryIndex> getEntries()
  {
    return _entries;
  }

  public void setEntries( final List<EntryIndex> entries )
  {
    _entries = entries;
  }
}
