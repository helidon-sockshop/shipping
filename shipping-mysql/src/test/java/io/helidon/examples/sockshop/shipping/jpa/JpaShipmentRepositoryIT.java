package io.helidon.examples.sockshop.shipping.jpa;

import io.helidon.examples.sockshop.shipping.ShipmentRepository;
import io.helidon.examples.sockshop.shipping.ShipmentRepositoryTest;
import io.helidon.microprofile.server.Server;

import org.junit.jupiter.api.AfterAll;

/**
 * Integration tests for {@link io.helidon.examples.sockshop.shipping.jpa.JpaShipmentRepository}.
 */
public class JpaShipmentRepositoryIT extends ShipmentRepositoryTest {
    /**
     * Starting server on ephemeral port in order to be able to get the
     * fully configured repository from the CDI container.
     */
    private static final Server SERVER = Server.builder().port(0).build().start();

    @AfterAll
    static void stopServer() {
        SERVER.stop();
    }

    @Override
    protected ShipmentRepository getShipmentRepository() {
        return SERVER.cdiContainer().select(ShipmentRepository.class).get();
    }

    @Override
    protected void clearRepository(ShipmentRepository repository) {
        ((JpaShipmentRepository) repository).clear();
    }
}
