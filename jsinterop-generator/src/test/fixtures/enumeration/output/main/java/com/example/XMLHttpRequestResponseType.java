package com.example;

import java.lang.annotation.Documented;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
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
  @Nonnull
  String default_text = "";

  @Nonnull
  String arraybuffer = "arraybuffer";

  @Nonnull
  String blob = "blob";

  @Nonnull
  String document = "document";

  @Nonnull
  String json = "json";

  @Nonnull
  String text = "text";

  final class Validator {
    private Validator() {
    }

    @XMLHttpRequestResponseType
    public static String requireValid(final String value) {
      assertValid( value );
      return value;
    }

    public static void assertValid(@Nonnull final String value) {
      assert isValid( value );
    }

    public static boolean isValid(@Nonnull final String value) {
      return XMLHttpRequestResponseType.default_text.equals( value ) || XMLHttpRequestResponseType.arraybuffer.equals( value ) || XMLHttpRequestResponseType.blob.equals( value ) || XMLHttpRequestResponseType.document.equals( value ) || XMLHttpRequestResponseType.json.equals( value ) || XMLHttpRequestResponseType.text.equals( value );
    }
  }
}
