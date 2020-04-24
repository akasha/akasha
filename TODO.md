# TODO

This document is essentially a list of shorthand notes describing work yet to be completed.
Unfortunately it is not complete enough for other people to pick work off the list and
complete as there is too much un-said.

* Remove local html once fetch is successful. Potentially add a CLI arg that will leave it rather than deleting.

* Add blend operation that will attempt merge multiple schemas and if it finds matching declarations will perform blending. This is useful when pulling in gecko or chrome schemas and creating a combined schema.

* Should blend of multiple Extended attribute `Ident` types produce an `IdentList` type or only for special well-known extended attributes ala `Exposed`?

* Generate an error if the IDL extracted from web page is empty. Either the spec does not use WebIDL or we have incorrect matching rules.

* Add quiet mode to fetch so that only actions that require download print

* The spec docs have a lot of documentation that can be scraped. Some of them have great cross-linking
  so it should be possible with a little bit of heuristics to extract the documentation for different
  members and definitions.

  Spec Docs: https://heycam.github.io/webidl/

* Add a process that expands the partials into the actuals and creates a new `WebIDLSchema` with result.

* Add a series of validators that verify characteristics of the schema before further processing. Errors or
  warnings are likely the result of each validation process. Validations may include:
  - if a partial exists then the actual should exist
  - ensure that inherits exists for interfaces
  - ensure all `TypeReference` types resolve to a valid type
  - ensure that names are unique across all the types
  etc.

* Add a simple output process that emits java (or closure externs) directly as part of the experiment. Consider
  how this would look if we created a parallel model hierarchy and then generated source code based on this model.

* Consider loading in the chrome `WebIDL` so that we could decorate the model with chrome specific extensions.
  We could then make sure these extensions are clearly marked in the source code (i.e. generate to extern prefixed
  with chrome etc or explicit annotations in java code)

* Add a process where we could load customizations from json when processing the model so we can patch the schema
  in specific ways.

* Add passes where we modify the internal model (i.e. in java we could emit a `addOnFooListener(e -> {})` if there
  is an event named `foo`)

* Re-add idl source named `deviceorientation` at url `https://w3c.github.io/deviceorientation/`
