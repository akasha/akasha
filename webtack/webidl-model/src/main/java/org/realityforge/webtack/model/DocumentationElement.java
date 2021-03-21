package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class DocumentationElement
  extends Node
{
  /**
   * Documentation as a string.
   * In the future this will probably be broken up into spans and inline tags but
   * we are going with a simple approach for now.
   */
  @Nullable
  private final String _documentation;
  @Nonnull
  private final List<DocumentationBlockTag> _blockTags;
  private final boolean _synthetic;

  public DocumentationElement( @Nullable final String documentation,
                               @Nonnull final List<DocumentationBlockTag> blockTags,
                               @Nonnull final List<SourceInterval> sourceLocations,
                               final boolean synthetic )
  {
    super( sourceLocations );
    _documentation = documentation;
    _blockTags = Objects.requireNonNull( blockTags );
    _synthetic = synthetic;
  }

  public boolean isSynthetic()
  {
    return _synthetic;
  }

  @Nullable
  public String getDocumentation()
  {
    return _documentation;
  }

  @Nonnull
  public List<DocumentationBlockTag> getBlockTags()
  {
    return _blockTags;
  }

  public boolean hasDeprecatedTag()
  {
    return getBlockTags().stream().anyMatch( t -> t.getName().equals( "deprecated" ) );
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
      final DocumentationElement other = (DocumentationElement) o;
      return Objects.equals( _documentation, other._documentation ) &&
             Objects.equals( _blockTags, other._blockTags );
    }
  }

  @Override
  public int hashCode()
  {
    return Objects.hash( super.hashCode(), _documentation, _blockTags );
  }

  public boolean equiv( @Nonnull final DocumentationElement other )
  {
    return equals( other );
  }
}
