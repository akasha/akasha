enum RTCPriorityType {
  "very-low",
  "low",
  "medium",
  "high"
};

partial dictionary RTCDataChannelInit {
  RTCPriorityType priority;
};

partial dictionary RTCRtpEncodingParameters {
  RTCPriorityType networkPriority;
  RTCPriorityType priority;
};

partial interface RTCDataChannel {
  readonly attribute RTCPriorityType priority;
};
