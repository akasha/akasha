package com.example;

import java.lang.annotation.Documented;
import javax.annotation.Generated;
import jsinterop.annotations.JsNonNull;
import org.intellij.lang.annotations.MagicConstant;

/**
 * This tests scenario where there is an empty enum value.
 */
@Generated("org.realityforge.webtack")
@Documented
@MagicConstant(
    valuesFromClass = XMLHttpRequestResponseType.class
)
public @interface XMLHttpRequestResponseType {
  @JsNonNull
  String default_text = "";

  @JsNonNull
  String arraybuffer = "arraybuffer";

  @JsNonNull
  String blob = "blob";

  @JsNonNull
  String document = "document";

  @JsNonNull
  String json = "json";

  @JsNonNull
  String text = "text";

  final class Util {
    private Util() {
    }

    @XMLHttpRequestResponseType
    public static String requireValid(final String value) {
      assertValid( value );
      return value;
    }

    public static void assertValid(@JsNonNull final String value) {
      assert isValid( value );
    }

    public static boolean isValid(@JsNonNull final String value) {
      return XMLHttpRequestResponseType.default_text.equals( value ) || XMLHttpRequestResponseType.arraybuffer.equals( value ) || XMLHttpRequestResponseType.blob.equals( value ) || XMLHttpRequestResponseType.document.equals( value ) || XMLHttpRequestResponseType.json.equals( value ) || XMLHttpRequestResponseType.text.equals( value );
    }
  }
}
