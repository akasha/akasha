package org.realityforge.webtack.model.tools.processors.validate;

import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.spi.Name;
import org.realityforge.webtack.model.tools.spi.Processor;
import org.realityforge.webtack.model.tools.spi.ProcessorFactory;
import org.realityforge.webtack.model.tools.validator.ValidatorRuleConfig;

@Name( "Validate" )
public final class ValidateProcessorFactory
  implements ProcessorFactory
{
  public ValidatorRuleConfig ruleConfig = new ValidatorRuleConfig();

  @Nonnull
  @Override
  public Processor create()
  {
    return new ValidateProcessor( ruleConfig );
  }
}
