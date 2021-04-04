package org.realityforge.webtack.jsinterop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
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
    final String scenario = directory.getFileName().toString();
    if ( "partial_interface".equals( scenario ) || "javadocs".equals( scenario ) || "input_catalog".equals( scenario ) )
    {
      validatorRuleConfig.allowDanglingInterfacePartials = true;
    }
    String globalInterface = null;
    if ( "global_interface".equals( scenario ) ||
         "namespaces".equals( scenario ) ||
         "global_object".equals( scenario ) ||
         "deprecated".equals( scenario ) )
    {
      globalInterface = "Window";
    }

    final String commonDir = "alt_inherit".equals( scenario ) ? "_other_common_code" : "_common_code";
    final List<String> gwtInherits = new ArrayList<>();
    if ( "alt_inherit".equals( scenario ) )
    {
      gwtInherits.add( "com.other.Other" );
    }
    final String packageName = "com.example";
    generateCode( directory,
                  directory.getParent().resolve( commonDir ),
                  loadWebIDLSchema( directory.resolve( "schema.webidl" ) ),
                  packageName,
                  globalInterface,
                  validatorRuleConfig,
                  gwtInherits );
  }
}
