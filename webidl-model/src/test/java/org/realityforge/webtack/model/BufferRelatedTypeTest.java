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
    assertParse( "ArrayBuffer", BufferRelatedType.ARRAY_BUFFER );
    assertParse( "DataView", BufferRelatedType.DATA_VIEW );
    assertParse( "Int8Array", BufferRelatedType.INT8_ARRAY );
    assertParse( "Int16Array", BufferRelatedType.INT16_ARRAY );
    assertParse( "Int32Array", BufferRelatedType.INT32_ARRAY );
    assertParse( "Uint8Array", BufferRelatedType.UINT8_ARRAY );
    assertParse( "Uint16Array", BufferRelatedType.UINT16_ARRAY );
    assertParse( "Uint32Array", BufferRelatedType.UINT32_ARRAY );
    assertParse( "Uint8ClampedArray", BufferRelatedType.UINT8_CLAMPED_ARRAY );
    assertParse( "Float32Array", BufferRelatedType.FLOAT32_ARRAY );
    assertParse( "Float64Array", BufferRelatedType.FLOAT64_ARRAY );
  }

  private void assertParse( @Nonnull final String idl, @Nonnull final BufferRelatedType expected )
    throws IOException
  {
    final WebIDLParser parser = createParser( idl );
    final BufferRelatedType actual = BufferRelatedType.parse( parser.bufferRelatedType() );
    assertEquals( actual, expected );
    assertEquals( actual.getName(), idl );
  }
}
