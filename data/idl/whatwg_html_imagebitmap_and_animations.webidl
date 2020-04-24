enum ColorSpaceConversion {
  "default",
  "none"
};

enum ImageOrientation {
  "flipY",
  "none"
};

enum PremultiplyAlpha {
  "default",
  "none",
  "premultiply"
};

enum ResizeQuality {
  "high",
  "low",
  "medium",
  "pixelated"
};

typedef ( CanvasImageSource or Blob or ImageData ) ImageBitmapSource;

callback FrameRequestCallback = void ( DOMHighResTimeStamp time );

dictionary ImageBitmapOptions {
  ColorSpaceConversion colorSpaceConversion = "default";
  ImageOrientation imageOrientation = "none";
  PremultiplyAlpha premultiplyAlpha = "default";
  [EnforceRange]
  unsigned long resizeHeight;
  ResizeQuality resizeQuality = "low";
  [EnforceRange]
  unsigned long resizeWidth;
};

interface mixin AnimationFrameProvider {
  void cancelAnimationFrame( unsigned long handle );
  unsigned long requestAnimationFrame( FrameRequestCallback callback );
};

[Exposed=(Window,Worker), Serializable, Transferable]
interface ImageBitmap {
  readonly attribute unsigned long height;
  readonly attribute unsigned long width;
  void close();
};

DedicatedWorkerGlobalScope includes AnimationFrameProvider;

Window includes AnimationFrameProvider;
