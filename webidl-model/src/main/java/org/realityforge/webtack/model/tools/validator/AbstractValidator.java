package org.realityforge.webtack.model.tools.validator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.Argument;
import org.realityforge.webtack.model.AsyncIterableMember;
import org.realityforge.webtack.model.AttributeMember;
import org.realityforge.webtack.model.CallbackDefinition;
import org.realityforge.webtack.model.CallbackInterfaceDefinition;
import org.realityforge.webtack.model.ConstMember;
import org.realityforge.webtack.model.ConstValue;
import org.realityforge.webtack.model.DefaultValue;
import org.realityforge.webtack.model.DictionaryDefinition;
import org.realityforge.webtack.model.DictionaryMember;
import org.realityforge.webtack.model.EnumerationDefinition;
import org.realityforge.webtack.model.ExtendedAttribute;
import org.realityforge.webtack.model.FrozenArrayType;
import org.realityforge.webtack.model.IncludesStatement;
import org.realityforge.webtack.model.InterfaceDefinition;
import org.realityforge.webtack.model.IterableMember;
import org.realityforge.webtack.model.Kind;
import org.realityforge.webtack.model.MapLikeMember;
import org.realityforge.webtack.model.MixinDefinition;
import org.realityforge.webtack.model.NamespaceDefinition;
import org.realityforge.webtack.model.OperationMember;
import org.realityforge.webtack.model.PartialDictionaryDefinition;
import org.realityforge.webtack.model.PartialInterfaceDefinition;
import org.realityforge.webtack.model.PartialMixinDefinition;
import org.realityforge.webtack.model.PartialNamespaceDefinition;
import org.realityforge.webtack.model.PromiseType;
import org.realityforge.webtack.model.RecordType;
import org.realityforge.webtack.model.SequenceType;
import org.realityforge.webtack.model.SetLikeMember;
import org.realityforge.webtack.model.SourceInterval;
import org.realityforge.webtack.model.Type;
import org.realityforge.webtack.model.TypedefDefinition;
import org.realityforge.webtack.model.UnionType;
import org.realityforge.webtack.model.WebIDLSchema;

/**
 * Base class for applying a transformation to a schema.
 *
 * <p>It should be notes that this is extremely inefficient computationally and memory-wise. If this is
 * ever a problem we can always allow subclasses to use a bitset to declare which child elements of the
 * schema are processed. We would just reuse elements if we don't walk down a tree.</p>
 */
