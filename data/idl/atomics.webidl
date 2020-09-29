typedef ( Int8Array or Int16Array or Int32Array or Uint8Array or Uint16Array or Uint32Array or Uint8ClampedArray ) IntegerTypedArray;

/**
 * The result of waiting on a value.
 */
enum AtomicWaitResult {
  "ok",
  "not-equal",
  "timed-out"
};

/**
 * The Atomics object provides atomic operations as static methods. They are used with SharedArrayBuffer and ArrayBuffer objects.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Atomics">Atomics - MDN</a>
 * @see <a href="https://tc39.es/ecma262/#sec-atomics-object">Atomics - ECMA</a>
 */
namespace Atomics {

  // We could tighten up the types of these operations so that a Int16Array returns a short
  // and accepts a short value but the juice does not seem worth the squeeze atm

  /**
   * Add the provided value to the existing value at the specified index of the array.
   *
   * @param typedArray the typed array.
   * @param index      the position in the typed array.
   * @param value      the number to add.
   * @return the old value at the position.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Atomics/add">Atomics.add() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-atomics.add">Atomics.add() - ECMA</a>
   */
  long long add( IntegerTypedArray typedArray, long index, long long value );

  /**
   * Computes a bitwise AND on the value at the specified index of the array with the provided value.
   *
   * @param typedArray the typed array.
   * @param index      the position in the typed array.
   * @param value      the number to compute the bitwise AND with.
   * @return the old value at the position.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Atomics/and">Atomics.and() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-atomics.and">Atomics.and() - ECMA</a>
   */
  long long and( IntegerTypedArray typedArray, long index, long long value );

  /**
   * Stores a value at the specified index of the array, if it equals a value.
   *
   * @param typedArray the typed array.
   * @param index      the position in the typed array.
   * @param expectedValue    the value to check for equality.
   * @param replacementValue the number to exchange.
   * @return the old value at the position.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Atomics/compareExchange">Atomics.compareExchange - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-atomics.compareExchange">Atomics.compareExchange() - ECMA</a>
   */
  long long compareExchange( IntegerTypedArray typedArray, long index, long long expectedValue, long long replacementValue );

  /**
   * Stores a value at the specified index of the array.
   *
   * @param typedArray the typed array.
   * @param index      the position in the typed array.
   * @param value      the number to exchange.
   * @return the old value at the position.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Atomics/exchange">Atomics.exchange() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-atomics.exchange">Atomics.exchange() - ECMA</a>
   */
  long long exchange( IntegerTypedArray typedArray, long index, long long value );

  /**
   * An optimization primitive that can be used to determine whether to use locks or atomic operations.
   *
   * @param size the size in bytes to check.
   * @return true if an atomic operation on arrays of the given element size will be implemented using a hardware atomic operation (as opposed to a lock).
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Atomics/isLockFree">MDN - Atomics.isLockFree</a>
   * @see <a href="https://tc39.es/ecma262/#sec-atomics.isLockFree">Atomics.isLockFree() - ECMA</a>
   */
  long long isLockFree( long size );

  /**
   * Returns the value at the specified index of the array.
   *
   * @param typedArray the typed array.
   * @param index      the position in the typed array.
   * @return the value at the index
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Atomics/load">Atomics.load() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-atomics.load">Atomics.load() - ECMA</a>
   */
  long long load( IntegerTypedArray typedArray, long index );

  /**
   * Computes a bitwise OR on the value at the specified index of the array with the provided value.
   *
   * @param typedArray the typed array.
   * @param index      the position in the typed array.
   * @param value      the number to compute the bitwise OR with.
   * @return the old value at the position.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Atomics/or">Atomics.or() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-atomics.or">Atomics.or() - ECMA</a>
   */
  long long or( IntegerTypedArray typedArray, long index, long long value );

  /**
   * Stores a value at the specified index of the array.
   *
   * @param typedArray the typed array.
   * @param index      the position in the typed array.
   * @param value      the number to store.
   * @return value that has been stored.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Atomics/store">Atomics.store() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-atomics.store">Atomics.store() - ECMA</a>
   */
  long long store( IntegerTypedArray typedArray, long index, long long value );

 /**
   * Subtracts a value at the specified index of the array.
   *
   * @param typedArray the typed array.
   * @param index      the position in the typed array.
   * @param value      the number to subtract.
   * @return the old value at the position.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Atomics/sub">Atomics.sub() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-atomics.sub">Atomics.sub() - ECMA</a>
   */
  long long sub( IntegerTypedArray typedArray, long index, long long value );

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
  AtomicWaitResult wait( IntegerTypedArray typedArray, long index, long long value, optional long long timeout = Infinity );

  /**
   * Computes a bitwise XOR on the value at the specified index of the array with the provided value.
   *
   * @param typedArray the typed array.
   * @param index      the position in the typed array.
   * @param value      the number to compute the bitwise XOR with.
   * @return the old value at the position.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Atomics/xor">Atomics.xor() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-atomics.xor">Atomics.xor() - ECMA</a>
   */
  long long xor( IntegerTypedArray typedArray, long index, long long value );
};

