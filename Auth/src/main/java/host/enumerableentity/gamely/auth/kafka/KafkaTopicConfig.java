package host.enumerableentity.gamely.auth.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import static host.enumerableentity.gamely.commons.kafka.TopicsConstants.USERS_TOPIC;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic usersSyncTopic() {
        return TopicBuilder.name(USERS_TOPIC).build();
    }
}
