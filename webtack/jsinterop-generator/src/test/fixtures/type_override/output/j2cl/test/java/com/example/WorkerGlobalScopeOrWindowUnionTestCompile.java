package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class WorkerGlobalScopeOrWindowUnionTestCompile {
  static WorkerGlobalScopeOrWindowUnion $typeReference$;

  public static WorkerGlobalScopeOrWindowUnion of(final WorkerGlobalScope value) {
    return WorkerGlobalScopeOrWindowUnion.of( value );
  }

  public static WorkerGlobalScopeOrWindowUnion of(final Window value) {
    return WorkerGlobalScopeOrWindowUnion.of( value );
  }

  public static boolean isWindow(final WorkerGlobalScopeOrWindowUnion $instance) {
    return $instance.isWindow();
  }

  public static Window asWindow(final WorkerGlobalScopeOrWindowUnion $instance) {
    return $instance.asWindow();
  }

  public static boolean isWorkerGlobalScope(final WorkerGlobalScopeOrWindowUnion $instance) {
    return $instance.isWorkerGlobalScope();
  }

  public static WorkerGlobalScope asWorkerGlobalScope(
      final WorkerGlobalScopeOrWindowUnion $instance) {
    return $instance.asWorkerGlobalScope();
  }
}
