[Exposed=(Window,Worker,Worklet)]
namespace WebAssembly {
  Promise<Module> compile( BufferSource bytes );
  Promise<Module> compileStreaming( Promise<Response> source );
  Promise<WebAssemblyInstantiatedSource> instantiate( BufferSource bytes, optional object importObject );
  Promise<Instance> instantiate( Module moduleObject, optional object importObject );
  Promise<WebAssemblyInstantiatedSource> instantiateStreaming( Promise<Response> source, optional object importObject );
  boolean validate( BufferSource bytes );
};
