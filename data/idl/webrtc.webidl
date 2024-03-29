enum RTCBundlePolicy {
  "balanced",
  "max-bundle",
  "max-compat"
};

enum RTCDataChannelState {
  "closed",
  "closing",
  "connecting",
  "open"
};

enum RTCDtlsTransportState {
  "closed",
  "connected",
  "connecting",
  "failed",
  "new"
};

enum RTCErrorDetailType {
  "data-channel-failure",
  "dtls-failure",
  "fingerprint-failure",
  "hardware-encoder-error",
  "hardware-encoder-not-available",
  "sctp-failure",
  "sdp-syntax-error"
};

enum RTCIceCandidateType {
  "host",
  "prflx",
  "relay",
  "srflx"
};

enum RTCIceComponent {
  "rtcp",
  "rtp"
};

enum RTCIceConnectionState {
  "checking",
  "closed",
  "completed",
  "connected",
  "disconnected",
  "failed",
  "new"
};

enum RTCIceCredentialType {
  "password"
};

enum RTCIceGathererState {
  "complete",
  "gathering",
  "new"
};

enum RTCIceGatheringState {
  "complete",
  "gathering",
  "new"
};

enum RTCIceProtocol {
  "tcp",
  "udp"
};

enum RTCIceRole {
  "controlled",
  "controlling",
  "unknown"
};

enum RTCIceTcpCandidateType {
  "active",
  "passive",
  "so"
};

enum RTCIceTransportPolicy {
  "all",
  "relay"
};

enum RTCIceTransportState {
  "checking",
  "closed",
  "completed",
  "connected",
  "disconnected",
  "failed",
  "new"
};

enum RTCPeerConnectionState {
  "closed",
  "connected",
  "connecting",
  "disconnected",
  "failed",
  "new"
};

enum RTCRtcpMuxPolicy {
  "require"
};

enum RTCRtpTransceiverDirection {
  "inactive",
  "recvonly",
  "sendonly",
  "sendrecv",
  "stopped"
};

enum RTCSctpTransportState {
  "closed",
  "connected",
  "connecting"
};

enum RTCSdpType {
  "answer",
  "offer",
  "pranswer",
  "rollback"
};

enum RTCSignalingState {
  "closed",
  "have-local-offer",
  "have-local-pranswer",
  "have-remote-offer",
  "have-remote-pranswer",
  "stable"
};

callback RTCPeerConnectionErrorCallback = undefined ( DOMException error );

callback RTCSessionDescriptionCallback = undefined ( RTCSessionDescriptionInit description );

dictionary RTCAnswerOptions : RTCOfferAnswerOptions {
};

dictionary RTCCertificateExpiration {
  [EnforceRange]
  unsigned long long expires;
};

dictionary RTCConfiguration {
  RTCBundlePolicy bundlePolicy = "balanced";
  sequence<RTCCertificate> certificates = [];
  [EnforceRange]
  octet iceCandidatePoolSize = 0;
  sequence<RTCIceServer> iceServers = [];
  RTCIceTransportPolicy iceTransportPolicy = "all";
  RTCRtcpMuxPolicy rtcpMuxPolicy = "require";
};

dictionary RTCDTMFToneChangeEventInit : EventInit {
  DOMString tone = "";
};

dictionary RTCDataChannelEventInit : EventInit {
  required RTCDataChannel channel;
};

dictionary RTCDataChannelInit {
  [EnforceRange]
  unsigned short id;
  [EnforceRange]
  unsigned short maxPacketLifeTime;
  [EnforceRange]
  unsigned short maxRetransmits;
  boolean negotiated = false;
  boolean ordered = true;
  USVString protocol = "";
};

dictionary RTCDtlsFingerprint {
  DOMString algorithm;
  DOMString value;
};

dictionary RTCErrorEventInit : EventInit {
  required RTCError error;
};

