package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class ExtendableMessageEventHandlerOrMessageEventHandlerUnionTestCompile {
  @SuppressWarnings("overloads")
  public static ExtendableMessageEventHandlerOrMessageEventHandlerUnion of(
      final ExtendableMessageEventHandler value) {
    return ExtendableMessageEventHandlerOrMessageEventHandlerUnion.of( value );
  }

  @SuppressWarnings("overloads")
  public static ExtendableMessageEventHandlerOrMessageEventHandlerUnion of(
      final MessageEventHandler value) {
    return ExtendableMessageEventHandlerOrMessageEventHandlerUnion.of( value );
  }

  public static boolean isExtendableMessageEventHandler(
      final ExtendableMessageEventHandlerOrMessageEventHandlerUnion $instance) {
    return $instance.isExtendableMessageEventHandler();
  }

  public static ExtendableMessageEventHandler asExtendableMessageEventHandler(
      final ExtendableMessageEventHandlerOrMessageEventHandlerUnion $instance) {
    return $instance.asExtendableMessageEventHandler();
  }

  public static boolean isMessageEventHandler(
      final ExtendableMessageEventHandlerOrMessageEventHandlerUnion $instance) {
    return $instance.isMessageEventHandler();
  }

  public static MessageEventHandler asMessageEventHandler(
      final ExtendableMessageEventHandlerOrMessageEventHandlerUnion $instance) {
    return $instance.asMessageEventHandler();
  }
}
