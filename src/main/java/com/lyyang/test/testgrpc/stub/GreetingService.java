package com.lyyang.test.testgrpc.stub;

import com.lyyang.test.testgrpc.model.GreeterGrpc;
import com.lyyang.test.testgrpc.model.GreeterProto;
import com.lyyang.test.testgrpc.model.Hello;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    @GrpcClient("local-grpc-server")
    private GreeterGrpc.GreeterBlockingStub greeterStub;

    public Hello sayHello(String name) {
        GreeterProto.HelloReply reply = greeterStub.sayHello(GreeterProto.HelloRequest.newBuilder().setName(name).build());
        return Hello.builder().message(reply.getMessage()).build();
    }
}
