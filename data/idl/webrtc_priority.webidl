enum RTCPriorityType {
  "high",
  "low",
  "medium",
  "very-low"
};

partial dictionary RTCDataChannelInit {
  RTCPriorityType priority = "low";
};

partial dictionary RTCRtpEncodingParameters {
  RTCPriorityType networkPriority;
  RTCPriorityType priority = "low";
};

partial interface RTCDataChannel {
  readonly attribute RTCPriorityType priority;
};
