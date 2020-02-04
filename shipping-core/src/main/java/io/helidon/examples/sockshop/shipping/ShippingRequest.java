package io.helidon.examples.sockshop.shipping;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Shipping request that is received from Order service.
 */
@Data
@NoArgsConstructor
public class ShippingRequest implements Serializable {
    /**
     * Order identifier.
     */
    private String orderId;

    /**
     * Shipping address.
     */
    private Address address;

    /**
     * The number of items in the order.
     */
    private int itemCount;

    @Builder
    ShippingRequest(String orderId, Address address, int itemCount) {
        this.orderId = orderId;
        this.address = address;
        this.itemCount = itemCount;
    }
}
