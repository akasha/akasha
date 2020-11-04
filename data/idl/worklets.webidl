dictionary WorkletOptions {
  RequestCredentials credentials = "same-origin";
};

[Exposed=Window, SecureContext]
interface Worklet {
  [NewObject]
  Promise<undefined> addModule( USVString moduleURL, optional WorkletOptions options = {} );
};

[Exposed=Worklet, SecureContext]
interface WorkletGlobalScope {
};
