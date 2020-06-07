package org.realityforge.webtack.model.tools.transform;

import org.realityforge.webtack.model.AbstractTest;
import org.testng.annotations.Test;

public class ExtractExposureSetProcessorTest
  extends AbstractTest
{
  @Test
  public void interfaceTest()
    throws Exception
  {
    performFixtureTest( "ExposureSetExtractorProcessor - interface",
                        () -> new ExtractExposureSetProcessor( "other" ),
                        getTestLocalFixtureDir().resolve( "interface" ),
                        "input",
                        "output_other" );
    performFixtureTest( "ExposureSetExtractorProcessor - interface",
                        () -> new ExtractExposureSetProcessor( "Window" ),
                        getTestLocalFixtureDir().resolve( "interface" ),
                        "input",
                        "output_window" );
    performFixtureTest( "ExposureSetExtractorProcessor - interface",
                        () -> new ExtractExposureSetProcessor( "Worker" ),
                        getTestLocalFixtureDir().resolve( "interface" ),
                        "input",
                        "output_worker" );
  }

  @Test
  public void mixinTest()
    throws Exception
  {
    performFixtureTest( "ExposureSetExtractorProcessor - mixin",
                        () -> new ExtractExposureSetProcessor( "other" ),
                        getTestLocalFixtureDir().resolve( "mixin" ),
                        "input",
                        "output_other" );
    performFixtureTest( "ExposureSetExtractorProcessor - mixin",
                        () -> new ExtractExposureSetProcessor( "Window" ),
                        getTestLocalFixtureDir().resolve( "mixin" ),
                        "input",
                        "output_window" );
    performFixtureTest( "ExposureSetExtractorProcessor - mixin",
                        () -> new ExtractExposureSetProcessor( "Worker" ),
                        getTestLocalFixtureDir().resolve( "mixin" ),
                        "input",
                        "output_worker" );
  }

  @Test
  public void namespaceTest()
    throws Exception
  {
    performFixtureTest( "ExposureSetExtractorProcessor - namespace",
                        () -> new ExtractExposureSetProcessor( "other" ),
                        getTestLocalFixtureDir().resolve( "namespace" ),
                        "input",
                        "output_other" );
    performFixtureTest( "ExposureSetExtractorProcessor - namespace",
                        () -> new ExtractExposureSetProcessor( "Window" ),
                        getTestLocalFixtureDir().resolve( "namespace" ),
                        "input",
                        "output_window" );
    performFixtureTest( "ExposureSetExtractorProcessor - namespace",
                        () -> new ExtractExposureSetProcessor( "Worker" ),
                        getTestLocalFixtureDir().resolve( "namespace" ),
                        "input",
                        "output_worker" );
  }

  @Test
  public void callbackInterfaceTest()
    throws Exception
  {
    performFixtureTest( "ExposureSetExtractorProcessor - callback_interface",
                        () -> new ExtractExposureSetProcessor( "other" ),
                        getTestLocalFixtureDir().resolve( "callback_interface" ),
                        "input",
                        "output_other" );
    performFixtureTest( "ExposureSetExtractorProcessor - callback_interface",
                        () -> new ExtractExposureSetProcessor( "Window" ),
                        getTestLocalFixtureDir().resolve( "callback_interface" ),
                        "input",
                        "output_window" );
    performFixtureTest( "ExposureSetExtractorProcessor - callback_interface",
                        () -> new ExtractExposureSetProcessor( "Worker" ),
                        getTestLocalFixtureDir().resolve( "callback_interface" ),
                        "input",
                        "output_worker" );
  }
}
