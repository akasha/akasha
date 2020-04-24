enum AlignSetting {
  "center",
  "end",
  "left",
  "right",
  "start"
};

enum AutoKeyword {
  "auto"
};

enum DirectionSetting {
  "",
  "lr",
  "rl"
};

enum LineAlignSetting {
  "center",
  "end",
  "start"
};

enum PositionAlignSetting {
  "auto",
  "center",
  "line-left",
  "line-right"
};

enum ScrollSetting {
  "",
  "up"
};

typedef ( double or AutoKeyword ) LineAndPositionSetting;

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
