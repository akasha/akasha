package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

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
}
