package io.helidon.examples.sockshop.shipping.redis;

import io.helidon.examples.sockshop.shipping.ShipmentRepository;
import io.helidon.examples.sockshop.shipping.ShipmentRepositoryTest;

import static io.helidon.examples.sockshop.shipping.redis.RedisProducers.client;
import static io.helidon.examples.sockshop.shipping.redis.RedisProducers.shipments;

/**
 * Tests for Redis repository implementation.
 */
class RedisShipmentRepositoryIT extends ShipmentRepositoryTest {
    public ShipmentRepository getShipmentRepository() {
        String host = System.getProperty("db.host","localhost");
        int    port = Integer.parseInt(System.getProperty("db.port","6379"));

        return new RedisShipmentRepository(shipments(client(host, port)));
    }

    @Override
    protected void clearRepository(ShipmentRepository repository) {
        ((RedisShipmentRepository) repository).clear();
    }
}
