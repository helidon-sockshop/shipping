package io.helidon.examples.sockshop.shipping.mongo;

import javax.json.bind.annotation.JsonbTransient;

import io.helidon.examples.sockshop.shipping.Shipment;

import org.bson.types.ObjectId;

/**
 * @author Aleksandar Seovic  2020.01.22
 */
public class MongoShipment extends Shipment {
    @JsonbTransient
    public ObjectId _id;

    public MongoShipment() {
    }

    public MongoShipment(Shipment shipment) {
        super(shipment.getOrderId(), shipment.getTrackingNumber());
    }
}
