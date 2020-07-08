callback interface EventListener {
  void handleEvent( Event event );
};

[Exposed=(Window,Worker,AudioWorklet)]
interface Event {
  constructor();
};
