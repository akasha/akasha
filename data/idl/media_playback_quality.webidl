[Exposed=Window]
interface VideoPlaybackQuality {
  readonly attribute unsigned long corruptedVideoFrames;
  readonly attribute DOMHighResTimeStamp creationTime;
  readonly attribute unsigned long droppedVideoFrames;
  readonly attribute unsigned long totalVideoFrames;
};

partial interface HTMLVideoElement {
  VideoPlaybackQuality getVideoPlaybackQuality();
};
