// See the WebIDLParser file for a description of the grammar and how it differs from the spec.
lexer grammar WebIDLLexer;

ASYNC : 'async';
ATTRIBUTE : 'attribute';
EVENT : 'event';
CALLBACK : 'callback';
CONST : 'const';
CONSTRUCTOR : 'constructor';
DELETER : 'deleter';
DICTIONARY : 'dictionary';
ENUM : 'enum';
GETTER : 'getter';
INCLUDES : 'includes';
INHERIT : 'inherit';
INTERFACE : 'interface';
ITERABLE : 'iterable';
MAPLIKE : 'maplike';
MIXIN : 'mixin';
NAMESPACE : 'namespace';
PARTIAL : 'partial';
READONLY : 'readonly';
REQUIRED : 'required';
SETLIKE : 'setlike';
SETTER : 'setter';
STATIC : 'static';
STRINGIFIER : 'stringifier';
TYPEDEF : 'typedef';
UNRESTRICTED : 'unrestricted';
OPTIONAL : 'optional';
VOID : 'void';
UNDEFINED : 'undefined';

ANY : 'any';
SEQUENCE : 'sequence';
OBJECT : 'object';
SYMBOL : 'symbol';
FROZEN_ARRAY : 'FrozenArray';

BOOLEAN : 'boolean';
BYTE : 'byte';
OCTET : 'octet';
FLOAT : 'float';
DOUBLE : 'double';
UNSIGNED : 'unsigned';

OPEN_ANGLE_BRACKET : '<';
CLOSE_ANGLE_BRACKET : '>';
OR : 'or';

SHORT : 'short';
LONG : 'long';
BYTE_STRING : 'ByteString';
DOM_STRING : 'DOMString';
USV_STRING : 'USVString';
PROMISE : 'Promise';
RECORD : 'record';
QUESTION_MARK : '?';

OPEN_BRACE : '{';
CLOSE_BRACE : '}';
OPEN_BRACKET : '(';
CLOSE_BRACKET : ')';
OPEN_SQUARE_BRACKET : '[';
CLOSE_SQUARE_BRACKET : ']';
SEMI_COLON : ';';
COLON : ':';
EQUALS : '=';
DOT : '.';
COMMA : ',';
ELLIPSIS : '...';
NULL : 'null';
TRUE : 'true';
FALSE : 'false';
NEGATIVE_INFINITY : '-Infinity';
POSITIVE_INFINITY : 'Infinity';
NAN : 'NaN';

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

JAVADOC_START
	: '/**' STAR* -> mode(JAVADOC)
;

COMMENT
	: ('//'~[\n\r]*|'/*'~[*]+(.|'\n')*?'*/')+ -> channel(HIDDEN)
; // Note: '/''/'~[\n\r]* instead of '/''/'.* (non-greedy because of wildcard).

mode JAVADOC;

NAME
	: [a-zA-Z]+
	;

NEWLINE
	: '\n' (SPACE? (STAR {_input.LA(1) != '/'}?)+)?
	| '\r\n' (SPACE? (STAR {_input.LA(1) != '/'}?)+)?
	| '\r' (SPACE? (STAR {_input.LA(1) != '/'}?)+)?
	;

SPACE
	: (' '|'\t')+
	;

TEXT_CONTENT
	: ~[\n\r\t @*{}/a-zA-Z]+
	;

AT
	: '@'
	;

STAR
	: '*'
	;

SLASH
	: '/'
	;

JAVADOC_END
	: SPACE? STAR* '*/' -> mode(DEFAULT_MODE)
	;

INLINE_TAG_START
	: '{@'
;

BRACE_OPEN
	: '{'
;

BRACE_CLOSE
	: '}'
;
