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
    name = "AllowedBluetoothDevice"
)
public interface AllowedBluetoothDevice {
  @JsOverlay
  @Nonnull
  static Step1 allowedServices(@Nonnull final String allowedServices) {
    final Builder $allowedBluetoothDevice = Js.<Builder>uncheckedCast( JsPropertyMap.of() );
    $allowedBluetoothDevice.setAllowedServices( allowedServices );
    return Js.uncheckedCast( $allowedBluetoothDevice );
  }

  @JsOverlay
  @Nonnull
  static Step1 allowedServices(@Nonnull final JsArray<String> allowedServices) {
    final Builder $allowedBluetoothDevice = Js.<Builder>uncheckedCast( JsPropertyMap.of() );
    $allowedBluetoothDevice.setAllowedServices( allowedServices );
    return Js.uncheckedCast( $allowedBluetoothDevice );
  }

  @JsOverlay
  @Nonnull
  static Step1 allowedServices(@Nonnull final String... allowedServices) {
    final Builder $allowedBluetoothDevice = Js.<Builder>uncheckedCast( JsPropertyMap.of() );
    $allowedBluetoothDevice.setAllowedServices( allowedServices );
    return Js.uncheckedCast( $allowedBluetoothDevice );
  }

  @JsProperty(
      name = "allowedServices"
  )
  @JsNonNull
  StringOrStringArrayUnion allowedServices();

  @JsProperty
  void setAllowedServices(@JsNonNull StringOrStringArrayUnion allowedServices);

  @JsOverlay
  default void setAllowedServices(@Nonnull final String allowedServices) {
    setAllowedServices( StringOrStringArrayUnion.of( allowedServices ) );
  }

  @JsOverlay
  default void setAllowedServices(@Nonnull final JsArray<String> allowedServices) {
    setAllowedServices( StringOrStringArrayUnion.of( allowedServices ) );
  }

  @JsOverlay
  default void setAllowedServices(@Nonnull final String... allowedServices) {
    setAllowedServices( StringOrStringArrayUnion.of( allowedServices ) );
  }

  @JsProperty(
      name = "requiredUuids"
  )
  @JsNonNull
  JsArray<StringOrLongLongUnion> requiredUuids();

  @JsProperty
  void setRequiredUuids(@JsNonNull JsArray<StringOrLongLongUnion> requiredUuids);

  @JsOverlay
  default void setRequiredUuids(@Nonnull final StringOrLongLongUnion... requiredUuids) {
    setRequiredUuids( Js.<JsArray<StringOrLongLongUnion>>uncheckedCast( requiredUuids ) );
  }

  @JsProperty(
      name = "otherServices"
  )
  StringOrStringArrayUnion otherServices();

  @JsProperty
  void setOtherServices(@JsNonNull StringOrStringArrayUnion otherServices);

  @JsOverlay
  default void setOtherServices(@Nonnull final String otherServices) {
    setOtherServices( StringOrStringArrayUnion.of( otherServices ) );
  }

  @JsOverlay
  default void setOtherServices(@Nonnull final JsArray<String> otherServices) {
    setOtherServices( StringOrStringArrayUnion.of( otherServices ) );
  }

  @JsOverlay
  default void setOtherServices(@Nonnull final String... otherServices) {
    setOtherServices( StringOrStringArrayUnion.of( otherServices ) );
  }

  @JsProperty(
      name = "uuids"
  )
  JsArray<StringOrOctetUnion> uuids();

  @JsProperty
  void setUuids(@JsNonNull JsArray<StringOrOctetUnion> uuids);

  @JsOverlay
  default void setUuids(@Nonnull final StringOrOctetUnion... uuids) {
    setUuids( Js.<JsArray<StringOrOctetUnion>>uncheckedCast( uuids ) );
  }

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "AllowedBluetoothDevice"
  )
  interface Step1 {
    @JsOverlay
    @Nonnull
    default Builder requiredUuids(@Nonnull JsArray<StringOrLongLongUnion> requiredUuids) {
      Js.<AllowedBluetoothDevice>uncheckedCast( this ).setRequiredUuids( requiredUuids );
      return Js.uncheckedCast( this );
    }

    @JsOverlay
    @Nonnull
    default Builder requiredUuids(@Nonnull StringOrLongLongUnion... requiredUuids) {
      Js.<AllowedBluetoothDevice>uncheckedCast( this ).setRequiredUuids( requiredUuids );
      return Js.uncheckedCast( this );
    }
  }

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "AllowedBluetoothDevice"
  )
  interface Builder extends AllowedBluetoothDevice {
    @JsOverlay
    @Nonnull
    default Builder otherServices(@Nonnull final String otherServices) {
      setOtherServices( otherServices );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder otherServices(@Nonnull final JsArray<String> otherServices) {
      setOtherServices( otherServices );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder otherServices(@Nonnull final String... otherServices) {
      setOtherServices( otherServices );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder uuids(@Nonnull final JsArray<StringOrOctetUnion> uuids) {
      setUuids( uuids );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder uuids(@Nonnull final StringOrOctetUnion... uuids) {
      setUuids( uuids );
      return this;
    }
  }
}
