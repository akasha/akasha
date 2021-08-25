interface Document : Element {
  event MyEvent myevent;
  event MyOtherEvent myotherevent3;
  event MyOtherEvent myotherevent4;
};

interface Element : Node {
  event MyOtherEvent myotherevent;
  event MyOtherEvent myotherevent2;
  event MyOtherEvent myotherevent3;
};

interface Event {
};

interface MyEvent : Event {
};

interface MyOtherEvent : Event {
};

interface Node {
  event Event myevent;
};
