package org.realityforge.webtack.model.tools.processors.change_dictionary_member_type;

import java.util.Objects;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.DictionaryDefinition;
import org.realityforge.webtack.model.DictionaryMember;
import org.realityforge.webtack.model.NamedDefinition;
import org.realityforge.webtack.model.NamedElement;
import org.realityforge.webtack.model.PartialDictionaryDefinition;
import org.realityforge.webtack.model.Type;
import org.realityforge.webtack.model.tools.processors.AbstractProcessor;
import org.realityforge.webtack.model.tools.spi.Completable;
import org.realityforge.webtack.model.tools.spi.PipelineContext;

final class ChangeDictionaryMemberTypeProcessor
  extends AbstractProcessor
  implements Completable
{
  @Nonnull
  private final Pattern _dictionaryNamePattern;
  @Nonnull
  private final Pattern _dictionaryMemberNamePattern;
  @Nonnull
  private final Type _type;
  private boolean _lastElementMatched;
  public final int _expectedChangeCount;
  private int _changeCount;

  ChangeDictionaryMemberTypeProcessor( @Nonnull final PipelineContext context,
                                       @Nonnull final Pattern dictionaryNamePattern,
                                       @Nonnull final Pattern dictionaryMemberNamePattern,
                                       @Nonnull final Type type,
                                       final int expectedChangeCount )
  {
    super( context );
    _dictionaryNamePattern = Objects.requireNonNull( dictionaryNamePattern );
    _dictionaryMemberNamePattern = Objects.requireNonNull( dictionaryMemberNamePattern );
    _type = Objects.requireNonNull( type );
    _expectedChangeCount = expectedChangeCount;
  }

  @Override
  public void onComplete()
  {
    if ( _expectedChangeCount > 0 )
    {
      if ( _changeCount != _expectedChangeCount )
      {
        context().error( "Changed " + _changeCount + " members but expected to " +
                         "change " + _expectedChangeCount + " members." );
      }
    }
    else
    {
      if ( 0 == _changeCount )
      {
        context().error( "Changed " + _changeCount + " members. Remove processor." );
      }
      else
      {
        context().debug( "Changed " + _changeCount + " members." );
      }
    }
  }

  @Nullable
  @Override
  protected DictionaryDefinition transformDictionary( @Nonnull final DictionaryDefinition input )
  {
    _lastElementMatched = matches( input );
    try
    {
      return super.transformDictionary( input );
    }
    finally
    {
      _lastElementMatched = false;
    }
  }

  @Nullable
  @Override
  protected PartialDictionaryDefinition transformPartialDictionary( @Nonnull final PartialDictionaryDefinition input )
  {
    _lastElementMatched = matches( input );
    try
    {
      return super.transformPartialDictionary( input );
    }
    finally
    {
      _lastElementMatched = false;
    }
  }

  @Nonnull
  @Override
  protected DictionaryMember transformDictionaryMember( @Nonnull final DictionaryMember input )
  {
    final boolean matches = matches( input );
    if ( matches )
    {
      _changeCount++;
    }
    return new DictionaryMember( input.getName(),
                                 matches ? _type : transformType( input.getType() ),
                                 input.isOptional(),
                                 input.getDefaultValue(),
                                 transformDocumentation( input.getDocumentation() ),
                                 transformExtendedAttributes( input.getExtendedAttributes() ),
                                 transformSourceLocations( input.getSourceLocations() ) );
  }

  private boolean matches( @Nonnull final NamedDefinition input )
  {
    return _dictionaryNamePattern.matcher( input.getName() ).matches();
  }

  private boolean matches( @Nonnull final NamedElement input )
  {
    final String name = input.getName();
    return _lastElementMatched && _dictionaryMemberNamePattern.matcher( name ).matches();
  }
}
