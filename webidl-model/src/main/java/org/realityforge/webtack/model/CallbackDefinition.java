package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;

public final class CallbackDefinition
  extends Definition
{
  @Nonnull
  private final String _name;
  @Nonnull
  private final Type _returnType;
  @Nonnull
  private final List<Argument> _arguments;

  CallbackDefinition( @Nonnull final String name,
                      @Nonnull final Type returnType,
                      @Nonnull final List<Argument> arguments,
                      @Nonnull final List<ExtendedAttribute> extendedAttributes,
                      @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( extendedAttributes, sourceLocations );
    _name = Objects.requireNonNull( name );
    _returnType = Objects.requireNonNull( returnType );
    _arguments = Objects.requireNonNull( arguments );
  }

  @Nonnull
  public String getName()
  {
    return _name;
  }

  @Nonnull
  public Type getReturnType()
  {
    return _returnType;
  }

  @Nonnull
  public List<Argument> getArguments()
  {
    return _arguments;
  }
}
