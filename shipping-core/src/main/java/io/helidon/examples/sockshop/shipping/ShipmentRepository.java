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

/**
 * A repository interface that should be implemented by
 * the various data store integrations.
 */
public interface ShipmentRepository {
    /**
     * Return shipment for the specified order.
     *
     * @param orderId the order identifier
     *
     * @return the shipment for the specified order;
     *         {@code null} if the shipment doesn't exist
     */
    Shipment getShipment(String orderId);

    /**
     * Save shipment details into the repository.
     *
     * @param shipment the shipment to save
     */
    void saveShipment(Shipment shipment);
}
