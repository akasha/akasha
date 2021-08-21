package com.example;

import java.lang.annotation.Documented;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.intellij.lang.annotations.MagicConstant;

@Generated("org.realityforge.webtack")
@Documented
@MagicConstant(
    intValues = {
        XMLHttpRequest.UNSENT,
        XMLHttpRequest.OPENED,
        XMLHttpRequest.HEADERS_RECEIVED,
        XMLHttpRequest.LOADING,
        XMLHttpRequest.DONE
    }
)
public @interface ReadyStateType {
  final class Util {
    private Util() {
    }

    @ReadyStateType
    public static int requireValid(final int value) {
      assertValid( value );
      return value;
    }

    public static void assertValid(final int value) {
      assert isValid( value ) : "@ReadyStateType annotated value must be one of [XMLHttpRequest.UNSENT, XMLHttpRequest.OPENED, XMLHttpRequest.HEADERS_RECEIVED, XMLHttpRequest.LOADING, XMLHttpRequest.DONE] but is " + value;
    }

    public static boolean isValid(final int value) {
      return XMLHttpRequest.UNSENT == value || XMLHttpRequest.OPENED == value || XMLHttpRequest.HEADERS_RECEIVED == value || XMLHttpRequest.LOADING == value || XMLHttpRequest.DONE == value;
    }

    @Nonnull
    public static String describe(final int value) {
      return XMLHttpRequest.UNSENT == value ? "UNSENT" : XMLHttpRequest.OPENED == value ? "OPENED" : XMLHttpRequest.HEADERS_RECEIVED == value ? "HEADERS_RECEIVED" : XMLHttpRequest.LOADING == value ? "LOADING" : XMLHttpRequest.DONE == value ? "DONE" : "Unknown value " + value;
    }
  }
}
