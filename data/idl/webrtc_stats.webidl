enum RTCCodecType {
  "decode",
  "encode"
};

enum RTCQualityLimitationReason {
  "bandwidth",
  "cpu",
  "none",
  "other"
};

enum RTCStatsIceCandidatePairState {
  "failed",
  "frozen",
  "in-progress",
  "succeeded",
  "waiting"
};

enum RTCStatsType {
  "candidate-pair",
  "certificate",
  "codec",
  "csrc",
  "data-channel",
  "ice-server",
  "inbound-rtp",
  "local-candidate",
  "media-source",
  "outbound-rtp",
  "peer-connection",
  "receiver",
  "remote-candidate",
  "remote-inbound-rtp",
  "remote-outbound-rtp",
  "sctp-transport",
  "sender",
  "stream",
  "track",
  "transceiver",
  "transport"
};

dictionary RTCAudioHandlerStats : RTCMediaHandlerStats {
};

dictionary RTCAudioReceiverStats : RTCAudioHandlerStats {
};

dictionary RTCAudioSenderStats : RTCAudioHandlerStats {
  DOMString mediaSourceId;
};

dictionary RTCAudioSourceStats : RTCMediaSourceStats {
  double audioLevel;
  double echoReturnLoss;
  double echoReturnLossEnhancement;
  double totalAudioEnergy;
  double totalSamplesDuration;
};

dictionary RTCCertificateStats : RTCStats {
  DOMString base64Certificate;
  DOMString fingerprint;
  DOMString fingerprintAlgorithm;
  DOMString issuerCertificateId;
};

dictionary RTCCodecStats : RTCStats {
  unsigned long channels;
  unsigned long clockRate;
  RTCCodecType codecType;
  DOMString mimeType;
  unsigned long payloadType;
  DOMString sdpFmtpLine;
  DOMString transportId;
};

dictionary RTCDataChannelStats : RTCStats {
  unsigned long long bytesReceived;
  unsigned long long bytesSent;
  long dataChannelIdentifier;
  DOMString label;
  unsigned long messagesReceived;
  unsigned long messagesSent;
  DOMString protocol;
  RTCDataChannelState state;
  DOMString transportId;
};

dictionary RTCIceCandidatePairStats : RTCStats {
  double availableIncomingBitrate;
  double availableOutgoingBitrate;
  unsigned long long bytesDiscardedOnSend;
  unsigned long long bytesReceived;
  unsigned long long bytesSent;
  unsigned long circuitBreakerTriggerCount;
  DOMHighResTimeStamp consentExpiredTimestamp;
  unsigned long long consentRequestsSent;
  double currentRoundTripTime;
  DOMHighResTimeStamp firstRequestTimestamp;
  DOMHighResTimeStamp lastPacketReceivedTimestamp;
  DOMHighResTimeStamp lastPacketSentTimestamp;
  DOMHighResTimeStamp lastRequestTimestamp;
  DOMHighResTimeStamp lastResponseTimestamp;
  DOMString localCandidateId;
  boolean nominated;
  unsigned long packetsDiscardedOnSend;
  unsigned long long packetsReceived;
  unsigned long long packetsSent;
  DOMString remoteCandidateId;
  unsigned long long requestsReceived;
  unsigned long long requestsSent;
  unsigned long long responsesReceived;
  unsigned long long responsesSent;
  unsigned long long retransmissionsReceived;
  unsigned long long retransmissionsSent;
  RTCStatsIceCandidatePairState state;
  double totalRoundTripTime;
  DOMString transportId;
};

dictionary RTCIceCandidateStats : RTCStats {
  DOMString? address;
  RTCIceCandidateType candidateType;
  long port;
  long priority;
  DOMString protocol;
  DOMString relayProtocol;
  DOMString transportId;
  DOMString url;
};

dictionary RTCIceServerStats : RTCStats {
  long port;
  DOMString protocol;
  unsigned long totalRequestsSent;
  unsigned long totalResponsesReceived;
  double totalRoundTripTime;
  DOMString url;
};

