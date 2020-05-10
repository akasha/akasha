[Exposed=(Window,Worker,Worklet)]
callback interface EventListenerA {
  void handleEvent( Event event );
};

[Exposed=Window]
callback interface EventListenerB {
  void handleEvent( Event event );
};

callback interface EventListenerC {
  void handleEvent( Event event );
};
