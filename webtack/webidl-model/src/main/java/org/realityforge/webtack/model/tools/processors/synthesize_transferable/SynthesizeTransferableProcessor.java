package org.realityforge.webtack.model.tools.processors.synthesize_transferable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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
  private final int _expectedTransferableCount;
  @Nonnull
  private final List<InterfaceDefinition> _transferables = new ArrayList<>();

  SynthesizeTransferableProcessor( @Nonnull final PipelineContext context, final int expectedTransferableCount )
  {
    super( context );
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
        context().error( "Detected " + transferableCount + " [Transferable] interfaces but expected " +
                         _expectedTransferableCount + " interfaces." );
      }
    }
    else
    {
      if ( 0 == transferableCount )
      {
        context().info( "Collected " + transferableCount + " [Transferable] interfaces." );
      }
      else
      {
        context().debug( "Collected " + transferableCount + " [Transferable] interfaces." );
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
      final List<Type> memberTypes =
        _transferables
          .stream()
          .map( InterfaceDefinition::getName )
          .sorted()
          .map( name -> new TypeReference( name, Collections.emptyList(), false, Collections.emptyList() ) )
          .collect( Collectors.toList() );
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
        ExtendedAttribute.createNoArgs( ExtendedAttributes.MARKER_TYPE );
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
