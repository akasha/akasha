package org.realityforge.webtack.model.tools.validator;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nonnull;

public final class ValidatorTool
{
  private ValidatorTool()
  {
  }

  @Nonnull
  public static Validator create()
  {
    final List<Validator> validators = new ArrayList<>();
    validators.add( new InheritsValidator() );
    validators.add( new UniqueNamesValidator() );
    return new AggregateValidator( validators );
  }
}
