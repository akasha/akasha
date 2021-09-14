package com.example;

import com.example.web_assembly.Module;
import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class WebAssemblyTestCompile {
  public static JsPromise<Module> compile(final ArrayBuffer bytes) {
    return WebAssembly.compile( bytes );
  }
}
