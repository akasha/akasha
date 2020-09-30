callback Function = any ( any... arguments );

[Exposed=Window]
interface DOMTokenList {
  [CEReactions]
  undefined add( DOMString... tokens );
  boolean contains( DOMString token );
  [CEReactions]
  undefined remove( DOMString... tokens );
};
