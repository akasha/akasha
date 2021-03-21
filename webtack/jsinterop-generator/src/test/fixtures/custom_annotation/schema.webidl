[JavaAnnotation="akasha.MyAnnotation"]
enum PermissionState {
  "denied",
  [JavaAnnotation="akasha.MyAnnotation2"] "granted",
  "prompt"
};

[JavaAnnotation="akasha.MyAnnotation"]
typedef ( DOMString or double ) MyTypedefedUnion;

[JavaAnnotation="akasha.MyAnnotation"]
namespace CSS {
  [JavaAnnotation="akasha.MyAnnotation2"]
  DOMString escape( DOMString ident );
};

[JavaAnnotation="akasha.MyAnnotation"]
callback MyEventHandler = undefined ( [JavaAnnotation="akasha.MyAnnotation2"] Event event );

[JavaAnnotation="akasha.MyAnnotation"]
callback interface EventListener {
  [JavaAnnotation="akasha.MyAnnotation3"]
  undefined handleEvent( [JavaAnnotation="akasha.MyAnnotation2"] Event event );
};

[JavaAnnotation="akasha.MyAnnotation"]
dictionary EventInit {
  [JavaAnnotation="akasha.MyAnnotation"]
  boolean bubbles = false;
};

interface Event {
};

[JavaAnnotation="akasha.MyAnnotation"]
interface WebGL2RenderingContext {
  [JavaAnnotation="akasha.gl.GLSL"]
  DOMString? getShaderSource( [JavaAnnotation="akasha.MyAnnotation"] WebGLShader shader );
};

interface WebGLShader {
};
