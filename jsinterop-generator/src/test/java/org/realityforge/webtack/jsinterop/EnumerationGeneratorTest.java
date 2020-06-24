package org.realityforge.webtack.jsinterop;

import javax.annotation.Nonnull;
import org.realityforge.webtack.model.EnumerationDefinition;
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
    final WebIDLSchema schema = loadSchema( content );
    final EnumerationDefinition definition = schema.findEnumerationByName( "SpeechRecognitionErrorCode" );
    assert null != definition;

    generateCode( schema, definition );
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
    final WebIDLSchema schema = loadSchema( content );
    final EnumerationDefinition definition = schema.findEnumerationByName( "XMLHttpRequestResponseType" );
    assert null != definition;

    generateCode( schema, definition );
  }

  private void generateCode( @Nonnull final WebIDLSchema schema, @Nonnull final EnumerationDefinition definition )
    throws Exception
  {
    //TODO: We should generate the java code for above and compile java code to ensure it is valid
    final CallbackInterfaceGenerator generator = new CallbackInterfaceGenerator();
    generator.generate( newContext( schema ), definition );
    assertFileMatchesFixture( javaFile( definition.getName() ), javaFixtureFile( definition.getName() ) );
  }
}
