package org.realityforge.webtack.model;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;

public class Type
  extends Element
{
  @Nonnull
  private final Kind _kind;
  private final boolean _nullable;

  public Type( @Nonnull final Kind kind,
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
    if ( !super.equiv( other ) || _nullable != other._nullable || _kind != other._kind )
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

  @Override
  public String toString()
  {
    try
    {
      final StringWriter sw = new StringWriter();
      WebIDLWriter.writeType( sw, this );
      return sw.toString();
    }
    catch ( final IOException e )
    {
      throw new IllegalStateException( "Error generating toString for type of kind " + _kind );
    }
  }
}
