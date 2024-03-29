package org.realityforge.webtack.model.tools.processors.extract_exposure_set;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.AttributeMember;
import org.realityforge.webtack.model.CallbackInterfaceDefinition;
import org.realityforge.webtack.model.ConstMember;
import org.realityforge.webtack.model.ExtendedAttribute;
import org.realityforge.webtack.model.InterfaceDefinition;
import org.realityforge.webtack.model.MixinDefinition;
import org.realityforge.webtack.model.NamespaceDefinition;
import org.realityforge.webtack.model.OperationMember;
import org.realityforge.webtack.model.PartialInterfaceDefinition;
import org.realityforge.webtack.model.PartialMixinDefinition;
import org.realityforge.webtack.model.PartialNamespaceDefinition;
import org.realityforge.webtack.model.tools.processors.AbstractProcessor;
import org.realityforge.webtack.model.tools.spi.PipelineContext;

/**
 * Transform schema extracting/retaining a particular exposure set.
 *
 * <p>The [Exposed] extended attribute may appear on an interface, partial interface,
 * interface mixin, partial interface mixin, callback interface, namespace, partial namespace,
 * or an individual interface member, interface mixin member, or namespace member. If present, the
 * extended attribute specifies that the construct is exposed on that particular set of global
 * interfaces. The extended attribute may either be an ident or identList form.</p>
 */
final class ExtractExposureSetProcessor
  extends AbstractProcessor
{
  @Nonnull
  private final String _globalInterface;

  ExtractExposureSetProcessor( @Nonnull final PipelineContext context, @Nonnull final String globalInterface )
  {
    super( context );
    _globalInterface = Objects.requireNonNull( globalInterface );
  }

  @Nullable
  @Override
  protected InterfaceDefinition transformInterface( @Nonnull final InterfaceDefinition input )
  {
    return isExposed( input.getExtendedAttributes() ) ? super.transformInterface( input ) : null;
  }

  @Nullable
  @Override
  protected MixinDefinition transformMixin( @Nonnull final MixinDefinition input )
  {
    return isExposed( input.getExtendedAttributes() ) ? super.transformMixin( input ) : null;
  }

  @Nullable
  @Override
  protected PartialMixinDefinition transformPartialMixin( @Nonnull final PartialMixinDefinition input )
  {
    return isExposed( input.getExtendedAttributes() ) ? super.transformPartialMixin( input ) : null;
  }

  @Nullable
  @Override
  protected CallbackInterfaceDefinition transformCallbackInterface( @Nonnull final CallbackInterfaceDefinition input )
  {
    return isExposed( input.getExtendedAttributes() ) ? super.transformCallbackInterface( input ) : null;
  }

  @Nullable
  @Override
  protected OperationMember transformOptionalOperationMember( @Nonnull final OperationMember input )
  {
    return isExposed( input.getExtendedAttributes() ) ? super.transformOptionalOperationMember( input ) : null;
  }

  @Nullable
  @Override
  protected ConstMember transformConstant( @Nonnull final ConstMember input )
  {
    return isExposed( input.getExtendedAttributes() ) ? super.transformConstant( input ) : null;
  }

  @Nullable
  @Override
  protected NamespaceDefinition transformNamespace( @Nonnull final NamespaceDefinition input )
  {
    return isExposed( input.getExtendedAttributes() ) ? super.transformNamespace( input ) : null;
  }

  @Nullable
  @Override
  protected PartialNamespaceDefinition transformPartialNamespace( @Nonnull final PartialNamespaceDefinition input )
  {
    return isExposed( input.getExtendedAttributes() ) ? super.transformPartialNamespace( input ) : null;
  }

  @Nullable
  @Override
  protected AttributeMember transformAttributeMember( @Nonnull final AttributeMember input )
  {
    return isExposed( input.getExtendedAttributes() ) ? super.transformAttributeMember( input ) : null;
  }

  @Nullable
  @Override
  protected PartialInterfaceDefinition transformPartialInterface( @Nonnull final PartialInterfaceDefinition input )
  {
    return isExposed( input.getExtendedAttributes() ) ? super.transformPartialInterface( input ) : null;
  }

  /**
   * Return true if the exposed flag is either not specified ot includes the configured global interface.
   * As we shortcut testing children on false, we do not need to look up to host interface to determine
   * whether a construct is exposed.
   *
   * @param extendedAttributes the extended attributes.
   * @return true if construct should be exposed on global interface.
   */
  private boolean isExposed( @Nonnull final List<ExtendedAttribute> extendedAttributes )
  {
    for ( final ExtendedAttribute a : extendedAttributes )
    {
      final ExtendedAttribute.Kind kind = a.getKind();
      if ( ExtendedAttribute.Kind.IDENT == kind && a.getName().equals( "Exposed" ) )
      {
        return a.getIdent().equals( _globalInterface );
      }
      else if ( ExtendedAttribute.Kind.WILDCARD == kind && a.getName().equals( "Exposed" ) )
      {
        return true;
      }
      else if ( ExtendedAttribute.Kind.IDENT_LIST == kind && a.getName().equals( "Exposed" ) )
      {
        return a.getIdentList().contains( _globalInterface );
      }
    }

    return true;
  }
}
