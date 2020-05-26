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

package io.helidon.examples.sockshop.shipping.mongo;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import io.helidon.examples.sockshop.shipping.Shipment;
import io.helidon.examples.sockshop.shipping.ShipmentRepository;

import com.mongodb.client.MongoCollection;

import org.eclipse.microprofile.opentracing.Traced;

import static com.mongodb.client.model.Filters.eq;
import static javax.interceptor.Interceptor.Priority.APPLICATION;

/**
 * An implementation of {@link io.helidon.examples.sockshop.shipping.ShipmentRepository}
 * that that uses MongoDB as a backend data store.
 */
@ApplicationScoped
@Alternative
@Priority(APPLICATION)
@Traced
public class MongoShipmentRepository implements ShipmentRepository {
    /**
     * Mongo collection used to store shipments.
     */
    protected MongoCollection<Shipment> shipments;

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
}
