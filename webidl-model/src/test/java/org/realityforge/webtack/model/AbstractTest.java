package org.realityforge.webtack.model;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.nio.file.Path;
import java.util.UUID;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.antlr.v4.runtime.ParserRuleContext;
import org.realityforge.webtack.webidl.parser.WebIDLParser;
import org.testng.Assert;
import static org.testng.Assert.*;

public abstract class AbstractTest
{
  protected final void assertArgument( @Nonnull final Argument argument,
                                       @Nonnull final String name,
                                       @Nonnull final Kind kind,
                                       final boolean optional,
                                       final boolean variadic )
  {
    assertEquals( argument.getName(), name );
    assertEquals( argument.getType().getKind(), kind );
    assertEquals( argument.isOptional(), optional );
    assertEquals( argument.isVariadic(), variadic );
  }

  @Nonnull
  protected final String randomString()
  {
    return UUID.randomUUID().toString().substring( 0, 7 );
  }

  protected final <T extends Throwable> void assertThrows( @Nonnull Class<T> throwableClass,
                                                           @Nullable final String message,
                                                           @Nonnull final Assert.ThrowingRunnable throwingRunnable )
  {
    assertEquals( expectThrows( throwableClass, throwingRunnable ).getMessage(), message );
  }

  @Nonnull
  protected final WebIDLParser createParser( @Nonnull final String webIDL )
    throws IOException
  {
    return WebIDLModelParser.createParser( "test", new StringReader( webIDL ) );
  }

  @Nonnull
  protected final SourcePosition parseStartPosition( @Nonnull final ParserRuleContext ctx )
  {
    return WebIDLModelParser.parseSourcePosition( ctx.getStart() );
  }

  @Nonnull
  protected final WebIDLSchema loadWebIDLSchema( @Nonnull final Path file )
  {
    return loadWebIDLSchema( file, null );
  }

  @Nonnull
  protected final WebIDLSchema loadWebIDLSchema( @Nonnull final Path file, @Nullable final String testDescription )
  {
    final String filename = file.toString();
    try ( final Reader reader = new FileReader( file.toFile() ) )
    {
      return WebIDLModelParser.parse( filename, reader, new BailErrorListener( filename ) );
    }
    catch ( final IOException ioe )
    {
      throw new AssertionError( "Error reading file " + filename +
                                ( null == testDescription ? "" : " for " + testDescription ) );
    }
  }

  @Nonnull
  protected final Path getTestLocalFixtureDir()
  {
    return getBaseFixtureDir().resolve( getClass().getName().replaceAll( "\\.", File.separator ) );
  }

  protected final boolean writeOutputFixtures()
  {
    return "true".equals( System.getProperty( "webtack.output_fixture_data" ) );
  }

  @Nonnull
  protected final Path getBaseFixtureDir()
  {
    final String key = "webtack.fixture_dir";
    final String fixtureDir = System.getProperty( key );
    assertNotNull( fixtureDir, "Expected System.getProperty( \"" + key + "\" ) to return fixture directory" );
    return new File( fixtureDir ).toPath();
  }
}
