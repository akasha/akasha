dictionary DOMMatrix2DInit {
  unrestricted double a;
  unrestricted double b;
  unrestricted double c;
  unrestricted double d;
  unrestricted double e;
  unrestricted double f;
  unrestricted double m11;
  unrestricted double m12;
  unrestricted double m21;
  unrestricted double m22;
  unrestricted double m41;
  unrestricted double m42;
};

dictionary DOMMatrixInit : DOMMatrix2DInit {
  boolean is2D;
  unrestricted double m13 = 0;
  unrestricted double m14 = 0;
  unrestricted double m23 = 0;
  unrestricted double m24 = 0;
  unrestricted double m31 = 0;
  unrestricted double m32 = 0;
  unrestricted double m33 = 1;
  unrestricted double m34 = 0;
  unrestricted double m43 = 0;
  unrestricted double m44 = 1;
};

dictionary DOMPointInit {
  unrestricted double w = 1;
  unrestricted double x = 0;
  unrestricted double y = 0;
  unrestricted double z = 0;
};

dictionary DOMQuadInit {
  DOMPointInit p1;
  DOMPointInit p2;
  DOMPointInit p3;
  DOMPointInit p4;
};

dictionary DOMRectInit {
  unrestricted double height = 0;
  unrestricted double width = 0;
  unrestricted double x = 0;
  unrestricted double y = 0;
};

[Constructor( optional ( DOMString or sequence<unrestricted double> ) init ), Exposed=(Window,Worker), Serializable, LegacyWindowAlias=(SVGMatrix,WebKitCSSMatrix)]
interface DOMMatrix : DOMMatrixReadOnly {
  inherit attribute unrestricted double a;
  inherit attribute unrestricted double b;
  inherit attribute unrestricted double c;
  inherit attribute unrestricted double d;
  inherit attribute unrestricted double e;
  inherit attribute unrestricted double f;
  inherit attribute unrestricted double m11;
  inherit attribute unrestricted double m12;
  inherit attribute unrestricted double m13;
  inherit attribute unrestricted double m14;
  inherit attribute unrestricted double m21;
  inherit attribute unrestricted double m22;
  inherit attribute unrestricted double m23;
  inherit attribute unrestricted double m24;
  inherit attribute unrestricted double m31;
  inherit attribute unrestricted double m32;
  inherit attribute unrestricted double m33;
  inherit attribute unrestricted double m34;
  inherit attribute unrestricted double m41;
  inherit attribute unrestricted double m42;
  inherit attribute unrestricted double m43;
  inherit attribute unrestricted double m44;
  [NewObject]
  static DOMMatrix fromFloat32Array( Float32Array array32 );
  [NewObject]
  static DOMMatrix fromFloat64Array( Float64Array array64 );
  [NewObject]
  static DOMMatrix fromMatrix( optional DOMMatrixInit other );
  DOMMatrix invertSelf();
  DOMMatrix multiplySelf( optional DOMMatrixInit other );
  DOMMatrix preMultiplySelf( optional DOMMatrixInit other );
  DOMMatrix rotateAxisAngleSelf( optional unrestricted double x = 0, optional unrestricted double y = 0, optional unrestricted double z = 0, optional unrestricted double angle = 0 );
  DOMMatrix rotateFromVectorSelf( optional unrestricted double x = 0, optional unrestricted double y = 0 );
  DOMMatrix rotateSelf( optional unrestricted double rotX = 0, optional unrestricted double rotY, optional unrestricted double rotZ );
  DOMMatrix scale3dSelf( optional unrestricted double scale = 1, optional unrestricted double originX = 0, optional unrestricted double originY = 0, optional unrestricted double originZ = 0 );
  DOMMatrix scaleSelf( optional unrestricted double scaleX = 1, optional unrestricted double scaleY, optional unrestricted double scaleZ = 1, optional unrestricted double originX = 0, optional unrestricted double originY = 0, optional unrestricted double originZ = 0 );
  [Exposed=Window]
  DOMMatrix setMatrixValue( DOMString transformList );
  DOMMatrix skewXSelf( optional unrestricted double sx = 0 );
  DOMMatrix skewYSelf( optional unrestricted double sy = 0 );
  DOMMatrix translateSelf( optional unrestricted double tx = 0, optional unrestricted double ty = 0, optional unrestricted double tz = 0 );
};

