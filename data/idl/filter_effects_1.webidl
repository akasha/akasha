interface mixin SVGFilterPrimitiveStandardAttributes {
  readonly attribute SVGAnimatedLength height;
  readonly attribute SVGAnimatedString result;
  readonly attribute SVGAnimatedLength width;
  readonly attribute SVGAnimatedLength x;
  readonly attribute SVGAnimatedLength y;
};

interface SVGFEComponentTransferElement : SVGElement {
  readonly attribute SVGAnimatedString in1;
};

interface SVGFEDisplacementMapElement : SVGElement {
  const unsigned short SVG_CHANNEL_A = 4;
  const unsigned short SVG_CHANNEL_B = 3;
  const unsigned short SVG_CHANNEL_G = 2;
  const unsigned short SVG_CHANNEL_R = 1;
  const unsigned short SVG_CHANNEL_UNKNOWN = 0;
  readonly attribute SVGAnimatedString in1;
  readonly attribute SVGAnimatedString in2;
  readonly attribute SVGAnimatedNumber scale;
  readonly attribute SVGAnimatedEnumeration xChannelSelector;
  readonly attribute SVGAnimatedEnumeration yChannelSelector;
};

interface SVGFEFloodElement : SVGElement {
};

interface SVGFESpecularLightingElement : SVGElement {
  readonly attribute SVGAnimatedString in1;
  readonly attribute SVGAnimatedNumber kernelUnitLengthX;
  readonly attribute SVGAnimatedNumber kernelUnitLengthY;
  readonly attribute SVGAnimatedNumber specularConstant;
  readonly attribute SVGAnimatedNumber specularExponent;
  readonly attribute SVGAnimatedNumber surfaceScale;
};

interface SVGFEFuncGElement : SVGComponentTransferFunctionElement {
};

interface SVGFEFuncRElement : SVGComponentTransferFunctionElement {
};

interface SVGFEDiffuseLightingElement : SVGElement {
  readonly attribute SVGAnimatedNumber diffuseConstant;
  readonly attribute SVGAnimatedString in1;
  readonly attribute SVGAnimatedNumber kernelUnitLengthX;
  readonly attribute SVGAnimatedNumber kernelUnitLengthY;
  readonly attribute SVGAnimatedNumber surfaceScale;
};

interface SVGFEBlendElement : SVGElement {
  const unsigned short SVG_FEBLEND_MODE_COLOR = 15;
  const unsigned short SVG_FEBLEND_MODE_COLOR_BURN = 8;
  const unsigned short SVG_FEBLEND_MODE_COLOR_DODGE = 7;
  const unsigned short SVG_FEBLEND_MODE_DARKEN = 4;
  const unsigned short SVG_FEBLEND_MODE_DIFFERENCE = 11;
  const unsigned short SVG_FEBLEND_MODE_EXCLUSION = 12;
  const unsigned short SVG_FEBLEND_MODE_HARD_LIGHT = 9;
  const unsigned short SVG_FEBLEND_MODE_HUE = 13;
  const unsigned short SVG_FEBLEND_MODE_LIGHTEN = 5;
  const unsigned short SVG_FEBLEND_MODE_LUMINOSITY = 16;
  const unsigned short SVG_FEBLEND_MODE_MULTIPLY = 2;
  const unsigned short SVG_FEBLEND_MODE_NORMAL = 1;
  const unsigned short SVG_FEBLEND_MODE_OVERLAY = 6;
  const unsigned short SVG_FEBLEND_MODE_SATURATION = 14;
  const unsigned short SVG_FEBLEND_MODE_SCREEN = 3;
  const unsigned short SVG_FEBLEND_MODE_SOFT_LIGHT = 10;
  const unsigned short SVG_FEBLEND_MODE_UNKNOWN = 0;
  readonly attribute SVGAnimatedString in1;
  readonly attribute SVGAnimatedString in2;
  readonly attribute SVGAnimatedEnumeration mode;
};

interface SVGFEColorMatrixElement : SVGElement {
  const unsigned short SVG_FECOLORMATRIX_TYPE_HUEROTATE = 3;
  const unsigned short SVG_FECOLORMATRIX_TYPE_LUMINANCETOALPHA = 4;
  const unsigned short SVG_FECOLORMATRIX_TYPE_MATRIX = 1;
  const unsigned short SVG_FECOLORMATRIX_TYPE_SATURATE = 2;
  const unsigned short SVG_FECOLORMATRIX_TYPE_UNKNOWN = 0;
  readonly attribute SVGAnimatedString in1;
  readonly attribute SVGAnimatedEnumeration type;
  readonly attribute SVGAnimatedNumberList values;
};

