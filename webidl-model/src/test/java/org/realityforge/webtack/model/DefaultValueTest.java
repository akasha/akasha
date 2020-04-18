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
    assertDefaultValue( "[]", DefaultValue.Kind.EmptySequence, null, null );
    assertDefaultValue( "{}", DefaultValue.Kind.EmptyDictionary, null, null );
    assertDefaultValue( "null", DefaultValue.Kind.Null, null, null );
    assertDefaultValue( "\"Zap\"", DefaultValue.Kind.String, null, "Zap" );
    assertDefaultValue( "-Infinity", DefaultValue.Kind.Const, ConstValue.Kind.NegativeInfinity, null );
    assertDefaultValue( "-Infinity", DefaultValue.Kind.Const, ConstValue.Kind.NegativeInfinity, null );
    assertDefaultValue( "Infinity", DefaultValue.Kind.Const, ConstValue.Kind.PositiveInfinity, null );
    assertDefaultValue( "true", DefaultValue.Kind.Const, ConstValue.Kind.True, null );
    assertDefaultValue( "false", DefaultValue.Kind.Const, ConstValue.Kind.False, null );
    assertDefaultValue( "23.45", DefaultValue.Kind.Const, ConstValue.Kind.Decimal, null );
    assertDefaultValue( "23", DefaultValue.Kind.Const, ConstValue.Kind.Integer, null );
  }

  private void assertDefaultValue( @Nonnull final String webIDL,
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
