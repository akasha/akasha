package com.example;

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
public interface MyDictionary1 {
  @JsOverlay
  @Nonnull
  static MyDictionary1 create(@Nonnull final Object clone, @Nonnull final Object default_,
      @Nonnull final Object equals, @Nonnull final Object finalize, @Nonnull final Object getClass,
      @Nonnull final Object hashCode, @Nonnull final Object is, @Nonnull final Object notify,
      @Nonnull final Object notifyAll, @Nonnull final Object private_,
      @Nonnull final Object protected_, @Nonnull final Object public_,
      @Nonnull final Object toString, @Nonnull final Object wait) {
    return Js.<MyDictionary1>uncheckedCast( JsPropertyMap.of() ).clone_( clone ).default_( default_ ).equals_( equals ).finalize_( finalize ).getClass_( getClass ).hashCode_( hashCode ).is( is ).notify_( notify ).notifyAll_( notifyAll ).private_( private_ ).protected_( protected_ ).public_( public_ ).toString_( toString ).wait_( wait );
  }

  @JsProperty(
      name = "clone"
  )
  @Nonnull
  Object clone_();

  @JsProperty
  void setClone(@Nonnull Object clone);

  @JsOverlay
  @Nonnull
  default MyDictionary1 clone_(@Nonnull final Object clone) {
    setClone( clone );
    return this;
  }

  @JsProperty(
      name = "default"
  )
  @Nonnull
  Object default_();

  @JsProperty
  void setDefault(@Nonnull Object default_);

  @JsOverlay
  @Nonnull
  default MyDictionary1 default_(@Nonnull final Object default_) {
    setDefault( default_ );
    return this;
  }

  @JsProperty(
      name = "equals"
  )
  @Nonnull
  Object equals_();

  @JsProperty
  void setEquals(@Nonnull Object equals);

  @JsOverlay
  @Nonnull
  default MyDictionary1 equals_(@Nonnull final Object equals) {
    setEquals( equals );
    return this;
  }

  @JsProperty(
      name = "finalize"
  )
  @Nonnull
  Object finalize_();

  @JsProperty
  void setFinalize(@Nonnull Object finalize);

  @JsOverlay
  @Nonnull
  default MyDictionary1 finalize_(@Nonnull final Object finalize) {
    setFinalize( finalize );
    return this;
  }

  @JsProperty(
      name = "getClass"
  )
  @Nonnull
  Object getClass_();

  @JsProperty
  void setGetClass(@Nonnull Object getClass);

  @JsOverlay
  @Nonnull
  default MyDictionary1 getClass_(@Nonnull final Object getClass) {
    setGetClass( getClass );
    return this;
  }

  @JsProperty(
      name = "hashCode"
  )
  @Nonnull
  Object hashCode_();

  @JsProperty
  void setHashCode(@Nonnull Object hashCode);

  @JsOverlay
  @Nonnull
  default MyDictionary1 hashCode_(@Nonnull final Object hashCode) {
    setHashCode( hashCode );
    return this;
  }

  @JsProperty(
      name = "is"
  )
  @Nonnull
  Object _is();

  @JsProperty
  void setIs(@Nonnull Object is);

  @JsOverlay
  @Nonnull
  default MyDictionary1 is(@Nonnull final Object is) {
    setIs( is );
    return this;
  }

  @JsProperty(
      name = "notify"
  )
  @Nonnull
  Object notify_();

  @JsProperty
  void setNotify(@Nonnull Object notify);

  @JsOverlay
  @Nonnull
  default MyDictionary1 notify_(@Nonnull final Object notify) {
    setNotify( notify );
    return this;
  }

  @JsProperty(
      name = "notifyAll"
  )
  @Nonnull
  Object notifyAll_();

  @JsProperty
  void setNotifyAll(@Nonnull Object notifyAll);

  @JsOverlay
  @Nonnull
  default MyDictionary1 notifyAll_(@Nonnull final Object notifyAll) {
    setNotifyAll( notifyAll );
    return this;
  }

  @JsProperty(
      name = "private"
  )
  @Nonnull
  Object private_();

  @JsProperty
  void setPrivate(@Nonnull Object private_);

  @JsOverlay
  @Nonnull
  default MyDictionary1 private_(@Nonnull final Object private_) {
    setPrivate( private_ );
    return this;
  }

  @JsProperty(
      name = "protected"
  )
  @Nonnull
  Object protected_();

  @JsProperty
  void setProtected(@Nonnull Object protected_);

  @JsOverlay
  @Nonnull
  default MyDictionary1 protected_(@Nonnull final Object protected_) {
    setProtected( protected_ );
    return this;
  }

  @JsProperty(
      name = "public"
  )
  @Nonnull
  Object public_();

  @JsProperty
  void setPublic(@Nonnull Object public_);

  @JsOverlay
  @Nonnull
  default MyDictionary1 public_(@Nonnull final Object public_) {
    setPublic( public_ );
    return this;
  }

  @JsProperty(
      name = "toString"
  )
  @Nonnull
  Object toString_();

  @JsProperty
  void setToString(@Nonnull Object toString);

  @JsOverlay
  @Nonnull
  default MyDictionary1 toString_(@Nonnull final Object toString) {
    setToString( toString );
    return this;
  }

  @JsProperty(
      name = "wait"
  )
  @Nonnull
  Object wait_();

  @JsProperty
  void setWait(@Nonnull Object wait);

  @JsOverlay
  @Nonnull
  default MyDictionary1 wait_(@Nonnull final Object wait) {
    setWait( wait );
    return this;
  }
}
