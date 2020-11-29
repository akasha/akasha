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
  public interface EveryCallbackFn<T>
  {
    Object onInvoke( T p0, int p1, JsArray<T> p2 );

    @JsOverlay
    default Object onInvoke( T p0, int p1, T[] p2 )
    {
      return onInvoke( p0, p1, Js.<JsArray<T>>uncheckedCast( p2 ) );
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
  public interface FindIndexPredicateFn<T>
  {
    boolean onInvoke( T p0, int p1, JsArray<T> p2 );

    @JsOverlay
    default boolean onInvoke( T p0, int p1, T[] p2 )
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
  public interface SomeCallbackFn<T>
  {
    Object onInvoke( T p0, int p1, JsArray<T> p2 );

    @JsOverlay
    default Object onInvoke( T p0, int p1, T[] p2 )
    {
      return onInvoke( p0, p1, Js.<JsArray<T>>uncheckedCast( p2 ) );
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

  public static native <T, S, R> JsArray<R> from(
    FromArrayLikeUnionType<T> arrayLike,
    FromMapFn<? super T, ? extends R> mapFn,
    S this_ );

  public static native <T, R> JsArray<R> from(
    FromArrayLikeUnionType<T> arrayLike, FromMapFn<? super T, ? extends R> mapFn );

  public static native <T, R> JsArray<R> from( FromArrayLikeUnionType<T> arrayLike );

  @JsOverlay
  public static <T, S, R> JsArray<R> from(
    JsArrayLike<T> arrayLike, FromMapFn<? super T, ? extends R> mapFn, S this_ )
  {
    return from( Js.<FromArrayLikeUnionType<T>>uncheckedCast( arrayLike ), mapFn, this_ );
  }

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
  public static <T, S, R> JsArray<R> from(
    JsIterable<T> arrayLike, FromMapFn<? super T, ? extends R> mapFn, S this_ )
  {
    return from( Js.<FromArrayLikeUnionType<T>>uncheckedCast( arrayLike ), mapFn, this_ );
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
  public static <T, S, R> JsArray<R> from( String arrayLike, FromMapFn<? super T, ? extends R> mapFn, S this_ )
  {
    return from( Js.<FromArrayLikeUnionType<T>>uncheckedCast( arrayLike ), mapFn, this_ );
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
  public static <T, S, R> JsArray<R> from(
    T[] arrayLike, FromMapFn<? super T, ? extends R> mapFn, S this_ )
  {
    return from( Js.<JsArrayLike<T>>uncheckedCast( arrayLike ), mapFn, this_ );
  }

  @JsOverlay
  public static <T, R> JsArray<R> from(
    T[] arrayLike, FromMapFn<? super T, ? extends R> mapFn )
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

  public native JsIteratorIterable<
    JsArray<EntriesJsIteratorIterableTypeParameterArrayUnionType<T>>>
  entries();

  public native <S> boolean every( EveryCallbackFn<T> callback, S thisobj );

  public native boolean every( EveryCallbackFn<T> callback );

  public native JsArray<T> fill( T value, int begin, int end );

  public native JsArray<T> fill( T value, int begin );

  public native JsArray<T> fill( T value );

  public native <S> JsArray<T> filter( FilterCallbackFn<T> callback, S thisobj );

  public native JsArray<T> filter( FilterCallbackFn<T> callback );

  @Nullable
  public native T find( @Nonnull FindPredicate<T> predicateFn );

  @Nullable
  public native T find( @Nonnull FindPredicate2<T> predicateFn );

  @Nullable
  public native T find( @Nonnull FindPredicate3<T> predicateFn );

  public native <S> int findIndex( FindIndexPredicateFn<T> predicateFn, S this_ );

  public native int findIndex( FindIndexPredicateFn<T> predicateFn );

  public native <S> JsArray<S> flat();

  public native <S> JsArray<S> flat( double depth );

  public native <THIS, S> JsArray<S> flatMap(
    FlatMapCallbackFn<S, T> callback, THIS thisArg );

  public native <S> JsArray<S> flatMap( FlatMapCallbackFn<S, T> callback );

  public native void forEach( @Nonnull ForEachCallback<T> forEachCallback );

  public native void forEach( @Nonnull ForEachCallback2<T> forEachCallback );

  public native void forEach( @Nonnull ForEachCallback3<T> forEachCallback );

  public native boolean includes( T searchElement, int fromIndex );

  public native boolean includes( T searchElement );

  public native int indexOf( T obj, int fromIndex );

  public native int indexOf( T obj );

  public native String join();

  public native String join( Object separator );

  public native JsIteratorIterable<Double> keys();

  public native int lastIndexOf( T obj, int fromIndex );

  public native int lastIndexOf( T obj );

  public native <S, R> JsArray<R> map( MapCallbackFn<? extends R, T> callback, S thisobj );

  public native <R> JsArray<R> map( MapCallbackFn<? extends R, T> callback );

  public native T pop();

  @SafeVarargs
  public final native int push( T... var_args );

  public native <R> R reduce(
    ReduceCallbackFn<? extends R, T> callback, Object initialValue );

  public native <R> R reduce( ReduceCallbackFn<? extends R, T> callback );

  public native <R> R reduceRight(
    ReduceRightCallbackFn<? extends R, T> callback, Object initialValue );

  public native <R> R reduceRight( ReduceRightCallbackFn<? extends R, T> callback );

  public native T[] reverse();

  public native T shift();

  public native JsArray<T> slice();

  public native JsArray<T> slice( int begin, int end );

  public native JsArray<T> slice( int begin );

  public native <S> boolean some( SomeCallbackFn<T> callback, S thisobj );

  public native boolean some( SomeCallbackFn<T> callback );

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
  public interface FindPredicate<T>
  {
    boolean test( T value );
  }

  @JsFunction
  @FunctionalInterface
  public interface FindPredicate2<T>
  {
    boolean test( T value, int key );
  }

  @JsFunction
  @FunctionalInterface
  public interface FindPredicate3<T>
  {
    boolean test( T value, int key, @Nonnull JsArray<T> array );
  }
}
