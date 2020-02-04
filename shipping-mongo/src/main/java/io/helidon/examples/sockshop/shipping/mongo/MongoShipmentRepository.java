package io.helidon.examples.sockshop.shipping.mongo;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;
import javax.inject.Inject;

import io.helidon.examples.sockshop.shipping.DefaultShipmentRepository;
import io.helidon.examples.sockshop.shipping.Shipment;

import com.mongodb.client.MongoCollection;
import org.bson.BsonDocument;
import org.eclipse.microprofile.opentracing.Traced;

import static com.mongodb.client.model.Filters.eq;

/**
 * An implementation of {@link io.helidon.examples.sockshop.shipping.ShipmentRepository}
 * that that uses MongoDB as a backend data store.
 */
@ApplicationScoped
@Specializes
@Traced
public class MongoShipmentRepository extends DefaultShipmentRepository {
    /**
     * Mongo collection used to store shipments.
     */
    private MongoCollection<Shipment> shipments;

    /**
     * Construct {@code MongoPaymentRepository} instance.
     *
     * @param shipments Mongo collection used to store shipments
     */
    @Inject
    MongoShipmentRepository(MongoCollection<Shipment> shipments) {
        this.shipments = shipments;
    }

    @Override
    public Shipment getShipment(String orderId) {
        return shipments.find(eq("orderId", orderId)).first();
    }

    @Override
    public void saveShipment(Shipment shipment) {
        shipments.insertOne(shipment);
    }

    // ---- helpers ---------------------------------------------------------

    @Override
    public void clear() {
        shipments.deleteMany(new BsonDocument());
    }
}
