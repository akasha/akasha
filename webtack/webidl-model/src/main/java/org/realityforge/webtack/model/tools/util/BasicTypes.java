package org.realityforge.webtack.model.tools.util;

import com.squareup.javapoet.ClassName;
import javax.annotation.Nonnull;

public final class BasicTypes
{
  @Nonnull
  public static final ClassName STRING = ClassName.get( String.class );
  @Nonnull
  public static final ClassName BOXED_DOUBLE = ClassName.get( Double.class );
  @Nonnull
  public static final ClassName NONNULL = ClassName.get( "javax.annotation", "Nonnull" );
  @Nonnull
  public static final ClassName NULLABLE = ClassName.get( "javax.annotation", "Nullable" );
  @Nonnull
  public static final ClassName MAGIC_CONSTANT = ClassName.get( "org.intellij.lang.annotations", "MagicConstant" );
  @Nonnull
  public static final ClassName INTERNAL_API = ClassName.bestGuess( "org.jetbrains.annotations.ApiStatus.Internal" );

  private BasicTypes()
  {
  }
}
