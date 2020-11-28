/*
 * TypedArray IDL definitions.
 *
 * This document is a manually constructed blending of the original Khronos Working Draft retrieved
 * from https://web.archive.org/web/20160318230720/https://www.khronos.org/registry/typedarray/specs/latest/typedarray.idl
 * MDN documentation, ECMA specification, WebIDL specification and prior manually constructed "arrays.idl".
 */

/**
 * The ArrayBuffer object is used to represent a generic, fixed-length raw binary data buffer.
 *
 * <p>It is an array of bytes, often referred to in other languages as a "byte array". You cannot
 * directly manipulate the contents of an ArrayBuffer; instead, you create one of the typed array
 * objects or a {@link DataView} object which represents the buffer in a specific format, and use
 * that to read and write the contents of the buffer.</p>
 *
 * <p>The ArrayBuffer() constructor creates a new ArrayBuffer of the given length in bytes. You can
 * also get an array buffer from existing data, for example from a <a href="https://developer.mozilla.org/en-US/docs/Glossary/Base64#Appendix_to_Solution_1_Decode_a_Base64_string_to_Uint8Array_or_ArrayBuffer">Base64 string</a>
 * or from a <a href="https://developer.mozilla.org/en-US/docs/Web/API/FileReader/readAsArrayBuffer">local file</a>.</p>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/ArrayBuffer">ArrayBuffer - MDN</a>
 * @see <a href="https://tc39.es/ecma262/#sec-arraybuffer-objects">ArrayBuffer - ECMA</a>
 */
[Transferable]
interface ArrayBuffer {
  /**
   * The byteLength accessor property represents the length of an ArrayBuffer in bytes.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/ArrayBuffer/byteLength">ArrayBuffer.byteLength - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-get-arraybuffer.prototype.bytelength">ArrayBuffer.prototype.byteLength - ECMA</a>
   */
  readonly attribute unsigned long byteLength;

  /**
   * The ArrayBuffer.isView() method determines whether the passed value is one of the ArrayBuffer views, such as typed array objects or a DataView.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/ArrayBuffer/isView">ArrayBuffer.isView - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-arraybuffer.isview">ArrayBuffer.isView - ECMA</a>
   */
  static boolean isView(any value);

  /**
   * The ArrayBuffer() constructor is used to create ArrayBuffer objects.
   *
   * @param length The size, in bytes, of the array buffer to create.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/ArrayBuffer/ArrayBuffer">ArrayBuffer() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-arraybuffer-constructor">The ArrayBuffer Constructor - ECMA</a>
   */
  constructor(unsigned long length);

  /**
   * The slice() method returns a new ArrayBuffer whose contents are a copy of this ArrayBuffer's bytes from begin, inclusive, up to end, exclusive.
   *
   * @param begin Zero-based byte index at which to begin slicing.
   * @param end Byte index before which to end slicing. If end is unspecified, the new ArrayBuffer contains all bytes from begin to the end of this ArrayBuffer.
   * @return A new ArrayBuffer containing the extracted elements.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/ArrayBuffer/slice">ArrayBuffer.slice - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-arraybuffer.prototype.slice">ArrayBuffer.slice - ECMA</a>
   */
  ArrayBuffer slice(long begin, optional long end = 0);
};

/**
 * The SharedArrayBuffer object is used to represent a generic, fixed-length raw binary data buffer, similar to the ArrayBuffer object, but in a way that they can be used to create views on shared memory.
 * Unlike an ArrayBuffer, a SharedArrayBuffer cannot become detached.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/SharedArrayBuffer">SharedArrayBuffer - MDN</a>
 * @see <a href="https://tc39.es/ecma262/#sec-sharedarraybuffer-objects">SharedArrayBuffer - ECMA</a>
 */
interface SharedArrayBuffer {
  /**
   * The byteLength accessor property represents the length of an SharedArrayBuffer in bytes.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/SharedArrayBuffer/byteLength">SharedArrayBuffer.byteLength - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-get-sharedarraybuffer.prototype.bytelength">SharedArrayBuffer.prototype.byteLength - ECMA</a>
   */
  readonly attribute long long byteLength;

