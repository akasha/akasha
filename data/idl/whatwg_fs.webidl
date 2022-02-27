enum FileSystemHandleKind {
  "directory",
  "file"
};

enum WriteCommandType {
  "seek",
  "truncate",
  "write"
};

typedef ( BufferSource or Blob or USVString or WriteParams ) FileSystemWriteChunkType;

dictionary FileSystemCreateWritableOptions {
  boolean keepExistingData = false;
};

dictionary FileSystemGetDirectoryOptions {
  boolean create = false;
};

dictionary FileSystemGetFileOptions {
  boolean create = false;
};

dictionary FileSystemRemoveOptions {
  boolean recursive = false;
};

dictionary WriteParams {
  required WriteCommandType type;
  ( BufferSource or Blob or USVString )? data;
  unsigned long long? position;
  unsigned long long? size;
};

[Exposed=(Window,Worker), SecureContext, Serializable]
interface FileSystemDirectoryHandle : FileSystemHandle {
  async iterable<USVString, FileSystemHandle>;
  Promise<FileSystemDirectoryHandle> getDirectoryHandle( USVString name, optional FileSystemGetDirectoryOptions options = {} );
  Promise<FileSystemFileHandle> getFileHandle( USVString name, optional FileSystemGetFileOptions options = {} );
  Promise<undefined> removeEntry( USVString name, optional FileSystemRemoveOptions options = {} );
  Promise<sequence<USVString>?> resolve( FileSystemHandle possibleDescendant );
};

[Exposed=(Window,Worker), SecureContext, Serializable]
interface FileSystemFileHandle : FileSystemHandle {
  Promise<FileSystemWritableFileStream> createWritable( optional FileSystemCreateWritableOptions options = {} );
  Promise<File> getFile();
};

[Exposed=(Window,Worker), SecureContext, Serializable]
interface FileSystemHandle {
  readonly attribute FileSystemHandleKind kind;
  readonly attribute USVString name;
  Promise<boolean> isSameEntry( FileSystemHandle other );
};

[Exposed=(Window,Worker), SecureContext]
interface FileSystemWritableFileStream : WritableStream {
  Promise<undefined> seek( unsigned long long position );
  Promise<undefined> truncate( unsigned long long size );
  Promise<undefined> write( FileSystemWriteChunkType data );
};

[SecureContext]
partial interface StorageManager {
  Promise<FileSystemDirectoryHandle> getDirectory();
};