dictionary RTCErrorInit {
  required RTCErrorDetailType errorDetail;
  unsigned long receivedAlert;
  long sctpCauseCode;
  long sdpLineNumber;
  unsigned long sentAlert;
};

dictionary RTCIceCandidateInit {
  DOMString candidate = "";
  unsigned short? sdpMLineIndex = null;
  DOMString? sdpMid = null;
  DOMString? usernameFragment = null;
};

dictionary RTCIceCandidatePair {
  RTCIceCandidate local;
  RTCIceCandidate remote;
};

dictionary RTCIceParameters {
  DOMString password;
  DOMString usernameFragment;
};

dictionary RTCIceServer {
  required ( DOMString or sequence<DOMString> ) urls;
  DOMString credential;
  RTCIceCredentialType credentialType = "password";
  DOMString username;
};

dictionary RTCLocalSessionDescriptionInit {
  DOMString sdp = "";
  RTCSdpType type;
};

dictionary RTCOfferAnswerOptions {
};

dictionary RTCOfferOptions : RTCOfferAnswerOptions {
  boolean iceRestart = false;
};

dictionary RTCPeerConnectionIceErrorEventInit : EventInit {
  required unsigned short errorCode;
  DOMString? address;
  USVString errorText;
  unsigned short? port;
  DOMString url;
};

dictionary RTCPeerConnectionIceEventInit : EventInit {
  RTCIceCandidate? candidate;
  DOMString? url;
};

dictionary RTCRtcpParameters {
  DOMString cname;
  boolean reducedSize;
};

dictionary RTCRtpCapabilities {
  required sequence<RTCRtpCodecCapability> codecs;
  required sequence<RTCRtpHeaderExtensionCapability> headerExtensions;
};

dictionary RTCRtpCodecCapability {
  required DOMString mimeType;
  required unsigned long clockRate;
  unsigned short channels;
  DOMString sdpFmtpLine;
};

dictionary RTCRtpCodecParameters {
  required octet payloadType;
  required DOMString mimeType;
  required unsigned long clockRate;
  unsigned short channels;
  DOMString sdpFmtpLine;
};

dictionary RTCRtpCodingParameters {
  DOMString rid;
};

dictionary RTCRtpContributingSource {
  required DOMHighResTimeStamp timestamp;
  required unsigned long source;
  required unsigned long rtpTimestamp;
  double audioLevel;
};

dictionary RTCRtpDecodingParameters : RTCRtpCodingParameters {
};

dictionary RTCRtpEncodingParameters : RTCRtpCodingParameters {
  boolean active = true;
  unsigned long maxBitrate;
  double scaleResolutionDownBy;
};

dictionary RTCRtpHeaderExtensionCapability {
  DOMString uri;
};

dictionary RTCRtpHeaderExtensionParameters {
  required DOMString uri;
  required unsigned short id;
  boolean encrypted = false;
};

dictionary RTCRtpParameters {
  required sequence<RTCRtpHeaderExtensionParameters> headerExtensions;
  required RTCRtcpParameters rtcp;
  required sequence<RTCRtpCodecParameters> codecs;
};

dictionary RTCRtpReceiveParameters : RTCRtpParameters {
};

dictionary RTCRtpSendParameters : RTCRtpParameters {
  required DOMString transactionId;
  required sequence<RTCRtpEncodingParameters> encodings;
};

dictionary RTCRtpSynchronizationSource : RTCRtpContributingSource {
};

dictionary RTCRtpTransceiverInit {
  RTCRtpTransceiverDirection direction = "sendrecv";
  sequence<RTCRtpEncodingParameters> sendEncodings = [];
  sequence<MediaStream> streams = [];
};

dictionary RTCSessionDescriptionInit {
  required RTCSdpType type;
  DOMString sdp = "";
};

dictionary RTCStats {
  required DOMHighResTimeStamp timestamp;
  required RTCStatsType type;
  required DOMString id;
};

dictionary RTCTrackEventInit : EventInit {
  required RTCRtpReceiver receiver;
  required MediaStreamTrack track;
  required RTCRtpTransceiver transceiver;
  sequence<MediaStream> streams = [];
};

