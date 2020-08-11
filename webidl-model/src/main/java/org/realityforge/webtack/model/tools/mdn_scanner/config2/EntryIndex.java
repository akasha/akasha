package org.realityforge.webtack.model.tools.mdn_scanner.config2;

import java.util.Objects;
import javax.annotation.Nonnull;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.json.bind.annotation.JsonbTransient;

@JsonbPropertyOrder( { "name", "lastModifiedAt" } )
public class EntryIndex
{
  //qualifiedName exists to stop Jsonb crashing when it can not find field for @JsonbTransient setter
  @SuppressWarnings( "unused" )
  private String qualifiedName;
  @JsonbTransient
  private DocIndex docIndex;
  private String name;
  private long lastModifiedAt;

  public DocIndex getDocIndex()
  {
    return docIndex;
  }

  void setDocIndex( @Nonnull final DocIndex docIndex )
  {
    this.docIndex = Objects.requireNonNull( docIndex );
  }

  @JsonbTransient
  public String getQualifiedName()
  {
    return docIndex.getName() + "." + name;
  }

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
