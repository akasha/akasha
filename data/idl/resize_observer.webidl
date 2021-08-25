enum ResizeObserverBoxOptions {
  "border-box",
  "content-box",
  "device-pixel-content-box"
};

callback ResizeObserverCallback = undefined ( sequence<ResizeObserverEntry> entries, ResizeObserver observer );

dictionary ResizeObserverOptions {
  ResizeObserverBoxOptions box = "content-box";
};

[Constructor( Element target )]
interface ResizeObservation {
  readonly attribute sequence<ResizeObserverSize> lastReportedSizes;
  readonly attribute ResizeObserverBoxOptions observedBox;
  readonly attribute Element target;
};

[Exposed=(Window), Constructor( ResizeObserverCallback callback )]
interface ResizeObserver {
  undefined disconnect();
  undefined observe( Element target, optional ResizeObserverOptions options );
  undefined unobserve( Element target );
};

[Exposed=Window]
interface ResizeObserverEntry {
  readonly attribute sequence<ResizeObserverSize> borderBoxSize;
  readonly attribute sequence<ResizeObserverSize> contentBoxSize;
  readonly attribute DOMRectReadOnly contentRect;
  readonly attribute sequence<ResizeObserverSize> devicePixelContentBoxSize;
  readonly attribute Element target;
};

interface ResizeObserverSize {
  readonly attribute unrestricted double blockSize;
  readonly attribute unrestricted double inlineSize;
};
