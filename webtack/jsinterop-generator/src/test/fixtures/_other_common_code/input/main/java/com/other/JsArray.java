package com.other;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.JsArrayLike;

@JsType( name = "Array", isNative = true, namespace = JsPackage.GLOBAL )
public class JsArray<T>
  implements JsIterable<T>, JsArrayLike<T>
{
}
