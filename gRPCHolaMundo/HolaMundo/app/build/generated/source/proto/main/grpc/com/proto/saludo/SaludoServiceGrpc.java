package com.proto.saludo;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Este bloque representa el nombre del servicio "SaludoService"
 * y el nombre de la función "saludo()" que se puede llamar.
 * La función "saludo()" toma la entrada de tipo "SaludoRequest" y devuelve la salida de tipo "SaludoResponse".
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.62.2)",
    comments = "Source: holamundo.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SaludoServiceGrpc {

  private SaludoServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "SaludoService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.proto.saludo.Holamundo.SaludoRequest,
      com.proto.saludo.Holamundo.SaludoResponse> getSaludoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "saludo",
      requestType = com.proto.saludo.Holamundo.SaludoRequest.class,
      responseType = com.proto.saludo.Holamundo.SaludoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.proto.saludo.Holamundo.SaludoRequest,
      com.proto.saludo.Holamundo.SaludoResponse> getSaludoMethod() {
    io.grpc.MethodDescriptor<com.proto.saludo.Holamundo.SaludoRequest, com.proto.saludo.Holamundo.SaludoResponse> getSaludoMethod;
    if ((getSaludoMethod = SaludoServiceGrpc.getSaludoMethod) == null) {
      synchronized (SaludoServiceGrpc.class) {
        if ((getSaludoMethod = SaludoServiceGrpc.getSaludoMethod) == null) {
          SaludoServiceGrpc.getSaludoMethod = getSaludoMethod =
              io.grpc.MethodDescriptor.<com.proto.saludo.Holamundo.SaludoRequest, com.proto.saludo.Holamundo.SaludoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "saludo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.saludo.Holamundo.SaludoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.saludo.Holamundo.SaludoResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SaludoServiceMethodDescriptorSupplier("saludo"))
              .build();
        }
      }
    }
    return getSaludoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SaludoServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SaludoServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SaludoServiceStub>() {
        @java.lang.Override
        public SaludoServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SaludoServiceStub(channel, callOptions);
        }
      };
    return SaludoServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SaludoServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SaludoServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SaludoServiceBlockingStub>() {
        @java.lang.Override
        public SaludoServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SaludoServiceBlockingStub(channel, callOptions);
        }
      };
    return SaludoServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SaludoServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SaludoServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SaludoServiceFutureStub>() {
        @java.lang.Override
        public SaludoServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SaludoServiceFutureStub(channel, callOptions);
        }
      };
    return SaludoServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Este bloque representa el nombre del servicio "SaludoService"
   * y el nombre de la función "saludo()" que se puede llamar.
   * La función "saludo()" toma la entrada de tipo "SaludoRequest" y devuelve la salida de tipo "SaludoResponse".
   * </pre>
   */
  public interface AsyncService {

    /**
     */
    default void saludo(com.proto.saludo.Holamundo.SaludoRequest request,
        io.grpc.stub.StreamObserver<com.proto.saludo.Holamundo.SaludoResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSaludoMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SaludoService.
   * <pre>
   * Este bloque representa el nombre del servicio "SaludoService"
   * y el nombre de la función "saludo()" que se puede llamar.
   * La función "saludo()" toma la entrada de tipo "SaludoRequest" y devuelve la salida de tipo "SaludoResponse".
   * </pre>
   */
  public static abstract class SaludoServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return SaludoServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SaludoService.
   * <pre>
   * Este bloque representa el nombre del servicio "SaludoService"
   * y el nombre de la función "saludo()" que se puede llamar.
   * La función "saludo()" toma la entrada de tipo "SaludoRequest" y devuelve la salida de tipo "SaludoResponse".
   * </pre>
   */
  public static final class SaludoServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SaludoServiceStub> {
    private SaludoServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SaludoServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SaludoServiceStub(channel, callOptions);
    }

    /**
     */
    public void saludo(com.proto.saludo.Holamundo.SaludoRequest request,
        io.grpc.stub.StreamObserver<com.proto.saludo.Holamundo.SaludoResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSaludoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SaludoService.
   * <pre>
   * Este bloque representa el nombre del servicio "SaludoService"
   * y el nombre de la función "saludo()" que se puede llamar.
   * La función "saludo()" toma la entrada de tipo "SaludoRequest" y devuelve la salida de tipo "SaludoResponse".
   * </pre>
   */
  public static final class SaludoServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SaludoServiceBlockingStub> {
    private SaludoServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SaludoServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SaludoServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.proto.saludo.Holamundo.SaludoResponse saludo(com.proto.saludo.Holamundo.SaludoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSaludoMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SaludoService.
   * <pre>
   * Este bloque representa el nombre del servicio "SaludoService"
   * y el nombre de la función "saludo()" que se puede llamar.
   * La función "saludo()" toma la entrada de tipo "SaludoRequest" y devuelve la salida de tipo "SaludoResponse".
   * </pre>
   */
  public static final class SaludoServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SaludoServiceFutureStub> {
    private SaludoServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SaludoServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SaludoServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.saludo.Holamundo.SaludoResponse> saludo(
        com.proto.saludo.Holamundo.SaludoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSaludoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SALUDO = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SALUDO:
          serviceImpl.saludo((com.proto.saludo.Holamundo.SaludoRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.saludo.Holamundo.SaludoResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getSaludoMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.proto.saludo.Holamundo.SaludoRequest,
              com.proto.saludo.Holamundo.SaludoResponse>(
                service, METHODID_SALUDO)))
        .build();
  }

  private static abstract class SaludoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SaludoServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.proto.saludo.Holamundo.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SaludoService");
    }
  }

  private static final class SaludoServiceFileDescriptorSupplier
      extends SaludoServiceBaseDescriptorSupplier {
    SaludoServiceFileDescriptorSupplier() {}
  }

  private static final class SaludoServiceMethodDescriptorSupplier
      extends SaludoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SaludoServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (SaludoServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SaludoServiceFileDescriptorSupplier())
              .addMethod(getSaludoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
