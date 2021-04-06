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
 * @constructor
 * @private
 */
function WebAssemblyInterface() {}
/**
 * @param {(!BufferSource|!Module)} arg0
 * @param {!Object=} arg1
 * @return {(!Promise<!WebAssemblyInstantiatedSource>|!Promise<!Instance>)}
 */
WebAssemblyInterface.prototype.instantiate = function(arg0,arg1) {}
/**
 * @const
 * @type {WebAssemblyInterface}
 */
var WebAssembly;
/**
 * @constructor
 * @private
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
 */
function Instance() {}
/**
 * @constructor
 * @private
 */
function BufferSource() {}
/**
 * @constructor
 * @private
 */
function MediaStreamTrack() {}
/**
 * @constructor
 * @private
 */
function Point() {}
/**
 * @constructor
 * @private
 */
function Module() {}
/**
 * @constructor
 * @private
 */
function Other() {}
/**
 * @param {(!number|!Point)} arg0
 * @param {!number=} arg1
 * @return {undefined}
 */
Other.prototype.castSpell = function(arg0,arg1) {}
