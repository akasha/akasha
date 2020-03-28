package org.realityforge.webtack.model;

import javax.annotation.Nonnull;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.realityforge.webtack.webidl.parser.WebIDLParser;

public final class BufferRelatedType
  extends Type
{
  @Nonnull
  public static final BufferRelatedType ARRAY_BUFFER = new BufferRelatedType( "ArrayBuffer", false );
  @Nonnull
  public static final BufferRelatedType NULLABLE_ARRAY_BUFFER = new BufferRelatedType( "ArrayBuffer", true );
  @Nonnull
  public static final BufferRelatedType DATA_VIEW = new BufferRelatedType( "DataView", false );
  @Nonnull
  public static final BufferRelatedType NULLABLE_DATA_VIEW = new BufferRelatedType( "DataView", true );
  @Nonnull
  public static final BufferRelatedType INT8_ARRAY = new BufferRelatedType( "Int8Array", false );
  @Nonnull
  public static final BufferRelatedType NULLABLE_INT8_ARRAY = new BufferRelatedType( "Int8Array", true );
  @Nonnull
  public static final BufferRelatedType INT16_ARRAY = new BufferRelatedType( "Int16Array", false );
  @Nonnull
  public static final BufferRelatedType NULLABLE_INT16_ARRAY = new BufferRelatedType( "Int16Array", true );
  @Nonnull
  public static final BufferRelatedType INT32_ARRAY = new BufferRelatedType( "Int32Array", false );
  @Nonnull
  public static final BufferRelatedType NULLABLE_INT32_ARRAY = new BufferRelatedType( "Int32Array", true );
  @Nonnull
  public static final BufferRelatedType UINT8_ARRAY = new BufferRelatedType( "Uint8Array", false );
  @Nonnull
  public static final BufferRelatedType NULLABLE_UINT8_ARRAY = new BufferRelatedType( "Uint8Array", true );
  @Nonnull
  public static final BufferRelatedType UINT16_ARRAY = new BufferRelatedType( "Uint16Array", false );
  @Nonnull
  public static final BufferRelatedType NULLABLE_UINT16_ARRAY = new BufferRelatedType( "Uint16Array", true );
  @Nonnull
  public static final BufferRelatedType UINT32_ARRAY = new BufferRelatedType( "Uint32Array", false );
  @Nonnull
  public static final BufferRelatedType NULLABLE_UINT32_ARRAY = new BufferRelatedType( "Uint32Array", true );
  @Nonnull
  public static final BufferRelatedType UINT8_CLAMPED_ARRAY = new BufferRelatedType( "Uint8ClampedArray", false );
  @Nonnull
  public static final BufferRelatedType NULLABLE_UINT8_CLAMPED_ARRAY = new BufferRelatedType( "Uint8ClampedArray", true );
  @Nonnull
  public static final BufferRelatedType FLOAT32_ARRAY = new BufferRelatedType( "Float32Array", false );
  @Nonnull
  public static final BufferRelatedType NULLABLE_FLOAT32_ARRAY = new BufferRelatedType( "Float32Array", true );
  @Nonnull
  public static final BufferRelatedType FLOAT64_ARRAY = new BufferRelatedType( "Float64Array", false );
  @Nonnull
  public static final BufferRelatedType NULLABLE_FLOAT64_ARRAY = new BufferRelatedType( "Float64Array", true );

  @Nonnull
  public static BufferRelatedType parse( @Nonnull final WebIDLParser.BufferRelatedTypeContext ctx, final boolean nullable )
  {

    final TerminalNode child = (TerminalNode) ctx.getChild( 0 );
    final String literalName = child.getText();
    if ( ARRAY_BUFFER.getTypeName().equals( literalName ) )
    {
      return nullable ? NULLABLE_ARRAY_BUFFER : ARRAY_BUFFER;
    }
    else if ( DATA_VIEW.getTypeName().equals( literalName ) )
    {
      return nullable ? NULLABLE_DATA_VIEW : DATA_VIEW;
    }
    else if ( INT8_ARRAY.getTypeName().equals( literalName ) )
    {
      return nullable ? NULLABLE_INT8_ARRAY : INT8_ARRAY;
    }
    else if ( INT16_ARRAY.getTypeName().equals( literalName ) )
    {
      return nullable ? NULLABLE_INT16_ARRAY : INT16_ARRAY;
    }
    else if ( INT32_ARRAY.getTypeName().equals( literalName ) )
    {
      return nullable ? NULLABLE_INT32_ARRAY : INT32_ARRAY;
    }
    else if ( UINT8_ARRAY.getTypeName().equals( literalName ) )
    {
      return nullable ? NULLABLE_UINT8_ARRAY : UINT8_ARRAY;
    }
    else if ( UINT16_ARRAY.getTypeName().equals( literalName ) )
    {
      return nullable ? NULLABLE_UINT16_ARRAY : UINT16_ARRAY;
    }
    else if ( UINT32_ARRAY.getTypeName().equals( literalName ) )
    {
      return nullable ? NULLABLE_UINT32_ARRAY : UINT32_ARRAY;
    }
    else if ( UINT8_CLAMPED_ARRAY.getTypeName().equals( literalName ) )
    {
      return nullable ? NULLABLE_UINT8_CLAMPED_ARRAY : UINT8_CLAMPED_ARRAY;
    }
    else if ( FLOAT32_ARRAY.getTypeName().equals( literalName ) )
    {
      return nullable ? NULLABLE_FLOAT32_ARRAY : FLOAT32_ARRAY;
    }
    else
    {
      assert FLOAT64_ARRAY.getTypeName().equals( literalName );
      return nullable ? NULLABLE_FLOAT64_ARRAY : FLOAT64_ARRAY;
    }
  }

  private BufferRelatedType( @Nonnull final String name, final boolean nullable )
  {
    super( name, nullable );
  }
}
