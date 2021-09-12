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

callback NotificationPermissionCallback = undefined ( NotificationPermission permission );

dictionary GetNotificationOptions {
  DOMString tag = "";
};

dictionary NotificationAction {
  required DOMString action;
  required DOMString title;
  USVString icon;
};

dictionary NotificationEventInit : ExtendableEventInit {
  required Notification notification;
  DOMString action = "";
};

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
  undefined close();
};

[Exposed=ServiceWorker]
interface NotificationEvent : ExtendableEvent {
  readonly attribute DOMString action;
  readonly attribute Notification notification;
  constructor( DOMString type, NotificationEventInit eventInitDict );
};

partial interface ServiceWorkerGlobalScope {
  attribute EventHandler onnotificationclick;
  attribute EventHandler onnotificationclose;
};

partial interface ServiceWorkerRegistration {
  Promise<sequence<Notification>> getNotifications( optional GetNotificationOptions filter = {} );
  Promise<undefined> showNotification( DOMString title, optional NotificationOptions options = {} );
};
