/**
 * A temporary hack to emulate ArrayBufferView as an interface.
 */
[MarkerType]
typedef ( DataView or DataView ) FakeArrayBufferView;

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
interface ArrayBuffer {
  /**
   * The byteLength accessor property represents the length of an ArrayBuffer in bytes.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/ArrayBuffer/byteLength">SharedArrayBuffer.byteLength - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-get-arraybuffer.prototype.bytelength">ArrayBuffer.prototype.byteLength - ECMA</a>
   */
  readonly attribute long long byteLength;

  /**
   * The ArrayBuffer() constructor is used to create ArrayBuffer objects.
   *
   * @param length The size, in bytes, of the array buffer to create.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/ArrayBuffer/ArrayBuffer">ArrayBuffer() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-arraybuffer-constructor">The ArrayBuffer Constructor - ECMA</a>
   */
  constructor(long long length);

  /**
   * The slice() method returns a new ArrayBuffer whose contents are a copy of this ArrayBuffer's bytes from begin, inclusive, up to end, exclusive.
   *
   * @param begin Zero-based byte index at which to begin slicing.
   * @param end Byte index before which to end slicing. If end is unspecified, the new ArrayBuffer contains all bytes from begin to the end of this ArrayBuffer.
   * @return A new ArrayBuffer containing the extracted elements.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/ArrayBuffer/slice">ArrayBuffer.slice - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-arraybuffer.prototype.slice">ArrayBuffer.slice - ECMA</a>
   */
  ArrayBuffer slice(long long begin, optional long long end = 0);
};

interface DataView {
  constructor(ArrayBuffer buffer, optional long long byteOffset = 0, optional long long byteLength = 0);
  constructor(SharedArrayBuffer buffer, optional long long byteOffset = 0, optional long long byteLength = 0);

  byte getInt8(long long byteOffset);
  long getUint8(long long byteOffset);
  long getInt16(long long byteOffset, optional boolean littleEndian);
  long long getUint16(long long byteOffset, optional boolean littleEndian);
  long long getInt32(long long byteOffset, optional boolean littleEndian);
  long long getUint32(long long byteOffset, optional boolean littleEndian);
  float getFloat32(long long byteOffset, optional boolean littleEndian);
  double getFloat64(long long byteOffset, optional boolean littleEndian);

  undefined setInt8(long long byteOffset, byte value);
  undefined setUint8(long long byteOffset, long value);
  undefined setInt16(long long byteOffset, long value, optional boolean littleEndian);
  undefined setUint16(long long byteOffset, long long value, optional boolean littleEndian);
  undefined setInt32(long long byteOffset, long long value, optional boolean littleEndian);
  undefined setUint32(long long byteOffset, long long value, optional boolean littleEndian);
  undefined setFloat32(long long byteOffset, float value, optional boolean littleEndian);
  undefined setFloat64(long long byteOffset, double value, optional boolean littleEndian);
};

/*
 * The Int8Array typed array represents an array of twos-complement 8-bit signed integers.
 * The contents are initialized to 0. Once established, you can reference elements in the
 * array using the object's methods, or using standard array index syntax (that is, using
 * bracket notation).
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Int8Array">Int8Array - MDN</a>
 * @see <a href="https://tc39.es/ecma262/#sec-typedarray-objects">TypedArray Objects - ECMA</a>
 */
//interface Int8Array {
//};
