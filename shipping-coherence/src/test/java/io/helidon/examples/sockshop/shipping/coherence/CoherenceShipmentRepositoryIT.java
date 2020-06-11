/*
 * Copyright (c) 2020 Oracle and/or its affiliates.
 *
 * Licensed under the Universal Permissive License v 1.0 as shown at
 * http://oss.oracle.com/licenses/upl.
 */

package io.helidon.examples.sockshop.shipping.coherence;

import io.helidon.examples.sockshop.shipping.ShipmentRepositoryTest;
import io.helidon.examples.sockshop.shipping.TestShipmentRepository;

import com.tangosol.net.CacheFactory;

/**
 * Tests for Coherence repository implementation.
 */
class CoherenceShipmentRepositoryIT extends ShipmentRepositoryTest {
    public TestShipmentRepository getShipmentRepository() {
        return new TestCoherenceShipmentRepository(CacheFactory.getCache("shipments"));
    }
}
