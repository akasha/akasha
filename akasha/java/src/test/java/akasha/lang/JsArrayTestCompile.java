package akasha.lang;

import jsinterop.base.JsArrayLike;

@SuppressWarnings( { "unchecked", "unused", "ConstantConditions" } )
public final class JsArrayTestCompile
{
  static JsArray<?> $typeReference$;

  public static <T> int key( final JsArray.Entry<T> $instance )
  {
    return $instance.key();
  }

  public static <T> T value( final JsArray.Entry<T> $instance )
  {
    return $instance.value();
  }

  public static <T> JsArray<T> asJsArray( final JsArray<T> $instance, final T[] array )
  {
    return JsArray.asJsArray( array );
  }

  public static <T, R> JsArray<R> from( final JsArray<T> $instance, final JsArrayLike<T> arrayLike,
                                        final JsArray.Converter<? super T, ? extends R> mapFn )
  {
    return JsArray.from( arrayLike, mapFn );
  }

  public static <T, R> JsArray<R> from( final JsArray<T> $instance, final JsArrayLike<T> arrayLike )
  {
    return JsArray.from( arrayLike );
  }

  public static <T, R> JsArray<R> from( final JsArray<T> $instance, final JsIterable<T> arrayLike,
                                        final JsArray.Converter<? super T, ? extends R> mapFn )
  {
    return JsArray.from( arrayLike, mapFn );
  }

  public static <T, R> JsArray<R> from( final JsArray<T> $instance, final JsIterable<T> arrayLike )
  {
    return JsArray.from( arrayLike );
  }

  public static <T, R> JsArray<R> from( final JsArray<T> $instance, final T[] arrayLike,
                                        final JsArray.Converter<? super T, ? extends R> mapFn )
  {
    return JsArray.from( arrayLike, mapFn );
  }

  public static <T, R> JsArray<R> from( final JsArray<T> $instance, final T[] arrayLike )
  {
    return JsArray.from( arrayLike );
  }

  public static boolean isArray( final Object value )
  {
    return JsArray.isArray( value );
  }

  public static <T> JsArray<T> of( final JsArray<T> $instance, final T... var_args )
  {
    return JsArray.of( var_args );
  }

  public static <T> int length( final JsArray<T> $instance, final int length )
  {
    final int initialLength = $instance.length;
    $instance.length = length;
    return initialLength;
  }

  public static <T> JsArray<T> JsArray()
  {
    return new JsArray<>();
  }

  public static <T> JsArray<T> JsArray( final JsArray<T> $instance, final T... items )
  {
    return new JsArray<>( items );
  }

  public static <T> void delete( final JsArray<T> $instance, final int index )
  {
    $instance.delete( index );
  }

  public static <T> void forEach( final JsArray<T> $instance, final JsArray.ForEachCallback<T> forEachCallback )
  {
    $instance.forEach( forEachCallback );
  }

  public static <T> void forEach( final JsArray<T> $instance, final JsArray.ForEachCallback2<T> forEachCallback )
  {
    $instance.forEach( forEachCallback );
  }

  public static <T> void forEach( final JsArray<T> $instance, final JsArray.ForEachCallback3<T> forEachCallback )
  {
    $instance.forEach( forEachCallback );
  }

  public static <T> JsIteratorIterable<JsArray<JsArray.Entry<T>>> entries( final JsArray<T> $instance )
  {
    return $instance.entries();
  }

  public static <T> JsIteratorIterable<Double> keys( final JsArray<T> $instance )
  {
    return $instance.keys();
  }

  public static <T> JsIteratorIterable<T> values( final JsArray<T> $instance )
  {
    return $instance.values();
  }

  public static <T> T[] asArray( final JsArray<T> $instance, final T[] reference )
  {
    return $instance.asArray( reference );
  }

  public static <T> JsArray<T> concat( final JsArray<T> $instance, T... items )
  {
    return $instance.concat( items );
  }

  public static <T> JsArray<T> copyWithin( final JsArray<T> $instance,
                                           final int target,
                                           final int start,
                                           final int end )
  {
    return $instance.copyWithin( target, start, end );
  }

  public static <T> JsArray<T> copyWithin( final JsArray<T> $instance, final int target, final int start )
  {
    return $instance.copyWithin( target, start );
  }

  public static <T> boolean every( final JsArray<T> $instance, final JsArray.Predicate<T> predicate )
  {
    return $instance.every( predicate );
  }

  public static <T> boolean every( final JsArray<T> $instance, final JsArray.Predicate2<T> predicate )
  {
    return $instance.every( predicate );
  }

