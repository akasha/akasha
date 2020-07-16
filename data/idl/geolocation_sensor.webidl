dictionary GeolocationReadingValues {
  required double? accuracy;
  required double? altitude;
  required double? altitudeAccuracy;
  required double? heading;
  required double? latitude;
  required double? longitude;
  required double? speed;
};

dictionary GeolocationSensorOptions : SensorOptions {
};

dictionary GeolocationSensorReading {
  double? accuracy;
  double? altitude;
  double? altitudeAccuracy;
  double? heading;
  double? latitude;
  double? longitude;
  double? speed;
  DOMHighResTimeStamp? timestamp;
};

dictionary ReadOptions : GeolocationSensorOptions {
  AbortSignal? signal;
};

[SecureContext, Exposed=(DedicatedWorker,Window)]
interface GeolocationSensor : Sensor {
  readonly attribute unrestricted double? accuracy;
  readonly attribute unrestricted double? altitude;
  readonly attribute unrestricted double? altitudeAccuracy;
  readonly attribute unrestricted double? heading;
  readonly attribute unrestricted double? latitude;
  readonly attribute unrestricted double? longitude;
  readonly attribute unrestricted double? speed;
  static Promise<GeolocationSensorReading> read( optional ReadOptions readOptions = {} );
  constructor( optional GeolocationSensorOptions options = {} );
};
