package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class AllowedBluetoothDeviceTestCompile {
  static AllowedBluetoothDevice $typeReference$;

  public static AllowedBluetoothDevice.Step1 allowedServices(final String allowedServices) {
    return AllowedBluetoothDevice.allowedServices( allowedServices );
  }

  public static AllowedBluetoothDevice.Step1 allowedServices(
      final JsArray<String> allowedServices) {
    return AllowedBluetoothDevice.allowedServices( allowedServices );
  }

  public static AllowedBluetoothDevice.Step1 allowedServices(final String[] allowedServices) {
    return AllowedBluetoothDevice.allowedServices( allowedServices );
  }

  public static StringOrStringArrayUnion allowedServices(final AllowedBluetoothDevice $instance) {
    return $instance.allowedServices();
  }

  public static void setAllowedServices(final AllowedBluetoothDevice $instance,
      StringOrStringArrayUnion allowedServices) {
    $instance.setAllowedServices( allowedServices );
  }

  public static void setAllowedServices(final AllowedBluetoothDevice $instance,
      final String allowedServices) {
    $instance.setAllowedServices( allowedServices );
  }

  public static void setAllowedServices(final AllowedBluetoothDevice $instance,
      final JsArray<String> allowedServices) {
    $instance.setAllowedServices( allowedServices );
  }

  public static void setAllowedServices(final AllowedBluetoothDevice $instance,
      final String[] allowedServices) {
    $instance.setAllowedServices( allowedServices );
  }

  public static JsArray<StringOrLongLongUnion> requiredUuids(
      final AllowedBluetoothDevice $instance) {
    return $instance.requiredUuids();
  }

  public static void setRequiredUuids(final AllowedBluetoothDevice $instance,
      JsArray<StringOrLongLongUnion> requiredUuids) {
    $instance.setRequiredUuids( requiredUuids );
  }

  public static void setRequiredUuids(final AllowedBluetoothDevice $instance,
      final StringOrLongLongUnion[] requiredUuids) {
    $instance.setRequiredUuids( requiredUuids );
  }

  public static StringOrStringArrayUnion otherServices(final AllowedBluetoothDevice $instance) {
    return $instance.otherServices();
  }

  public static void setOtherServices(final AllowedBluetoothDevice $instance,
      StringOrStringArrayUnion otherServices) {
    $instance.setOtherServices( otherServices );
  }

  public static void setOtherServices(final AllowedBluetoothDevice $instance,
      final String otherServices) {
    $instance.setOtherServices( otherServices );
  }

  public static void setOtherServices(final AllowedBluetoothDevice $instance,
      final JsArray<String> otherServices) {
    $instance.setOtherServices( otherServices );
  }

  public static void setOtherServices(final AllowedBluetoothDevice $instance,
      final String[] otherServices) {
    $instance.setOtherServices( otherServices );
  }

  public static JsArray<StringOrOctetUnion> uuids(final AllowedBluetoothDevice $instance) {
    return $instance.uuids();
  }

  public static void setUuids(final AllowedBluetoothDevice $instance,
      JsArray<StringOrOctetUnion> uuids) {
    $instance.setUuids( uuids );
  }

  public static void setUuids(final AllowedBluetoothDevice $instance,
      final StringOrOctetUnion[] uuids) {
    $instance.setUuids( uuids );
  }

  public static AllowedBluetoothDevice.Builder otherServices(
      final AllowedBluetoothDevice.Builder $instance, final String otherServices) {
    return $instance.otherServices( otherServices );
  }

  public static AllowedBluetoothDevice.Builder otherServices(
      final AllowedBluetoothDevice.Builder $instance, final JsArray<String> otherServices) {
    return $instance.otherServices( otherServices );
  }

  public static AllowedBluetoothDevice.Builder otherServices(
      final AllowedBluetoothDevice.Builder $instance, final String[] otherServices) {
    return $instance.otherServices( otherServices );
  }

  public static AllowedBluetoothDevice.Builder uuids(final AllowedBluetoothDevice.Builder $instance,
      final JsArray<StringOrOctetUnion> uuids) {
    return $instance.uuids( uuids );
  }

  public static AllowedBluetoothDevice.Builder uuids(final AllowedBluetoothDevice.Builder $instance,
      final StringOrOctetUnion[] uuids) {
    return $instance.uuids( uuids );
  }
}
