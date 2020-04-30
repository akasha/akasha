package org.realityforge.webtack.model.tools.validator;

import java.util.Collection;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.WebIDLSchema;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class PartialValidatorTest
  extends AbstractValidatorTest
{
  @Test
  public void allPartialsMatch()
  {
    final WebIDLSchema schema = loadTestLocalSchema( "allPartialsMatch.webidl" );

    // Some assertions just to make sure it is in the shape we expect
    assertEquals( schema.getNamespaces().size(), 2 );
    assertEquals( schema.getPartialNamespaces().size(), 3 );
    assertEquals( schema.getDictionaries().size(), 2 );
    assertEquals( schema.getPartialDictionaries().size(), 3 );
    assertEquals( schema.getInterfaces().size(), 2 );
    assertEquals( schema.getPartialInterfaces().size(), 3 );
    assertEquals( schema.getMixins().size(), 2 );
    assertEquals( schema.getPartialMixins().size(), 3 );

    validate( schema, 0 );
  }

  @Test
  public void dictionaryMissing()
  {
    final WebIDLSchema schema = loadTestLocalSchema( "dictionaryMissing.webidl" );

    // Some assertions just to make sure it is in the shape we expect
    assertEquals( schema.getDictionaries().size(), 1 );
    assertEquals( schema.getPartialDictionaries().size(), 3 );

    final Collection<ValidationError> errors = validate( schema, 1 );
    assertErrorPresent( errors,
                        "Dictionary named 'DictionaryB' does not exist but a partial for the dictionary does exist" );
  }

  @Test
  public void interfaceMissing()
  {
    final WebIDLSchema schema = loadTestLocalSchema( "interfaceMissing.webidl" );

    // Some assertions just to make sure it is in the shape we expect
    assertEquals( schema.getInterfaces().size(), 1 );
    assertEquals( schema.getPartialInterfaces().size(), 3 );

    final Collection<ValidationError> errors = validate( schema, 1 );
    assertErrorPresent( errors,
                        "Interface named 'InterfaceB' does not exist but a partial for the interface does exist" );
  }

  @Test
  public void mixinMissing()
  {
    final WebIDLSchema schema = loadTestLocalSchema( "mixinMissing.webidl" );

    // Some assertions just to make sure it is in the shape we expect
    assertEquals( schema.getMixins().size(), 1 );
    assertEquals( schema.getPartialMixins().size(), 3 );

    final Collection<ValidationError> errors = validate( schema, 1 );
    assertErrorPresent( errors,
                        "Mixin named 'MixinB' does not exist but a partial for the mixin does exist" );
  }

  @Test
  public void namespaceMissing()
  {
    final WebIDLSchema schema = loadTestLocalSchema( "namespaceMissing.webidl" );

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
    return new PartialValidator();
  }
}
