enum ImportExportKind {
  "function",
  "global",
  "memory",
  "table"
};

enum TableKind {
  "anyfunc"
};

enum ValueType {
  "f32",
  "f64",
  "i32",
  "i64"
};

[Exposed=(Window,Worker,Worklet)]
namespace WebAssembly {
  Promise<Module> compile( BufferSource bytes );
  Promise<WebAssemblyInstantiatedSource> instantiate( BufferSource bytes, optional object importObject );
  Promise<Instance> instantiate( Module moduleObject, optional object importObject );
  boolean validate( BufferSource bytes );
};

dictionary GlobalDescriptor {
  boolean mutable = false;
  required ValueType value;
};

dictionary MemoryDescriptor {
  required [EnforceRange] unsigned long initial;
  [EnforceRange]
  unsigned long maximum;
};

dictionary ModuleExportDescriptor {
  required ImportExportKind kind;
  required USVString name;
};

dictionary ModuleImportDescriptor {
  required ImportExportKind kind;
  required USVString module;
  required USVString name;
};

dictionary TableDescriptor {
  required TableKind element;
  required [EnforceRange] unsigned long initial;
  [EnforceRange]
  unsigned long maximum;
};

dictionary WebAssemblyInstantiatedSource {
  required Instance instance;
  required Module module;
};

[LegacyNamespace=WebAssembly]
interface CompileError {
};

[LegacyNamespace=WebAssembly, Constructor( GlobalDescriptor descriptor, optional any v ), Exposed=(Window,Worker,Worklet)]
interface Global {
  attribute any value;
  any valueOf();
};

[LegacyNamespace=WebAssembly, Constructor( Module module, optional object importObject ), Exposed=(Window,Worker,Worklet)]
interface Instance {
  readonly attribute object exports;
};

[LegacyNamespace=WebAssembly]
interface LinkError {
};

[LegacyNamespace=WebAssembly, Constructor( MemoryDescriptor descriptor ), Exposed=(Window,Worker,Worklet)]
interface Memory {
  readonly attribute ArrayBuffer buffer;
  unsigned long grow( [EnforceRange] unsigned long delta );
};

[LegacyNamespace=WebAssembly, Constructor( BufferSource bytes ), Exposed=(Window,Worker,Worklet)]
interface Module {
  static sequence<ArrayBuffer> customSections( Module moduleObject, DOMString sectionName );
  static sequence<ModuleExportDescriptor> exports( Module moduleObject );
  static sequence<ModuleImportDescriptor> imports( Module moduleObject );
};

[LegacyNamespace=WebAssembly]
interface RuntimeError {
};

[LegacyNamespace=WebAssembly, Constructor( TableDescriptor descriptor ), Exposed=(Window,Worker,Worklet)]
interface Table {
  readonly attribute unsigned long length;
  Function? get( [EnforceRange] unsigned long index );
  unsigned long grow( [EnforceRange] unsigned long delta );
  void set( [EnforceRange] unsigned long index, Function? value );
};
