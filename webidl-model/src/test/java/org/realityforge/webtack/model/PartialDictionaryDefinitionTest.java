package org.realityforge.webtack.model;

import java.io.IOException;
import java.util.List;
import javax.annotation.Nonnull;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class PartialDictionaryDefinitionTest
  extends AbstractTest
{
  @Test
  public void parse()
    throws IOException
  {
    final PartialDictionaryDefinition dictionary =
      parse( "partial dictionary CredentialRequestOptions {\n" +
             "  boolean password = false;\n" +
             "};" );
    assertEquals( dictionary.getName(), "CredentialRequestOptions" );
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

  @SuppressWarnings( "SameParameterValue" )
  @Nonnull
  private PartialDictionaryDefinition parse( @Nonnull final String webIDL )
    throws IOException
  {
    final Definition definition =
      WebIDLModelParser.parse( createParser( webIDL ).definitions() ).get( 0 );
    assertTrue( definition instanceof PartialDictionaryDefinition );
    return (PartialDictionaryDefinition) definition;
  }
}
