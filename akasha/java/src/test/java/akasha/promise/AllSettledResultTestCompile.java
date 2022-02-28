package akasha.promise;

@SuppressWarnings( { "unused", "ConstantConditions" } )
public final class AllSettledResultTestCompile
{
  static AllSettledResult<?> $typeReference$;

  public static <V> String status( final AllSettledResult<V> result )
  {
    return result.status();
  }

  public static <V> V value( final AllSettledResult<V> result )
  {
    return result.value();
  }

  public static <V> Object reason( final AllSettledResult<V> result )
  {
    return result.reason();
  }
}
