package io.helidon.examples.sockshop.shipping.jpa;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import io.helidon.examples.sockshop.shipping.Shipment;
import io.helidon.examples.sockshop.shipping.DefaultShipmentRepository;

/**
 * An implementation of {@link io.helidon.examples.sockshop.shipping.ShipmentRepository}
 * that that uses relational database (via JPA) as a backend data store.
 */
@ApplicationScoped
@Specializes
public class JpaShipmentRepository extends DefaultShipmentRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void saveShipment(Shipment shipment) {
        em.persist(shipment);
    }

    @Override
    @Transactional
    public Shipment getShipment(String orderId) {
        return em.find(Shipment.class, orderId);
    }

    @Override
    @Transactional
    public void clear() {
        em.createQuery("delete from Shipment").executeUpdate();
    }
}
