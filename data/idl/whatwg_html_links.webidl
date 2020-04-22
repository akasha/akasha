interface mixin HTMLHyperlinkElementUtils {
  readonly attribute USVString origin;
  [CEReactions]
  attribute USVString hash;
  [CEReactions]
  attribute USVString host;
  [CEReactions]
  attribute USVString hostname;
  [CEReactions]
  attribute USVString password;
  [CEReactions]
  attribute USVString pathname;
  [CEReactions]
  attribute USVString port;
  [CEReactions]
  attribute USVString protocol;
  [CEReactions]
  attribute USVString search;
  [CEReactions]
  attribute USVString username;
  [CEReactions]
  stringifier attribute USVString href;
};
