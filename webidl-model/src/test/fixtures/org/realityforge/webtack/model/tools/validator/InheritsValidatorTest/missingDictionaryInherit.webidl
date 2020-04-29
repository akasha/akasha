dictionary BaseDictionary {
};

dictionary MiddleDictionary : BaseDictionary {
};

dictionary DanglingDictionary : MissingDictionary {
};

dictionary TopDictionary : MiddleDictionary {
};
