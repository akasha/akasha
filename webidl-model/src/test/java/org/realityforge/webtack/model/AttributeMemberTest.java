package org.realityforge.webtack.model;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
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
    assertAttributeMember( "attribute GLenum bufferBits;", "bufferBits", Kind.TypeReference );
    assertAttributeMember( "inherit attribute short rambaldi;",
                           "rambaldi",
                           Kind.Short,
                           AttributeMember.Modifier.INHERIT );
  }

  private void assertAttributeMember( @Nonnull final String idl,
                                      @Nonnull final String name,
                                      @Nonnull final Kind kind,
                                      @Nonnull final AttributeMember.Modifier... modifiers )
    throws IOException
  {
    final AttributeMember member = parse( idl );
    assertEquals( member.getName(), name );
    assertEquals( member.getType().getKind(), kind );
    assertEquals( member.getModifiers().size(), modifiers.length );
    for ( final AttributeMember.Modifier modifier : modifiers )
    {
      assertTrue( member.getModifiers().contains( modifier ), "Expected modifier " + modifier );
    }
    assertEquals( member.getModifiers().size(), modifiers.length );
  }

  @Nonnull
  private AttributeMember parse( @Nonnull final String webIDL )
    throws IOException
  {
    return WebIDLModelParser.parse( createParser( webIDL ).readWriteAttribute(),
                                    new HashSet<>(),
                                    Collections.emptyList() );
  }
}
