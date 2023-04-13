package host.enumerableentity.gamely.auth.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaMessageSender<T> {

    private final KafkaTemplate<String, T> kafkaTemplate;

    public void send(String topic, T message) {
        log.debug("Sending message to topic {}: {}", topic, message);
        kafkaTemplate.send(topic, message);
    }
}