partial dictionary RTCOfferOptions {
  boolean offerToReceiveAudio;
  boolean offerToReceiveVideo;
};

[Exposed=Window, Serializable]
interface RTCCertificate {
  readonly attribute EpochTimeStamp expires;
  sequence<RTCDtlsFingerprint> getFingerprints();
};

[Exposed=Window]
interface RTCDTMFSender : EventTarget {
  readonly attribute boolean canInsertDTMF;
  readonly attribute DOMString toneBuffer;
  attribute EventHandler ontonechange;
  undefined insertDTMF( DOMString tones, optional unsigned long duration = 100, optional unsigned long interToneGap = 70 );
};

[Exposed=Window]
interface RTCDTMFToneChangeEvent : Event {
  readonly attribute DOMString tone;
  constructor( DOMString type, optional RTCDTMFToneChangeEventInit eventInitDict = {} );
};

[Exposed=Window]
interface RTCDataChannel : EventTarget {
  readonly attribute unsigned long bufferedAmount;
  readonly attribute unsigned short? id;
  readonly attribute USVString label;
  readonly attribute unsigned short? maxPacketLifeTime;
  readonly attribute unsigned short? maxRetransmits;
  readonly attribute boolean negotiated;
  readonly attribute boolean ordered;
  readonly attribute USVString protocol;
  readonly attribute RTCDataChannelState readyState;
  attribute BinaryType binaryType;
  [EnforceRange]
  attribute unsigned long bufferedAmountLowThreshold;
  attribute EventHandler onbufferedamountlow;
  attribute EventHandler onclose;
  attribute EventHandler onclosing;
  attribute EventHandler onerror;
  attribute EventHandler onmessage;
  attribute EventHandler onopen;
  undefined close();
  undefined send( USVString data );
  undefined send( Blob data );
  undefined send( ArrayBuffer data );
  undefined send( ArrayBufferView data );
};

[Exposed=Window]
interface RTCDataChannelEvent : Event {
  readonly attribute RTCDataChannel channel;
  constructor( DOMString type, RTCDataChannelEventInit eventInitDict );
};

[Exposed=Window]
interface RTCDtlsTransport : EventTarget {
  [SameObject]
  readonly attribute RTCIceTransport iceTransport;
  readonly attribute RTCDtlsTransportState state;
  attribute EventHandler onerror;
  attribute EventHandler onstatechange;
  sequence<ArrayBuffer> getRemoteCertificates();
};

[Exposed=Window]
interface RTCError : DOMException {
  readonly attribute RTCErrorDetailType errorDetail;
  readonly attribute unsigned long? receivedAlert;
  readonly attribute long? sctpCauseCode;
  readonly attribute long? sdpLineNumber;
  readonly attribute unsigned long? sentAlert;
  constructor( RTCErrorInit init, optional DOMString message = "" );
};

[Exposed=Window]
interface RTCErrorEvent : Event {
  [SameObject]
  readonly attribute RTCError error;
  constructor( DOMString type, RTCErrorEventInit eventInitDict );
};

[Exposed=Window]
interface RTCIceCandidate {
  readonly attribute DOMString? address;
  readonly attribute DOMString candidate;
  readonly attribute RTCIceComponent? component;
  readonly attribute DOMString? foundation;
  readonly attribute unsigned short? port;
  readonly attribute unsigned long? priority;
  readonly attribute RTCIceProtocol? protocol;
  readonly attribute DOMString? relatedAddress;
  readonly attribute unsigned short? relatedPort;
  readonly attribute unsigned short? sdpMLineIndex;
  readonly attribute DOMString? sdpMid;
  readonly attribute RTCIceTcpCandidateType? tcpType;
  readonly attribute RTCIceCandidateType? type;
  readonly attribute DOMString? usernameFragment;
  constructor( optional RTCIceCandidateInit candidateInitDict = {} );
  RTCIceCandidateInit toJSON();
};

