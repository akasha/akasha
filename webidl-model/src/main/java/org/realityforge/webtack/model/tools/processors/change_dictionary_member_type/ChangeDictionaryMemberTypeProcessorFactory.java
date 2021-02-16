package org.realityforge.webtack.model.tools.processors.change_dictionary_member_type;

import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.processors.AbstractProcessorFactory;
import org.realityforge.webtack.model.tools.spi.Name;
import org.realityforge.webtack.model.tools.spi.PipelineContext;
import org.realityforge.webtack.model.tools.spi.Processor;

@Name( "ChangeDictionaryMemberType" )
public final class ChangeDictionaryMemberTypeProcessorFactory
  extends AbstractProcessorFactory
{
  public String dictionaryNamePattern;
  public String dictionaryMemberNamePattern;
  public String type;
  public int expectedChangeCount;

  @Nonnull
  @Override
  public Processor create( @Nonnull final PipelineContext context )
  {
    return new ChangeDictionaryMemberTypeProcessor( context,
                                                    requirePattern( "dictionaryNamePattern", dictionaryNamePattern ),
                                                    requirePattern( "dictionaryMemberNamePattern",
                                                                    dictionaryMemberNamePattern ),
                                                    requireType( "type", type ),
                                                    expectedChangeCount );
  }
}
