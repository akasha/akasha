package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class WorkerNavigatorOrNavigatorUnionTestCompile {
  public static WorkerNavigatorOrNavigatorUnion of(final WorkerNavigator value) {
    return WorkerNavigatorOrNavigatorUnion.of( value );
  }

  public static WorkerNavigatorOrNavigatorUnion of(final Navigator value) {
    return WorkerNavigatorOrNavigatorUnion.of( value );
  }

  public static boolean isNavigator(final WorkerNavigatorOrNavigatorUnion $instance) {
    return $instance.isNavigator();
  }

  public static Navigator asNavigator(final WorkerNavigatorOrNavigatorUnion $instance) {
    return $instance.asNavigator();
  }

  public static boolean isWorkerNavigator(final WorkerNavigatorOrNavigatorUnion $instance) {
    return $instance.isWorkerNavigator();
  }

  public static WorkerNavigator asWorkerNavigator(final WorkerNavigatorOrNavigatorUnion $instance) {
    return $instance.asWorkerNavigator();
  }
}
