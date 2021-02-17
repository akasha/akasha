[NoInterfaceObject]
interface OCULUS_multiview {
  const GLenum FRAMEBUFFER_ATTACHMENT_TEXTURE_BASE_VIEW_INDEX_OVR = 0x9632;
  const GLenum FRAMEBUFFER_ATTACHMENT_TEXTURE_NUM_VIEWS_OVR = 0x9630;
  const GLenum FRAMEBUFFER_INCOMPLETE_VIEW_TARGETS_OVR = 0x9633;
  const GLenum MAX_VIEWS_OVR = 0x9631;
  undefined framebufferTextureMultiviewOVR( GLenum target, GLenum attachment, WebGLTexture? texture, GLint level, GLint baseViewIndex, GLsizei numViews );
  undefined framebufferTextureMultisampleMultiviewOVR(GLenum target, GLenum attachment, WebGLTexture? texture, GLint level, GLsizei samples, GLint baseViewIndex, GLsizei numViews);
};
