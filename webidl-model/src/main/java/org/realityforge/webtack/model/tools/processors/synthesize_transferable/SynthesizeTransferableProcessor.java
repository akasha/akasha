package org.realityforge.webtack.model.tools.processors.synthesize_transferable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.DocumentationBlockTag;
import org.realityforge.webtack.model.DocumentationElement;
import org.realityforge.webtack.model.ExtendedAttribute;
import org.realityforge.webtack.model.InterfaceDefinition;
import org.realityforge.webtack.model.Type;
import org.realityforge.webtack.model.TypeReference;
import org.realityforge.webtack.model.TypedefDefinition;
import org.realityforge.webtack.model.UnionType;
import org.realityforge.webtack.model.tools.processors.AbstractProcessor;
import org.realityforge.webtack.model.tools.spi.Completable;
import org.realityforge.webtack.model.tools.spi.PipelineContext;
import org.realityforge.webtack.model.tools.util.ExtendedAttributes;

final class SynthesizeTransferableProcessor
  extends AbstractProcessor
  implements Completable
{
  @Nonnull
  private final PipelineContext _context;
  private final int _expectedTransferableCount;
  @Nonnull
  private final List<InterfaceDefinition> _transferables = new ArrayList<>();

  SynthesizeTransferableProcessor( @Nonnull final PipelineContext context,
                                   final int expectedTransferableCount )
  {
    _context = Objects.requireNonNull( context );
    _expectedTransferableCount = expectedTransferableCount;
  }

  @Override
  public void onComplete()
  {
    final int transferableCount = _transferables.size();
    if ( _expectedTransferableCount > 0 )
    {
      if ( transferableCount != _expectedTransferableCount )
      {
        _context.error( "Detected " + transferableCount + " [Transferable] interfaces but expected " +
                        _expectedTransferableCount + " interfaces." );
      }
    }
    else
    {
      if ( 0 == transferableCount )
      {
        _context.info( "Collected " + transferableCount + " [Transferable] interfaces." );
      }
      else
      {
        _context.debug( "Collected " + transferableCount + " [Transferable] interfaces." );
      }
    }
  }

  @Nullable
  @Override
  protected InterfaceDefinition transformInterface( @Nonnull final InterfaceDefinition input )
  {
    final InterfaceDefinition definition = super.transformInterface( input );
    if ( null != definition && definition.isNoArgsExtendedAttributePresent( ExtendedAttributes.TRANSFERABLE ) )
    {
      _transferables.add( definition );
    }
    return definition;
  }

  @Nonnull
  @Override
  protected Map<String, TypedefDefinition> transformTypedefs( @Nonnull final Collection<TypedefDefinition> inputs )
  {
    final Map<String, TypedefDefinition> typedefs = super.transformTypedefs( inputs );
    if ( !_transferables.isEmpty() )
    {
      final List<Type> memberTypes = new ArrayList<>();
      for ( final InterfaceDefinition transferable : _transferables )
      {
        memberTypes.add( new TypeReference( transferable.getName(),
                                            Collections.emptyList(),
                                            false,
                                            Collections.emptyList() ) );
      }
      final UnionType type = new UnionType( memberTypes, Collections.emptyList(), false, Collections.emptyList() );
      final DocumentationBlockTag seeTag =
        new DocumentationBlockTag( "see",
                                   "<a href=\"https://html.spec.whatwg.org/multipage/structured-data.html#transferable-objects\">Transferable - HTML Specification</a>" );
      final DocumentationElement documentation =
        new DocumentationElement( "The Transferable type can be be transferred between contexts.",
                                  Collections.singletonList( seeTag ),
                                  Collections.emptyList(),
                                  true );
      final ExtendedAttribute markerType =
        ExtendedAttribute.createExtendedAttributeNoArgs( "MarkerType", Collections.emptyList() );
      final TypedefDefinition definition =
        new TypedefDefinition( "Transferable",
                               type,
                               documentation,
                               Collections.singletonList( markerType ),
                               Collections.emptyList() );
      typedefs.put( definition.getName(), definition );
    }
    return typedefs;
  }
}
