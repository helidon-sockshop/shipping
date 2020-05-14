package io.helidon.examples.sockshop.shipping;

/**
 * Tests for default in memory repository implementation.
 */
public class DefaultShipmentRepositoryTest extends ShipmentRepositoryTest {
    @Override
    protected TestShipmentRepository getShipmentRepository() {
        return new TestDefaultShipmentRepository();
    }
}
