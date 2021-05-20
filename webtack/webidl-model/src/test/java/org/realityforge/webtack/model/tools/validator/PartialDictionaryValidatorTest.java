package org.realityforge.webtack.model.tools.validator;

import java.util.Collection;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.WebIDLSchema;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class PartialDictionaryValidatorTest
  extends AbstractValidatorTest
{
  @Test
  public void allPartialsMatch()
  {
    final WebIDLSchema schema = loadTestLocalSchema( "allPartialsMatch" + WebIDLSchema.EXTENSION );

    // Some assertions just to make sure it is in the shape we expect
    assertEquals( schema.getDictionaries().size(), 2 );
    assertEquals( schema.getPartialDictionaries().size(), 3 );

    validate( schema, 0 );
  }

  @Test
  public void dictionaryMissing()
  {
    final WebIDLSchema schema = loadTestLocalSchema( "dictionaryMissing" + WebIDLSchema.EXTENSION );

    // Some assertions just to make sure it is in the shape we expect
    assertEquals( schema.getDictionaries().size(), 1 );
    assertEquals( schema.getPartialDictionaries().size(), 3 );

    final Collection<ValidationError> errors = validate( schema, 1 );
    assertErrorPresent( errors,
                        "Dictionary named 'DictionaryB' does not exist but a partial for the dictionary does exist" );
  }

  @Override
  @Nonnull
  Validator createValidator()
  {
    return new PartialDictionaryValidator();
  }
}
