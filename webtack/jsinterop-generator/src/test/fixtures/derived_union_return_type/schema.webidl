interface AudioNode {
  /**
   * If the destination is a node, connect() returns a reference to the destination AudioNode object, allowing you to chain multiple connect() calls. In some browsers, older implementations of this interface return undefined.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/AudioNode/connect">AudioNode.connect - MDN</a>
   * @see <a href="https://webaudio.github.io/web-audio-api/#dom-audionode-connect">connect() to an AudioNode - Web Audio API</a>
   * @see <a href="https://webaudio.github.io/web-audio-api/#dom-audionode-connect-destinationparam-output">connect() to an AudioParam - Web Audio API</a>
   */
  AudioNode connect( AudioNode destinationNode, optional unsigned long output = 0, optional unsigned long input = 0 );
  /**
   * If the destination is a node, connect() returns a reference to the destination AudioNode object, allowing you to chain multiple connect() calls. In some browsers, older implementations of this interface return undefined.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/AudioNode/connect">AudioNode.connect - MDN</a>
   * @see <a href="https://webaudio.github.io/web-audio-api/#dom-audionode-connect">connect() to an AudioNode - Web Audio API</a>
   * @see <a href="https://webaudio.github.io/web-audio-api/#dom-audionode-connect-destinationparam-output">connect() to an AudioParam - Web Audio API</a>
   */
  undefined connect( AudioParam destinationParam, optional unsigned long output = 0 );
};

interface AudioParam {
};

interface Document {
  /**
   * The Document.open() method opens a document for writing.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Document/open">Document.open - MDN</a>
   * @see <a href="https://html.spec.whatwg.org/multipage/#dom-document-open">document.open() - HTML Living Standard</a>
   * @see <a href="https://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-72161170">document.open() - Document Object Model (DOM) Level 2 HTML Specification</a>
   */
  [CEReactions]
  Document open( optional DOMString unused1, optional DOMString unused2 );
  /**
   * The Document.open() method opens a document for writing.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Document/open">Document.open - MDN</a>
   * @see <a href="https://html.spec.whatwg.org/multipage/#dom-document-open">document.open() - HTML Living Standard</a>
   * @see <a href="https://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-72161170">document.open() - Document Object Model (DOM) Level 2 HTML Specification</a>
   */
  WindowProxy? open( USVString url, DOMString name, DOMString features );
};

interface WindowProxy {
};
