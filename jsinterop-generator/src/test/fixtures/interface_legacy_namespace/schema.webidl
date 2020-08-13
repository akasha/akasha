typedef ArrayBuffer BufferSource;

[Exposed=(Window,Worker,Worklet)]
namespace WebAssembly {
  Promise<Module> compile( BufferSource bytes );
};

dictionary GlobalDescriptor {
  boolean mutable = false;
  required any value;
};

[LegacyNamespace=WebAssembly]
interface CompileError {
};

[LegacyNamespace=WebAssembly, Exposed=(Window,Worker,Worklet)]
interface Global {
  attribute any value;
  constructor( GlobalDescriptor descriptor, optional any v );
  any valueOf();
};

[LegacyNamespace=WebAssembly]
interface Module {
};
