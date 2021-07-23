package org.realityforge.webtack.model;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import org.realityforge.webtack.webidl.parser.WebIDLParser;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class DictionaryTest
  extends AbstractTest
{
  @Test
  public void parseWithoutInherits()
    throws IOException
  {
    final DictionaryDefinition dictionary =
      parse( "dictionary CredentialRequestOptions {\n" +
             "  boolean password = false;\n" +
             "};" );
    assertEquals( dictionary.getName(), "CredentialRequestOptions" );
    assertNull( dictionary.getInherits() );
    final List<DictionaryMember> members = dictionary.getMembers();
    assertEquals( members.size(), 1 );

    final DictionaryMember member = members.get( 0 );
    assertEquals( member.getName(), "password" );
    assertEquals( member.getType().getKind(), Kind.Boolean );
    assertTrue( member.isOptional() );
    final DefaultValue defaultValue = member.getDefaultValue();
    assertNotNull( defaultValue );
    assertEquals( defaultValue.getKind(), DefaultValue.Kind.Const );
    final ConstValue constValue = defaultValue.getConstValue();
    assertNotNull( constValue );
    assertEquals( constValue.getKind(), ConstValue.Kind.False );
  }

  @Test
  public void parseWithInherits()
    throws IOException
  {
    final DictionaryDefinition dictionary =
      parse( "dictionary XRReferenceSpaceEventInit : EventInit {\n" +
             "  required short referenceSpace;\n" +
             "  long transform;\n" +
             "};\n" );
    assertEquals( dictionary.getName(), "XRReferenceSpaceEventInit" );
    assertEquals( dictionary.getInherits(), "EventInit" );
    final List<DictionaryMember> members = dictionary.getMembers();
    assertEquals( members.size(), 2 );

    {
      final DictionaryMember member = members.get( 0 );
      assertEquals( member.getName(), "referenceSpace" );
      assertEquals( member.getType().getKind(), Kind.Short );
      assertFalse( member.isOptional() );
      assertNull( member.getDefaultValue() );
    }
    {
      final DictionaryMember member = members.get( 1 );
      assertEquals( member.getName(), "transform" );
      assertEquals( member.getType().getKind(), Kind.Long );
      assertTrue( member.isOptional() );
      assertNull( member.getDefaultValue() );
    }
  }

  @Test
  public void parseRetainingRequiredMembersDeclaredOrdering()
    throws IOException
  {
    final DictionaryDefinition dictionary =
      writeThenRead( parse( "dictionary ColorInit {\n" +
                            "  required short r;\n" +
                            "  required short g;\n" +
                            "  required short b;\n" +
                            "  required short a;\n" +
                            "  long t;\n" +
                            "  long s;\n" +
                            "};\n" ) );
    assertEquals( dictionary.getName(), "ColorInit" );
    assertNull( dictionary.getInherits() );
    final List<DictionaryMember> members = dictionary.getMembers();

    assertEquals( members.size(), 6 );

    assertEquals( members.get( 0 ).getName(), "r" );
    assertEquals( members.get( 1 ).getName(), "g" );
    assertEquals( members.get( 2 ).getName(), "b" );
    assertEquals( members.get( 3 ).getName(), "a" );
    // Non-required members are sorted by name
    assertEquals( members.get( 4 ).getName(), "s" );
    assertEquals( members.get( 5 ).getName(), "t" );

    assertEquals( members.stream().map( NamedElement::getName ).collect( Collectors.joining() ), "rgbast" );
  }

  @Nonnull
  private DictionaryDefinition parse( @Nonnull final String webIDL )
    throws IOException
  {
    final WebIDLParser.DictionaryContext ctx = createParser( webIDL ).dictionary();
    final DictionaryDefinition actual =
      WebIDLModelParser.parse( ctx, null, Collections.emptyList(), parseStartPosition( ctx ) );
    assertEquals( actual, actual );
    assertEquals( actual.hashCode(), actual.hashCode() );

    final DictionaryDefinition definition = writeThenRead( actual );
    assertEquals( definition, definition );
    assertEquals( definition.hashCode(), definition.hashCode() );

    assertTrue( definition.equiv( actual ) );
    assertNotSame( definition, actual );

    return actual;
  }

  @Nonnull
  private DictionaryDefinition writeThenRead( @Nonnull final DictionaryDefinition definition )
    throws IOException
  {
    final StringWriter writer = new StringWriter();
    WebIDLWriter.writeDictionaryDefinition( writer, definition );
    writer.close();
    final String emittedIDL = writer.toString();
    final List<Definition> definitions = WebIDLModelParser.parse( createParser( emittedIDL ).definitions() );
    assertEquals( definitions.size(), 1 );
    final Definition element = definitions.get( 0 );
    assertTrue( element instanceof DictionaryDefinition );
    return (DictionaryDefinition) element;
  }
}
