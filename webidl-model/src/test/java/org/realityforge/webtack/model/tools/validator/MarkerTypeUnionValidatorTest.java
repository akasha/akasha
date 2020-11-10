package org.realityforge.webtack.model.tools.validator;

import java.util.Collection;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.WebIDLSchema;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class MarkerTypeUnionValidatorTest
  extends AbstractValidatorTest
{
  @Test
  public void validMarkerTypeUnion()
  {
    final WebIDLSchema schema = loadTestLocalSchema( "validMarkerTypeUnion" + WebIDLSchema.EXTENSION );

    // Some assertions just to make sure it is in the shape we expect
    assertEquals( schema.getTypedefs().size(), 3 );
    assertEquals( schema.getInterfaces().size(), 6 );

    validate( schema, 0 );
  }

  @Test
  public void nonReferenceMarkerTypeUnion()
  {
    final WebIDLSchema schema = loadTestLocalSchema( "nonReferenceMarkerTypeUnion" + WebIDLSchema.EXTENSION );

    // Some assertions just to make sure it is in the shape we expect
    assertEquals( schema.getTypedefs().size(), 1 );
    assertEquals( schema.getInterfaces().size(), 2 );

    final Collection<ValidationError> errors = validate( schema, 1 );
    assertErrorPresent( errors,
                        "Typedef named 'TexImageSource' has the MarkerType extended attribute but contains a member type 'long' that is not a reference to an interface." );
  }

  @Test
  public void invalidReferenceMarkerTypeUnion()
  {
    final WebIDLSchema schema = loadTestLocalSchema( "invalidReferenceMarkerTypeUnion" + WebIDLSchema.EXTENSION );

    // Some assertions just to make sure it is in the shape we expect
    assertEquals( schema.getEnumerations().size(), 1 );
    assertEquals( schema.getTypedefs().size(), 1 );
    assertEquals( schema.getInterfaces().size(), 3 );

    final Collection<ValidationError> errors = validate( schema, 1 );
    assertErrorPresent( errors,
                        "Typedef named 'TexImageSource' has the MarkerType extended attribute but contains a member type 'BasicEnumeration' that is not a reference to an interface." );
  }

  @Nonnull
  Validator createValidator()
  {
    return new MarkerTypeUnionValidator();
  }
}
