typedef ArrayBuffer BufferSource;

namespace WebAssembly {
  Promise<Module> compile( BufferSource bytes );
};

dictionary GlobalDescriptor {
  boolean mutable = false;
  required any value;
};

interface ArrayBuffer {
};

[LegacyNamespace=WebAssembly]
interface CompileError {
};

[LegacyNamespace=WebAssembly]
interface Global {
  attribute any value;
  constructor( GlobalDescriptor descriptor, optional any v );
  any valueOf();
};

[LegacyNamespace=WebAssembly]
interface Module {
};
