package org.realityforge.webtack.model.tools.validator;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.TestNode;
import org.realityforge.webtack.model.WebIDLSchema;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class AggregateValidatorTest
{
  @Test
  public void basicOperation()
  {
    final TestValidator validator1 = new TestValidator( Collections.singleton( error( "V1" ) ) );
    final TestValidator validator2 = new TestValidator( Collections.emptyList() );
    final TestValidator validator3 = new TestValidator( Collections.singleton( error( "V3", true ) ) );
    final TestValidator validator4 = new TestValidator( Collections.singleton( error( "V4" ) ) );
    final AggregateValidator validator =
      new AggregateValidator( Arrays.asList( validator1, validator2, validator3, validator4 ) );

    final Collection<ValidationError> errors = validator.validate( createEmptySchema() );
    assertErrorCount( errors, 2 );
    assertErrorMessagePresent( errors, "V1", false );
    assertErrorMessagePresent( errors, "V3", true );
    assertErrorMessageNotPresent( errors, "V4" );
    assertErrorMessageNotPresent( errors, "other" );
  }

  private void assertErrorMessagePresent( @Nonnull final Collection<ValidationError> errors,
                                          @Nonnull final String message,
                                          final boolean haltValidation )
  {
    assertTrue( errors.stream()
                  .anyMatch( e -> e.getMessage().equals( message ) && e.shouldHalt() == haltValidation ) );
  }

  private void assertErrorMessageNotPresent( @Nonnull final Collection<ValidationError> errors,
                                             @Nonnull final String message )
  {
    assertTrue( errors.stream().noneMatch( e -> e.getMessage().equals( message ) ) );
  }

  private void assertErrorCount( @Nonnull final Collection<ValidationError> errors, final int expected )
  {
    assertEquals( errors.size(), expected );
  }

  @Nonnull
  private ValidationError error( @Nonnull final String message )
  {
    return error( message, false );
  }

  @Nonnull
  private ValidationError error( @Nonnull final String message, final boolean haltValidation )
  {
    return new ValidationError( new TestNode(), message, haltValidation );
  }

  @Nonnull
  private WebIDLSchema createEmptySchema()
  {
    return new WebIDLSchema( Collections.emptyMap(),
                             Collections.emptyMap(),
                             Collections.emptyMap(),
                             Collections.emptyMap(),
                             Collections.emptyMap(),
                             Collections.emptyMap(),
                             Collections.emptyList(),
                             Collections.emptyMap(),
                             Collections.emptyMap(),
                             Collections.emptyMap(),
                             Collections.emptyMap(),
                             Collections.emptyMap(),
                             Collections.emptyMap(),
                             Collections.emptyList(),
                             Collections.emptySet() );
  }
}
