package com.example;

import akasha.lang.JsArray;
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
    name = "Object"
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

  @JsProperty(
      name = "allowedServices"
  )
  @Nonnull
  StringOrStringArrayUnion allowedServices();

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

  @JsProperty(
      name = "otherServices"
  )
  StringOrStringArrayUnion otherServices();

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

  @JsProperty(
      name = "requiredUuids"
  )
  @Nonnull
  JsArray<StringOrLongLongUnion> requiredUuids();

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
    setRequiredUuids( Js.<JsArray<StringOrLongLongUnion>>uncheckedCast( requiredUuids ) );
  }

  @JsOverlay
  @Nonnull
  default AllowedBluetoothDevice requiredUuids(
      @Nonnull final StringOrLongLongUnion... requiredUuids) {
    setRequiredUuids( requiredUuids );
    return this;
  }

  @JsProperty(
      name = "uuids"
  )
  JsArray<StringOrOctetUnion> uuids();

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
    setUuids( Js.<JsArray<StringOrOctetUnion>>uncheckedCast( uuids ) );
  }

  @JsOverlay
  @Nonnull
  default AllowedBluetoothDevice uuids(@Nonnull final StringOrOctetUnion... uuids) {
    setUuids( uuids );
    return this;
  }
}
