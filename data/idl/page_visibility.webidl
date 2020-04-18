enum VisibilityState {
        "hidden", "visible"
      };

partial interface Document {
        readonly attribute boolean hidden;
        readonly attribute VisibilityState visibilityState;
        attribute EventHandler onvisibilitychange;
      };