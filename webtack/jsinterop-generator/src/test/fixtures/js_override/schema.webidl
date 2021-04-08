interface AudioBufferSourceNode : AudioScheduledSourceNode {
  undefined start( optional double when = 0, optional double offset, optional double duration );
};

interface AudioScheduledSourceNode {
  undefined start( optional double when = 0 );
  undefined stop( optional double when = 0 );
};

interface DOMMatrix : DOMMatrixReadOnly {
  static DOMMatrix fromMatrix( optional object other );
};

interface DOMMatrixReadOnly {
  static DOMMatrixReadOnly fromMatrix( optional object other );
};
