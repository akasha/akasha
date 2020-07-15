package org.realityforge.webtack.model.tools.processors.remove_element;

import javax.json.bind.annotation.JsonbProperty;

public enum ElementType
{
  callback,
  callback_interface,
  dictionary,
  enumeration,
  @JsonbProperty( "interface" )
  interface_type,
  mixin,
  namespace
}
