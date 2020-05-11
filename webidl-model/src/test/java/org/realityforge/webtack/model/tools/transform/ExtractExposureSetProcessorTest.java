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
                        "input.webidl",
                        "output_other.webidl" );
    performFixtureTest( "ExposureSetExtractorProcessor - interface",
                        () -> new ExtractExposureSetProcessor( "Window" ),
                        getTestLocalFixtureDir().resolve( "interface" ),
                        "input.webidl",
                        "output_window.webidl" );
    performFixtureTest( "ExposureSetExtractorProcessor - interface",
                        () -> new ExtractExposureSetProcessor( "Worker" ),
                        getTestLocalFixtureDir().resolve( "interface" ),
                        "input.webidl",
                        "output_worker.webidl" );
  }
  @Test
  public void mixinTest()
    throws Exception
  {
    performFixtureTest( "ExposureSetExtractorProcessor - mixin",
                        () -> new ExtractExposureSetProcessor( "other" ),
                        getTestLocalFixtureDir().resolve( "mixin" ),
                        "input.webidl",
                        "output_other.webidl" );
    performFixtureTest( "ExposureSetExtractorProcessor - mixin",
                        () -> new ExtractExposureSetProcessor( "Window" ),
                        getTestLocalFixtureDir().resolve( "mixin" ),
                        "input.webidl",
                        "output_window.webidl" );
    performFixtureTest( "ExposureSetExtractorProcessor - mixin",
                        () -> new ExtractExposureSetProcessor( "Worker" ),
                        getTestLocalFixtureDir().resolve( "mixin" ),
                        "input.webidl",
                        "output_worker.webidl" );
  }

  @Test
  public void namespaceTest()
    throws Exception
  {
    performFixtureTest( "ExposureSetExtractorProcessor - namespace",
                        () -> new ExtractExposureSetProcessor( "other" ),
                        getTestLocalFixtureDir().resolve( "namespace" ),
                        "input.webidl",
                        "output_other.webidl" );
    performFixtureTest( "ExposureSetExtractorProcessor - namespace",
                        () -> new ExtractExposureSetProcessor( "Window" ),
                        getTestLocalFixtureDir().resolve( "namespace" ),
                        "input.webidl",
                        "output_window.webidl" );
    performFixtureTest( "ExposureSetExtractorProcessor - namespace",
                        () -> new ExtractExposureSetProcessor( "Worker" ),
                        getTestLocalFixtureDir().resolve( "namespace" ),
                        "input.webidl",
                        "output_worker.webidl" );
  }


  @Test
  public void callbackInterfaceTest()
    throws Exception
  {
    performFixtureTest( "ExposureSetExtractorProcessor - callback_interface",
                        () -> new ExtractExposureSetProcessor( "other" ),
                        getTestLocalFixtureDir().resolve( "callback_interface" ),
                        "input.webidl",
                        "output_other.webidl" );
    performFixtureTest( "ExposureSetExtractorProcessor - callback_interface",
                        () -> new ExtractExposureSetProcessor( "Window" ),
                        getTestLocalFixtureDir().resolve( "callback_interface" ),
                        "input.webidl",
                        "output_window.webidl" );
    performFixtureTest( "ExposureSetExtractorProcessor - callback_interface",
                        () -> new ExtractExposureSetProcessor( "Worker" ),
                        getTestLocalFixtureDir().resolve( "callback_interface" ),
                        "input.webidl",
                        "output_worker.webidl" );
  }
}
