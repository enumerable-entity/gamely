package host.enumerableentity.gamely.auth.dto;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

public record AuthenticationRequest(String username, String password) {
    public Authentication toAuthenticationToken() {
        return new UsernamePasswordAuthenticationToken(username, password);
    }
}
