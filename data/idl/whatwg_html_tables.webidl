[Exposed=Window]
interface HTMLTableSectionElement : HTMLElement {
  [SameObject]
  readonly attribute HTMLCollection rows;
  [HTMLConstructor]
  constructor();
  [CEReactions]
  void deleteRow( long index );
  HTMLTableRowElement insertRow( optional long index = -1 );
};

[Exposed=Window]
interface HTMLTableRowElement : HTMLElement {
  [SameObject]
  readonly attribute HTMLCollection cells;
  readonly attribute long rowIndex;
  readonly attribute long sectionRowIndex;
  [HTMLConstructor]
  constructor();
  [CEReactions]
  void deleteCell( long index );
  HTMLTableCellElement insertCell( optional long index = -1 );
};

[Exposed=Window]
interface HTMLTableColElement : HTMLElement {
  [CEReactions]
  attribute unsigned long span;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLTableElement : HTMLElement {
  [SameObject]
  readonly attribute HTMLCollection rows;
  [SameObject]
  readonly attribute HTMLCollection tBodies;
  [CEReactions]
  attribute HTMLTableCaptionElement? caption;
  [CEReactions]
  attribute HTMLTableSectionElement? tFoot;
  [CEReactions]
  attribute HTMLTableSectionElement? tHead;
  [HTMLConstructor]
  constructor();
  HTMLTableCaptionElement createCaption();
  HTMLTableSectionElement createTBody();
  HTMLTableSectionElement createTFoot();
  HTMLTableSectionElement createTHead();
  [CEReactions]
  void deleteCaption();
  [CEReactions]
  void deleteRow( long index );
  [CEReactions]
  void deleteTFoot();
  [CEReactions]
  void deleteTHead();
  HTMLTableRowElement insertRow( optional long index = -1 );
};

[Exposed=Window]
interface HTMLTableCellElement : HTMLElement {
  readonly attribute long cellIndex;
  [CEReactions]
  attribute DOMString abbr;
  [CEReactions]
  attribute unsigned long colSpan;
  [CEReactions]
  attribute DOMString headers;
  [CEReactions]
  attribute unsigned long rowSpan;
  [CEReactions]
  attribute DOMString scope;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLTableCaptionElement : HTMLElement {
  [HTMLConstructor]
  constructor();
};
