package org.realityforge.webtack.jsinterop;

import com.squareup.javapoet.ClassName;
import javax.annotation.Nonnull;

final class Types
{
  @Nonnull
  static final ClassName JS_TYPE = ClassName.get( "jsinterop.annotations", "JsType" );
  @Nonnull
  static final ClassName JS_OVERLAY = ClassName.get( "jsinterop.annotations", "JsOverlay" );
  @Nonnull
  static final ClassName JS_PACKAGE = ClassName.get( "jsinterop.annotations", "JsPackage" );
  @Nonnull
  static final ClassName JS_PROPERTY = ClassName.get( "jsinterop.annotations", "JsProperty" );
  @Nonnull
  static final ClassName JS_METHOD = ClassName.get( "jsinterop.annotations", "JsMethod" );
  @Nonnull
  static final ClassName JS_FUNCTION = ClassName.get( "jsinterop.annotations", "JsFunction" );
  @Nonnull
  static final ClassName ANY = ClassName.get( "jsinterop.base", "Any" );
  @Nonnull
  static final ClassName JS = ClassName.get( "jsinterop.base", "Js" );
  @Nonnull
  static final ClassName JS_PROPERTY_MAP = ClassName.get( "jsinterop.base", "JsPropertyMap" );
  @Nonnull
  static final ClassName JS_ARRAY = ClassName.get( "elemental2.core", "JsArray" );
  @Nonnull
  static final ClassName SYMBOL = ClassName.get( "elemental2.core", "Symbol" );
  @Nonnull
  static final ClassName PROMISE = ClassName.get( "elemental2.promise", "Promise" );
  @Nonnull
  static final ClassName ARRAY_BUFFER = ClassName.get( "elemental2.core", "ArrayBuffer" );
  @Nonnull
  static final ClassName DATA_VIEW = ClassName.get( "elemental2.core", "DataView" );
  @Nonnull
  static final ClassName INT8_ARRAY = ClassName.get( "elemental2.core", "Int8Array" );
  @Nonnull
  static final ClassName INT16_ARRAY = ClassName.get( "elemental2.core", "Int16Array" );
  @Nonnull
  static final ClassName INT32_ARRAY = ClassName.get( "elemental2.core", "Int32Array" );
  @Nonnull
  static final ClassName UINT8_ARRAY = ClassName.get( "elemental2.core", "Uint8Array" );
  @Nonnull
  static final ClassName UINT16_ARRAY = ClassName.get( "elemental2.core", "Uint16Array" );
  @Nonnull
  static final ClassName UINT32_ARRAY = ClassName.get( "elemental2.core", "Uint32Array" );
  @Nonnull
  static final ClassName UINT8_CLAMPED_ARRAY = ClassName.get( "elemental2.core", "Uint8ClampedArray" );
  @Nonnull
  static final ClassName FLOAT32_ARRAY = ClassName.get( "elemental2.core", "Float32Array" );
  @Nonnull
  static final ClassName FLOAT64_ARRAY = ClassName.get( "elemental2.core", "Float64Array" );
  @Nonnull
  static final ClassName STRING = ClassName.get( String.class );
  @Nonnull
  static final ClassName NONNULL = ClassName.get( "javax.annotation", "Nonnull" );
  @Nonnull
  static final ClassName NULLABLE = ClassName.get( "javax.annotation", "Nullable" );
  @Nonnull
  static final ClassName MAGIC_CONSTANT = ClassName.get( "org.intellij.lang.annotations", "MagicConstant" );

  private Types()
  {
  }
}
