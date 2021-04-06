typedef ( DOMString or long long ) StringifySpaceUnionType;

interface MyJSON {
  DOMString stringify( any value, optional StringifySpaceUnionType? space = null );
};
