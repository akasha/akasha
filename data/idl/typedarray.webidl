/*
 * typedarray.idl
 *
 * TypedArray IDL definitions scraped from the Khronos specification.
 *
 * Original Khronos Working Draft:
 *
 *   https://www.khronos.org/registry/typedarray/specs/latest/
 *
 * NOTE: This document was retrieved from https://web.archive.org/web/20160318230720/https://www.khronos.org/registry/typedarray/specs/latest/typedarray.idl
 */

[ Constructor(unsigned long length) ]
interface ArrayBuffer {
    readonly attribute unsigned long byteLength;
    ArrayBuffer slice(long begin, optional long end);
    static boolean isView(any value);
};

ArrayBuffer implements Transferable;

[NoInterfaceObject]
interface ArrayBufferView {
    readonly attribute ArrayBuffer buffer;
    readonly attribute unsigned long byteOffset;
    readonly attribute unsigned long byteLength;
};


// The 'byte' type does not currently exist in Web IDL.
// In this IDL, it should be a signed 8 bit type.
[
    Constructor(unsigned long length),
    Constructor(Int8Array array),
    Constructor(byte[] array),
    Constructor(ArrayBuffer buffer,
                optional unsigned long byteOffset, optional unsigned long length)
]
interface Int8Array {
    const long BYTES_PER_ELEMENT = 1;

    readonly attribute unsigned long length;

    getter byte get(unsigned long index);
    setter void set(unsigned long index, byte value);
    void set(Int8Array array, optional unsigned long offset);
    void set(byte[] array, optional unsigned long offset);
    Int8Array subarray(long start, long end);
};
Int8Array implements ArrayBufferView;


// The 'unsigned byte' type does not currently exist in Web IDL, though
// 'octet' is equivalent.
[
    Constructor(unsigned long length),
    Constructor(Uint8Array array),
    Constructor(octet[] array),
    Constructor(ArrayBuffer buffer,
                optional unsigned long byteOffset, optional unsigned long length)
]
interface Uint8Array {
    const long BYTES_PER_ELEMENT = 1;

    readonly attribute unsigned long length;

    getter octet get(unsigned long index);
    setter void set(unsigned long index, octet value);
    void set(Uint8Array array, optional unsigned long offset);
    void set(octet[] array, optional unsigned long offset);
    Uint8Array subarray(long start, long end);
};
Uint8Array implements ArrayBufferView;


[
    Constructor(unsigned long length),
    Constructor(Uint8ClampedArray array),
    Constructor(octet[] array),
    Constructor(ArrayBuffer buffer,
                optional unsigned long byteOffset, optional unsigned long length)
]
interface Uint8ClampedArray {
    const long BYTES_PER_ELEMENT = 1;

    readonly attribute unsigned long length;

    getter octet get(unsigned long index);
    setter void set(unsigned long index, [Clamp] octet value);
    void set(Uint8ClampedArray array, optional unsigned long offset);
    void set(octet[] array, optional unsigned long offset);
    Uint8ClampedArray subarray(long start, long end);
};
Uint8ClampedArray implements ArrayBufferView;


[
    Constructor(unsigned long length),
    Constructor(Int16Array array),
    Constructor(short[] array),
    Constructor(ArrayBuffer buffer,
                optional unsigned long byteOffset, optional unsigned long length)
]
interface Int16Array {
    const long BYTES_PER_ELEMENT = 2;

    readonly attribute unsigned long length;

    getter short get(unsigned long index);
    setter void set(unsigned long index, short value);
    void set(Int16Array array, optional unsigned long offset);
    void set(short[] array, optional unsigned long offset);
    Int16Array subarray(long start, long end);
};
Int16Array implements ArrayBufferView;


[
    Constructor(unsigned long length),
    Constructor(Uint16Array array),
    Constructor(unsigned short[] array),
    Constructor(ArrayBuffer buffer,
                optional unsigned long byteOffset, optional unsigned long length)
]
interface Uint16Array {
    const long BYTES_PER_ELEMENT = 2;

    readonly attribute unsigned long length;

    getter unsigned short get(unsigned long index);
    setter void set(unsigned long index, unsigned short value);
    void set(Uint16Array array, optional unsigned long offset);
    void set(unsigned short[] array, optional unsigned long offset);
    Uint16Array subarray(long start, long end);
};
Uint16Array implements ArrayBufferView;