[Constructor( optional ( DOMString or sequence<unrestricted double> ) init ), Exposed=(Window,Worker), Serializable]
interface DOMMatrixReadOnly {
  readonly attribute unrestricted double a;
  readonly attribute unrestricted double b;
  readonly attribute unrestricted double c;
  readonly attribute unrestricted double d;
  readonly attribute unrestricted double e;
  readonly attribute unrestricted double f;
  readonly attribute boolean is2D;
  readonly attribute boolean isIdentity;
  readonly attribute unrestricted double m11;
  readonly attribute unrestricted double m12;
  readonly attribute unrestricted double m13;
  readonly attribute unrestricted double m14;
  readonly attribute unrestricted double m21;
  readonly attribute unrestricted double m22;
  readonly attribute unrestricted double m23;
  readonly attribute unrestricted double m24;
  readonly attribute unrestricted double m31;
  readonly attribute unrestricted double m32;
  readonly attribute unrestricted double m33;
  readonly attribute unrestricted double m34;
  readonly attribute unrestricted double m41;
  readonly attribute unrestricted double m42;
  readonly attribute unrestricted double m43;
  readonly attribute unrestricted double m44;
  [NewObject]
  static DOMMatrixReadOnly fromFloat32Array( Float32Array array32 );
  [NewObject]
  static DOMMatrixReadOnly fromFloat64Array( Float64Array array64 );
  [NewObject]
  static DOMMatrixReadOnly fromMatrix( optional DOMMatrixInit other );
  [NewObject]
  DOMMatrix flipX();
  [NewObject]
  DOMMatrix flipY();
  [NewObject]
  DOMMatrix inverse();
  [NewObject]
  DOMMatrix multiply( optional DOMMatrixInit other );
  [NewObject]
  DOMMatrix rotate( optional unrestricted double rotX = 0, optional unrestricted double rotY, optional unrestricted double rotZ );
  [NewObject]
  DOMMatrix rotateAxisAngle( optional unrestricted double x = 0, optional unrestricted double y = 0, optional unrestricted double z = 0, optional unrestricted double angle = 0 );
  [NewObject]
  DOMMatrix rotateFromVector( optional unrestricted double x = 0, optional unrestricted double y = 0 );
  [NewObject]
  DOMMatrix scale( optional unrestricted double scaleX = 1, optional unrestricted double scaleY, optional unrestricted double scaleZ = 1, optional unrestricted double originX = 0, optional unrestricted double originY = 0, optional unrestricted double originZ = 0 );
  [NewObject]
  DOMMatrix scale3d( optional unrestricted double scale = 1, optional unrestricted double originX = 0, optional unrestricted double originY = 0, optional unrestricted double originZ = 0 );
  [NewObject]
  DOMMatrix scaleNonUniform( optional unrestricted double scaleX = 1, optional unrestricted double scaleY = 1 );
  [NewObject]
  DOMMatrix skewX( optional unrestricted double sx = 0 );
  [NewObject]
  DOMMatrix skewY( optional unrestricted double sy = 0 );
  [NewObject]
  Float32Array toFloat32Array();
  [NewObject]
  Float64Array toFloat64Array();
  [Default]
  object toJSON();
  [NewObject]
  DOMPoint transformPoint( optional DOMPointInit point );
  [NewObject]
  DOMMatrix translate( optional unrestricted double tx = 0, optional unrestricted double ty = 0, optional unrestricted double tz = 0 );
  [Exposed=Window]
  stringifier;
};

[Constructor( optional unrestricted double x = 0, optional unrestricted double y = 0, optional unrestricted double z = 0, optional unrestricted double w = 1 ), Exposed=(Window,Worker), Serializable, LegacyWindowAlias=SVGPoint]
interface DOMPoint : DOMPointReadOnly {
  inherit attribute unrestricted double w;
  inherit attribute unrestricted double x;
  inherit attribute unrestricted double y;
  inherit attribute unrestricted double z;
  [NewObject]
  static DOMPoint fromPoint( optional DOMPointInit other );
};

[Constructor( optional unrestricted double x = 0, optional unrestricted double y = 0, optional unrestricted double z = 0, optional unrestricted double w = 1 ), Exposed=(Window,Worker), Serializable]
interface DOMPointReadOnly {
  readonly attribute unrestricted double w;
  readonly attribute unrestricted double x;
  readonly attribute unrestricted double y;
  readonly attribute unrestricted double z;
  [NewObject]
  static DOMPointReadOnly fromPoint( optional DOMPointInit other );
  DOMPoint matrixTransform( optional DOMMatrixInit matrix );
  [Default]
  object toJSON();
};

[Constructor( optional DOMPointInit p1, optional DOMPointInit p2, optional DOMPointInit p3, optional DOMPointInit p4 ), Exposed=(Window,Worker), Serializable]
interface DOMQuad {
  [SameObject]
  readonly attribute DOMPoint p1;
  [SameObject]
  readonly attribute DOMPoint p2;
  [SameObject]
  readonly attribute DOMPoint p3;
  [SameObject]
  readonly attribute DOMPoint p4;
  [NewObject]
  static DOMQuad fromQuad( optional DOMQuadInit other );
  [NewObject]
  static DOMQuad fromRect( optional DOMRectInit other );
  [NewObject]
  DOMRect getBounds();
  [Default]
  object toJSON();
};

[Constructor( optional unrestricted double x = 0, optional unrestricted double y = 0, optional unrestricted double width = 0, optional unrestricted double height = 0 ), Exposed=(Window,Worker), Serializable, LegacyWindowAlias=SVGRect]
interface DOMRect : DOMRectReadOnly {
  inherit attribute unrestricted double height;
  inherit attribute unrestricted double width;
  inherit attribute unrestricted double x;
  inherit attribute unrestricted double y;
  [NewObject]
  static DOMRect fromRect( optional DOMRectInit other );
};

interface DOMRectList {
  readonly attribute unsigned long length;
  getter DOMRect? item( unsigned long index );
};

[Constructor( optional unrestricted double x = 0, optional unrestricted double y = 0, optional unrestricted double width = 0, optional unrestricted double height = 0 ), Exposed=(Window,Worker), Serializable]
interface DOMRectReadOnly {
  readonly attribute unrestricted double bottom;
  readonly attribute unrestricted double height;
  readonly attribute unrestricted double left;
  readonly attribute unrestricted double right;
  readonly attribute unrestricted double top;
  readonly attribute unrestricted double width;
  readonly attribute unrestricted double x;
  readonly attribute unrestricted double y;
  [NewObject]
  static DOMRectReadOnly fromRect( optional DOMRectInit other );
  [Default]
  object toJSON();
};
