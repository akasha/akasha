package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class ServiceWorkerGlobalScopeGlobalTestCompile {
  public static ExtendableMessageEventHandler onmessage() {
    return ServiceWorkerGlobalScopeGlobal.onmessage();
  }

  public static void onmessage(final ExtendableMessageEventHandler value) {
    ServiceWorkerGlobalScopeGlobal.setOnmessage( value );
  }

  public static WorkerLocation location() {
    return ServiceWorkerGlobalScopeGlobal.location();
  }

  public static WorkerNavigator navigator() {
    return ServiceWorkerGlobalScopeGlobal.navigator();
  }

  public static WorkerGlobalScope self() {
    return ServiceWorkerGlobalScopeGlobal.self();
  }
}
