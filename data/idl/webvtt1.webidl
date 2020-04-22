enum ScrollSetting {
  "",
  "up"
};

enum PositionAlignSetting {
  "auto",
  "center",
  "line-left",
  "line-right"
};

enum DirectionSetting {
  "",
  "lr",
  "rl"
};

enum AlignSetting {
  "center",
  "end",
  "left",
  "right",
  "start"
};

enum LineAlignSetting {
  "center",
  "end",
  "start"
};

enum AutoKeyword {
  "auto"
};

typedef ( double or AutoKeyword ) LineAndPositionSetting;

[Exposed=Window, Constructor]
interface VTTRegion {
  attribute DOMString id;
  attribute unsigned long lines;
  attribute double regionAnchorX;
  attribute double regionAnchorY;
  attribute ScrollSetting scroll;
  attribute double viewportAnchorX;
  attribute double viewportAnchorY;
  attribute double width;
};

[Exposed=Window, Constructor( double startTime, double endTime, DOMString text )]
interface VTTCue : TextTrackCue {
  attribute AlignSetting align;
  attribute LineAndPositionSetting line;
  attribute LineAlignSetting lineAlign;
  attribute LineAndPositionSetting position;
  attribute PositionAlignSetting positionAlign;
  attribute VTTRegion? region;
  attribute double size;
  attribute boolean snapToLines;
  attribute DOMString text;
  attribute DirectionSetting vertical;
  DocumentFragment getCueAsHTML();
};