@SuppressWarnings( "unused" )
public abstract class AbstractValidator
  implements Validator
{
  @Nonnull
  @Override
  public Collection<ValidationError> validate( @Nonnull final WebIDLSchema schema )
  {
    final Collection<ValidationError> errors = new ArrayList<>();

    schema.getCallbacks().forEach( d -> validateCallback( d, errors ) );
    schema.getCallbackInterfaces().forEach( d -> validateCallbackInterface( d, errors ) );
    schema.getEnumerations().forEach( d -> validateEnumeration( d, errors ) );
    schema.getDictionaries().forEach( d -> validateDictionary( d, errors ) );
    schema.getPartialDictionaries().forEach( d -> validatePartialDictionary( d, errors ) );
    schema.getNamespaces().forEach( d -> validateNamespace( d, errors ) );
    schema.getPartialNamespaces().forEach( d -> validatePartialNamespace( d, errors ) );
    schema.getInterfaces().forEach( d -> validateInterface( d, errors ) );
    schema.getPartialInterfaces().forEach( d -> validatePartialInterface( d, errors ) );
    schema.getIncludes().forEach( d -> validateIncludesStatement( d, errors ) );
    schema.getTypedefs().forEach( d -> validateTypedef( d, errors ) );
    schema.getMixins().forEach( d -> validateMixin( d, errors ) );
    schema.getPartialMixins().forEach( d -> validatePartialMixin( d, errors ) );

    return errors;
  }

  protected void validateTags( @Nonnull final WebIDLSchema schema, @Nonnull final Collection<ValidationError> errors )
  {
  }

  protected void validateCallback( @Nonnull final CallbackDefinition input,
                                   @Nonnull final Collection<ValidationError> errors )
  {
    validateType( input.getReturnType(), errors );
    validateArguments( input.getArguments(), errors );
    validateExtendedAttributes( input.getExtendedAttributes(), errors );
    validateSourceLocations( input.getSourceLocations(), errors );
  }

  protected void validateCallbackInterface( @Nonnull final CallbackInterfaceDefinition input,
                                            @Nonnull final Collection<ValidationError> errors )
  {
    validateOperationMember( input.getOperation(), errors );
    validateConstants( input.getConstants(), errors );
    validateExtendedAttributes( input.getExtendedAttributes(), errors );
    validateSourceLocations( input.getSourceLocations(), errors );
  }

  protected void validateOperationMember( @Nonnull final OperationMember input,
                                          @Nonnull final Collection<ValidationError> errors )
  {
    validateArguments( input.getArguments(), errors );
    validateType( input.getReturnType(), errors );
    validateExtendedAttributes( input.getExtendedAttributes(), errors );
    validateSourceLocations( input.getSourceLocations(), errors );
  }

  protected void validateOptionalOperationMember( @Nonnull final OperationMember input,
                                                  @Nonnull final Collection<ValidationError> errors )
  {
    validateOperationMember( input, errors );
  }

  protected void validateConstants( @Nonnull final List<ConstMember> inputs,
                                    @Nonnull final Collection<ValidationError> errors )
  {
    inputs.forEach( c -> validateConstant( c, errors ) );
  }

  protected void validateConstant( @Nonnull final ConstMember input, @Nonnull final Collection<ValidationError> errors )
  {
    validateType( input.getType(), errors );
    validateConstValue( input.getValue(), errors );
    validateExtendedAttributes( input.getExtendedAttributes(), errors );
    validateSourceLocations( input.getSourceLocations(), errors );
  }

  protected void validateEnumeration( @Nonnull final EnumerationDefinition input,
                                      @Nonnull final Collection<ValidationError> errors )
  {
    validateExtendedAttributes( input.getExtendedAttributes(), errors );
    validateSourceLocations( input.getSourceLocations(), errors );
  }

  protected void validateMixin( @Nonnull final MixinDefinition input,
                                @Nonnull final Collection<ValidationError> errors )
  {
    validateConstants( input.getConstants(), errors );
    validateAttributeMembers( input.getAttributes(), errors );
    validateOperationMembers( input.getOperations(), errors );
    validateExtendedAttributes( input.getExtendedAttributes(), errors );
    validateSourceLocations( input.getSourceLocations(), errors );
  }

  protected void validatePartialMixin( @Nonnull final PartialMixinDefinition input,
                                       @Nonnull final Collection<ValidationError> errors )
  {
    validateConstants( input.getConstants(), errors );
    validateAttributeMembers( input.getAttributes(), errors );
    validateOperationMembers( input.getOperations(), errors );
    validateExtendedAttributes( input.getExtendedAttributes(), errors );
    validateSourceLocations( input.getSourceLocations(), errors );
  }

  protected void validateInterface( @Nonnull final InterfaceDefinition input,
                                    @Nonnull final Collection<ValidationError> errors )
  {
    validateConstants( input.getConstants(), errors );
    validateAttributeMembers( input.getAttributes(), errors );
    validateOperationMembers( input.getOperations(), errors );
    final IterableMember iterable = input.getIterable();
    if ( null != iterable )
    {
      validateIterableMember( iterable, errors );
    }
    final AsyncIterableMember asyncIterable = input.getAsyncIterable();
    if ( null != asyncIterable )
    {
      validateAsyncIterableMember( asyncIterable, errors );
    }
    final MapLikeMember mapLikeMember = input.getMapLikeMember();
    if ( null != mapLikeMember )
    {
      validateMapLikeMember( mapLikeMember, errors );
    }
    final SetLikeMember setLikeMember = input.getSetLikeMember();
    if ( null != setLikeMember )
    {
      validateSetLikeMember( setLikeMember, errors );
    }
    validateExtendedAttributes( input.getExtendedAttributes(), errors );
    validateSourceLocations( input.getSourceLocations(), errors );
  }

  protected void validateSetLikeMember( @Nonnull final SetLikeMember input,
                                        @Nonnull final Collection<ValidationError> errors )
  {
    validateType( input.getType(), errors );
    validateExtendedAttributes( input.getExtendedAttributes(), errors );
    validateSourceLocations( input.getSourceLocations(), errors );
  }

  protected void validateMapLikeMember( @Nonnull final MapLikeMember input,
                                        @Nonnull final Collection<ValidationError> errors )
  {
    validateType( input.getKeyType(), errors );
    validateType( input.getValueType(), errors );
    validateExtendedAttributes( input.getExtendedAttributes(), errors );
    validateSourceLocations( input.getSourceLocations(), errors );
  }

  protected void validateAsyncIterableMember( @Nonnull final AsyncIterableMember input,
                                              @Nonnull final Collection<ValidationError> errors )
  {
    validateType( input.getKeyType(), errors );
    validateType( input.getValueType(), errors );
    validateExtendedAttributes( input.getExtendedAttributes(), errors );
    validateSourceLocations( input.getSourceLocations(), errors );
  }

  protected void validateIterableMember( @Nonnull final IterableMember input,
                                         @Nonnull final Collection<ValidationError> errors )
  {
    validateOptionalType( input.getKeyType(), errors );
    validateType( input.getValueType(), errors );
    validateExtendedAttributes( input.getExtendedAttributes(), errors );
    validateSourceLocations( input.getSourceLocations(), errors );
  }

  protected void validateOptionalType( @Nullable final Type type,
                                       @Nonnull final Collection<ValidationError> errors )
  {
    if ( null != type )
    {
      validateType( type, errors );
    }
  }

  protected void validatePartialInterface( @Nonnull final PartialInterfaceDefinition input,
                                           @Nonnull final Collection<ValidationError> errors )
  {
    validateConstants( input.getConstants(), errors );
    validateAttributeMembers( input.getAttributes(), errors );
    validateOperationMembers( input.getOperations(), errors );
    final IterableMember iterableMember = input.getIterable();
    if ( null != iterableMember )
    {
      validateIterableMember( iterableMember, errors );
    }
    final AsyncIterableMember asyncIterableMember = input.getAsyncIterable();
    if ( null != asyncIterableMember )
    {
      validateAsyncIterableMember( asyncIterableMember, errors );
    }
    final MapLikeMember mapLikeMember = input.getMapLikeMember();
    if ( null != mapLikeMember )
    {
      validateMapLikeMember( mapLikeMember, errors );
    }
    final SetLikeMember setLikeMember = input.getSetLikeMember();
    if ( null != setLikeMember )
    {
      validateSetLikeMember( setLikeMember, errors );
    }
    validateExtendedAttributes( input.getExtendedAttributes(), errors );
    validateSourceLocations( input.getSourceLocations(), errors );
  }

  protected void validateNamespace( @Nonnull final NamespaceDefinition input,
                                    @Nonnull final Collection<ValidationError> errors )
  {
    validateOperationMembers( input.getOperations(), errors );
    validateAttributeMembers( input.getAttributes(), errors );
    validateExtendedAttributes( input.getExtendedAttributes(), errors );
    validateSourceLocations( input.getSourceLocations(), errors );
  }

  protected void validatePartialNamespace( @Nonnull final PartialNamespaceDefinition input,
                                           @Nonnull final Collection<ValidationError> errors )
  {
    validateOperationMembers( input.getOperations(), errors );
    validateAttributeMembers( input.getAttributes(), errors );
    validateExtendedAttributes( input.getExtendedAttributes(), errors );
    validateSourceLocations( input.getSourceLocations(), errors );
  }

  protected void validateOperationMembers( @Nonnull final List<OperationMember> inputs,
                                           @Nonnull final Collection<ValidationError> errors )
  {
    inputs.forEach( m -> validateOptionalOperationMember( m, errors ) );
  }

  protected void validateAttributeMembers( @Nonnull final List<AttributeMember> inputs,
                                           @Nonnull final Collection<ValidationError> errors )
  {
    inputs.forEach( m -> validateAttributeMember( m, errors ) );
  }

  protected void validateAttributeMember( @Nonnull final AttributeMember input,
                                          @Nonnull final Collection<ValidationError> errors )
  {
    validateType( input.getType(), errors );
    validateExtendedAttributes( input.getExtendedAttributes(), errors );
    validateSourceLocations( input.getSourceLocations(), errors );
  }

  protected void validateDictionary( @Nonnull final DictionaryDefinition input,
                                     @Nonnull final Collection<ValidationError> errors )
  {
    input.getMembers().forEach( m -> validateDictionaryMember( m, errors ) );
    validateExtendedAttributes( input.getExtendedAttributes(), errors );
    validateSourceLocations( input.getSourceLocations(), errors );
  }

  protected void validateDictionaryMember( @Nonnull final DictionaryMember input,
                                           @Nonnull final Collection<ValidationError> errors )
  {
    validateType( input.getType(), errors );
    validateExtendedAttributes( input.getExtendedAttributes(), errors );
    validateSourceLocations( input.getSourceLocations(), errors );
  }

  protected void validatePartialDictionary( @Nonnull final PartialDictionaryDefinition input,
                                            @Nonnull final Collection<ValidationError> errors )
  {
    input.getMembers().forEach( m -> validateDictionaryMember( m, errors ) );
    validateExtendedAttributes( input.getExtendedAttributes(), errors );
    validateSourceLocations( input.getSourceLocations(), errors );
  }

  protected void validateIncludesStatement( @Nonnull final IncludesStatement input,
                                            @Nonnull final Collection<ValidationError> errors )
  {
    validateExtendedAttributes( input.getExtendedAttributes(), errors );
    validateSourceLocations( input.getSourceLocations(), errors );
  }

  protected void validateTypedef( @Nonnull final TypedefDefinition input,
                                  @Nonnull final Collection<ValidationError> errors )
  {
    validateType( input.getType(), errors );
    validateExtendedAttributes( input.getExtendedAttributes(), errors );
    validateSourceLocations( input.getSourceLocations(), errors );
  }

  protected void validateArguments( @Nonnull final List<Argument> arguments,
                                    @Nonnull final Collection<ValidationError> errors )
  {
    arguments.forEach( a -> validateArgument( a, errors ) );
  }

  protected void validateArgument( @Nonnull final Argument input, @Nonnull final Collection<ValidationError> errors )
  {
    validateType( input.getType(), errors );
    final DefaultValue defaultValue = input.getDefaultValue();
    if ( null != defaultValue )
    {
      validateDefaultValue( defaultValue, errors );
    }
    validateExtendedAttributes( input.getExtendedAttributes(), errors );
    validateSourceLocations( input.getSourceLocations(), errors );
  }

  protected void validateDefaultValue( @Nonnull final DefaultValue input,
                                       @Nonnull final Collection<ValidationError> errors )
  {
    final ConstValue constValue = input.getConstValue();
    if ( null != constValue )
    {
      validateConstValue( constValue, errors );
    }
    validateSourceLocations( input.getSourceLocations(), errors );
  }

  protected void validateConstValue( @Nonnull final ConstValue input,
                                     @Nonnull final Collection<ValidationError> errors )
  {
    validateSourceLocations( input.getSourceLocations(), errors );
  }

  protected void validateType( @Nonnull final Type type, @Nonnull final Collection<ValidationError> errors )
  {
    final Kind kind = type.getKind();
    if ( Kind.Union == kind )
    {
      ( (UnionType) type ).getMemberTypes().forEach( t -> validateType( t, errors ) );
    }
    else if ( Kind.Promise == kind )
    {
      validateType( ( (PromiseType) type ).getResolveType(), errors );
    }
    else if ( Kind.Sequence == kind )
    {
      validateType( ( (SequenceType) type ).getItemType(), errors );
    }
    else if ( Kind.FrozenArray == kind )
    {
      validateType( ( (FrozenArrayType) type ).getItemType(), errors );
    }
    else if ( Kind.Record == kind )
    {
      final RecordType recordType = (RecordType) type;
      validateType( recordType.getKeyType(), errors );
      validateType( recordType.getValueType(), errors );
    }
    validateExtendedAttributes( type.getExtendedAttributes(), errors );
    validateSourceLocations( type.getSourceLocations(), errors );
  }

  protected void validateExtendedAttributes( @Nonnull final List<ExtendedAttribute> inputs,
                                             @Nonnull final Collection<ValidationError> errors )
  {
  }

  protected void validateSourceLocations( @Nonnull final List<SourceInterval> inputs,
                                          @Nonnull final Collection<ValidationError> errors )
  {
  }
}
