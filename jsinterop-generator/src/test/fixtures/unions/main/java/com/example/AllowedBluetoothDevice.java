package com.example;

import elemental2.core.JsArray;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
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
    name = "?"
)
public interface AllowedBluetoothDevice {
  @JsOverlay
  @Nonnull
  static AllowedBluetoothDevice create(@Nonnull final StringOrStringArrayUnion allowedServices,
      @Nonnull final JsArray<StringOrLongLongUnion> requiredUuids) {
    final AllowedBluetoothDevice value = Js.uncheckedCast( JsPropertyMap.of() );
    value.setAllowedServices( allowedServices );
    value.setRequiredUuids( requiredUuids );
    return value;
  }

  @JsProperty
  @Nonnull
  StringOrStringArrayUnion getAllowedServices();

  @JsProperty
  void setAllowedServices(@Nonnull StringOrStringArrayUnion allowedServices);

  @JsOverlay
  @Nonnull
  default AllowedBluetoothDevice allowedServices(
      @Nonnull StringOrStringArrayUnion allowedServices) {
    setAllowedServices( allowedServices );
    return this;
  }

  @JsProperty
  StringOrStringArrayUnion getOtherServices();

  @JsProperty
  void setOtherServices(@Nonnull StringOrStringArrayUnion otherServices);

  @JsOverlay
  @Nonnull
  default AllowedBluetoothDevice otherServices(@Nonnull StringOrStringArrayUnion otherServices) {
    setOtherServices( otherServices );
    return this;
  }

  @JsProperty
  @Nonnull
  JsArray<StringOrLongLongUnion> getRequiredUuids();

  @JsProperty
  void setRequiredUuids(@Nonnull JsArray<StringOrLongLongUnion> requiredUuids);

  @JsOverlay
  @Nonnull
  default AllowedBluetoothDevice requiredUuids(
      @Nonnull JsArray<StringOrLongLongUnion> requiredUuids) {
    setRequiredUuids( requiredUuids );
    return this;
  }

  @JsProperty
  JsArray<StringOrOctetUnion> getUuids();

  @JsProperty
  void setUuids(@Nonnull JsArray<StringOrOctetUnion> uuids);

  @JsOverlay
  @Nonnull
  default AllowedBluetoothDevice uuids(@Nonnull JsArray<StringOrOctetUnion> uuids) {
    setUuids( uuids );
    return this;
  }
}