  /**
   * The SharedArrayBuffer() constructor is used to create a SharedArrayBuffer object representing a generic, fixed-length raw binary data buffer, similar to the ArrayBuffer object.
   *
   * @param length The size, in bytes, of the array buffer to create.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/SharedArrayBuffer/SharedArrayBuffer">SharedArrayBuffer() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-sharedarraybuffer-constructor">The SharedArrayBuffer Constructor - ECMA</a>
   */
  constructor(long long length);

  /**
   * The SharedArrayBuffer.prototype.slice() method returns a new SharedArrayBuffer whose contents are a copy of this SharedArrayBuffer's bytes from begin, inclusive, up to end, exclusive. If either begin or end is negative, it refers to an index from the end of the array, as opposed to from the beginning. This method has the same algorithm as Array.prototype.slice().
   *
   * @param begin Zero-based index at which to begin extraction. A negative index can be used, indicating an offset from the end of the sequence. slice(-2) extracts the last two elements in the sequence. If begin is undefined, slice begins from index 0.
   * @param end Zero-based index before which to end extraction. slice extracts up to but not including end. For example, slice(1,4) extracts the second element through the fourth element (elements indexed 1, 2, and 3). A negative index can be used, indicating an offset from the end of the sequence. slice(2,-1) extracts the third element through the second-to-last element in the sequence. If end is omitted, slice extracts through the end of the sequence (sab.byteLength).
   * @return A new SharedArrayBuffer containing the extracted elements.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/SharedArrayBuffer/slice">SharedArrayBuffer.slice - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-sharedarraybuffer.prototype.slice">SharedArrayBuffer.slice - ECMA</a>
   */
  SharedArrayBuffer slice(optional long long begin = 0, optional long long end = 0);
};

interface mixin ArrayBufferViewImpl {
  readonly attribute ArrayBuffer buffer;
  readonly attribute unsigned long byteOffset;
  readonly attribute unsigned long byteLength;

  readonly attribute unsigned long length;
};

/**
 * The Int8Array typed array represents an array of twos-complement 8-bit signed integers.
 * The contents are initialized to 0. Once established, you can reference elements in the
 * array using the object's methods, or using standard array index syntax (that is, using
 * bracket notation).
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Int8Array">Int8Array - MDN</a>
 * @see <a href="https://tc39.es/ecma262/#sec-typedarray-objects">TypedArray Objects - ECMA</a>
 * @see <a href="https://heycam.github.io/webidl/#idl-Int8Array">Int8Array - WebIDL</a>
 */
interface Int8Array {
  /**
   * The BYTES_PER_ELEMENT property represents the size in bytes of each element in an typed array.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/TypedArray/BYTES_PER_ELEMENT">TypedArray.BYTES_PER_ELEMENT - MDN</a>
   */
  const long BYTES_PER_ELEMENT = 1;
  /**
   * The name property represents a string value of the typed array constructor name.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/TypedArray/name">TypedArray.name - MDN</a>
   */
  const DOMString name = "Int8Array";


  constructor(unsigned long length);
  constructor(Int8Array array);
  constructor(sequence<byte> array);
  constructor(ArrayBuffer buffer, optional unsigned long byteOffset, optional unsigned long length);

  getter byte get(unsigned long index);
  setter void set(unsigned long index, byte value);
  void set(Int8Array array, optional unsigned long offset);
  void set(sequence<byte> array, optional unsigned long offset);
  Int8Array subarray(long start, long end);
};
Int8Array includes ArrayBufferViewImpl;


/**
 * The Uint8Array typed array represents an array of 8-bit unsigned integers. The contents are initialized to 0.
 * Once established, you can reference elements in the array using the object's methods, or using standard array
 * index syntax (that is, using bracket notation).
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Uint8Array">Uint8Array - MDN</a>
 * @see <a href="https://tc39.es/ecma262/#sec-typedarray-objects">TypedArray Objects - ECMA</a>
 * @see <a href="https://heycam.github.io/webidl/#idl-Uint8Array">Uint8Array - WebIDL</a>
 */
