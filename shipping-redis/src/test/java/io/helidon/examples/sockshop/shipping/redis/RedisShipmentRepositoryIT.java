/*
 * Copyright (c) 2020 Oracle and/or its affiliates.
 *
 * Licensed under the Universal Permissive License v 1.0 as shown at
 * http://oss.oracle.com/licenses/upl.
 */

package io.helidon.examples.sockshop.shipping.redis;

import io.helidon.examples.sockshop.shipping.ShipmentRepositoryTest;
import io.helidon.examples.sockshop.shipping.TestShipmentRepository;

import static io.helidon.examples.sockshop.shipping.redis.RedisProducers.client;
import static io.helidon.examples.sockshop.shipping.redis.RedisProducers.shipments;

/**
 * Tests for Redis repository implementation.
 */
class RedisShipmentRepositoryIT extends ShipmentRepositoryTest {
    public TestShipmentRepository getShipmentRepository() {
        String host = System.getProperty("db.host","localhost");
        int    port = Integer.parseInt(System.getProperty("db.port","6379"));

        return new TestRedisShipmentRepository(shipments(client(host, port)));
    }
}
