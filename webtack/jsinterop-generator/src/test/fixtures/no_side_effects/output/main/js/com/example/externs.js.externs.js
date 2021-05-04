/**
 * @fileoverview
 * @externs
 */
/**
 * @const
 */
var FakeMath;
/** @const {!number} */ FakeMath.SQRT2;
/**
 * @param {!number} x
 * @return {!number}
 */
FakeMath.abs = function(x) {}
/**
 * @param {!number} x
 * @return {!number}
 * @nosideeffects
 */
FakeMath.acos = function(x) {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function WEBGL_debug_shaders() {}
/**
 * @param {!number} shaderId
 * @return {!string}
 * @nosideeffects
 */
WEBGL_debug_shaders.prototype.getTranslatedShaderSource = function(shaderId) {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function CSSFontPaletteValuesRule() {}
/** @type {!string} */ CSSFontPaletteValuesRule.prototype.basePalette;
/** @type {!string} */ CSSFontPaletteValuesRule.prototype.fontFamily;
/** @const {number} */ CSSFontPaletteValuesRule.prototype.size;
/**
 * @param {!number} key
 * @return {!boolean}
 * @nosideeffects
 */
CSSFontPaletteValuesRule.prototype.has = function(key) {}
/**
 * @param {!number} key
 * @return {?string}
 * @nosideeffects
 */
CSSFontPaletteValuesRule.prototype.get = function(key) {}
/**
 * @return {!Iterator<!number>}
 * @nosideeffects
 */
CSSFontPaletteValuesRule.prototype.keys = function() {}
/**
 * @return {!Iterator<!string>}
 * @nosideeffects
 */
CSSFontPaletteValuesRule.prototype.values = function() {}
/**
 * @return {!Iterator<!Array<!number|!string>>}
 * @nosideeffects
 */
CSSFontPaletteValuesRule.prototype.entries = function() {};
/**
 * @return {!Iterator<!Array<!number|!string>>}
 * @nosideeffects
 */
CSSFontPaletteValuesRule.prototype[Symbol.iterator] = function() {};
/**
 * @param {function(!string, !number, MAP)} callback
 * @this {MAP}
 * @template MAP
 */
CSSFontPaletteValuesRule.prototype.forEach = function(callback) {};
/**
 * @param {!number} key
 * @param {!string} value
 * @return {undefined}
 */
CSSFontPaletteValuesRule.prototype.set = function(key,value) {}
/**
 * @param {!number} key
 * @return {!boolean}
 */
CSSFontPaletteValuesRule.prototype.delete = function(key) {}
/**
 * @return {undefined}
 */
CSSFontPaletteValuesRule.prototype.clear = function() {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function FakeRegExpGroups() {}
/** @const {number} */ FakeRegExpGroups.prototype.size;
/**
 * @param {!string} key
 * @return {!boolean}
 * @nosideeffects
 */
FakeRegExpGroups.prototype.has = function(key) {}
/**
 * @param {!string} key
 * @return {?string}
 * @nosideeffects
 */
FakeRegExpGroups.prototype.get = function(key) {}
/**
 * @return {!Iterator<!string>}
 * @nosideeffects
 */
FakeRegExpGroups.prototype.keys = function() {}
/**
 * @return {!Iterator<!string>}
 * @nosideeffects
 */
FakeRegExpGroups.prototype.values = function() {}
/**
 * @return {!Iterator<!Array<!string|!string>>}
 * @nosideeffects
 */
FakeRegExpGroups.prototype.entries = function() {};
/**
 * @return {!Iterator<!Array<!string|!string>>}
 * @nosideeffects
 */
FakeRegExpGroups.prototype[Symbol.iterator] = function() {};
/**
 * @param {function(!string, !string, MAP)} callback
 * @this {MAP}
 * @template MAP
 */
FakeRegExpGroups.prototype.forEach = function(callback) {};
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function Performance() {}
/**
 * @return {!number}
 * @nosideeffects
 */
Performance.prototype.now = function() {}
/**
 * @constructor
 * @nosideeffects
 */
function OffscreenCanvas() {}
/**
 * @return {undefined}
 */
OffscreenCanvas.prototype.drawStuff = function() {}
/**
 * @return {!boolean}
 * @nosideeffects
 */
OffscreenCanvas.prototype.isValid = function() {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function FakeRegExpResult() {}
/** @type {!number} */ FakeRegExpResult.prototype.index;
/** @type {!string} */ FakeRegExpResult.prototype.input;
/** @type {!number} */ FakeRegExpResult.prototype.length;
/**
 * @param {!number} index
 * @return {?string}
 */
FakeRegExpResult.prototype.get = function(index) {}
