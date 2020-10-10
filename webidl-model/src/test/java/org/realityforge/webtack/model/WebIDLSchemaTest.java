package org.realityforge.webtack.model;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nonnull;
import org.realityforge.webtack.webidl.parser.WebIDLParser;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class WebIDLSchemaTest
  extends AbstractTest
{
  @Test
  public void basicParse()
    throws IOException
  {
    // Parse an arbitrary schema ... just to make sure this does not crash
    final WebIDLSchema schema =
      parse( "partial interface Navigator {\n" +
             "  [SecureContext, SameObject] readonly attribute XR xr;\n" +
             "};\n" +
             "\n" +
             "[SecureContext, Exposed=Window] interface XR : EventTarget {\n" +
             "  // Methods\n" +
             "  Promise<boolean> isSessionSupported(XRSessionMode mode);\n" +
             "  [NewObject] Promise<XRSession> requestSession(XRSessionMode mode, optional XRSessionInit options = {});\n" +
             "\n" +
             "  // Events\n" +
             "  attribute EventHandler ondevicechange;\n" +
             "};\n" +
             "\n" +
             "enum XRSessionMode {\n" +
             "  \"inline\",\n" +
             "  \"immersive-vr\"\n" +
             "};\n" +
             "\n" +
             "dictionary XRSessionInit {\n" +
             "  sequence<any> requiredFeatures;\n" +
             "  sequence<any> optionalFeatures;\n" +
             "};\n" +
             "\n" +
             "enum XRVisibilityState {\n" +
             "  \"visible\",\n" +
             "  \"visible-blurred\",\n" +
             "  \"hidden\",\n" +
             "};\n" +
             "\n" +
             "[SecureContext, Exposed=Window] interface XRSession : EventTarget {\n" +
             "  // Attributes\n" +
             "  readonly attribute XRVisibilityState visibilityState;\n" +
             "  [SameObject] readonly attribute XRRenderState renderState;\n" +
             "  [SameObject] readonly attribute XRInputSourceArray inputSources;\n" +
             "\n" +
             "  // Methods\n" +
             "  void updateRenderState(optional XRRenderStateInit state = {});\n" +
             "  [NewObject] Promise<XRReferenceSpace> requestReferenceSpace(XRReferenceSpaceType type);\n" +
             "\n" +
             "  long requestAnimationFrame(XRFrameRequestCallback callback);\n" +
             "  void cancelAnimationFrame(long handle);\n" +
             "\n" +
             "  Promise<void> end();\n" +
             "\n" +
             "  // Events\n" +
             "  attribute EventHandler onend;\n" +
             "  attribute EventHandler onselect;\n" +
             "  attribute EventHandler oninputsourceschange;\n" +
             "  attribute EventHandler onselectstart;\n" +
             "  attribute EventHandler onselectend;\n" +
             "  attribute EventHandler onvisibilitychange;\n" +
             "};\n" +
             "\n" +
             "dictionary XRRenderStateInit {\n" +
             "  double depthNear;\n" +
             "  double depthFar;\n" +
             "  double inlineVerticalFieldOfView;\n" +
             "  XRWebGLLayer? baseLayer;\n" +
             "};\n" +
             "\n" +
             "[SecureContext, Exposed=Window] interface XRRenderState {\n" +
             "  readonly attribute double depthNear;\n" +
             "  readonly attribute double depthFar;\n" +
             "  readonly attribute double? inlineVerticalFieldOfView;\n" +
             "  readonly attribute XRWebGLLayer? baseLayer;\n" +
             "};\n" +
             "\n" +
             "callback XRFrameRequestCallback = void (DOMHighResTimeStamp time, XRFrame frame);\n" +
             "\n" +
             "[SecureContext, Exposed=Window] interface XRFrame {\n" +
             "  [SameObject] readonly attribute XRSession session;\n" +
             "\n" +
             "  XRViewerPose? getViewerPose(XRReferenceSpace referenceSpace);\n" +
             "  XRPose? getPose(XRSpace space, XRSpace baseSpace);\n" +
             "};\n" +
             "\n" +
             "[SecureContext, Exposed=Window] interface XRSpace : EventTarget {\n" +
             "\n" +
             "};\n" +
             "\n" +
             "enum XRReferenceSpaceType {\n" +
             "  \"viewer\",\n" +
             "  \"local\",\n" +
             "  \"local-floor\",\n" +
             "  \"bounded-floor\",\n" +
             "  \"unbounded\"\n" +
             "};\n" +
             "\n" +
             "[SecureContext, Exposed=Window]\n" +
             "interface XRReferenceSpace : XRSpace {\n" +
             "  [NewObject] XRReferenceSpace getOffsetReferenceSpace(XRRigidTransform originOffset);\n" +
             "\n" +
             "  attribute EventHandler onreset;\n" +
             "};\n" +
             "\n" +
             "[SecureContext, Exposed=Window]\n" +
             "interface XRBoundedReferenceSpace : XRReferenceSpace {\n" +
             "  readonly attribute FrozenArray<DOMPointReadOnly> boundsGeometry;\n" +
             "};\n" +
             "\n" +
             "enum XREye {\n" +
             "  \"none\",\n" +
             "  \"left\",\n" +
             "  \"right\"\n" +
             "};\n" +
             "\n" +
             "[SecureContext, Exposed=Window] interface XRView {\n" +
             "  readonly attribute XREye eye;\n" +
             "  readonly attribute Float32Array projectionMatrix;\n" +
             "  [SameObject] readonly attribute XRRigidTransform transform;\n" +
             "};\n" +
             "\n" +
             "[SecureContext, Exposed=Window] interface XRViewport {\n" +
             "  readonly attribute long x;\n" +
             "  readonly attribute long y;\n" +
             "  readonly attribute long width;\n" +
             "  readonly attribute long height;\n" +
             "};\n" +
             "\n" +
             "[SecureContext, Exposed=Window]\n" +
             "interface XRRigidTransform {\n" +
             "  constructor(optional DOMPointInit position = {}, optional DOMPointInit orientation = {});\n" +
             "  [SameObject, JavaAnnotation=\"com.example.MyAnnotation\"] readonly attribute DOMPointReadOnly position;\n" +
             "  [SameObject] readonly attribute DOMPointReadOnly orientation;\n" +
             "  readonly attribute Float32Array matrix;\n" +
             "  [SameObject] readonly attribute XRRigidTransform inverse;\n" +
             "};\n" +
             "\n" +
             "[SecureContext, Exposed=Window] interface XRPose {\n" +
             "  [SameObject] readonly attribute XRRigidTransform transform;\n" +
             "  readonly attribute boolean emulatedPosition;\n" +
             "};\n" +
             "\n" +
             "[SecureContext, Exposed=Window] interface XRViewerPose : XRPose {\n" +
             "  [SameObject] readonly attribute FrozenArray<XRView> views;\n" +
             "};\n" +
             "\n" +
             "enum XRHandedness {\n" +
             "  \"none\",\n" +
             "  \"left\",\n" +
             "  \"right\"\n" +
             "};\n" +
             "\n" +
             "enum XRTargetRayMode {\n" +
             "  \"gaze\",\n" +
             "  \"tracked-pointer\",\n" +
             "  \"screen\"\n" +
             "};\n" +
             "\n" +
             "[SecureContext, Exposed=Window]\n" +
             "interface XRInputSource {\n" +
             "  readonly attribute XRHandedness handedness;\n" +
             "  readonly attribute XRTargetRayMode targetRayMode;\n" +
             "  [SameObject] readonly attribute XRSpace targetRaySpace;\n" +
             "  [SameObject] readonly attribute XRSpace? gripSpace;\n" +
             "  [SameObject] readonly attribute FrozenArray<DOMString> profiles;\n" +
             "};\n" +
             "\n" +
             "[SecureContext, Exposed=Window]\n" +
             "interface XRInputSourceArray {\n" +
             "  iterable<XRInputSource>;\n" +
             "  readonly attribute unsigned long length;\n" +
             "  getter XRInputSource(unsigned long index);\n" +
             "};\n" +
             "\n" +
             "typedef (WebGLRenderingContext or\n" +
             "         WebGL2RenderingContext) XRWebGLRenderingContext;\n" +
             "\n" +
             "dictionary XRWebGLLayerInit {\n" +
             "  boolean antialias = true;\n" +
             "  boolean depth = true;\n" +
             "  boolean stencil = false;\n" +
             "  boolean alpha = true;\n" +
             "  boolean ignoreDepthValues = false;\n" +
             "  double framebufferScaleFactor = 1.0;\n" +
             "};\n" +
             "\n" +
             "[SecureContext, Exposed=Window]\n" +
             "interface XRWebGLLayer {\n" +
             "  constructor(XRSession session,\n" +
             "             XRWebGLRenderingContext context,\n" +
             "             optional XRWebGLLayerInit layerInit = {});\n" +
             "  // Attributes\n" +
             "  readonly attribute boolean antialias;\n" +
             "  readonly attribute boolean ignoreDepthValues;\n" +
             "\n" +
             "  [SameObject] readonly attribute WebGLFramebuffer framebuffer;\n" +
             "  readonly attribute unsigned long framebufferWidth;\n" +
             "  readonly attribute unsigned long framebufferHeight;\n" +
             "\n" +
             "  // Methods\n" +
             "  XRViewport? getViewport(XRView view);\n" +
             "\n" +
             "  // Static Methods\n" +
             "  static double getNativeFramebufferScaleFactor(XRSession session);\n" +
             "};\n" +
             "\n" +
             "partial dictionary WebGLContextAttributes {\n" +
             "    boolean xrCompatible = null;\n" +
             "};\n" +
             "\n" +
             "partial interface mixin WebGLRenderingContextBase {\n" +
             "    Promise<void> makeXRCompatible();\n" +
             "};\n" +
             "\n" +
             "[SecureContext, Exposed=Window]\n" +
             "interface XRSessionEvent : Event {\n" +
             "  constructor(DOMString type, XRSessionEventInit eventInitDict);\n" +
             "  [SameObject] readonly attribute XRSession session;\n" +
             "};\n" +
             "\n" +
             "dictionary XRSessionEventInit : EventInit {\n" +
             "  required XRSession session;\n" +
             "};\n" +
             "\n" +
             "[SecureContext, Exposed=Window]\n" +
             "interface XRInputSourceEvent : Event {\n" +
             "  constructor(DOMString type, XRInputSourceEventInit eventInitDict);\n" +
             "  [SameObject] readonly attribute XRFrame frame;\n" +
             "  [SameObject] readonly attribute XRInputSource inputSource;\n" +
             "};\n" +
             "\n" +
             "dictionary XRInputSourceEventInit : EventInit {\n" +
             "  required XRFrame frame;\n" +
             "  required XRInputSource inputSource;\n" +
             "};\n" +
             "\n" +
             "[SecureContext, Exposed=Window]\n" +
             "interface XRInputSourcesChangeEvent : Event {\n" +
             "  constructor(DOMString type, XRInputSourcesChangeEventInit eventInitDict);\n" +
             "  [SameObject] readonly attribute XRSession session;\n" +
             "  [SameObject] readonly attribute FrozenArray<XRInputSource> added;\n" +
             "  [SameObject] readonly attribute FrozenArray<XRInputSource> removed;\n" +
             "};\n" +
             "\n" +
             "dictionary XRInputSourcesChangeEventInit : EventInit {\n" +
             "  required XRSession session;\n" +
             "  required FrozenArray<XRInputSource> added;\n" +
             "  required FrozenArray<XRInputSource> removed;\n" +
             "\n" +
             "};\n" +
             "\n" +
             "[SecureContext, Exposed=Window]\n" +
             "interface XRReferenceSpaceEvent : Event {\n" +
             "  constructor(DOMString type, XRReferenceSpaceEventInit eventInitDict);\n" +
             "  [SameObject] readonly attribute XRReferenceSpace referenceSpace;\n" +
             "  [SameObject] readonly attribute XRRigidTransform? transform;\n" +
             "};\n" +
             "\n" +
             "dictionary XRReferenceSpaceEventInit : EventInit {\n" +
             "  required XRReferenceSpace referenceSpace;\n" +
             "  XRRigidTransform transform;\n" +
             "};",
             new HashSet<>( Arrays.asList( "name=xr", "size=big" ) ) );

    assertEquals( schema.getTags().size(), 2 );
    assertEquals( schema.getCallbacks().size(), 1 );
    assertEquals( schema.getCallbackInterfaces().size(), 0 );
    assertEquals( schema.getTypedefs().size(), 1 );
    assertEquals( schema.getNamespaces().size(), 0 );
    assertEquals( schema.getPartialNamespaces().size(), 0 );
    assertEquals( schema.getEnumerations().size(), 6 );
    assertEquals( schema.getDictionaries().size(), 7 );
    assertEquals( schema.getPartialDictionaries().size(), 1 );
    assertEquals( schema.getIncludes().size(), 0 );
    assertEquals( schema.getInterfaces().size(), 19 );
    assertEquals( schema.getPartialInterfaces().size(), 1 );
    assertEquals( schema.getMixins().size(), 0 );
    assertEquals( schema.getPartialMixins().size(), 1 );
  }

  @SuppressWarnings( "SameParameterValue" )
  @Nonnull
  private WebIDLSchema parse( @Nonnull final String webIDL,
                              @Nonnull final Set<String> tags )
    throws IOException
  {
    final WebIDLParser.WebIDLContext ctx = createParser( webIDL ).webIDL();
    final WebIDLSchema actual = WebIDLModelParser.parse( ctx, tags );
    assertEquals( actual, actual );
    assertEquals( actual.hashCode(), actual.hashCode() );

    final StringWriter writer = new StringWriter();
    WebIDLWriter.writeSchema( writer, actual );
    writer.close();
    final String emittedIDL = writer.toString();
    final WebIDLSchema element =
      WebIDLModelParser.parse( createParser( emittedIDL ).webIDL(), tags );
    assertEquals( element, element );
    assertEquals( element.hashCode(), element.hashCode() );

    assertTrue( element.equiv( actual ) );
    assertNotSame( element, actual );

    return actual;
  }
}
