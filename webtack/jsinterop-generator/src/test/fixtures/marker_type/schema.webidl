[MarkerType]
typedef ( PasswordCredentialData or HTMLFormElement ) PasswordCredentialInit;

[MarkerType]
typedef ( TexImageSource or MyBufferSource ) TexBufferSource;

[MarkerType]
typedef ( ImageBitmap or ImageData or HTMLImageElement or HTMLCanvasElement or HTMLVideoElement or OffscreenCanvas ) TexImageSource;

dictionary PasswordCredentialData {
  USVString iconURL;
};

interface HTMLCanvasElement {
};

interface HTMLFormElement {
};

interface HTMLImageElement {
};

interface HTMLVideoElement {
};

interface ImageBitmap {
};

interface ImageData {
};

interface MyBufferSource {
};

interface OffscreenCanvas {
};

interface WebGLRenderingContext {
  undefined texImage2D( TexImageSource source );
};
