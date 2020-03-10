package io.helidon.examples.sockshop.shipping;

import java.time.LocalDate;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * Implementation of the Shipping Service REST API.
 */
@ApplicationScoped
@Path("/shipping")
public class ShippingResource {
    /**
     * Shipment repository to use.
     */
    @Inject
    private ShipmentRepository shipments;

    @GET
    @Path("{orderId}")
    @Produces(APPLICATION_JSON)
    public Shipment getShipmentByOrderId(@PathParam("orderId") String orderId) {
        return shipments.getShipment(orderId);
    }

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
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
