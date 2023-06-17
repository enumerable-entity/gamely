package host.enumerableentity.gamely.auth.controller;

import host.enumerableentity.gamely.auth.dto.AuthenticationRequest;
import host.enumerableentity.gamely.auth.dto.AuthenticationResponse;
import host.enumerableentity.gamely.auth.dto.FullInfoUserDTO;
import host.enumerableentity.gamely.auth.dto.RegistrationRequest;
import host.enumerableentity.gamely.auth.service.AuthenticationService;
import host.enumerableentity.gamely.auth.service.RegistrationService;
import host.enumerableentity.gamely.auth.service.UserDetailsServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static host.enumerableentity.gamely.auth.commons.ServiceConstants.API_PREFIX;

@Tag(name = "Authentication controller", description = "Controller for managing authentication")
@RestController
@RequestMapping(API_PREFIX)
@RequiredArgsConstructor
public class AuthenticationController {

    private final RegistrationService registrationService;
    private final AuthenticationService authenticationService;
    private final UserDetailsServiceImpl userDetailsService;

    @Operation(summary = "Register new user")
    @PostMapping("/registration")
    public ResponseEntity<AuthenticationResponse> registerNewUser(@RequestBody RegistrationRequest registrationRequest) {
        return ResponseEntity.ok(registrationService.registerNewUser(registrationRequest));
    }

    @Operation(summary = "Login user")
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest authenticationRequest) {
        return ResponseEntity.ok(authenticationService.login(authenticationRequest));
    }

    @Operation(summary = "Get user info")
    @GetMapping("/me")
    public ResponseEntity<FullInfoUserDTO> getUserInfo() {
        return ResponseEntity.ok(userDetailsService.me());
    }

}
