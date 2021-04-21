/**
 * @fileoverview
 * @externs
 */

/**
 * This type def is an alias because the type is used in closure/base that is added during J2CL compiles.
 * @typedef {Document}
 */
var HTMLDocument;

/**
 * This type def is an alias because the type is used in closure/base that is added during J2CL compiles.
 * @typedef {string}
 */
var TrustedScript;

/**
 * This does not yet have a typing declared in closure compiler.
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
