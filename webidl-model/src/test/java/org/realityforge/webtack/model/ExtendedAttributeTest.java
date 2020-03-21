package org.realityforge.webtack.model;

import java.util.Arrays;
import java.util.List;
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
  public void IDENT_LIST()
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
}
