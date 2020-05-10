package org.realityforge.webtack.model.tools.transform;

import org.realityforge.webtack.model.AbstractTest;
import org.testng.annotations.Test;

public class ExposureSetExtractorProcessorTest
  extends AbstractTest
{

  @Test
  public void interfaceTest()
    throws Exception
  {
    performFixtureTest( "ExposureSetExtractorProcessor - interface",
                        () -> new ExposureSetExtractorProcessor( "other" ),
                        getTestLocalFixtureDir().resolve( "interface" ),
                        "input.webidl",
                        "output_other.webidl" );
    performFixtureTest( "ExposureSetExtractorProcessor - interface",
                        () -> new ExposureSetExtractorProcessor( "Window" ),
                        getTestLocalFixtureDir().resolve( "interface" ),
                        "input.webidl",
                        "output_window.webidl" );
    performFixtureTest( "ExposureSetExtractorProcessor - interface",
                        () -> new ExposureSetExtractorProcessor( "Worker" ),
                        getTestLocalFixtureDir().resolve( "interface" ),
                        "input.webidl",
                        "output_worker.webidl" );
  }
  @Test
  public void mixinTest()
    throws Exception
  {
    performFixtureTest( "ExposureSetExtractorProcessor - mixin",
                        () -> new ExposureSetExtractorProcessor( "other" ),
                        getTestLocalFixtureDir().resolve( "mixin" ),
                        "input.webidl",
                        "output_other.webidl" );
    performFixtureTest( "ExposureSetExtractorProcessor - mixin",
                        () -> new ExposureSetExtractorProcessor( "Window" ),
                        getTestLocalFixtureDir().resolve( "mixin" ),
                        "input.webidl",
                        "output_window.webidl" );
    performFixtureTest( "ExposureSetExtractorProcessor - mixin",
                        () -> new ExposureSetExtractorProcessor( "Worker" ),
                        getTestLocalFixtureDir().resolve( "mixin" ),
                        "input.webidl",
                        "output_worker.webidl" );
  }

  @Test
  public void namespaceTest()
    throws Exception
  {
    performFixtureTest( "ExposureSetExtractorProcessor - namespace",
                        () -> new ExposureSetExtractorProcessor( "other" ),
                        getTestLocalFixtureDir().resolve( "namespace" ),
                        "input.webidl",
                        "output_other.webidl" );
    performFixtureTest( "ExposureSetExtractorProcessor - namespace",
                        () -> new ExposureSetExtractorProcessor( "Window" ),
                        getTestLocalFixtureDir().resolve( "namespace" ),
                        "input.webidl",
                        "output_window.webidl" );
    performFixtureTest( "ExposureSetExtractorProcessor - namespace",
                        () -> new ExposureSetExtractorProcessor( "Worker" ),
                        getTestLocalFixtureDir().resolve( "namespace" ),
                        "input.webidl",
                        "output_worker.webidl" );
  }


  @Test
  public void callbackInterfaceTest()
    throws Exception
  {
    performFixtureTest( "ExposureSetExtractorProcessor - callback_interface",
                        () -> new ExposureSetExtractorProcessor( "other" ),
                        getTestLocalFixtureDir().resolve( "callback_interface" ),
                        "input.webidl",
                        "output_other.webidl" );
    performFixtureTest( "ExposureSetExtractorProcessor - callback_interface",
                        () -> new ExposureSetExtractorProcessor( "Window" ),
                        getTestLocalFixtureDir().resolve( "callback_interface" ),
                        "input.webidl",
                        "output_window.webidl" );
    performFixtureTest( "ExposureSetExtractorProcessor - callback_interface",
                        () -> new ExposureSetExtractorProcessor( "Worker" ),
                        getTestLocalFixtureDir().resolve( "callback_interface" ),
                        "input.webidl",
                        "output_worker.webidl" );
  }
}
