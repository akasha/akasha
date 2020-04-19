package org.realityforge.webtack.model;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collections;
import javax.annotation.Nonnull;
import org.realityforge.webtack.webidl.parser.WebIDLParser;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class AsyncIterableMemberTest
  extends AbstractTest
{
  @Test
  public void parse()
    throws IOException
  {
    final AsyncIterableMember asyncIterableMember = parse( "async iterable<DOMString, object>;" );
    assertEquals( asyncIterableMember.getKeyType().getKind(), Kind.DOMString );
    assertEquals( asyncIterableMember.getValueType().getKind(), Kind.Object );
  }

  @SuppressWarnings( "SameParameterValue" )
  @Nonnull
  private AsyncIterableMember parse( @Nonnull final String webIDL )
    throws IOException
  {
    final WebIDLParser.AsyncIterableContext ctx = createParser( webIDL ).asyncIterable();
    final AsyncIterableMember actual =
      WebIDLModelParser.parse( ctx, Collections.emptyList(), parseStartPosition( ctx ) );
    final StringWriter writer = new StringWriter();

    WebIDLWriter.writeAsyncIterableMember( writer, actual );
    writer.close();
    final String emittedIDL = writer.toString();
    final WebIDLParser.AsyncIterableContext ctx2 = createParser( emittedIDL ).asyncIterable();
    final AsyncIterableMember element =
      WebIDLModelParser.parse( ctx2, Collections.emptyList(), parseStartPosition( ctx2 ) );
    assertEquals( element, actual );
    assertEquals( element.hashCode(), actual.hashCode() );
    assertTrue( element.equiv( actual ) );
    assertNotSame( element, actual );

    return actual;
  }
}
