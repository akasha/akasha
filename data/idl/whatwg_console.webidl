[Exposed=(Window,Worker,Worklet)]
namespace console {
  undefined assert( optional boolean condition = false, any... data );
  undefined clear();
  undefined count( optional DOMString label = "default" );
  undefined countReset( optional DOMString label = "default" );
  undefined debug( any... data );
  undefined dir( optional any item, optional object? options );
  undefined dirxml( any... data );
  undefined error( any... data );
  undefined group( any... data );
  undefined groupCollapsed( any... data );
  undefined groupEnd();
  undefined info( any... data );
  undefined log( any... data );
  undefined table( optional any tabularData, optional sequence<DOMString> properties );
  undefined time( optional DOMString label = "default" );
  undefined timeEnd( optional DOMString label = "default" );
  undefined timeLog( optional DOMString label = "default", any... data );
  undefined trace( any... data );
  undefined warn( any... data );
};
