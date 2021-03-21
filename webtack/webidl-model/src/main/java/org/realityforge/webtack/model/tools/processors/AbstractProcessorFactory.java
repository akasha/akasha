package org.realityforge.webtack.model.tools.processors;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.ExtendedAttribute;
import org.realityforge.webtack.model.Type;
import org.realityforge.webtack.model.WebIDLModelParser;
import org.realityforge.webtack.model.tools.spi.ProcessorFactory;
import org.realityforge.webtack.webidl.parser.WebIDLParser;
import org.realityforge.webtack.webidl.parser.WebIDLParserTool;

public abstract class AbstractProcessorFactory
  implements ProcessorFactory
{
  protected final <T> T requireNonNull( @Nonnull final String key, @Nullable final T value )
  {
    if ( null == value )
    {
      throw new IllegalArgumentException( getProcessorName() + " missing required " + key + " configuration value" );
    }
    else
    {
      return value;
    }
  }

  @SuppressWarnings( "SameParameterValue" )
  @Nonnull
  protected final ExtendedAttribute requireExtendedAttribute( @Nonnull final String key, @Nonnull final String value )
  {
    try
    {
      return ExtendedAttribute.parse( requireNonNull( key, value ) );
    }
    catch ( final Exception e )
    {
      throw new IllegalArgumentException( getProcessorName() + " failed to parse the " + key + " configuration value",
                                          e );
    }
  }

  @SuppressWarnings( "SameParameterValue" )
  @Nonnull
  protected final Type requireType( @Nonnull final String key, @Nonnull final String value )
  {
    try
    {
      final WebIDLParser parser =
        WebIDLParserTool.createParser( "", new StringReader( "attribute " + value + " v;" ) );
      parser.setBuildParseTree( true );
      final WebIDLParser.ReadWriteAttributeContext ctx = parser.readWriteAttribute();
      return WebIDLModelParser.parse( ctx,
                                      new HashSet<>(),
                                      null,
                                      new ArrayList<>(),
                                      WebIDLModelParser.parseSourcePosition( ctx.getStart() ) )
        .getType();
    }
    catch ( final Exception e )
    {
      throw new IllegalArgumentException( getProcessorName() + " failed to parse the " + key + " configuration value",
                                          e );
    }
  }

  @Nonnull
  protected final Pattern requirePattern( @Nonnull final String key, @Nonnull final String pattern )
  {
    try
    {
      return Pattern.compile( requireNonNull( key, pattern ) );
    }
    catch ( final PatternSyntaxException pse )
    {
      throw new IllegalArgumentException( getProcessorName() + " supplied invalid configuration value " + key +
                                          " that is not a valid java regular expression", pse );
    }
  }

  @Nonnull
  protected String getProcessorName()
  {
    return getClass().getSimpleName().replaceAll( "Factory$", "" );
  }
}
