/**
 * @fileoverview
 * @externs
 */
/**
 * @interface
 */
function NodeFilter() {}
/** @const {!number} */ NodeFilter.FILTER_ACCEPT;
/** @const {!number} */ NodeFilter.FILTER_REJECT;
/** @const {!number} */ NodeFilter.FILTER_SKIP;
/** @const {!number} */ NodeFilter.SHOW_ALL;
/** @const {!number} */ NodeFilter.SHOW_ATTRIBUTE;
/** @const {!number} */ NodeFilter.SHOW_CDATA_SECTION;
/** @const {!number} */ NodeFilter.SHOW_COMMENT;
/** @const {!number} */ NodeFilter.SHOW_DOCUMENT;
/** @const {!number} */ NodeFilter.SHOW_DOCUMENT_FRAGMENT;
/** @const {!number} */ NodeFilter.SHOW_DOCUMENT_TYPE;
/** @const {!number} */ NodeFilter.SHOW_ELEMENT;
/** @const {!number} */ NodeFilter.SHOW_ENTITY;
/** @const {!number} */ NodeFilter.SHOW_ENTITY_REFERENCE;
/** @const {!number} */ NodeFilter.SHOW_NOTATION;
/** @const {!number} */ NodeFilter.SHOW_PROCESSING_INSTRUCTION;
/** @const {!number} */ NodeFilter.SHOW_TEXT;
/**
 * @param {!Node} node
 * @return {!number}
 */
NodeFilter.prototype.acceptNode = function(node) {}
/**
 * @constructor
 */
function Node() {}
