package org.realityforge.webtack.model.tools.processors.add_extended_attribute_to_member;

import javax.annotation.Nonnull;
import javax.json.Json;
import org.realityforge.webtack.model.tools.pipeline.ProgressListener;
import org.realityforge.webtack.model.tools.pipeline.TestProgressListener;
import org.realityforge.webtack.model.tools.processors.AbstractProcessorTest;
import org.realityforge.webtack.model.tools.spi.Processor;
import org.realityforge.webtack.model.tools.spi.Registry;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class AddExtendedAttributeToMemberProcessorTest
  extends AbstractProcessorTest
{
  @Test
  public void registry()
  {
    assertTrue( Registry.isProcessorPresent( "AddExtendedAttributeToMember" ) );
  }

  @Test
  public void basic()
    throws Exception
  {
    performStandardFixtureTest( "basic",
                                () -> createProcessor( new TestProgressListener(),
                                                       "^PostMessageOptions$",
                                                       "^transfer$",
                                                       "Transferable",
                                                       1 ) );
  }

  @Test
  public void enumeration_value()
    throws Exception
  {
    performStandardFixtureTest( "enumeration_value",
                                () -> createProcessor( new TestProgressListener(),
                                                       "^XMLHttpRequestResponseType$",
                                                       "^$",
                                                       "JavaName=default_text",
                                                       1 ) );
  }

  @Test
  public void operation()
    throws Exception
  {
    performStandardFixtureTest( "operation",
                                () -> createProcessor( new TestProgressListener(),
                                                       "^(WebGL2RenderingContext|WebGLRenderingContext)$",
                                                       "^getShaderSource$",
                                                       "JavaAnnotation=\"elemental3.gl.GLSL\"",
                                                       1 ) );
  }

  @Test
  public void basicBad_expectedAddCount()
    throws Exception
  {
    final TestProgressListener progressListener = new TestProgressListener();
    performStandardFixtureTest( "basic",
                                () -> createProcessor( progressListener,
                                                       "^PostMessageOptions$",
                                                       "^transfer$",
                                                       "Transferable",
                                                       2000 ) );
    progressListener.assertContains(
      "stageError(MyPipeline,MyStage): ERROR: Added 1 extended attributes but expected to add 2000 extended attributes." );
  }

  @SuppressWarnings( "SameParameterValue" )
  @Nonnull
  private Processor createProcessor( @Nonnull final ProgressListener progressListener,
                                     @Nonnull final String elementNamePattern,
                                     @Nonnull final String memberNamePattern,
                                     @Nonnull final String extendedAttribute,
                                     final int expectedAddCount )
  {
    return Registry.createProcessor( newPipelineContext( progressListener ),
                                     "AddExtendedAttributeToMember",
                                     Json
                                       .createObjectBuilder()
                                       .add( "expectedAddCount", expectedAddCount )
                                       .add( "elementNamePattern", elementNamePattern )
                                       .add( "memberNamePattern", memberNamePattern )
                                       .add( "extendedAttribute", extendedAttribute ).build() );
  }
}