[
    Constructor(unsigned long length),
    Constructor(Int32Array array),
    Constructor(long[] array),
    Constructor(ArrayBuffer buffer,
                optional unsigned long byteOffset, optional unsigned long length)
]
interface Int32Array {
    const long BYTES_PER_ELEMENT = 4;

    readonly attribute unsigned long length;

    getter long get(unsigned long index);
    setter void set(unsigned long index, long value);
    void set(Int32Array array, optional unsigned long offset);
    void set(long[] array, optional unsigned long offset);
    Int32Array subarray(long start, long end);
};
Int32Array implements ArrayBufferView;


[
    Constructor(unsigned long length),
    Constructor(Uint32Array array),
    Constructor(unsigned long[] array),
    Constructor(ArrayBuffer buffer,
                optional unsigned long byteOffset, optional unsigned long length)
]
interface Uint32Array {
    const long BYTES_PER_ELEMENT = 4;

    readonly attribute unsigned long length;

    getter unsigned long get(unsigned long index);
    setter void set(unsigned long index, unsigned long value);
    void set(Uint32Array array, optional unsigned long offset);
    void set(unsigned long[] array, optional unsigned long offset);
    Uint32Array subarray(long start, long end);
};
Uint32Array implements ArrayBufferView;


[
    Constructor(unsigned long length),
    Constructor(Float32Array array),
    Constructor(unrestricted float[] array),
    Constructor(ArrayBuffer buffer,
                optional unsigned long byteOffset, optional unsigned long length)
]
interface Float32Array {
    const long BYTES_PER_ELEMENT = 4;

    readonly attribute unsigned long length;

    getter unrestricted float get(unsigned long index);
    setter void set(unsigned long index, unrestricted float value);
    void set(Float32Array array, optional unsigned long offset);
    void set(unrestricted float[] array, optional unsigned long offset);
    Float32Array subarray(long start, long end);
};
Float32Array implements ArrayBufferView;


[
    Constructor(unsigned long length),
    Constructor(Float64Array array),
    Constructor(unrestricted double[] array),
    Constructor(ArrayBuffer buffer,
                optional unsigned long byteOffset, optional unsigned long length)
]
interface Float64Array {
    const long BYTES_PER_ELEMENT = 8;

    readonly attribute unsigned long length;

    getter unrestricted double get(unsigned long index);
    setter void set(unsigned long index, unrestricted double value);
    void set(Float64Array array, optional unsigned long offset);
    void set(unrestricted double[] array, optional unsigned long offset);
    Float64Array subarray(long start, long end);
};
Float64Array implements ArrayBufferView;


[
  Constructor(ArrayBuffer buffer,
              optional unsigned long byteOffset,
              optional unsigned long byteLength)
]
interface DataView {
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
    short getInt16(unsigned long byteOffset,
                   optional boolean littleEndian);
    unsigned short getUint16(unsigned long byteOffset,
                             optional boolean littleEndian);
    long getInt32(unsigned long byteOffset,
                  optional boolean littleEndian);
    unsigned long getUint32(unsigned long byteOffset,
                            optional boolean littleEndian);
    unrestricted float getFloat32(unsigned long byteOffset,
                                  optional boolean littleEndian);
    unrestricted double getFloat64(unsigned long byteOffset,
                                   optional boolean littleEndian);

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
    void setInt8(unsigned long byteOffset,
                 byte value);
    void setUint8(unsigned long byteOffset,
                  octet value);
    void setInt16(unsigned long byteOffset,
                  short value,
                  optional boolean littleEndian);
    void setUint16(unsigned long byteOffset,
                   unsigned short value,
                   optional boolean littleEndian);
    void setInt32(unsigned long byteOffset,
                  long value,
                  optional boolean littleEndian);
    void setUint32(unsigned long byteOffset,
                   unsigned long value,
                   optional boolean littleEndian);
    void setFloat32(unsigned long byteOffset,
                    unrestricted float value,
                    optional boolean littleEndian);
    void setFloat64(unsigned long byteOffset,
                    unrestricted double value,
                    optional boolean littleEndian);
};
DataView implements ArrayBufferView;