[JavaAnnotation="elemental3.MyAnnotation"]
enum PermissionState {
  "denied",
  [JavaAnnotation="elemental3.MyAnnotation2"] "granted",
  "prompt"
};

[JavaAnnotation="elemental3.MyAnnotation"]
typedef ( DOMString or double ) MyTypedefedUnion;

[JavaAnnotation="elemental3.MyAnnotation"]
namespace CSS {
  [JavaAnnotation="elemental3.MyAnnotation2"]
  DOMString escape( DOMString ident );
};

[JavaAnnotation="elemental3.MyAnnotation"]
callback MyEventHandler = undefined ( [JavaAnnotation="elemental3.MyAnnotation2"] Event event );

[JavaAnnotation="elemental3.MyAnnotation"]
callback interface EventListener {
  [JavaAnnotation="elemental3.MyAnnotation3"]
  undefined handleEvent( [JavaAnnotation="elemental3.MyAnnotation2"] Event event );
};

[JavaAnnotation="elemental3.MyAnnotation"]
dictionary EventInit {
  [JavaAnnotation="elemental3.MyAnnotation"]
  boolean bubbles = false;
};

interface Event {
};

[JavaAnnotation="elemental3.MyAnnotation"]
interface WebGL2RenderingContext {
  [JavaAnnotation="elemental3.gl.GLSL"]
  DOMString? getShaderSource( [JavaAnnotation="elemental3.MyAnnotation"] WebGLShader shader );
};

interface WebGLShader {
};
