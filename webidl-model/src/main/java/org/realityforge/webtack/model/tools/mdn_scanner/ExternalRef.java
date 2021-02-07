package org.realityforge.webtack.model.tools.mdn_scanner;

import javax.json.bind.annotation.JsonbPropertyOrder;

@JsonbPropertyOrder( { "name", "href" } )
public class ExternalRef
{
  private String name;
  private String href;

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
}
