callback PositionCallback = undefined ( GeolocationPosition position );

callback PositionErrorCallback = undefined ( GeolocationPositionError positionError );

dictionary PositionOptions {
  boolean enableHighAccuracy = false;
  [Clamp]
  unsigned long maximumAge = 0;
  [Clamp]
  unsigned long timeout = 0xFFFFFFFF;
};

[Exposed=Window]
interface Geolocation {
  undefined clearWatch( long watchId );
  undefined getCurrentPosition( PositionCallback successCallback, optional PositionErrorCallback? errorCallback = null, optional PositionOptions options = {} );
  long watchPosition( PositionCallback successCallback, optional PositionErrorCallback? errorCallback = null, optional PositionOptions options = {} );
};

[Exposed=Window, SecureContext]
interface GeolocationCoordinates {
  readonly attribute double accuracy;
  readonly attribute double? altitude;
  readonly attribute double? altitudeAccuracy;
  readonly attribute double? heading;
  readonly attribute double latitude;
  readonly attribute double longitude;
  readonly attribute double? speed;
};

[Exposed=Window, SecureContext]
interface GeolocationPosition {
  readonly attribute GeolocationCoordinates coords;
  readonly attribute EpochTimeStamp timestamp;
};

[Exposed=Window]
interface GeolocationPositionError {
  const unsigned short PERMISSION_DENIED = 1;
  const unsigned short POSITION_UNAVAILABLE = 2;
  const unsigned short TIMEOUT = 3;
  readonly attribute unsigned short code;
  readonly attribute DOMString message;
};

partial interface Navigator {
  [SameObject]
  readonly attribute Geolocation geolocation;
};
