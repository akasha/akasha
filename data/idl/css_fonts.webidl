[Exposed=Window]
interface CSSFontFaceRule : CSSRule {
  readonly attribute CSSStyleDeclaration style;
};

[Exposed=Window]
interface CSSFontFeatureValuesMap {
  maplike<CSSOMString, sequence<unsigned long>>;
  undefined set( CSSOMString featureValueName, ( unsigned long or sequence<unsigned long> ) values );
};

[Exposed=Window]
interface CSSFontFeatureValuesRule : CSSRule {
  readonly attribute CSSFontFeatureValuesMap annotation;
  readonly attribute CSSFontFeatureValuesMap characterVariant;
  readonly attribute CSSFontFeatureValuesMap ornaments;
  readonly attribute CSSFontFeatureValuesMap styleset;
  readonly attribute CSSFontFeatureValuesMap stylistic;
  readonly attribute CSSFontFeatureValuesMap swash;
  attribute CSSOMString fontFamily;
};

[Exposed=Window]
interface CSSFontPaletteValuesRule : CSSRule {
  readonly attribute CSSOMString basePalette;
  readonly attribute CSSOMString fontFamily;
  readonly attribute CSSOMString name;
  readonly attribute CSSOMString overrideColors;
};

partial interface CSSRule {
  const unsigned short FONT_FEATURE_VALUES_RULE = 14;
};
