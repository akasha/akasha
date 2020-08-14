// Patch HTMLFormControlsCollection so that it does not inherit from HTMLCollection
// as the namedItem method has a return type incompatible with HTMLCollection.namedItem
// method

[Exposed=Window, LegacyUnenumerableNamedProperties]
interface HTMLFormControlsCollection {
  readonly attribute unsigned long length;
  getter ( RadioNodeList or Element )? item( unsigned long index );
  getter ( RadioNodeList or Element )? namedItem( DOMString name );
};
