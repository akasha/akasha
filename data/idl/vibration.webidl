typedef (unsigned long or sequence<unsigned long>) VibratePattern;

partial interface Navigator {
    boolean vibrate(VibratePattern pattern);
};