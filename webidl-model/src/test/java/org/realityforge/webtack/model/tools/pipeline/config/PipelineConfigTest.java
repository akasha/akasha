package org.realityforge.webtack.model.tools.pipeline.config;

import gir.io.FileUtil;
import java.nio.file.Path;
import java.util.List;
import javax.json.JsonObject;
import org.realityforge.webtack.model.AbstractTest;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class PipelineConfigTest
  extends AbstractTest
{
  @Test
  public void load()
    throws Exception
  {
    final Path directory = getWorkingDirectory();
    final Path file = directory.resolve( "main.json" );
    FileUtil.write( file,
                    "{\n" +
                    "  \"sourceSelector\": \"*\",\n" +
                    "  \"stages\": [\n" +
                    "    {\n" +
                    "      \"name\": \"RemoveIncludes\",\n" +
                    "      \"sourceSelector\": \"name=svg2\",\n" +
                    "      \"config\": {\n" +
                    "        \"interfacePattern\": \"^SVGAElement$\",\n" +
                    "        \"mixinPattern\": \"^SVGURIReference$\"\n" +
                    "      }\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"name\": \"ExtractExposureSet\",\n" +
                    "      \"config\": {\n" +
                    "        \"globalInterface\": \"Window\"\n" +
                    "      }\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"name\": \"Merge\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"name\": \"Flatten\"\n" +
                    "    }\n" +
                    "  ]\n" +
                    "}" );

    final PipelineConfig config = PipelineConfig.load( "main", directory );

    assertEquals( config.getName(), "main" );
    assertEquals( config.getSourceSelector(), "*" );
    final List<StageConfig> stages = config.getStages();
    assertEquals( stages.size(), 4 );

    final StageConfig stage1 = stages.get( 0 );
    assertEquals( stage1.getName(), "RemoveIncludes" );
    assertEquals( stage1.getSourceSelector(), "name=svg2" );
    final JsonObject config1 = stage1.getConfig();
    assertNotNull( config1 );
    assertEquals( config1.toString(),
                  "{\"interfacePattern\":\"^SVGAElement$\",\"mixinPattern\":\"^SVGURIReference$\"}" );

    final StageConfig stage2 = stages.get( 1 );
    assertEquals( stage2.getName(), "ExtractExposureSet" );
    assertNull( stage2.getSourceSelector() );
    final JsonObject config2 = stage2.getConfig();
    assertNotNull( config2 );
    assertEquals( config2.toString(), "{\"globalInterface\":\"Window\"}" );

    final StageConfig stage3 = stages.get( 2 );
    assertEquals( stage3.getName(), "Merge" );
    assertNull( stage3.getSourceSelector() );
    assertNull( stage3.getConfig() );

    final StageConfig stage4 = stages.get( 3 );
    assertEquals( stage4.getName(), "Flatten" );
    assertNull( stage4.getSourceSelector() );
    assertNull( stage4.getConfig() );
  }

  @Test
  public void load_withPre()
    throws Exception
  {
    final Path directory = getWorkingDirectory();
    FileUtil.write( directory.resolve( "base.json" ),
                    "{\n" +
                    "  \"sourceSelector\": \"*\",\n" +
                    "  \"stages\": [\n" +
                    "    {\n" +
                    "      \"name\": \"RemoveIncludes\",\n" +
                    "      \"sourceSelector\": \"name=svg2\",\n" +
                    "      \"config\": {\n" +
                    "        \"interfacePattern\": \"^SVGAElement$\",\n" +
                    "        \"mixinPattern\": \"^SVGURIReference$\"\n" +
                    "      }\n" +
                    "    }\n" +
                    "  ]\n" +
                    "}" );
    FileUtil.write( directory.resolve( "base2.json" ),
                    "{\n" +
                    "  \"stages\": [\n" +
                    "    {\n" +
                    "      \"name\": \"ExtractExposureSet\",\n" +
                    "      \"config\": {\n" +
                    "        \"globalInterface\": \"Window\"\n" +
                    "      }\n" +
                    "    }\n" +
                    "  ]\n" +
                    "}" );
    FileUtil.write( directory.resolve( "base3.json" ),
                    "{\n" +
                    "  \"pre\": [\"base2\"],\n" +
                    "  \"stages\": [\n" +
                    "    {\n" +
                    "      \"name\": \"Merge\"\n" +
                    "    }\n" +
                    "  ]\n" +
                    "}" );
    FileUtil.write( directory.resolve( "main.json" ),
                    "{\n" +
                    "  \"pre\": [\"base\", \"base3\"],\n" +
                    "  \"stages\": [\n" +
                    "    {\n" +
                    "      \"name\": \"Flatten\"\n" +
                    "    }\n" +
                    "  ]\n" +
                    "}" );

    final PipelineConfig config = PipelineConfig.load( "main", directory );

    assertEquals( config.getName(), "main" );
    assertEquals( config.getSourceSelector(), "*" );
    final List<StageConfig> stages = config.getStages();
    assertEquals( stages.size(), 4 );

    final StageConfig stage1 = stages.get( 0 );
    assertEquals( stage1.getName(), "RemoveIncludes" );
    assertEquals( stage1.getSourceSelector(), "name=svg2" );
    final JsonObject config1 = stage1.getConfig();
    assertNotNull( config1 );
    assertEquals( config1.toString(),
                  "{\"interfacePattern\":\"^SVGAElement$\",\"mixinPattern\":\"^SVGURIReference$\"}" );

    final StageConfig stage2 = stages.get( 1 );
    assertEquals( stage2.getName(), "ExtractExposureSet" );
    assertNull( stage2.getSourceSelector() );
    final JsonObject config2 = stage2.getConfig();
    assertNotNull( config2 );
    assertEquals( config2.toString(), "{\"globalInterface\":\"Window\"}" );

    final StageConfig stage3 = stages.get( 2 );
    assertEquals( stage3.getName(), "Merge" );
    assertNull( stage3.getSourceSelector() );
    assertNull( stage3.getConfig() );

    final StageConfig stage4 = stages.get( 3 );
    assertEquals( stage4.getName(), "Flatten" );
    assertNull( stage4.getSourceSelector() );
    assertNull( stage4.getConfig() );
  }

  @Test
  public void load_withPost()
    throws Exception
  {
    final Path directory = getWorkingDirectory();
    FileUtil.write( directory.resolve( "base.json" ),
                    "{\n" +
                    "  \"sourceSelector\": \"*\",\n" +
                    "  \"stages\": [\n" +
                    "    {\n" +
                    "      \"name\": \"RemoveIncludes\",\n" +
                    "      \"sourceSelector\": \"name=svg2\",\n" +
                    "      \"config\": {\n" +
                    "        \"interfacePattern\": \"^SVGAElement$\",\n" +
                    "        \"mixinPattern\": \"^SVGURIReference$\"\n" +
                    "      }\n" +
                    "    }\n" +
                    "  ]\n" +
                    "}" );
    FileUtil.write( directory.resolve( "base2.json" ),
                    "{\n" +
                    "  \"stages\": [\n" +
                    "    {\n" +
                    "      \"name\": \"ExtractExposureSet\",\n" +
                    "      \"config\": {\n" +
                    "        \"globalInterface\": \"Window\"\n" +
                    "      }\n" +
                    "    }\n" +
                    "  ]\n" +
                    "}" );
    FileUtil.write( directory.resolve( "base3.json" ),
                    "{\n" +
                    "  \"post\": [\"base2\"],\n" +
                    "  \"stages\": [\n" +
                    "    {\n" +
                    "      \"name\": \"Merge\"\n" +
                    "    }\n" +
                    "  ]\n" +
                    "}" );
    FileUtil.write( directory.resolve( "main.json" ),
                    "{\n" +
                    "  \"post\": [\"base\", \"base3\"],\n" +
                    "  \"stages\": [\n" +
                    "    {\n" +
                    "      \"name\": \"Flatten\"\n" +
                    "    }\n" +
                    "  ]\n" +
                    "}" );

    final PipelineConfig config = PipelineConfig.load( "main", directory );

    assertEquals( config.getName(), "main" );
    assertEquals( config.getSourceSelector(), "*" );
    final List<StageConfig> stages = config.getStages();
    assertEquals( stages.size(), 4 );

    final StageConfig stage1 = stages.get( 1 );
    assertEquals( stage1.getName(), "RemoveIncludes" );
    assertEquals( stage1.getSourceSelector(), "name=svg2" );
    final JsonObject config1 = stage1.getConfig();
    assertNotNull( config1 );
    assertEquals( config1.toString(),
                  "{\"interfacePattern\":\"^SVGAElement$\",\"mixinPattern\":\"^SVGURIReference$\"}" );

    final StageConfig stage2 = stages.get( 3 );
    assertEquals( stage2.getName(), "ExtractExposureSet" );
    assertNull( stage2.getSourceSelector() );
    final JsonObject config2 = stage2.getConfig();
    assertNotNull( config2 );
    assertEquals( config2.toString(), "{\"globalInterface\":\"Window\"}" );

    final StageConfig stage3 = stages.get( 2 );
    assertEquals( stage3.getName(), "Merge" );
    assertNull( stage3.getSourceSelector() );
    assertNull( stage3.getConfig() );

    final StageConfig stage4 = stages.get( 0 );
    assertEquals( stage4.getName(), "Flatten" );
    assertNull( stage4.getSourceSelector() );
    assertNull( stage4.getConfig() );
  }

  @Test
  public void load_stagesUnspecified()
    throws Exception
  {
    final Path directory = getWorkingDirectory();
    final Path file = directory.resolve( "main.json" );
    FileUtil.write( file, "{}" );

    assertThrows( IllegalPipelineConfigException.class,
                  "Invalid pipeline named 'main' specifies no stages",
                  () -> PipelineConfig.load( "main", directory ) );
  }

  @Test
  public void load_badStage()
    throws Exception
  {
    final Path directory = getWorkingDirectory();
    final Path file = directory.resolve( "main.json" );
    FileUtil.write( file, "{\"stages\":[{}]}" );

    assertThrows( IllegalPipelineConfigException.class,
                  "Invalid stage detected that specifies no name",
                  () -> PipelineConfig.load( "main", directory ) );
  }
}
