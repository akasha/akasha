typedef ( DOMString or long long ) StringifySpaceUnionType;

interface JSON {
  DOMString stringify( any value, optional StringifySpaceUnionType? space = null );
};
