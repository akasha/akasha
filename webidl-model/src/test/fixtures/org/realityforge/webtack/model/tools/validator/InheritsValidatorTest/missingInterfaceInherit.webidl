interface BaseInterface {
};

interface MiddleInterface : BaseInterface {
};

interface DanglingInterface : MissingInterface {
};

interface TopInterface : MiddleInterface {
};
