package org.realityforge.webtack.model;

import javax.annotation.Nonnull;

public final class EnumerationType
  extends Type
{
  EnumerationType( @Nonnull final String enumerationName, final boolean nullable )
  {
    super( enumerationName, nullable );
  }
}
