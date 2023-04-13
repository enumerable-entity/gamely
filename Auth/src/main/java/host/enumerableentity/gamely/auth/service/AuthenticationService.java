package host.enumerableentity.gamely.auth.service;

import host.enumerableentity.gamely.auth.dto.AuthenticationRequest;
import host.enumerableentity.gamely.auth.dto.AuthenticationResponse;
import host.enumerableentity.gamely.auth.entity.SystemUserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthenticationResponse login(AuthenticationRequest authenticationRequest) {
        Authentication authenticate = authenticationManager.authenticate(authenticationRequest.toAuthenticationToken());
        SystemUserEntity loggedUser = (SystemUserEntity) authenticate.getPrincipal();
        var token = jwtService.generateToken(loggedUser);
        return new AuthenticationResponse(token);
    }
}
