package org.realityforge.webtack.model.tools.sink;

import java.nio.file.Path;
import java.util.Collections;
import javax.annotation.Nonnull;
import javax.json.Json;
import org.realityforge.webtack.model.AbstractTest;
import org.realityforge.webtack.model.WebIDLSchema;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class EmitActionTest
  extends AbstractTest
{
  @Test
  public void registry()
    throws Exception
  {
    assertTrue( SchemaActionRegistry.isSchemaActionFactoryPresent( "Emit" ) );
    final Path output = getOutputFile( "%{name}" );
    assertNotNull( createAction( output.toString() ) );
  }

  @Test
  public void performAction()
    throws Exception
  {
    final Path output = getOutputFile( "%{name}" );
    final SchemaAction action = createAction( output.toString() );

    final Path schemaFile =
      writeSchema( "speech_api",
                   "[Exposed=(Window,Other)]\n" +
                   "interface SpeechGrammar {\n" +
                   "  attribute DOMString src;\n" +
                   "  attribute float weight;\n" +
                   "};\n" +
                   "[Exposed=Worker]\n" +
                   "interface SpeechGrammar2 {\n" +
                   "  attribute DOMString src;\n" +
                   "  attribute float weight;\n" +
                   "};\n" );

    final WebIDLSchema input =
      loadWebIDLSchema( schemaFile,
                        Collections.singleton( "name=speech_api" ),
                        "Valid schema" );
    action.process( input );

    assertFileContents( getOutputDirectory().resolve( "speech_api.webidl" ),
                        "[Exposed=(Window,Other)]\n" +
                        "interface SpeechGrammar {\n" +
                        "  attribute DOMString src;\n" +
                        "  attribute float weight;\n" +
                        "};\n" +
                        "\n" +
                        "[Exposed=Worker]\n" +
                        "interface SpeechGrammar2 {\n" +
                        "  attribute DOMString src;\n" +
                        "  attribute float weight;\n" +
                        "};\n" );
  }

  @Nonnull
  private SchemaAction createAction( @Nonnull final String filePattern )
  {
    return SchemaActionRegistry.createSchemaAction( EmitAction.NAME,
                                                    Json.createObjectBuilder()
                                                      .add( "filePattern", filePattern )
                                                      .build() );
  }
}
