# shipping-mysql

This module implements [JPA backend](./src/main/java/io/helidon/examples/sockshop/shipping/jpa/JpaShipmentRepository.java)
for the [Shipping Service](../README.md), using MySQL as a backend database.

## Building the Service

See [main documentation page](../README.md#building-the-service) for instructions.

## Running the Service

This implementation is slightly more complex to run, because it requires a MySQL instance
to use as a data store.

First you will need to create a Docker network that will be used by both MySQL and the service 
containers, if you haven't done that already:

```bash
$ docker network create sockshop 
``` 

Then you can run MySQL container, but you need to assign it to the `sockshop` network 
created above, and give it a name that the service container expects (`shipping-db` in this case). 
You will also need to pass a number of environment variables to tell MySQL which database and
user to create:

```bash
$ docker run --rm --name shipping-db --network sockshop \
      -e MYSQL_ALLOW_EMPTY_PASSWORD=true \
      -e MYSQL_DATABASE=shipping \
      -e MYSQL_USER=shipping \
      -e MYSQL_PASSWORD=pass \
      mysql:8.0.20
``` 
> **Note:** The `--rm` flag above ensures that the container is removed automatically after it is 
> stopped. This allows you to re-run the command above without having to remove the `shipping-db`
> container manually between runs.

Finally, you can start the service container in the same network:

```bash
$ docker run --network sockshop -p 7001:7001 ghcr.io/helidon-sockshop/shipping-mysql
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
