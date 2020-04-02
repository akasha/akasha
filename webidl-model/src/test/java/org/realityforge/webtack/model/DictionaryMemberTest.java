package org.realityforge.webtack.model;

import java.io.IOException;
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

  @Nonnull
  private DictionaryMember parse( @Nonnull final String webIDL )
    throws IOException
  {
    return WebIDLModelParser.parse( createParser( webIDL ).dictionaryMember() );
  }
}
