package io.helidon.examples.sockshop.shipping;

import java.time.LocalDate;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;

import io.helidon.microprofile.grpc.core.GrpcMarshaller;
import io.helidon.microprofile.grpc.core.RpcService;
import io.helidon.microprofile.grpc.core.Unary;

/**
 * Implementation of the Shipping Service REST and gRPC API.
 */
@ApplicationScoped
@Path("/shipping")
@RpcService(name = "ShippingGrpc")
@GrpcMarshaller("jsonb")
public class ShippingResource implements ShippingApi {
    /**
     * Shipment repository to use.
     */
    @Inject
    private ShipmentRepository shipments;

    @Override
    @Unary
    public Shipment getShipmentByOrderId(String orderId) {
        return shipments.getShipment(orderId);
    }

    @Override
    @Unary
    public Shipment ship(ShippingRequest req) {
        // defaults
        String carrier = "USPS";
        String trackingNumber = "9205 5000 0000 0000 0000 00";
        LocalDate deliveryDate = LocalDate.now().plusDays(5);

        if (req.getItemCount() == 1) {  // use FedEx
            carrier = "FEDEX";
            trackingNumber = "231300687629630";
            deliveryDate = LocalDate.now().plusDays(1);
        }
        else if (req.getItemCount() <= 3) {  // use UPS
            carrier = "UPS";
            trackingNumber = "1Z999AA10123456784";
            deliveryDate = LocalDate.now().plusDays(3);
        }

        Shipment shipment = Shipment.builder()
                .orderId(req.getOrderId())
                .carrier(carrier)
                .trackingNumber(trackingNumber)
                .deliveryDate(deliveryDate)
                .build();

        shipments.saveShipment(shipment);

        return shipment;
    }
}
