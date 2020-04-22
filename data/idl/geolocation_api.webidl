callback PositionCallback = void ( Position position );

callback PositionErrorCallback = void ( PositionError positionError );

dictionary PositionOptions {
  boolean enableHighAccuracy = false;
  [Clamp]
  unsigned long maximumAge = 0;
  [Clamp]
  unsigned long timeout = 0xFFFFFFFF;
};

[NoInterfaceObject]
interface PositionError {
  const unsigned short PERMISSION_DENIED = 1;
  const unsigned short POSITION_UNAVAILABLE = 2;
  const unsigned short TIMEOUT = 3;
  readonly attribute unsigned short code;
  readonly attribute DOMString message;
};

[NoInterfaceObject]
interface Geolocation {
  void clearWatch( long watchId );
  void getCurrentPosition( PositionCallback successCallback, optional PositionErrorCallback errorCallback, optional PositionOptions options );
  long watchPosition( PositionCallback successCallback, optional PositionErrorCallback errorCallback, optional PositionOptions options );
};

[NoInterfaceObject]
interface Position {
  readonly attribute Coordinates coords;
  readonly attribute DOMTimeStamp timestamp;
};

[NoInterfaceObject]
interface Coordinates {
  readonly attribute double accuracy;
  readonly attribute double? altitude;
  readonly attribute double? altitudeAccuracy;
  readonly attribute double? heading;
  readonly attribute double latitude;
  readonly attribute double longitude;
  readonly attribute double? speed;
};

partial interface Navigator {
  readonly attribute Geolocation geolocation;
};
