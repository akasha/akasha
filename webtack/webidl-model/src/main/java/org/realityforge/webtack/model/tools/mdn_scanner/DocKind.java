package org.realityforge.webtack.model.tools.mdn_scanner;

public enum DocKind
{
  // A javascript class, webidl interface
  Type,
  // A javascript constructor, webidl operation of constructor kind
  Constructor,
  // A javascript property, webidl attribute and/or member
  Property,
  // A javascript static/instance method/function, webidl operation not of type constructor
  Method,
  // A javascript event, not directly represented in webidl
  Event
}
