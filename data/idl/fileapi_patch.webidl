[Exposed=(Window,DedicatedWorker,SharedWorker)]
partial interface URL {
  static DOMString createObjectURL( Blob blob );
};

const enum FileReaderReadyState {
  FileReader.EMPTY,
  FileReader.LOADING,
  FileReader.DONE
};

partial interface FileReader {
  readonly attribute FileReaderReadyState readyState;
};
