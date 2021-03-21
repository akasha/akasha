package org.realityforge.webtack.model.tools.validator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.Argument;
import org.realityforge.webtack.model.AsyncIterableMember;
import org.realityforge.webtack.model.AttributeMember;
import org.realityforge.webtack.model.CallbackDefinition;
import org.realityforge.webtack.model.CallbackInterfaceDefinition;
import org.realityforge.webtack.model.ConstMember;
import org.realityforge.webtack.model.DictionaryDefinition;
import org.realityforge.webtack.model.DictionaryMember;
import org.realityforge.webtack.model.EventMember;
import org.realityforge.webtack.model.FrozenArrayType;
import org.realityforge.webtack.model.InterfaceDefinition;
import org.realityforge.webtack.model.IterableMember;
import org.realityforge.webtack.model.Kind;
import org.realityforge.webtack.model.MapLikeMember;
import org.realityforge.webtack.model.MixinDefinition;
import org.realityforge.webtack.model.NamespaceDefinition;
import org.realityforge.webtack.model.Node;
import org.realityforge.webtack.model.OperationMember;
import org.realityforge.webtack.model.PartialDictionaryDefinition;
import org.realityforge.webtack.model.PartialInterfaceDefinition;
import org.realityforge.webtack.model.PartialMixinDefinition;
import org.realityforge.webtack.model.PartialNamespaceDefinition;
import org.realityforge.webtack.model.PromiseType;
import org.realityforge.webtack.model.RecordType;
import org.realityforge.webtack.model.SequenceType;
import org.realityforge.webtack.model.SetLikeMember;
import org.realityforge.webtack.model.Type;
import org.realityforge.webtack.model.TypeReference;
import org.realityforge.webtack.model.TypedefDefinition;
import org.realityforge.webtack.model.UnionType;
import org.realityforge.webtack.model.WebIDLSchema;

