package org.realityforge.webtack.model.tools.validator;

import java.util.Collection;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.WebIDLSchema;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class PartialMixinValidatorTest
  extends AbstractValidatorTest
{
  @Test
  public void allPartialsMatch()
  {
    final WebIDLSchema schema = loadTestLocalSchema( "allPartialsMatch" + WebIDLSchema.EXTENSION );

    // Some assertions just to make sure it is in the shape we expect
    assertEquals( schema.getMixins().size(), 2 );
    assertEquals( schema.getPartialMixins().size(), 3 );

    validate( schema, 0 );
  }

  @Test
  public void mixinMissing()
  {
    final WebIDLSchema schema = loadTestLocalSchema( "mixinMissing" + WebIDLSchema.EXTENSION );

    // Some assertions just to make sure it is in the shape we expect
    assertEquals( schema.getMixins().size(), 1 );
    assertEquals( schema.getPartialMixins().size(), 3 );

    final Collection<ValidationError> errors = validate( schema, 1 );
    assertErrorPresent( errors,
                        "Mixin named 'MixinB' does not exist but a partial for the mixin does exist" );
  }

  @Nonnull
  Validator createValidator()
  {
    return new PartialMixinValidator();
  }
}
