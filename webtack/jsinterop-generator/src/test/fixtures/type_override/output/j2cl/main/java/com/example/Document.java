package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsNullable;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "Document"
)
public class Document {
  protected Document() {
  }

  @JsOverlay
  @JsNonNull
  public final Document open(@Nonnull final String unused1, @Nonnull final String unused2) {
    return Js.uncheckedCast( _open( unused1, unused2 ) );
  }

  @JsMethod(
      name = "open"
  )
  @JsNonNull
  private native DocumentOrWindowUnion _open(@Nonnull String unused1, @Nonnull String unused2);

  @JsOverlay
  @JsNonNull
  public final Document open(@Nonnull final String unused1) {
    return Js.uncheckedCast( _open( unused1 ) );
  }

  @JsMethod(
      name = "open"
  )
  @JsNonNull
  private native DocumentOrWindowUnion _open(@Nonnull String unused1);

  @JsOverlay
  @JsNonNull
  public final Document open() {
    return Js.uncheckedCast( _open() );
  }

  @JsMethod(
      name = "open"
  )
  @JsNonNull
  private native DocumentOrWindowUnion _open();

  @JsOverlay
  @JsNullable
  public final Window open(@Nonnull final String url, @Nonnull final String name,
      @Nonnull final String features) {
    return Js.uncheckedCast( _open( url, name, features ) );
  }

  @JsMethod(
      name = "open"
  )
  @JsNullable
  private native DocumentOrWindowUnion _open(@Nonnull String url, @Nonnull String name,
      @Nonnull String features);
}
