package org.realityforge.webtack.model.tools.validator;

import java.util.Collection;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.WebIDLSchema;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class UniqueNamesValidatorTest
  extends AbstractValidatorTest
{
  @Test
  public void allUnique()
  {
    final WebIDLSchema schema = loadTestLocalSchema( "allUnique" + WebIDLSchema.EXTENSION );

    // Some assertions just to make sure it is in the shape we expect
    assertEquals( schema.getCallbacks().size(), 3 );
    assertEquals( schema.getCallbackInterfaces().size(), 3 );
    assertEquals( schema.getEnumerations().size(), 3 );
    assertEquals( schema.getDictionaries().size(), 3 );
    assertEquals( schema.getInterfaces().size(), 3 );
    assertEquals( schema.getTypedefs().size(), 3 );

    validate( schema, 0 );
  }

  @Test
  public void typedefNonUnique()
  {
    final WebIDLSchema schema = loadTestLocalSchema( "typedefNonUnique" + WebIDLSchema.EXTENSION );

    // Some assertions just to make sure it is in the shape we expect
    assertEquals( schema.getCallbacks().size(), 3 );
    assertEquals( schema.getCallbackInterfaces().size(), 3 );
    assertEquals( schema.getEnumerations().size(), 3 );
    assertEquals( schema.getDictionaries().size(), 3 );
    assertEquals( schema.getInterfaces().size(), 3 );
    assertEquals( schema.getTypedefs().size(), 5 );

    final Collection<ValidationError> errors = validate( schema, 10 );

    assertErrorPresent( errors, "Typedef named 'CallbackA' conflicts with a callback function with the same name." );
    assertErrorPresent( errors,
                        "Typedef named 'CallbackInterfaceA' conflicts with a callback interface with the same name." );
    assertErrorPresent( errors, "Typedef named 'EnumerationA' conflicts with a enumeration with the same name." );
    assertErrorPresent( errors, "Typedef named 'DictionaryA' conflicts with a dictionary with the same name." );
    assertErrorPresent( errors, "Typedef named 'InterfaceA' conflicts with a interface with the same name." );
    assertErrorPresent( errors, "Interface named 'InterfaceA' conflicts with a typedef with the same name." );
    assertErrorPresent( errors, "Callback named 'CallbackA' conflicts with a typedef with the same name." );
    assertErrorPresent( errors, "Dictionary named 'DictionaryA' conflicts with a typedef with the same name." );
    assertErrorPresent( errors,
                        "Callback interface named 'CallbackInterfaceA' conflicts with a typedef with the same name." );
    assertErrorPresent( errors, "Enumeration named 'EnumerationA' conflicts with a typedef with the same name." );
  }

  @Test
  public void interfaceNonUnique()
  {
    final WebIDLSchema schema = loadTestLocalSchema( "interfaceNonUnique" + WebIDLSchema.EXTENSION );

    // Some assertions just to make sure it is in the shape we expect
    assertEquals( schema.getCallbacks().size(), 3 );
    assertEquals( schema.getCallbackInterfaces().size(), 3 );
    assertEquals( schema.getEnumerations().size(), 3 );
    assertEquals( schema.getDictionaries().size(), 3 );
    assertEquals( schema.getInterfaces().size(), 5 );
    assertEquals( schema.getTypedefs().size(), 3 );

    final Collection<ValidationError> errors = validate( schema, 10 );

    assertErrorPresent( errors, "Interface named 'CallbackA' conflicts with a callback function with the same name." );
    assertErrorPresent( errors,
                        "Interface named 'CallbackInterfaceA' conflicts with a callback interface with the same name." );
    assertErrorPresent( errors, "Interface named 'EnumerationA' conflicts with a enumeration with the same name." );
    assertErrorPresent( errors, "Interface named 'DictionaryA' conflicts with a dictionary with the same name." );
    assertErrorPresent( errors, "Interface named 'TypedefA' conflicts with a typedef with the same name." );
    assertErrorPresent( errors, "Typedef named 'TypedefA' conflicts with a interface with the same name." );
    assertErrorPresent( errors, "Callback named 'CallbackA' conflicts with a interface with the same name." );
    assertErrorPresent( errors, "Dictionary named 'DictionaryA' conflicts with a interface with the same name." );
    assertErrorPresent( errors,
                        "Callback interface named 'CallbackInterfaceA' conflicts with a interface with the same name." );
    assertErrorPresent( errors, "Enumeration named 'EnumerationA' conflicts with a interface with the same name." );
  }

  @Nonnull
  @Override
  Validator createValidator()
  {
    return new UniqueNamesValidator();
  }
}
