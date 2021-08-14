/**
 * @fileoverview
 * @externs
 */
/**
 * @typedef {{left:(!number|undefined),top:(!number|undefined)}}
 */
var ScrollToOptions;
/**
 * @typedef {{instance:!Instance,module:!Module}}
 */
var WebAssemblyInstantiatedSource;
/**
 * @const
 */
var WebAssembly;
/**
 * @param {(!BufferSource|!Module)} arg0
 * @param {!Object=} arg1
 * @return {(!Promise<!WebAssemblyInstantiatedSource>|!Promise<!Instance>)}
 */
WebAssembly.instantiate = function(arg0,arg1) {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function Window() {}
/**
 * @param {(!number|!ScrollToOptions)=} arg0
 * @param {!number=} arg1
 * @return {undefined}
 */
Window.prototype.scroll = function(arg0,arg1) {}
/**
 * @constructor
 * @param {(!MediaStream|!Array<!MediaStreamTrack>)=} arg0
 */
function MediaStream(arg0) {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function Instance() {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function MediaStreamTrack() {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function Point() {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function Module() {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function Other() {}
/**
 * @param {(!number|!Point)} arg0
 * @param {!number=} arg1
 * @return {undefined}
 */
Other.prototype.castSpell = function(arg0,arg1) {}
