/*
 *  Copyright (c) 2020 Oracle and/or its affiliates.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package io.helidon.examples.sockshop.shipping;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.opentracing.Traced;

import static javax.interceptor.Interceptor.Priority.APPLICATION;

/**
 * Simple in-memory implementation of {@link io.helidon.examples.sockshop.shipping.ShipmentRepository}
 * that can be used for demos and testing.
 * <p/>
 * This implementation is obviously not suitable for production use, because it is not
 * persistent and it doesn't scale, but it is trivial to write and very useful for the
 * API testing and quick demos.
 */
@ApplicationScoped
@Priority(APPLICATION - 10)
@Traced
public class DefaultShipmentRepository implements ShipmentRepository {

    protected Map<String, Shipment> shipments;

    /**
     * Construct {@code DefaultShipmentRepository} with an empty storage map.
     */
    public DefaultShipmentRepository() {
        this(new ConcurrentHashMap<>());
    }

    /**
     * Construct {@code DefaultShipmentRepository} with the specified storage map.
     *
     * @param shipments the storage map to use
     */
    protected DefaultShipmentRepository(Map<String, Shipment> shipments) {
        this.shipments = shipments;
    }

    @Override
    public Shipment getShipment(String orderId) {
        return shipments.get(orderId);
    }

    @Override
    public void saveShipment(Shipment shipment) {
        shipments.put(shipment.getOrderId(), shipment);
    }
}
