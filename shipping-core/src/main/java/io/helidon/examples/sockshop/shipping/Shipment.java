package io.helidon.examples.sockshop.shipping;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Shipment information to send as a response to Order service.
 */
@Data
@NoArgsConstructor
@Entity
public class Shipment implements Serializable {
    /**
     * Order identifier.
     */
    @Id
    private String orderId;

    /**
     * Shipping carrier.
     */
    private String carrier;

    /**
     * Tracking number.
     */
    private String trackingNumber;

    /**
     * Estimated delivery date.
     */
    private LocalDate deliveryDate;

    @Builder
    Shipment(String orderId, String carrier, String trackingNumber, LocalDate deliveryDate) {
        this.orderId = orderId;
        this.carrier = carrier;
        this.trackingNumber = trackingNumber;
        this.deliveryDate = deliveryDate;
    }
}
