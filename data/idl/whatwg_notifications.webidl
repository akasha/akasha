enum NotificationDirection {
  "auto",
  "ltr",
  "rtl"
};

enum NotificationPermission {
  "default",
  "denied",
  "granted"
};

callback NotificationPermissionCallback = void ( NotificationPermission permission );

dictionary NotificationOptions {
  sequence<NotificationAction> actions = [];
  USVString badge;
  DOMString body = "";
  any data = null;
  NotificationDirection dir = "auto";
  USVString icon;
  USVString image;
  DOMString lang = "";
  boolean renotify = false;
  boolean requireInteraction = false;
  boolean silent = false;
  DOMString tag = "";
  DOMTimeStamp timestamp;
  VibratePattern vibrate;
};

dictionary NotificationAction {
  required DOMString action;
  USVString icon;
  required DOMString title;
};

dictionary GetNotificationOptions {
  DOMString tag = "";
};

dictionary NotificationEventInit : ExtendableEventInit {
  DOMString action = "";
  required Notification notification;
};

[Exposed=ServiceWorker]
interface NotificationEvent : ExtendableEvent {
  readonly attribute DOMString action;
  readonly attribute Notification notification;
  constructor( DOMString type, NotificationEventInit eventInitDict );
};

[Exposed=(Window,Worker)]
interface Notification : EventTarget {
  static readonly attribute unsigned long maxActions;
  static readonly attribute NotificationPermission permission;
  [SameObject]
  readonly attribute FrozenArray<NotificationAction> actions;
  readonly attribute USVString badge;
  readonly attribute DOMString body;
  [SameObject]
  readonly attribute any data;
  readonly attribute NotificationDirection dir;
  readonly attribute USVString icon;
  readonly attribute USVString image;
  readonly attribute DOMString lang;
  readonly attribute boolean renotify;
  readonly attribute boolean requireInteraction;
  readonly attribute boolean silent;
  readonly attribute DOMString tag;
  readonly attribute DOMTimeStamp timestamp;
  readonly attribute DOMString title;
  [SameObject]
  readonly attribute FrozenArray<unsigned long> vibrate;
  attribute EventHandler onclick;
  attribute EventHandler onclose;
  attribute EventHandler onerror;
  attribute EventHandler onshow;
  [Exposed=Window]
  static Promise<NotificationPermission> requestPermission( optional NotificationPermissionCallback deprecatedCallback );
  constructor( DOMString title, optional NotificationOptions options = {} );
  void close();
};

partial interface ServiceWorkerRegistration {
  Promise<sequence<Notification>> getNotifications( optional GetNotificationOptions filter = {} );
  Promise<void> showNotification( DOMString title, optional NotificationOptions options = {} );
};

partial interface ServiceWorkerGlobalScope {
  attribute EventHandler onnotificationclick;
  attribute EventHandler onnotificationclose;
};
