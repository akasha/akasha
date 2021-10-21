package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class IDBIndexParameters2TestCompile {
  static IDBIndexParameters2 $typeReference$;

  public static IDBIndexParameters2.Builder of() {
    return IDBIndexParameters2.of();
  }

  public static boolean multiEntry(final IDBIndexParameters2 $instance) {
    return $instance.multiEntry();
  }

  public static void setMultiEntry(final IDBIndexParameters2 $instance, boolean multiEntry) {
    $instance.setMultiEntry( multiEntry );
  }

  public static boolean unique(final IDBIndexParameters2 $instance) {
    return $instance.unique();
  }

  public static void setUnique(final IDBIndexParameters2 $instance, boolean unique) {
    $instance.setUnique( unique );
  }

  public static IDBIndexParameters2.Builder multiEntry(final IDBIndexParameters2.Builder $instance,
      final boolean multiEntry) {
    return $instance.multiEntry( multiEntry );
  }

  public static IDBIndexParameters2.Builder unique(final IDBIndexParameters2.Builder $instance,
      final boolean unique) {
    return $instance.unique( unique );
  }
}
