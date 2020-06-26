package com.example;

import javax.annotation.Generated;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "?"
)
public class StorageEventInit extends EventInit {
  public String key;

  public String newValue;

  public String oldValue;

  public Storage storageArea;

  public String url;
}