interface Uint8Array {
    const long BYTES_PER_ELEMENT = 1;

    constructor(unsigned long length);
    constructor(Uint8Array array);
    constructor(sequence<octet> array);
    constructor(ArrayBuffer buffer, optional unsigned long byteOffset, optional unsigned long length);

    getter octet get(unsigned long index);
    setter void set(unsigned long index, octet value);
    void set(Uint8Array array, optional unsigned long offset);
    void set(sequence<octet> array, optional unsigned long offset);
    Uint8Array subarray(long start, long end);
};
Uint8Array includes ArrayBufferViewImpl;


/**
 * The Uint8ClampedArray typed array represents an array of 8-bit unsigned integers clamped to 0-255; if you
 * specified a value that is out of the range of [0,255], 0 or 255 will be set instead; if you specify a non-integer,
 * the nearest integer will be set. The contents are initialized to 0. Once established, you can reference elements
 * in the array using the object's methods, or using standard array index syntax (that is, using bracket notation).
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Uint8ClampedArray">Uint8ClampedArray - MDN</a>
 * @see <a href="https://tc39.es/ecma262/#sec-typedarray-objects">TypedArray Objects - ECMA</a>
 * @see <a href="https://heycam.github.io/webidl/#idl-Uint8ClampedArray">Uint8ClampedArray - WebIDL</a>
 */
interface Uint8ClampedArray {
    const long BYTES_PER_ELEMENT = 1;

    constructor(unsigned long length);
    constructor(Uint8ClampedArray array);
    constructor(sequence<octet> array);
    constructor(ArrayBuffer buffer, optional unsigned long byteOffset, optional unsigned long length);

    getter octet get(unsigned long index);
    setter void set(unsigned long index, [Clamp] octet value);
    void set(Uint8ClampedArray array, optional unsigned long offset);
    void set(sequence<octet> array, optional unsigned long offset);
    Uint8ClampedArray subarray(long start, long end);
};
Uint8ClampedArray includes ArrayBufferViewImpl;


/**
 * The Int16Array typed array represents an array of twos-complement 16-bit signed integers in the
 * platform byte order. If control over byte order is needed, use DataView instead. The contents are
 * initialized to 0. Once established, you can reference elements in the array using the object's methods,
 * or using standard array index syntax (that is, using bracket notation).
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Int16Array">Int16Array - MDN</a>
 * @see <a href="https://tc39.es/ecma262/#sec-typedarray-objects">TypedArray Objects - ECMA</a>
 * @see <a href="https://heycam.github.io/webidl/#idl-Int16Array">Int16Array - WebIDL</a>
 */
interface Int16Array {
    const long BYTES_PER_ELEMENT = 2;

    constructor(unsigned long length);
    constructor(Int16Array array);
    constructor(sequence<short> array);
    constructor(ArrayBuffer buffer, optional unsigned long byteOffset, optional unsigned long length);

    getter short get(unsigned long index);
    setter void set(unsigned long index, short value);
    void set(Int16Array array, optional unsigned long offset);
    void set(sequence<short> array, optional unsigned long offset);
    Int16Array subarray(long start, long end);
};
Int16Array includes ArrayBufferViewImpl;


/**
 * The Uint16Array typed array represents an array of 16-bit unsigned integers in the platform byte order.
 * If control over byte order is needed, use DataView instead. The contents are initialized to 0. Once
 * established, you can reference elements in the array using the object's methods, or using standard array
 * index syntax (that is, using bracket notation).
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Uint16Array">Uint16Array - MDN</a>
 * @see <a href="https://tc39.es/ecma262/#sec-typedarray-objects">TypedArray Objects - ECMA</a>
 * @see <a href="https://heycam.github.io/webidl/#idl-Uint16Array">Uint16Array - WebIDL</a>
 */
interface Uint16Array {
    const long BYTES_PER_ELEMENT = 2;

    constructor(unsigned long length);
    constructor(Uint16Array array);
    constructor(sequence<unsigned short> array);
    constructor(ArrayBuffer buffer, optional unsigned long byteOffset, optional unsigned long length);

