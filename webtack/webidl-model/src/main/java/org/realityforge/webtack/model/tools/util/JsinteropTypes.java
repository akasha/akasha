package org.realityforge.webtack.model.tools.util;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import javax.annotation.Nonnull;

public final class JsinteropTypes
{
  @Nonnull
  public static final ClassName JS_TYPE = ClassName.get( "jsinterop.annotations", "JsType" );
  @Nonnull
  public static final ClassName JS_OVERLAY = ClassName.get( "jsinterop.annotations", "JsOverlay" );
  @Nonnull
  public static final ClassName JS_PACKAGE = ClassName.get( "jsinterop.annotations", "JsPackage" );
  @Nonnull
  public static final ClassName JS_FUNCTION = ClassName.get( "jsinterop.annotations", "JsFunction" );
  @Nonnull
  public static final ClassName ANY = ClassName.get( "jsinterop.base", "Any" );
  @Nonnull
  public static final ClassName JS = ClassName.get( "jsinterop.base", "Js" );
  @Nonnull
  public static final ClassName JS_PROPERTY_MAP = ClassName.get( "jsinterop.base", "JsPropertyMap" );
  @Nonnull
  public static final ClassName JS_ARRAY_LIKE = ClassName.get( "jsinterop.base", "JsArrayLike" );
  @Nonnull
  public static final ParameterizedTypeName JS_PROPERTY_MAP_T_OBJECT =
    ParameterizedTypeName.get( JS_PROPERTY_MAP, TypeName.OBJECT );
  @Nonnull
  public static final ClassName JS_PROPERTY = ClassName.get( "jsinterop.annotations", "JsProperty" );
  @Nonnull
  public static final ClassName JS_METHOD = ClassName.get( "jsinterop.annotations", "JsMethod" );
  @Nonnull
  public static final ClassName DO_NOT_AUTOBOX = ClassName.get( "javaemul.internal.annotations", "DoNotAutobox" );

  private JsinteropTypes()
  {
  }
}
