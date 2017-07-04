#### Run RabbitMQ
- `cd hello-java/hello-amqp`
- `docker-compose up`
> Verify rabbitmq is running. Open `http://localhost:15672/` in browser, and login with 'guest', 'guest'.

#### Run Demos
- Run the producer in a subproject.
- Run the consumer in the same subproject.
> Repeat above and try another subproject.

#### Verify
- The producer will print out messages sent.
- The consumer will receive and print messages correspondingly.