[Exposed=Window]
interface RTCIceTransport : EventTarget {
  readonly attribute RTCIceComponent component;
  readonly attribute RTCIceGathererState gatheringState;
  readonly attribute RTCIceRole role;
  readonly attribute RTCIceTransportState state;
  attribute EventHandler ongatheringstatechange;
  attribute EventHandler onselectedcandidatepairchange;
  attribute EventHandler onstatechange;
  sequence<RTCIceCandidate> getLocalCandidates();
  RTCIceParameters? getLocalParameters();
  sequence<RTCIceCandidate> getRemoteCandidates();
  RTCIceParameters? getRemoteParameters();
  RTCIceCandidatePair? getSelectedCandidatePair();
};

[Exposed=Window]
interface RTCPeerConnection : EventTarget {
  readonly attribute boolean? canTrickleIceCandidates;
  readonly attribute RTCPeerConnectionState connectionState;
  readonly attribute RTCSessionDescription? currentLocalDescription;
  readonly attribute RTCSessionDescription? currentRemoteDescription;
  readonly attribute RTCIceConnectionState iceConnectionState;
  readonly attribute RTCIceGatheringState iceGatheringState;
  readonly attribute RTCSessionDescription? localDescription;
  readonly attribute RTCSessionDescription? pendingLocalDescription;
  readonly attribute RTCSessionDescription? pendingRemoteDescription;
  readonly attribute RTCSessionDescription? remoteDescription;
  readonly attribute RTCSignalingState signalingState;
  attribute EventHandler onconnectionstatechange;
  attribute EventHandler onicecandidate;
  attribute EventHandler onicecandidateerror;
  attribute EventHandler oniceconnectionstatechange;
  attribute EventHandler onicegatheringstatechange;
  attribute EventHandler onnegotiationneeded;
  attribute EventHandler onsignalingstatechange;
  constructor( optional RTCConfiguration configuration = {} );
  Promise<undefined> addIceCandidate( optional RTCIceCandidateInit candidate = {} );
  Promise<undefined> addIceCandidate( RTCIceCandidateInit candidate, VoidFunction successCallback, RTCPeerConnectionErrorCallback failureCallback );
  undefined close();
  Promise<RTCSessionDescriptionInit> createAnswer( optional RTCAnswerOptions options = {} );
  Promise<undefined> createAnswer( RTCSessionDescriptionCallback successCallback, RTCPeerConnectionErrorCallback failureCallback );
  Promise<RTCSessionDescriptionInit> createOffer( optional RTCOfferOptions options = {} );
  Promise<undefined> createOffer( RTCSessionDescriptionCallback successCallback, RTCPeerConnectionErrorCallback failureCallback, optional RTCOfferOptions options = {} );
  RTCConfiguration getConfiguration();
  undefined restartIce();
  undefined setConfiguration( optional RTCConfiguration configuration = {} );
  Promise<undefined> setLocalDescription( optional RTCLocalSessionDescriptionInit description = {} );
  Promise<undefined> setLocalDescription( RTCLocalSessionDescriptionInit description, VoidFunction successCallback, RTCPeerConnectionErrorCallback failureCallback );
  Promise<undefined> setRemoteDescription( RTCSessionDescriptionInit description );
  Promise<undefined> setRemoteDescription( RTCSessionDescriptionInit description, VoidFunction successCallback, RTCPeerConnectionErrorCallback failureCallback );
};

[Exposed=Window]
interface RTCPeerConnectionIceErrorEvent : Event {
  readonly attribute DOMString? address;
  readonly attribute unsigned short errorCode;
  readonly attribute USVString errorText;
  readonly attribute unsigned short? port;
  readonly attribute DOMString url;
  constructor( DOMString type, RTCPeerConnectionIceErrorEventInit eventInitDict );
};

