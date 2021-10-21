package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class IDBIndexParametersTestCompile {
  static IDBIndexParameters $typeReference$;

  public static IDBIndexParameters.Builder of() {
    return IDBIndexParameters.of();
  }

  public static boolean multiEntry(final IDBIndexParameters $instance) {
    return $instance.multiEntry();
  }

  public static void setMultiEntry(final IDBIndexParameters $instance, boolean multiEntry) {
    $instance.setMultiEntry( multiEntry );
  }

  public static boolean unique(final IDBIndexParameters $instance) {
    return $instance.unique();
  }

  public static void setUnique(final IDBIndexParameters $instance, boolean unique) {
    $instance.setUnique( unique );
  }

  public static IDBIndexParameters.Builder multiEntry(final IDBIndexParameters.Builder $instance,
      final boolean multiEntry) {
    return $instance.multiEntry( multiEntry );
  }

  public static IDBIndexParameters.Builder unique(final IDBIndexParameters.Builder $instance,
      final boolean unique) {
    return $instance.unique( unique );
  }
}
