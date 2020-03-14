// This grammar is based on grammar in Web IDL Editor’s Draft, 13 March 2020.

// changes from the spec:
// - Added `webIDL` wrapper type
// - Renamed `enum` to `enumDefinition`
// - Renamed `const` to `constMember`
// - Renamed `null` to `nullModifier`
// - Renamed `default` to `defaultAssignment`
grammar WebIDL;

INTEGER
	: '-'?([1-9][0-9]*|'0'([Xx][0-9A-Fa-f]+|[0-7]*))
;

DECIMAL
	: '-'?(([0-9]+'.'[0-9]*|[0-9]*'.'[0-9]+)([Ee][+\-]?[0-9]+)?|[0-9]+[Ee][+\-]?[0-9]+)
;

IDENTIFIER
	: [_-]?[A-Za-z][0-9A-Z_a-z\-]*
;

STRING
	: '"' ~["]* '"'
;

WHITESPACE
	: [\t\n\r ]+ -> channel(HIDDEN)
;

COMMENT
	: ('//'~[\n\r]*|'/*'(.|'\n')*?'*/')+ -> channel(HIDDEN)
; // Note: '/''/'~[\n\r]* instead of '/''/'.* (non-greedy because of wildcard).

OTHER
	: ~[\t\n\r 0-9A-Za-z]
;

webIDL
	: definitions EOF
;

definitions
	: extendedAttributeList definition definitions
	| /* empty */
;

definition
	: callbackOrInterfaceOrMixin
	| namespace
	| partial
	| dictionary
	| enumDefinition
	| typedef
	| includesStatement
;

argumentNameKeyword
	: 'async'
	| 'attribute'
	| 'callback'
	| 'const'
	| 'constructor'
	| 'deleter'
	| 'dictionary'
	| 'enum'
	| 'getter'
	| 'includes'
	| 'inherit'
	| 'interface'
	| 'iterable'
	| 'maplike'
	| 'mixin'
	| 'namespace'
	| 'partial'
	| 'readonly'
	| 'required'
	| 'setlike'
	| 'setter'
	| 'static'
	| 'stringifier'
	| 'typedef'
	| 'unrestricted'
;

callbackOrInterfaceOrMixin
	: 'callback' callbackRestOrInterface
	| 'interface' interfaceOrMixin
;

interfaceOrMixin
  : interfaceRest
  | mixinRest
;

interfaceRest
  : IDENTIFIER inheritance '{' interfaceMembers '}'
;

partial
  : 'partial' partialDefinition
;

partialDefinition
  : 'interface' partialInterfaceOrPartialMixin
  | partialDictionary
  | namespace
;

partialInterfaceOrPartialMixin
  : partialInterfaceRest
  | mixinRest
;

partialInterfaceRest
  : IDENTIFIER '{' partialInterfaceMembers '}'
;

interfaceMembers
  : extendedAttributeList interfaceMember interfaceMembers
  | /* empty */
;

interfaceMember
  : partialInterfaceMember
  | constructor
;

partialInterfaceMembers
  : extendedAttributeList partialInterfaceMember partialInterfaceMembers
  | /* empty */
;

partialInterfaceMember
  : constMember
  | operation
  | stringifier
  | staticMember
  | iterable
  | asyncIterable
  | readOnlyMember
  | readWriteAttribute
  | readWriteMaplike
  | readWriteSetlike
;

inheritance
  : ':' IDENTIFIER
  | /* empty */
;

mixinRest
  : 'mixin' IDENTIFIER '{' mixinMembers '}'
;

mixinMembers
  : extendedAttributeList mixinMember mixinMembers
  | /* empty */
;

mixinMember
  : constMember
  | regularOperation
  | stringifier
  | readOnly attributeRest
;

includesStatement
  : IDENTIFIER 'includes' IDENTIFIER
;

callbackRestOrInterface
  : callbackRest
  | 'interface' IDENTIFIER '{' callbackInterfaceMembers '}'
;

callbackInterfaceMembers
  : extendedAttributeList callbackInterfaceMember callbackInterfaceMembers
  | /* empty */
;

callbackInterfaceMember
  : constMember
  |  regularOperation
;

constMember
  : 'const' constMemberType IDENTIFIER '=' constMemberValue
;

constMemberValue
  : booleanLiteral
  | floatLiteral
  | INTEGER
;

booleanLiteral
  : 'true'
  | 'false'
;

floatLiteral
  : DECIMAL
  | '-Infinity'
  | 'Infinity'
  | 'NaN'
;

constMemberType
  : primitiveType
  | IDENTIFIER
;

readOnlyMember
  : 'readonly' readOnlyMemberRest
;

readOnlyMemberRest
  : attributeRest
  | maplikeRest
  | setlikeRest
;

readWriteAttribute
  : 'inherit' attributeRest
  | attributeRest
;

attributeRest
  : 'attribute' typeWithExtendedAttributes attributeName
;

attributeName
  : attributeNameKeyword
  | IDENTIFIER
;

attributeNameKeyword
  : 'async'
  | 'required'
;

readOnly
  : 'readonly'
  | /* empty */
;

defaultValue
  : constMemberValue
  | STRING
  | '[' ']'
  | '{' '}'
  | 'null'
;

operation
  : regularOperation
  | specialOperation
;

regularOperation
  : returnType operationRest
;

specialOperation
  : special regularOperation
;

special
  : 'getter'
  | 'setter'
  | 'deleter'
;

operationRest
  : optionalOperationName '(' argumentList ')'
;

optionalOperationName
  : operationName
  | /* empty */
;

operationName
  : operationNameKeyword
  | IDENTIFIER
;

operationNameKeyword
  : 'includes'
;

argumentList
  : argument arguments
  | /* empty */
;

arguments
  : ',' argument arguments
  | /* empty */
;

argument
  : extendedAttributeList argumentRest
;

argumentRest
  : 'optional' typeWithExtendedAttributes argumentName defaultAssignment
  | type ellipsis argumentName
;

argumentName
  : argumentNameKeyword
  | IDENTIFIER
;

ellipsis
  : '...'
  | /* empty */
;

returnType
  : type
  | 'void'
;

constructor
  : 'constructor' '(' argumentList ')'
;

stringifier
  : 'stringifier' stringifierRest
;

stringifierRest
  : readOnly attributeRest
  | regularOperation
;

staticMember
  : 'static' staticMemberRest
;

staticMemberRest
  : readOnly attributeRest
  | regularOperation
;

iterable
  : 'iterable' '<' typeWithExtendedAttributes optionalType '>'
;

optionalType
  : ',' typeWithExtendedAttributes
  | /* empty */
;

asyncIterable
  : 'async' 'iterable' '<' typeWithExtendedAttributes ',' typeWithExtendedAttributes '>'
;

readWriteMaplike
  : maplikeRest
;

maplikeRest
  : 'maplike' '<' typeWithExtendedAttributes ',' typeWithExtendedAttributes '>'
;

readWriteSetlike
  : setlikeRest
;

setlikeRest
  : 'setlike' '<' typeWithExtendedAttributes '>'
;

namespace
  : 'namespace' IDENTIFIER '{' namespaceMembers '}'
;

namespaceMembers
  : extendedAttributeList namespaceMember namespaceMembers
  | /* empty */
;

namespaceMember
  : regularOperation
  | 'readonly' attributeRest
;

dictionary
  : 'dictionary' IDENTIFIER inheritance '{' dictionaryMembers '}'
;

dictionaryMembers
  : dictionaryMember dictionaryMembers
  | /* empty */
;

dictionaryMember
  : extendedAttributeList dictionaryMemberRest
;

dictionaryMemberRest
  : 'required' typeWithExtendedAttributes IDENTIFIER ';'
  | type IDENTIFIER defaultAssignment
;

partialDictionary
  : 'dictionary' IDENTIFIER '{' dictionaryMembers '}'
;

defaultAssignment
  : '=' defaultValue
  | /* empty */
;

enumDefinition
  : 'enum' IDENTIFIER '{' enumValueList '}'
;

enumValueList
  : STRING enumValueListComma
;

enumValueListComma
  : ',' enumValueListString
  | /* empty */
;

enumValueListString
  : STRING enumValueListComma
  | /* empty */
;

callbackRest
  : IDENTIFIER '=' returnType '(' argumentList ')'
;

typedef
  : 'typedef' typeWithExtendedAttributes IDENTIFIER
;

type
  : singleType
  | unionType nullModifier
;

typeWithExtendedAttributes
  : extendedAttributeList type
;

singleType
  : distinguishableType
  | 'any'
  | promiseType
;

unionType
  : '(' unionMemberType 'or' unionMemberType unionMemberTypes ')'
;

unionMemberType
  : extendedAttributeList distinguishableType
  | unionType nullModifier
;

unionMemberTypes
  : 'or' unionMemberType unionMemberTypes
  | /* empty */
;

distinguishableType
  : primitiveType nullModifier
  | stringType nullModifier
  | IDENTIFIER nullModifier
  | 'sequence' '<' typeWithExtendedAttributes '>' nullModifier
  | 'object' nullModifier
  | 'symbol' nullModifier
  | bufferRelatedType nullModifier
  | 'FrozenArray' '<' typeWithExtendedAttributes '>' nullModifier
  | recordType nullModifier
;

primitiveType
  : unsignedIntegerType
  | unrestrictedFloatType
  | 'boolean'
  | 'byte'
  | 'octet'
;

unrestrictedFloatType
  : 'unrestricted' floatType
  | floatType
;

floatType
  : 'float'
  | 'double'
;

unsignedIntegerType
  : 'unsigned' integerType
  | integerType
;

integerType
  : 'short'
  | 'long' optionalLong
;

optionalLong
  : 'long'
  | /* empty */
;

stringType
  : 'ByteString'
  | 'DOMString'
  | 'USVString'
;

promiseType
  : 'Promise' '<' returnType '>'
;

recordType
  : 'record' '<' stringType ',' typeWithExtendedAttributes '>'
;

nullModifier
  : '?'
  | /* empty */
;

bufferRelatedType
  : 'ArrayBuffer'
  | 'DataView'
  | 'Int8Array'
  | 'Int16Array'
  | 'Int32Array'
  | 'Uint8Array'
  | 'Uint16Array'
  | 'Uint32Array'
  | 'Uint8ClampedArray'
  | 'Float32Array'
  | 'Float64Array'
;

extendedAttributeList
  : '[' extendedAttribute extendedAttributes ']'
  | /* empty */
;

extendedAttributes
  : ',' extendedAttribute extendedAttributes
  | /* empty */
;

extendedAttribute
  : '(' extendedAttributeInner ')' extendedAttributeRest
  | '[' extendedAttributeInner ']' extendedAttributeRest
  | '{' extendedAttributeInner '}' extendedAttributeRest
  | other extendedAttributeRest
;

extendedAttributeRest
  : extendedAttribute
  | /* empty */
;

extendedAttributeInner
  : '(' extendedAttributeInner ')' extendedAttributeInner
  | '[' extendedAttributeInner ']' extendedAttributeInner
  | '{' extendedAttributeInner '}' extendedAttributeInner
  | otherOrComma extendedAttributeInner
  | /* empty */
;

other
  : INTEGER
  | DECIMAL
  | IDENTIFIER
  | STRING
  | OTHER
  | '-'
  | '-Infinity'
  | '.'
  | '...'
  | ':'
  | ';'
  | '<'
  | '='
  | '>'
  | '?'
  | 'ByteString'
  | 'DOMString'
  | 'FrozenArray'
  | 'Infinity'
  | 'NaN'
  | 'Promise'
  | 'USVString'
  | 'any'
  | 'boolean'
  | 'byte'
  | 'double'
  | 'false'
  | 'float'
  | 'long'
  | 'null'
  | 'object'
  | 'octet'
  | 'or'
  | 'optional'
  | 'record'
  | 'sequence'
  | 'short'
  | 'symbol'
  | 'true'
  | 'unsigned'
  | 'void'
  | argumentNameKeyword
  | bufferRelatedType
;

otherOrComma
  : other
  | ','
;

identifierList
  : IDENTIFIER identifiers
;

identifiers
  : ',' IDENTIFIER identifiers
  | /* empty */
;

extendedAttributeNoArgs
  : IDENTIFIER
;

extendedAttributeArgList
  : IDENTIFIER '(' argumentList ')'
;

extendedAttributeIdent
  : IDENTIFIER '=' IDENTIFIER
;

extendedAttributeIdentList
  : IDENTIFIER '=' '(' identifierList ')'
;

extendedAttributeNamedArgList
  : IDENTIFIER '=' IDENTIFIER '(' argumentList ')'
;

/*

The following is the grammar from the spec:

Definitions ::
    ExtendedAttributeList Definition Definitions
    ε

Definition ::
    CallbackOrInterfaceOrMixin
    Namespace
    Partial
    Dictionary
    Enum
    Typedef
    IncludesStatement

ArgumentNameKeyword ::
    async
    attribute
    callback
    const
    constructor
    deleter
    dictionary
    enum
    getter
    includes
    inherit
    interface
    iterable
    maplike
    mixin
    namespace
    partial
    readonly
    required
    setlike
    setter
    static
    stringifier
    typedef
    unrestricted

CallbackOrInterfaceOrMixin ::
    callback CallbackRestOrInterface
    interface InterfaceOrMixin

InterfaceOrMixin ::
    InterfaceRest
    MixinRest

InterfaceRest ::
    identifier Inheritance { InterfaceMembers } ;

Partial ::
    partial PartialDefinition

PartialDefinition ::
    interface PartialInterfaceOrPartialMixin
    PartialDictionary
    Namespace

PartialInterfaceOrPartialMixin ::
    PartialInterfaceRest
    MixinRest

PartialInterfaceRest ::
    identifier { PartialInterfaceMembers } ;

InterfaceMembers ::
    ExtendedAttributeList InterfaceMember InterfaceMembers
    ε

InterfaceMember ::
    PartialInterfaceMember
    Constructor

PartialInterfaceMembers ::
    ExtendedAttributeList PartialInterfaceMember PartialInterfaceMembers
    ε

PartialInterfaceMember ::
    Const
    Operation
    Stringifier
    StaticMember
    Iterable
    AsyncIterable
    ReadOnlyMember
    ReadWriteAttribute
    ReadWriteMaplike
    ReadWriteSetlike

Inheritance ::
    : identifier
    ε

MixinRest ::
    mixin identifier { MixinMembers } ;

MixinMembers ::
    ExtendedAttributeList MixinMember MixinMembers
    ε

MixinMember ::
    Const
    RegularOperation
    Stringifier
    ReadOnly AttributeRest

IncludesStatement ::
    identifier includes identifier ;

CallbackRestOrInterface ::
    CallbackRest
    interface identifier { CallbackInterfaceMembers } ;

CallbackInterfaceMembers ::
    ExtendedAttributeList CallbackInterfaceMember CallbackInterfaceMembers
    ε

CallbackInterfaceMember ::
    Const
    RegularOperation

Const ::
    const ConstType identifier = ConstValue ;

ConstValue ::
    BooleanLiteral
    FloatLiteral
    integer

BooleanLiteral ::
    true
    false

FloatLiteral ::
    decimal
    -Infinity
    Infinity
    NaN

ConstType ::
    PrimitiveType
    identifier

ReadOnlyMember ::
    readonly ReadOnlyMemberRest

ReadOnlyMemberRest ::
    AttributeRest
    MaplikeRest
    SetlikeRest

ReadWriteAttribute ::
    inherit AttributeRest
    AttributeRest

AttributeRest ::
    attribute TypeWithExtendedAttributes AttributeName ;

AttributeName ::
    AttributeNameKeyword
    identifier

AttributeNameKeyword ::
    async
    required

ReadOnly ::
    readonly
    ε

DefaultValue ::
    ConstValue
    string
    [ ]
    { }
    null

Operation ::
    RegularOperation
    SpecialOperation

RegularOperation ::
    ReturnType OperationRest

SpecialOperation ::
    Special RegularOperation

Special ::
    getter
    setter
    deleter

OperationRest ::
    OptionalOperationName ( ArgumentList ) ;

OptionalOperationName ::
    OperationName
    ε

OperationName ::
    OperationNameKeyword
    identifier

OperationNameKeyword ::
    includes

ArgumentList ::
    Argument Arguments
    ε

Arguments ::
    , Argument Arguments
    ε

Argument ::
    ExtendedAttributeList ArgumentRest

ArgumentRest ::
    optional TypeWithExtendedAttributes ArgumentName Default
    Type Ellipsis ArgumentName

ArgumentName ::
    ArgumentNameKeyword
    identifier

Ellipsis ::
    ...
    ε

ReturnType ::
    Type
    void

Constructor ::
    constructor ( ArgumentList ) ;

Stringifier ::
    stringifier StringifierRest

StringifierRest ::
    ReadOnly AttributeRest
    RegularOperation
    ;

StaticMember ::
    static StaticMemberRest

StaticMemberRest ::
    ReadOnly AttributeRest
    RegularOperation

Iterable ::
    iterable < TypeWithExtendedAttributes OptionalType > ;

OptionalType ::
    , TypeWithExtendedAttributes
    ε

AsyncIterable ::
    async iterable < TypeWithExtendedAttributes , TypeWithExtendedAttributes > ;

ReadWriteMaplike ::
    MaplikeRest

MaplikeRest ::
    maplike < TypeWithExtendedAttributes , TypeWithExtendedAttributes > ;

ReadWriteSetlike ::
    SetlikeRest

SetlikeRest ::
    setlike < TypeWithExtendedAttributes > ;

Namespace ::
    namespace identifier { NamespaceMembers } ;

NamespaceMembers ::
    ExtendedAttributeList NamespaceMember NamespaceMembers
    ε

NamespaceMember ::
    RegularOperation
    readonly AttributeRest

Dictionary ::
    dictionary identifier Inheritance { DictionaryMembers } ;

DictionaryMembers ::
    DictionaryMember DictionaryMembers
    ε

DictionaryMember ::
    ExtendedAttributeList DictionaryMemberRest

DictionaryMemberRest ::
    required TypeWithExtendedAttributes identifier ;
    Type identifier Default ;

PartialDictionary ::
    dictionary identifier { DictionaryMembers } ;

Default ::
    = DefaultValue
    ε

Enum ::
    enum identifier { EnumValueList } ;

EnumValueList ::
    string EnumValueListComma

EnumValueListComma ::
    , EnumValueListString
    ε

EnumValueListString ::
    string EnumValueListComma
    ε

CallbackRest ::
    identifier = ReturnType ( ArgumentList ) ;

Typedef ::
    typedef TypeWithExtendedAttributes identifier ;

Type ::
    SingleType
    UnionType Null

TypeWithExtendedAttributes ::
    ExtendedAttributeList Type

SingleType ::
    DistinguishableType
    any
    PromiseType

UnionType ::
    ( UnionMemberType or UnionMemberType UnionMemberTypes )

UnionMemberType ::
    ExtendedAttributeList DistinguishableType
    UnionType Null

UnionMemberTypes ::
    or UnionMemberType UnionMemberTypes
    ε

DistinguishableType ::
    PrimitiveType Null
    StringType Null
    identifier Null
    sequence < TypeWithExtendedAttributes > Null
    object Null
    symbol Null
    BufferRelatedType Null
    FrozenArray < TypeWithExtendedAttributes > Null
    RecordType Null

PrimitiveType ::
    UnsignedIntegerType
    UnrestrictedFloatType
    boolean
    byte
    octet

UnrestrictedFloatType ::
    unrestricted FloatType
    FloatType

FloatType ::
    float
    double

UnsignedIntegerType ::
    unsigned IntegerType
    IntegerType

IntegerType ::
    short
    long OptionalLong

OptionalLong ::
    long
    ε

StringType ::
    ByteString
    DOMString
    USVString

PromiseType ::
    Promise < ReturnType >

RecordType ::
    record < StringType , TypeWithExtendedAttributes >

Null ::
    ?
    ε

BufferRelatedType ::
    ArrayBuffer
    DataView
    Int8Array
    Int16Array
    Int32Array
    Uint8Array
    Uint16Array
    Uint32Array
    Uint8ClampedArray
    Float32Array
    Float64Array

ExtendedAttributeList ::
    [ ExtendedAttribute ExtendedAttributes ]
    ε

ExtendedAttributes ::
    , ExtendedAttribute ExtendedAttributes
    ε

ExtendedAttribute ::
    ( ExtendedAttributeInner ) ExtendedAttributeRest
    [ ExtendedAttributeInner ] ExtendedAttributeRest
    { ExtendedAttributeInner } ExtendedAttributeRest
    Other ExtendedAttributeRest

ExtendedAttributeRest ::
    ExtendedAttribute
    ε

ExtendedAttributeInner ::
    ( ExtendedAttributeInner ) ExtendedAttributeInner
    [ ExtendedAttributeInner ] ExtendedAttributeInner
    { ExtendedAttributeInner } ExtendedAttributeInner
    OtherOrComma ExtendedAttributeInner
    ε

Other ::
    integer
    decimal
    identifier
    string
    other
    -
    -Infinity
    .
    ...
    :
    ;
    <
    =
    >
    ?
    ByteString
    DOMString
    FrozenArray
    Infinity
    NaN
    Promise
    USVString
    any
    boolean
    byte
    double
    false
    float
    long
    null
    object
    octet
    or
    optional
    record
    sequence
    short
    symbol
    true
    unsigned
    void
    ArgumentNameKeyword
    BufferRelatedType

OtherOrComma ::
    Other
    ,

IdentifierList ::
    identifier Identifiers

Identifiers ::
    , identifier Identifiers
    ε

ExtendedAttributeNoArgs ::
    identifier

ExtendedAttributeArgList ::
    identifier ( ArgumentList )

ExtendedAttributeIdent ::
    identifier = identifier

ExtendedAttributeIdentList ::
    identifier = ( IdentifierList )

ExtendedAttributeNamedArgList ::
    identifier = identifier ( ArgumentList )


*/