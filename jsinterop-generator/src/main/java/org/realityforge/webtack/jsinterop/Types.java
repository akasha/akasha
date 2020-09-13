package org.realityforge.webtack.jsinterop;

import com.squareup.javapoet.ClassName;
import javax.annotation.Nonnull;

final class Types
{
  @Nonnull
  static final ClassName JS_ITERATOR = ClassName.get( "elemental2.core", "JsIterator" );

  private Types()
  {
  }
}
