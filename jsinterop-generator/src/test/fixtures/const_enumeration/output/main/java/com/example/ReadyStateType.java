package com.example;

import java.lang.annotation.Documented;
import javax.annotation.Generated;
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
  final class Validator {
    private Validator() {
    }

    public static void assertValid(final int value) {
      assert isValid( value );
    }

    public static boolean isValid(final int value) {
      return XMLHttpRequest.UNSENT == value || XMLHttpRequest.OPENED == value || XMLHttpRequest.HEADERS_RECEIVED == value || XMLHttpRequest.LOADING == value || XMLHttpRequest.DONE == value;
    }
  }
}
