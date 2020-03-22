package org.realityforge.webtack.model;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class InterfaceModelTest
  extends AbstractTest
{
  @Test
  public void basicOperation()
  {
    final ModelRepository repository = new ModelRepository();
    final String name = randomString();
    final String inherits = randomString();

    final InterfaceModel model = new InterfaceModel( repository, name );

    assertEquals( model.getName(), name );
    assertEquals( model.getRepository(), repository );
    assertFalse( model.isInheritsSet() );
    assertThrows( IllegalModelException.class,
                  "Attempting to access inherits for interface named '" +
                  name + "' before it has been set",
                  model::getInherits );

    model.setInherits( inherits );

    assertEquals( model.getInherits(), inherits );
    assertTrue( model.isInheritsSet() );

    // Fine to try and set again if value matches as sometimes multiple specs define the same interface
    model.setInherits( inherits );

    final String inherits2 = randomString();

    assertThrows( IllegalModelException.class,
                  "Attempting to set inherits for interface named '" + name + "' to '" +
                  inherits2 + "' but it has already been set to '" + inherits + "'",
                  () -> model.setInherits( inherits2 ) );
  }
}
