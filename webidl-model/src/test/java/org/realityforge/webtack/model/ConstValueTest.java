package org.realityforge.webtack.model;

import java.io.IOException;
import java.io.StringWriter;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class ConstValueTest
  extends AbstractTest
{
  @Test
  public void parse()
    throws IOException
  {
    assertConstValue( "NaN", ConstValue.Kind.NaN, null );
    assertConstValue( "-Infinity", ConstValue.Kind.NegativeInfinity, null );
    assertConstValue( "Infinity", ConstValue.Kind.PositiveInfinity, null );
    assertConstValue( "true", ConstValue.Kind.True, null );
    assertConstValue( "false", ConstValue.Kind.False, null );
    assertConstValue( "23.45", ConstValue.Kind.Decimal, "23.45" );
    assertConstValue( "23", ConstValue.Kind.Integer, "23" );
  }

  private void assertConstValue( @Nonnull final String webIDL,
                                 @Nonnull final ConstValue.Kind kind,
                                 @Nullable final String value )
    throws IOException
  {
    final ConstValue constValue = WebIDLModelParser.parse( createParser( webIDL ).constMemberValue() );
    assertEquals( constValue.getKind(), kind );
    assertEquals( constValue.getValue(), value );

    final StringWriter writer = new StringWriter();
    constValue.write( writer );
    writer.close();
    final String emittedIDL = writer.toString();
    final ConstValue element = WebIDLModelParser.parse( createParser( emittedIDL ).constMemberValue() );
    assertEquals( element, constValue );
    assertEquals( element.hashCode(), constValue.hashCode() );
    assertTrue( element.equiv( constValue ) );
    assertNotSame( element, constValue );
  }
}
