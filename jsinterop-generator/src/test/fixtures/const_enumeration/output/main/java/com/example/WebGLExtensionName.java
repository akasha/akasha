package com.example;

import java.lang.annotation.Documented;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.intellij.lang.annotations.MagicConstant;

@Generated("org.realityforge.webtack")
@Documented
@MagicConstant(
    stringValues = {
        EXT_color_buffer_float.NAME,
        EXT_float_blend.NAME,
        KHR_parallel_shader_compile.NAME
    }
)
public @interface WebGLExtensionName {
  final class Validator {
    private Validator() {
    }

    @WebGLExtensionName
    @Nonnull
    public static String cast(@Nonnull final String value) {
      assertValid( value );
      return value;
    }

    public static void assertValid(@Nonnull final String value) {
      assert isValid( value ) : "@WebGLExtensionName annotated value must be one of [EXT_color_buffer_float.NAME, EXT_float_blend.NAME, KHR_parallel_shader_compile.NAME] but is " + value;
    }

    public static boolean isValid(@Nonnull final String value) {
      return EXT_color_buffer_float.NAME.equals( value ) || EXT_float_blend.NAME.equals( value ) || KHR_parallel_shader_compile.NAME.equals( value );
    }

    @Nonnull
    public static String describe(@Nonnull final String value) {
      return EXT_color_buffer_float.NAME.equals( value ) ? "NAME" : EXT_float_blend.NAME.equals( value ) ? "NAME" : KHR_parallel_shader_compile.NAME.equals( value ) ? "NAME" : "Unknown value " + value;
    }
  }
}
