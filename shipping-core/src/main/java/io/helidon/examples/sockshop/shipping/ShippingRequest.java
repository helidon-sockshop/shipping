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

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * Shipping request that is received from Order service.
 */
@Data
@NoArgsConstructor
@Schema(description = "Shipping request that is received from Order service")
public class ShippingRequest implements Serializable {
    /**
     * Order identifier.
     */
    @Schema(description = "Order identifier")
    private String orderId;

    /**
     * Shipping address.
     */
    @Schema(description = "Shipping address")
    private Address address;

    /**
     * The number of items in the order.
     */
    @Schema(description = "The number of items in the order")
    private int itemCount;

    @Builder
    ShippingRequest(String orderId, Address address, int itemCount) {
        this.orderId = orderId;
        this.address = address;
        this.itemCount = itemCount;
    }
}
