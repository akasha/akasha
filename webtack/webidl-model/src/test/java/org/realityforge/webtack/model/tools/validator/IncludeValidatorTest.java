package org.realityforge.webtack.model.tools.validator;

import java.util.Collection;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.WebIDLSchema;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class IncludeValidatorTest
  extends AbstractValidatorTest
{
  @Test
  public void allElementsPresent()
  {
    final WebIDLSchema schema = loadTestLocalSchema( "allElementsPresent" + WebIDLSchema.EXTENSION );

    // Some assertions just to make sure it is in the shape we expect
    assertEquals( schema.getMixins().size(), 1 );
    assertEquals( schema.getInterfaces().size(), 1 );
    assertEquals( schema.getIncludes().size(), 1 );

    validate( schema, 0 );
  }

  @Test
  public void interfaceMissing()
  {
    final WebIDLSchema schema = loadTestLocalSchema( "interfaceMissing" + WebIDLSchema.EXTENSION );

    // Some assertions just to make sure it is in the shape we expect
    assertEquals( schema.getMixins().size(), 1 );
    assertEquals( schema.getInterfaces().size(), 0 );
    assertEquals( schema.getIncludes().size(), 1 );

    final Collection<ValidationError> errors = validate( schema, 1 );
    assertErrorPresent( errors,
                        "Include of mixin named 'MixinInterfaceA' into interface named 'InterfaceA' defined but no such interface exists" );
  }

  @Test
  public void mixinMissing()
  {
    final WebIDLSchema schema = loadTestLocalSchema( "mixinMissing" + WebIDLSchema.EXTENSION );

    // Some assertions just to make sure it is in the shape we expect
    assertEquals( schema.getMixins().size(), 0 );
    assertEquals( schema.getInterfaces().size(), 1 );
    assertEquals( schema.getIncludes().size(), 1 );

    final Collection<ValidationError> errors = validate( schema, 1 );
    assertErrorPresent( errors,
                        "Include of mixin named 'MixinInterfaceA' into interface named 'InterfaceA' defined but no such mixin exists" );
  }

  @Override
  @Nonnull
  Validator createValidator()
  {
    return new IncludeValidator();
  }
}
