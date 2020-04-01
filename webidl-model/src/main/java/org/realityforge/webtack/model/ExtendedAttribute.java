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
  public static ExtendedAttribute createExtendedAttributeNoArgs( @Nonnull final String name )
  {
    return new ExtendedAttribute( Objects.requireNonNull( name ),
                                  Kind.NO_ARGS,
                                  null,
                                  null,
                                  null,
                                  null );
  }

  @Nonnull
  public static ExtendedAttribute createExtendedAttributeIdent( @Nonnull final String name,
                                                                @Nonnull final String ident )
  {
    return new ExtendedAttribute( Objects.requireNonNull( name ),
                                  Kind.IDENT,
                                  Objects.requireNonNull( ident ),
                                  null,
                                  null,
                                  null );
  }

  @Nonnull
  public static ExtendedAttribute createExtendedAttributeIdentList( @Nonnull final String name,
                                                                    @Nonnull final List<String> identList )
  {
    return new ExtendedAttribute( Objects.requireNonNull( name ),
                                  Kind.IDENT_LIST,
                                  null,
                                  Objects.requireNonNull( identList ),
                                  null,
                                  null );
  }

  @Nonnull
  public static ExtendedAttribute createExtendedAttributeNamedArgList( @Nonnull final String name,
                                                                       @Nonnull final String argListName,
                                                                       @Nonnull final List<Argument> argList )
  {
    return new ExtendedAttribute( Objects.requireNonNull( name ),
                                  Kind.NAMED_ARG_LIST,
                                  null,
                                  null,
                                  Objects.requireNonNull( argListName ),
                                  Objects.requireNonNull( argList ) );
  }

  @Nonnull
  public static ExtendedAttribute createExtendedAttributeArgList( @Nonnull final String argListName,
                                                                  @Nonnull final List<Argument> argList )
  {
    return new ExtendedAttribute( null,
                                  Kind.ARG_LIST,
                                  null,
                                  null,
                                  Objects.requireNonNull( argListName ),
                                  Objects.requireNonNull( argList ) );
  }

  private ExtendedAttribute( @Nullable final String name,
                             @Nonnull final Kind kind,
                             @Nullable final String ident,
                             @Nullable final List<String> identList,
                             @Nullable final String argListName,
                             @Nullable final List<Argument> argList )
  {
    _name = name;
    _kind = kind;
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

  @Nonnull
  public static List<ExtendedAttribute> parse( @Nonnull final WebIDLParser.ExtendedAttributeListContext ctx )
  {
    final WebIDLParser.ExtendedAttributeContext extendedAttributeContext = ctx.extendedAttribute();
    if ( null == extendedAttributeContext )
    {
      return Collections.emptyList();
    }
    else
    {
      final List<ExtendedAttribute> attributes = new ArrayList<>();
      attributes.add( parse( extendedAttributeContext ) );
      collectAttributes( attributes, ctx.extendedAttributes() );
      return Collections.unmodifiableList( attributes );
    }
  }

  private static void collectAttributes( @Nonnull final List<ExtendedAttribute> attributes,
                                         @Nonnull final WebIDLParser.ExtendedAttributesContext extendedAttributesContext )
  {
    final WebIDLParser.ExtendedAttributeContext attr = extendedAttributesContext.extendedAttribute();
    if ( null != attr )
    {
      attributes.add( parse( attr ) );
      collectAttributes( attributes, extendedAttributesContext.extendedAttributes() );
    }
  }

  @Nonnull
  static ExtendedAttribute parse( @Nonnull final WebIDLParser.ExtendedAttributeContext ctx )
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
    final WebIDLParser.ExtendedAttributeArgListContext argListContext = ctx.extendedAttributeArgList();
    if ( null != argListContext )
    {
      final String argName = argListContext.IDENTIFIER().getText();
      final List<Argument> arguments = Argument.parse( argListContext.argumentList() );
      return ExtendedAttribute.createExtendedAttributeArgList( argName, arguments );
    }
    final WebIDLParser.ExtendedAttributeNamedArgListContext namedArgListContext = ctx.extendedAttributeNamedArgList();
    assert null != namedArgListContext;

    final String name = namedArgListContext.IDENTIFIER( 0 ).getText();
    final String argName = namedArgListContext.IDENTIFIER( 1 ).getText();
    final List<Argument> arguments = Argument.parse( namedArgListContext.argumentList() );
    return ExtendedAttribute.createExtendedAttributeNamedArgList( name, argName, arguments );
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
