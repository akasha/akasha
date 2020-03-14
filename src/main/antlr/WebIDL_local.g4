// This grammar is based on grammar in Web IDL Editor’s Draft, 13 March 2020.

// changes from the spec:
// - Added `webIDL` wrapper type
// - Renamed `enum` to `enumDefinition`
// - Renamed `const` to `constMember`
// - Renamed `null` to `nullModifier`
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
  : 'optional' typeWithExtendedAttributes argumentName default
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
  | type IDENTIFIER default
;

partialDictionary
  : 'dictionary' IDENTIFIER '{' dictionaryMembers '}'
;

default
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
  : 'promise' '<' returnType '>'
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