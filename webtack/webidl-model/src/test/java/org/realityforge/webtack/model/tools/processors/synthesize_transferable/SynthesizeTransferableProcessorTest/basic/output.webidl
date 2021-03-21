/**
 * The Transferable type can be be transferred between contexts.
 *
 * @see <a href="https://html.spec.whatwg.org/multipage/structured-data.html#transferable-objects">Transferable - HTML Specification</a>
 */
[MarkerType]
typedef ( ImageBitmap or MessagePort or OffscreenCanvas or ReadableStream or TransformStream ) Transferable;

[Transferable]
interface ImageBitmap {
};

[Transferable]
interface MessagePort {
};

[Transferable]
interface OffscreenCanvas {
};

interface Other {
};

[Transferable]
interface ReadableStream {
};

[Transferable]
interface TransformStream {
};
