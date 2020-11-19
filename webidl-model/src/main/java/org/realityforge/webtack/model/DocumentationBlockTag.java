package org.realityforge.webtack.model;

import java.util.Objects;
import javax.annotation.Nonnull;

public final class DocumentationBlockTag
{
  /**
   * The tag name.
   */
  @Nonnull
  private final String _name;
  /**
   * Documentation as a string.
   * In the future this will probably be broken up into spans and inline tags but
   * we are going with a simple approach for now.
   */
  @Nonnull
  private final String _documentation;

  public DocumentationBlockTag( @Nonnull final String name, @Nonnull final String documentation )
  {
    _name = Objects.requireNonNull( name );
    _documentation = Objects.requireNonNull( documentation );
  }

  @Nonnull
  public String getName()
  {
    return _name;
  }

  @Nonnull
  public String getDocumentation()
  {
    return _documentation;
  }

  public boolean isParamTag( @Nonnull final String argumentName )
  {
    return "param".equals( _name ) && _documentation.startsWith( argumentName + " " );
  }

  @Override
  public boolean equals( final Object o )
  {
    if ( this == o )
    {
      return true;
    }
    else if ( o == null || getClass() != o.getClass() )
    {
      return false;
    }
    else
    {
      final DocumentationBlockTag other = (DocumentationBlockTag) o;
      return _name.equals( other._name ) && Objects.equals( _documentation, other._documentation );
    }
  }

  @Override
  public int hashCode()
  {
    return Objects.hash( super.hashCode(), _name, _documentation );
  }

  public boolean equiv( @Nonnull final DocumentationBlockTag other )
  {
    return equals( other );
  }
}
