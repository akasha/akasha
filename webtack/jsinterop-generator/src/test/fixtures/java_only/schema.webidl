[JavaOnly]
enum OverSampleType {
  "2x",
  "4x",
  "none"
};

namespace Math1 {
  [JavaOnly]
  const double E = 2.7182818284590452354;
  const double LN10 = 2.302585092994046;
  [JavaOnly]
  unrestricted double abs( unrestricted double x );
  unrestricted double abs2( unrestricted double x );
};

[JavaOnly]
namespace Math2 {
  const double E = 2.7182818284590452354;
};

callback OnBlahEventHandler = any ( DOMString event );

[JavaOnly]
callback OnBleeEventHandler = any ( DOMString event );

callback interface EventListener1 {
  undefined handleUuid( unsigned long event );
};

[JavaOnly]
callback interface EventListener2 {
  undefined handleUuid( unsigned long event );
};

dictionary PermissionDescriptor {
  [JavaOnly]
  required DOMString name1;
  required DOMString name2;
  [JavaOnly]
  boolean userVisibleOnly1 = false;
  boolean userVisibleOnly2 = false;
};

[JavaOnly]
dictionary PushPermissionDescriptor : PermissionDescriptor {
  boolean userVisibleOnly3 = false;
};

interface EXT_disjoint_timer_query {
  [JavaOnly]
  const DOMString NAME = "EXT_disjoint_timer_query";
  const long QUERY_COUNTER_BITS_EXT = 0x8864;
  const long QUERY_RESULT_AVAILABLE_EXT = 0x8867;
  [JavaOnly]
  readonly attribute any valueA;
  readonly attribute any valueB;
  [JavaOnly]
  undefined beginQueryEXT( long target );
  undefined endQueryEXT( long target );
};

[JavaOnly]
interface MyType2 {
  const long QUERY_COUNTER_BITS_EXT = 0x8864;
  readonly attribute any valueB;
  undefined endQueryEXT( long target );
};
