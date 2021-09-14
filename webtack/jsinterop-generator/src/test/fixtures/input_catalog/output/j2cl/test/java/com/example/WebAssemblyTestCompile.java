package com.example;

import com.biz.MyActiveMode;
import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class WebAssemblyTestCompile {
  public static boolean validate(@TxMode final String txMode, @MyActiveMode final String mode) {
    return WebAssembly.validate( txMode, mode );
  }
}
