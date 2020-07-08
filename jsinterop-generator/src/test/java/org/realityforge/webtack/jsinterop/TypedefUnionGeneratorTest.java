package org.realityforge.webtack.jsinterop;

import org.testng.annotations.Test;

public final class TypedefUnionGeneratorTest
  extends AbstractTest
{
  @Test
  public void generate()
    throws Exception
  {
    final String content =
      "[Exposed=(Window,Worker), Serializable] interface Blob { readonly attribute DOMString type; };\n" +
      "typedef ( DOMString or Blob ) ClipboardItemDataType;\n" +
      "\n" +
      "typedef ( double? or sequence<double?> ) IndexedKeyframeOffsetType;\n" +
      "\n" +
      "typedef ( Int8Array or Int16Array or Int32Array or Uint8Array or Uint16Array or Uint32Array or Uint8ClampedArray or Float32Array or Float64Array or DataView ) ArrayBufferView;\n";
    generateCode( content );
    assertJavaFilePresent( "ArrayBufferView" );
    assertJavaFilePresent( "Blob" );
    assertJavaFilePresent( "ClipboardItemDataType" );
  }
}
