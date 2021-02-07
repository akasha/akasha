package org.realityforge.webtack.model.tools.mdn_scanner.config2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.DocumentationBlockTag;
import org.realityforge.webtack.model.DocumentationElement;
import org.realityforge.webtack.model.tools.mdn_scanner.DocEntry;
import org.realityforge.webtack.model.tools.mdn_scanner.DocKind;
import org.realityforge.webtack.model.tools.mdn_scanner.ExternalRef;

public final class DocEntryUtil
{
  private DocEntryUtil()
  {
  }

  @Nonnull
  public static DocumentationElement createDocumentationElement( @Nonnull final DocEntry docEntry )
  {
    final List<DocumentationBlockTag> blockTags = new ArrayList<>();
    blockTags.add( seeTag( docEntry ) );
    final ExternalRef[] refs = docEntry.getRefs();
    if ( null != refs )
    {
      for ( final ExternalRef ref : refs )
      {
        final String description = ref.getDescription();
        blockTags.add( seeTag( null == description ? ref.getName() : description, ref.getHref() ) );
      }
    }
    return new DocumentationElement( docEntry.getDescription(),
                                     blockTags,
                                     Collections.emptyList(),
                                     true );
  }

  @Nonnull
  private static DocumentationBlockTag seeTag( @Nonnull final DocEntry docEntry )
  {
    final String label = docEntry.getKind() == DocKind.Event ? docEntry.getEventName() + " event" : docEntry.getName();
    return seeTag( label + " - MDN", docEntry.getHref() );
  }

  @Nonnull
  private static DocumentationBlockTag seeTag( @Nonnull final String label, @Nonnull final String href )
  {
    return new DocumentationBlockTag( "see", "<a href=\"" + href + "\">" + label + "</a>" );
  }
}
