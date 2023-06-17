package host.enumerableentity.gamely.games.security;

import lombok.NoArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class SecurityUtils {

    public static String getCurrentUserName() {
        return (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
