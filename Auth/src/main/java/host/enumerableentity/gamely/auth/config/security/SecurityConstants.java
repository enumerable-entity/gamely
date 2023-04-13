package host.enumerableentity.gamely.auth.config.security;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class SecurityConstants {
    @Value("${application.jwt.secret}")
    public static final String SECRET = "secret";
    public static final long EXPIRATION_TIME = 86_400_000L;
    public static final String HEADER_STRING = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
}
