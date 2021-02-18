enum GamepadHand {
  "",
  "left",
  "right"
};

enum GamepadHapticActuatorType {
  "vibration"
};

[Exposed=Window]
interface GamepadHapticActuator {
  readonly attribute GamepadHapticActuatorType type;
  Promise<boolean> pulse( double value, double duration );
};

[Exposed=Window]
interface GamepadPose {
  readonly attribute Float32Array? angularAcceleration;
  readonly attribute Float32Array? angularVelocity;
  readonly attribute boolean hasOrientation;
  readonly attribute boolean hasPosition;
  readonly attribute Float32Array? linearAcceleration;
  readonly attribute Float32Array? linearVelocity;
  readonly attribute Float32Array? orientation;
  readonly attribute Float32Array? position;
};

[Exposed=Window, SecureContext]
interface GamepadTouch {
  readonly attribute Float32Array position;
  readonly attribute Uint32Array? surfaceDimensions;
  readonly attribute octet surfaceId;
  readonly attribute unsigned long touchId;
};

partial interface Gamepad {
  readonly attribute GamepadHand hand;
  readonly attribute FrozenArray<GamepadHapticActuator> hapticActuators;
  readonly attribute GamepadPose? pose;
  readonly attribute FrozenArray<GamepadTouch>? touchEvents;
};
