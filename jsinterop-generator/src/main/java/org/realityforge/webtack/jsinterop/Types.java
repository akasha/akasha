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
  static final ClassName JS_ITERATOR = ClassName.get( "elemental2.core", "JsIterator" );
  @Nonnull
  static final ClassName STRING = ClassName.get( String.class );
  @Nonnull
  static final ClassName NONNULL = ClassName.get( "javax.annotation", "Nonnull" );
  @Nonnull
  static final ClassName NULLABLE = ClassName.get( "javax.annotation", "Nullable" );
  @Nonnull
  static final ClassName DO_NOT_AUTOBOX = ClassName.get( "javaemul.internal.annotations", "DoNotAutobox" );

  private Types()
  {
  }
}
