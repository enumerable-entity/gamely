package host.enumerableentity.gamely.auth.service;

import host.enumerableentity.gamely.auth.config.security.SecurityUtils;
import host.enumerableentity.gamely.auth.dto.FullInfoUserDTO;
import host.enumerableentity.gamely.auth.entity.SystemUserEntity;
import host.enumerableentity.gamely.auth.repository.SystemUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final SystemUserRepository systemUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SystemUserEntity systemUser = systemUserRepository.findByUsername(username);
        if (systemUser == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return systemUser;
    }

    public FullInfoUserDTO me() {
        SystemUserEntity currentUser = SecurityUtils.getCurrentUser();
        if (currentUser != null) {
            return new FullInfoUserDTO(
                    currentUser.getId(),
                    currentUser.getUsername(),
                    currentUser.getEmail(),
                    currentUser.getFirstName(),
                    currentUser.getLastName(),
                    currentUser.getAvatarLink(),
                    currentUser.getRole()
            );
        }
        return null;
    }
}
