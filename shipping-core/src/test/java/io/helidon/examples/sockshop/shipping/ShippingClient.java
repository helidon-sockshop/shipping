package io.helidon.examples.sockshop.shipping;

import io.helidon.microprofile.grpc.core.GrpcMarshaller;
import io.helidon.microprofile.grpc.core.RpcService;
import io.helidon.microprofile.grpc.core.Unary;

@RpcService(name = "ShippingGrpc")
@GrpcMarshaller("jsonb")
public interface ShippingClient {
    @Unary
    Shipment ship(ShippingRequest request);

    @Unary
    Shipment getShipmentByOrderId(String orderId);
}