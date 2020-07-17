callback Function = any ( any... arguments );

[Exposed=Window]
interface DOMTokenList {
  [CEReactions]
  void add( DOMString... tokens );
  boolean contains( DOMString token );
  [CEReactions]
  void remove( DOMString... tokens );
};
