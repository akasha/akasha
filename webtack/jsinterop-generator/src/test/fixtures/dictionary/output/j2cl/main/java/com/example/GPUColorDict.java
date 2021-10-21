package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

/**
 * Test to ensure that required members are not reordered.
 */
@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "GPUColorDict"
)
public interface GPUColorDict {
  @JsOverlay
  @Nonnull
  static Step1 r(final double r) {
    final GPUColorDict $gpuColorDict = Js.<GPUColorDict>uncheckedCast( JsPropertyMap.of() );
    $gpuColorDict.setR( r );
    return Js.uncheckedCast( $gpuColorDict );
  }

  @JsProperty(
      name = "r"
  )
  double r();

  @JsProperty
  void setR(double r);

  @JsProperty(
      name = "g"
  )
  double g();

  @JsProperty
  void setG(double g);

  @JsProperty(
      name = "b"
  )
  double b();

  @JsProperty
  void setB(double b);

  @JsProperty(
      name = "a"
  )
  double a();

  @JsProperty
  void setA(double a);

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "GPUColorDict"
  )
  interface Step1 {
    @JsOverlay
    @Nonnull
    default Step2 g(double g) {
      Js.<GPUColorDict>uncheckedCast( this ).setG( g );
      return Js.uncheckedCast( this );
    }
  }

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "GPUColorDict"
  )
  interface Step2 {
    @JsOverlay
    @Nonnull
    default Step3 b(double b) {
      Js.<GPUColorDict>uncheckedCast( this ).setB( b );
      return Js.uncheckedCast( this );
    }
  }

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "GPUColorDict"
  )
  interface Step3 {
    @JsOverlay
    @Nonnull
    default GPUColorDict a(double a) {
      Js.<GPUColorDict>uncheckedCast( this ).setA( a );
      return Js.uncheckedCast( this );
    }
  }
}