    getter unsigned short get(unsigned long index);
    setter void set(unsigned long index, unsigned short value);
    void set(Uint16Array array, optional unsigned long offset);
    void set(sequence<unsigned short> array, optional unsigned long offset);
    Uint16Array subarray(long start, long end);
};
Uint16Array includes ArrayBufferViewImpl;


/**
 * The Int32Array() typed array constructor creates an array of twos-complement 32-bit signed integers in
 * the platform byte order. If control over byte order is needed, use DataView instead. The contents are
 * initialized to 0. Once established, you can reference elements in the array using the object's methods,
 * or using standard array index syntax (that is, using bracket notation).
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Int32Array">Int32Array - MDN</a>
 * @see <a href="https://tc39.es/ecma262/#sec-typedarray-objects">TypedArray Objects - ECMA</a>
 * @see <a href="https://heycam.github.io/webidl/#idl-Int32Array">Int32Array - WebIDL</a>
 */
interface Int32Array {
    const long BYTES_PER_ELEMENT = 4;

    constructor(unsigned long length);
    constructor(Int32Array array);
    constructor(sequence<long> array);
    constructor(ArrayBuffer buffer, optional unsigned long byteOffset, optional unsigned long length);

    getter long get(unsigned long index);
    setter void set(unsigned long index, long value);
    void set(Int32Array array, optional unsigned long offset);
    void set(sequence<long> array, optional unsigned long offset);
    Int32Array subarray(long start, long end);
};
Int32Array includes ArrayBufferViewImpl;


/**
 * The Uint32Array typed array represents an array of 32-bit unsigned integers in the platform byte order. If
 * control over byte order is needed, use DataView instead. The contents are initialized to 0. Once established,
 * you can reference elements in the array using the object's methods, or using standard array index syntax
 * (that is, using bracket notation).
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Uint32Array">Uint32Array - MDN</a>
 * @see <a href="https://tc39.es/ecma262/#sec-typedarray-objects">TypedArray Objects - ECMA</a>
 * @see <a href="https://heycam.github.io/webidl/#idl-Uint32Array">Uint32Array - WebIDL</a>
 */
interface Uint32Array {
    const long BYTES_PER_ELEMENT = 4;

    constructor(unsigned long length);
    constructor(Uint32Array array);
    constructor(sequence<unsigned long> array);
    constructor(ArrayBuffer buffer, optional unsigned long byteOffset, optional unsigned long length);

    getter unsigned long get(unsigned long index);
    setter void set(unsigned long index, unsigned long value);
    void set(Uint32Array array, optional unsigned long offset);
    void set(sequence<unsigned long> array, optional unsigned long offset);
    Uint32Array subarray(long start, long end);
};
Uint32Array includes ArrayBufferViewImpl;


/**
 * The Float32Array typed array represents an array of 32-bit floating point numbers (corresponding to
 * the C float data type) in the platform byte order. If control over byte order is needed, use DataView
 * instead. The contents are initialized to 0. Once established, you can reference elements in the array
 * using the object's methods, or using standard array index syntax (that is, using bracket notation).
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Float32Array">Float32Array - MDN</a>
 * @see <a href="https://tc39.es/ecma262/#sec-typedarray-objects">TypedArray Objects - ECMA</a>
 * @see <a href="https://heycam.github.io/webidl/#idl-Float32Array">Float32Array - WebIDL</a>
 */
interface Float32Array {
    const long BYTES_PER_ELEMENT = 4;

    constructor(unsigned long length);
    constructor(Float32Array array);
    constructor(sequence<unrestricted float> array);
    constructor(ArrayBuffer buffer, optional unsigned long byteOffset, optional unsigned long length);

    getter unrestricted float get(unsigned long index);
    setter void set(unsigned long index, unrestricted float value);
    void set(Float32Array array, optional unsigned long offset);
    void set(sequence<unrestricted float> array, optional unsigned long offset);
    Float32Array subarray(long start, long end);
};
Float32Array includes ArrayBufferViewImpl;


