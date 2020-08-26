package org.realityforge.webtack.model.tools.util;

import javax.annotation.Nullable;

public final class GeneratedAnnotationUtil
{
  private GeneratedAnnotationUtil()
  {
  }

  @Nullable
  public static Class<?> getGeneratedAnnotation()
  {
    try
    {
      return Class.forName( "javax.annotation.processing.Generated" );
    }
    catch ( final ClassNotFoundException ignored )
    {
      try
      {
        return Class.forName( "javax.annotation.Generated" );
      }
      catch ( final ClassNotFoundException ignored2 )
      {
        //Generate no annotation
        return null;
      }
    }
  }
}
