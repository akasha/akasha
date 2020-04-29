dictionary BaseDictionary {
};

dictionary MiddleDictionary : BaseDictionary {
};

dictionary TopDictionary : MiddleDictionary {
};

interface BaseInterface {
};

interface MiddleInterface : BaseInterface {
};

interface TopInterface : MiddleInterface {
};
