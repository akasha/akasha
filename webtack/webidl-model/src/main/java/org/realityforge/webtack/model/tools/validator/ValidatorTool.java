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
  public static Validator create( @Nonnull final ValidatorRuleConfig config )
  {
    final List<Validator> validators = new ArrayList<>();
    validators.add( new InheritsValidator() );
    validators.add( new IncludeValidator() );
    validators.add( new UniqueNamesValidator() );
    if ( !config.allowDanglingDictionaryPartials )
    {
      validators.add( new PartialDictionaryValidator() );
    }
    if ( !config.allowDanglingInterfacePartials )
    {
      validators.add( new PartialInterfaceValidator() );
    }
    if ( !config.allowDanglingMixinPartials )
    {
      validators.add( new PartialMixinValidator() );
    }
    if ( !config.allowDanglingNamespacePartials )
    {
      validators.add( new PartialNamespaceValidator() );
    }
    validators.add( new TypeReferenceValidator() );
    validators.add( new ConstEnumerationValidator() );
    validators.add( new MarkerTypeUnionValidator() );
    return new AggregateValidator( validators );
  }
}
