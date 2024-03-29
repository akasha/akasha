package com.example.req;

import java.lang.annotation.Documented;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.intellij.lang.annotations.MagicConstant;

@Generated("org.realityforge.webtack")
@Documented
@MagicConstant(
    intValues = {
        XMLHR2.UNSENT,
        XMLHR2.OPENED,
        XMLHR2.HEADERS_RECEIVED,
        XMLHR2.LOADING,
        XMLHR2.DONE
    }
)
public @interface ReadyStateType2b {
  final class Util {
    private Util() {
    }

    @ReadyStateType2b
    public static int requireValid(final int value) {
      assertValid( value );
      return value;
    }

    public static void assertValid(final int value) {
      assert isValid( value ) : "@ReadyStateType2b annotated value must be one of [XMLHR2.UNSENT, XMLHR2.OPENED, XMLHR2.HEADERS_RECEIVED, XMLHR2.LOADING, XMLHR2.DONE] but is " + value;
    }

    public static boolean isValid(final int value) {
      return XMLHR2.UNSENT == value || XMLHR2.OPENED == value || XMLHR2.HEADERS_RECEIVED == value || XMLHR2.LOADING == value || XMLHR2.DONE == value;
    }

    @Nonnull
    public static String describe(final int value) {
      return XMLHR2.UNSENT == value ? "UNSENT" : XMLHR2.OPENED == value ? "OPENED" : XMLHR2.HEADERS_RECEIVED == value ? "HEADERS_RECEIVED" : XMLHR2.LOADING == value ? "LOADING" : XMLHR2.DONE == value ? "DONE" : "Unknown value " + value;
    }
  }
}