dictionary RTCInboundRtpStreamStats : RTCReceivedRtpStreamStats {
  double audioLevel;
  double averageRtcpInterval;
  unsigned long long bytesReceived;
  unsigned long long concealedSamples;
  unsigned long long concealmentEvents;
  DOMString decoderImplementation;
  DOMHighResTimeStamp estimatedPlayoutTimestamp;
  unsigned long long fecPacketsDiscarded;
  unsigned long long fecPacketsReceived;
  unsigned long firCount;
  unsigned long frameBitDepth;
  unsigned long frameHeight;
  unsigned long frameWidth;
  unsigned long framesDecoded;
  double framesPerSecond;
  unsigned long framesReceived;
  unsigned long long headerBytesReceived;
  unsigned long long insertedSamplesForDeceleration;
  double jitterBufferDelay;
  unsigned long long jitterBufferEmittedCount;
  unsigned long keyFramesDecoded;
  DOMHighResTimeStamp lastPacketReceivedTimestamp;
  unsigned long nackCount;
  unsigned long long packetsDuplicated;
  unsigned long long packetsFailedDecryption;
  record<USVString, unsigned long long> perDscpPacketsReceived;
  unsigned long pliCount;
  unsigned long long qpSum;
  DOMString receiverId;
  DOMString remoteId;
  unsigned long long removedSamplesForAcceleration;
  unsigned long long samplesDecodedWithCelt;
  unsigned long long samplesDecodedWithSilk;
  unsigned long long silentConcealedSamples;
  unsigned long sliCount;
  double totalAudioEnergy;
  double totalDecodeTime;
  double totalInterFrameDelay;
  double totalSamplesDuration;
  unsigned long long totalSamplesReceived;
  double totalSquaredInterFrameDelay;
  DOMString trackId;
  boolean voiceActivityFlag;
};

dictionary RTCMediaHandlerStats : RTCStats {
  boolean ended;
  DOMString kind;
  RTCPriorityType priority;
  boolean remoteSource;
  DOMString trackIdentifier;
};

dictionary RTCMediaSourceStats : RTCStats {
  DOMString kind;
  DOMString trackIdentifier;
};

dictionary RTCMediaStreamStats : RTCStats {
  DOMString streamIdentifier;
  sequence<DOMString> trackIds;
};

dictionary RTCOutboundRtpStreamStats : RTCSentRtpStreamStats {
  double averageRtcpInterval;
  unsigned long long bytesDiscardedOnSend;
  DOMString encoderImplementation;
  unsigned long fecPacketsSent;
  unsigned long firCount;
  unsigned long frameBitDepth;
  unsigned long frameHeight;
  unsigned long frameWidth;
  unsigned long framesDiscardedOnSend;
  unsigned long framesEncoded;
  double framesPerSecond;
  unsigned long framesSent;
  unsigned long long headerBytesSent;
  unsigned long hugeFramesSent;
  unsigned long keyFramesEncoded;
  DOMHighResTimeStamp lastPacketSentTimestamp;
  DOMString mediaSourceId;
  unsigned long nackCount;
  unsigned long packetsDiscardedOnSend;
  record<USVString, unsigned long long> perDscpPacketsSent;
  unsigned long pliCount;
  unsigned long long qpSum;
  record<DOMString, double> qualityLimitationDurations;
  RTCQualityLimitationReason qualityLimitationReason;
  unsigned long qualityLimitationResolutionChanges;
  DOMString remoteId;
  unsigned long long retransmittedBytesSent;
  unsigned long long retransmittedPacketsSent;
  DOMString rid;
  unsigned long long samplesEncodedWithCelt;
  unsigned long long samplesEncodedWithSilk;
  DOMString senderId;
  unsigned long sliCount;
  double targetBitrate;
  double totalEncodeTime;
  unsigned long long totalEncodedBytesTarget;
  double totalPacketSendDelay;
  unsigned long long totalSamplesSent;
  DOMString trackId;
  boolean voiceActivityFlag;
};

dictionary RTCPeerConnectionStats : RTCStats {
  unsigned long dataChannelsAccepted;
  unsigned long dataChannelsClosed;
  unsigned long dataChannelsOpened;
  unsigned long dataChannelsRequested;
};

dictionary RTCReceivedRtpStreamStats : RTCRtpStreamStats {
  unsigned long burstDiscardCount;
  double burstDiscardRate;
  unsigned long burstLossCount;
  double burstLossRate;
  unsigned long long burstPacketsDiscarded;
  unsigned long long burstPacketsLost;
  unsigned long framesDropped;
  unsigned long fullFramesLost;
  double gapDiscardRate;
  double gapLossRate;
  double jitter;
  unsigned long long packetsDiscarded;
  long long packetsLost;
  unsigned long long packetsReceived;
  unsigned long long packetsRepaired;
  unsigned long partialFramesLost;
};

dictionary RTCReceiverAudioTrackAttachmentStats : RTCAudioReceiverStats {
};

dictionary RTCReceiverVideoTrackAttachmentStats : RTCVideoReceiverStats {
};

dictionary RTCRemoteInboundRtpStreamStats : RTCReceivedRtpStreamStats {
  double fractionLost;
  DOMString localId;
  unsigned long long reportsReceived;
  double roundTripTime;
  unsigned long long roundTripTimeMeasurements;
  double totalRoundTripTime;
};

