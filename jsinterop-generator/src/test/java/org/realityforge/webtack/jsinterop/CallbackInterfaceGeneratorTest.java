package org.realityforge.webtack.jsinterop;

import org.realityforge.webtack.model.CallbackInterfaceDefinition;
import org.realityforge.webtack.model.WebIDLSchema;
import org.testng.annotations.Test;

public final class CallbackInterfaceGeneratorTest
  extends AbstractTest
{
  @Test
  public void generate()
    throws Exception
  {
    final String content =
      "interface Event {\n" +
      "  constructor();\n" +
      "};\n" +
      "\n" +
      "callback interface EventListener {\n" +
      "  void handleEvent( Event event );\n" +
      "};\n";
    final WebIDLSchema schema = loadSchema( content );
    final CallbackInterfaceDefinition definition = schema.findCallbackInterfaceByName( "EventListener" );
    assert null != definition;

    //TODO: We should generate the java code for above and compile java code to ensure it is valid
    final CallbackInterfaceGenerator generator = new CallbackInterfaceGenerator();
    generator.generate( newContext(), definition );
    assertFileMatchesFixture( javaFile( definition.getName() ), javaFixtureFile( definition.getName() ) );
  }
}
