package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class WorkerLocationOrLocationUnionTestCompile {
  static WorkerLocationOrLocationUnion $typeReference$;

  public static WorkerLocationOrLocationUnion of(final WorkerLocation value) {
    return WorkerLocationOrLocationUnion.of( value );
  }

  public static WorkerLocationOrLocationUnion of(final Location value) {
    return WorkerLocationOrLocationUnion.of( value );
  }

  public static boolean isLocation(final WorkerLocationOrLocationUnion $instance) {
    return $instance.isLocation();
  }

  public static Location asLocation(final WorkerLocationOrLocationUnion $instance) {
    return $instance.asLocation();
  }

  public static boolean isWorkerLocation(final WorkerLocationOrLocationUnion $instance) {
    return $instance.isWorkerLocation();
  }

  public static WorkerLocation asWorkerLocation(final WorkerLocationOrLocationUnion $instance) {
    return $instance.asWorkerLocation();
  }
}
