package org.realityforge.webtack.model.tools.validator;

import java.util.Collection;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.WebIDLSchema;
import org.testng.annotations.Test;

public final class TypeReferenceValidatorTest
  extends AbstractValidatorTest
{
  @Test
  public void allReferencesValid()
  {
    validate( loadTestLocalSchema( "allReferencesValid" + WebIDLSchema.EXTENSION ), 0 );
  }

  @Test
  public void callback_badArg()
  {
    assertError( "Callback_badArg" + WebIDLSchema.EXTENSION,
                 "Argument named 'arg1' of callback function named 'CallbackUnderTest' contains or is a type reference but it does not reference a known value" );
  }

  @Test
  public void callback_badReturn()
  {
    assertError( "Callback_badReturn" + WebIDLSchema.EXTENSION,
                 "Return value of callback function named 'CallbackUnderTest' contains or is a type reference but it does not reference a known value" );
  }

  @Test
  public void callbackInterface_badConst()
  {
    assertError( "CallbackInterface_badConst" + WebIDLSchema.EXTENSION,
                 "Constant named 'CONST_A' contained by callback interface named 'CallbackInterfaceUnderTest' contains or is a type reference but it does not reference a known value" );
  }

  @Test
  public void callbackInterface_badOperation()
  {
    assertError( "CallbackInterface_badOperation" + WebIDLSchema.EXTENSION,
                 "Operation named 'myCallback' contained by callback interface named 'CallbackInterfaceUnderTest' has a return type that contains or is a type reference but it does not reference a known value" );
  }

  @Test
  public void dictionary_BadMember()
  {
    assertError( "Dictionary_BadMember" + WebIDLSchema.EXTENSION,
                 "Dictionary member named 'touches' of dictionary named 'DictionaryUnderTest' contains or is a type reference but it does not reference a known value" );
  }

  @Test
  public void partialDictionary_BadMember()
  {
    assertError( "PartialDictionary_BadMember" + WebIDLSchema.EXTENSION,
                 "Dictionary member named 'touches' of partial dictionary named 'DictionaryUnderTest' contains or is a type reference but it does not reference a known value" );
  }

  @Test
  public void mixin_badConst()
  {
    assertError( "Mixin_badConst" + WebIDLSchema.EXTENSION,
                 "Constant named 'CONST_A' contained by mixin named 'MixinUnderTest' contains or is a type reference but it does not reference a known value" );
  }

  @Test
  public void partialMixin_badConst()
  {
    assertError( "PartialMixin_badConst" + WebIDLSchema.EXTENSION,
                 "Constant named 'CONST_A' contained by partial mixin named 'MixinUnderTest' contains or is a type reference but it does not reference a known value" );
  }

  @Test
  public void mixin_badAttribute()
  {
    assertError( "Mixin_badAttribute" + WebIDLSchema.EXTENSION,
                 "Attribute named 'myValue' contained by mixin named 'MixinUnderTest' contains or is a type reference but it does not reference a known value" );
  }

  @Test
  public void partialMixin_badAttribute()
  {
    assertError( "PartialMixin_badAttribute" + WebIDLSchema.EXTENSION,
                 "Attribute named 'myValue' contained by partial mixin named 'MixinUnderTest' contains or is a type reference but it does not reference a known value" );
  }

  @Test
  public void mixin_badOperation()
  {
    assertError( "Mixin_badOperation" + WebIDLSchema.EXTENSION,
                 "Operation named 'myOperation' contained by mixin named 'MixinUnderTest' has a return type that contains or is a type reference but it does not reference a known value" );
  }

  @Test
  public void partialMixin_badOperation()
  {
    assertError( "PartialMixin_badOperation" + WebIDLSchema.EXTENSION,
                 "Operation named 'myOperation' contained by mixin named 'MixinUnderTest' has a return type that contains or is a type reference but it does not reference a known value" );
  }

  @Test
  public void interface_badConst()
  {
    assertError( "Interface_badConst" + WebIDLSchema.EXTENSION,
                 "Constant named 'CONST_A' contained by interface named 'InterfaceUnderTest' contains or is a type reference but it does not reference a known value" );
  }

  @Test
  public void partialInterface_badConst()
  {
    assertError( "PartialInterface_badConst" + WebIDLSchema.EXTENSION,
                 "Constant named 'CONST_A' contained by partial interface named 'PartialInterfaceUnderTest' contains or is a type reference but it does not reference a known value" );
  }

  @Test
  public void interface_badAttribute()
  {
    assertError( "Interface_badAttribute" + WebIDLSchema.EXTENSION,
                 "Attribute named 'myValue' contained by interface named 'InterfaceUnderTest' contains or is a type reference but it does not reference a known value" );
  }

  @Test
  public void partialInterface_badAttribute()
  {
    assertError( "PartialInterface_badAttribute" + WebIDLSchema.EXTENSION,
                 "Attribute named 'myValue' contained by partial interface named 'PartialInterfaceUnderTest' contains or is a type reference but it does not reference a known value" );
  }

  @Test
  public void interface_badOperation()
  {
    assertError( "Interface_badOperation" + WebIDLSchema.EXTENSION,
                 "Operation named 'myOperation' contained by interface named 'InterfaceUnderTest' has a return type that contains or is a type reference but it does not reference a known value" );
  }

  @Test
  public void partialInterface_badOperation()
  {
    assertError( "PartialInterface_badOperation" + WebIDLSchema.EXTENSION,
                 "Operation named 'myOperation' contained by partial interface named 'PartialInterfaceUnderTest' has a return type that contains or is a type reference but it does not reference a known value" );
  }

  @Test
  public void namespace_badAttribute()
  {
    assertError( "Namespace_badAttribute" + WebIDLSchema.EXTENSION,
                 "Attribute named 'myAttr' contained by namespace named 'NamespaceUnderTest' contains or is a type reference but it does not reference a known value" );
  }

  @Test
  public void namespace_badOperation()
  {
    assertError( "Namespace_badOperation" + WebIDLSchema.EXTENSION,
                 "Operation named 'myOperation' contained by namespace named 'NamespaceUnderTest' has a return type that contains or is a type reference but it does not reference a known value" );
  }

  @Test
  public void partialNamespace_badAttribute()
  {
    assertError( "PartialNamespace_badAttribute" + WebIDLSchema.EXTENSION,
                 "Attribute named 'myAttr' contained by partial namespace named 'NamespaceUnderTest' contains or is a type reference but it does not reference a known value" );
  }

  @Test
  public void partialNamespace_badOperation()
  {
    assertError( "PartialNamespace_badOperation" + WebIDLSchema.EXTENSION,
                 "Operation named 'myOperation' contained by partial namespace named 'NamespaceUnderTest' has a return type that contains or is a type reference but it does not reference a known value" );
  }

  private void assertError( @Nonnull final String filename, @Nonnull final String message )
  {
    final WebIDLSchema schema = loadTestLocalSchema( filename );
    final Collection<ValidationError> errors = validate( schema, 1 );
    assertErrorPresent( errors, message );
  }

  @Nonnull
  Validator createValidator()
  {
    return new TypeReferenceValidator();
  }
}
