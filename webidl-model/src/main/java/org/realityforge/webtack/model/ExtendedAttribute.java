package org.realityforge.webtack.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.realityforge.webtack.webidl.parser.WebIDLParser;

/**
 * @see <a href="https://heycam.github.io/webidl/#idl-extended-attributes">Extended Attributes Spec</a>
 */
public final class ExtendedAttribute
{
  public enum Kind
  {
    NO_ARGS,
    // ARG_LIST has no specs that implement it
    //ARG_LIST,
    NAMED_ARG_LIST,
    IDENT,
    IDENT_LIST
  }

  @Nonnull
  private final String _name;
  @Nonnull
  private final Kind _kind;
  @Nullable
  private final String _ident;
  @Nullable
  private final List<String> _identList;

  @Nonnull
  public static ExtendedAttribute createExtendedAttributeNoArgs( @Nonnull final String name )
  {
    return new ExtendedAttribute( name );
  }

  @Nonnull
  public static ExtendedAttribute createExtendedAttributeIdent( @Nonnull final String name,
                                                                @Nonnull final String ident )
  {
    return new ExtendedAttribute( name, ident );
  }

  @Nonnull
  public static ExtendedAttribute createExtendedAttributeIdentList( @Nonnull final String name,
                                                                    @Nonnull final List<String> identList )
  {
    return new ExtendedAttribute( name, identList );
  }

  private ExtendedAttribute( @Nonnull final String name )
  {
    _name = Objects.requireNonNull( name );
    _kind = Kind.NO_ARGS;
    _ident = null;
    _identList = null;
  }

  private ExtendedAttribute( @Nonnull final String name, @Nonnull final String ident )
  {
    _name = Objects.requireNonNull( name );
    _kind = Kind.IDENT;
    _ident = Objects.requireNonNull( ident );
    _identList = null;
  }

  private ExtendedAttribute( @Nonnull final String name, @Nonnull final List<String> identList )
  {
    _name = Objects.requireNonNull( name );
    _kind = Kind.IDENT_LIST;
    _ident = null;
    _identList = Objects.requireNonNull( identList );
  }

  @Nonnull
  public String getName()
  {
    return _name;
  }

  @Nonnull
  public Kind getKind()
  {
    return _kind;
  }

  @Nonnull
  public String getIdent()
  {
    if ( Kind.IDENT != _kind )
    {
      throw new IllegalStateException( "Invoked getIdent() on extended attribute named '" + _name +
                                       "' but attribute is of kind " + _kind );
    }
    assert null != _ident;
    return _ident;
  }

  @Nonnull
  public List<String> getIdentList()
  {
    if ( Kind.IDENT_LIST != _kind )
    {
      throw new IllegalStateException( "Invoked getIdentList() on extended attribute named '" + _name +
                                       "' but attribute is of kind " + _kind );
    }
    assert null != _identList;
    return _identList;
  }

  @Nonnull
  public static ExtendedAttribute parse( @Nonnull final WebIDLParser.ExtendedAttributeContext ctx )
  {
    final WebIDLParser.ExtendedAttributeNoArgsContext noArgsContext = ctx.extendedAttributeNoArgs();
    if ( null != noArgsContext )
    {
      return ExtendedAttribute.createExtendedAttributeNoArgs( noArgsContext.IDENTIFIER().getText() );
    }
    final WebIDLParser.ExtendedAttributeIdentContext identContext = ctx.extendedAttributeIdent();
    if ( null != identContext )
    {
      return ExtendedAttribute.createExtendedAttributeIdent( identContext.IDENTIFIER( 0 ).getText(),
                                                             identContext.IDENTIFIER( 1 ).getText() );
    }
    final WebIDLParser.ExtendedAttributeIdentListContext identListContext = ctx.extendedAttributeIdentList();
    if ( null != identListContext )
    {
      final List<String> identifiers = new ArrayList<>();
      collectIdentifiers( identifiers, identListContext.identifierList() );
      return ExtendedAttribute.createExtendedAttributeIdentList( identListContext.IDENTIFIER().getText(),
                                                                 Collections.unmodifiableList( identifiers ) );
    }
    throw new IllegalModelException( "ExtendedAttribute does not yet model extendedAttributeArgList " +
                                     "or extendedAttributeNamedArgList" );
  }

  private static void collectIdentifiers( @Nonnull final List<String> identifiers,
                                          @Nonnull final WebIDLParser.IdentifierListContext identifierListContext )
  {
    identifiers.add( identifierListContext.IDENTIFIER().getText() );
    collectIdentifiers( identifiers, identifierListContext.identifiers() );
  }

  private static void collectIdentifiers( @Nonnull final List<String> identifiers,
                                          @Nonnull final WebIDLParser.IdentifiersContext identifiersContext )
  {
    final TerminalNode identifier = identifiersContext.IDENTIFIER();
    if ( null != identifier )
    {
      identifiers.add( identifier.getText() );
      collectIdentifiers( identifiers, identifiersContext.identifiers() );
    }
  }
}
