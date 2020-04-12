package org.realityforge.webtack.model;

import java.io.IOException;
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
    return WebIDLModelParser.parse( ctx, Collections.emptyList(), parseStartPosition( ctx ) );
  }
}
