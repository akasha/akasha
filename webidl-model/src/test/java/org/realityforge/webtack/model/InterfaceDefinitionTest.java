package org.realityforge.webtack.model;

import java.io.IOException;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class InterfaceDefinitionTest
  extends AbstractTest
{
  @Test
  public void parse_constant()
    throws IOException
  {
    final InterfaceDefinition definition =
      ensureInterfaceDefinition( "[Exposed=(Window,DedicatedWorker,SharedWorker)]\n" +
                                 "interface XMLHttpRequest : XMLHttpRequestEventTarget {\n" +
                                 "  const unsigned short UNSENT = 0;\n" +
                                 "};\n",
                                 "XMLHttpRequest",
                                 "XMLHttpRequestEventTarget",
                                 1,
                                 1,
                                 0,
                                 0 );
    final List<ConstMember> constants = definition.getConstants();
    final ConstMember constant = constants.get( 0 );
    assertEquals( constant.getName(), "UNSENT" );
    assertEquals( constant.getType().getKind(), Kind.UnsignedShort );
    assertEquals( constant.getValue().getValue(), "0" );
  }

  @Test
  public void parse_attribute()
    throws IOException
  {
    final InterfaceDefinition mixin =
      ensureInterfaceDefinition( "[SecureContext,Exposed=(Window,DedicatedWorker,SharedWorker)]\n" +
                                 "interface NavigatorStorage {\n" +
                                 "  [SameObject] readonly attribute StorageManager storage;\n" +
                                 "};\n",
                                 "NavigatorStorage",
                                 null,
                                 2,
                                 0,
                                 1,
                                 0 );
    final List<AttributeMember> attributes = mixin.getAttributes();
    final AttributeMember attribute = attributes.get( 0 );
    assertEquals( attribute.getName(), "storage" );
    assertTrue( attribute.getModifiers().contains( AttributeMember.Modifier.READ_ONLY ) );
    assertEquals( attribute.getExtendedAttributes().size(), 1 );
    assertEquals( attribute.getType().getKind(), Kind.TypeReference );
    assertEquals( ( (TypeReference) attribute.getType() ).getName(), "StorageManager" );
  }

  @Test
  public void parse_operation()
    throws IOException
  {
    final InterfaceDefinition definition =
      ensureInterfaceDefinition( "[Exposed=Window]\n" +
                                 "interface Worklet {\n" +
                                 "    [NewObject] Promise<void> addModule(USVString moduleURL, optional WorkletOptions options);\n" +
                                 "};\n",
                                 "Worklet",
                                 null,
                                 1,
                                 0,
                                 0,
                                 1 );

    final List<ExtendedAttribute> extendedAttributes = definition.getExtendedAttributes();
    assertEquals( extendedAttributes.size(), 1 );
    final ExtendedAttribute extendedAttribute = extendedAttributes.get( 0 );
    assertEquals( extendedAttribute.getName(), "Exposed" );
    assertEquals( extendedAttribute.getIdent(), "Window" );

    final List<OperationMember> operations = definition.getOperations();
    final OperationMember operation = operations.get( 0 );
    final List<ExtendedAttribute> operationExtendedAttributes = operation.getExtendedAttributes();
    assertEquals( operationExtendedAttributes.size(), 1 );
    assertEquals( operationExtendedAttributes.get( 0 ).getName(), "NewObject" );
    assertEquals( operation.getName(), "addModule" );
    final Type returnType = operation.getReturnType();
    assertEquals( returnType.getKind(), Kind.Promise );
    assertEquals( ( (PromiseType) returnType ).getResolveType().getKind(), Kind.Void );
    final List<Argument> arguments = operation.getArguments();
    assertEquals( arguments.size(), 2 );
    final Argument argument1 = arguments.get( 0 );
    assertEquals( argument1.getName(), "moduleURL" );
    assertEquals( argument1.getType().getKind(), Kind.USVString );

    final Argument argument2 = arguments.get( 1 );
    assertEquals( argument2.getName(), "options" );
    assertTrue( argument2.isOptional() );
    final Type argument2Type = argument2.getType();
    assertEquals( argument2Type.getKind(), Kind.TypeReference );
    assertEquals( ( (TypeReference) argument2Type ).getName(), "WorkletOptions" );
  }

  @Test
  public void parse_maplike()
    throws IOException
  {
    final InterfaceDefinition definition =
      ensureInterfaceDefinition( "[Exposed=Window]\n" +
                                 "interface AudioParamMap {\n" +
                                 "  readonly maplike<DOMString, AudioParam>;\n" +
                                 "};\n",
                                 "AudioParamMap",
                                 null,
                                 1,
                                 0,
                                 0,
                                 0 );
    final MapLikeMember mapLike = definition.getMapLikeMember();
    assertNotNull( mapLike );
    assertTrue( mapLike.isReadOnly() );
    assertEquals( mapLike.getKeyType().getKind(), Kind.DOMString );
    assertEquals( mapLike.getValueType().getKind(), Kind.TypeReference );
  }

  @Test
  public void parse_setlike()
    throws IOException
  {
    final InterfaceDefinition definition =
      ensureInterfaceDefinition( "[Exposed=Window]\n" +
                                 "interface AudioParamMap {\n" +
                                 "  readonly setlike<DOMString>;\n" +
                                 "};\n",
                                 "AudioParamMap",
                                 null,
                                 1,
                                 0,
                                 0,
                                 0 );
    final SetLikeMember setLike = definition.getSetLikeMember();
    assertNotNull( setLike );
    assertTrue( setLike.isReadOnly() );
    assertEquals( setLike.getType().getKind(), Kind.DOMString );
  }

  @Test
  public void parse_iterable()
    throws IOException
  {
    final InterfaceDefinition definition =
      ensureInterfaceDefinition( "[Exposed=Window]\n" +
                                 "  interface NodeList {\n" +
                                 "    getter Node? item(unsigned long index);\n" +
                                 "    readonly attribute unsigned long length;\n" +
                                 "    iterable<Node>;\n" +
                                 "  };",
                                 "NodeList",
                                 null,
                                 1,
                                 0,
                                 1,
                                 1 );
    final IterableMember iterable = definition.getIterable();
    assertNotNull( iterable );
    assertNull( iterable.getKeyType() );
    assertEquals( iterable.getValueType().getKind(), Kind.TypeReference );
  }

  @Test
  public void parse_async_iterable()
    throws IOException
  {
    final InterfaceDefinition definition =
      ensureInterfaceDefinition( "  interface Config {\n" +
                                 "    async iterable<DOMString,any>;\n" +
                                 "  };",
                                 "Config",
                                 null,
                                 0,
                                 0,
                                 0,
                                 0 );
    final AsyncIterableMember iterable = definition.getAsyncIterable();
    assertNotNull( iterable );
    assertEquals( iterable.getKeyType().getKind(), Kind.DOMString );
    assertEquals( iterable.getValueType().getKind(), Kind.Any );
  }

  @Test
  public void parse_complex()
    throws IOException
  {
    ensureInterfaceDefinition( "[Exposed=(Window,Worker)]\n" +
                               "interface Notification : EventTarget {\n" +
                               "  constructor(DOMString title, optional NotificationOptions options = {});\n" +
                               "\n" +
                               "  static readonly attribute NotificationPermission permission;\n" +
                               "  [Exposed=Window] static Promise<NotificationPermission> requestPermission(optional NotificationPermissionCallback deprecatedCallback);\n" +
                               "\n" +
                               "  static readonly attribute unsigned long maxActions;\n" +
                               "\n" +
                               "  attribute EventHandler onclick;\n" +
                               "  attribute EventHandler onshow;\n" +
                               "  attribute EventHandler onerror;\n" +
                               "  attribute EventHandler onclose;\n" +
                               "\n" +
                               "  readonly attribute DOMString title;\n" +
                               "  readonly attribute NotificationDirection dir;\n" +
                               "  readonly attribute DOMString lang;\n" +
                               "  readonly attribute DOMString body;\n" +
                               "  readonly attribute DOMString tag;\n" +
                               "  readonly attribute USVString image;\n" +
                               "  readonly attribute USVString icon;\n" +
                               "  readonly attribute USVString badge;\n" +
                               "  [SameObject] readonly attribute FrozenArray<unsigned long> vibrate;\n" +
                               "  readonly attribute DOMTimeStamp timestamp;\n" +
                               "  readonly attribute boolean renotify;\n" +
                               "  readonly attribute boolean silent;\n" +
                               "  readonly attribute boolean requireInteraction;\n" +
                               "  [SameObject] readonly attribute any data;\n" +
                               "  [SameObject] readonly attribute FrozenArray<NotificationAction> actions;\n" +
                               "\n" +
                               "  void close();\n" +
                               "};",
                               "Notification",
                               "EventTarget",
                               1,
                               0,
                               21,
                               3 );
  }

  @Nonnull
  private InterfaceDefinition ensureInterfaceDefinition( @Nonnull final String webIDL,
                                                         @Nonnull final String name,
                                                         @Nullable final String inherits,
                                                         final int extendedAttributeCount,
                                                         final int constantCount,
                                                         final int attributeCount,
                                                         final int operationCount )
    throws IOException
  {
    final Definition definition =
      WebIDLModelParser.parse( createParser( webIDL ).definitions() ).get( 0 );
    assertTrue( definition instanceof InterfaceDefinition );
    final InterfaceDefinition mixin = (InterfaceDefinition) definition;
    assertEquals( mixin.getName(), name );
    assertEquals( mixin.getInherits(), inherits );
    assertEquals( mixin.getExtendedAttributes().size(), extendedAttributeCount );
    assertEquals( mixin.getConstants().size(), constantCount );
    assertEquals( mixin.getAttributes().size(), attributeCount );
    assertEquals( mixin.getOperations().size(), operationCount );
    return mixin;
  }
}
