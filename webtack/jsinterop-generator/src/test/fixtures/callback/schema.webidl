/**
 * This tests that lowercase name converted to uppercase when converted into java.
 */
callback txEventHandler = undefined ( Event event, optional DOMString source, optional CallbackOptions metadata = {} );

dictionary CallbackOptions {
  DOMString label;
};

interface Event {
};
