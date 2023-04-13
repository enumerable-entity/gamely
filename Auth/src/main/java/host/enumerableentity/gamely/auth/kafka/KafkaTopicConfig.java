package host.enumerableentity.gamely.auth.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    public static final String USERS_TOPIC = "users";

    @Bean
    public NewTopic usersSyncTopic() {
        return TopicBuilder.name(USERS_TOPIC).build();
    }
}
