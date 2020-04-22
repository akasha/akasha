[Exposed=Window]
interface HTMLFormControlsCollection : HTMLCollection {
  getter ( RadioNodeList or Element )? namedItem( DOMString name );
};

[Exposed=(Window,Worker)]
interface DOMStringList {
  readonly attribute unsigned long length;
  boolean contains( DOMString string );
  getter DOMString? item( unsigned long index );
};

[Exposed=Window]
interface HTMLOptionsCollection : HTMLCollection {
  [CEReactions]
  attribute unsigned long length;
  attribute long selectedIndex;
  [CEReactions]
  void add( ( HTMLOptionElement or HTMLOptGroupElement ) element, optional ( HTMLElement or long )? before = null );
  [CEReactions]
  void remove( long index );
  [CEReactions]
  setter void ( unsigned long index, HTMLOptionElement? option );
};

[Exposed=Window, LegacyUnenumerableNamedProperties]
interface HTMLAllCollection {
  readonly attribute unsigned long length;
  ( HTMLCollection or Element )? item( optional DOMString nameOrIndex );
  getter ( HTMLCollection or Element )? namedItem( DOMString name );
  getter Element ( unsigned long index );
};

[Exposed=Window]
interface RadioNodeList : NodeList {
  attribute DOMString value;
};
