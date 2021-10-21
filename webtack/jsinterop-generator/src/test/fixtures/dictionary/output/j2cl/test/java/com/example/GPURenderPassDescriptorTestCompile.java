package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class GPURenderPassDescriptorTestCompile {
  static GPURenderPassDescriptor $typeReference$;

  public static GPURenderPassDescriptor.Builder colorAttachments(
      final JsArray<GPURenderPassColorAttachment> colorAttachments) {
    return GPURenderPassDescriptor.colorAttachments( colorAttachments );
  }

  public static GPURenderPassDescriptor.Builder colorAttachments(
      final GPURenderPassColorAttachment[] colorAttachments) {
    return GPURenderPassDescriptor.colorAttachments( colorAttachments );
  }

  public static JsArray<GPURenderPassColorAttachment> colorAttachments(
      final GPURenderPassDescriptor $instance) {
    return $instance.colorAttachments();
  }

  public static void setColorAttachments(final GPURenderPassDescriptor $instance,
      JsArray<GPURenderPassColorAttachment> colorAttachments) {
    $instance.setColorAttachments( colorAttachments );
  }

  public static void setColorAttachments(final GPURenderPassDescriptor $instance,
      final GPURenderPassColorAttachment[] colorAttachments) {
    $instance.setColorAttachments( colorAttachments );
  }

  public static GPUQuerySet occlusionQuerySet(final GPURenderPassDescriptor $instance) {
    return $instance.occlusionQuerySet();
  }

  public static void setOcclusionQuerySet(final GPURenderPassDescriptor $instance,
      GPUQuerySet occlusionQuerySet) {
    $instance.setOcclusionQuerySet( occlusionQuerySet );
  }

  public static GPURenderPassDescriptor.Builder occlusionQuerySet(
      final GPURenderPassDescriptor.Builder $instance, final GPUQuerySet occlusionQuerySet) {
    return $instance.occlusionQuerySet( occlusionQuerySet );
  }
}
