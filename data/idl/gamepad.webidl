enum GamepadMappingType {
  "",
  "standard"
};

dictionary GamepadEventInit : EventInit {
  required Gamepad gamepad;
};

[Exposed=Window, SecureContext]
interface Gamepad {
  readonly attribute FrozenArray<double> axes;
  readonly attribute FrozenArray<GamepadButton> buttons;
  readonly attribute boolean connected;
  readonly attribute DOMString id;
  readonly attribute long index;
  readonly attribute GamepadMappingType mapping;
  readonly attribute DOMHighResTimeStamp timestamp;
};

[Exposed=Window, SecureContext]
interface GamepadButton {
  readonly attribute boolean pressed;
  readonly attribute boolean touched;
  readonly attribute double value;
};

[Exposed=Window, SecureContext]
interface GamepadEvent : Event {
  [SameObject]
  readonly attribute Gamepad gamepad;
  constructor( DOMString type, GamepadEventInit eventInitDict );
};

[Exposed=Window]
partial interface Navigator {
  sequence<Gamepad?> getGamepads();
};
