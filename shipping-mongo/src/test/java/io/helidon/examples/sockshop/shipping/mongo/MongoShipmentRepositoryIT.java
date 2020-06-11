/*
 * Copyright (c) 2020 Oracle and/or its affiliates.
 *
 * Licensed under the Universal Permissive License v 1.0 as shown at
 * http://oss.oracle.com/licenses/upl.
 */

package io.helidon.examples.sockshop.shipping.mongo;

import io.helidon.examples.sockshop.shipping.ShipmentRepositoryTest;
import io.helidon.examples.sockshop.shipping.TestShipmentRepository;

import static io.helidon.examples.sockshop.shipping.mongo.MongoProducers.client;
import static io.helidon.examples.sockshop.shipping.mongo.MongoProducers.db;
import static io.helidon.examples.sockshop.shipping.mongo.MongoProducers.shipments;

/**
 * Integration tests for {@link io.helidon.examples.sockshop.shipping.mongo.MongoShipmentRepository}.
 */
class MongoShipmentRepositoryIT extends ShipmentRepositoryTest {
    public TestShipmentRepository getShipmentRepository() {
        String host = System.getProperty("db.host","localhost");
        int    port = Integer.parseInt(System.getProperty("db.port","27017"));

        return new TestMongoShipmentRepository(shipments(db(client(host, port))));
    }
}
