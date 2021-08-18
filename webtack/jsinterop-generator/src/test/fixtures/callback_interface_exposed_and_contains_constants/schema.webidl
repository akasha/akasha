[Exposed=Window]
callback interface NodeFilter {
  const unsigned short FILTER_ACCEPT = 1;
  const unsigned short FILTER_REJECT = 2;
  const unsigned short FILTER_SKIP = 3;
  const unsigned long SHOW_ALL = 0xFFFFFFFF;
  const unsigned long SHOW_ATTRIBUTE = 0x2;
  const unsigned long SHOW_CDATA_SECTION = 0x8;
  const unsigned long SHOW_COMMENT = 0x80;
  const unsigned long SHOW_DOCUMENT = 0x100;
  const unsigned long SHOW_DOCUMENT_FRAGMENT = 0x400;
  const unsigned long SHOW_DOCUMENT_TYPE = 0x200;
  const unsigned long SHOW_ELEMENT = 0x1;
  const unsigned long SHOW_ENTITY = 0x20;
  const unsigned long SHOW_ENTITY_REFERENCE = 0x10;
  const unsigned long SHOW_NOTATION = 0x800;
  const unsigned long SHOW_PROCESSING_INSTRUCTION = 0x40;
  const unsigned long SHOW_TEXT = 0x4;
  unsigned short acceptNode( Node node );
};

interface Node {
  constructor();
};
