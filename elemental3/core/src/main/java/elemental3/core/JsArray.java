package elemental3.core;

import javaemul.internal.ArrayStamper;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsArrayLike;

@JsType( name = "Array", isNative = true, namespace = JsPackage.GLOBAL )
public class JsArray<T>
  implements JsIterable<T>, JsArrayLike<T>
{
  @JsType( isNative = true, name = "Array", namespace = JsPackage.GLOBAL )
  public static final class Entry<T>
    extends JsArray<Object>
  {
    @JsOverlay
    public int key()
    {
      return getAtAsAny( 0 ).asInt();
    }

    @JsOverlay
    public T value()
    {
      return getAtAsAny( 1 ).cast();
    }
  }

  @JsOverlay
  @Nonnull
  public static <T> JsArray<T> asJsArray( @Nonnull T[] array )
  {
    return Js.uncheckedCast( array );
  }

  @Nonnull
  public static native <T, R> JsArray<R> from( @Nonnull JsArrayLike<T> arrayLike,
                                               @Nonnull Converter<? super T, ? extends R> mapFn );

  @Nonnull
  public static native <T, R> JsArray<R> from( @Nonnull JsArrayLike<T> arrayLike );

  @Nonnull
  public static native <T, R> JsArray<R> from( @Nonnull JsIterable<T> arrayLike,
                                               @Nonnull Converter<? super T, ? extends R> mapFn );

  @Nonnull
  public static native <T, R> JsArray<R> from( @Nonnull JsIterable<T> arrayLike );

  @Nonnull
  public static native <T, R> JsArray<R> from( @Nonnull T[] arrayLike,
                                               @Nonnull Converter<? super T, ? extends R> mapFn );

  @Nonnull
  public static native <T, R> JsArray<R> from( @Nonnull T[] arrayLike );

  public static native boolean isArray( @Nullable Object arr );

  @SafeVarargs
  @Nonnull
  public static native <T> JsArray<T> of( @Nonnull T... var_args );

  public int length;

  @SafeVarargs
  public JsArray( @Nonnull T... items )
  {
  }

  @JsOverlay
  public final T[] asArray( @Nonnull T[] reference )
  {
    return ArrayStamper.stampJavaTypeInfo( this, reference );
  }

  @SafeVarargs
  @Nonnull
  public final native JsArray<T> concat( @Nonnull T... items );

  @Nonnull
  public native JsArray<T> copyWithin( int target, int start, int end );

  @Nonnull
  public native JsArray<T> copyWithin( int target, int start );

  @Nonnull
  public native JsIteratorIterable<JsArray<Entry<T>>> entries();

  public native boolean every( @Nonnull Predicate<T> predicate );

  public native boolean every( @Nonnull Predicate2<T> predicate );

  public native boolean every( @Nonnull Predicate3<T> predicate );

  @Nonnull
  public native JsArray<T> fill( @Nullable T value, int begin, int end );

  @Nonnull
  public native JsArray<T> fill( @Nullable T value, int begin );

  @Nonnull
  public native JsArray<T> fill( @Nullable T value );

  @Nonnull
  public native JsArray<T> filter( @Nonnull Predicate<T> predicate );

  @Nonnull
  public native JsArray<T> filter( @Nonnull Predicate2<T> predicate );

  @Nonnull
  public native JsArray<T> filter( @Nonnull Predicate3<T> predicate );

  @Nullable
  public native T find( @Nonnull Predicate<T> predicate );

  @Nullable
  public native T find( @Nonnull Predicate2<T> predicate );

  @Nullable
  public native T find( @Nonnull Predicate3<T> predicate );

  public native int findIndex( @Nonnull Predicate<T> predicate );

  public native int findIndex( @Nonnull Predicate2<T> predicate );

  public native int findIndex( @Nonnull Predicate3<T> predicate );

  @Nonnull
  public native <S> JsArray<S> flat();

  @Nonnull
  public native <S> JsArray<S> flat( double depth );

  @Nonnull
  public native <S> JsArray<S> flatMap( @Nonnull FlatMap<S, T> callback );

  @Nonnull
  public native <S> JsArray<S> flatMap( @Nonnull FlatMap2<S, T> callback );

  @Nonnull
  public native <S> JsArray<S> flatMap( @Nonnull FlatMap3<S, T> callback );

  public native void forEach( @Nonnull ForEachCallback<T> forEachCallback );

  public native void forEach( @Nonnull ForEachCallback2<T> forEachCallback );

  public native void forEach( @Nonnull ForEachCallback3<T> forEachCallback );

  public native boolean includes( @Nullable T searchElement, int fromIndex );

  public native boolean includes( @Nullable T searchElement );

  public native int indexOf( @Nonnull T searchElement, int fromIndex );

  public native int indexOf( @Nonnull T searchElement );

  @Nonnull
  public native String join();

  @Nonnull
  public native String join( @Nonnull String separator );

  @Nonnull
  public native JsIteratorIterable<Double> keys();

  public native int lastIndexOf( @Nullable T searchElement, int fromIndex );

  public native int lastIndexOf( @Nullable T searchElement );

  @Nonnull
  public native <R> JsArray<R> map( @Nonnull Map<? extends R, T> callback );

  @Nonnull
  public native <R> JsArray<R> map( @Nonnull Map2<? extends R, T> callback );

  @Nonnull
  public native <R> JsArray<R> map( @Nonnull Map3<? extends R, T> callback );

  public native T pop();

  @SafeVarargs
  public final native int push( @Nonnull T... var_args );

  public native <R> R reduce( @Nonnull Reduce<? extends R, T> callback, R initialValue );

  public native <R> R reduce( @Nonnull Reduce2<? extends R, T> callback, R initialValue );

  public native <R> R reduce( @Nonnull Reduce3<? extends R, T> callback, R initialValue );

  public native <R> R reduce( @Nonnull Reduce<? extends R, T> callback );

  public native <R> R reduce( @Nonnull Reduce2<? extends R, T> callback );

  public native <R> R reduce( @Nonnull Reduce3<? extends R, T> callback );

  public native <R> R reduceRight( @Nonnull Reduce<? extends R, T> callback, R initialValue );

  public native <R> R reduceRight( @Nonnull Reduce2<? extends R, T> callback, R initialValue );

  public native <R> R reduceRight( @Nonnull Reduce3<? extends R, T> callback, R initialValue );

  public native <R> R reduceRight( @Nonnull Reduce<? extends R, T> callback );

  public native <R> R reduceRight( @Nonnull Reduce2<? extends R, T> callback );

  public native <R> R reduceRight( @Nonnull Reduce3<? extends R, T> callback );

  @Nonnull
  public native JsArray<T> reverse();

  public native T shift();

  @Nonnull
  public native JsArray<T> slice();

  @Nonnull
  public native JsArray<T> slice( int begin, int end );

  @Nonnull
  public native JsArray<T> slice( int begin );

  public native boolean some( @Nonnull Predicate<T> predicate );

  public native boolean some( @Nonnull Predicate2<T> predicate );

  public native boolean some( @Nonnull Predicate3<T> predicate );

  @Nonnull
  public native JsArray<T> sort();

  @Nonnull
  public native JsArray<T> sort( @Nonnull Comparator<? super T> compareFn );

  @Nonnull
  public native JsArray<T> splice();

  @SafeVarargs
  @Nonnull
  public final native JsArray<T> splice( int start, int deleteCount, @Nonnull T... items );

  @Nonnull
  public native JsArray<T> splice( int start );

  @Nonnull
  public native String toSource();

  @JsMethod( name = "toString" )
  @Nonnull
  public native String toString_();

  @SafeVarargs
  public final native int unshift( @Nonnull T... items );

  @Nonnull
  public native JsIteratorIterable<T> values();

  @JsFunction
  @FunctionalInterface
  public interface Comparator<T>
  {
    int compare( T item1, T item2 );
  }

  @JsFunction
  @FunctionalInterface
  public interface Converter<T, R>
  {
    R onInvoke( T value );
  }

  @JsFunction
  @FunctionalInterface
  public interface ForEachCallback<T>
  {
    void item( T value );
  }

  @JsFunction
  @FunctionalInterface
  public interface ForEachCallback2<T>
  {
    void item( T value, int key );
  }

  @JsFunction
  @FunctionalInterface
  public interface ForEachCallback3<T>
  {
    void item( T value, int key, @Nonnull JsArray<T> array );
  }

  @JsFunction
  @FunctionalInterface
  public interface Predicate<T>
  {
    boolean test( T value );
  }

  @JsFunction
  @FunctionalInterface
  public interface Predicate2<T>
  {
    boolean test( T value, int index );
  }

  @JsFunction
  @FunctionalInterface
  public interface Predicate3<T>
  {
    boolean test( T value, int index, @Nonnull JsArray<T> array );
  }

  @JsFunction
  @FunctionalInterface
  public interface Map<R, T>
  {
    R map( T value );
  }

  @JsFunction
  @FunctionalInterface
  public interface Map2<R, T>
  {
    R map( T value, int index );
  }

  @JsFunction
  @FunctionalInterface
  public interface Map3<R, T>
  {
    R map( T value, int index, @Nonnull JsArrayLike<T> array );
  }

  @JsFunction
  @FunctionalInterface
  public interface FlatMap<S, T>
  {
    @Nonnull
    JsArray<S> flatMap( T value );
  }

  @JsFunction
  @FunctionalInterface
  public interface FlatMap2<S, T>
  {
    @Nonnull
    JsArray<S> flatMap( T value, int index );
  }

  @JsFunction
  @FunctionalInterface
  public interface FlatMap3<S, T>
  {
    @Nonnull
    JsArray<S> flatMap( T value, int index, @Nonnull JsArrayLike<T> array );
  }

  @JsFunction
  @FunctionalInterface
  public interface Reduce<R, T>
  {
    R reduce( R accumulator, T currentValue );
  }

  @JsFunction
  @FunctionalInterface
  public interface Reduce2<R, T>
  {
    R reduce( R accumulator, T currentValue, int index );
  }

  @JsFunction
  @FunctionalInterface
  public interface Reduce3<R, T>
  {
    R reduce( R accumulator, T currentValue, int index, @Nonnull JsArray<T> p3 );
  }
}
