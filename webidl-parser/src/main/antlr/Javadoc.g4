// This grammar is based on grammar in https://github.com/antlr/grammars-v4/tree/master/javadoc at version 156f60d6d22c40870eb026dd24bafa68ad287625

grammar Javadoc;

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

JAVADOC_START
	: '/**' STAR*
	;

JAVADOC_END
	: SPACE? STAR* '*/'
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

documentation
	: EOF
	| JAVADOC_START skipWhitespace* documentationContent JAVADOC_END EOF
	;

documentationContent
	: description skipWhitespace*
	| skipWhitespace* tagSection
	| description NEWLINE+ skipWhitespace* tagSection
	;

skipWhitespace
	: SPACE
	| NEWLINE
	;

description
	: descriptionLine (descriptionNewline+ descriptionLine)*
	;

descriptionLine
	: descriptionLineStart descriptionLineElement*
	| inlineTag descriptionLineElement*
	;

descriptionLineStart
	: SPACE? descriptionLineNoSpaceNoAt+ (descriptionLineNoSpaceNoAt | SPACE | AT)*
	;

descriptionLineNoSpaceNoAt
	: TEXT_CONTENT
	| NAME
	| STAR
	| SLASH
	| BRACE_OPEN
	| BRACE_CLOSE
	;

descriptionLineElement
	: inlineTag
	| descriptionLineText
	;

descriptionLineText
	: (descriptionLineNoSpaceNoAt | SPACE | AT)+
	;

descriptionNewline
	: NEWLINE
	;

tagSection
	: blockTag+
;

blockTag
	: SPACE? AT NAME SPACE? blockTagContent*
;

blockTagContent
	: blockTagText
	| inlineTag
	| NEWLINE
;

blockTagText
	: blockTagTextElement+
;

blockTagTextElement
	: TEXT_CONTENT
	| NAME
	| SPACE
	| STAR
	| SLASH
	| BRACE_OPEN
	| BRACE_CLOSE
;


inlineTag
	: INLINE_TAG_START inlineTagName SPACE* inlineTagContent? BRACE_CLOSE
;

inlineTagName
	: NAME
;

inlineTagContent
	: braceContent+
;

braceExpression
	: BRACE_OPEN braceContent* BRACE_CLOSE
;

braceContent
	: braceExpression
	| braceText (NEWLINE* braceText)*
;

braceText
	: TEXT_CONTENT
	| NAME
	| SPACE
	| STAR
	| SLASH
	| NEWLINE
;