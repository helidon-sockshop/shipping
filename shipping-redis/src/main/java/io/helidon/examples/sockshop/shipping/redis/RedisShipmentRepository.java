package io.helidon.examples.sockshop.shipping.redis;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;
import javax.inject.Inject;

import io.helidon.examples.sockshop.shipping.Shipment;
import io.helidon.examples.sockshop.shipping.DefaultShipmentRepository;

import org.eclipse.microprofile.opentracing.Traced;
import org.redisson.api.RMap;

/**
 * An implementation of {@link io.helidon.examples.sockshop.shipping.ShipmentRepository}
 * that that uses Redis (via Redisson) as a backend data store.
 */
@ApplicationScoped
@Specializes
@Traced
public class RedisShipmentRepository extends DefaultShipmentRepository {
    @Inject
    public RedisShipmentRepository(RMap<String, Shipment> shipments) {
        super(shipments);
    }
}
