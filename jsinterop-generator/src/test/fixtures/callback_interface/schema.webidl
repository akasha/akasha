callback interface EventListener {
  void handleEvent( Event event );
};

/**
 * This tests that lowercase name converted to uppercase when converted into java.
 */
callback interface txCallback {
  void handleEvent( Event event );
};

[Exposed=(Window,Worker,AudioWorklet)]
interface Event {
  constructor();
};
