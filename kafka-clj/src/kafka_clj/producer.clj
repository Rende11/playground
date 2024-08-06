(ns kafka-clj.producer
  (:import
   (org.apache.kafka.clients.producer KafkaProducer ProducerConfig ProducerRecord Callback)))

(def producer-config
  {ProducerConfig/BOOTSTRAP_SERVERS_CONFIG "127.0.0.1:9092"
   ProducerConfig/KEY_SERIALIZER_CLASS_CONFIG "org.apache.kafka.common.serialization.StringSerializer"
   ProducerConfig/VALUE_SERIALIZER_CLASS_CONFIG "org.apache.kafka.common.serialization.StringSerializer"})

(def callback
  (reify Callback
    (onCompletion [_this metadata _exception]
      (println (str "Topic - " (.topic metadata) ", Partition - " (.partition metadata))))))


(defn run-producer! []
  (with-open [producer (KafkaProducer. producer-config)]
    (let [topic "demo"
          evt-key "id_555"
          evt-value "Hello Clj"
          producer-record (ProducerRecord. topic evt-key evt-value)]
      (.send producer producer-record callback)
      (.flush producer))))


(comment
  (def producer
    (KafkaProducer. producer-config))

  (def producer-record
    (ProducerRecord. "demo" "id_555" "Hello Clj"))

  (def callback
    (reify Callback
      (onCompletion [this metadata exception]
        (println (str "Topic - " (.topic metadata) ", Partition - " (.partition metadata))))))

  (.send producer producer-record callback)

  (run-producer!)
  )