interface SVGFECompositeElement : SVGElement {
  const unsigned short SVG_FECOMPOSITE_OPERATOR_ARITHMETIC = 6;
  const unsigned short SVG_FECOMPOSITE_OPERATOR_ATOP = 4;
  const unsigned short SVG_FECOMPOSITE_OPERATOR_IN = 2;
  const unsigned short SVG_FECOMPOSITE_OPERATOR_OUT = 3;
  const unsigned short SVG_FECOMPOSITE_OPERATOR_OVER = 1;
  const unsigned short SVG_FECOMPOSITE_OPERATOR_UNKNOWN = 0;
  const unsigned short SVG_FECOMPOSITE_OPERATOR_XOR = 5;
  readonly attribute SVGAnimatedString in1;
  readonly attribute SVGAnimatedString in2;
  readonly attribute SVGAnimatedNumber k1;
  readonly attribute SVGAnimatedNumber k2;
  readonly attribute SVGAnimatedNumber k3;
  readonly attribute SVGAnimatedNumber k4;
  readonly attribute SVGAnimatedEnumeration operator;
};

interface SVGComponentTransferFunctionElement : SVGElement {
  const unsigned short SVG_FECOMPONENTTRANSFER_TYPE_DISCRETE = 3;
  const unsigned short SVG_FECOMPONENTTRANSFER_TYPE_GAMMA = 5;
  const unsigned short SVG_FECOMPONENTTRANSFER_TYPE_IDENTITY = 1;
  const unsigned short SVG_FECOMPONENTTRANSFER_TYPE_LINEAR = 4;
  const unsigned short SVG_FECOMPONENTTRANSFER_TYPE_TABLE = 2;
  const unsigned short SVG_FECOMPONENTTRANSFER_TYPE_UNKNOWN = 0;
  readonly attribute SVGAnimatedNumber amplitude;
  readonly attribute SVGAnimatedNumber exponent;
  readonly attribute SVGAnimatedNumber intercept;
  readonly attribute SVGAnimatedNumber offset;
  readonly attribute SVGAnimatedNumber slope;
  readonly attribute SVGAnimatedNumberList tableValues;
  readonly attribute SVGAnimatedEnumeration type;
};

interface SVGFEGaussianBlurElement : SVGElement {
  const unsigned short SVG_EDGEMODE_DUPLICATE = 1;
  const unsigned short SVG_EDGEMODE_NONE = 3;
  const unsigned short SVG_EDGEMODE_UNKNOWN = 0;
  const unsigned short SVG_EDGEMODE_WRAP = 2;
  readonly attribute SVGAnimatedEnumeration edgeMode;
  readonly attribute SVGAnimatedString in1;
  readonly attribute SVGAnimatedNumber stdDeviationX;
  readonly attribute SVGAnimatedNumber stdDeviationY;
  void setStdDeviation( float stdDeviationX, float stdDeviationY );
};

interface SVGFilterElement : SVGElement {
  readonly attribute SVGAnimatedEnumeration filterUnits;
  readonly attribute SVGAnimatedLength height;
  readonly attribute SVGAnimatedEnumeration primitiveUnits;
  readonly attribute SVGAnimatedLength width;
  readonly attribute SVGAnimatedLength x;
  readonly attribute SVGAnimatedLength y;
};

interface SVGFETileElement : SVGElement {
  readonly attribute SVGAnimatedString in1;
};

interface SVGFEConvolveMatrixElement : SVGElement {
  const unsigned short SVG_EDGEMODE_DUPLICATE = 1;
  const unsigned short SVG_EDGEMODE_NONE = 3;
  const unsigned short SVG_EDGEMODE_UNKNOWN = 0;
  const unsigned short SVG_EDGEMODE_WRAP = 2;
  readonly attribute SVGAnimatedNumber bias;
  readonly attribute SVGAnimatedNumber divisor;
  readonly attribute SVGAnimatedEnumeration edgeMode;
  readonly attribute SVGAnimatedString in1;
  readonly attribute SVGAnimatedNumberList kernelMatrix;
  readonly attribute SVGAnimatedNumber kernelUnitLengthX;
  readonly attribute SVGAnimatedNumber kernelUnitLengthY;
  readonly attribute SVGAnimatedInteger orderX;
  readonly attribute SVGAnimatedInteger orderY;
  readonly attribute SVGAnimatedBoolean preserveAlpha;
  readonly attribute SVGAnimatedInteger targetX;
  readonly attribute SVGAnimatedInteger targetY;
};

interface SVGFEFuncAElement : SVGComponentTransferFunctionElement {
};

interface SVGFEOffsetElement : SVGElement {
  readonly attribute SVGAnimatedNumber dx;
  readonly attribute SVGAnimatedNumber dy;
  readonly attribute SVGAnimatedString in1;
};

interface SVGFEFuncBElement : SVGComponentTransferFunctionElement {
};