[Exposed=Window]
interface RTCPeerConnectionIceEvent : Event {
  readonly attribute RTCIceCandidate? candidate;
  readonly attribute DOMString? url;
  constructor( DOMString type, optional RTCPeerConnectionIceEventInit eventInitDict = {} );
};

[Exposed=Window]
interface RTCRtpReceiver {
  readonly attribute MediaStreamTrack track;
  readonly attribute RTCDtlsTransport? transport;
  static RTCRtpCapabilities? getCapabilities( DOMString kind );
  sequence<RTCRtpContributingSource> getContributingSources();
  RTCRtpReceiveParameters getParameters();
  Promise<RTCStatsReport> getStats();
  sequence<RTCRtpSynchronizationSource> getSynchronizationSources();
};

[Exposed=Window]
interface RTCRtpSender {
  readonly attribute MediaStreamTrack? track;
  readonly attribute RTCDtlsTransport? transport;
  static RTCRtpCapabilities? getCapabilities( DOMString kind );
  RTCRtpSendParameters getParameters();
  Promise<RTCStatsReport> getStats();
  Promise<undefined> replaceTrack( MediaStreamTrack? withTrack );
  Promise<undefined> setParameters( RTCRtpSendParameters parameters );
  undefined setStreams( MediaStream... streams );
};

[Exposed=Window]
interface RTCRtpTransceiver {
  readonly attribute RTCRtpTransceiverDirection? currentDirection;
  readonly attribute DOMString? mid;
  [SameObject]
  readonly attribute RTCRtpReceiver receiver;
  [SameObject]
  readonly attribute RTCRtpSender sender;
  attribute RTCRtpTransceiverDirection direction;
  undefined setCodecPreferences( sequence<RTCRtpCodecCapability> codecs );
  undefined stop();
};

[Exposed=Window]
interface RTCSctpTransport : EventTarget {
  readonly attribute unsigned short? maxChannels;
  readonly attribute unrestricted double maxMessageSize;
  readonly attribute RTCSctpTransportState state;
  readonly attribute RTCDtlsTransport transport;
  attribute EventHandler onstatechange;
};

[Exposed=Window]
interface RTCSessionDescription {
  readonly attribute DOMString sdp;
  readonly attribute RTCSdpType type;
  constructor( RTCSessionDescriptionInit descriptionInitDict );
  [Default]
  object toJSON();
};

[Exposed=Window]
interface RTCStatsReport {
  readonly maplike<DOMString, object>;
};

[Exposed=Window]
interface RTCTrackEvent : Event {
  readonly attribute RTCRtpReceiver receiver;
  [SameObject]
  readonly attribute FrozenArray<MediaStream> streams;
  readonly attribute MediaStreamTrack track;
  readonly attribute RTCRtpTransceiver transceiver;
  constructor( DOMString type, RTCTrackEventInit eventInitDict );
};

partial interface RTCPeerConnection {
  static Promise<RTCCertificate> generateCertificate( AlgorithmIdentifier keygenAlgorithm );
};

partial interface RTCPeerConnection {
  attribute EventHandler ontrack;
  RTCRtpSender addTrack( MediaStreamTrack track, MediaStream... streams );
  RTCRtpTransceiver addTransceiver( ( MediaStreamTrack or DOMString ) trackOrKind, optional RTCRtpTransceiverInit init = {} );
  sequence<RTCRtpReceiver> getReceivers();
  sequence<RTCRtpSender> getSenders();
  sequence<RTCRtpTransceiver> getTransceivers();
  undefined removeTrack( RTCRtpSender sender );
};

partial interface RTCPeerConnection {
  readonly attribute RTCSctpTransport? sctp;
  attribute EventHandler ondatachannel;
  RTCDataChannel createDataChannel( USVString label, optional RTCDataChannelInit dataChannelDict = {} );
};

partial interface RTCPeerConnection {
  Promise<RTCStatsReport> getStats( optional MediaStreamTrack? selector = null );
};

partial interface RTCRtpSender {
  readonly attribute RTCDTMFSender? dtmf;
};
