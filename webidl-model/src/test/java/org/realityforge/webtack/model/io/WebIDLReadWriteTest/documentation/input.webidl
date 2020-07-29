/**
 * This is some basic documentation for DocumentOrShadowRoot
 * element.
 *
 * @see http://example.com/#DocumentOrShadowRoot
 */
interface mixin DocumentOrShadowRoot {
  /**
   * documentation ....
   *
   * @see http://example.com/#pointerLockElement
   */
  [LegacyLenientSetter]
  readonly attribute Element? pointerLockElement;
};

/**
 * This is from spec blah blah that decorates the mixin
 * by adding full screen.
 *
 * @see http://example.com/#DocumentOrShadowRoot
 * @version 2
 */
partial interface mixin DocumentOrShadowRoot {
  /**
   * Go fullscreen baby!
   * Experience the glory of full screen.
   * Yum!
   *
   * @see http://example.com/#fullscreenElement
   */
  [LegacyLenientSetter]
  readonly attribute Element? fullscreenElement;
};

/**
 * The Document interface.
 *
 * @version 23
 */
[Exposed=Window]
interface Document {
  /**
   * This attribute is documented.
   *
   * @version 23
   */
  readonly attribute USVString URL;
  readonly attribute DOMString characterSet;
  /**
   * This operation is documented.
   *
   * @return the new range.
   * @version 23
   */
  [NewObject]
  Range createRange();
  /**
   * This operation is documented.
   *
   * @param node this is the node we are importing
   * @param deep should it be a deep import?
   * @version 23
   */
  [CEReactions, NewObject]
  Node importNode( Node node, optional boolean deep = false );
};

/**
 * Because why not.
 *
 * @version 23
 */
Document includes DocumentOrShadowRoot;
