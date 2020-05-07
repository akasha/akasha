# TODO

This document is essentially a list of shorthand notes describing work yet to be completed.
Unfortunately it is not complete enough for other people to pick work off the list and
complete as there is too much un-said.

* Add query language that can be used to select sources based on tags or names so that we can filter load/merge/blend/generate operations

* Define "pass" that transforms one schema into another schema.

* Add blend operation that will attempt merge multiple schemas and if it finds matching declarations will perform blending. This is useful when pulling in gecko or chrome schemas and creating a combined schema.

* Should blend of multiple Extended attribute `Ident` types produce an `IdentList` type or only for special well-known extended attributes ala `Exposed`?

* The spec docs have a lot of documentation that can be scraped. Some of them have great cross-linking
  so it should be possible with a little bit of heuristics to extract the documentation for different
  members and definitions.

  Spec Docs: https://heycam.github.io/webidl/

* Add a process that expands the partials into the actuals and creates a new `WebIDLSchema` with result.
  Includes should also be merged into the types so the final model just includes the resolved interfaces,
  dictionaries etc.

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
