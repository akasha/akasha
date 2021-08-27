package org.realityforge.webtack.model;

import java.io.IOException;
import java.io.StringReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.webidl.parser.WebIDLParser;
import org.realityforge.webtack.webidl.parser.WebIDLParserTool;

/**
 * @see <a href="https://heycam.github.io/webidl/#idl-extended-attributes">Extended Attributes Spec</a>
 */
public final class ExtendedAttribute
  extends Node
{
  public enum Kind
  {
    NO_ARGS,
    // ARG_LIST has no specs other implement it
    ARG_LIST,
    NAMED_ARG_LIST,
    NAMED_STRING,
    IDENT,
    IDENT_LIST,
    NAMED_IDENT_LIST
  }

  @Nullable
  private final String _name;
  @Nonnull
  private final Kind _kind;
  @Nullable
  private final String _value;
  @Nullable
  private final String _ident;
  @Nullable
  private final String _identListName;
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
  public static ExtendedAttribute parse( @Nonnull final String extendedAttribute )
    throws IOException
  {
    final WebIDLParser parser = WebIDLParserTool.createParser( "", new StringReader( extendedAttribute ) );
    parser.setBuildParseTree( true );
    return WebIDLModelParser.parse( parser.extendedAttribute() );
  }

  @Nonnull
  public static ExtendedAttribute createNoArgs( @Nonnull final String name )
  {
    return createNoArgs( name, Collections.emptyList() );
  }

  @Nonnull
  public static ExtendedAttribute createNoArgs( @Nonnull final String name,
                                                @Nonnull final List<SourceInterval> sourceLocations )
  {
    return new ExtendedAttribute( Objects.requireNonNull( name ),
                                  Kind.NO_ARGS,
                                  null,
                                  null,
                                  null,
                                  null,
                                  null,
                                  null,
                                  sourceLocations );
  }

  @Nonnull
  public static ExtendedAttribute createIdent( @Nonnull final String name, @Nonnull final String ident )
  {
    return createIdent( name, ident, Collections.emptyList() );
  }

  @Nonnull
  public static ExtendedAttribute createIdent( @Nonnull final String name,
                                               @Nonnull final String ident,
                                               @Nonnull final List<SourceInterval> sourceLocations )
  {
    return new ExtendedAttribute( Objects.requireNonNull( name ),
                                  Kind.IDENT,
                                  null,
                                  Objects.requireNonNull( ident ),
                                  null,
                                  null,
                                  null,
                                  null,
                                  sourceLocations );
  }

  @Nonnull
  public static ExtendedAttribute createNamedString( @Nonnull final String name, @Nonnull final String ident )
  {
    return createNamedString( name, ident, Collections.emptyList() );
  }

  @Nonnull
  public static ExtendedAttribute createNamedString( @Nonnull final String name,
                                                     @Nonnull final String ident,
                                                     @Nonnull final List<SourceInterval> sourceLocations )
  {
    return new ExtendedAttribute( Objects.requireNonNull( name ),
                                  Kind.NAMED_STRING,
                                  Objects.requireNonNull( ident ),
                                  null,
                                  null,
                                  null,
                                  null,
                                  null,
                                  sourceLocations );
  }

  @Nonnull
  public static ExtendedAttribute createIdentList( @Nonnull final String name,
                                                   @Nonnull final List<String> identList )
  {
    return createIdentList( name, identList, Collections.emptyList() );
  }

  @Nonnull
  public static ExtendedAttribute createIdentList( @Nonnull final String name,
                                                   @Nonnull final List<String> identList,
                                                   @Nonnull final List<SourceInterval> sourceLocations )
  {
    return new ExtendedAttribute( Objects.requireNonNull( name ),
                                  Kind.IDENT_LIST,
                                  null,
                                  null,
                                  null,
                                  Objects.requireNonNull( identList ),
                                  null,
                                  null,
                                  sourceLocations );
  }

  @Nonnull
  public static ExtendedAttribute createNamedIdentList( @Nonnull final String name,
                                                        @Nonnull final String identListName,
                                                        @Nonnull final List<String> identList )
  {
    return createNamedIdentList( name, identListName, identList, Collections.emptyList() );
  }

  @Nonnull
  public static ExtendedAttribute createNamedIdentList( @Nonnull final String name,
                                                        @Nonnull final String identListName,
                                                        @Nonnull final List<String> identList,
                                                        @Nonnull final List<SourceInterval> sourceLocations )
  {
    return new ExtendedAttribute( Objects.requireNonNull( name ),
                                  Kind.NAMED_IDENT_LIST,
                                  null,
                                  null,
                                  Objects.requireNonNull( identListName ),
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
                                  null,
                                  null,
                                  Objects.requireNonNull( argListName ),
                                  Objects.requireNonNull( argList ),
                                  sourceLocations );
  }

  private ExtendedAttribute( @Nullable final String name,
                             @Nonnull final Kind kind,
                             @Nullable final String value,
                             @Nullable final String ident,
                             @Nullable final String identListName,
                             @Nullable final List<String> identList,
                             @Nullable final String argListName,
                             @Nullable final List<Argument> argList,
                             @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( sourceLocations );
    _name = name;
    _kind = Objects.requireNonNull( kind );
    _value = value;
    _ident = ident;
    _identListName = identListName;
    _identList = identList;
    _argListName = argListName;
    _argList = argList;
  }

  @Nonnull
  public String getName()
  {
    verifyKind( "getName()",
                Kind.NO_ARGS,
                Kind.NAMED_ARG_LIST,
                Kind.IDENT,
                Kind.IDENT_LIST,
                Kind.NAMED_IDENT_LIST,
                Kind.NAMED_STRING );
    assert null != _name;
    return _name;
  }

  @Nonnull
  public Kind getKind()
  {
    return _kind;
  }

  @Nonnull
  public String getValue()
  {
    verifyKind( "getValue()", Kind.NAMED_STRING );
    assert null != _value;
    return _value;
  }

  @Nonnull
  public String getIdent()
  {
    verifyKind( "getIdent()", Kind.IDENT );
    assert null != _ident;
    return _ident;
  }

  @Nonnull
  public String getIdentListName()
  {
    verifyKind( "getIdentListName()", Kind.NAMED_IDENT_LIST );
    assert null != _identListName;
    return _identListName;
  }

  @Nonnull
  public List<String> getIdentList()
  {
    verifyKind( "getIdentList()", Kind.IDENT_LIST, Kind.NAMED_IDENT_LIST );
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
      final ExtendedAttribute other = (ExtendedAttribute) o;
      return Objects.equals( _name, other._name ) &&
             _kind == other._kind &&
             Objects.equals( _value, other._value ) &&
             Objects.equals( _ident, other._ident ) &&
             Objects.equals( _identListName, other._identListName ) &&
             Objects.equals( _identList, other._identList ) &&
             Objects.equals( _argListName, other._argListName ) &&
             Objects.equals( _argList, other._argList );
    }
  }

  @Override
  public int hashCode()
  {
    return Objects.hash( _name, _kind, _ident, _identList, _argListName, _argList );
  }

  public boolean equiv( @Nonnull final ExtendedAttribute other )
  {
    if ( Objects.equals( _name, other._name ) &&
         _kind == other._kind &&
         Objects.equals( _value, other._value ) &&
         Objects.equals( _ident, other._ident ) &&
         Objects.equals( _identListName, other._identListName ) &&
         (
           ( null == _identList && null == other._identList ) ||
           ( null != _identList && null != other._identList && _identList.size() == other._identList.size() )
         ) &&
         Objects.equals( _argListName, other._argListName ) &&
         (
           ( null == _argList && null == other._argList ) ||
           ( null != _argList && null != other._argList && _argList.size() == other._argList.size() )
         ) )
    {
      if ( null != _identList )
      {
        final Set<String> otherValues = new HashSet<>( other._identList );
        for ( final String value : _identList )
        {
          if ( !otherValues.remove( value ) )
          {
            return false;
          }
        }
      }
      if ( null != _argList )
      {
        final Set<Argument> otherArguments = new HashSet<>( other._argList );
        for ( final Argument argument : _argList )
        {
          if ( !otherArguments.removeIf( argument::equiv ) )
          {
            return false;
          }
        }
      }
      return true;
    }
    else
    {
      return false;
    }
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
      throw new IllegalStateException( "Invoked " + methodName + " on unnamed extended attribute but attribute " +
                                       "is of kind " + _kind );
    }
  }
}
