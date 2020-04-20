package org.realityforge.webtack.model;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import javax.annotation.Nonnull;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class DictionaryMemberTest
  extends AbstractTest
{
  @Test
  public void parseOptional()
    throws IOException
  {
    final DictionaryMember member = parse( "boolean antialias = true;" );
    assertEquals( member.getName(), "antialias" );
    assertEquals( member.getType().getKind(), Kind.Boolean );
    assertTrue( member.isOptional() );
    final DefaultValue defaultValue = member.getDefaultValue();
    assertNotNull( defaultValue );
    assertEquals( defaultValue.getKind(), DefaultValue.Kind.Const );
    final ConstValue constValue = defaultValue.getConstValue();
    assertNotNull( constValue );
    assertEquals( constValue.getKind(), ConstValue.Kind.True );
  }

  @Test
  public void parseRequired()
    throws IOException
  {
    final DictionaryMember member = parse( "required unsigned short errorCode;" );
    assertEquals( member.getName(), "errorCode" );
    assertEquals( member.getType().getKind(), Kind.UnsignedShort );
    assertFalse( member.isOptional() );
    assertNull( member.getDefaultValue() );
  }

  @Test
  public void parseList()
    throws IOException
  {
    final String webIDL = "  USVString name;\n" +
                          "  USVString iconURL;\n" +
                          "  required USVString origin;\n" +
                          "};\n";
    final List<DictionaryMember> members = WebIDLModelParser.parse( createParser( webIDL ).dictionaryMembers() );
    assertEquals( members.size(), 3 );
    {
      final DictionaryMember member = members.get( 0 );
      assertEquals( member.getName(), "name" );
      assertEquals( member.getType().getKind(), Kind.USVString );
      assertTrue( member.isOptional() );
      assertNull( member.getDefaultValue() );
    }
    {
      final DictionaryMember member = members.get( 1 );
      assertEquals( member.getName(), "iconURL" );
      assertEquals( member.getType().getKind(), Kind.USVString );
      assertTrue( member.isOptional() );
      assertNull( member.getDefaultValue() );
    }
    {
      final DictionaryMember member = members.get( 2 );
      assertEquals( member.getName(), "origin" );
      assertEquals( member.getType().getKind(), Kind.USVString );
      assertFalse( member.isOptional() );
      assertNull( member.getDefaultValue() );
    }
  }

  @Nonnull
  private DictionaryMember parse( @Nonnull final String webIDL )
    throws IOException
  {
    final DictionaryMember actual = WebIDLModelParser.parse( createParser( webIDL ).dictionaryMember() );
    assertEquals( actual, actual );
    assertEquals( actual.hashCode(), actual.hashCode() );

    final StringWriter writer = new StringWriter();
    WebIDLWriter.writeDictionaryMember( writer, actual );
    writer.close();
    final String emittedIDL = writer.toString();
    final DictionaryMember element = WebIDLModelParser.parse( createParser( emittedIDL ).dictionaryMember() );
    assertEquals( element, actual );
    assertEquals( element.hashCode(), actual.hashCode() );

    assertTrue( element.equiv( actual ) );
    assertNotSame( element, actual );

    return actual;
  }
}
