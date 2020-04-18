[Exposed=Window]
interface Gamepad {
  readonly attribute DOMString id;
  readonly attribute long index;
  readonly attribute boolean connected;
  readonly attribute DOMHighResTimeStamp timestamp;
  readonly attribute GamepadMappingType mapping;
  readonly attribute FrozenArray<double> axes;
  readonly attribute FrozenArray<GamepadButton> buttons;
};

[Exposed=Window]
interface GamepadButton {
  readonly attribute boolean pressed;
  readonly attribute boolean touched;
  readonly attribute double value;
};

enum GamepadMappingType {
  "",
  "standard",
};

[Exposed=Window]
partial interface Navigator {
  sequence<Gamepad?> getGamepads();
};

[Exposed=Window]

interface GamepadEvent: Event {
  constructor(DOMString type, GamepadEventInit eventInitDict);
  [SameObject] readonly attribute Gamepad gamepad;
};

dictionary GamepadEventInit : EventInit {
  required Gamepad gamepad;
};