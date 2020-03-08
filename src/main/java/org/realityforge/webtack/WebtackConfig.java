package org.realityforge.webtack;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;
import javax.annotation.Nonnull;

public final class WebtackConfig
{
  @Nonnull
  static final String PROPERTY_KEY = "webtack.version";
  @Nonnull
  private static final Properties c_config = loadConfig();

  @Nonnull
  public static String getVersion()
  {
    final String versionProperty = System.getProperty( PROPERTY_KEY );
    if ( null != versionProperty )
    {
      return versionProperty;
    }
    else
    {
      return Objects.requireNonNull( c_config.getProperty( "version" ) );
    }
  }

  @Nonnull
  private static Properties loadConfig()
  {
    final InputStream inputStream = WebtackConfig.class.getResourceAsStream( "config.properties" );
    assert null != inputStream;

    try
    {
      final Properties properties = new Properties();
      properties.load( inputStream );
      return properties;
    }
    catch ( final IOException e )
    {
      throw new WebtackConfigurationException( "Failed to load config.properties", e );
    }
  }

  private WebtackConfig()
  {
  }
}
