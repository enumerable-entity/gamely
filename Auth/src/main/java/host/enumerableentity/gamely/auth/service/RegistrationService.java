package host.enumerableentity.gamely.auth.service;

import host.enumerableentity.gamely.auth.commons.Role;
import host.enumerableentity.gamely.auth.dto.AuthenticationResponse;
import host.enumerableentity.gamely.auth.dto.RegistrationRequest;
import host.enumerableentity.gamely.auth.entity.SystemUserEntity;
import host.enumerableentity.gamely.auth.kafka.KafkaMessageSender;
import host.enumerableentity.gamely.auth.mapper.UserMapper;
import host.enumerableentity.gamely.auth.repository.SystemUserRepository;
import host.enumerableentity.gamely.commons.dto.UserSyncDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

import static host.enumerableentity.gamely.commons.kafka.TopicsConstants.USERS_TOPIC;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final SystemUserRepository systemUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final UserMapper userMapper;

    private final ApplicationEventPublisher eventPublisher;
    private final KafkaMessageSender<UserSyncDto> kafkaUserSender;


    @Transactional
    public AuthenticationResponse registerNewUser(RegistrationRequest registrationRequest) {
        var newUser = SystemUserEntity.builder()
                .firstName(registrationRequest.firstName())
                .lastName(registrationRequest.lastName())
                .username(registrationRequest.username())
                .password(passwordEncoder.encode(registrationRequest.password()))
                .email(registrationRequest.email())
                .role(Role.USER)
                .build();
        systemUserRepository.save(newUser);
        AuthenticationResponse response = new AuthenticationResponse(jwtService.generateToken(newUser));
        eventPublisher.publishEvent(new UserRegisteredEvent(newUser));
        return response;
    }

    @TransactionalEventListener
    public void publishNewUserToKafkaTopic(UserRegisteredEvent event) {
        kafkaUserSender.send(USERS_TOPIC, userMapper.toSyncDto(event.user()));
    }

    private record UserRegisteredEvent(SystemUserEntity user) {
    }
}
