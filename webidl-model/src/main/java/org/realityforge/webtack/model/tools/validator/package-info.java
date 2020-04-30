/**
 * The package validator contains a small set of validators to validate the WebIDL schema.
 *
 * <p>It should be noted that the validators are not intended to be comprehensive validators that check
 * conformance against the spec requirements. Instead they ensure that the schema definition is "good enough"
 * for the purposes of code generation which mostly means is the schema complete or are there dangling
 * references or other problems that would cause code generation to fail.</p>
 *
 * <p>It should also be noted that the validators are NOT optimized for performance and are instead
 * optimized for development ease. The assumptions is that they run very, very infrequently and it
 * is much more important that they are easy to write and easy to understand.</p>
 */
package org.realityforge.webtack.model.tools.validator;