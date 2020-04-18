partial namespace WebAssembly {
  Promise<Module> compileStreaming(Promise<Response> source);
  Promise<WebAssemblyInstantiatedSource> instantiateStreaming(
      Promise<Response> source, optional object importObject);
};