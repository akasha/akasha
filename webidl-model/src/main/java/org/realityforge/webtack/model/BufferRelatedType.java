package org.realityforge.webtack.model;

import javax.annotation.Nonnull;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.realityforge.webtack.webidl.parser.WebIDLParser;

public final class BufferRelatedType
  extends NullableType
{
  @Nonnull
  public static final BufferRelatedType ARRAY_BUFFER = new BufferRelatedType( "ArrayBuffer" );
  @Nonnull
  public static final BufferRelatedType DATA_VIEW = new BufferRelatedType( "DataView" );
  @Nonnull
  public static final BufferRelatedType INT8_ARRAY = new BufferRelatedType( "Int8Array" );
  @Nonnull
  public static final BufferRelatedType INT16_ARRAY = new BufferRelatedType( "Int16Array" );
  @Nonnull
  public static final BufferRelatedType INT32_ARRAY = new BufferRelatedType( "Int32Array" );
  @Nonnull
  public static final BufferRelatedType UINT8_ARRAY = new BufferRelatedType( "Uint8Array" );
  @Nonnull
  public static final BufferRelatedType UINT16_ARRAY = new BufferRelatedType( "Uint16Array" );
  @Nonnull
  public static final BufferRelatedType UINT32_ARRAY = new BufferRelatedType( "Uint32Array" );
  @Nonnull
  public static final BufferRelatedType UINT8_CLAMPED_ARRAY = new BufferRelatedType( "Uint8ClampedArray" );
  @Nonnull
  public static final BufferRelatedType FLOAT32_ARRAY = new BufferRelatedType( "Float32Array" );
  @Nonnull
  public static final BufferRelatedType FLOAT64_ARRAY = new BufferRelatedType( "Float64Array" );

  @Nonnull
  public static BufferRelatedType parse( @Nonnull final WebIDLParser.BufferRelatedTypeContext ctx )
  {

    final TerminalNode child = (TerminalNode) ctx.getChild( 0 );
    final String literalName = child.getText();
    if ( ARRAY_BUFFER.getName().equals( literalName ) )
    {
      return ARRAY_BUFFER;
    }
    else if ( DATA_VIEW.getName().equals( literalName ) )
    {
      return DATA_VIEW;
    }
    else if ( INT8_ARRAY.getName().equals( literalName ) )
    {
      return INT8_ARRAY;
    }
    else if ( INT16_ARRAY.getName().equals( literalName ) )
    {
      return INT16_ARRAY;
    }
    else if ( INT32_ARRAY.getName().equals( literalName ) )
    {
      return INT32_ARRAY;
    }
    else if ( UINT8_ARRAY.getName().equals( literalName ) )
    {
      return UINT8_ARRAY;
    }
    else if ( UINT16_ARRAY.getName().equals( literalName ) )
    {
      return UINT16_ARRAY;
    }
    else if ( UINT32_ARRAY.getName().equals( literalName ) )
    {
      return UINT32_ARRAY;
    }
    else if ( UINT8_CLAMPED_ARRAY.getName().equals( literalName ) )
    {
      return UINT8_CLAMPED_ARRAY;
    }
    else if ( FLOAT32_ARRAY.getName().equals( literalName ) )
    {
      return FLOAT32_ARRAY;
    }
    else
    {
      assert FLOAT64_ARRAY.getName().equals( literalName );
      return FLOAT64_ARRAY;
    }
  }

  private BufferRelatedType( @Nonnull final String name )
  {
    super( name );
  }
}
