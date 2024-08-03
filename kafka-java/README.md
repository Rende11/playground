Main link - [Conductor Kafka](https://www.conduktor.io/kafka)

Run environment
```dtd
make up
```

Run container shell
```dtd
make shell
```

Kafka topics CLI example
```dtd
kafka-topics --bootstrap-server localhost:9092 --topic demo --create --partitions 3 --replication-factor 1
```

Kafka producer CLI example
```dtd
kafka-console-producer --bootstrap-server localhost:9092 --topic demo
```

Kafka consumer CLI example
```dtd
kafka-console-consumer --bootstrap-server localhost:9092 --topic demo
```