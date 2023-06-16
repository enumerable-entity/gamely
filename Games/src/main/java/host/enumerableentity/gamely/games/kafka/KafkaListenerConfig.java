package host.enumerableentity.gamely.games.kafka;

import host.enumerableentity.gamely.commons.dto.UserSyncDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static host.enumerableentity.gamely.commons.kafka.TopicsConstants.USERS_TOPIC;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaListenerConfig {

    private final KafkaDataHandler kafkaDataHandler;

    @KafkaListener(topics = USERS_TOPIC, groupId = "games-service")
    public void listen(UserSyncDto message) {
        log.info("Received message from topic: {} - {}", USERS_TOPIC, message);
        kafkaDataHandler.handleMessage(message);
    }
}
