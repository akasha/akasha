// Patched Atomics.wait to align with types in current release of closure compiler.
// A PR has been submitted upstream at https://github.com/google/closure-compiler/pull/3820
// and as soon as this has been accepted and release we should remove this patch and the corresponding
// pipeline stage to remove original
partial namespace Atomics {
 /**
   * Verifies that the specified index of the array still contains a value and sleeps awaiting or times out.
   * Returns either "ok", "not-equal", or "timed-out".
   * If waiting is not allowed in the calling agent then it throws an Error exception. Most browsers will not
   * allow wait() on the browser's main thread.
   *
   * @param typedArray the typed array.
   * @param index      the position in the typed array.
   * @param value      the expected value to test.
   * @param timeout    the time to wait in milliseconds
   * @return the result state.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Atomics/wait">Atomics.wait() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-atomics.wait">Atomics.wait() - ECMA</a>
   */
  String wait( IntegerTypedArray typedArray, long index, long long value, optional long long timeout = Infinity );
};

// Patched Date.UTC to align with optionality in current release of closure compiler.
// A PR has been submitted upstream at https://github.com/google/closure-compiler/pull/3819
// and as soon as this has been accepted and release we should remove this patch and the corresponding
// pipeline stage to remove original
partial interface Date {
  static Timestamp UTC(long year, long month, optional long date = 0, optional long hours = 0, optional long minute = 0, optional long second = 0, optional long ms = 0 );
};

// Patched SharedArrayBuffer.slice to align with optionality in current release of closure compiler.
// A PR has been submitted upstream at https://github.com/google/closure-compiler/pull/3814
// and as soon as this has been accepted and release we should remove this patch and the corresponding
// pipeline stage to remove original
partial interface SharedArrayBuffer {
  /**
   * The SharedArrayBuffer.prototype.slice() method returns a new SharedArrayBuffer whose contents are a copy of this SharedArrayBuffer's bytes from begin, inclusive, up to end, exclusive. If either begin or end is negative, it refers to an index from the end of the array, as opposed to from the beginning. This method has the same algorithm as Array.prototype.slice().
   *
   * @param begin Zero-based index at which to begin extraction. A negative index can be used, indicating an offset from the end of the sequence. slice(-2) extracts the last two elements in the sequence. If begin is undefined, slice begins from index 0.
   * @param end Zero-based index before which to end extraction. slice extracts up to but not including end. For example, slice(1,4) extracts the second element through the fourth element (elements indexed 1, 2, and 3). A negative index can be used, indicating an offset from the end of the sequence. slice(2,-1) extracts the third element through the second-to-last element in the sequence. If end is omitted, slice extracts through the end of the sequence (sab.byteLength).
   * @return A new SharedArrayBuffer containing the extracted elements.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/SharedArrayBuffer/slice">SharedArrayBuffer.slice - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-sharedarraybuffer.prototype.slice">SharedArrayBuffer.slice - ECMA</a>
   */
  SharedArrayBuffer slice(long long begin, optional long long end = 0);
};
