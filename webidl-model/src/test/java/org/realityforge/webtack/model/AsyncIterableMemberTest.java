package org.realityforge.webtack.model;

import java.io.IOException;
import java.util.Collections;
import javax.annotation.Nonnull;
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

  @Nonnull
  private AsyncIterableMember parse( @Nonnull final String webIDL )
    throws IOException
  {
    return WebIDLModelParser.parse( createParser( webIDL ).asyncIterable(), Collections.emptyList() );
  }
}
