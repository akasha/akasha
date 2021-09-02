package org.realityforge.webtack.model.tools.processors.name_anonymous_unions;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.AttributeMember;
import org.realityforge.webtack.model.CallbackDefinition;
import org.realityforge.webtack.model.CallbackInterfaceDefinition;
import org.realityforge.webtack.model.ConstEnumerationDefinition;
import org.realityforge.webtack.model.DictionaryDefinition;
import org.realityforge.webtack.model.DictionaryMember;
import org.realityforge.webtack.model.EnumerationDefinition;
import org.realityforge.webtack.model.ExtendedAttribute;
import org.realityforge.webtack.model.IllegalModelException;
import org.realityforge.webtack.model.IncludesStatement;
import org.realityforge.webtack.model.InterfaceDefinition;
import org.realityforge.webtack.model.Kind;
import org.realityforge.webtack.model.MixinDefinition;
import org.realityforge.webtack.model.NamespaceDefinition;
import org.realityforge.webtack.model.OperationMember;
import org.realityforge.webtack.model.PartialDictionaryDefinition;
import org.realityforge.webtack.model.PartialInterfaceDefinition;
import org.realityforge.webtack.model.PartialMixinDefinition;
import org.realityforge.webtack.model.PartialNamespaceDefinition;
import org.realityforge.webtack.model.Type;
import org.realityforge.webtack.model.TypeReference;
import org.realityforge.webtack.model.TypedefDefinition;
import org.realityforge.webtack.model.UnionType;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.tools.processors.AbstractProcessor;
import org.realityforge.webtack.model.tools.spi.Completable;
import org.realityforge.webtack.model.tools.spi.PipelineContext;
import org.realityforge.webtack.model.tools.util.ExtendedAttributes;
import org.realityforge.webtack.model.tools.util.UnionUtil;

final class NameAnonymousUnionsProcessor
  extends AbstractProcessor
  implements Completable
{
  @Nonnull
  private final Map<String, UnionType> _unions = new HashMap<>();
  public final int _expectedChangeCount;

  NameAnonymousUnionsProcessor( @Nonnull final PipelineContext context, final int expectedChangeCount )
  {
    super( context );
    _expectedChangeCount = expectedChangeCount;
  }

  @Nullable
  @Override
  public WebIDLSchema process( @Nonnull final WebIDLSchema schema )
  {
    _unions.clear();
    return super.process( schema );
  }

  @Override
  public void onComplete()
  {
    final int unionCount = _unions.size();
    if ( _expectedChangeCount > 0 )
    {
      if ( unionCount != _expectedChangeCount )
      {
        context().error( "Named " + unionCount + " unions but expected to " +
                         "name " + _expectedChangeCount + " unions." );
      }
    }
    else
    {
      if ( 0 == unionCount )
      {
        context().error( "Named " + unionCount + " unions. Remove processor." );
      }
      else
      {
        context().debug( "Named " + unionCount + " unions." );
      }
    }
  }

  @Nonnull
  @Override
  protected DictionaryMember transformDictionaryMember( @Nonnull final DictionaryMember input )
  {
    final Type type = input.getType();
    if ( Kind.Union == type.getKind() )
    {
      return new DictionaryMember( input.getName(),
                                   toTypeReference( (UnionType) type ),
                                   input.isOptional(),
                                   input.getDefaultValue(),
                                   input.getDocumentation(),
                                   input.getExtendedAttributes(),
                                   input.getSourceLocations() );
    }
    else
    {
      return input;
    }
  }

  @Nonnull
  @Override
  protected AttributeMember transformAttributeMember( @Nonnull final AttributeMember input )
  {
    final Type type = input.getType();
    if ( Kind.Union == type.getKind() )
    {
      return new AttributeMember( input.getName(),
                                  toTypeReference( (UnionType) type ),
                                  input.getModifiers(),
                                  input.getDocumentation(),
                                  input.getExtendedAttributes(),
                                  input.getSourceLocations() );
    }
    else
    {
      return input;
    }
  }

  @Nonnull
  @Override
  protected OperationMember transformOperationMember( @Nonnull final OperationMember input )
  {
    final Type type = input.getReturnType();
    if ( Kind.Union == type.getKind() )
    {
      return new OperationMember( input.getKind(),
                                  input.getName(),
                                  input.getArguments(),
                                  toTypeReference( (UnionType) type ),
                                  input.getDocumentation(),
                                  input.getExtendedAttributes(),
                                  input.getSourceLocations() );
    }
    else
    {
      return input;
    }
  }

  @Nonnull
  private TypeReference toTypeReference( @Nonnull final UnionType unionType )
  {
    return new TypeReference( registerUnionTypeName( unionType ),
                              Collections.emptyList(),
                              false,
                              Collections.emptyList() );
  }

  @Nonnull
  private String registerUnionTypeName( @Nonnull final UnionType type )
  {
    final String name = UnionUtil.deriveTypeDefNameForUnionType( type );
    if ( !_unions.containsKey( name ) )
    {
      _unions.put( name, type );
    }
    return name;
  }

  @Nonnull
  @Override
  protected WebIDLSchema createSchema( @Nonnull final WebIDLSchema schema,
                                       @Nonnull final Map<String, CallbackDefinition> callbacks,
                                       @Nonnull final Map<String, CallbackInterfaceDefinition> callbackInterfaces,
                                       @Nonnull final Map<String, EnumerationDefinition> enumerations,
                                       @Nonnull final Map<String, ConstEnumerationDefinition> constEnumerations,
                                       @Nonnull final Map<String, DictionaryDefinition> dictionaries,
                                       @Nonnull final Map<String, List<PartialDictionaryDefinition>> partialDictionaries,
                                       @Nonnull final Map<String, NamespaceDefinition> namespaces,
                                       @Nonnull final Map<String, List<PartialNamespaceDefinition>> partialNamespaces,
                                       @Nonnull final Map<String, MixinDefinition> mixins,
                                       @Nonnull final Map<String, List<PartialMixinDefinition>> partialMixins,
                                       @Nonnull final Map<String, InterfaceDefinition> interfaces,
                                       @Nonnull final Map<String, List<PartialInterfaceDefinition>> partialInterfaces,
                                       @Nonnull final List<IncludesStatement> includes,
                                       @Nonnull final Map<String, TypedefDefinition> typedefs )
  {
    for ( final Map.Entry<String, UnionType> entry : _unions.entrySet() )
    {
      final String name = entry.getKey();
      if ( typedefs.containsKey( name ) )
      {
        throw new IllegalModelException( "Attempted to create union named " + name +
                                         " that has already been explicitly declared" );
      }
      final UnionType unionType = entry.getValue();
      final TypedefDefinition typedef =
        new TypedefDefinition( name,
                               unionType,
                               null,
                               Collections.singletonList( ExtendedAttribute.createNoArgs( ExtendedAttributes.SYNTHETIC ) ),
                               Collections.emptyList() );
      typedefs.put( name, typedef );
    }
    return super.createSchema( schema,
                               callbacks,
                               callbackInterfaces,
                               enumerations,
                               constEnumerations,
                               dictionaries,
                               partialDictionaries,
                               namespaces,
                               partialNamespaces,
                               mixins,
                               partialMixins,
                               interfaces,
                               partialInterfaces,
                               includes,
                               typedefs );
  }
}
