partial interface Window {
    readonly attribute short orientation;
    attribute EventHandler onorientationchange;
};

partial interface HTMLBodyElement {
    attribute EventHandler onorientationchange;
};