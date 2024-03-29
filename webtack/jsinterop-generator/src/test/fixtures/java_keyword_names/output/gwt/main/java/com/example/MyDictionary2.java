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
    name = "Object"
)
public interface MyDictionary2 {
  @JsOverlay
  @Nonnull
  static Builder of() {
    return Js.uncheckedCast( JsPropertyMap.of() );
  }

  @JsProperty(
      name = "clone"
  )
  Object clone_();

  @JsProperty
  void setClone(@JsNonNull Object clone);

  @JsProperty(
      name = "default"
  )
  Object default_();

  @JsProperty
  void setDefault(@JsNonNull Object default_);

  @JsProperty(
      name = "equals"
  )
  Object equals_();

  @JsProperty
  void setEquals(@JsNonNull Object equals);

  @JsProperty(
      name = "finalize"
  )
  Object finalize_();

  @JsProperty
  void setFinalize(@JsNonNull Object finalize);

  @JsProperty(
      name = "getClass"
  )
  Object getClass_();

  @JsProperty
  void setGetClass(@JsNonNull Object getClass);

  @JsProperty(
      name = "hashCode"
  )
  Object hashCode_();

  @JsProperty
  void setHashCode(@JsNonNull Object hashCode);

  @JsProperty(
      name = "is"
  )
  Object _is();

  @JsProperty
  void setIs(@JsNonNull Object is);

  @JsProperty(
      name = "notify"
  )
  Object notify_();

  @JsProperty
  void setNotify(@JsNonNull Object notify);

  @JsProperty(
      name = "notifyAll"
  )
  Object notifyAll_();

  @JsProperty
  void setNotifyAll(@JsNonNull Object notifyAll);

  @JsProperty(
      name = "private"
  )
  Object private_();

  @JsProperty
  void setPrivate(@JsNonNull Object private_);

  @JsProperty(
      name = "protected"
  )
  Object protected_();

  @JsProperty
  void setProtected(@JsNonNull Object protected_);

  @JsProperty(
      name = "public"
  )
  Object public_();

  @JsProperty
  void setPublic(@JsNonNull Object public_);

  @JsProperty(
      name = "toString"
  )
  Object toString_();

  @JsProperty
  void setToString(@JsNonNull Object toString);

  @JsProperty(
      name = "wait"
  )
  Object wait_();

  @JsProperty
  void setWait(@JsNonNull Object wait);

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends MyDictionary2 {
    @JsOverlay
    @Nonnull
    default Builder clone_(@Nonnull final Object clone) {
      setClone( clone );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder default_(@Nonnull final Object default_) {
      setDefault( default_ );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder equals_(@Nonnull final Object equals) {
      setEquals( equals );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder finalize_(@Nonnull final Object finalize) {
      setFinalize( finalize );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder getClass_(@Nonnull final Object getClass) {
      setGetClass( getClass );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder hashCode_(@Nonnull final Object hashCode) {
      setHashCode( hashCode );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder is(@Nonnull final Object is) {
      setIs( is );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder notify_(@Nonnull final Object notify) {
      setNotify( notify );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder notifyAll_(@Nonnull final Object notifyAll) {
      setNotifyAll( notifyAll );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder private_(@Nonnull final Object private_) {
      setPrivate( private_ );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder protected_(@Nonnull final Object protected_) {
      setProtected( protected_ );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder public_(@Nonnull final Object public_) {
      setPublic( public_ );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder toString_(@Nonnull final Object toString) {
      setToString( toString );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder wait_(@Nonnull final Object wait) {
      setWait( wait );
      return this;
    }
  }
}
