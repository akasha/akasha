package org.realityforge.webtack.jsinterop;

import org.testng.annotations.Test;

public final class InterfaceGeneratorTest
  extends AbstractTest
{
  @Test
  public void generate()
    throws Exception
  {
    final String content =
      "dictionary EventInit {\n" +
      "  boolean bubbles = false;\n" +
      "  boolean cancelable = false;\n" +
      "  boolean composed = false;\n" +
      "};\n" +
      "[Exposed=(Window,Worker,AudioWorklet)]\n" +
      "interface Event {\n" +
      "  const unsigned short AT_TARGET = 2;\n" +
      "  const unsigned short BUBBLING_PHASE = 3;\n" +
      "  const unsigned short CAPTURING_PHASE = 1;\n" +
      "  const unsigned short NONE = 0;\n" +
      "  readonly attribute boolean bubbles;\n" +
      "  readonly attribute boolean cancelable;\n" +
      "  readonly attribute boolean composed;\n" +
      "  readonly attribute EventTarget? currentTarget;\n" +
      "  readonly attribute boolean defaultPrevented;\n" +
      "  readonly attribute unsigned short eventPhase;\n" +
      "  [LegacyUnforgeable]\n" +
      "  readonly attribute boolean isTrusted;\n" +
      "  readonly attribute EventTarget? srcElement;\n" +
      "  readonly attribute EventTarget? target;\n" +
      "  readonly attribute DOMString type;\n" +
      "  attribute boolean cancelBubble;\n" +
      "  attribute boolean returnValue;\n" +
      "  constructor( DOMString type, optional EventInit eventInitDict = {} );\n" +
      "  sequence<EventTarget> composedPath();\n" +
      "  void initEvent( DOMString type, optional boolean bubbles = false, optional boolean cancelable = false );\n" +
      "  void preventDefault();\n" +
      "  void stopImmediatePropagation();\n" +
      "  void stopPropagation();\n" +
      "};\n" +
      "[Exposed=Window]\n" +
      "interface SpeechRecognitionErrorEvent : Event {\n" +
      "  readonly attribute DOMString message;\n" +
      "  constructor( DOMString type );\n" +
      "};\n" +
      "[Exposed=(Window,Worker,AudioWorklet)]\n" +
      "interface EventTarget {\n" +
      "  constructor();\n" +
      "  boolean dispatchEvent( Event event );\n" +
      "};\n";
    generateCode( content );
    assertJavaFilePresent( "Event" );
    assertJavaFilePresent( "EventTarget" );
    assertJavaFilePresent( "EventInit" );
    assertJavaFilePresent( "SpeechRecognitionErrorEvent" );
  }

  @Test
  public void propertyNameIsJavaKeyword()
    throws Exception
  {
    final String content =
      "[Exposed=Window]\n" +
      "interface SpeechSynthesisVoice {\n" +
      "  readonly attribute boolean default;\n" +
      "  readonly attribute DOMString lang;\n" +
      "  readonly attribute boolean localService;\n" +
      "  readonly attribute DOMString name;\n" +
      "  readonly attribute DOMString voiceURI;\n" +
      "};\n";
    generateCode( content );
    assertJavaFilePresent( "SpeechSynthesisVoice" );
  }
}
