package org.realityforge.webtack.jsinterop;

import org.testng.annotations.Test;

public final class DictionaryGeneratorTest
  extends AbstractTest
{
  @Test
  public void generate()
    throws Exception
  {
    final String content =
      "dictionary EventInit {\n" +
      "  boolean bubbles = false;\n" +
      "  boolean cancelable = false;\n" +
      "  boolean composed = false;\n" +
      "};\n" +
      "dictionary TransitionEventInit : EventInit {\n" +
      "  double elapsedTime = 0.0;\n" +
      "  DOMString propertyName = \"\";\n" +
      "  DOMString pseudoElement = \"\";\n" +
      "};\n" +
      "dictionary PromiseRejectionEventInit : EventInit {\n" +
      "  required Promise<any> promise;\n" +
      "  any reason;\n" +
      "};\n" +
      "\n" +
      "[Exposed=Window]\n" +
      "interface Storage {\n" +
      "  readonly attribute unsigned long length;\n" +
      "  void clear();\n" +
      "  DOMString? key( unsigned long index );\n" +
      "  getter DOMString? getItem( DOMString key );\n" +
      "  setter void setItem( DOMString key, DOMString value );\n" +
      "  deleter void removeItem( DOMString key );\n" +
      "};\n" +
      "dictionary StorageEventInit : EventInit {\n" +
      "  DOMString? key = null;\n" +
      "  DOMString? newValue = null;\n" +
      "  DOMString? oldValue = null;\n" +
      "  Storage? storageArea = null;\n" +
      "  USVString url = \"\";\n" +
      "};\n";
    generateCode( content );
    assertJavaFilePresent( "EventInit" );
    assertJavaFilePresent( "TransitionEventInit" );
    assertJavaFilePresent( "PromiseRejectionEventInit" );
    assertJavaFilePresent( "StorageEventInit" );
    assertJavaFilePresent( "Storage" );
  }

  @Test
  public void sequenceTypes()
    throws Exception
  {
    final String content =
      "dictionary XRSessionInit {\n" +
      "  sequence<any> optionalFeatures;\n" +
      "  sequence<any> requiredFeatures;\n" +
      "};\n\n";
    generateCode( content );
    assertJavaFilePresent( "XRSessionInit" );
  }
}
