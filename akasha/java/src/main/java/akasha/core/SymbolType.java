package akasha.core;

import javax.annotation.Nonnull;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * This type exists due to the odd way that closure compiler manages the symbol type.
 * It has both a interface type named "Symbol" and a type annotation {symbol} and both
 * are treated differently. Thus we have had to hand write these classes to ensure that
 * it operates within the constraints of the base closure externs (which can not be
 * overridden).
 */
@JsType( isNative = true, namespace = JsPackage.GLOBAL, name = "Symbol" )
final class SymbolType
{
  @JsProperty( name = "asyncIterator" )
  @Nonnull
  static native Symbol asyncIterator();

  @JsProperty( name = "hasInstance" )
  @Nonnull
  static native Symbol hasInstance();

  @JsProperty( name = "isConcatSpreadable" )
  @Nonnull
  static native Symbol _isConcatSpreadable();

  @JsProperty( name = "iterator" )
  @Nonnull
  static native Symbol iterator();

  @JsProperty( name = "match" )
  @Nonnull
  static native Symbol match();

  @JsProperty( name = "matchAll" )
  @Nonnull
  static native Symbol matchAll();

  @JsProperty( name = "replace" )
  @Nonnull
  static native Symbol replace();

  @JsProperty( name = "search" )
  @Nonnull
  static native Symbol search();

  @JsProperty( name = "species" )
  @Nonnull
  static native Symbol species();

  @JsProperty( name = "split" )
  @Nonnull
  static native Symbol split();

  @JsProperty( name = "toPrimitive" )
  @Nonnull
  static native Symbol toPrimitive();

  @JsProperty( name = "toStringTag" )
  @Nonnull
  static native Symbol toStringTag();

  @JsProperty( name = "unscopables" )
  @Nonnull
  static native Symbol unscopables();

  @JsMethod( name = "for" )
  @Nonnull
  static native Symbol for_( @Nonnull String key );

  @Nonnull
  static native String keyFor( @Nonnull Symbol symbol );
}
