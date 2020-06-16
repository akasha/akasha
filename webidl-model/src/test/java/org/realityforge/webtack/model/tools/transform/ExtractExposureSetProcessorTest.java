package org.realityforge.webtack.model.tools.transform;

import javax.annotation.Nonnull;
import javax.json.Json;
import org.realityforge.webtack.model.AbstractTest;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ExtractExposureSetProcessorTest
  extends AbstractTest
{
  @Test
  public void registry()
  {
    assertTrue( SchemaProcessorRegistry.isSchemaProcessorFactoryPresent( ExtractExposureSetProcessor.NAME ) );
    assertNotNull( createProcessor( "Window" ) );
  }

  @Test
  public void interfaceTest()
    throws Exception
  {

    performFixtureTest( "ExposureSetExtractorProcessor - interface",
                        () -> createProcessor( "other" ),
                        getTestLocalFixtureDir().resolve( "interface" ),
                        "input",
                        "output_other" );
    performFixtureTest( "ExposureSetExtractorProcessor - interface",
                        () -> createProcessor( "Window" ),
                        getTestLocalFixtureDir().resolve( "interface" ),
                        "input",
                        "output_window" );
    performFixtureTest( "ExposureSetExtractorProcessor - interface",
                        () -> createProcessor( "Worker" ),
                        getTestLocalFixtureDir().resolve( "interface" ),
                        "input",
                        "output_worker" );
  }

  @Test
  public void mixinTest()
    throws Exception
  {
    performFixtureTest( "ExposureSetExtractorProcessor - mixin",
                        () -> createProcessor( "other" ),
                        getTestLocalFixtureDir().resolve( "mixin" ),
                        "input",
                        "output_other" );
    performFixtureTest( "ExposureSetExtractorProcessor - mixin",
                        () -> createProcessor( "Window" ),
                        getTestLocalFixtureDir().resolve( "mixin" ),
                        "input",
                        "output_window" );
    performFixtureTest( "ExposureSetExtractorProcessor - mixin",
                        () -> createProcessor( "Worker" ),
                        getTestLocalFixtureDir().resolve( "mixin" ),
                        "input",
                        "output_worker" );
  }

  @Test
  public void namespaceTest()
    throws Exception
  {
    performFixtureTest( "ExposureSetExtractorProcessor - namespace",
                        () -> createProcessor( "other" ),
                        getTestLocalFixtureDir().resolve( "namespace" ),
                        "input",
                        "output_other" );
    performFixtureTest( "ExposureSetExtractorProcessor - namespace",
                        () -> createProcessor( "Window" ),
                        getTestLocalFixtureDir().resolve( "namespace" ),
                        "input",
                        "output_window" );
    performFixtureTest( "ExposureSetExtractorProcessor - namespace",
                        () -> createProcessor( "Worker" ),
                        getTestLocalFixtureDir().resolve( "namespace" ),
                        "input",
                        "output_worker" );
  }

  @Test
  public void callbackInterfaceTest()
    throws Exception
  {
    performFixtureTest( "ExposureSetExtractorProcessor - callback_interface",
                        () -> createProcessor( "other" ),
                        getTestLocalFixtureDir().resolve( "callback_interface" ),
                        "input",
                        "output_other" );
    performFixtureTest( "ExposureSetExtractorProcessor - callback_interface",
                        () -> createProcessor( "Window" ),
                        getTestLocalFixtureDir().resolve( "callback_interface" ),
                        "input",
                        "output_window" );
    performFixtureTest( "ExposureSetExtractorProcessor - callback_interface",
                        () -> createProcessor( "Worker" ),
                        getTestLocalFixtureDir().resolve( "callback_interface" ),
                        "input",
                        "output_worker" );
  }

  @Nonnull
  private SchemaProcessor createProcessor( @Nonnull final String globalInterface )
  {
    return SchemaProcessorRegistry.createSchemaProcessor( ExtractExposureSetProcessor.NAME,
                                                          Json.createObjectBuilder()
                                                            .add( "globalInterface", globalInterface )
                                                            .build() );
  }
}
