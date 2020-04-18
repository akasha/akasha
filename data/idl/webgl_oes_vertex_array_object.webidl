[NoInterfaceObject]
interface WebGLVertexArrayObjectOES : WebGLObject {
};

[NoInterfaceObject]
interface OES_vertex_array_object {
    const GLenum VERTEX_ARRAY_BINDING_OES = 0x85B5;

    WebGLVertexArrayObjectOES? createVertexArrayOES();
    void deleteVertexArrayOES(WebGLVertexArrayObjectOES? arrayObject);
    [WebGLHandlesContextLoss] GLboolean isVertexArrayOES(WebGLVertexArrayObjectOES? arrayObject);
    void bindVertexArrayOES(WebGLVertexArrayObjectOES? arrayObject);
};