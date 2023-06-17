package host.enumerableentity.gamely.auth.config.security;

import host.enumerableentity.gamely.auth.entity.SystemUserEntity;
import lombok.NoArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class SecurityUtils {

    public static SystemUserEntity getCurrentUser() {
        return (SystemUserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
