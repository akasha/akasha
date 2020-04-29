package org.realityforge.webtack.model.tools.validator;

import java.util.Collection;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.AbstractTest;
import org.realityforge.webtack.model.WebIDLSchema;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class InheritsValidatorTest
  extends AbstractTest
{
  @Test
  public void allInheritsPresent()
  {
    final WebIDLSchema schema = loadSchema( "allInheritsPresent.webidl" );

    // Some assertions just to make sure it is in the shape we expect
    assertEquals( schema.getDictionaries().size(), 3 );
    assertEquals( schema.getInterfaces().size(), 3 );

    final Collection<ValidationError> errors = new InheritsValidator().validate( schema );

    assertEquals( errors.size(), 0 );
  }

  @Test
  public void missingDictionaryInherit()
  {
    final WebIDLSchema schema = loadSchema( "missingDictionaryInherit.webidl" );

    // Some assertions just to make sure it is in the shape we expect
    assertEquals( schema.getDictionaries().size(), 4 );

    final Collection<ValidationError> errors = new InheritsValidator().validate( schema );

    assertEquals( errors.size(), 1 );
    assertErrorPresent( errors, "Dictionary named 'DanglingDictionary' inherits from dictionary named 'MissingDictionary' but no such dictionary exists", true );
  }


  @Test
  public void missingInterfaceInherit()
  {
    final WebIDLSchema schema = loadSchema( "missingInterfaceInherit.webidl" );

    // Some assertions just to make sure it is in the shape we expect
    assertEquals( schema.getInterfaces().size(), 4 );

    final Collection<ValidationError> errors = new InheritsValidator().validate( schema );

    assertEquals( errors.size(), 1 );
    assertErrorPresent( errors, "Interface named 'DanglingInterface' inherits from interface named 'MissingInterface' but no such interface exists", true );
  }

  private void assertErrorPresent( @Nonnull final Collection<ValidationError> errors,
                                   @Nonnull final String message,
                                   final boolean shouldHaltValidation )
  {
    assertTrue( errors.stream()
                  .anyMatch( e -> e.getMessage().equals( message ) &&
                                  e.shouldHaltValidation() == shouldHaltValidation ) );
  }

  @Nonnull
  private WebIDLSchema loadSchema( final String filename )
  {
    return loadWebIDLSchema( getTestLocalFixtureDir().resolve( filename ) );
  }
}
