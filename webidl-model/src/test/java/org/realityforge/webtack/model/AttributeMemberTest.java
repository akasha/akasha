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
  public void parseInstanceAttributes()
    throws Exception
  {
    assertInstanceAttribute( "attribute short rambaldi;", "rambaldi", Kind.Short );
    assertInstanceAttribute( "attribute DOMString name;", "name", Kind.DOMString );
    assertInstanceAttribute( "attribute boolean async;", "async", Kind.Boolean );
    assertInstanceAttribute( "attribute boolean required;", "required", Kind.Boolean );
    assertInstanceAttribute( "attribute GLenum bufferBits;", "bufferBits", Kind.TypeReference );
    assertInstanceAttribute( "inherit attribute short rambaldi;",
                             "rambaldi",
                             Kind.Short,
                             AttributeMember.Modifier.INHERIT );
  }

  private void assertInstanceAttribute( @Nonnull final String idl,
                                        @Nonnull final String name,
                                        @Nonnull final Kind kind,
                                        @Nonnull final AttributeMember.Modifier... modifiers )
    throws IOException
  {
    final AttributeMember member =
      WebIDLModelParser.parse( createParser( idl ).readWriteAttribute(),
                               new HashSet<>(),
                               Collections.emptyList() );
    assertAttributeMember( member, name, kind, modifiers );
  }

  private void assertAttributeMember( @Nonnull final AttributeMember member,
                                      @Nonnull final String name,
                                      @Nonnull final Kind kind,
                                      @Nonnull final AttributeMember.Modifier[] modifiers )
  {
    assertEquals( member.getName(), name );
    assertEquals( member.getType().getKind(), kind );
    assertEquals( member.getModifiers().size(), modifiers.length );
    for ( final AttributeMember.Modifier modifier : modifiers )
    {
      assertTrue( member.getModifiers().contains( modifier ), "Expected modifier " + modifier );
    }
  }
}
