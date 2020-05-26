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

/**
 * Helper methods to create test data.
 */
class TestDataFactory {

    static ShippingRequest shippingRequest(String orderId, int itemCount) {
        return ShippingRequest.builder()
                .orderId(orderId)
                .address(address())
                .itemCount(itemCount)
                .build();
    }

    static Address address() {
        return Address.builder()
                .number("123")
                .street("Main St")
                .city("Springfield")
                .postcode("55555")
                .country("USA")
                .build();
    }

    static Shipment shipment(String orderId, String carrier, String trackingNumber, LocalDate deliveryDate) {
        return Shipment.builder()
                .orderId(orderId)
                .carrier(carrier)
                .trackingNumber(trackingNumber)
                .deliveryDate(deliveryDate)
                .build();
    }
}
