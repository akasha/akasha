package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "Document"
)
public class Document {
  protected Document() {
  }

  @JsMethod(
      name = "open"
  )
  @Nullable
  public native DocumentOrWindowProxyUnion _open(@Nonnull String unused1, @Nonnull String unused2);

  /**
   * The Document.open() method opens a document for writing.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Document/open">Document.open - MDN</a>
   * @see <a href="https://html.spec.whatwg.org/multipage/#dom-document-open">document.open() - HTML Living Standard</a>
   * @see <a href="https://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-72161170">document.open() - Document Object Model (DOM) Level 2 HTML Specification</a>
   */
  @JsOverlay
  @Nonnull
  public final Document open(@Nonnull String unused1, @Nonnull String unused2) {
    return Js.uncheckedCast( _open( unused1, unused2 ) );
  }

  @JsMethod(
      name = "open"
  )
  @Nullable
  public native DocumentOrWindowProxyUnion _open(@Nonnull String unused1);

  /**
   * The Document.open() method opens a document for writing.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Document/open">Document.open - MDN</a>
   * @see <a href="https://html.spec.whatwg.org/multipage/#dom-document-open">document.open() - HTML Living Standard</a>
   * @see <a href="https://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-72161170">document.open() - Document Object Model (DOM) Level 2 HTML Specification</a>
   */
  @JsOverlay
  @Nonnull
  public final Document open(@Nonnull String unused1) {
    return Js.uncheckedCast( _open( unused1 ) );
  }

  @JsMethod(
      name = "open"
  )
  @Nullable
  public native DocumentOrWindowProxyUnion _open();

  /**
   * The Document.open() method opens a document for writing.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Document/open">Document.open - MDN</a>
   * @see <a href="https://html.spec.whatwg.org/multipage/#dom-document-open">document.open() - HTML Living Standard</a>
   * @see <a href="https://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-72161170">document.open() - Document Object Model (DOM) Level 2 HTML Specification</a>
   */
  @JsOverlay
  @Nonnull
  public final Document open() {
    return Js.uncheckedCast( _open() );
  }

  @JsMethod(
      name = "open"
  )
  @Nullable
  public native DocumentOrWindowProxyUnion _open(@Nonnull String url, @Nonnull String name,
      @Nonnull String features);

  /**
   * The Document.open() method opens a document for writing.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Document/open">Document.open - MDN</a>
   * @see <a href="https://html.spec.whatwg.org/multipage/#dom-document-open">document.open() - HTML Living Standard</a>
   * @see <a href="https://www.w3.org/TR/DOM-Level-2-HTML/html.html#ID-72161170">document.open() - Document Object Model (DOM) Level 2 HTML Specification</a>
   */
  @JsOverlay
  @Nullable
  public final WindowProxy open(@Nonnull String url, @Nonnull String name,
      @Nonnull String features) {
    return Js.uncheckedCast( _open( url, name, features ) );
  }
}
