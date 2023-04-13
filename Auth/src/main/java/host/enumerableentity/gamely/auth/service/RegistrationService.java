package host.enumerableentity.gamely.auth.service;

import host.enumerableentity.gamely.auth.commons.Role;
import host.enumerableentity.gamely.auth.dto.AuthenticationResponse;
import host.enumerableentity.gamely.auth.dto.RegistrationRequest;
import host.enumerableentity.gamely.auth.entity.SystemUserEntity;
import host.enumerableentity.gamely.auth.repository.SystemUserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final SystemUserRepository systemUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

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
        return new AuthenticationResponse(jwtService.generateToken(newUser));
    }
}
