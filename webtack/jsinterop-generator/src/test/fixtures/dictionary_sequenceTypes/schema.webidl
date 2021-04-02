dictionary Base {
  sequence<any> optionalFeatures;
};

dictionary Sub1 : Base {
  sequence<Base> others;
};

dictionary Sub2 : Sub1 {
  sequence<XRSessionInit> sessions;
};

dictionary XRSessionInit {
  sequence<any> optionalFeatures;
  sequence<any> requiredFeatures;
};