dictionary RTCRemoteOutboundRtpStreamStats : RTCSentRtpStreamStats {
  DOMString localId;
  DOMHighResTimeStamp remoteTimestamp;
  unsigned long long reportsSent;
};

dictionary RTCRtpContributingSourceStats : RTCStats {
  double audioLevel;
  unsigned long contributorSsrc;
  DOMString inboundRtpStreamId;
  unsigned long packetsContributedTo;
};

dictionary RTCRtpStreamStats : RTCStats {
  DOMString codecId;
  DOMString kind;
  unsigned long ssrc;
  DOMString transportId;
};

dictionary RTCRtpTransceiverStats {
  DOMString mid;
  DOMString receiverId;
  DOMString senderId;
};

dictionary RTCSctpTransportStats : RTCStats {
  double smoothedRoundTripTime;
};

dictionary RTCSenderAudioTrackAttachmentStats : RTCAudioSenderStats {
};

dictionary RTCSenderVideoTrackAttachmentStats : RTCVideoSenderStats {
};

dictionary RTCSentRtpStreamStats : RTCRtpStreamStats {
  unsigned long long bytesSent;
  unsigned long packetsSent;
};

dictionary RTCStats {
  DOMString id;
  DOMHighResTimeStamp timestamp;
  RTCStatsType type;
};

dictionary RTCTransportStats : RTCStats {
  unsigned long long bytesReceived;
  unsigned long long bytesSent;
  DOMString dtlsCipher;
  RTCDtlsTransportState dtlsState;
  RTCIceRole iceRole;
  DOMString localCertificateId;
  unsigned long long packetsReceived;
  unsigned long long packetsSent;
  DOMString remoteCertificateId;
  DOMString rtcpTransportStatsId;
  unsigned long selectedCandidatePairChanges;
  DOMString selectedCandidatePairId;
  DOMString srtpCipher;
  DOMString tlsGroup;
  DOMString tlsVersion;
};

dictionary RTCVideoHandlerStats : RTCMediaHandlerStats {
};

dictionary RTCVideoReceiverStats : RTCVideoHandlerStats {
};

dictionary RTCVideoSenderStats : RTCVideoHandlerStats {
  DOMString mediaSourceId;
};

dictionary RTCVideoSourceStats : RTCMediaSourceStats {
  unsigned long bitDepth;
  unsigned long frames;
  unsigned long framesPerSecond;
  unsigned long height;
  unsigned long width;
};

partial dictionary RTCAudioHandlerStats {
  double audioLevel;
  double totalAudioEnergy;
  double totalSamplesDuration;
  boolean voiceActivityFlag;
};

partial dictionary RTCAudioReceiverStats {
  double audioLevel;
  unsigned long long concealedSamples;
  unsigned long long concealmentEvents;
  DOMHighResTimeStamp estimatedPlayoutTimestamp;
  unsigned long long insertedSamplesForDeceleration;
  double jitterBufferDelay;
  unsigned long long jitterBufferEmittedCount;
  unsigned long long removedSamplesForAcceleration;
  unsigned long long silentConcealedSamples;
  double totalAudioEnergy;
  double totalSamplesDuration;
  unsigned long long totalSamplesReceived;
};

partial dictionary RTCAudioSenderStats {
  double echoReturnLoss;
  double echoReturnLossEnhancement;
  unsigned long long totalSamplesSent;
};

partial dictionary RTCCodecStats {
  DOMString implementation;
};

partial dictionary RTCIceCandidatePairStats {
  double currentRtt;
  unsigned long long priority;
  double totalRtt;
};

partial dictionary RTCIceCandidateStats {
  boolean deleted = false;
  boolean isRemote;
};

partial dictionary RTCInboundRtpStreamStats {
  double fractionLost;
};

partial dictionary RTCRtpStreamStats {
  double averageRTCPInterval;
  DOMString mediaType;
};

partial dictionary RTCVideoHandlerStats {
  unsigned long frameHeight;
  unsigned long frameWidth;
  double framesPerSecond;
};

partial dictionary RTCVideoReceiverStats {
  DOMHighResTimeStamp estimatedPlayoutTimestamp;
  unsigned long framesDecoded;
  unsigned long framesDropped;
  unsigned long framesReceived;
  unsigned long fullFramesLost;
  double jitterBufferDelay;
  unsigned long long jitterBufferEmittedCount;
  unsigned long keyFramesReceived;
  unsigned long partialFramesLost;
};

partial dictionary RTCVideoSenderStats {
  unsigned long framesCaptured;
  unsigned long framesSent;
  unsigned long hugeFramesSent;
  unsigned long keyFramesSent;
};
