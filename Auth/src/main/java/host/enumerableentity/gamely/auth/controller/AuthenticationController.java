package host.enumerableentity.gamely.auth.controller;

import host.enumerableentity.gamely.auth.dto.AuthenticationRequest;
import host.enumerableentity.gamely.auth.dto.AuthenticationResponse;
import host.enumerableentity.gamely.auth.dto.RegistrationRequest;
import host.enumerableentity.gamely.auth.service.AuthenticationService;
import host.enumerableentity.gamely.auth.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static host.enumerableentity.gamely.auth.commons.ServiceConstants.API_PREFIX;

@RestController
@RequestMapping(API_PREFIX)
@RequiredArgsConstructor
public class AuthenticationController {

    private final RegistrationService registrationService;
    private final AuthenticationService authenticationService;

    @PostMapping("/registration")
    public ResponseEntity<AuthenticationResponse> registerNewUser(@RequestBody RegistrationRequest registrationRequest) {
        return ResponseEntity.ok(registrationService.registerNewUser(registrationRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest authenticationRequest) {
        return ResponseEntity.ok(authenticationService.login(authenticationRequest));
    }

}
