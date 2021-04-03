/**
 * @template T
 * @param {*} obj
 * @param {string|number|Symbol} key
 * @return {T}
 * @public
 */
JsUtil.getIndexed = function(obj, key) {
  return obj[key];
};
