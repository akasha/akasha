package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "NodeFilter"
)
@FunctionalInterface
public interface NodeFilter {
  int FILTER_ACCEPT = 1;

  int FILTER_REJECT = 2;

  int FILTER_SKIP = 3;

  int SHOW_ALL = 0xFFFFFFFF;

  int SHOW_ATTRIBUTE = 0x2;

  int SHOW_CDATA_SECTION = 0x8;

  int SHOW_COMMENT = 0x80;

  int SHOW_DOCUMENT = 0x100;

  int SHOW_DOCUMENT_FRAGMENT = 0x400;

  int SHOW_DOCUMENT_TYPE = 0x200;

  int SHOW_ELEMENT = 0x1;

  int SHOW_ENTITY = 0x20;

  int SHOW_ENTITY_REFERENCE = 0x10;

  int SHOW_NOTATION = 0x800;

  int SHOW_PROCESSING_INSTRUCTION = 0x40;

  int SHOW_TEXT = 0x4;

  int acceptNode(@Nonnull Node node);
}
