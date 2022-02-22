package kr.co.eda.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.35.0)",
    comments = "Source: helloworld.proto")
public final class LogGrpc {

  private LogGrpc() {}

  public static final String SERVICE_NAME = "Log";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<kr.co.eda.grpc.LogRequest,
      kr.co.eda.grpc.LogReply> getSendMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Send",
      requestType = kr.co.eda.grpc.LogRequest.class,
      responseType = kr.co.eda.grpc.LogReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<kr.co.eda.grpc.LogRequest,
      kr.co.eda.grpc.LogReply> getSendMethod() {
    io.grpc.MethodDescriptor<kr.co.eda.grpc.LogRequest, kr.co.eda.grpc.LogReply> getSendMethod;
    if ((getSendMethod = LogGrpc.getSendMethod) == null) {
      synchronized (LogGrpc.class) {
        if ((getSendMethod = LogGrpc.getSendMethod) == null) {
          LogGrpc.getSendMethod = getSendMethod =
              io.grpc.MethodDescriptor.<kr.co.eda.grpc.LogRequest, kr.co.eda.grpc.LogReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Send"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  kr.co.eda.grpc.LogRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  kr.co.eda.grpc.LogReply.getDefaultInstance()))
              .setSchemaDescriptor(new LogMethodDescriptorSupplier("Send"))
              .build();
        }
      }
    }
    return getSendMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LogStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LogStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LogStub>() {
        @java.lang.Override
        public LogStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LogStub(channel, callOptions);
        }
      };
    return LogStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LogBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LogBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LogBlockingStub>() {
        @java.lang.Override
        public LogBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LogBlockingStub(channel, callOptions);
        }
      };
    return LogBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LogFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LogFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LogFutureStub>() {
        @java.lang.Override
        public LogFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LogFutureStub(channel, callOptions);
        }
      };
    return LogFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class LogImplBase implements io.grpc.BindableService {

    /**
     */
    public void send(kr.co.eda.grpc.LogRequest request,
        io.grpc.stub.StreamObserver<kr.co.eda.grpc.LogReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                kr.co.eda.grpc.LogRequest,
                kr.co.eda.grpc.LogReply>(
                  this, METHODID_SEND)))
          .build();
    }
  }

  /**
   */
  public static final class LogStub extends io.grpc.stub.AbstractAsyncStub<LogStub> {
    private LogStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LogStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LogStub(channel, callOptions);
    }

    /**
     */
    public void send(kr.co.eda.grpc.LogRequest request,
        io.grpc.stub.StreamObserver<kr.co.eda.grpc.LogReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class LogBlockingStub extends io.grpc.stub.AbstractBlockingStub<LogBlockingStub> {
    private LogBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LogBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LogBlockingStub(channel, callOptions);
    }

    /**
     */
    public kr.co.eda.grpc.LogReply send(kr.co.eda.grpc.LogRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class LogFutureStub extends io.grpc.stub.AbstractFutureStub<LogFutureStub> {
    private LogFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LogFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LogFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<kr.co.eda.grpc.LogReply> send(
        kr.co.eda.grpc.LogRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LogImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LogImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND:
          serviceImpl.send((kr.co.eda.grpc.LogRequest) request,
              (io.grpc.stub.StreamObserver<kr.co.eda.grpc.LogReply>) responseObserver);
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

  private static abstract class LogBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LogBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return kr.co.eda.grpc.LogProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Log");
    }
  }

  private static final class LogFileDescriptorSupplier
      extends LogBaseDescriptorSupplier {
    LogFileDescriptorSupplier() {}
  }

  private static final class LogMethodDescriptorSupplier
      extends LogBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LogMethodDescriptorSupplier(String methodName) {
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
      synchronized (LogGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LogFileDescriptorSupplier())
              .addMethod(getSendMethod())
              .build();
        }
      }
    }
    return result;
  }
}
