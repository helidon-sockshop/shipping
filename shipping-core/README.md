# shipping-core

This module contains the bulk of the Shipping service implementation, including the 
[domain model](./src/main/java/io/helidon/examples/sockshop/shipping/Shipment.java), 
[REST API](./src/main/java/io/helidon/examples/sockshop/shipping/ShippingResource.java), as well as the
[data repository abstraction](./src/main/java/io/helidon/examples/sockshop/shipping/ShipmentRepository.java) 
and its [in-memory implementation](./src/main/java/io/helidon/examples/sockshop/shipping/DefaultShipmentRepository.java).

## Building the Service

See [main documentation page](../README.md#building-the-service) for instructions.

## Running the Service

Because this implementation uses in-memory data store, it is trivial to run.

Once you've built the Docker image per instructions above, you can simply run it by executing:

```bash
$ docker run -p 7001:7001 helidon/sockshop/shipping-core
``` 

Once the container is up and running, you should be able to access [service API](../README.md#api) 
by navigating to http://localhost:7001/shipping/.

As a basic test, you should be able to perform an HTTP GET against `/health` endpoint:

```bash
$ curl -i http://localhost:7001/health
``` 
which should return HTTP status code 200 and a JSON response with health check details.

## License

The Universal Permissive License (UPL), Version 1.0
