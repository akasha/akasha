[Exposed=Window]
interface SVGTextContentElement : SVGGraphicsElement {

  // lengthAdjust Types
  const unsigned short LENGTHADJUST_UNKNOWN = 0;
  const unsigned short LENGTHADJUST_SPACING = 1;
  const unsigned short LENGTHADJUST_SPACINGANDGLYPHS = 2;

  [SameObject] readonly attribute SVGAnimatedLength textLength;
  [SameObject] readonly attribute SVGAnimatedEnumeration lengthAdjust;

  long getNumberOfChars();
  float getComputedTextLength();
  float getSubStringLength(unsigned long charnum, unsigned long nchars);
  DOMPoint getStartPositionOfChar(unsigned long charnum);
  DOMPoint getEndPositionOfChar(unsigned long charnum);
  DOMRect getExtentOfChar(unsigned long charnum);
  float getRotationOfChar(unsigned long charnum);
  long getCharNumAtPosition(optional DOMPointInit point);
  void selectSubString(unsigned long charnum, unsigned long nchars);
};

[Exposed=Window]
interface SVGTextPositioningElement : SVGTextContentElement {
  [SameObject] readonly attribute SVGAnimatedLengthList x;
  [SameObject] readonly attribute SVGAnimatedLengthList y;
  [SameObject] readonly attribute SVGAnimatedLengthList dx;
  [SameObject] readonly attribute SVGAnimatedLengthList dy;
  [SameObject] readonly attribute SVGAnimatedNumberList rotate;
};

[Exposed=Window]
interface SVGTextElement : SVGTextPositioningElement {
};

[Exposed=Window]
interface SVGTSpanElement : SVGTextPositioningElement {
};

[Exposed=Window]
interface SVGTextPathElement : SVGTextContentElement {

  // textPath Method Types
  const unsigned short TEXTPATH_METHODTYPE_UNKNOWN = 0;
  const unsigned short TEXTPATH_METHODTYPE_ALIGN = 1;
  const unsigned short TEXTPATH_METHODTYPE_STRETCH = 2;

  // textPath Spacing Types
  const unsigned short TEXTPATH_SPACINGTYPE_UNKNOWN = 0;
  const unsigned short TEXTPATH_SPACINGTYPE_AUTO = 1;
  const unsigned short TEXTPATH_SPACINGTYPE_EXACT = 2;

  [SameObject] readonly attribute SVGAnimatedLength startOffset;
  [SameObject] readonly attribute SVGAnimatedEnumeration method;
  [SameObject] readonly attribute SVGAnimatedEnumeration spacing;
};

SVGTextPathElement includes SVGURIReference;