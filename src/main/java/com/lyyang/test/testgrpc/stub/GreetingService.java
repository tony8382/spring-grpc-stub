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

    public String sayHello(String name) {
        GreeterProto.HelloReply reply = greeterStub.sayHello(GreeterProto.HelloRequest.newBuilder().setName(name).build());
        return reply.getMessage();
    }
    public String sayHelloAdmin(String name) {
        GreeterProto.HelloReply reply = greeterStub.sayHelloAdmin(GreeterProto.HelloRequest.newBuilder().setName(name).build());
        return reply.getMessage();
    }

    public String auth(String username, String password) {
        GreeterProto.AuthReply reply = greeterStub.authenticate(GreeterProto.AuthRequest.newBuilder().setUsername(username).setPassword(password).build());

        return reply.getToken();
    }
}
