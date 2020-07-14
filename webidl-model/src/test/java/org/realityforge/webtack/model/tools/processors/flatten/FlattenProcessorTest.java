package org.realityforge.webtack.model.tools.processors.flatten;

import java.io.IOException;
import java.nio.file.Files;
import javax.annotation.Nonnull;
import javax.json.Json;
import org.realityforge.webtack.model.AbstractTest;
import org.realityforge.webtack.model.tools.spi.Processor;
import org.realityforge.webtack.model.tools.spi.Registry;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class FlattenProcessorTest
  extends AbstractTest
{
  @Test
  public void registry()
  {
    assertTrue( Registry.isProcessorPresent( "Flatten" ) );
    assertNotNull( createProcessor() );
  }

  @DataProvider( name = "fixtureTests" )
  public Object[][] fixtureTests()
    throws IOException
  {
    return Files.list( getTestLocalFixtureDir() )
      .filter( Files::isDirectory )
      .filter( d -> Files.exists( d.resolve( "input.webidl" ) ) && Files.exists( d.resolve( "output.webidl" ) ) )
      .map( d -> new Object[]{ d.getFileName().toString() } )
      .toArray( Object[][]::new );
  }

  @Test( dataProvider = "fixtureTests" )
  public void fixtureTest( @Nonnull final String subDirectory )
    throws Exception
  {
    performFlattenFixtureTest( subDirectory );
  }

  private void performFlattenFixtureTest( @Nonnull final String subDirectory )
    throws Exception
  {
    performFixtureTest( getClass().getSimpleName() + " " + subDirectory,
                        this::createProcessor,
                        getTestLocalFixtureDir().resolve( subDirectory ),
                        "input",
                        "output" );
  }

  @DataProvider( name = "failedFixtures" )
  public Object[][] failedFixtures()
  {
    return new Object[][]{
      new Object[]{ "partial_dictionary_duplicate_member",
                    "Failed to merge dictionary member named 'clientX' into dictionary named 'MouseEventInit' as the dictionary already contains a member with the same name. Existing defined in:\n" +
                    "src/test/java/org/realityforge/webtack/model/tools/processors/flatten/FlattenProcessorTest/partial_dictionary_duplicate_member/input.webidl:4:2\n" +
                    "Attempting to add member defined in:\n" +
                    "src/test/java/org/realityforge/webtack/model/tools/processors/flatten/FlattenProcessorTest/partial_dictionary_duplicate_member/input.webidl:12:2" },
      new Object[]{ "partial_interface_duplicate_attribute",
                    "Failed to merge attribute named 'speechSynthesis' into interface named 'Window' as the interface already contains an attribute with the same name. Existing defined in:\n" +
                    "src/test/java/org/realityforge/webtack/model/tools/processors/flatten/FlattenProcessorTest/partial_interface_duplicate_attribute/input.webidl:2:2\n" +
                    "Attempting to add member defined in:\n" +
                    "src/test/java/org/realityforge/webtack/model/tools/processors/flatten/FlattenProcessorTest/partial_interface_duplicate_attribute/input.webidl:12:2" },
      new Object[]{ "partial_interface_duplicate_attribute_no_interface",
                    "Failed to merge attribute named 'speechSynthesis' into partial interface named 'Window' as the partial interface already contains an attribute with the same name. Existing defined in:\n" +
                    "src/test/java/org/realityforge/webtack/model/tools/processors/flatten/FlattenProcessorTest/partial_interface_duplicate_attribute_no_interface/input.webidl:2:2\n" +
                    "Attempting to add member defined in:\n" +
                    "src/test/java/org/realityforge/webtack/model/tools/processors/flatten/FlattenProcessorTest/partial_interface_duplicate_attribute_no_interface/input.webidl:12:2" },
      new Object[]{ "partial_interface_duplicate_constant",
                    "Failed to merge constant named 'COMPRESSED_RGB_S3TC_DXT1_EXT' into interface named 'Window' as the interface already contains a constant with the same name. Existing defined in:\n" +
                    "src/test/java/org/realityforge/webtack/model/tools/processors/flatten/FlattenProcessorTest/partial_interface_duplicate_constant/input.webidl:5:2\n" +
                    "Attempting to add member defined in:\n" +
                    "src/test/java/org/realityforge/webtack/model/tools/processors/flatten/FlattenProcessorTest/partial_interface_duplicate_constant/input.webidl:14:2" },
      new Object[]{ "partial_interface_duplicate_constant_no_interface",
                    "Failed to merge constant named 'COMPRESSED_RGB_S3TC_DXT1_EXT' into partial interface named 'Window' as the partial interface already contains a constant with the same name. Existing defined in:\n" +
                    "src/test/java/org/realityforge/webtack/model/tools/processors/flatten/FlattenProcessorTest/partial_interface_duplicate_constant_no_interface/input.webidl:5:2\n" +
                    "Attempting to add member defined in:\n" +
                    "src/test/java/org/realityforge/webtack/model/tools/processors/flatten/FlattenProcessorTest/partial_interface_duplicate_constant_no_interface/input.webidl:14:2" },
      new Object[]{ "mixin_and_partial_interface_into_interface_duplicate_attribute",
                    "Failed to merge attribute named 'rootElement' from mixin named 'DocumentOrShadowRoot' into interface named 'Document' as the interface already contains an attribute with the same name. Existing defined in:\n" +
                    "src/test/java/org/realityforge/webtack/model/tools/processors/flatten/FlattenProcessorTest/mixin_and_partial_interface_into_interface_duplicate_attribute/input.webidl:12:2\n" +
                    "Attempting to add member defined in:\n" +
                    "src/test/java/org/realityforge/webtack/model/tools/processors/flatten/FlattenProcessorTest/mixin_and_partial_interface_into_interface_duplicate_attribute/input.webidl:15:0" },
      new Object[]{ "mixin_and_partial_interface_into_interface_duplicate_constant",
                    "Failed to merge constant named 'COMPRESSED_RGBA_S3TC_DXT1_EXT' from mixin named 'DocumentOrShadowRoot' into interface named 'Document' as the interface already contains a constant with the same name. Existing defined in:\n" +
                    "src/test/java/org/realityforge/webtack/model/tools/processors/flatten/FlattenProcessorTest/mixin_and_partial_interface_into_interface_duplicate_constant/input.webidl:12:2\n" +
                    "Attempting to add member defined in:\n" +
                    "src/test/java/org/realityforge/webtack/model/tools/processors/flatten/FlattenProcessorTest/mixin_and_partial_interface_into_interface_duplicate_constant/input.webidl:17:0" },
      new Object[]{ "partial_namespace_duplicate_attribute",
                    "Failed to merge attribute named 'URL' into namespace named 'WebAssembly' as the namespace already contains an attribute with the same name. Existing defined in:\n" +
                    "src/test/java/org/realityforge/webtack/model/tools/processors/flatten/FlattenProcessorTest/partial_namespace_duplicate_attribute/input.webidl:8:2\n" +
                    "Attempting to add member defined in:\n" +
                    "src/test/java/org/realityforge/webtack/model/tools/processors/flatten/FlattenProcessorTest/partial_namespace_duplicate_attribute/input.webidl:2:2" },
      new Object[]{ "partial_mixin_duplicate_constant",
                    "Failed to merge constant named 'CHARSET_RULE' into mixin named 'DocumentOrShadowRoot' as the mixin already contains a constant with the same name. Existing defined in:\n" +
                    "src/test/java/org/realityforge/webtack/model/tools/processors/flatten/FlattenProcessorTest/partial_mixin_duplicate_constant/input.webidl:1:0\n" +
                    "Attempting to add member defined in:\n" +
                    "src/test/java/org/realityforge/webtack/model/tools/processors/flatten/FlattenProcessorTest/partial_mixin_duplicate_constant/input.webidl:7:0" }
    };
  }

  @Test( dataProvider = "failedFixtures" )
  public void failedFixtureTest( @Nonnull final String subDirectory, @Nonnull final String errorMessage )
  {
    processFailedTest( subDirectory, errorMessage );
  }

  private void processFailedTest( @Nonnull final String subDirectory, @Nonnull final String errorMessage )
  {
    processorGeneratesError( getClass().getSimpleName() + " " + subDirectory,
                             this::createProcessor,
                             getTestLocalFixtureDir().resolve( subDirectory ),
                             "input",
                             errorMessage );
  }

  @Nonnull
  private Processor createProcessor()
  {
    return Registry.createProcessor( "Flatten", Json.createObjectBuilder().build() );
  }
}
