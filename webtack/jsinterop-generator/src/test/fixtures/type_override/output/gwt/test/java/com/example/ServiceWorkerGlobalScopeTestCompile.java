package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class ServiceWorkerGlobalScopeTestCompile {
  static ServiceWorkerGlobalScope $typeReference$;

  public static ExtendableMessageEventHandler onmessage(final ServiceWorkerGlobalScope type) {
    return type.onmessage;
  }

  public static void onmessage(final ServiceWorkerGlobalScope type,
      final ExtendableMessageEventHandler value) {
    type.onmessage = value;
  }
}
