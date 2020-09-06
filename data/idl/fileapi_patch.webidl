[Exposed=(Window,DedicatedWorker,SharedWorker)]
partial interface URL {
  static DOMString createObjectURL( Blob blob );
};
