package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "AudioWorkletNodeOptions"
)
public interface AudioWorkletNodeOptions {
  @JsOverlay
  @Nonnull
  static Builder of() {
    return Js.uncheckedCast( JsPropertyMap.of() );
  }

  @JsProperty(
      name = "otherData1"
  )
  JsPropertyMap<Boolean> otherData1();

  @JsProperty
  void setOtherData1(@JsNonNull JsPropertyMap<Boolean> otherData1);

  @JsProperty(
      name = "otherData10"
  )
  JsPropertyMap<Double> otherData10();

  @JsProperty
  void setOtherData10(@JsNonNull JsPropertyMap<Double> otherData10);

  @JsProperty(
      name = "otherData11"
  )
  JsPropertyMap<Double> otherData11();

  @JsProperty
  void setOtherData11(@JsNonNull JsPropertyMap<Double> otherData11);

  @JsProperty(
      name = "otherData2"
  )
  JsPropertyMap<Double> otherData2();

  @JsProperty
  void setOtherData2(@JsNonNull JsPropertyMap<Double> otherData2);

  @JsProperty(
      name = "otherData3"
  )
  JsPropertyMap<Double> otherData3();

  @JsProperty
  void setOtherData3(@JsNonNull JsPropertyMap<Double> otherData3);

  @JsProperty(
      name = "otherData4"
  )
  JsPropertyMap<Double> otherData4();

  @JsProperty
  void setOtherData4(@JsNonNull JsPropertyMap<Double> otherData4);

  @JsProperty(
      name = "otherData5"
  )
  JsPropertyMap<Double> otherData5();

  @JsProperty
  void setOtherData5(@JsNonNull JsPropertyMap<Double> otherData5);

  @JsProperty(
      name = "otherData6"
  )
  JsPropertyMap<Double> otherData6();

  @JsProperty
  void setOtherData6(@JsNonNull JsPropertyMap<Double> otherData6);

  @JsProperty(
      name = "otherData7"
  )
  JsPropertyMap<Double> otherData7();

  @JsProperty
  void setOtherData7(@JsNonNull JsPropertyMap<Double> otherData7);

  @JsProperty(
      name = "otherData8"
  )
  JsPropertyMap<Double> otherData8();

  @JsProperty
  void setOtherData8(@JsNonNull JsPropertyMap<Double> otherData8);

  @JsProperty(
      name = "otherData9"
  )
  JsPropertyMap<Double> otherData9();

  @JsProperty
  void setOtherData9(@JsNonNull JsPropertyMap<Double> otherData9);

  @JsProperty(
      name = "parameterData"
  )
  JsPropertyMap<Double> parameterData();

  @JsProperty
  void setParameterData(@JsNonNull JsPropertyMap<Double> parameterData);

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "AudioWorkletNodeOptions"
  )
  interface Builder extends AudioWorkletNodeOptions {
    @JsOverlay
    @Nonnull
    default Builder otherData1(@Nonnull final JsPropertyMap<Boolean> otherData1) {
      setOtherData1( otherData1 );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder otherData10(@Nonnull final JsPropertyMap<Double> otherData10) {
      setOtherData10( otherData10 );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder otherData11(@Nonnull final JsPropertyMap<Double> otherData11) {
      setOtherData11( otherData11 );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder otherData2(@Nonnull final JsPropertyMap<Double> otherData2) {
      setOtherData2( otherData2 );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder otherData3(@Nonnull final JsPropertyMap<Double> otherData3) {
      setOtherData3( otherData3 );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder otherData4(@Nonnull final JsPropertyMap<Double> otherData4) {
      setOtherData4( otherData4 );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder otherData5(@Nonnull final JsPropertyMap<Double> otherData5) {
      setOtherData5( otherData5 );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder otherData6(@Nonnull final JsPropertyMap<Double> otherData6) {
      setOtherData6( otherData6 );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder otherData7(@Nonnull final JsPropertyMap<Double> otherData7) {
      setOtherData7( otherData7 );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder otherData8(@Nonnull final JsPropertyMap<Double> otherData8) {
      setOtherData8( otherData8 );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder otherData9(@Nonnull final JsPropertyMap<Double> otherData9) {
      setOtherData9( otherData9 );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder parameterData(@Nonnull final JsPropertyMap<Double> parameterData) {
      setParameterData( parameterData );
      return this;
    }
  }
}
