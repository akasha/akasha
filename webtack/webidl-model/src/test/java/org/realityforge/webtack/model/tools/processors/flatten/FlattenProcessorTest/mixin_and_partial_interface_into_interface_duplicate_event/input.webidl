interface mixin DocumentOrShadowRoot {
};

partial interface mixin DocumentOrShadowRoot {
  event Event myevent;
};

interface Document {
};

interface Event {
};

partial interface Document {
  event Event myevent;
};

Document includes DocumentOrShadowRoot;
