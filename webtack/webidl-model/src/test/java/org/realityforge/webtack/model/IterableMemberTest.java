package org.realityforge.webtack.model;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collections;
import javax.annotation.Nonnull;
import org.realityforge.webtack.webidl.parser.WebIDLParser;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class IterableMemberTest
  extends AbstractTest
{
  @Test
  public void parse()
    throws IOException
  {
    {
      final IterableMember member = parse( " iterable<DOMString, object>;" );
      final Type keyType = member.getKeyType();
      assertNotNull( keyType );
      assertEquals( keyType.getKind(), Kind.DOMString );
      assertEquals( member.getValueType().getKind(), Kind.Object );
    }
    {
      final IterableMember member = parse( " iterable<DOMString>;" );
      final Type keyType = member.getKeyType();
      assertNull( keyType );
      assertEquals( member.getValueType().getKind(), Kind.DOMString );
    }
  }

  @Nonnull
  private IterableMember parse( @Nonnull final String webIDL )
    throws IOException
  {
    final WebIDLParser.IterableContext ctx = createParser( webIDL ).iterable();
    final IterableMember actual =
      WebIDLModelParser.parse( ctx, null, Collections.emptyList(), parseStartPosition( ctx ) );

    assertEquals( actual, actual );
    assertEquals( actual.hashCode(), actual.hashCode() );

    final StringWriter writer = new StringWriter();
    WebIDLWriter.writeIterableMember( writer, actual );
    writer.close();
    final String emittedIDL = writer.toString();
    final WebIDLParser.IterableContext ctx2 = createParser( emittedIDL ).iterable();
    final IterableMember element =
      WebIDLModelParser.parse( ctx2, null, Collections.emptyList(), parseStartPosition( ctx2 ) );
    assertEquals( element, element );
    assertEquals( element.hashCode(), element.hashCode() );

    assertTrue( element.equiv( actual ) );
    assertNotSame( element, actual );

    return actual;
  }
}
