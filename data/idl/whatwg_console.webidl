[Exposed=(Window,Worker,Worklet)]
namespace console {
  void assert( optional boolean condition = false, any... data );
  void clear();
  void count( optional DOMString label = "default" );
  void countReset( optional DOMString label = "default" );
  void debug( any... data );
  void dir( optional any item, optional object? options );
  void dirxml( any... data );
  void error( any... data );
  void group( any... data );
  void groupCollapsed( any... data );
  void groupEnd();
  void info( any... data );
  void log( any... data );
  void table( optional any tabularData, optional sequence<DOMString> properties );
  void time( optional DOMString label = "default" );
  void timeEnd( optional DOMString label = "default" );
  void timeLog( optional DOMString label = "default", any... data );
  void trace( any... data );
  void warn( any... data );
};
