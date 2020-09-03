package com.example;

import java.util.stream.Stream;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import react4j.ReactElement;
import react4j.ReactNode;

/**
 * Element factory that provides convenience wrappers for creating react4j host elements
 */
@Generated("org.realityforge.webtack")
public final class HTML {
  private HTML() {
  }

  @Nonnull
  private static ReactNode[] toArray(@Nullable final Stream<? extends ReactNode> children) {
    return children.toArray( ReactNode[]::new );
  }

  @Nonnull
  private static ReactElement createElement(@Nonnull final String type,
      @Nullable final JsPropertyMap<Object> props, @Nullable final ReactNode... children) {
    final JsPropertyMap<Object> actual = JsPropertyMap.of();
    String key = null;
    Object ref = null;
    if ( null != props ) {
      key = props.has( "key" ) ? Js.asString( props.get( "key" ) ) : null;
      ref = props.has( "ref" ) ? props.get( "ref" ) : null;
      props.forEach( p -> { if ( !p.equals( "key" ) && !p.equals( "ref" ) ) { actual.set( p, props.get( p ) ); } } );
    }
    if ( null != children && children.length > 0 ) {
      actual.set( "children", 1 == children.length ? children[ 0 ] : children );
    }
    return ReactElement.createHostElement( type, key, ref, actual );
  }
}
