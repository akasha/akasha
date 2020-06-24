package org.realityforge.webtack.jsinterop;

import org.realityforge.webtack.model.WebIDLSchema;
import org.testng.annotations.Test;

public final class EnumerationGeneratorTest
  extends AbstractTest
{
  @Test
  public void generate()
    throws Exception
  {
    final String content =
      "enum SpeechRecognitionErrorCode {\n" +
      "  \"aborted\",\n" +
      "  \"audio-capture\",\n" +
      "  \"bad-grammar\",\n" +
      "  \"language-not-supported\",\n" +
      "  \"network\",\n" +
      "  \"no-speech\",\n" +
      "  \"not-allowed\",\n" +
      "  \"service-not-allowed\"\n" +
      "};\n";
    generateCode( content );
    assertJavaFilePresent( "SpeechRecognitionErrorCode" );
  }

  @Test
  public void generate_with_empty()
    throws Exception
  {
    final String content =
      "enum XMLHttpRequestResponseType {\n" +
      "  \"\",\n" +
      "  \"arraybuffer\",\n" +
      "  \"blob\",\n" +
      "  \"document\",\n" +
      "  \"json\",\n" +
      "  \"text\"\n" +
      "};\n";
    generateCode( content );
    assertJavaFilePresent( "XMLHttpRequestResponseType" );
  }
}
