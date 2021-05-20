package org.realityforge.webtack.model.tools.validator;

import java.util.Collection;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.WebIDLSchema;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class InheritsValidatorTest
  extends AbstractValidatorTest
{
  @Test
  public void allInheritsPresent()
  {
    final WebIDLSchema schema = loadTestLocalSchema( "allInheritsPresent" + WebIDLSchema.EXTENSION );

    // Some assertions just to make sure it is in the shape we expect
    assertEquals( schema.getDictionaries().size(), 3 );
    assertEquals( schema.getInterfaces().size(), 3 );

    validate( schema, 0 );
  }

  @Test
  public void missingDictionaryInherit()
  {
    final WebIDLSchema schema = loadTestLocalSchema( "missingDictionaryInherit" + WebIDLSchema.EXTENSION );

    // Some assertions just to make sure it is in the shape we expect
    assertEquals( schema.getDictionaries().size(), 4 );

    final Collection<ValidationError> errors = validate( schema, 1 );
    assertErrorPresent( errors,
                        "Dictionary named 'DanglingDictionary' inherits from dictionary named 'MissingDictionary' but no such dictionary exists" );
  }

  @Test
  public void missingInterfaceInherit()
  {
    final WebIDLSchema schema = loadTestLocalSchema( "missingInterfaceInherit" + WebIDLSchema.EXTENSION );

    // Some assertions just to make sure it is in the shape we expect
    assertEquals( schema.getInterfaces().size(), 4 );

    final Collection<ValidationError> errors = validate( schema, 1 );
    assertErrorPresent( errors,
                        "Interface named 'DanglingInterface' inherits from interface named 'MissingInterface' but no such interface exists" );
  }

  @Override
  @Nonnull
  Validator createValidator()
  {
    return new InheritsValidator();
  }
}
