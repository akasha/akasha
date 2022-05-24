enum CursorCaptureConstraint {
  "always",
  "motion",
  "never"
};

enum DisplayCaptureSurfaceType {
  "browser",
  "monitor",
  "window"
};

enum SelfCapturePreferenceEnum {
  "exclude",
  "include"
};

enum SystemAudioPreferenceEnum {
  "exclude",
  "include"
};

dictionary DisplayMediaStreamConstraints {
  ( boolean or MediaTrackConstraints ) audio = false;
  SelfCapturePreferenceEnum selfBrowserSurface;
  SystemAudioPreferenceEnum systemAudio;
  ( boolean or MediaTrackConstraints ) video = true;
};

partial dictionary MediaTrackCapabilities {
  sequence<DOMString> cursor;
  DOMString displaySurface;
  boolean logicalSurface;
};

partial dictionary MediaTrackConstraintSet {
  ConstrainDOMString cursor;
  ConstrainDOMString displaySurface;
  ConstrainBoolean logicalSurface;
  ConstrainBoolean restrictOwnAudio;
  ConstrainBoolean suppressLocalAudioPlayback;
};

partial dictionary MediaTrackSettings {
  DOMString cursor;
  DOMString displaySurface;
  boolean logicalSurface;
  boolean restrictOwnAudio;
};

partial dictionary MediaTrackSupportedConstraints {
  boolean cursor = true;
  boolean displaySurface = true;
  boolean logicalSurface = true;
  boolean restrictOwnAudio = true;
  boolean suppressLocalAudioPlayback = true;
};

partial interface MediaDevices {
  Promise<MediaStream> getDisplayMedia( optional DisplayMediaStreamConstraints constraints = {} );
};
