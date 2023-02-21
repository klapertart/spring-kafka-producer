package klapertart.lab.kafkaproducer.producers;

public interface KafkaProducer {
    public void sendStringMessage(String message);
    public <T> void sendObjectMessage(T object);
}
