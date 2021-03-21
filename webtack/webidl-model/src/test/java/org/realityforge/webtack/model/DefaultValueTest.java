package org.realityforge.webtack.model;

import java.io.IOException;
import java.io.StringWriter;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class DefaultValueTest
  extends AbstractTest
{
  @Test
  public void parse()
    throws IOException
  {
    assertDefaultValue( "[]", DefaultValue.Kind.EmptySequence, null, null );
    assertDefaultValue( "{}", DefaultValue.Kind.EmptyDictionary, null, null );
    assertDefaultValue( "null", DefaultValue.Kind.Null, null, null );
    assertDefaultValue( "\"Zap\"", DefaultValue.Kind.Const, ConstValue.Kind.String, "Zap" );
    assertDefaultValue( "-Infinity", DefaultValue.Kind.Const, ConstValue.Kind.NegativeInfinity, null );
    assertDefaultValue( "-Infinity", DefaultValue.Kind.Const, ConstValue.Kind.NegativeInfinity, null );
    assertDefaultValue( "Infinity", DefaultValue.Kind.Const, ConstValue.Kind.PositiveInfinity, null );
    assertDefaultValue( "true", DefaultValue.Kind.Const, ConstValue.Kind.True, null );
    assertDefaultValue( "false", DefaultValue.Kind.Const, ConstValue.Kind.False, null );
    assertDefaultValue( "23.45", DefaultValue.Kind.Const, ConstValue.Kind.Decimal, "23.45" );
    assertDefaultValue( "23", DefaultValue.Kind.Const, ConstValue.Kind.Integer, "23" );
  }

  private void assertDefaultValue( @Nonnull final String webIDL,
                                   @Nonnull final DefaultValue.Kind kind,
                                   @Nullable final ConstValue.Kind constValueType,
                                   @Nullable final String value )
    throws IOException
  {
    final DefaultValue actual = WebIDLModelParser.parse( createParser( webIDL ).defaultValue() );
    assertEquals( actual.getKind(), kind );
    final ConstValue constValue = actual.getConstValue();
    assertEquals( null != constValue, null != constValueType );
    if ( null != constValue )
    {
      assertEquals( constValue.getKind(), constValueType );
      assertEquals( constValue.getValue(), value );
    }
    assertEquals( actual, actual );
    assertEquals( actual.hashCode(), actual.hashCode() );

    final StringWriter writer = new StringWriter();
    WebIDLWriter.writeDefaultValue( writer, actual );
    writer.close();
    final String emittedIDL = writer.toString();
    final DefaultValue element = WebIDLModelParser.parse( createParser( emittedIDL ).defaultValue() );
    assertEquals( element, actual );
    assertEquals( element.hashCode(), actual.hashCode() );

    assertTrue( element.equiv( actual ) );
    assertNotSame( element, actual );
  }
}
