// It should be noted that we are deliberately ignoring the operations (i.e. abs(), asin(), asin(), ...)
// that can accept strings under the assumption that java code should not be implementing such features

[JavaName=JsMath]
namespace Math {
  // These constants are approximations and change based on platform. So we need to lookup these values at runtime

  [JavaNoInline]
  const double E = 2.7182818284590452354;
  [JavaNoInline]
  const double LN10 = 2.302585092994046;
  [JavaNoInline]
  const double LN2 = 0.6931471805599453;
  [JavaNoInline]
  const double LOG10E = 0.4342944819032518;
  [JavaNoInline]
  const double LOG2E = 1.4426950408889634;
  [JavaNoInline]
  const double PI = 3.1415926535897932;
  [JavaNoInline]
  const double SQRT1_2 = 0.7071067811865476;
  [JavaNoInline]
  const double SQRT2 = 1.4142135623730951;

  unrestricted double abs( unrestricted double x );
  unrestricted double acos( unrestricted double x );
  unrestricted double acosh( unrestricted double x );
  unrestricted double asin( unrestricted double x );
  unrestricted double asinh( unrestricted double x );
  unrestricted double atan( unrestricted double x );
  unrestricted double atan2( unrestricted double y, double x );
  unrestricted double atanh( unrestricted double x );
  unrestricted double cbrt( unrestricted double x );
  long ceil( unrestricted double x );
  long clz32( long x );
  unrestricted double cos( unrestricted double x );
  unrestricted double cosh( unrestricted double x );
  unrestricted double exp( unrestricted double x );
  unrestricted double expm1( unrestricted double x );
  long floor( unrestricted double x );
  unrestricted float fround( unrestricted double x );
  unrestricted double hypot( unrestricted double... value );
  unrestricted double imul( unrestricted double... value );
  unsigned long imul(unsigned long value1, unsigned long value2);
  unrestricted double log( unrestricted double x );
  unrestricted double log10( unrestricted double x );
  unrestricted double log1p( unrestricted double x );
  unrestricted double log2( unrestricted double x );
  unrestricted double max( unrestricted double... values );
  unrestricted double min( unrestricted double... values );
  unrestricted double pow( unrestricted double x, unrestricted double y );
  unrestricted double random();
  long round( unrestricted double x );
  unrestricted double sign( unrestricted double x );
  unrestricted double sin( unrestricted double x );
  unrestricted double sinh( unrestricted double x );
  unrestricted double sqrt( unrestricted double x );
  unrestricted double tan( unrestricted double x );
  unrestricted double tanh( unrestricted double x );
  long trunc( unrestricted double x );
};
