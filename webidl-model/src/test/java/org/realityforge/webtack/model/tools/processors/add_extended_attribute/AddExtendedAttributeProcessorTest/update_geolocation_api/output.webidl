callback PositionCallback = undefined ( Position position );

callback PositionErrorCallback = undefined ( PositionError positionError );

dictionary PositionOptions {
  boolean enableHighAccuracy = false;
  [Clamp]
  unsigned long maximumAge = 0;
  [Clamp]
  unsigned long timeout = 0xFFFFFFFF;
};

[LegacyNoInterfaceObject]
interface Coordinates {
  readonly attribute double accuracy;
  readonly attribute double? altitude;
  readonly attribute double? altitudeAccuracy;
  readonly attribute double? heading;
  readonly attribute double latitude;
  readonly attribute double longitude;
  readonly attribute double? speed;
};

[LegacyNoInterfaceObject]
interface Geolocation {
  undefined clearWatch( long watchId );
  undefined getCurrentPosition( PositionCallback successCallback, optional PositionErrorCallback errorCallback, optional PositionOptions options );
  long watchPosition( PositionCallback successCallback, optional PositionErrorCallback errorCallback, optional PositionOptions options );
};

[LegacyNoInterfaceObject]
interface Position {
  readonly attribute Coordinates coords;
  readonly attribute DOMTimeStamp timestamp;
};

[LegacyNoInterfaceObject]
interface PositionError {
  const unsigned short PERMISSION_DENIED = 1;
  const unsigned short POSITION_UNAVAILABLE = 2;
  const unsigned short TIMEOUT = 3;
  readonly attribute unsigned short code;
  readonly attribute DOMString message;
};

partial interface Navigator {
  readonly attribute Geolocation geolocation;
};
