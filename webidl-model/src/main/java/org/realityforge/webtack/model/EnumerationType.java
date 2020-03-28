package org.realityforge.webtack.model;

import javax.annotation.Nonnull;

public final class EnumerationType
  extends Type
{
  EnumerationType( @Nonnull final String enumerationName, final int flags )
  {
    super( enumerationName, Flags.ENUMERATION | flags );
  }
}
