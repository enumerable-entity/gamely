package host.enumerableentity.gamely.games.kafka;

import host.enumerableentity.gamely.commons.dto.UserSyncDto;
import host.enumerableentity.gamely.games.mapper.UserMapper;
import host.enumerableentity.gamely.games.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaDataHandler {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public void handleMessage(UserSyncDto receivedUser) {
        userRepository.save(userMapper.fromSyncDto(receivedUser));
    }
}
