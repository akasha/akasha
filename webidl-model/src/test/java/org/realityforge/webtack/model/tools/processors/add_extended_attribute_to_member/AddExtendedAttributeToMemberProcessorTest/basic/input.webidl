/**
 * Not matched by processor.
 */
dictionary Other {
  sequence<object> transfer = [];
};

dictionary PostMessageOptions {
  sequence<object> transfer = [];
};

dictionary WindowPostMessageOptions : PostMessageOptions {
  USVString targetOrigin = "/";
};
