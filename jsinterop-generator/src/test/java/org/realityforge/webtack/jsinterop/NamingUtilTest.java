package org.realityforge.webtack.jsinterop;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class NamingUtilTest
{
  @Test
  public void camelCase()
  {
    assertEquals( NamingUtil.camelCase( "thisIsCamelCased" ), "thisIsCamelCased" );
    assertEquals( NamingUtil.camelCase( "ThisIsCamelCased" ), "thisIsCamelCased" );
    assertEquals( NamingUtil.camelCase( "this_Is_Camel_Cased" ), "thisIsCamelCased" );
    assertEquals( NamingUtil.camelCase( "this_Is_camel_cased" ), "thisIsCamelCased" );
    assertEquals( NamingUtil.camelCase( "EJB" ), "ejb" );
    assertEquals( NamingUtil.camelCase( "EJBContainer" ), "ejbContainer" );
    assertEquals( NamingUtil.camelCase( "_someField" ), "someField" );

    assertFalse( NamingUtil.isCamelCase( "_someField" ) );
    assertFalse( NamingUtil.isCamelCase( "EJB" ) );
    assertTrue( NamingUtil.isCamelCase( "someField" ) );
    assertTrue( NamingUtil.isCamelCase( "thisIsCamelCased" ) );
  }

  @Test
  public void pascalCase()
  {
    assertEquals( NamingUtil.pascalCase( "thisIsPascalCased" ), "ThisIsPascalCased" );
    assertEquals( NamingUtil.pascalCase( "ThisIsPascalCased" ), "ThisIsPascalCased" );
    assertEquals( NamingUtil.pascalCase( "this_Is_Pascal_Cased" ), "ThisIsPascalCased" );
    assertEquals( NamingUtil.pascalCase( "this_Is_pascal_cased" ), "ThisIsPascalCased" );
    assertEquals( NamingUtil.pascalCase( "EJB" ), "EJB" );
    assertEquals( NamingUtil.pascalCase( "EJBContainer" ), "EJBContainer" );
    assertEquals( NamingUtil.pascalCase( "_someField" ), "SomeField" );

    assertFalse( NamingUtil.isPascalCase( "findByID" ) );
    assertFalse( NamingUtil.isPascalCase( "thisIsCamelCased" ) );
    assertTrue( NamingUtil.isPascalCase( "FindByID" ) );
    assertTrue( NamingUtil.isPascalCase( "EJB" ) );
    assertTrue( NamingUtil.isPascalCase( "Ejb" ) );
  }
}
