/*
 * Copyright (c) 2020 Oracle and/or its affiliates.
 *
 * Licensed under the Universal Permissive License v 1.0 as shown at
 * http://oss.oracle.com/licenses/upl.
 */

package io.helidon.examples.sockshop.shipping.coherence;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

import javax.inject.Inject;

import io.helidon.examples.sockshop.shipping.Shipment;
import io.helidon.examples.sockshop.shipping.DefaultShipmentRepository;

import com.oracle.coherence.inject.Name;
import com.tangosol.net.NamedMap;
import org.eclipse.microprofile.opentracing.Traced;

import static javax.interceptor.Interceptor.Priority.APPLICATION;

/**
 * An implementation of {@link io.helidon.examples.sockshop.shipping.ShipmentRepository}
 * that that uses Coherence as a backend data store.
 */
@ApplicationScoped
@Alternative
@Priority(APPLICATION)
@Traced
public class CoherenceShipmentRepository extends DefaultShipmentRepository {
    @Inject
    public CoherenceShipmentRepository(@Name("shipments") NamedMap<String, Shipment> shipments) {
        super(shipments);
    }
}
