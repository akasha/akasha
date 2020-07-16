callback PositionCallback = void ( Position position );

callback PositionErrorCallback = void ( PositionError positionError );

dictionary PositionOptions {
  boolean enableHighAccuracy = false;
  [Clamp]
  unsigned long maximumAge = 0;
  [Clamp]
  unsigned long timeout = 0xFFFFFFFF;
};

interface Coordinates {
  readonly attribute double accuracy;
  readonly attribute double? altitude;
  readonly attribute double? altitudeAccuracy;
  readonly attribute double? heading;
  readonly attribute double latitude;
  readonly attribute double longitude;
  readonly attribute double? speed;
};

interface Geolocation {
  void clearWatch( long watchId );
  void getCurrentPosition( PositionCallback successCallback, optional PositionErrorCallback errorCallback, optional PositionOptions options );
  long watchPosition( PositionCallback successCallback, optional PositionErrorCallback errorCallback, optional PositionOptions options );
};

interface Position {
  readonly attribute Coordinates coords;
  readonly attribute DOMTimeStamp timestamp;
};

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
