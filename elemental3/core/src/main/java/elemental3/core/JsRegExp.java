package elemental3.core;

import javax.annotation.Nonnull;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType( name = "RegExp", isNative = true, namespace = JsPackage.GLOBAL )
public class JsRegExp
{
  public String flags;
  public boolean global;
  public boolean ignoreCase;
  public int lastIndex;
  public boolean multiline;
  public String source;
  public boolean sticky;

  public JsRegExp( @Nonnull final String pattern, @Nonnull final String flags )
  {
  }

  public JsRegExp( @Nonnull final String pattern )
  {
  }

  public native RegExpResult exec( String str );

  public native boolean test( String str );

  @JsMethod( name = "toString" )
  public native String toString_();
}
