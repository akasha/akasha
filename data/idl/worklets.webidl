dictionary WorkletOptions {
  RequestCredentials credentials = "same-origin";
};

[Exposed=Window]
interface Worklet {
  [NewObject]
  Promise<void> addModule( USVString moduleURL, optional WorkletOptions options = {} );
};

[Exposed=Worklet]
interface WorkletGlobalScope {
};
