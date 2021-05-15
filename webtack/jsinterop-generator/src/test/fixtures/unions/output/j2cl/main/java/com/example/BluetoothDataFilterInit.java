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
    name = "Object"
)
public interface BluetoothDataFilterInit {
  @JsOverlay
  @Nonnull
  static Builder create(@Nonnull final BufferSource dataPrefix) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).dataPrefix( dataPrefix );
  }

  @JsOverlay
  @Nonnull
  static Builder create(@Nonnull final ArrayBufferView dataPrefix) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).dataPrefix( dataPrefix );
  }

  @JsOverlay
  @Nonnull
  static Builder create(@Nonnull final Int8Array dataPrefix) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).dataPrefix( dataPrefix );
  }

  @JsOverlay
  @Nonnull
  static Builder create(@Nonnull final Int16Array dataPrefix) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).dataPrefix( dataPrefix );
  }

  @JsOverlay
  @Nonnull
  static Builder create(@Nonnull final Int32Array dataPrefix) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).dataPrefix( dataPrefix );
  }

  @JsOverlay
  @Nonnull
  static Builder create(@Nonnull final Uint8Array dataPrefix) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).dataPrefix( dataPrefix );
  }

  @JsOverlay
  @Nonnull
  static Builder create(@Nonnull final Uint16Array dataPrefix) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).dataPrefix( dataPrefix );
  }

  @JsOverlay
  @Nonnull
  static Builder create(@Nonnull final Uint32Array dataPrefix) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).dataPrefix( dataPrefix );
  }

  @JsOverlay
  @Nonnull
  static Builder create(@Nonnull final Uint8ClampedArray dataPrefix) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).dataPrefix( dataPrefix );
  }

  @JsOverlay
  @Nonnull
  static Builder create(@Nonnull final Float32Array dataPrefix) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).dataPrefix( dataPrefix );
  }

  @JsOverlay
  @Nonnull
  static Builder create(@Nonnull final Float64Array dataPrefix) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).dataPrefix( dataPrefix );
  }

  @JsOverlay
  @Nonnull
  static Builder create(@Nonnull final DataView dataPrefix) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).dataPrefix( dataPrefix );
  }

  @JsOverlay
  @Nonnull
  static Builder create(@Nonnull final ArrayBuffer dataPrefix) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).dataPrefix( dataPrefix );
  }

  @JsProperty(
      name = "dataPrefix"
  )
  @Nonnull
  BufferSource dataPrefix();

  @JsProperty
  void setDataPrefix(@Nonnull BufferSource dataPrefix);

  @JsOverlay
  default void setDataPrefix(@Nonnull final ArrayBufferView dataPrefix) {
    setDataPrefix( BufferSource.of( dataPrefix ) );
  }

  @JsOverlay
  default void setDataPrefix(@Nonnull final Int8Array dataPrefix) {
    setDataPrefix( BufferSource.of( dataPrefix ) );
  }

  @JsOverlay
  default void setDataPrefix(@Nonnull final Int16Array dataPrefix) {
    setDataPrefix( BufferSource.of( dataPrefix ) );
  }

  @JsOverlay
  default void setDataPrefix(@Nonnull final Int32Array dataPrefix) {
    setDataPrefix( BufferSource.of( dataPrefix ) );
  }

  @JsOverlay
  default void setDataPrefix(@Nonnull final Uint8Array dataPrefix) {
    setDataPrefix( BufferSource.of( dataPrefix ) );
  }

  @JsOverlay
  default void setDataPrefix(@Nonnull final Uint16Array dataPrefix) {
    setDataPrefix( BufferSource.of( dataPrefix ) );
  }

  @JsOverlay
  default void setDataPrefix(@Nonnull final Uint32Array dataPrefix) {
    setDataPrefix( BufferSource.of( dataPrefix ) );
  }

  @JsOverlay
  default void setDataPrefix(@Nonnull final Uint8ClampedArray dataPrefix) {
    setDataPrefix( BufferSource.of( dataPrefix ) );
  }

  @JsOverlay
  default void setDataPrefix(@Nonnull final Float32Array dataPrefix) {
    setDataPrefix( BufferSource.of( dataPrefix ) );
  }

  @JsOverlay
  default void setDataPrefix(@Nonnull final Float64Array dataPrefix) {
    setDataPrefix( BufferSource.of( dataPrefix ) );
  }

  @JsOverlay
  default void setDataPrefix(@Nonnull final DataView dataPrefix) {
    setDataPrefix( BufferSource.of( dataPrefix ) );
  }

  @JsOverlay
  default void setDataPrefix(@Nonnull final ArrayBuffer dataPrefix) {
    setDataPrefix( BufferSource.of( dataPrefix ) );
  }

  @JsProperty(
      name = "mask"
  )
  BufferSource mask();

  @JsProperty
  void setMask(@Nonnull BufferSource mask);

  @JsOverlay
  default void setMask(@Nonnull final ArrayBufferView mask) {
    setMask( BufferSource.of( mask ) );
  }

  @JsOverlay
  default void setMask(@Nonnull final Int8Array mask) {
    setMask( BufferSource.of( mask ) );
  }

  @JsOverlay
  default void setMask(@Nonnull final Int16Array mask) {
    setMask( BufferSource.of( mask ) );
  }

  @JsOverlay
  default void setMask(@Nonnull final Int32Array mask) {
    setMask( BufferSource.of( mask ) );
  }

  @JsOverlay
  default void setMask(@Nonnull final Uint8Array mask) {
    setMask( BufferSource.of( mask ) );
  }

  @JsOverlay
  default void setMask(@Nonnull final Uint16Array mask) {
    setMask( BufferSource.of( mask ) );
  }

  @JsOverlay
  default void setMask(@Nonnull final Uint32Array mask) {
    setMask( BufferSource.of( mask ) );
  }

  @JsOverlay
  default void setMask(@Nonnull final Uint8ClampedArray mask) {
    setMask( BufferSource.of( mask ) );
  }

  @JsOverlay
  default void setMask(@Nonnull final Float32Array mask) {
    setMask( BufferSource.of( mask ) );
  }

  @JsOverlay
  default void setMask(@Nonnull final Float64Array mask) {
    setMask( BufferSource.of( mask ) );
  }

  @JsOverlay
  default void setMask(@Nonnull final DataView mask) {
    setMask( BufferSource.of( mask ) );
  }

  @JsOverlay
  default void setMask(@Nonnull final ArrayBuffer mask) {
    setMask( BufferSource.of( mask ) );
  }

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends BluetoothDataFilterInit {
    @JsOverlay
    @Nonnull
    default Builder dataPrefix(@Nonnull final BufferSource dataPrefix) {
      setDataPrefix( dataPrefix );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder dataPrefix(@Nonnull final ArrayBufferView dataPrefix) {
      setDataPrefix( dataPrefix );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder dataPrefix(@Nonnull final Int8Array dataPrefix) {
      setDataPrefix( dataPrefix );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder dataPrefix(@Nonnull final Int16Array dataPrefix) {
      setDataPrefix( dataPrefix );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder dataPrefix(@Nonnull final Int32Array dataPrefix) {
      setDataPrefix( dataPrefix );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder dataPrefix(@Nonnull final Uint8Array dataPrefix) {
      setDataPrefix( dataPrefix );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder dataPrefix(@Nonnull final Uint16Array dataPrefix) {
      setDataPrefix( dataPrefix );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder dataPrefix(@Nonnull final Uint32Array dataPrefix) {
      setDataPrefix( dataPrefix );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder dataPrefix(@Nonnull final Uint8ClampedArray dataPrefix) {
      setDataPrefix( dataPrefix );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder dataPrefix(@Nonnull final Float32Array dataPrefix) {
      setDataPrefix( dataPrefix );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder dataPrefix(@Nonnull final Float64Array dataPrefix) {
      setDataPrefix( dataPrefix );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder dataPrefix(@Nonnull final DataView dataPrefix) {
      setDataPrefix( dataPrefix );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder dataPrefix(@Nonnull final ArrayBuffer dataPrefix) {
      setDataPrefix( dataPrefix );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder mask(@Nonnull final BufferSource mask) {
      setMask( mask );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder mask(@Nonnull final ArrayBufferView mask) {
      setMask( mask );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder mask(@Nonnull final Int8Array mask) {
      setMask( mask );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder mask(@Nonnull final Int16Array mask) {
      setMask( mask );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder mask(@Nonnull final Int32Array mask) {
      setMask( mask );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder mask(@Nonnull final Uint8Array mask) {
      setMask( mask );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder mask(@Nonnull final Uint16Array mask) {
      setMask( mask );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder mask(@Nonnull final Uint32Array mask) {
      setMask( mask );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder mask(@Nonnull final Uint8ClampedArray mask) {
      setMask( mask );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder mask(@Nonnull final Float32Array mask) {
      setMask( mask );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder mask(@Nonnull final Float64Array mask) {
      setMask( mask );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder mask(@Nonnull final DataView mask) {
      setMask( mask );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder mask(@Nonnull final ArrayBuffer mask) {
      setMask( mask );
      return this;
    }
  }
}
