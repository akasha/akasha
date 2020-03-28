package org.realityforge.webtack.model;

import java.io.IOException;
import javax.annotation.Nonnull;
import org.realityforge.webtack.webidl.parser.WebIDLParser;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class BufferRelatedTypeTest
  extends AbstractTest
{
  @Test
  public void parse()
    throws Exception
  {
    assertParse( "ArrayBuffer", BufferRelatedType.ARRAY_BUFFER, false );
    assertParse( "DataView", BufferRelatedType.DATA_VIEW, false );
    assertParse( "Int8Array", BufferRelatedType.INT8_ARRAY, false );
    assertParse( "Int16Array", BufferRelatedType.INT16_ARRAY, false );
    assertParse( "Int32Array", BufferRelatedType.INT32_ARRAY, false );
    assertParse( "Uint8Array", BufferRelatedType.UINT8_ARRAY, false );
    assertParse( "Uint16Array", BufferRelatedType.UINT16_ARRAY, false );
    assertParse( "Uint32Array", BufferRelatedType.UINT32_ARRAY, false );
    assertParse( "Uint8ClampedArray", BufferRelatedType.UINT8_CLAMPED_ARRAY, false );
    assertParse( "Float32Array", BufferRelatedType.FLOAT32_ARRAY, false );
    assertParse( "Float64Array", BufferRelatedType.FLOAT64_ARRAY, false );

    assertParse( "ArrayBuffer", BufferRelatedType.NULLABLE_ARRAY_BUFFER, true );
    assertParse( "DataView", BufferRelatedType.NULLABLE_DATA_VIEW, true );
    assertParse( "Int8Array", BufferRelatedType.NULLABLE_INT8_ARRAY, true );
    assertParse( "Int16Array", BufferRelatedType.NULLABLE_INT16_ARRAY, true );
    assertParse( "Int32Array", BufferRelatedType.NULLABLE_INT32_ARRAY, true );
    assertParse( "Uint8Array", BufferRelatedType.NULLABLE_UINT8_ARRAY, true );
    assertParse( "Uint16Array", BufferRelatedType.NULLABLE_UINT16_ARRAY, true );
    assertParse( "Uint32Array", BufferRelatedType.NULLABLE_UINT32_ARRAY, true );
    assertParse( "Uint8ClampedArray", BufferRelatedType.NULLABLE_UINT8_CLAMPED_ARRAY, true );
    assertParse( "Float32Array", BufferRelatedType.NULLABLE_FLOAT32_ARRAY, true );
    assertParse( "Float64Array", BufferRelatedType.NULLABLE_FLOAT64_ARRAY, true );
  }

  private void assertParse( @Nonnull final String idl,
                            @Nonnull final BufferRelatedType expected,
                            final boolean nullable )
    throws IOException
  {
    final WebIDLParser parser = createParser( idl );
    final BufferRelatedType actual = BufferRelatedType.parse( parser.bufferRelatedType(), nullable );
    assertEquals( actual, expected );
    assertEquals( actual.getTypeName(), idl );
    assertEquals( actual.isNullable(), nullable );
  }
}
