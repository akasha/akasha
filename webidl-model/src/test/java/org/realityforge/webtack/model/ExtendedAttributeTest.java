package org.realityforge.webtack.model;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;
import org.realityforge.webtack.webidl.parser.WebIDLParser;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class ExtendedAttributeTest
  extends AbstractTest
{
  @Test
  public void NO_ARGS()
  {
    final String name = randomString();
    final ExtendedAttribute extendedAttribute =
      ExtendedAttribute.createExtendedAttributeNoArgs( name, Collections.emptyList() );
    assertEquals( extendedAttribute.getName(), name );
    assertEquals( extendedAttribute.getKind(), ExtendedAttribute.Kind.NO_ARGS );
    assertThrows( IllegalStateException.class,
                  "Invoked getIdent() on extended attribute named '" + name + "' but attribute is of kind NO_ARGS",
                  extendedAttribute::getIdent );
    assertThrows( IllegalStateException.class,
                  "Invoked getIdentList() on extended attribute named '" + name + "' but attribute is of kind NO_ARGS",
                  extendedAttribute::getIdentList );
    assertThrows( IllegalStateException.class,
                  "Invoked getArgListName() on extended attribute named '" + name + "' but attribute" +
                  " is of kind NO_ARGS",
                  extendedAttribute::getArgListName );
    assertThrows( IllegalStateException.class,
                  "Invoked getArgList() on extended attribute named '" + name + "' but attribute is of kind NO_ARGS",
                  extendedAttribute::getArgList );
  }

  @Test
  public void NO_ARGS_parse()
    throws Exception
  {
    final ExtendedAttribute extendedAttribute = parse( "EnforceRange" );
    assertEquals( extendedAttribute.getName(), "EnforceRange" );
    assertEquals( extendedAttribute.getKind(), ExtendedAttribute.Kind.NO_ARGS );
  }

  @Test
  public void NAMED_STRING()
  {
    final String name = randomString();
    final String value = randomString() + "." + randomString();
    final ExtendedAttribute extendedAttribute =
      ExtendedAttribute.createExtendedAttributeNamedString( name, value, Collections.emptyList() );
    assertEquals( extendedAttribute.getName(), name );
    assertEquals( extendedAttribute.getKind(), ExtendedAttribute.Kind.NAMED_STRING );
    assertEquals( extendedAttribute.getValue(), value );
    assertThrows( IllegalStateException.class,
                  "Invoked getIdent() on extended attribute named '" + name + "' but attribute is of kind NAMED_STRING",
                  extendedAttribute::getIdent );
    assertThrows( IllegalStateException.class,
                  "Invoked getIdentList() on extended attribute named '" + name + "' but attribute " +
                  "is of kind NAMED_STRING",
                  extendedAttribute::getIdentList );
    assertThrows( IllegalStateException.class,
                  "Invoked getArgListName() on extended attribute named '" + name + "' but attribute " +
                  "is of kind NAMED_STRING",
                  extendedAttribute::getArgListName );
    assertThrows( IllegalStateException.class,
                  "Invoked getArgList() on extended attribute named '" + name + "' but attribute " +
                  "is of kind NAMED_STRING",
                  extendedAttribute::getArgList );
  }

  @Test
  public void NAMED_STRING_parse()
    throws Exception
  {
    final ExtendedAttribute extendedAttribute = parse( "JavaAnnotation=\"com.biz.Example\"" );
    assertEquals( extendedAttribute.getName(), "JavaAnnotation" );
    assertEquals( extendedAttribute.getKind(), ExtendedAttribute.Kind.NAMED_STRING );
    assertEquals( extendedAttribute.getValue(), "com.biz.Example" );
  }

  @Test
  public void IDENT()
  {
    final String name = randomString();
    final String ident = randomString();
    final ExtendedAttribute extendedAttribute =
      ExtendedAttribute.createExtendedAttributeIdent( name, ident, Collections.emptyList() );
    assertEquals( extendedAttribute.getName(), name );
    assertEquals( extendedAttribute.getKind(), ExtendedAttribute.Kind.IDENT );
    assertEquals( extendedAttribute.getIdent(), ident );
    assertThrows( IllegalStateException.class,
                  "Invoked getValue() on extended attribute named '" + name + "' but attribute is of kind IDENT",
                  extendedAttribute::getValue );
    assertThrows( IllegalStateException.class,
                  "Invoked getIdentList() on extended attribute named '" + name + "' but attribute is of kind IDENT",
                  extendedAttribute::getIdentList );
    assertThrows( IllegalStateException.class,
                  "Invoked getArgListName() on extended attribute named '" + name + "' but attribute is of kind IDENT",
                  extendedAttribute::getArgListName );
    assertThrows( IllegalStateException.class,
                  "Invoked getArgList() on extended attribute named '" + name + "' but attribute is of kind IDENT",
                  extendedAttribute::getArgList );
  }

  @Test
  public void IDENT_parse()
    throws Exception
  {
    final ExtendedAttribute extendedAttribute = parse( "LegacyNamespace=WebAssembly" );
    assertEquals( extendedAttribute.getName(), "LegacyNamespace" );
    assertEquals( extendedAttribute.getKind(), ExtendedAttribute.Kind.IDENT );
    assertEquals( extendedAttribute.getIdent(), "WebAssembly" );
  }

  @Test
  public void IDENT_LIST()
  {
    final String name = randomString();
    final List<String> identList = Arrays.asList( randomString(), randomString() );
    final ExtendedAttribute extendedAttribute =
      ExtendedAttribute.createExtendedAttributeIdentList( name, identList, Collections.emptyList() );
    assertEquals( extendedAttribute.getName(), name );
    assertEquals( extendedAttribute.getKind(), ExtendedAttribute.Kind.IDENT_LIST );
    assertEquals( extendedAttribute.getIdentList(), identList );
    assertThrows( IllegalStateException.class,
                  "Invoked getValue() on extended attribute named '" + name + "' but attribute is of kind IDENT_LIST",
                  extendedAttribute::getValue );
    assertThrows( IllegalStateException.class,
                  "Invoked getIdent() on extended attribute named '" + name + "' but attribute is of kind IDENT_LIST",
                  extendedAttribute::getIdent );
    assertThrows( IllegalStateException.class,
                  "Invoked getArgListName() on extended attribute named '" +
                  name +
                  "' but attribute is of kind IDENT_LIST",
                  extendedAttribute::getArgListName );
    assertThrows( IllegalStateException.class,
                  "Invoked getArgList() on extended attribute named '" + name + "' but attribute is of kind IDENT_LIST",
                  extendedAttribute::getArgList );
  }

  @Test
  public void IDENT_LIST_parse()
    throws Exception
  {
    final ExtendedAttribute extendedAttribute = parse( "Exposed=(Window,Worker)" );
    assertEquals( extendedAttribute.getName(), "Exposed" );
    assertEquals( extendedAttribute.getKind(), ExtendedAttribute.Kind.IDENT_LIST );
    assertEquals( extendedAttribute.getIdentList(), Arrays.asList( "Window", "Worker" ) );
  }

  @Test
  public void ARG_LIST()
  {
    final String argListName = randomString();
    final List<Argument> argList =
      Collections.singletonList( new Argument( "foo",
                                               new Type( Kind.Octet,
                                                         Collections.emptyList(),
                                                         false,
                                                         Collections.emptyList() ),
                                               false,
                                               false,
                                               null,
                                               null,
                                               Collections.emptyList(),
                                               Collections.emptyList() ) );
    final ExtendedAttribute extendedAttribute =
      ExtendedAttribute.createExtendedAttributeArgList( argListName, argList, Collections.emptyList() );
    assertEquals( extendedAttribute.getKind(), ExtendedAttribute.Kind.ARG_LIST );
    assertEquals( extendedAttribute.getArgListName(), argListName );
    assertEquals( extendedAttribute.getArgList(), argList );
    assertThrows( IllegalStateException.class,
                  "Invoked getValue() on unnamed extended attribute but attribute is of kind ARG_LIST",
                  extendedAttribute::getValue );
    assertThrows( IllegalStateException.class,
                  "Invoked getName() on unnamed extended attribute but attribute is of kind ARG_LIST",
                  extendedAttribute::getName );
    assertThrows( IllegalStateException.class,
                  "Invoked getIdentList() on unnamed extended attribute but attribute is of kind ARG_LIST",
                  extendedAttribute::getIdentList );
    assertThrows( IllegalStateException.class,
                  "Invoked getIdent() on unnamed extended attribute but attribute is of kind ARG_LIST",
                  extendedAttribute::getIdent );
  }

  @Test
  public void ARG_LIST_parse()
    throws Exception
  {
    final ExtendedAttribute extendedAttribute =
      parse( "CreatedBy(optional DOMPointInit position = {}, optional DOMPointInit orientation = {})" );
    assertEquals( extendedAttribute.getArgListName(), "CreatedBy" );
    assertEquals( extendedAttribute.getKind(), ExtendedAttribute.Kind.ARG_LIST );

    final List<Argument> arguments = extendedAttribute.getArgList();

    final Argument argument1 = arguments.get( 0 );
    assertArgument( argument1, "position", Kind.TypeReference, true, false );
    assertNotNull( argument1.getDefaultValue() );
    assertEquals( argument1.getDefaultValue().getKind(), DefaultValue.Kind.EmptyDictionary );
    assertArgument( arguments.get( 1 ), "orientation", Kind.TypeReference, true, false );
  }

  @Test
  public void NAMED_ARG_LIST()
  {
    final String name = randomString();
    final String argListName = randomString();
    final List<Argument> argList =
      Collections.singletonList( new Argument( "foo",
                                               new Type( Kind.Octet,
                                                         Collections.emptyList(),
                                                         false,
                                                         Collections.emptyList() ),
                                               false,
                                               false,
                                               null,
                                               null,
                                               Collections.emptyList(),
                                               Collections.emptyList() ) );
    final ExtendedAttribute extendedAttribute =
      ExtendedAttribute.createExtendedAttributeNamedArgList( name, argListName, argList, Collections.emptyList() );
    assertEquals( extendedAttribute.getName(), name );
    assertEquals( extendedAttribute.getKind(), ExtendedAttribute.Kind.NAMED_ARG_LIST );
    assertEquals( extendedAttribute.getArgListName(), argListName );
    assertEquals( extendedAttribute.getArgList(), argList );
    assertThrows( IllegalStateException.class,
                  "Invoked getValue() on extended attribute named '" + name + "' but " +
                  "attribute is of kind NAMED_ARG_LIST",
                  extendedAttribute::getValue );
    assertThrows( IllegalStateException.class,
                  "Invoked getIdent() on extended attribute named '" + name + "' but " +
                  "attribute is of kind NAMED_ARG_LIST",
                  extendedAttribute::getIdent );
    assertThrows( IllegalStateException.class,
                  "Invoked getIdentList() on extended attribute named '" + name + "' but " +
                  "attribute is of kind NAMED_ARG_LIST",
                  extendedAttribute::getIdentList );
  }

  @Test
  public void NAMED_ARG_LIST_parse()
    throws Exception
  {
    final ExtendedAttribute extendedAttribute =
      parse( "Creator=CreatedBy(optional DOMPointInit position = {}, optional DOMPointInit orientation = {})" );
    assertEquals( extendedAttribute.getName(), "Creator" );
    assertEquals( extendedAttribute.getArgListName(), "CreatedBy" );
    assertEquals( extendedAttribute.getKind(), ExtendedAttribute.Kind.NAMED_ARG_LIST );

    final List<Argument> arguments = extendedAttribute.getArgList();

    final Argument argument1 = arguments.get( 0 );
    assertArgument( argument1, "position", Kind.TypeReference, true, false );
    assertNotNull( argument1.getDefaultValue() );
    assertEquals( argument1.getDefaultValue().getKind(), DefaultValue.Kind.EmptyDictionary );
    assertArgument( arguments.get( 1 ), "orientation", Kind.TypeReference, true, false );
  }

  @Test
  public void parseExtendedAttributesList()
    throws Exception
  {
    final WebIDLParser parser =
      createParser( "[NoInterfaceObject, LegacyNamespace=WebAssembly, Exposed=(Window,Worker,Worklet)]" );
    final List<ExtendedAttribute> extendedAttributes = WebIDLModelParser.parse( parser.extendedAttributeList() );
    assertEquals( extendedAttributes.size(), 3 );
    {
      final ExtendedAttribute extendedAttribute = extendedAttributes.get( 0 );
      assertEquals( extendedAttribute.getName(), "NoInterfaceObject" );
      assertEquals( extendedAttribute.getKind(), ExtendedAttribute.Kind.NO_ARGS );
    }
    {
      final ExtendedAttribute extendedAttribute = extendedAttributes.get( 1 );
      assertEquals( extendedAttribute.getName(), "LegacyNamespace" );
      assertEquals( extendedAttribute.getKind(), ExtendedAttribute.Kind.IDENT );
      assertEquals( extendedAttribute.getIdent(), "WebAssembly" );
    }
    {
      final ExtendedAttribute extendedAttribute = extendedAttributes.get( 2 );
      assertEquals( extendedAttribute.getName(), "Exposed" );
      assertEquals( extendedAttribute.getKind(), ExtendedAttribute.Kind.IDENT_LIST );
      assertEquals( extendedAttribute.getIdentList(), Arrays.asList( "Window", "Worker", "Worklet" ) );
    }
  }

  @Nonnull
  private ExtendedAttribute parse( @Nonnull final String webIDL )
    throws IOException
  {
    final ExtendedAttribute actual = ExtendedAttribute.parse( webIDL );

    assertEquals( actual, actual );
    assertEquals( actual.hashCode(), actual.hashCode() );

    final StringWriter writer = new StringWriter();
    WebIDLWriter.writeExtendedAttribute( writer, actual );
    writer.close();
    final String emittedIDL = writer.toString();
    final ExtendedAttribute element = ExtendedAttribute.parse( emittedIDL );
    assertEquals( element, actual );
    assertEquals( element.hashCode(), actual.hashCode() );

    assertTrue( element.equiv( actual ) );
    assertNotSame( element, actual );

    return actual;
  }
}
