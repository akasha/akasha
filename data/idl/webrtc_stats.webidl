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
  required DOMString fingerprint;
  required DOMString fingerprintAlgorithm;
  required DOMString base64Certificate;
  DOMString issuerCertificateId;
};

dictionary RTCCodecStats : RTCStats {
  required unsigned long payloadType;
  required DOMString transportId;
  required DOMString mimeType;
  unsigned long channels;
  unsigned long clockRate;
  RTCCodecType codecType;
  DOMString sdpFmtpLine;
};

dictionary RTCDataChannelStats : RTCStats {
  required RTCDataChannelState state;
  unsigned long long bytesReceived;
  unsigned long long bytesSent;
  unsigned short dataChannelIdentifier;
  DOMString label;
  unsigned long messagesReceived;
  unsigned long messagesSent;
  DOMString protocol;
};

dictionary RTCIceCandidatePairStats : RTCStats {
  required DOMString transportId;
  required DOMString localCandidateId;
  required DOMString remoteCandidateId;
  required RTCStatsIceCandidatePairState state;
  double availableIncomingBitrate;
  double availableOutgoingBitrate;
  unsigned long long bytesDiscardedOnSend;
  unsigned long long bytesReceived;
  unsigned long long bytesSent;
  unsigned long circuitBreakerTriggerCount;
  DOMHighResTimeStamp consentExpiredTimestamp;
  unsigned long long consentRequestBytesSent;
  unsigned long long consentRequestsSent;
  double currentRoundTripTime;
  DOMHighResTimeStamp firstRequestTimestamp;
  DOMHighResTimeStamp lastPacketReceivedTimestamp;
  DOMHighResTimeStamp lastPacketSentTimestamp;
  DOMHighResTimeStamp lastRequestTimestamp;
  DOMHighResTimeStamp lastResponseTimestamp;
  boolean nominated;
  unsigned long packetsDiscardedOnSend;
  unsigned long long packetsReceived;
  unsigned long long packetsSent;
  unsigned long long requestBytesSent;
  unsigned long long requestsReceived;
  unsigned long long requestsSent;
  unsigned long long responseBytesSent;
  unsigned long long responsesReceived;
  unsigned long long responsesSent;
  unsigned long long retransmissionsReceived;
  unsigned long long retransmissionsSent;
  double totalRoundTripTime;
};

dictionary RTCIceCandidateStats : RTCStats {
  required DOMString transportId;
  required RTCIceCandidateType candidateType;
  DOMString? address;
  long port;
  long priority;
  DOMString protocol;
  DOMString relayProtocol;
  DOMString url;
};

dictionary RTCIceServerStats : RTCStats {
  required DOMString url;
  long port;
  DOMString relayProtocol;
  unsigned long totalRequestsSent;
  unsigned long totalResponsesReceived;
  double totalRoundTripTime;
};

dictionary RTCInboundRtpStreamStats : RTCReceivedRtpStreamStats {
  required DOMString receiverId;
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
  DOMString remoteId;
  unsigned long long removedSamplesForAcceleration;
  unsigned long long samplesDecodedWithCelt;
  unsigned long long samplesDecodedWithSilk;
  unsigned long long silentConcealedSamples;
  unsigned long sliCount;
  double totalAudioEnergy;
  double totalDecodeTime;
  double totalInterFrameDelay;
  double totalProcessingDelay;
  unsigned long long totalSamplesDecoded;
  double totalSamplesDuration;
  unsigned long long totalSamplesReceived;
  double totalSquaredInterFrameDelay;
  boolean voiceActivityFlag;
};

dictionary RTCMediaHandlerStats : RTCStats {
  required DOMString kind;
  boolean ended;
  DOMString trackIdentifier;
};

dictionary RTCMediaSourceStats : RTCStats {
  required DOMString trackIdentifier;
  required DOMString kind;
  boolean relayedSource;
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
  unsigned long rtxSsrc;
  unsigned long long samplesEncodedWithCelt;
  unsigned long long samplesEncodedWithSilk;
  DOMString senderId;
  unsigned long sliCount;
  double targetBitrate;
  double totalEncodeTime;
  unsigned long long totalEncodedBytesTarget;
  double totalPacketSendDelay;
  unsigned long long totalSamplesSent;
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
  double roundTripTime;
  unsigned long long roundTripTimeMeasurements;
  double totalRoundTripTime;
};

dictionary RTCRtpContributingSourceStats : RTCStats {
  required unsigned long contributorSsrc;
  required DOMString inboundRtpStreamId;
  double audioLevel;
  unsigned long packetsContributedTo;
};

dictionary RTCRtpStreamStats : RTCStats {
  required unsigned long ssrc;
  required DOMString kind;
  DOMString codecId;
  DOMString transportId;
};

dictionary RTCRtpTransceiverStats : RTCStats {
  required DOMString senderId;
  required DOMString receiverId;
  DOMString mid;
};

dictionary RTCSctpTransportStats : RTCStats {
  unsigned long congestionWindow;
  unsigned long mtu;
  unsigned long receiverWindow;
  double smoothedRoundTripTime;
  DOMString transportId;
  unsigned long unackData;
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
  required DOMHighResTimeStamp timestamp;
  required RTCStatsType type;
  required DOMString id;
};

dictionary RTCTransportStats : RTCStats {
  required RTCDtlsTransportState dtlsState;
  unsigned long long bytesReceived;
  unsigned long long bytesSent;
  DOMString dtlsCipher;
  DOMString iceLocalUsernameFragment;
  RTCIceRole iceRole;
  RTCIceTransportState iceState;
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
  double framesPerSecond;
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
  DOMString trackId;
};

partial dictionary RTCMediaHandlerStats {
  RTCPriorityType priority;
  boolean remoteSource;
};

partial dictionary RTCOutboundRtpStreamStats {
  DOMString trackId;
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
