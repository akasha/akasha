/**
 * @fileoverview
 * @externs
 */

/**
 * This type def is an alias because the type is used in closure/base that is added during J2CL compiles.
 *
 * @typedef {Document}
 */
var HTMLDocument;

/**
 * This type def is an alias because the type defined in the closure compiler externs does not match the underlying symbol name.
 *
 * @typedef {JSONType}
 */
var JSON;

/**
 * This type def is an alias because the type is used in closure/base that is added during J2CL compiles.
 * @typedef {string}
 */
var TrustedScript;

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
 * @see https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise
 * @param {!Iterable<VALUE>} iterable
 * @return {!Promise<RESULT>}
 * @template VALUE
 * @template RESULT := mapunion(VALUE, (V) =>
 *     cond(isUnknown(V),
 *         unknown(),
 *         cond(isTemplatized(V) && sub(rawTypeOf(V), 'IThenable'),
 *             templateTypeOf(V, 0),
 *             cond(sub(V, 'Thenable'), unknown(), V))))
 * =:
 */
Promise.any = function(iterable) {};

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