/**
 * The Float64Array typed array represents an array of 64-bit floating point numbers (corresponding
 * to the C double data type) in the platform byte order. If control over byte order is needed, use
 * DataView instead. The contents are initialized to 0. Once established, you can reference elements
 * in the array using the object's methods, or using standard array index syntax (that is, using
 * bracket notation).
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Float64Array">Float64Array - MDN</a>
 * @see <a href="https://tc39.es/ecma262/#sec-typedarray-objects">TypedArray Objects - ECMA</a>
 * @see <a href="https://heycam.github.io/webidl/#idl-Float64Array">Float64Array - WebIDL</a>
 */
interface Float64Array {
    const long BYTES_PER_ELEMENT = 8;

    constructor(unsigned long length);
    constructor(Float64Array array);
    constructor(sequence<unrestricted double> array);
    constructor(ArrayBuffer buffer, optional unsigned long byteOffset, optional unsigned long length);

    getter unrestricted double get(unsigned long index);
    setter void set(unsigned long index, unrestricted double value);
    void set(Float64Array array, optional unsigned long offset);
    void set(sequence<unrestricted double> array, optional unsigned long offset);
    Float64Array subarray(long start, long end);
};
Float64Array includes ArrayBufferViewImpl;

interface DataView {
  constructor(ArrayBuffer buffer, optional unsigned long byteOffset = 0, optional unsigned long byteLength = 0);
  constructor(SharedArrayBuffer buffer, optional unsigned long byteOffset = 0, optional unsigned long byteLength = 0);

  // Gets the value of the given type at the specified byte offset
  // from the start of the view. There is no alignment constraint;
  // multi-byte values may be fetched from any offset.
  //
  // For multi-byte values, the optional littleEndian argument
  // indicates whether a big-endian or little-endian value should be
  // read. If false or undefined, a big-endian value is read.
  //
  // These methods raise an INDEX_SIZE_ERR exception if they would read
  // beyond the end of the view.

  byte getInt8(unsigned long byteOffset);
  octet getUint8(unsigned long byteOffset);
  short getInt16(unsigned long byteOffset, optional boolean littleEndian);
  unsigned short getUint16(unsigned long byteOffset, optional boolean littleEndian);
  long getInt32(unsigned long byteOffset, optional boolean littleEndian);
  unsigned long getUint32(unsigned long byteOffset, optional boolean littleEndian);
  unrestricted float getFloat32(unsigned long byteOffset, optional boolean littleEndian);
  unrestricted double getFloat64(unsigned long byteOffset, optional boolean littleEndian);

  // Stores a value of the given type at the specified byte offset
  // from the start of the view. There is no alignment constraint;
  // multi-byte values may be stored at any offset.
  //
  // For multi-byte values, the optional littleEndian argument
  // indicates whether the value should be stored in big-endian or
  // little-endian byte order. If false or undefined, the value is
  // stored in big-endian byte order.
  //
  // These methods throw exceptions if they would write beyond the end
  // of the view.

  undefined setInt8(unsigned long byteOffset, byte value);
  undefined setUint8(unsigned long byteOffset, long value);
  undefined setInt16(unsigned long byteOffset, long value, optional boolean littleEndian);
  undefined setUint16(unsigned long byteOffset, long long value, optional boolean littleEndian);
  undefined setInt32(unsigned long byteOffset, long long value, optional boolean littleEndian);
  undefined setUint32(unsigned long byteOffset, unsigned long value, optional boolean littleEndian);
  undefined setFloat32(unsigned long byteOffset, unrestricted float value, optional boolean littleEndian);
  undefined setFloat64(unsigned long byteOffset, unrestricted double value, optional boolean littleEndian);
};

DataView includes ArrayBufferViewImpl;

[MarkerType]
typedef ( Int8Array or Int16Array or Int32Array or Uint8Array or Uint16Array or Uint32Array or Uint8ClampedArray ) IntegerTypedArray;

[MarkerType]
typedef ( IntegerTypedArray or Float32Array or Float64Array ) TypedArray;
