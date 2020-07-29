package org.realityforge.webtack.model;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;
import org.realityforge.webtack.webidl.parser.WebIDLParser;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class TypedefDefinitionTest
  extends AbstractTest
{
  @Test
  public void parse()
    throws IOException
  {
    assertTypedef( "typedef long long GLint64;", "GLint64", Kind.LongLong );
    assertTypedef( "typedef unsigned long long GLuint64;", "GLuint64", Kind.UnsignedLongLong );
    assertTypedef( "typedef (DOMString or Blob) ClipboardItemDataType;", "ClipboardItemDataType", Kind.Union );
    assertTypedef( "typedef (WebGLRenderingContext or WebGL2RenderingContext) XRWebGLRenderingContext;",
                   "XRWebGLRenderingContext",
                   Kind.Union );
    assertTypedef( "typedef sequence<ClipboardItem> ClipboardItems;", "ClipboardItems", Kind.Sequence );
  }

  private void assertTypedef( @Nonnull final String webIDL, @Nonnull final String name, @Nonnull final Kind kind )
    throws IOException
  {
    final TypedefDefinition typedefModel = parse( webIDL );
    assertEquals( typedefModel.getName(), name );
    assertEquals( typedefModel.getType().getKind(), kind );
  }

  @Nonnull
  private TypedefDefinition parse( @Nonnull final String webIDL )
    throws IOException
  {
    final WebIDLParser.TypedefContext ctx = createParser( webIDL ).typedef();
    final TypedefDefinition actual =
      WebIDLModelParser.parse( ctx, null, Collections.emptyList(), parseStartPosition( ctx ) );
    assertEquals( actual, actual );
    assertEquals( actual.hashCode(), actual.hashCode() );

    final StringWriter writer = new StringWriter();
    WebIDLWriter.writeTypedefDefinition( writer, actual );
    writer.close();
    final String emittedIDL = writer.toString();
    final List<Definition> definitions = WebIDLModelParser.parse( createParser( emittedIDL ).definitions() );
    assertEquals( definitions.size(), 1 );
    final Definition definition = definitions.get( 0 );
    assertTrue( definition instanceof TypedefDefinition );
    final TypedefDefinition element = (TypedefDefinition) definition;
    assertEquals( element, element );
    assertEquals( element.hashCode(), element.hashCode() );

    assertTrue( element.equiv( actual ) );
    assertNotSame( element, actual );

    return actual;
  }
}