  public static <T> boolean every( final JsArray<T> $instance, final JsArray.Predicate3<T> predicate )
  {
    return $instance.every( predicate );
  }

  public static <T> JsArray<T> fill( final JsArray<T> $instance, final T value, final int begin, final int end )
  {
    return $instance.fill( value, begin, end );
  }

  public static <T> JsArray<T> fill( final JsArray<T> $instance, final T value, final int begin )
  {
    return $instance.fill( value, begin );
  }

  public static <T> JsArray<T> fill( final JsArray<T> $instance, final T value )
  {
    return $instance.fill( value );
  }

  public static <T> JsArray<T> filter( final JsArray<T> $instance, final JsArray.Predicate<T> predicate )
  {
    return $instance.filter( predicate );
  }

  public static <T> JsArray<T> filter( final JsArray<T> $instance, final JsArray.Predicate2<T> predicate )
  {
    return $instance.filter( predicate );
  }

  public static <T> JsArray<T> filter( final JsArray<T> $instance, final JsArray.Predicate3<T> predicate )
  {
    return $instance.filter( predicate );
  }

  public static <T> T find( final JsArray<T> $instance, final JsArray.Predicate<T> predicate )
  {
    return $instance.find( predicate );
  }

  public static <T> T find( final JsArray<T> $instance, final JsArray.Predicate2<T> predicate )
  {
    return $instance.find( predicate );
  }

  public static <T> T find( final JsArray<T> $instance, final JsArray.Predicate3<T> predicate )
  {
    return $instance.find( predicate );
  }

  public static <T> int findIndex( final JsArray<T> $instance, final JsArray.Predicate<T> predicate )
  {
    return $instance.findIndex( predicate );
  }

  public static <T> int findIndex( final JsArray<T> $instance, final JsArray.Predicate2<T> predicate )
  {
    return $instance.findIndex( predicate );
  }

  public static <T> int findIndex( final JsArray<T> $instance, final JsArray.Predicate3<T> predicate )
  {
    return $instance.findIndex( predicate );
  }

  public static <T, S> JsArray<S> flat( final JsArray<T> $instance )
  {
    return $instance.flat();
  }

  public static <T, S> JsArray<S> flat( final JsArray<T> $instance, final double depth )
  {
    return $instance.flat( depth );
  }

  public static <T, S> JsArray<S> flatMap( final JsArray<T> $instance, final JsArray.FlatMap<S, T> callback )
  {
    return $instance.flatMap( callback );
  }

  public static <T, S> JsArray<S> flatMap( final JsArray<T> $instance, final JsArray.FlatMap2<S, T> callback )
  {
    return $instance.flatMap( callback );
  }

  public static <T, S> JsArray<S> flatMap( final JsArray<T> $instance, final JsArray.FlatMap3<S, T> callback )
  {
    return $instance.flatMap( callback );
  }

  public static <T> boolean includes( final JsArray<T> $instance, final T searchElement, final int fromIndex )
  {
    return $instance.includes( searchElement, fromIndex );
  }

  public static <T> boolean includes( final JsArray<T> $instance, final T searchElement )
  {
    return $instance.includes( searchElement );
  }

  public static <T> int indexOf( final JsArray<T> $instance, final T searchElement, final int fromIndex )
  {
    return $instance.indexOf( searchElement, fromIndex );
  }

  public static <T> int indexOf( final JsArray<T> $instance, final T searchElement )
  {
    return $instance.indexOf( searchElement );
  }

  public static <T> String join( final JsArray<T> $instance, final String separator )
  {
    return $instance.join( separator );
  }

  public static <T> String join( final JsArray<T> $instance )
  {
    return $instance.join();
  }

  public static <T> int lastIndexOf( final JsArray<T> $instance, final T searchElement, final int fromIndex )
  {
    return $instance.lastIndexOf( searchElement, fromIndex );
  }

  public static <T> int lastIndexOf( final JsArray<T> $instance, final T searchElement )
  {
    return $instance.lastIndexOf( searchElement );
  }

  public static <T, R> JsArray<R> map( final JsArray<T> $instance, final JsArray.Map<? extends R, T> callback )
  {
    return $instance.map( callback );
  }

  public static <T, R> JsArray<R> map( final JsArray<T> $instance, final JsArray.Map2<? extends R, T> callback )
  {
    return $instance.map( callback );
  }

  public static <T, R> JsArray<R> map( final JsArray<T> $instance, final JsArray.Map3<? extends R, T> callback )
  {
    return $instance.map( callback );
  }

  public static <T> T pop( final JsArray<T> $instance )
  {
    return $instance.pop();
  }

