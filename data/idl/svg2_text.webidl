[Exposed=Window]
interface SVGTextPositioningElement : SVGTextContentElement {
  [SameObject]
  readonly attribute SVGAnimatedLengthList dx;
  [SameObject]
  readonly attribute SVGAnimatedLengthList dy;
  [SameObject]
  readonly attribute SVGAnimatedNumberList rotate;
  [SameObject]
  readonly attribute SVGAnimatedLengthList x;
  [SameObject]
  readonly attribute SVGAnimatedLengthList y;
};

[Exposed=Window]
interface SVGTextElement : SVGTextPositioningElement {
};

[Exposed=Window]
interface SVGTextContentElement : SVGGraphicsElement {
  const unsigned short LENGTHADJUST_SPACING = 1;
  const unsigned short LENGTHADJUST_SPACINGANDGLYPHS = 2;
  const unsigned short LENGTHADJUST_UNKNOWN = 0;
  [SameObject]
  readonly attribute SVGAnimatedEnumeration lengthAdjust;
  [SameObject]
  readonly attribute SVGAnimatedLength textLength;
  long getCharNumAtPosition( optional DOMPointInit point );
  float getComputedTextLength();
  DOMPoint getEndPositionOfChar( unsigned long charnum );
  DOMRect getExtentOfChar( unsigned long charnum );
  long getNumberOfChars();
  float getRotationOfChar( unsigned long charnum );
  DOMPoint getStartPositionOfChar( unsigned long charnum );
  float getSubStringLength( unsigned long charnum, unsigned long nchars );
  void selectSubString( unsigned long charnum, unsigned long nchars );
};

[Exposed=Window]
interface SVGTextPathElement : SVGTextContentElement {
  const unsigned short TEXTPATH_METHODTYPE_ALIGN = 1;
  const unsigned short TEXTPATH_METHODTYPE_STRETCH = 2;
  const unsigned short TEXTPATH_METHODTYPE_UNKNOWN = 0;
  const unsigned short TEXTPATH_SPACINGTYPE_AUTO = 1;
  const unsigned short TEXTPATH_SPACINGTYPE_EXACT = 2;
  const unsigned short TEXTPATH_SPACINGTYPE_UNKNOWN = 0;
  [SameObject]
  readonly attribute SVGAnimatedEnumeration method;
  [SameObject]
  readonly attribute SVGAnimatedEnumeration spacing;
  [SameObject]
  readonly attribute SVGAnimatedLength startOffset;
};

[Exposed=Window]
interface SVGTSpanElement : SVGTextPositioningElement {
};

SVGTextPathElement includes SVGURIReference;
