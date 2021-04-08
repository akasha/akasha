/**
 * @fileoverview
 * @externs
 */
/**
 * @constructor
 * @private
 */
function AudioScheduledSourceNode() {}
/**
 * @param {!number=} when
 * @return {undefined}
 */
AudioScheduledSourceNode.prototype.stop = function(when) {}
/**
 * @param {!number=} when
 * @return {undefined}
 */
AudioScheduledSourceNode.prototype.start = function(when) {}
/**
 * @constructor
 * @extends {AudioScheduledSourceNode}
 * @private
 */
function AudioBufferSourceNode() {}
/**
 * @param {!number=} when
 * @param {!number=} offset
 * @param {!number=} duration
 * @return {undefined}
 * @override
 */
AudioBufferSourceNode.prototype.start = function(when,offset,duration) {}
/**
 * @constructor
 * @private
 */
function DOMMatrixReadOnly() {}
/**
 * @param {!Object=} other
 * @return {!DOMMatrixReadOnly}
 */
DOMMatrixReadOnly.fromMatrix = function(other) {}
/**
 * @constructor
 * @extends {DOMMatrixReadOnly}
 * @private
 */
function DOMMatrix() {}
/**
 * @param {!Object=} other
 * @return {!DOMMatrix}
 */
DOMMatrix.fromMatrix = function(other) {}