  public static <T> int push( final JsArray<T> $instance, T... elements )
  {
    return $instance.push( elements );
  }

  public static <T, R> R reduce( final JsArray<T> $instance,
                                 final JsArray.Reduce<? extends R, T> reducer,
                                 final R initialValue )
  {
    return $instance.reduce( reducer, initialValue );
  }

  public static <T, R> R reduce( final JsArray<T> $instance,
                                 final JsArray.Reduce2<? extends R, T> reducer,
                                 final R initialValue )
  {
    return $instance.reduce( reducer, initialValue );
  }

  public static <T, R> R reduce( final JsArray<T> $instance,
                                 final JsArray.Reduce3<? extends R, T> reducer,
                                 final R initialValue )
  {
    return $instance.reduce( reducer, initialValue );
  }

  public static <T, R> R reduce( final JsArray<T> $instance, final JsArray.Reduce<? extends R, T> reducer )
  {
    return $instance.reduce( reducer );
  }

  public static <T, R> R reduce( final JsArray<T> $instance, final JsArray.Reduce2<? extends R, T> reducer )
  {
    return $instance.reduce( reducer );
  }

  public static <T, R> R reduce( final JsArray<T> $instance, final JsArray.Reduce3<? extends R, T> reducer )
  {
    return $instance.reduce( reducer );
  }

  public static <T, R> R reduceRight( final JsArray<T> $instance,
                                      final JsArray.Reduce<? extends R, T> reducer,
                                      final R initialValue )
  {
    return $instance.reduceRight( reducer, initialValue );
  }

  public static <T, R> R reduceRight( final JsArray<T> $instance,
                                      final JsArray.Reduce2<? extends R, T> reducer,
                                      final R initialValue )
  {
    return $instance.reduceRight( reducer, initialValue );
  }

  public static <T, R> R reduceRight( final JsArray<T> $instance,
                                      final JsArray.Reduce3<? extends R, T> reducer,
                                      final R initialValue )
  {
    return $instance.reduceRight( reducer, initialValue );
  }

  public static <T, R> R reduceRight( final JsArray<T> $instance, final JsArray.Reduce<? extends R, T> reducer )
  {
    return $instance.reduceRight( reducer );
  }

  public static <T, R> R reduceRight( final JsArray<T> $instance, final JsArray.Reduce2<? extends R, T> reducer )
  {
    return $instance.reduceRight( reducer );
  }

  public static <T, R> R reduceRight( final JsArray<T> $instance, final JsArray.Reduce3<? extends R, T> reducer )
  {
    return $instance.reduceRight( reducer );
  }

  public static <T> JsArray<T> reverse( final JsArray<T> $instance )
  {
    return $instance.reverse();
  }

  public static <T> T shift( final JsArray<T> $instance )
  {
    return $instance.shift();
  }

  public static <T> JsArray<T> slice( final JsArray<T> $instance, final int begin, final int end )
  {
    return $instance.slice( begin, end );
  }

  public static <T> JsArray<T> slice( final JsArray<T> $instance, final int begin )
  {
    return $instance.slice( begin );
  }

  public static <T> JsArray<T> slice( final JsArray<T> $instance )
  {
    return $instance.slice();
  }

  public static <T> boolean some( final JsArray<T> $instance, final JsArray.Predicate<T> predicate )
  {
    return $instance.some( predicate );
  }

  public static <T> boolean some( final JsArray<T> $instance, final JsArray.Predicate2<T> predicate )
  {
    return $instance.some( predicate );
  }

  public static <T> boolean some( final JsArray<T> $instance, final JsArray.Predicate3<T> predicate )
  {
    return $instance.some( predicate );
  }

  public static <T> JsArray<T> sort( final JsArray<T> $instance, final JsArray.Comparator<? super T> compareFunction )
  {
    return $instance.sort( compareFunction );
  }

  public static <T> JsArray<T> sort( final JsArray<T> $instance )
  {
    return $instance.sort();
  }

  public static <T> JsArray<T> splice( final JsArray<T> $instance,
                                       final int start,
                                       final int deleteCount,
                                       final T... items )
  {
    return $instance.splice( start, deleteCount, items );
  }

  public static <T> JsArray<T> splice( final JsArray<T> $instance, final int start )
  {
    return $instance.splice( start );
  }

  public static <T> String toString_( final JsArray<T> $instance )
  {
    return $instance.toString_();
  }

  public static <T> int unshift( final JsArray<T> $instance, final T... elements )
  {
    return $instance.unshift( elements );
  }
}
