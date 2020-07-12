package org.realityforge.webtack.model.tools.validator;

import java.util.Collection;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.WebIDLSchema;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class PartialNamespaceValidatorTest
  extends AbstractValidatorTest
{
  @Test
  public void allPartialsMatch()
  {
    final WebIDLSchema schema = loadTestLocalSchema( "allPartialsMatch" + WebIDLSchema.EXTENSION );

    // Some assertions just to make sure it is in the shape we expect
    assertEquals( schema.getNamespaces().size(), 2 );
    assertEquals( schema.getPartialNamespaces().size(), 3 );

    validate( schema, 0 );
  }

  @Test
  public void namespaceMissing()
  {
    final WebIDLSchema schema = loadTestLocalSchema( "namespaceMissing" + WebIDLSchema.EXTENSION );

    // Some assertions just to make sure it is in the shape we expect
    assertEquals( schema.getNamespaces().size(), 1 );
    assertEquals( schema.getPartialNamespaces().size(), 3 );

    final Collection<ValidationError> errors = validate( schema, 1 );
    assertErrorPresent( errors,
                        "Namespace named 'NamespaceB' does not exist but a partial for the namespace does exist" );
  }

  @Nonnull
  Validator createValidator()
  {
    return new PartialNamespaceValidator();
  }
}
