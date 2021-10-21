/**
 * @fileoverview
 * @externs
 */

/**
 * This type def is an alias because the type defined in the closure compiler externs does not match the underlying
 * symbol name.
 *
 * @typedef {JSONType}
 */
var JSON;

/**
 * This does not yet have a typing declared in closure compiler.
 * NOTE: This has been submitted upstream and should be removed once it is accepted.
 *
 * @const {symbol}
 */
Symbol.split;

/**
 * This does not yet have a typing declared in closure compiler.
 * NOTE: This has been submitted upstream and should be removed once it is accepted.
 *
 * @type {boolean}
 */
RegExp.prototype.unicode;

/**
 * This does not yet have a typing declared in closure compiler.
 * NOTE: This has been submitted upstream and should be removed once it is accepted.
 *
 * @type {boolean}
 */
RegExp.prototype.dotAll;

/**
 * Typedef for type used in jsinterop but associated with JSON type which has no externs generated as it is part of the
 * core types.
 *
 * @typedef {(string|number)}
 */
var StringOrLongLongUnion;
