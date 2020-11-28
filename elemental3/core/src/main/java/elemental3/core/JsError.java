package elemental3.core;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@JsType( name = "Error", isNative = true, namespace = JsPackage.GLOBAL )
public class JsError
{
  public static double stackTraceLimit;

  public static native void captureStackTrace( JsObject error, JsFunction constructor );

  public static native void captureStackTrace( JsObject error );

  @JsOverlay
  public static final void captureStackTrace( Object error, JsFunction constructor )
  {
    captureStackTrace( Js.uncheckedCast( error ), constructor );
  }

  @JsOverlay
  public static final void captureStackTrace( Object error )
  {
    captureStackTrace( Js.uncheckedCast( error ) );
  }

  public String description;
  public String fileName;
  public double lineNumber;
  public String message;
  public String name;
  public Object sourceURL;
  public String stack;

  public JsError()
  {
  }

  public JsError( Object message, Object file, Object line )
  {
  }

  public JsError( Object message, Object file )
  {
  }

  public JsError( Object message )
  {
  }
}
