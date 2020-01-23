package io.helidon.examples.sockshop.shipping.mongo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;
import javax.inject.Inject;

import io.helidon.examples.sockshop.shipping.DefaultShipmentRepository;
import io.helidon.examples.sockshop.shipping.Shipment;

import com.mongodb.client.MongoCollection;

import static com.mongodb.client.model.Filters.eq;

/**
 * @author Aleksandar Seovic  2020.01.21
 */
@ApplicationScoped
@Specializes
public class MongoShipmentRepository extends DefaultShipmentRepository {
    private static final Logger LOGGER = Logger.getLogger(MongoShipmentRepository.class.getName());

    @Inject
    private MongoCollection<MongoShipment> shipments;

    @Override
    public Collection<Shipment> getAllShipments() {
        List<Shipment> results = new ArrayList<>();
        shipments.find().forEach((Consumer<? super MongoShipment>) results::add);
        return results;
    }

    @Override
    public Shipment getShipment(String id) {
        return shipments.find(eq("_id", id)).first();
    }

    @Override
    public Shipment addShipment(Shipment shipment) {
        shipments.insertOne(new MongoShipment(shipment));
        return shipment;
    }
}
