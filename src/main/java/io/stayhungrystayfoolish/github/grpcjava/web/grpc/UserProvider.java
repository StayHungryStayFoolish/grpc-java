package io.stayhungrystayfoolish.github.grpcjava.web.grpc;

import io.grpc.stub.StreamObserver;
import io.stayhungrystayfoolish.github.grpcjava.domain.User;
import io.stayhungrystayfoolish.github.grpcjava.grpc.UserProviderGrpc;
import io.stayhungrystayfoolish.github.grpcjava.grpc.UserProviderOuterClass;
import net.badata.protobuf.converter.Converter;
import net.devh.springboot.autoconfigure.grpc.server.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 */
@GrpcService(UserProviderGrpc.class)
public class UserProvider extends UserProviderGrpc.UserProviderImplBase {

    private final Logger logger = LoggerFactory.getLogger(UserProvider.class);

    @Override
    public void getByUserId(UserProviderOuterClass.UserIdRequest request, StreamObserver<UserProviderOuterClass.UserVoReplay> responseObserver) {

        long userId = request.getId();

        logger.debug("GO GRPC User Id : {}", userId);

//        UserProviderOuterClass.UserVoReplay.Builder userVoReplay = UserProviderOuterClass.UserVoReplay.newBuilder();

        if (0 == userId) {
            userId = 1L;
        }


        User user = new User();
        user.setId(1L);
        user.setEmail("bonismo@hotmail.com");
        user.setName("Li Chao Nan");


        // construct return data
//        userVoReplay.setId(userId);
//        userVoReplay.setUsername("Zhang San");

        UserProviderOuterClass.UserVoReplay userProto = Converter.create().toProtobuf(UserProviderOuterClass.UserVoReplay.class, user);


        UserProviderOuterClass.UserVoReplay voReplay = userProto.toBuilder().build();

        logger.debug("VoReplay : {}", voReplay.toString());

        // response
        responseObserver.onNext(voReplay);
        responseObserver.onCompleted();

    }
}
