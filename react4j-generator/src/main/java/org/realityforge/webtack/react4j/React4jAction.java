package org.realityforge.webtack.react4j;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.tools.io.FilesUtil;
import org.realityforge.webtack.model.tools.util.AbstractJavaAction;
import org.realityforge.webtack.model.tools.util.NamingUtil;

final class React4jAction
  extends AbstractJavaAction
{
  @Nullable
  private final String _factoryName;
  private final boolean _generateGwtModule;

  React4jAction( @Nonnull final Path outputDirectory,
                 @Nonnull final String packageName,
                 @Nullable final String factoryName,
                 final boolean generateGwtModule )
  {
    super( outputDirectory, packageName );
    _factoryName = factoryName;
    _generateGwtModule = generateGwtModule;
  }

  @Override
  public void process( @Nonnull final WebIDLSchema schema )
    throws Exception
  {
    schema.link();
    processInit();

    FilesUtil.deleteDirectory( getMainJavaDirectory() );

    if ( _generateGwtModule )
    {
      writeGwtModule();
    }
  }

  private void writeGwtModule()
    throws IOException
  {
    final String gwtModuleContent =
      "<module>\n" +
      "  <source path=''/>\n" +
      "</module>\n";
    final String packageName = getPackageName();
    final String name =
      packageName.isEmpty() ?
      "core" :
      NamingUtil.uppercaseFirstCharacter( packageName.replaceAll( ".*\\.([^.]+)$", "$1" ) );
    writeResourceFile( name + ".gwt.xml", gwtModuleContent.getBytes( StandardCharsets.UTF_8 ) );
  }

  @Nonnull
  @Override
  protected Map<String, Path> getGeneratedFiles()
  {
    return super.getGeneratedFiles();
  }

  @Nonnull
  @Override
  protected Path getMainJavaDirectory()
  {
    return super.getMainJavaDirectory();
  }
}
