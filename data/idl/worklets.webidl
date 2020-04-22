dictionary WorkletOptions {
  RequestCredentials credentials = "same-origin";
};

[Exposed=Worklet]
interface WorkletGlobalScope {
};

[Exposed=Window]
interface Worklet {
  [NewObject]
  Promise<void> addModule( USVString moduleURL, optional WorkletOptions options = {} );
};
