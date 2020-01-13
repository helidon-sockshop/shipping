package io.helidon.examples.sockshop.shipping;

import java.util.Collection;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@ApplicationScoped
@Path("/shipping")
public class ShippingResource {

    @Inject
    private ShipmentRepository shipments;

    @GET
    @Produces(APPLICATION_JSON)
    public Collection<Shipment> getAllShipments() {
        return shipments.getAllShipments();
    }

    @GET
    @Path("{id}")
    @Produces(APPLICATION_JSON)
    public Shipment getShipmentById(@PathParam("id") String id) {
        return shipments.getShipment(id);
    }

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Shipment ship(Shipment shipment) {
        shipment.setTrackingNumber(UUID.randomUUID().toString());
        return shipments.addShipment(shipment);
    }
}
