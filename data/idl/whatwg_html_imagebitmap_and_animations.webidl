[Exposed=(Window,Worker), Serializable, Transferable]
interface ImageBitmap {
  readonly attribute unsigned long width;
  readonly attribute unsigned long height;
  void close();
};

typedef (CanvasImageSource or
         Blob or
         ImageData) ImageBitmapSource;

enum ImageOrientation { "none", "flipY" };
enum PremultiplyAlpha { "none", "premultiply", "default" };
enum ColorSpaceConversion { "none", "default" };
enum ResizeQuality { "pixelated", "low", "medium", "high" };

dictionary ImageBitmapOptions {
  ImageOrientation imageOrientation = "none";
  PremultiplyAlpha premultiplyAlpha = "default";
  ColorSpaceConversion colorSpaceConversion = "default";
  [EnforceRange] unsigned long resizeWidth;
  [EnforceRange] unsigned long resizeHeight;
  ResizeQuality resizeQuality = "low";
};

callback FrameRequestCallback = void (DOMHighResTimeStamp time);

interface mixin AnimationFrameProvider {
  unsigned long requestAnimationFrame(FrameRequestCallback callback);
  void cancelAnimationFrame(unsigned long handle);
};
Window includes AnimationFrameProvider;
DedicatedWorkerGlobalScope includes AnimationFrameProvider;