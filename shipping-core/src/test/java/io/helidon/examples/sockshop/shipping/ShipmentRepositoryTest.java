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

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.helidon.examples.sockshop.shipping.TestDataFactory.shipment;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

/**
 * Abstract base class containing tests for all
 * {@link io.helidon.examples.sockshop.shipping.ShipmentRepository} implementations.
 */
public abstract class ShipmentRepositoryTest {

    private final TestShipmentRepository shipments = getShipmentRepository();

    protected abstract TestShipmentRepository getShipmentRepository();

    @BeforeEach
    void setup() {
        shipments.clear();
    }

    @Test
    void testSaveShipment() {
        LocalDate deliveryDate = LocalDate.now().plusDays(2);
        shipments.saveShipment(shipment("A123", "UPS", "1Z999AA10123456784", deliveryDate));

        Shipment s = shipments.getShipment("A123");
        assertThat(s.getOrderId(), is("A123"));
        assertThat(s.getCarrier(), is("UPS"));
        assertThat(s.getTrackingNumber(), is("1Z999AA10123456784"));
        assertThat(s.getDeliveryDate(), is(deliveryDate));
    }


    @Test
    void testGetShipmentByOrder() {
        assertThat(shipments.getShipment("A123"), nullValue());

        LocalDate deliveryDate = LocalDate.now().plusDays(2);
        shipments.saveShipment(shipment("A123", "UPS", "1Z999AA10123456784", deliveryDate));

        Shipment s = shipments.getShipment("A123");
        assertThat(s.getOrderId(), is("A123"));
        assertThat(s.getCarrier(), is("UPS"));
        assertThat(s.getTrackingNumber(), is("1Z999AA10123456784"));
        assertThat(s.getDeliveryDate(), is(deliveryDate));
    }
}
