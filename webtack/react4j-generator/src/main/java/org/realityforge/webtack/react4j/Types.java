package org.realityforge.webtack.react4j;

import com.squareup.javapoet.ArrayTypeName;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.WildcardTypeName;
import java.util.stream.Stream;
import javax.annotation.Nonnull;

final class Types
{
  @Nonnull
  static final ClassName REACT_ELEMENT = ClassName.get( "react4j", "ReactElement" );
  @Nonnull
  static final ClassName REACT_NODE = ClassName.get( "react4j", "ReactNode" );
  @Nonnull
  static final ArrayTypeName REACT_NODE_ARRAY = ArrayTypeName.of( REACT_NODE );
  @Nonnull
  static final ClassName STREAM = ClassName.get( Stream.class );
  @Nonnull
  static final ParameterizedTypeName STREAM_T_REACT_NODE =
    ParameterizedTypeName.get( STREAM, WildcardTypeName.subtypeOf( REACT_NODE ) );

  private Types()
  {
  }
}
