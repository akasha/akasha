package org.realityforge.webtack.model;

import java.io.IOException;
import java.util.List;
import javax.annotation.Nonnull;
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

  @Nonnull
  private DictionaryDefinition parse( @Nonnull final String webIDL )
    throws IOException
  {
    return WebIDLModelParser.parse( createParser( webIDL ).dictionary() );
  }
}
