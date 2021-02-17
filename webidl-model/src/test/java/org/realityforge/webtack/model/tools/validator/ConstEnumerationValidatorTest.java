package org.realityforge.webtack.model.tools.validator;

import javax.annotation.Nonnull;
import org.realityforge.webtack.model.WebIDLSchema;
import org.testng.annotations.Test;

public final class ConstEnumerationValidatorTest
  extends AbstractValidatorTest
{
  @Test
  public void all_valid()
  {
    validate( loadTestLocalSchema( "all_valid" + WebIDLSchema.EXTENSION ), 0 );
  }

  @Test
  public void invalid_const_type()
  {
    assertErrorPresent( validate( loadTestLocalSchema( "invalid_const_type" + WebIDLSchema.EXTENSION ), 1 ),
                        "Constant named 'DONE' referenced by const enumeration named 'XMLHttpRequestReadyStateType' has a type of double which is not an integer type" );
  }

  @Test
  public void missing_constant()
  {
    assertErrorPresent( validate( loadTestLocalSchema( "missing_constant" + WebIDLSchema.EXTENSION ), 1 ),
                        "Constant named 'NOT_HERE' referenced by const enumeration named 'XMLHttpRequestReadyStateType' does not exist on type named 'XMLHttpRequest'" );
  }

  @Test
  public void missing_interface_type()
  {
    assertErrorPresent( validate( loadTestLocalSchema( "missing_interface_type" + WebIDLSchema.EXTENSION ), 1 ),
                        "Constant named 'DONE' referenced by const enumeration named 'XMLHttpRequestReadyStateType' references an unknown type named 'XMLHttpRequest2'" );
  }

  @Test
  public void non_matching_const_type()
  {
    assertErrorPresent( validate( loadTestLocalSchema( "non_matching_const_type" + WebIDLSchema.EXTENSION ), 1 ),
                        "Constant named 'UNSENT' referenced by const enumeration named 'XMLHttpRequestReadyStateType' has a type of long long which does not match the type of other constants in the const enumeration which are of type unsigned short" );
  }

  @Nonnull
  Validator createValidator()
  {
    return new ConstEnumerationValidator();
  }
}
