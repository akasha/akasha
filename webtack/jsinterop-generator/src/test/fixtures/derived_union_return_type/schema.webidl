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
