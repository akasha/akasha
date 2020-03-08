package org.realityforge.webtack;

final class ExitCodes
{
  static final int SUCCESS_EXIT_CODE = 0;
  static final int ERROR_EXIT_CODE = 1;
  static final int ERROR_PARSING_ARGS_EXIT_CODE = 2;
  static final int ERROR_LOADING_CONFIG_CODE = 3;
  static final int ERROR_SAVING_CONFIG_CODE = 4;
  static final int ERROR_SOURCE_EXISTS_CODE = 5;
  static final int ERROR_BAD_SOURCE_NAME_DERIVED_CODE = 6;

  private ExitCodes()
  {
  }
}
