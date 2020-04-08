package org.realityforge.webtack.model;

import java.io.IOException;
import java.util.Collections;
import javax.annotation.Nonnull;
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
    return WebIDLModelParser.parse( createParser( webIDL ).iterable(), Collections.emptyList() );
  }
}
