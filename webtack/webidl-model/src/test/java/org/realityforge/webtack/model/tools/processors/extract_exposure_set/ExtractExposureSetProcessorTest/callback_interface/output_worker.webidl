[Exposed=(Window,Worker,Worklet)]
callback interface EventListenerA {
  undefined handleEvent( Event event );
};

callback interface EventListenerC {
  undefined handleEvent( Event event );
};

[Exposed=*]
callback interface EventListenerD {
  undefined handleEvent( Event event );
};
