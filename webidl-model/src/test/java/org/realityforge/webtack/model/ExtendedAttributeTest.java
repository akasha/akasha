package org.realityforge.webtack.model;

import java.util.Arrays;
import java.util.List;
import org.realityforge.webtack.webidl.parser.WebIDLParser;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

@SuppressWarnings( "ResultOfMethodCallIgnored" )
public final class ExtendedAttributeTest
  extends AbstractTest
{
  @Test
  public void NO_ARGS()
  {
    final String name = randomString();
    final ExtendedAttribute extendedAttribute = ExtendedAttribute.createExtendedAttributeNoArgs( name );
    assertEquals( extendedAttribute.getName(), name );
    assertEquals( extendedAttribute.getKind(), ExtendedAttribute.Kind.NO_ARGS );
    assertThrows( IllegalStateException.class,
                  "Invoked getIdent() on extended attribute named '" + name + "' but attribute is of kind NO_ARGS",
                  extendedAttribute::getIdent );
    assertThrows( IllegalStateException.class,
                  "Invoked getIdentList() on extended attribute named '" + name + "' but attribute is of kind NO_ARGS",
                  extendedAttribute::getIdentList );
  }

  @Test
  public void NO_ARGS_parse()
    throws Exception
  {
    final WebIDLParser parser = createParser( "EnforceRange" );
    final ExtendedAttribute extendedAttribute = ExtendedAttribute.parse( parser.extendedAttribute() );
    assertEquals( extendedAttribute.getName(), "EnforceRange" );
    assertEquals( extendedAttribute.getKind(), ExtendedAttribute.Kind.NO_ARGS );
  }

  @Test
  public void IDENT()
  {
    final String name = randomString();
    final String ident = randomString();
    final ExtendedAttribute extendedAttribute = ExtendedAttribute.createExtendedAttributeIdent( name, ident );
    assertEquals( extendedAttribute.getName(), name );
    assertEquals( extendedAttribute.getKind(), ExtendedAttribute.Kind.IDENT );
    assertEquals( extendedAttribute.getIdent(), ident );
    assertThrows( IllegalStateException.class,
                  "Invoked getIdentList() on extended attribute named '" + name + "' but attribute is of kind IDENT",
                  extendedAttribute::getIdentList );
  }

  @Test
  public void IDENT_parse()
    throws Exception
  {
    final WebIDLParser parser = createParser( "LegacyNamespace=WebAssembly" );
    final ExtendedAttribute extendedAttribute = ExtendedAttribute.parse( parser.extendedAttribute() );
    assertEquals( extendedAttribute.getName(), "LegacyNamespace" );
    assertEquals( extendedAttribute.getKind(), ExtendedAttribute.Kind.IDENT );
    assertEquals( extendedAttribute.getIdent(), "WebAssembly" );
  }

  @Test
  public void IDENT_LIST()
    throws Exception
  {
    final String name = randomString();
    final List<String> identList = Arrays.asList( randomString(), randomString() );
    final ExtendedAttribute extendedAttribute =
      ExtendedAttribute.createExtendedAttributeIdentList( name, identList );
    assertEquals( extendedAttribute.getName(), name );
    assertEquals( extendedAttribute.getKind(), ExtendedAttribute.Kind.IDENT_LIST );
    assertEquals( extendedAttribute.getIdentList(), identList );
    assertThrows( IllegalStateException.class,
                  "Invoked getIdent() on extended attribute named '" + name + "' but attribute is of kind IDENT_LIST",
                  extendedAttribute::getIdent );
  }

  @Test
  public void IDENT_LIST_parse()
    throws Exception
  {
    final WebIDLParser parser = createParser( "Exposed=(Window,Worker)" );
    final ExtendedAttribute extendedAttribute = ExtendedAttribute.parse( parser.extendedAttribute() );
    assertEquals( extendedAttribute.getName(), "Exposed" );
    assertEquals( extendedAttribute.getKind(), ExtendedAttribute.Kind.IDENT_LIST );
    assertEquals( extendedAttribute.getIdentList(), Arrays.asList( "Window", "Worker" ) );
  }

  @Test
  public void parseExtendedAttributesList()
    throws Exception
  {
    final WebIDLParser parser =
      createParser( "[NoInterfaceObject, LegacyNamespace=WebAssembly, Exposed=(Window,Worker,Worklet)]" );
    final List<ExtendedAttribute> extendedAttributes = ExtendedAttribute.parse( parser.extendedAttributeList() );
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
}
