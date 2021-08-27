package org.realityforge.webtack.model.tools.util;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.Attributed;
import org.realityforge.webtack.model.Named;
import org.realityforge.webtack.model.OperationMember;

public final class JsUtil
{
  private JsUtil()
  {
  }

  @Nullable
  public static String toJsName( @Nonnull final OperationMember operation )
  {
    final String jsName = operation.getIdentValue( ExtendedAttributes.JS_NAME );
    return null == jsName ? operation.getName() : jsName;
  }

  @Nonnull
  public static <T extends Named & Attributed> String toJsName( @Nonnull final T element )
  {
    final String jsName = element.getIdentValue( ExtendedAttributes.JS_NAME );
    return null == jsName ? element.getName() : jsName;
  }
}
