package org.realityforge.webtack.model;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;

public class Type
  extends Element
{
  @Nonnull
  private final Kind _kind;
  private final boolean _nullable;

  Type( @Nonnull final Kind kind,
        @Nonnull final List<ExtendedAttribute> extendedAttributes,
        final boolean nullable,
        @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( extendedAttributes, sourceLocations );
    _kind = Objects.requireNonNull( kind );
    _nullable = nullable;
    assert _kind.isNullableAllowed() || !isNullable();
    assert ( Kind.Sequence == _kind ) == ( this instanceof SequenceType );
    assert ( Kind.FrozenArray == _kind ) == ( this instanceof FrozenArrayType );
    assert ( Kind.TypeReference == _kind ) == ( this instanceof TypeReference );
    assert ( Kind.Promise == _kind ) == ( this instanceof PromiseType );
    assert ( Kind.Record == _kind ) == ( this instanceof RecordType );
    assert ( Kind.Union == _kind ) == ( this instanceof UnionType );
  }

  @Nonnull
  public final Kind getKind()
  {
    return _kind;
  }

  public final boolean isNullable()
  {
    return _nullable;
  }

  @Override
  public final boolean equals( final Object o )
  {
    if ( this == o )
    {
      return true;
    }
    else if ( o == null || getClass() != o.getClass() )
    {
      return false;
    }
    else
    {
      final Type other = (Type) o;
      if ( _nullable != other._nullable ||
           _kind != other._kind ||
           !Objects.equals( getExtendedAttributes(), other.getExtendedAttributes() ) )
      {
        return false;
      }
      else
      {
        switch ( _kind )
        {
          case FrozenArray:
            return ( (FrozenArrayType) this ).getItemType().equals( ( (FrozenArrayType) other ).getItemType() );
          case Sequence:
            return ( (SequenceType) this ).getItemType().equals( ( (SequenceType) other ).getItemType() );
          case Record:
          {
            final RecordType self = (RecordType) this;
            final RecordType that = (RecordType) other;
            return self.getKeyType().equals( that.getKeyType() ) && self.getValueType().equals( that.getValueType() );
          }
          case TypeReference:
            return ( (TypeReference) this ).getName().equals( ( (TypeReference) other ).getName() );
          case Promise:
            return ( (PromiseType) this ).getResolveType().equals( ( (PromiseType) other ).getResolveType() );
          case Union:
          {
            final UnionType self = (UnionType) this;
            final UnionType that = (UnionType) other;
            final List<Type> selfMemberTypes = self.getMemberTypes();
            final List<Type> thatMemberTypes = that.getMemberTypes();
            if ( selfMemberTypes.size() != thatMemberTypes.size() )
            {
              return false;
            }
            final int count = selfMemberTypes.size();
            for ( int i = 0; i < count; i++ )
            {
              if ( !selfMemberTypes.get( i ).equals( thatMemberTypes.get( i ) ) )
              {
                return false;
              }
            }
            return true;
          }
          default:
            return true;
        }
      }
    }
  }

  @Override
  public final int hashCode()
  {
    switch ( _kind )
    {
      case FrozenArray:
        return Objects.hash( super.hashCode(), _kind, _nullable, ( (FrozenArrayType) this ).getItemType() );
      case Sequence:
        return Objects.hash( super.hashCode(), _kind, _nullable, ( (SequenceType) this ).getItemType() );
      case Record:
      {
        final RecordType self = (RecordType) this;
        return Objects.hash( super.hashCode(), _kind, _nullable, self.getKeyType(), self.getValueType() );
      }
      case TypeReference:
        return Objects.hash( super.hashCode(), _kind, _nullable, ( (TypeReference) this ).getName() );
      case Promise:
        return Objects.hash( super.hashCode(), _kind, _nullable, ( (PromiseType) this ).getResolveType() );
      case Union:
      {
        final UnionType self = (UnionType) this;
        final List<Type> memberTypes = self.getMemberTypes();
        final int count = memberTypes.size();
        final Object[] objects = new Object[ 3 + count ];
        objects[ 0 ] = super.hashCode();
        objects[ 1 ] = _kind;
        objects[ 2 ] = _nullable;
        for ( int i = 0; i < count; i++ )
        {
          objects[ 3 + i ] = memberTypes.get( i );
        }
        return Objects.hash( objects );
      }
      default:
        return Objects.hash( super.hashCode(), _kind, _nullable );
    }
  }

  public final boolean equiv( @Nonnull final Type other )
  {
    if ( !equivAttributes( other ) || _nullable != other._nullable || _kind != other._kind )
    {
      return false;
    }
    else
    {
      switch ( _kind )
      {
        case FrozenArray:
          return ( (FrozenArrayType) this ).getItemType().equiv( ( (FrozenArrayType) other ).getItemType() );
        case Sequence:
          return ( (SequenceType) this ).getItemType().equiv( ( (SequenceType) other ).getItemType() );
        case Record:
        {
          final RecordType self = (RecordType) this;
          final RecordType that = (RecordType) other;
          return self.getKeyType().equiv( that.getKeyType() ) && self.getValueType().equiv( that.getValueType() );
        }
        case TypeReference:
          return ( (TypeReference) this ).getName().equals( ( (TypeReference) other ).getName() );
        case Promise:
          return ( (PromiseType) this ).getResolveType().equiv( ( (PromiseType) other ).getResolveType() );
        case Union:
        {
          final UnionType self = (UnionType) this;
          final UnionType that = (UnionType) other;
          final List<Type> selfMemberTypes = self.getMemberTypes();
          final List<Type> thatMemberTypes = that.getMemberTypes();
          if ( selfMemberTypes.size() != thatMemberTypes.size() )
          {
            return false;
          }
          final int count = selfMemberTypes.size();
          for ( int i = 0; i < count; i++ )
          {
            if ( !selfMemberTypes.get( i ).equiv( thatMemberTypes.get( i ) ) )
            {
              return false;
            }
          }
          return true;
        }
        default:
          return true;
      }
    }
  }

  public final void write(
    @Nonnull final Writer writer )
    throws IOException
  {
    if ( !getExtendedAttributes().isEmpty() )
    {
      super.write( writer );
      writer.write( ' ' );
    }
    switch ( _kind )
    {
      case Any:
        writer.write( "any" );
        break;
      case Object:
        writer.write( "object" );
        break;
      case Symbol:
        writer.write( "symbol" );
        break;
      case Void:
        writer.write( "void" );
        break;
      case Byte:
        writer.write( "byte" );
        break;
      case Octet:
        writer.write( "octet" );
        break;
      case Boolean:
        writer.write( "boolean" );
        break;
      case ArrayBuffer:
        writer.write( "ArrayBuffer" );
        break;
      case DataView:
        writer.write( "DataView" );
        break;
      case Int8Array:
        writer.write( "Int8Array" );
        break;
      case Int16Array:
        writer.write( "Int16Array" );
        break;
      case Int32Array:
        writer.write( "Int32Array" );
        break;
      case Uint8Array:
        writer.write( "Uint8Array" );
        break;
      case Uint16Array:
        writer.write( "Uint16Array" );
        break;
      case Uint32Array:
        writer.write( "Uint32Array" );
        break;
      case Uint8ClampedArray:
        writer.write( "Uint8ClampedArray" );
        break;
      case Float32Array:
        writer.write( "Float32Array" );
        break;
      case Float64Array:
        writer.write( "Float64Array" );
        break;
      case DOMString:
        writer.write( "DOMString" );
        break;
      case ByteString:
        writer.write( "ByteString" );
        break;
      case USVString:
        writer.write( "USVString" );
        break;
      case Short:
        writer.write( "short" );
        break;
      case Long:
        writer.write( "long" );
        break;
      case LongLong:
        writer.write( "long long" );
        break;
      case UnsignedShort:
        writer.write( "unsigned short" );
        break;
      case UnsignedLong:
        writer.write( "unsigned long" );
        break;
      case UnsignedLongLong:
        writer.write( "unsigned long long" );
        break;
      case Float:
        writer.write( "float" );
        break;
      case Double:
        writer.write( "double" );
        break;
      case UnrestrictedFloat:
        writer.write( "unrestricted float" );
        break;
      case UnrestrictedDouble:
        writer.write( "unrestricted double" );
        break;
      case FrozenArray:
      {
        final FrozenArrayType self = (FrozenArrayType) this;
        writer.write( "FrozenArray<" );
        self.getItemType().write( writer );
        writer.write( ">" );
        break;
      }
      case Sequence:
      {
        final SequenceType self = (SequenceType) this;
        writer.write( "sequence<" );
        self.getItemType().write( writer );
        writer.write( ">" );
        break;
      }
      case Record:
      {
        final RecordType self = (RecordType) this;
        writer.write( "record<" );
        self.getKeyType().write( writer );
        writer.write( ", " );
        self.getValueType().write( writer );
        writer.write( ">" );
        break;
      }
      case TypeReference:
      {
        final TypeReference self = (TypeReference) this;
        writer.write( self.getName() );
        break;
      }
      case Promise:
      {
        final PromiseType self = (PromiseType) this;
        writer.write( "Promise<" );
        self.getResolveType().write( writer );
        writer.write( ">" );
        break;
      }
      case Union:
      {
        final UnionType self = (UnionType) this;
        writer.write( "( " );
        boolean first = true;
        for ( final Type memberType : self.getMemberTypes() )
        {
          if ( !first )
          {
            writer.write( " or " );
          }
          else
          {
            first = false;
          }
          memberType.write( writer );
        }
        writer.write( " )" );
        break;
      }
    }
    if ( _nullable )
    {
      writer.write( '?' );
    }
  }
}
