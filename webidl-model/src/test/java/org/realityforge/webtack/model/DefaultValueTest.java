package org.realityforge.webtack.model;

import java.io.IOException;
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
    assertConstValue( "[]", DefaultValue.Kind.EmptySequence, null, null );
    assertConstValue( "{}", DefaultValue.Kind.EmptyDictionary, null, null );
    assertConstValue( "null", DefaultValue.Kind.Null, null, null );
    assertConstValue( "\"Zap\"", DefaultValue.Kind.String, null, "Zap" );
    assertConstValue( "-Infinity", DefaultValue.Kind.Const, ConstValue.Kind.NegativeInfinity, null );
    assertConstValue( "-Infinity", DefaultValue.Kind.Const, ConstValue.Kind.NegativeInfinity, null );
    assertConstValue( "Infinity", DefaultValue.Kind.Const, ConstValue.Kind.PositiveInfinity, null );
    assertConstValue( "true", DefaultValue.Kind.Const, ConstValue.Kind.True, null );
    assertConstValue( "false", DefaultValue.Kind.Const, ConstValue.Kind.False, null );
    assertConstValue( "23.45", DefaultValue.Kind.Const, ConstValue.Kind.Decimal, null );
    assertConstValue( "23", DefaultValue.Kind.Const, ConstValue.Kind.Integer, null );
  }

  private void assertConstValue( @Nonnull final String webIDL,
                                 @Nonnull final DefaultValue.Kind kind,
                                 @Nullable final ConstValue.Kind constValueType,
                                 @Nullable final String stringValue )
    throws IOException
  {
    final DefaultValue defaultValue = WebIDLModelParser.parse( createParser( webIDL ).defaultValue() );
    assertEquals( defaultValue.getKind(), kind );
    final ConstValue constValue = defaultValue.getConstValue();
    assertEquals( null != constValue, null != constValueType );
    if ( null != constValue )
    {
      assertEquals( constValue.getKind(), constValueType );
    }
    assertEquals( defaultValue.getStringValue(), stringValue );
  }
}
