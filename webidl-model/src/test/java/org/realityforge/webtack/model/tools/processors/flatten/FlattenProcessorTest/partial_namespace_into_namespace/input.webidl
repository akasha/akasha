partial namespace WebAssembly {
  Promise<Module> compileStreaming( Promise<Response> source );
  Promise<WebAssemblyInstantiatedSource> instantiateStreaming( Promise<Response> source, optional object importObject );
};

[Exposed=(Window,Worker,Worklet)]
namespace WebAssembly {
  Promise<Module> compile( BufferSource bytes );
  Promise<WebAssemblyInstantiatedSource> instantiate( BufferSource bytes, optional object importObject );
  Promise<Instance> instantiate( Module moduleObject, optional object importObject );
  boolean validate( BufferSource bytes );
};
