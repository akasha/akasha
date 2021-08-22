package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsNullable;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "Document"
)
public class Document {
  protected Document() {
  }

  /**
   * The Document.open() method opens a document for writing.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Document/open">Document.open - MDN</a>
   * @see <a href="https://html.spec.whatwg.org/multipage/#dom-document-open">document.open() - HTML Living Standard</a>
   * @see <a href="https://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-72161170">document.open() - Document Object Model (DOM) Level 2 HTML Specification</a>
   */
  @JsNonNull
  public native Document open(@Nonnull String unused1, @Nonnull String unused2);

  /**
   * The Document.open() method opens a document for writing.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Document/open">Document.open - MDN</a>
   * @see <a href="https://html.spec.whatwg.org/multipage/#dom-document-open">document.open() - HTML Living Standard</a>
   * @see <a href="https://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-72161170">document.open() - Document Object Model (DOM) Level 2 HTML Specification</a>
   */
  @JsNonNull
  public native Document open(@Nonnull String unused1);

  /**
   * The Document.open() method opens a document for writing.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Document/open">Document.open - MDN</a>
   * @see <a href="https://html.spec.whatwg.org/multipage/#dom-document-open">document.open() - HTML Living Standard</a>
   * @see <a href="https://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-72161170">document.open() - Document Object Model (DOM) Level 2 HTML Specification</a>
   */
  @JsNonNull
  public native Document open();

  /**
   * The Document.open() method opens a document for writing.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Document/open">Document.open - MDN</a>
   * @see <a href="https://html.spec.whatwg.org/multipage/#dom-document-open">document.open() - HTML Living Standard</a>
   * @see <a href="https://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-72161170">document.open() - Document Object Model (DOM) Level 2 HTML Specification</a>
   */
  @JsNullable
  public native WindowProxy open(@Nonnull String url, @Nonnull String name,
      @Nonnull String features);
}
