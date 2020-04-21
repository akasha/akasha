package org.realityforge.webtack.model;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;
import org.realityforge.webtack.webidl.parser.WebIDLParser;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class PartialNamespaceDefinitionTest
  extends AbstractTest
{
  @Test
  public void parse_operations()
    throws IOException
  {
    final PartialNamespaceDefinition namespace =
      ensurePartialNamespaceDefinition( "partial namespace WebAssembly {\n" +
                                        "    boolean validate(BufferSource bytes);\n" +
                                        "    Promise<Module> compile(BufferSource bytes);\n" +
                                        "};\n",
                                        "WebAssembly",
                                        2,
                                        0 );
    final List<OperationMember> operations = namespace.getOperations();
    {
      final OperationMember operation = operations.get( 0 );
      assertEquals( operation.getName(), "validate" );
      assertEquals( operation.getReturnType().getKind(), Kind.Boolean );
      final List<Argument> arguments = operation.getArguments();
      assertEquals( arguments.size(), 1 );
      final Argument argument1 = arguments.get( 0 );
      final Type argument1Type = argument1.getType();
      assertEquals( argument1Type.getKind(), Kind.TypeReference );
      assertEquals( ( (TypeReference) argument1Type ).getName(), "BufferSource" );
    }

    {
      final OperationMember operation = operations.get( 1 );
      assertEquals( operation.getName(), "compile" );
      final Type returnType = operation.getReturnType();
      assertEquals( returnType.getKind(), Kind.Promise );
      final Type resolveType = ( (PromiseType) returnType ).getResolveType();
      assertEquals( resolveType.getKind(), Kind.TypeReference );
      assertEquals( ( (TypeReference) resolveType ).getName(), "Module" );
      final List<Argument> arguments = operation.getArguments();
      assertEquals( arguments.size(), 1 );
      final Argument argument1 = arguments.get( 0 );
      final Type argument1Type = argument1.getType();
      assertEquals( argument1Type.getKind(), Kind.TypeReference );
      assertEquals( ( (TypeReference) argument1Type ).getName(), "BufferSource" );
    }
  }

  @Test
  public void parse()
    throws IOException
  {
    final PartialNamespaceDefinition namespace =
      ensurePartialNamespaceDefinition( "partial namespace Something {\n" +
                                        "    readonly attribute XRVisibilityState visibilityState;\n" +
                                        "    [SameObject] readonly attribute XRRenderState renderState;\n" +
                                        "};\n",
                                        "Something",
                                        0,
                                        2 );
    final List<AttributeMember> attributes = namespace.getAttributes();
    {
      final AttributeMember attribute = attributes.get( 0 );
      assertEquals( attribute.getName(), "visibilityState" );
      assertEquals( attribute.getType().getKind(), Kind.TypeReference );
      assertTrue( attribute.getModifiers().contains( AttributeMember.Modifier.READ_ONLY ) );
      assertEquals( ( (TypeReference) attribute.getType() ).getName(), "XRVisibilityState" );
    }

    {
      final AttributeMember attribute = attributes.get( 1 );
      assertEquals( attribute.getName(), "renderState" );
      assertEquals( attribute.getType().getKind(), Kind.TypeReference );
      assertTrue( attribute.getModifiers().contains( AttributeMember.Modifier.READ_ONLY ) );
      assertEquals( ( (TypeReference) attribute.getType() ).getName(), "XRRenderState" );
      final List<ExtendedAttribute> extendedAttributes = attribute.getExtendedAttributes();
      assertEquals( extendedAttributes.size(), 1 );
      assertTrue( extendedAttributes.stream().anyMatch( n -> "SameObject".equals( n.getName() ) ) );
    }
  }

  @Nonnull
  private PartialNamespaceDefinition ensurePartialNamespaceDefinition( @Nonnull final String webIDL,
                                                                       @Nonnull final String name,
                                                                       final int operationCount,
                                                                       final int attributeCount )
    throws IOException
  {
    final WebIDLParser.DefinitionContext ctx = createParser( webIDL ).definition();
    final Definition definition = WebIDLModelParser.parse( ctx, Collections.emptyList(), parseStartPosition( ctx ) );
    assertTrue( definition instanceof PartialNamespaceDefinition );
    final PartialNamespaceDefinition actual = (PartialNamespaceDefinition) definition;
    assertEquals( actual.getName(), name );
    assertEquals( actual.getOperations().size(), operationCount );
    assertEquals( actual.getAttributes().size(), attributeCount );
    assertEquals( actual, actual );
    assertEquals( actual.hashCode(), actual.hashCode() );

    final StringWriter writer = new StringWriter();
    WebIDLWriter.writePartialNamespaceDefinition( writer, actual );
    writer.close();
    final String emittedIDL = writer.toString();
    final List<Definition> definitions = WebIDLModelParser.parse( createParser( emittedIDL ).definitions() );
    assertEquals( definitions.size(), 1 );
    assertTrue( definitions.get( 0 ) instanceof PartialNamespaceDefinition );
    final PartialNamespaceDefinition element = (PartialNamespaceDefinition) definitions.get( 0 );
    assertEquals( element, element );
    assertEquals( element.hashCode(), element.hashCode() );

    assertTrue( element.equiv( actual ) );
    assertNotSame( element, actual );

    return actual;
  }
}
