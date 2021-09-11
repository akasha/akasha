package com.example;

import java.lang.annotation.Documented;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.intellij.lang.annotations.MagicConstant;

@Generated("org.realityforge.webtack")
@Documented
@MagicConstant(
    flags = {
        GPUColorWrite.RED,
        GPUColorWrite.GREEN,
        GPUColorWrite.BLUE,
        GPUColorWrite.ALPHA,
        GPUColorWrite.ALL
    }
)
public @interface GPUColorWriteFlags {
  final class Util {
    private Util() {
    }

    @GPUColorWriteFlags
    public static int requireValid(final int value) {
      assertValid( value );
      return value;
    }

    public static void assertValid(final int value) {
      assert isValid( value ) : "@GPUColorWriteFlags annotated value must be one of [GPUColorWrite.RED, GPUColorWrite.GREEN, GPUColorWrite.BLUE, GPUColorWrite.ALPHA, GPUColorWrite.ALL] but is " + value;
    }

    public static boolean isValid(final int value) {
      return GPUColorWrite.RED == value || GPUColorWrite.GREEN == value || GPUColorWrite.BLUE == value || GPUColorWrite.ALPHA == value || GPUColorWrite.ALL == value;
    }

    @Nonnull
    public static String describe(final int value) {
      return GPUColorWrite.RED == value ? "RED" : GPUColorWrite.GREEN == value ? "GREEN" : GPUColorWrite.BLUE == value ? "BLUE" : GPUColorWrite.ALPHA == value ? "ALPHA" : GPUColorWrite.ALL == value ? "ALL" : "Unknown value " + value;
    }
  }
}
