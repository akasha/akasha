package org.realityforge.webtack.model;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collections;
import java.util.HashSet;
import javax.annotation.Nonnull;
import org.realityforge.webtack.webidl.parser.WebIDLParser;
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

  @Test
  public void parseStaticAttributes()
    throws Exception
  {
    assertStaticAttribute( "static readonly attribute NotificationPermission permission;",
                           "permission",
                           Kind.TypeReference,
                           AttributeMember.Modifier.READ_ONLY,
                           AttributeMember.Modifier.STATIC );
    assertStaticAttribute( "static readonly attribute unsigned long maxActions;",
                           "maxActions",
                           Kind.UnsignedLong,
                           AttributeMember.Modifier.READ_ONLY,
                           AttributeMember.Modifier.STATIC );
    assertStaticAttribute( "static attribute boolean active;",
                           "active",
                           Kind.Boolean,
                           AttributeMember.Modifier.STATIC );
  }

  @Test
  public void parseStringifierAttributes()
    throws Exception
  {
    assertStringifierAttribute( "stringifier readonly attribute USVString href;",
                                "href",
                                Kind.USVString,
                                AttributeMember.Modifier.READ_ONLY,
                                AttributeMember.Modifier.STRINGIFIER );
    assertStringifierAttribute( "stringifier attribute DOMString value;",
                                "value",
                                Kind.DOMString,
                                AttributeMember.Modifier.STRINGIFIER );
  }

  private void assertInstanceAttribute( @Nonnull final String idl,
                                        @Nonnull final String name,
                                        @Nonnull final Kind kind,
                                        @Nonnull final AttributeMember.Modifier... modifiers )
    throws IOException
  {
    final WebIDLParser.ReadWriteAttributeContext ctx = createParser( idl ).readWriteAttribute();
    final AttributeMember member =
      WebIDLModelParser.parse( ctx, new HashSet<>(), Collections.emptyList(), parseStartPosition( ctx ) );
    assertAttributeMember( member, name, kind, modifiers );

    final StringWriter writer = new StringWriter();
    WebIDLWriter.writeAttributeMember( writer, member );
    writer.close();
    final String emittedIDL = writer.toString();
    final WebIDLParser.ReadWriteAttributeContext ctx2 = createParser( emittedIDL ).readWriteAttribute();
    final AttributeMember element =
      WebIDLModelParser.parse( ctx2, new HashSet<>(), Collections.emptyList(), parseStartPosition( ctx2 ) );
    assertEquals( element, member );
    assertEquals( element.hashCode(), member.hashCode() );
    assertTrue( element.equiv( member ) );
    assertNotSame( element, member );
  }

  private void assertStaticAttribute( @Nonnull final String idl,
                                      @Nonnull final String name,
                                      @Nonnull final Kind kind,
                                      @Nonnull final AttributeMember.Modifier... modifiers )
    throws IOException
  {
    final WebIDLParser.StaticMemberContext ctx = createParser( idl ).staticMember();
    final Member member = WebIDLModelParser.parse( ctx, Collections.emptyList(), parseStartPosition( ctx ) );
    assertTrue( member instanceof AttributeMember );
    assertAttributeMember( (AttributeMember) member, name, kind, modifiers );

    final StringWriter writer = new StringWriter();
    WebIDLWriter.writeAttributeMember( writer, (AttributeMember) member );
    writer.close();
    final String emittedIDL = writer.toString();
    final WebIDLParser.StaticMemberContext ctx2 = createParser( emittedIDL ).staticMember();
    final Member element =
      WebIDLModelParser.parse( ctx2, Collections.emptyList(), parseStartPosition( ctx2 ) );
    assertEquals( element, member );
    assertEquals( element.hashCode(), member.hashCode() );
    assertTrue( ( (AttributeMember) element ).equiv( (AttributeMember) member ) );
    assertNotSame( element, member );
  }

  private void assertStringifierAttribute( @Nonnull final String idl,
                                           @Nonnull final String name,
                                           @Nonnull final Kind kind,
                                           @Nonnull final AttributeMember.Modifier... modifiers )
    throws IOException
  {
    final WebIDLParser.StringifierContext ctx = createParser( idl ).stringifier();
    final Member member = WebIDLModelParser.parse( ctx, Collections.emptyList(), parseStartPosition( ctx ) );
    assertTrue( member instanceof AttributeMember );
    assertAttributeMember( (AttributeMember) member, name, kind, modifiers );

    final StringWriter writer = new StringWriter();
    WebIDLWriter.writeAttributeMember( writer, (AttributeMember) member );
    writer.close();
    final String emittedIDL = writer.toString();
    final WebIDLParser.StringifierContext ctx2 = createParser( emittedIDL ).stringifier();
    final Member element =
      WebIDLModelParser.parse( ctx2, Collections.emptyList(), parseStartPosition( ctx2 ) );
    assertEquals( element, member );
    assertEquals( element.hashCode(), member.hashCode() );
    assertTrue( ( (AttributeMember) element ).equiv( (AttributeMember) member ) );
    assertNotSame( element, member );
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
