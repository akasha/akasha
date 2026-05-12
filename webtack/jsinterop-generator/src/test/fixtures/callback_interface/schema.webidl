callback interface EventListener {
  undefined handleEvent( Event event );
};

/**
 * This tests that lowercase name converted to uppercase when converted into java.
 */
callback interface txCallback {
  undefined handleEvent( Event event, optional DOMString source, optional CallbackOptions metadata = {} );
};

dictionary CallbackOptions {
  DOMString label;
};

interface Event {
  constructor();
};
