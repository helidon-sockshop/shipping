package io.helidon.examples.sockshop.shipping;

import java.util.Collection;

/**
 */
public interface ShipmentRepository {
    Collection<Shipment> getAllShipments();

    Shipment getShipment(String id);

    Shipment addShipment(Shipment shipment);
}
