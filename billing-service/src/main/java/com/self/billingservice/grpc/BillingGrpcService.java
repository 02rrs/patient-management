package com.self.billingservice.grpc;

import billing.BillingRequest;
import billing.BillingResponse;
import billing.BillingServiceGrpc.BillingServiceImplBase;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
public class BillingGrpcService extends BillingServiceImplBase {

    private static final Logger log = LoggerFactory.getLogger(BillingGrpcService.class);

    @Override
    public void createBillingAccount(BillingRequest request, StreamObserver<BillingResponse> responseObserver) {
        // 1. Log the incoming request to the console so we can see it working
        log.info("Create billing account request received: {}", request.toString());

        // 2. Add your Business Logic here in the real world (e.g., save to database)

        // 3. Build the response object using the auto-generated Builder
        BillingResponse response = BillingResponse.newBuilder()
                .setAccountId("ACC-998877") // Hardcoded dummy ID for now
                .setStatus("ACTIVE")
                .build();

        // 4. Send the response back to the client
        responseObserver.onNext(response);

        // 5. Tell the client we are finished
        responseObserver.onCompleted();
    }

}
