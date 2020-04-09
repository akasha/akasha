package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class OperationMember
  extends Element
  implements Member
{
  @Nonnull
  private final Kind _kind;
  @Nullable
  private final String _name;
  @Nonnull
  private final List<Argument> _arguments;
  @Nonnull
  private final Type _returnType;

  public OperationMember( @Nonnull final Kind kind,
                          @Nullable final String name,
                          @Nonnull final List<Argument> arguments,
                          @Nonnull final Type returnType,
                          @Nonnull final List<ExtendedAttribute> extendedAttributes )
  {
    super( extendedAttributes );
    _kind = Objects.requireNonNull( kind );
    _name = name;
    _arguments = Objects.requireNonNull( arguments );
    _returnType = Objects.requireNonNull( returnType );
  }

  @Nonnull
  public Kind getKind()
  {
    return _kind;
  }

  @Nullable
  public String getName()
  {
    return _name;
  }

  @Nonnull
  public List<Argument> getArguments()
  {
    return _arguments;
  }

  @Nonnull
  public Type getReturnType()
  {
    return _returnType;
  }

  public enum Kind
  {
    //TODO: Rename OPERATOR to REGULAR?
    OPERATOR,
    CONSTRUCTOR,
    GETTER,
    SETTER,
    DELETER
  }
}
