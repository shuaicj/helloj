#### Run RabbitMQ
- `cd hello-java/hello-amqp`
- `docker-compose up`
> Verify rabbitmq is running. Open `http://localhost:15672/` in browser, and login with 'guest', 'guest'.

#### Run this demo
- Run `hello-amqp-consumer` via entry `shuaicj.hello.amqp.consumer.Application`
- Run `hello-amqp-producer` via entry `shuaicj.hello.amqp.producer.Application`

#### Verify
- The producer will print out `send message` every 2 seconds.
- The consumer will receive messages and print out `receive message` correspondingly.


