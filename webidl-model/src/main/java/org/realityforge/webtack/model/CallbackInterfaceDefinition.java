package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;

public final class CallbackInterfaceDefinition
  extends Definition
{
  @Nonnull
  private final String _name;
  @Nonnull
  private final OperationMember _operation;
  @Nonnull
  private final List<ConstMember> _constants;

  public CallbackInterfaceDefinition( @Nonnull final String name,
                                      @Nonnull final OperationMember operation,
                                      @Nonnull final List<ConstMember> constants,
                                      @Nonnull final List<ExtendedAttribute> extendedAttributes )
  {
    super( extendedAttributes );
    _name = Objects.requireNonNull( name );
    _operation = Objects.requireNonNull( operation );
    _constants = Objects.requireNonNull( constants );
  }

  @Nonnull
  public String getName()
  {
    return _name;
  }

  @Nonnull
  public OperationMember getOperation()
  {
    return _operation;
  }

  @Nonnull
  public List<ConstMember> getConstants()
  {
    return _constants;
  }
}
