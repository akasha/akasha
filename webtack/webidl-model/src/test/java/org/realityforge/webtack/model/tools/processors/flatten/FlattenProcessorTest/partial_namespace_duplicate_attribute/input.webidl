partial namespace WebAssembly {
  readonly attribute USVString URL;
  Promise<WebAssemblyInstantiatedSource> instantiateStreaming( Promise<Response> source, optional object importObject );
};

[Exposed=(Window,Worker,Worklet)]
namespace WebAssembly {
  readonly attribute USVString URL;
  boolean validate( BufferSource bytes );
};
