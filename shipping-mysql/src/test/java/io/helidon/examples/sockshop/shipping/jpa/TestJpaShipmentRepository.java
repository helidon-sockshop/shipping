package io.helidon.examples.sockshop.shipping.jpa;

import javax.annotation.Priority;
import javax.enterprise.inject.Alternative;
import javax.transaction.Transactional;

import io.helidon.examples.sockshop.shipping.TestShipmentRepository;

import static javax.interceptor.Interceptor.Priority.APPLICATION;

@Alternative
@Priority(APPLICATION + 5)
public class TestJpaShipmentRepository extends JpaShipmentRepository implements TestShipmentRepository {
    @Override
    @Transactional
    public void clear() {
        em.createQuery("delete from Shipment").executeUpdate();
    }
}
