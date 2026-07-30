/**
 * @fileoverview
 * @suppress {useOfGoogProvide}
 */

/**
 * @param {string} name
 * @return {undefined}
 */
goog.provide = function(name) {};

/**
 * @param {string} name
 * @return {?}
 */
goog.require = function(name) {};

/**
 * @param {string} name
 * @param {T} defaultValue
 * @return {T}
 * @template T
 */
goog.define = function(name, defaultValue) {};

goog.provide('jre');

/**
 * @param {string} name
 * @param {string} value
 */
jre.addSystemPropertyFromGoogDefine = function(name, value) {};
