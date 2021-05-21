package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "AudioNode"
)
public class AudioNode {
  protected AudioNode() {
  }

  @JsMethod(
      name = "connect"
  )
  @Nonnull
  public native AudioNodeOrUndefinedUnion _connect(@Nonnull AudioNode destinationNode, int output,
      int input);

  /**
   * If the destination is a node, connect() returns a reference to the destination AudioNode object, allowing you to chain multiple connect() calls. In some browsers, older implementations of this interface return undefined.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/AudioNode/connect">AudioNode.connect - MDN</a>
   * @see <a href="https://webaudio.github.io/web-audio-api/#dom-audionode-connect">connect() to an AudioNode - Web Audio API</a>
   * @see <a href="https://webaudio.github.io/web-audio-api/#dom-audionode-connect-destinationparam-output">connect() to an AudioParam - Web Audio API</a>
   */
  @JsOverlay
  @Nonnull
  public final AudioNode connect(@Nonnull AudioNode destinationNode, int output, int input) {
    return _connect( destinationNode, output, input ).asAudioNode();
  }

  @JsMethod(
      name = "connect"
  )
  @Nonnull
  public native AudioNodeOrUndefinedUnion _connect(@Nonnull AudioNode destinationNode, int output);

  /**
   * If the destination is a node, connect() returns a reference to the destination AudioNode object, allowing you to chain multiple connect() calls. In some browsers, older implementations of this interface return undefined.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/AudioNode/connect">AudioNode.connect - MDN</a>
   * @see <a href="https://webaudio.github.io/web-audio-api/#dom-audionode-connect">connect() to an AudioNode - Web Audio API</a>
   * @see <a href="https://webaudio.github.io/web-audio-api/#dom-audionode-connect-destinationparam-output">connect() to an AudioParam - Web Audio API</a>
   */
  @JsOverlay
  @Nonnull
  public final AudioNode connect(@Nonnull AudioNode destinationNode, int output) {
    return _connect( destinationNode, output ).asAudioNode();
  }

  @JsMethod(
      name = "connect"
  )
  @Nonnull
  public native AudioNodeOrUndefinedUnion _connect(@Nonnull AudioNode destinationNode);

  /**
   * If the destination is a node, connect() returns a reference to the destination AudioNode object, allowing you to chain multiple connect() calls. In some browsers, older implementations of this interface return undefined.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/AudioNode/connect">AudioNode.connect - MDN</a>
   * @see <a href="https://webaudio.github.io/web-audio-api/#dom-audionode-connect">connect() to an AudioNode - Web Audio API</a>
   * @see <a href="https://webaudio.github.io/web-audio-api/#dom-audionode-connect-destinationparam-output">connect() to an AudioParam - Web Audio API</a>
   */
  @JsOverlay
  @Nonnull
  public final AudioNode connect(@Nonnull AudioNode destinationNode) {
    return _connect( destinationNode ).asAudioNode();
  }

  @JsMethod(
      name = "connect"
  )
  @Nonnull
  public native AudioNodeOrUndefinedUnion _connect(@Nonnull AudioParam destinationParam,
      int output);

  /**
   * If the destination is a node, connect() returns a reference to the destination AudioNode object, allowing you to chain multiple connect() calls. In some browsers, older implementations of this interface return undefined.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/AudioNode/connect">AudioNode.connect - MDN</a>
   * @see <a href="https://webaudio.github.io/web-audio-api/#dom-audionode-connect">connect() to an AudioNode - Web Audio API</a>
   * @see <a href="https://webaudio.github.io/web-audio-api/#dom-audionode-connect-destinationparam-output">connect() to an AudioParam - Web Audio API</a>
   */
  @JsOverlay
  public final void connect(@Nonnull AudioParam destinationParam, int output) {
    _connect( destinationParam, output );
  }

  @JsMethod(
      name = "connect"
  )
  @Nonnull
  public native AudioNodeOrUndefinedUnion _connect(@Nonnull AudioParam destinationParam);

  /**
   * If the destination is a node, connect() returns a reference to the destination AudioNode object, allowing you to chain multiple connect() calls. In some browsers, older implementations of this interface return undefined.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/AudioNode/connect">AudioNode.connect - MDN</a>
   * @see <a href="https://webaudio.github.io/web-audio-api/#dom-audionode-connect">connect() to an AudioNode - Web Audio API</a>
   * @see <a href="https://webaudio.github.io/web-audio-api/#dom-audionode-connect-destinationparam-output">connect() to an AudioParam - Web Audio API</a>
   */
  @JsOverlay
  public final void connect(@Nonnull AudioParam destinationParam) {
    _connect( destinationParam );
  }
}
