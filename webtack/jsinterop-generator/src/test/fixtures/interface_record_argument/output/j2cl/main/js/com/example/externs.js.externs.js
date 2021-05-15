/**
 * @fileoverview
 * @externs
 */
/**
 * @typedef {!Object<!string,!string>}
 */
var AuthenticationExtensionsAuthenticatorInputs;
/**
 * @typedef {{presentationStyle:(!string|undefined)}}
 */
var ClipboardItemOptions;
/**
 * @typedef {{value:(!AuthenticationExtensionsAuthenticatorInputs|undefined)}}
 */
var OtherDict;
/**
 * @typedef {{otherData1:(!Object<!string,!boolean>|undefined),otherData10:(!Object<!string,!number>|undefined),otherData11:(!Object<!string,!number>|undefined),otherData2:(!Object<!string,!number>|undefined),otherData3:(!Object<!string,!number>|undefined),otherData4:(!Object<!string,!number>|undefined),otherData5:(!Object<!string,!number>|undefined),otherData6:(!Object<!string,!number>|undefined),otherData7:(!Object<!string,!number>|undefined),otherData8:(!Object<!string,!number>|undefined),otherData9:(!Object<!string,!number>|undefined),parameterData:(!Object<!string,!number>|undefined)}}
 */
var AudioWorkletNodeOptions;
/**
 * @constructor
 * @param {!Object<!string,!ClipboardItemData>} items
 * @param {!ClipboardItemOptions=} options
 */
function ClipboardItem(items,options) {}
/**
 * @constructor
 * @param {!Object<!string,!string>=} headers
 */
function Headers(headers) {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function ClipboardItemData() {}
/** @type {!string} */ ClipboardItemData.prototype.data;
