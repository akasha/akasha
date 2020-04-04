package org.realityforge.webtack.model;

import java.io.IOException;
import java.util.Collections;
import javax.annotation.Nonnull;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class AttributeMemberTest
  extends AbstractTest
{
  @Test
  public void parse()
    throws Exception
  {
    assertAttributeMember( "attribute short rambaldi;", "rambaldi", Kind.Short );
    assertAttributeMember( "attribute DOMString name;", "name", Kind.DOMString );
    assertAttributeMember( "attribute boolean async;", "async", Kind.Boolean );
    assertAttributeMember( "attribute boolean required;", "required", Kind.Boolean );
    assertAttributeMember( "attributeGLenum bufferBits;", "bufferBits", Kind.TypeReference );
  }

  private void assertAttributeMember( @Nonnull final String idl,
                                      @Nonnull final String name,
                                      @Nonnull final Kind kind )
    throws IOException
  {
    final AttributeMember member = parse( idl );
    assertEquals( member.getName(), name );
    assertEquals( member.getType().getKind(), kind );
  }

  @Nonnull
  private AttributeMember parse( @Nonnull final String webIDL )
    throws IOException
  {
    return WebIDLModelParser.parse( createParser( webIDL ).attributeRest(), Collections.emptyList() );
  }
}
