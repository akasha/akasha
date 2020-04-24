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
  static final int ERROR_SOURCE_DOES_NOT_EXIST_CODE = 7;
  static final int ERROR_SOURCE_FETCH_FAILED_CODE = 8;
  static final int ERROR_EXTRACT_IDL_FAILED_CODE = 9;
  static final int ERROR_SOURCE_NOT_FETCHED_CODE = 10;
  static final int ERROR_IDL_NOT_VALID_CODE = 11;
  static final int ERROR_SAVING_IDL_CODE = 12;
  static final int ERROR_REMOVING_EXISTING_IDL_CODE = 13;
  static final int ERROR_REMOVING_SOURCE_CODE = 14;

  private ExitCodes()
  {
  }
}
