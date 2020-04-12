package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @see <a href="https://heycam.github.io/webidl/#idl-extended-attributes">Extended Attributes Spec</a>
 */
public final class ExtendedAttribute
  extends Node
{
  public enum Kind
  {
    NO_ARGS,
    // ARG_LIST has no specs that implement it
    ARG_LIST,
    NAMED_ARG_LIST,
    IDENT,
    IDENT_LIST
  }

  @Nullable
  private final String _name;
  @Nonnull
  private final Kind _kind;
  @Nullable
  private final String _ident;
  @Nullable
  private final List<String> _identList;
  /**
   * The name attached to the _argList. This is non-null iff argList is non-null.
   */
  @Nullable
  private final String _argListName;
  @Nullable
  private final List<Argument> _argList;

  @Nonnull
  public static ExtendedAttribute createExtendedAttributeNoArgs( @Nonnull final String name,
                                                                 @Nonnull final List<SourceInterval> sourceLocations )
  {
    return new ExtendedAttribute( Objects.requireNonNull( name ),
                                  Kind.NO_ARGS,
                                  null,
                                  null,
                                  null,
                                  null,
                                  sourceLocations );
  }

  @Nonnull
  public static ExtendedAttribute createExtendedAttributeIdent( @Nonnull final String name,
                                                                @Nonnull final String ident,
                                                                @Nonnull final List<SourceInterval> sourceLocations )
  {
    return new ExtendedAttribute( Objects.requireNonNull( name ),
                                  Kind.IDENT,
                                  Objects.requireNonNull( ident ),
                                  null,
                                  null,
                                  null,
                                  sourceLocations );
  }

  @Nonnull
  public static ExtendedAttribute createExtendedAttributeIdentList( @Nonnull final String name,
                                                                    @Nonnull final List<String> identList,
                                                                    @Nonnull final List<SourceInterval> sourceLocations )
  {
    return new ExtendedAttribute( Objects.requireNonNull( name ),
                                  Kind.IDENT_LIST,
                                  null,
                                  Objects.requireNonNull( identList ),
                                  null,
                                  null,
                                  sourceLocations );
  }

  @Nonnull
  public static ExtendedAttribute createExtendedAttributeNamedArgList( @Nonnull final String name,
                                                                       @Nonnull final String argListName,
                                                                       @Nonnull final List<Argument> argList,
                                                                       @Nonnull final List<SourceInterval> sourceLocations )
  {
    return new ExtendedAttribute( Objects.requireNonNull( name ),
                                  Kind.NAMED_ARG_LIST,
                                  null,
                                  null,
                                  Objects.requireNonNull( argListName ),
                                  Objects.requireNonNull( argList ),
                                  sourceLocations );
  }

  @Nonnull
  public static ExtendedAttribute createExtendedAttributeArgList( @Nonnull final String argListName,
                                                                  @Nonnull final List<Argument> argList,
                                                                  @Nonnull final List<SourceInterval> sourceLocations )
  {
    return new ExtendedAttribute( null,
                                  Kind.ARG_LIST,
                                  null,
                                  null,
                                  Objects.requireNonNull( argListName ),
                                  Objects.requireNonNull( argList ),
                                  sourceLocations );
  }

  private ExtendedAttribute( @Nullable final String name,
                             @Nonnull final Kind kind,
                             @Nullable final String ident,
                             @Nullable final List<String> identList,
                             @Nullable final String argListName,
                             @Nullable final List<Argument> argList,
                             @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( sourceLocations );
    _name = name;
    _kind = Objects.requireNonNull( kind );
    _ident = ident;
    _identList = identList;
    _argListName = argListName;
    _argList = argList;
  }

  @Nonnull
  public String getName()
  {
    verifyKind( "getName()", Kind.NO_ARGS, Kind.NAMED_ARG_LIST, Kind.IDENT, Kind.IDENT_LIST );
    assert null != _name;
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
    verifyKind( "getIdent()", Kind.IDENT );
    assert null != _ident;
    return _ident;
  }

  @Nonnull
  public List<String> getIdentList()
  {
    verifyKind( "getIdentList()", Kind.IDENT_LIST );
    assert null != _identList;
    return _identList;
  }

  @Nonnull
  public String getArgListName()
  {
    verifyKind( "getArgListName()", Kind.ARG_LIST, Kind.NAMED_ARG_LIST );
    assert null != _argListName;
    return _argListName;
  }

  @Nonnull
  public List<Argument> getArgList()
  {
    verifyKind( "getArgList()", Kind.ARG_LIST, Kind.NAMED_ARG_LIST );
    assert null != _argList;
    return _argList;
  }

  private void verifyKind( @Nonnull final String methodName, @Nonnull final Kind... kinds )
  {
    for ( final Kind kind : kinds )
    {
      if ( kind == _kind )
      {
        return;
      }
    }
    if ( null != _name )
    {
      throw new IllegalStateException( "Invoked " + methodName + " on extended attribute named '" + _name +
                                       "' but attribute is of kind " + _kind );
    }
    else
    {
      throw new IllegalStateException( "Invoked " + methodName + " on unnamed extended attribute attribute " +
                                       "is of kind " + _kind );
    }
  }
}
