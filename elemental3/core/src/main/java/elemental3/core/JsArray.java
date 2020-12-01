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
  @JsType( isNative = true, name = "?", namespace = JsPackage.GLOBAL )
  public interface EntriesJsIteratorIterableTypeParameterArrayUnionType<T>
  {
    @JsOverlay
    static <T> EntriesJsIteratorIterableTypeParameterArrayUnionType<T> of( Object o )
    {
      return Js.cast( o );
    }

    @JsOverlay
    default Double asDouble()
    {
      return Js.cast( this );
    }

    @JsOverlay
    default T asT()
    {
      return Js.cast( this );
    }

    @SuppressWarnings( "ConstantConditions" )
    @JsOverlay
    default boolean isDouble()
    {
      return (Object) this instanceof Double;
    }
  }

  @JsFunction
  public interface FilterCallbackFn<T>
  {
    Object onInvoke( T p0, int p1, JsArray<T> p2 );

    @JsOverlay
    default Object onInvoke( T p0, int p1, T[] p2 )
    {
      return onInvoke( p0, p1, Js.<JsArray<T>>uncheckedCast( p2 ) );
    }
  }

  @JsFunction
  public interface FlatMapCallbackFn<S, T>
  {
    JsArray<S> onInvoke( T p0, double p1, JsArrayLike<T> p2 );

    @JsOverlay
    default JsArray<S> onInvoke( T p0, double p1, T[] p2 )
    {
      return onInvoke( p0, p1, Js.<JsArrayLike<T>>uncheckedCast( p2 ) );
    }
  }

  @JsType( isNative = true, name = "?", namespace = JsPackage.GLOBAL )
  public interface FromArrayLikeUnionType<T>
  {
    @JsOverlay
    static <T> FromArrayLikeUnionType<T> of( Object o )
    {
      return Js.cast( o );
    }

    @JsOverlay
    default JsArrayLike<T> asJsArrayLike()
    {
      return Js.cast( this );
    }

    @JsOverlay
    default JsIterable<T> asJsIterable()
    {
      return Js.cast( this );
    }

    @JsOverlay
    default String asString()
    {
      return Js.asString( this );
    }

    @SuppressWarnings( "ConstantConditions" )
    @JsOverlay
    default boolean isString()
    {
      return (Object) this instanceof String;
    }
  }

  @JsFunction
  public interface FromMapFn<T, R>
  {
    @JsType( isNative = true, name = "?", namespace = JsPackage.GLOBAL )
    interface P0UnionType<T>
    {
      @JsOverlay
      static <T> P0UnionType<T> of( Object o )
      {
        return Js.cast( o );
      }

      @JsOverlay
      default String asString()
      {
        return Js.asString( this );
      }

      @JsOverlay
      default T asT()
      {
        return Js.cast( this );
      }

      @SuppressWarnings( "ConstantConditions" )
      @JsOverlay
      default boolean isString()
      {
        return (Object) this instanceof String;
      }
    }

    R onInvoke( P0UnionType<T> p0, int p1 );

    @JsOverlay
    default R onInvoke( String p0, int p1 )
    {
      return onInvoke( Js.<P0UnionType<T>>uncheckedCast( p0 ), p1 );
    }

    @JsOverlay
    default R onInvoke( T p0, int p1 )
    {
      return onInvoke( Js.<P0UnionType<T>>uncheckedCast( p0 ), p1 );
    }
  }

  @JsFunction
  public interface MapCallbackFn<R, T>
  {
    R onInvoke( T p0, int p1, JsArray<T> p2 );

    @JsOverlay
    default R onInvoke( T p0, int p1, T[] p2 )
    {
      return onInvoke( p0, p1, Js.<JsArray<T>>uncheckedCast( p2 ) );
    }
  }

  @JsFunction
  public interface ReduceCallbackFn<R, T>
  {
    R onInvoke( Object p0, T p1, int p2, JsArray<T> p3 );

    @JsOverlay
    default R onInvoke( Object p0, T p1, int p2, T[] p3 )
    {
      return onInvoke( p0, p1, p2, Js.<JsArray<T>>uncheckedCast( p3 ) );
    }
  }

  @JsFunction
  public interface ReduceRightCallbackFn<R, T>
  {
    R onInvoke( Object p0, T p1, int p2, JsArray<T> p3 );

    @JsOverlay
    default R onInvoke( Object p0, T p1, int p2, T[] p3 )
    {
      return onInvoke( p0, p1, p2, Js.<JsArray<T>>uncheckedCast( p3 ) );
    }
  }

  @JsFunction
  public interface SortCompareFn<T>
  {
    double onInvoke( T p0, T p1 );
  }

  @JsOverlay
  public static <T> JsArray<T> asJsArray( T[] array )
  {
    return Js.uncheckedCast( array );
  }

  public static native <T, R> JsArray<R> from( FromArrayLikeUnionType<T> arrayLike,
                                               FromMapFn<? super T, ? extends R> mapFn );

  public static native <T, R> JsArray<R> from( FromArrayLikeUnionType<T> arrayLike );

  @JsOverlay
  public static <T, R> JsArray<R> from(
    JsArrayLike<T> arrayLike, FromMapFn<? super T, ? extends R> mapFn )
  {
    return from( Js.<FromArrayLikeUnionType<T>>uncheckedCast( arrayLike ), mapFn );
  }

  @JsOverlay
  public static <T, R> JsArray<R> from( JsArrayLike<T> arrayLike )
  {
    return from( Js.<FromArrayLikeUnionType<T>>uncheckedCast( arrayLike ) );
  }

  @JsOverlay
  public static <T, R> JsArray<R> from( JsIterable<T> arrayLike, FromMapFn<? super T, ? extends R> mapFn )
  {
    return from( Js.<FromArrayLikeUnionType<T>>uncheckedCast( arrayLike ), mapFn );
  }

  @JsOverlay
  public static <T, R> JsArray<R> from( JsIterable<T> arrayLike )
  {
    return from( Js.<FromArrayLikeUnionType<T>>uncheckedCast( arrayLike ) );
  }

  @JsOverlay
  public static <T, R> JsArray<R> from( String arrayLike, FromMapFn<? super T, ? extends R> mapFn )
  {
    return from( Js.<FromArrayLikeUnionType<T>>uncheckedCast( arrayLike ), mapFn );
  }

  @JsOverlay
  public static <T, R> JsArray<R> from( String arrayLike )
  {
    return from( Js.<FromArrayLikeUnionType<T>>uncheckedCast( arrayLike ) );
  }

  @JsOverlay
  public static <T, R> JsArray<R> from( T[] arrayLike, FromMapFn<? super T, ? extends R> mapFn )
  {
    return from( Js.<JsArrayLike<T>>uncheckedCast( arrayLike ), mapFn );
  }

  @JsOverlay
  public static <T, R> JsArray<R> from( T[] arrayLike )
  {
    return from( Js.<JsArrayLike<T>>uncheckedCast( arrayLike ) );
  }

  public static native boolean isArray( Object arr );

  @SafeVarargs
  public static native <T> JsArray<T> of( T... var_args );

  public int index;
  public String input;
  public int length;

  @SafeVarargs
  public JsArray( T... items )
  {
  }

  @JsOverlay
  public final T[] asArray( T[] reference )
  {
    return ArrayStamper.stampJavaTypeInfo( this, reference );
  }

  @SafeVarargs
  public final native JsArray<T> concat( T... items );

  public native JsArray<T> copyWithin( int target, int start, int end );

  public native JsArray<T> copyWithin( int target, int start );

  public native JsIteratorIterable<JsArray<EntriesJsIteratorIterableTypeParameterArrayUnionType<T>>> entries();

  public native boolean every( @Nonnull Predicate<T> predicate );

  public native boolean every( @Nonnull Predicate2<T> predicate );

  public native boolean every( @Nonnull Predicate3<T> predicate );

  public native JsArray<T> fill( T value, int begin, int end );

  public native JsArray<T> fill( T value, int begin );

  public native JsArray<T> fill( T value );

  public native JsArray<T> filter( FilterCallbackFn<T> callback );

  @Nullable
  public native T find( @Nonnull Predicate<T> predicate );

  @Nullable
  public native T find( @Nonnull Predicate2<T> predicate );

  @Nullable
  public native T find( @Nonnull Predicate3<T> predicate );

  public native int findIndex( @Nonnull Predicate<T> predicate );

  public native int findIndex( @Nonnull Predicate2<T> predicate );

  public native int findIndex( @Nonnull Predicate3<T> predicate );

  public native <S> JsArray<S> flat();

  public native <S> JsArray<S> flat( double depth );

  public native <S> JsArray<S> flatMap( FlatMapCallbackFn<S, T> callback );

  public native void forEach( @Nonnull ForEachCallback<T> forEachCallback );

  public native void forEach( @Nonnull ForEachCallback2<T> forEachCallback );

  public native void forEach( @Nonnull ForEachCallback3<T> forEachCallback );

  public native boolean includes( @Nullable T searchElement, int fromIndex );

  public native boolean includes( @Nullable T searchElement );

  public native int indexOf( @Nonnull T obj, int fromIndex );

  public native int indexOf( @Nonnull T obj );

  @Nonnull
  public native String join();

  @Nonnull
  public native String join( @Nonnull String separator );

  @Nonnull
  public native JsIteratorIterable<Double> keys();

  public native int lastIndexOf( @Nullable T searchElement, int fromIndex );

  public native int lastIndexOf( @Nullable T searchElement );

  public native <R> JsArray<R> map( MapCallbackFn<? extends R, T> callback );

  public native T pop();

  @SafeVarargs
  public final native int push( T... var_args );

  public native <R> R reduce( ReduceCallbackFn<? extends R, T> callback, Object initialValue );

  public native <R> R reduce( ReduceCallbackFn<? extends R, T> callback );

  public native <R> R reduceRight( ReduceRightCallbackFn<? extends R, T> callback, Object initialValue );

  public native <R> R reduceRight( ReduceRightCallbackFn<? extends R, T> callback );

  public native T[] reverse();

  public native T shift();

  public native JsArray<T> slice();

  public native JsArray<T> slice( int begin, int end );

  public native JsArray<T> slice( int begin );

  public native boolean some( @Nonnull Predicate<T> predicate );

  public native boolean some( @Nonnull Predicate2<T> predicate );

  public native boolean some( @Nonnull Predicate3<T> predicate );

  public native JsArray<T> sort();

  public native JsArray<T> sort( SortCompareFn<? super T> compareFn );

  public native JsArray<T> splice();

  @SafeVarargs
  public final native JsArray<T> splice( int index, int howMany, T... var_args );

  public native JsArray<T> splice( int index );

  public native String toSource();

  @JsMethod( name = "toString" )
  public native String toString_();

  @SafeVarargs
  public final native int unshift( T... items );

  public native JsIteratorIterable<T> values();

  @JsFunction
  @FunctionalInterface
  public interface ForEachCallback<T>
  {
    void item( @Nonnull T value );
  }

  @JsFunction
  @FunctionalInterface
  public interface ForEachCallback2<T>
  {
    void item( @Nonnull T value, int key );
  }

  @JsFunction
  @FunctionalInterface
  public interface ForEachCallback3<T>
  {
    void item( @Nonnull T value, int key, @Nonnull JsArray<T> array );
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
    boolean test( T value, int key );
  }

  @JsFunction
  @FunctionalInterface
  public interface Predicate3<T>
  {
    boolean test( T value, int key, @Nonnull JsArray<T> array );
  }
}
