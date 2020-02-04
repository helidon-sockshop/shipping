package io.helidon.examples.sockshop.shipping;

/**
 * Tests for default in memory repository implementation.
 */
public class DefaultShipmentRepositoryTest extends ShipmentRepositoryTest {
    @Override
    protected ShipmentRepository getShipmentRepository() {
        return new DefaultShipmentRepository();
    }

    @Override
    protected void clearRepository(ShipmentRepository repository) {
        ((DefaultShipmentRepository) repository).clear();
    }
}
