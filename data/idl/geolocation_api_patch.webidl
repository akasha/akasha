const enum PositionErrorCode {
  PositionError.PERMISSION_DENIED,
  PositionError.POSITION_UNAVAILABLE,
  PositionError.TIMEOUT
};

partial interface PositionError {
  readonly attribute PositionErrorCode code;
};
