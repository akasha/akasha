/**
 * Overloaded operator return values.
 */
namespace WebAssembly {
  Promise<WebAssemblyInstantiatedSource> instantiate( BufferSource bytes, optional object importObject );
  Promise<Instance> instantiate( Module moduleObject, optional object importObject );
};

dictionary ScrollToOptions {
  unrestricted double left;
  unrestricted double top;
};

dictionary WebAssemblyInstantiatedSource {
  required Instance instance;
  required Module module;
};

interface BufferSource {
};

interface Instance {
};

/**
 * Overloaded constructors
 */
interface MediaStream {
  constructor();
  constructor( MediaStream stream );
  constructor( sequence<MediaStreamTrack> tracks );
};

interface MediaStreamTrack {
};

interface Module {
};

/**
 * Move overloaded operator arguments with a minimum arg count higher than 0.
 */
interface Other {
  undefined castSpell( unrestricted double x, unrestricted double y );
  undefined castSpell( Point location );
};

interface Point {
};

/**
 * Overloaded operator arguments.
 */
interface Window {
  undefined scroll( unrestricted double x, unrestricted double y );
  undefined scroll( optional ScrollToOptions options = {} );
};
