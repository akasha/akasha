package org.realityforge.webtack.jsinterop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.validator.ValidatorRuleConfig;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public final class FixtureTest
  extends AbstractTest
{
  @DataProvider( name = "fixtureTests" )
  public Object[][] fixtureTests()
    throws IOException
  {
    return Files.list( getBaseFixtureDir() )
      .filter( Files::isDirectory )
      .filter( d -> Files.exists( d.resolve( "schema.webidl" ) ) )
      .map( d -> new Object[]{ d } )
      .toArray( Object[][]::new );
  }

  @Test( dataProvider = "fixtureTests" )
  public void fixtureTest( @Nonnull final Path directory )
    throws Exception
  {
    final ValidatorRuleConfig validatorRuleConfig = new ValidatorRuleConfig();
    if ( directory.getFileName().toString().equals( "partial_interface" ) )
    {
      validatorRuleConfig.allowDanglingInterfacePartials = true;
    }
    generateCode( directory, validatorRuleConfig );
  }
}