interface SVGFEDistantLightElement : SVGElement {
  readonly attribute SVGAnimatedNumber azimuth;
  readonly attribute SVGAnimatedNumber elevation;
};

interface SVGFEDropShadowElement : SVGElement {
  readonly attribute SVGAnimatedNumber dx;
  readonly attribute SVGAnimatedNumber dy;
  readonly attribute SVGAnimatedString in1;
  readonly attribute SVGAnimatedNumber stdDeviationX;
  readonly attribute SVGAnimatedNumber stdDeviationY;
  void setStdDeviation( float stdDeviationX, float stdDeviationY );
};

interface SVGFESpotLightElement : SVGElement {
  readonly attribute SVGAnimatedNumber limitingConeAngle;
  readonly attribute SVGAnimatedNumber pointsAtX;
  readonly attribute SVGAnimatedNumber pointsAtY;
  readonly attribute SVGAnimatedNumber pointsAtZ;
  readonly attribute SVGAnimatedNumber specularExponent;
  readonly attribute SVGAnimatedNumber x;
  readonly attribute SVGAnimatedNumber y;
  readonly attribute SVGAnimatedNumber z;
};

interface SVGFETurbulenceElement : SVGElement {
  const unsigned short SVG_STITCHTYPE_NOSTITCH = 2;
  const unsigned short SVG_STITCHTYPE_STITCH = 1;
  const unsigned short SVG_STITCHTYPE_UNKNOWN = 0;
  const unsigned short SVG_TURBULENCE_TYPE_FRACTALNOISE = 1;
  const unsigned short SVG_TURBULENCE_TYPE_TURBULENCE = 2;
  const unsigned short SVG_TURBULENCE_TYPE_UNKNOWN = 0;
  readonly attribute SVGAnimatedNumber baseFrequencyX;
  readonly attribute SVGAnimatedNumber baseFrequencyY;
  readonly attribute SVGAnimatedInteger numOctaves;
  readonly attribute SVGAnimatedNumber seed;
  readonly attribute SVGAnimatedEnumeration stitchTiles;
  readonly attribute SVGAnimatedEnumeration type;
};

interface SVGFEMorphologyElement : SVGElement {
  const unsigned short SVG_MORPHOLOGY_OPERATOR_DILATE = 2;
  const unsigned short SVG_MORPHOLOGY_OPERATOR_ERODE = 1;
  const unsigned short SVG_MORPHOLOGY_OPERATOR_UNKNOWN = 0;
  readonly attribute SVGAnimatedString in1;
  readonly attribute SVGAnimatedEnumeration operator;
  readonly attribute SVGAnimatedNumber radiusX;
  readonly attribute SVGAnimatedNumber radiusY;
};

interface SVGFEMergeElement : SVGElement {
};

interface SVGFEPointLightElement : SVGElement {
  readonly attribute SVGAnimatedNumber x;
  readonly attribute SVGAnimatedNumber y;
  readonly attribute SVGAnimatedNumber z;
};

interface SVGFEMergeNodeElement : SVGElement {
  readonly attribute SVGAnimatedString in1;
};

interface SVGFEImageElement : SVGElement {
  readonly attribute SVGAnimatedString crossOrigin;
  readonly attribute SVGAnimatedPreserveAspectRatio preserveAspectRatio;
};

SVGFESpecularLightingElement includes SVGFilterPrimitiveStandardAttributes;

SVGFEImageElement includes SVGURIReference;

SVGFEFloodElement includes SVGFilterPrimitiveStandardAttributes;

SVGFEOffsetElement includes SVGFilterPrimitiveStandardAttributes;

SVGFilterElement includes SVGURIReference;

SVGFEDiffuseLightingElement includes SVGFilterPrimitiveStandardAttributes;

SVGFEDisplacementMapElement includes SVGFilterPrimitiveStandardAttributes;

SVGFEDropShadowElement includes SVGFilterPrimitiveStandardAttributes;

SVGFEImageElement includes SVGFilterPrimitiveStandardAttributes;

SVGFEComponentTransferElement includes SVGFilterPrimitiveStandardAttributes;

SVGFEMorphologyElement includes SVGFilterPrimitiveStandardAttributes;

SVGFETileElement includes SVGFilterPrimitiveStandardAttributes;

SVGFETurbulenceElement includes SVGFilterPrimitiveStandardAttributes;

SVGFECompositeElement includes SVGFilterPrimitiveStandardAttributes;

SVGFEBlendElement includes SVGFilterPrimitiveStandardAttributes;

SVGFEConvolveMatrixElement includes SVGFilterPrimitiveStandardAttributes;

SVGFEGaussianBlurElement includes SVGFilterPrimitiveStandardAttributes;

SVGFEMergeElement includes SVGFilterPrimitiveStandardAttributes;

SVGFEColorMatrixElement includes SVGFilterPrimitiveStandardAttributes;