final class TypeReferenceValidator
  implements Validator
{
  @Nonnull
  @Override
  public Collection<ValidationError> validate( @Nonnull final WebIDLSchema schema )
  {
    final Collection<ValidationError> errors = new ArrayList<>();
    for ( final NamespaceDefinition definition : schema.getNamespaces() )
    {
      validateAttributeTypeReference( schema, errors, "namespace", definition.getName(), definition.getAttributes() );
      validateOperationsTypeReference( schema, errors, "namespace", definition.getName(), definition.getOperations() );
    }
    for ( final PartialNamespaceDefinition definition : schema.getPartialNamespaces() )
    {
      validateAttributeTypeReference( schema,
                                      errors,
                                      "partial namespace",
                                      definition.getName(),
                                      definition.getAttributes() );
      validateOperationsTypeReference( schema,
                                       errors,
                                       "partial namespace",
                                       definition.getName(),
                                       definition.getOperations() );
    }
    for ( final CallbackDefinition definition : schema.getCallbacks() )
    {
      {
        final Supplier<String> message =
          () -> "Return value of callback function named '" + definition.getName() + "' contains or is a type " +
                "reference but it does not reference a known value";
        validateType( schema, errors, definition.getReturnType(), definition, message );
      }
      for ( final Argument argument : definition.getArguments() )
      {
        final Supplier<String> message =
          () -> "Argument named '" + argument.getName() + "' of callback function named '" + definition.getName() +
                "' contains or is a type reference but it does not reference a known value";
        validateType( schema, errors, argument.getType(), argument, message );
      }
    }
    for ( final CallbackInterfaceDefinition definition : schema.getCallbackInterfaces() )
    {
      validateConstantTypeReference( schema,
                                     errors,
                                     "callback interface",
                                     definition.getName(),
                                     definition.getConstants() );
      validateOperationTypeReference( schema,
                                      errors,
                                      "callback interface",
                                      definition.getName(),
                                      definition.getOperation() );
    }
    for ( final DictionaryDefinition definition : schema.getDictionaries() )
    {
      for ( final DictionaryMember member : definition.getMembers() )
      {
        final Supplier<String> message =
          () -> "Dictionary member named '" + member.getName() + "' of dictionary named '" + definition.getName() +
                "' contains or is a type reference but it does not reference a known value";
        validateType( schema, errors, member.getType(), definition, message );
      }
    }
    for ( final PartialDictionaryDefinition definition : schema.getPartialDictionaries() )
    {
      for ( final DictionaryMember member : definition.getMembers() )
      {
        final Supplier<String> message =
          () -> "Dictionary member named '" + member.getName() + "' of partial dictionary named '" +
                definition.getName() + "' contains or is a type reference but it does not reference a known value";
        validateType( schema, errors, member.getType(), definition, message );
      }
    }
    for ( final MixinDefinition definition : schema.getMixins() )
    {
      validateConstantTypeReference( schema, errors, "mixin", definition.getName(), definition.getConstants() );
      validateAttributeTypeReference( schema, errors, "mixin", definition.getName(), definition.getAttributes() );
      validateOperationsTypeReference( schema, errors, "mixin", definition.getName(), definition.getOperations() );
    }
    for ( final PartialMixinDefinition definition : schema.getPartialMixins() )
    {
      validateConstantTypeReference( schema, errors, "partial mixin", definition.getName(), definition.getConstants() );
      validateAttributeTypeReference( schema,
                                      errors,
                                      "partial mixin",
                                      definition.getName(),
                                      definition.getAttributes() );
      validateOperationsTypeReference( schema,
                                       errors,
                                       "partial mixin",
                                       definition.getName(),
                                       definition.getOperations() );
    }
    for ( final InterfaceDefinition definition : schema.getInterfaces() )
    {
      final String containerType = "interface";
      final String containerName = definition.getName();
      validateConstantTypeReference( schema, errors, containerType, containerName, definition.getConstants() );
      validateAttributeTypeReference( schema, errors, containerType, containerName, definition.getAttributes() );
      validateOperationsTypeReference( schema, errors, containerType, containerName, definition.getOperations() );
      validateEventsTypeReference( schema, errors, containerType, containerName, definition.getEvents() );
      validateIterableMember( schema, errors, containerType, containerName, definition.getIterable() );
      validateAsyncIterableMember( schema, errors, containerType, containerName, definition.getAsyncIterable() );
      validateMapLikeMember( schema, errors, containerType, containerName, definition.getMapLikeMember() );
      validateSetLikeMember( schema, errors, containerType, containerName, definition.getSetLikeMember() );
    }
    for ( final PartialInterfaceDefinition definition : schema.getPartialInterfaces() )
    {
      final String containerType = "partial interface";
      final String containerName = definition.getName();
      validateConstantTypeReference( schema, errors, containerType, containerName, definition.getConstants() );
      validateAttributeTypeReference( schema, errors, containerType, containerName, definition.getAttributes() );
      validateOperationsTypeReference( schema, errors, containerType, containerName, definition.getOperations() );
      validateEventsTypeReference( schema, errors, containerType, containerName, definition.getEvents() );
      validateIterableMember( schema, errors, containerType, containerName, definition.getIterable() );
      validateAsyncIterableMember( schema, errors, containerType, containerName, definition.getAsyncIterable() );
      validateMapLikeMember( schema, errors, containerType, containerName, definition.getMapLikeMember() );
      validateSetLikeMember( schema, errors, containerType, containerName, definition.getSetLikeMember() );
    }

    for ( final TypedefDefinition definition : schema.getTypedefs() )
    {
      final Supplier<String> message =
        () -> "Typedef named '" + definition.getName() + "' specifies a type that contains or is a type " +
              "reference but it does not reference a known value";
      validateType( schema, errors, definition.getType(), definition, message );
    }

    return errors;
  }

  private void validateEventsTypeReference( @Nonnull final WebIDLSchema schema,
                                            @Nonnull final Collection<ValidationError> errors,
                                            @Nonnull final String containerType,
                                            @Nonnull final String containerName,
                                            @Nonnull final List<EventMember> events )
  {
    for ( final EventMember event : events )
    {
      validateEventTypeReference( schema, errors, containerType, containerName, event );
    }
  }

  private void validateEventTypeReference( @Nonnull final WebIDLSchema schema,
                                           @Nonnull final Collection<ValidationError> errors,
                                           @Nonnull final String containerType,
                                           @Nonnull final String containerName,
                                           @Nonnull final EventMember event )
  {
    final Supplier<String> returnTypeMessage =
      () -> "Event named '" + event.getName() + "' contained by " + containerType + " named '" +
            containerName + "' has a type but it does not reference a known value";
    validateType( schema, errors, event.getEventType(), event, returnTypeMessage );
  }

  private void validateIterableMember( @Nonnull final WebIDLSchema schema,
                                       @Nonnull final Collection<ValidationError> errors,
                                       @Nonnull final String containerType,
                                       @Nonnull final String containerName,
                                       @Nullable final IterableMember member )
  {
    if ( null != member )
    {
      final Type keyType = member.getKeyType();
      if ( null != keyType )
      {
        final Supplier<String> keyMessage =
          () -> "Iterable contained by " + containerType + " named '" + containerName + "' has a key type " +
                "that contains or is a type reference but it does not reference a known value";
        validateType( schema, errors, keyType, member, keyMessage );
      }
      final Supplier<String> valueMessage =
        () -> "Iterable contained by " + containerType + " named '" + containerName + "' has a value type " +
              "that contains or is a type reference but it does not reference a known value";
      validateType( schema, errors, member.getValueType(), member, valueMessage );
    }
  }

  private void validateAsyncIterableMember( @Nonnull final WebIDLSchema schema,
                                            @Nonnull final Collection<ValidationError> errors,
                                            @Nonnull final String containerType,
                                            @Nonnull final String containerName,
                                            @Nullable final AsyncIterableMember member )
  {
    if ( null != member )
    {
      final Type keyType = member.getKeyType();
      if ( null != keyType )
      {
        final Supplier<String> keyMessage =
          () -> "AsyncIterable contained by " + containerType + " named '" + containerName + "' has a key type " +
                "that contains or is a type reference but it does not reference a known value";
        validateType( schema, errors, keyType, member, keyMessage );
      }

      final Supplier<String> valueMessage =
        () -> "AsyncIterable contained by " + containerType + " named '" + containerName + "' has a value type " +
              "that contains or is a type reference but it does not reference a known value";
      validateType( schema, errors, member.getValueType(), member, valueMessage );
    }
  }

  private void validateMapLikeMember( @Nonnull final WebIDLSchema schema,
                                      @Nonnull final Collection<ValidationError> errors,
                                      @Nonnull final String containerType,
                                      @Nonnull final String containerName,
                                      @Nullable final MapLikeMember member )
  {
    if ( null != member )
    {
      final Type keyType = member.getKeyType();
      final Supplier<String> keyMessage =
        () -> "MapLike contained by " + containerType + " named '" + containerName + "' has a key type " +
              "that contains or is a type reference but it does not reference a known value";
      validateType( schema, errors, keyType, member, keyMessage );

      final Supplier<String> valueMessage =
        () -> "MapLike contained by " + containerType + " named '" + containerName + "' has a value type " +
              "that contains or is a type reference but it does not reference a known value";
      validateType( schema, errors, member.getValueType(), member, valueMessage );
    }
  }

  private void validateSetLikeMember( @Nonnull final WebIDLSchema schema,
                                      @Nonnull final Collection<ValidationError> errors,
                                      @Nonnull final String containerType,
                                      @Nonnull final String containerName,
                                      @Nullable final SetLikeMember member )
  {
    if ( null != member )
    {
      final Type keyType = member.getType();
      final Supplier<String> keyMessage =
        () -> "SetLike contained by " + containerType + " named '" + containerName + "' has a type " +
              "that contains or is a type reference but it does not reference a known value";
      validateType( schema, errors, keyType, member, keyMessage );
    }
  }

  private void validateConstantTypeReference( @Nonnull final WebIDLSchema schema,
                                              @Nonnull final Collection<ValidationError> errors,
                                              @Nonnull final String containerType,
                                              @Nonnull final String containerName,
                                              @Nonnull final List<ConstMember> constants )
  {
    for ( final ConstMember constant : constants )
    {
      final Supplier<String> message =
        () -> "Constant named '" + constant.getName() + "' contained by " + containerType + " named '" +
              containerName + "' contains or is a type reference but it does not reference a known value";
      validateType( schema, errors, constant.getType(), constant, message );
    }
  }

  private void validateAttributeTypeReference( @Nonnull final WebIDLSchema schema,
                                               @Nonnull final Collection<ValidationError> errors,
                                               @Nonnull final String containerType,
                                               @Nonnull final String containerName,
                                               @Nonnull final List<AttributeMember> attributes )
  {
    for ( final AttributeMember attribute : attributes )
    {
      final Supplier<String> message =
        () -> "Attribute named '" + attribute.getName() + "' contained by " + containerType + " named '" +
              containerName + "' contains or is a type reference but it does not reference a known value";
      validateType( schema, errors, attribute.getType(), attribute, message );
    }
  }

  private void validateOperationsTypeReference( @Nonnull final WebIDLSchema schema,
                                                @Nonnull final Collection<ValidationError> errors,
                                                @Nonnull final String containerType,
                                                @Nonnull final String containerName,
                                                @Nonnull final List<OperationMember> operations )
  {
    for ( final OperationMember operation : operations )
    {
      validateOperationTypeReference( schema, errors, containerType, containerName, operation );
    }
  }

  private void validateOperationTypeReference( @Nonnull final WebIDLSchema schema,
                                               @Nonnull final Collection<ValidationError> errors,
                                               @Nonnull final String containerType,
                                               @Nonnull final String containerName,
                                               @Nonnull final OperationMember operation )
  {
    final Supplier<String> returnTypeMessage =
      () -> "Operation named '" + operation.getName() + "' contained by " + containerType + " named '" +
            containerName + "' has a return type that contains or is a type reference but it does not " +
            "reference a known value";
    validateType( schema, errors, operation.getReturnType(), operation, returnTypeMessage );

    for ( final Argument argument : operation.getArguments() )
    {
      final Supplier<String> message =
        () -> "Argument named '" + argument.getName() + "' in operation named '" + operation.getName() +
              "' contained by " + containerType + " named '" + containerName +
              "' contains or is a type reference but it does not reference a known value";
      validateType( schema, errors, argument.getType(), argument, message );
    }
  }

  private void validateType( @Nonnull final WebIDLSchema schema,
                             @Nonnull final Collection<ValidationError> errors,
                             @Nonnull final Type type,
                             @Nonnull final Node node,
                             @Nonnull final Supplier<String> messageSupplier )
  {
    if ( Kind.TypeReference == type.getKind() )
    {
      final TypeReference reference = (TypeReference) type;
      final String name = reference.getName();
      if ( null == schema.findInterfaceByName( name ) &&
           null == schema.findDictionaryByName( name ) &&
           null == schema.findEnumerationByName( name ) &&
           null == schema.findConstEnumerationByName( name ) &&
           null == schema.findCallbackByName( name ) &&
           null == schema.findCallbackInterfaceByName( name ) &&
           null == schema.findTypedefByName( name ) )
      {
        errors.add( new ValidationError( node, messageSupplier.get(), true ) );
      }
    }
    else if ( Kind.Sequence == type.getKind() )
    {
      validateType( schema, errors, ( (SequenceType) type ).getItemType(), node, messageSupplier );
    }
    else if ( Kind.Record == type.getKind() )
    {
      validateType( schema, errors, ( (RecordType) type ).getValueType(), node, messageSupplier );
    }
    else if ( Kind.FrozenArray == type.getKind() )
    {
      validateType( schema, errors, ( (FrozenArrayType) type ).getItemType(), node, messageSupplier );
    }
    else if ( Kind.Promise == type.getKind() )
    {
      validateType( schema, errors, ( (PromiseType) type ).getResolveType(), node, messageSupplier );
    }
    else if ( Kind.Union == type.getKind() )
    {
      final UnionType unionType = (UnionType) type;
      for ( final Type memberType : unionType.getMemberTypes() )
      {
        validateType( schema, errors, memberType, node, messageSupplier );
      }
    }
  }
}
