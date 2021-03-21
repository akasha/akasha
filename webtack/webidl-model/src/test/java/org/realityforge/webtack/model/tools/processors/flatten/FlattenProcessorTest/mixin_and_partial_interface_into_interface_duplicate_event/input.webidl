partial interface mixin DocumentOrShadowRoot {
  event Event myevent;
};

interface Event {
};

interface mixin DocumentOrShadowRoot {
};

Document includes DocumentOrShadowRoot;

partial interface Document {
  event Event myevent;
};

interface Document {
};
