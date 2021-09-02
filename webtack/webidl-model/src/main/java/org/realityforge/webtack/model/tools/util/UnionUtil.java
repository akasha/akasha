package org.realityforge.webtack.model.tools.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.ExtendedAttribute;
import org.realityforge.webtack.model.FrozenArrayType;
import org.realityforge.webtack.model.Kind;
import org.realityforge.webtack.model.RecordType;
import org.realityforge.webtack.model.SequenceType;
import org.realityforge.webtack.model.Type;
import org.realityforge.webtack.model.TypeReference;
import org.realityforge.webtack.model.TypedefDefinition;
import org.realityforge.webtack.model.UnionType;
import org.realityforge.webtack.model.WebIDLSchema;

public final class UnionUtil
{
  private UnionUtil()
  {
  }

  @Nonnull
  public static String deriveTypeDefNameForUnionType( @Nonnull final UnionType type )
  {
    final StringBuilder sb = new StringBuilder();
    for ( final Type memberType : type.getMemberTypes() )
    {
      if ( 0 != sb.length() )
      {
        sb.append( "Or" );
      }
      appendTypeToUnionName( sb, memberType );
    }
    sb.append( "Union" );
    return sb.toString();
  }

  private static void appendTypeToUnionName( @Nonnull final StringBuilder sb, @Nonnull final Type type )
  {
    final Kind kind = type.getKind();
    if ( kind.isString() )
    {
      sb.append( "String" );
    }
    else if ( kind.isPrimitive() || Kind.FrozenArray == kind || Kind.Object == kind )
    {
      sb.append( kind.name() );
    }
    else if ( Kind.TypeReference == kind )
    {
      sb.append( NamingUtil.uppercaseFirstCharacter( ( (TypeReference) type ).getName() ) );
    }
    else if ( Kind.Sequence == kind )
    {
      appendTypeToUnionName( sb, ( (SequenceType) type ).getItemType() );
      sb.append( "Array" );
    }
    else if ( Kind.Void == kind )
    {
      sb.append( "Undefined" );
    }
    else if ( Kind.Any == kind )
    {
      sb.append( "Any" );
    }
    else
    {
      throw new UnsupportedOperationException( "Contains kind " + kind + " in union which has not been implemented" );
    }
  }

  /**
   * Return a UnionType that is compatible with the specified types or null if all the types are equivalent.
   *
   * @param schema the the underlying schema. (Used to resolve TypeReferences)
   * @param types  the types.
   * @return the UnionType representing the specified type list or null if types are equivalent.
   */
  @Nullable
  public static UnionType createUnionIfRequired( @Nonnull final WebIDLSchema schema, @Nonnull final List<Type> types )
  {
    if ( types.size() < 2 )
    {
      return null;
    }
    else
    {
      final List<Type> uniqueTypes = new ArrayList<>();
      for ( final Type candidate : types )
      {
        // This first loop looks to see if all the types are equivalent without exploding the types
        // Useful when the types list contains a typeref to a union
        if ( !isEquivPresent( uniqueTypes, candidate ) )
        {
          uniqueTypes.add( candidate );
        }
      }
      if ( 1 == uniqueTypes.size() )
      {
        // We have a single equivalent return type so no need to generate UnionType
        return null;
      }

      final List<Type> componentTypes = new ArrayList<>();
      for ( final Type candidate : types )
      {
        // Generate the set of resolved types to the componentTypes list
        explodeTypeAndAddToList( schema, componentTypes, candidate );
      }

      if ( 1 == componentTypes.size() )
      {
        // We have a single equivalent return type (i.e. we had a "double" and a "typedef double DOMHighResTimeStamp")
        // that resolve to the same underlying type
        return null;
      }

      // Promises can not be in unions according to WebIDL
      // Luckily closures type system does not object to when multiple operations with the same name
      // return promises with different resolve types. So we just skip scenario where all are promises
      // (i.e. happens for RTCPeerConnection.prototype.createOffer)
      final long promiseCount = componentTypes.stream().filter( t -> Kind.Promise == t.getKind() ).count();
      if ( promiseCount == componentTypes.size() )
      {
        return null;
      }
      else if ( promiseCount > 0 )
      {
        throw new UnsupportedOperationException( "createUnionIfRequired called with multiple distinct types," +
                                                 " some of which are promises." );
      }

      final List<ExtendedAttribute> attributes = new ArrayList<>();
      attributes.add( ExtendedAttribute.createNoArgs( ExtendedAttributes.INTERNAL ) );
      attributes.add( ExtendedAttribute.createNoArgs( ExtendedAttributes.SYNTHETIC ) );
      final List<Type> actualComponents =
        componentTypes
          .stream()
          .map( UnionUtil::removeNullableFromType )
          .sorted()
          .collect( Collectors.toList() );
      final boolean nullable = componentTypes.stream().anyMatch( Type::isNullable );
      return new UnionType( actualComponents, attributes, nullable, Collections.emptyList() );
    }
  }

  private static boolean isEquivPresent( @Nonnull final List<Type> types, @Nonnull final Type candidate )
  {
    for ( final Type type : types )
    {
      if ( type.equiv( candidate ) )
      {
        return true;
      }
    }
    return false;
  }

  private static void explodeTypeAndAddToList( @Nonnull final WebIDLSchema schema,
                                               @Nonnull final List<Type> types,
                                               @Nonnull final Type candidate )
  {
    if ( isEquivPresent( types, candidate ) )
    {
      return;
    }
    if ( Kind.Union == candidate.getKind() )
    {
      final List<Type> memberTypes = ( (UnionType) candidate ).getMemberTypes();
      for ( final Type memberType : memberTypes )
      {
        explodeTypeAndAddToList( schema, types, memberType );
      }
      return;
    }
    else if ( Kind.TypeReference == candidate.getKind() )
    {
      final String name = ( (TypeReference) candidate ).getName();
      final TypedefDefinition typedef = schema.findTypedefByName( name );
      if ( null != typedef )
      {
        explodeTypeAndAddToList( schema, types, typedef.getType() );
        return;
      }
    }

    types.add( candidate );
  }

  @Nonnull
  private static Type removeNullableFromType( @Nonnull final Type type )
  {
    final Kind kind = type.getKind();
    if ( Kind.Union == kind )
    {
      final UnionType unionType = (UnionType) type;
      return new UnionType( unionType.getMemberTypes(),
                            unionType.getExtendedAttributes(),
                            false,
                            unionType.getSourceLocations() );
    }
    else if ( Kind.Sequence == kind )
    {
      final SequenceType sequenceType = (SequenceType) type;
      return new SequenceType( sequenceType.getItemType(),
                               sequenceType.getExtendedAttributes(),
                               false,
                               sequenceType.getSourceLocations() );
    }
    else if ( Kind.FrozenArray == kind )
    {
      final FrozenArrayType frozenArrayType = (FrozenArrayType) type;
      return new FrozenArrayType( frozenArrayType.getItemType(),
                                  frozenArrayType.getExtendedAttributes(),
                                  false,
                                  frozenArrayType.getSourceLocations() );
    }
    else if ( Kind.Record == kind )
    {
      final RecordType recordType = (RecordType) type;
      return new RecordType( recordType.getKeyType(),
                             recordType.getValueType(),
                             recordType.getExtendedAttributes(),
                             false,
                             recordType.getSourceLocations() );
    }
    else
    {
      return type;
    }
  }
}
