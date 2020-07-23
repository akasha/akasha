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
  static AllowedBluetoothDevice create(@Nonnull final String allowedServices,
      @Nonnull final JsArray<StringOrLongLongUnion> requiredUuids) {
    return Js.<AllowedBluetoothDevice>uncheckedCast( JsPropertyMap.of() ).allowedServices( allowedServices ).requiredUuids( requiredUuids );
  }

  @JsOverlay
  @Nonnull
  static AllowedBluetoothDevice create(@Nonnull final JsArray<String> allowedServices,
      @Nonnull final JsArray<StringOrLongLongUnion> requiredUuids) {
    return Js.<AllowedBluetoothDevice>uncheckedCast( JsPropertyMap.of() ).allowedServices( allowedServices ).requiredUuids( requiredUuids );
  }

  @JsOverlay
  @Nonnull
  static AllowedBluetoothDevice create(@Nonnull final String[] allowedServices,
      @Nonnull final JsArray<StringOrLongLongUnion> requiredUuids) {
    return Js.<AllowedBluetoothDevice>uncheckedCast( JsPropertyMap.of() ).allowedServices( allowedServices ).requiredUuids( requiredUuids );
  }

  @JsOverlay
  @Nonnull
  static AllowedBluetoothDevice create(@Nonnull final String allowedServices,
      @Nonnull final StringOrLongLongUnion[] requiredUuids) {
    return Js.<AllowedBluetoothDevice>uncheckedCast( JsPropertyMap.of() ).allowedServices( allowedServices ).requiredUuids( requiredUuids );
  }

  @JsOverlay
  @Nonnull
  static AllowedBluetoothDevice create(@Nonnull final JsArray<String> allowedServices,
      @Nonnull final StringOrLongLongUnion[] requiredUuids) {
    return Js.<AllowedBluetoothDevice>uncheckedCast( JsPropertyMap.of() ).allowedServices( allowedServices ).requiredUuids( requiredUuids );
  }

  @JsOverlay
  @Nonnull
  static AllowedBluetoothDevice create(@Nonnull final String[] allowedServices,
      @Nonnull final StringOrLongLongUnion[] requiredUuids) {
    return Js.<AllowedBluetoothDevice>uncheckedCast( JsPropertyMap.of() ).allowedServices( allowedServices ).requiredUuids( requiredUuids );
  }

  @JsProperty
  @Nonnull
  StringOrStringArrayUnion getAllowedServices();

  @JsProperty
  void setAllowedServices(@Nonnull StringOrStringArrayUnion allowedServices);

  @JsOverlay
  default void setAllowedServices(@Nonnull final String allowedServices) {
    setAllowedServices( StringOrStringArrayUnion.of( allowedServices ) );
  }

  @JsOverlay
  @Nonnull
  default AllowedBluetoothDevice allowedServices(@Nonnull final String allowedServices) {
    setAllowedServices( allowedServices );
    return this;
  }

  @JsOverlay
  default void setAllowedServices(@Nonnull final JsArray<String> allowedServices) {
    setAllowedServices( StringOrStringArrayUnion.of( allowedServices ) );
  }

  @JsOverlay
  @Nonnull
  default AllowedBluetoothDevice allowedServices(@Nonnull final JsArray<String> allowedServices) {
    setAllowedServices( allowedServices );
    return this;
  }

  @JsOverlay
  default void setAllowedServices(@Nonnull final String... allowedServices) {
    setAllowedServices( StringOrStringArrayUnion.of( allowedServices ) );
  }

  @JsOverlay
  @Nonnull
  default AllowedBluetoothDevice allowedServices(@Nonnull final String... allowedServices) {
    setAllowedServices( allowedServices );
    return this;
  }

  @JsProperty
  StringOrStringArrayUnion getOtherServices();

  @JsProperty
  void setOtherServices(@Nonnull StringOrStringArrayUnion otherServices);

  @JsOverlay
  default void setOtherServices(@Nonnull final String otherServices) {
    setOtherServices( StringOrStringArrayUnion.of( otherServices ) );
  }

  @JsOverlay
  @Nonnull
  default AllowedBluetoothDevice otherServices(@Nonnull final String otherServices) {
    setOtherServices( otherServices );
    return this;
  }

  @JsOverlay
  default void setOtherServices(@Nonnull final JsArray<String> otherServices) {
    setOtherServices( StringOrStringArrayUnion.of( otherServices ) );
  }

  @JsOverlay
  @Nonnull
  default AllowedBluetoothDevice otherServices(@Nonnull final JsArray<String> otherServices) {
    setOtherServices( otherServices );
    return this;
  }

  @JsOverlay
  default void setOtherServices(@Nonnull final String... otherServices) {
    setOtherServices( StringOrStringArrayUnion.of( otherServices ) );
  }

  @JsOverlay
  @Nonnull
  default AllowedBluetoothDevice otherServices(@Nonnull final String... otherServices) {
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
      @Nonnull final JsArray<StringOrLongLongUnion> requiredUuids) {
    setRequiredUuids( requiredUuids );
    return this;
  }

  @JsOverlay
  default void setRequiredUuids(@Nonnull final StringOrLongLongUnion... requiredUuids) {
    setRequiredUuids( JsArray.asJsArray( requiredUuids ) );
  }

  @JsOverlay
  @Nonnull
  default AllowedBluetoothDevice requiredUuids(
      @Nonnull final StringOrLongLongUnion... requiredUuids) {
    setRequiredUuids( requiredUuids );
    return this;
  }

  @JsProperty
  JsArray<StringOrOctetUnion> getUuids();

  @JsProperty
  void setUuids(@Nonnull JsArray<StringOrOctetUnion> uuids);

  @JsOverlay
  @Nonnull
  default AllowedBluetoothDevice uuids(@Nonnull final JsArray<StringOrOctetUnion> uuids) {
    setUuids( uuids );
    return this;
  }

  @JsOverlay
  default void setUuids(@Nonnull final StringOrOctetUnion... uuids) {
    setUuids( JsArray.asJsArray( uuids ) );
  }

  @JsOverlay
  @Nonnull
  default AllowedBluetoothDevice uuids(@Nonnull final StringOrOctetUnion... uuids) {
    setUuids( uuids );
    return this;
  }
}
